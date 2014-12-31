package ru.ifmo.ctddev.swapyourbook.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;
import ru.ifmo.ctddev.swapyourbook.helpers.UserRole;
import ru.ifmo.ctddev.swapyourbook.mybatis.dao.CustomUserMapper;
import ru.ifmo.ctddev.swapyourbook.mybatis.gen.dao.AuthTokenMapper;
import ru.ifmo.ctddev.swapyourbook.mybatis.gen.dao.FileMapper;
import ru.ifmo.ctddev.swapyourbook.mybatis.gen.dao.UserMapper;
import ru.ifmo.ctddev.swapyourbook.helpers.MyLoggable;
import ru.ifmo.ctddev.swapyourbook.mybatis.gen.model.*;
import ru.ifmo.ctddev.swapyourbook.pojo.UserBookWrapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class UserDAO implements MyLoggable {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CustomUserMapper customUserMapper;
    @Autowired
    private AuthTokenMapper authTokenMapper;
    @Autowired
    private FileMapper fileMapper;


    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public UserDAO(boolean ignored) {
        String connectionString = "jdbc:mysql://178.62.246.183:3306/book_db?user=root" +
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

    public UserDAO() {
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

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public boolean isUsernameAvailable(String username) {
        Integer result = jdbcTemplate.queryForObject("SELECT count(*) FROM user WHERE username = ?", new Object[]{username},Integer.class);
        logger.debug("username: "+username+ ", result is: "+result);
        return result == 0;
    }

    public void addAuthToken(String token,String email,String username,String password) {
        jdbcTemplate.update("INSERT INTO auth_token(token,username,password,email) VALUES(?,?,?,?)",token,username,password,email);
    }

    public User processAuthToken(String token) {
        AuthTokenExample example = new AuthTokenExample();
        example.createCriteria().andTokenEqualTo(token);
        List<AuthToken> tokens = authTokenMapper.selectByExample(example);
        assert tokens.size() == 1;
        AuthToken tok = tokens.get(0);
        User user = new User(null, tok.getUsername(), UserRole.USER.role, tok.getEmail(), tok.getPassword());
        customUserMapper.insertWithoutID(user);
        return user;
    }

    public User getUser(int userID){
        return userMapper.selectByPrimaryKey(userID);
    }

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public List<UserBookWrapper> getBooksByUserID(int userID) {
        boolean f = true;
        return jdbcTemplate.query(
                "select * from user_book join book using(bookID) where userID = ?",
                new Object[]{userID},
                new RowMapper<UserBookWrapper>() {
            @Override
            public UserBookWrapper mapRow(ResultSet rs, int i) throws SQLException {
                UserBookWrapper wrapper = new UserBookWrapper();
                Book book = new Book();
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setThumbnailid(rs.getInt("thumbnailID"));
                book.setBookid(rs.getInt("bookID"));
                UserBook userBook = new UserBook();
                userBook.setBookid(rs.getInt("bookID"));
                userBook.setUserbookid(rs.getInt("userBookID"));
                wrapper.setBook(book);
                wrapper.setUserBook(userBook);
                return wrapper;
            }
        });
    }

    public byte[] getImageByID(int imageID) {
        File file = fileMapper.selectByPrimaryKey(imageID);
        return file.getBytes();
    }
}
