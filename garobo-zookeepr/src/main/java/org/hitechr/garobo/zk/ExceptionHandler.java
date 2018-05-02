package org.hitechr.garobo.zk;
/**
 * @Package org.hitechr.garobo.zk
 * @Title: ExceptionHandler
 * @author hapic
 * @date 2018/4/28 17:20
 * @version V1.0
 */

import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.KeeperException;

/**
 * @Descriptions:
 */
@Slf4j
public class ExceptionHandler {
    public static void handleException(final Exception cause) {
        if (isIgnoredException(cause) || isIgnoredException(cause.getCause())) {
            log.debug("ignored exception for: {}", cause.getMessage());
        } else if (cause instanceof InterruptedException) {
            Thread.currentThread().interrupt();
        } else {
            throw new ZookeeperException(cause);
        }
    }

    private static boolean isIgnoredException(final Throwable cause) {
        return null != cause &&
                (cause instanceof KeeperException.ConnectionLossException
                        || cause instanceof KeeperException.NoNodeException
                        || cause instanceof KeeperException.NodeExistsException);
    }
}
