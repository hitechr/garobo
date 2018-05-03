package org.hitechr.garobo.exec.common;

/**
 * Created by ShenQi on 18/5/3.
 */

import lombok.Getter;
import lombok.Setter;
import org.hitechr.garobo.model.Job;

import java.util.Date;

/**
 * 每次执行的job实力
 */
@Setter
@Getter
public class TaskCommand extends Job{



    private Date startDate;
    private Date endDate;



}
