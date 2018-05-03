package org.hitechr.garobo.exec.utils;

/**
 * Created by ShenQi on 18/5/3.
 */

import org.hitechr.garobo.exec.common.TaskCommand;

/**
 * 任务控制器，判断任务的依赖，完成后的后续
 */
public class TaskControl {

    /**
     * 判断依赖的任务是否执行完
     * @param taskCommand
     * @return
     */
    public static boolean dependOver(TaskCommand taskCommand){

        return true;
    }

    /**
     * 创造正在执行的节点信息
     * @param taskCommand
     * @return
     */
    private static boolean creatRunningData(TaskCommand taskCommand){

        return true;
    }

    /**
     * 任务执行完后的信息
     * @param result
     * @param taskCommand
     */
    public static void finishTask(int result,TaskCommand taskCommand){

    }
}
