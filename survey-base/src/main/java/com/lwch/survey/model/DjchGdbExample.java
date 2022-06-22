package com.lwch.survey.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DjchGdbExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DjchGdbExample() {
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

        public Criteria andApplyIdIsNull() {
            addCriterion("apply_id is null");
            return (Criteria) this;
        }

        public Criteria andApplyIdIsNotNull() {
            addCriterion("apply_id is not null");
            return (Criteria) this;
        }

        public Criteria andApplyIdEqualTo(String value) {
            addCriterion("apply_id =", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdNotEqualTo(String value) {
            addCriterion("apply_id <>", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdGreaterThan(String value) {
            addCriterion("apply_id >", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdGreaterThanOrEqualTo(String value) {
            addCriterion("apply_id >=", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdLessThan(String value) {
            addCriterion("apply_id <", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdLessThanOrEqualTo(String value) {
            addCriterion("apply_id <=", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdLike(String value) {
            addCriterion("apply_id like", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdNotLike(String value) {
            addCriterion("apply_id not like", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdIn(List<String> values) {
            addCriterion("apply_id in", values, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdNotIn(List<String> values) {
            addCriterion("apply_id not in", values, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdBetween(String value1, String value2) {
            addCriterion("apply_id between", value1, value2, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdNotBetween(String value1, String value2) {
            addCriterion("apply_id not between", value1, value2, "applyId");
            return (Criteria) this;
        }

        public Criteria andProNameIsNull() {
            addCriterion("pro_name is null");
            return (Criteria) this;
        }

        public Criteria andProNameIsNotNull() {
            addCriterion("pro_name is not null");
            return (Criteria) this;
        }

        public Criteria andProNameEqualTo(String value) {
            addCriterion("pro_name =", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameNotEqualTo(String value) {
            addCriterion("pro_name <>", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameGreaterThan(String value) {
            addCriterion("pro_name >", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameGreaterThanOrEqualTo(String value) {
            addCriterion("pro_name >=", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameLessThan(String value) {
            addCriterion("pro_name <", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameLessThanOrEqualTo(String value) {
            addCriterion("pro_name <=", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameLike(String value) {
            addCriterion("pro_name like", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameNotLike(String value) {
            addCriterion("pro_name not like", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameIn(List<String> values) {
            addCriterion("pro_name in", values, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameNotIn(List<String> values) {
            addCriterion("pro_name not in", values, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameBetween(String value1, String value2) {
            addCriterion("pro_name between", value1, value2, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameNotBetween(String value1, String value2) {
            addCriterion("pro_name not between", value1, value2, "proName");
            return (Criteria) this;
        }

        public Criteria andProXmlzIsNull() {
            addCriterion("pro_xmlz is null");
            return (Criteria) this;
        }

        public Criteria andProXmlzIsNotNull() {
            addCriterion("pro_xmlz is not null");
            return (Criteria) this;
        }

        public Criteria andProXmlzEqualTo(String value) {
            addCriterion("pro_xmlz =", value, "proXmlz");
            return (Criteria) this;
        }

        public Criteria andProXmlzNotEqualTo(String value) {
            addCriterion("pro_xmlz <>", value, "proXmlz");
            return (Criteria) this;
        }

        public Criteria andProXmlzGreaterThan(String value) {
            addCriterion("pro_xmlz >", value, "proXmlz");
            return (Criteria) this;
        }

        public Criteria andProXmlzGreaterThanOrEqualTo(String value) {
            addCriterion("pro_xmlz >=", value, "proXmlz");
            return (Criteria) this;
        }

        public Criteria andProXmlzLessThan(String value) {
            addCriterion("pro_xmlz <", value, "proXmlz");
            return (Criteria) this;
        }

        public Criteria andProXmlzLessThanOrEqualTo(String value) {
            addCriterion("pro_xmlz <=", value, "proXmlz");
            return (Criteria) this;
        }

        public Criteria andProXmlzLike(String value) {
            addCriterion("pro_xmlz like", value, "proXmlz");
            return (Criteria) this;
        }

        public Criteria andProXmlzNotLike(String value) {
            addCriterion("pro_xmlz not like", value, "proXmlz");
            return (Criteria) this;
        }

        public Criteria andProXmlzIn(List<String> values) {
            addCriterion("pro_xmlz in", values, "proXmlz");
            return (Criteria) this;
        }

        public Criteria andProXmlzNotIn(List<String> values) {
            addCriterion("pro_xmlz not in", values, "proXmlz");
            return (Criteria) this;
        }

        public Criteria andProXmlzBetween(String value1, String value2) {
            addCriterion("pro_xmlz between", value1, value2, "proXmlz");
            return (Criteria) this;
        }

        public Criteria andProXmlzNotBetween(String value1, String value2) {
            addCriterion("pro_xmlz not between", value1, value2, "proXmlz");
            return (Criteria) this;
        }

        public Criteria andJsdwIsNull() {
            addCriterion("jsdw is null");
            return (Criteria) this;
        }

        public Criteria andJsdwIsNotNull() {
            addCriterion("jsdw is not null");
            return (Criteria) this;
        }

        public Criteria andJsdwEqualTo(String value) {
            addCriterion("jsdw =", value, "jsdw");
            return (Criteria) this;
        }

        public Criteria andJsdwNotEqualTo(String value) {
            addCriterion("jsdw <>", value, "jsdw");
            return (Criteria) this;
        }

        public Criteria andJsdwGreaterThan(String value) {
            addCriterion("jsdw >", value, "jsdw");
            return (Criteria) this;
        }

        public Criteria andJsdwGreaterThanOrEqualTo(String value) {
            addCriterion("jsdw >=", value, "jsdw");
            return (Criteria) this;
        }

        public Criteria andJsdwLessThan(String value) {
            addCriterion("jsdw <", value, "jsdw");
            return (Criteria) this;
        }

        public Criteria andJsdwLessThanOrEqualTo(String value) {
            addCriterion("jsdw <=", value, "jsdw");
            return (Criteria) this;
        }

        public Criteria andJsdwLike(String value) {
            addCriterion("jsdw like", value, "jsdw");
            return (Criteria) this;
        }

        public Criteria andJsdwNotLike(String value) {
            addCriterion("jsdw not like", value, "jsdw");
            return (Criteria) this;
        }

        public Criteria andJsdwIn(List<String> values) {
            addCriterion("jsdw in", values, "jsdw");
            return (Criteria) this;
        }

        public Criteria andJsdwNotIn(List<String> values) {
            addCriterion("jsdw not in", values, "jsdw");
            return (Criteria) this;
        }

        public Criteria andJsdwBetween(String value1, String value2) {
            addCriterion("jsdw between", value1, value2, "jsdw");
            return (Criteria) this;
        }

        public Criteria andJsdwNotBetween(String value1, String value2) {
            addCriterion("jsdw not between", value1, value2, "jsdw");
            return (Criteria) this;
        }

        public Criteria andApplyFieldIsNull() {
            addCriterion("apply_field is null");
            return (Criteria) this;
        }

        public Criteria andApplyFieldIsNotNull() {
            addCriterion("apply_field is not null");
            return (Criteria) this;
        }

        public Criteria andApplyFieldEqualTo(String value) {
            addCriterion("apply_field =", value, "applyField");
            return (Criteria) this;
        }

        public Criteria andApplyFieldNotEqualTo(String value) {
            addCriterion("apply_field <>", value, "applyField");
            return (Criteria) this;
        }

        public Criteria andApplyFieldGreaterThan(String value) {
            addCriterion("apply_field >", value, "applyField");
            return (Criteria) this;
        }

        public Criteria andApplyFieldGreaterThanOrEqualTo(String value) {
            addCriterion("apply_field >=", value, "applyField");
            return (Criteria) this;
        }

        public Criteria andApplyFieldLessThan(String value) {
            addCriterion("apply_field <", value, "applyField");
            return (Criteria) this;
        }

        public Criteria andApplyFieldLessThanOrEqualTo(String value) {
            addCriterion("apply_field <=", value, "applyField");
            return (Criteria) this;
        }

        public Criteria andApplyFieldLike(String value) {
            addCriterion("apply_field like", value, "applyField");
            return (Criteria) this;
        }

        public Criteria andApplyFieldNotLike(String value) {
            addCriterion("apply_field not like", value, "applyField");
            return (Criteria) this;
        }

        public Criteria andApplyFieldIn(List<String> values) {
            addCriterion("apply_field in", values, "applyField");
            return (Criteria) this;
        }

        public Criteria andApplyFieldNotIn(List<String> values) {
            addCriterion("apply_field not in", values, "applyField");
            return (Criteria) this;
        }

        public Criteria andApplyFieldBetween(String value1, String value2) {
            addCriterion("apply_field between", value1, value2, "applyField");
            return (Criteria) this;
        }

        public Criteria andApplyFieldNotBetween(String value1, String value2) {
            addCriterion("apply_field not between", value1, value2, "applyField");
            return (Criteria) this;
        }

        public Criteria andGdnoIsNull() {
            addCriterion("gdno is null");
            return (Criteria) this;
        }

        public Criteria andGdnoIsNotNull() {
            addCriterion("gdno is not null");
            return (Criteria) this;
        }

        public Criteria andGdnoEqualTo(String value) {
            addCriterion("gdno =", value, "gdno");
            return (Criteria) this;
        }

        public Criteria andGdnoNotEqualTo(String value) {
            addCriterion("gdno <>", value, "gdno");
            return (Criteria) this;
        }

        public Criteria andGdnoGreaterThan(String value) {
            addCriterion("gdno >", value, "gdno");
            return (Criteria) this;
        }

        public Criteria andGdnoGreaterThanOrEqualTo(String value) {
            addCriterion("gdno >=", value, "gdno");
            return (Criteria) this;
        }

        public Criteria andGdnoLessThan(String value) {
            addCriterion("gdno <", value, "gdno");
            return (Criteria) this;
        }

        public Criteria andGdnoLessThanOrEqualTo(String value) {
            addCriterion("gdno <=", value, "gdno");
            return (Criteria) this;
        }

        public Criteria andGdnoLike(String value) {
            addCriterion("gdno like", value, "gdno");
            return (Criteria) this;
        }

        public Criteria andGdnoNotLike(String value) {
            addCriterion("gdno not like", value, "gdno");
            return (Criteria) this;
        }

        public Criteria andGdnoIn(List<String> values) {
            addCriterion("gdno in", values, "gdno");
            return (Criteria) this;
        }

        public Criteria andGdnoNotIn(List<String> values) {
            addCriterion("gdno not in", values, "gdno");
            return (Criteria) this;
        }

        public Criteria andGdnoBetween(String value1, String value2) {
            addCriterion("gdno between", value1, value2, "gdno");
            return (Criteria) this;
        }

        public Criteria andGdnoNotBetween(String value1, String value2) {
            addCriterion("gdno not between", value1, value2, "gdno");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andYxxIsNull() {
            addCriterion("yxx is null");
            return (Criteria) this;
        }

        public Criteria andYxxIsNotNull() {
            addCriterion("yxx is not null");
            return (Criteria) this;
        }

        public Criteria andYxxEqualTo(Integer value) {
            addCriterion("yxx =", value, "yxx");
            return (Criteria) this;
        }

        public Criteria andYxxNotEqualTo(Integer value) {
            addCriterion("yxx <>", value, "yxx");
            return (Criteria) this;
        }

        public Criteria andYxxGreaterThan(Integer value) {
            addCriterion("yxx >", value, "yxx");
            return (Criteria) this;
        }

        public Criteria andYxxGreaterThanOrEqualTo(Integer value) {
            addCriterion("yxx >=", value, "yxx");
            return (Criteria) this;
        }

        public Criteria andYxxLessThan(Integer value) {
            addCriterion("yxx <", value, "yxx");
            return (Criteria) this;
        }

        public Criteria andYxxLessThanOrEqualTo(Integer value) {
            addCriterion("yxx <=", value, "yxx");
            return (Criteria) this;
        }

        public Criteria andYxxIn(List<Integer> values) {
            addCriterion("yxx in", values, "yxx");
            return (Criteria) this;
        }

        public Criteria andYxxNotIn(List<Integer> values) {
            addCriterion("yxx not in", values, "yxx");
            return (Criteria) this;
        }

        public Criteria andYxxBetween(Integer value1, Integer value2) {
            addCriterion("yxx between", value1, value2, "yxx");
            return (Criteria) this;
        }

        public Criteria andYxxNotBetween(Integer value1, Integer value2) {
            addCriterion("yxx not between", value1, value2, "yxx");
            return (Criteria) this;
        }

        public Criteria andLcslidIsNull() {
            addCriterion("lcslid is null");
            return (Criteria) this;
        }

        public Criteria andLcslidIsNotNull() {
            addCriterion("lcslid is not null");
            return (Criteria) this;
        }

        public Criteria andLcslidEqualTo(String value) {
            addCriterion("lcslid =", value, "lcslid");
            return (Criteria) this;
        }

        public Criteria andLcslidNotEqualTo(String value) {
            addCriterion("lcslid <>", value, "lcslid");
            return (Criteria) this;
        }

        public Criteria andLcslidGreaterThan(String value) {
            addCriterion("lcslid >", value, "lcslid");
            return (Criteria) this;
        }

        public Criteria andLcslidGreaterThanOrEqualTo(String value) {
            addCriterion("lcslid >=", value, "lcslid");
            return (Criteria) this;
        }

        public Criteria andLcslidLessThan(String value) {
            addCriterion("lcslid <", value, "lcslid");
            return (Criteria) this;
        }

        public Criteria andLcslidLessThanOrEqualTo(String value) {
            addCriterion("lcslid <=", value, "lcslid");
            return (Criteria) this;
        }

        public Criteria andLcslidLike(String value) {
            addCriterion("lcslid like", value, "lcslid");
            return (Criteria) this;
        }

        public Criteria andLcslidNotLike(String value) {
            addCriterion("lcslid not like", value, "lcslid");
            return (Criteria) this;
        }

        public Criteria andLcslidIn(List<String> values) {
            addCriterion("lcslid in", values, "lcslid");
            return (Criteria) this;
        }

        public Criteria andLcslidNotIn(List<String> values) {
            addCriterion("lcslid not in", values, "lcslid");
            return (Criteria) this;
        }

        public Criteria andLcslidBetween(String value1, String value2) {
            addCriterion("lcslid between", value1, value2, "lcslid");
            return (Criteria) this;
        }

        public Criteria andLcslidNotBetween(String value1, String value2) {
            addCriterion("lcslid not between", value1, value2, "lcslid");
            return (Criteria) this;
        }

        public Criteria andBacknumIsNull() {
            addCriterion("backNum is null");
            return (Criteria) this;
        }

        public Criteria andBacknumIsNotNull() {
            addCriterion("backNum is not null");
            return (Criteria) this;
        }

        public Criteria andBacknumEqualTo(Integer value) {
            addCriterion("backNum =", value, "backnum");
            return (Criteria) this;
        }

        public Criteria andBacknumNotEqualTo(Integer value) {
            addCriterion("backNum <>", value, "backnum");
            return (Criteria) this;
        }

        public Criteria andBacknumGreaterThan(Integer value) {
            addCriterion("backNum >", value, "backnum");
            return (Criteria) this;
        }

        public Criteria andBacknumGreaterThanOrEqualTo(Integer value) {
            addCriterion("backNum >=", value, "backnum");
            return (Criteria) this;
        }

        public Criteria andBacknumLessThan(Integer value) {
            addCriterion("backNum <", value, "backnum");
            return (Criteria) this;
        }

        public Criteria andBacknumLessThanOrEqualTo(Integer value) {
            addCriterion("backNum <=", value, "backnum");
            return (Criteria) this;
        }

        public Criteria andBacknumIn(List<Integer> values) {
            addCriterion("backNum in", values, "backnum");
            return (Criteria) this;
        }

        public Criteria andBacknumNotIn(List<Integer> values) {
            addCriterion("backNum not in", values, "backnum");
            return (Criteria) this;
        }

        public Criteria andBacknumBetween(Integer value1, Integer value2) {
            addCriterion("backNum between", value1, value2, "backnum");
            return (Criteria) this;
        }

        public Criteria andBacknumNotBetween(Integer value1, Integer value2) {
            addCriterion("backNum not between", value1, value2, "backnum");
            return (Criteria) this;
        }

        public Criteria andPzxxIsNull() {
            addCriterion("pzxx is null");
            return (Criteria) this;
        }

        public Criteria andPzxxIsNotNull() {
            addCriterion("pzxx is not null");
            return (Criteria) this;
        }

        public Criteria andPzxxEqualTo(String value) {
            addCriterion("pzxx =", value, "pzxx");
            return (Criteria) this;
        }

        public Criteria andPzxxNotEqualTo(String value) {
            addCriterion("pzxx <>", value, "pzxx");
            return (Criteria) this;
        }

        public Criteria andPzxxGreaterThan(String value) {
            addCriterion("pzxx >", value, "pzxx");
            return (Criteria) this;
        }

        public Criteria andPzxxGreaterThanOrEqualTo(String value) {
            addCriterion("pzxx >=", value, "pzxx");
            return (Criteria) this;
        }

        public Criteria andPzxxLessThan(String value) {
            addCriterion("pzxx <", value, "pzxx");
            return (Criteria) this;
        }

        public Criteria andPzxxLessThanOrEqualTo(String value) {
            addCriterion("pzxx <=", value, "pzxx");
            return (Criteria) this;
        }

        public Criteria andPzxxLike(String value) {
            addCriterion("pzxx like", value, "pzxx");
            return (Criteria) this;
        }

        public Criteria andPzxxNotLike(String value) {
            addCriterion("pzxx not like", value, "pzxx");
            return (Criteria) this;
        }

        public Criteria andPzxxIn(List<String> values) {
            addCriterion("pzxx in", values, "pzxx");
            return (Criteria) this;
        }

        public Criteria andPzxxNotIn(List<String> values) {
            addCriterion("pzxx not in", values, "pzxx");
            return (Criteria) this;
        }

        public Criteria andPzxxBetween(String value1, String value2) {
            addCriterion("pzxx between", value1, value2, "pzxx");
            return (Criteria) this;
        }

        public Criteria andPzxxNotBetween(String value1, String value2) {
            addCriterion("pzxx not between", value1, value2, "pzxx");
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