package com.lwch.survey.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BuildingGhxkExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BuildingGhxkExample() {
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

        public Criteria andProjectNoIsNull() {
            addCriterion("project_no is null");
            return (Criteria) this;
        }

        public Criteria andProjectNoIsNotNull() {
            addCriterion("project_no is not null");
            return (Criteria) this;
        }

        public Criteria andProjectNoEqualTo(String value) {
            addCriterion("project_no =", value, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoNotEqualTo(String value) {
            addCriterion("project_no <>", value, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoGreaterThan(String value) {
            addCriterion("project_no >", value, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoGreaterThanOrEqualTo(String value) {
            addCriterion("project_no >=", value, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoLessThan(String value) {
            addCriterion("project_no <", value, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoLessThanOrEqualTo(String value) {
            addCriterion("project_no <=", value, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoLike(String value) {
            addCriterion("project_no like", value, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoNotLike(String value) {
            addCriterion("project_no not like", value, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoIn(List<String> values) {
            addCriterion("project_no in", values, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoNotIn(List<String> values) {
            addCriterion("project_no not in", values, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoBetween(String value1, String value2) {
            addCriterion("project_no between", value1, value2, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoNotBetween(String value1, String value2) {
            addCriterion("project_no not between", value1, value2, "projectNo");
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

        public Criteria andLpmcIsNull() {
            addCriterion("lpmc is null");
            return (Criteria) this;
        }

        public Criteria andLpmcIsNotNull() {
            addCriterion("lpmc is not null");
            return (Criteria) this;
        }

        public Criteria andLpmcEqualTo(String value) {
            addCriterion("lpmc =", value, "lpmc");
            return (Criteria) this;
        }

        public Criteria andLpmcNotEqualTo(String value) {
            addCriterion("lpmc <>", value, "lpmc");
            return (Criteria) this;
        }

        public Criteria andLpmcGreaterThan(String value) {
            addCriterion("lpmc >", value, "lpmc");
            return (Criteria) this;
        }

        public Criteria andLpmcGreaterThanOrEqualTo(String value) {
            addCriterion("lpmc >=", value, "lpmc");
            return (Criteria) this;
        }

        public Criteria andLpmcLessThan(String value) {
            addCriterion("lpmc <", value, "lpmc");
            return (Criteria) this;
        }

        public Criteria andLpmcLessThanOrEqualTo(String value) {
            addCriterion("lpmc <=", value, "lpmc");
            return (Criteria) this;
        }

        public Criteria andLpmcLike(String value) {
            addCriterion("lpmc like", value, "lpmc");
            return (Criteria) this;
        }

        public Criteria andLpmcNotLike(String value) {
            addCriterion("lpmc not like", value, "lpmc");
            return (Criteria) this;
        }

        public Criteria andLpmcIn(List<String> values) {
            addCriterion("lpmc in", values, "lpmc");
            return (Criteria) this;
        }

        public Criteria andLpmcNotIn(List<String> values) {
            addCriterion("lpmc not in", values, "lpmc");
            return (Criteria) this;
        }

        public Criteria andLpmcBetween(String value1, String value2) {
            addCriterion("lpmc between", value1, value2, "lpmc");
            return (Criteria) this;
        }

        public Criteria andLpmcNotBetween(String value1, String value2) {
            addCriterion("lpmc not between", value1, value2, "lpmc");
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

        public Criteria andFwlxIsNull() {
            addCriterion("fwlx is null");
            return (Criteria) this;
        }

        public Criteria andFwlxIsNotNull() {
            addCriterion("fwlx is not null");
            return (Criteria) this;
        }

        public Criteria andFwlxEqualTo(String value) {
            addCriterion("fwlx =", value, "fwlx");
            return (Criteria) this;
        }

        public Criteria andFwlxNotEqualTo(String value) {
            addCriterion("fwlx <>", value, "fwlx");
            return (Criteria) this;
        }

        public Criteria andFwlxGreaterThan(String value) {
            addCriterion("fwlx >", value, "fwlx");
            return (Criteria) this;
        }

        public Criteria andFwlxGreaterThanOrEqualTo(String value) {
            addCriterion("fwlx >=", value, "fwlx");
            return (Criteria) this;
        }

        public Criteria andFwlxLessThan(String value) {
            addCriterion("fwlx <", value, "fwlx");
            return (Criteria) this;
        }

        public Criteria andFwlxLessThanOrEqualTo(String value) {
            addCriterion("fwlx <=", value, "fwlx");
            return (Criteria) this;
        }

        public Criteria andFwlxLike(String value) {
            addCriterion("fwlx like", value, "fwlx");
            return (Criteria) this;
        }

        public Criteria andFwlxNotLike(String value) {
            addCriterion("fwlx not like", value, "fwlx");
            return (Criteria) this;
        }

        public Criteria andFwlxIn(List<String> values) {
            addCriterion("fwlx in", values, "fwlx");
            return (Criteria) this;
        }

        public Criteria andFwlxNotIn(List<String> values) {
            addCriterion("fwlx not in", values, "fwlx");
            return (Criteria) this;
        }

        public Criteria andFwlxBetween(String value1, String value2) {
            addCriterion("fwlx between", value1, value2, "fwlx");
            return (Criteria) this;
        }

        public Criteria andFwlxNotBetween(String value1, String value2) {
            addCriterion("fwlx not between", value1, value2, "fwlx");
            return (Criteria) this;
        }

        public Criteria andJzndIsNull() {
            addCriterion("jznd is null");
            return (Criteria) this;
        }

        public Criteria andJzndIsNotNull() {
            addCriterion("jznd is not null");
            return (Criteria) this;
        }

        public Criteria andJzndEqualTo(String value) {
            addCriterion("jznd =", value, "jznd");
            return (Criteria) this;
        }

        public Criteria andJzndNotEqualTo(String value) {
            addCriterion("jznd <>", value, "jznd");
            return (Criteria) this;
        }

        public Criteria andJzndGreaterThan(String value) {
            addCriterion("jznd >", value, "jznd");
            return (Criteria) this;
        }

        public Criteria andJzndGreaterThanOrEqualTo(String value) {
            addCriterion("jznd >=", value, "jznd");
            return (Criteria) this;
        }

        public Criteria andJzndLessThan(String value) {
            addCriterion("jznd <", value, "jznd");
            return (Criteria) this;
        }

        public Criteria andJzndLessThanOrEqualTo(String value) {
            addCriterion("jznd <=", value, "jznd");
            return (Criteria) this;
        }

        public Criteria andJzndLike(String value) {
            addCriterion("jznd like", value, "jznd");
            return (Criteria) this;
        }

        public Criteria andJzndNotLike(String value) {
            addCriterion("jznd not like", value, "jznd");
            return (Criteria) this;
        }

        public Criteria andJzndIn(List<String> values) {
            addCriterion("jznd in", values, "jznd");
            return (Criteria) this;
        }

        public Criteria andJzndNotIn(List<String> values) {
            addCriterion("jznd not in", values, "jznd");
            return (Criteria) this;
        }

        public Criteria andJzndBetween(String value1, String value2) {
            addCriterion("jznd between", value1, value2, "jznd");
            return (Criteria) this;
        }

        public Criteria andJzndNotBetween(String value1, String value2) {
            addCriterion("jznd not between", value1, value2, "jznd");
            return (Criteria) this;
        }

        public Criteria andJzccIsNull() {
            addCriterion("jzcc is null");
            return (Criteria) this;
        }

        public Criteria andJzccIsNotNull() {
            addCriterion("jzcc is not null");
            return (Criteria) this;
        }

        public Criteria andJzccEqualTo(String value) {
            addCriterion("jzcc =", value, "jzcc");
            return (Criteria) this;
        }

        public Criteria andJzccNotEqualTo(String value) {
            addCriterion("jzcc <>", value, "jzcc");
            return (Criteria) this;
        }

        public Criteria andJzccGreaterThan(String value) {
            addCriterion("jzcc >", value, "jzcc");
            return (Criteria) this;
        }

        public Criteria andJzccGreaterThanOrEqualTo(String value) {
            addCriterion("jzcc >=", value, "jzcc");
            return (Criteria) this;
        }

        public Criteria andJzccLessThan(String value) {
            addCriterion("jzcc <", value, "jzcc");
            return (Criteria) this;
        }

        public Criteria andJzccLessThanOrEqualTo(String value) {
            addCriterion("jzcc <=", value, "jzcc");
            return (Criteria) this;
        }

        public Criteria andJzccLike(String value) {
            addCriterion("jzcc like", value, "jzcc");
            return (Criteria) this;
        }

        public Criteria andJzccNotLike(String value) {
            addCriterion("jzcc not like", value, "jzcc");
            return (Criteria) this;
        }

        public Criteria andJzccIn(List<String> values) {
            addCriterion("jzcc in", values, "jzcc");
            return (Criteria) this;
        }

        public Criteria andJzccNotIn(List<String> values) {
            addCriterion("jzcc not in", values, "jzcc");
            return (Criteria) this;
        }

        public Criteria andJzccBetween(String value1, String value2) {
            addCriterion("jzcc between", value1, value2, "jzcc");
            return (Criteria) this;
        }

        public Criteria andJzccNotBetween(String value1, String value2) {
            addCriterion("jzcc not between", value1, value2, "jzcc");
            return (Criteria) this;
        }

        public Criteria andJzzmjIsNull() {
            addCriterion("jzzmj is null");
            return (Criteria) this;
        }

        public Criteria andJzzmjIsNotNull() {
            addCriterion("jzzmj is not null");
            return (Criteria) this;
        }

        public Criteria andJzzmjEqualTo(Double value) {
            addCriterion("jzzmj =", value, "jzzmj");
            return (Criteria) this;
        }

        public Criteria andJzzmjNotEqualTo(Double value) {
            addCriterion("jzzmj <>", value, "jzzmj");
            return (Criteria) this;
        }

        public Criteria andJzzmjGreaterThan(Double value) {
            addCriterion("jzzmj >", value, "jzzmj");
            return (Criteria) this;
        }

        public Criteria andJzzmjGreaterThanOrEqualTo(Double value) {
            addCriterion("jzzmj >=", value, "jzzmj");
            return (Criteria) this;
        }

        public Criteria andJzzmjLessThan(Double value) {
            addCriterion("jzzmj <", value, "jzzmj");
            return (Criteria) this;
        }

        public Criteria andJzzmjLessThanOrEqualTo(Double value) {
            addCriterion("jzzmj <=", value, "jzzmj");
            return (Criteria) this;
        }

        public Criteria andJzzmjIn(List<Double> values) {
            addCriterion("jzzmj in", values, "jzzmj");
            return (Criteria) this;
        }

        public Criteria andJzzmjNotIn(List<Double> values) {
            addCriterion("jzzmj not in", values, "jzzmj");
            return (Criteria) this;
        }

        public Criteria andJzzmjBetween(Double value1, Double value2) {
            addCriterion("jzzmj between", value1, value2, "jzzmj");
            return (Criteria) this;
        }

        public Criteria andJzzmjNotBetween(Double value1, Double value2) {
            addCriterion("jzzmj not between", value1, value2, "jzzmj");
            return (Criteria) this;
        }

        public Criteria andWwjzmjIsNull() {
            addCriterion("wwjzmj is null");
            return (Criteria) this;
        }

        public Criteria andWwjzmjIsNotNull() {
            addCriterion("wwjzmj is not null");
            return (Criteria) this;
        }

        public Criteria andWwjzmjEqualTo(Double value) {
            addCriterion("wwjzmj =", value, "wwjzmj");
            return (Criteria) this;
        }

        public Criteria andWwjzmjNotEqualTo(Double value) {
            addCriterion("wwjzmj <>", value, "wwjzmj");
            return (Criteria) this;
        }

        public Criteria andWwjzmjGreaterThan(Double value) {
            addCriterion("wwjzmj >", value, "wwjzmj");
            return (Criteria) this;
        }

        public Criteria andWwjzmjGreaterThanOrEqualTo(Double value) {
            addCriterion("wwjzmj >=", value, "wwjzmj");
            return (Criteria) this;
        }

        public Criteria andWwjzmjLessThan(Double value) {
            addCriterion("wwjzmj <", value, "wwjzmj");
            return (Criteria) this;
        }

        public Criteria andWwjzmjLessThanOrEqualTo(Double value) {
            addCriterion("wwjzmj <=", value, "wwjzmj");
            return (Criteria) this;
        }

        public Criteria andWwjzmjIn(List<Double> values) {
            addCriterion("wwjzmj in", values, "wwjzmj");
            return (Criteria) this;
        }

        public Criteria andWwjzmjNotIn(List<Double> values) {
            addCriterion("wwjzmj not in", values, "wwjzmj");
            return (Criteria) this;
        }

        public Criteria andWwjzmjBetween(Double value1, Double value2) {
            addCriterion("wwjzmj between", value1, value2, "wwjzmj");
            return (Criteria) this;
        }

        public Criteria andWwjzmjNotBetween(Double value1, Double value2) {
            addCriterion("wwjzmj not between", value1, value2, "wwjzmj");
            return (Criteria) this;
        }

        public Criteria andHsjzmjIsNull() {
            addCriterion("hsjzmj is null");
            return (Criteria) this;
        }

        public Criteria andHsjzmjIsNotNull() {
            addCriterion("hsjzmj is not null");
            return (Criteria) this;
        }

        public Criteria andHsjzmjEqualTo(Double value) {
            addCriterion("hsjzmj =", value, "hsjzmj");
            return (Criteria) this;
        }

        public Criteria andHsjzmjNotEqualTo(Double value) {
            addCriterion("hsjzmj <>", value, "hsjzmj");
            return (Criteria) this;
        }

        public Criteria andHsjzmjGreaterThan(Double value) {
            addCriterion("hsjzmj >", value, "hsjzmj");
            return (Criteria) this;
        }

        public Criteria andHsjzmjGreaterThanOrEqualTo(Double value) {
            addCriterion("hsjzmj >=", value, "hsjzmj");
            return (Criteria) this;
        }

        public Criteria andHsjzmjLessThan(Double value) {
            addCriterion("hsjzmj <", value, "hsjzmj");
            return (Criteria) this;
        }

        public Criteria andHsjzmjLessThanOrEqualTo(Double value) {
            addCriterion("hsjzmj <=", value, "hsjzmj");
            return (Criteria) this;
        }

        public Criteria andHsjzmjIn(List<Double> values) {
            addCriterion("hsjzmj in", values, "hsjzmj");
            return (Criteria) this;
        }

        public Criteria andHsjzmjNotIn(List<Double> values) {
            addCriterion("hsjzmj not in", values, "hsjzmj");
            return (Criteria) this;
        }

        public Criteria andHsjzmjBetween(Double value1, Double value2) {
            addCriterion("hsjzmj between", value1, value2, "hsjzmj");
            return (Criteria) this;
        }

        public Criteria andHsjzmjNotBetween(Double value1, Double value2) {
            addCriterion("hsjzmj not between", value1, value2, "hsjzmj");
            return (Criteria) this;
        }

        public Criteria andZtsIsNull() {
            addCriterion("zts is null");
            return (Criteria) this;
        }

        public Criteria andZtsIsNotNull() {
            addCriterion("zts is not null");
            return (Criteria) this;
        }

        public Criteria andZtsEqualTo(Integer value) {
            addCriterion("zts =", value, "zts");
            return (Criteria) this;
        }

        public Criteria andZtsNotEqualTo(Integer value) {
            addCriterion("zts <>", value, "zts");
            return (Criteria) this;
        }

        public Criteria andZtsGreaterThan(Integer value) {
            addCriterion("zts >", value, "zts");
            return (Criteria) this;
        }

        public Criteria andZtsGreaterThanOrEqualTo(Integer value) {
            addCriterion("zts >=", value, "zts");
            return (Criteria) this;
        }

        public Criteria andZtsLessThan(Integer value) {
            addCriterion("zts <", value, "zts");
            return (Criteria) this;
        }

        public Criteria andZtsLessThanOrEqualTo(Integer value) {
            addCriterion("zts <=", value, "zts");
            return (Criteria) this;
        }

        public Criteria andZtsIn(List<Integer> values) {
            addCriterion("zts in", values, "zts");
            return (Criteria) this;
        }

        public Criteria andZtsNotIn(List<Integer> values) {
            addCriterion("zts not in", values, "zts");
            return (Criteria) this;
        }

        public Criteria andZtsBetween(Integer value1, Integer value2) {
            addCriterion("zts between", value1, value2, "zts");
            return (Criteria) this;
        }

        public Criteria andZtsNotBetween(Integer value1, Integer value2) {
            addCriterion("zts not between", value1, value2, "zts");
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