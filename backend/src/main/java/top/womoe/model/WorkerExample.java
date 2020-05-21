package top.womoe.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class WorkerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WorkerExample() {
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

        public Criteria andWksNumberIsNull() {
            addCriterion("wks_number is null");
            return (Criteria) this;
        }

        public Criteria andWksNumberIsNotNull() {
            addCriterion("wks_number is not null");
            return (Criteria) this;
        }

        public Criteria andWksNumberEqualTo(String value) {
            addCriterion("wks_number =", value, "wksNumber");
            return (Criteria) this;
        }

        public Criteria andWksNumberNotEqualTo(String value) {
            addCriterion("wks_number <>", value, "wksNumber");
            return (Criteria) this;
        }

        public Criteria andWksNumberGreaterThan(String value) {
            addCriterion("wks_number >", value, "wksNumber");
            return (Criteria) this;
        }

        public Criteria andWksNumberGreaterThanOrEqualTo(String value) {
            addCriterion("wks_number >=", value, "wksNumber");
            return (Criteria) this;
        }

        public Criteria andWksNumberLessThan(String value) {
            addCriterion("wks_number <", value, "wksNumber");
            return (Criteria) this;
        }

        public Criteria andWksNumberLessThanOrEqualTo(String value) {
            addCriterion("wks_number <=", value, "wksNumber");
            return (Criteria) this;
        }

        public Criteria andWksNumberLike(String value) {
            addCriterion("wks_number like", value, "wksNumber");
            return (Criteria) this;
        }

        public Criteria andWksNumberNotLike(String value) {
            addCriterion("wks_number not like", value, "wksNumber");
            return (Criteria) this;
        }

        public Criteria andWksNumberIn(List<String> values) {
            addCriterion("wks_number in", values, "wksNumber");
            return (Criteria) this;
        }

        public Criteria andWksNumberNotIn(List<String> values) {
            addCriterion("wks_number not in", values, "wksNumber");
            return (Criteria) this;
        }

        public Criteria andWksNumberBetween(String value1, String value2) {
            addCriterion("wks_number between", value1, value2, "wksNumber");
            return (Criteria) this;
        }

        public Criteria andWksNumberNotBetween(String value1, String value2) {
            addCriterion("wks_number not between", value1, value2, "wksNumber");
            return (Criteria) this;
        }

        public Criteria andWksNameIsNull() {
            addCriterion("wks_name is null");
            return (Criteria) this;
        }

        public Criteria andWksNameIsNotNull() {
            addCriterion("wks_name is not null");
            return (Criteria) this;
        }

        public Criteria andWksNameEqualTo(String value) {
            addCriterion("wks_name =", value, "wksName");
            return (Criteria) this;
        }

        public Criteria andWksNameNotEqualTo(String value) {
            addCriterion("wks_name <>", value, "wksName");
            return (Criteria) this;
        }

        public Criteria andWksNameGreaterThan(String value) {
            addCriterion("wks_name >", value, "wksName");
            return (Criteria) this;
        }

        public Criteria andWksNameGreaterThanOrEqualTo(String value) {
            addCriterion("wks_name >=", value, "wksName");
            return (Criteria) this;
        }

        public Criteria andWksNameLessThan(String value) {
            addCriterion("wks_name <", value, "wksName");
            return (Criteria) this;
        }

        public Criteria andWksNameLessThanOrEqualTo(String value) {
            addCriterion("wks_name <=", value, "wksName");
            return (Criteria) this;
        }

        public Criteria andWksNameLike(String value) {
            addCriterion("wks_name like", value, "wksName");
            return (Criteria) this;
        }

        public Criteria andWksNameNotLike(String value) {
            addCriterion("wks_name not like", value, "wksName");
            return (Criteria) this;
        }

        public Criteria andWksNameIn(List<String> values) {
            addCriterion("wks_name in", values, "wksName");
            return (Criteria) this;
        }

        public Criteria andWksNameNotIn(List<String> values) {
            addCriterion("wks_name not in", values, "wksName");
            return (Criteria) this;
        }

        public Criteria andWksNameBetween(String value1, String value2) {
            addCriterion("wks_name between", value1, value2, "wksName");
            return (Criteria) this;
        }

        public Criteria andWksNameNotBetween(String value1, String value2) {
            addCriterion("wks_name not between", value1, value2, "wksName");
            return (Criteria) this;
        }

        public Criteria andWksBirthdateIsNull() {
            addCriterion("wks_birthdate is null");
            return (Criteria) this;
        }

        public Criteria andWksBirthdateIsNotNull() {
            addCriterion("wks_birthdate is not null");
            return (Criteria) this;
        }

        public Criteria andWksBirthdateEqualTo(Date value) {
            addCriterionForJDBCDate("wks_birthdate =", value, "wksBirthdate");
            return (Criteria) this;
        }

        public Criteria andWksBirthdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("wks_birthdate <>", value, "wksBirthdate");
            return (Criteria) this;
        }

        public Criteria andWksBirthdateGreaterThan(Date value) {
            addCriterionForJDBCDate("wks_birthdate >", value, "wksBirthdate");
            return (Criteria) this;
        }

        public Criteria andWksBirthdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("wks_birthdate >=", value, "wksBirthdate");
            return (Criteria) this;
        }

        public Criteria andWksBirthdateLessThan(Date value) {
            addCriterionForJDBCDate("wks_birthdate <", value, "wksBirthdate");
            return (Criteria) this;
        }

        public Criteria andWksBirthdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("wks_birthdate <=", value, "wksBirthdate");
            return (Criteria) this;
        }

        public Criteria andWksBirthdateIn(List<Date> values) {
            addCriterionForJDBCDate("wks_birthdate in", values, "wksBirthdate");
            return (Criteria) this;
        }

        public Criteria andWksBirthdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("wks_birthdate not in", values, "wksBirthdate");
            return (Criteria) this;
        }

        public Criteria andWksBirthdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("wks_birthdate between", value1, value2, "wksBirthdate");
            return (Criteria) this;
        }

        public Criteria andWksBirthdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("wks_birthdate not between", value1, value2, "wksBirthdate");
            return (Criteria) this;
        }

        public Criteria andWksEduIsNull() {
            addCriterion("wks_edu is null");
            return (Criteria) this;
        }

        public Criteria andWksEduIsNotNull() {
            addCriterion("wks_edu is not null");
            return (Criteria) this;
        }

        public Criteria andWksEduEqualTo(Integer value) {
            addCriterion("wks_edu =", value, "wksEdu");
            return (Criteria) this;
        }

        public Criteria andWksEduNotEqualTo(Integer value) {
            addCriterion("wks_edu <>", value, "wksEdu");
            return (Criteria) this;
        }

        public Criteria andWksEduGreaterThan(Integer value) {
            addCriterion("wks_edu >", value, "wksEdu");
            return (Criteria) this;
        }

        public Criteria andWksEduGreaterThanOrEqualTo(Integer value) {
            addCriterion("wks_edu >=", value, "wksEdu");
            return (Criteria) this;
        }

        public Criteria andWksEduLessThan(Integer value) {
            addCriterion("wks_edu <", value, "wksEdu");
            return (Criteria) this;
        }

        public Criteria andWksEduLessThanOrEqualTo(Integer value) {
            addCriterion("wks_edu <=", value, "wksEdu");
            return (Criteria) this;
        }

        public Criteria andWksEduIn(List<Integer> values) {
            addCriterion("wks_edu in", values, "wksEdu");
            return (Criteria) this;
        }

        public Criteria andWksEduNotIn(List<Integer> values) {
            addCriterion("wks_edu not in", values, "wksEdu");
            return (Criteria) this;
        }

        public Criteria andWksEduBetween(Integer value1, Integer value2) {
            addCriterion("wks_edu between", value1, value2, "wksEdu");
            return (Criteria) this;
        }

        public Criteria andWksEduNotBetween(Integer value1, Integer value2) {
            addCriterion("wks_edu not between", value1, value2, "wksEdu");
            return (Criteria) this;
        }

        public Criteria andWksHometownIsNull() {
            addCriterion("wks_hometown is null");
            return (Criteria) this;
        }

        public Criteria andWksHometownIsNotNull() {
            addCriterion("wks_hometown is not null");
            return (Criteria) this;
        }

        public Criteria andWksHometownEqualTo(String value) {
            addCriterion("wks_hometown =", value, "wksHometown");
            return (Criteria) this;
        }

        public Criteria andWksHometownNotEqualTo(String value) {
            addCriterion("wks_hometown <>", value, "wksHometown");
            return (Criteria) this;
        }

        public Criteria andWksHometownGreaterThan(String value) {
            addCriterion("wks_hometown >", value, "wksHometown");
            return (Criteria) this;
        }

        public Criteria andWksHometownGreaterThanOrEqualTo(String value) {
            addCriterion("wks_hometown >=", value, "wksHometown");
            return (Criteria) this;
        }

        public Criteria andWksHometownLessThan(String value) {
            addCriterion("wks_hometown <", value, "wksHometown");
            return (Criteria) this;
        }

        public Criteria andWksHometownLessThanOrEqualTo(String value) {
            addCriterion("wks_hometown <=", value, "wksHometown");
            return (Criteria) this;
        }

        public Criteria andWksHometownLike(String value) {
            addCriterion("wks_hometown like", value, "wksHometown");
            return (Criteria) this;
        }

        public Criteria andWksHometownNotLike(String value) {
            addCriterion("wks_hometown not like", value, "wksHometown");
            return (Criteria) this;
        }

        public Criteria andWksHometownIn(List<String> values) {
            addCriterion("wks_hometown in", values, "wksHometown");
            return (Criteria) this;
        }

        public Criteria andWksHometownNotIn(List<String> values) {
            addCriterion("wks_hometown not in", values, "wksHometown");
            return (Criteria) this;
        }

        public Criteria andWksHometownBetween(String value1, String value2) {
            addCriterion("wks_hometown between", value1, value2, "wksHometown");
            return (Criteria) this;
        }

        public Criteria andWksHometownNotBetween(String value1, String value2) {
            addCriterion("wks_hometown not between", value1, value2, "wksHometown");
            return (Criteria) this;
        }

        public Criteria andWksAddressIsNull() {
            addCriterion("wks_address is null");
            return (Criteria) this;
        }

        public Criteria andWksAddressIsNotNull() {
            addCriterion("wks_address is not null");
            return (Criteria) this;
        }

        public Criteria andWksAddressEqualTo(String value) {
            addCriterion("wks_address =", value, "wksAddress");
            return (Criteria) this;
        }

        public Criteria andWksAddressNotEqualTo(String value) {
            addCriterion("wks_address <>", value, "wksAddress");
            return (Criteria) this;
        }

        public Criteria andWksAddressGreaterThan(String value) {
            addCriterion("wks_address >", value, "wksAddress");
            return (Criteria) this;
        }

        public Criteria andWksAddressGreaterThanOrEqualTo(String value) {
            addCriterion("wks_address >=", value, "wksAddress");
            return (Criteria) this;
        }

        public Criteria andWksAddressLessThan(String value) {
            addCriterion("wks_address <", value, "wksAddress");
            return (Criteria) this;
        }

        public Criteria andWksAddressLessThanOrEqualTo(String value) {
            addCriterion("wks_address <=", value, "wksAddress");
            return (Criteria) this;
        }

        public Criteria andWksAddressLike(String value) {
            addCriterion("wks_address like", value, "wksAddress");
            return (Criteria) this;
        }

        public Criteria andWksAddressNotLike(String value) {
            addCriterion("wks_address not like", value, "wksAddress");
            return (Criteria) this;
        }

        public Criteria andWksAddressIn(List<String> values) {
            addCriterion("wks_address in", values, "wksAddress");
            return (Criteria) this;
        }

        public Criteria andWksAddressNotIn(List<String> values) {
            addCriterion("wks_address not in", values, "wksAddress");
            return (Criteria) this;
        }

        public Criteria andWksAddressBetween(String value1, String value2) {
            addCriterion("wks_address between", value1, value2, "wksAddress");
            return (Criteria) this;
        }

        public Criteria andWksAddressNotBetween(String value1, String value2) {
            addCriterion("wks_address not between", value1, value2, "wksAddress");
            return (Criteria) this;
        }

        public Criteria andWksTelephoneIsNull() {
            addCriterion("wks_telephone is null");
            return (Criteria) this;
        }

        public Criteria andWksTelephoneIsNotNull() {
            addCriterion("wks_telephone is not null");
            return (Criteria) this;
        }

        public Criteria andWksTelephoneEqualTo(String value) {
            addCriterion("wks_telephone =", value, "wksTelephone");
            return (Criteria) this;
        }

        public Criteria andWksTelephoneNotEqualTo(String value) {
            addCriterion("wks_telephone <>", value, "wksTelephone");
            return (Criteria) this;
        }

        public Criteria andWksTelephoneGreaterThan(String value) {
            addCriterion("wks_telephone >", value, "wksTelephone");
            return (Criteria) this;
        }

        public Criteria andWksTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("wks_telephone >=", value, "wksTelephone");
            return (Criteria) this;
        }

        public Criteria andWksTelephoneLessThan(String value) {
            addCriterion("wks_telephone <", value, "wksTelephone");
            return (Criteria) this;
        }

        public Criteria andWksTelephoneLessThanOrEqualTo(String value) {
            addCriterion("wks_telephone <=", value, "wksTelephone");
            return (Criteria) this;
        }

        public Criteria andWksTelephoneLike(String value) {
            addCriterion("wks_telephone like", value, "wksTelephone");
            return (Criteria) this;
        }

        public Criteria andWksTelephoneNotLike(String value) {
            addCriterion("wks_telephone not like", value, "wksTelephone");
            return (Criteria) this;
        }

        public Criteria andWksTelephoneIn(List<String> values) {
            addCriterion("wks_telephone in", values, "wksTelephone");
            return (Criteria) this;
        }

        public Criteria andWksTelephoneNotIn(List<String> values) {
            addCriterion("wks_telephone not in", values, "wksTelephone");
            return (Criteria) this;
        }

        public Criteria andWksTelephoneBetween(String value1, String value2) {
            addCriterion("wks_telephone between", value1, value2, "wksTelephone");
            return (Criteria) this;
        }

        public Criteria andWksTelephoneNotBetween(String value1, String value2) {
            addCriterion("wks_telephone not between", value1, value2, "wksTelephone");
            return (Criteria) this;
        }

        public Criteria andWksSeniorityIsNull() {
            addCriterion("wks_seniority is null");
            return (Criteria) this;
        }

        public Criteria andWksSeniorityIsNotNull() {
            addCriterion("wks_seniority is not null");
            return (Criteria) this;
        }

        public Criteria andWksSeniorityEqualTo(Integer value) {
            addCriterion("wks_seniority =", value, "wksSeniority");
            return (Criteria) this;
        }

        public Criteria andWksSeniorityNotEqualTo(Integer value) {
            addCriterion("wks_seniority <>", value, "wksSeniority");
            return (Criteria) this;
        }

        public Criteria andWksSeniorityGreaterThan(Integer value) {
            addCriterion("wks_seniority >", value, "wksSeniority");
            return (Criteria) this;
        }

        public Criteria andWksSeniorityGreaterThanOrEqualTo(Integer value) {
            addCriterion("wks_seniority >=", value, "wksSeniority");
            return (Criteria) this;
        }

        public Criteria andWksSeniorityLessThan(Integer value) {
            addCriterion("wks_seniority <", value, "wksSeniority");
            return (Criteria) this;
        }

        public Criteria andWksSeniorityLessThanOrEqualTo(Integer value) {
            addCriterion("wks_seniority <=", value, "wksSeniority");
            return (Criteria) this;
        }

        public Criteria andWksSeniorityIn(List<Integer> values) {
            addCriterion("wks_seniority in", values, "wksSeniority");
            return (Criteria) this;
        }

        public Criteria andWksSeniorityNotIn(List<Integer> values) {
            addCriterion("wks_seniority not in", values, "wksSeniority");
            return (Criteria) this;
        }

        public Criteria andWksSeniorityBetween(Integer value1, Integer value2) {
            addCriterion("wks_seniority between", value1, value2, "wksSeniority");
            return (Criteria) this;
        }

        public Criteria andWksSeniorityNotBetween(Integer value1, Integer value2) {
            addCriterion("wks_seniority not between", value1, value2, "wksSeniority");
            return (Criteria) this;
        }

        public Criteria andWksBasesalaryIsNull() {
            addCriterion("wks_basesalary is null");
            return (Criteria) this;
        }

        public Criteria andWksBasesalaryIsNotNull() {
            addCriterion("wks_basesalary is not null");
            return (Criteria) this;
        }

        public Criteria andWksBasesalaryEqualTo(Float value) {
            addCriterion("wks_basesalary =", value, "wksBasesalary");
            return (Criteria) this;
        }

        public Criteria andWksBasesalaryNotEqualTo(Float value) {
            addCriterion("wks_basesalary <>", value, "wksBasesalary");
            return (Criteria) this;
        }

        public Criteria andWksBasesalaryGreaterThan(Float value) {
            addCriterion("wks_basesalary >", value, "wksBasesalary");
            return (Criteria) this;
        }

        public Criteria andWksBasesalaryGreaterThanOrEqualTo(Float value) {
            addCriterion("wks_basesalary >=", value, "wksBasesalary");
            return (Criteria) this;
        }

        public Criteria andWksBasesalaryLessThan(Float value) {
            addCriterion("wks_basesalary <", value, "wksBasesalary");
            return (Criteria) this;
        }

        public Criteria andWksBasesalaryLessThanOrEqualTo(Float value) {
            addCriterion("wks_basesalary <=", value, "wksBasesalary");
            return (Criteria) this;
        }

        public Criteria andWksBasesalaryIn(List<Float> values) {
            addCriterion("wks_basesalary in", values, "wksBasesalary");
            return (Criteria) this;
        }

        public Criteria andWksBasesalaryNotIn(List<Float> values) {
            addCriterion("wks_basesalary not in", values, "wksBasesalary");
            return (Criteria) this;
        }

        public Criteria andWksBasesalaryBetween(Float value1, Float value2) {
            addCriterion("wks_basesalary between", value1, value2, "wksBasesalary");
            return (Criteria) this;
        }

        public Criteria andWksBasesalaryNotBetween(Float value1, Float value2) {
            addCriterion("wks_basesalary not between", value1, value2, "wksBasesalary");
            return (Criteria) this;
        }

        public Criteria andWksSexIsNull() {
            addCriterion("wks_sex is null");
            return (Criteria) this;
        }

        public Criteria andWksSexIsNotNull() {
            addCriterion("wks_sex is not null");
            return (Criteria) this;
        }

        public Criteria andWksSexEqualTo(String value) {
            addCriterion("wks_sex =", value, "wksSex");
            return (Criteria) this;
        }

        public Criteria andWksSexNotEqualTo(String value) {
            addCriterion("wks_sex <>", value, "wksSex");
            return (Criteria) this;
        }

        public Criteria andWksSexGreaterThan(String value) {
            addCriterion("wks_sex >", value, "wksSex");
            return (Criteria) this;
        }

        public Criteria andWksSexGreaterThanOrEqualTo(String value) {
            addCriterion("wks_sex >=", value, "wksSex");
            return (Criteria) this;
        }

        public Criteria andWksSexLessThan(String value) {
            addCriterion("wks_sex <", value, "wksSex");
            return (Criteria) this;
        }

        public Criteria andWksSexLessThanOrEqualTo(String value) {
            addCriterion("wks_sex <=", value, "wksSex");
            return (Criteria) this;
        }

        public Criteria andWksSexLike(String value) {
            addCriterion("wks_sex like", value, "wksSex");
            return (Criteria) this;
        }

        public Criteria andWksSexNotLike(String value) {
            addCriterion("wks_sex not like", value, "wksSex");
            return (Criteria) this;
        }

        public Criteria andWksSexIn(List<String> values) {
            addCriterion("wks_sex in", values, "wksSex");
            return (Criteria) this;
        }

        public Criteria andWksSexNotIn(List<String> values) {
            addCriterion("wks_sex not in", values, "wksSex");
            return (Criteria) this;
        }

        public Criteria andWksSexBetween(String value1, String value2) {
            addCriterion("wks_sex between", value1, value2, "wksSex");
            return (Criteria) this;
        }

        public Criteria andWksSexNotBetween(String value1, String value2) {
            addCriterion("wks_sex not between", value1, value2, "wksSex");
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