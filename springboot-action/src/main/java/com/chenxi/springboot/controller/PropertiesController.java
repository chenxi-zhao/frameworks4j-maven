package com.chenxi.springboot.controller;

import com.chenxi.springboot.config.ConfigurationValues;
import com.chenxi.springboot.config.RandomValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chenxi on 2017/8/22.
 *
 * @author chenxi
 */
@RestController
@RequestMapping(value = "/property")
public class PropertiesController {
    @Value("${internal.name}")
    private String name;

    @Value("${internal.age}")
    private Integer age;

    @Autowired
    private ConfigurationValues configurationValues;

    @Autowired
    private RandomValues randomValues;

    @GetMapping("/internal")
    public String internal() {
        return "Name : " + this.name + ", Age : " + this.age;
    }

    @GetMapping("/config")
    public ConfigurationValues configurationValue() {
        return configurationValues;
    }

    @GetMapping("/random")
    public RandomValues randomValue() {
        return randomValues;
    }
}
