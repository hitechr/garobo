package org.hitechr.garobo.console.common.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

/**
 * Created by Administrator on 2015/5/9.
 */
public class LocalHost {
    private static final Log log = LogFactory.getLog(LocalHost.class);
    private static NetworkInterface localNetworkInterface;
    private static String hostName;

    static {
        try {
            Enumeration e = NetworkInterface.getNetworkInterfaces();
            while(e.hasMoreElements()) {
                NetworkInterface networkInterface = (NetworkInterface)e.nextElement();
                if(!networkInterface.getName().equals("lo")) {
                    localNetworkInterface = networkInterface;
                    break;
                }
            }
        } catch (SocketException var3) {
            log.error("init LocalHost error!", var3);
        }

        try {
            hostName = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException var2) {
            log.error("init hostname error!", var2);
        }

    }

    public LocalHost() {
    }

    public static NetworkInterface getLocalNetworkInterface() {
        return localNetworkInterface;
    }

    public static String getMachineName() {
        return hostName;
    }
}

