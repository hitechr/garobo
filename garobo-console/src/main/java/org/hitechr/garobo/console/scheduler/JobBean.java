package org.hitechr.garobo.console.scheduler;
/**
 * @Package org.hitechr.garobo.console.scheduler
 * @Title: JobBean
 * @author hitechr
 * @date 2018/8/3 15:57
 * @version V1.0
 */

import lombok.Getter;
import lombok.Setter;
import org.hitechr.garobo.console.model.Job;

/**
 * @Descriptions:
 */
@Setter
@Getter
public class JobBean {
    private Integer jobId;
    private String jobName;
    private String jobGroup;
    private String triggerName;
    private String triggerGroup;
    private String cron;
    private Job job;

    @Override
    public String toString() {
        return "JobBean{" +
                "jobId=" + jobId +
                ", jobName='" + jobName + '\'' +
                ", jobGroup='" + jobGroup + '\'' +
                ", triggerName='" + triggerName + '\'' +
                ", triggerGroup='" + triggerGroup + '\'' +
                ", cron='" + cron + '\'' +
                ", job=" + job +
                '}';
    }
}
