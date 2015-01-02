package ru.ifmo.ctddev.swapyourbook.helpers;

/**
 * Created by root on 1/2/15.
 */
public enum UserBookHelper {
    OFFER(1),
    WISH(2);
    public int type;

    UserBookHelper(int type) {
        this.type = type;
    }
}
