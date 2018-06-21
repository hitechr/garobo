package org.hitechr.garobo.exec.listener;
/**
 * @Package org.hitechr.garobo.exec.listener
 * @Title: ExecutionStatusListener
 * @author hitechr
 * @date 2018/6/21 14:24
 * @version V1.0
 */

import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.zookeeper.data.Stat;
import org.hitechr.garobo.common.Constants;
import org.hitechr.garobo.zk.PathCacheListener;

import static org.hitechr.garobo.zk.ZKPath.getPendingJobName;
import static org.hitechr.garobo.zk.ZKPath.getPendingJobPath;

/**
 * @Descriptions: 执行节点的状态监听事件
 */
@Slf4j
public class ExecutionStatusListener implements PathCacheListener {

    public ExecutionStatusListener() {
    }

    @Override
    public void changed(NodeCache nodeCache) {



    }
}
