package com.chenxi.hibernate.test;

import com.chenxi.hibernate.ManyToOne.Article;
import com.chenxi.hibernate.ManyToOne.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by chenxi on 2017/8/19.
 *
 * @author chenxi
 */
public class ManyToOneTest {
    private static SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    @BeforeClass//在测试类初始化时调用此方法，完成静态对象的初始化
    public static void before() {
//        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
//        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-hibernate.xml");
        sessionFactory = (SessionFactory) ac.getBean("sessionFactory");
    }

    @Before//每一个被注解Test方法在调用前都会调用此方法一次
    public void setup() {//建立针对我们当前测试方法的的会话和事务
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
    }

    //测试级联关系映射注解配置：多对一单向关联
    @Test
    public void test1() {
        User user = new User();
        user.setName("name1");
        Article article = new Article();
        article.setContent("content1");
        article.setUser(user);//建立级联关系
        session.save(article);//注意这里我们没有保存我们的user对象
    }


    @After//每一个被注解Test方法在调用后都会调用此方法一次
    public void teardown() {
        transaction.commit();
        session.clear();
        session.close();
    }

    @AfterClass//在类销毁时调用一次
    public static void after() {
        sessionFactory.close();
    }
}
