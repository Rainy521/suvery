package com.lwch.survey.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ApplyCadastreExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ApplyCadastreExample() {
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

        public Criteria andProXmzlIsNull() {
            addCriterion("pro_xmzl is null");
            return (Criteria) this;
        }

        public Criteria andProXmzlIsNotNull() {
            addCriterion("pro_xmzl is not null");
            return (Criteria) this;
        }

        public Criteria andProXmzlEqualTo(String value) {
            addCriterion("pro_xmzl =", value, "proXmzl");
            return (Criteria) this;
        }

        public Criteria andProXmzlNotEqualTo(String value) {
            addCriterion("pro_xmzl <>", value, "proXmzl");
            return (Criteria) this;
        }

        public Criteria andProXmzlGreaterThan(String value) {
            addCriterion("pro_xmzl >", value, "proXmzl");
            return (Criteria) this;
        }

        public Criteria andProXmzlGreaterThanOrEqualTo(String value) {
            addCriterion("pro_xmzl >=", value, "proXmzl");
            return (Criteria) this;
        }

        public Criteria andProXmzlLessThan(String value) {
            addCriterion("pro_xmzl <", value, "proXmzl");
            return (Criteria) this;
        }

        public Criteria andProXmzlLessThanOrEqualTo(String value) {
            addCriterion("pro_xmzl <=", value, "proXmzl");
            return (Criteria) this;
        }

        public Criteria andProXmzlLike(String value) {
            addCriterion("pro_xmzl like", value, "proXmzl");
            return (Criteria) this;
        }

        public Criteria andProXmzlNotLike(String value) {
            addCriterion("pro_xmzl not like", value, "proXmzl");
            return (Criteria) this;
        }

        public Criteria andProXmzlIn(List<String> values) {
            addCriterion("pro_xmzl in", values, "proXmzl");
            return (Criteria) this;
        }

        public Criteria andProXmzlNotIn(List<String> values) {
            addCriterion("pro_xmzl not in", values, "proXmzl");
            return (Criteria) this;
        }

        public Criteria andProXmzlBetween(String value1, String value2) {
            addCriterion("pro_xmzl between", value1, value2, "proXmzl");
            return (Criteria) this;
        }

        public Criteria andProXmzlNotBetween(String value1, String value2) {
            addCriterion("pro_xmzl not between", value1, value2, "proXmzl");
            return (Criteria) this;
        }

        public Criteria andTdsymjIsNull() {
            addCriterion("tdsymj is null");
            return (Criteria) this;
        }

        public Criteria andTdsymjIsNotNull() {
            addCriterion("tdsymj is not null");
            return (Criteria) this;
        }

        public Criteria andTdsymjEqualTo(Double value) {
            addCriterion("tdsymj =", value, "tdsymj");
            return (Criteria) this;
        }

        public Criteria andTdsymjNotEqualTo(Double value) {
            addCriterion("tdsymj <>", value, "tdsymj");
            return (Criteria) this;
        }

        public Criteria andTdsymjGreaterThan(Double value) {
            addCriterion("tdsymj >", value, "tdsymj");
            return (Criteria) this;
        }

        public Criteria andTdsymjGreaterThanOrEqualTo(Double value) {
            addCriterion("tdsymj >=", value, "tdsymj");
            return (Criteria) this;
        }

        public Criteria andTdsymjLessThan(Double value) {
            addCriterion("tdsymj <", value, "tdsymj");
            return (Criteria) this;
        }

        public Criteria andTdsymjLessThanOrEqualTo(Double value) {
            addCriterion("tdsymj <=", value, "tdsymj");
            return (Criteria) this;
        }

        public Criteria andTdsymjIn(List<Double> values) {
            addCriterion("tdsymj in", values, "tdsymj");
            return (Criteria) this;
        }

        public Criteria andTdsymjNotIn(List<Double> values) {
            addCriterion("tdsymj not in", values, "tdsymj");
            return (Criteria) this;
        }

        public Criteria andTdsymjBetween(Double value1, Double value2) {
            addCriterion("tdsymj between", value1, value2, "tdsymj");
            return (Criteria) this;
        }

        public Criteria andTdsymjNotBetween(Double value1, Double value2) {
            addCriterion("tdsymj not between", value1, value2, "tdsymj");
            return (Criteria) this;
        }

        public Criteria andTdytIsNull() {
            addCriterion("tdyt is null");
            return (Criteria) this;
        }

        public Criteria andTdytIsNotNull() {
            addCriterion("tdyt is not null");
            return (Criteria) this;
        }

        public Criteria andTdytEqualTo(String value) {
            addCriterion("tdyt =", value, "tdyt");
            return (Criteria) this;
        }

        public Criteria andTdytNotEqualTo(String value) {
            addCriterion("tdyt <>", value, "tdyt");
            return (Criteria) this;
        }

        public Criteria andTdytGreaterThan(String value) {
            addCriterion("tdyt >", value, "tdyt");
            return (Criteria) this;
        }

        public Criteria andTdytGreaterThanOrEqualTo(String value) {
            addCriterion("tdyt >=", value, "tdyt");
            return (Criteria) this;
        }

        public Criteria andTdytLessThan(String value) {
            addCriterion("tdyt <", value, "tdyt");
            return (Criteria) this;
        }

        public Criteria andTdytLessThanOrEqualTo(String value) {
            addCriterion("tdyt <=", value, "tdyt");
            return (Criteria) this;
        }

        public Criteria andTdytLike(String value) {
            addCriterion("tdyt like", value, "tdyt");
            return (Criteria) this;
        }

        public Criteria andTdytNotLike(String value) {
            addCriterion("tdyt not like", value, "tdyt");
            return (Criteria) this;
        }

        public Criteria andTdytIn(List<String> values) {
            addCriterion("tdyt in", values, "tdyt");
            return (Criteria) this;
        }

        public Criteria andTdytNotIn(List<String> values) {
            addCriterion("tdyt not in", values, "tdyt");
            return (Criteria) this;
        }

        public Criteria andTdytBetween(String value1, String value2) {
            addCriterion("tdyt between", value1, value2, "tdyt");
            return (Criteria) this;
        }

        public Criteria andTdytNotBetween(String value1, String value2) {
            addCriterion("tdyt not between", value1, value2, "tdyt");
            return (Criteria) this;
        }

        public Criteria andTdsyqlxIsNull() {
            addCriterion("tdsyqlx is null");
            return (Criteria) this;
        }

        public Criteria andTdsyqlxIsNotNull() {
            addCriterion("tdsyqlx is not null");
            return (Criteria) this;
        }

        public Criteria andTdsyqlxEqualTo(String value) {
            addCriterion("tdsyqlx =", value, "tdsyqlx");
            return (Criteria) this;
        }

        public Criteria andTdsyqlxNotEqualTo(String value) {
            addCriterion("tdsyqlx <>", value, "tdsyqlx");
            return (Criteria) this;
        }

        public Criteria andTdsyqlxGreaterThan(String value) {
            addCriterion("tdsyqlx >", value, "tdsyqlx");
            return (Criteria) this;
        }

        public Criteria andTdsyqlxGreaterThanOrEqualTo(String value) {
            addCriterion("tdsyqlx >=", value, "tdsyqlx");
            return (Criteria) this;
        }

        public Criteria andTdsyqlxLessThan(String value) {
            addCriterion("tdsyqlx <", value, "tdsyqlx");
            return (Criteria) this;
        }

        public Criteria andTdsyqlxLessThanOrEqualTo(String value) {
            addCriterion("tdsyqlx <=", value, "tdsyqlx");
            return (Criteria) this;
        }

        public Criteria andTdsyqlxLike(String value) {
            addCriterion("tdsyqlx like", value, "tdsyqlx");
            return (Criteria) this;
        }

        public Criteria andTdsyqlxNotLike(String value) {
            addCriterion("tdsyqlx not like", value, "tdsyqlx");
            return (Criteria) this;
        }

        public Criteria andTdsyqlxIn(List<String> values) {
            addCriterion("tdsyqlx in", values, "tdsyqlx");
            return (Criteria) this;
        }

        public Criteria andTdsyqlxNotIn(List<String> values) {
            addCriterion("tdsyqlx not in", values, "tdsyqlx");
            return (Criteria) this;
        }

        public Criteria andTdsyqlxBetween(String value1, String value2) {
            addCriterion("tdsyqlx between", value1, value2, "tdsyqlx");
            return (Criteria) this;
        }

        public Criteria andTdsyqlxNotBetween(String value1, String value2) {
            addCriterion("tdsyqlx not between", value1, value2, "tdsyqlx");
            return (Criteria) this;
        }

        public Criteria andTdsynxIsNull() {
            addCriterion("tdsynx is null");
            return (Criteria) this;
        }

        public Criteria andTdsynxIsNotNull() {
            addCriterion("tdsynx is not null");
            return (Criteria) this;
        }

        public Criteria andTdsynxEqualTo(String value) {
            addCriterion("tdsynx =", value, "tdsynx");
            return (Criteria) this;
        }

        public Criteria andTdsynxNotEqualTo(String value) {
            addCriterion("tdsynx <>", value, "tdsynx");
            return (Criteria) this;
        }

        public Criteria andTdsynxGreaterThan(String value) {
            addCriterion("tdsynx >", value, "tdsynx");
            return (Criteria) this;
        }

        public Criteria andTdsynxGreaterThanOrEqualTo(String value) {
            addCriterion("tdsynx >=", value, "tdsynx");
            return (Criteria) this;
        }

        public Criteria andTdsynxLessThan(String value) {
            addCriterion("tdsynx <", value, "tdsynx");
            return (Criteria) this;
        }

        public Criteria andTdsynxLessThanOrEqualTo(String value) {
            addCriterion("tdsynx <=", value, "tdsynx");
            return (Criteria) this;
        }

        public Criteria andTdsynxLike(String value) {
            addCriterion("tdsynx like", value, "tdsynx");
            return (Criteria) this;
        }

        public Criteria andTdsynxNotLike(String value) {
            addCriterion("tdsynx not like", value, "tdsynx");
            return (Criteria) this;
        }

        public Criteria andTdsynxIn(List<String> values) {
            addCriterion("tdsynx in", values, "tdsynx");
            return (Criteria) this;
        }

        public Criteria andTdsynxNotIn(List<String> values) {
            addCriterion("tdsynx not in", values, "tdsynx");
            return (Criteria) this;
        }

        public Criteria andTdsynxBetween(String value1, String value2) {
            addCriterion("tdsynx between", value1, value2, "tdsynx");
            return (Criteria) this;
        }

        public Criteria andTdsynxNotBetween(String value1, String value2) {
            addCriterion("tdsynx not between", value1, value2, "tdsynx");
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

        public Criteria andJsdwCodeIsNull() {
            addCriterion("jsdw_code is null");
            return (Criteria) this;
        }

        public Criteria andJsdwCodeIsNotNull() {
            addCriterion("jsdw_code is not null");
            return (Criteria) this;
        }

        public Criteria andJsdwCodeEqualTo(String value) {
            addCriterion("jsdw_code =", value, "jsdwCode");
            return (Criteria) this;
        }

        public Criteria andJsdwCodeNotEqualTo(String value) {
            addCriterion("jsdw_code <>", value, "jsdwCode");
            return (Criteria) this;
        }

        public Criteria andJsdwCodeGreaterThan(String value) {
            addCriterion("jsdw_code >", value, "jsdwCode");
            return (Criteria) this;
        }

        public Criteria andJsdwCodeGreaterThanOrEqualTo(String value) {
            addCriterion("jsdw_code >=", value, "jsdwCode");
            return (Criteria) this;
        }

        public Criteria andJsdwCodeLessThan(String value) {
            addCriterion("jsdw_code <", value, "jsdwCode");
            return (Criteria) this;
        }

        public Criteria andJsdwCodeLessThanOrEqualTo(String value) {
            addCriterion("jsdw_code <=", value, "jsdwCode");
            return (Criteria) this;
        }

        public Criteria andJsdwCodeLike(String value) {
            addCriterion("jsdw_code like", value, "jsdwCode");
            return (Criteria) this;
        }

        public Criteria andJsdwCodeNotLike(String value) {
            addCriterion("jsdw_code not like", value, "jsdwCode");
            return (Criteria) this;
        }

        public Criteria andJsdwCodeIn(List<String> values) {
            addCriterion("jsdw_code in", values, "jsdwCode");
            return (Criteria) this;
        }

        public Criteria andJsdwCodeNotIn(List<String> values) {
            addCriterion("jsdw_code not in", values, "jsdwCode");
            return (Criteria) this;
        }

        public Criteria andJsdwCodeBetween(String value1, String value2) {
            addCriterion("jsdw_code between", value1, value2, "jsdwCode");
            return (Criteria) this;
        }

        public Criteria andJsdwCodeNotBetween(String value1, String value2) {
            addCriterion("jsdw_code not between", value1, value2, "jsdwCode");
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

        public Criteria andChdwCodeIsNull() {
            addCriterion("chdw_code is null");
            return (Criteria) this;
        }

        public Criteria andChdwCodeIsNotNull() {
            addCriterion("chdw_code is not null");
            return (Criteria) this;
        }

        public Criteria andChdwCodeEqualTo(String value) {
            addCriterion("chdw_code =", value, "chdwCode");
            return (Criteria) this;
        }

        public Criteria andChdwCodeNotEqualTo(String value) {
            addCriterion("chdw_code <>", value, "chdwCode");
            return (Criteria) this;
        }

        public Criteria andChdwCodeGreaterThan(String value) {
            addCriterion("chdw_code >", value, "chdwCode");
            return (Criteria) this;
        }

        public Criteria andChdwCodeGreaterThanOrEqualTo(String value) {
            addCriterion("chdw_code >=", value, "chdwCode");
            return (Criteria) this;
        }

        public Criteria andChdwCodeLessThan(String value) {
            addCriterion("chdw_code <", value, "chdwCode");
            return (Criteria) this;
        }

        public Criteria andChdwCodeLessThanOrEqualTo(String value) {
            addCriterion("chdw_code <=", value, "chdwCode");
            return (Criteria) this;
        }

        public Criteria andChdwCodeLike(String value) {
            addCriterion("chdw_code like", value, "chdwCode");
            return (Criteria) this;
        }

        public Criteria andChdwCodeNotLike(String value) {
            addCriterion("chdw_code not like", value, "chdwCode");
            return (Criteria) this;
        }

        public Criteria andChdwCodeIn(List<String> values) {
            addCriterion("chdw_code in", values, "chdwCode");
            return (Criteria) this;
        }

        public Criteria andChdwCodeNotIn(List<String> values) {
            addCriterion("chdw_code not in", values, "chdwCode");
            return (Criteria) this;
        }

        public Criteria andChdwCodeBetween(String value1, String value2) {
            addCriterion("chdw_code between", value1, value2, "chdwCode");
            return (Criteria) this;
        }

        public Criteria andChdwCodeNotBetween(String value1, String value2) {
            addCriterion("chdw_code not between", value1, value2, "chdwCode");
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

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
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