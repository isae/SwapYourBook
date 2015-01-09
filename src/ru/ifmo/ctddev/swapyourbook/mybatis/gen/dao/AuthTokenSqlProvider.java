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
import ru.ifmo.ctddev.swapyourbook.mybatis.gen.model.AuthToken;
import ru.ifmo.ctddev.swapyourbook.mybatis.gen.model.AuthTokenExample.Criteria;
import ru.ifmo.ctddev.swapyourbook.mybatis.gen.model.AuthTokenExample.Criterion;
import ru.ifmo.ctddev.swapyourbook.mybatis.gen.model.AuthTokenExample;

public class AuthTokenSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table auth_token
     *
     * @mbggenerated Fri Jan 09 18:39:37 MSK 2015
     */
    public String countByExample(AuthTokenExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("auth_token");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table auth_token
     *
     * @mbggenerated Fri Jan 09 18:39:37 MSK 2015
     */
    public String deleteByExample(AuthTokenExample example) {
        BEGIN();
        DELETE_FROM("auth_token");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table auth_token
     *
     * @mbggenerated Fri Jan 09 18:39:37 MSK 2015
     */
    public String insertSelective(AuthToken record) {
        BEGIN();
        INSERT_INTO("auth_token");
        
        if (record.getTokenid() != null) {
            VALUES("tokenID", "#{tokenid,jdbcType=BIGINT}");
        }
        
        if (record.getToken() != null) {
            VALUES("token", "#{token,jdbcType=VARCHAR}");
        }
        
        if (record.getUsername() != null) {
            VALUES("username", "#{username,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            VALUES("password", "#{password,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            VALUES("email", "#{email,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatedTimestamp() != null) {
            VALUES("created_timestamp", "#{createdTimestamp,jdbcType=TIMESTAMP}");
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table auth_token
     *
     * @mbggenerated Fri Jan 09 18:39:37 MSK 2015
     */
    public String selectByExample(AuthTokenExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("tokenID");
        } else {
            SELECT("tokenID");
        }
        SELECT("token");
        SELECT("username");
        SELECT("password");
        SELECT("email");
        SELECT("created_timestamp");
        FROM("auth_token");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table auth_token
     *
     * @mbggenerated Fri Jan 09 18:39:37 MSK 2015
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        AuthToken record = (AuthToken) parameter.get("record");
        AuthTokenExample example = (AuthTokenExample) parameter.get("example");
        
        BEGIN();
        UPDATE("auth_token");
        
        if (record.getTokenid() != null) {
            SET("tokenID = #{record.tokenid,jdbcType=BIGINT}");
        }
        
        if (record.getToken() != null) {
            SET("token = #{record.token,jdbcType=VARCHAR}");
        }
        
        if (record.getUsername() != null) {
            SET("username = #{record.username,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            SET("password = #{record.password,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            SET("email = #{record.email,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatedTimestamp() != null) {
            SET("created_timestamp = #{record.createdTimestamp,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table auth_token
     *
     * @mbggenerated Fri Jan 09 18:39:37 MSK 2015
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("auth_token");
        
        SET("tokenID = #{record.tokenid,jdbcType=BIGINT}");
        SET("token = #{record.token,jdbcType=VARCHAR}");
        SET("username = #{record.username,jdbcType=VARCHAR}");
        SET("password = #{record.password,jdbcType=VARCHAR}");
        SET("email = #{record.email,jdbcType=VARCHAR}");
        SET("created_timestamp = #{record.createdTimestamp,jdbcType=TIMESTAMP}");
        
        AuthTokenExample example = (AuthTokenExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table auth_token
     *
     * @mbggenerated Fri Jan 09 18:39:37 MSK 2015
     */
    public String updateByPrimaryKeySelective(AuthToken record) {
        BEGIN();
        UPDATE("auth_token");
        
        if (record.getToken() != null) {
            SET("token = #{token,jdbcType=VARCHAR}");
        }
        
        if (record.getUsername() != null) {
            SET("username = #{username,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            SET("password = #{password,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            SET("email = #{email,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatedTimestamp() != null) {
            SET("created_timestamp = #{createdTimestamp,jdbcType=TIMESTAMP}");
        }
        
        WHERE("tokenID = #{tokenid,jdbcType=BIGINT}");
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table auth_token
     *
     * @mbggenerated Fri Jan 09 18:39:37 MSK 2015
     */
    protected void applyWhere(AuthTokenExample example, boolean includeExamplePhrase) {
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