package com.chenxi.mybatis.beans;

import java.io.Serializable;

/**
 * Created by chenxi on 2017/8/16.
 *
 * @author chenxi
 */
public class UserBean implements Serializable {
    private long id;
    private String userName;
    private String userAge;
    private String UserAddress;

    public UserBean() {
        super();
    }

    public UserBean(String userName, String userAge, String userAddress) {
        this.userName = userName;
        this.userAge = userAge;
        UserAddress = userAddress;
    }

    public UserBean(long id, String userName, String userAge, String userAddress) {
        this.id = id;
        this.userName = userName;
        this.userAge = userAge;
        UserAddress = userAddress;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAge() {
        return userAge;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }

    public String getUserAddress() {
        return UserAddress;
    }

    public void setUserAddress(String userAddress) {
        UserAddress = userAddress;
    }

    @Override
    public String toString() {
        return "UserBean [id=" + id + ", username=" + userName + ", userAge="
                + userAge + ", UserAddress=" + UserAddress + "]";
    }
}
