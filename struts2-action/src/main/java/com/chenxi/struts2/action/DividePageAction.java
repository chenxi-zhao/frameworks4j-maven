package com.chenxi.struts2.action;

import com.chenxi.struts2.bean.Page;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

public class DividePageAction extends ActionSupport {
    private static final long serialVersionUID = 1L;
    private Page page;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    // 成员列表分页
    public String MemberPaging() {
        HttpServletRequest request = ServletActionContext.getRequest();

        String pagestr = request.getParameter("pageid");// 2
        StaticMethod.getMemberPaging(pagestr, 10);

        return "success";

    }

    // 博客管理分页
    public String BlogPaging() {
        HttpServletRequest request = ServletActionContext.getRequest();

        String pagestr = request.getParameter("pageid");// 2
        StaticMethod.getBlogPaging(pagestr, 10);

        return "success";

    }

    // 项目管理分页
    public String ProjectPaging() {
        HttpServletRequest request = ServletActionContext.getRequest();

        String pagestr = request.getParameter("pageid");// 2
        StaticMethod.getProjectPaging(pagestr, 10);

        return "success";

    }

    // 服务分页
    public String ServicePaging() {
        HttpServletRequest request = ServletActionContext.getRequest();

        String pagestr = request.getParameter("pageid");// 2
        StaticMethod.getServicePaging(pagestr, 10);

        return "success";

    }

}
