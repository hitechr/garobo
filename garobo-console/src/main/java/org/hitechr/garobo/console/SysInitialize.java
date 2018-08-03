package org.hitechr.garobo.console;
/**
 * @Package org.hitechr.garobo.console
 * @Title: SysInitialize
 * @author hitechr
 * @date 2018/8/3 12:50
 * @version V1.0
 */

import lombok.extern.slf4j.Slf4j;
import org.hitechr.garobo.common.MachineInfo;
import org.hitechr.garobo.console.zk.ZKSevice;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Descriptions:
 */
@Configuration
@Slf4j
public class SysInitialize extends WebMvcConfigurerAdapter implements InitializingBean {

    @Autowired
    private ZKSevice zkSevice;

    @Autowired
    private MachineInfo machineInfo;

    @Override
    public void afterPropertiesSet() throws Exception {
        initConsole();

    }

    private void initConsole() {
        log.info("init console info to zk...");
        zkSevice.register(machineInfo);
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {

    }
}
