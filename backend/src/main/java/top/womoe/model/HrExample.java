package top.womoe.model;

import java.util.ArrayList;
import java.util.List;

public class HrExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HrExample() {
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

        public Criteria andHrUsernameIsNull() {
            addCriterion("hr_username is null");
            return (Criteria) this;
        }

        public Criteria andHrUsernameIsNotNull() {
            addCriterion("hr_username is not null");
            return (Criteria) this;
        }

        public Criteria andHrUsernameEqualTo(String value) {
            addCriterion("hr_username =", value, "hrUsername");
            return (Criteria) this;
        }

        public Criteria andHrUsernameNotEqualTo(String value) {
            addCriterion("hr_username <>", value, "hrUsername");
            return (Criteria) this;
        }

        public Criteria andHrUsernameGreaterThan(String value) {
            addCriterion("hr_username >", value, "hrUsername");
            return (Criteria) this;
        }

        public Criteria andHrUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("hr_username >=", value, "hrUsername");
            return (Criteria) this;
        }

        public Criteria andHrUsernameLessThan(String value) {
            addCriterion("hr_username <", value, "hrUsername");
            return (Criteria) this;
        }

        public Criteria andHrUsernameLessThanOrEqualTo(String value) {
            addCriterion("hr_username <=", value, "hrUsername");
            return (Criteria) this;
        }

        public Criteria andHrUsernameLike(String value) {
            addCriterion("hr_username like", value, "hrUsername");
            return (Criteria) this;
        }

        public Criteria andHrUsernameNotLike(String value) {
            addCriterion("hr_username not like", value, "hrUsername");
            return (Criteria) this;
        }

        public Criteria andHrUsernameIn(List<String> values) {
            addCriterion("hr_username in", values, "hrUsername");
            return (Criteria) this;
        }

        public Criteria andHrUsernameNotIn(List<String> values) {
            addCriterion("hr_username not in", values, "hrUsername");
            return (Criteria) this;
        }

        public Criteria andHrUsernameBetween(String value1, String value2) {
            addCriterion("hr_username between", value1, value2, "hrUsername");
            return (Criteria) this;
        }

        public Criteria andHrUsernameNotBetween(String value1, String value2) {
            addCriterion("hr_username not between", value1, value2, "hrUsername");
            return (Criteria) this;
        }

        public Criteria andHrPasswordIsNull() {
            addCriterion("hr_password is null");
            return (Criteria) this;
        }

        public Criteria andHrPasswordIsNotNull() {
            addCriterion("hr_password is not null");
            return (Criteria) this;
        }

        public Criteria andHrPasswordEqualTo(String value) {
            addCriterion("hr_password =", value, "hrPassword");
            return (Criteria) this;
        }

        public Criteria andHrPasswordNotEqualTo(String value) {
            addCriterion("hr_password <>", value, "hrPassword");
            return (Criteria) this;
        }

        public Criteria andHrPasswordGreaterThan(String value) {
            addCriterion("hr_password >", value, "hrPassword");
            return (Criteria) this;
        }

        public Criteria andHrPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("hr_password >=", value, "hrPassword");
            return (Criteria) this;
        }

        public Criteria andHrPasswordLessThan(String value) {
            addCriterion("hr_password <", value, "hrPassword");
            return (Criteria) this;
        }

        public Criteria andHrPasswordLessThanOrEqualTo(String value) {
            addCriterion("hr_password <=", value, "hrPassword");
            return (Criteria) this;
        }

        public Criteria andHrPasswordLike(String value) {
            addCriterion("hr_password like", value, "hrPassword");
            return (Criteria) this;
        }

        public Criteria andHrPasswordNotLike(String value) {
            addCriterion("hr_password not like", value, "hrPassword");
            return (Criteria) this;
        }

        public Criteria andHrPasswordIn(List<String> values) {
            addCriterion("hr_password in", values, "hrPassword");
            return (Criteria) this;
        }

        public Criteria andHrPasswordNotIn(List<String> values) {
            addCriterion("hr_password not in", values, "hrPassword");
            return (Criteria) this;
        }

        public Criteria andHrPasswordBetween(String value1, String value2) {
            addCriterion("hr_password between", value1, value2, "hrPassword");
            return (Criteria) this;
        }

        public Criteria andHrPasswordNotBetween(String value1, String value2) {
            addCriterion("hr_password not between", value1, value2, "hrPassword");
            return (Criteria) this;
        }

        public Criteria andHrNumberIsNull() {
            addCriterion("hr_number is null");
            return (Criteria) this;
        }

        public Criteria andHrNumberIsNotNull() {
            addCriterion("hr_number is not null");
            return (Criteria) this;
        }

        public Criteria andHrNumberEqualTo(String value) {
            addCriterion("hr_number =", value, "hrNumber");
            return (Criteria) this;
        }

        public Criteria andHrNumberNotEqualTo(String value) {
            addCriterion("hr_number <>", value, "hrNumber");
            return (Criteria) this;
        }

        public Criteria andHrNumberGreaterThan(String value) {
            addCriterion("hr_number >", value, "hrNumber");
            return (Criteria) this;
        }

        public Criteria andHrNumberGreaterThanOrEqualTo(String value) {
            addCriterion("hr_number >=", value, "hrNumber");
            return (Criteria) this;
        }

        public Criteria andHrNumberLessThan(String value) {
            addCriterion("hr_number <", value, "hrNumber");
            return (Criteria) this;
        }

        public Criteria andHrNumberLessThanOrEqualTo(String value) {
            addCriterion("hr_number <=", value, "hrNumber");
            return (Criteria) this;
        }

        public Criteria andHrNumberLike(String value) {
            addCriterion("hr_number like", value, "hrNumber");
            return (Criteria) this;
        }

        public Criteria andHrNumberNotLike(String value) {
            addCriterion("hr_number not like", value, "hrNumber");
            return (Criteria) this;
        }

        public Criteria andHrNumberIn(List<String> values) {
            addCriterion("hr_number in", values, "hrNumber");
            return (Criteria) this;
        }

        public Criteria andHrNumberNotIn(List<String> values) {
            addCriterion("hr_number not in", values, "hrNumber");
            return (Criteria) this;
        }

        public Criteria andHrNumberBetween(String value1, String value2) {
            addCriterion("hr_number between", value1, value2, "hrNumber");
            return (Criteria) this;
        }

        public Criteria andHrNumberNotBetween(String value1, String value2) {
            addCriterion("hr_number not between", value1, value2, "hrNumber");
            return (Criteria) this;
        }

        public Criteria andHrNameIsNull() {
            addCriterion("hr_name is null");
            return (Criteria) this;
        }

        public Criteria andHrNameIsNotNull() {
            addCriterion("hr_name is not null");
            return (Criteria) this;
        }

        public Criteria andHrNameEqualTo(String value) {
            addCriterion("hr_name =", value, "hrName");
            return (Criteria) this;
        }

        public Criteria andHrNameNotEqualTo(String value) {
            addCriterion("hr_name <>", value, "hrName");
            return (Criteria) this;
        }

        public Criteria andHrNameGreaterThan(String value) {
            addCriterion("hr_name >", value, "hrName");
            return (Criteria) this;
        }

        public Criteria andHrNameGreaterThanOrEqualTo(String value) {
            addCriterion("hr_name >=", value, "hrName");
            return (Criteria) this;
        }

        public Criteria andHrNameLessThan(String value) {
            addCriterion("hr_name <", value, "hrName");
            return (Criteria) this;
        }

        public Criteria andHrNameLessThanOrEqualTo(String value) {
            addCriterion("hr_name <=", value, "hrName");
            return (Criteria) this;
        }

        public Criteria andHrNameLike(String value) {
            addCriterion("hr_name like", value, "hrName");
            return (Criteria) this;
        }

        public Criteria andHrNameNotLike(String value) {
            addCriterion("hr_name not like", value, "hrName");
            return (Criteria) this;
        }

        public Criteria andHrNameIn(List<String> values) {
            addCriterion("hr_name in", values, "hrName");
            return (Criteria) this;
        }

        public Criteria andHrNameNotIn(List<String> values) {
            addCriterion("hr_name not in", values, "hrName");
            return (Criteria) this;
        }

        public Criteria andHrNameBetween(String value1, String value2) {
            addCriterion("hr_name between", value1, value2, "hrName");
            return (Criteria) this;
        }

        public Criteria andHrNameNotBetween(String value1, String value2) {
            addCriterion("hr_name not between", value1, value2, "hrName");
            return (Criteria) this;
        }

        public Criteria andHrSexIsNull() {
            addCriterion("hr_sex is null");
            return (Criteria) this;
        }

        public Criteria andHrSexIsNotNull() {
            addCriterion("hr_sex is not null");
            return (Criteria) this;
        }

        public Criteria andHrSexEqualTo(String value) {
            addCriterion("hr_sex =", value, "hrSex");
            return (Criteria) this;
        }

        public Criteria andHrSexNotEqualTo(String value) {
            addCriterion("hr_sex <>", value, "hrSex");
            return (Criteria) this;
        }

        public Criteria andHrSexGreaterThan(String value) {
            addCriterion("hr_sex >", value, "hrSex");
            return (Criteria) this;
        }

        public Criteria andHrSexGreaterThanOrEqualTo(String value) {
            addCriterion("hr_sex >=", value, "hrSex");
            return (Criteria) this;
        }

        public Criteria andHrSexLessThan(String value) {
            addCriterion("hr_sex <", value, "hrSex");
            return (Criteria) this;
        }

        public Criteria andHrSexLessThanOrEqualTo(String value) {
            addCriterion("hr_sex <=", value, "hrSex");
            return (Criteria) this;
        }

        public Criteria andHrSexLike(String value) {
            addCriterion("hr_sex like", value, "hrSex");
            return (Criteria) this;
        }

        public Criteria andHrSexNotLike(String value) {
            addCriterion("hr_sex not like", value, "hrSex");
            return (Criteria) this;
        }

        public Criteria andHrSexIn(List<String> values) {
            addCriterion("hr_sex in", values, "hrSex");
            return (Criteria) this;
        }

        public Criteria andHrSexNotIn(List<String> values) {
            addCriterion("hr_sex not in", values, "hrSex");
            return (Criteria) this;
        }

        public Criteria andHrSexBetween(String value1, String value2) {
            addCriterion("hr_sex between", value1, value2, "hrSex");
            return (Criteria) this;
        }

        public Criteria andHrSexNotBetween(String value1, String value2) {
            addCriterion("hr_sex not between", value1, value2, "hrSex");
            return (Criteria) this;
        }

        public Criteria andHrSeniorityIsNull() {
            addCriterion("hr_seniority is null");
            return (Criteria) this;
        }

        public Criteria andHrSeniorityIsNotNull() {
            addCriterion("hr_seniority is not null");
            return (Criteria) this;
        }

        public Criteria andHrSeniorityEqualTo(Integer value) {
            addCriterion("hr_seniority =", value, "hrSeniority");
            return (Criteria) this;
        }

        public Criteria andHrSeniorityNotEqualTo(Integer value) {
            addCriterion("hr_seniority <>", value, "hrSeniority");
            return (Criteria) this;
        }

        public Criteria andHrSeniorityGreaterThan(Integer value) {
            addCriterion("hr_seniority >", value, "hrSeniority");
            return (Criteria) this;
        }

        public Criteria andHrSeniorityGreaterThanOrEqualTo(Integer value) {
            addCriterion("hr_seniority >=", value, "hrSeniority");
            return (Criteria) this;
        }

        public Criteria andHrSeniorityLessThan(Integer value) {
            addCriterion("hr_seniority <", value, "hrSeniority");
            return (Criteria) this;
        }

        public Criteria andHrSeniorityLessThanOrEqualTo(Integer value) {
            addCriterion("hr_seniority <=", value, "hrSeniority");
            return (Criteria) this;
        }

        public Criteria andHrSeniorityIn(List<Integer> values) {
            addCriterion("hr_seniority in", values, "hrSeniority");
            return (Criteria) this;
        }

        public Criteria andHrSeniorityNotIn(List<Integer> values) {
            addCriterion("hr_seniority not in", values, "hrSeniority");
            return (Criteria) this;
        }

        public Criteria andHrSeniorityBetween(Integer value1, Integer value2) {
            addCriterion("hr_seniority between", value1, value2, "hrSeniority");
            return (Criteria) this;
        }

        public Criteria andHrSeniorityNotBetween(Integer value1, Integer value2) {
            addCriterion("hr_seniority not between", value1, value2, "hrSeniority");
            return (Criteria) this;
        }

        public Criteria andHrTelephoneIsNull() {
            addCriterion("hr_telephone is null");
            return (Criteria) this;
        }

        public Criteria andHrTelephoneIsNotNull() {
            addCriterion("hr_telephone is not null");
            return (Criteria) this;
        }

        public Criteria andHrTelephoneEqualTo(String value) {
            addCriterion("hr_telephone =", value, "hrTelephone");
            return (Criteria) this;
        }

        public Criteria andHrTelephoneNotEqualTo(String value) {
            addCriterion("hr_telephone <>", value, "hrTelephone");
            return (Criteria) this;
        }

        public Criteria andHrTelephoneGreaterThan(String value) {
            addCriterion("hr_telephone >", value, "hrTelephone");
            return (Criteria) this;
        }

        public Criteria andHrTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("hr_telephone >=", value, "hrTelephone");
            return (Criteria) this;
        }

        public Criteria andHrTelephoneLessThan(String value) {
            addCriterion("hr_telephone <", value, "hrTelephone");
            return (Criteria) this;
        }

        public Criteria andHrTelephoneLessThanOrEqualTo(String value) {
            addCriterion("hr_telephone <=", value, "hrTelephone");
            return (Criteria) this;
        }

        public Criteria andHrTelephoneLike(String value) {
            addCriterion("hr_telephone like", value, "hrTelephone");
            return (Criteria) this;
        }

        public Criteria andHrTelephoneNotLike(String value) {
            addCriterion("hr_telephone not like", value, "hrTelephone");
            return (Criteria) this;
        }

        public Criteria andHrTelephoneIn(List<String> values) {
            addCriterion("hr_telephone in", values, "hrTelephone");
            return (Criteria) this;
        }

        public Criteria andHrTelephoneNotIn(List<String> values) {
            addCriterion("hr_telephone not in", values, "hrTelephone");
            return (Criteria) this;
        }

        public Criteria andHrTelephoneBetween(String value1, String value2) {
            addCriterion("hr_telephone between", value1, value2, "hrTelephone");
            return (Criteria) this;
        }

        public Criteria andHrTelephoneNotBetween(String value1, String value2) {
            addCriterion("hr_telephone not between", value1, value2, "hrTelephone");
            return (Criteria) this;
        }

        public Criteria andHrTokenIsNull() {
            addCriterion("hr_token is null");
            return (Criteria) this;
        }

        public Criteria andHrTokenIsNotNull() {
            addCriterion("hr_token is not null");
            return (Criteria) this;
        }

        public Criteria andHrTokenEqualTo(String value) {
            addCriterion("hr_token =", value, "hrToken");
            return (Criteria) this;
        }

        public Criteria andHrTokenNotEqualTo(String value) {
            addCriterion("hr_token <>", value, "hrToken");
            return (Criteria) this;
        }

        public Criteria andHrTokenGreaterThan(String value) {
            addCriterion("hr_token >", value, "hrToken");
            return (Criteria) this;
        }

        public Criteria andHrTokenGreaterThanOrEqualTo(String value) {
            addCriterion("hr_token >=", value, "hrToken");
            return (Criteria) this;
        }

        public Criteria andHrTokenLessThan(String value) {
            addCriterion("hr_token <", value, "hrToken");
            return (Criteria) this;
        }

        public Criteria andHrTokenLessThanOrEqualTo(String value) {
            addCriterion("hr_token <=", value, "hrToken");
            return (Criteria) this;
        }

        public Criteria andHrTokenLike(String value) {
            addCriterion("hr_token like", value, "hrToken");
            return (Criteria) this;
        }

        public Criteria andHrTokenNotLike(String value) {
            addCriterion("hr_token not like", value, "hrToken");
            return (Criteria) this;
        }

        public Criteria andHrTokenIn(List<String> values) {
            addCriterion("hr_token in", values, "hrToken");
            return (Criteria) this;
        }

        public Criteria andHrTokenNotIn(List<String> values) {
            addCriterion("hr_token not in", values, "hrToken");
            return (Criteria) this;
        }

        public Criteria andHrTokenBetween(String value1, String value2) {
            addCriterion("hr_token between", value1, value2, "hrToken");
            return (Criteria) this;
        }

        public Criteria andHrTokenNotBetween(String value1, String value2) {
            addCriterion("hr_token not between", value1, value2, "hrToken");
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