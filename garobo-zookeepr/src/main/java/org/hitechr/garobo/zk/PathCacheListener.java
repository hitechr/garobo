package org.hitechr.garobo.zk;
/**
 * @Package org.hitechr.garobo.zk
 * @Title: PathCacheListener
 * @author hapic
 * @date 2018/5/2 19:15
 * @version V1.0
 */

import org.apache.curator.framework.recipes.cache.NodeCache;

/**
 * @Descriptions:
 */
public interface PathCacheListener {
    void changed(NodeCache nodeCache);
}
