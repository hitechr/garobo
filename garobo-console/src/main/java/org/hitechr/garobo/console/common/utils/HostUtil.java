package org.hitechr.garobo.console.common.utils;

import java.net.InetAddress;

/**
 * Created by Administrator on 2015/5/9.
 */
public class HostUtil {

    public static String getMachineName() {
        String machineName = LocalHost.getMachineName();
        if (machineName == null) {
            machineName = System.getProperty("machine.name");
        }

        return machineName;
    }

    public static String getLoclServerIp() {
        try {
            String hostAddress = InetAddress.getLocalHost().getHostAddress();
            return null == hostAddress ? "unknown" : hostAddress;
        } catch (Exception e) {
            return "unknown";
        }
    }

}
