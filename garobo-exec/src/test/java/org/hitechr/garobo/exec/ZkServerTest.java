package org.hitechr.garobo.exec;
/**
 * @Package org.hitechr.garobo.exec
 * @Title: ZkServerTest
 * @author hapic
 * @date 2018/5/2 17:12
 * @version V1.0
 */

import org.hitechr.garobo.exec.common.MachineInfo;
import org.hitechr.garobo.exec.service.ZKSevice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @Descriptions:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BaseTest.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
@ComponentScan( basePackages = {"org.hitechr.garobo.exec"})
public class ZkServerTest  {

    @Autowired
    private ZKSevice zkServer;
    @Test
    public void testRegister(){
        String ip="192.168.2.12";
        int pid=12;
        MachineInfo machineInfo= new MachineInfo();
        machineInfo.setIp(ip);
        machineInfo.setPid(pid);
        machineInfo.setPid(1099);
        machineInfo.setStartDate(new Date());
        zkServer.register(machineInfo);

        String data = zkServer.getAgentStatusData(machineInfo);
        System.out.println(data);

        try {
            Thread.sleep(10000*100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
