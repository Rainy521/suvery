package com.lwch.survey.model;

import java.util.ArrayList;
import java.util.List;

public class ApplyBuildExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ApplyBuildExample() {
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

        public Criteria andSlbhIsNull() {
            addCriterion("slbh is null");
            return (Criteria) this;
        }

        public Criteria andSlbhIsNotNull() {
            addCriterion("slbh is not null");
            return (Criteria) this;
        }

        public Criteria andSlbhEqualTo(String value) {
            addCriterion("slbh =", value, "slbh");
            return (Criteria) this;
        }

        public Criteria andSlbhNotEqualTo(String value) {
            addCriterion("slbh <>", value, "slbh");
            return (Criteria) this;
        }

        public Criteria andSlbhGreaterThan(String value) {
            addCriterion("slbh >", value, "slbh");
            return (Criteria) this;
        }

        public Criteria andSlbhGreaterThanOrEqualTo(String value) {
            addCriterion("slbh >=", value, "slbh");
            return (Criteria) this;
        }

        public Criteria andSlbhLessThan(String value) {
            addCriterion("slbh <", value, "slbh");
            return (Criteria) this;
        }

        public Criteria andSlbhLessThanOrEqualTo(String value) {
            addCriterion("slbh <=", value, "slbh");
            return (Criteria) this;
        }

        public Criteria andSlbhLike(String value) {
            addCriterion("slbh like", value, "slbh");
            return (Criteria) this;
        }

        public Criteria andSlbhNotLike(String value) {
            addCriterion("slbh not like", value, "slbh");
            return (Criteria) this;
        }

        public Criteria andSlbhIn(List<String> values) {
            addCriterion("slbh in", values, "slbh");
            return (Criteria) this;
        }

        public Criteria andSlbhNotIn(List<String> values) {
            addCriterion("slbh not in", values, "slbh");
            return (Criteria) this;
        }

        public Criteria andSlbhBetween(String value1, String value2) {
            addCriterion("slbh between", value1, value2, "slbh");
            return (Criteria) this;
        }

        public Criteria andSlbhNotBetween(String value1, String value2) {
            addCriterion("slbh not between", value1, value2, "slbh");
            return (Criteria) this;
        }

        public Criteria andSlsjIsNull() {
            addCriterion("slsj is null");
            return (Criteria) this;
        }

        public Criteria andSlsjIsNotNull() {
            addCriterion("slsj is not null");
            return (Criteria) this;
        }

        public Criteria andSlsjEqualTo(String value) {
            addCriterion("slsj =", value, "slsj");
            return (Criteria) this;
        }

        public Criteria andSlsjNotEqualTo(String value) {
            addCriterion("slsj <>", value, "slsj");
            return (Criteria) this;
        }

        public Criteria andSlsjGreaterThan(String value) {
            addCriterion("slsj >", value, "slsj");
            return (Criteria) this;
        }

        public Criteria andSlsjGreaterThanOrEqualTo(String value) {
            addCriterion("slsj >=", value, "slsj");
            return (Criteria) this;
        }

        public Criteria andSlsjLessThan(String value) {
            addCriterion("slsj <", value, "slsj");
            return (Criteria) this;
        }

        public Criteria andSlsjLessThanOrEqualTo(String value) {
            addCriterion("slsj <=", value, "slsj");
            return (Criteria) this;
        }

        public Criteria andSlsjLike(String value) {
            addCriterion("slsj like", value, "slsj");
            return (Criteria) this;
        }

        public Criteria andSlsjNotLike(String value) {
            addCriterion("slsj not like", value, "slsj");
            return (Criteria) this;
        }

        public Criteria andSlsjIn(List<String> values) {
            addCriterion("slsj in", values, "slsj");
            return (Criteria) this;
        }

        public Criteria andSlsjNotIn(List<String> values) {
            addCriterion("slsj not in", values, "slsj");
            return (Criteria) this;
        }

        public Criteria andSlsjBetween(String value1, String value2) {
            addCriterion("slsj between", value1, value2, "slsj");
            return (Criteria) this;
        }

        public Criteria andSlsjNotBetween(String value1, String value2) {
            addCriterion("slsj not between", value1, value2, "slsj");
            return (Criteria) this;
        }

        public Criteria andChlxIsNull() {
            addCriterion("chlx is null");
            return (Criteria) this;
        }

        public Criteria andChlxIsNotNull() {
            addCriterion("chlx is not null");
            return (Criteria) this;
        }

        public Criteria andChlxEqualTo(String value) {
            addCriterion("chlx =", value, "chlx");
            return (Criteria) this;
        }

        public Criteria andChlxNotEqualTo(String value) {
            addCriterion("chlx <>", value, "chlx");
            return (Criteria) this;
        }

        public Criteria andChlxGreaterThan(String value) {
            addCriterion("chlx >", value, "chlx");
            return (Criteria) this;
        }

        public Criteria andChlxGreaterThanOrEqualTo(String value) {
            addCriterion("chlx >=", value, "chlx");
            return (Criteria) this;
        }

        public Criteria andChlxLessThan(String value) {
            addCriterion("chlx <", value, "chlx");
            return (Criteria) this;
        }

        public Criteria andChlxLessThanOrEqualTo(String value) {
            addCriterion("chlx <=", value, "chlx");
            return (Criteria) this;
        }

        public Criteria andChlxLike(String value) {
            addCriterion("chlx like", value, "chlx");
            return (Criteria) this;
        }

        public Criteria andChlxNotLike(String value) {
            addCriterion("chlx not like", value, "chlx");
            return (Criteria) this;
        }

        public Criteria andChlxIn(List<String> values) {
            addCriterion("chlx in", values, "chlx");
            return (Criteria) this;
        }

        public Criteria andChlxNotIn(List<String> values) {
            addCriterion("chlx not in", values, "chlx");
            return (Criteria) this;
        }

        public Criteria andChlxBetween(String value1, String value2) {
            addCriterion("chlx between", value1, value2, "chlx");
            return (Criteria) this;
        }

        public Criteria andChlxNotBetween(String value1, String value2) {
            addCriterion("chlx not between", value1, value2, "chlx");
            return (Criteria) this;
        }

        public Criteria andSbrIsNull() {
            addCriterion("sbr is null");
            return (Criteria) this;
        }

        public Criteria andSbrIsNotNull() {
            addCriterion("sbr is not null");
            return (Criteria) this;
        }

        public Criteria andSbrEqualTo(String value) {
            addCriterion("sbr =", value, "sbr");
            return (Criteria) this;
        }

        public Criteria andSbrNotEqualTo(String value) {
            addCriterion("sbr <>", value, "sbr");
            return (Criteria) this;
        }

        public Criteria andSbrGreaterThan(String value) {
            addCriterion("sbr >", value, "sbr");
            return (Criteria) this;
        }

        public Criteria andSbrGreaterThanOrEqualTo(String value) {
            addCriterion("sbr >=", value, "sbr");
            return (Criteria) this;
        }

        public Criteria andSbrLessThan(String value) {
            addCriterion("sbr <", value, "sbr");
            return (Criteria) this;
        }

        public Criteria andSbrLessThanOrEqualTo(String value) {
            addCriterion("sbr <=", value, "sbr");
            return (Criteria) this;
        }

        public Criteria andSbrLike(String value) {
            addCriterion("sbr like", value, "sbr");
            return (Criteria) this;
        }

        public Criteria andSbrNotLike(String value) {
            addCriterion("sbr not like", value, "sbr");
            return (Criteria) this;
        }

        public Criteria andSbrIn(List<String> values) {
            addCriterion("sbr in", values, "sbr");
            return (Criteria) this;
        }

        public Criteria andSbrNotIn(List<String> values) {
            addCriterion("sbr not in", values, "sbr");
            return (Criteria) this;
        }

        public Criteria andSbrBetween(String value1, String value2) {
            addCriterion("sbr between", value1, value2, "sbr");
            return (Criteria) this;
        }

        public Criteria andSbrNotBetween(String value1, String value2) {
            addCriterion("sbr not between", value1, value2, "sbr");
            return (Criteria) this;
        }

        public Criteria andLpzhIsNull() {
            addCriterion("lpzh is null");
            return (Criteria) this;
        }

        public Criteria andLpzhIsNotNull() {
            addCriterion("lpzh is not null");
            return (Criteria) this;
        }

        public Criteria andLpzhEqualTo(String value) {
            addCriterion("lpzh =", value, "lpzh");
            return (Criteria) this;
        }

        public Criteria andLpzhNotEqualTo(String value) {
            addCriterion("lpzh <>", value, "lpzh");
            return (Criteria) this;
        }

        public Criteria andLpzhGreaterThan(String value) {
            addCriterion("lpzh >", value, "lpzh");
            return (Criteria) this;
        }

        public Criteria andLpzhGreaterThanOrEqualTo(String value) {
            addCriterion("lpzh >=", value, "lpzh");
            return (Criteria) this;
        }

        public Criteria andLpzhLessThan(String value) {
            addCriterion("lpzh <", value, "lpzh");
            return (Criteria) this;
        }

        public Criteria andLpzhLessThanOrEqualTo(String value) {
            addCriterion("lpzh <=", value, "lpzh");
            return (Criteria) this;
        }

        public Criteria andLpzhLike(String value) {
            addCriterion("lpzh like", value, "lpzh");
            return (Criteria) this;
        }

        public Criteria andLpzhNotLike(String value) {
            addCriterion("lpzh not like", value, "lpzh");
            return (Criteria) this;
        }

        public Criteria andLpzhIn(List<String> values) {
            addCriterion("lpzh in", values, "lpzh");
            return (Criteria) this;
        }

        public Criteria andLpzhNotIn(List<String> values) {
            addCriterion("lpzh not in", values, "lpzh");
            return (Criteria) this;
        }

        public Criteria andLpzhBetween(String value1, String value2) {
            addCriterion("lpzh between", value1, value2, "lpzh");
            return (Criteria) this;
        }

        public Criteria andLpzhNotBetween(String value1, String value2) {
            addCriterion("lpzh not between", value1, value2, "lpzh");
            return (Criteria) this;
        }

        public Criteria andBdcqzhIsNull() {
            addCriterion("bdcqzh is null");
            return (Criteria) this;
        }

        public Criteria andBdcqzhIsNotNull() {
            addCriterion("bdcqzh is not null");
            return (Criteria) this;
        }

        public Criteria andBdcqzhEqualTo(String value) {
            addCriterion("bdcqzh =", value, "bdcqzh");
            return (Criteria) this;
        }

        public Criteria andBdcqzhNotEqualTo(String value) {
            addCriterion("bdcqzh <>", value, "bdcqzh");
            return (Criteria) this;
        }

        public Criteria andBdcqzhGreaterThan(String value) {
            addCriterion("bdcqzh >", value, "bdcqzh");
            return (Criteria) this;
        }

        public Criteria andBdcqzhGreaterThanOrEqualTo(String value) {
            addCriterion("bdcqzh >=", value, "bdcqzh");
            return (Criteria) this;
        }

        public Criteria andBdcqzhLessThan(String value) {
            addCriterion("bdcqzh <", value, "bdcqzh");
            return (Criteria) this;
        }

        public Criteria andBdcqzhLessThanOrEqualTo(String value) {
            addCriterion("bdcqzh <=", value, "bdcqzh");
            return (Criteria) this;
        }

        public Criteria andBdcqzhLike(String value) {
            addCriterion("bdcqzh like", value, "bdcqzh");
            return (Criteria) this;
        }

        public Criteria andBdcqzhNotLike(String value) {
            addCriterion("bdcqzh not like", value, "bdcqzh");
            return (Criteria) this;
        }

        public Criteria andBdcqzhIn(List<String> values) {
            addCriterion("bdcqzh in", values, "bdcqzh");
            return (Criteria) this;
        }

        public Criteria andBdcqzhNotIn(List<String> values) {
            addCriterion("bdcqzh not in", values, "bdcqzh");
            return (Criteria) this;
        }

        public Criteria andBdcqzhBetween(String value1, String value2) {
            addCriterion("bdcqzh between", value1, value2, "bdcqzh");
            return (Criteria) this;
        }

        public Criteria andBdcqzhNotBetween(String value1, String value2) {
            addCriterion("bdcqzh not between", value1, value2, "bdcqzh");
            return (Criteria) this;
        }

        public Criteria andGhxkzhIsNull() {
            addCriterion("ghxkzh is null");
            return (Criteria) this;
        }

        public Criteria andGhxkzhIsNotNull() {
            addCriterion("ghxkzh is not null");
            return (Criteria) this;
        }

        public Criteria andGhxkzhEqualTo(String value) {
            addCriterion("ghxkzh =", value, "ghxkzh");
            return (Criteria) this;
        }

        public Criteria andGhxkzhNotEqualTo(String value) {
            addCriterion("ghxkzh <>", value, "ghxkzh");
            return (Criteria) this;
        }

        public Criteria andGhxkzhGreaterThan(String value) {
            addCriterion("ghxkzh >", value, "ghxkzh");
            return (Criteria) this;
        }

        public Criteria andGhxkzhGreaterThanOrEqualTo(String value) {
            addCriterion("ghxkzh >=", value, "ghxkzh");
            return (Criteria) this;
        }

        public Criteria andGhxkzhLessThan(String value) {
            addCriterion("ghxkzh <", value, "ghxkzh");
            return (Criteria) this;
        }

        public Criteria andGhxkzhLessThanOrEqualTo(String value) {
            addCriterion("ghxkzh <=", value, "ghxkzh");
            return (Criteria) this;
        }

        public Criteria andGhxkzhLike(String value) {
            addCriterion("ghxkzh like", value, "ghxkzh");
            return (Criteria) this;
        }

        public Criteria andGhxkzhNotLike(String value) {
            addCriterion("ghxkzh not like", value, "ghxkzh");
            return (Criteria) this;
        }

        public Criteria andGhxkzhIn(List<String> values) {
            addCriterion("ghxkzh in", values, "ghxkzh");
            return (Criteria) this;
        }

        public Criteria andGhxkzhNotIn(List<String> values) {
            addCriterion("ghxkzh not in", values, "ghxkzh");
            return (Criteria) this;
        }

        public Criteria andGhxkzhBetween(String value1, String value2) {
            addCriterion("ghxkzh between", value1, value2, "ghxkzh");
            return (Criteria) this;
        }

        public Criteria andGhxkzhNotBetween(String value1, String value2) {
            addCriterion("ghxkzh not between", value1, value2, "ghxkzh");
            return (Criteria) this;
        }

        public Criteria andJzjgIsNull() {
            addCriterion("jzjg is null");
            return (Criteria) this;
        }

        public Criteria andJzjgIsNotNull() {
            addCriterion("jzjg is not null");
            return (Criteria) this;
        }

        public Criteria andJzjgEqualTo(String value) {
            addCriterion("jzjg =", value, "jzjg");
            return (Criteria) this;
        }

        public Criteria andJzjgNotEqualTo(String value) {
            addCriterion("jzjg <>", value, "jzjg");
            return (Criteria) this;
        }

        public Criteria andJzjgGreaterThan(String value) {
            addCriterion("jzjg >", value, "jzjg");
            return (Criteria) this;
        }

        public Criteria andJzjgGreaterThanOrEqualTo(String value) {
            addCriterion("jzjg >=", value, "jzjg");
            return (Criteria) this;
        }

        public Criteria andJzjgLessThan(String value) {
            addCriterion("jzjg <", value, "jzjg");
            return (Criteria) this;
        }

        public Criteria andJzjgLessThanOrEqualTo(String value) {
            addCriterion("jzjg <=", value, "jzjg");
            return (Criteria) this;
        }

        public Criteria andJzjgLike(String value) {
            addCriterion("jzjg like", value, "jzjg");
            return (Criteria) this;
        }

        public Criteria andJzjgNotLike(String value) {
            addCriterion("jzjg not like", value, "jzjg");
            return (Criteria) this;
        }

        public Criteria andJzjgIn(List<String> values) {
            addCriterion("jzjg in", values, "jzjg");
            return (Criteria) this;
        }

        public Criteria andJzjgNotIn(List<String> values) {
            addCriterion("jzjg not in", values, "jzjg");
            return (Criteria) this;
        }

        public Criteria andJzjgBetween(String value1, String value2) {
            addCriterion("jzjg between", value1, value2, "jzjg");
            return (Criteria) this;
        }

        public Criteria andJzjgNotBetween(String value1, String value2) {
            addCriterion("jzjg not between", value1, value2, "jzjg");
            return (Criteria) this;
        }

        public Criteria andZcsIsNull() {
            addCriterion("zcs is null");
            return (Criteria) this;
        }

        public Criteria andZcsIsNotNull() {
            addCriterion("zcs is not null");
            return (Criteria) this;
        }

        public Criteria andZcsEqualTo(Integer value) {
            addCriterion("zcs =", value, "zcs");
            return (Criteria) this;
        }

        public Criteria andZcsNotEqualTo(Integer value) {
            addCriterion("zcs <>", value, "zcs");
            return (Criteria) this;
        }

        public Criteria andZcsGreaterThan(Integer value) {
            addCriterion("zcs >", value, "zcs");
            return (Criteria) this;
        }

        public Criteria andZcsGreaterThanOrEqualTo(Integer value) {
            addCriterion("zcs >=", value, "zcs");
            return (Criteria) this;
        }

        public Criteria andZcsLessThan(Integer value) {
            addCriterion("zcs <", value, "zcs");
            return (Criteria) this;
        }

        public Criteria andZcsLessThanOrEqualTo(Integer value) {
            addCriterion("zcs <=", value, "zcs");
            return (Criteria) this;
        }

        public Criteria andZcsIn(List<Integer> values) {
            addCriterion("zcs in", values, "zcs");
            return (Criteria) this;
        }

        public Criteria andZcsNotIn(List<Integer> values) {
            addCriterion("zcs not in", values, "zcs");
            return (Criteria) this;
        }

        public Criteria andZcsBetween(Integer value1, Integer value2) {
            addCriterion("zcs between", value1, value2, "zcs");
            return (Criteria) this;
        }

        public Criteria andZcsNotBetween(Integer value1, Integer value2) {
            addCriterion("zcs not between", value1, value2, "zcs");
            return (Criteria) this;
        }

        public Criteria andDxcsIsNull() {
            addCriterion("dxcs is null");
            return (Criteria) this;
        }

        public Criteria andDxcsIsNotNull() {
            addCriterion("dxcs is not null");
            return (Criteria) this;
        }

        public Criteria andDxcsEqualTo(Integer value) {
            addCriterion("dxcs =", value, "dxcs");
            return (Criteria) this;
        }

        public Criteria andDxcsNotEqualTo(Integer value) {
            addCriterion("dxcs <>", value, "dxcs");
            return (Criteria) this;
        }

        public Criteria andDxcsGreaterThan(Integer value) {
            addCriterion("dxcs >", value, "dxcs");
            return (Criteria) this;
        }

        public Criteria andDxcsGreaterThanOrEqualTo(Integer value) {
            addCriterion("dxcs >=", value, "dxcs");
            return (Criteria) this;
        }

        public Criteria andDxcsLessThan(Integer value) {
            addCriterion("dxcs <", value, "dxcs");
            return (Criteria) this;
        }

        public Criteria andDxcsLessThanOrEqualTo(Integer value) {
            addCriterion("dxcs <=", value, "dxcs");
            return (Criteria) this;
        }

        public Criteria andDxcsIn(List<Integer> values) {
            addCriterion("dxcs in", values, "dxcs");
            return (Criteria) this;
        }

        public Criteria andDxcsNotIn(List<Integer> values) {
            addCriterion("dxcs not in", values, "dxcs");
            return (Criteria) this;
        }

        public Criteria andDxcsBetween(Integer value1, Integer value2) {
            addCriterion("dxcs between", value1, value2, "dxcs");
            return (Criteria) this;
        }

        public Criteria andDxcsNotBetween(Integer value1, Integer value2) {
            addCriterion("dxcs not between", value1, value2, "dxcs");
            return (Criteria) this;
        }

        public Criteria andDscsIsNull() {
            addCriterion("dscs is null");
            return (Criteria) this;
        }

        public Criteria andDscsIsNotNull() {
            addCriterion("dscs is not null");
            return (Criteria) this;
        }

        public Criteria andDscsEqualTo(Integer value) {
            addCriterion("dscs =", value, "dscs");
            return (Criteria) this;
        }

        public Criteria andDscsNotEqualTo(Integer value) {
            addCriterion("dscs <>", value, "dscs");
            return (Criteria) this;
        }

        public Criteria andDscsGreaterThan(Integer value) {
            addCriterion("dscs >", value, "dscs");
            return (Criteria) this;
        }

        public Criteria andDscsGreaterThanOrEqualTo(Integer value) {
            addCriterion("dscs >=", value, "dscs");
            return (Criteria) this;
        }

        public Criteria andDscsLessThan(Integer value) {
            addCriterion("dscs <", value, "dscs");
            return (Criteria) this;
        }

        public Criteria andDscsLessThanOrEqualTo(Integer value) {
            addCriterion("dscs <=", value, "dscs");
            return (Criteria) this;
        }

        public Criteria andDscsIn(List<Integer> values) {
            addCriterion("dscs in", values, "dscs");
            return (Criteria) this;
        }

        public Criteria andDscsNotIn(List<Integer> values) {
            addCriterion("dscs not in", values, "dscs");
            return (Criteria) this;
        }

        public Criteria andDscsBetween(Integer value1, Integer value2) {
            addCriterion("dscs between", value1, value2, "dscs");
            return (Criteria) this;
        }

        public Criteria andDscsNotBetween(Integer value1, Integer value2) {
            addCriterion("dscs not between", value1, value2, "dscs");
            return (Criteria) this;
        }

        public Criteria andGhytIsNull() {
            addCriterion("ghyt is null");
            return (Criteria) this;
        }

        public Criteria andGhytIsNotNull() {
            addCriterion("ghyt is not null");
            return (Criteria) this;
        }

        public Criteria andGhytEqualTo(String value) {
            addCriterion("ghyt =", value, "ghyt");
            return (Criteria) this;
        }

        public Criteria andGhytNotEqualTo(String value) {
            addCriterion("ghyt <>", value, "ghyt");
            return (Criteria) this;
        }

        public Criteria andGhytGreaterThan(String value) {
            addCriterion("ghyt >", value, "ghyt");
            return (Criteria) this;
        }

        public Criteria andGhytGreaterThanOrEqualTo(String value) {
            addCriterion("ghyt >=", value, "ghyt");
            return (Criteria) this;
        }

        public Criteria andGhytLessThan(String value) {
            addCriterion("ghyt <", value, "ghyt");
            return (Criteria) this;
        }

        public Criteria andGhytLessThanOrEqualTo(String value) {
            addCriterion("ghyt <=", value, "ghyt");
            return (Criteria) this;
        }

        public Criteria andGhytLike(String value) {
            addCriterion("ghyt like", value, "ghyt");
            return (Criteria) this;
        }

        public Criteria andGhytNotLike(String value) {
            addCriterion("ghyt not like", value, "ghyt");
            return (Criteria) this;
        }

        public Criteria andGhytIn(List<String> values) {
            addCriterion("ghyt in", values, "ghyt");
            return (Criteria) this;
        }

        public Criteria andGhytNotIn(List<String> values) {
            addCriterion("ghyt not in", values, "ghyt");
            return (Criteria) this;
        }

        public Criteria andGhytBetween(String value1, String value2) {
            addCriterion("ghyt between", value1, value2, "ghyt");
            return (Criteria) this;
        }

        public Criteria andGhytNotBetween(String value1, String value2) {
            addCriterion("ghyt not between", value1, value2, "ghyt");
            return (Criteria) this;
        }

        public Criteria andZjzmjIsNull() {
            addCriterion("zjzmj is null");
            return (Criteria) this;
        }

        public Criteria andZjzmjIsNotNull() {
            addCriterion("zjzmj is not null");
            return (Criteria) this;
        }

        public Criteria andZjzmjEqualTo(Double value) {
            addCriterion("zjzmj =", value, "zjzmj");
            return (Criteria) this;
        }

        public Criteria andZjzmjNotEqualTo(Double value) {
            addCriterion("zjzmj <>", value, "zjzmj");
            return (Criteria) this;
        }

        public Criteria andZjzmjGreaterThan(Double value) {
            addCriterion("zjzmj >", value, "zjzmj");
            return (Criteria) this;
        }

        public Criteria andZjzmjGreaterThanOrEqualTo(Double value) {
            addCriterion("zjzmj >=", value, "zjzmj");
            return (Criteria) this;
        }

        public Criteria andZjzmjLessThan(Double value) {
            addCriterion("zjzmj <", value, "zjzmj");
            return (Criteria) this;
        }

        public Criteria andZjzmjLessThanOrEqualTo(Double value) {
            addCriterion("zjzmj <=", value, "zjzmj");
            return (Criteria) this;
        }

        public Criteria andZjzmjIn(List<Double> values) {
            addCriterion("zjzmj in", values, "zjzmj");
            return (Criteria) this;
        }

        public Criteria andZjzmjNotIn(List<Double> values) {
            addCriterion("zjzmj not in", values, "zjzmj");
            return (Criteria) this;
        }

        public Criteria andZjzmjBetween(Double value1, Double value2) {
            addCriterion("zjzmj between", value1, value2, "zjzmj");
            return (Criteria) this;
        }

        public Criteria andZjzmjNotBetween(Double value1, Double value2) {
            addCriterion("zjzmj not between", value1, value2, "zjzmj");
            return (Criteria) this;
        }

        public Criteria andXmzlIsNull() {
            addCriterion("xmzl is null");
            return (Criteria) this;
        }

        public Criteria andXmzlIsNotNull() {
            addCriterion("xmzl is not null");
            return (Criteria) this;
        }

        public Criteria andXmzlEqualTo(String value) {
            addCriterion("xmzl =", value, "xmzl");
            return (Criteria) this;
        }

        public Criteria andXmzlNotEqualTo(String value) {
            addCriterion("xmzl <>", value, "xmzl");
            return (Criteria) this;
        }

        public Criteria andXmzlGreaterThan(String value) {
            addCriterion("xmzl >", value, "xmzl");
            return (Criteria) this;
        }

        public Criteria andXmzlGreaterThanOrEqualTo(String value) {
            addCriterion("xmzl >=", value, "xmzl");
            return (Criteria) this;
        }

        public Criteria andXmzlLessThan(String value) {
            addCriterion("xmzl <", value, "xmzl");
            return (Criteria) this;
        }

        public Criteria andXmzlLessThanOrEqualTo(String value) {
            addCriterion("xmzl <=", value, "xmzl");
            return (Criteria) this;
        }

        public Criteria andXmzlLike(String value) {
            addCriterion("xmzl like", value, "xmzl");
            return (Criteria) this;
        }

        public Criteria andXmzlNotLike(String value) {
            addCriterion("xmzl not like", value, "xmzl");
            return (Criteria) this;
        }

        public Criteria andXmzlIn(List<String> values) {
            addCriterion("xmzl in", values, "xmzl");
            return (Criteria) this;
        }

        public Criteria andXmzlNotIn(List<String> values) {
            addCriterion("xmzl not in", values, "xmzl");
            return (Criteria) this;
        }

        public Criteria andXmzlBetween(String value1, String value2) {
            addCriterion("xmzl between", value1, value2, "xmzl");
            return (Criteria) this;
        }

        public Criteria andXmzlNotBetween(String value1, String value2) {
            addCriterion("xmzl not between", value1, value2, "xmzl");
            return (Criteria) this;
        }

        public Criteria andXmbhIsNull() {
            addCriterion("xmbh is null");
            return (Criteria) this;
        }

        public Criteria andXmbhIsNotNull() {
            addCriterion("xmbh is not null");
            return (Criteria) this;
        }

        public Criteria andXmbhEqualTo(String value) {
            addCriterion("xmbh =", value, "xmbh");
            return (Criteria) this;
        }

        public Criteria andXmbhNotEqualTo(String value) {
            addCriterion("xmbh <>", value, "xmbh");
            return (Criteria) this;
        }

        public Criteria andXmbhGreaterThan(String value) {
            addCriterion("xmbh >", value, "xmbh");
            return (Criteria) this;
        }

        public Criteria andXmbhGreaterThanOrEqualTo(String value) {
            addCriterion("xmbh >=", value, "xmbh");
            return (Criteria) this;
        }

        public Criteria andXmbhLessThan(String value) {
            addCriterion("xmbh <", value, "xmbh");
            return (Criteria) this;
        }

        public Criteria andXmbhLessThanOrEqualTo(String value) {
            addCriterion("xmbh <=", value, "xmbh");
            return (Criteria) this;
        }

        public Criteria andXmbhLike(String value) {
            addCriterion("xmbh like", value, "xmbh");
            return (Criteria) this;
        }

        public Criteria andXmbhNotLike(String value) {
            addCriterion("xmbh not like", value, "xmbh");
            return (Criteria) this;
        }

        public Criteria andXmbhIn(List<String> values) {
            addCriterion("xmbh in", values, "xmbh");
            return (Criteria) this;
        }

        public Criteria andXmbhNotIn(List<String> values) {
            addCriterion("xmbh not in", values, "xmbh");
            return (Criteria) this;
        }

        public Criteria andXmbhBetween(String value1, String value2) {
            addCriterion("xmbh between", value1, value2, "xmbh");
            return (Criteria) this;
        }

        public Criteria andXmbhNotBetween(String value1, String value2) {
            addCriterion("xmbh not between", value1, value2, "xmbh");
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