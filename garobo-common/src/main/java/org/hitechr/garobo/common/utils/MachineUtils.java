package org.hitechr.garobo.common.utils;
/**
 * @Package org.hitechr.garobo.common.utils
 * @Title: MachineUtils
 * @author hapic
 * @date 2018/4/28 14:08
 * @version V1.0
 */

import java.lang.management.ManagementFactory;

/**
 * @Descriptions: 获取机器相关的工具类
 */
public class MachineUtils {

    /**
     * 获取当前启动的pid
     * @return
     */
    public static int pid(){
        String name = ManagementFactory.getRuntimeMXBean().getName();
        System.out.println(name);
        String pid = name.split("@")[0];
        return Integer.parseInt(pid);
    }
}
