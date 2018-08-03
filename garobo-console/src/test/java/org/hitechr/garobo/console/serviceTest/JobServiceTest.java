package org.hitechr.garobo.console.serviceTest;
/**
 * @Package org.hitechr.garobo.console.serviceTest
 * @Title: JobServiceTest
 * @author hitechr
 * @date 2018/8/3 14:12
 * @version V1.0
 */

import org.hitechr.garobo.console.model.Job;
import org.hitechr.garobo.console.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

/**
 * @Descriptions:
 */
public class JobServiceTest extends BaseTest {


    @Autowired
    private JobService jobService;

    @Test
    public void saveJobAndJobExecutorTest(){

        Job job= new Job();
        job.setCommand("date");
        job.setFlowNum(1);
        job.setGroupId(1);
        job.setJobCron("0 0 3 * * ? ");
        job.setLast(true);
        job.setName("第一个测试Job");
        job.setRedo(2);
        job.setRedoNow(1);
        job.setWeight(1);
        job.setStatus(1);
        job.setType(1);
        job.setSuccessCode(0);
        jobService.saveJobAndJobExecutor(job,new Integer[]{1,2});

    }

}
