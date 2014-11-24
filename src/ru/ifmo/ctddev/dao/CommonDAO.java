package ru.ifmo.ctddev.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by root on 11/24/14.
 */

@Repository
public class CommonDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate = null;

    public CommonDAO(boolean ignored) {
        jdbcTemplate = new JdbcTemplate(new DriverManagerDataSource("jdbc:mysql://localhost:3306/book_db", "root", "admin"));
    }

    public CommonDAO() {

    }

    public Set<String> getAllUserNames() {
        assert jdbcTemplate != null;
        List<String> result = jdbcTemplate.query("SELECT * FROM user", (Object[]) null, new RowMapper<String>() {
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
}
