package org.hitechr.garobo.console.web;
/**
 * @Package org.hitechr.garobo.console.web
 * @Title: Test
 * @author hapic
 * @date 2018/4/24 20:10
 * @version V1.0
 */

import org.hitechr.garobo.common.entity.Response;
import org.hitechr.garobo.common.web.BaseController;
import org.hitechr.garobo.console.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Descriptions:
 */
@RestController
public class Test extends BaseController {


    @Autowired
    private JobService jobService;

    @PostMapping("/hi")
    public Response test1() {
        return successResponse("hello!");
    }
}
