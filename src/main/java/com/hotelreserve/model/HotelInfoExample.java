package com.hotelreserve.model;

import java.util.ArrayList;
import java.util.List;

public class HotelInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HotelInfoExample() {
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

        public Criteria andHotelnameIsNull() {
            addCriterion("hotelName is null");
            return (Criteria) this;
        }

        public Criteria andHotelnameIsNotNull() {
            addCriterion("hotelName is not null");
            return (Criteria) this;
        }

        public Criteria andHotelnameEqualTo(String value) {
            addCriterion("hotelName =", value, "hotelname");
            return (Criteria) this;
        }

        public Criteria andHotelnameNotEqualTo(String value) {
            addCriterion("hotelName <>", value, "hotelname");
            return (Criteria) this;
        }

        public Criteria andHotelnameGreaterThan(String value) {
            addCriterion("hotelName >", value, "hotelname");
            return (Criteria) this;
        }

        public Criteria andHotelnameGreaterThanOrEqualTo(String value) {
            addCriterion("hotelName >=", value, "hotelname");
            return (Criteria) this;
        }

        public Criteria andHotelnameLessThan(String value) {
            addCriterion("hotelName <", value, "hotelname");
            return (Criteria) this;
        }

        public Criteria andHotelnameLessThanOrEqualTo(String value) {
            addCriterion("hotelName <=", value, "hotelname");
            return (Criteria) this;
        }

        public Criteria andHotelnameLike(String value) {
            addCriterion("hotelName like", value, "hotelname");
            return (Criteria) this;
        }

        public Criteria andHotelnameNotLike(String value) {
            addCriterion("hotelName not like", value, "hotelname");
            return (Criteria) this;
        }

        public Criteria andHotelnameIn(List<String> values) {
            addCriterion("hotelName in", values, "hotelname");
            return (Criteria) this;
        }

        public Criteria andHotelnameNotIn(List<String> values) {
            addCriterion("hotelName not in", values, "hotelname");
            return (Criteria) this;
        }

        public Criteria andHotelnameBetween(String value1, String value2) {
            addCriterion("hotelName between", value1, value2, "hotelname");
            return (Criteria) this;
        }

        public Criteria andHotelnameNotBetween(String value1, String value2) {
            addCriterion("hotelName not between", value1, value2, "hotelname");
            return (Criteria) this;
        }

        public Criteria andHoteladdressIsNull() {
            addCriterion("hotelAddress is null");
            return (Criteria) this;
        }

        public Criteria andHoteladdressIsNotNull() {
            addCriterion("hotelAddress is not null");
            return (Criteria) this;
        }

        public Criteria andHoteladdressEqualTo(String value) {
            addCriterion("hotelAddress =", value, "hoteladdress");
            return (Criteria) this;
        }

        public Criteria andHoteladdressNotEqualTo(String value) {
            addCriterion("hotelAddress <>", value, "hoteladdress");
            return (Criteria) this;
        }

        public Criteria andHoteladdressGreaterThan(String value) {
            addCriterion("hotelAddress >", value, "hoteladdress");
            return (Criteria) this;
        }

        public Criteria andHoteladdressGreaterThanOrEqualTo(String value) {
            addCriterion("hotelAddress >=", value, "hoteladdress");
            return (Criteria) this;
        }

        public Criteria andHoteladdressLessThan(String value) {
            addCriterion("hotelAddress <", value, "hoteladdress");
            return (Criteria) this;
        }

        public Criteria andHoteladdressLessThanOrEqualTo(String value) {
            addCriterion("hotelAddress <=", value, "hoteladdress");
            return (Criteria) this;
        }

        public Criteria andHoteladdressLike(String value) {
            addCriterion("hotelAddress like", value, "hoteladdress");
            return (Criteria) this;
        }

        public Criteria andHoteladdressNotLike(String value) {
            addCriterion("hotelAddress not like", value, "hoteladdress");
            return (Criteria) this;
        }

        public Criteria andHoteladdressIn(List<String> values) {
            addCriterion("hotelAddress in", values, "hoteladdress");
            return (Criteria) this;
        }

        public Criteria andHoteladdressNotIn(List<String> values) {
            addCriterion("hotelAddress not in", values, "hoteladdress");
            return (Criteria) this;
        }

        public Criteria andHoteladdressBetween(String value1, String value2) {
            addCriterion("hotelAddress between", value1, value2, "hoteladdress");
            return (Criteria) this;
        }

        public Criteria andHoteladdressNotBetween(String value1, String value2) {
            addCriterion("hotelAddress not between", value1, value2, "hoteladdress");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andFacilityIsNull() {
            addCriterion("facility is null");
            return (Criteria) this;
        }

        public Criteria andFacilityIsNotNull() {
            addCriterion("facility is not null");
            return (Criteria) this;
        }

        public Criteria andFacilityEqualTo(String value) {
            addCriterion("facility =", value, "facility");
            return (Criteria) this;
        }

        public Criteria andFacilityNotEqualTo(String value) {
            addCriterion("facility <>", value, "facility");
            return (Criteria) this;
        }

        public Criteria andFacilityGreaterThan(String value) {
            addCriterion("facility >", value, "facility");
            return (Criteria) this;
        }

        public Criteria andFacilityGreaterThanOrEqualTo(String value) {
            addCriterion("facility >=", value, "facility");
            return (Criteria) this;
        }

        public Criteria andFacilityLessThan(String value) {
            addCriterion("facility <", value, "facility");
            return (Criteria) this;
        }

        public Criteria andFacilityLessThanOrEqualTo(String value) {
            addCriterion("facility <=", value, "facility");
            return (Criteria) this;
        }

        public Criteria andFacilityLike(String value) {
            addCriterion("facility like", value, "facility");
            return (Criteria) this;
        }

        public Criteria andFacilityNotLike(String value) {
            addCriterion("facility not like", value, "facility");
            return (Criteria) this;
        }

        public Criteria andFacilityIn(List<String> values) {
            addCriterion("facility in", values, "facility");
            return (Criteria) this;
        }

        public Criteria andFacilityNotIn(List<String> values) {
            addCriterion("facility not in", values, "facility");
            return (Criteria) this;
        }

        public Criteria andFacilityBetween(String value1, String value2) {
            addCriterion("facility between", value1, value2, "facility");
            return (Criteria) this;
        }

        public Criteria andFacilityNotBetween(String value1, String value2) {
            addCriterion("facility not between", value1, value2, "facility");
            return (Criteria) this;
        }

        public Criteria andHoteltextIsNull() {
            addCriterion("hotelText is null");
            return (Criteria) this;
        }

        public Criteria andHoteltextIsNotNull() {
            addCriterion("hotelText is not null");
            return (Criteria) this;
        }

        public Criteria andHoteltextEqualTo(String value) {
            addCriterion("hotelText =", value, "hoteltext");
            return (Criteria) this;
        }

        public Criteria andHoteltextNotEqualTo(String value) {
            addCriterion("hotelText <>", value, "hoteltext");
            return (Criteria) this;
        }

        public Criteria andHoteltextGreaterThan(String value) {
            addCriterion("hotelText >", value, "hoteltext");
            return (Criteria) this;
        }

        public Criteria andHoteltextGreaterThanOrEqualTo(String value) {
            addCriterion("hotelText >=", value, "hoteltext");
            return (Criteria) this;
        }

        public Criteria andHoteltextLessThan(String value) {
            addCriterion("hotelText <", value, "hoteltext");
            return (Criteria) this;
        }

        public Criteria andHoteltextLessThanOrEqualTo(String value) {
            addCriterion("hotelText <=", value, "hoteltext");
            return (Criteria) this;
        }

        public Criteria andHoteltextLike(String value) {
            addCriterion("hotelText like", value, "hoteltext");
            return (Criteria) this;
        }

        public Criteria andHoteltextNotLike(String value) {
            addCriterion("hotelText not like", value, "hoteltext");
            return (Criteria) this;
        }

        public Criteria andHoteltextIn(List<String> values) {
            addCriterion("hotelText in", values, "hoteltext");
            return (Criteria) this;
        }

        public Criteria andHoteltextNotIn(List<String> values) {
            addCriterion("hotelText not in", values, "hoteltext");
            return (Criteria) this;
        }

        public Criteria andHoteltextBetween(String value1, String value2) {
            addCriterion("hotelText between", value1, value2, "hoteltext");
            return (Criteria) this;
        }

        public Criteria andHoteltextNotBetween(String value1, String value2) {
            addCriterion("hotelText not between", value1, value2, "hoteltext");
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