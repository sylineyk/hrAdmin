package com.hong.admin.dao.entity.nurse;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class NurseImportExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NurseImportExample() {
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

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("sex not between", value1, value2, "sex");
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

        public Criteria andIdCardIsNull() {
            addCriterion("id_card is null");
            return (Criteria) this;
        }

        public Criteria andIdCardIsNotNull() {
            addCriterion("id_card is not null");
            return (Criteria) this;
        }

        public Criteria andIdCardEqualTo(String value) {
            addCriterion("id_card =", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotEqualTo(String value) {
            addCriterion("id_card <>", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardGreaterThan(String value) {
            addCriterion("id_card >", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardGreaterThanOrEqualTo(String value) {
            addCriterion("id_card >=", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLessThan(String value) {
            addCriterion("id_card <", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLessThanOrEqualTo(String value) {
            addCriterion("id_card <=", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLike(String value) {
            addCriterion("id_card like", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotLike(String value) {
            addCriterion("id_card not like", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardIn(List<String> values) {
            addCriterion("id_card in", values, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotIn(List<String> values) {
            addCriterion("id_card not in", values, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardBetween(String value1, String value2) {
            addCriterion("id_card between", value1, value2, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotBetween(String value1, String value2) {
            addCriterion("id_card not between", value1, value2, "idCard");
            return (Criteria) this;
        }

        public Criteria andAgeIsNull() {
            addCriterion("age is null");
            return (Criteria) this;
        }

        public Criteria andAgeIsNotNull() {
            addCriterion("age is not null");
            return (Criteria) this;
        }

        public Criteria andAgeEqualTo(Integer value) {
            addCriterion("age =", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotEqualTo(Integer value) {
            addCriterion("age <>", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThan(Integer value) {
            addCriterion("age >", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("age >=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThan(Integer value) {
            addCriterion("age <", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThanOrEqualTo(Integer value) {
            addCriterion("age <=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeIn(List<Integer> values) {
            addCriterion("age in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotIn(List<Integer> values) {
            addCriterion("age not in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeBetween(Integer value1, Integer value2) {
            addCriterion("age between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("age not between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andZodiacIsNull() {
            addCriterion("zodiac is null");
            return (Criteria) this;
        }

        public Criteria andZodiacIsNotNull() {
            addCriterion("zodiac is not null");
            return (Criteria) this;
        }

        public Criteria andZodiacEqualTo(String value) {
            addCriterion("zodiac =", value, "zodiac");
            return (Criteria) this;
        }

        public Criteria andZodiacNotEqualTo(String value) {
            addCriterion("zodiac <>", value, "zodiac");
            return (Criteria) this;
        }

        public Criteria andZodiacGreaterThan(String value) {
            addCriterion("zodiac >", value, "zodiac");
            return (Criteria) this;
        }

        public Criteria andZodiacGreaterThanOrEqualTo(String value) {
            addCriterion("zodiac >=", value, "zodiac");
            return (Criteria) this;
        }

        public Criteria andZodiacLessThan(String value) {
            addCriterion("zodiac <", value, "zodiac");
            return (Criteria) this;
        }

        public Criteria andZodiacLessThanOrEqualTo(String value) {
            addCriterion("zodiac <=", value, "zodiac");
            return (Criteria) this;
        }

        public Criteria andZodiacLike(String value) {
            addCriterion("zodiac like", value, "zodiac");
            return (Criteria) this;
        }

        public Criteria andZodiacNotLike(String value) {
            addCriterion("zodiac not like", value, "zodiac");
            return (Criteria) this;
        }

        public Criteria andZodiacIn(List<String> values) {
            addCriterion("zodiac in", values, "zodiac");
            return (Criteria) this;
        }

        public Criteria andZodiacNotIn(List<String> values) {
            addCriterion("zodiac not in", values, "zodiac");
            return (Criteria) this;
        }

        public Criteria andZodiacBetween(String value1, String value2) {
            addCriterion("zodiac between", value1, value2, "zodiac");
            return (Criteria) this;
        }

        public Criteria andZodiacNotBetween(String value1, String value2) {
            addCriterion("zodiac not between", value1, value2, "zodiac");
            return (Criteria) this;
        }

        public Criteria andXlIsNull() {
            addCriterion("xl is null");
            return (Criteria) this;
        }

        public Criteria andXlIsNotNull() {
            addCriterion("xl is not null");
            return (Criteria) this;
        }

        public Criteria andXlEqualTo(String value) {
            addCriterion("xl =", value, "xl");
            return (Criteria) this;
        }

        public Criteria andXlNotEqualTo(String value) {
            addCriterion("xl <>", value, "xl");
            return (Criteria) this;
        }

        public Criteria andXlGreaterThan(String value) {
            addCriterion("xl >", value, "xl");
            return (Criteria) this;
        }

        public Criteria andXlGreaterThanOrEqualTo(String value) {
            addCriterion("xl >=", value, "xl");
            return (Criteria) this;
        }

        public Criteria andXlLessThan(String value) {
            addCriterion("xl <", value, "xl");
            return (Criteria) this;
        }

        public Criteria andXlLessThanOrEqualTo(String value) {
            addCriterion("xl <=", value, "xl");
            return (Criteria) this;
        }

        public Criteria andXlLike(String value) {
            addCriterion("xl like", value, "xl");
            return (Criteria) this;
        }

        public Criteria andXlNotLike(String value) {
            addCriterion("xl not like", value, "xl");
            return (Criteria) this;
        }

        public Criteria andXlIn(List<String> values) {
            addCriterion("xl in", values, "xl");
            return (Criteria) this;
        }

        public Criteria andXlNotIn(List<String> values) {
            addCriterion("xl not in", values, "xl");
            return (Criteria) this;
        }

        public Criteria andXlBetween(String value1, String value2) {
            addCriterion("xl between", value1, value2, "xl");
            return (Criteria) this;
        }

        public Criteria andXlNotBetween(String value1, String value2) {
            addCriterion("xl not between", value1, value2, "xl");
            return (Criteria) this;
        }

        public Criteria andMzIsNull() {
            addCriterion("mz is null");
            return (Criteria) this;
        }

        public Criteria andMzIsNotNull() {
            addCriterion("mz is not null");
            return (Criteria) this;
        }

        public Criteria andMzEqualTo(String value) {
            addCriterion("mz =", value, "mz");
            return (Criteria) this;
        }

        public Criteria andMzNotEqualTo(String value) {
            addCriterion("mz <>", value, "mz");
            return (Criteria) this;
        }

        public Criteria andMzGreaterThan(String value) {
            addCriterion("mz >", value, "mz");
            return (Criteria) this;
        }

        public Criteria andMzGreaterThanOrEqualTo(String value) {
            addCriterion("mz >=", value, "mz");
            return (Criteria) this;
        }

        public Criteria andMzLessThan(String value) {
            addCriterion("mz <", value, "mz");
            return (Criteria) this;
        }

        public Criteria andMzLessThanOrEqualTo(String value) {
            addCriterion("mz <=", value, "mz");
            return (Criteria) this;
        }

        public Criteria andMzLike(String value) {
            addCriterion("mz like", value, "mz");
            return (Criteria) this;
        }

        public Criteria andMzNotLike(String value) {
            addCriterion("mz not like", value, "mz");
            return (Criteria) this;
        }

        public Criteria andMzIn(List<String> values) {
            addCriterion("mz in", values, "mz");
            return (Criteria) this;
        }

        public Criteria andMzNotIn(List<String> values) {
            addCriterion("mz not in", values, "mz");
            return (Criteria) this;
        }

        public Criteria andMzBetween(String value1, String value2) {
            addCriterion("mz between", value1, value2, "mz");
            return (Criteria) this;
        }

        public Criteria andMzNotBetween(String value1, String value2) {
            addCriterion("mz not between", value1, value2, "mz");
            return (Criteria) this;
        }

        public Criteria andHeightIsNull() {
            addCriterion("height is null");
            return (Criteria) this;
        }

        public Criteria andHeightIsNotNull() {
            addCriterion("height is not null");
            return (Criteria) this;
        }

        public Criteria andHeightEqualTo(Integer value) {
            addCriterion("height =", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotEqualTo(Integer value) {
            addCriterion("height <>", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightGreaterThan(Integer value) {
            addCriterion("height >", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightGreaterThanOrEqualTo(Integer value) {
            addCriterion("height >=", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLessThan(Integer value) {
            addCriterion("height <", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLessThanOrEqualTo(Integer value) {
            addCriterion("height <=", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightIn(List<Integer> values) {
            addCriterion("height in", values, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotIn(List<Integer> values) {
            addCriterion("height not in", values, "height");
            return (Criteria) this;
        }

        public Criteria andHeightBetween(Integer value1, Integer value2) {
            addCriterion("height between", value1, value2, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotBetween(Integer value1, Integer value2) {
            addCriterion("height not between", value1, value2, "height");
            return (Criteria) this;
        }

        public Criteria andWeightIsNull() {
            addCriterion("weight is null");
            return (Criteria) this;
        }

        public Criteria andWeightIsNotNull() {
            addCriterion("weight is not null");
            return (Criteria) this;
        }

        public Criteria andWeightEqualTo(Integer value) {
            addCriterion("weight =", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotEqualTo(Integer value) {
            addCriterion("weight <>", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThan(Integer value) {
            addCriterion("weight >", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThanOrEqualTo(Integer value) {
            addCriterion("weight >=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThan(Integer value) {
            addCriterion("weight <", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThanOrEqualTo(Integer value) {
            addCriterion("weight <=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightIn(List<Integer> values) {
            addCriterion("weight in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotIn(List<Integer> values) {
            addCriterion("weight not in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightBetween(Integer value1, Integer value2) {
            addCriterion("weight between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotBetween(Integer value1, Integer value2) {
            addCriterion("weight not between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andJkzkIsNull() {
            addCriterion("jkzk is null");
            return (Criteria) this;
        }

        public Criteria andJkzkIsNotNull() {
            addCriterion("jkzk is not null");
            return (Criteria) this;
        }

        public Criteria andJkzkEqualTo(String value) {
            addCriterion("jkzk =", value, "jkzk");
            return (Criteria) this;
        }

        public Criteria andJkzkNotEqualTo(String value) {
            addCriterion("jkzk <>", value, "jkzk");
            return (Criteria) this;
        }

        public Criteria andJkzkGreaterThan(String value) {
            addCriterion("jkzk >", value, "jkzk");
            return (Criteria) this;
        }

        public Criteria andJkzkGreaterThanOrEqualTo(String value) {
            addCriterion("jkzk >=", value, "jkzk");
            return (Criteria) this;
        }

        public Criteria andJkzkLessThan(String value) {
            addCriterion("jkzk <", value, "jkzk");
            return (Criteria) this;
        }

        public Criteria andJkzkLessThanOrEqualTo(String value) {
            addCriterion("jkzk <=", value, "jkzk");
            return (Criteria) this;
        }

        public Criteria andJkzkLike(String value) {
            addCriterion("jkzk like", value, "jkzk");
            return (Criteria) this;
        }

        public Criteria andJkzkNotLike(String value) {
            addCriterion("jkzk not like", value, "jkzk");
            return (Criteria) this;
        }

        public Criteria andJkzkIn(List<String> values) {
            addCriterion("jkzk in", values, "jkzk");
            return (Criteria) this;
        }

        public Criteria andJkzkNotIn(List<String> values) {
            addCriterion("jkzk not in", values, "jkzk");
            return (Criteria) this;
        }

        public Criteria andJkzkBetween(String value1, String value2) {
            addCriterion("jkzk between", value1, value2, "jkzk");
            return (Criteria) this;
        }

        public Criteria andJkzkNotBetween(String value1, String value2) {
            addCriterion("jkzk not between", value1, value2, "jkzk");
            return (Criteria) this;
        }

        public Criteria andExperienceIsNull() {
            addCriterion("experience is null");
            return (Criteria) this;
        }

        public Criteria andExperienceIsNotNull() {
            addCriterion("experience is not null");
            return (Criteria) this;
        }

        public Criteria andExperienceEqualTo(Double value) {
            addCriterion("experience =", value, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceNotEqualTo(Double value) {
            addCriterion("experience <>", value, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceGreaterThan(Double value) {
            addCriterion("experience >", value, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceGreaterThanOrEqualTo(Double value) {
            addCriterion("experience >=", value, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceLessThan(Double value) {
            addCriterion("experience <", value, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceLessThanOrEqualTo(Double value) {
            addCriterion("experience <=", value, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceIn(List<Double> values) {
            addCriterion("experience in", values, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceNotIn(List<Double> values) {
            addCriterion("experience not in", values, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceBetween(Double value1, Double value2) {
            addCriterion("experience between", value1, value2, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceNotBetween(Double value1, Double value2) {
            addCriterion("experience not between", value1, value2, "experience");
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

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andMarriageIsNull() {
            addCriterion("marriage is null");
            return (Criteria) this;
        }

        public Criteria andMarriageIsNotNull() {
            addCriterion("marriage is not null");
            return (Criteria) this;
        }

        public Criteria andMarriageEqualTo(String value) {
            addCriterion("marriage =", value, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageNotEqualTo(String value) {
            addCriterion("marriage <>", value, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageGreaterThan(String value) {
            addCriterion("marriage >", value, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageGreaterThanOrEqualTo(String value) {
            addCriterion("marriage >=", value, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageLessThan(String value) {
            addCriterion("marriage <", value, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageLessThanOrEqualTo(String value) {
            addCriterion("marriage <=", value, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageLike(String value) {
            addCriterion("marriage like", value, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageNotLike(String value) {
            addCriterion("marriage not like", value, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageIn(List<String> values) {
            addCriterion("marriage in", values, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageNotIn(List<String> values) {
            addCriterion("marriage not in", values, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageBetween(String value1, String value2) {
            addCriterion("marriage between", value1, value2, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageNotBetween(String value1, String value2) {
            addCriterion("marriage not between", value1, value2, "marriage");
            return (Criteria) this;
        }

        public Criteria andYyIsNull() {
            addCriterion("yy is null");
            return (Criteria) this;
        }

        public Criteria andYyIsNotNull() {
            addCriterion("yy is not null");
            return (Criteria) this;
        }

        public Criteria andYyEqualTo(String value) {
            addCriterion("yy =", value, "yy");
            return (Criteria) this;
        }

        public Criteria andYyNotEqualTo(String value) {
            addCriterion("yy <>", value, "yy");
            return (Criteria) this;
        }

        public Criteria andYyGreaterThan(String value) {
            addCriterion("yy >", value, "yy");
            return (Criteria) this;
        }

        public Criteria andYyGreaterThanOrEqualTo(String value) {
            addCriterion("yy >=", value, "yy");
            return (Criteria) this;
        }

        public Criteria andYyLessThan(String value) {
            addCriterion("yy <", value, "yy");
            return (Criteria) this;
        }

        public Criteria andYyLessThanOrEqualTo(String value) {
            addCriterion("yy <=", value, "yy");
            return (Criteria) this;
        }

        public Criteria andYyLike(String value) {
            addCriterion("yy like", value, "yy");
            return (Criteria) this;
        }

        public Criteria andYyNotLike(String value) {
            addCriterion("yy not like", value, "yy");
            return (Criteria) this;
        }

        public Criteria andYyIn(List<String> values) {
            addCriterion("yy in", values, "yy");
            return (Criteria) this;
        }

        public Criteria andYyNotIn(List<String> values) {
            addCriterion("yy not in", values, "yy");
            return (Criteria) this;
        }

        public Criteria andYyBetween(String value1, String value2) {
            addCriterion("yy between", value1, value2, "yy");
            return (Criteria) this;
        }

        public Criteria andYyNotBetween(String value1, String value2) {
            addCriterion("yy not between", value1, value2, "yy");
            return (Criteria) this;
        }

        public Criteria andCookieIsNull() {
            addCriterion("cookie is null");
            return (Criteria) this;
        }

        public Criteria andCookieIsNotNull() {
            addCriterion("cookie is not null");
            return (Criteria) this;
        }

        public Criteria andCookieEqualTo(String value) {
            addCriterion("cookie =", value, "cookie");
            return (Criteria) this;
        }

        public Criteria andCookieNotEqualTo(String value) {
            addCriterion("cookie <>", value, "cookie");
            return (Criteria) this;
        }

        public Criteria andCookieGreaterThan(String value) {
            addCriterion("cookie >", value, "cookie");
            return (Criteria) this;
        }

        public Criteria andCookieGreaterThanOrEqualTo(String value) {
            addCriterion("cookie >=", value, "cookie");
            return (Criteria) this;
        }

        public Criteria andCookieLessThan(String value) {
            addCriterion("cookie <", value, "cookie");
            return (Criteria) this;
        }

        public Criteria andCookieLessThanOrEqualTo(String value) {
            addCriterion("cookie <=", value, "cookie");
            return (Criteria) this;
        }

        public Criteria andCookieLike(String value) {
            addCriterion("cookie like", value, "cookie");
            return (Criteria) this;
        }

        public Criteria andCookieNotLike(String value) {
            addCriterion("cookie not like", value, "cookie");
            return (Criteria) this;
        }

        public Criteria andCookieIn(List<String> values) {
            addCriterion("cookie in", values, "cookie");
            return (Criteria) this;
        }

        public Criteria andCookieNotIn(List<String> values) {
            addCriterion("cookie not in", values, "cookie");
            return (Criteria) this;
        }

        public Criteria andCookieBetween(String value1, String value2) {
            addCriterion("cookie between", value1, value2, "cookie");
            return (Criteria) this;
        }

        public Criteria andCookieNotBetween(String value1, String value2) {
            addCriterion("cookie not between", value1, value2, "cookie");
            return (Criteria) this;
        }

        public Criteria andWorkIsNull() {
            addCriterion("work is null");
            return (Criteria) this;
        }

        public Criteria andWorkIsNotNull() {
            addCriterion("work is not null");
            return (Criteria) this;
        }

        public Criteria andWorkEqualTo(String value) {
            addCriterion("work =", value, "work");
            return (Criteria) this;
        }

        public Criteria andWorkNotEqualTo(String value) {
            addCriterion("work <>", value, "work");
            return (Criteria) this;
        }

        public Criteria andWorkGreaterThan(String value) {
            addCriterion("work >", value, "work");
            return (Criteria) this;
        }

        public Criteria andWorkGreaterThanOrEqualTo(String value) {
            addCriterion("work >=", value, "work");
            return (Criteria) this;
        }

        public Criteria andWorkLessThan(String value) {
            addCriterion("work <", value, "work");
            return (Criteria) this;
        }

        public Criteria andWorkLessThanOrEqualTo(String value) {
            addCriterion("work <=", value, "work");
            return (Criteria) this;
        }

        public Criteria andWorkLike(String value) {
            addCriterion("work like", value, "work");
            return (Criteria) this;
        }

        public Criteria andWorkNotLike(String value) {
            addCriterion("work not like", value, "work");
            return (Criteria) this;
        }

        public Criteria andWorkIn(List<String> values) {
            addCriterion("work in", values, "work");
            return (Criteria) this;
        }

        public Criteria andWorkNotIn(List<String> values) {
            addCriterion("work not in", values, "work");
            return (Criteria) this;
        }

        public Criteria andWorkBetween(String value1, String value2) {
            addCriterion("work between", value1, value2, "work");
            return (Criteria) this;
        }

        public Criteria andWorkNotBetween(String value1, String value2) {
            addCriterion("work not between", value1, value2, "work");
            return (Criteria) this;
        }

        public Criteria andSydqIsNull() {
            addCriterion("sydq is null");
            return (Criteria) this;
        }

        public Criteria andSydqIsNotNull() {
            addCriterion("sydq is not null");
            return (Criteria) this;
        }

        public Criteria andSydqEqualTo(String value) {
            addCriterion("sydq =", value, "sydq");
            return (Criteria) this;
        }

        public Criteria andSydqNotEqualTo(String value) {
            addCriterion("sydq <>", value, "sydq");
            return (Criteria) this;
        }

        public Criteria andSydqGreaterThan(String value) {
            addCriterion("sydq >", value, "sydq");
            return (Criteria) this;
        }

        public Criteria andSydqGreaterThanOrEqualTo(String value) {
            addCriterion("sydq >=", value, "sydq");
            return (Criteria) this;
        }

        public Criteria andSydqLessThan(String value) {
            addCriterion("sydq <", value, "sydq");
            return (Criteria) this;
        }

        public Criteria andSydqLessThanOrEqualTo(String value) {
            addCriterion("sydq <=", value, "sydq");
            return (Criteria) this;
        }

        public Criteria andSydqLike(String value) {
            addCriterion("sydq like", value, "sydq");
            return (Criteria) this;
        }

        public Criteria andSydqNotLike(String value) {
            addCriterion("sydq not like", value, "sydq");
            return (Criteria) this;
        }

        public Criteria andSydqIn(List<String> values) {
            addCriterion("sydq in", values, "sydq");
            return (Criteria) this;
        }

        public Criteria andSydqNotIn(List<String> values) {
            addCriterion("sydq not in", values, "sydq");
            return (Criteria) this;
        }

        public Criteria andSydqBetween(String value1, String value2) {
            addCriterion("sydq between", value1, value2, "sydq");
            return (Criteria) this;
        }

        public Criteria andSydqNotBetween(String value1, String value2) {
            addCriterion("sydq not between", value1, value2, "sydq");
            return (Criteria) this;
        }

        public Criteria andSsjjrIsNull() {
            addCriterion("ssjjr is null");
            return (Criteria) this;
        }

        public Criteria andSsjjrIsNotNull() {
            addCriterion("ssjjr is not null");
            return (Criteria) this;
        }

        public Criteria andSsjjrEqualTo(String value) {
            addCriterion("ssjjr =", value, "ssjjr");
            return (Criteria) this;
        }

        public Criteria andSsjjrNotEqualTo(String value) {
            addCriterion("ssjjr <>", value, "ssjjr");
            return (Criteria) this;
        }

        public Criteria andSsjjrGreaterThan(String value) {
            addCriterion("ssjjr >", value, "ssjjr");
            return (Criteria) this;
        }

        public Criteria andSsjjrGreaterThanOrEqualTo(String value) {
            addCriterion("ssjjr >=", value, "ssjjr");
            return (Criteria) this;
        }

        public Criteria andSsjjrLessThan(String value) {
            addCriterion("ssjjr <", value, "ssjjr");
            return (Criteria) this;
        }

        public Criteria andSsjjrLessThanOrEqualTo(String value) {
            addCriterion("ssjjr <=", value, "ssjjr");
            return (Criteria) this;
        }

        public Criteria andSsjjrLike(String value) {
            addCriterion("ssjjr like", value, "ssjjr");
            return (Criteria) this;
        }

        public Criteria andSsjjrNotLike(String value) {
            addCriterion("ssjjr not like", value, "ssjjr");
            return (Criteria) this;
        }

        public Criteria andSsjjrIn(List<String> values) {
            addCriterion("ssjjr in", values, "ssjjr");
            return (Criteria) this;
        }

        public Criteria andSsjjrNotIn(List<String> values) {
            addCriterion("ssjjr not in", values, "ssjjr");
            return (Criteria) this;
        }

        public Criteria andSsjjrBetween(String value1, String value2) {
            addCriterion("ssjjr between", value1, value2, "ssjjr");
            return (Criteria) this;
        }

        public Criteria andSsjjrNotBetween(String value1, String value2) {
            addCriterion("ssjjr not between", value1, value2, "ssjjr");
            return (Criteria) this;
        }

        public Criteria andSsgsIsNull() {
            addCriterion("ssgs is null");
            return (Criteria) this;
        }

        public Criteria andSsgsIsNotNull() {
            addCriterion("ssgs is not null");
            return (Criteria) this;
        }

        public Criteria andSsgsEqualTo(String value) {
            addCriterion("ssgs =", value, "ssgs");
            return (Criteria) this;
        }

        public Criteria andSsgsNotEqualTo(String value) {
            addCriterion("ssgs <>", value, "ssgs");
            return (Criteria) this;
        }

        public Criteria andSsgsGreaterThan(String value) {
            addCriterion("ssgs >", value, "ssgs");
            return (Criteria) this;
        }

        public Criteria andSsgsGreaterThanOrEqualTo(String value) {
            addCriterion("ssgs >=", value, "ssgs");
            return (Criteria) this;
        }

        public Criteria andSsgsLessThan(String value) {
            addCriterion("ssgs <", value, "ssgs");
            return (Criteria) this;
        }

        public Criteria andSsgsLessThanOrEqualTo(String value) {
            addCriterion("ssgs <=", value, "ssgs");
            return (Criteria) this;
        }

        public Criteria andSsgsLike(String value) {
            addCriterion("ssgs like", value, "ssgs");
            return (Criteria) this;
        }

        public Criteria andSsgsNotLike(String value) {
            addCriterion("ssgs not like", value, "ssgs");
            return (Criteria) this;
        }

        public Criteria andSsgsIn(List<String> values) {
            addCriterion("ssgs in", values, "ssgs");
            return (Criteria) this;
        }

        public Criteria andSsgsNotIn(List<String> values) {
            addCriterion("ssgs not in", values, "ssgs");
            return (Criteria) this;
        }

        public Criteria andSsgsBetween(String value1, String value2) {
            addCriterion("ssgs between", value1, value2, "ssgs");
            return (Criteria) this;
        }

        public Criteria andSsgsNotBetween(String value1, String value2) {
            addCriterion("ssgs not between", value1, value2, "ssgs");
            return (Criteria) this;
        }

        public Criteria andSalaryIsNull() {
            addCriterion("salary is null");
            return (Criteria) this;
        }

        public Criteria andSalaryIsNotNull() {
            addCriterion("salary is not null");
            return (Criteria) this;
        }

        public Criteria andSalaryEqualTo(Integer value) {
            addCriterion("salary =", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryNotEqualTo(Integer value) {
            addCriterion("salary <>", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryGreaterThan(Integer value) {
            addCriterion("salary >", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryGreaterThanOrEqualTo(Integer value) {
            addCriterion("salary >=", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryLessThan(Integer value) {
            addCriterion("salary <", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryLessThanOrEqualTo(Integer value) {
            addCriterion("salary <=", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryIn(List<Integer> values) {
            addCriterion("salary in", values, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryNotIn(List<Integer> values) {
            addCriterion("salary not in", values, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryBetween(Integer value1, Integer value2) {
            addCriterion("salary between", value1, value2, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryNotBetween(Integer value1, Integer value2) {
            addCriterion("salary not between", value1, value2, "salary");
            return (Criteria) this;
        }

        public Criteria andHtStartDateIsNull() {
            addCriterion("ht_start_date is null");
            return (Criteria) this;
        }

        public Criteria andHtStartDateIsNotNull() {
            addCriterion("ht_start_date is not null");
            return (Criteria) this;
        }

        public Criteria andHtStartDateEqualTo(Date value) {
            addCriterionForJDBCDate("ht_start_date =", value, "htStartDate");
            return (Criteria) this;
        }

        public Criteria andHtStartDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("ht_start_date <>", value, "htStartDate");
            return (Criteria) this;
        }

        public Criteria andHtStartDateGreaterThan(Date value) {
            addCriterionForJDBCDate("ht_start_date >", value, "htStartDate");
            return (Criteria) this;
        }

        public Criteria andHtStartDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ht_start_date >=", value, "htStartDate");
            return (Criteria) this;
        }

        public Criteria andHtStartDateLessThan(Date value) {
            addCriterionForJDBCDate("ht_start_date <", value, "htStartDate");
            return (Criteria) this;
        }

        public Criteria andHtStartDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ht_start_date <=", value, "htStartDate");
            return (Criteria) this;
        }

        public Criteria andHtStartDateIn(List<Date> values) {
            addCriterionForJDBCDate("ht_start_date in", values, "htStartDate");
            return (Criteria) this;
        }

        public Criteria andHtStartDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("ht_start_date not in", values, "htStartDate");
            return (Criteria) this;
        }

        public Criteria andHtStartDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ht_start_date between", value1, value2, "htStartDate");
            return (Criteria) this;
        }

        public Criteria andHtStartDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ht_start_date not between", value1, value2, "htStartDate");
            return (Criteria) this;
        }

        public Criteria andHtEndDateIsNull() {
            addCriterion("ht_end_date is null");
            return (Criteria) this;
        }

        public Criteria andHtEndDateIsNotNull() {
            addCriterion("ht_end_date is not null");
            return (Criteria) this;
        }

        public Criteria andHtEndDateEqualTo(Date value) {
            addCriterionForJDBCDate("ht_end_date =", value, "htEndDate");
            return (Criteria) this;
        }

        public Criteria andHtEndDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("ht_end_date <>", value, "htEndDate");
            return (Criteria) this;
        }

        public Criteria andHtEndDateGreaterThan(Date value) {
            addCriterionForJDBCDate("ht_end_date >", value, "htEndDate");
            return (Criteria) this;
        }

        public Criteria andHtEndDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ht_end_date >=", value, "htEndDate");
            return (Criteria) this;
        }

        public Criteria andHtEndDateLessThan(Date value) {
            addCriterionForJDBCDate("ht_end_date <", value, "htEndDate");
            return (Criteria) this;
        }

        public Criteria andHtEndDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ht_end_date <=", value, "htEndDate");
            return (Criteria) this;
        }

        public Criteria andHtEndDateIn(List<Date> values) {
            addCriterionForJDBCDate("ht_end_date in", values, "htEndDate");
            return (Criteria) this;
        }

        public Criteria andHtEndDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("ht_end_date not in", values, "htEndDate");
            return (Criteria) this;
        }

        public Criteria andHtEndDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ht_end_date between", value1, value2, "htEndDate");
            return (Criteria) this;
        }

        public Criteria andHtEndDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ht_end_date not between", value1, value2, "htEndDate");
            return (Criteria) this;
        }

        public Criteria andKhyhIsNull() {
            addCriterion("khyh is null");
            return (Criteria) this;
        }

        public Criteria andKhyhIsNotNull() {
            addCriterion("khyh is not null");
            return (Criteria) this;
        }

        public Criteria andKhyhEqualTo(String value) {
            addCriterion("khyh =", value, "khyh");
            return (Criteria) this;
        }

        public Criteria andKhyhNotEqualTo(String value) {
            addCriterion("khyh <>", value, "khyh");
            return (Criteria) this;
        }

        public Criteria andKhyhGreaterThan(String value) {
            addCriterion("khyh >", value, "khyh");
            return (Criteria) this;
        }

        public Criteria andKhyhGreaterThanOrEqualTo(String value) {
            addCriterion("khyh >=", value, "khyh");
            return (Criteria) this;
        }

        public Criteria andKhyhLessThan(String value) {
            addCriterion("khyh <", value, "khyh");
            return (Criteria) this;
        }

        public Criteria andKhyhLessThanOrEqualTo(String value) {
            addCriterion("khyh <=", value, "khyh");
            return (Criteria) this;
        }

        public Criteria andKhyhLike(String value) {
            addCriterion("khyh like", value, "khyh");
            return (Criteria) this;
        }

        public Criteria andKhyhNotLike(String value) {
            addCriterion("khyh not like", value, "khyh");
            return (Criteria) this;
        }

        public Criteria andKhyhIn(List<String> values) {
            addCriterion("khyh in", values, "khyh");
            return (Criteria) this;
        }

        public Criteria andKhyhNotIn(List<String> values) {
            addCriterion("khyh not in", values, "khyh");
            return (Criteria) this;
        }

        public Criteria andKhyhBetween(String value1, String value2) {
            addCriterion("khyh between", value1, value2, "khyh");
            return (Criteria) this;
        }

        public Criteria andKhyhNotBetween(String value1, String value2) {
            addCriterion("khyh not between", value1, value2, "khyh");
            return (Criteria) this;
        }

        public Criteria andBankCodeIsNull() {
            addCriterion("bank_code is null");
            return (Criteria) this;
        }

        public Criteria andBankCodeIsNotNull() {
            addCriterion("bank_code is not null");
            return (Criteria) this;
        }

        public Criteria andBankCodeEqualTo(String value) {
            addCriterion("bank_code =", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeNotEqualTo(String value) {
            addCriterion("bank_code <>", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeGreaterThan(String value) {
            addCriterion("bank_code >", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeGreaterThanOrEqualTo(String value) {
            addCriterion("bank_code >=", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeLessThan(String value) {
            addCriterion("bank_code <", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeLessThanOrEqualTo(String value) {
            addCriterion("bank_code <=", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeLike(String value) {
            addCriterion("bank_code like", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeNotLike(String value) {
            addCriterion("bank_code not like", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeIn(List<String> values) {
            addCriterion("bank_code in", values, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeNotIn(List<String> values) {
            addCriterion("bank_code not in", values, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeBetween(String value1, String value2) {
            addCriterion("bank_code between", value1, value2, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeNotBetween(String value1, String value2) {
            addCriterion("bank_code not between", value1, value2, "bankCode");
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

        public Criteria andLevelIsNull() {
            addCriterion("level is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("level is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(String value) {
            addCriterion("level =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(String value) {
            addCriterion("level <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(String value) {
            addCriterion("level >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(String value) {
            addCriterion("level >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(String value) {
            addCriterion("level <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(String value) {
            addCriterion("level <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLike(String value) {
            addCriterion("level like", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotLike(String value) {
            addCriterion("level not like", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<String> values) {
            addCriterion("level in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<String> values) {
            addCriterion("level not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(String value1, String value2) {
            addCriterion("level between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(String value1, String value2) {
            addCriterion("level not between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andFlagIsNull() {
            addCriterion("flag is null");
            return (Criteria) this;
        }

        public Criteria andFlagIsNotNull() {
            addCriterion("flag is not null");
            return (Criteria) this;
        }

        public Criteria andFlagEqualTo(String value) {
            addCriterion("flag =", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotEqualTo(String value) {
            addCriterion("flag <>", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThan(String value) {
            addCriterion("flag >", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThanOrEqualTo(String value) {
            addCriterion("flag >=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThan(String value) {
            addCriterion("flag <", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThanOrEqualTo(String value) {
            addCriterion("flag <=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLike(String value) {
            addCriterion("flag like", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotLike(String value) {
            addCriterion("flag not like", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagIn(List<String> values) {
            addCriterion("flag in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotIn(List<String> values) {
            addCriterion("flag not in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagBetween(String value1, String value2) {
            addCriterion("flag between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotBetween(String value1, String value2) {
            addCriterion("flag not between", value1, value2, "flag");
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

        public Criteria andResultIsNull() {
            addCriterion("result is null");
            return (Criteria) this;
        }

        public Criteria andResultIsNotNull() {
            addCriterion("result is not null");
            return (Criteria) this;
        }

        public Criteria andResultEqualTo(String value) {
            addCriterion("result =", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotEqualTo(String value) {
            addCriterion("result <>", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThan(String value) {
            addCriterion("result >", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThanOrEqualTo(String value) {
            addCriterion("result >=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThan(String value) {
            addCriterion("result <", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThanOrEqualTo(String value) {
            addCriterion("result <=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLike(String value) {
            addCriterion("result like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotLike(String value) {
            addCriterion("result not like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultIn(List<String> values) {
            addCriterion("result in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotIn(List<String> values) {
            addCriterion("result not in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultBetween(String value1, String value2) {
            addCriterion("result between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotBetween(String value1, String value2) {
            addCriterion("result not between", value1, value2, "result");
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

        public Criteria andYwxhIsNull() {
            addCriterion("ywxh is null");
            return (Criteria) this;
        }

        public Criteria andYwxhIsNotNull() {
            addCriterion("ywxh is not null");
            return (Criteria) this;
        }

        public Criteria andYwxhEqualTo(String value) {
            addCriterion("ywxh =", value, "ywxh");
            return (Criteria) this;
        }

        public Criteria andYwxhNotEqualTo(String value) {
            addCriterion("ywxh <>", value, "ywxh");
            return (Criteria) this;
        }

        public Criteria andYwxhGreaterThan(String value) {
            addCriterion("ywxh >", value, "ywxh");
            return (Criteria) this;
        }

        public Criteria andYwxhGreaterThanOrEqualTo(String value) {
            addCriterion("ywxh >=", value, "ywxh");
            return (Criteria) this;
        }

        public Criteria andYwxhLessThan(String value) {
            addCriterion("ywxh <", value, "ywxh");
            return (Criteria) this;
        }

        public Criteria andYwxhLessThanOrEqualTo(String value) {
            addCriterion("ywxh <=", value, "ywxh");
            return (Criteria) this;
        }

        public Criteria andYwxhLike(String value) {
            addCriterion("ywxh like", value, "ywxh");
            return (Criteria) this;
        }

        public Criteria andYwxhNotLike(String value) {
            addCriterion("ywxh not like", value, "ywxh");
            return (Criteria) this;
        }

        public Criteria andYwxhIn(List<String> values) {
            addCriterion("ywxh in", values, "ywxh");
            return (Criteria) this;
        }

        public Criteria andYwxhNotIn(List<String> values) {
            addCriterion("ywxh not in", values, "ywxh");
            return (Criteria) this;
        }

        public Criteria andYwxhBetween(String value1, String value2) {
            addCriterion("ywxh between", value1, value2, "ywxh");
            return (Criteria) this;
        }

        public Criteria andYwxhNotBetween(String value1, String value2) {
            addCriterion("ywxh not between", value1, value2, "ywxh");
            return (Criteria) this;
        }

        public Criteria andGspjIsNull() {
            addCriterion("gspj is null");
            return (Criteria) this;
        }

        public Criteria andGspjIsNotNull() {
            addCriterion("gspj is not null");
            return (Criteria) this;
        }

        public Criteria andGspjEqualTo(String value) {
            addCriterion("gspj =", value, "gspj");
            return (Criteria) this;
        }

        public Criteria andGspjNotEqualTo(String value) {
            addCriterion("gspj <>", value, "gspj");
            return (Criteria) this;
        }

        public Criteria andGspjGreaterThan(String value) {
            addCriterion("gspj >", value, "gspj");
            return (Criteria) this;
        }

        public Criteria andGspjGreaterThanOrEqualTo(String value) {
            addCriterion("gspj >=", value, "gspj");
            return (Criteria) this;
        }

        public Criteria andGspjLessThan(String value) {
            addCriterion("gspj <", value, "gspj");
            return (Criteria) this;
        }

        public Criteria andGspjLessThanOrEqualTo(String value) {
            addCriterion("gspj <=", value, "gspj");
            return (Criteria) this;
        }

        public Criteria andGspjLike(String value) {
            addCriterion("gspj like", value, "gspj");
            return (Criteria) this;
        }

        public Criteria andGspjNotLike(String value) {
            addCriterion("gspj not like", value, "gspj");
            return (Criteria) this;
        }

        public Criteria andGspjIn(List<String> values) {
            addCriterion("gspj in", values, "gspj");
            return (Criteria) this;
        }

        public Criteria andGspjNotIn(List<String> values) {
            addCriterion("gspj not in", values, "gspj");
            return (Criteria) this;
        }

        public Criteria andGspjBetween(String value1, String value2) {
            addCriterion("gspj between", value1, value2, "gspj");
            return (Criteria) this;
        }

        public Criteria andGspjNotBetween(String value1, String value2) {
            addCriterion("gspj not between", value1, value2, "gspj");
            return (Criteria) this;
        }

        public Criteria andSzdqIsNull() {
            addCriterion("szdq is null");
            return (Criteria) this;
        }

        public Criteria andSzdqIsNotNull() {
            addCriterion("szdq is not null");
            return (Criteria) this;
        }

        public Criteria andSzdqEqualTo(String value) {
            addCriterion("szdq =", value, "szdq");
            return (Criteria) this;
        }

        public Criteria andSzdqNotEqualTo(String value) {
            addCriterion("szdq <>", value, "szdq");
            return (Criteria) this;
        }

        public Criteria andSzdqGreaterThan(String value) {
            addCriterion("szdq >", value, "szdq");
            return (Criteria) this;
        }

        public Criteria andSzdqGreaterThanOrEqualTo(String value) {
            addCriterion("szdq >=", value, "szdq");
            return (Criteria) this;
        }

        public Criteria andSzdqLessThan(String value) {
            addCriterion("szdq <", value, "szdq");
            return (Criteria) this;
        }

        public Criteria andSzdqLessThanOrEqualTo(String value) {
            addCriterion("szdq <=", value, "szdq");
            return (Criteria) this;
        }

        public Criteria andSzdqLike(String value) {
            addCriterion("szdq like", value, "szdq");
            return (Criteria) this;
        }

        public Criteria andSzdqNotLike(String value) {
            addCriterion("szdq not like", value, "szdq");
            return (Criteria) this;
        }

        public Criteria andSzdqIn(List<String> values) {
            addCriterion("szdq in", values, "szdq");
            return (Criteria) this;
        }

        public Criteria andSzdqNotIn(List<String> values) {
            addCriterion("szdq not in", values, "szdq");
            return (Criteria) this;
        }

        public Criteria andSzdqBetween(String value1, String value2) {
            addCriterion("szdq between", value1, value2, "szdq");
            return (Criteria) this;
        }

        public Criteria andSzdqNotBetween(String value1, String value2) {
            addCriterion("szdq not between", value1, value2, "szdq");
            return (Criteria) this;
        }

        public Criteria andFwdqIsNull() {
            addCriterion("fwdq is null");
            return (Criteria) this;
        }

        public Criteria andFwdqIsNotNull() {
            addCriterion("fwdq is not null");
            return (Criteria) this;
        }

        public Criteria andFwdqEqualTo(String value) {
            addCriterion("fwdq =", value, "fwdq");
            return (Criteria) this;
        }

        public Criteria andFwdqNotEqualTo(String value) {
            addCriterion("fwdq <>", value, "fwdq");
            return (Criteria) this;
        }

        public Criteria andFwdqGreaterThan(String value) {
            addCriterion("fwdq >", value, "fwdq");
            return (Criteria) this;
        }

        public Criteria andFwdqGreaterThanOrEqualTo(String value) {
            addCriterion("fwdq >=", value, "fwdq");
            return (Criteria) this;
        }

        public Criteria andFwdqLessThan(String value) {
            addCriterion("fwdq <", value, "fwdq");
            return (Criteria) this;
        }

        public Criteria andFwdqLessThanOrEqualTo(String value) {
            addCriterion("fwdq <=", value, "fwdq");
            return (Criteria) this;
        }

        public Criteria andFwdqLike(String value) {
            addCriterion("fwdq like", value, "fwdq");
            return (Criteria) this;
        }

        public Criteria andFwdqNotLike(String value) {
            addCriterion("fwdq not like", value, "fwdq");
            return (Criteria) this;
        }

        public Criteria andFwdqIn(List<String> values) {
            addCriterion("fwdq in", values, "fwdq");
            return (Criteria) this;
        }

        public Criteria andFwdqNotIn(List<String> values) {
            addCriterion("fwdq not in", values, "fwdq");
            return (Criteria) this;
        }

        public Criteria andFwdqBetween(String value1, String value2) {
            addCriterion("fwdq between", value1, value2, "fwdq");
            return (Criteria) this;
        }

        public Criteria andFwdqNotBetween(String value1, String value2) {
            addCriterion("fwdq not between", value1, value2, "fwdq");
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