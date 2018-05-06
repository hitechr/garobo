package org.hitechr.garobo.exec;
/**
 * @Package org.hitechr.garobo.exec
 * @Title: Application
 * @author hapic
 * @date 2018/4/28 13:49
 * @version V1.0
 */

import org.hitechr.garobo.common.Constants;
import org.hitechr.garobo.common.utils.MachineUtils;
import org.hitechr.garobo.exec.common.MachineInfo;
import org.hitechr.garobo.exec.job.JobCommandFacory;
import org.hitechr.garobo.exec.job.ShellJobCommand;
import org.hitechr.garobo.exec.listener.ShellJobCommandListener;
import org.hitechr.garobo.exec.service.ZKSevice;
import org.hitechr.garobo.exec.utils.SchedulerUtils;
import org.hitechr.garobo.exec.utils.TaskControl;
import org.hitechr.garobo.zk.ZookeeperConfiguration;
import org.hitechr.garobo.zk.ZookeeperServer;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;
import java.util.Date;

/**
 * @Descriptions: 启动程序的主类
 */
@SpringBootApplication
@ComponentScan( basePackages = {"org.hitechr.garobo.exec"})
//@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }



    @Bean
    public Scheduler schedulerFactoryBean() throws IOException, SchedulerException {
        SchedulerFactory factory =  new StdSchedulerFactory();
        return factory.getScheduler();
    }


    @Bean
    public ZookeeperServer zookeeperServer(ZookeeperConfiguration zkConfiguration){
//        ZookeeperServer zookeeperServer= new ZookeeperServer(zkConfiguration);
//        return  zookeeperServer;
        return null;
    }

    @Bean
    public void initScheduler(ZKSevice zkSevice, Scheduler scheduler){
        SchedulerUtils.init(zkSevice,scheduler);
    }


    @Bean
    public ShellJobCommand shellJobCommand(ShellJobCommandListener shellJobCommandListener){
        ShellJobCommand shellJobCommand = new ShellJobCommand(shellJobCommandListener);
        JobCommandFacory.addJobCommand(Constants.JOB_COMMAND_TYPE_SHELL,shellJobCommand);
        return shellJobCommand;
    }


    /**
     * 初始化机器 信息
     * @return
     */
    @Bean
    public MachineInfo initMachineInfo(){
        int pid = MachineUtils.pid();
        MachineInfo machineInfo= new MachineInfo();
        machineInfo.setStartDate(new Date());
        machineInfo.setPid(pid);
        machineInfo.setIp("192.168.2.12");
        machineInfo.setPort(7789);
        return machineInfo;
    }
}
