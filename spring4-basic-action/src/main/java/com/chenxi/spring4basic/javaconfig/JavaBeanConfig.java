package com.chenxi.spring4basic.javaconfig;

import com.chenxi.spring4basic.model.HelloWorld;
import com.chenxi.spring4basic.model.SpellChecker;
import com.chenxi.spring4basic.model.TextEditorCopy;
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
