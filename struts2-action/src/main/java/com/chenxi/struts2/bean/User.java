package com.chenxi.struts2.bean;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

    private static final long serialVersionUID = -7683790574672416624L;

    private int uid;
    private String uname;
    private String upass;
    private Date lastLoginDate;

    public User() {
        super();
    }


    public User(int uid, String uname, String upass, Date lastLoginDate) {
        super();
        this.uid = uid;
        this.uname = uname;
        this.upass = upass;
        this.lastLoginDate = lastLoginDate;
    }


    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpass() {
        return upass;
    }

    public void setUpass(String upass) {
        this.upass = upass;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

}
