package ru.ifmo.ctddev.swapyourbook.mybatis.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import ru.ifmo.ctddev.swapyourbook.mybatis.gen.model.User;

/**
 * Created by root on 12/20/14.
 */
public interface CustomUserMapper {
    @Insert({
            "insert into user (username, ",
            "role, email, password)",
            "values (#{username,jdbcType=VARCHAR}, ",
            "#{role,jdbcType=INTEGER}, #{email,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "userid")
    public int insertWithoutID(User user);
}
