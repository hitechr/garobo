package org.hitechr.garobo.model;
/**
 * @Package org.hitechr.garobo.model
 * @Title: Response
 * @author hitechr
 * @date 2018/8/1 15:58
 * @version V1.0
 */


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;


/**
 * @Descriptions:
 */

@Getter
@Setter
@ToString
public class Response {

    private String result;
    private int exitValue;
    private int status;
    private Date startDate;
    private Date endDate;


}
