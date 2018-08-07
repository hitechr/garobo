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
import  org.hitechr.garobo.console.model.Group;

import javax.validation.constraints.NotNull;


@Getter
@Setter
public class  GroupVo {


    private Integer id;

    @NotBlank(message="任务组名称不能为空")
    private String name;

    private String comment;

    private Integer version;

    private java.util.Date insertDate;

    private java.util.Date udateDate;





}
