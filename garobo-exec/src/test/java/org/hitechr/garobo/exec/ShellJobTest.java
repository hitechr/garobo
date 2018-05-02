package org.hitechr.garobo.exec;
/**
 * @Package org.hitechr.garobo.exec
 * @Title: ShellJobTest
 * @author hapic
 * @date 2018/5/2 13:18
 * @version V1.0
 */

import org.hitechr.garobo.exec.job.ShellJobCommand;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * @Descriptions:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShellJobTest.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
@ComponentScan( basePackages = {"org.hitechr.garobo.exec"})
public class ShellJobTest {


    @Autowired
    private Scheduler scheduler;



    @Before
    public void before(){
        try {
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    public JobDetail getJobDetail(){
        String jobName="testOne";
        String jobGroup="1";
        String desc="testOnetestOne";
        JobDataMap dataMap = new JobDataMap();
        JobDetail jobDetail = JobBuilder.newJob(ShellJobCommand.class)
                .withIdentity(jobName, jobGroup)
                .withDescription(desc)
                .build();
        return jobDetail;
    }

    public Trigger setTrigger(JobDetail jobDetail){
        JobKey key = jobDetail.getKey();
        TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger()
                .withIdentity(key.getName(),key.getGroup())
                .usingJobData(jobDetail.getJobDataMap())
                .withDescription(jobDetail.getDescription());
        triggerBuilder.startNow();//立即解发
        return triggerBuilder.build();
    }

    @Test
    public void testOne(){


        try {


            JobDetail jobDetail = getJobDetail();
            Trigger trigger = setTrigger(jobDetail);
            scheduler.scheduleJob(jobDetail,trigger);

        } catch (SchedulerException e) {
            e.printStackTrace();
        }


        try {
            Thread.sleep(1000*10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
