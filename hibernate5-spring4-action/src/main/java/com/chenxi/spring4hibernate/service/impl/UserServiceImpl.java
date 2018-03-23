package com.chenxi.spring4hibernate.service.impl;

import com.chenxi.spring4hibernate.dao.UserDao;
import com.chenxi.spring4hibernate.entity.User;
import com.chenxi.spring4hibernate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zhaochx1 on 2016/11/30.
 *
 * @author zhaochx1
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getAllUser() {
        return userDao.find("from User t");
    }

    @Override
    public void addUser(User user) {
        userDao.save(user);
    }
}
