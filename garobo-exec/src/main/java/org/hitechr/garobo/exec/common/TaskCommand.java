package org.hitechr.garobo.exec.common;

/**
 * Created by ShenQi on 18/5/3.
 */

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 每次执行的job实力
 */
@Setter
@Getter
public class TaskCommand {



    private int runId;//运行的id

    private String executeIp;

    private Date startDate;
    private Date endDate;



}
