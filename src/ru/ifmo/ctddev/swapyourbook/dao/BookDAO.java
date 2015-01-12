package ru.ifmo.ctddev.swapyourbook.dao;

import com.mysql.jdbc.Statement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ru.ifmo.ctddev.swapyourbook.helpers.FileType;
import ru.ifmo.ctddev.swapyourbook.mybatis.dao.CustomUserMapper;
import ru.ifmo.ctddev.swapyourbook.mybatis.gen.dao.*;
import ru.ifmo.ctddev.swapyourbook.mybatis.gen.model.*;

import javax.sql.rowset.serial.SerialBlob;
import java.awt.print.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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
    private UserOfferMapper userOfferMapper;
    @Autowired
    private CustomUserMapper customUserMapper;
    @Autowired
    private UserWishMapper userWishMapper;
    @Autowired
    private AuthTokenMapper authTokenMapper;

    @Autowired
    private CityMapper cityMapper;

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

    public int putFileToDB(final byte[] imageThumbnail) {
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
        return keyHolder.getKey().intValue();
    }

    public synchronized boolean addOfferToUser(final int userID, final String authorName, final String title, final String description, final byte[] imageThumbnail) {
        final int imageID = putFileToDB(imageThumbnail);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                new PreparedStatementCreator() {
                    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                        PreparedStatement ps =
                                connection.prepareStatement(
                                        "INSERT INTO user_offer(title,author,comment,thumbnailID,from_google,owner) VALUES(?,?,?,?,?,?)",
                                        Statement.RETURN_GENERATED_KEYS);
                        ps.setString(1, title);
                        ps.setString(2, authorName);
                        ps.setString(3, description);
                        ps.setInt(4, imageID);
                        ps.setBoolean(5, false);
                        ps.setInt(6, userID);
                        return ps;
                    }
                },
                keyHolder);
        int bookID = keyHolder.getKey().intValue();
        return true;
    }

    public synchronized boolean addBookToUser(final int userID, final String authorName, final String title, final String description, final int imageID) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                new PreparedStatementCreator() {
                    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                        PreparedStatement ps =
                                connection.prepareStatement(
                                        "INSERT INTO book(title,author,comment,thumbnailID,from_google,owner) VALUES(?,?,?,?,?,?)",
                                        Statement.RETURN_GENERATED_KEYS);
                        ps.setString(1, title);
                        ps.setString(2, authorName);
                        ps.setString(3, description);
                        ps.setInt(4, imageID);
                        ps.setBoolean(5, false);
                        ps.setInt(6, userID);
                        return ps;
                    }
                },
                keyHolder);
        int bookID = keyHolder.getKey().intValue();
        jdbcTemplate.update("INSERT INTO user_book(userID,bookID) VALUES(?,?)", userID, bookID);
        return true;
    }

    public UserOffer getUserOffer(int bookID) {
        UserOfferExample example = new UserOfferExample();
        example.createCriteria().andBookidEqualTo(bookID);
        List<UserOffer> books = userOfferMapper.selectByExample(example);
        if (books.size() != 1) {
            return null;
        } else {
            return books.get(0);
        }
    }

    public synchronized boolean tryToEditBook(int userID, Integer bookID, String title, String author, String description, byte[] thumbnail) {
        UserOffer book = getUserOffer(bookID);
        if (book == null) return false;
        if (thumbnail != null
                || !description.equals(book.getComment())
                || !author.equals(book.getAuthor())
                || !title.equals(book.getTitle())) {
            int imageID = thumbnail == null ? book.getThumbnailid() : putFileToDB(thumbnail);
            book.setTitle(title);
            book.setComment(description);
            book.setAuthor(author);
            book.setThumbnailid(imageID);
            UserOfferExample idExample = new UserOfferExample();
            idExample.createCriteria().andBookidEqualTo(book.getBookid());
            userOfferMapper.updateByExample(book, idExample);
        }
        return true;
    }

    public void deleteUserOffer(int userOfferID) {
        UserOfferExample ex = new UserOfferExample();
        ex.createCriteria().andBookidEqualTo(userOfferID);
        userOfferMapper.deleteByExample(ex);
    }

    public void deleteUserWish(int userWishID) {
        UserWishExample ex = new UserWishExample();
        ex.createCriteria().andUserwishidEqualTo(userWishID);
        userWishMapper.deleteByExample(ex);
    }

    public City getCityByID(Integer cityid) {
        return cityMapper.selectByPrimaryKey(cityid);
    }

    public void addWishToUser(User currentUser, String authorName, String bookTitle) {
        UserWish wish = new UserWish(null, bookTitle, authorName, 0, currentUser.getUserid());
        userWishMapper.insert(wish);
    }

    public List<UserWish> getWishesByUser(User currentUser) {
        UserWishExample example = new UserWishExample();
        example.createCriteria().andOwnerEqualTo(currentUser.getUserid());
        return userWishMapper.selectByExample(example);
    }

    public void editUserWish(int userWishID, String authorName, String bookTitle) {
        UserWish userWish = userWishMapper.selectByPrimaryKey(userWishID);
        if(userWish!=null){
            userWish.setTitle(bookTitle);
            userWish.setAuthor(authorName);
            userWishMapper.updateByPrimaryKey(userWish);
        }
    }

    public void updateWish(UserWish wish) {
        userWishMapper.updateByPrimaryKey(wish);
    }

    public synchronized List<UserWish> getAllPendingWishes() {
       UserWishExample example = new UserWishExample();
        example.createCriteria().andMessageSentLessThan(3);
        return userWishMapper.selectByExample(example);
    }

    public synchronized List<User> findUsersWithMatchingBooks(UserWish wish) {
        String queryString = "SELECT user.* FROM user JOIN user_offer ON (user.userID = user_offer.owner) WHERE user_offer.title LIKE ? and user_offer.author LIKE ?";
        List<User> result;
        result = jdbcTemplate.query(queryString, new Object[]{wish.getTitle(),wish.getAuthor()}, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int i) throws SQLException {
                return new User(
                        rs.getInt("user.userID"),
                        rs.getString("user.username"),
                        rs.getInt("user.role"),
                        rs.getString("user.email"),
                        rs.getString("user.password"),
                        rs.getString("user.first_name"),
                        rs.getString("user.last_name"),
                        rs.getInt("avatarID"),
                        rs.getInt("cityID"));

            }
        });
        return result;
    }
}
