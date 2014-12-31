package ru.ifmo.ctddev.swapyourbook.helpers;

/**
 * Created by root on 12/20/14.
 */
public enum UserRole {
    ADMIN(1),
    USER(2);
    public int role;

    UserRole(int role) {
        this.role = role;
    }
}
