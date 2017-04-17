package com.chenxi.javaconfig;

import com.chenxi.model.HelloWorld;
import com.chenxi.model.TextEditorCopy;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by chenxi on 2017/4/2.
 *
 * @author chenxi
 */
public class JavaConfigApp {
    public static void main(String[] args) {
        ApplicationContext ctx =
                new AnnotationConfigApplicationContext(JavaBeanConfig.class);
        HelloWorld helloWorld = ctx.getBean(HelloWorld.class);
        helloWorld.setMessage("Hello World!");
        helloWorld.getMessage();

        TextEditorCopy textEditor = (TextEditorCopy) ctx.getBean("textEditorCopy");
        textEditor.spellCheck();

    }

}
