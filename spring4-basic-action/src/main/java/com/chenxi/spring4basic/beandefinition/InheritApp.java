package com.chenxi.spring4basic.beandefinition;

import com.chenxi.spring4basic.model.HelloIndia;
import com.chenxi.spring4basic.model.HelloWorld;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by chenxi on 2017/4/2.
 *
 * @author chenxi
 */
public class InheritApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld");
        helloWorld.getMessage();
        helloWorld.getMessage2();

        HelloIndia helloIndia = (HelloIndia) context.getBean("helloIndia");
        helloIndia.getMessage();
        helloIndia.getMessage2();
        helloIndia.getMessage3();
    }
}
