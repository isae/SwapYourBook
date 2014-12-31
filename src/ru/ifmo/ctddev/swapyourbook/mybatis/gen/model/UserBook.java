package ru.ifmo.ctddev.swapyourbook.mybatis.gen.model;

public class UserBook {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_book.userBookID
     *
     * @mbggenerated Wed Dec 31 00:38:26 MSK 2014
     */
    private Integer userbookid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_book.userID
     *
     * @mbggenerated Wed Dec 31 00:38:26 MSK 2014
     */
    private Integer userid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_book.bookID
     *
     * @mbggenerated Wed Dec 31 00:38:26 MSK 2014
     */
    private Integer bookid;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_book
     *
     * @mbggenerated Wed Dec 31 00:38:26 MSK 2014
     */
    public UserBook(Integer userbookid, Integer userid, Integer bookid) {
        this.userbookid = userbookid;
        this.userid = userid;
        this.bookid = bookid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_book
     *
     * @mbggenerated Wed Dec 31 00:38:26 MSK 2014
     */
    public UserBook() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_book.userBookID
     *
     * @return the value of user_book.userBookID
     *
     * @mbggenerated Wed Dec 31 00:38:26 MSK 2014
     */
    public Integer getUserbookid() {
        return userbookid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_book.userBookID
     *
     * @param userbookid the value for user_book.userBookID
     *
     * @mbggenerated Wed Dec 31 00:38:26 MSK 2014
     */
    public void setUserbookid(Integer userbookid) {
        this.userbookid = userbookid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_book.userID
     *
     * @return the value of user_book.userID
     *
     * @mbggenerated Wed Dec 31 00:38:26 MSK 2014
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_book.userID
     *
     * @param userid the value for user_book.userID
     *
     * @mbggenerated Wed Dec 31 00:38:26 MSK 2014
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_book.bookID
     *
     * @return the value of user_book.bookID
     *
     * @mbggenerated Wed Dec 31 00:38:26 MSK 2014
     */
    public Integer getBookid() {
        return bookid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_book.bookID
     *
     * @param bookid the value for user_book.bookID
     *
     * @mbggenerated Wed Dec 31 00:38:26 MSK 2014
     */
    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }
}