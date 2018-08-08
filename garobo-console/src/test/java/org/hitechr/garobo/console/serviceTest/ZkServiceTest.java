package org.hitechr.garobo.console.serviceTest;
/**
 * @Package org.hitechr.garobo.console.serviceTest
 * @Title: ZkServiceTest
 * @author hitechr
 * @date 2018/8/7 11:12
 * @version V1.0
 */

import com.alibaba.fastjson.JSONObject;
import org.hitechr.garobo.common.MachineInfo;
import org.hitechr.garobo.console.zk.ZKSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @Descriptions:
 */
public class ZkServiceTest extends BaseTest{

    @Autowired
    private ZKSevice zkSevice;

    @Test
    public void testExecuter(){
        long start = System.currentTimeMillis();
        List<String> objects = zkSevice.loadAllExecuter();
        objects.stream().forEach(status->{
            System.out.println(status);
        });
        long end = System.currentTimeMillis();

        System.out.println(end-start);


        try {
            Thread.sleep(1000*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
