package org.hitechr.garobo.exec.controller;
/**
 * @Package org.hitechr.garobo.exec.controller
 * @Title: CommandController
 * @author hitechr
 * @date 2018/8/1 16:28
 * @version V1.0
 */

import org.apache.commons.exec.ExecuteWatchdog;
import org.hitechr.garobo.exec.common.ExecUtils;
import org.hitechr.garobo.exec.handler.CommandExecuteResultHandler;
import org.hitechr.garobo.model.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * @Descriptions:
 */
@RestController
@RequestMapping("/cmd")
public class CommandController {

//    @RequestMapping(value ="execute", method = RequestMethod.GET )
    @GetMapping("/execute")
    public String cmd(String pid,String commond,Long timeout){

        try {
            ExecuteWatchdog cmd = ExecUtils.cmd(pid,commond, timeout, new CommandExecuteResultHandler() {
                @Override
                protected void callBack(Response response) {
                    System.out.println(response);
                }
            });
            System.out.println(pid+" "+cmd.toString());
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }

        return "success";
    }


    /**
     *
     * @param pid
     * @return
     */
    @GetMapping("/kill")
    public String kill(String pid){

        ExecUtils.kill(pid);

//        watchdog.stop();
        return "success";
    }

    public String cmdStatus(String pid){

        if (ExecUtils.watching(pid)){
            return "running";
        }else {//从zk上获取结果数据


        }


        return null;
    }

}
