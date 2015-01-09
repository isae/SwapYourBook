package ru.ifmo.ctddev.swapyourbook.mybatis.gen.model;

public class UserWish {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_wish.userWishID
     *
     * @mbggenerated Fri Jan 09 18:39:37 MSK 2015
     */
    private Integer userwishid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_wish.title
     *
     * @mbggenerated Fri Jan 09 18:39:37 MSK 2015
     */
    private String title;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_wish.author
     *
     * @mbggenerated Fri Jan 09 18:39:37 MSK 2015
     */
    private String author;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_wish.message_sent
     *
     * @mbggenerated Fri Jan 09 18:39:37 MSK 2015
     */
    private Integer messageSent;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_wish.owner
     *
     * @mbggenerated Fri Jan 09 18:39:37 MSK 2015
     */
    private Integer owner;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_wish
     *
     * @mbggenerated Fri Jan 09 18:39:37 MSK 2015
     */
    public UserWish(Integer userwishid, String title, String author, Integer messageSent, Integer owner) {
        this.userwishid = userwishid;
        this.title = title;
        this.author = author;
        this.messageSent = messageSent;
        this.owner = owner;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_wish
     *
     * @mbggenerated Fri Jan 09 18:39:37 MSK 2015
     */
    public UserWish() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_wish.userWishID
     *
     * @return the value of user_wish.userWishID
     *
     * @mbggenerated Fri Jan 09 18:39:37 MSK 2015
     */
    public Integer getUserwishid() {
        return userwishid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_wish.userWishID
     *
     * @param userwishid the value for user_wish.userWishID
     *
     * @mbggenerated Fri Jan 09 18:39:37 MSK 2015
     */
    public void setUserwishid(Integer userwishid) {
        this.userwishid = userwishid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_wish.title
     *
     * @return the value of user_wish.title
     *
     * @mbggenerated Fri Jan 09 18:39:37 MSK 2015
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_wish.title
     *
     * @param title the value for user_wish.title
     *
     * @mbggenerated Fri Jan 09 18:39:37 MSK 2015
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_wish.author
     *
     * @return the value of user_wish.author
     *
     * @mbggenerated Fri Jan 09 18:39:37 MSK 2015
     */
    public String getAuthor() {
        return author;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_wish.author
     *
     * @param author the value for user_wish.author
     *
     * @mbggenerated Fri Jan 09 18:39:37 MSK 2015
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_wish.message_sent
     *
     * @return the value of user_wish.message_sent
     *
     * @mbggenerated Fri Jan 09 18:39:37 MSK 2015
     */
    public Integer getMessageSent() {
        return messageSent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_wish.message_sent
     *
     * @param messageSent the value for user_wish.message_sent
     *
     * @mbggenerated Fri Jan 09 18:39:37 MSK 2015
     */
    public void setMessageSent(Integer messageSent) {
        this.messageSent = messageSent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_wish.owner
     *
     * @return the value of user_wish.owner
     *
     * @mbggenerated Fri Jan 09 18:39:37 MSK 2015
     */
    public Integer getOwner() {
        return owner;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_wish.owner
     *
     * @param owner the value for user_wish.owner
     *
     * @mbggenerated Fri Jan 09 18:39:37 MSK 2015
     */
    public void setOwner(Integer owner) {
        this.owner = owner;
    }
}