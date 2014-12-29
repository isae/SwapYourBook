package ru.ifmo.ctddev.swapyourbook.helpers;

import java.io.Serializable;

public class SuggestionItem {
    public int id;
    public String name;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public SuggestionItem(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
