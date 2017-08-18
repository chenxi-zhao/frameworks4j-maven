package com.chenxi.spring4basic.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by chenxi on 2017/4/5.
 *
 * @author chenxi
 */
public class SpringAopApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("aspectj.xml");
        Student student = (Student)context.getBean("student");
        student.getName();
        student.getAge();
        student.printThrowException();
    }
}
