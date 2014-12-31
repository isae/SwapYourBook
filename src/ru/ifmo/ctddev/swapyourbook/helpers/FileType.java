package ru.ifmo.ctddev.swapyourbook.helpers;

/**
 * Created by root on 12/31/14.
 */
public enum FileType {
    IMAGE_THUMBNAIL(1),
    USER_AVATAR(2),
    OTHER(3);
    public int type;

    FileType(int type) {
        this.type = type;
    }
}
