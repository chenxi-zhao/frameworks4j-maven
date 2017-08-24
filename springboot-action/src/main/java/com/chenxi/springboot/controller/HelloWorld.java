package com.chenxi.springboot.controller;

import com.chenxi.springboot.domain.XmlThing;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by chenxi on 2017/8/22.
 *
 * @author chenxi
 */
// @RestController是Spring 4.0之后出现的注解，相当于@Controller加@ResponseBody结合。
@RestController
@RequestMapping(value = "/chenxi")
public class HelloWorld {
    // 其中@GetMapping注解是Spring 4.3之后出现的组合注解，
    // 作用与@RequestMapping(value = "/hi", method = RequestMethod.GET)相同。
    // @RequestMapping( method = {RequestMethod.GET})
    @GetMapping(value = "/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String hi() {
        return "hi";
    }

    @RequestMapping("/thing")
    public XmlThing thing() {
        XmlThing thing = new XmlThing();
        thing.setWhen(new Date());
        thing.setThingTodo("Go out for walking.");
        return thing;
    }
}
