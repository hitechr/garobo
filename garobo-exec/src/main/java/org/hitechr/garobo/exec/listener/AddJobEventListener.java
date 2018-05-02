package org.hitechr.garobo.exec.listener;
/**
 * @Package org.hitechr.garobo.exec.listener
 * @Title: AddJobEventListener
 * @author hapic
 * @date 2018/5/2 20:17
 * @version V1.0
 */

import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.recipes.cache.ChildData;
import org.hitechr.garobo.zk.ChildrenCacheListener;
import org.springframework.stereotype.Service;

/**
 * @Descriptions: 当job有被指定到当前机器时触发的事件
 */
@Slf4j
public class AddJobEventListener  extends ChildrenCacheListener {
    @Override
    protected void removeChild(ChildData data) {

        log.info("remove "+data.getPath()+" "+new String(data.getData()));
    }

    @Override
    protected void updateChild(ChildData data) {
        log.info("update "+data.getPath()+" "+new String(data.getData()));
    }

    @Override
    protected void addChild(ChildData data) {
        log.info("add "+data.getPath()+" "+new String(data.getData()));
    }
}
