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
import org.hitechr.garobo.common.utils.SerNumUtils;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

/**
 * @Descriptions: 启动程序的主类
 */
@SpringBootApplication
@ComponentScan( basePackages = {"org.hitechr.garobo.exec","org.hitechr.garobo.zk"})
@EnableAutoConfiguration
public class Application {


    @Value("${server.port}")
    private Integer port;

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }




   /* public Scheduler schedulerFactoryBean() throws IOException, SchedulerException {
        SchedulerFactory factory =  new StdSchedulerFactory();
        return factory.getScheduler();
    }*/


    @Bean
    public ZookeeperServer zookeeperServer(ZookeeperConfiguration zookeeperConfiguration){
        ZookeeperServer zookeeperServer= new ZookeeperServer(zookeeperConfiguration);
        return  zookeeperServer;
    }

    /*@Bean
    public void initScheduler(ZKSevice zkSevice, Scheduler scheduler){
        SchedulerUtils.init(zkSevice,scheduler);
    }*/



    /*public ShellJobCommand shellJobCommand(ShellJobCommandListener shellJobCommandListener){
        ShellJobCommand shellJobCommand = new ShellJobCommand(shellJobCommandListener);
        JobCommandFacory.addJobCommand(Constants.JOB_COMMAND_TYPE_SHELL,shellJobCommand);
        return shellJobCommand;
    }*/


    /**
     * 初始化机器 信息
     * @return
     */
    @Bean
    public MachineInfo initMachineInfo(){
        int pid = MachineUtils.pid();
        String runid= SerNumUtils.uuid();

        MachineInfo machineInfo= new MachineInfo();
        machineInfo.setStartDate(new Date());
        machineInfo.setPid(pid);
        machineInfo.setIp(MachineUtils.ip());
        machineInfo.setPort(port);
        machineInfo.setRunid(runid);
        return machineInfo;
    }
}
