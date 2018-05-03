package org.hitechr.garobo.exec.listener;

import org.hitechr.garobo.common.exceptions.JobCommandException;
import org.hitechr.garobo.exec.common.TaskCommand;

/**
 * Created by ShenQi on 18/5/3.
 */
public interface JobCommandListener {

    boolean before(TaskCommand taskCommand);

    boolean after(int resultCode, TaskCommand taskCommand, JobCommandException exception);
}
