package com.chenxi.spring4basic.ioc;

import com.chenxi.spring4basic.model.TextEditor;
import com.chenxi.spring4basic.model.TextEditorCopy;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by chenxi on 2017/4/2.
 *
 * @author chenxi
 */
public class AutoWareApp {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");
        // byName
        waredByConstructor(context);
    }

    public static void waredByName(ApplicationContext context) {
        TextEditor textEditor = (TextEditor) context.getBean("autoware_byName_textEditor");
        textEditor.spellCheck();
    }

    public static void waredByType(ApplicationContext context) {
        TextEditor textEditor = (TextEditor) context.getBean("autoware_byType_textEditor");
        textEditor.spellCheck();
    }

    public static void waredByConstructor(ApplicationContext context) {
        TextEditorCopy textEditor = (TextEditorCopy) context.getBean("autoware_byCons_textEditor");
        textEditor.spellCheck();
    }
}
