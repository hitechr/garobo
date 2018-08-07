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


public class GroupExample extends BaseModel implements Serializable{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GroupExample() {
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

	 public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "Name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "Name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "Name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "Name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "Name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "Name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "Name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "Name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "Name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "Name");
            return (Criteria) this;
        } 

	 public Criteria andCommentIsNull() {
            addCriterion("comment is null");
            return (Criteria) this;
        }

        public Criteria andCommentIsNotNull() {
            addCriterion("comment is not null");
            return (Criteria) this;
        }

        public Criteria andCommentEqualTo(String value) {
            addCriterion("comment =", value, "Comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotEqualTo(String value) {
            addCriterion("comment <>", value, "Comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThan(String value) {
            addCriterion("comment >", value, "Comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThanOrEqualTo(String value) {
            addCriterion("comment >=", value, "Comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThan(String value) {
            addCriterion("comment <", value, "Comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThanOrEqualTo(String value) {
            addCriterion("comment <=", value, "Comment");
            return (Criteria) this;
        }

        public Criteria andCommentIn(List<String> values) {
            addCriterion("comment in", values, "Comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotIn(List<String> values) {
            addCriterion("comment not in", values, "Comment");
            return (Criteria) this;
        }

        public Criteria andCommentBetween(String value1, String value2) {
            addCriterion("comment between", value1, value2, "Comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotBetween(String value1, String value2) {
            addCriterion("comment not between", value1, value2, "Comment");
            return (Criteria) this;
        } 

	 public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Integer value) {
            addCriterion("version =", value, "Version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Integer value) {
            addCriterion("version <>", value, "Version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Integer value) {
            addCriterion("version >", value, "Version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("version >=", value, "Version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Integer value) {
            addCriterion("version <", value, "Version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Integer value) {
            addCriterion("version <=", value, "Version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Integer> values) {
            addCriterion("version in", values, "Version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Integer> values) {
            addCriterion("version not in", values, "Version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Integer value1, Integer value2) {
            addCriterion("version between", value1, value2, "Version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("version not between", value1, value2, "Version");
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
