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
import org.hitechr.garobo.exec.common.MachineInfo;
import org.hitechr.garobo.exec.listener.AddJobEventListener;
import org.hitechr.garobo.zk.ZookeeperServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.hitechr.garobo.common.ZKPath.getAgentJobsPath;
import static org.hitechr.garobo.common.ZKPath.getAgentStatusPath;

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
                .filter(child->{
                    String childPath=agentJobsPath + "/" + child;
                    String data = zookeeperServer.getData(childPath);
                    log.info("path:{},data:{}",childPath,data);
                    return "0".equals(data);
                })
                .forEach(child->{



        });
    }

    public static void main(String[] args) {
        List<String> list= new ArrayList<>();
        list.add("0");
        list.add("2");
        list.add("1");
        list.add("3");
        /**
         * child->{
         String childPath=agentJobsPath + "/" + child;
         String data = zookeeperServer.getData(childPath);
         log.info("path:{},data:{}",childPath,data);
         return "0".equals(data);
         }
         */

        list.stream().filter("0"::equals)
                .forEach(System.out::println);

        System.out.println("ok");
    }
}
