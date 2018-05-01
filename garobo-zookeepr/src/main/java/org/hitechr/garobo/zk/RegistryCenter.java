package org.hitechr.garobo.zk;
/**
 * @Package org.hitechr.garobo.zk
 * @Title: RegistryCenter
 * @author hapic
 * @date 2018/4/28 15:05
 * @version V1.0
 */

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @Descriptions:
 */
@Slf4j
public class RegistryCenter {


    private ZookeeperConfiguration zkConfig;

    public RegistryCenter(ZookeeperConfiguration zkConfig) {
        this.zkConfig = zkConfig;
        init();
    }

    @Getter
    private CuratorFramework client;

    public void init() {
        log.info("garobo zookeeper register address:{}",zkConfig.getAddress());
        ExponentialBackoffRetry exponentialBackoffRetry = new ExponentialBackoffRetry(1000, zkConfig.getMaxRetries(), zkConfig.getSleepBetweenRetries());
        CuratorFrameworkFactory.Builder builder = CuratorFrameworkFactory.builder()
                .connectString(zkConfig.getAddress())
                .retryPolicy(exponentialBackoffRetry)
                .namespace(zkConfig.getNamespace());

        if(zkConfig.getSessionTimeout()!=0){
            builder.sessionTimeoutMs(zkConfig.getSessionTimeout());
        }
        if(zkConfig.getConnectionTimeout()!=0){
            builder.connectionTimeoutMs(zkConfig.getConnectionTimeout());
        }
        try {
            client = builder.build();
            client.start();
            boolean b = client.blockUntilConnected(zkConfig.getMaxRetries()*zkConfig.getSleepBetweenRetries(), TimeUnit.MILLISECONDS);
            if(!b){
                throw new KeeperException.OperationTimeoutException();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        try {
            String address="192.168.2.16:2181";
            String nameSpace="garobo";
            RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
            CuratorFramework client1 = CuratorFrameworkFactory.builder().connectString(address)
                    .sessionTimeoutMs(5000)//会话超时时间
                    .connectionTimeoutMs(5000)//连接超时时间
                    .namespace(nameSpace)
                    .retryPolicy(retryPolicy)
                    .build();

            client1.start();
            client1.blockUntilConnected(5000 * 3, TimeUnit.MILLISECONDS);
            boolean connected = client1.getZookeeperClient().isConnected();
            System.out.println(connected);
            String path = client1.create().creatingParentsIfNeeded()//若创建节点的父节点不存在会先创建父节点再创建子节点
                    .withMode(CreateMode.EPHEMERAL)//withMode节点类型，
                    .withACL(ZooDefs.Ids.OPEN_ACL_UNSAFE)
                    .forPath("/curator/3","131".getBytes());
            System.out.println(path);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
