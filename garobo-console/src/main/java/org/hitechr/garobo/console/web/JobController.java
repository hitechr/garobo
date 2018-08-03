package org.hitechr.garobo.console.web;
/**
 * @Package org.hitechr.garobo.console.web
 * @Title: JobController
 * @author hitechr
 * @date 2018/8/3 13:29
 * @version V1.0
 */

import org.hitechr.garobo.common.entity.Response;
import org.hitechr.garobo.common.web.BaseController;
import org.hitechr.garobo.console.model.Job;
import org.hitechr.garobo.console.service.JobService;
import org.hitechr.garobo.console.vo.JobVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Descriptions:
 */
@RestController
@RequestMapping("/job")
public class JobController extends BaseController {

    @Autowired
    private JobService jobService;


    @PostMapping("/save.do")
    public Response saveJob(JobVo jobVo){
        Job job= new Job();
        BeanUtils.copyProperties(jobVo,job);
        //保存job和对应执行器
        jobService.saveJobAndJobExecutor(job,jobVo.getExecIds());

        return successResponse("保存成功");
    }

}
