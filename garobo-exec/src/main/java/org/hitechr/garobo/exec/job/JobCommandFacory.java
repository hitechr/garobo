package org.hitechr.garobo.exec.job;
/**
 * @Package org.hitechr.garobo.exec.job
 * @Title: JobCommandFacory
 * @author hapic
 * @date 2018/5/3 16:46
 * @version V1.0
 */

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @Descriptions:
 */
public class JobCommandFacory {

    private static ConcurrentMap<Integer,JobCommand> commandConcurrentMap=new ConcurrentHashMap<>();

    public static Class<? extends JobCommand> commdTypeClass(Integer type) {
        return commdType(type).getClass();
    }


    public static JobCommand commdType(Integer type) {
        return commandConcurrentMap.get(type);
    }
    public static void addJobCommand(Integer type,JobCommand jobCommand){
        commandConcurrentMap.putIfAbsent(type,jobCommand);
    }
}
