package org.hitechr.garobo.exec;
/**
 * @Package org.hitechr.garobo.exec
 * @Title: SysInitialize
 * @author hapic
 * @date 2018/5/2 15:34
 * @version V1.0
 */

import lombok.extern.slf4j.Slf4j;
import org.hitechr.garobo.exec.common.MachineInfo;
import org.hitechr.garobo.exec.service.ZKSevice;
import org.hitechr.garobo.exec.utils.SchedulerUtils;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Descriptions: 系统 启动初始化工作
 */
@Component
@Slf4j
public class SysInitialize implements ApplicationContextAware, InitializingBean {
    private ApplicationContext applicationContext;

    @Autowired
    private Scheduler scheduler;

    @Autowired
    private ZKSevice zkServer;

    @Autowired
    private MachineInfo machineInfo;


    @Override
    public void afterPropertiesSet() throws Exception {

//        startScheduler();

//        initAgentZk();

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
        zkServer.watchJobListener(machineInfo);

    }

    /**
     * 注册zookeeper
     */
    private void initAgentZk() {
        log.info("init agent info to zk...");
        zkServer.register(machineInfo);
    }

    /**
     * 启动scheduler
     */
    private void startScheduler() {
        try {
            log.info("start scheduler....");
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }




}
