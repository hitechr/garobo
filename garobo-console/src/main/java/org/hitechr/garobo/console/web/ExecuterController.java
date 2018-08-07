package org.hitechr.garobo.console.web;
/**
 * @Package org.hitechr.garobo.console.web
 * @Title: ExecuterController
 * @author hitechr
 * @date 2018/8/3 15:06
 * @version V1.0
 */

import org.hitechr.garobo.common.entity.Response;
import org.hitechr.garobo.console.service.ExecuterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Descriptions:
 */
@RestController
@RequestMapping("/exec")
public class ExecuterController  {


    @Autowired
    private ExecuterService executerService;





}
