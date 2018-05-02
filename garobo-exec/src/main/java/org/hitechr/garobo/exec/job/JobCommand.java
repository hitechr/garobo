package org.hitechr.garobo.exec.job;
/**
 * @Package org.hitechr.garobo.exec.job
 * @Title: JobCommand
 * @author hapic
 * @date 2018/5/2 13:02
 * @version V1.0
 */

import lombok.extern.slf4j.Slf4j;
import org.hitechr.garobo.common.exceptions.JobCommandException;
import org.hitechr.garobo.exec.common.TaskExecutionContext;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import static org.hitechr.garobo.common.utils.DateUtils.currentTimeMillis;

/**
 * @Descriptions: 通用抽象的执行方法
 */
@Slf4j
public abstract class JobCommand implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        TaskExecutionContext taskExecutionContext=null;
        try {
            taskExecutionContext = new TaskExecutionContext(jobExecutionContext);
            log.info("job:{} UUID:{} start:{}",this.getClass(),taskExecutionContext.getUuid(),currentTimeMillis());
            int result = execute(taskExecutionContext);
            log.info("job:{} UUID:{} end:{}",this.getClass(),taskExecutionContext.getUuid(),currentTimeMillis(),result);
        } catch (Exception e) {
            log.info("job:{} UUID:{},error:{}",this.getClass(),taskExecutionContext.getUuid(),e.getCause());
            throw new JobCommandException(e);
        }
    }

    public abstract int execute(TaskExecutionContext context);
}
