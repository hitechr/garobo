package org.hitechr.garobo.console.scheduler;
/**
 * @Package org.hitechr.garobo.console.scheduler
 * @Title: AbstractExecteJob
 * @author hitechr
 * @date 2018/8/6 11:24
 * @version V1.0
 */

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;




/**
 * @Descriptions:
 */
public abstract class AbstractExecteJob<T> implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        T t = (T)jobExecutionContext.getJobDetail().getJobDataMap().get(jobDataKey());
        execute(jobExecutionContext,t);
    }

    public abstract String jobDataKey();

    public abstract void execute(JobExecutionContext jobExecutionContext,T t);
}
