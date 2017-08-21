package com.chenxi.struts2.action;

import com.chenxi.struts2.bean.*;
import com.chenxi.struts2.dao.BlogDao;
import com.chenxi.struts2.dao.MemberDao;
import com.chenxi.struts2.dao.ProjectDao;
import com.chenxi.struts2.dao.ServiceDao;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class StaticMethod extends ActionSupport {
    private static final long serialVersionUID = 1L;

    //Member分页
    public static void getMemberPaging(String pagestr, int pageSize) {
        HttpServletRequest request = ServletActionContext.getRequest();
        int pagenum = 1;
        if (pagestr != null && !pagestr.isEmpty()) {
            pagenum = Integer.parseInt(pagestr); // 2
        }
        Page page = new Page();
        page.setTotalRow(new MemberDao().getCount());
        page.setPageSize(pageSize);
        page.setCurPage(pagenum);
        request.getSession().setAttribute("page", page);
        request.getSession().removeAttribute("isDel");
        List<Member> li = new MemberDao().getMemberList(page.getStart(), page.getPageSize());
        request.getSession().setAttribute("list", li);
        request.getSession().removeAttribute("sthAdd");
    }

    //博客分页
    public static void getBlogPaging(String pagestr, int pageSize) {
        HttpServletRequest request = ServletActionContext.getRequest();
        int pagenum = 1;
        if (pagestr != null && !pagestr.isEmpty()) {
            pagenum = Integer.parseInt(pagestr); // 2
        }
        Page page = new Page();
        page.setTotalRow(new BlogDao().getCount());
        page.setPageSize(pageSize);
        page.setCurPage(pagenum);
        request.getSession().setAttribute("page", page);
        request.getSession().removeAttribute("isDel");
        List<Blog> li = new BlogDao().getBlogList(page.getStart(), page.getPageSize());
        request.getSession().setAttribute("list", li);
    }

    //项目分页
    public static void getProjectPaging(String pagestr, int pageSize) {
        HttpServletRequest request = ServletActionContext.getRequest();
        int pagenum = 1;
        if (pagestr != null && !pagestr.isEmpty()) {
            pagenum = Integer.parseInt(pagestr); // 2
        }
        Page page = new Page();
        page.setTotalRow(new ProjectDao().getCount());
        page.setPageSize(pageSize);
        page.setCurPage(pagenum);
        request.getSession().setAttribute("page", page);
        request.getSession().removeAttribute("isDel");
        List<Project> li = new ProjectDao().getProjectList(page.getStart(), page.getPageSize());
        request.getSession().setAttribute("list", li);
    }

    //服务分页
    public static void getServicePaging(String pagestr, int pageSize) {
        HttpServletRequest request = ServletActionContext.getRequest();
        int pagenum = 1;
        if (pagestr != null && !pagestr.isEmpty()) {
            pagenum = Integer.parseInt(pagestr); // 2
        }
        Page page = new Page();
        page.setTotalRow(new ServiceDao().getCount());
        page.setPageSize(pageSize);
        page.setCurPage(pagenum);
        request.getSession().setAttribute("page", page);
        request.getSession().removeAttribute("isDel");
        List<Service> li = new ServiceDao().getServiceList(page.getStart(), page.getPageSize());
        request.getSession().setAttribute("list", li);
    }
}
