package ru.ifmo.ctddev.swapyourbook.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;
import ru.ifmo.ctddev.swapyourbook.helpers.MyLoggable;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by root on 11/24/14.
 */

@Repository
public class CommonDAO implements MyLoggable{

    private JdbcTemplate jdbcTemplate;


    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public CommonDAO(boolean ignored) {
        String connectionString = "jdbc:mysql://localhost:3306/book_db?user=root" +
                "&password=admin" +
                "&useUnicode=true" +
                "&characterEncoding=UTF-8" +
                "&autoReconnect=true" +
                "&failOverReadOnly=false" +
                "&maxReconnects=3";
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
        }
        jdbcTemplate = new JdbcTemplate(new DriverManagerDataSource(connectionString));
    }

    public CommonDAO() {
    }

    public Set<String> getAllUserNames() {
        assert jdbcTemplate != null;
        List<String> result = jdbcTemplate.query("SELECT * FROM user ", (Object[])null, new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet rs, int i) throws SQLException {
                return rs.getString("username");
            }
        });
        return new HashSet<>(result);
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public boolean isUsernameAvailable(String username) {
        Integer result = jdbcTemplate.queryForObject("SELECT 1 FROM user WHERE username = ?", new Object[]{username},Integer.class);
        logger.debug("username: "+username+ ", result is: "+result);
        return result != null;
    }
}
