package org.hitechr.garobo.console.serviceTest;
/**
 * @Package org.hitechr.garobo.console.serviceTest
 * @Title: BaseTest
 * @author hitechr
 * @date 2018/8/3 14:14
 * @version V1.0
 */

import org.hitechr.garobo.console.Application;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @Descriptions:
 */
//@EnableWebMvc
//@WebAppConfiguration
@SpringBootTest(classes = { Application.class})
public class BaseTest  extends AbstractTestNGSpringContextTests {
}
