package com.chenxi.spring4basic.beandefinition;

import com.chenxi.spring4basic.model.HelloWorld;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by chenxi on 2017/4/2.
 *
 * @author chenxi
 */
public class LifeCycleApp {
    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        HelloWorld helloWorld = (HelloWorld) context.getBean("lifecycle_helloWorld");
        helloWorld.getMessage();
        context.registerShutdownHook();
    }
}
