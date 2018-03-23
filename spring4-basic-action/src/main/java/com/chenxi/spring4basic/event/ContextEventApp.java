package com.chenxi.spring4basic.event;

import com.chenxi.spring4basic.model.HelloWorld;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by chenxi on 2017/4/5.
 *
 * @author chenxi
 */
public class ContextEventApp {

    /**
     * 1.ContextRefreshedEvent
     * ApplicationContext 被初始化或刷新时，该事件被发布。这也可以在 ConfigurableApplicationContext 接口中使用 refresh() 方法来发生。
     * <p>
     * 2.ContextStartedEvent
     * 当使用 ConfigurableApplicationContext 接口中的 start() 方法启动 ApplicationContext 时，该事件被发布。
     * 你可以调查你的数据库，或者你可以在接受到这个事件后重 启任何停止的应用程序。
     * <p>
     * 3.ContextStoppedEvent
     * 当使用 ConfigurableApplicationContext 接口中的 stop() 方法停止 ApplicationContext 时，发布这个事件。
     * 你可以在接受到这个事件后做必要的清理的工作。
     * <p>
     * 4.ContextClosedEvent
     * 当使用 ConfigurableApplicationContext 接口中的 close() 方法关闭 ApplicationContext 时，该事件被发布。
     * 一个已关闭的上下文到达生命周期末端;它不能被刷新或 重启。
     * <p>
     * 5.RequestHandledEvent
     * 这是一个 web-specific 事件，告诉所有 bean HTTP 请求已经被服务。
     */

    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");
        context.start();

        HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld");
        helloWorld.getMessage();

        context.stop();
    }
}
