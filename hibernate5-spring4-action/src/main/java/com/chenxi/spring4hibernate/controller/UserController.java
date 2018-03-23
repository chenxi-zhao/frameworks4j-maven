package com.chenxi.spring4hibernate.controller;

import com.alibaba.fastjson.JSON;
import com.chenxi.spring4hibernate.entity.User;
import com.chenxi.spring4hibernate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by zhaochx1 on 2016/11/30.
 *
 * @author zhaochx1
 */
@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 获取用户列表
     */
    @RequestMapping("/getUserList")
    public void getJson(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        List<User> list = userService.getAllUser();
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println(JSON.toJSONString(list));
        out.flush();
        out.close();
    }
}
