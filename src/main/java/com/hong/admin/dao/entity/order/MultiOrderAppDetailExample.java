package com.hong.admin.dao.entity.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MultiOrderAppDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MultiOrderAppDetailExample() {
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

        public Criteria andServiceTimeIsNull() {
            addCriterion("service_time is null");
            return (Criteria) this;
        }

        public Criteria andServiceTimeIsNotNull() {
            addCriterion("service_time is not null");
            return (Criteria) this;
        }

        public Criteria andServiceTimeEqualTo(String value) {
            addCriterion("service_time =", value, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andServiceTimeNotEqualTo(String value) {
            addCriterion("service_time <>", value, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andServiceTimeGreaterThan(String value) {
            addCriterion("service_time >", value, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andServiceTimeGreaterThanOrEqualTo(String value) {
            addCriterion("service_time >=", value, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andServiceTimeLessThan(String value) {
            addCriterion("service_time <", value, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andServiceTimeLessThanOrEqualTo(String value) {
            addCriterion("service_time <=", value, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andServiceTimeLike(String value) {
            addCriterion("service_time like", value, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andServiceTimeNotLike(String value) {
            addCriterion("service_time not like", value, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andServiceTimeIn(List<String> values) {
            addCriterion("service_time in", values, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andServiceTimeNotIn(List<String> values) {
            addCriterion("service_time not in", values, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andServiceTimeBetween(String value1, String value2) {
            addCriterion("service_time between", value1, value2, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andServiceTimeNotBetween(String value1, String value2) {
            addCriterion("service_time not between", value1, value2, "serviceTime");
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

        public Criteria andServiceWeekIsNull() {
            addCriterion("service_week is null");
            return (Criteria) this;
        }

        public Criteria andServiceWeekIsNotNull() {
            addCriterion("service_week is not null");
            return (Criteria) this;
        }

        public Criteria andServiceWeekEqualTo(String value) {
            addCriterion("service_week =", value, "serviceWeek");
            return (Criteria) this;
        }

        public Criteria andServiceWeekNotEqualTo(String value) {
            addCriterion("service_week <>", value, "serviceWeek");
            return (Criteria) this;
        }

        public Criteria andServiceWeekGreaterThan(String value) {
            addCriterion("service_week >", value, "serviceWeek");
            return (Criteria) this;
        }

        public Criteria andServiceWeekGreaterThanOrEqualTo(String value) {
            addCriterion("service_week >=", value, "serviceWeek");
            return (Criteria) this;
        }

        public Criteria andServiceWeekLessThan(String value) {
            addCriterion("service_week <", value, "serviceWeek");
            return (Criteria) this;
        }

        public Criteria andServiceWeekLessThanOrEqualTo(String value) {
            addCriterion("service_week <=", value, "serviceWeek");
            return (Criteria) this;
        }

        public Criteria andServiceWeekLike(String value) {
            addCriterion("service_week like", value, "serviceWeek");
            return (Criteria) this;
        }

        public Criteria andServiceWeekNotLike(String value) {
            addCriterion("service_week not like", value, "serviceWeek");
            return (Criteria) this;
        }

        public Criteria andServiceWeekIn(List<String> values) {
            addCriterion("service_week in", values, "serviceWeek");
            return (Criteria) this;
        }

        public Criteria andServiceWeekNotIn(List<String> values) {
            addCriterion("service_week not in", values, "serviceWeek");
            return (Criteria) this;
        }

        public Criteria andServiceWeekBetween(String value1, String value2) {
            addCriterion("service_week between", value1, value2, "serviceWeek");
            return (Criteria) this;
        }

        public Criteria andServiceWeekNotBetween(String value1, String value2) {
            addCriterion("service_week not between", value1, value2, "serviceWeek");
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

        public Criteria andMonthPackageIsNull() {
            addCriterion("month_package is null");
            return (Criteria) this;
        }

        public Criteria andMonthPackageIsNotNull() {
            addCriterion("month_package is not null");
            return (Criteria) this;
        }

        public Criteria andMonthPackageEqualTo(Integer value) {
            addCriterion("month_package =", value, "monthPackage");
            return (Criteria) this;
        }

        public Criteria andMonthPackageNotEqualTo(Integer value) {
            addCriterion("month_package <>", value, "monthPackage");
            return (Criteria) this;
        }

        public Criteria andMonthPackageGreaterThan(Integer value) {
            addCriterion("month_package >", value, "monthPackage");
            return (Criteria) this;
        }

        public Criteria andMonthPackageGreaterThanOrEqualTo(Integer value) {
            addCriterion("month_package >=", value, "monthPackage");
            return (Criteria) this;
        }

        public Criteria andMonthPackageLessThan(Integer value) {
            addCriterion("month_package <", value, "monthPackage");
            return (Criteria) this;
        }

        public Criteria andMonthPackageLessThanOrEqualTo(Integer value) {
            addCriterion("month_package <=", value, "monthPackage");
            return (Criteria) this;
        }

        public Criteria andMonthPackageIn(List<Integer> values) {
            addCriterion("month_package in", values, "monthPackage");
            return (Criteria) this;
        }

        public Criteria andMonthPackageNotIn(List<Integer> values) {
            addCriterion("month_package not in", values, "monthPackage");
            return (Criteria) this;
        }

        public Criteria andMonthPackageBetween(Integer value1, Integer value2) {
            addCriterion("month_package between", value1, value2, "monthPackage");
            return (Criteria) this;
        }

        public Criteria andMonthPackageNotBetween(Integer value1, Integer value2) {
            addCriterion("month_package not between", value1, value2, "monthPackage");
            return (Criteria) this;
        }

        public Criteria andPayIsNull() {
            addCriterion("pay is null");
            return (Criteria) this;
        }

        public Criteria andPayIsNotNull() {
            addCriterion("pay is not null");
            return (Criteria) this;
        }

        public Criteria andPayEqualTo(Float value) {
            addCriterion("pay =", value, "pay");
            return (Criteria) this;
        }

        public Criteria andPayNotEqualTo(Float value) {
            addCriterion("pay <>", value, "pay");
            return (Criteria) this;
        }

        public Criteria andPayGreaterThan(Float value) {
            addCriterion("pay >", value, "pay");
            return (Criteria) this;
        }

        public Criteria andPayGreaterThanOrEqualTo(Float value) {
            addCriterion("pay >=", value, "pay");
            return (Criteria) this;
        }

        public Criteria andPayLessThan(Float value) {
            addCriterion("pay <", value, "pay");
            return (Criteria) this;
        }

        public Criteria andPayLessThanOrEqualTo(Float value) {
            addCriterion("pay <=", value, "pay");
            return (Criteria) this;
        }

        public Criteria andPayIn(List<Float> values) {
            addCriterion("pay in", values, "pay");
            return (Criteria) this;
        }

        public Criteria andPayNotIn(List<Float> values) {
            addCriterion("pay not in", values, "pay");
            return (Criteria) this;
        }

        public Criteria andPayBetween(Float value1, Float value2) {
            addCriterion("pay between", value1, value2, "pay");
            return (Criteria) this;
        }

        public Criteria andPayNotBetween(Float value1, Float value2) {
            addCriterion("pay not between", value1, value2, "pay");
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

        public Criteria andCookIsNull() {
            addCriterion("cook is null");
            return (Criteria) this;
        }

        public Criteria andCookIsNotNull() {
            addCriterion("cook is not null");
            return (Criteria) this;
        }

        public Criteria andCookEqualTo(String value) {
            addCriterion("cook =", value, "cook");
            return (Criteria) this;
        }

        public Criteria andCookNotEqualTo(String value) {
            addCriterion("cook <>", value, "cook");
            return (Criteria) this;
        }

        public Criteria andCookGreaterThan(String value) {
            addCriterion("cook >", value, "cook");
            return (Criteria) this;
        }

        public Criteria andCookGreaterThanOrEqualTo(String value) {
            addCriterion("cook >=", value, "cook");
            return (Criteria) this;
        }

        public Criteria andCookLessThan(String value) {
            addCriterion("cook <", value, "cook");
            return (Criteria) this;
        }

        public Criteria andCookLessThanOrEqualTo(String value) {
            addCriterion("cook <=", value, "cook");
            return (Criteria) this;
        }

        public Criteria andCookLike(String value) {
            addCriterion("cook like", value, "cook");
            return (Criteria) this;
        }

        public Criteria andCookNotLike(String value) {
            addCriterion("cook not like", value, "cook");
            return (Criteria) this;
        }

        public Criteria andCookIn(List<String> values) {
            addCriterion("cook in", values, "cook");
            return (Criteria) this;
        }

        public Criteria andCookNotIn(List<String> values) {
            addCriterion("cook not in", values, "cook");
            return (Criteria) this;
        }

        public Criteria andCookBetween(String value1, String value2) {
            addCriterion("cook between", value1, value2, "cook");
            return (Criteria) this;
        }

        public Criteria andCookNotBetween(String value1, String value2) {
            addCriterion("cook not between", value1, value2, "cook");
            return (Criteria) this;
        }

        public Criteria andMonthPayIsNull() {
            addCriterion("month_pay is null");
            return (Criteria) this;
        }

        public Criteria andMonthPayIsNotNull() {
            addCriterion("month_pay is not null");
            return (Criteria) this;
        }

        public Criteria andMonthPayEqualTo(Integer value) {
            addCriterion("month_pay =", value, "monthPay");
            return (Criteria) this;
        }

        public Criteria andMonthPayNotEqualTo(Integer value) {
            addCriterion("month_pay <>", value, "monthPay");
            return (Criteria) this;
        }

        public Criteria andMonthPayGreaterThan(Integer value) {
            addCriterion("month_pay >", value, "monthPay");
            return (Criteria) this;
        }

        public Criteria andMonthPayGreaterThanOrEqualTo(Integer value) {
            addCriterion("month_pay >=", value, "monthPay");
            return (Criteria) this;
        }

        public Criteria andMonthPayLessThan(Integer value) {
            addCriterion("month_pay <", value, "monthPay");
            return (Criteria) this;
        }

        public Criteria andMonthPayLessThanOrEqualTo(Integer value) {
            addCriterion("month_pay <=", value, "monthPay");
            return (Criteria) this;
        }

        public Criteria andMonthPayIn(List<Integer> values) {
            addCriterion("month_pay in", values, "monthPay");
            return (Criteria) this;
        }

        public Criteria andMonthPayNotIn(List<Integer> values) {
            addCriterion("month_pay not in", values, "monthPay");
            return (Criteria) this;
        }

        public Criteria andMonthPayBetween(Integer value1, Integer value2) {
            addCriterion("month_pay between", value1, value2, "monthPay");
            return (Criteria) this;
        }

        public Criteria andMonthPayNotBetween(Integer value1, Integer value2) {
            addCriterion("month_pay not between", value1, value2, "monthPay");
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