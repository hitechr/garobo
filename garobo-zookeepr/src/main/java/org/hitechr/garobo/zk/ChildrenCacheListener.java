package org.hitechr.garobo.zk;
/**
 * @Package org.hitechr.garobo.zk
 * @Title: ChildrenCacheListener
 * @author hapic
 * @date 2018/5/2 19:56
 * @version V1.0
 */

import org.apache.curator.framework.recipes.cache.ChildData;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent; /**
 * @Descriptions:
 */

public abstract class ChildrenCacheListener {


    public void change(PathChildrenCacheEvent event) {
        
        switch(event.getType()) {
            case CHILD_ADDED :
                addChild(event.getData());
                break;
            case CHILD_UPDATED :
                updateChild(event.getData());
                break;
            case CHILD_REMOVED :
                removeChild(event.getData());
                break;
            default:
                break;
        }
    }

    protected abstract void removeChild(ChildData data);

    protected abstract void updateChild(ChildData data);

    protected abstract void addChild(ChildData data);
}
