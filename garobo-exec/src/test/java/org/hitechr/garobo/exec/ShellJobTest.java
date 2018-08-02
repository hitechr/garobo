package org.hitechr.garobo.exec;
/**
 * @Package org.hitechr.garobo.exec
 * @Title: ShellJobTest
 * @author hapic
 * @date 2018/5/2 13:18
 * @version V1.0
 */

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Descriptions:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShellJobTest.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
@ComponentScan( basePackages = {"org.hitechr.garobo.exec","org.hitechr.garobo.zk"})
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
       /* String jobName="testTwo";
        String jobGroup="1";
        String desc="testOnetestOne";
        JobDataMap dataMap = new JobDataMap();
        TaskCommand taskCommand= new TaskCommand();
        taskCommand.setRunId(10002);
        taskCommand.setName(jobName);
        taskCommand.setExecuteIp("192.168.10.1");
        dataMap.put(Constants.JOBDATA,taskCommand);
        JobDetail jobDetail = JobBuilder.newJob(ShellJobCommand.class)
                .setJobData(dataMap)
                .withIdentity(jobName, jobGroup)
                .withDescription(desc)
                .build();

        return jobDetail;*/
       return null;
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
            Thread.sleep(1000*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
