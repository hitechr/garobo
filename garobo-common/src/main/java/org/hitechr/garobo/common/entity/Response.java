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
    @Getter
    private int status;
    private Date startDate;
    private Date endDate;

    public Response(){}
    public Response(Status status) {
        this.status = status.getCode();
    }

    public Response(String result, Status status) {
        this.result = result;
        this.status = status.getCode();
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

    public enum Status{
        SUCCESS(0),
        FAIL(1),
        ERROR(2),
        NULL(3),
        EXIST(4);

        int code;

        Status(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }
    }
}
