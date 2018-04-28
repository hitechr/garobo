package org.hitechr.garobo.zk;
/**
 * @Package org.hitechr.garobo.zk
 * @Title: ZookeeperException
 * @author hapic
 * @date 2018/4/28 17:21
 * @version V1.0
 */

/**
 * @Descriptions:
 */
public class ZookeeperException extends RuntimeException  {

    public ZookeeperException(String message) {
        super(message);
    }

    public ZookeeperException(Throwable cause) {
        super(cause);
    }
}
