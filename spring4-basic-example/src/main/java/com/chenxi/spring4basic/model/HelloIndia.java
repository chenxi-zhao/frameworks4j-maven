package com.chenxi.spring4basic.model;

/**
 * Created by chenxi on 2017/4/2.
 *
 * @author chenxi
 */
public class HelloIndia {
    private String message;
    private String message2;
    private String message3;

    public String getMessage() {
        System.out.println("HelloIndia Class:" + message);
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage2() {
        System.out.println("HelloIndia Class:" + message2);
        return message2;
    }

    public void setMessage2(String message2) {
        this.message2 = message2;
    }

    public String getMessage3() {
        System.out.println("HelloIndia Class:" + message3);
        return message3;
    }

    public void setMessage3(String message3) {
        this.message3 = message3;
    }
}
