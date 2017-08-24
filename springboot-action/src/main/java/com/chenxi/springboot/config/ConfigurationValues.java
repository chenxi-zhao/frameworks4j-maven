package com.chenxi.springboot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by chenxi on 2017/8/22.
 *
 * @author chenxi
 */
@Component
@ConfigurationProperties(prefix = "configuration")
@PropertySource("classpath:my.properties")
public class ConfigurationValues {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
