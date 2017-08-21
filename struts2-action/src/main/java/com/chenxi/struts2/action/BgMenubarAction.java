package com.chenxi.struts2.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

public class BgMenubarAction extends ActionSupport {
    private static final long serialVersionUID = 1L;

    @Override
    public String execute() throws Exception {

        HttpServletRequest request = ServletActionContext.getRequest();
        String barMa = (String) request.getParameter("barMa");
        String detail = (String) request.getParameter("detail");
        request.getSession().setAttribute("barMa", barMa);
        request.getSession().setAttribute("detail", detail);

        String pagestr = request.getParameter("pageid");

        if ("member".equals(barMa)) {
            StaticMethod.getMemberPaging(pagestr, 10);
        } else if ("blog".equals(barMa)) {
            StaticMethod.getBlogPaging(pagestr, 10);
        } else if ("project".equals(barMa)) {
            StaticMethod.getProjectPaging(pagestr, 10);
        } else if ("service".equals(barMa)) {
            if ("service".equals(detail)) {
                StaticMethod.getServicePaging(pagestr, 10);
            }
        } else if ("group".equals(barMa)) {
            if ("advertise".equals(detail)) {
                FrontStaticMethod.getIndexImg();
            }
        }


        request.getSession().removeAttribute("sthAdd");
        request.getSession().removeAttribute("modify");
        request.getSession().removeAttribute("modifySave");


        return SUCCESS;
    }

}
