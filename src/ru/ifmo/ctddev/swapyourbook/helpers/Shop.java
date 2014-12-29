package ru.ifmo.ctddev.swapyourbook.helpers;

import java.io.Serializable;

public class Shop implements Serializable {

    private String name;
    private String staffName[];

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String[] getStaffName() {
        return staffName;
    }
    public void setStaffName(String[] staffName) {
        this.staffName = staffName;
    }

}