package com.chenxi.struts2.action;

import com.chenxi.struts2.bean.User;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

public class UserLoginAction extends ActionSupport {
    private static final long serialVersionUID = 1L;
    private User user;
    private String loginMsg = "init";

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getLoginMsg() {
        return loginMsg;
    }

    public void setLoginMsg(String loginMsg) {
        this.loginMsg = loginMsg;
    }


    public String UserLogin() {
        System.out.println("-----------------------");
        System.out.println(user.getUname() + " " + user.getUpass());
        if ("Username".equals(user.getUname()) && "Password".equals(user.getUpass())) {
            loginMsg = "success";
            System.out.println("user:" + user.getUname() + "pass:" + user.getUpass());
        } else {
            loginMsg = "error!";
        }
        ServletActionContext.getRequest().getSession().setAttribute("loginMsg", loginMsg);

        ServletActionContext.getRequest().getSession().setAttribute("user", user);
        System.out.println("-----------------------");

        return "LOGIN_SUCCESS";
    }

    public String UserLoginOut() {
        System.out.println("-----------------------");
        ServletActionContext.getRequest().getSession().removeAttribute("loginMsg");
        ServletActionContext.getRequest().getSession().removeAttribute("user");
        System.out.println("-------UserLoginOut------");
        System.out.println("-----------------------");
        return "LOGINOUT_SUCCESS";
    }

}
