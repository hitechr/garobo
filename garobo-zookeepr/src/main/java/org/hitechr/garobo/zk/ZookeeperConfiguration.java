package org.hitechr.garobo.zk;
/**
 * @Package org.hitechr.garobo.zk
 * @Title: ZookeeperConfiguration
 * @author hapic
 * @date 2018/4/28 14:26
 * @version V1.0
 */

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Descriptions: 注册中心zk的配置
 */
@Setter
@Getter

// https://www.jianshu.com/p/b71845c142d0
// spring boot1.5以上版本@ConfigurationProperties取消location注解后的替代方案
@Component
@ConfigurationProperties(prefix = "zookeeper")
//@Configuration
@PropertySource("zookeeper.properties")
//@PropertySource("classpath:/zookeeper.properties")
public class ZookeeperConfiguration {

    private String address;
    /**
     * 命名空间.
     */
    private String namespace;

    public ZookeeperConfiguration() {
    }

    public ZookeeperConfiguration(String address, String namespace) {
        this.address = address;
        this.namespace = namespace;
    }

    /**
     * 会话超时时间(MS)
     */
    private int sessionTimeout=1000*5;
    /**
     * //连接超时时间(MS)
     */
    private int connectionTimeout=1000*5;
    /**
     * //重试时间间隔(MS)
     */
    private int sleepBetweenRetries=1000*3;
    /**
     * //重试次数
     */
    private int maxRetries=3;

}
