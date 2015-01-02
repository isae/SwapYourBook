package ru.ifmo.ctddev.swapyourbook.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;
import ru.ifmo.ctddev.swapyourbook.helpers.SearchItem;
import ru.ifmo.ctddev.swapyourbook.helpers.SuggestionItem;
import ru.ifmo.ctddev.swapyourbook.mybatis.dao.CustomUserMapper;
import ru.ifmo.ctddev.swapyourbook.mybatis.gen.dao.AuthTokenMapper;
import ru.ifmo.ctddev.swapyourbook.mybatis.gen.dao.FileMapper;
import ru.ifmo.ctddev.swapyourbook.mybatis.gen.dao.UserMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Repository
public class SearchDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CustomUserMapper customUserMapper;
    @Autowired
    private AuthTokenMapper authTokenMapper;

    public SearchDAO() {
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

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    // todo remove
    public int getNumberOfIntersectingStrings(String requestedString) {
        String[] database = {"kokoko", "koko", "deyneka", "isaev", "mazin"};

        int cnt = 0;
        for (int i = 0; i < database.length; ++i) {
            if (database[i].toLowerCase().contains(requestedString.toLowerCase())) {
                ++cnt;
            }
        }
        return cnt;
    }

    public List<String> getAutocompleteList(String requestedString) {
        assert jdbcTemplate != null;

        String request = "%" + requestedString + "%";
        List<String> matchedBooksAndAuthors = jdbcTemplate.query("SELECT * FROM book WHERE title LIKE ? OR author LIKE ?",
                                                       new Object[]{request, request},
                                                       new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet rs, int i) throws SQLException {
                return rs.getString("title");
            }
        });

        return matchedBooksAndAuthors;
    }

    public List<SearchItem> getSearchList(String requestedString,
                                          boolean isByAuthor,
                                          boolean isWithImages) {
        // todo use isWithImages
        assert jdbcTemplate != null;

        String request = "%" + requestedString + "%";
        String queryString;
        List<SearchItem> matchedBooks = null;
        if (!isByAuthor) {
            queryString = "SELECT * FROM book WHERE title LIKE ?";

        } else {
            queryString = "SELECT * FROM book WHERE author LIKE ?";
        }

        // Find books
        matchedBooks = jdbcTemplate.query(queryString, new Object[]{request}, new RowMapper<SearchItem>() {
                    @Override
                    public SearchItem mapRow(ResultSet rs, int i) throws SQLException {
                        SearchItem item = new SearchItem();
                        item.bookID = rs.getInt("bookID");
                        item.title = rs.getString("title");
                        item.author = rs.getString("author");
                        return item;
                    }
                });

        for (int i = 0; i < matchedBooks.size(); ++i) {
            SearchItem item = matchedBooks.get(i);
            List<Integer> ownersIds = jdbcTemplate.query("SELECT * FROM user_book WHERE bookID=item.bookID", (Object[])null, new RowMapper<Integer>() {
                @Override
                public Integer mapRow(ResultSet rs, int i) throws SQLException {
                    return rs.getInt("userID");
                }
            });

            List<String> owners = new ArrayList<String>(ownersIds.size());
            for (int j = 0; j < ownersIds.size(); ++j) {
                List<String> ownerName = jdbcTemplate.query("SELECT * FROM user WHERE userID=ownersIds.get(j)", (Object[])null, new RowMapper<String>() {
                    @Override
                    public String mapRow(ResultSet rs, int i) throws SQLException {
                        return rs.getString("username");
                    }
                });
                // todo
                assert ownerName.size() == 1;

                owners.add(ownerName.get(0));
            }

            matchedBooks.get(i).owners = owners;
        }

        return matchedBooks;
    }
}
