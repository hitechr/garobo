package org.hitechr.garobo.zk;
/**
 * @Package org.hitechr.garobo.zk
 * @Title: ZookeeperServer
 * @author hapic
 * @date 2018/4/28 14:31
 * @version V1.0
 */

import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.CreateMode;

import java.nio.charset.Charset;

/**
 * @Descriptions: zk配置中心的访问类，单利
 */

@Slf4j
public class ZookeeperServer {
    private ZookeeperConfiguration zkConfig=null;

    public ZookeeperServer(ZookeeperConfiguration zkConfig) {
        this.zkConfig = zkConfig;
        init();
    }

    private CuratorFramework client;


    /**
     * 创建一个目录节点
     * @param path
     * @param value
     * @throws Exception
     */
    public void createPath(String path,String value) {
        try {
            String forPath = client.create().creatingParentsIfNeeded()//若创建节点的父节点不存在会先创建父节点再创建子节点
                    .withMode(CreateMode.EPHEMERAL)//withMode节点类型，
                    .forPath(path, bytes(value));
            log.info("create path:{}",forPath);
        } catch (Exception e) {
            //CHECKSTYLE:ON
            ExceptionHandler.handleException(e);
        }
    }

    /**
     * 更新
     * @param key
     * @param value
     */
    public void update(final String key, final String value) {
        try {
            client.inTransaction().check().
                    forPath(key).and().setData().
                    forPath(key, bytes(value)).and().commit();
            //CHECKSTYLE:OFF
        } catch (final Exception ex) {
            //CHECKSTYLE:ON
            ExceptionHandler.handleException(ex);
        }
    }

    /**
     * 判断是否存在
     * @param key
     * @return
     */
    public boolean isExisted(final String key) {
        try {
            return null != client.checkExists().forPath(key);
            //CHECKSTYLE:OFF
        } catch (final Exception ex) {
            //CHECKSTYLE:ON
            ExceptionHandler.handleException(ex);
            return false;
        }
    }



    public void init(){
        RegistryCenter registryCenter = new RegistryCenter(zkConfig);
        this.client=registryCenter.getClient();
    }

    private byte[] bytes(String value){
        return value.getBytes(Charset.forName("UTF-8"));
    }

}
