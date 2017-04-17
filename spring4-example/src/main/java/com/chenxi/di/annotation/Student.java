package com.chenxi.di.annotation;

import org.springframework.beans.factory.annotation.Required;

/**
 * Created by chenxi on 2017/4/2.
 *
 * @author chenxi
 */
public class Student {
    private Integer age;
    private String name;

    public Integer getAge() {
        return age;
    }

    @Required
    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    @Required
    public void setName(String name) {
        this.name = name;
    }
}
