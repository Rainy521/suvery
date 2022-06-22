package com.lwch.survey.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BuildingDomainExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BuildingDomainExample() {
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

        public Criteria andBuildIdIsNull() {
            addCriterion("build_id is null");
            return (Criteria) this;
        }

        public Criteria andBuildIdIsNotNull() {
            addCriterion("build_id is not null");
            return (Criteria) this;
        }

        public Criteria andBuildIdEqualTo(String value) {
            addCriterion("build_id =", value, "buildId");
            return (Criteria) this;
        }

        public Criteria andBuildIdNotEqualTo(String value) {
            addCriterion("build_id <>", value, "buildId");
            return (Criteria) this;
        }

        public Criteria andBuildIdGreaterThan(String value) {
            addCriterion("build_id >", value, "buildId");
            return (Criteria) this;
        }

        public Criteria andBuildIdGreaterThanOrEqualTo(String value) {
            addCriterion("build_id >=", value, "buildId");
            return (Criteria) this;
        }

        public Criteria andBuildIdLessThan(String value) {
            addCriterion("build_id <", value, "buildId");
            return (Criteria) this;
        }

        public Criteria andBuildIdLessThanOrEqualTo(String value) {
            addCriterion("build_id <=", value, "buildId");
            return (Criteria) this;
        }

        public Criteria andBuildIdLike(String value) {
            addCriterion("build_id like", value, "buildId");
            return (Criteria) this;
        }

        public Criteria andBuildIdNotLike(String value) {
            addCriterion("build_id not like", value, "buildId");
            return (Criteria) this;
        }

        public Criteria andBuildIdIn(List<String> values) {
            addCriterion("build_id in", values, "buildId");
            return (Criteria) this;
        }

        public Criteria andBuildIdNotIn(List<String> values) {
            addCriterion("build_id not in", values, "buildId");
            return (Criteria) this;
        }

        public Criteria andBuildIdBetween(String value1, String value2) {
            addCriterion("build_id between", value1, value2, "buildId");
            return (Criteria) this;
        }

        public Criteria andBuildIdNotBetween(String value1, String value2) {
            addCriterion("build_id not between", value1, value2, "buildId");
            return (Criteria) this;
        }

        public Criteria andGnqhIsNull() {
            addCriterion("gnqh is null");
            return (Criteria) this;
        }

        public Criteria andGnqhIsNotNull() {
            addCriterion("gnqh is not null");
            return (Criteria) this;
        }

        public Criteria andGnqhEqualTo(String value) {
            addCriterion("gnqh =", value, "gnqh");
            return (Criteria) this;
        }

        public Criteria andGnqhNotEqualTo(String value) {
            addCriterion("gnqh <>", value, "gnqh");
            return (Criteria) this;
        }

        public Criteria andGnqhGreaterThan(String value) {
            addCriterion("gnqh >", value, "gnqh");
            return (Criteria) this;
        }

        public Criteria andGnqhGreaterThanOrEqualTo(String value) {
            addCriterion("gnqh >=", value, "gnqh");
            return (Criteria) this;
        }

        public Criteria andGnqhLessThan(String value) {
            addCriterion("gnqh <", value, "gnqh");
            return (Criteria) this;
        }

        public Criteria andGnqhLessThanOrEqualTo(String value) {
            addCriterion("gnqh <=", value, "gnqh");
            return (Criteria) this;
        }

        public Criteria andGnqhLike(String value) {
            addCriterion("gnqh like", value, "gnqh");
            return (Criteria) this;
        }

        public Criteria andGnqhNotLike(String value) {
            addCriterion("gnqh not like", value, "gnqh");
            return (Criteria) this;
        }

        public Criteria andGnqhIn(List<String> values) {
            addCriterion("gnqh in", values, "gnqh");
            return (Criteria) this;
        }

        public Criteria andGnqhNotIn(List<String> values) {
            addCriterion("gnqh not in", values, "gnqh");
            return (Criteria) this;
        }

        public Criteria andGnqhBetween(String value1, String value2) {
            addCriterion("gnqh between", value1, value2, "gnqh");
            return (Criteria) this;
        }

        public Criteria andGnqhNotBetween(String value1, String value2) {
            addCriterion("gnqh not between", value1, value2, "gnqh");
            return (Criteria) this;
        }

        public Criteria andGnqlbIsNull() {
            addCriterion("gnqlb is null");
            return (Criteria) this;
        }

        public Criteria andGnqlbIsNotNull() {
            addCriterion("gnqlb is not null");
            return (Criteria) this;
        }

        public Criteria andGnqlbEqualTo(String value) {
            addCriterion("gnqlb =", value, "gnqlb");
            return (Criteria) this;
        }

        public Criteria andGnqlbNotEqualTo(String value) {
            addCriterion("gnqlb <>", value, "gnqlb");
            return (Criteria) this;
        }

        public Criteria andGnqlbGreaterThan(String value) {
            addCriterion("gnqlb >", value, "gnqlb");
            return (Criteria) this;
        }

        public Criteria andGnqlbGreaterThanOrEqualTo(String value) {
            addCriterion("gnqlb >=", value, "gnqlb");
            return (Criteria) this;
        }

        public Criteria andGnqlbLessThan(String value) {
            addCriterion("gnqlb <", value, "gnqlb");
            return (Criteria) this;
        }

        public Criteria andGnqlbLessThanOrEqualTo(String value) {
            addCriterion("gnqlb <=", value, "gnqlb");
            return (Criteria) this;
        }

        public Criteria andGnqlbLike(String value) {
            addCriterion("gnqlb like", value, "gnqlb");
            return (Criteria) this;
        }

        public Criteria andGnqlbNotLike(String value) {
            addCriterion("gnqlb not like", value, "gnqlb");
            return (Criteria) this;
        }

        public Criteria andGnqlbIn(List<String> values) {
            addCriterion("gnqlb in", values, "gnqlb");
            return (Criteria) this;
        }

        public Criteria andGnqlbNotIn(List<String> values) {
            addCriterion("gnqlb not in", values, "gnqlb");
            return (Criteria) this;
        }

        public Criteria andGnqlbBetween(String value1, String value2) {
            addCriterion("gnqlb between", value1, value2, "gnqlb");
            return (Criteria) this;
        }

        public Criteria andGnqlbNotBetween(String value1, String value2) {
            addCriterion("gnqlb not between", value1, value2, "gnqlb");
            return (Criteria) this;
        }

        public Criteria andGnqmcIsNull() {
            addCriterion("gnqmc is null");
            return (Criteria) this;
        }

        public Criteria andGnqmcIsNotNull() {
            addCriterion("gnqmc is not null");
            return (Criteria) this;
        }

        public Criteria andGnqmcEqualTo(String value) {
            addCriterion("gnqmc =", value, "gnqmc");
            return (Criteria) this;
        }

        public Criteria andGnqmcNotEqualTo(String value) {
            addCriterion("gnqmc <>", value, "gnqmc");
            return (Criteria) this;
        }

        public Criteria andGnqmcGreaterThan(String value) {
            addCriterion("gnqmc >", value, "gnqmc");
            return (Criteria) this;
        }

        public Criteria andGnqmcGreaterThanOrEqualTo(String value) {
            addCriterion("gnqmc >=", value, "gnqmc");
            return (Criteria) this;
        }

        public Criteria andGnqmcLessThan(String value) {
            addCriterion("gnqmc <", value, "gnqmc");
            return (Criteria) this;
        }

        public Criteria andGnqmcLessThanOrEqualTo(String value) {
            addCriterion("gnqmc <=", value, "gnqmc");
            return (Criteria) this;
        }

        public Criteria andGnqmcLike(String value) {
            addCriterion("gnqmc like", value, "gnqmc");
            return (Criteria) this;
        }

        public Criteria andGnqmcNotLike(String value) {
            addCriterion("gnqmc not like", value, "gnqmc");
            return (Criteria) this;
        }

        public Criteria andGnqmcIn(List<String> values) {
            addCriterion("gnqmc in", values, "gnqmc");
            return (Criteria) this;
        }

        public Criteria andGnqmcNotIn(List<String> values) {
            addCriterion("gnqmc not in", values, "gnqmc");
            return (Criteria) this;
        }

        public Criteria andGnqmcBetween(String value1, String value2) {
            addCriterion("gnqmc between", value1, value2, "gnqmc");
            return (Criteria) this;
        }

        public Criteria andGnqmcNotBetween(String value1, String value2) {
            addCriterion("gnqmc not between", value1, value2, "gnqmc");
            return (Criteria) this;
        }

        public Criteria andFtxsIsNull() {
            addCriterion("ftxs is null");
            return (Criteria) this;
        }

        public Criteria andFtxsIsNotNull() {
            addCriterion("ftxs is not null");
            return (Criteria) this;
        }

        public Criteria andFtxsEqualTo(Double value) {
            addCriterion("ftxs =", value, "ftxs");
            return (Criteria) this;
        }

        public Criteria andFtxsNotEqualTo(Double value) {
            addCriterion("ftxs <>", value, "ftxs");
            return (Criteria) this;
        }

        public Criteria andFtxsGreaterThan(Double value) {
            addCriterion("ftxs >", value, "ftxs");
            return (Criteria) this;
        }

        public Criteria andFtxsGreaterThanOrEqualTo(Double value) {
            addCriterion("ftxs >=", value, "ftxs");
            return (Criteria) this;
        }

        public Criteria andFtxsLessThan(Double value) {
            addCriterion("ftxs <", value, "ftxs");
            return (Criteria) this;
        }

        public Criteria andFtxsLessThanOrEqualTo(Double value) {
            addCriterion("ftxs <=", value, "ftxs");
            return (Criteria) this;
        }

        public Criteria andFtxsIn(List<Double> values) {
            addCriterion("ftxs in", values, "ftxs");
            return (Criteria) this;
        }

        public Criteria andFtxsNotIn(List<Double> values) {
            addCriterion("ftxs not in", values, "ftxs");
            return (Criteria) this;
        }

        public Criteria andFtxsBetween(Double value1, Double value2) {
            addCriterion("ftxs between", value1, value2, "ftxs");
            return (Criteria) this;
        }

        public Criteria andFtxsNotBetween(Double value1, Double value2) {
            addCriterion("ftxs not between", value1, value2, "ftxs");
            return (Criteria) this;
        }

        public Criteria andJzmjIsNull() {
            addCriterion("jzmj is null");
            return (Criteria) this;
        }

        public Criteria andJzmjIsNotNull() {
            addCriterion("jzmj is not null");
            return (Criteria) this;
        }

        public Criteria andJzmjEqualTo(Double value) {
            addCriterion("jzmj =", value, "jzmj");
            return (Criteria) this;
        }

        public Criteria andJzmjNotEqualTo(Double value) {
            addCriterion("jzmj <>", value, "jzmj");
            return (Criteria) this;
        }

        public Criteria andJzmjGreaterThan(Double value) {
            addCriterion("jzmj >", value, "jzmj");
            return (Criteria) this;
        }

        public Criteria andJzmjGreaterThanOrEqualTo(Double value) {
            addCriterion("jzmj >=", value, "jzmj");
            return (Criteria) this;
        }

        public Criteria andJzmjLessThan(Double value) {
            addCriterion("jzmj <", value, "jzmj");
            return (Criteria) this;
        }

        public Criteria andJzmjLessThanOrEqualTo(Double value) {
            addCriterion("jzmj <=", value, "jzmj");
            return (Criteria) this;
        }

        public Criteria andJzmjIn(List<Double> values) {
            addCriterion("jzmj in", values, "jzmj");
            return (Criteria) this;
        }

        public Criteria andJzmjNotIn(List<Double> values) {
            addCriterion("jzmj not in", values, "jzmj");
            return (Criteria) this;
        }

        public Criteria andJzmjBetween(Double value1, Double value2) {
            addCriterion("jzmj between", value1, value2, "jzmj");
            return (Criteria) this;
        }

        public Criteria andJzmjNotBetween(Double value1, Double value2) {
            addCriterion("jzmj not between", value1, value2, "jzmj");
            return (Criteria) this;
        }

        public Criteria andTnmjIsNull() {
            addCriterion("tnmj is null");
            return (Criteria) this;
        }

        public Criteria andTnmjIsNotNull() {
            addCriterion("tnmj is not null");
            return (Criteria) this;
        }

        public Criteria andTnmjEqualTo(Double value) {
            addCriterion("tnmj =", value, "tnmj");
            return (Criteria) this;
        }

        public Criteria andTnmjNotEqualTo(Double value) {
            addCriterion("tnmj <>", value, "tnmj");
            return (Criteria) this;
        }

        public Criteria andTnmjGreaterThan(Double value) {
            addCriterion("tnmj >", value, "tnmj");
            return (Criteria) this;
        }

        public Criteria andTnmjGreaterThanOrEqualTo(Double value) {
            addCriterion("tnmj >=", value, "tnmj");
            return (Criteria) this;
        }

        public Criteria andTnmjLessThan(Double value) {
            addCriterion("tnmj <", value, "tnmj");
            return (Criteria) this;
        }

        public Criteria andTnmjLessThanOrEqualTo(Double value) {
            addCriterion("tnmj <=", value, "tnmj");
            return (Criteria) this;
        }

        public Criteria andTnmjIn(List<Double> values) {
            addCriterion("tnmj in", values, "tnmj");
            return (Criteria) this;
        }

        public Criteria andTnmjNotIn(List<Double> values) {
            addCriterion("tnmj not in", values, "tnmj");
            return (Criteria) this;
        }

        public Criteria andTnmjBetween(Double value1, Double value2) {
            addCriterion("tnmj between", value1, value2, "tnmj");
            return (Criteria) this;
        }

        public Criteria andTnmjNotBetween(Double value1, Double value2) {
            addCriterion("tnmj not between", value1, value2, "tnmj");
            return (Criteria) this;
        }

        public Criteria andFtmjIsNull() {
            addCriterion("ftmj is null");
            return (Criteria) this;
        }

        public Criteria andFtmjIsNotNull() {
            addCriterion("ftmj is not null");
            return (Criteria) this;
        }

        public Criteria andFtmjEqualTo(Double value) {
            addCriterion("ftmj =", value, "ftmj");
            return (Criteria) this;
        }

        public Criteria andFtmjNotEqualTo(Double value) {
            addCriterion("ftmj <>", value, "ftmj");
            return (Criteria) this;
        }

        public Criteria andFtmjGreaterThan(Double value) {
            addCriterion("ftmj >", value, "ftmj");
            return (Criteria) this;
        }

        public Criteria andFtmjGreaterThanOrEqualTo(Double value) {
            addCriterion("ftmj >=", value, "ftmj");
            return (Criteria) this;
        }

        public Criteria andFtmjLessThan(Double value) {
            addCriterion("ftmj <", value, "ftmj");
            return (Criteria) this;
        }

        public Criteria andFtmjLessThanOrEqualTo(Double value) {
            addCriterion("ftmj <=", value, "ftmj");
            return (Criteria) this;
        }

        public Criteria andFtmjIn(List<Double> values) {
            addCriterion("ftmj in", values, "ftmj");
            return (Criteria) this;
        }

        public Criteria andFtmjNotIn(List<Double> values) {
            addCriterion("ftmj not in", values, "ftmj");
            return (Criteria) this;
        }

        public Criteria andFtmjBetween(Double value1, Double value2) {
            addCriterion("ftmj between", value1, value2, "ftmj");
            return (Criteria) this;
        }

        public Criteria andFtmjNotBetween(Double value1, Double value2) {
            addCriterion("ftmj not between", value1, value2, "ftmj");
            return (Criteria) this;
        }

        public Criteria andTsIsNull() {
            addCriterion("ts is null");
            return (Criteria) this;
        }

        public Criteria andTsIsNotNull() {
            addCriterion("ts is not null");
            return (Criteria) this;
        }

        public Criteria andTsEqualTo(Integer value) {
            addCriterion("ts =", value, "ts");
            return (Criteria) this;
        }

        public Criteria andTsNotEqualTo(Integer value) {
            addCriterion("ts <>", value, "ts");
            return (Criteria) this;
        }

        public Criteria andTsGreaterThan(Integer value) {
            addCriterion("ts >", value, "ts");
            return (Criteria) this;
        }

        public Criteria andTsGreaterThanOrEqualTo(Integer value) {
            addCriterion("ts >=", value, "ts");
            return (Criteria) this;
        }

        public Criteria andTsLessThan(Integer value) {
            addCriterion("ts <", value, "ts");
            return (Criteria) this;
        }

        public Criteria andTsLessThanOrEqualTo(Integer value) {
            addCriterion("ts <=", value, "ts");
            return (Criteria) this;
        }

        public Criteria andTsIn(List<Integer> values) {
            addCriterion("ts in", values, "ts");
            return (Criteria) this;
        }

        public Criteria andTsNotIn(List<Integer> values) {
            addCriterion("ts not in", values, "ts");
            return (Criteria) this;
        }

        public Criteria andTsBetween(Integer value1, Integer value2) {
            addCriterion("ts between", value1, value2, "ts");
            return (Criteria) this;
        }

        public Criteria andTsNotBetween(Integer value1, Integer value2) {
            addCriterion("ts not between", value1, value2, "ts");
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