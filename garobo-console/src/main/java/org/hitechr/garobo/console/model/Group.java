/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package org.hitechr.garobo.console.model;

import java.io.Serializable;



public class Group implements Serializable {


	//alias
    
		private Integer id;  
    
		private String name;  
    
		private String desc;  
    
		private Integer runId;  
    
		private Integer version;  
    
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
    
    public void setDesc(String desc) {  
        this.desc = desc;  
    }  
      
    public String getDesc() {  
        return this.desc;  
    }  
    
    public void setRunId(Integer runId) {  
        this.runId = runId;  
    }  
      
    public Integer getRunId() {  
        return this.runId;  
    }  
    
    public void setVersion(Integer version) {  
        this.version = version;  
    }  
      
    public Integer getVersion() {  
        return this.version;  
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

