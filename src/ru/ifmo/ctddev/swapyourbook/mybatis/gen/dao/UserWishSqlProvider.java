package ru.ifmo.ctddev.swapyourbook.mybatis.gen.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.DELETE_FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.ORDER_BY;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT_DISTINCT;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import java.util.List;
import java.util.Map;
import ru.ifmo.ctddev.swapyourbook.mybatis.gen.model.UserWish;
import ru.ifmo.ctddev.swapyourbook.mybatis.gen.model.UserWishExample.Criteria;
import ru.ifmo.ctddev.swapyourbook.mybatis.gen.model.UserWishExample.Criterion;
import ru.ifmo.ctddev.swapyourbook.mybatis.gen.model.UserWishExample;

public class UserWishSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_wish
     *
     * @mbggenerated Fri Jan 09 18:39:37 MSK 2015
     */
    public String countByExample(UserWishExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("user_wish");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_wish
     *
     * @mbggenerated Fri Jan 09 18:39:37 MSK 2015
     */
    public String deleteByExample(UserWishExample example) {
        BEGIN();
        DELETE_FROM("user_wish");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_wish
     *
     * @mbggenerated Fri Jan 09 18:39:37 MSK 2015
     */
    public String insertSelective(UserWish record) {
        BEGIN();
        INSERT_INTO("user_wish");
        
        if (record.getUserwishid() != null) {
            VALUES("userWishID", "#{userwishid,jdbcType=INTEGER}");
        }
        
        if (record.getTitle() != null) {
            VALUES("title", "#{title,jdbcType=VARCHAR}");
        }
        
        if (record.getAuthor() != null) {
            VALUES("author", "#{author,jdbcType=VARCHAR}");
        }
        
        if (record.getMessageSent() != null) {
            VALUES("message_sent", "#{messageSent,jdbcType=INTEGER}");
        }
        
        if (record.getOwner() != null) {
            VALUES("owner", "#{owner,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_wish
     *
     * @mbggenerated Fri Jan 09 18:39:37 MSK 2015
     */
    public String selectByExample(UserWishExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("userWishID");
        } else {
            SELECT("userWishID");
        }
        SELECT("title");
        SELECT("author");
        SELECT("message_sent");
        SELECT("owner");
        FROM("user_wish");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_wish
     *
     * @mbggenerated Fri Jan 09 18:39:37 MSK 2015
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        UserWish record = (UserWish) parameter.get("record");
        UserWishExample example = (UserWishExample) parameter.get("example");
        
        BEGIN();
        UPDATE("user_wish");
        
        if (record.getUserwishid() != null) {
            SET("userWishID = #{record.userwishid,jdbcType=INTEGER}");
        }
        
        if (record.getTitle() != null) {
            SET("title = #{record.title,jdbcType=VARCHAR}");
        }
        
        if (record.getAuthor() != null) {
            SET("author = #{record.author,jdbcType=VARCHAR}");
        }
        
        if (record.getMessageSent() != null) {
            SET("message_sent = #{record.messageSent,jdbcType=INTEGER}");
        }
        
        if (record.getOwner() != null) {
            SET("owner = #{record.owner,jdbcType=INTEGER}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_wish
     *
     * @mbggenerated Fri Jan 09 18:39:37 MSK 2015
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("user_wish");
        
        SET("userWishID = #{record.userwishid,jdbcType=INTEGER}");
        SET("title = #{record.title,jdbcType=VARCHAR}");
        SET("author = #{record.author,jdbcType=VARCHAR}");
        SET("message_sent = #{record.messageSent,jdbcType=INTEGER}");
        SET("owner = #{record.owner,jdbcType=INTEGER}");
        
        UserWishExample example = (UserWishExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_wish
     *
     * @mbggenerated Fri Jan 09 18:39:37 MSK 2015
     */
    public String updateByPrimaryKeySelective(UserWish record) {
        BEGIN();
        UPDATE("user_wish");
        
        if (record.getTitle() != null) {
            SET("title = #{title,jdbcType=VARCHAR}");
        }
        
        if (record.getAuthor() != null) {
            SET("author = #{author,jdbcType=VARCHAR}");
        }
        
        if (record.getMessageSent() != null) {
            SET("message_sent = #{messageSent,jdbcType=INTEGER}");
        }
        
        if (record.getOwner() != null) {
            SET("owner = #{owner,jdbcType=INTEGER}");
        }
        
        WHERE("userWishID = #{userwishid,jdbcType=INTEGER}");
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_wish
     *
     * @mbggenerated Fri Jan 09 18:39:37 MSK 2015
     */
    protected void applyWhere(UserWishExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            WHERE(sb.toString());
        }
    }
}