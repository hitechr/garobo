package org.hitechr.garobo.console;
/**
 * @Package org.hitechr.garobo.console
 * @Title: Application
 * @author hapic
 * @date 2018/4/24 20:09
 * @version V1.0
 */

import org.hitechr.garobo.common.MachineInfo;
import org.hitechr.garobo.common.utils.MachineUtils;
import org.hitechr.garobo.common.utils.SerNumUtils;
import org.hitechr.garobo.zk.ZookeeperConfiguration;
import org.hitechr.garobo.zk.ZookeeperServer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.Date;

/**
 * @Descriptions:
 */
@SpringBootApplication
@ComponentScan( basePackages = {"org.hitechr.garobo.console","org.hitechr.garobo.zk"})
@MapperScan("org.hitechr.garobo.console.mapper")//将项目中对应的mapper类的路径加进来就可以了
public class Application  {

    @Value("${server.port}")
    private Integer port;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

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
        machineInfo.setType("console");
        return machineInfo;
    }

    @Bean
    public ZookeeperServer zookeeperServer(ZookeeperConfiguration zookeeperConfiguration){
        ZookeeperServer zookeeperServer= new ZookeeperServer(zookeeperConfiguration);
        return  zookeeperServer;
    }


}
