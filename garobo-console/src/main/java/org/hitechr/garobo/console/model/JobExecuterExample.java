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


public class JobExecuterExample extends BaseModel implements Serializable{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public JobExecuterExample() {
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

    protected abstract static class GeneratedCriteria {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andRealnameIsNull() {
            addCriterion("realname is null");
            return (Criteria) this;
        }

        public Criteria andRealnameIsNotNull() {
            addCriterion("realname is not null");
            return (Criteria) this;
        }

        public Criteria andRealnameEqualTo(String value) {
            addCriterion("realname =", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotEqualTo(String value) {
            addCriterion("realname <>", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameGreaterThan(String value) {
            addCriterion("realname >", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameGreaterThanOrEqualTo(String value) {
            addCriterion("realname >=", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameLessThan(String value) {
            addCriterion("realname <", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameLessThanOrEqualTo(String value) {
            addCriterion("realname <=", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameLike(String value) {
            addCriterion("realname like", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotLike(String value) {
            addCriterion("realname not like", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameIn(List<String> values) {
            addCriterion("realname in", values, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotIn(List<String> values) {
            addCriterion("realname not in", values, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameBetween(String value1, String value2) {
            addCriterion("realname between", value1, value2, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotBetween(String value1, String value2) {
            addCriterion("realname not between", value1, value2, "realname");
            return (Criteria) this;
        }

        public Criteria andMobileIsNull() {
            addCriterion("mobile is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("mobile is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("mobile =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("mobile <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("mobile >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("mobile >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("mobile <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("mobile <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLike(String value) {
            addCriterion("mobile like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("mobile not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<String> values) {
            addCriterion("mobile in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("mobile not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("mobile between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("mobile not between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andIdcardIsNull() {
            addCriterion("idcard is null");
            return (Criteria) this;
        }

        public Criteria andIdcardIsNotNull() {
            addCriterion("idcard is not null");
            return (Criteria) this;
        }

        public Criteria andIdcardEqualTo(String value) {
            addCriterion("idcard =", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotEqualTo(String value) {
            addCriterion("idcard <>", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardGreaterThan(String value) {
            addCriterion("idcard >", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardGreaterThanOrEqualTo(String value) {
            addCriterion("idcard >=", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardLessThan(String value) {
            addCriterion("idcard <", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardLessThanOrEqualTo(String value) {
            addCriterion("idcard <=", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardLike(String value) {
            addCriterion("idcard like", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotLike(String value) {
            addCriterion("idcard not like", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardIn(List<String> values) {
            addCriterion("idcard in", values, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotIn(List<String> values) {
            addCriterion("idcard not in", values, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardBetween(String value1, String value2) {
            addCriterion("idcard between", value1, value2, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotBetween(String value1, String value2) {
            addCriterion("idcard not between", value1, value2, "idcard");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andRoleIsNull() {
            addCriterion("role is null");
            return (Criteria) this;
        }

        public Criteria andRoleIsNotNull() {
            addCriterion("role is not null");
            return (Criteria) this;
        }

        public Criteria andRoleEqualTo(Integer value) {
            addCriterion("role =", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotEqualTo(Integer value) {
            addCriterion("role <>", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleGreaterThan(Integer value) {
            addCriterion("role >", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleGreaterThanOrEqualTo(Integer value) {
            addCriterion("role >=", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleLessThan(Integer value) {
            addCriterion("role <", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleLessThanOrEqualTo(Integer value) {
            addCriterion("role <=", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleIn(List<Integer> values) {
            addCriterion("role in", values, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotIn(List<Integer> values) {
            addCriterion("role not in", values, "role");
            return (Criteria) this;
        }

        public Criteria andRoleBetween(Integer value1, Integer value2) {
            addCriterion("role between", value1, value2, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotBetween(Integer value1, Integer value2) {
            addCriterion("role not between", value1, value2, "role");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Short value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Short value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Short value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Short value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Short value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Short> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Short> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Short value1, Short value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Short value1, Short value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andPaypasswordIsNull() {
            addCriterion("paypassword is null");
            return (Criteria) this;
        }

        public Criteria andPaypasswordIsNotNull() {
            addCriterion("paypassword is not null");
            return (Criteria) this;
        }

        public Criteria andPaypasswordEqualTo(String value) {
            addCriterion("paypassword =", value, "paypassword");
            return (Criteria) this;
        }

        public Criteria andPaypasswordNotEqualTo(String value) {
            addCriterion("paypassword <>", value, "paypassword");
            return (Criteria) this;
        }

        public Criteria andPaypasswordGreaterThan(String value) {
            addCriterion("paypassword >", value, "paypassword");
            return (Criteria) this;
        }

        public Criteria andPaypasswordGreaterThanOrEqualTo(String value) {
            addCriterion("paypassword >=", value, "paypassword");
            return (Criteria) this;
        }

        public Criteria andPaypasswordLessThan(String value) {
            addCriterion("paypassword <", value, "paypassword");
            return (Criteria) this;
        }

        public Criteria andPaypasswordLessThanOrEqualTo(String value) {
            addCriterion("paypassword <=", value, "paypassword");
            return (Criteria) this;
        }

        public Criteria andPaypasswordLike(String value) {
            addCriterion("paypassword like", value, "paypassword");
            return (Criteria) this;
        }

        public Criteria andPaypasswordNotLike(String value) {
            addCriterion("paypassword not like", value, "paypassword");
            return (Criteria) this;
        }

        public Criteria andPaypasswordIn(List<String> values) {
            addCriterion("paypassword in", values, "paypassword");
            return (Criteria) this;
        }

        public Criteria andPaypasswordNotIn(List<String> values) {
            addCriterion("paypassword not in", values, "paypassword");
            return (Criteria) this;
        }

        public Criteria andPaypasswordBetween(String value1, String value2) {
            addCriterion("paypassword between", value1, value2, "paypassword");
            return (Criteria) this;
        }

        public Criteria andPaypasswordNotBetween(String value1, String value2) {
            addCriterion("paypassword not between", value1, value2, "paypassword");
            return (Criteria) this;
        }

        public Criteria andCdateIsNull() {
            addCriterion("cdate is null");
            return (Criteria) this;
        }

        public Criteria andCdateIsNotNull() {
            addCriterion("cdate is not null");
            return (Criteria) this;
        }

        public Criteria andCdateEqualTo(Long value) {
            addCriterion("cdate =", value, "cdate");
            return (Criteria) this;
        }

        public Criteria andCdateNotEqualTo(Long value) {
            addCriterion("cdate <>", value, "cdate");
            return (Criteria) this;
        }

        public Criteria andCdateGreaterThan(Long value) {
            addCriterion("cdate >", value, "cdate");
            return (Criteria) this;
        }

        public Criteria andCdateGreaterThanOrEqualTo(Long value) {
            addCriterion("cdate >=", value, "cdate");
            return (Criteria) this;
        }

        public Criteria andCdateLessThan(Long value) {
            addCriterion("cdate <", value, "cdate");
            return (Criteria) this;
        }

        public Criteria andCdateLessThanOrEqualTo(Long value) {
            addCriterion("cdate <=", value, "cdate");
            return (Criteria) this;
        }

        public Criteria andCdateIn(List<Long> values) {
            addCriterion("cdate in", values, "cdate");
            return (Criteria) this;
        }

        public Criteria andCdateNotIn(List<Long> values) {
            addCriterion("cdate not in", values, "cdate");
            return (Criteria) this;
        }

        public Criteria andCdateBetween(Long value1, Long value2) {
            addCriterion("cdate between", value1, value2, "cdate");
            return (Criteria) this;
        }

        public Criteria andCdateNotBetween(Long value1, Long value2) {
            addCriterion("cdate not between", value1, value2, "cdate");
            return (Criteria) this;
        }

        public Criteria andPhotoIsNull() {
            addCriterion("photo is null");
            return (Criteria) this;
        }

        public Criteria andPhotoIsNotNull() {
            addCriterion("photo is not null");
            return (Criteria) this;
        }

        public Criteria andPhotoEqualTo(String value) {
            addCriterion("photo =", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoNotEqualTo(String value) {
            addCriterion("photo <>", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoGreaterThan(String value) {
            addCriterion("photo >", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoGreaterThanOrEqualTo(String value) {
            addCriterion("photo >=", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoLessThan(String value) {
            addCriterion("photo <", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoLessThanOrEqualTo(String value) {
            addCriterion("photo <=", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoLike(String value) {
            addCriterion("photo like", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoNotLike(String value) {
            addCriterion("photo not like", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoIn(List<String> values) {
            addCriterion("photo in", values, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoNotIn(List<String> values) {
            addCriterion("photo not in", values, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoBetween(String value1, String value2) {
            addCriterion("photo between", value1, value2, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoNotBetween(String value1, String value2) {
            addCriterion("photo not between", value1, value2, "photo");
            return (Criteria) this;
        }

        public Criteria andListphotoIsNull() {
            addCriterion("listphoto is null");
            return (Criteria) this;
        }

        public Criteria andListphotoIsNotNull() {
            addCriterion("listphoto is not null");
            return (Criteria) this;
        }

        public Criteria andListphotoEqualTo(String value) {
            addCriterion("listphoto =", value, "listphoto");
            return (Criteria) this;
        }

        public Criteria andListphotoNotEqualTo(String value) {
            addCriterion("listphoto <>", value, "listphoto");
            return (Criteria) this;
        }

        public Criteria andListphotoGreaterThan(String value) {
            addCriterion("listphoto >", value, "listphoto");
            return (Criteria) this;
        }

        public Criteria andListphotoGreaterThanOrEqualTo(String value) {
            addCriterion("listphoto >=", value, "listphoto");
            return (Criteria) this;
        }

        public Criteria andListphotoLessThan(String value) {
            addCriterion("listphoto <", value, "listphoto");
            return (Criteria) this;
        }

        public Criteria andListphotoLessThanOrEqualTo(String value) {
            addCriterion("listphoto <=", value, "listphoto");
            return (Criteria) this;
        }

        public Criteria andListphotoLike(String value) {
            addCriterion("listphoto like", value, "listphoto");
            return (Criteria) this;
        }

        public Criteria andListphotoNotLike(String value) {
            addCriterion("listphoto not like", value, "listphoto");
            return (Criteria) this;
        }

        public Criteria andListphotoIn(List<String> values) {
            addCriterion("listphoto in", values, "listphoto");
            return (Criteria) this;
        }

        public Criteria andListphotoNotIn(List<String> values) {
            addCriterion("listphoto not in", values, "listphoto");
            return (Criteria) this;
        }

        public Criteria andListphotoBetween(String value1, String value2) {
            addCriterion("listphoto between", value1, value2, "listphoto");
            return (Criteria) this;
        }

        public Criteria andListphotoNotBetween(String value1, String value2) {
            addCriterion("listphoto not between", value1, value2, "listphoto");
            return (Criteria) this;
        }

        public Criteria andSessionidIsNull() {
            addCriterion("sessionid is null");
            return (Criteria) this;
        }

        public Criteria andSessionidIsNotNull() {
            addCriterion("sessionid is not null");
            return (Criteria) this;
        }

        public Criteria andSessionidEqualTo(String value) {
            addCriterion("sessionid =", value, "sessionid");
            return (Criteria) this;
        }

        public Criteria andSessionidNotEqualTo(String value) {
            addCriterion("sessionid <>", value, "sessionid");
            return (Criteria) this;
        }

        public Criteria andSessionidGreaterThan(String value) {
            addCriterion("sessionid >", value, "sessionid");
            return (Criteria) this;
        }

        public Criteria andSessionidGreaterThanOrEqualTo(String value) {
            addCriterion("sessionid >=", value, "sessionid");
            return (Criteria) this;
        }

        public Criteria andSessionidLessThan(String value) {
            addCriterion("sessionid <", value, "sessionid");
            return (Criteria) this;
        }

        public Criteria andSessionidLessThanOrEqualTo(String value) {
            addCriterion("sessionid <=", value, "sessionid");
            return (Criteria) this;
        }

        public Criteria andSessionidLike(String value) {
            addCriterion("sessionid like", value, "sessionid");
            return (Criteria) this;
        }

        public Criteria andSessionidNotLike(String value) {
            addCriterion("sessionid not like", value, "sessionid");
            return (Criteria) this;
        }

        public Criteria andSessionidIn(List<String> values) {
            addCriterion("sessionid in", values, "sessionid");
            return (Criteria) this;
        }

        public Criteria andSessionidNotIn(List<String> values) {
            addCriterion("sessionid not in", values, "sessionid");
            return (Criteria) this;
        }

        public Criteria andSessionidBetween(String value1, String value2) {
            addCriterion("sessionid between", value1, value2, "sessionid");
            return (Criteria) this;
        }

        public Criteria andSessionidNotBetween(String value1, String value2) {
            addCriterion("sessionid not between", value1, value2, "sessionid");
            return (Criteria) this;
        }

        public Criteria andActivecodeIsNull() {
            addCriterion("activecode is null");
            return (Criteria) this;
        }

        public Criteria andActivecodeIsNotNull() {
            addCriterion("activecode is not null");
            return (Criteria) this;
        }

        public Criteria andActivecodeEqualTo(String value) {
            addCriterion("activecode =", value, "activecode");
            return (Criteria) this;
        }

        public Criteria andActivecodeNotEqualTo(String value) {
            addCriterion("activecode <>", value, "activecode");
            return (Criteria) this;
        }

        public Criteria andActivecodeGreaterThan(String value) {
            addCriterion("activecode >", value, "activecode");
            return (Criteria) this;
        }

        public Criteria andActivecodeGreaterThanOrEqualTo(String value) {
            addCriterion("activecode >=", value, "activecode");
            return (Criteria) this;
        }

        public Criteria andActivecodeLessThan(String value) {
            addCriterion("activecode <", value, "activecode");
            return (Criteria) this;
        }

        public Criteria andActivecodeLessThanOrEqualTo(String value) {
            addCriterion("activecode <=", value, "activecode");
            return (Criteria) this;
        }

        public Criteria andActivecodeLike(String value) {
            addCriterion("activecode like", value, "activecode");
            return (Criteria) this;
        }

        public Criteria andActivecodeNotLike(String value) {
            addCriterion("activecode not like", value, "activecode");
            return (Criteria) this;
        }

        public Criteria andActivecodeIn(List<String> values) {
            addCriterion("activecode in", values, "activecode");
            return (Criteria) this;
        }

        public Criteria andActivecodeNotIn(List<String> values) {
            addCriterion("activecode not in", values, "activecode");
            return (Criteria) this;
        }

        public Criteria andActivecodeBetween(String value1, String value2) {
            addCriterion("activecode between", value1, value2, "activecode");
            return (Criteria) this;
        }

        public Criteria andActivecodeNotBetween(String value1, String value2) {
            addCriterion("activecode not between", value1, value2, "activecode");
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

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andRegiesttypeIsNull() {
            addCriterion("regiestType is null");
            return (Criteria) this;
        }

        public Criteria andRegiesttypeIsNotNull() {
            addCriterion("regiestType is not null");
            return (Criteria) this;
        }

        public Criteria andRegiesttypeEqualTo(Integer value) {
            addCriterion("regiestType =", value, "regiesttype");
            return (Criteria) this;
        }

        public Criteria andRegiesttypeNotEqualTo(Integer value) {
            addCriterion("regiestType <>", value, "regiesttype");
            return (Criteria) this;
        }

        public Criteria andRegiesttypeGreaterThan(Integer value) {
            addCriterion("regiestType >", value, "regiesttype");
            return (Criteria) this;
        }

        public Criteria andRegiesttypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("regiestType >=", value, "regiesttype");
            return (Criteria) this;
        }

        public Criteria andRegiesttypeLessThan(Integer value) {
            addCriterion("regiestType <", value, "regiesttype");
            return (Criteria) this;
        }

        public Criteria andRegiesttypeLessThanOrEqualTo(Integer value) {
            addCriterion("regiestType <=", value, "regiesttype");
            return (Criteria) this;
        }

        public Criteria andRegiesttypeIn(List<Integer> values) {
            addCriterion("regiestType in", values, "regiesttype");
            return (Criteria) this;
        }

        public Criteria andRegiesttypeNotIn(List<Integer> values) {
            addCriterion("regiestType not in", values, "regiesttype");
            return (Criteria) this;
        }

        public Criteria andRegiesttypeBetween(Integer value1, Integer value2) {
            addCriterion("regiestType between", value1, value2, "regiesttype");
            return (Criteria) this;
        }

        public Criteria andRegiesttypeNotBetween(Integer value1, Integer value2) {
            addCriterion("regiestType not between", value1, value2, "regiesttype");
            return (Criteria) this;
        }

        public Criteria andEncodepasswortypeIsNull() {
            addCriterion("encodePassworType is null");
            return (Criteria) this;
        }

        public Criteria andEncodepasswortypeIsNotNull() {
            addCriterion("encodePassworType is not null");
            return (Criteria) this;
        }

        public Criteria andEncodepasswortypeEqualTo(Integer value) {
            addCriterion("encodePassworType =", value, "encodepasswortype");
            return (Criteria) this;
        }

        public Criteria andEncodepasswortypeNotEqualTo(Integer value) {
            addCriterion("encodePassworType <>", value, "encodepasswortype");
            return (Criteria) this;
        }

        public Criteria andEncodepasswortypeGreaterThan(Integer value) {
            addCriterion("encodePassworType >", value, "encodepasswortype");
            return (Criteria) this;
        }

        public Criteria andEncodepasswortypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("encodePassworType >=", value, "encodepasswortype");
            return (Criteria) this;
        }

        public Criteria andEncodepasswortypeLessThan(Integer value) {
            addCriterion("encodePassworType <", value, "encodepasswortype");
            return (Criteria) this;
        }

        public Criteria andEncodepasswortypeLessThanOrEqualTo(Integer value) {
            addCriterion("encodePassworType <=", value, "encodepasswortype");
            return (Criteria) this;
        }

        public Criteria andEncodepasswortypeIn(List<Integer> values) {
            addCriterion("encodePassworType in", values, "encodepasswortype");
            return (Criteria) this;
        }

        public Criteria andEncodepasswortypeNotIn(List<Integer> values) {
            addCriterion("encodePassworType not in", values, "encodepasswortype");
            return (Criteria) this;
        }

        public Criteria andEncodepasswortypeBetween(Integer value1, Integer value2) {
            addCriterion("encodePassworType between", value1, value2, "encodepasswortype");
            return (Criteria) this;
        }

        public Criteria andEncodepasswortypeNotBetween(Integer value1, Integer value2) {
            addCriterion("encodePassworType not between", value1, value2, "encodepasswortype");
            return (Criteria) this;
        }

        public Criteria andIsthreeleadIsNull() {
            addCriterion("isThreeLead is null");
            return (Criteria) this;
        }

        public Criteria andIsthreeleadIsNotNull() {
            addCriterion("isThreeLead is not null");
            return (Criteria) this;
        }

        public Criteria andIsthreeleadEqualTo(Integer value) {
            addCriterion("isThreeLead =", value, "isthreelead");
            return (Criteria) this;
        }

        public Criteria andIsthreeleadNotEqualTo(Integer value) {
            addCriterion("isThreeLead <>", value, "isthreelead");
            return (Criteria) this;
        }

        public Criteria andIsthreeleadGreaterThan(Integer value) {
            addCriterion("isThreeLead >", value, "isthreelead");
            return (Criteria) this;
        }

        public Criteria andIsthreeleadGreaterThanOrEqualTo(Integer value) {
            addCriterion("isThreeLead >=", value, "isthreelead");
            return (Criteria) this;
        }

        public Criteria andIsthreeleadLessThan(Integer value) {
            addCriterion("isThreeLead <", value, "isthreelead");
            return (Criteria) this;
        }

        public Criteria andIsthreeleadLessThanOrEqualTo(Integer value) {
            addCriterion("isThreeLead <=", value, "isthreelead");
            return (Criteria) this;
        }

        public Criteria andIsthreeleadIn(List<Integer> values) {
            addCriterion("isThreeLead in", values, "isthreelead");
            return (Criteria) this;
        }

        public Criteria andIsthreeleadNotIn(List<Integer> values) {
            addCriterion("isThreeLead not in", values, "isthreelead");
            return (Criteria) this;
        }

        public Criteria andIsthreeleadBetween(Integer value1, Integer value2) {
            addCriterion("isThreeLead between", value1, value2, "isthreelead");
            return (Criteria) this;
        }

        public Criteria andIsthreeleadNotBetween(Integer value1, Integer value2) {
            addCriterion("isThreeLead not between", value1, value2, "isthreelead");
            return (Criteria) this;
        }

        public Criteria andSinguserIsNull() {
            addCriterion("singUser is null");
            return (Criteria) this;
        }

        public Criteria andSinguserIsNotNull() {
            addCriterion("singUser is not null");
            return (Criteria) this;
        }

        public Criteria andSinguserEqualTo(String value) {
            addCriterion("singUser =", value, "singuser");
            return (Criteria) this;
        }

        public Criteria andSinguserNotEqualTo(String value) {
            addCriterion("singUser <>", value, "singuser");
            return (Criteria) this;
        }

        public Criteria andSinguserGreaterThan(String value) {
            addCriterion("singUser >", value, "singuser");
            return (Criteria) this;
        }

        public Criteria andSinguserGreaterThanOrEqualTo(String value) {
            addCriterion("singUser >=", value, "singuser");
            return (Criteria) this;
        }

        public Criteria andSinguserLessThan(String value) {
            addCriterion("singUser <", value, "singuser");
            return (Criteria) this;
        }

        public Criteria andSinguserLessThanOrEqualTo(String value) {
            addCriterion("singUser <=", value, "singuser");
            return (Criteria) this;
        }

        public Criteria andSinguserLike(String value) {
            addCriterion("singUser like", value, "singuser");
            return (Criteria) this;
        }

        public Criteria andSinguserNotLike(String value) {
            addCriterion("singUser not like", value, "singuser");
            return (Criteria) this;
        }

        public Criteria andSinguserIn(List<String> values) {
            addCriterion("singUser in", values, "singuser");
            return (Criteria) this;
        }

        public Criteria andSinguserNotIn(List<String> values) {
            addCriterion("singUser not in", values, "singuser");
            return (Criteria) this;
        }

        public Criteria andSinguserBetween(String value1, String value2) {
            addCriterion("singUser between", value1, value2, "singuser");
            return (Criteria) this;
        }

        public Criteria andSinguserNotBetween(String value1, String value2) {
            addCriterion("singUser not between", value1, value2, "singuser");
            return (Criteria) this;
        }

        public Criteria andEncodecharIsNull() {
            addCriterion("encodeChar is null");
            return (Criteria) this;
        }

        public Criteria andEncodecharIsNotNull() {
            addCriterion("encodeChar is not null");
            return (Criteria) this;
        }

        public Criteria andEncodecharEqualTo(String value) {
            addCriterion("encodeChar =", value, "encodechar");
            return (Criteria) this;
        }

        public Criteria andEncodecharNotEqualTo(String value) {
            addCriterion("encodeChar <>", value, "encodechar");
            return (Criteria) this;
        }

        public Criteria andEncodecharGreaterThan(String value) {
            addCriterion("encodeChar >", value, "encodechar");
            return (Criteria) this;
        }

        public Criteria andEncodecharGreaterThanOrEqualTo(String value) {
            addCriterion("encodeChar >=", value, "encodechar");
            return (Criteria) this;
        }

        public Criteria andEncodecharLessThan(String value) {
            addCriterion("encodeChar <", value, "encodechar");
            return (Criteria) this;
        }

        public Criteria andEncodecharLessThanOrEqualTo(String value) {
            addCriterion("encodeChar <=", value, "encodechar");
            return (Criteria) this;
        }

        public Criteria andEncodecharLike(String value) {
            addCriterion("encodeChar like", value, "encodechar");
            return (Criteria) this;
        }

        public Criteria andEncodecharNotLike(String value) {
            addCriterion("encodeChar not like", value, "encodechar");
            return (Criteria) this;
        }

        public Criteria andEncodecharIn(List<String> values) {
            addCriterion("encodeChar in", values, "encodechar");
            return (Criteria) this;
        }

        public Criteria andEncodecharNotIn(List<String> values) {
            addCriterion("encodeChar not in", values, "encodechar");
            return (Criteria) this;
        }

        public Criteria andEncodecharBetween(String value1, String value2) {
            addCriterion("encodeChar between", value1, value2, "encodechar");
            return (Criteria) this;
        }

        public Criteria andEncodecharNotBetween(String value1, String value2) {
            addCriterion("encodeChar not between", value1, value2, "encodechar");
            return (Criteria) this;
        }

        public Criteria andEncodepaycharIsNull() {
            addCriterion("encodePayChar is null");
            return (Criteria) this;
        }

        public Criteria andEncodepaycharIsNotNull() {
            addCriterion("encodePayChar is not null");
            return (Criteria) this;
        }

        public Criteria andEncodepaycharEqualTo(String value) {
            addCriterion("encodePayChar =", value, "encodepaychar");
            return (Criteria) this;
        }

        public Criteria andEncodepaycharNotEqualTo(String value) {
            addCriterion("encodePayChar <>", value, "encodepaychar");
            return (Criteria) this;
        }

        public Criteria andEncodepaycharGreaterThan(String value) {
            addCriterion("encodePayChar >", value, "encodepaychar");
            return (Criteria) this;
        }

        public Criteria andEncodepaycharGreaterThanOrEqualTo(String value) {
            addCriterion("encodePayChar >=", value, "encodepaychar");
            return (Criteria) this;
        }

        public Criteria andEncodepaycharLessThan(String value) {
            addCriterion("encodePayChar <", value, "encodepaychar");
            return (Criteria) this;
        }

        public Criteria andEncodepaycharLessThanOrEqualTo(String value) {
            addCriterion("encodePayChar <=", value, "encodepaychar");
            return (Criteria) this;
        }

        public Criteria andEncodepaycharLike(String value) {
            addCriterion("encodePayChar like", value, "encodepaychar");
            return (Criteria) this;
        }

        public Criteria andEncodepaycharNotLike(String value) {
            addCriterion("encodePayChar not like", value, "encodepaychar");
            return (Criteria) this;
        }

        public Criteria andEncodepaycharIn(List<String> values) {
            addCriterion("encodePayChar in", values, "encodepaychar");
            return (Criteria) this;
        }

        public Criteria andEncodepaycharNotIn(List<String> values) {
            addCriterion("encodePayChar not in", values, "encodepaychar");
            return (Criteria) this;
        }

        public Criteria andEncodepaycharBetween(String value1, String value2) {
            addCriterion("encodePayChar between", value1, value2, "encodepaychar");
            return (Criteria) this;
        }

        public Criteria andEncodepaycharNotBetween(String value1, String value2) {
            addCriterion("encodePayChar not between", value1, value2, "encodepaychar");
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
