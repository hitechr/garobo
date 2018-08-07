package org.hitechr.garobo.common.web;
/**
 * @Package org.hitechr.garobo.exec.controller
 * @Title: BaseController
 * @author hitechr
 * @date 2018/8/2 15:18
 * @version V1.0
 */


import org.hitechr.garobo.common.entity.Response;



/**
 * @Descriptions:
 */
public class BaseController {

    public Response errorResponse(String msg){
        return new Response(msg,Response.Status.ERROR);
    }
    public Response successResponse(String msg){
        return new Response(msg,Response.Status.SUCCESS);
    }
    public Response successResponse(){
        return successResponse("处理成功");
    }

    public Response otherResponse(Response.Status code,String msg){
        return new Response(msg,code);
    }



}
