package org.hitechr.garobo.exec.controller;
/**
 * @Package org.hitechr.garobo.exec.controller
 * @Title: BaseController
 * @author hitechr
 * @date 2018/8/2 15:18
 * @version V1.0
 */

/**
 * @Descriptions:
 */
public class BaseController {

    public Response errorResponse(String msg){
        return new Response(msg,500);
    }
    public Response successResponse(String msg){
        return new Response(msg,200);
    }

}
