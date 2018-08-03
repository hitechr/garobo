package org.hitechr.garobo.common.utils;
/**
 * @Package org.hitechr.garobo.common.utils
 * @Title: MachineUtils
 * @author hapic
 * @date 2018/4/28 14:08
 * @version V1.0
 */

import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.UnknownHostException;

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
        String pid = name.split("@")[0];
        return Integer.parseInt(pid);
    }

    /**
     * 获取当前机器的IP
     * @return
     */
    public static String ip(){
        String ip=null;
        try {
            InetAddress addr = InetAddress.getLocalHost();
            ip =addr.getHostAddress().toString(); //获取本机ip
//            String hostName=addr.getHostName().toString(); //获取本机计算机名称
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return ip;
    }


    public static void main(String[] args) throws UnknownHostException {
        InetAddress addr = InetAddress.getLocalHost();
        String ip=addr.getHostAddress().toString(); //获取本机ip
        String hostName=addr.getHostName().toString(); //获取本机计算机名称
        System.out.println(ip);
        System.out.println(hostName);
    }
}
