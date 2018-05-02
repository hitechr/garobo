package org.hitechr.garobo.exec;
/**
 * @Package org.hitechr.garobo.exec
 * @Title: BaseTest
 * @author hapic
 * @date 2018/5/2 17:12
 * @version V1.0
 */

import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Descriptions:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BaseTest.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
@ComponentScan( basePackages = {"org.hitechr.garobo.exec","org.hitechr.garobo.zk"})
public class BaseTest {
}
