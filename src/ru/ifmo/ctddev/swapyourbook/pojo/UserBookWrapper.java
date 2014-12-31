package ru.ifmo.ctddev.swapyourbook.pojo;

import ru.ifmo.ctddev.swapyourbook.mybatis.gen.model.Book;
import ru.ifmo.ctddev.swapyourbook.mybatis.gen.model.File;
import ru.ifmo.ctddev.swapyourbook.mybatis.gen.model.UserBook;

/**
 * Created by root on 12/31/14.
 */
public class UserBookWrapper {
    private UserBook userBook;
    private Book book;

    public UserBook getUserBook() {
        return userBook;
    }

    public void setUserBook(UserBook userBook) {
        this.userBook = userBook;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
