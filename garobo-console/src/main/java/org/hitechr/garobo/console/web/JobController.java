package org.hitechr.garobo.console.web;
/**
 * @Package org.hitechr.garobo.console.web
 * @Title: JobController
 * @author hitechr
 * @date 2018/8/3 13:29
 * @version V1.0
 */

import lombok.extern.slf4j.Slf4j;
import org.hitechr.garobo.common.entity.Response;
import org.hitechr.garobo.common.web.BaseController;
import org.hitechr.garobo.console.model.Group;
import org.hitechr.garobo.console.model.Job;
import org.hitechr.garobo.console.service.GroupService;
import org.hitechr.garobo.console.service.JobService;
import org.hitechr.garobo.console.vo.JobVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @Descriptions:
 */
@RestController
@RequestMapping("/job")
@Slf4j
@Validated
public class JobController extends BaseController {

    @Autowired
    private JobService jobService;

    @Autowired
    private GroupService groupService;


    @PostMapping("/save.do")
    public Response saveJob(@Valid JobVo jobVo){

        //验证所选组是否存在
        Integer groupId = jobVo.getGroupId();
        Optional<Group> opGroup = groupService.selectByPrimaryId(groupId);
        if(!opGroup.isPresent()){//如果不存在
            log.info("jobName:{} bond to groupId:{} no exist!",jobVo.getName(),groupId);
            return otherResponse(Response.Status.NULL,"任务组不存在!");
        }

        //验证所选组执行器


        Job job= new Job();
        BeanUtils.copyProperties(jobVo,job);

        //要把作业设置相关的属性值
        job.setLast(true);

        if(Stream.of(jobVo.getDepJobId()).count()>0){
            int flowNum=jobService.selectMaxFlowNum(jobVo.getDepJobId());
            job.setFlowNum(flowNum+1);
        }

        //保存job和对应执行器
        jobService.saveJobAndJobExecutor(job,jobVo.getExecIds(),jobVo.getDepJobId());

        return successResponse("保存成功");
    }




}
