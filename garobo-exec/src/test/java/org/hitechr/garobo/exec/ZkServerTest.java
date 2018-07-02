package org.hitechr.garobo.exec;
/**
 * @Package org.hitechr.garobo.exec
 * @Title: ZkServerTest
 * @author hapic
 * @date 2018/5/2 17:12
 * @version V1.0
 */

import com.alibaba.fastjson.JSONObject;
import org.hitechr.garobo.exec.common.MachineInfo;
import org.hitechr.garobo.exec.service.ZKSevice;
import org.hitechr.garobo.model.Job;
import org.hitechr.garobo.zk.ZookeeperConfiguration;
import org.hitechr.garobo.zk.ZookeeperServer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.StringJoiner;
import java.util.function.BiPredicate;
import java.util.function.Supplier;

/**
 * @Descriptions:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BaseTest.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
@ComponentScan( basePackages = {"org.hitechr.garobo.exec","org.hitechr.garobo.zk"})
public class ZkServerTest  {

    @Autowired
    private ZKSevice zkServer;

    @Autowired
    private ZookeeperServer zookeeperServer;

    @Test
    public void createJob(){

        Job job= new Job();
        job.setName("job_1");
        job.setGroupId(1);
        job.setJobCron("0 0/10 * * * ? ");
        job.setJobDesc("测试程序");
        job.setFlowNum(0);

        String jobData = JSONObject.toJSONString(job);
        String path="/jobs/"+job.getName();
        zookeeperServer.createPathPer(path,jobData);
        path="/agent/192.168.2.12/jobs/"+job.getName();
        zookeeperServer.createPathPer(path,jobData);


        try {
            Thread.sleep(10000*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

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

    @Test
    public void test12(){

        BiPredicate<List<String>, String> contains =(list, element) -> list.contains(element);
        BiPredicate<List<String>, String> contains2 =List::contains;
//        BiPredicate<List<String>, String> contains3 =list::contains;
        Supplier<Job> jobSupplier = Job::new;
        Job job = jobSupplier.get();


        StringJoiner sj= new StringJoiner(",");
        sj.add("a").add("b").add("c").add("d");
        

        System.out.println(sj);
    }
}
