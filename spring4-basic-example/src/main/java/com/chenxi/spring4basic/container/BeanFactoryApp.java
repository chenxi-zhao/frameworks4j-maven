package com.chenxi.spring4basic.container;

import com.chenxi.spring4basic.model.HelloWorld;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by chenxi on 2017/4/2.
 *
 * @author chenxi
 */
public class BeanFactoryApp {
    /**
     * 在 Spring 中，有大量对 BeanFactory 接口的实现。
     *
     * 其中，最常被使用的是 XmlBeanFactory 类。这个容器从 一个 XML 文件中读取配置元数据，由这些元数据来生成一个被配置化的系统或者应用。
     *
     * 在资源宝贵的移动设备或者基于 applet 的应用当中， BeanFactory 会被优先选择。否则，一般使用的是 Applic ationContext
     */
    public static void main(String[] args) {
        XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("beans.xml"));
        HelloWorld obj = (HelloWorld) factory.getBean("helloWorld");
        System.out.println(obj.getMessage());
    }
}
