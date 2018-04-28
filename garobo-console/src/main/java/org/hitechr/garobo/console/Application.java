package org.hitechr.garobo.console;
/**
 * @Package org.hitechr.garobo.console
 * @Title: Application
 * @author hapic
 * @date 2018/4/24 20:09
 * @version V1.0
 */

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Descriptions:
 */
@ComponentScan( basePackages = {"org.hitechr.garobo.console"})
@EnableAutoConfiguration
@MapperScan("org.hitechr.garobo.console.mapper")//将项目中对应的mapper类的路径加进来就可以了
public class Application extends SpringBootServletInitializer implements EmbeddedServletContainerCustomizer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        container.setPort(8081);
    }
}