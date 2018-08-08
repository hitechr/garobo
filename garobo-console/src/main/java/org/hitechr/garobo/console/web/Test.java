package org.hitechr.garobo.console.web;
/**
 * @Package org.hitechr.garobo.console.web
 * @Title: Test
 * @author hapic
 * @date 2018/4/24 20:10
 * @version V1.0
 */

import org.hibernate.validator.constraints.NotBlank;
import org.hitechr.garobo.common.entity.Response;
import org.hitechr.garobo.common.web.BaseController;
import org.hitechr.garobo.console.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Descriptions:
 */
@RestController
@Validated
public class Test extends BaseController {


    @Autowired
    private JobService jobService;

    @PostMapping("/hi")
    public Response test1() {
        return successResponse("hello!");
    }

    @PostMapping("/second")
    public Response second(@NotBlank(message = "不能为空!")  String password){
        return successResponse(password);
    }

    @PostMapping("/first")
    @Valid
    public Response first(@NotBlank(message = "密码不能为空!")  String password){
        return successResponse(password);
    }
}
