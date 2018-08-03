package org.hitechr.garobo.console.zk;
/**
 * @Package org.hitechr.garobo.console.zk
 * @Title: ZKSevice
 * @author hitechr
 * @date 2018/8/3 12:59
 * @version V1.0
 */

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.hitechr.garobo.common.MachineInfo;
import org.hitechr.garobo.zk.ZookeeperServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import static org.hitechr.garobo.zk.ZKPath.*;


/**
 * @Descriptions:
 */
@Component
@Slf4j
public class ZKSevice {

    @Autowired
    private ZookeeperServer zookeeperServer;



    public void register(MachineInfo machineInfo) {
        try {
            String ip=machineInfo.getIp();

            String consoleStatusPath=getConsoleStatusPath(ip);

            String consoleStatus=zookeeperServer.getData(consoleStatusPath);
            log.info("console path:{} status:{}",consoleStatusPath,consoleStatus);
            if(consoleStatus==null){
                //首先创建一个status的临时目录节点
                String macJson = JSONObject.toJSONString(machineInfo);
                zookeeperServer.createPath(consoleStatusPath, macJson);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
