package com.lwch.survey.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HouseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HouseExample() {
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

        public Criteria andBuildNoIsNull() {
            addCriterion("build_no is null");
            return (Criteria) this;
        }

        public Criteria andBuildNoIsNotNull() {
            addCriterion("build_no is not null");
            return (Criteria) this;
        }

        public Criteria andBuildNoEqualTo(String value) {
            addCriterion("build_no =", value, "buildNo");
            return (Criteria) this;
        }

        public Criteria andBuildNoNotEqualTo(String value) {
            addCriterion("build_no <>", value, "buildNo");
            return (Criteria) this;
        }

        public Criteria andBuildNoGreaterThan(String value) {
            addCriterion("build_no >", value, "buildNo");
            return (Criteria) this;
        }

        public Criteria andBuildNoGreaterThanOrEqualTo(String value) {
            addCriterion("build_no >=", value, "buildNo");
            return (Criteria) this;
        }

        public Criteria andBuildNoLessThan(String value) {
            addCriterion("build_no <", value, "buildNo");
            return (Criteria) this;
        }

        public Criteria andBuildNoLessThanOrEqualTo(String value) {
            addCriterion("build_no <=", value, "buildNo");
            return (Criteria) this;
        }

        public Criteria andBuildNoLike(String value) {
            addCriterion("build_no like", value, "buildNo");
            return (Criteria) this;
        }

        public Criteria andBuildNoNotLike(String value) {
            addCriterion("build_no not like", value, "buildNo");
            return (Criteria) this;
        }

        public Criteria andBuildNoIn(List<String> values) {
            addCriterion("build_no in", values, "buildNo");
            return (Criteria) this;
        }

        public Criteria andBuildNoNotIn(List<String> values) {
            addCriterion("build_no not in", values, "buildNo");
            return (Criteria) this;
        }

        public Criteria andBuildNoBetween(String value1, String value2) {
            addCriterion("build_no between", value1, value2, "buildNo");
            return (Criteria) this;
        }

        public Criteria andBuildNoNotBetween(String value1, String value2) {
            addCriterion("build_no not between", value1, value2, "buildNo");
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

        public Criteria andHouseNoIsNull() {
            addCriterion("house_no is null");
            return (Criteria) this;
        }

        public Criteria andHouseNoIsNotNull() {
            addCriterion("house_no is not null");
            return (Criteria) this;
        }

        public Criteria andHouseNoEqualTo(String value) {
            addCriterion("house_no =", value, "houseNo");
            return (Criteria) this;
        }

        public Criteria andHouseNoNotEqualTo(String value) {
            addCriterion("house_no <>", value, "houseNo");
            return (Criteria) this;
        }

        public Criteria andHouseNoGreaterThan(String value) {
            addCriterion("house_no >", value, "houseNo");
            return (Criteria) this;
        }

        public Criteria andHouseNoGreaterThanOrEqualTo(String value) {
            addCriterion("house_no >=", value, "houseNo");
            return (Criteria) this;
        }

        public Criteria andHouseNoLessThan(String value) {
            addCriterion("house_no <", value, "houseNo");
            return (Criteria) this;
        }

        public Criteria andHouseNoLessThanOrEqualTo(String value) {
            addCriterion("house_no <=", value, "houseNo");
            return (Criteria) this;
        }

        public Criteria andHouseNoLike(String value) {
            addCriterion("house_no like", value, "houseNo");
            return (Criteria) this;
        }

        public Criteria andHouseNoNotLike(String value) {
            addCriterion("house_no not like", value, "houseNo");
            return (Criteria) this;
        }

        public Criteria andHouseNoIn(List<String> values) {
            addCriterion("house_no in", values, "houseNo");
            return (Criteria) this;
        }

        public Criteria andHouseNoNotIn(List<String> values) {
            addCriterion("house_no not in", values, "houseNo");
            return (Criteria) this;
        }

        public Criteria andHouseNoBetween(String value1, String value2) {
            addCriterion("house_no between", value1, value2, "houseNo");
            return (Criteria) this;
        }

        public Criteria andHouseNoNotBetween(String value1, String value2) {
            addCriterion("house_no not between", value1, value2, "houseNo");
            return (Criteria) this;
        }

        public Criteria andBuildStructureIsNull() {
            addCriterion("build_structure is null");
            return (Criteria) this;
        }

        public Criteria andBuildStructureIsNotNull() {
            addCriterion("build_structure is not null");
            return (Criteria) this;
        }

        public Criteria andBuildStructureEqualTo(String value) {
            addCriterion("build_structure =", value, "buildStructure");
            return (Criteria) this;
        }

        public Criteria andBuildStructureNotEqualTo(String value) {
            addCriterion("build_structure <>", value, "buildStructure");
            return (Criteria) this;
        }

        public Criteria andBuildStructureGreaterThan(String value) {
            addCriterion("build_structure >", value, "buildStructure");
            return (Criteria) this;
        }

        public Criteria andBuildStructureGreaterThanOrEqualTo(String value) {
            addCriterion("build_structure >=", value, "buildStructure");
            return (Criteria) this;
        }

        public Criteria andBuildStructureLessThan(String value) {
            addCriterion("build_structure <", value, "buildStructure");
            return (Criteria) this;
        }

        public Criteria andBuildStructureLessThanOrEqualTo(String value) {
            addCriterion("build_structure <=", value, "buildStructure");
            return (Criteria) this;
        }

        public Criteria andBuildStructureLike(String value) {
            addCriterion("build_structure like", value, "buildStructure");
            return (Criteria) this;
        }

        public Criteria andBuildStructureNotLike(String value) {
            addCriterion("build_structure not like", value, "buildStructure");
            return (Criteria) this;
        }

        public Criteria andBuildStructureIn(List<String> values) {
            addCriterion("build_structure in", values, "buildStructure");
            return (Criteria) this;
        }

        public Criteria andBuildStructureNotIn(List<String> values) {
            addCriterion("build_structure not in", values, "buildStructure");
            return (Criteria) this;
        }

        public Criteria andBuildStructureBetween(String value1, String value2) {
            addCriterion("build_structure between", value1, value2, "buildStructure");
            return (Criteria) this;
        }

        public Criteria andBuildStructureNotBetween(String value1, String value2) {
            addCriterion("build_structure not between", value1, value2, "buildStructure");
            return (Criteria) this;
        }

        public Criteria andLayersTotalIsNull() {
            addCriterion("layers_total is null");
            return (Criteria) this;
        }

        public Criteria andLayersTotalIsNotNull() {
            addCriterion("layers_total is not null");
            return (Criteria) this;
        }

        public Criteria andLayersTotalEqualTo(Integer value) {
            addCriterion("layers_total =", value, "layersTotal");
            return (Criteria) this;
        }

        public Criteria andLayersTotalNotEqualTo(Integer value) {
            addCriterion("layers_total <>", value, "layersTotal");
            return (Criteria) this;
        }

        public Criteria andLayersTotalGreaterThan(Integer value) {
            addCriterion("layers_total >", value, "layersTotal");
            return (Criteria) this;
        }

        public Criteria andLayersTotalGreaterThanOrEqualTo(Integer value) {
            addCriterion("layers_total >=", value, "layersTotal");
            return (Criteria) this;
        }

        public Criteria andLayersTotalLessThan(Integer value) {
            addCriterion("layers_total <", value, "layersTotal");
            return (Criteria) this;
        }

        public Criteria andLayersTotalLessThanOrEqualTo(Integer value) {
            addCriterion("layers_total <=", value, "layersTotal");
            return (Criteria) this;
        }

        public Criteria andLayersTotalIn(List<Integer> values) {
            addCriterion("layers_total in", values, "layersTotal");
            return (Criteria) this;
        }

        public Criteria andLayersTotalNotIn(List<Integer> values) {
            addCriterion("layers_total not in", values, "layersTotal");
            return (Criteria) this;
        }

        public Criteria andLayersTotalBetween(Integer value1, Integer value2) {
            addCriterion("layers_total between", value1, value2, "layersTotal");
            return (Criteria) this;
        }

        public Criteria andLayersTotalNotBetween(Integer value1, Integer value2) {
            addCriterion("layers_total not between", value1, value2, "layersTotal");
            return (Criteria) this;
        }

        public Criteria andLayersLocationIsNull() {
            addCriterion("layers_location is null");
            return (Criteria) this;
        }

        public Criteria andLayersLocationIsNotNull() {
            addCriterion("layers_location is not null");
            return (Criteria) this;
        }

        public Criteria andLayersLocationEqualTo(Integer value) {
            addCriterion("layers_location =", value, "layersLocation");
            return (Criteria) this;
        }

        public Criteria andLayersLocationNotEqualTo(Integer value) {
            addCriterion("layers_location <>", value, "layersLocation");
            return (Criteria) this;
        }

        public Criteria andLayersLocationGreaterThan(Integer value) {
            addCriterion("layers_location >", value, "layersLocation");
            return (Criteria) this;
        }

        public Criteria andLayersLocationGreaterThanOrEqualTo(Integer value) {
            addCriterion("layers_location >=", value, "layersLocation");
            return (Criteria) this;
        }

        public Criteria andLayersLocationLessThan(Integer value) {
            addCriterion("layers_location <", value, "layersLocation");
            return (Criteria) this;
        }

        public Criteria andLayersLocationLessThanOrEqualTo(Integer value) {
            addCriterion("layers_location <=", value, "layersLocation");
            return (Criteria) this;
        }

        public Criteria andLayersLocationIn(List<Integer> values) {
            addCriterion("layers_location in", values, "layersLocation");
            return (Criteria) this;
        }

        public Criteria andLayersLocationNotIn(List<Integer> values) {
            addCriterion("layers_location not in", values, "layersLocation");
            return (Criteria) this;
        }

        public Criteria andLayersLocationBetween(Integer value1, Integer value2) {
            addCriterion("layers_location between", value1, value2, "layersLocation");
            return (Criteria) this;
        }

        public Criteria andLayersLocationNotBetween(Integer value1, Integer value2) {
            addCriterion("layers_location not between", value1, value2, "layersLocation");
            return (Criteria) this;
        }

        public Criteria andBuildAreaIsNull() {
            addCriterion("build_area is null");
            return (Criteria) this;
        }

        public Criteria andBuildAreaIsNotNull() {
            addCriterion("build_area is not null");
            return (Criteria) this;
        }

        public Criteria andBuildAreaEqualTo(Double value) {
            addCriterion("build_area =", value, "buildArea");
            return (Criteria) this;
        }

        public Criteria andBuildAreaNotEqualTo(Double value) {
            addCriterion("build_area <>", value, "buildArea");
            return (Criteria) this;
        }

        public Criteria andBuildAreaGreaterThan(Double value) {
            addCriterion("build_area >", value, "buildArea");
            return (Criteria) this;
        }

        public Criteria andBuildAreaGreaterThanOrEqualTo(Double value) {
            addCriterion("build_area >=", value, "buildArea");
            return (Criteria) this;
        }

        public Criteria andBuildAreaLessThan(Double value) {
            addCriterion("build_area <", value, "buildArea");
            return (Criteria) this;
        }

        public Criteria andBuildAreaLessThanOrEqualTo(Double value) {
            addCriterion("build_area <=", value, "buildArea");
            return (Criteria) this;
        }

        public Criteria andBuildAreaIn(List<Double> values) {
            addCriterion("build_area in", values, "buildArea");
            return (Criteria) this;
        }

        public Criteria andBuildAreaNotIn(List<Double> values) {
            addCriterion("build_area not in", values, "buildArea");
            return (Criteria) this;
        }

        public Criteria andBuildAreaBetween(Double value1, Double value2) {
            addCriterion("build_area between", value1, value2, "buildArea");
            return (Criteria) this;
        }

        public Criteria andBuildAreaNotBetween(Double value1, Double value2) {
            addCriterion("build_area not between", value1, value2, "buildArea");
            return (Criteria) this;
        }

        public Criteria andInnerAreaIsNull() {
            addCriterion("inner_area is null");
            return (Criteria) this;
        }

        public Criteria andInnerAreaIsNotNull() {
            addCriterion("inner_area is not null");
            return (Criteria) this;
        }

        public Criteria andInnerAreaEqualTo(Double value) {
            addCriterion("inner_area =", value, "innerArea");
            return (Criteria) this;
        }

        public Criteria andInnerAreaNotEqualTo(Double value) {
            addCriterion("inner_area <>", value, "innerArea");
            return (Criteria) this;
        }

        public Criteria andInnerAreaGreaterThan(Double value) {
            addCriterion("inner_area >", value, "innerArea");
            return (Criteria) this;
        }

        public Criteria andInnerAreaGreaterThanOrEqualTo(Double value) {
            addCriterion("inner_area >=", value, "innerArea");
            return (Criteria) this;
        }

        public Criteria andInnerAreaLessThan(Double value) {
            addCriterion("inner_area <", value, "innerArea");
            return (Criteria) this;
        }

        public Criteria andInnerAreaLessThanOrEqualTo(Double value) {
            addCriterion("inner_area <=", value, "innerArea");
            return (Criteria) this;
        }

        public Criteria andInnerAreaIn(List<Double> values) {
            addCriterion("inner_area in", values, "innerArea");
            return (Criteria) this;
        }

        public Criteria andInnerAreaNotIn(List<Double> values) {
            addCriterion("inner_area not in", values, "innerArea");
            return (Criteria) this;
        }

        public Criteria andInnerAreaBetween(Double value1, Double value2) {
            addCriterion("inner_area between", value1, value2, "innerArea");
            return (Criteria) this;
        }

        public Criteria andInnerAreaNotBetween(Double value1, Double value2) {
            addCriterion("inner_area not between", value1, value2, "innerArea");
            return (Criteria) this;
        }

        public Criteria andShareAreaIsNull() {
            addCriterion("share_area is null");
            return (Criteria) this;
        }

        public Criteria andShareAreaIsNotNull() {
            addCriterion("share_area is not null");
            return (Criteria) this;
        }

        public Criteria andShareAreaEqualTo(Double value) {
            addCriterion("share_area =", value, "shareArea");
            return (Criteria) this;
        }

        public Criteria andShareAreaNotEqualTo(Double value) {
            addCriterion("share_area <>", value, "shareArea");
            return (Criteria) this;
        }

        public Criteria andShareAreaGreaterThan(Double value) {
            addCriterion("share_area >", value, "shareArea");
            return (Criteria) this;
        }

        public Criteria andShareAreaGreaterThanOrEqualTo(Double value) {
            addCriterion("share_area >=", value, "shareArea");
            return (Criteria) this;
        }

        public Criteria andShareAreaLessThan(Double value) {
            addCriterion("share_area <", value, "shareArea");
            return (Criteria) this;
        }

        public Criteria andShareAreaLessThanOrEqualTo(Double value) {
            addCriterion("share_area <=", value, "shareArea");
            return (Criteria) this;
        }

        public Criteria andShareAreaIn(List<Double> values) {
            addCriterion("share_area in", values, "shareArea");
            return (Criteria) this;
        }

        public Criteria andShareAreaNotIn(List<Double> values) {
            addCriterion("share_area not in", values, "shareArea");
            return (Criteria) this;
        }

        public Criteria andShareAreaBetween(Double value1, Double value2) {
            addCriterion("share_area between", value1, value2, "shareArea");
            return (Criteria) this;
        }

        public Criteria andShareAreaNotBetween(Double value1, Double value2) {
            addCriterion("share_area not between", value1, value2, "shareArea");
            return (Criteria) this;
        }

        public Criteria andYtmjIsNull() {
            addCriterion("ytmj is null");
            return (Criteria) this;
        }

        public Criteria andYtmjIsNotNull() {
            addCriterion("ytmj is not null");
            return (Criteria) this;
        }

        public Criteria andYtmjEqualTo(Double value) {
            addCriterion("ytmj =", value, "ytmj");
            return (Criteria) this;
        }

        public Criteria andYtmjNotEqualTo(Double value) {
            addCriterion("ytmj <>", value, "ytmj");
            return (Criteria) this;
        }

        public Criteria andYtmjGreaterThan(Double value) {
            addCriterion("ytmj >", value, "ytmj");
            return (Criteria) this;
        }

        public Criteria andYtmjGreaterThanOrEqualTo(Double value) {
            addCriterion("ytmj >=", value, "ytmj");
            return (Criteria) this;
        }

        public Criteria andYtmjLessThan(Double value) {
            addCriterion("ytmj <", value, "ytmj");
            return (Criteria) this;
        }

        public Criteria andYtmjLessThanOrEqualTo(Double value) {
            addCriterion("ytmj <=", value, "ytmj");
            return (Criteria) this;
        }

        public Criteria andYtmjIn(List<Double> values) {
            addCriterion("ytmj in", values, "ytmj");
            return (Criteria) this;
        }

        public Criteria andYtmjNotIn(List<Double> values) {
            addCriterion("ytmj not in", values, "ytmj");
            return (Criteria) this;
        }

        public Criteria andYtmjBetween(Double value1, Double value2) {
            addCriterion("ytmj between", value1, value2, "ytmj");
            return (Criteria) this;
        }

        public Criteria andYtmjNotBetween(Double value1, Double value2) {
            addCriterion("ytmj not between", value1, value2, "ytmj");
            return (Criteria) this;
        }

        public Criteria andRoomIdIsNull() {
            addCriterion("room_id is null");
            return (Criteria) this;
        }

        public Criteria andRoomIdIsNotNull() {
            addCriterion("room_id is not null");
            return (Criteria) this;
        }

        public Criteria andRoomIdEqualTo(String value) {
            addCriterion("room_id =", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotEqualTo(String value) {
            addCriterion("room_id <>", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdGreaterThan(String value) {
            addCriterion("room_id >", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdGreaterThanOrEqualTo(String value) {
            addCriterion("room_id >=", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdLessThan(String value) {
            addCriterion("room_id <", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdLessThanOrEqualTo(String value) {
            addCriterion("room_id <=", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdLike(String value) {
            addCriterion("room_id like", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotLike(String value) {
            addCriterion("room_id not like", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdIn(List<String> values) {
            addCriterion("room_id in", values, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotIn(List<String> values) {
            addCriterion("room_id not in", values, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdBetween(String value1, String value2) {
            addCriterion("room_id between", value1, value2, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotBetween(String value1, String value2) {
            addCriterion("room_id not between", value1, value2, "roomId");
            return (Criteria) this;
        }

        public Criteria andOwnerFlatIsNull() {
            addCriterion("owner_flat is null");
            return (Criteria) this;
        }

        public Criteria andOwnerFlatIsNotNull() {
            addCriterion("owner_flat is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerFlatEqualTo(String value) {
            addCriterion("owner_flat =", value, "ownerFlat");
            return (Criteria) this;
        }

        public Criteria andOwnerFlatNotEqualTo(String value) {
            addCriterion("owner_flat <>", value, "ownerFlat");
            return (Criteria) this;
        }

        public Criteria andOwnerFlatGreaterThan(String value) {
            addCriterion("owner_flat >", value, "ownerFlat");
            return (Criteria) this;
        }

        public Criteria andOwnerFlatGreaterThanOrEqualTo(String value) {
            addCriterion("owner_flat >=", value, "ownerFlat");
            return (Criteria) this;
        }

        public Criteria andOwnerFlatLessThan(String value) {
            addCriterion("owner_flat <", value, "ownerFlat");
            return (Criteria) this;
        }

        public Criteria andOwnerFlatLessThanOrEqualTo(String value) {
            addCriterion("owner_flat <=", value, "ownerFlat");
            return (Criteria) this;
        }

        public Criteria andOwnerFlatLike(String value) {
            addCriterion("owner_flat like", value, "ownerFlat");
            return (Criteria) this;
        }

        public Criteria andOwnerFlatNotLike(String value) {
            addCriterion("owner_flat not like", value, "ownerFlat");
            return (Criteria) this;
        }

        public Criteria andOwnerFlatIn(List<String> values) {
            addCriterion("owner_flat in", values, "ownerFlat");
            return (Criteria) this;
        }

        public Criteria andOwnerFlatNotIn(List<String> values) {
            addCriterion("owner_flat not in", values, "ownerFlat");
            return (Criteria) this;
        }

        public Criteria andOwnerFlatBetween(String value1, String value2) {
            addCriterion("owner_flat between", value1, value2, "ownerFlat");
            return (Criteria) this;
        }

        public Criteria andOwnerFlatNotBetween(String value1, String value2) {
            addCriterion("owner_flat not between", value1, value2, "ownerFlat");
            return (Criteria) this;
        }

        public Criteria andOwnerRoomIsNull() {
            addCriterion("owner_room is null");
            return (Criteria) this;
        }

        public Criteria andOwnerRoomIsNotNull() {
            addCriterion("owner_room is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerRoomEqualTo(String value) {
            addCriterion("owner_room =", value, "ownerRoom");
            return (Criteria) this;
        }

        public Criteria andOwnerRoomNotEqualTo(String value) {
            addCriterion("owner_room <>", value, "ownerRoom");
            return (Criteria) this;
        }

        public Criteria andOwnerRoomGreaterThan(String value) {
            addCriterion("owner_room >", value, "ownerRoom");
            return (Criteria) this;
        }

        public Criteria andOwnerRoomGreaterThanOrEqualTo(String value) {
            addCriterion("owner_room >=", value, "ownerRoom");
            return (Criteria) this;
        }

        public Criteria andOwnerRoomLessThan(String value) {
            addCriterion("owner_room <", value, "ownerRoom");
            return (Criteria) this;
        }

        public Criteria andOwnerRoomLessThanOrEqualTo(String value) {
            addCriterion("owner_room <=", value, "ownerRoom");
            return (Criteria) this;
        }

        public Criteria andOwnerRoomLike(String value) {
            addCriterion("owner_room like", value, "ownerRoom");
            return (Criteria) this;
        }

        public Criteria andOwnerRoomNotLike(String value) {
            addCriterion("owner_room not like", value, "ownerRoom");
            return (Criteria) this;
        }

        public Criteria andOwnerRoomIn(List<String> values) {
            addCriterion("owner_room in", values, "ownerRoom");
            return (Criteria) this;
        }

        public Criteria andOwnerRoomNotIn(List<String> values) {
            addCriterion("owner_room not in", values, "ownerRoom");
            return (Criteria) this;
        }

        public Criteria andOwnerRoomBetween(String value1, String value2) {
            addCriterion("owner_room between", value1, value2, "ownerRoom");
            return (Criteria) this;
        }

        public Criteria andOwnerRoomNotBetween(String value1, String value2) {
            addCriterion("owner_room not between", value1, value2, "ownerRoom");
            return (Criteria) this;
        }

        public Criteria andPlanUseIsNull() {
            addCriterion("plan_use is null");
            return (Criteria) this;
        }

        public Criteria andPlanUseIsNotNull() {
            addCriterion("plan_use is not null");
            return (Criteria) this;
        }

        public Criteria andPlanUseEqualTo(String value) {
            addCriterion("plan_use =", value, "planUse");
            return (Criteria) this;
        }

        public Criteria andPlanUseNotEqualTo(String value) {
            addCriterion("plan_use <>", value, "planUse");
            return (Criteria) this;
        }

        public Criteria andPlanUseGreaterThan(String value) {
            addCriterion("plan_use >", value, "planUse");
            return (Criteria) this;
        }

        public Criteria andPlanUseGreaterThanOrEqualTo(String value) {
            addCriterion("plan_use >=", value, "planUse");
            return (Criteria) this;
        }

        public Criteria andPlanUseLessThan(String value) {
            addCriterion("plan_use <", value, "planUse");
            return (Criteria) this;
        }

        public Criteria andPlanUseLessThanOrEqualTo(String value) {
            addCriterion("plan_use <=", value, "planUse");
            return (Criteria) this;
        }

        public Criteria andPlanUseLike(String value) {
            addCriterion("plan_use like", value, "planUse");
            return (Criteria) this;
        }

        public Criteria andPlanUseNotLike(String value) {
            addCriterion("plan_use not like", value, "planUse");
            return (Criteria) this;
        }

        public Criteria andPlanUseIn(List<String> values) {
            addCriterion("plan_use in", values, "planUse");
            return (Criteria) this;
        }

        public Criteria andPlanUseNotIn(List<String> values) {
            addCriterion("plan_use not in", values, "planUse");
            return (Criteria) this;
        }

        public Criteria andPlanUseBetween(String value1, String value2) {
            addCriterion("plan_use between", value1, value2, "planUse");
            return (Criteria) this;
        }

        public Criteria andPlanUseNotBetween(String value1, String value2) {
            addCriterion("plan_use not between", value1, value2, "planUse");
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

        public Criteria andFuncNameIsNull() {
            addCriterion("func_name is null");
            return (Criteria) this;
        }

        public Criteria andFuncNameIsNotNull() {
            addCriterion("func_name is not null");
            return (Criteria) this;
        }

        public Criteria andFuncNameEqualTo(String value) {
            addCriterion("func_name =", value, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameNotEqualTo(String value) {
            addCriterion("func_name <>", value, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameGreaterThan(String value) {
            addCriterion("func_name >", value, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameGreaterThanOrEqualTo(String value) {
            addCriterion("func_name >=", value, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameLessThan(String value) {
            addCriterion("func_name <", value, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameLessThanOrEqualTo(String value) {
            addCriterion("func_name <=", value, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameLike(String value) {
            addCriterion("func_name like", value, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameNotLike(String value) {
            addCriterion("func_name not like", value, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameIn(List<String> values) {
            addCriterion("func_name in", values, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameNotIn(List<String> values) {
            addCriterion("func_name not in", values, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameBetween(String value1, String value2) {
            addCriterion("func_name between", value1, value2, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameNotBetween(String value1, String value2) {
            addCriterion("func_name not between", value1, value2, "funcName");
            return (Criteria) this;
        }

        public Criteria andMycIsNull() {
            addCriterion("myc is null");
            return (Criteria) this;
        }

        public Criteria andMycIsNotNull() {
            addCriterion("myc is not null");
            return (Criteria) this;
        }

        public Criteria andMycEqualTo(String value) {
            addCriterion("myc =", value, "myc");
            return (Criteria) this;
        }

        public Criteria andMycNotEqualTo(String value) {
            addCriterion("myc <>", value, "myc");
            return (Criteria) this;
        }

        public Criteria andMycGreaterThan(String value) {
            addCriterion("myc >", value, "myc");
            return (Criteria) this;
        }

        public Criteria andMycGreaterThanOrEqualTo(String value) {
            addCriterion("myc >=", value, "myc");
            return (Criteria) this;
        }

        public Criteria andMycLessThan(String value) {
            addCriterion("myc <", value, "myc");
            return (Criteria) this;
        }

        public Criteria andMycLessThanOrEqualTo(String value) {
            addCriterion("myc <=", value, "myc");
            return (Criteria) this;
        }

        public Criteria andMycLike(String value) {
            addCriterion("myc like", value, "myc");
            return (Criteria) this;
        }

        public Criteria andMycNotLike(String value) {
            addCriterion("myc not like", value, "myc");
            return (Criteria) this;
        }

        public Criteria andMycIn(List<String> values) {
            addCriterion("myc in", values, "myc");
            return (Criteria) this;
        }

        public Criteria andMycNotIn(List<String> values) {
            addCriterion("myc not in", values, "myc");
            return (Criteria) this;
        }

        public Criteria andMycBetween(String value1, String value2) {
            addCriterion("myc between", value1, value2, "myc");
            return (Criteria) this;
        }

        public Criteria andMycNotBetween(String value1, String value2) {
            addCriterion("myc not between", value1, value2, "myc");
            return (Criteria) this;
        }

        public Criteria andZrzzcIsNull() {
            addCriterion("zrzzc is null");
            return (Criteria) this;
        }

        public Criteria andZrzzcIsNotNull() {
            addCriterion("zrzzc is not null");
            return (Criteria) this;
        }

        public Criteria andZrzzcEqualTo(String value) {
            addCriterion("zrzzc =", value, "zrzzc");
            return (Criteria) this;
        }

        public Criteria andZrzzcNotEqualTo(String value) {
            addCriterion("zrzzc <>", value, "zrzzc");
            return (Criteria) this;
        }

        public Criteria andZrzzcGreaterThan(String value) {
            addCriterion("zrzzc >", value, "zrzzc");
            return (Criteria) this;
        }

        public Criteria andZrzzcGreaterThanOrEqualTo(String value) {
            addCriterion("zrzzc >=", value, "zrzzc");
            return (Criteria) this;
        }

        public Criteria andZrzzcLessThan(String value) {
            addCriterion("zrzzc <", value, "zrzzc");
            return (Criteria) this;
        }

        public Criteria andZrzzcLessThanOrEqualTo(String value) {
            addCriterion("zrzzc <=", value, "zrzzc");
            return (Criteria) this;
        }

        public Criteria andZrzzcLike(String value) {
            addCriterion("zrzzc like", value, "zrzzc");
            return (Criteria) this;
        }

        public Criteria andZrzzcNotLike(String value) {
            addCriterion("zrzzc not like", value, "zrzzc");
            return (Criteria) this;
        }

        public Criteria andZrzzcIn(List<String> values) {
            addCriterion("zrzzc in", values, "zrzzc");
            return (Criteria) this;
        }

        public Criteria andZrzzcNotIn(List<String> values) {
            addCriterion("zrzzc not in", values, "zrzzc");
            return (Criteria) this;
        }

        public Criteria andZrzzcBetween(String value1, String value2) {
            addCriterion("zrzzc between", value1, value2, "zrzzc");
            return (Criteria) this;
        }

        public Criteria andZrzzcNotBetween(String value1, String value2) {
            addCriterion("zrzzc not between", value1, value2, "zrzzc");
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