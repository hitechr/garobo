package org.hitechr.garobo.exec.handler;
/**
 * @Package org.hitechr.garobo.exec.handler
 * @Title: CommandExecuteResultHandler
 * @author hitechr
 * @date 2018/8/1 15:36
 * @version V1.0
 */

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.exec.*;
import org.hitechr.garobo.common.entity.Response;
import org.hitechr.garobo.exec.common.DogHose;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;

/**
 * @Descriptions:
 */
@Slf4j
public abstract class CommandExecuteResultHandler extends DefaultExecuteResultHandler {

    ByteArrayOutputStream outputStream =null;
    private ExecuteWatchdog watchdog;
    String result;
    Response response= new Response();
    String pid;


    @Override
    public void onProcessComplete(int exitValue) {
        end();
        log.info("pid:{} success exitValue:{}",pid,exitValue);
        super.onProcessComplete(exitValue);

        DogHose.remove(pid);
        response.setExitValue(getExitValue());
        try {
            outputStream.flush();
            result= outputStream.toString("UTF-8");
            log.info("pid:{},result:{}",pid,result);
            response.setResult(result);
            callBack(response);
        } catch (IOException e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
    }

    protected abstract void callBack(Response response);

    @Override
    public void onProcessFailed(ExecuteException e) {
        end();
        super.onProcessFailed(e);
        log.info("pid:{} process failed exitValue:{}",pid,getExitValue());
        ExecuteWatchdog remove = DogHose.remove(pid);
        if(remove==null){
            result="killed!";
            response.setResult(result);
        }else if (watchdog != null && watchdog.killedProcess()) {
            result="process timed out";
            response.setResult(result);
        }else{
            result=e.getLocalizedMessage();
            response.setResult(result);
        }
        log.info("pid:{} result:{}",pid,result);
        response.setExitValue(getExitValue());
        callBack(response);

    }

    public void setOutputStream(ByteArrayOutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void setWatchdog(ExecuteWatchdog watchdog) {
        this.watchdog = watchdog;
    }

    public String getResult() {
        return result;
    }

    public void begin(){
        response.setStartDate(new Date());
    }
    public void end(){
        response.setEndDate(new Date());
    }

    public void setPid(String pid) {
        this.pid = pid;
    }
}
