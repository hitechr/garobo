package org.hitechr.garobo.zk;
/**
 * @Package org.hitechr.garobo.zk
 * @Title: ZookeeperServer
 * @author hapic
 * @date 2018/4/28 14:31
 * @version V1.0
 */

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.*;
import org.apache.zookeeper.CreateMode;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

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
     * 创建一个临时目录节点
     * @param path
     * @param value
     * @throws Exception
     */
    public void createPath(String path,String value) {
        try {
            String forPath = client.create().creatingParentsIfNeeded()//若创建节点的父节点不存在会先创建父节点再创建子节点
                    .withMode(CreateMode.EPHEMERAL)//withMode节点类型，
                    .forPath(path, bytes(value));
            log.info("create path:{} value:{}",forPath,value);
        } catch (Exception e) {
            ExceptionHandler.handleException(e);
        }
    }

    /**
     * 创建固定的目录 节点
     * @param path
     * @param value
     */
    public void createPathPer(String path,String value) {
        try {
            String forPath = client.create().creatingParentsIfNeeded()//若创建节点的父节点不存在会先创建父节点再创建子节点
                    .withMode(CreateMode.PERSISTENT)//withMode节点类型，
                    .forPath(path, bytes(value));
            log.info("create path:{} value:{}",forPath,value);
        } catch (Exception e) {
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
        } catch (final Exception ex) {
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

    /**
     * 获取value的值
     * @param path
     * @return
     */
    public String getData(String path)  {
        try {
            if(!isExisted(path)){
                return null;
            }
            return new String(client.getData().forPath(path));
        } catch (Exception e) {
            e.printStackTrace();
            ExceptionHandler.handleException(e);
        }
        return null;
    }

    /**
     * 给节点绑定监听事件
     * @param path
     * @param listener
     */
    public void addPathListener(String path,PathCacheListener listener){
        try {
            NodeCache nodeCache = new NodeCache(client,path);
            nodeCache.start();
            nodeCache.getListenable().addListener(()->listener.changed());
        } catch (Exception e) {
            e.printStackTrace();
            ExceptionHandler.handleException(e);
        }
    }
    public void addPathChildListener(String path,ChildrenCacheListener listener){

        try {
            PathChildrenCache cache = new PathChildrenCache(client, path, true);

            cache.start(PathChildrenCache.StartMode.POST_INITIALIZED_EVENT);
            cache.getListenable().addListener((client,event)-> listener.change(event)
            );
        } catch (Exception e) {
            e.printStackTrace();
            ExceptionHandler.handleException(e);
        }


    }

    /**
     * 获取孩子节点
     * @param path
     * @return
     */
    public List<String> getChildPath(String path) {
        try {
            if(isExisted(path)){
                return client.getChildren().forPath(path);
            }
            return Lists.newArrayList();


        } catch (Exception e) {
            e.printStackTrace();
            ExceptionHandler.handleException(e);
        }
        return Lists.newArrayList();


    }
}
