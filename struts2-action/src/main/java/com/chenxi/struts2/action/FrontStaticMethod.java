package com.chenxi.struts2.action;

import com.chenxi.struts2.bean.*;
import com.chenxi.struts2.dao.*;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class FrontStaticMethod extends ActionSupport {
    private static final long serialVersionUID = 1L;
    HttpServletRequest request = ServletActionContext.getRequest();

    //获取IndexImg
    public static void getIndexImg() {
        HttpServletRequest request = ServletActionContext.getRequest();
        List<IndexImg> li = new IndexImgDao().getIndexImgList();
        request.getSession().removeAttribute("isDel");
        request.getSession().setAttribute("indexImg", li);
    }

    public static void getMemberList() {
        HttpServletRequest request = ServletActionContext.getRequest();
        List<Member> li = new MemberDao().getMemberList(0, new MemberDao().getCount());

        request.getSession().removeAttribute("isDel");
        request.getSession().setAttribute("memberlist", li);
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
        request.getSession().setAttribute("fpage", page);
        request.getSession().removeAttribute("isDel");
        List<Blog> li = new BlogDao().getBlogList(page.getStart(), page.getPageSize());
        request.getSession().setAttribute("bloglist", li);
        request.getSession().setAttribute("isPaging", "Yes");
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
        request.getSession().setAttribute("fpage", page);
        request.getSession().removeAttribute("isDel");
        List<Project> li = new ProjectDao().getProjectList(page.getStart(), page.getPageSize());
        request.getSession().setAttribute("projectlist", li);
        request.getSession().setAttribute("isPaging", "Yes");

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
        request.getSession().setAttribute("fpage", page);
        request.getSession().removeAttribute("isDel");
        List<Service> li = new ServiceDao().getServiceList(page.getStart(), page.getPageSize());
        request.getSession().setAttribute("frontlist", li);
    }
}
