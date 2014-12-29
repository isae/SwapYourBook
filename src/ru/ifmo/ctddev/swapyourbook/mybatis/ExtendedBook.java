package ru.ifmo.ctddev.swapyourbook.mybatis;

import ru.ifmo.ctddev.swapyourbook.mybatis.gen.model.Book;

/**
 * Created by root on 12/28/14.
 */
public class ExtendedBook extends Book {
    private String imageLink;

    public ExtendedBook(Integer bookid, String title, String author, String comment, Boolean fromGoogle, byte[] image) {
        super(bookid, title, author, comment, fromGoogle, image);
    }

    public ExtendedBook() {

    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public String getImageLink() {
        return imageLink;
    }
}
