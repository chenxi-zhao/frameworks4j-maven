package com.chenxi.struts2.dao;

import com.chenxi.struts2.bean.Blog;
import com.chenxi.struts2.util.DbHelp;
import com.chenxi.struts2.util.ListToString;

import javax.sql.rowset.CachedRowSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BlogDao {
	public List<Blog> getBlogList(int start, int end) {
		List<Blog> li = new ArrayList<Blog>();

		String sql = "select * from blog ORDER BY bid limit ?,?";
		Object arr[] = {start,end};
		CachedRowSet crs = DbHelp.executeQuery(sql,arr);
		try {
			while (crs.next()) {
				Blog blog = new Blog();
				blog.setId(crs.getInt(1));
				blog.setTitle(crs.getString(2));
				blog.setAuthor(crs.getString(3));
				blog.setDate(crs.getString(4));
				blog.setCategory(crs.getString(5));
				blog.setTags(crs.getString(6));
				blog.setIntro(crs.getString(7));
				blog.setComments((ListToString.Str2List(crs.getString(8))));
				blog.setContent(crs.getString(9));
				
				li.add(blog);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// Collections.sort(li);
		return li;
	}

	public boolean delBlog(int id) {
		boolean b = false;
		String sql = "delete from blog where bid=?";
		int count = DbHelp.executeUpdata(sql, id);
		if (count >= 0) {
			b = true;
		}
		return b;
	}

	public Blog getBlogById(int id) {
		Blog blog = new Blog();
		String sql = "select * from blog where bid = ?";
		CachedRowSet crs = DbHelp.executeQuery(sql, id);
		try {
			while (crs.next()) {
				blog.setId(crs.getInt(1));
				blog.setTitle(crs.getString(2));
				blog.setAuthor(crs.getString(3));
				blog.setDate(crs.getString(4));
				blog.setCategory(crs.getString(5));
				blog.setTags(crs.getString(6));
				blog.setIntro(crs.getString(7));
				blog.setComments((ListToString.Str2List(crs.getString(8))));
				blog.setContent(crs.getString(9));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return blog;
	}

	public boolean updateBlog(Blog blog) {
		boolean b = false;
		String sql = "update blog set title = ? ,category=? , tags=? ,intro=?, content=? where bid =?";
		Object[] obj = { blog.getTitle(), blog.getCategory(), blog.getTags(),
				blog.getIntro(), blog.getContent(), blog.getId() };
		int count = DbHelp.executeUpdata(sql, obj);
		if (count >= 0) {
			b = true;
		}
		return b;
	}

	public boolean addBlog(Blog blog) {
		boolean b = false;
		int count = -1;
		String sql = "insert into blog values(?,?,?,?,?,?,?,?,?)";
		Object[] arr = { blog.getId(),blog.getTitle(), blog.getAuthor(),
				blog.getDate(), blog.getCategory(), blog.getTags(), blog.getIntro(),ListToString.List2Str(blog.getComments()),blog.getContent()};
		count = DbHelp.executeUpdata(sql, arr);
		if (count > 0) {
			b = true;
		}
		return b;
	}

	/**
	 * 返回总条数
	 */
	public int getCount() {
		int count = 0;
		String sql = "select count(*) from blog";
		CachedRowSet crs = DbHelp.executeQuery(sql);
		try {
			while (crs.next()) {
				count = crs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;

	}
}
