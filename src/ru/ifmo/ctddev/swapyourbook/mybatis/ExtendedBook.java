package ru.ifmo.ctddev.swapyourbook.mybatis;

import ru.ifmo.ctddev.swapyourbook.mybatis.gen.model.Book;

/**
 * Created by root on 12/28/14.
 */
public class ExtendedBook extends Book {
    private String imageLink;

    public int getUserBook() {
        return userBook;
    }

    public void setUserBook(int userBook) {
        this.userBook = userBook;
    }

    private int userBook;

    public ExtendedBook(Integer bookid, String title, String author, String comment, Boolean fromGoogle, Integer thumbnailid, Boolean trusted) {
        super(bookid, title, author, comment, fromGoogle, thumbnailid, trusted);
    }

    public ExtendedBook(Book book) {
        super(book.getBookid(), book.getTitle(), book.getAuthor(), book.getComment(), book.getFromGoogle(), book.getThumbnailid(), book.getTrusted());
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
