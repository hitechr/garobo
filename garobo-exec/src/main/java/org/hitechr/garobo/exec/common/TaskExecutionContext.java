package org.hitechr.garobo.exec.common;

import lombok.Getter;
import org.quartz.JobExecutionContext;

/**
 * @author weiwei
 */
public class TaskExecutionContext {
    private JobExecutionContext jobExecutionContext;

    @Getter
    private String uuid;

    public TaskExecutionContext(JobExecutionContext jobExecutionContext) {
        this.jobExecutionContext = jobExecutionContext;
    }

    public JobExecutionContext getJobExecutionContext() {
        return jobExecutionContext;
    }

    public void setJobExecutionContext(JobExecutionContext jobExecutionContext) {
        this.jobExecutionContext = jobExecutionContext;
    }
}
