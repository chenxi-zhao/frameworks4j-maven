package com.chenxi.model;

/**
 * Created by chenxi on 2017/4/2.
 *
 * @author chenxi
 */
public class HelloWorld {
    private String message;

    private String message2;


    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        System.out.println("HelloWorld Class:" + message);
        return message;
    }

    public String getMessage2() {
        System.out.println("HelloWorld Class:" +  message2);
        return message2;
    }

    public void setMessage2(String message2) {
        this.message2 = message2;
    }

    public void init() {
        System.out.println("Bean is going through init.");
    }

    public void destroy() {
        System.out.println("Bean will destroy now.");
    }
}
