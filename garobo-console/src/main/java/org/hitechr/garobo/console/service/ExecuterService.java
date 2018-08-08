/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package org.hitechr.garobo.console.service;


import jdk.nashorn.internal.runtime.options.Option;
import lombok.extern.slf4j.Slf4j;
import org.hitechr.garobo.console.common.web.service.BaseService;
import org.hitechr.garobo.console.mapper.ExecuterMapper;
import org.hitechr.garobo.console.model.Executer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.hitechr.garobo.console.vo.ExecuterVo;
import org.hitechr.garobo.console.model.ExecuterExample;

import java.util.Optional;

@Service
@Slf4j
public class ExecuterService extends BaseService<Executer, ExecuterExample> {

    @Autowired
    private ExecuterMapper executerMapper;

    public void updateExecuterInfo(Executer executer) {
        String ip = executer.getIp();

        Optional<Executer> opExecuter = selectExecuterByIp(ip);

        if(opExecuter.isPresent()){
            Executer dbExecuter = opExecuter.get();
            Integer id = dbExecuter.getId();
            if(dbExecuter.getStatus()==1){//如果在线状态 下作处理
                return;
            }
            executer.setId(id);
            if(executer.getStatus()==0){//下线
                log.info("executer ip:{} down!",executer.getIp());
                executerMapper.clearExecuter(executer);
            }else{//上线
                log.info("executer ip:{} up!",executer.getIp());
                executerMapper.updateByPrimaryKeySelective(executer);
            }
        }else{
            executerMapper.insertSelective(executer);
            log.info("insert executer:{},ip:{} up!",executer.getId(),executer.getIp());
        }
    }


    /**
     * 根据IP查找执行器
     * @param ip
     * @return
     */
    public Optional<Executer> selectExecuterByIp(String ip){
        ExecuterExample executerExample= new ExecuterExample();
        executerExample.createCriteria()
                .andIpEqualTo(ip);

        Executer dbExecuter = executerMapper.getByExample(executerExample);
        return Optional.ofNullable(dbExecuter);
    }


}
