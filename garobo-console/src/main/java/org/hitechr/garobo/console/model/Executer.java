/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package org.hitechr.garobo.console.model;

import java.io.Serializable;



public class Executer implements Serializable {


	//alias
    
		private Integer id;  
    
		private String ip;  
    
		private Integer status;  
    
		private String rid;  
    
		private java.util.Date insertDate;  
    
		private java.util.Date udateDate;  
	

    
    public void setId(Integer id) {  
        this.id = id;  
    }  
      
    public Integer getId() {  
        return this.id;  
    }  
    
    public void setIp(String ip) {  
        this.ip = ip;  
    }  
      
    public String getIp() {  
        return this.ip;  
    }  
    
    public void setStatus(Integer status) {  
        this.status = status;  
    }  
      
    public Integer getStatus() {  
        return this.status;  
    }  
    
    public void setRid(String rid) {  
        this.rid = rid;  
    }  
      
    public String getRid() {  
        return this.rid;  
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

