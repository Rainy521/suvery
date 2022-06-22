package com.lwch.survey.model;

import java.util.ArrayList;
import java.util.List;

public class BuildingDomainMemberExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BuildingDomainMemberExample() {
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

        public Criteria andGnqidIsNull() {
            addCriterion("gnqid is null");
            return (Criteria) this;
        }

        public Criteria andGnqidIsNotNull() {
            addCriterion("gnqid is not null");
            return (Criteria) this;
        }

        public Criteria andGnqidEqualTo(String value) {
            addCriterion("gnqid =", value, "gnqid");
            return (Criteria) this;
        }

        public Criteria andGnqidNotEqualTo(String value) {
            addCriterion("gnqid <>", value, "gnqid");
            return (Criteria) this;
        }

        public Criteria andGnqidGreaterThan(String value) {
            addCriterion("gnqid >", value, "gnqid");
            return (Criteria) this;
        }

        public Criteria andGnqidGreaterThanOrEqualTo(String value) {
            addCriterion("gnqid >=", value, "gnqid");
            return (Criteria) this;
        }

        public Criteria andGnqidLessThan(String value) {
            addCriterion("gnqid <", value, "gnqid");
            return (Criteria) this;
        }

        public Criteria andGnqidLessThanOrEqualTo(String value) {
            addCriterion("gnqid <=", value, "gnqid");
            return (Criteria) this;
        }

        public Criteria andGnqidLike(String value) {
            addCriterion("gnqid like", value, "gnqid");
            return (Criteria) this;
        }

        public Criteria andGnqidNotLike(String value) {
            addCriterion("gnqid not like", value, "gnqid");
            return (Criteria) this;
        }

        public Criteria andGnqidIn(List<String> values) {
            addCriterion("gnqid in", values, "gnqid");
            return (Criteria) this;
        }

        public Criteria andGnqidNotIn(List<String> values) {
            addCriterion("gnqid not in", values, "gnqid");
            return (Criteria) this;
        }

        public Criteria andGnqidBetween(String value1, String value2) {
            addCriterion("gnqid between", value1, value2, "gnqid");
            return (Criteria) this;
        }

        public Criteria andGnqidNotBetween(String value1, String value2) {
            addCriterion("gnqid not between", value1, value2, "gnqid");
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