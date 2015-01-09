package ru.ifmo.ctddev.swapyourbook.mybatis.gen.model;

import java.util.ArrayList;
import java.util.List;

public class UserOfferExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table user_offer
     *
     * @mbggenerated Fri Jan 09 18:39:37 MSK 2015
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table user_offer
     *
     * @mbggenerated Fri Jan 09 18:39:37 MSK 2015
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table user_offer
     *
     * @mbggenerated Fri Jan 09 18:39:37 MSK 2015
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_offer
     *
     * @mbggenerated Fri Jan 09 18:39:37 MSK 2015
     */
    public UserOfferExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_offer
     *
     * @mbggenerated Fri Jan 09 18:39:37 MSK 2015
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_offer
     *
     * @mbggenerated Fri Jan 09 18:39:37 MSK 2015
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_offer
     *
     * @mbggenerated Fri Jan 09 18:39:37 MSK 2015
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_offer
     *
     * @mbggenerated Fri Jan 09 18:39:37 MSK 2015
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_offer
     *
     * @mbggenerated Fri Jan 09 18:39:37 MSK 2015
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_offer
     *
     * @mbggenerated Fri Jan 09 18:39:37 MSK 2015
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_offer
     *
     * @mbggenerated Fri Jan 09 18:39:37 MSK 2015
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_offer
     *
     * @mbggenerated Fri Jan 09 18:39:37 MSK 2015
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_offer
     *
     * @mbggenerated Fri Jan 09 18:39:37 MSK 2015
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_offer
     *
     * @mbggenerated Fri Jan 09 18:39:37 MSK 2015
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table user_offer
     *
     * @mbggenerated Fri Jan 09 18:39:37 MSK 2015
     */
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

        public Criteria andBookidIsNull() {
            addCriterion("bookID is null");
            return (Criteria) this;
        }

        public Criteria andBookidIsNotNull() {
            addCriterion("bookID is not null");
            return (Criteria) this;
        }

        public Criteria andBookidEqualTo(Integer value) {
            addCriterion("bookID =", value, "bookid");
            return (Criteria) this;
        }

        public Criteria andBookidNotEqualTo(Integer value) {
            addCriterion("bookID <>", value, "bookid");
            return (Criteria) this;
        }

        public Criteria andBookidGreaterThan(Integer value) {
            addCriterion("bookID >", value, "bookid");
            return (Criteria) this;
        }

        public Criteria andBookidGreaterThanOrEqualTo(Integer value) {
            addCriterion("bookID >=", value, "bookid");
            return (Criteria) this;
        }

        public Criteria andBookidLessThan(Integer value) {
            addCriterion("bookID <", value, "bookid");
            return (Criteria) this;
        }

        public Criteria andBookidLessThanOrEqualTo(Integer value) {
            addCriterion("bookID <=", value, "bookid");
            return (Criteria) this;
        }

        public Criteria andBookidIn(List<Integer> values) {
            addCriterion("bookID in", values, "bookid");
            return (Criteria) this;
        }

        public Criteria andBookidNotIn(List<Integer> values) {
            addCriterion("bookID not in", values, "bookid");
            return (Criteria) this;
        }

        public Criteria andBookidBetween(Integer value1, Integer value2) {
            addCriterion("bookID between", value1, value2, "bookid");
            return (Criteria) this;
        }

        public Criteria andBookidNotBetween(Integer value1, Integer value2) {
            addCriterion("bookID not between", value1, value2, "bookid");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNull() {
            addCriterion("author is null");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNotNull() {
            addCriterion("author is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorEqualTo(String value) {
            addCriterion("author =", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotEqualTo(String value) {
            addCriterion("author <>", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThan(String value) {
            addCriterion("author >", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("author >=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThan(String value) {
            addCriterion("author <", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThanOrEqualTo(String value) {
            addCriterion("author <=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLike(String value) {
            addCriterion("author like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotLike(String value) {
            addCriterion("author not like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorIn(List<String> values) {
            addCriterion("author in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotIn(List<String> values) {
            addCriterion("author not in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorBetween(String value1, String value2) {
            addCriterion("author between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotBetween(String value1, String value2) {
            addCriterion("author not between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andCommentIsNull() {
            addCriterion("comment is null");
            return (Criteria) this;
        }

        public Criteria andCommentIsNotNull() {
            addCriterion("comment is not null");
            return (Criteria) this;
        }

        public Criteria andCommentEqualTo(String value) {
            addCriterion("comment =", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotEqualTo(String value) {
            addCriterion("comment <>", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThan(String value) {
            addCriterion("comment >", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThanOrEqualTo(String value) {
            addCriterion("comment >=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThan(String value) {
            addCriterion("comment <", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThanOrEqualTo(String value) {
            addCriterion("comment <=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLike(String value) {
            addCriterion("comment like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotLike(String value) {
            addCriterion("comment not like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentIn(List<String> values) {
            addCriterion("comment in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotIn(List<String> values) {
            addCriterion("comment not in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentBetween(String value1, String value2) {
            addCriterion("comment between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotBetween(String value1, String value2) {
            addCriterion("comment not between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andFromGoogleIsNull() {
            addCriterion("from_google is null");
            return (Criteria) this;
        }

        public Criteria andFromGoogleIsNotNull() {
            addCriterion("from_google is not null");
            return (Criteria) this;
        }

        public Criteria andFromGoogleEqualTo(Boolean value) {
            addCriterion("from_google =", value, "fromGoogle");
            return (Criteria) this;
        }

        public Criteria andFromGoogleNotEqualTo(Boolean value) {
            addCriterion("from_google <>", value, "fromGoogle");
            return (Criteria) this;
        }

        public Criteria andFromGoogleGreaterThan(Boolean value) {
            addCriterion("from_google >", value, "fromGoogle");
            return (Criteria) this;
        }

        public Criteria andFromGoogleGreaterThanOrEqualTo(Boolean value) {
            addCriterion("from_google >=", value, "fromGoogle");
            return (Criteria) this;
        }

        public Criteria andFromGoogleLessThan(Boolean value) {
            addCriterion("from_google <", value, "fromGoogle");
            return (Criteria) this;
        }

        public Criteria andFromGoogleLessThanOrEqualTo(Boolean value) {
            addCriterion("from_google <=", value, "fromGoogle");
            return (Criteria) this;
        }

        public Criteria andFromGoogleIn(List<Boolean> values) {
            addCriterion("from_google in", values, "fromGoogle");
            return (Criteria) this;
        }

        public Criteria andFromGoogleNotIn(List<Boolean> values) {
            addCriterion("from_google not in", values, "fromGoogle");
            return (Criteria) this;
        }

        public Criteria andFromGoogleBetween(Boolean value1, Boolean value2) {
            addCriterion("from_google between", value1, value2, "fromGoogle");
            return (Criteria) this;
        }

        public Criteria andFromGoogleNotBetween(Boolean value1, Boolean value2) {
            addCriterion("from_google not between", value1, value2, "fromGoogle");
            return (Criteria) this;
        }

        public Criteria andThumbnailidIsNull() {
            addCriterion("thumbnailID is null");
            return (Criteria) this;
        }

        public Criteria andThumbnailidIsNotNull() {
            addCriterion("thumbnailID is not null");
            return (Criteria) this;
        }

        public Criteria andThumbnailidEqualTo(Integer value) {
            addCriterion("thumbnailID =", value, "thumbnailid");
            return (Criteria) this;
        }

        public Criteria andThumbnailidNotEqualTo(Integer value) {
            addCriterion("thumbnailID <>", value, "thumbnailid");
            return (Criteria) this;
        }

        public Criteria andThumbnailidGreaterThan(Integer value) {
            addCriterion("thumbnailID >", value, "thumbnailid");
            return (Criteria) this;
        }

        public Criteria andThumbnailidGreaterThanOrEqualTo(Integer value) {
            addCriterion("thumbnailID >=", value, "thumbnailid");
            return (Criteria) this;
        }

        public Criteria andThumbnailidLessThan(Integer value) {
            addCriterion("thumbnailID <", value, "thumbnailid");
            return (Criteria) this;
        }

        public Criteria andThumbnailidLessThanOrEqualTo(Integer value) {
            addCriterion("thumbnailID <=", value, "thumbnailid");
            return (Criteria) this;
        }

        public Criteria andThumbnailidIn(List<Integer> values) {
            addCriterion("thumbnailID in", values, "thumbnailid");
            return (Criteria) this;
        }

        public Criteria andThumbnailidNotIn(List<Integer> values) {
            addCriterion("thumbnailID not in", values, "thumbnailid");
            return (Criteria) this;
        }

        public Criteria andThumbnailidBetween(Integer value1, Integer value2) {
            addCriterion("thumbnailID between", value1, value2, "thumbnailid");
            return (Criteria) this;
        }

        public Criteria andThumbnailidNotBetween(Integer value1, Integer value2) {
            addCriterion("thumbnailID not between", value1, value2, "thumbnailid");
            return (Criteria) this;
        }

        public Criteria andTrustedIsNull() {
            addCriterion("trusted is null");
            return (Criteria) this;
        }

        public Criteria andTrustedIsNotNull() {
            addCriterion("trusted is not null");
            return (Criteria) this;
        }

        public Criteria andTrustedEqualTo(Boolean value) {
            addCriterion("trusted =", value, "trusted");
            return (Criteria) this;
        }

        public Criteria andTrustedNotEqualTo(Boolean value) {
            addCriterion("trusted <>", value, "trusted");
            return (Criteria) this;
        }

        public Criteria andTrustedGreaterThan(Boolean value) {
            addCriterion("trusted >", value, "trusted");
            return (Criteria) this;
        }

        public Criteria andTrustedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("trusted >=", value, "trusted");
            return (Criteria) this;
        }

        public Criteria andTrustedLessThan(Boolean value) {
            addCriterion("trusted <", value, "trusted");
            return (Criteria) this;
        }

        public Criteria andTrustedLessThanOrEqualTo(Boolean value) {
            addCriterion("trusted <=", value, "trusted");
            return (Criteria) this;
        }

        public Criteria andTrustedIn(List<Boolean> values) {
            addCriterion("trusted in", values, "trusted");
            return (Criteria) this;
        }

        public Criteria andTrustedNotIn(List<Boolean> values) {
            addCriterion("trusted not in", values, "trusted");
            return (Criteria) this;
        }

        public Criteria andTrustedBetween(Boolean value1, Boolean value2) {
            addCriterion("trusted between", value1, value2, "trusted");
            return (Criteria) this;
        }

        public Criteria andTrustedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("trusted not between", value1, value2, "trusted");
            return (Criteria) this;
        }

        public Criteria andOwnerIsNull() {
            addCriterion("owner is null");
            return (Criteria) this;
        }

        public Criteria andOwnerIsNotNull() {
            addCriterion("owner is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerEqualTo(Integer value) {
            addCriterion("owner =", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotEqualTo(Integer value) {
            addCriterion("owner <>", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerGreaterThan(Integer value) {
            addCriterion("owner >", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerGreaterThanOrEqualTo(Integer value) {
            addCriterion("owner >=", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerLessThan(Integer value) {
            addCriterion("owner <", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerLessThanOrEqualTo(Integer value) {
            addCriterion("owner <=", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerIn(List<Integer> values) {
            addCriterion("owner in", values, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotIn(List<Integer> values) {
            addCriterion("owner not in", values, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerBetween(Integer value1, Integer value2) {
            addCriterion("owner between", value1, value2, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotBetween(Integer value1, Integer value2) {
            addCriterion("owner not between", value1, value2, "owner");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table user_offer
     *
     * @mbggenerated do_not_delete_during_merge Fri Jan 09 18:39:37 MSK 2015
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table user_offer
     *
     * @mbggenerated Fri Jan 09 18:39:37 MSK 2015
     */
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