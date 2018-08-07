package org.hitechr.garobo.console.serviceTest;
/**
 * @Package org.hitechr.garobo.console.serviceTest
 * @Title: SchedulerManagerTest
 * @author hitechr
 * @date 2018/8/3 16:33
 * @version V1.0
 */

import lombok.extern.slf4j.Slf4j;
import org.hitechr.garobo.console.model.Job;
import org.hitechr.garobo.console.scheduler.JobBean;
import org.hitechr.garobo.console.scheduler.QuartzUtils;
import org.hitechr.garobo.console.scheduler.SchedulerManager;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.util.Date;

/**
 * @Descriptions:
 */
@Slf4j
public class SchedulerManagerTest extends BaseTest {


    @Autowired
    private SchedulerManager schedulerManager;


    @Test
    public void testMiss(){
        Job job = new Job();
        job.setId(1);
        job.setGroupId(10);
        job.setName("第一个触发的任务");
        job.setJobCron("0 30 10 * * ? ");
        JobBean jobBean = QuartzUtils.wrapJob(job);
        schedulerManager.addJob(jobBean);

        CronTriggerImpl cronTrigger = new CronTriggerImpl();
        try {
            cronTrigger.setCronExpression(job.getJobCron());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date nextFireTime = cronTrigger.getNextFireTime();
        System.out.println(nextFireTime);


        try {
            Thread.sleep(1000*1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void addTest(){
        Job job = new Job();
        job.setId(1);
        job.setGroupId(10);
        job.setName("第一个触发的任务");
        job.setJobCron("0 29 10 * * ? ");
        JobBean jobBean = QuartzUtils.wrapJob(job);
        log.info("add job................");
        schedulerManager.addJob(jobBean);
        try {
            Thread.sleep(1000*100L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("pause job................");

        schedulerManager.pauseJob(jobBean);
        try {
            Thread.sleep(1000*70L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.info("resume job................");
        schedulerManager.resumeJob(jobBean);
        try {
            Thread.sleep(1000*100L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.info("remove job................");
        schedulerManager.removeJob(jobBean);



        try {
            Thread.sleep(1000*1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
