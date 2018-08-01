package org.hitechr.garobo.exec.common;
/**
 * @Package org.hitechr.garobo.exec.common
 * @Title: ExecUtils
 * @author hitechr
 * @date 2018/8/1 14:47
 * @version V1.0
 */



import org.apache.commons.exec.*;
import org.hitechr.garobo.exec.handler.CommandExecuteResultHandler;
import org.hitechr.garobo.model.Response;

import java.io.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @Descriptions:
 */
public class ExecUtils {




    /**
     * 执行命令，并设置超时时间
     * @param command
     * @param timeout
     */
    public static ExecuteWatchdog cmd(String pid,String command,long timeout,CommandExecuteResultHandler resultHandler) throws IOException {


        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ByteArrayOutputStream errorStream = new ByteArrayOutputStream();
        resultHandler.setOutputStream(outputStream);

        final CommandLine cmdLine = CommandLine.parse(command);
        DefaultExecutor executor = new DefaultExecutor();

        timeout=timeout>0?timeout:Long.MAX_VALUE;

        ExecuteWatchdog watchdog = new ExecuteWatchdog(timeout);
        executor.setWatchdog(watchdog);
        resultHandler.setWatchdog(watchdog);
        resultHandler.setPid(pid);

//        ExecuteStreamHandler stream = new PumpStreamHandler(outputStream, errorStream);
//        executor.setStreamHandler(stream);
        executor.setExitValue(0);
        resultHandler.begin();
        executor.execute(cmdLine,resultHandler);

        DogHose.add(pid,watchdog);

        return watchdog;
    }



    public static void main(String[] args) throws IOException {

        String command="ping 192.168.2.16 -t";
        CommandExecuteResultHandler commandExecuteResultHandler = new CommandExecuteResultHandler(){
            @Override
            protected void callBack(Response response) {
                System.out.println(response);
            }
        };
        ExecuteWatchdog watchdog = cmd("1",command, 5 * 1000, commandExecuteResultHandler);


        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        watchdog.destroyProcess();
        watchdog.stop();



    }


    public static void kill(String pid) {
        ExecuteWatchdog watchdog = DogHose.remove(pid);
        if(watchdog!=null){
            watchdog.destroyProcess();
        }
    }

}
