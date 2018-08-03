package org.hitechr.garobo.common;
/**
 * @Package org.hitechr.garobo.common.utils
 * @Title: MachineUtils
 * @author hapic
 * @date 2018/4/28 14:08
 * @version V1.0
 */

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @Descriptions: 机器相关的信息
 */
@Setter
@Getter
public class MachineInfo implements Serializable{

    private String ip;

    private String mac;

    private Integer pid;

    private int port;
    //运行时的UUID
    private String runid;

    //当前机器类型
    private String type;

    private Date startDate;


}
