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
import org.hitechr.garobo.common.exceptions.JobDataException;
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
    private static  ThreadLocal<Job> jobThreadLocal;


    public static void  init(ZookeeperServer zookeeperServer,Scheduler scheduler){
        SchedulerUtils.zookeeperServer=zookeeperServer;
        SchedulerUtils.scheduler=scheduler;
        jobThreadLocal=new ThreadLocal<>();
    }


    public static JobDetail jobDetail(Job job){

        Class jobCommand= JobCommandFacory.commdType(job.getType());

        JobKey jobKey = JobKey.jobKey(job.getName(), job.getGroupId() + "");

        JobDetail jobDetail = JobBuilder.newJob(jobCommand)
                .withIdentity(jobKey)
                .withDescription(job.getJobDesc())
                .build();
        return jobDetail;
    }

    public static Trigger setTrigger(Job job){
        TriggerKey triggerKey = TriggerKey
                .triggerKey(job.getName(),job.getGroupId()+"");

        TriggerBuilder<Trigger> triggerTriggerBuilder = newTrigger().withIdentity(triggerKey);
        return triggerTriggerBuilder.withSchedule(cronSchedule(job.getJobCron())).build();
    }

    /**
     * 开启任务的方法
     * @param jobName
     */
    public static void startJob(String jobName) {
        Job jobData = getJobData(jobName);

        JobDetail jobDetail = jobDetail(jobData);
        Trigger cronTrigger = setTrigger(jobData);

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
        Job jobData = getJobData(jobName);
        return 0==jobData.getOrderNum();
    }

    private static Job getJobData(String jobName){
        Job job = jobThreadLocal.get();
        if(job==null){
            String jobPath = getJobPath(jobName);
            String data = zookeeperServer.getData(jobPath);
            log.info("job:{} data:{}",jobName,data);
            if(StringUtils.isEmpty(data)){
                log.info("jobPath:{} data is null",jobPath);
                throw new JobDataException("job "+jobName+" data not found!");
            }
            job = JSONObject.parseObject(data, Job.class);
            jobThreadLocal.set(job);
        }
        return job;
    }

}
