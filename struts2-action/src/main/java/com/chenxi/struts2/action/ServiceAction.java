package com.chenxi.struts2.action;

import com.chenxi.struts2.bean.Service;
import com.chenxi.struts2.dao.ServiceDao;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

public class ServiceAction extends ActionSupport {
    private static final long serialVersionUID = 1L;
    private Service service;

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public String AddService() {
        HttpServletRequest request = ServletActionContext.getRequest();
        boolean isAdd = new ServiceDao().addService(service);
        if (isAdd) {
            request.getSession().setAttribute("sthAdd", "yes");
            request.getSession().setAttribute("dealMsg", "Service创建成功");
        }
        return SUCCESS;
    }

    public String BlogGet() {
        HttpServletRequest request = ServletActionContext.getRequest();
        int bid = Integer.parseInt(request.getParameter("bid"));
        service = new ServiceDao().getSerivceById(bid);

        if (service != null) {
            request.getSession().setAttribute("frontShow", service);
            return "BLOG_SINGLE";
        } else {
            return ERROR;
        }
    }

    public String ServiceDel() {
        HttpServletRequest request = ServletActionContext.getRequest();
        int sid = Integer.parseInt(request.getParameter("sid"));
        boolean isDel = new ServiceDao().delService(sid);
        String pagestr = request.getParameter("pageid");
        StaticMethod.getServicePaging(pagestr, 10);
        if (isDel) {
            System.out.println("---------------------------");
            request.getSession().setAttribute("isDel", "yes");
            request.getSession().setAttribute("dealMsg", "Service删除成功");
            return SUCCESS;
        } else {
            return ERROR;
        }
    }
}
