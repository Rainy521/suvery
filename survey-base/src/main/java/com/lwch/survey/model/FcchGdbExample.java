package com.lwch.survey.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FcchGdbExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FcchGdbExample() {
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

        public Criteria andApplyidIsNull() {
            addCriterion("applyId is null");
            return (Criteria) this;
        }

        public Criteria andApplyidIsNotNull() {
            addCriterion("applyId is not null");
            return (Criteria) this;
        }

        public Criteria andApplyidEqualTo(String value) {
            addCriterion("applyId =", value, "applyid");
            return (Criteria) this;
        }

        public Criteria andApplyidNotEqualTo(String value) {
            addCriterion("applyId <>", value, "applyid");
            return (Criteria) this;
        }

        public Criteria andApplyidGreaterThan(String value) {
            addCriterion("applyId >", value, "applyid");
            return (Criteria) this;
        }

        public Criteria andApplyidGreaterThanOrEqualTo(String value) {
            addCriterion("applyId >=", value, "applyid");
            return (Criteria) this;
        }

        public Criteria andApplyidLessThan(String value) {
            addCriterion("applyId <", value, "applyid");
            return (Criteria) this;
        }

        public Criteria andApplyidLessThanOrEqualTo(String value) {
            addCriterion("applyId <=", value, "applyid");
            return (Criteria) this;
        }

        public Criteria andApplyidLike(String value) {
            addCriterion("applyId like", value, "applyid");
            return (Criteria) this;
        }

        public Criteria andApplyidNotLike(String value) {
            addCriterion("applyId not like", value, "applyid");
            return (Criteria) this;
        }

        public Criteria andApplyidIn(List<String> values) {
            addCriterion("applyId in", values, "applyid");
            return (Criteria) this;
        }

        public Criteria andApplyidNotIn(List<String> values) {
            addCriterion("applyId not in", values, "applyid");
            return (Criteria) this;
        }

        public Criteria andApplyidBetween(String value1, String value2) {
            addCriterion("applyId between", value1, value2, "applyid");
            return (Criteria) this;
        }

        public Criteria andApplyidNotBetween(String value1, String value2) {
            addCriterion("applyId not between", value1, value2, "applyid");
            return (Criteria) this;
        }

        public Criteria andPronameIsNull() {
            addCriterion("proName is null");
            return (Criteria) this;
        }

        public Criteria andPronameIsNotNull() {
            addCriterion("proName is not null");
            return (Criteria) this;
        }

        public Criteria andPronameEqualTo(String value) {
            addCriterion("proName =", value, "proname");
            return (Criteria) this;
        }

        public Criteria andPronameNotEqualTo(String value) {
            addCriterion("proName <>", value, "proname");
            return (Criteria) this;
        }

        public Criteria andPronameGreaterThan(String value) {
            addCriterion("proName >", value, "proname");
            return (Criteria) this;
        }

        public Criteria andPronameGreaterThanOrEqualTo(String value) {
            addCriterion("proName >=", value, "proname");
            return (Criteria) this;
        }

        public Criteria andPronameLessThan(String value) {
            addCriterion("proName <", value, "proname");
            return (Criteria) this;
        }

        public Criteria andPronameLessThanOrEqualTo(String value) {
            addCriterion("proName <=", value, "proname");
            return (Criteria) this;
        }

        public Criteria andPronameLike(String value) {
            addCriterion("proName like", value, "proname");
            return (Criteria) this;
        }

        public Criteria andPronameNotLike(String value) {
            addCriterion("proName not like", value, "proname");
            return (Criteria) this;
        }

        public Criteria andPronameIn(List<String> values) {
            addCriterion("proName in", values, "proname");
            return (Criteria) this;
        }

        public Criteria andPronameNotIn(List<String> values) {
            addCriterion("proName not in", values, "proname");
            return (Criteria) this;
        }

        public Criteria andPronameBetween(String value1, String value2) {
            addCriterion("proName between", value1, value2, "proname");
            return (Criteria) this;
        }

        public Criteria andPronameNotBetween(String value1, String value2) {
            addCriterion("proName not between", value1, value2, "proname");
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

        public Criteria andJsdwcodeIsNull() {
            addCriterion("jsdwCode is null");
            return (Criteria) this;
        }

        public Criteria andJsdwcodeIsNotNull() {
            addCriterion("jsdwCode is not null");
            return (Criteria) this;
        }

        public Criteria andJsdwcodeEqualTo(String value) {
            addCriterion("jsdwCode =", value, "jsdwcode");
            return (Criteria) this;
        }

        public Criteria andJsdwcodeNotEqualTo(String value) {
            addCriterion("jsdwCode <>", value, "jsdwcode");
            return (Criteria) this;
        }

        public Criteria andJsdwcodeGreaterThan(String value) {
            addCriterion("jsdwCode >", value, "jsdwcode");
            return (Criteria) this;
        }

        public Criteria andJsdwcodeGreaterThanOrEqualTo(String value) {
            addCriterion("jsdwCode >=", value, "jsdwcode");
            return (Criteria) this;
        }

        public Criteria andJsdwcodeLessThan(String value) {
            addCriterion("jsdwCode <", value, "jsdwcode");
            return (Criteria) this;
        }

        public Criteria andJsdwcodeLessThanOrEqualTo(String value) {
            addCriterion("jsdwCode <=", value, "jsdwcode");
            return (Criteria) this;
        }

        public Criteria andJsdwcodeLike(String value) {
            addCriterion("jsdwCode like", value, "jsdwcode");
            return (Criteria) this;
        }

        public Criteria andJsdwcodeNotLike(String value) {
            addCriterion("jsdwCode not like", value, "jsdwcode");
            return (Criteria) this;
        }

        public Criteria andJsdwcodeIn(List<String> values) {
            addCriterion("jsdwCode in", values, "jsdwcode");
            return (Criteria) this;
        }

        public Criteria andJsdwcodeNotIn(List<String> values) {
            addCriterion("jsdwCode not in", values, "jsdwcode");
            return (Criteria) this;
        }

        public Criteria andJsdwcodeBetween(String value1, String value2) {
            addCriterion("jsdwCode between", value1, value2, "jsdwcode");
            return (Criteria) this;
        }

        public Criteria andJsdwcodeNotBetween(String value1, String value2) {
            addCriterion("jsdwCode not between", value1, value2, "jsdwcode");
            return (Criteria) this;
        }

        public Criteria andLxrIsNull() {
            addCriterion("lxr is null");
            return (Criteria) this;
        }

        public Criteria andLxrIsNotNull() {
            addCriterion("lxr is not null");
            return (Criteria) this;
        }

        public Criteria andLxrEqualTo(String value) {
            addCriterion("lxr =", value, "lxr");
            return (Criteria) this;
        }

        public Criteria andLxrNotEqualTo(String value) {
            addCriterion("lxr <>", value, "lxr");
            return (Criteria) this;
        }

        public Criteria andLxrGreaterThan(String value) {
            addCriterion("lxr >", value, "lxr");
            return (Criteria) this;
        }

        public Criteria andLxrGreaterThanOrEqualTo(String value) {
            addCriterion("lxr >=", value, "lxr");
            return (Criteria) this;
        }

        public Criteria andLxrLessThan(String value) {
            addCriterion("lxr <", value, "lxr");
            return (Criteria) this;
        }

        public Criteria andLxrLessThanOrEqualTo(String value) {
            addCriterion("lxr <=", value, "lxr");
            return (Criteria) this;
        }

        public Criteria andLxrLike(String value) {
            addCriterion("lxr like", value, "lxr");
            return (Criteria) this;
        }

        public Criteria andLxrNotLike(String value) {
            addCriterion("lxr not like", value, "lxr");
            return (Criteria) this;
        }

        public Criteria andLxrIn(List<String> values) {
            addCriterion("lxr in", values, "lxr");
            return (Criteria) this;
        }

        public Criteria andLxrNotIn(List<String> values) {
            addCriterion("lxr not in", values, "lxr");
            return (Criteria) this;
        }

        public Criteria andLxrBetween(String value1, String value2) {
            addCriterion("lxr between", value1, value2, "lxr");
            return (Criteria) this;
        }

        public Criteria andLxrNotBetween(String value1, String value2) {
            addCriterion("lxr not between", value1, value2, "lxr");
            return (Criteria) this;
        }

        public Criteria andLxdhIsNull() {
            addCriterion("lxdh is null");
            return (Criteria) this;
        }

        public Criteria andLxdhIsNotNull() {
            addCriterion("lxdh is not null");
            return (Criteria) this;
        }

        public Criteria andLxdhEqualTo(String value) {
            addCriterion("lxdh =", value, "lxdh");
            return (Criteria) this;
        }

        public Criteria andLxdhNotEqualTo(String value) {
            addCriterion("lxdh <>", value, "lxdh");
            return (Criteria) this;
        }

        public Criteria andLxdhGreaterThan(String value) {
            addCriterion("lxdh >", value, "lxdh");
            return (Criteria) this;
        }

        public Criteria andLxdhGreaterThanOrEqualTo(String value) {
            addCriterion("lxdh >=", value, "lxdh");
            return (Criteria) this;
        }

        public Criteria andLxdhLessThan(String value) {
            addCriterion("lxdh <", value, "lxdh");
            return (Criteria) this;
        }

        public Criteria andLxdhLessThanOrEqualTo(String value) {
            addCriterion("lxdh <=", value, "lxdh");
            return (Criteria) this;
        }

        public Criteria andLxdhLike(String value) {
            addCriterion("lxdh like", value, "lxdh");
            return (Criteria) this;
        }

        public Criteria andLxdhNotLike(String value) {
            addCriterion("lxdh not like", value, "lxdh");
            return (Criteria) this;
        }

        public Criteria andLxdhIn(List<String> values) {
            addCriterion("lxdh in", values, "lxdh");
            return (Criteria) this;
        }

        public Criteria andLxdhNotIn(List<String> values) {
            addCriterion("lxdh not in", values, "lxdh");
            return (Criteria) this;
        }

        public Criteria andLxdhBetween(String value1, String value2) {
            addCriterion("lxdh between", value1, value2, "lxdh");
            return (Criteria) this;
        }

        public Criteria andLxdhNotBetween(String value1, String value2) {
            addCriterion("lxdh not between", value1, value2, "lxdh");
            return (Criteria) this;
        }

        public Criteria andChdwIsNull() {
            addCriterion("chdw is null");
            return (Criteria) this;
        }

        public Criteria andChdwIsNotNull() {
            addCriterion("chdw is not null");
            return (Criteria) this;
        }

        public Criteria andChdwEqualTo(String value) {
            addCriterion("chdw =", value, "chdw");
            return (Criteria) this;
        }

        public Criteria andChdwNotEqualTo(String value) {
            addCriterion("chdw <>", value, "chdw");
            return (Criteria) this;
        }

        public Criteria andChdwGreaterThan(String value) {
            addCriterion("chdw >", value, "chdw");
            return (Criteria) this;
        }

        public Criteria andChdwGreaterThanOrEqualTo(String value) {
            addCriterion("chdw >=", value, "chdw");
            return (Criteria) this;
        }

        public Criteria andChdwLessThan(String value) {
            addCriterion("chdw <", value, "chdw");
            return (Criteria) this;
        }

        public Criteria andChdwLessThanOrEqualTo(String value) {
            addCriterion("chdw <=", value, "chdw");
            return (Criteria) this;
        }

        public Criteria andChdwLike(String value) {
            addCriterion("chdw like", value, "chdw");
            return (Criteria) this;
        }

        public Criteria andChdwNotLike(String value) {
            addCriterion("chdw not like", value, "chdw");
            return (Criteria) this;
        }

        public Criteria andChdwIn(List<String> values) {
            addCriterion("chdw in", values, "chdw");
            return (Criteria) this;
        }

        public Criteria andChdwNotIn(List<String> values) {
            addCriterion("chdw not in", values, "chdw");
            return (Criteria) this;
        }

        public Criteria andChdwBetween(String value1, String value2) {
            addCriterion("chdw between", value1, value2, "chdw");
            return (Criteria) this;
        }

        public Criteria andChdwNotBetween(String value1, String value2) {
            addCriterion("chdw not between", value1, value2, "chdw");
            return (Criteria) this;
        }

        public Criteria andChdwcodeIsNull() {
            addCriterion("chdwCode is null");
            return (Criteria) this;
        }

        public Criteria andChdwcodeIsNotNull() {
            addCriterion("chdwCode is not null");
            return (Criteria) this;
        }

        public Criteria andChdwcodeEqualTo(String value) {
            addCriterion("chdwCode =", value, "chdwcode");
            return (Criteria) this;
        }

        public Criteria andChdwcodeNotEqualTo(String value) {
            addCriterion("chdwCode <>", value, "chdwcode");
            return (Criteria) this;
        }

        public Criteria andChdwcodeGreaterThan(String value) {
            addCriterion("chdwCode >", value, "chdwcode");
            return (Criteria) this;
        }

        public Criteria andChdwcodeGreaterThanOrEqualTo(String value) {
            addCriterion("chdwCode >=", value, "chdwcode");
            return (Criteria) this;
        }

        public Criteria andChdwcodeLessThan(String value) {
            addCriterion("chdwCode <", value, "chdwcode");
            return (Criteria) this;
        }

        public Criteria andChdwcodeLessThanOrEqualTo(String value) {
            addCriterion("chdwCode <=", value, "chdwcode");
            return (Criteria) this;
        }

        public Criteria andChdwcodeLike(String value) {
            addCriterion("chdwCode like", value, "chdwcode");
            return (Criteria) this;
        }

        public Criteria andChdwcodeNotLike(String value) {
            addCriterion("chdwCode not like", value, "chdwcode");
            return (Criteria) this;
        }

        public Criteria andChdwcodeIn(List<String> values) {
            addCriterion("chdwCode in", values, "chdwcode");
            return (Criteria) this;
        }

        public Criteria andChdwcodeNotIn(List<String> values) {
            addCriterion("chdwCode not in", values, "chdwcode");
            return (Criteria) this;
        }

        public Criteria andChdwcodeBetween(String value1, String value2) {
            addCriterion("chdwCode between", value1, value2, "chdwcode");
            return (Criteria) this;
        }

        public Criteria andChdwcodeNotBetween(String value1, String value2) {
            addCriterion("chdwCode not between", value1, value2, "chdwcode");
            return (Criteria) this;
        }

        public Criteria andChdwlxrIsNull() {
            addCriterion("chdwlxr is null");
            return (Criteria) this;
        }

        public Criteria andChdwlxrIsNotNull() {
            addCriterion("chdwlxr is not null");
            return (Criteria) this;
        }

        public Criteria andChdwlxrEqualTo(String value) {
            addCriterion("chdwlxr =", value, "chdwlxr");
            return (Criteria) this;
        }

        public Criteria andChdwlxrNotEqualTo(String value) {
            addCriterion("chdwlxr <>", value, "chdwlxr");
            return (Criteria) this;
        }

        public Criteria andChdwlxrGreaterThan(String value) {
            addCriterion("chdwlxr >", value, "chdwlxr");
            return (Criteria) this;
        }

        public Criteria andChdwlxrGreaterThanOrEqualTo(String value) {
            addCriterion("chdwlxr >=", value, "chdwlxr");
            return (Criteria) this;
        }

        public Criteria andChdwlxrLessThan(String value) {
            addCriterion("chdwlxr <", value, "chdwlxr");
            return (Criteria) this;
        }

        public Criteria andChdwlxrLessThanOrEqualTo(String value) {
            addCriterion("chdwlxr <=", value, "chdwlxr");
            return (Criteria) this;
        }

        public Criteria andChdwlxrLike(String value) {
            addCriterion("chdwlxr like", value, "chdwlxr");
            return (Criteria) this;
        }

        public Criteria andChdwlxrNotLike(String value) {
            addCriterion("chdwlxr not like", value, "chdwlxr");
            return (Criteria) this;
        }

        public Criteria andChdwlxrIn(List<String> values) {
            addCriterion("chdwlxr in", values, "chdwlxr");
            return (Criteria) this;
        }

        public Criteria andChdwlxrNotIn(List<String> values) {
            addCriterion("chdwlxr not in", values, "chdwlxr");
            return (Criteria) this;
        }

        public Criteria andChdwlxrBetween(String value1, String value2) {
            addCriterion("chdwlxr between", value1, value2, "chdwlxr");
            return (Criteria) this;
        }

        public Criteria andChdwlxrNotBetween(String value1, String value2) {
            addCriterion("chdwlxr not between", value1, value2, "chdwlxr");
            return (Criteria) this;
        }

        public Criteria andChdwlxdhIsNull() {
            addCriterion("chdwlxdh is null");
            return (Criteria) this;
        }

        public Criteria andChdwlxdhIsNotNull() {
            addCriterion("chdwlxdh is not null");
            return (Criteria) this;
        }

        public Criteria andChdwlxdhEqualTo(String value) {
            addCriterion("chdwlxdh =", value, "chdwlxdh");
            return (Criteria) this;
        }

        public Criteria andChdwlxdhNotEqualTo(String value) {
            addCriterion("chdwlxdh <>", value, "chdwlxdh");
            return (Criteria) this;
        }

        public Criteria andChdwlxdhGreaterThan(String value) {
            addCriterion("chdwlxdh >", value, "chdwlxdh");
            return (Criteria) this;
        }

        public Criteria andChdwlxdhGreaterThanOrEqualTo(String value) {
            addCriterion("chdwlxdh >=", value, "chdwlxdh");
            return (Criteria) this;
        }

        public Criteria andChdwlxdhLessThan(String value) {
            addCriterion("chdwlxdh <", value, "chdwlxdh");
            return (Criteria) this;
        }

        public Criteria andChdwlxdhLessThanOrEqualTo(String value) {
            addCriterion("chdwlxdh <=", value, "chdwlxdh");
            return (Criteria) this;
        }

        public Criteria andChdwlxdhLike(String value) {
            addCriterion("chdwlxdh like", value, "chdwlxdh");
            return (Criteria) this;
        }

        public Criteria andChdwlxdhNotLike(String value) {
            addCriterion("chdwlxdh not like", value, "chdwlxdh");
            return (Criteria) this;
        }

        public Criteria andChdwlxdhIn(List<String> values) {
            addCriterion("chdwlxdh in", values, "chdwlxdh");
            return (Criteria) this;
        }

        public Criteria andChdwlxdhNotIn(List<String> values) {
            addCriterion("chdwlxdh not in", values, "chdwlxdh");
            return (Criteria) this;
        }

        public Criteria andChdwlxdhBetween(String value1, String value2) {
            addCriterion("chdwlxdh between", value1, value2, "chdwlxdh");
            return (Criteria) this;
        }

        public Criteria andChdwlxdhNotBetween(String value1, String value2) {
            addCriterion("chdwlxdh not between", value1, value2, "chdwlxdh");
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

        public Criteria andZmjIsNull() {
            addCriterion("zmj is null");
            return (Criteria) this;
        }

        public Criteria andZmjIsNotNull() {
            addCriterion("zmj is not null");
            return (Criteria) this;
        }

        public Criteria andZmjEqualTo(Double value) {
            addCriterion("zmj =", value, "zmj");
            return (Criteria) this;
        }

        public Criteria andZmjNotEqualTo(Double value) {
            addCriterion("zmj <>", value, "zmj");
            return (Criteria) this;
        }

        public Criteria andZmjGreaterThan(Double value) {
            addCriterion("zmj >", value, "zmj");
            return (Criteria) this;
        }

        public Criteria andZmjGreaterThanOrEqualTo(Double value) {
            addCriterion("zmj >=", value, "zmj");
            return (Criteria) this;
        }

        public Criteria andZmjLessThan(Double value) {
            addCriterion("zmj <", value, "zmj");
            return (Criteria) this;
        }

        public Criteria andZmjLessThanOrEqualTo(Double value) {
            addCriterion("zmj <=", value, "zmj");
            return (Criteria) this;
        }

        public Criteria andZmjIn(List<Double> values) {
            addCriterion("zmj in", values, "zmj");
            return (Criteria) this;
        }

        public Criteria andZmjNotIn(List<Double> values) {
            addCriterion("zmj not in", values, "zmj");
            return (Criteria) this;
        }

        public Criteria andZmjBetween(Double value1, Double value2) {
            addCriterion("zmj between", value1, value2, "zmj");
            return (Criteria) this;
        }

        public Criteria andZmjNotBetween(Double value1, Double value2) {
            addCriterion("zmj not between", value1, value2, "zmj");
            return (Criteria) this;
        }

        public Criteria andFilesIsNull() {
            addCriterion("files is null");
            return (Criteria) this;
        }

        public Criteria andFilesIsNotNull() {
            addCriterion("files is not null");
            return (Criteria) this;
        }

        public Criteria andFilesEqualTo(String value) {
            addCriterion("files =", value, "files");
            return (Criteria) this;
        }

        public Criteria andFilesNotEqualTo(String value) {
            addCriterion("files <>", value, "files");
            return (Criteria) this;
        }

        public Criteria andFilesGreaterThan(String value) {
            addCriterion("files >", value, "files");
            return (Criteria) this;
        }

        public Criteria andFilesGreaterThanOrEqualTo(String value) {
            addCriterion("files >=", value, "files");
            return (Criteria) this;
        }

        public Criteria andFilesLessThan(String value) {
            addCriterion("files <", value, "files");
            return (Criteria) this;
        }

        public Criteria andFilesLessThanOrEqualTo(String value) {
            addCriterion("files <=", value, "files");
            return (Criteria) this;
        }

        public Criteria andFilesLike(String value) {
            addCriterion("files like", value, "files");
            return (Criteria) this;
        }

        public Criteria andFilesNotLike(String value) {
            addCriterion("files not like", value, "files");
            return (Criteria) this;
        }

        public Criteria andFilesIn(List<String> values) {
            addCriterion("files in", values, "files");
            return (Criteria) this;
        }

        public Criteria andFilesNotIn(List<String> values) {
            addCriterion("files not in", values, "files");
            return (Criteria) this;
        }

        public Criteria andFilesBetween(String value1, String value2) {
            addCriterion("files between", value1, value2, "files");
            return (Criteria) this;
        }

        public Criteria andFilesNotBetween(String value1, String value2) {
            addCriterion("files not between", value1, value2, "files");
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

        public Criteria andLspzxxIsNull() {
            addCriterion("lspzxx is null");
            return (Criteria) this;
        }

        public Criteria andLspzxxIsNotNull() {
            addCriterion("lspzxx is not null");
            return (Criteria) this;
        }

        public Criteria andLspzxxEqualTo(String value) {
            addCriterion("lspzxx =", value, "lspzxx");
            return (Criteria) this;
        }

        public Criteria andLspzxxNotEqualTo(String value) {
            addCriterion("lspzxx <>", value, "lspzxx");
            return (Criteria) this;
        }

        public Criteria andLspzxxGreaterThan(String value) {
            addCriterion("lspzxx >", value, "lspzxx");
            return (Criteria) this;
        }

        public Criteria andLspzxxGreaterThanOrEqualTo(String value) {
            addCriterion("lspzxx >=", value, "lspzxx");
            return (Criteria) this;
        }

        public Criteria andLspzxxLessThan(String value) {
            addCriterion("lspzxx <", value, "lspzxx");
            return (Criteria) this;
        }

        public Criteria andLspzxxLessThanOrEqualTo(String value) {
            addCriterion("lspzxx <=", value, "lspzxx");
            return (Criteria) this;
        }

        public Criteria andLspzxxLike(String value) {
            addCriterion("lspzxx like", value, "lspzxx");
            return (Criteria) this;
        }

        public Criteria andLspzxxNotLike(String value) {
            addCriterion("lspzxx not like", value, "lspzxx");
            return (Criteria) this;
        }

        public Criteria andLspzxxIn(List<String> values) {
            addCriterion("lspzxx in", values, "lspzxx");
            return (Criteria) this;
        }

        public Criteria andLspzxxNotIn(List<String> values) {
            addCriterion("lspzxx not in", values, "lspzxx");
            return (Criteria) this;
        }

        public Criteria andLspzxxBetween(String value1, String value2) {
            addCriterion("lspzxx between", value1, value2, "lspzxx");
            return (Criteria) this;
        }

        public Criteria andLspzxxNotBetween(String value1, String value2) {
            addCriterion("lspzxx not between", value1, value2, "lspzxx");
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

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("updateTime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("updateTime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterion("updateTime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterion("updateTime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterion("updateTime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updateTime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterion("updateTime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("updateTime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterion("updateTime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterion("updateTime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("updateTime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("updateTime not between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andApplytimeIsNull() {
            addCriterion("applyTime is null");
            return (Criteria) this;
        }

        public Criteria andApplytimeIsNotNull() {
            addCriterion("applyTime is not null");
            return (Criteria) this;
        }

        public Criteria andApplytimeEqualTo(Date value) {
            addCriterion("applyTime =", value, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeNotEqualTo(Date value) {
            addCriterion("applyTime <>", value, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeGreaterThan(Date value) {
            addCriterion("applyTime >", value, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeGreaterThanOrEqualTo(Date value) {
            addCriterion("applyTime >=", value, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeLessThan(Date value) {
            addCriterion("applyTime <", value, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeLessThanOrEqualTo(Date value) {
            addCriterion("applyTime <=", value, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeIn(List<Date> values) {
            addCriterion("applyTime in", values, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeNotIn(List<Date> values) {
            addCriterion("applyTime not in", values, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeBetween(Date value1, Date value2) {
            addCriterion("applyTime between", value1, value2, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeNotBetween(Date value1, Date value2) {
            addCriterion("applyTime not between", value1, value2, "applytime");
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

        public Criteria andThcsIsNull() {
            addCriterion("thcs is null");
            return (Criteria) this;
        }

        public Criteria andThcsIsNotNull() {
            addCriterion("thcs is not null");
            return (Criteria) this;
        }

        public Criteria andThcsEqualTo(Integer value) {
            addCriterion("thcs =", value, "thcs");
            return (Criteria) this;
        }

        public Criteria andThcsNotEqualTo(Integer value) {
            addCriterion("thcs <>", value, "thcs");
            return (Criteria) this;
        }

        public Criteria andThcsGreaterThan(Integer value) {
            addCriterion("thcs >", value, "thcs");
            return (Criteria) this;
        }

        public Criteria andThcsGreaterThanOrEqualTo(Integer value) {
            addCriterion("thcs >=", value, "thcs");
            return (Criteria) this;
        }

        public Criteria andThcsLessThan(Integer value) {
            addCriterion("thcs <", value, "thcs");
            return (Criteria) this;
        }

        public Criteria andThcsLessThanOrEqualTo(Integer value) {
            addCriterion("thcs <=", value, "thcs");
            return (Criteria) this;
        }

        public Criteria andThcsIn(List<Integer> values) {
            addCriterion("thcs in", values, "thcs");
            return (Criteria) this;
        }

        public Criteria andThcsNotIn(List<Integer> values) {
            addCriterion("thcs not in", values, "thcs");
            return (Criteria) this;
        }

        public Criteria andThcsBetween(Integer value1, Integer value2) {
            addCriterion("thcs between", value1, value2, "thcs");
            return (Criteria) this;
        }

        public Criteria andThcsNotBetween(Integer value1, Integer value2) {
            addCriterion("thcs not between", value1, value2, "thcs");
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