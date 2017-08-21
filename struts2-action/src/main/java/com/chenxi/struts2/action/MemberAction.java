package com.chenxi.struts2.action;

import com.chenxi.struts2.bean.Member;
import com.chenxi.struts2.dao.MemberDao;
import com.chenxi.struts2.util.ListToString;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

public class MemberAction extends ActionSupport {
    private static final long serialVersionUID = 1L;
    private Member member;
    private boolean isLogin;

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean isLogin) {
        this.isLogin = isLogin;
    }

    public String AddMember() {
        HttpServletRequest request = ServletActionContext.getRequest();
        member.setSkill(ListToString.Str2List(request.getParameter("skill")));

        boolean isAdd = new MemberDao().addMember(member);
        if (isAdd) {
            String pagestr = request.getParameter("pageid");
            StaticMethod.getMemberPaging(pagestr, 10);
            request.getSession().setAttribute("sthAdd", "yes");
            request.getSession().setAttribute("dealMsg", "Member创建成功");
        }
        return SUCCESS;
    }

    // 后台登陆
    public String MemberLogin() {
        HttpServletRequest request = ServletActionContext.getRequest();
        System.out.println(member.getName() + "_" + member.getPass());
        Member mem = new MemberDao().Login(member.getName(), member.getPass());
        if (mem != null) {
            isLogin = true;
            member = mem;
            request.getSession().setAttribute("isLogin", isLogin);
            request.getSession().setAttribute("mymember", mem);
            return "LOGIN_SUCCESS";
        } else {
            isLogin = false;
            request.getSession().setAttribute("isLogin", isLogin);
            return "LOGIN_FAIL";
        }
    }

    public String MemberLoginOut() {
        HttpServletRequest request = ServletActionContext.getRequest();
        request.removeAttribute("isLogin");
        request.getSession().removeAttribute("barMa");
        request.getSession().removeAttribute("detail");
        request.getSession().removeAttribute("isDel");
        request.getSession().removeAttribute("sthAdd");
        request.getSession().removeAttribute("modify");
        request.getSession().removeAttribute("modifySave");
        request.getSession().removeAttribute("dealMsg");
//		request.getSession().removeAttribute("modify");
//		request.getSession().removeAttribute("modifySave");
        return "LOGINOUT_SUCCESS";
    }

    public String MemberDel() {
        HttpServletRequest request = ServletActionContext.getRequest();
        int mid = Integer.parseInt(request.getParameter("mid"));
        boolean isDel = new MemberDao().delMember(mid);
        String pagestr = request.getParameter("pageid");
        StaticMethod.getMemberPaging(pagestr, 10);
        if (isDel) {
            System.out.println("---------------------------");
            request.getSession().setAttribute("isDel", "yes");
            request.getSession().setAttribute("dealMsg", "member删除成功");
            return SUCCESS;
        } else {
            return "DEL_FAIL";
        }
    }

}
