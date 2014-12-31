package ru.ifmo.ctddev.swapyourbook.mybatis.gen.model;

public class Book {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book.bookID
     *
     * @mbggenerated Wed Dec 31 00:38:26 MSK 2014
     */
    private Integer bookid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book.title
     *
     * @mbggenerated Wed Dec 31 00:38:26 MSK 2014
     */
    private String title;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book.author
     *
     * @mbggenerated Wed Dec 31 00:38:26 MSK 2014
     */
    private String author;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book.comment
     *
     * @mbggenerated Wed Dec 31 00:38:26 MSK 2014
     */
    private String comment;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book.from_google
     *
     * @mbggenerated Wed Dec 31 00:38:26 MSK 2014
     */
    private Boolean fromGoogle;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book.thumbnailID
     *
     * @mbggenerated Wed Dec 31 00:38:26 MSK 2014
     */
    private Integer thumbnailid;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table book
     *
     * @mbggenerated Wed Dec 31 00:38:26 MSK 2014
     */
    public Book(Integer bookid, String title, String author, String comment, Boolean fromGoogle, Integer thumbnailid) {
        this.bookid = bookid;
        this.title = title;
        this.author = author;
        this.comment = comment;
        this.fromGoogle = fromGoogle;
        this.thumbnailid = thumbnailid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table book
     *
     * @mbggenerated Wed Dec 31 00:38:26 MSK 2014
     */
    public Book() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book.bookID
     *
     * @return the value of book.bookID
     *
     * @mbggenerated Wed Dec 31 00:38:26 MSK 2014
     */
    public Integer getBookid() {
        return bookid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book.bookID
     *
     * @param bookid the value for book.bookID
     *
     * @mbggenerated Wed Dec 31 00:38:26 MSK 2014
     */
    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book.title
     *
     * @return the value of book.title
     *
     * @mbggenerated Wed Dec 31 00:38:26 MSK 2014
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book.title
     *
     * @param title the value for book.title
     *
     * @mbggenerated Wed Dec 31 00:38:26 MSK 2014
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book.author
     *
     * @return the value of book.author
     *
     * @mbggenerated Wed Dec 31 00:38:26 MSK 2014
     */
    public String getAuthor() {
        return author;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book.author
     *
     * @param author the value for book.author
     *
     * @mbggenerated Wed Dec 31 00:38:26 MSK 2014
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book.comment
     *
     * @return the value of book.comment
     *
     * @mbggenerated Wed Dec 31 00:38:26 MSK 2014
     */
    public String getComment() {
        return comment;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book.comment
     *
     * @param comment the value for book.comment
     *
     * @mbggenerated Wed Dec 31 00:38:26 MSK 2014
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book.from_google
     *
     * @return the value of book.from_google
     *
     * @mbggenerated Wed Dec 31 00:38:26 MSK 2014
     */
    public Boolean getFromGoogle() {
        return fromGoogle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book.from_google
     *
     * @param fromGoogle the value for book.from_google
     *
     * @mbggenerated Wed Dec 31 00:38:26 MSK 2014
     */
    public void setFromGoogle(Boolean fromGoogle) {
        this.fromGoogle = fromGoogle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book.thumbnailID
     *
     * @return the value of book.thumbnailID
     *
     * @mbggenerated Wed Dec 31 00:38:26 MSK 2014
     */
    public Integer getThumbnailid() {
        return thumbnailid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book.thumbnailID
     *
     * @param thumbnailid the value for book.thumbnailID
     *
     * @mbggenerated Wed Dec 31 00:38:26 MSK 2014
     */
    public void setThumbnailid(Integer thumbnailid) {
        this.thumbnailid = thumbnailid;
    }
}