package ru.ifmo.ctddev.swapyourbook.dao;


import org.springframework.stereotype.Repository;
import ru.ifmo.ctddev.swapyourbook.helpers.SuggestionItem;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SearchDAO {
    String[] database = {"kokoko", "koko", "deyneka", "isaev", "mazin"};

    public int getNumberOfIntersectingStrings(String requestedString) {
        int cnt = 0;
        for (int i = 0; i < database.length; ++i) {
            if (database[i].toLowerCase().contains(requestedString.toLowerCase())) {
                ++cnt;
            }
        }
        return cnt;
    }

    public List<String> getSuggestionListForRequest(String requestedString) {
        /*
        List<SuggestionItem> suggestions = new ArrayList<>();
        for (int i = 0; i < database.length; ++i) {
            if (database[i].toLowerCase().contains(requestedString.toLowerCase())) {
                suggestions.add(new SuggestionItem(i, database[i]));
            }
        }
        */
        List<String> suggestions = new ArrayList<>();
        for (int i = 0; i < database.length; ++i) {
            if (database[i].toLowerCase().contains(requestedString.toLowerCase())) {
                suggestions.add(database[i]);
            }
        }

        return suggestions;
    }
}
