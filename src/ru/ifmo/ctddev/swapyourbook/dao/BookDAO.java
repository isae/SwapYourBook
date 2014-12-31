package ru.ifmo.ctddev.swapyourbook.dao;

import com.mysql.jdbc.Blob;
import com.mysql.jdbc.Statement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ru.ifmo.ctddev.swapyourbook.helpers.FileType;
import ru.ifmo.ctddev.swapyourbook.mybatis.dao.CustomUserMapper;
import ru.ifmo.ctddev.swapyourbook.mybatis.gen.dao.AuthTokenMapper;
import ru.ifmo.ctddev.swapyourbook.mybatis.gen.dao.UserMapper;

import javax.sql.rowset.serial.SerialBlob;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by root on 12/31/14.
 */
@Repository
public class BookDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CustomUserMapper customUserMapper;
    @Autowired
    private AuthTokenMapper authTokenMapper;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public void setCustomUserMapper(CustomUserMapper customUserMapper) {
        this.customUserMapper = customUserMapper;
    }

    public void setAuthTokenMapper(AuthTokenMapper authTokenMapper) {
        this.authTokenMapper = authTokenMapper;
    }

    public boolean addBookToUser(int userID, final String authorName, final String title, final String description, final byte[] imageThumbnail) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                new PreparedStatementCreator() {
                    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                        PreparedStatement ps =
                                connection.prepareStatement(
                                        "INSERT INTO file(fileType,bytes) VALUES(?,?)",
                                        Statement.RETURN_GENERATED_KEYS);
                        ps.setInt(1, FileType.IMAGE_THUMBNAIL.type);
                        ps.setBlob(2, new SerialBlob(imageThumbnail));
                        return ps;
                    }
                },
                keyHolder);
        final int imageID = keyHolder.getKey().intValue();
        keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                new PreparedStatementCreator() {
                    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                        PreparedStatement ps =
                                connection.prepareStatement(
                                        "INSERT INTO book(title,author,comment,thumbnailID,from_google) VALUES(?,?,?,?,?)",
                                        Statement.RETURN_GENERATED_KEYS);
                        ps.setString(1, title);
                        ps.setString(2, authorName);
                        ps.setString(3, description);
                        ps.setInt(4, imageID);
                        ps.setBoolean(5, false);
                        return ps;
                    }
                },
                keyHolder);
        int bookID = keyHolder.getKey().intValue();
        jdbcTemplate.update("INSERT INTO user_book(userID,bookID) VALUES(?,?)", userID, bookID);
        return true;
    }
}
