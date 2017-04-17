package com.chenxi.javaconfig;

import com.chenxi.model.HelloWorld;
import com.chenxi.model.SpellChecker;
import com.chenxi.model.TextEditor;
import com.chenxi.model.TextEditorCopy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by chenxi on 2017/4/2.
 *
 * @author chenxi
 */
@Configuration
public class JavaBeanConfig {
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public HelloWorld helloWorld(){
        return new HelloWorld();
    }

    @Bean
    public TextEditorCopy textEditorCopy(){
        return new TextEditorCopy(spellChecker(), "windows");
    }

    @Bean
    public SpellChecker spellChecker(){
        return new SpellChecker("spell");
    }
}
