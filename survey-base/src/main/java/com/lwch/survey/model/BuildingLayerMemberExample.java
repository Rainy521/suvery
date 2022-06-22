package com.lwch.survey.model;

import java.util.ArrayList;
import java.util.List;

public class BuildingLayerMemberExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BuildingLayerMemberExample() {
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

        public Criteria andLpzidIsNull() {
            addCriterion("lpzid is null");
            return (Criteria) this;
        }

        public Criteria andLpzidIsNotNull() {
            addCriterion("lpzid is not null");
            return (Criteria) this;
        }

        public Criteria andLpzidEqualTo(String value) {
            addCriterion("lpzid =", value, "lpzid");
            return (Criteria) this;
        }

        public Criteria andLpzidNotEqualTo(String value) {
            addCriterion("lpzid <>", value, "lpzid");
            return (Criteria) this;
        }

        public Criteria andLpzidGreaterThan(String value) {
            addCriterion("lpzid >", value, "lpzid");
            return (Criteria) this;
        }

        public Criteria andLpzidGreaterThanOrEqualTo(String value) {
            addCriterion("lpzid >=", value, "lpzid");
            return (Criteria) this;
        }

        public Criteria andLpzidLessThan(String value) {
            addCriterion("lpzid <", value, "lpzid");
            return (Criteria) this;
        }

        public Criteria andLpzidLessThanOrEqualTo(String value) {
            addCriterion("lpzid <=", value, "lpzid");
            return (Criteria) this;
        }

        public Criteria andLpzidLike(String value) {
            addCriterion("lpzid like", value, "lpzid");
            return (Criteria) this;
        }

        public Criteria andLpzidNotLike(String value) {
            addCriterion("lpzid not like", value, "lpzid");
            return (Criteria) this;
        }

        public Criteria andLpzidIn(List<String> values) {
            addCriterion("lpzid in", values, "lpzid");
            return (Criteria) this;
        }

        public Criteria andLpzidNotIn(List<String> values) {
            addCriterion("lpzid not in", values, "lpzid");
            return (Criteria) this;
        }

        public Criteria andLpzidBetween(String value1, String value2) {
            addCriterion("lpzid between", value1, value2, "lpzid");
            return (Criteria) this;
        }

        public Criteria andLpzidNotBetween(String value1, String value2) {
            addCriterion("lpzid not between", value1, value2, "lpzid");
            return (Criteria) this;
        }

        public Criteria andCidIsNull() {
            addCriterion("cid is null");
            return (Criteria) this;
        }

        public Criteria andCidIsNotNull() {
            addCriterion("cid is not null");
            return (Criteria) this;
        }

        public Criteria andCidEqualTo(String value) {
            addCriterion("cid =", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotEqualTo(String value) {
            addCriterion("cid <>", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThan(String value) {
            addCriterion("cid >", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThanOrEqualTo(String value) {
            addCriterion("cid >=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThan(String value) {
            addCriterion("cid <", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThanOrEqualTo(String value) {
            addCriterion("cid <=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLike(String value) {
            addCriterion("cid like", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotLike(String value) {
            addCriterion("cid not like", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidIn(List<String> values) {
            addCriterion("cid in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotIn(List<String> values) {
            addCriterion("cid not in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidBetween(String value1, String value2) {
            addCriterion("cid between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotBetween(String value1, String value2) {
            addCriterion("cid not between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andCgyidIsNull() {
            addCriterion("cgyid is null");
            return (Criteria) this;
        }

        public Criteria andCgyidIsNotNull() {
            addCriterion("cgyid is not null");
            return (Criteria) this;
        }

        public Criteria andCgyidEqualTo(String value) {
            addCriterion("cgyid =", value, "cgyid");
            return (Criteria) this;
        }

        public Criteria andCgyidNotEqualTo(String value) {
            addCriterion("cgyid <>", value, "cgyid");
            return (Criteria) this;
        }

        public Criteria andCgyidGreaterThan(String value) {
            addCriterion("cgyid >", value, "cgyid");
            return (Criteria) this;
        }

        public Criteria andCgyidGreaterThanOrEqualTo(String value) {
            addCriterion("cgyid >=", value, "cgyid");
            return (Criteria) this;
        }

        public Criteria andCgyidLessThan(String value) {
            addCriterion("cgyid <", value, "cgyid");
            return (Criteria) this;
        }

        public Criteria andCgyidLessThanOrEqualTo(String value) {
            addCriterion("cgyid <=", value, "cgyid");
            return (Criteria) this;
        }

        public Criteria andCgyidLike(String value) {
            addCriterion("cgyid like", value, "cgyid");
            return (Criteria) this;
        }

        public Criteria andCgyidNotLike(String value) {
            addCriterion("cgyid not like", value, "cgyid");
            return (Criteria) this;
        }

        public Criteria andCgyidIn(List<String> values) {
            addCriterion("cgyid in", values, "cgyid");
            return (Criteria) this;
        }

        public Criteria andCgyidNotIn(List<String> values) {
            addCriterion("cgyid not in", values, "cgyid");
            return (Criteria) this;
        }

        public Criteria andCgyidBetween(String value1, String value2) {
            addCriterion("cgyid between", value1, value2, "cgyid");
            return (Criteria) this;
        }

        public Criteria andCgyidNotBetween(String value1, String value2) {
            addCriterion("cgyid not between", value1, value2, "cgyid");
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