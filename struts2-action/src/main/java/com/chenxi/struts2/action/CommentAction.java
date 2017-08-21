package com.chenxi.struts2.action;

import com.chenxi.struts2.bean.Comment;
import com.chenxi.struts2.dao.BlogCommentDao;
import com.chenxi.struts2.dao.ProjectCommentDao;
import com.chenxi.struts2.util.MyTool;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

public class CommentAction extends ActionSupport {
    private static final long serialVersionUID = 1L;
    private Comment comment;

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public String addBlogComment() {
        HttpServletRequest request = ServletActionContext.getRequest();
        int bid = Integer.parseInt(request.getParameter("bid"));
        comment.setXid(bid);
        comment.setDate(MyTool.dateToString(new Date()));

        boolean isAdd = new BlogCommentDao().addComment(comment);
        if (isAdd) {
            List<Comment> comments = new BlogCommentDao().getCommentsByBid(bid);
            request.getSession().setAttribute("commentShow", comments);
            return "ADD_BLOGCOMMENT_SU";
        } else
            return "ADD_BLOGCOMMENT_FA";
    }

    public String addProjectComment() {
        HttpServletRequest request = ServletActionContext.getRequest();
        int pid = Integer.parseInt(request.getParameter("pid"));
        comment.setXid(pid);
        comment.setDate(MyTool.dateToString(new Date()));

        boolean isAdd = new ProjectCommentDao().addComment(comment);
        if (isAdd) {
            List<Comment> comments = new ProjectCommentDao().getCommentsByPid(pid);
            request.getSession().setAttribute("commentShow", comments);
            return "ADD_PROJECTCOMMENT_SU";
        } else
            return "ADD_PROJECTCOMMENT_FA";
    }
}
