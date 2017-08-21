package com.chenxi.struts2.action;

import com.chenxi.struts2.bean.Blog;
import com.chenxi.struts2.bean.Comment;
import com.chenxi.struts2.bean.Member;
import com.chenxi.struts2.dao.BlogCommentDao;
import com.chenxi.struts2.dao.BlogDao;
import com.chenxi.struts2.util.MyTool;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

public class BlogAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private Blog blog;
	
	public Blog getBlog() {
		return blog;
	}
	public void setBlog(Blog blog) {
		this.blog = blog;
	}
	
	public String writeBlog(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String content = request.getParameter("content");
		Member mem = (Member) request.getSession().getAttribute("mymember");
		
		blog.setContent(content);
		blog.setAuthor(mem.getName());
		blog.setDate(MyTool.dateToString(new Date()));
		
		boolean isAdd =new BlogDao().addBlog(blog);
		
		if(isAdd){
			request.getSession().setAttribute("sthAdd", "yes");
			request.getSession().setAttribute("dealMsg", "blog创建成功");
		}
		return SUCCESS;
	}
	public String BlogDel() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int bid = Integer.parseInt(request.getParameter("bid"));
		boolean isDel = new BlogDao().delBlog(bid);
		String pagestr = request.getParameter("pageid");
		StaticMethod.getBlogPaging(pagestr,10);
		if (isDel) {
			System.out.println("---------------------------");
			request.getSession().setAttribute("isDel", "yes");
			request.getSession().setAttribute("dealMsg", "Blog删除成功");
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
	
	public String BlogGet() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int bid = Integer.parseInt(request.getParameter("bid"));
		String des = (String)request.getParameter("des");
		String from = (String)request.getParameter("from");
		
		blog = new BlogDao().getBlogById(bid);
		List<Comment> comments = new BlogCommentDao().getCommentsByBid(bid);
		if (blog !=null) {
			if(from != null && "front".equals(from)){
				request.getSession().setAttribute("frontShow", blog);
				request.getSession().setAttribute("commentShow", comments);
				return "BLOG_SINGLE";
			}
			request.getSession().setAttribute("detail", des);
			request.getSession().setAttribute(des, blog);
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
	public String BlogUpdate() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int bid = Integer.parseInt(request.getParameter("bid"));
		
		String content = request.getParameter("content");
		blog.setId(bid);
		
		System.out.println(blog.getTitle()+"__"+blog.getId());
		
		blog.setContent(content);
		
		boolean isUpdate =new BlogDao().updateBlog(blog);
		if (isUpdate) {
			System.out.println("---------------------------");
			request.getSession().setAttribute("modify", blog);
			request.getSession().setAttribute("modifySave", "yes");
			request.getSession().setAttribute("dealMsg", "Blog修改成功");
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
	
}
