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
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent;
import org.apache.curator.framework.recipes.cache.TreeCacheEvent;
import org.apache.curator.framework.recipes.cache.TreeCacheListener;
import org.hitechr.garobo.common.MachineInfo;
import org.hitechr.garobo.zk.ZKPath;
import org.hitechr.garobo.zk.ZookeeperServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static org.hitechr.garobo.zk.ZKPath.getConsoleStatusPath;
import static org.hitechr.garobo.zk.ZKPath.getExecuter;


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

    /**
     * 加载当前可用的Executer信息
     */
    public List<String> loadAllExecuter() {
        List<String> executerIps = zookeeperServer.getChildPath(getExecuter());
       return executerIps.stream()
                .map(ZKPath::getAgentStatusPath)//获取所有的status信息
//                .filter(StringUtils::isNotBlank)//剔除下线的ip
//                .map(JSONObject::parse)//转换为MacheInfo对象
////                .map(obj->{
////                    JSONObject jsonObject=(JSONObject)obj;
////                    return jsonObject.toJavaObject(MachineInfo.class);
////                })
                .collect(Collectors.toList());
    }

    public boolean isExisted(String path){
        return zookeeperServer.isExisted(path);
    }

    public void bindExecutorListener(String path, Consumer<PathChildrenCacheEvent> consumer) {
        try {
            zookeeperServer.addPathChildListener(path,true,(client,event)->{
                consumer.accept(event);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
