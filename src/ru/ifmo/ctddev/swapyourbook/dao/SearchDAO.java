package ru.ifmo.ctddev.swapyourbook.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.ifmo.ctddev.swapyourbook.helpers.GoogleBooksSearcher;
import ru.ifmo.ctddev.swapyourbook.helpers.SearchItem;
import ru.ifmo.ctddev.swapyourbook.mybatis.ExtendedBook;
import ru.ifmo.ctddev.swapyourbook.mybatis.gen.dao.UserMapper;
import ru.ifmo.ctddev.swapyourbook.mybatis.gen.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
public class SearchDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private UserMapper userMapper;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public List<String> getAutocompleteList(String requestedString) {
        List<ExtendedBook> books = new ArrayList<>();
        // search both by titles and authors
        books.addAll(GoogleBooksSearcher.queryGoogleBooksCommon(requestedString, requestedString));

        Set<String> sortedBooksAndAuthors = new HashSet<String>();
        for (int i = 0; i < books.size(); ++i) {
            if (books.get(i).getTitle().toLowerCase().contains(requestedString.toLowerCase())) {
                sortedBooksAndAuthors.add(books.get(i).getTitle());
            } else {
                sortedBooksAndAuthors.add(books.get(i).getAuthor());
            }
        }

        List<String> sortedAsList = new ArrayList<>(sortedBooksAndAuthors.size());
        sortedAsList.addAll(sortedBooksAndAuthors);
        return sortedAsList;
    }

    public List<SearchItem> getSearchList(String requestedString,
                                          boolean isByAuthor) {
        assert jdbcTemplate != null;


        String request = "%" + requestedString + "%";
        String queryString;
        List<SearchItem> matchedBooks = null;
        if (!isByAuthor) {
            queryString = "SELECT * FROM user_offer WHERE title LIKE ?";

        } else {
            queryString = "SELECT * FROM user_offer WHERE author LIKE ?";
        }



        // Find books
        matchedBooks = jdbcTemplate.query(queryString, new Object[]{request}, new RowMapper<SearchItem>() {
                    @Override
                    public SearchItem mapRow(ResultSet rs, int i) throws SQLException {
                        SearchItem item = new SearchItem();
                        item.setBookID(rs.getInt("bookID"));
                        item.setTitle(rs.getString("title"));
                        item.setAuthor(rs.getString("author"));
                        item.setImgID(rs.getInt("thumbnailID"));
                        item.setOwnerId(rs.getInt("owner"));
                        item.setComment(rs.getString("comment"));
                        return item;
                    }
                });


        for (int i = 0; i < matchedBooks.size(); ++i) {
            SearchItem item = matchedBooks.get(i);
            int requestedId = item.getOwnerId();
            User owner = userMapper.selectByPrimaryKey(requestedId);

            item.setOwner(owner);

            if (item.getComment() == null) {
                item.setComment("Описания нет");
            }
        }

        return matchedBooks;
    }
}
