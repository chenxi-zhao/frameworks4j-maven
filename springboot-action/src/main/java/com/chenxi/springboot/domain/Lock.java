package com.chenxi.springboot.domain;

/**
 * Created by chenxi on 2017/8/24.
 *
 * @author chenxi
 */
public class Lock {
    private String name;
    private String value;

    public Lock(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

}
