package com.chenxi.ioc;

import com.chenxi.model.TextEditor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by chenxi on 2017/4/2.
 *
 * @author chenxi
 */
public class SetterDIApp {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");
        TextEditor te = (TextEditor) context.getBean("setter_textEditor");
        te.spellCheck();
    }
}
