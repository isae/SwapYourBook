package ru.ifmo.ctddev.swapyourbook.helpers;

/**
 * Created by root on 12/20/14.
 */
public enum UserRoleID {
    ADMIN(1),
    USER(2);
    public int roleID;

    UserRoleID(int roleID) {
        this.roleID = roleID;
    }
}
