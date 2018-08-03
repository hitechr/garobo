package org.hitechr.garobo.exec;
/**
 * @Package org.hitechr.garobo.exec
 * @Title: SysInitialize
 * @author hapic
 * @date 2018/5/2 15:34
 * @version V1.0
 */

import lombok.extern.slf4j.Slf4j;
import org.hitechr.garobo.common.MachineInfo;
import org.hitechr.garobo.exec.handler.SecurityHandlerInterceptor;
import org.hitechr.garobo.exec.service.ZKSevice;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Descriptions: 系统 启动初始化工作
 */
@Component
@Slf4j
@Configuration
public class SysInitialize extends WebMvcConfigurerAdapter implements ApplicationContextAware, InitializingBean {
    private ApplicationContext applicationContext;



    @Autowired
    private ZKSevice zkServer;

    @Autowired
    private MachineInfo machineInfo;



    @Override
    public void afterPropertiesSet() throws Exception {

//        SchedulerUtils.init(zkServer,scheduler);

//        startScheduler();//开启任务触发的监听

        initAgentZk(); //注册当前执行器的信息到zk上

//        initScheduler();

//        addListener();
    }

    /**
     * 刚启动时初始化任务
     */
    private void initScheduler() {
        log.info("scheduler job...");
        zkServer.initSchedulerJob(machineInfo);

    }

    /**
     * 增加监听事件
     */
    private void addListener() {
        /**
         * 添加jobs节点的监听事件，当有任务任务指定到这个节点时进行注册
         */
//        zkServer.watchJobListener(machineInfo);

    }

    /**
     * 注册zookeeper
     */
    private void initAgentZk() {
        log.info("init agent info to zk...");
        zkServer.register(machineInfo);
    }



    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        SecurityHandlerInterceptor securityHandlerInterceptor = new SecurityHandlerInterceptor();
        securityHandlerInterceptor.setMachineInfo(machineInfo);
        registry.addInterceptor(securityHandlerInterceptor)
                .addPathPatterns("/cmd/*");
    }
}
