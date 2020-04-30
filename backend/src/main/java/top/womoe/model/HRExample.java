package top.womoe.model;

import java.util.ArrayList;
import java.util.List;

public class HRExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HRExample() {
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