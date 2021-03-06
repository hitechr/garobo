/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package org.hitechr.garobo.console.service;


import lombok.extern.slf4j.Slf4j;
import org.hitechr.garobo.console.common.web.service.BaseService;
import org.hitechr.garobo.console.mapper.JobDepMapper;
import org.hitechr.garobo.console.mapper.JobExecuterMapper;
import org.hitechr.garobo.console.mapper.JobMapper;
import org.hitechr.garobo.console.model.Job;
import org.hitechr.garobo.console.scheduler.JobBean;
import org.hitechr.garobo.console.scheduler.QuartzUtils;
import org.hitechr.garobo.console.scheduler.SchedulerManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.hitechr.garobo.console.model.JobExample;

import java.util.Arrays;
import java.util.stream.Stream;

@Service
@Slf4j
public class JobService extends BaseService<Job, JobExample> {

    @Autowired
    private JobMapper jobMapper;

    @Autowired
    private JobExecuterMapper jobExecuterMapper;

    @Autowired
    private JobDepMapper jobDepMapper;

    @Autowired
    private SchedulerManager schedulerManager;

    /**
     * 保存job 和对应与执行器的关系记录
     * @param job
     * @param execIds
     * @param depJobIds
     */
    public void saveJobAndJobExecutor(Job job, Integer[] execIds, Integer[] depJobIds) {

        int count = jobMapper.insertSelective(job);
        log.info("save job:{}, result:{}",job.getName(),count);

        //保存执行器和job的关系
        int executerCount = jobExecuterMapper.saveRelation(job.getId(), job.getGroupId(), execIds);
        log.info("job:{} bound execter count:{}",job.getName(),executerCount);

        //保存任务的依赖关系记录

        if(Stream.of(depJobIds).count()>0){
            int relationCount=jobDepMapper.saveDepRelation(job.getGroupId(),job.getId(),depJobIds);
            log.info("job:{} save depRelation count:{}",job.getName(),relationCount);

            //更新作业的是否最后一个节点
            updateJobDepRelationLastValue(depJobIds);

        }

        //如果都保存成功了，则添加到内存里，等待自动触发
        if(job.getFlowNum()==0){//只有根节点的任务才可以添加到执行器中
            JobBean jobBean = QuartzUtils.wrapJob(job);
            schedulerManager.addJob(jobBean);//添加到执行器里面去
        }

    }

    private int updateJobDepRelationLastValue(Integer[] depJobIds) {
        return jobDepMapper.updateJobLastValue(depJobIds);

    }


    public int selectMaxFlowNum(Integer[] depJobIds) {
        return jobMapper.selectMaxFlowNum(depJobIds);
    }
}
