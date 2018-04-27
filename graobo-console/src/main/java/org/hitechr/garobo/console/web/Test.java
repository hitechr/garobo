package org.hitechr.garobo.console.web;
/**
 * @Package org.hitechr.garobo.console.web
 * @Title: Test
 * @author hapic
 * @date 2018/4/24 20:10
 * @version V1.0
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Descriptions:
 */
@Controller
public class Test {

    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    @ResponseBody
    public String test1() {
        return "spring boot multiple modules test";
    }
}
