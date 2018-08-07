package org.hitechr.garobo.console.web;
/**
 * @Package org.hitechr.garobo.console.web
 * @Title: JobGroupController
 * @author hitechr
 * @date 2018/8/3 15:04
 * @version V1.0
 */

import lombok.extern.slf4j.Slf4j;
import org.hitechr.garobo.common.entity.Response;
import org.hitechr.garobo.common.web.BaseController;
import org.hitechr.garobo.console.model.Group;
import org.hitechr.garobo.console.service.GroupService;
import org.hitechr.garobo.console.vo.GroupVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

/**
 * @Descriptions:
 */
@RestController
@RequestMapping("/group")
@Slf4j
public class GroupController extends BaseController {

    @Autowired
    private GroupService groupService;

    @PostMapping("save")
    public Response save(@Valid GroupVo groupVo){
        Optional<Group> opGroup =groupService.findGroupByName(groupVo.getName());
        if(opGroup.isPresent()){//如果存在
            log.info("group name:{} has exist!",groupVo.getName());
            return otherResponse(Response.Status.EXIST,groupVo.getName()+"重复!");
        }

        Group group= new Group();
        BeanUtils.copyProperties(groupVo,group);
        groupService.insertSelective(group);
        log.info("save");
        return successResponse();
    }


    @PostMapping("checkName")
    public Response checkName(@Valid GroupVo groupVo){
        Optional<Group> opGroup =groupService.findGroupByName(groupVo.getName());
        if(opGroup.isPresent()){//如果存在
            return otherResponse(Response.Status.EXIST,"任务组名称:'"+groupVo.getName()+"'重复!");
        }
        return successResponse("'"+groupVo.getName()+"'可以使用");
    }

}
