package com.chenxi.jedis.controller;

import com.chenxi.jedis.dao.UserDao;
import com.chenxi.jedis.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;

/**
 * Created by zhaochx1 on 2016/11/24.
 *
 * @author zhaochx1
 */
@Controller
@RequestMapping("/user")
public class UserAction {
    private static int i;

    @Resource(name = "userDao")
    private UserDao userDao;

    @RequestMapping(value = "/getuser", method = RequestMethod.GET)
    @ResponseBody
    public User getuser() {
        User user = new User();
        user.setId(i++);
        user.setUserName("xxx" + i);
        user.setUserPassword("xxx" + i);
        String set = this.userDao.set("user", user);
        System.out.println(set);
        return this.userDao.get("user", User.class);
    }


    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-redis.xml");
        JedisPool jedisPool = (JedisPool) context.getBean("connectionPool");
        System.out.println(jedisPool.toString());

        jedisPool.getResource().set("testredis", "test");
    }
}
