package org.hitechr.garobo.common.entity;
/**
 * @Package org.hitechr.garobo.model
 * @Title: Response
 * @author hitechr
 * @date 2018/8/1 15:58
 * @version V1.0
 */


import lombok.Getter;
import lombok.Setter;

import java.util.Date;


/**
 * @Descriptions:
 */

@Getter
@Setter
public class Response {

    private String result;
    private int exitValue;
    private int status;
    private Date startDate;
    private Date endDate;

    public Response() {
    }

    public Response(String result, int status) {
        this.result = result;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Response{" +
                "result='" + result + '\'' +
                ", exitValue=" + exitValue +
                ", status=" + status +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
