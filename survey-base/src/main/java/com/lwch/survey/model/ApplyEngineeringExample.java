package com.lwch.survey.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ApplyEngineeringExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ApplyEngineeringExample() {
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

        public Criteria andRjlIsNull() {
            addCriterion("rjl is null");
            return (Criteria) this;
        }

        public Criteria andRjlIsNotNull() {
            addCriterion("rjl is not null");
            return (Criteria) this;
        }

        public Criteria andRjlEqualTo(String value) {
            addCriterion("rjl =", value, "rjl");
            return (Criteria) this;
        }

        public Criteria andRjlNotEqualTo(String value) {
            addCriterion("rjl <>", value, "rjl");
            return (Criteria) this;
        }

        public Criteria andRjlGreaterThan(String value) {
            addCriterion("rjl >", value, "rjl");
            return (Criteria) this;
        }

        public Criteria andRjlGreaterThanOrEqualTo(String value) {
            addCriterion("rjl >=", value, "rjl");
            return (Criteria) this;
        }

        public Criteria andRjlLessThan(String value) {
            addCriterion("rjl <", value, "rjl");
            return (Criteria) this;
        }

        public Criteria andRjlLessThanOrEqualTo(String value) {
            addCriterion("rjl <=", value, "rjl");
            return (Criteria) this;
        }

        public Criteria andRjlLike(String value) {
            addCriterion("rjl like", value, "rjl");
            return (Criteria) this;
        }

        public Criteria andRjlNotLike(String value) {
            addCriterion("rjl not like", value, "rjl");
            return (Criteria) this;
        }

        public Criteria andRjlIn(List<String> values) {
            addCriterion("rjl in", values, "rjl");
            return (Criteria) this;
        }

        public Criteria andRjlNotIn(List<String> values) {
            addCriterion("rjl not in", values, "rjl");
            return (Criteria) this;
        }

        public Criteria andRjlBetween(String value1, String value2) {
            addCriterion("rjl between", value1, value2, "rjl");
            return (Criteria) this;
        }

        public Criteria andRjlNotBetween(String value1, String value2) {
            addCriterion("rjl not between", value1, value2, "rjl");
            return (Criteria) this;
        }

        public Criteria andJzmdIsNull() {
            addCriterion("jzmd is null");
            return (Criteria) this;
        }

        public Criteria andJzmdIsNotNull() {
            addCriterion("jzmd is not null");
            return (Criteria) this;
        }

        public Criteria andJzmdEqualTo(String value) {
            addCriterion("jzmd =", value, "jzmd");
            return (Criteria) this;
        }

        public Criteria andJzmdNotEqualTo(String value) {
            addCriterion("jzmd <>", value, "jzmd");
            return (Criteria) this;
        }

        public Criteria andJzmdGreaterThan(String value) {
            addCriterion("jzmd >", value, "jzmd");
            return (Criteria) this;
        }

        public Criteria andJzmdGreaterThanOrEqualTo(String value) {
            addCriterion("jzmd >=", value, "jzmd");
            return (Criteria) this;
        }

        public Criteria andJzmdLessThan(String value) {
            addCriterion("jzmd <", value, "jzmd");
            return (Criteria) this;
        }

        public Criteria andJzmdLessThanOrEqualTo(String value) {
            addCriterion("jzmd <=", value, "jzmd");
            return (Criteria) this;
        }

        public Criteria andJzmdLike(String value) {
            addCriterion("jzmd like", value, "jzmd");
            return (Criteria) this;
        }

        public Criteria andJzmdNotLike(String value) {
            addCriterion("jzmd not like", value, "jzmd");
            return (Criteria) this;
        }

        public Criteria andJzmdIn(List<String> values) {
            addCriterion("jzmd in", values, "jzmd");
            return (Criteria) this;
        }

        public Criteria andJzmdNotIn(List<String> values) {
            addCriterion("jzmd not in", values, "jzmd");
            return (Criteria) this;
        }

        public Criteria andJzmdBetween(String value1, String value2) {
            addCriterion("jzmd between", value1, value2, "jzmd");
            return (Criteria) this;
        }

        public Criteria andJzmdNotBetween(String value1, String value2) {
            addCriterion("jzmd not between", value1, value2, "jzmd");
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

        public Criteria andJrjzmjIsNull() {
            addCriterion("jrjzmj is null");
            return (Criteria) this;
        }

        public Criteria andJrjzmjIsNotNull() {
            addCriterion("jrjzmj is not null");
            return (Criteria) this;
        }

        public Criteria andJrjzmjEqualTo(Double value) {
            addCriterion("jrjzmj =", value, "jrjzmj");
            return (Criteria) this;
        }

        public Criteria andJrjzmjNotEqualTo(Double value) {
            addCriterion("jrjzmj <>", value, "jrjzmj");
            return (Criteria) this;
        }

        public Criteria andJrjzmjGreaterThan(Double value) {
            addCriterion("jrjzmj >", value, "jrjzmj");
            return (Criteria) this;
        }

        public Criteria andJrjzmjGreaterThanOrEqualTo(Double value) {
            addCriterion("jrjzmj >=", value, "jrjzmj");
            return (Criteria) this;
        }

        public Criteria andJrjzmjLessThan(Double value) {
            addCriterion("jrjzmj <", value, "jrjzmj");
            return (Criteria) this;
        }

        public Criteria andJrjzmjLessThanOrEqualTo(Double value) {
            addCriterion("jrjzmj <=", value, "jrjzmj");
            return (Criteria) this;
        }

        public Criteria andJrjzmjIn(List<Double> values) {
            addCriterion("jrjzmj in", values, "jrjzmj");
            return (Criteria) this;
        }

        public Criteria andJrjzmjNotIn(List<Double> values) {
            addCriterion("jrjzmj not in", values, "jrjzmj");
            return (Criteria) this;
        }

        public Criteria andJrjzmjBetween(Double value1, Double value2) {
            addCriterion("jrjzmj between", value1, value2, "jrjzmj");
            return (Criteria) this;
        }

        public Criteria andJrjzmjNotBetween(Double value1, Double value2) {
            addCriterion("jrjzmj not between", value1, value2, "jrjzmj");
            return (Criteria) this;
        }

        public Criteria andJzzgdIsNull() {
            addCriterion("jzzgd is null");
            return (Criteria) this;
        }

        public Criteria andJzzgdIsNotNull() {
            addCriterion("jzzgd is not null");
            return (Criteria) this;
        }

        public Criteria andJzzgdEqualTo(Integer value) {
            addCriterion("jzzgd =", value, "jzzgd");
            return (Criteria) this;
        }

        public Criteria andJzzgdNotEqualTo(Integer value) {
            addCriterion("jzzgd <>", value, "jzzgd");
            return (Criteria) this;
        }

        public Criteria andJzzgdGreaterThan(Integer value) {
            addCriterion("jzzgd >", value, "jzzgd");
            return (Criteria) this;
        }

        public Criteria andJzzgdGreaterThanOrEqualTo(Integer value) {
            addCriterion("jzzgd >=", value, "jzzgd");
            return (Criteria) this;
        }

        public Criteria andJzzgdLessThan(Integer value) {
            addCriterion("jzzgd <", value, "jzzgd");
            return (Criteria) this;
        }

        public Criteria andJzzgdLessThanOrEqualTo(Integer value) {
            addCriterion("jzzgd <=", value, "jzzgd");
            return (Criteria) this;
        }

        public Criteria andJzzgdIn(List<Integer> values) {
            addCriterion("jzzgd in", values, "jzzgd");
            return (Criteria) this;
        }

        public Criteria andJzzgdNotIn(List<Integer> values) {
            addCriterion("jzzgd not in", values, "jzzgd");
            return (Criteria) this;
        }

        public Criteria andJzzgdBetween(Integer value1, Integer value2) {
            addCriterion("jzzgd between", value1, value2, "jzzgd");
            return (Criteria) this;
        }

        public Criteria andJzzgdNotBetween(Integer value1, Integer value2) {
            addCriterion("jzzgd not between", value1, value2, "jzzgd");
            return (Criteria) this;
        }

        public Criteria andCgIsNull() {
            addCriterion("cg is null");
            return (Criteria) this;
        }

        public Criteria andCgIsNotNull() {
            addCriterion("cg is not null");
            return (Criteria) this;
        }

        public Criteria andCgEqualTo(Double value) {
            addCriterion("cg =", value, "cg");
            return (Criteria) this;
        }

        public Criteria andCgNotEqualTo(Double value) {
            addCriterion("cg <>", value, "cg");
            return (Criteria) this;
        }

        public Criteria andCgGreaterThan(Double value) {
            addCriterion("cg >", value, "cg");
            return (Criteria) this;
        }

        public Criteria andCgGreaterThanOrEqualTo(Double value) {
            addCriterion("cg >=", value, "cg");
            return (Criteria) this;
        }

        public Criteria andCgLessThan(Double value) {
            addCriterion("cg <", value, "cg");
            return (Criteria) this;
        }

        public Criteria andCgLessThanOrEqualTo(Double value) {
            addCriterion("cg <=", value, "cg");
            return (Criteria) this;
        }

        public Criteria andCgIn(List<Double> values) {
            addCriterion("cg in", values, "cg");
            return (Criteria) this;
        }

        public Criteria andCgNotIn(List<Double> values) {
            addCriterion("cg not in", values, "cg");
            return (Criteria) this;
        }

        public Criteria andCgBetween(Double value1, Double value2) {
            addCriterion("cg between", value1, value2, "cg");
            return (Criteria) this;
        }

        public Criteria andCgNotBetween(Double value1, Double value2) {
            addCriterion("cg not between", value1, value2, "cg");
            return (Criteria) this;
        }

        public Criteria andZflbgIsNull() {
            addCriterion("zflbg is null");
            return (Criteria) this;
        }

        public Criteria andZflbgIsNotNull() {
            addCriterion("zflbg is not null");
            return (Criteria) this;
        }

        public Criteria andZflbgEqualTo(Double value) {
            addCriterion("zflbg =", value, "zflbg");
            return (Criteria) this;
        }

        public Criteria andZflbgNotEqualTo(Double value) {
            addCriterion("zflbg <>", value, "zflbg");
            return (Criteria) this;
        }

        public Criteria andZflbgGreaterThan(Double value) {
            addCriterion("zflbg >", value, "zflbg");
            return (Criteria) this;
        }

        public Criteria andZflbgGreaterThanOrEqualTo(Double value) {
            addCriterion("zflbg >=", value, "zflbg");
            return (Criteria) this;
        }

        public Criteria andZflbgLessThan(Double value) {
            addCriterion("zflbg <", value, "zflbg");
            return (Criteria) this;
        }

        public Criteria andZflbgLessThanOrEqualTo(Double value) {
            addCriterion("zflbg <=", value, "zflbg");
            return (Criteria) this;
        }

        public Criteria andZflbgIn(List<Double> values) {
            addCriterion("zflbg in", values, "zflbg");
            return (Criteria) this;
        }

        public Criteria andZflbgNotIn(List<Double> values) {
            addCriterion("zflbg not in", values, "zflbg");
            return (Criteria) this;
        }

        public Criteria andZflbgBetween(Double value1, Double value2) {
            addCriterion("zflbg between", value1, value2, "zflbg");
            return (Criteria) this;
        }

        public Criteria andZflbgNotBetween(Double value1, Double value2) {
            addCriterion("zflbg not between", value1, value2, "zflbg");
            return (Criteria) this;
        }

        public Criteria andSnwdpbgIsNull() {
            addCriterion("snwdpbg is null");
            return (Criteria) this;
        }

        public Criteria andSnwdpbgIsNotNull() {
            addCriterion("snwdpbg is not null");
            return (Criteria) this;
        }

        public Criteria andSnwdpbgEqualTo(Double value) {
            addCriterion("snwdpbg =", value, "snwdpbg");
            return (Criteria) this;
        }

        public Criteria andSnwdpbgNotEqualTo(Double value) {
            addCriterion("snwdpbg <>", value, "snwdpbg");
            return (Criteria) this;
        }

        public Criteria andSnwdpbgGreaterThan(Double value) {
            addCriterion("snwdpbg >", value, "snwdpbg");
            return (Criteria) this;
        }

        public Criteria andSnwdpbgGreaterThanOrEqualTo(Double value) {
            addCriterion("snwdpbg >=", value, "snwdpbg");
            return (Criteria) this;
        }

        public Criteria andSnwdpbgLessThan(Double value) {
            addCriterion("snwdpbg <", value, "snwdpbg");
            return (Criteria) this;
        }

        public Criteria andSnwdpbgLessThanOrEqualTo(Double value) {
            addCriterion("snwdpbg <=", value, "snwdpbg");
            return (Criteria) this;
        }

        public Criteria andSnwdpbgIn(List<Double> values) {
            addCriterion("snwdpbg in", values, "snwdpbg");
            return (Criteria) this;
        }

        public Criteria andSnwdpbgNotIn(List<Double> values) {
            addCriterion("snwdpbg not in", values, "snwdpbg");
            return (Criteria) this;
        }

        public Criteria andSnwdpbgBetween(Double value1, Double value2) {
            addCriterion("snwdpbg between", value1, value2, "snwdpbg");
            return (Criteria) this;
        }

        public Criteria andSnwdpbgNotBetween(Double value1, Double value2) {
            addCriterion("snwdpbg not between", value1, value2, "snwdpbg");
            return (Criteria) this;
        }

        public Criteria andLmscczIsNull() {
            addCriterion("lmsccz is null");
            return (Criteria) this;
        }

        public Criteria andLmscczIsNotNull() {
            addCriterion("lmsccz is not null");
            return (Criteria) this;
        }

        public Criteria andLmscczEqualTo(String value) {
            addCriterion("lmsccz =", value, "lmsccz");
            return (Criteria) this;
        }

        public Criteria andLmscczNotEqualTo(String value) {
            addCriterion("lmsccz <>", value, "lmsccz");
            return (Criteria) this;
        }

        public Criteria andLmscczGreaterThan(String value) {
            addCriterion("lmsccz >", value, "lmsccz");
            return (Criteria) this;
        }

        public Criteria andLmscczGreaterThanOrEqualTo(String value) {
            addCriterion("lmsccz >=", value, "lmsccz");
            return (Criteria) this;
        }

        public Criteria andLmscczLessThan(String value) {
            addCriterion("lmsccz <", value, "lmsccz");
            return (Criteria) this;
        }

        public Criteria andLmscczLessThanOrEqualTo(String value) {
            addCriterion("lmsccz <=", value, "lmsccz");
            return (Criteria) this;
        }

        public Criteria andLmscczLike(String value) {
            addCriterion("lmsccz like", value, "lmsccz");
            return (Criteria) this;
        }

        public Criteria andLmscczNotLike(String value) {
            addCriterion("lmsccz not like", value, "lmsccz");
            return (Criteria) this;
        }

        public Criteria andLmscczIn(List<String> values) {
            addCriterion("lmsccz in", values, "lmsccz");
            return (Criteria) this;
        }

        public Criteria andLmscczNotIn(List<String> values) {
            addCriterion("lmsccz not in", values, "lmsccz");
            return (Criteria) this;
        }

        public Criteria andLmscczBetween(String value1, String value2) {
            addCriterion("lmsccz between", value1, value2, "lmsccz");
            return (Criteria) this;
        }

        public Criteria andLmscczNotBetween(String value1, String value2) {
            addCriterion("lmsccz not between", value1, value2, "lmsccz");
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