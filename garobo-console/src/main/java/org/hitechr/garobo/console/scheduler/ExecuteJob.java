package org.hitechr.garobo.console.scheduler;
/**
 * @Package org.hitechr.garobo.console.scheduler
 * @Title: ExecuteJob
 * @author hitechr
 * @date 2018/8/3 15:27
 * @version V1.0
 */

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Descriptions:
 */
@Slf4j
public class ExecuteJob implements Job {



    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        log.info("This is a first spring combine quartz !");
        log.info("Welcome to Spring_Quartz World!"+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) );
        log.info("Let's begin ! \n \n");
    }
}
