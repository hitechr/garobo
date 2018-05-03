package org.hitechr.garobo.exec.job;
/**
 * @Package org.hitechr.garobo.exec.job
 * @Title: JobCommandFacory
 * @author hapic
 * @date 2018/5/3 16:46
 * @version V1.0
 */

/**
 * @Descriptions:
 */
public class JobCommandFacory {

    public static Class<ShellJobCommand> commdType(Integer type) {
        return ShellJobCommand.class;
    }
}
