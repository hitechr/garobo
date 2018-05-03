package org.hitechr.garobo.exec.common;

import lombok.Getter;
import org.hitechr.garobo.common.Constants;
import org.hitechr.garobo.common.utils.SerNumUtils;
import org.quartz.JobExecutionContext;

import java.util.UUID;

/**
 * @author weiwei
 * @from  bee-Scheduler
 */
public class TaskExecutionContext {
    private JobExecutionContext jobExecutionContext;

    @Getter
    private String uuid;
    @Getter
    private String fullPath;

    @Getter
    private TaskCommand taskCommand;

    public TaskExecutionContext(JobExecutionContext jobExecutionContext) {
        this.jobExecutionContext = jobExecutionContext;
        uuid= SerNumUtils.uuid();
        taskCommand = (TaskCommand)jobExecutionContext.getMergedJobDataMap().get(Constants.JOBDATA);
    }

    public JobExecutionContext getJobExecutionContext() {
        return jobExecutionContext;
    }

    public void setJobExecutionContext(JobExecutionContext jobExecutionContext) {
        this.jobExecutionContext = jobExecutionContext;
    }
}
