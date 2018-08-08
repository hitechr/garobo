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
        ExecuterExample executerExample= new ExecuterExample();
        executerExample.createCriteria()
                .andIpEqualTo(ip);

        Executer dbExecuter = executerMapper.getByExample(executerExample);
        Optional<Executer> opExecuter = Optional.ofNullable(dbExecuter);
        if(opExecuter.isPresent()){
            Integer id = dbExecuter.getId();
            executer.setId(id);
            executerMapper.updateByPrimaryKey(executer);
        }else{
            executerMapper.insertSelective(executer);
            log.info("insert executer:{},ip:{}",executer.getId(),executer.getIp());
        }

    }
}
