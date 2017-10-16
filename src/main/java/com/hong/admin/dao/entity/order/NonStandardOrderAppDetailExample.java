package com.hong.admin.dao.entity.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class NonStandardOrderAppDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NonStandardOrderAppDetailExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andOrderCreateDateIsNull() {
            addCriterion("order_create_Date is null");
            return (Criteria) this;
        }

        public Criteria andOrderCreateDateIsNotNull() {
            addCriterion("order_create_Date is not null");
            return (Criteria) this;
        }

        public Criteria andOrderCreateDateEqualTo(Date value) {
            addCriterion("order_create_Date =", value, "orderCreateDate");
            return (Criteria) this;
        }

        public Criteria andOrderCreateDateNotEqualTo(Date value) {
            addCriterion("order_create_Date <>", value, "orderCreateDate");
            return (Criteria) this;
        }

        public Criteria andOrderCreateDateGreaterThan(Date value) {
            addCriterion("order_create_Date >", value, "orderCreateDate");
            return (Criteria) this;
        }

        public Criteria andOrderCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("order_create_Date >=", value, "orderCreateDate");
            return (Criteria) this;
        }

        public Criteria andOrderCreateDateLessThan(Date value) {
            addCriterion("order_create_Date <", value, "orderCreateDate");
            return (Criteria) this;
        }

        public Criteria andOrderCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("order_create_Date <=", value, "orderCreateDate");
            return (Criteria) this;
        }

        public Criteria andOrderCreateDateIn(List<Date> values) {
            addCriterion("order_create_Date in", values, "orderCreateDate");
            return (Criteria) this;
        }

        public Criteria andOrderCreateDateNotIn(List<Date> values) {
            addCriterion("order_create_Date not in", values, "orderCreateDate");
            return (Criteria) this;
        }

        public Criteria andOrderCreateDateBetween(Date value1, Date value2) {
            addCriterion("order_create_Date between", value1, value2, "orderCreateDate");
            return (Criteria) this;
        }

        public Criteria andOrderCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("order_create_Date not between", value1, value2, "orderCreateDate");
            return (Criteria) this;
        }

        public Criteria andServiceStartDateIsNull() {
            addCriterion("service_start_Date is null");
            return (Criteria) this;
        }

        public Criteria andServiceStartDateIsNotNull() {
            addCriterion("service_start_Date is not null");
            return (Criteria) this;
        }

        public Criteria andServiceStartDateEqualTo(Date value) {
            addCriterionForJDBCDate("service_start_Date =", value, "serviceStartDate");
            return (Criteria) this;
        }

        public Criteria andServiceStartDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("service_start_Date <>", value, "serviceStartDate");
            return (Criteria) this;
        }

        public Criteria andServiceStartDateGreaterThan(Date value) {
            addCriterionForJDBCDate("service_start_Date >", value, "serviceStartDate");
            return (Criteria) this;
        }

        public Criteria andServiceStartDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("service_start_Date >=", value, "serviceStartDate");
            return (Criteria) this;
        }

        public Criteria andServiceStartDateLessThan(Date value) {
            addCriterionForJDBCDate("service_start_Date <", value, "serviceStartDate");
            return (Criteria) this;
        }

        public Criteria andServiceStartDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("service_start_Date <=", value, "serviceStartDate");
            return (Criteria) this;
        }

        public Criteria andServiceStartDateIn(List<Date> values) {
            addCriterionForJDBCDate("service_start_Date in", values, "serviceStartDate");
            return (Criteria) this;
        }

        public Criteria andServiceStartDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("service_start_Date not in", values, "serviceStartDate");
            return (Criteria) this;
        }

        public Criteria andServiceStartDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("service_start_Date between", value1, value2, "serviceStartDate");
            return (Criteria) this;
        }

        public Criteria andServiceStartDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("service_start_Date not between", value1, value2, "serviceStartDate");
            return (Criteria) this;
        }

        public Criteria andServiceEndDateIsNull() {
            addCriterion("service_end_Date is null");
            return (Criteria) this;
        }

        public Criteria andServiceEndDateIsNotNull() {
            addCriterion("service_end_Date is not null");
            return (Criteria) this;
        }

        public Criteria andServiceEndDateEqualTo(Date value) {
            addCriterionForJDBCDate("service_end_Date =", value, "serviceEndDate");
            return (Criteria) this;
        }

        public Criteria andServiceEndDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("service_end_Date <>", value, "serviceEndDate");
            return (Criteria) this;
        }

        public Criteria andServiceEndDateGreaterThan(Date value) {
            addCriterionForJDBCDate("service_end_Date >", value, "serviceEndDate");
            return (Criteria) this;
        }

        public Criteria andServiceEndDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("service_end_Date >=", value, "serviceEndDate");
            return (Criteria) this;
        }

        public Criteria andServiceEndDateLessThan(Date value) {
            addCriterionForJDBCDate("service_end_Date <", value, "serviceEndDate");
            return (Criteria) this;
        }

        public Criteria andServiceEndDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("service_end_Date <=", value, "serviceEndDate");
            return (Criteria) this;
        }

        public Criteria andServiceEndDateIn(List<Date> values) {
            addCriterionForJDBCDate("service_end_Date in", values, "serviceEndDate");
            return (Criteria) this;
        }

        public Criteria andServiceEndDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("service_end_Date not in", values, "serviceEndDate");
            return (Criteria) this;
        }

        public Criteria andServiceEndDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("service_end_Date between", value1, value2, "serviceEndDate");
            return (Criteria) this;
        }

        public Criteria andServiceEndDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("service_end_Date not between", value1, value2, "serviceEndDate");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(Integer value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(Integer value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(Integer value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(Integer value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(Integer value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(Integer value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<Integer> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<Integer> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(Integer value1, Integer value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(Integer value1, Integer value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(Float value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(Float value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(Float value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(Float value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(Float value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(Float value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<Float> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<Float> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(Float value1, Float value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(Float value1, Float value2) {
            addCriterion("amount not between", value1, value2, "amount");
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberIsNull() {
            addCriterion("phone_number is null");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberIsNotNull() {
            addCriterion("phone_number is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberEqualTo(String value) {
            addCriterion("phone_number =", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberNotEqualTo(String value) {
            addCriterion("phone_number <>", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberGreaterThan(String value) {
            addCriterion("phone_number >", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberGreaterThanOrEqualTo(String value) {
            addCriterion("phone_number >=", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberLessThan(String value) {
            addCriterion("phone_number <", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberLessThanOrEqualTo(String value) {
            addCriterion("phone_number <=", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberLike(String value) {
            addCriterion("phone_number like", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberNotLike(String value) {
            addCriterion("phone_number not like", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberIn(List<String> values) {
            addCriterion("phone_number in", values, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberNotIn(List<String> values) {
            addCriterion("phone_number not in", values, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberBetween(String value1, String value2) {
            addCriterion("phone_number between", value1, value2, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberNotBetween(String value1, String value2) {
            addCriterion("phone_number not between", value1, value2, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNull() {
            addCriterion("remarks is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("remarks is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("remarks =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("remarks <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("remarks >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("remarks >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("remarks <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("remarks <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("remarks like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("remarks not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("remarks in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("remarks not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("remarks between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("remarks not between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andOrderAppointmentIdIsNull() {
            addCriterion("order_appointment_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderAppointmentIdIsNotNull() {
            addCriterion("order_appointment_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderAppointmentIdEqualTo(Integer value) {
            addCriterion("order_appointment_id =", value, "orderAppointmentId");
            return (Criteria) this;
        }

        public Criteria andOrderAppointmentIdNotEqualTo(Integer value) {
            addCriterion("order_appointment_id <>", value, "orderAppointmentId");
            return (Criteria) this;
        }

        public Criteria andOrderAppointmentIdGreaterThan(Integer value) {
            addCriterion("order_appointment_id >", value, "orderAppointmentId");
            return (Criteria) this;
        }

        public Criteria andOrderAppointmentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_appointment_id >=", value, "orderAppointmentId");
            return (Criteria) this;
        }

        public Criteria andOrderAppointmentIdLessThan(Integer value) {
            addCriterion("order_appointment_id <", value, "orderAppointmentId");
            return (Criteria) this;
        }

        public Criteria andOrderAppointmentIdLessThanOrEqualTo(Integer value) {
            addCriterion("order_appointment_id <=", value, "orderAppointmentId");
            return (Criteria) this;
        }

        public Criteria andOrderAppointmentIdIn(List<Integer> values) {
            addCriterion("order_appointment_id in", values, "orderAppointmentId");
            return (Criteria) this;
        }

        public Criteria andOrderAppointmentIdNotIn(List<Integer> values) {
            addCriterion("order_appointment_id not in", values, "orderAppointmentId");
            return (Criteria) this;
        }

        public Criteria andOrderAppointmentIdBetween(Integer value1, Integer value2) {
            addCriterion("order_appointment_id between", value1, value2, "orderAppointmentId");
            return (Criteria) this;
        }

        public Criteria andOrderAppointmentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("order_appointment_id not between", value1, value2, "orderAppointmentId");
            return (Criteria) this;
        }

        public Criteria andFaceMarksIsNull() {
            addCriterion("face_marks is null");
            return (Criteria) this;
        }

        public Criteria andFaceMarksIsNotNull() {
            addCriterion("face_marks is not null");
            return (Criteria) this;
        }

        public Criteria andFaceMarksEqualTo(String value) {
            addCriterion("face_marks =", value, "faceMarks");
            return (Criteria) this;
        }

        public Criteria andFaceMarksNotEqualTo(String value) {
            addCriterion("face_marks <>", value, "faceMarks");
            return (Criteria) this;
        }

        public Criteria andFaceMarksGreaterThan(String value) {
            addCriterion("face_marks >", value, "faceMarks");
            return (Criteria) this;
        }

        public Criteria andFaceMarksGreaterThanOrEqualTo(String value) {
            addCriterion("face_marks >=", value, "faceMarks");
            return (Criteria) this;
        }

        public Criteria andFaceMarksLessThan(String value) {
            addCriterion("face_marks <", value, "faceMarks");
            return (Criteria) this;
        }

        public Criteria andFaceMarksLessThanOrEqualTo(String value) {
            addCriterion("face_marks <=", value, "faceMarks");
            return (Criteria) this;
        }

        public Criteria andFaceMarksLike(String value) {
            addCriterion("face_marks like", value, "faceMarks");
            return (Criteria) this;
        }

        public Criteria andFaceMarksNotLike(String value) {
            addCriterion("face_marks not like", value, "faceMarks");
            return (Criteria) this;
        }

        public Criteria andFaceMarksIn(List<String> values) {
            addCriterion("face_marks in", values, "faceMarks");
            return (Criteria) this;
        }

        public Criteria andFaceMarksNotIn(List<String> values) {
            addCriterion("face_marks not in", values, "faceMarks");
            return (Criteria) this;
        }

        public Criteria andFaceMarksBetween(String value1, String value2) {
            addCriterion("face_marks between", value1, value2, "faceMarks");
            return (Criteria) this;
        }

        public Criteria andFaceMarksNotBetween(String value1, String value2) {
            addCriterion("face_marks not between", value1, value2, "faceMarks");
            return (Criteria) this;
        }

        public Criteria andHouseAreaIsNull() {
            addCriterion("house_area is null");
            return (Criteria) this;
        }

        public Criteria andHouseAreaIsNotNull() {
            addCriterion("house_area is not null");
            return (Criteria) this;
        }

        public Criteria andHouseAreaEqualTo(String value) {
            addCriterion("house_area =", value, "houseArea");
            return (Criteria) this;
        }

        public Criteria andHouseAreaNotEqualTo(String value) {
            addCriterion("house_area <>", value, "houseArea");
            return (Criteria) this;
        }

        public Criteria andHouseAreaGreaterThan(String value) {
            addCriterion("house_area >", value, "houseArea");
            return (Criteria) this;
        }

        public Criteria andHouseAreaGreaterThanOrEqualTo(String value) {
            addCriterion("house_area >=", value, "houseArea");
            return (Criteria) this;
        }

        public Criteria andHouseAreaLessThan(String value) {
            addCriterion("house_area <", value, "houseArea");
            return (Criteria) this;
        }

        public Criteria andHouseAreaLessThanOrEqualTo(String value) {
            addCriterion("house_area <=", value, "houseArea");
            return (Criteria) this;
        }

        public Criteria andHouseAreaLike(String value) {
            addCriterion("house_area like", value, "houseArea");
            return (Criteria) this;
        }

        public Criteria andHouseAreaNotLike(String value) {
            addCriterion("house_area not like", value, "houseArea");
            return (Criteria) this;
        }

        public Criteria andHouseAreaIn(List<String> values) {
            addCriterion("house_area in", values, "houseArea");
            return (Criteria) this;
        }

        public Criteria andHouseAreaNotIn(List<String> values) {
            addCriterion("house_area not in", values, "houseArea");
            return (Criteria) this;
        }

        public Criteria andHouseAreaBetween(String value1, String value2) {
            addCriterion("house_area between", value1, value2, "houseArea");
            return (Criteria) this;
        }

        public Criteria andHouseAreaNotBetween(String value1, String value2) {
            addCriterion("house_area not between", value1, value2, "houseArea");
            return (Criteria) this;
        }

        public Criteria andOrderCountPayIsNull() {
            addCriterion("order_count_pay is null");
            return (Criteria) this;
        }

        public Criteria andOrderCountPayIsNotNull() {
            addCriterion("order_count_pay is not null");
            return (Criteria) this;
        }

        public Criteria andOrderCountPayEqualTo(Integer value) {
            addCriterion("order_count_pay =", value, "orderCountPay");
            return (Criteria) this;
        }

        public Criteria andOrderCountPayNotEqualTo(Integer value) {
            addCriterion("order_count_pay <>", value, "orderCountPay");
            return (Criteria) this;
        }

        public Criteria andOrderCountPayGreaterThan(Integer value) {
            addCriterion("order_count_pay >", value, "orderCountPay");
            return (Criteria) this;
        }

        public Criteria andOrderCountPayGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_count_pay >=", value, "orderCountPay");
            return (Criteria) this;
        }

        public Criteria andOrderCountPayLessThan(Integer value) {
            addCriterion("order_count_pay <", value, "orderCountPay");
            return (Criteria) this;
        }

        public Criteria andOrderCountPayLessThanOrEqualTo(Integer value) {
            addCriterion("order_count_pay <=", value, "orderCountPay");
            return (Criteria) this;
        }

        public Criteria andOrderCountPayIn(List<Integer> values) {
            addCriterion("order_count_pay in", values, "orderCountPay");
            return (Criteria) this;
        }

        public Criteria andOrderCountPayNotIn(List<Integer> values) {
            addCriterion("order_count_pay not in", values, "orderCountPay");
            return (Criteria) this;
        }

        public Criteria andOrderCountPayBetween(Integer value1, Integer value2) {
            addCriterion("order_count_pay between", value1, value2, "orderCountPay");
            return (Criteria) this;
        }

        public Criteria andOrderCountPayNotBetween(Integer value1, Integer value2) {
            addCriterion("order_count_pay not between", value1, value2, "orderCountPay");
            return (Criteria) this;
        }

        public Criteria andAgentPayIsNull() {
            addCriterion("agent_pay is null");
            return (Criteria) this;
        }

        public Criteria andAgentPayIsNotNull() {
            addCriterion("agent_pay is not null");
            return (Criteria) this;
        }

        public Criteria andAgentPayEqualTo(Integer value) {
            addCriterion("agent_pay =", value, "agentPay");
            return (Criteria) this;
        }

        public Criteria andAgentPayNotEqualTo(Integer value) {
            addCriterion("agent_pay <>", value, "agentPay");
            return (Criteria) this;
        }

        public Criteria andAgentPayGreaterThan(Integer value) {
            addCriterion("agent_pay >", value, "agentPay");
            return (Criteria) this;
        }

        public Criteria andAgentPayGreaterThanOrEqualTo(Integer value) {
            addCriterion("agent_pay >=", value, "agentPay");
            return (Criteria) this;
        }

        public Criteria andAgentPayLessThan(Integer value) {
            addCriterion("agent_pay <", value, "agentPay");
            return (Criteria) this;
        }

        public Criteria andAgentPayLessThanOrEqualTo(Integer value) {
            addCriterion("agent_pay <=", value, "agentPay");
            return (Criteria) this;
        }

        public Criteria andAgentPayIn(List<Integer> values) {
            addCriterion("agent_pay in", values, "agentPay");
            return (Criteria) this;
        }

        public Criteria andAgentPayNotIn(List<Integer> values) {
            addCriterion("agent_pay not in", values, "agentPay");
            return (Criteria) this;
        }

        public Criteria andAgentPayBetween(Integer value1, Integer value2) {
            addCriterion("agent_pay between", value1, value2, "agentPay");
            return (Criteria) this;
        }

        public Criteria andAgentPayNotBetween(Integer value1, Integer value2) {
            addCriterion("agent_pay not between", value1, value2, "agentPay");
            return (Criteria) this;
        }

        public Criteria andBzjPayIsNull() {
            addCriterion("bzj_pay is null");
            return (Criteria) this;
        }

        public Criteria andBzjPayIsNotNull() {
            addCriterion("bzj_pay is not null");
            return (Criteria) this;
        }

        public Criteria andBzjPayEqualTo(Integer value) {
            addCriterion("bzj_pay =", value, "bzjPay");
            return (Criteria) this;
        }

        public Criteria andBzjPayNotEqualTo(Integer value) {
            addCriterion("bzj_pay <>", value, "bzjPay");
            return (Criteria) this;
        }

        public Criteria andBzjPayGreaterThan(Integer value) {
            addCriterion("bzj_pay >", value, "bzjPay");
            return (Criteria) this;
        }

        public Criteria andBzjPayGreaterThanOrEqualTo(Integer value) {
            addCriterion("bzj_pay >=", value, "bzjPay");
            return (Criteria) this;
        }

        public Criteria andBzjPayLessThan(Integer value) {
            addCriterion("bzj_pay <", value, "bzjPay");
            return (Criteria) this;
        }

        public Criteria andBzjPayLessThanOrEqualTo(Integer value) {
            addCriterion("bzj_pay <=", value, "bzjPay");
            return (Criteria) this;
        }

        public Criteria andBzjPayIn(List<Integer> values) {
            addCriterion("bzj_pay in", values, "bzjPay");
            return (Criteria) this;
        }

        public Criteria andBzjPayNotIn(List<Integer> values) {
            addCriterion("bzj_pay not in", values, "bzjPay");
            return (Criteria) this;
        }

        public Criteria andBzjPayBetween(Integer value1, Integer value2) {
            addCriterion("bzj_pay between", value1, value2, "bzjPay");
            return (Criteria) this;
        }

        public Criteria andBzjPayNotBetween(Integer value1, Integer value2) {
            addCriterion("bzj_pay not between", value1, value2, "bzjPay");
            return (Criteria) this;
        }

        public Criteria andFaceAddressIsNull() {
            addCriterion("face_address is null");
            return (Criteria) this;
        }

        public Criteria andFaceAddressIsNotNull() {
            addCriterion("face_address is not null");
            return (Criteria) this;
        }

        public Criteria andFaceAddressEqualTo(Integer value) {
            addCriterion("face_address =", value, "faceAddress");
            return (Criteria) this;
        }

        public Criteria andFaceAddressNotEqualTo(Integer value) {
            addCriterion("face_address <>", value, "faceAddress");
            return (Criteria) this;
        }

        public Criteria andFaceAddressGreaterThan(Integer value) {
            addCriterion("face_address >", value, "faceAddress");
            return (Criteria) this;
        }

        public Criteria andFaceAddressGreaterThanOrEqualTo(Integer value) {
            addCriterion("face_address >=", value, "faceAddress");
            return (Criteria) this;
        }

        public Criteria andFaceAddressLessThan(Integer value) {
            addCriterion("face_address <", value, "faceAddress");
            return (Criteria) this;
        }

        public Criteria andFaceAddressLessThanOrEqualTo(Integer value) {
            addCriterion("face_address <=", value, "faceAddress");
            return (Criteria) this;
        }

        public Criteria andFaceAddressIn(List<Integer> values) {
            addCriterion("face_address in", values, "faceAddress");
            return (Criteria) this;
        }

        public Criteria andFaceAddressNotIn(List<Integer> values) {
            addCriterion("face_address not in", values, "faceAddress");
            return (Criteria) this;
        }

        public Criteria andFaceAddressBetween(Integer value1, Integer value2) {
            addCriterion("face_address between", value1, value2, "faceAddress");
            return (Criteria) this;
        }

        public Criteria andFaceAddressNotBetween(Integer value1, Integer value2) {
            addCriterion("face_address not between", value1, value2, "faceAddress");
            return (Criteria) this;
        }

        public Criteria andFaceTimeIsNull() {
            addCriterion("face_time is null");
            return (Criteria) this;
        }

        public Criteria andFaceTimeIsNotNull() {
            addCriterion("face_time is not null");
            return (Criteria) this;
        }

        public Criteria andFaceTimeEqualTo(Date value) {
            addCriterion("face_time =", value, "faceTime");
            return (Criteria) this;
        }

        public Criteria andFaceTimeNotEqualTo(Date value) {
            addCriterion("face_time <>", value, "faceTime");
            return (Criteria) this;
        }

        public Criteria andFaceTimeGreaterThan(Date value) {
            addCriterion("face_time >", value, "faceTime");
            return (Criteria) this;
        }

        public Criteria andFaceTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("face_time >=", value, "faceTime");
            return (Criteria) this;
        }

        public Criteria andFaceTimeLessThan(Date value) {
            addCriterion("face_time <", value, "faceTime");
            return (Criteria) this;
        }

        public Criteria andFaceTimeLessThanOrEqualTo(Date value) {
            addCriterion("face_time <=", value, "faceTime");
            return (Criteria) this;
        }

        public Criteria andFaceTimeIn(List<Date> values) {
            addCriterion("face_time in", values, "faceTime");
            return (Criteria) this;
        }

        public Criteria andFaceTimeNotIn(List<Date> values) {
            addCriterion("face_time not in", values, "faceTime");
            return (Criteria) this;
        }

        public Criteria andFaceTimeBetween(Date value1, Date value2) {
            addCriterion("face_time between", value1, value2, "faceTime");
            return (Criteria) this;
        }

        public Criteria andFaceTimeNotBetween(Date value1, Date value2) {
            addCriterion("face_time not between", value1, value2, "faceTime");
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