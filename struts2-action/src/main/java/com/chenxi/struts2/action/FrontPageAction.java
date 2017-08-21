package com.chenxi.struts2.action;

import com.chenxi.struts2.bean.Page;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

public class FrontPageAction extends ActionSupport {
    private static final long serialVersionUID = 1L;
    private Page page;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

//	// 成员列表分页
//	public String MemberPaging() {
//		HttpServletRequest request = ServletActionContext.getRequest();
//
//		String pagestr = request.getParameter("pageid");// 2
//		FrontStaticMethod.getMemberPaging(pagestr,10);
//
//		return "success";
//
//	}

    // 博客管理分页
    public String BlogPaging() {
        HttpServletRequest request = ServletActionContext.getRequest();

        String pagestr = request.getParameter("pageid");// 2
        FrontStaticMethod.getBlogPaging(pagestr, 5);

        return "BLOG_PAGING_SU";

    }

    // 项目管理分页
    public String ProjectPaging() {
        HttpServletRequest request = ServletActionContext.getRequest();

        String pagestr = request.getParameter("pageid");// 2
        FrontStaticMethod.getProjectPaging(pagestr, 3);

        return "PROJECT_PAGING_SU";

    }

    // 服务分页
    public String ServicePaging() {
        HttpServletRequest request = ServletActionContext.getRequest();

        String pagestr = request.getParameter("pageid");// 2
        FrontStaticMethod.getServicePaging(pagestr, 5);

        return "success";

    }

}
