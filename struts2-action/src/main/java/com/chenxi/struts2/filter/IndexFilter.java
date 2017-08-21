package com.chenxi.struts2.filter;

import com.chenxi.struts2.action.FrontStaticMethod;
import com.chenxi.struts2.bean.Comment;
import com.chenxi.struts2.bean.Page;
import com.chenxi.struts2.dao.BlogCommentDao;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class IndexFilter implements Filter {

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String path = req.getRequestURL().toString();

        System.out.println("---------Log: request>>>>" + path);

        String isPaging = (String) req.getSession().getAttribute("isPaging");
        Page page = (Page) req.getSession().getAttribute("fpage");


        if (isPaging != null) {
            System.out.println("+++++++++++++++++++++++++++");

        } else {
            System.out.println("--------------------------------");
            if (path.endsWith("/index.jsp")) {
                FrontStaticMethod.getIndexImg();
            } else if (path.endsWith("/blog.jsp")) {
                if (page != null) {
                    FrontStaticMethod.getBlogPaging(page.getCurPage() + "", 5);
                    List<Comment> recentcomments = new BlogCommentDao().getBlogCommentsList(5);
                    req.getSession().setAttribute("recentCom", recentcomments);
                } else
                    FrontStaticMethod.getBlogPaging(null, 5);
            } else if (path.endsWith("/project.jsp")) {
                if (page != null) {
                    FrontStaticMethod.getProjectPaging(page.getCurPage() + "", 5);
                } else
                    FrontStaticMethod.getProjectPaging(null, 5);
            } else if (path.endsWith("/about.jsp")) {
                FrontStaticMethod.getMemberList();
            }
        }
        req.getSession().removeAttribute("isPaging");
        chain.doFilter(req, res);
    }

    public void init(FilterConfig fConfig) throws ServletException {
    }
}
