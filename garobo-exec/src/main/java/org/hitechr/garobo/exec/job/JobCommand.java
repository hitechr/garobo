package org.hitechr.garobo.exec.job;
/**
 * @Package org.hitechr.garobo.exec.job
 * @Title: JobCommand
 * @author hapic
 * @date 2018/5/2 13:02
 * @version V1.0
 */

import lombok.extern.slf4j.Slf4j;
import org.hitechr.garobo.common.Constants;
import org.hitechr.garobo.common.exceptions.JobCommandException;
import org.hitechr.garobo.common.utils.DateUtils;
import org.hitechr.garobo.exec.common.TaskCommand;
import org.hitechr.garobo.exec.common.TaskExecutionContext;
import org.hitechr.garobo.exec.listener.JobCommandListener;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

import static org.hitechr.garobo.common.utils.DateUtils.currentTimeMillis;

/**
 * @Descriptions: 通用抽象的执行方法
 */
@Slf4j
public abstract class JobCommand implements Job {


    JobCommandListener jobCommandListener;

    public JobCommand(JobCommandListener jobCommandListener) {
        this.jobCommandListener = jobCommandListener;
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        TaskExecutionContext taskExecutionContext=null;
        try {
            //判断当前任务是否可以执行
            taskExecutionContext = new TaskExecutionContext(jobExecutionContext);
            log.info("job:{} UUID:{} start:{}",this.getClass(),taskExecutionContext.getUuid(),currentTimeMillis());
            TaskCommand taskCommand = taskExecutionContext.getTaskCommand();

            int result=-1;
            JobCommandException exception=null;
            try {
                if(jobCommandListener.before(taskCommand)){
                    taskCommand.setStartDate(new Date());
                    result= execute(taskExecutionContext);
                }
            } catch (Exception e) {
                exception=new JobCommandException(e);
            }
            jobCommandListener.after(result,taskCommand,exception);

        } catch (Exception e) {
            log.info("job:{} UUID:{},error:{}",this.getClass(),taskExecutionContext.getUuid(),e.getCause());
            throw new JobCommandException(e);
        }
    }



    public abstract int execute(TaskExecutionContext context);
}
