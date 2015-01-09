package ru.ifmo.ctddev.swapyourbook.mybatis.gen.dao;

import java.util.List;
import org.apache.ibatis.annotations.Arg;
import org.apache.ibatis.annotations.ConstructorArgs;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import ru.ifmo.ctddev.swapyourbook.mybatis.gen.model.User;
import ru.ifmo.ctddev.swapyourbook.mybatis.gen.model.UserExample;

public interface UserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Fri Jan 09 18:39:37 MSK 2015
     */
    @SelectProvider(type=UserSqlProvider.class, method="countByExample")
    int countByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Fri Jan 09 18:39:37 MSK 2015
     */
    @DeleteProvider(type=UserSqlProvider.class, method="deleteByExample")
    int deleteByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Fri Jan 09 18:39:37 MSK 2015
     */
    @Delete({
        "delete from user",
        "where userID = #{userid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer userid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Fri Jan 09 18:39:37 MSK 2015
     */
    @Insert({
        "insert into user (userID, username, ",
        "role, email, password, ",
        "first_name, last_name, ",
        "avatarID, cityID)",
        "values (#{userid,jdbcType=INTEGER}, #{username,jdbcType=VARCHAR}, ",
        "#{role,jdbcType=INTEGER}, #{email,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, ",
        "#{firstName,jdbcType=VARCHAR}, #{lastName,jdbcType=VARCHAR}, ",
        "#{avatarid,jdbcType=INTEGER}, #{cityid,jdbcType=INTEGER})"
    })
    int insert(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Fri Jan 09 18:39:37 MSK 2015
     */
    @InsertProvider(type=UserSqlProvider.class, method="insertSelective")
    int insertSelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Fri Jan 09 18:39:37 MSK 2015
     */
    @SelectProvider(type=UserSqlProvider.class, method="selectByExample")
    @ConstructorArgs({
        @Arg(column="userID", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="username", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="role", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="email", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="password", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="first_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="last_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="avatarID", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="cityID", javaType=Integer.class, jdbcType=JdbcType.INTEGER)
    })
    List<User> selectByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Fri Jan 09 18:39:37 MSK 2015
     */
    @Select({
        "select",
        "userID, username, role, email, password, first_name, last_name, avatarID, cityID",
        "from user",
        "where userID = #{userid,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
        @Arg(column="userID", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="username", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="role", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="email", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="password", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="first_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="last_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="avatarID", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="cityID", javaType=Integer.class, jdbcType=JdbcType.INTEGER)
    })
    User selectByPrimaryKey(Integer userid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Fri Jan 09 18:39:37 MSK 2015
     */
    @UpdateProvider(type=UserSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Fri Jan 09 18:39:37 MSK 2015
     */
    @UpdateProvider(type=UserSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Fri Jan 09 18:39:37 MSK 2015
     */
    @UpdateProvider(type=UserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Fri Jan 09 18:39:37 MSK 2015
     */
    @Update({
        "update user",
        "set username = #{username,jdbcType=VARCHAR},",
          "role = #{role,jdbcType=INTEGER},",
          "email = #{email,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "first_name = #{firstName,jdbcType=VARCHAR},",
          "last_name = #{lastName,jdbcType=VARCHAR},",
          "avatarID = #{avatarid,jdbcType=INTEGER},",
          "cityID = #{cityid,jdbcType=INTEGER}",
        "where userID = #{userid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(User record);
}