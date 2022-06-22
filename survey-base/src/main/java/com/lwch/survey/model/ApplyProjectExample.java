package com.lwch.survey.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ApplyProjectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ApplyProjectExample() {
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

        public Criteria andProjectNameIsNull() {
            addCriterion("project_name is null");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNotNull() {
            addCriterion("project_name is not null");
            return (Criteria) this;
        }

        public Criteria andProjectNameEqualTo(String value) {
            addCriterion("project_name =", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotEqualTo(String value) {
            addCriterion("project_name <>", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThan(String value) {
            addCriterion("project_name >", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThanOrEqualTo(String value) {
            addCriterion("project_name >=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThan(String value) {
            addCriterion("project_name <", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThanOrEqualTo(String value) {
            addCriterion("project_name <=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLike(String value) {
            addCriterion("project_name like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotLike(String value) {
            addCriterion("project_name not like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameIn(List<String> values) {
            addCriterion("project_name in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotIn(List<String> values) {
            addCriterion("project_name not in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameBetween(String value1, String value2) {
            addCriterion("project_name between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotBetween(String value1, String value2) {
            addCriterion("project_name not between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectTypeIsNull() {
            addCriterion("project_type is null");
            return (Criteria) this;
        }

        public Criteria andProjectTypeIsNotNull() {
            addCriterion("project_type is not null");
            return (Criteria) this;
        }

        public Criteria andProjectTypeEqualTo(String value) {
            addCriterion("project_type =", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeNotEqualTo(String value) {
            addCriterion("project_type <>", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeGreaterThan(String value) {
            addCriterion("project_type >", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeGreaterThanOrEqualTo(String value) {
            addCriterion("project_type >=", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeLessThan(String value) {
            addCriterion("project_type <", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeLessThanOrEqualTo(String value) {
            addCriterion("project_type <=", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeLike(String value) {
            addCriterion("project_type like", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeNotLike(String value) {
            addCriterion("project_type not like", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeIn(List<String> values) {
            addCriterion("project_type in", values, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeNotIn(List<String> values) {
            addCriterion("project_type not in", values, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeBetween(String value1, String value2) {
            addCriterion("project_type between", value1, value2, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeNotBetween(String value1, String value2) {
            addCriterion("project_type not between", value1, value2, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectFzrIsNull() {
            addCriterion("project_fzr is null");
            return (Criteria) this;
        }

        public Criteria andProjectFzrIsNotNull() {
            addCriterion("project_fzr is not null");
            return (Criteria) this;
        }

        public Criteria andProjectFzrEqualTo(String value) {
            addCriterion("project_fzr =", value, "projectFzr");
            return (Criteria) this;
        }

        public Criteria andProjectFzrNotEqualTo(String value) {
            addCriterion("project_fzr <>", value, "projectFzr");
            return (Criteria) this;
        }

        public Criteria andProjectFzrGreaterThan(String value) {
            addCriterion("project_fzr >", value, "projectFzr");
            return (Criteria) this;
        }

        public Criteria andProjectFzrGreaterThanOrEqualTo(String value) {
            addCriterion("project_fzr >=", value, "projectFzr");
            return (Criteria) this;
        }

        public Criteria andProjectFzrLessThan(String value) {
            addCriterion("project_fzr <", value, "projectFzr");
            return (Criteria) this;
        }

        public Criteria andProjectFzrLessThanOrEqualTo(String value) {
            addCriterion("project_fzr <=", value, "projectFzr");
            return (Criteria) this;
        }

        public Criteria andProjectFzrLike(String value) {
            addCriterion("project_fzr like", value, "projectFzr");
            return (Criteria) this;
        }

        public Criteria andProjectFzrNotLike(String value) {
            addCriterion("project_fzr not like", value, "projectFzr");
            return (Criteria) this;
        }

        public Criteria andProjectFzrIn(List<String> values) {
            addCriterion("project_fzr in", values, "projectFzr");
            return (Criteria) this;
        }

        public Criteria andProjectFzrNotIn(List<String> values) {
            addCriterion("project_fzr not in", values, "projectFzr");
            return (Criteria) this;
        }

        public Criteria andProjectFzrBetween(String value1, String value2) {
            addCriterion("project_fzr between", value1, value2, "projectFzr");
            return (Criteria) this;
        }

        public Criteria andProjectFzrNotBetween(String value1, String value2) {
            addCriterion("project_fzr not between", value1, value2, "projectFzr");
            return (Criteria) this;
        }

        public Criteria andProjectGkIsNull() {
            addCriterion("project_gk is null");
            return (Criteria) this;
        }

        public Criteria andProjectGkIsNotNull() {
            addCriterion("project_gk is not null");
            return (Criteria) this;
        }

        public Criteria andProjectGkEqualTo(String value) {
            addCriterion("project_gk =", value, "projectGk");
            return (Criteria) this;
        }

        public Criteria andProjectGkNotEqualTo(String value) {
            addCriterion("project_gk <>", value, "projectGk");
            return (Criteria) this;
        }

        public Criteria andProjectGkGreaterThan(String value) {
            addCriterion("project_gk >", value, "projectGk");
            return (Criteria) this;
        }

        public Criteria andProjectGkGreaterThanOrEqualTo(String value) {
            addCriterion("project_gk >=", value, "projectGk");
            return (Criteria) this;
        }

        public Criteria andProjectGkLessThan(String value) {
            addCriterion("project_gk <", value, "projectGk");
            return (Criteria) this;
        }

        public Criteria andProjectGkLessThanOrEqualTo(String value) {
            addCriterion("project_gk <=", value, "projectGk");
            return (Criteria) this;
        }

        public Criteria andProjectGkLike(String value) {
            addCriterion("project_gk like", value, "projectGk");
            return (Criteria) this;
        }

        public Criteria andProjectGkNotLike(String value) {
            addCriterion("project_gk not like", value, "projectGk");
            return (Criteria) this;
        }

        public Criteria andProjectGkIn(List<String> values) {
            addCriterion("project_gk in", values, "projectGk");
            return (Criteria) this;
        }

        public Criteria andProjectGkNotIn(List<String> values) {
            addCriterion("project_gk not in", values, "projectGk");
            return (Criteria) this;
        }

        public Criteria andProjectGkBetween(String value1, String value2) {
            addCriterion("project_gk between", value1, value2, "projectGk");
            return (Criteria) this;
        }

        public Criteria andProjectGkNotBetween(String value1, String value2) {
            addCriterion("project_gk not between", value1, value2, "projectGk");
            return (Criteria) this;
        }

        public Criteria andProjectXmzlIsNull() {
            addCriterion("project_xmzl is null");
            return (Criteria) this;
        }

        public Criteria andProjectXmzlIsNotNull() {
            addCriterion("project_xmzl is not null");
            return (Criteria) this;
        }

        public Criteria andProjectXmzlEqualTo(String value) {
            addCriterion("project_xmzl =", value, "projectXmzl");
            return (Criteria) this;
        }

        public Criteria andProjectXmzlNotEqualTo(String value) {
            addCriterion("project_xmzl <>", value, "projectXmzl");
            return (Criteria) this;
        }

        public Criteria andProjectXmzlGreaterThan(String value) {
            addCriterion("project_xmzl >", value, "projectXmzl");
            return (Criteria) this;
        }

        public Criteria andProjectXmzlGreaterThanOrEqualTo(String value) {
            addCriterion("project_xmzl >=", value, "projectXmzl");
            return (Criteria) this;
        }

        public Criteria andProjectXmzlLessThan(String value) {
            addCriterion("project_xmzl <", value, "projectXmzl");
            return (Criteria) this;
        }

        public Criteria andProjectXmzlLessThanOrEqualTo(String value) {
            addCriterion("project_xmzl <=", value, "projectXmzl");
            return (Criteria) this;
        }

        public Criteria andProjectXmzlLike(String value) {
            addCriterion("project_xmzl like", value, "projectXmzl");
            return (Criteria) this;
        }

        public Criteria andProjectXmzlNotLike(String value) {
            addCriterion("project_xmzl not like", value, "projectXmzl");
            return (Criteria) this;
        }

        public Criteria andProjectXmzlIn(List<String> values) {
            addCriterion("project_xmzl in", values, "projectXmzl");
            return (Criteria) this;
        }

        public Criteria andProjectXmzlNotIn(List<String> values) {
            addCriterion("project_xmzl not in", values, "projectXmzl");
            return (Criteria) this;
        }

        public Criteria andProjectXmzlBetween(String value1, String value2) {
            addCriterion("project_xmzl between", value1, value2, "projectXmzl");
            return (Criteria) this;
        }

        public Criteria andProjectXmzlNotBetween(String value1, String value2) {
            addCriterion("project_xmzl not between", value1, value2, "projectXmzl");
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

        public Criteria andSldwIsNull() {
            addCriterion("sldw is null");
            return (Criteria) this;
        }

        public Criteria andSldwIsNotNull() {
            addCriterion("sldw is not null");
            return (Criteria) this;
        }

        public Criteria andSldwEqualTo(String value) {
            addCriterion("sldw =", value, "sldw");
            return (Criteria) this;
        }

        public Criteria andSldwNotEqualTo(String value) {
            addCriterion("sldw <>", value, "sldw");
            return (Criteria) this;
        }

        public Criteria andSldwGreaterThan(String value) {
            addCriterion("sldw >", value, "sldw");
            return (Criteria) this;
        }

        public Criteria andSldwGreaterThanOrEqualTo(String value) {
            addCriterion("sldw >=", value, "sldw");
            return (Criteria) this;
        }

        public Criteria andSldwLessThan(String value) {
            addCriterion("sldw <", value, "sldw");
            return (Criteria) this;
        }

        public Criteria andSldwLessThanOrEqualTo(String value) {
            addCriterion("sldw <=", value, "sldw");
            return (Criteria) this;
        }

        public Criteria andSldwLike(String value) {
            addCriterion("sldw like", value, "sldw");
            return (Criteria) this;
        }

        public Criteria andSldwNotLike(String value) {
            addCriterion("sldw not like", value, "sldw");
            return (Criteria) this;
        }

        public Criteria andSldwIn(List<String> values) {
            addCriterion("sldw in", values, "sldw");
            return (Criteria) this;
        }

        public Criteria andSldwNotIn(List<String> values) {
            addCriterion("sldw not in", values, "sldw");
            return (Criteria) this;
        }

        public Criteria andSldwBetween(String value1, String value2) {
            addCriterion("sldw between", value1, value2, "sldw");
            return (Criteria) this;
        }

        public Criteria andSldwNotBetween(String value1, String value2) {
            addCriterion("sldw not between", value1, value2, "sldw");
            return (Criteria) this;
        }

        public Criteria andSlzjhmIsNull() {
            addCriterion("slzjhm is null");
            return (Criteria) this;
        }

        public Criteria andSlzjhmIsNotNull() {
            addCriterion("slzjhm is not null");
            return (Criteria) this;
        }

        public Criteria andSlzjhmEqualTo(String value) {
            addCriterion("slzjhm =", value, "slzjhm");
            return (Criteria) this;
        }

        public Criteria andSlzjhmNotEqualTo(String value) {
            addCriterion("slzjhm <>", value, "slzjhm");
            return (Criteria) this;
        }

        public Criteria andSlzjhmGreaterThan(String value) {
            addCriterion("slzjhm >", value, "slzjhm");
            return (Criteria) this;
        }

        public Criteria andSlzjhmGreaterThanOrEqualTo(String value) {
            addCriterion("slzjhm >=", value, "slzjhm");
            return (Criteria) this;
        }

        public Criteria andSlzjhmLessThan(String value) {
            addCriterion("slzjhm <", value, "slzjhm");
            return (Criteria) this;
        }

        public Criteria andSlzjhmLessThanOrEqualTo(String value) {
            addCriterion("slzjhm <=", value, "slzjhm");
            return (Criteria) this;
        }

        public Criteria andSlzjhmLike(String value) {
            addCriterion("slzjhm like", value, "slzjhm");
            return (Criteria) this;
        }

        public Criteria andSlzjhmNotLike(String value) {
            addCriterion("slzjhm not like", value, "slzjhm");
            return (Criteria) this;
        }

        public Criteria andSlzjhmIn(List<String> values) {
            addCriterion("slzjhm in", values, "slzjhm");
            return (Criteria) this;
        }

        public Criteria andSlzjhmNotIn(List<String> values) {
            addCriterion("slzjhm not in", values, "slzjhm");
            return (Criteria) this;
        }

        public Criteria andSlzjhmBetween(String value1, String value2) {
            addCriterion("slzjhm between", value1, value2, "slzjhm");
            return (Criteria) this;
        }

        public Criteria andSlzjhmNotBetween(String value1, String value2) {
            addCriterion("slzjhm not between", value1, value2, "slzjhm");
            return (Criteria) this;
        }

        public Criteria andSllxrIsNull() {
            addCriterion("sllxr is null");
            return (Criteria) this;
        }

        public Criteria andSllxrIsNotNull() {
            addCriterion("sllxr is not null");
            return (Criteria) this;
        }

        public Criteria andSllxrEqualTo(String value) {
            addCriterion("sllxr =", value, "sllxr");
            return (Criteria) this;
        }

        public Criteria andSllxrNotEqualTo(String value) {
            addCriterion("sllxr <>", value, "sllxr");
            return (Criteria) this;
        }

        public Criteria andSllxrGreaterThan(String value) {
            addCriterion("sllxr >", value, "sllxr");
            return (Criteria) this;
        }

        public Criteria andSllxrGreaterThanOrEqualTo(String value) {
            addCriterion("sllxr >=", value, "sllxr");
            return (Criteria) this;
        }

        public Criteria andSllxrLessThan(String value) {
            addCriterion("sllxr <", value, "sllxr");
            return (Criteria) this;
        }

        public Criteria andSllxrLessThanOrEqualTo(String value) {
            addCriterion("sllxr <=", value, "sllxr");
            return (Criteria) this;
        }

        public Criteria andSllxrLike(String value) {
            addCriterion("sllxr like", value, "sllxr");
            return (Criteria) this;
        }

        public Criteria andSllxrNotLike(String value) {
            addCriterion("sllxr not like", value, "sllxr");
            return (Criteria) this;
        }

        public Criteria andSllxrIn(List<String> values) {
            addCriterion("sllxr in", values, "sllxr");
            return (Criteria) this;
        }

        public Criteria andSllxrNotIn(List<String> values) {
            addCriterion("sllxr not in", values, "sllxr");
            return (Criteria) this;
        }

        public Criteria andSllxrBetween(String value1, String value2) {
            addCriterion("sllxr between", value1, value2, "sllxr");
            return (Criteria) this;
        }

        public Criteria andSllxrNotBetween(String value1, String value2) {
            addCriterion("sllxr not between", value1, value2, "sllxr");
            return (Criteria) this;
        }

        public Criteria andSldhIsNull() {
            addCriterion("sldh is null");
            return (Criteria) this;
        }

        public Criteria andSldhIsNotNull() {
            addCriterion("sldh is not null");
            return (Criteria) this;
        }

        public Criteria andSldhEqualTo(String value) {
            addCriterion("sldh =", value, "sldh");
            return (Criteria) this;
        }

        public Criteria andSldhNotEqualTo(String value) {
            addCriterion("sldh <>", value, "sldh");
            return (Criteria) this;
        }

        public Criteria andSldhGreaterThan(String value) {
            addCriterion("sldh >", value, "sldh");
            return (Criteria) this;
        }

        public Criteria andSldhGreaterThanOrEqualTo(String value) {
            addCriterion("sldh >=", value, "sldh");
            return (Criteria) this;
        }

        public Criteria andSldhLessThan(String value) {
            addCriterion("sldh <", value, "sldh");
            return (Criteria) this;
        }

        public Criteria andSldhLessThanOrEqualTo(String value) {
            addCriterion("sldh <=", value, "sldh");
            return (Criteria) this;
        }

        public Criteria andSldhLike(String value) {
            addCriterion("sldh like", value, "sldh");
            return (Criteria) this;
        }

        public Criteria andSldhNotLike(String value) {
            addCriterion("sldh not like", value, "sldh");
            return (Criteria) this;
        }

        public Criteria andSldhIn(List<String> values) {
            addCriterion("sldh in", values, "sldh");
            return (Criteria) this;
        }

        public Criteria andSldhNotIn(List<String> values) {
            addCriterion("sldh not in", values, "sldh");
            return (Criteria) this;
        }

        public Criteria andSldhBetween(String value1, String value2) {
            addCriterion("sldh between", value1, value2, "sldh");
            return (Criteria) this;
        }

        public Criteria andSldhNotBetween(String value1, String value2) {
            addCriterion("sldh not between", value1, value2, "sldh");
            return (Criteria) this;
        }

        public Criteria andCreditCodeIsNull() {
            addCriterion("credit_code is null");
            return (Criteria) this;
        }

        public Criteria andCreditCodeIsNotNull() {
            addCriterion("credit_code is not null");
            return (Criteria) this;
        }

        public Criteria andCreditCodeEqualTo(String value) {
            addCriterion("credit_code =", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeNotEqualTo(String value) {
            addCriterion("credit_code <>", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeGreaterThan(String value) {
            addCriterion("credit_code >", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeGreaterThanOrEqualTo(String value) {
            addCriterion("credit_code >=", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeLessThan(String value) {
            addCriterion("credit_code <", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeLessThanOrEqualTo(String value) {
            addCriterion("credit_code <=", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeLike(String value) {
            addCriterion("credit_code like", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeNotLike(String value) {
            addCriterion("credit_code not like", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeIn(List<String> values) {
            addCriterion("credit_code in", values, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeNotIn(List<String> values) {
            addCriterion("credit_code not in", values, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeBetween(String value1, String value2) {
            addCriterion("credit_code between", value1, value2, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeNotBetween(String value1, String value2) {
            addCriterion("credit_code not between", value1, value2, "creditCode");
            return (Criteria) this;
        }

        public Criteria andSlcreditCodeIsNull() {
            addCriterion("slcredit_code is null");
            return (Criteria) this;
        }

        public Criteria andSlcreditCodeIsNotNull() {
            addCriterion("slcredit_code is not null");
            return (Criteria) this;
        }

        public Criteria andSlcreditCodeEqualTo(String value) {
            addCriterion("slcredit_code =", value, "slcreditCode");
            return (Criteria) this;
        }

        public Criteria andSlcreditCodeNotEqualTo(String value) {
            addCriterion("slcredit_code <>", value, "slcreditCode");
            return (Criteria) this;
        }

        public Criteria andSlcreditCodeGreaterThan(String value) {
            addCriterion("slcredit_code >", value, "slcreditCode");
            return (Criteria) this;
        }

        public Criteria andSlcreditCodeGreaterThanOrEqualTo(String value) {
            addCriterion("slcredit_code >=", value, "slcreditCode");
            return (Criteria) this;
        }

        public Criteria andSlcreditCodeLessThan(String value) {
            addCriterion("slcredit_code <", value, "slcreditCode");
            return (Criteria) this;
        }

        public Criteria andSlcreditCodeLessThanOrEqualTo(String value) {
            addCriterion("slcredit_code <=", value, "slcreditCode");
            return (Criteria) this;
        }

        public Criteria andSlcreditCodeLike(String value) {
            addCriterion("slcredit_code like", value, "slcreditCode");
            return (Criteria) this;
        }

        public Criteria andSlcreditCodeNotLike(String value) {
            addCriterion("slcredit_code not like", value, "slcreditCode");
            return (Criteria) this;
        }

        public Criteria andSlcreditCodeIn(List<String> values) {
            addCriterion("slcredit_code in", values, "slcreditCode");
            return (Criteria) this;
        }

        public Criteria andSlcreditCodeNotIn(List<String> values) {
            addCriterion("slcredit_code not in", values, "slcreditCode");
            return (Criteria) this;
        }

        public Criteria andSlcreditCodeBetween(String value1, String value2) {
            addCriterion("slcredit_code between", value1, value2, "slcreditCode");
            return (Criteria) this;
        }

        public Criteria andSlcreditCodeNotBetween(String value1, String value2) {
            addCriterion("slcredit_code not between", value1, value2, "slcreditCode");
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