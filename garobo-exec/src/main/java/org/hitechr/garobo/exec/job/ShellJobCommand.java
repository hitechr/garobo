package org.hitechr.garobo.exec.job;
/**
 * @Package org.hitechr.garobo.exec.job
 * @Title: ShellJobCommand
 * @author hapic
 * @date 2018/5/2 13:11
 * @version V1.0
 */

import org.hitechr.garobo.exec.common.TaskExecutionContext;
import org.hitechr.garobo.exec.listener.JobCommandListener;

/**
 * @Descriptions:
 */

public class ShellJobCommand extends JobCommand {


    public ShellJobCommand(JobCommandListener jobCommandListener) {
        super(jobCommandListener);
    }

    @Override
    public int execute(TaskExecutionContext context) {



        return 0;
    }


}
