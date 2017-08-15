package com.chenxi.ioc.annotation;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by chenxi on 2017/4/2.
 *
 * @author chenxi
 */
public class Class {
    @Autowired
    public Student student;

    public Student getStudent() {
        return student;
    }
}
