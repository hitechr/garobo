package org.hitechr.garobo.console.filter;
/**
 * @Package org.hitechr.garobo.console.filter
 * @Title: BizExceptionHandler
 * @author hitechr
 * @date 2018/8/6 14:49
 * @version V1.0
 */

import org.hitechr.garobo.common.entity.Response;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Descriptions: Controller异常处理类
 */
@RestControllerAdvice
public class BizExceptionHandler {

    /**
     * 验证字段是否为空
     * @param e
     * @return
     */
    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Response bindException(BindException e) {

        Response response= new Response(Response.Status.ERROR);
        BindingResult bindingResult = e.getBindingResult();

        String defaultMessage = bindingResult.getFieldError().getDefaultMessage();
        response.setResult(defaultMessage);
        return response;
    }

    /**
     * 其他异常信息
     * @param ex
     * @return
     */
    /*@ExceptionHandler(value = Exception.class)
    public Response errorHandler(Exception ex) {
        Response response= new Response();
        response.setStatus(555);//未知异常
        response.setResult(ex.getMessage());
        return response;
    }*/
}
