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
import org.hitechr.garobo.common.Constants;
import org.hitechr.garobo.exec.common.MachineInfo;
import org.hitechr.garobo.exec.listener.AddJobEventListener;
import org.hitechr.garobo.exec.utils.SchedulerUtils;
import org.hitechr.garobo.model.Job;
import org.hitechr.garobo.zk.ChildrenCacheListener;
import org.hitechr.garobo.zk.PathCacheListener;
import org.hitechr.garobo.zk.ZookeeperConfiguration;
import org.hitechr.garobo.zk.ZookeeperServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.hitechr.garobo.zk.ZKPath.*;

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

    public void bindPathListener(String path,boolean firstCache, PathCacheListener listener){
        zookeeperServer.addPathListener(path,firstCache,listener);
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
                .filter(SchedulerUtils::checkRootJob)//获取起始节点的任务
                .forEach(SchedulerUtils::startJob);
    }

    public  List<String> getChildPath(String agentJobsPath){
        return zookeeperServer.getChildPath(agentJobsPath);
    }

    /**
     * 验证当前job依赖的任务是否都执行完成
     *
     * @param runId
     * @param jobName
     * @return
     */
    public boolean depJobDone(int runId, String jobName) {
        //获取当前任务依赖的任务完成的个数
//        zookeeperServer.

        return false;
    }

    public String getData(String jobPath) {
        return zookeeperServer.getData(jobPath);
    }

    public boolean isExisted(String path){
        return zookeeperServer.isExisted(path);
    }

    public void createRunningPath(int runId, String jobId,String ip) {
        String executePath = getExecutionJobPath(runId+"",jobId);
        Map<String,String> map= new HashMap<>();

        map.put(executePath+"/"+ Constants.status,Constants.status_running);
        map.put(executePath+"/"+Constants.execute,ip);
        map.put(executePath+"/"+Constants.result,"");
        map.put(executePath+"/"+Constants.dependent,"");
        zookeeperServer.createPath(map);


    }


    public void createResultPath(String path, String value,
                                 String deletePath,
                                 List<String> depJobListPath) {

        zookeeperServer.createPathAndDeletePath(path,value,deletePath,depJobListPath);
    }

    public void createChildPath(List<String> childJobList) {

        Map<String, String> collect = childJobList.stream()
                .collect(Collectors.toMap(String::toString, v -> ""));

        zookeeperServer.createPath(collect);
    }

    public void createExecutionJobPath(String jobId,String runnid) {
        String executePath = getExecutionJobPath(runnid,jobId);
        zookeeperServer.createPathPer(executePath,"");
    }

    public void createPath(String path,String value) {
        zookeeperServer.createPathPer(path,value);
    }

    /**
     * 获取当前任务的子任务
     * @param jobName
     */
    public List<String> getChildJob(String jobName) {
        String jobChildPath = getJobChilds(jobName);
        return this.getChildPath(jobChildPath);
    }
}
