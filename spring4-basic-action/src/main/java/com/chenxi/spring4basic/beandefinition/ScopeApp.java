package com.chenxi.spring4basic.beandefinition;

import com.chenxi.spring4basic.model.HelloWorld;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by chenxi on 2017/4/2.
 *
 * @author chenxi
 */
public class ScopeApp {
    /**
     * Spring 框架支持以下五个作用域，如果你使用 web-aware ApplicationContext 时，其中三个是可用的。
     * <p>
     * singleton
     * 该作用域将 bean 的定义的限制在每一个 Spring IoC 容器中的一个单一实例(默认)。
     * <p>
     * prototype
     * 该作用域将单一 bean 的定义限制在任意数量的对象实例。
     * <p>
     * request
     * 该作用域将 bean 的定义限制为 HTTP 请求。只在 web-aware Spring ApplicationCo ntext 的上下文中有效。
     * <p>
     * session
     * 该作用域将 bean 的定义限制为 HTTP 会话。 只在web-aware Spring ApplicationCo ntext的上下文中有效。
     * <p>
     * global-session
     * 该作用域将 bean 的定义限制为全局 HTTP 会话。只在 web-aware Spring Applicatio nContext 的上下文中有效。
     */
    public static void main(String[] args) {
        // singleton -- 默认是singleton
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        HelloWorld objA = (HelloWorld) context.getBean("singleton_helloWorld");
        objA.setMessage("I'm object sington");
        objA.getMessage();
        HelloWorld objB = (HelloWorld) context.getBean("singleton_helloWorld");
        objB.getMessage();


        // prototype
        objA = (HelloWorld) context.getBean("protorype_helloWorld");
        objA.setMessage("I'm object prototype");
        objA.getMessage();
        objB = (HelloWorld) context.getBean("protorype_helloWorld");
        objB.getMessage();
    }
}
