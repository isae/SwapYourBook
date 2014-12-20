package ru.ifmo.ctddev.swapyourbook.dao;

import org.springframework.stereotype.Repository;

@Repository
public class SearchDAO {
    String[] possibleStrings = {"kokoko", "koko", "deyneka", "isaev", "mazin"};

    public int getNumberOfIntersectingStrings(String requestedString) {
        int cnt = 0;
        for (int i = 0; i < possibleStrings.length; ++i) {
            if (possibleStrings[i].toLowerCase().contains(requestedString.toLowerCase())) {
                ++cnt;
            }
        }
        return cnt;
    }
}
