package com.chenxi.spring4basic.container;

import com.chenxi.spring4basic.model.HelloWorld;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by chenxi on 2017/4/2.
 *
 * @author chenxi
 */
public class ApplicationContextApp {
    /**
     * FileSystemXmlApplicationContext:该容器从 XML 文件中加载已被定义的 bean。在这里，你需要提供 给构造器 XML 文件的完整路径
     *
     * ClassPathXmlApplicationContext:该容器从 XML 文件中加载已被定义的 bean。
     * 在这里，你不需要提 供 XML 文件的完整路径，只需正确配置 CLASSPATH 环境变量即可，因为，容器会从 CLASSPATH 中 搜索 bean 配置文件。
     *
     * WebXmlApplicationContext:该容器会在一个 web 应用程序的范围内加载在 XML 文件中已被定义的 bean。
     */

    public static void main(String[] args) {
        String path = "//Users/chenxi/Program/frameworks4j-maven/spring4-example/src/main/resources/beans.xml";
        ApplicationContext context = new FileSystemXmlApplicationContext(path);
        HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld");
        System.out.println(helloWorld.getMessage());
    }
}
