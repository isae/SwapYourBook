package ru.ifmo.ctddev.swapyourbook.mybatis.gen.model;

import java.util.Date;

public class AuthToken {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column auth_token.tokenID
     *
     * @mbggenerated Wed Dec 31 00:38:26 MSK 2014
     */
    private Long tokenid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column auth_token.token
     *
     * @mbggenerated Wed Dec 31 00:38:26 MSK 2014
     */
    private String token;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column auth_token.username
     *
     * @mbggenerated Wed Dec 31 00:38:26 MSK 2014
     */
    private String username;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column auth_token.password
     *
     * @mbggenerated Wed Dec 31 00:38:26 MSK 2014
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column auth_token.email
     *
     * @mbggenerated Wed Dec 31 00:38:26 MSK 2014
     */
    private String email;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column auth_token.created_timestamp
     *
     * @mbggenerated Wed Dec 31 00:38:26 MSK 2014
     */
    private Date createdTimestamp;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column auth_token.tokenID
     *
     * @return the value of auth_token.tokenID
     *
     * @mbggenerated Wed Dec 31 00:38:26 MSK 2014
     */
    public Long getTokenid() {
        return tokenid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column auth_token.tokenID
     *
     * @param tokenid the value for auth_token.tokenID
     *
     * @mbggenerated Wed Dec 31 00:38:26 MSK 2014
     */
    public void setTokenid(Long tokenid) {
        this.tokenid = tokenid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column auth_token.token
     *
     * @return the value of auth_token.token
     *
     * @mbggenerated Wed Dec 31 00:38:26 MSK 2014
     */
    public String getToken() {
        return token;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column auth_token.token
     *
     * @param token the value for auth_token.token
     *
     * @mbggenerated Wed Dec 31 00:38:26 MSK 2014
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column auth_token.username
     *
     * @return the value of auth_token.username
     *
     * @mbggenerated Wed Dec 31 00:38:26 MSK 2014
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column auth_token.username
     *
     * @param username the value for auth_token.username
     *
     * @mbggenerated Wed Dec 31 00:38:26 MSK 2014
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column auth_token.password
     *
     * @return the value of auth_token.password
     *
     * @mbggenerated Wed Dec 31 00:38:26 MSK 2014
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column auth_token.password
     *
     * @param password the value for auth_token.password
     *
     * @mbggenerated Wed Dec 31 00:38:26 MSK 2014
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column auth_token.email
     *
     * @return the value of auth_token.email
     *
     * @mbggenerated Wed Dec 31 00:38:26 MSK 2014
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column auth_token.email
     *
     * @param email the value for auth_token.email
     *
     * @mbggenerated Wed Dec 31 00:38:26 MSK 2014
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column auth_token.created_timestamp
     *
     * @return the value of auth_token.created_timestamp
     *
     * @mbggenerated Wed Dec 31 00:38:26 MSK 2014
     */
    public Date getCreatedTimestamp() {
        return createdTimestamp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column auth_token.created_timestamp
     *
     * @param createdTimestamp the value for auth_token.created_timestamp
     *
     * @mbggenerated Wed Dec 31 00:38:26 MSK 2014
     */
    public void setCreatedTimestamp(Date createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }
}