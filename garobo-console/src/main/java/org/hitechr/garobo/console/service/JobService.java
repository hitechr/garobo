/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package org.hitechr.garobo.console.service;


import lombok.extern.slf4j.Slf4j;
import org.hitechr.garobo.console.common.web.service.BaseService;
import org.hitechr.garobo.console.mapper.JobExecuterMapper;
import org.hitechr.garobo.console.mapper.JobMapper;
import org.hitechr.garobo.console.model.Job;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.hitechr.garobo.console.vo.JobVo;
import org.hitechr.garobo.console.model.JobExample;

@Service
@Slf4j
public class JobService extends BaseService<Job, JobExample> {

    @Autowired
    private JobMapper jobMapper;

    @Autowired
    private JobExecuterMapper jobExecuterMapper;

    /**
     * 保存job 和对应与执行器的关系记录
     * @param job
     * @param execIds
     */
    public void saveJobAndJobExecutor(Job job, Integer[] execIds) {
        int count = jobMapper.insertSelective(job);
        log.info("save job:{}, result:{}",job.getName(),count);

        //保存执行器和job的关系
        int executerCount = jobExecuterMapper.saveRelation(job.getId(), job.getGroupId(), execIds);
        log.info("job:{} bound execter count:{}",job.getName(),executerCount);


        //如果都保存成功了，则添加到内存里，等待自动触发



    }


}
