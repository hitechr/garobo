/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package org.hitechr.garobo.console.model;

import java.io.Serializable;



public class Job implements Serializable {


	//alias
    
		private Integer id;  
    
		private String name;  
    
		private Integer type;  
    
		private Boolean last;  
    
		private Integer status;  
    
		private String jobCron;  
    
		private String command;  
    
		private String jobDesc;  
    
		private Integer orderNum;  
    
		private Integer groupId;  
    
		private java.util.Date insertDate;  
    
		private java.util.Date udateDate;  
	

    
    public void setId(Integer id) {  
        this.id = id;  
    }  
      
    public Integer getId() {  
        return this.id;  
    }  
    
    public void setName(String name) {  
        this.name = name;  
    }  
      
    public String getName() {  
        return this.name;  
    }  
    
    public void setType(Integer type) {  
        this.type = type;  
    }  
      
    public Integer getType() {  
        return this.type;  
    }  
    
    public void setLast(Boolean last) {  
        this.last = last;  
    }  
      
    public Boolean getLast() {  
        return this.last;  
    }  
    
    public void setStatus(Integer status) {  
        this.status = status;  
    }  
      
    public Integer getStatus() {  
        return this.status;  
    }  
    
    public void setJobCron(String jobCron) {  
        this.jobCron = jobCron;  
    }  
      
    public String getJobCron() {  
        return this.jobCron;  
    }  
    
    public void setCommand(String command) {  
        this.command = command;  
    }  
      
    public String getCommand() {  
        return this.command;  
    }  
    
    public void setJobDesc(String jobDesc) {  
        this.jobDesc = jobDesc;  
    }  
      
    public String getJobDesc() {  
        return this.jobDesc;  
    }  
    
    public void setOrderNum(Integer orderNum) {  
        this.orderNum = orderNum;  
    }  
      
    public Integer getOrderNum() {  
        return this.orderNum;  
    }  
    
    public void setGroupId(Integer groupId) {  
        this.groupId = groupId;  
    }  
      
    public Integer getGroupId() {  
        return this.groupId;  
    }  
    
    public void setInsertDate(java.util.Date insertDate) {  
        this.insertDate = insertDate;  
    }  
      
    public java.util.Date getInsertDate() {  
        return this.insertDate;  
    }  
    
    public void setUdateDate(java.util.Date udateDate) {  
        this.udateDate = udateDate;  
    }  
      
    public java.util.Date getUdateDate() {  
        return this.udateDate;  
    }  
	
	

}

