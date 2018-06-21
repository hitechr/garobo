package org.hitechr.garobo.exec.utils;
/**
 * @Package org.hitechr.garobo.exec.utils
 * @Title: SchedulerUtils
 * @author hapic
 * @date 2018/5/3 16:43
 * @version V1.0
 */

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.zookeeper.data.Stat;
import org.hitechr.garobo.common.Constants;
import org.hitechr.garobo.common.exceptions.JobDataException;
import org.hitechr.garobo.exec.common.TaskCommand;
import org.hitechr.garobo.exec.job.JobCommandFacory;
import org.hitechr.garobo.exec.service.ZKSevice;
import org.hitechr.garobo.model.Job;
import org.hitechr.garobo.zk.ZookeeperServer;
import org.quartz.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.hitechr.garobo.zk.ZKPath.*;
import static org.hitechr.garobo.zk.ZKPath.getExecutionJobPath;
import static org.hitechr.garobo.zk.ZKPath.getExecutionJobStatus;
import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * @Descriptions:
 */
@Slf4j
public class SchedulerUtils {

    private static ZKSevice zkSevice;

    private static Scheduler scheduler;
    private static  ThreadLocal<TaskCommand> jobThreadLocal;


    public static void  init(ZKSevice zkSevice,Scheduler scheduler){
        SchedulerUtils.zkSevice=zkSevice;
        SchedulerUtils.scheduler=scheduler;
        jobThreadLocal=new ThreadLocal<>();
    }


    public static JobDetail jobDetail(TaskCommand taskCommand){

        Class jobCommand= JobCommandFacory.commdTypeClass(taskCommand.getType());

        JobKey jobKey = JobKey.jobKey(taskCommand.getName(), taskCommand.getGroupId() + "");

        JobDataMap dataMap= new JobDataMap();
        dataMap.put(Constants.JOBDATA,taskCommand);

        JobDetail jobDetail = JobBuilder.newJob(jobCommand)
                .withIdentity(jobKey)
                .withDescription(taskCommand.getJobDesc())
                .usingJobData(dataMap)
                .build();

        return jobDetail;
    }

    public static Trigger setTrigger(TaskCommand taskCommand){
        return setTrigger(taskCommand,taskCommand.getJobCron());
    }

    public static Trigger setTrigger(TaskCommand taskCommand,String cronExpression){
        TriggerKey triggerKey = TriggerKey
                .triggerKey(taskCommand.getName(),taskCommand.getGroupId()+"");
        log.info("set trigger:{}",triggerKey.toString());
        TriggerBuilder<Trigger> triggerTriggerBuilder = newTrigger().withIdentity(triggerKey);
        if(StringUtils.isEmpty(cronExpression)){
            log.info("job:{} start now",triggerKey.getName());
            triggerTriggerBuilder.startNow();
        }else{
            log.info("job:{} start with:{}",triggerKey.getName(),cronExpression);
            triggerTriggerBuilder.withSchedule(cronSchedule(cronExpression));
        }
        return triggerTriggerBuilder.build();
    }

    /**
     * 开启任务的方法
     * @param jobName
     */
    public static void startJob(String jobName) {
        TaskCommand taskCommand = getJobData(jobName);

        JobDetail jobDetail = jobDetail(taskCommand);
        Trigger cronTrigger = setTrigger(taskCommand);

        try {
            scheduler.scheduleJob(jobDetail,cronTrigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
//        jobThreadLocal.remove();
    }

    /**
     * 验证当前的job是否是起始job
     * @param jobName
     * @return
     */
    public static boolean checkRootJob(String jobName) {
        TaskCommand taskCommand = getJobData(jobName);
        return 0==taskCommand.getFlowNum();
    }

    private static TaskCommand getJobData(String jobName){
        TaskCommand job = jobThreadLocal.get();
        if(job==null){
            String jobPath = getJobPath(jobName);

            String data = zkSevice.getData(jobPath);
            log.info("job:{} data:{}",jobName,data);
            if(StringUtils.isEmpty(data)){
                log.info("jobPath:{} data is null",jobPath);
                throw new JobDataException("job "+jobName+" data not found!");
            }
            job = JSONObject.parseObject(data, TaskCommand.class);
//            jobThreadLocal.set(job);
        }
        return job;
    }

    /**
     * 创造正在执行的节点信息
     * @param taskCommand
     * @return
     */
    public static boolean creatRunningData(TaskCommand taskCommand){
        int runId = taskCommand.getRunId();
        String executeIp = taskCommand.getExecuteIp();

        //创建任务的根节点
        zkSevice.createExecutionJobPath(taskCommand.getName(),runId+"");

        String executionJobStatus = getExecutionJobStatus(taskCommand.getName(), runId + "");
        if(!zkSevice.isExisted(executionJobStatus)){
            zkSevice.createRunningPath(runId,taskCommand.getName(),executeIp);
        }else {
            log.info("path:{} is exist",executionJobStatus);
        }

        //给status绑定监听事件
        zkSevice.bindPathListener(executionJobStatus,false,nodeCache->{
            String path = nodeCache.getCurrentData().getPath();
            Stat stat = nodeCache.getCurrentData().getStat();
            log.info("path:{} change...",path);
            byte[] data = nodeCache.getCurrentData().getData();
            if(!Constants.status_done.equals(new String(data))){//判断节点是否已经完成
                log.info("path:{} is running..",path);
                return;
            }

            //加载


            //创建pending上的数据
            String pendingJobPath = getPendingJobPath(executeIp,runId+"");
            String pendingJobName = getPendingJobName(executeIp,runId+"",taskCommand.getName());
            zkSevice.createPath(pendingJobPath,"");

            //删除execution上的数据，和创建result节点上的数据



        });
        return true;
    }

    /**
     * 任务执行完后的信息
     * @param result
     * @param taskCommand
     */
    public static void finishTask(int result,TaskCommand taskCommand){
        int runId = taskCommand.getRunId();
        String name = taskCommand.getName();
        String resultPath = getResultPath(runId + "", name);

        JSONObject jsonObject= new JSONObject();
        jsonObject.put(Constants.status,"done");
        jsonObject.put(Constants.result,result);
        jsonObject.put(Constants.name,name);
        jsonObject.put(Constants.execute,taskCommand.getExecuteIp());

        String deletePath = getExecutionJobPath(runId + "", name);

        String jobChildPath = getJobChilds(name);
        List<String> childJobs = zkSevice.getChildPath(jobChildPath);

        List<String> childJobList= createPendingJobPath(runId+"",childJobs);//

        String jobDependent = getJobDependent(name);
        List<String> depJobPaths = zkSevice.getChildPath(jobDependent);


        List<String> depJobListPath= createResultJobPath(runId+"",depJobPaths);//

        zkSevice.createResultPath(resultPath,jsonObject.toJSONString(),deletePath,depJobListPath);

        zkSevice.createChildPath(childJobList);
    }


    /**
     * 创建执行结果的节点
     * @param runId
     * @param depJobPaths
     * @return
     */
    private static List<String> createResultJobPath(String runId,List<String> depJobPaths) {

        List<String> depJobListPath= Lists.newArrayList();

        depJobPaths.stream().forEach(depJob->{
            String executionJobDependent = getExecutionJobDependent(runId + "", depJob);
            depJobListPath.add(executionJobDependent);
        });
        return depJobListPath;

    }


    /**
     * 创建待执行任务的节点
     * @param runnid
     * @param childJobs
     * @return
     */
    private static List<String> createPendingJobPath(String runnid,List<String> childJobs) {

       List<String> childJobList=Lists.newArrayList();

        childJobs.stream().forEach(childJob->{
            TaskCommand jobData = getJobData(childJob);
            String executeIp = jobData.getExecuteIp();
            String pendingJobPath = getPendingJobPath(executeIp, runnid + "");
            childJobList.add(pendingJobPath);
        });


        return childJobList;

    }


    public static void main(String[] args) {


        final List<String> friends =
                Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
        List<String> list= new ArrayList<>();
        Map<String, String> collect = friends.stream().collect(Collectors.toMap(String::toString,k->""));


        collect.forEach((k,v)->{
            System.out.println(" "+k+"  V:" +v);
        });

        list.stream().forEach(System.out::println);


    }


}
