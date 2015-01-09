package ru.ifmo.ctddev.swapyourbook.dao;

import com.mysql.jdbc.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ru.ifmo.ctddev.swapyourbook.helpers.GoogleBooksSearcher;
import ru.ifmo.ctddev.swapyourbook.helpers.SearchItem;
import ru.ifmo.ctddev.swapyourbook.helpers.UserRole;
import ru.ifmo.ctddev.swapyourbook.mybatis.ExtendedBook;
import ru.ifmo.ctddev.swapyourbook.mybatis.dao.CustomUserMapper;
import ru.ifmo.ctddev.swapyourbook.helpers.MyLoggable;
import ru.ifmo.ctddev.swapyourbook.mybatis.gen.dao.*;
import ru.ifmo.ctddev.swapyourbook.mybatis.gen.model.*;

import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
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
    private CityMapper cityMapper;
    @Autowired
    private CustomUserMapper customUserMapper;
    @Autowired
    private UserOfferMapper userOfferMapper;
    @Autowired
    private AuthTokenMapper authTokenMapper;
    @Autowired
    private FileMapper fileMapper;
    @Autowired
    private BookDAO bookDAO;


    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // todo remove after testing
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
        List<String> result = jdbcTemplate.query("SELECT * FROM user ", (Object[]) null, new RowMapper<String>() {
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
        Integer result = jdbcTemplate.queryForObject("SELECT count(*) FROM user WHERE username = ?", new Object[]{username}, Integer.class);
        logger.debug("username: " + username + ", result is: " + result);
        return result == 0;
    }

    public void addAuthToken(String token, String email, String username, String password) {
        jdbcTemplate.update("INSERT INTO auth_token(token,username,password,email,created_timestamp) VALUES(?,?,?,?,?)", token, username, password, email, new Timestamp(System.currentTimeMillis()));
    }

    public synchronized User processAuthToken(String token) {
        AuthTokenExample example = new AuthTokenExample();
        example.createCriteria().andTokenEqualTo(token);
        List<AuthToken> tokens = authTokenMapper.selectByExample(example);
        assert tokens.size() == 1;
        AuthToken tok = tokens.get(0);
        User user = new User(null, tok.getUsername(), UserRole.USER.role, tok.getEmail(), tok.getPassword(), null, null, null, null);
        customUserMapper.insertWithoutID(user);
        authTokenMapper.deleteByExample(example);
        return user;
    }

    public User getUser(int userID) {
        return userMapper.selectByPrimaryKey(userID);
    }

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public List<UserOffer> getOffersByUserID(int userID) {
        UserOfferExample example = new UserOfferExample();
        example.createCriteria().andOwnerEqualTo(userID);
        return userOfferMapper.selectByExample(example);
    }

    public byte[] getImageByID(int imageID) {
        File file = fileMapper.selectByPrimaryKey(imageID);
        return file.getBytes();
    }

    public User getUser(String username) {
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<User> users = userMapper.selectByExample(example);
        if (users.size() != 1) {
            return null;
        } else {
            return users.get(0);
        }
    }

    public int addCity(final String cityName) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                new PreparedStatementCreator() {
                    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                        PreparedStatement ps =
                                connection.prepareStatement(
                                        "INSERT INTO city(name) VALUES(?)",
                                        com.mysql.jdbc.Statement.RETURN_GENERATED_KEYS);
                        ps.setString(1, cityName);
                        return ps;
                    }
                },
                keyHolder);
        return keyHolder.getKey().intValue();
    }

    public void editUser(User user, String userFirstName, String userLastName, String userEmail, String userCity, Integer cityID, byte[] bytes) {
        boolean mustUpdate = false;
        City city = bookDAO.getCityByID(cityID);
        mustUpdate = mustUpdate || (!userFirstName.equals(user.getFirstName()));
        mustUpdate = mustUpdate || (!userLastName.equals(user.getLastName()));
        mustUpdate = mustUpdate || !userCity.equals(city.getName());
        mustUpdate = mustUpdate || bytes != null;
        if (mustUpdate) {
            user.setFirstName(userFirstName);
            user.setLastName(userLastName);
            user.setEmail(userEmail);
            if (!userCity.equals(city.getName())) {
                int newCityID = addCity(userCity);
                user.setCityid(newCityID);
            }
            if (bytes != null) {
                int avaID = bookDAO.putFileToDB(bytes);
                user.setAvatarid(avaID);
            }
            UserExample example = new UserExample();
            example.createCriteria().andUseridEqualTo(user.getUserid());
            userMapper.updateByExample(user, example);
        }
    }

    public void changePassword(User user, String newPassword) {
        user.setPassword(newPassword);
        userMapper.updateByPrimaryKey(user);
    }

    public void deleteUser(User currentUser) {
        userMapper.deleteByPrimaryKey(currentUser.getUserid());
    }

    public List<String> getAutocompleteList(String requestedString,
                                            final boolean isByAuthor) {
        assert jdbcTemplate != null;

        String request = "%" + requestedString + "%";
        String queryString;
        List<String> matchedBooks = null;
        if (!isByAuthor) {
            queryString = "SELECT * FROM user_offer WHERE title LIKE ?";

        } else {
            queryString = "SELECT * FROM user_offer WHERE author LIKE ?";
        }

        // Find books
        matchedBooks = jdbcTemplate.query(queryString, new Object[]{request}, new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet rs, int i) throws SQLException {
                if (!isByAuthor) {
                    return rs.getString("title");
                } else {
                    return rs.getString("author");
                }
            }
        });

        return matchedBooks;
    }

    public List<String> getAutocompleteListByCities(String requestedString) {
        assert jdbcTemplate != null;

        String request = "%" + requestedString + "%";
        String queryString = "SELECT * FROM city WHERE name LIKE ?";
        // Find books
        List<String> matchedBooks = jdbcTemplate.query(queryString, new Object[]{request}, new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet rs, int i) throws SQLException {
                return rs.getString("name");
            }
        });

        return matchedBooks;
    }
}
