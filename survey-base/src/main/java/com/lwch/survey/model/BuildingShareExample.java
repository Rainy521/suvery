package com.lwch.survey.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BuildingShareExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BuildingShareExample() {
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andGybwmcIsNull() {
            addCriterion("gybwmc is null");
            return (Criteria) this;
        }

        public Criteria andGybwmcIsNotNull() {
            addCriterion("gybwmc is not null");
            return (Criteria) this;
        }

        public Criteria andGybwmcEqualTo(String value) {
            addCriterion("gybwmc =", value, "gybwmc");
            return (Criteria) this;
        }

        public Criteria andGybwmcNotEqualTo(String value) {
            addCriterion("gybwmc <>", value, "gybwmc");
            return (Criteria) this;
        }

        public Criteria andGybwmcGreaterThan(String value) {
            addCriterion("gybwmc >", value, "gybwmc");
            return (Criteria) this;
        }

        public Criteria andGybwmcGreaterThanOrEqualTo(String value) {
            addCriterion("gybwmc >=", value, "gybwmc");
            return (Criteria) this;
        }

        public Criteria andGybwmcLessThan(String value) {
            addCriterion("gybwmc <", value, "gybwmc");
            return (Criteria) this;
        }

        public Criteria andGybwmcLessThanOrEqualTo(String value) {
            addCriterion("gybwmc <=", value, "gybwmc");
            return (Criteria) this;
        }

        public Criteria andGybwmcLike(String value) {
            addCriterion("gybwmc like", value, "gybwmc");
            return (Criteria) this;
        }

        public Criteria andGybwmcNotLike(String value) {
            addCriterion("gybwmc not like", value, "gybwmc");
            return (Criteria) this;
        }

        public Criteria andGybwmcIn(List<String> values) {
            addCriterion("gybwmc in", values, "gybwmc");
            return (Criteria) this;
        }

        public Criteria andGybwmcNotIn(List<String> values) {
            addCriterion("gybwmc not in", values, "gybwmc");
            return (Criteria) this;
        }

        public Criteria andGybwmcBetween(String value1, String value2) {
            addCriterion("gybwmc between", value1, value2, "gybwmc");
            return (Criteria) this;
        }

        public Criteria andGybwmcNotBetween(String value1, String value2) {
            addCriterion("gybwmc not between", value1, value2, "gybwmc");
            return (Criteria) this;
        }

        public Criteria andSsgnqIsNull() {
            addCriterion("ssgnq is null");
            return (Criteria) this;
        }

        public Criteria andSsgnqIsNotNull() {
            addCriterion("ssgnq is not null");
            return (Criteria) this;
        }

        public Criteria andSsgnqEqualTo(String value) {
            addCriterion("ssgnq =", value, "ssgnq");
            return (Criteria) this;
        }

        public Criteria andSsgnqNotEqualTo(String value) {
            addCriterion("ssgnq <>", value, "ssgnq");
            return (Criteria) this;
        }

        public Criteria andSsgnqGreaterThan(String value) {
            addCriterion("ssgnq >", value, "ssgnq");
            return (Criteria) this;
        }

        public Criteria andSsgnqGreaterThanOrEqualTo(String value) {
            addCriterion("ssgnq >=", value, "ssgnq");
            return (Criteria) this;
        }

        public Criteria andSsgnqLessThan(String value) {
            addCriterion("ssgnq <", value, "ssgnq");
            return (Criteria) this;
        }

        public Criteria andSsgnqLessThanOrEqualTo(String value) {
            addCriterion("ssgnq <=", value, "ssgnq");
            return (Criteria) this;
        }

        public Criteria andSsgnqLike(String value) {
            addCriterion("ssgnq like", value, "ssgnq");
            return (Criteria) this;
        }

        public Criteria andSsgnqNotLike(String value) {
            addCriterion("ssgnq not like", value, "ssgnq");
            return (Criteria) this;
        }

        public Criteria andSsgnqIn(List<String> values) {
            addCriterion("ssgnq in", values, "ssgnq");
            return (Criteria) this;
        }

        public Criteria andSsgnqNotIn(List<String> values) {
            addCriterion("ssgnq not in", values, "ssgnq");
            return (Criteria) this;
        }

        public Criteria andSsgnqBetween(String value1, String value2) {
            addCriterion("ssgnq between", value1, value2, "ssgnq");
            return (Criteria) this;
        }

        public Criteria andSsgnqNotBetween(String value1, String value2) {
            addCriterion("ssgnq not between", value1, value2, "ssgnq");
            return (Criteria) this;
        }

        public Criteria andGymjIsNull() {
            addCriterion("gymj is null");
            return (Criteria) this;
        }

        public Criteria andGymjIsNotNull() {
            addCriterion("gymj is not null");
            return (Criteria) this;
        }

        public Criteria andGymjEqualTo(Double value) {
            addCriterion("gymj =", value, "gymj");
            return (Criteria) this;
        }

        public Criteria andGymjNotEqualTo(Double value) {
            addCriterion("gymj <>", value, "gymj");
            return (Criteria) this;
        }

        public Criteria andGymjGreaterThan(Double value) {
            addCriterion("gymj >", value, "gymj");
            return (Criteria) this;
        }

        public Criteria andGymjGreaterThanOrEqualTo(Double value) {
            addCriterion("gymj >=", value, "gymj");
            return (Criteria) this;
        }

        public Criteria andGymjLessThan(Double value) {
            addCriterion("gymj <", value, "gymj");
            return (Criteria) this;
        }

        public Criteria andGymjLessThanOrEqualTo(Double value) {
            addCriterion("gymj <=", value, "gymj");
            return (Criteria) this;
        }

        public Criteria andGymjIn(List<Double> values) {
            addCriterion("gymj in", values, "gymj");
            return (Criteria) this;
        }

        public Criteria andGymjNotIn(List<Double> values) {
            addCriterion("gymj not in", values, "gymj");
            return (Criteria) this;
        }

        public Criteria andGymjBetween(Double value1, Double value2) {
            addCriterion("gymj between", value1, value2, "gymj");
            return (Criteria) this;
        }

        public Criteria andGymjNotBetween(Double value1, Double value2) {
            addCriterion("gymj not between", value1, value2, "gymj");
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