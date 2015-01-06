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
import org.springframework.web.multipart.MultipartFile;
import ru.ifmo.ctddev.swapyourbook.helpers.FileType;
import ru.ifmo.ctddev.swapyourbook.mybatis.ExtendedBook;
import ru.ifmo.ctddev.swapyourbook.mybatis.dao.CustomUserMapper;
import ru.ifmo.ctddev.swapyourbook.mybatis.gen.dao.AuthTokenMapper;
import ru.ifmo.ctddev.swapyourbook.mybatis.gen.dao.BookMapper;
import ru.ifmo.ctddev.swapyourbook.mybatis.gen.dao.UserBookMapper;
import ru.ifmo.ctddev.swapyourbook.mybatis.gen.dao.UserMapper;
import ru.ifmo.ctddev.swapyourbook.mybatis.gen.model.Book;
import ru.ifmo.ctddev.swapyourbook.mybatis.gen.model.BookExample;
import ru.ifmo.ctddev.swapyourbook.mybatis.gen.model.UserBook;
import ru.ifmo.ctddev.swapyourbook.mybatis.gen.model.UserBookExample;

import javax.mail.Multipart;
import javax.sql.rowset.serial.SerialBlob;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
    private BookMapper bookMapper;
    @Autowired
    private CustomUserMapper customUserMapper;
    @Autowired
    private UserBookMapper userBookMapper;
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

    public synchronized boolean addBookToUser(int userID, final String authorName, final String title, final String description, final byte[] imageThumbnail) {
        final int imageID = putFileToDB(imageThumbnail);
        KeyHolder keyHolder = new GeneratedKeyHolder();
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

    public synchronized boolean addBookToUser(int userID, final String authorName, final String title, final String description, final int imageID) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
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

    public Book getBook(int bookID) {
        BookExample example = new BookExample();
        example.createCriteria().andBookidEqualTo(bookID);
        List<Book> books = bookMapper.selectByExample(example);
        if (books.size() != 1) {
            return null;
        } else {
            return books.get(0);
        }
    }

    public synchronized boolean tryToEditBook(int userID, Integer bookID, String title, String author, String description, byte[] thumbnail) {
        Book book = getBook(bookID);
        if (book == null) return false;
        UserBookExample example = new UserBookExample();
        example.createCriteria().andBookidEqualTo(bookID);
        List<UserBook> userBooks = userBookMapper.selectByExample(example);
        if (thumbnail != null
                || !description.equals(book.getComment())
                || !author.equals(book.getAuthor())
                || !title.equals(book.getTitle())) {
            int imageID = thumbnail == null ? book.getThumbnailid() : putFileToDB(thumbnail);
            if (userBooks.size() > 1) {
                example.createCriteria().andUseridEqualTo(userID);
                userBookMapper.deleteByExample(example);
                addBookToUser(userID, author, title, description, imageID);
            } else {
                book.setTitle(title);
                book.setComment(description);
                book.setAuthor(author);
                book.setThumbnailid(imageID);
                BookExample idExample = new BookExample();
                idExample.createCriteria().andBookidEqualTo(book.getBookid());
                bookMapper.updateByExample(book, idExample);
            }
        }
        return true;
    }
}
