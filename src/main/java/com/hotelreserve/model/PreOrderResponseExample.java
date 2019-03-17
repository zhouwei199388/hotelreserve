package com.hotelreserve.model;

import java.util.ArrayList;
import java.util.List;

public class PreOrderResponseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PreOrderResponseExample() {
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

        public Criteria andOrderidIsNull() {
            addCriterion("orderId is null");
            return (Criteria) this;
        }

        public Criteria andOrderidIsNotNull() {
            addCriterion("orderId is not null");
            return (Criteria) this;
        }

        public Criteria andOrderidEqualTo(Integer value) {
            addCriterion("orderId =", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotEqualTo(Integer value) {
            addCriterion("orderId <>", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidGreaterThan(Integer value) {
            addCriterion("orderId >", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidGreaterThanOrEqualTo(Integer value) {
            addCriterion("orderId >=", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLessThan(Integer value) {
            addCriterion("orderId <", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLessThanOrEqualTo(Integer value) {
            addCriterion("orderId <=", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidIn(List<Integer> values) {
            addCriterion("orderId in", values, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotIn(List<Integer> values) {
            addCriterion("orderId not in", values, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidBetween(Integer value1, Integer value2) {
            addCriterion("orderId between", value1, value2, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotBetween(Integer value1, Integer value2) {
            addCriterion("orderId not between", value1, value2, "orderid");
            return (Criteria) this;
        }

        public Criteria andNoncestrIsNull() {
            addCriterion("noncestr is null");
            return (Criteria) this;
        }

        public Criteria andNoncestrIsNotNull() {
            addCriterion("noncestr is not null");
            return (Criteria) this;
        }

        public Criteria andNoncestrEqualTo(String value) {
            addCriterion("noncestr =", value, "noncestr");
            return (Criteria) this;
        }

        public Criteria andNoncestrNotEqualTo(String value) {
            addCriterion("noncestr <>", value, "noncestr");
            return (Criteria) this;
        }

        public Criteria andNoncestrGreaterThan(String value) {
            addCriterion("noncestr >", value, "noncestr");
            return (Criteria) this;
        }

        public Criteria andNoncestrGreaterThanOrEqualTo(String value) {
            addCriterion("noncestr >=", value, "noncestr");
            return (Criteria) this;
        }

        public Criteria andNoncestrLessThan(String value) {
            addCriterion("noncestr <", value, "noncestr");
            return (Criteria) this;
        }

        public Criteria andNoncestrLessThanOrEqualTo(String value) {
            addCriterion("noncestr <=", value, "noncestr");
            return (Criteria) this;
        }

        public Criteria andNoncestrLike(String value) {
            addCriterion("noncestr like", value, "noncestr");
            return (Criteria) this;
        }

        public Criteria andNoncestrNotLike(String value) {
            addCriterion("noncestr not like", value, "noncestr");
            return (Criteria) this;
        }

        public Criteria andNoncestrIn(List<String> values) {
            addCriterion("noncestr in", values, "noncestr");
            return (Criteria) this;
        }

        public Criteria andNoncestrNotIn(List<String> values) {
            addCriterion("noncestr not in", values, "noncestr");
            return (Criteria) this;
        }

        public Criteria andNoncestrBetween(String value1, String value2) {
            addCriterion("noncestr between", value1, value2, "noncestr");
            return (Criteria) this;
        }

        public Criteria andNoncestrNotBetween(String value1, String value2) {
            addCriterion("noncestr not between", value1, value2, "noncestr");
            return (Criteria) this;
        }

        public Criteria andPackagestrIsNull() {
            addCriterion("packagestr is null");
            return (Criteria) this;
        }

        public Criteria andPackagestrIsNotNull() {
            addCriterion("packagestr is not null");
            return (Criteria) this;
        }

        public Criteria andPackagestrEqualTo(String value) {
            addCriterion("packagestr =", value, "packagestr");
            return (Criteria) this;
        }

        public Criteria andPackagestrNotEqualTo(String value) {
            addCriterion("packagestr <>", value, "packagestr");
            return (Criteria) this;
        }

        public Criteria andPackagestrGreaterThan(String value) {
            addCriterion("packagestr >", value, "packagestr");
            return (Criteria) this;
        }

        public Criteria andPackagestrGreaterThanOrEqualTo(String value) {
            addCriterion("packagestr >=", value, "packagestr");
            return (Criteria) this;
        }

        public Criteria andPackagestrLessThan(String value) {
            addCriterion("packagestr <", value, "packagestr");
            return (Criteria) this;
        }

        public Criteria andPackagestrLessThanOrEqualTo(String value) {
            addCriterion("packagestr <=", value, "packagestr");
            return (Criteria) this;
        }

        public Criteria andPackagestrLike(String value) {
            addCriterion("packagestr like", value, "packagestr");
            return (Criteria) this;
        }

        public Criteria andPackagestrNotLike(String value) {
            addCriterion("packagestr not like", value, "packagestr");
            return (Criteria) this;
        }

        public Criteria andPackagestrIn(List<String> values) {
            addCriterion("packagestr in", values, "packagestr");
            return (Criteria) this;
        }

        public Criteria andPackagestrNotIn(List<String> values) {
            addCriterion("packagestr not in", values, "packagestr");
            return (Criteria) this;
        }

        public Criteria andPackagestrBetween(String value1, String value2) {
            addCriterion("packagestr between", value1, value2, "packagestr");
            return (Criteria) this;
        }

        public Criteria andPackagestrNotBetween(String value1, String value2) {
            addCriterion("packagestr not between", value1, value2, "packagestr");
            return (Criteria) this;
        }

        public Criteria andTimestamapIsNull() {
            addCriterion("timestamap is null");
            return (Criteria) this;
        }

        public Criteria andTimestamapIsNotNull() {
            addCriterion("timestamap is not null");
            return (Criteria) this;
        }

        public Criteria andTimestamapEqualTo(String value) {
            addCriterion("timestamap =", value, "timestamap");
            return (Criteria) this;
        }

        public Criteria andTimestamapNotEqualTo(String value) {
            addCriterion("timestamap <>", value, "timestamap");
            return (Criteria) this;
        }

        public Criteria andTimestamapGreaterThan(String value) {
            addCriterion("timestamap >", value, "timestamap");
            return (Criteria) this;
        }

        public Criteria andTimestamapGreaterThanOrEqualTo(String value) {
            addCriterion("timestamap >=", value, "timestamap");
            return (Criteria) this;
        }

        public Criteria andTimestamapLessThan(String value) {
            addCriterion("timestamap <", value, "timestamap");
            return (Criteria) this;
        }

        public Criteria andTimestamapLessThanOrEqualTo(String value) {
            addCriterion("timestamap <=", value, "timestamap");
            return (Criteria) this;
        }

        public Criteria andTimestamapLike(String value) {
            addCriterion("timestamap like", value, "timestamap");
            return (Criteria) this;
        }

        public Criteria andTimestamapNotLike(String value) {
            addCriterion("timestamap not like", value, "timestamap");
            return (Criteria) this;
        }

        public Criteria andTimestamapIn(List<String> values) {
            addCriterion("timestamap in", values, "timestamap");
            return (Criteria) this;
        }

        public Criteria andTimestamapNotIn(List<String> values) {
            addCriterion("timestamap not in", values, "timestamap");
            return (Criteria) this;
        }

        public Criteria andTimestamapBetween(String value1, String value2) {
            addCriterion("timestamap between", value1, value2, "timestamap");
            return (Criteria) this;
        }

        public Criteria andTimestamapNotBetween(String value1, String value2) {
            addCriterion("timestamap not between", value1, value2, "timestamap");
            return (Criteria) this;
        }

        public Criteria andPaysignIsNull() {
            addCriterion("paysign is null");
            return (Criteria) this;
        }

        public Criteria andPaysignIsNotNull() {
            addCriterion("paysign is not null");
            return (Criteria) this;
        }

        public Criteria andPaysignEqualTo(String value) {
            addCriterion("paysign =", value, "paysign");
            return (Criteria) this;
        }

        public Criteria andPaysignNotEqualTo(String value) {
            addCriterion("paysign <>", value, "paysign");
            return (Criteria) this;
        }

        public Criteria andPaysignGreaterThan(String value) {
            addCriterion("paysign >", value, "paysign");
            return (Criteria) this;
        }

        public Criteria andPaysignGreaterThanOrEqualTo(String value) {
            addCriterion("paysign >=", value, "paysign");
            return (Criteria) this;
        }

        public Criteria andPaysignLessThan(String value) {
            addCriterion("paysign <", value, "paysign");
            return (Criteria) this;
        }

        public Criteria andPaysignLessThanOrEqualTo(String value) {
            addCriterion("paysign <=", value, "paysign");
            return (Criteria) this;
        }

        public Criteria andPaysignLike(String value) {
            addCriterion("paysign like", value, "paysign");
            return (Criteria) this;
        }

        public Criteria andPaysignNotLike(String value) {
            addCriterion("paysign not like", value, "paysign");
            return (Criteria) this;
        }

        public Criteria andPaysignIn(List<String> values) {
            addCriterion("paysign in", values, "paysign");
            return (Criteria) this;
        }

        public Criteria andPaysignNotIn(List<String> values) {
            addCriterion("paysign not in", values, "paysign");
            return (Criteria) this;
        }

        public Criteria andPaysignBetween(String value1, String value2) {
            addCriterion("paysign between", value1, value2, "paysign");
            return (Criteria) this;
        }

        public Criteria andPaysignNotBetween(String value1, String value2) {
            addCriterion("paysign not between", value1, value2, "paysign");
            return (Criteria) this;
        }

        public Criteria andAppidIsNull() {
            addCriterion("appid is null");
            return (Criteria) this;
        }

        public Criteria andAppidIsNotNull() {
            addCriterion("appid is not null");
            return (Criteria) this;
        }

        public Criteria andAppidEqualTo(String value) {
            addCriterion("appid =", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotEqualTo(String value) {
            addCriterion("appid <>", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidGreaterThan(String value) {
            addCriterion("appid >", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidGreaterThanOrEqualTo(String value) {
            addCriterion("appid >=", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidLessThan(String value) {
            addCriterion("appid <", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidLessThanOrEqualTo(String value) {
            addCriterion("appid <=", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidLike(String value) {
            addCriterion("appid like", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotLike(String value) {
            addCriterion("appid not like", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidIn(List<String> values) {
            addCriterion("appid in", values, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotIn(List<String> values) {
            addCriterion("appid not in", values, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidBetween(String value1, String value2) {
            addCriterion("appid between", value1, value2, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotBetween(String value1, String value2) {
            addCriterion("appid not between", value1, value2, "appid");
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