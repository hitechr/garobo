/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package org.hitechr.garobo.console.model;
import org.hitechr.garobo.console.common.web.model.BaseModel;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;


public class ExecuterExample extends BaseModel implements Serializable{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ExecuterExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria implements Serializable {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

       
		
		
			//alias

	 public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "Id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "Id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "Id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "Id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "Id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "Id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "Id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "Id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "Id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "Id");
            return (Criteria) this;
        } 

	 public Criteria andIpIsNull() {
            addCriterion("ip is null");
            return (Criteria) this;
        }

        public Criteria andIpIsNotNull() {
            addCriterion("ip is not null");
            return (Criteria) this;
        }

        public Criteria andIpEqualTo(String value) {
            addCriterion("ip =", value, "Ip");
            return (Criteria) this;
        }

        public Criteria andIpNotEqualTo(String value) {
            addCriterion("ip <>", value, "Ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThan(String value) {
            addCriterion("ip >", value, "Ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThanOrEqualTo(String value) {
            addCriterion("ip >=", value, "Ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThan(String value) {
            addCriterion("ip <", value, "Ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThanOrEqualTo(String value) {
            addCriterion("ip <=", value, "Ip");
            return (Criteria) this;
        }

        public Criteria andIpIn(List<String> values) {
            addCriterion("ip in", values, "Ip");
            return (Criteria) this;
        }

        public Criteria andIpNotIn(List<String> values) {
            addCriterion("ip not in", values, "Ip");
            return (Criteria) this;
        }

        public Criteria andIpBetween(String value1, String value2) {
            addCriterion("ip between", value1, value2, "Ip");
            return (Criteria) this;
        }

        public Criteria andIpNotBetween(String value1, String value2) {
            addCriterion("ip not between", value1, value2, "Ip");
            return (Criteria) this;
        } 

	 public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "Status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "Status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "Status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "Status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "Status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "Status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "Status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "Status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "Status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "Status");
            return (Criteria) this;
        } 

	 public Criteria andPortIsNull() {
            addCriterion("port is null");
            return (Criteria) this;
        }

        public Criteria andPortIsNotNull() {
            addCriterion("port is not null");
            return (Criteria) this;
        }

        public Criteria andPortEqualTo(Integer value) {
            addCriterion("port =", value, "Port");
            return (Criteria) this;
        }

        public Criteria andPortNotEqualTo(Integer value) {
            addCriterion("port <>", value, "Port");
            return (Criteria) this;
        }

        public Criteria andPortGreaterThan(Integer value) {
            addCriterion("port >", value, "Port");
            return (Criteria) this;
        }

        public Criteria andPortGreaterThanOrEqualTo(Integer value) {
            addCriterion("port >=", value, "Port");
            return (Criteria) this;
        }

        public Criteria andPortLessThan(Integer value) {
            addCriterion("port <", value, "Port");
            return (Criteria) this;
        }

        public Criteria andPortLessThanOrEqualTo(Integer value) {
            addCriterion("port <=", value, "Port");
            return (Criteria) this;
        }

        public Criteria andPortIn(List<Integer> values) {
            addCriterion("port in", values, "Port");
            return (Criteria) this;
        }

        public Criteria andPortNotIn(List<Integer> values) {
            addCriterion("port not in", values, "Port");
            return (Criteria) this;
        }

        public Criteria andPortBetween(Integer value1, Integer value2) {
            addCriterion("port between", value1, value2, "Port");
            return (Criteria) this;
        }

        public Criteria andPortNotBetween(Integer value1, Integer value2) {
            addCriterion("port not between", value1, value2, "Port");
            return (Criteria) this;
        } 

	 public Criteria andRidIsNull() {
            addCriterion("rid is null");
            return (Criteria) this;
        }

        public Criteria andRidIsNotNull() {
            addCriterion("rid is not null");
            return (Criteria) this;
        }

        public Criteria andRidEqualTo(String value) {
            addCriterion("rid =", value, "Rid");
            return (Criteria) this;
        }

        public Criteria andRidNotEqualTo(String value) {
            addCriterion("rid <>", value, "Rid");
            return (Criteria) this;
        }

        public Criteria andRidGreaterThan(String value) {
            addCriterion("rid >", value, "Rid");
            return (Criteria) this;
        }

        public Criteria andRidGreaterThanOrEqualTo(String value) {
            addCriterion("rid >=", value, "Rid");
            return (Criteria) this;
        }

        public Criteria andRidLessThan(String value) {
            addCriterion("rid <", value, "Rid");
            return (Criteria) this;
        }

        public Criteria andRidLessThanOrEqualTo(String value) {
            addCriterion("rid <=", value, "Rid");
            return (Criteria) this;
        }

        public Criteria andRidIn(List<String> values) {
            addCriterion("rid in", values, "Rid");
            return (Criteria) this;
        }

        public Criteria andRidNotIn(List<String> values) {
            addCriterion("rid not in", values, "Rid");
            return (Criteria) this;
        }

        public Criteria andRidBetween(String value1, String value2) {
            addCriterion("rid between", value1, value2, "Rid");
            return (Criteria) this;
        }

        public Criteria andRidNotBetween(String value1, String value2) {
            addCriterion("rid not between", value1, value2, "Rid");
            return (Criteria) this;
        } 

	 public Criteria andPidIsNull() {
            addCriterion("pid is null");
            return (Criteria) this;
        }

        public Criteria andPidIsNotNull() {
            addCriterion("pid is not null");
            return (Criteria) this;
        }

        public Criteria andPidEqualTo(Integer value) {
            addCriterion("pid =", value, "Pid");
            return (Criteria) this;
        }

        public Criteria andPidNotEqualTo(Integer value) {
            addCriterion("pid <>", value, "Pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThan(Integer value) {
            addCriterion("pid >", value, "Pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThanOrEqualTo(Integer value) {
            addCriterion("pid >=", value, "Pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThan(Integer value) {
            addCriterion("pid <", value, "Pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThanOrEqualTo(Integer value) {
            addCriterion("pid <=", value, "Pid");
            return (Criteria) this;
        }

        public Criteria andPidIn(List<Integer> values) {
            addCriterion("pid in", values, "Pid");
            return (Criteria) this;
        }

        public Criteria andPidNotIn(List<Integer> values) {
            addCriterion("pid not in", values, "Pid");
            return (Criteria) this;
        }

        public Criteria andPidBetween(Integer value1, Integer value2) {
            addCriterion("pid between", value1, value2, "Pid");
            return (Criteria) this;
        }

        public Criteria andPidNotBetween(Integer value1, Integer value2) {
            addCriterion("pid not between", value1, value2, "Pid");
            return (Criteria) this;
        } 

	 public Criteria andUpDateIsNull() {
            addCriterion("up_date is null");
            return (Criteria) this;
        }

        public Criteria andUpDateIsNotNull() {
            addCriterion("up_date is not null");
            return (Criteria) this;
        }

        public Criteria andUpDateEqualTo(java.util.Date value) {
            addCriterion("up_date =", value, "UpDate");
            return (Criteria) this;
        }

        public Criteria andUpDateNotEqualTo(java.util.Date value) {
            addCriterion("up_date <>", value, "UpDate");
            return (Criteria) this;
        }

        public Criteria andUpDateGreaterThan(java.util.Date value) {
            addCriterion("up_date >", value, "UpDate");
            return (Criteria) this;
        }

        public Criteria andUpDateGreaterThanOrEqualTo(java.util.Date value) {
            addCriterion("up_date >=", value, "UpDate");
            return (Criteria) this;
        }

        public Criteria andUpDateLessThan(java.util.Date value) {
            addCriterion("up_date <", value, "UpDate");
            return (Criteria) this;
        }

        public Criteria andUpDateLessThanOrEqualTo(java.util.Date value) {
            addCriterion("up_date <=", value, "UpDate");
            return (Criteria) this;
        }

        public Criteria andUpDateIn(List<java.util.Date> values) {
            addCriterion("up_date in", values, "UpDate");
            return (Criteria) this;
        }

        public Criteria andUpDateNotIn(List<java.util.Date> values) {
            addCriterion("up_date not in", values, "UpDate");
            return (Criteria) this;
        }

        public Criteria andUpDateBetween(java.util.Date value1, java.util.Date value2) {
            addCriterion("up_date between", value1, value2, "UpDate");
            return (Criteria) this;
        }

        public Criteria andUpDateNotBetween(java.util.Date value1, java.util.Date value2) {
            addCriterion("up_date not between", value1, value2, "UpDate");
            return (Criteria) this;
        } 

	 public Criteria andInsertDateIsNull() {
            addCriterion("insert_date is null");
            return (Criteria) this;
        }

        public Criteria andInsertDateIsNotNull() {
            addCriterion("insert_date is not null");
            return (Criteria) this;
        }

        public Criteria andInsertDateEqualTo(java.util.Date value) {
            addCriterion("insert_date =", value, "InsertDate");
            return (Criteria) this;
        }

        public Criteria andInsertDateNotEqualTo(java.util.Date value) {
            addCriterion("insert_date <>", value, "InsertDate");
            return (Criteria) this;
        }

        public Criteria andInsertDateGreaterThan(java.util.Date value) {
            addCriterion("insert_date >", value, "InsertDate");
            return (Criteria) this;
        }

        public Criteria andInsertDateGreaterThanOrEqualTo(java.util.Date value) {
            addCriterion("insert_date >=", value, "InsertDate");
            return (Criteria) this;
        }

        public Criteria andInsertDateLessThan(java.util.Date value) {
            addCriterion("insert_date <", value, "InsertDate");
            return (Criteria) this;
        }

        public Criteria andInsertDateLessThanOrEqualTo(java.util.Date value) {
            addCriterion("insert_date <=", value, "InsertDate");
            return (Criteria) this;
        }

        public Criteria andInsertDateIn(List<java.util.Date> values) {
            addCriterion("insert_date in", values, "InsertDate");
            return (Criteria) this;
        }

        public Criteria andInsertDateNotIn(List<java.util.Date> values) {
            addCriterion("insert_date not in", values, "InsertDate");
            return (Criteria) this;
        }

        public Criteria andInsertDateBetween(java.util.Date value1, java.util.Date value2) {
            addCriterion("insert_date between", value1, value2, "InsertDate");
            return (Criteria) this;
        }

        public Criteria andInsertDateNotBetween(java.util.Date value1, java.util.Date value2) {
            addCriterion("insert_date not between", value1, value2, "InsertDate");
            return (Criteria) this;
        } 

	 public Criteria andUdateDateIsNull() {
            addCriterion("udate_date is null");
            return (Criteria) this;
        }

        public Criteria andUdateDateIsNotNull() {
            addCriterion("udate_date is not null");
            return (Criteria) this;
        }

        public Criteria andUdateDateEqualTo(java.util.Date value) {
            addCriterion("udate_date =", value, "UdateDate");
            return (Criteria) this;
        }

        public Criteria andUdateDateNotEqualTo(java.util.Date value) {
            addCriterion("udate_date <>", value, "UdateDate");
            return (Criteria) this;
        }

        public Criteria andUdateDateGreaterThan(java.util.Date value) {
            addCriterion("udate_date >", value, "UdateDate");
            return (Criteria) this;
        }

        public Criteria andUdateDateGreaterThanOrEqualTo(java.util.Date value) {
            addCriterion("udate_date >=", value, "UdateDate");
            return (Criteria) this;
        }

        public Criteria andUdateDateLessThan(java.util.Date value) {
            addCriterion("udate_date <", value, "UdateDate");
            return (Criteria) this;
        }

        public Criteria andUdateDateLessThanOrEqualTo(java.util.Date value) {
            addCriterion("udate_date <=", value, "UdateDate");
            return (Criteria) this;
        }

        public Criteria andUdateDateIn(List<java.util.Date> values) {
            addCriterion("udate_date in", values, "UdateDate");
            return (Criteria) this;
        }

        public Criteria andUdateDateNotIn(List<java.util.Date> values) {
            addCriterion("udate_date not in", values, "UdateDate");
            return (Criteria) this;
        }

        public Criteria andUdateDateBetween(java.util.Date value1, java.util.Date value2) {
            addCriterion("udate_date between", value1, value2, "UdateDate");
            return (Criteria) this;
        }

        public Criteria andUdateDateNotBetween(java.util.Date value1, java.util.Date value2) {
            addCriterion("udate_date not between", value1, value2, "UdateDate");
            return (Criteria) this;
        } 
		
       
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
