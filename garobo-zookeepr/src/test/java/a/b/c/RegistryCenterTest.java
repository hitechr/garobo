package a.b.c;
/**
 * @Package a.b.c
 * @Title: RegistryCenterTest
 * @author hapic
 * @date 2018/4/28 15:15
 * @version V1.0
 */

import org.hitechr.garobo.zk.ZookeeperConfiguration;
import org.hitechr.garobo.zk.ZookeeperServer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Descriptions:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RegistryCenterTest.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
@ComponentScan( basePackages = {"org.hitechr.garobo.zk"})
public class RegistryCenterTest {

    private ZookeeperServer zooKeeperServer;

    @Before
    public void before(){
        String address="192.168.2.16:2181";
        String nameSpace="garobo";
        ZookeeperConfiguration zkc= new ZookeeperConfiguration(address,nameSpace);

        zooKeeperServer=new ZookeeperServer(zkc);

    }

    @Test
    public void testGet(){
        zooKeeperServer.createPath("/test","aa");

    }

}
