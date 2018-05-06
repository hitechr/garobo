package org.hitechr.garobo.exec.listener;

import org.hitechr.garobo.common.exceptions.JobCommandException;
import org.hitechr.garobo.exec.common.TaskCommand;
import org.hitechr.garobo.exec.service.ZKSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by ShenQi on 18/5/3.
 */
@Component
public class ShellJobCommandListener implements JobCommandListener {

    @Autowired
    private ZKSevice zkSevice;


    @Override
    public boolean before(TaskCommand taskCommand) {
        //验证当前job依赖的job是否都成功执行,
        zkSevice.depJobDone(taskCommand.getRunId(),taskCommand.getName());


        //验证当前运行中的任务是否已经达到上限
//        zkSevice.




        return true;
    }

    @Override
    public boolean after(int resultCode, TaskCommand taskCommand, JobCommandException exception) {
        return true;
    }
}
