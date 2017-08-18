package com.chenxi.spring4basic.ioc.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by chenxi on 2017/4/2.
 *
 * @author chenxi
 */
public class AnnotationApp {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");
        requiredAnnotation(context);
        autoWiredAnnotation(context);
        qualifierAnnotation(context);
    }

    public static void requiredAnnotation(ApplicationContext context){
        Student student = (Student) context.getBean("student");
        System.out.println("@required-Name: " + student.getName());
        System.out.println("@required-Age: " + student.getAge());
    }

    public static void autoWiredAnnotation(ApplicationContext context){
        Class clazz = (Class) context.getBean("class");
        System.out.println("@autoWired-Name: " + clazz.getStudent().getName());
        System.out.println("@autoWired-Age: " + clazz.getStudent().getAge());
    }
    public static void qualifierAnnotation(ApplicationContext context){
        Profile profile = (Profile) context.getBean("profile");
        profile.printAge();
        profile.printName();
    }
}
