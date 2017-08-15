package com.chenxi.ioc;

import com.chenxi.model.JavaCollection;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by chenxi on 2017/4/2.
 *
 * @author chenxi
 */
public class JavaCollectionApp {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("Beans.xml");
        JavaCollection jc = (JavaCollection) context.getBean("javaCollection");
        jc.getAddressList();
        jc.getAddressSet();
        jc.getAddressMap();
        jc.getAddressProp();

    }
}
