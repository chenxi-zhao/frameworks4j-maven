package com.chenxi.hibernate.test;

import com.chenxi.hibernate.OneToOne.IdCard;
import com.chenxi.hibernate.OneToOne.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by chenxi on 2017/8/20.
 *
 * @author chenxi
 */
public class OneToOneTest {
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

    @Test
    public void test1() {
        IdCard idCard = new IdCard();
        idCard.setCardNo("88888888888888888888888");
        session.save(idCard);
        Person person = new Person();
        person.setName("菜10");
        person.setIdCard(idCard);
        session.save(person);
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
