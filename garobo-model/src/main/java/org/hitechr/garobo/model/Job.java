/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package org.hitechr.garobo.model;

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
    
		private Integer flowNum;  
    
		private Integer groupId;  
    
		private Integer successCode;  
    
		private Integer weight;  
    
		private Integer redo;  
    
		private Integer redoGap;  
    
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
    
    public void setFlowNum(Integer flowNum) {  
        this.flowNum = flowNum;  
    }  
      
    public Integer getFlowNum() {  
        return this.flowNum;  
    }  
    
    public void setGroupId(Integer groupId) {  
        this.groupId = groupId;  
    }  
      
    public Integer getGroupId() {  
        return this.groupId;  
    }  
    
    public void setSuccessCode(Integer successCode) {  
        this.successCode = successCode;  
    }  
      
    public Integer getSuccessCode() {  
        return this.successCode;  
    }  
    
    public void setWeight(Integer weight) {  
        this.weight = weight;  
    }  
      
    public Integer getWeight() {  
        return this.weight;  
    }  
    
    public void setRedo(Integer redo) {  
        this.redo = redo;  
    }  
      
    public Integer getRedo() {  
        return this.redo;  
    }  
    
    public void setRedoGap(Integer redoGap) {  
        this.redoGap = redoGap;  
    }  
      
    public Integer getRedoGap() {  
        return this.redoGap;  
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

