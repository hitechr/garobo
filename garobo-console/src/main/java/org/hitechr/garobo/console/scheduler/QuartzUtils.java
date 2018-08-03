package org.hitechr.garobo.console.scheduler;
/**
 * @Package org.hitechr.garobo.console.scheduler
 * @Title: QuartzUtils
 * @author hitechr
 * @date 2018/8/3 15:57
 * @version V1.0
 */

import com.google.common.base.Joiner;
import org.hitechr.garobo.console.model.Job;

/**
 * @Descriptions:
 */
public class QuartzUtils {

    private static String TRIGGERPRE="trigger";
    private static String JOBGROUP="jobGroup";

    public static JobBean wrapJob(Job job){
        JobBean jobBean= new JobBean();
        jobBean.setJobName(assemName(job.getId(),job.getName()));
        jobBean.setJobGroup(assemName(JOBGROUP,job.getGroupId()));
        jobBean.setTriggerName(assemName(TRIGGERPRE,job.getId(),job.getName()));
        jobBean.setTriggerGroup(assemName(TRIGGERPRE,job.getGroupId(),job.getName()));
        jobBean.setCron(job.getJobCron());
        return jobBean;
    }

    private static String assemName(Object ... value){
        return Joiner.on(":").skipNulls().join(value);
    }


}
