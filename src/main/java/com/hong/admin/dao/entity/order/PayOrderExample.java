package com.hong.admin.dao.entity.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PayOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PayOrderExample() {
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

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Integer value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Integer value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Integer value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Integer value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Integer> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Integer> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andCodeIsNull() {
            addCriterion("code is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("code is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("code =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("code <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("code >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("code >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("code <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("code <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("code like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("code not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("code in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("code not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("code between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("code not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andNurseNameIsNull() {
            addCriterion("nurse_name is null");
            return (Criteria) this;
        }

        public Criteria andNurseNameIsNotNull() {
            addCriterion("nurse_name is not null");
            return (Criteria) this;
        }

        public Criteria andNurseNameEqualTo(String value) {
            addCriterion("nurse_name =", value, "nurseName");
            return (Criteria) this;
        }

        public Criteria andNurseNameNotEqualTo(String value) {
            addCriterion("nurse_name <>", value, "nurseName");
            return (Criteria) this;
        }

        public Criteria andNurseNameGreaterThan(String value) {
            addCriterion("nurse_name >", value, "nurseName");
            return (Criteria) this;
        }

        public Criteria andNurseNameGreaterThanOrEqualTo(String value) {
            addCriterion("nurse_name >=", value, "nurseName");
            return (Criteria) this;
        }

        public Criteria andNurseNameLessThan(String value) {
            addCriterion("nurse_name <", value, "nurseName");
            return (Criteria) this;
        }

        public Criteria andNurseNameLessThanOrEqualTo(String value) {
            addCriterion("nurse_name <=", value, "nurseName");
            return (Criteria) this;
        }

        public Criteria andNurseNameLike(String value) {
            addCriterion("nurse_name like", value, "nurseName");
            return (Criteria) this;
        }

        public Criteria andNurseNameNotLike(String value) {
            addCriterion("nurse_name not like", value, "nurseName");
            return (Criteria) this;
        }

        public Criteria andNurseNameIn(List<String> values) {
            addCriterion("nurse_name in", values, "nurseName");
            return (Criteria) this;
        }

        public Criteria andNurseNameNotIn(List<String> values) {
            addCriterion("nurse_name not in", values, "nurseName");
            return (Criteria) this;
        }

        public Criteria andNurseNameBetween(String value1, String value2) {
            addCriterion("nurse_name between", value1, value2, "nurseName");
            return (Criteria) this;
        }

        public Criteria andNurseNameNotBetween(String value1, String value2) {
            addCriterion("nurse_name not between", value1, value2, "nurseName");
            return (Criteria) this;
        }

        public Criteria andNursePhoneIsNull() {
            addCriterion("nurse_phone is null");
            return (Criteria) this;
        }

        public Criteria andNursePhoneIsNotNull() {
            addCriterion("nurse_phone is not null");
            return (Criteria) this;
        }

        public Criteria andNursePhoneEqualTo(String value) {
            addCriterion("nurse_phone =", value, "nursePhone");
            return (Criteria) this;
        }

        public Criteria andNursePhoneNotEqualTo(String value) {
            addCriterion("nurse_phone <>", value, "nursePhone");
            return (Criteria) this;
        }

        public Criteria andNursePhoneGreaterThan(String value) {
            addCriterion("nurse_phone >", value, "nursePhone");
            return (Criteria) this;
        }

        public Criteria andNursePhoneGreaterThanOrEqualTo(String value) {
            addCriterion("nurse_phone >=", value, "nursePhone");
            return (Criteria) this;
        }

        public Criteria andNursePhoneLessThan(String value) {
            addCriterion("nurse_phone <", value, "nursePhone");
            return (Criteria) this;
        }

        public Criteria andNursePhoneLessThanOrEqualTo(String value) {
            addCriterion("nurse_phone <=", value, "nursePhone");
            return (Criteria) this;
        }

        public Criteria andNursePhoneLike(String value) {
            addCriterion("nurse_phone like", value, "nursePhone");
            return (Criteria) this;
        }

        public Criteria andNursePhoneNotLike(String value) {
            addCriterion("nurse_phone not like", value, "nursePhone");
            return (Criteria) this;
        }

        public Criteria andNursePhoneIn(List<String> values) {
            addCriterion("nurse_phone in", values, "nursePhone");
            return (Criteria) this;
        }

        public Criteria andNursePhoneNotIn(List<String> values) {
            addCriterion("nurse_phone not in", values, "nursePhone");
            return (Criteria) this;
        }

        public Criteria andNursePhoneBetween(String value1, String value2) {
            addCriterion("nurse_phone between", value1, value2, "nursePhone");
            return (Criteria) this;
        }

        public Criteria andNursePhoneNotBetween(String value1, String value2) {
            addCriterion("nurse_phone not between", value1, value2, "nursePhone");
            return (Criteria) this;
        }

        public Criteria andNurseIdIsNull() {
            addCriterion("nurse_id is null");
            return (Criteria) this;
        }

        public Criteria andNurseIdIsNotNull() {
            addCriterion("nurse_id is not null");
            return (Criteria) this;
        }

        public Criteria andNurseIdEqualTo(Integer value) {
            addCriterion("nurse_id =", value, "nurseId");
            return (Criteria) this;
        }

        public Criteria andNurseIdNotEqualTo(Integer value) {
            addCriterion("nurse_id <>", value, "nurseId");
            return (Criteria) this;
        }

        public Criteria andNurseIdGreaterThan(Integer value) {
            addCriterion("nurse_id >", value, "nurseId");
            return (Criteria) this;
        }

        public Criteria andNurseIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("nurse_id >=", value, "nurseId");
            return (Criteria) this;
        }

        public Criteria andNurseIdLessThan(Integer value) {
            addCriterion("nurse_id <", value, "nurseId");
            return (Criteria) this;
        }

        public Criteria andNurseIdLessThanOrEqualTo(Integer value) {
            addCriterion("nurse_id <=", value, "nurseId");
            return (Criteria) this;
        }

        public Criteria andNurseIdIn(List<Integer> values) {
            addCriterion("nurse_id in", values, "nurseId");
            return (Criteria) this;
        }

        public Criteria andNurseIdNotIn(List<Integer> values) {
            addCriterion("nurse_id not in", values, "nurseId");
            return (Criteria) this;
        }

        public Criteria andNurseIdBetween(Integer value1, Integer value2) {
            addCriterion("nurse_id between", value1, value2, "nurseId");
            return (Criteria) this;
        }

        public Criteria andNurseIdNotBetween(Integer value1, Integer value2) {
            addCriterion("nurse_id not between", value1, value2, "nurseId");
            return (Criteria) this;
        }

        public Criteria andBrokerIdIsNull() {
            addCriterion("broker_id is null");
            return (Criteria) this;
        }

        public Criteria andBrokerIdIsNotNull() {
            addCriterion("broker_id is not null");
            return (Criteria) this;
        }

        public Criteria andBrokerIdEqualTo(Integer value) {
            addCriterion("broker_id =", value, "brokerId");
            return (Criteria) this;
        }

        public Criteria andBrokerIdNotEqualTo(Integer value) {
            addCriterion("broker_id <>", value, "brokerId");
            return (Criteria) this;
        }

        public Criteria andBrokerIdGreaterThan(Integer value) {
            addCriterion("broker_id >", value, "brokerId");
            return (Criteria) this;
        }

        public Criteria andBrokerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("broker_id >=", value, "brokerId");
            return (Criteria) this;
        }

        public Criteria andBrokerIdLessThan(Integer value) {
            addCriterion("broker_id <", value, "brokerId");
            return (Criteria) this;
        }

        public Criteria andBrokerIdLessThanOrEqualTo(Integer value) {
            addCriterion("broker_id <=", value, "brokerId");
            return (Criteria) this;
        }

        public Criteria andBrokerIdIn(List<Integer> values) {
            addCriterion("broker_id in", values, "brokerId");
            return (Criteria) this;
        }

        public Criteria andBrokerIdNotIn(List<Integer> values) {
            addCriterion("broker_id not in", values, "brokerId");
            return (Criteria) this;
        }

        public Criteria andBrokerIdBetween(Integer value1, Integer value2) {
            addCriterion("broker_id between", value1, value2, "brokerId");
            return (Criteria) this;
        }

        public Criteria andBrokerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("broker_id not between", value1, value2, "brokerId");
            return (Criteria) this;
        }

        public Criteria andBrokerNameIsNull() {
            addCriterion("broker_name is null");
            return (Criteria) this;
        }

        public Criteria andBrokerNameIsNotNull() {
            addCriterion("broker_name is not null");
            return (Criteria) this;
        }

        public Criteria andBrokerNameEqualTo(String value) {
            addCriterion("broker_name =", value, "brokerName");
            return (Criteria) this;
        }

        public Criteria andBrokerNameNotEqualTo(String value) {
            addCriterion("broker_name <>", value, "brokerName");
            return (Criteria) this;
        }

        public Criteria andBrokerNameGreaterThan(String value) {
            addCriterion("broker_name >", value, "brokerName");
            return (Criteria) this;
        }

        public Criteria andBrokerNameGreaterThanOrEqualTo(String value) {
            addCriterion("broker_name >=", value, "brokerName");
            return (Criteria) this;
        }

        public Criteria andBrokerNameLessThan(String value) {
            addCriterion("broker_name <", value, "brokerName");
            return (Criteria) this;
        }

        public Criteria andBrokerNameLessThanOrEqualTo(String value) {
            addCriterion("broker_name <=", value, "brokerName");
            return (Criteria) this;
        }

        public Criteria andBrokerNameLike(String value) {
            addCriterion("broker_name like", value, "brokerName");
            return (Criteria) this;
        }

        public Criteria andBrokerNameNotLike(String value) {
            addCriterion("broker_name not like", value, "brokerName");
            return (Criteria) this;
        }

        public Criteria andBrokerNameIn(List<String> values) {
            addCriterion("broker_name in", values, "brokerName");
            return (Criteria) this;
        }

        public Criteria andBrokerNameNotIn(List<String> values) {
            addCriterion("broker_name not in", values, "brokerName");
            return (Criteria) this;
        }

        public Criteria andBrokerNameBetween(String value1, String value2) {
            addCriterion("broker_name between", value1, value2, "brokerName");
            return (Criteria) this;
        }

        public Criteria andBrokerNameNotBetween(String value1, String value2) {
            addCriterion("broker_name not between", value1, value2, "brokerName");
            return (Criteria) this;
        }

        public Criteria andBrokerPhoneIsNull() {
            addCriterion("broker_phone is null");
            return (Criteria) this;
        }

        public Criteria andBrokerPhoneIsNotNull() {
            addCriterion("broker_phone is not null");
            return (Criteria) this;
        }

        public Criteria andBrokerPhoneEqualTo(String value) {
            addCriterion("broker_phone =", value, "brokerPhone");
            return (Criteria) this;
        }

        public Criteria andBrokerPhoneNotEqualTo(String value) {
            addCriterion("broker_phone <>", value, "brokerPhone");
            return (Criteria) this;
        }

        public Criteria andBrokerPhoneGreaterThan(String value) {
            addCriterion("broker_phone >", value, "brokerPhone");
            return (Criteria) this;
        }

        public Criteria andBrokerPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("broker_phone >=", value, "brokerPhone");
            return (Criteria) this;
        }

        public Criteria andBrokerPhoneLessThan(String value) {
            addCriterion("broker_phone <", value, "brokerPhone");
            return (Criteria) this;
        }

        public Criteria andBrokerPhoneLessThanOrEqualTo(String value) {
            addCriterion("broker_phone <=", value, "brokerPhone");
            return (Criteria) this;
        }

        public Criteria andBrokerPhoneLike(String value) {
            addCriterion("broker_phone like", value, "brokerPhone");
            return (Criteria) this;
        }

        public Criteria andBrokerPhoneNotLike(String value) {
            addCriterion("broker_phone not like", value, "brokerPhone");
            return (Criteria) this;
        }

        public Criteria andBrokerPhoneIn(List<String> values) {
            addCriterion("broker_phone in", values, "brokerPhone");
            return (Criteria) this;
        }

        public Criteria andBrokerPhoneNotIn(List<String> values) {
            addCriterion("broker_phone not in", values, "brokerPhone");
            return (Criteria) this;
        }

        public Criteria andBrokerPhoneBetween(String value1, String value2) {
            addCriterion("broker_phone between", value1, value2, "brokerPhone");
            return (Criteria) this;
        }

        public Criteria andBrokerPhoneNotBetween(String value1, String value2) {
            addCriterion("broker_phone not between", value1, value2, "brokerPhone");
            return (Criteria) this;
        }

        public Criteria andFwfIsNull() {
            addCriterion("fwf is null");
            return (Criteria) this;
        }

        public Criteria andFwfIsNotNull() {
            addCriterion("fwf is not null");
            return (Criteria) this;
        }

        public Criteria andFwfEqualTo(Float value) {
            addCriterion("fwf =", value, "fwf");
            return (Criteria) this;
        }

        public Criteria andFwfNotEqualTo(Float value) {
            addCriterion("fwf <>", value, "fwf");
            return (Criteria) this;
        }

        public Criteria andFwfGreaterThan(Float value) {
            addCriterion("fwf >", value, "fwf");
            return (Criteria) this;
        }

        public Criteria andFwfGreaterThanOrEqualTo(Float value) {
            addCriterion("fwf >=", value, "fwf");
            return (Criteria) this;
        }

        public Criteria andFwfLessThan(Float value) {
            addCriterion("fwf <", value, "fwf");
            return (Criteria) this;
        }

        public Criteria andFwfLessThanOrEqualTo(Float value) {
            addCriterion("fwf <=", value, "fwf");
            return (Criteria) this;
        }

        public Criteria andFwfIn(List<Float> values) {
            addCriterion("fwf in", values, "fwf");
            return (Criteria) this;
        }

        public Criteria andFwfNotIn(List<Float> values) {
            addCriterion("fwf not in", values, "fwf");
            return (Criteria) this;
        }

        public Criteria andFwfBetween(Float value1, Float value2) {
            addCriterion("fwf between", value1, value2, "fwf");
            return (Criteria) this;
        }

        public Criteria andFwfNotBetween(Float value1, Float value2) {
            addCriterion("fwf not between", value1, value2, "fwf");
            return (Criteria) this;
        }

        public Criteria andDjIsNull() {
            addCriterion("dj is null");
            return (Criteria) this;
        }

        public Criteria andDjIsNotNull() {
            addCriterion("dj is not null");
            return (Criteria) this;
        }

        public Criteria andDjEqualTo(Integer value) {
            addCriterion("dj =", value, "dj");
            return (Criteria) this;
        }

        public Criteria andDjNotEqualTo(Integer value) {
            addCriterion("dj <>", value, "dj");
            return (Criteria) this;
        }

        public Criteria andDjGreaterThan(Integer value) {
            addCriterion("dj >", value, "dj");
            return (Criteria) this;
        }

        public Criteria andDjGreaterThanOrEqualTo(Integer value) {
            addCriterion("dj >=", value, "dj");
            return (Criteria) this;
        }

        public Criteria andDjLessThan(Integer value) {
            addCriterion("dj <", value, "dj");
            return (Criteria) this;
        }

        public Criteria andDjLessThanOrEqualTo(Integer value) {
            addCriterion("dj <=", value, "dj");
            return (Criteria) this;
        }

        public Criteria andDjIn(List<Integer> values) {
            addCriterion("dj in", values, "dj");
            return (Criteria) this;
        }

        public Criteria andDjNotIn(List<Integer> values) {
            addCriterion("dj not in", values, "dj");
            return (Criteria) this;
        }

        public Criteria andDjBetween(Integer value1, Integer value2) {
            addCriterion("dj between", value1, value2, "dj");
            return (Criteria) this;
        }

        public Criteria andDjNotBetween(Integer value1, Integer value2) {
            addCriterion("dj not between", value1, value2, "dj");
            return (Criteria) this;
        }

        public Criteria andKhzfIsNull() {
            addCriterion("khzf is null");
            return (Criteria) this;
        }

        public Criteria andKhzfIsNotNull() {
            addCriterion("khzf is not null");
            return (Criteria) this;
        }

        public Criteria andKhzfEqualTo(Float value) {
            addCriterion("khzf =", value, "khzf");
            return (Criteria) this;
        }

        public Criteria andKhzfNotEqualTo(Float value) {
            addCriterion("khzf <>", value, "khzf");
            return (Criteria) this;
        }

        public Criteria andKhzfGreaterThan(Float value) {
            addCriterion("khzf >", value, "khzf");
            return (Criteria) this;
        }

        public Criteria andKhzfGreaterThanOrEqualTo(Float value) {
            addCriterion("khzf >=", value, "khzf");
            return (Criteria) this;
        }

        public Criteria andKhzfLessThan(Float value) {
            addCriterion("khzf <", value, "khzf");
            return (Criteria) this;
        }

        public Criteria andKhzfLessThanOrEqualTo(Float value) {
            addCriterion("khzf <=", value, "khzf");
            return (Criteria) this;
        }

        public Criteria andKhzfIn(List<Float> values) {
            addCriterion("khzf in", values, "khzf");
            return (Criteria) this;
        }

        public Criteria andKhzfNotIn(List<Float> values) {
            addCriterion("khzf not in", values, "khzf");
            return (Criteria) this;
        }

        public Criteria andKhzfBetween(Float value1, Float value2) {
            addCriterion("khzf between", value1, value2, "khzf");
            return (Criteria) this;
        }

        public Criteria andKhzfNotBetween(Float value1, Float value2) {
            addCriterion("khzf not between", value1, value2, "khzf");
            return (Criteria) this;
        }

        public Criteria andGzIsNull() {
            addCriterion("gz is null");
            return (Criteria) this;
        }

        public Criteria andGzIsNotNull() {
            addCriterion("gz is not null");
            return (Criteria) this;
        }

        public Criteria andGzEqualTo(Integer value) {
            addCriterion("gz =", value, "gz");
            return (Criteria) this;
        }

        public Criteria andGzNotEqualTo(Integer value) {
            addCriterion("gz <>", value, "gz");
            return (Criteria) this;
        }

        public Criteria andGzGreaterThan(Integer value) {
            addCriterion("gz >", value, "gz");
            return (Criteria) this;
        }

        public Criteria andGzGreaterThanOrEqualTo(Integer value) {
            addCriterion("gz >=", value, "gz");
            return (Criteria) this;
        }

        public Criteria andGzLessThan(Integer value) {
            addCriterion("gz <", value, "gz");
            return (Criteria) this;
        }

        public Criteria andGzLessThanOrEqualTo(Integer value) {
            addCriterion("gz <=", value, "gz");
            return (Criteria) this;
        }

        public Criteria andGzIn(List<Integer> values) {
            addCriterion("gz in", values, "gz");
            return (Criteria) this;
        }

        public Criteria andGzNotIn(List<Integer> values) {
            addCriterion("gz not in", values, "gz");
            return (Criteria) this;
        }

        public Criteria andGzBetween(Integer value1, Integer value2) {
            addCriterion("gz between", value1, value2, "gz");
            return (Criteria) this;
        }

        public Criteria andGzNotBetween(Integer value1, Integer value2) {
            addCriterion("gz not between", value1, value2, "gz");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNull() {
            addCriterion("pay_time is null");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNotNull() {
            addCriterion("pay_time is not null");
            return (Criteria) this;
        }

        public Criteria andPayTimeEqualTo(Date value) {
            addCriterion("pay_time =", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotEqualTo(Date value) {
            addCriterion("pay_time <>", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThan(Date value) {
            addCriterion("pay_time >", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pay_time >=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThan(Date value) {
            addCriterion("pay_time <", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThanOrEqualTo(Date value) {
            addCriterion("pay_time <=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeIn(List<Date> values) {
            addCriterion("pay_time in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotIn(List<Date> values) {
            addCriterion("pay_time not in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeBetween(Date value1, Date value2) {
            addCriterion("pay_time between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotBetween(Date value1, Date value2) {
            addCriterion("pay_time not between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andNurseBankCodeIsNull() {
            addCriterion("nurse_bank_code is null");
            return (Criteria) this;
        }

        public Criteria andNurseBankCodeIsNotNull() {
            addCriterion("nurse_bank_code is not null");
            return (Criteria) this;
        }

        public Criteria andNurseBankCodeEqualTo(String value) {
            addCriterion("nurse_bank_code =", value, "nurseBankCode");
            return (Criteria) this;
        }

        public Criteria andNurseBankCodeNotEqualTo(String value) {
            addCriterion("nurse_bank_code <>", value, "nurseBankCode");
            return (Criteria) this;
        }

        public Criteria andNurseBankCodeGreaterThan(String value) {
            addCriterion("nurse_bank_code >", value, "nurseBankCode");
            return (Criteria) this;
        }

        public Criteria andNurseBankCodeGreaterThanOrEqualTo(String value) {
            addCriterion("nurse_bank_code >=", value, "nurseBankCode");
            return (Criteria) this;
        }

        public Criteria andNurseBankCodeLessThan(String value) {
            addCriterion("nurse_bank_code <", value, "nurseBankCode");
            return (Criteria) this;
        }

        public Criteria andNurseBankCodeLessThanOrEqualTo(String value) {
            addCriterion("nurse_bank_code <=", value, "nurseBankCode");
            return (Criteria) this;
        }

        public Criteria andNurseBankCodeLike(String value) {
            addCriterion("nurse_bank_code like", value, "nurseBankCode");
            return (Criteria) this;
        }

        public Criteria andNurseBankCodeNotLike(String value) {
            addCriterion("nurse_bank_code not like", value, "nurseBankCode");
            return (Criteria) this;
        }

        public Criteria andNurseBankCodeIn(List<String> values) {
            addCriterion("nurse_bank_code in", values, "nurseBankCode");
            return (Criteria) this;
        }

        public Criteria andNurseBankCodeNotIn(List<String> values) {
            addCriterion("nurse_bank_code not in", values, "nurseBankCode");
            return (Criteria) this;
        }

        public Criteria andNurseBankCodeBetween(String value1, String value2) {
            addCriterion("nurse_bank_code between", value1, value2, "nurseBankCode");
            return (Criteria) this;
        }

        public Criteria andNurseBankCodeNotBetween(String value1, String value2) {
            addCriterion("nurse_bank_code not between", value1, value2, "nurseBankCode");
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