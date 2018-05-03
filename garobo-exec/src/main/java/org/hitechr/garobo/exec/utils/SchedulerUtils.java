package org.hitechr.garobo.exec.utils;
/**
 * @Package org.hitechr.garobo.exec.utils
 * @Title: SchedulerUtils
 * @author hapic
 * @date 2018/5/3 16:43
 * @version V1.0
 */

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.hitechr.garobo.common.Constants;
import org.hitechr.garobo.common.exceptions.JobDataException;
import org.hitechr.garobo.exec.common.TaskCommand;
import org.hitechr.garobo.exec.job.JobCommandFacory;
import org.hitechr.garobo.model.Job;
import org.hitechr.garobo.zk.ZookeeperServer;
import org.quartz.*;

import static org.hitechr.garobo.common.ZKPath.getJobPath;
import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * @Descriptions:
 */
@Slf4j
public class SchedulerUtils {

    private static ZookeeperServer zookeeperServer;

    private static Scheduler scheduler;
    private static  ThreadLocal<TaskCommand> jobThreadLocal;


    public static void  init(ZookeeperServer zookeeperServer,Scheduler scheduler){
        SchedulerUtils.zookeeperServer=zookeeperServer;
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
        jobThreadLocal.remove();
    }

    /**
     * 验证当前的job是否是起始job
     * @param jobName
     * @return
     */
    public static boolean checkRootJob(String jobName) {
        TaskCommand taskCommand = getJobData(jobName);
        return 0==taskCommand.getOrderNum();
    }

    private static TaskCommand getJobData(String jobName){
        TaskCommand job = jobThreadLocal.get();
        if(job==null){
            String jobPath = getJobPath(jobName);
            String data = zookeeperServer.getData(jobPath);
            log.info("job:{} data:{}",jobName,data);
            if(StringUtils.isEmpty(data)){
                log.info("jobPath:{} data is null",jobPath);
                throw new JobDataException("job "+jobName+" data not found!");
            }
            job = JSONObject.parseObject(data, TaskCommand.class);
            jobThreadLocal.set(job);
        }
        return job;
    }

}
