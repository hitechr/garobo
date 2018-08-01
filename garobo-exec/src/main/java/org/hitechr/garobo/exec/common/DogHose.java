package org.hitechr.garobo.exec.common;
/**
 * @Package org.hitechr.garobo.exec.common
 * @Title: DogHose
 * @author hitechr
 * @date 2018/8/1 18:45
 * @version V1.0
 */

import org.apache.commons.exec.ExecuteWatchdog;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @Descriptions:
 */
public class DogHose {
    private static ConcurrentMap<String,ExecuteWatchdog> dogHouse= new ConcurrentHashMap<>();

    public static ExecuteWatchdog get(String pid){
        return dogHouse.get(pid);
    }
    public static void add(String pid,ExecuteWatchdog watchdog){
        dogHouse.putIfAbsent(pid,watchdog);
    }

    public static ExecuteWatchdog remove(String pid){
       return  dogHouse.remove(pid);
    }
}
