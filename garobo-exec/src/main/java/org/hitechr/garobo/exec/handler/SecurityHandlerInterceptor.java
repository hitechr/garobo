package org.hitechr.garobo.exec.handler;
/**
 * @Package org.hitechr.garobo.exec.handler
 * @Title: SecurityHandlerInterceptor
 * @author hitechr
 * @date 2018/8/2 14:20
 * @version V1.0
 */

import com.alibaba.fastjson.JSON;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.hitechr.garobo.exec.common.MachineInfo;
import org.hitechr.garobo.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Descriptions:
 */
@Component
@Slf4j
public class SecurityHandlerInterceptor extends HandlerInterceptorAdapter {


    @Setter
    private MachineInfo machineInfo;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String rid = request.getParameter("rid");

        if(rid==null || !machineInfo.getRunid().equals(rid)){
            Response response1= new Response("rid error",500);
            response.getWriter().write(JSON.toJSONString(response1));
            return false;
        }

        return super.preHandle(request, response, handler);
    }
}
