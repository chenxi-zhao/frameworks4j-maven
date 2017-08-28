package com.chenxi.spring4hibernate.service;

import com.chenxi.spring4hibernate.entity.User;

import java.util.List;

/**
 * Created by zhaochx1 on 2016/11/30.
 *
 * @author zhaochx1
 */
public interface UserService {
    /**
     * 获取所有的用户信息
     */
    List<User> getAllUser();

    void addUser(User user);
}
