package ru.ifmo.ctddev.swapyourbook.mybatis;

import com.google.api.services.books.model.Volume;
import ru.ifmo.ctddev.swapyourbook.mybatis.gen.model.Book;

/**
 * Created by root on 12/28/14.
 */
public class ExtendedBook extends Book {
    private String smallLink;
    private String mediumLink;
    private String largeLink;

    public ExtendedBook(Integer bookid, String title, String author, String comment, Boolean fromGoogle, byte[] image) {
        super(bookid, title, author, comment, fromGoogle, image);
    }

    public ExtendedBook() {

    }

    public void setSmallLink(String smallLink) {
        this.smallLink = smallLink;
    }

    public String getSmallLink() {
        return smallLink;
    }

    public void setMediumLink(String mediumLink) {
        this.mediumLink = mediumLink;
    }

    public String getMediumLink() {
        return mediumLink;
    }

    public void setLargeLink(String largeLink) {
        this.largeLink = largeLink;
    }

    public String getLargeLink() {
        return largeLink;
    }
}
