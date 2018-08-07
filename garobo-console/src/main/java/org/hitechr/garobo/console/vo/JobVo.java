/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */


package  org.hitechr.garobo.console.vo;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;
import  org.hitechr.garobo.console.model.Job;

import javax.validation.constraints.NotNull;


@Setter
@Getter
public class  JobVo {


    private Integer id;

    @NotBlank(message = "作业的名称不能为空!")
    private String name;

    private Integer type;

    private Boolean last;

    private Integer status;

    @NotBlank(message = "触发表达式不能为空!")
    private String jobCron;

    @NotBlank(message = "执行命令不能为空!")
    private String command;

    private String jobDesc;

    private Integer flowNum;

    @NotNull(message = "任务组不能为空!")
    private Integer groupId;

    private Integer successCode;

    private Integer weight=0;

    private Integer redo;

    private Integer redoNow;

    private Integer alarmCode;

    private Integer timeOut;

    private java.util.Date insertDate;

    private java.util.Date udateDate;

    //执行器ID
    private Integer[] execIds;

    //依赖任务ID
    private Integer[] depJobId;





	

}
