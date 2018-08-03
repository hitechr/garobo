/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package org.hitechr.garobo.console.model;

import java.io.Serializable;



public class JobExecuter implements Serializable {


	//alias
    
		private Integer id;  
    
		private Integer execId;  
    
		private Integer jobId;  
    
		private Integer groupId;  
    
		private Integer status;  
    
		private java.util.Date insertDate;  
    
		private java.util.Date udateDate;  
	

    
    public void setId(Integer id) {  
        this.id = id;  
    }  
      
    public Integer getId() {  
        return this.id;  
    }  
    
    public void setExecId(Integer execId) {  
        this.execId = execId;  
    }  
      
    public Integer getExecId() {  
        return this.execId;  
    }  
    
    public void setJobId(Integer jobId) {  
        this.jobId = jobId;  
    }  
      
    public Integer getJobId() {  
        return this.jobId;  
    }  
    
    public void setGroupId(Integer groupId) {  
        this.groupId = groupId;  
    }  
      
    public Integer getGroupId() {  
        return this.groupId;  
    }  
    
    public void setStatus(Integer status) {  
        this.status = status;  
    }  
      
    public Integer getStatus() {  
        return this.status;  
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

