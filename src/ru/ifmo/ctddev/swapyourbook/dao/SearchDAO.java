package ru.ifmo.ctddev.swapyourbook.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.ifmo.ctddev.swapyourbook.helpers.GoogleBooksSearcher;
import ru.ifmo.ctddev.swapyourbook.helpers.SearchItem;
import ru.ifmo.ctddev.swapyourbook.mybatis.ExtendedBook;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SearchDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

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
        List<ExtendedBook> books = new ArrayList<>();
        System.out.println("#############READY NIGGA#####");
        // search both by titles and authors
        books.addAll(GoogleBooksSearcher.queryGoogleBooksCommon(requestedString, null));

        List<String> matchedBooksAndAuthors = new ArrayList<>(books.size());
        for (int i = 0; i < books.size(); ++i) {
            if (books.get(i).getTitle().toLowerCase().contains(requestedString.toLowerCase())) {
                matchedBooksAndAuthors.add(books.get(i).getTitle());
            } else {
                matchedBooksAndAuthors.add(books.get(i).getAuthor());
            }
        }

        return matchedBooksAndAuthors;
    }

    public List<SearchItem> getSearchList(String requestedString,
                                          boolean isByAuthor) {
        assert jdbcTemplate != null;

        String request = "%" + requestedString + "%";
        String queryString;
        List<SearchItem> matchedBooks = null;
        if (!isByAuthor) {
            queryString = "SELECT * FROM user_wish WHERE title LIKE ?";

        } else {
            queryString = "SELECT * FROM user_wish WHERE author LIKE ?";
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
                        return item;
                    }
                });

        for (int i = 0; i < matchedBooks.size(); ++i) {
            SearchItem item = matchedBooks.get(i);
            int requestedId = item.getBookID();
            List<Integer> ownersIds = jdbcTemplate.query("SELECT * FROM user_wish WHERE bookID=?", new Object[]{requestedId}, new RowMapper<Integer>() {
                @Override
                public Integer mapRow(ResultSet rs, int i) throws SQLException {
                    return rs.getInt("owner");
                }
            });

            List<String> owners = new ArrayList<String>(ownersIds.size());
            for (int j = 0; j < ownersIds.size(); ++j) {
                requestedId = ownersIds.get(j);
                List<String> ownerName = jdbcTemplate.query("SELECT * FROM user WHERE userID=?", new Object[]{requestedId}, new RowMapper<String>() {
                    @Override
                    public String mapRow(ResultSet rs, int i) throws SQLException {
                        return rs.getString("username");
                    }
                });
                // todo
                assert ownerName.size() == 1;

                owners.add(ownerName.get(0));
            }

            matchedBooks.get(i).setOwners(owners);
        }

        return matchedBooks;
    }
}
