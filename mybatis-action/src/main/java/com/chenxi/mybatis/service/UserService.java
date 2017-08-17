package com.chenxi.mybatis.service;

import com.chenxi.mybatis.beans.UserBean;
import com.chenxi.mybatis.mapper.UserMapper;
import com.chenxi.mybatis.tools.DBTools;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chenxi on 2017/8/16.
 *
 * @author chenxi
 */
public class UserService {

    public static void main(String[] args) {
//        insertUser();
//        deleteUser();
//        selectUserById();
//        selectAllUser();
        batchInsertUser();
        countUser();
        pagerUser();
    }

    private static void countUser() {
        SqlSession session = DBTools.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("userName", "kitty");
        int index = 0;
        params.put("index", index);//从第几页开始。mysql是从0开始的
        params.put("pageSize", 5);//每页显示的数据条数
        int count;
        try {
            count = mapper.countUser(params);
            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    private static void pagerUser() {
        SqlSession session = DBTools.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("userName", "kitty");
        params.put("index", 0);//从第几页开始。mysql是从0开始的
        params.put("pageSize", 5);//每页显示的数据条数
        try {
            List<UserBean> u = mapper.pagerUser(params);
            for (UserBean userBean : u) {
                System.out.println("--------" + userBean);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    private static void batchDeleteUser() {
        SqlSession session = DBTools.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<Integer> ids = new ArrayList<Integer>();
        for (int i = 4; i < 10; i++) {
            ids.add(i);
        }
        try {
            mapper.batchDeleteUser(ids);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    private static void batchInsertUser() {
        SqlSession session = DBTools.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);

        List<UserBean> users = new ArrayList<UserBean>();
        for (int i = 0; i < 10; i++) {
            UserBean user = new UserBean("kitty" + i, "99", "beijing");
            users.add(user);
        }
        try {
            mapper.batchInsertUser(users);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 新增用户
     */
    private static void insertUser() {
        SqlSession session = DBTools.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        UserBean user = new UserBean("chenxi", "20", "beijing");
        try {
            mapper.insertUser(user);
            System.out.println(user.toString());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
    }


    /**
     * 删除用户
     */
    private static void deleteUser() {
        SqlSession session = DBTools.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        try {
            mapper.deleteUser(1);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
    }


    /**
     * 根据id查询用户
     */
    private static void selectUserById() {
        SqlSession session = DBTools.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        try {
            UserBean user = mapper.selectUserById(2);
            System.out.println(user.toString());

            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
    }

    /**
     * 查询所有的用户
     */
    private static void selectAllUser() {
        SqlSession session = DBTools.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        try {
            List<UserBean> user = mapper.selectAllUser();
            System.out.println(user.toString());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
    }
}
