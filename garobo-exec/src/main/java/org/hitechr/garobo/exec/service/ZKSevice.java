package org.hitechr.garobo.exec.service;
/**
 * @Package org.hitechr.garobo.exec.server
 * @Title: ZKServer
 * @author hapic
 * @date 2018/5/2 15:45
 * @version V1.0
 */

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.hitechr.garobo.exec.common.MachineInfo;
import org.hitechr.garobo.exec.listener.AddJobEventListener;
import org.hitechr.garobo.exec.utils.SchedulerUtils;
import org.hitechr.garobo.model.Job;
import org.hitechr.garobo.zk.ZookeeperServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.hitechr.garobo.common.ZKPath.*;

/**
 * @Descriptions: 操作zk的方法
 */
@Component
@Slf4j
public class ZKSevice {

    @Autowired
    private ZookeeperServer zookeeperServer;


    public void register(MachineInfo machineInfo) {
        try {
            String ip=machineInfo.getIp();
            String agentStatusPath = getAgentStatusPath(ip);

            log.info("agenentStatus path:{}",agentStatusPath);
            String agentStatus=zookeeperServer.getData(agentStatusPath);
            log.info("agenent path:{} status:{}",agentStatusPath,agentStatus);

            if(agentStatus==null){
                //首先创建一个status的临时目录节点
                String macJson = JSONObject.toJSONString(machineInfo);
                zookeeperServer.createPath(agentStatusPath, macJson);

                String agentJobsPath = getAgentJobsPath(ip);
                zookeeperServer.createPathPer(agentJobsPath,"");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public String getAgentStatusData(MachineInfo machineInfo){
        try {
            String ip=machineInfo.getIp();
            String agentStatusPath = getAgentStatusPath(ip);
            return zookeeperServer.getData(agentStatusPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public void watchJobListener(MachineInfo machineInfo) {
        String ip = machineInfo.getIp();
        String agentJobsPath = getAgentJobsPath(ip);
        zookeeperServer.addPathChildListener(agentJobsPath,new AddJobEventListener());
    }

    /**
     * 初始化当前机器可以执行的job
     * @param machineInfo
     */
    public void initSchedulerJob(MachineInfo machineInfo) {
        String ip = machineInfo.getIp();
         String agentJobsPath = getAgentJobsPath(ip);
        List<String> childPathList = zookeeperServer.getChildPath(agentJobsPath);
        childPathList.stream()
                .filter(SchedulerUtils::checkRootJob)
                .forEach(SchedulerUtils::startJob);
    }
}
