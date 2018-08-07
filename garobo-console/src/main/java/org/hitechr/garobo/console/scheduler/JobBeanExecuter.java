package org.hitechr.garobo.console.scheduler;
/**
 * @Package org.hitechr.garobo.console.scheduler
 * @Title: JobBeanExecuter
 * @author hitechr
 * @date 2018/8/6 11:26
 * @version V1.0
 */

import lombok.extern.slf4j.Slf4j;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;

import java.text.SimpleDateFormat;
import java.util.Date;
import static org.hitechr.garobo.console.scheduler.JobDataKey.JOBBEAN;



/**
 * @Descriptions:
 */
// 为了避免并发问题导致数据紊乱, 同一时间将只有一个Job实例被执行,
@DisallowConcurrentExecution
@Slf4j
public class JobBeanExecuter extends AbstractExecteJob<JobBean> {

    @Override
    public String jobDataKey() {
        return JOBBEAN;
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext,JobBean jobBean) {


        log.info("This is a first spring combine quartz !");
        log.info("jobBean :"+jobBean);
        log.info("Welcome to Spring_Quartz World!"+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) );
        log.info("Let's begin ! \n \n");


    }
}
