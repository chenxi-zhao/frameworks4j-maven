package com.chenxi.struts2.action;

import com.chenxi.struts2.bean.Comment;
import com.chenxi.struts2.bean.Project;
import com.chenxi.struts2.dao.ProjectCommentDao;
import com.chenxi.struts2.dao.ProjectDao;
import com.chenxi.struts2.util.MyTool;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

public class ProjectAction extends ActionSupport {
    private static final long serialVersionUID = 1L;
    private Project project;

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String addProject() {
        HttpServletRequest request = ServletActionContext.getRequest();
        String content = request.getParameter("content");

        project.setContent(content);
        project.setDate(MyTool.dateToString(new Date()));

        boolean isAdd = new ProjectDao().addProject(project);

        if (isAdd) {
            request.getSession().setAttribute("sthAdd", "yes");
            request.getSession().setAttribute("dealMsg", "Project创建成功");
        }
        return SUCCESS;
    }

    public String ProjectDel() {
        HttpServletRequest request = ServletActionContext.getRequest();
        int pid = Integer.parseInt(request.getParameter("pid"));
        boolean isDel = new ProjectDao().delProject(pid);
        String pagestr = request.getParameter("pageid");
        StaticMethod.getProjectPaging(pagestr, 10);
        if (isDel) {
            System.out.println("---------------------------");
            request.getSession().setAttribute("isDel", "yes");
            request.getSession().setAttribute("dealMsg", "Project删除成功");
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    public String ProjectGet() {
        HttpServletRequest request = ServletActionContext.getRequest();
        int pid = Integer.parseInt(request.getParameter("pid"));

        String des = request.getParameter("des");
        String from = (String) request.getParameter("from");

        project = new ProjectDao().getProjectById(pid);
        List<Comment> comments = new ProjectCommentDao().getCommentsByPid(pid);
        if (project != null) {
            if (from != null && "front".equals(from)) {
                request.getSession().setAttribute("frontShow", project);
                request.getSession().setAttribute("commentShow", comments);
                return "PROJECT_SINGLE";
            }
            request.getSession().setAttribute("detail", des);
            request.getSession().setAttribute(des, project);
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    public String ProjectUpdate() {
        HttpServletRequest request = ServletActionContext.getRequest();
        int pid = Integer.parseInt(request.getParameter("pid"));

        String content = request.getParameter("content");
        project.setId(pid);

//		System.out.println(project.getTitle()+"__"+project.getId());

        project.setContent(content);

        boolean isUpdate = new ProjectDao().updateProject(project);
        if (isUpdate) {
            System.out.println("---------------------------");
            request.getSession().setAttribute("modify", project);
            request.getSession().setAttribute("modifySave", "yes");
            request.getSession().setAttribute("dealMsg", "Project修改成功");
            return SUCCESS;
        } else {
            return ERROR;
        }
    }
}
