package org.hitechr.garobo.console;
/**
 * @Package org.hitechr.garobo.console
 * @Title: SysInitialize
 * @author hitechr
 * @date 2018/8/3 12:50
 * @version V1.0
 */

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.recipes.cache.ChildData;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent;
import org.apache.curator.framework.recipes.cache.TreeCacheEvent;
import org.hitechr.garobo.common.MachineInfo;
import org.hitechr.garobo.console.model.Executer;
import org.hitechr.garobo.console.service.ExecuterService;
import org.hitechr.garobo.console.service.JobService;
import org.hitechr.garobo.console.zk.ZKSevice;
import org.hitechr.garobo.zk.ZKPath;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Date;
import java.util.List;

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

    @Autowired
    private JobService jobService;

    @Autowired
    private ExecuterService executerService;

    @Override
    public void afterPropertiesSet() throws Exception {
        initConsole();

        //监听客户端信息
        monitorExecutorMachine();

        //初始化执行Job
        initExecuteJob();

    }

    private void monitorExecutorMachine() {
        String path=ZKPath.getExecuter();

        zkSevice.bindExecutorListener(path,cacheEvent -> {
            ChildData currentData = cacheEvent.getData();
            log.info("path:{} data:{}",path,currentData);
            Executer executer= new Executer();
            if(currentData!=null){
                String execIp = currentData.getPath().replace(path,"").replace("/status","").replace("/","");
                executer.setIp(execIp);
            }

            PathChildrenCacheEvent.Type type = cacheEvent.getType();
            switch (type){
                case CHILD_ADDED:{
                    byte[] data = currentData.getData();
                    String stats= new String(data);
                    JSONObject jsonObject=(JSONObject)JSONObject.parse(stats);

                    MachineInfo execMachineInfo = jsonObject.toJavaObject(MachineInfo.class);
                    executer.setRid(execMachineInfo.getRunid());
                    executer.setUpDate(execMachineInfo.getStartDate());
                    executer.setPort(execMachineInfo.getPort());
                    executer.setStatus(1);//运行中
                    executer.setPid(execMachineInfo.getPid());
                    executerService.updateExecuterInfo(executer);
                    break;
                }
                case CHILD_REMOVED:{
                    executer.setRid(null);
                    executer.setUpDate(null);
                    executer.setPort(null);
                    executer.setStatus(0);//已经下线了
                    executerService.updateExecuterInfo(executer);
                    break;
                }
                default:{
                    System.out.println(type);
                }
            }
        });


        /*zkSevice.bindExecutorListener(path,event -> {
            ChildData data = event.getData();
            if(path.equals(data.getPath()) || data.getPath().contains("/status")){
                return;
            }

            Executer executer= new Executer();
            String execIp = data.getPath().replace(path,"").replace("/status","").replace("/","");
            executer.setIp(execIp);
            log.info("executor ip:{} event:{}",execIp,cacheEvent.getType());

            byte[] execData = data.getData();
            String stats= new String(execData);
            JSONObject jsonObject=(JSONObject)JSONObject.parse(stats);
            MachineInfo execMachineInfo = jsonObject.toJavaObject(MachineInfo.class);

            if(cacheEvent.getType().equals(TreeCacheEvent.Type.NODE_ADDED)){//添加节点

                executer.setRid(execMachineInfo.getRunid());
                executer.setUpDate(execMachineInfo.getStartDate());
                executer.setPort(execMachineInfo.getPort());
                executer.setStatus(1);//运行中
            }else if (cacheEvent.getType().equals(TreeCacheEvent.Type.NODE_REMOVED)){//节点下线
                executer.setRid(null);
                executer.setUpDate(null);
                executer.setPort(null);
                executer.setStatus(0);//已经下线了
            }
            executerService.updateExecuterInfo(executer);
        });*/



//        List<String> executerIpPaths = zkSevice.loadAllExecuter();

//        bindExecutorListener(ZKPath.getExecuter());
//        executerIpPaths.stream()
//                .filter(zkSevice::isExisted)//剔除一件下线的ip
//                .forEach(this::bindExecutorListener);//给每个存在的节点绑定事件
    }

    private void bindExecutorListener(String path) {




        String execIp=path.replace(ZKPath.getExecuter(),"")
                .replace("/status","").replace("/","");

        /*zkSevice.bindExecutorListener(path,nodeCache -> {
            ChildData currentData = nodeCache.getCurrentData();
            log.info("path:{} data:{}",path,currentData);
            Executer executer= new Executer();
            executer.setIp(execIp);
            if(currentData!=null){
                byte[] data = currentData.getData();
                String stats= new String(data);
                JSONObject jsonObject=(JSONObject)JSONObject.parse(stats);

                MachineInfo execMachineInfo = jsonObject.toJavaObject(MachineInfo.class);
                executer.setRid(execMachineInfo.getRunid());
                executer.setUpDate(execMachineInfo.getStartDate());
                executer.setPort(execMachineInfo.getPort());
                executer.setStatus(1);//运行中
            }else {
                executer.setRid(null);
                executer.setUpDate(null);
                executer.setPort(null);
                executer.setStatus(0);//已经下线了
            }

            executerService.updateExecuterInfo(executer);
        });*/
    }

    private void initExecuteJob() {



    }

    private void initConsole() {
        log.info("init console info to zk...");
        zkSevice.register(machineInfo);
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {

    }
}
