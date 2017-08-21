package com.chenxi.struts2.dao;

import com.chenxi.struts2.bean.Comment;
import com.chenxi.struts2.util.DbHelp;

import javax.sql.rowset.CachedRowSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BlogCommentDao {
	public List<Comment> getBlogCommentsList(int limit) {
		List<Comment> li = new ArrayList<Comment>();

		String sql = "select * from blogcomment ORDER BY cid DESC limit ?";
		Object arr[] = {limit};
		CachedRowSet crs = DbHelp.executeQuery(sql,arr);
		try {
			while (crs.next()) {
				Comment bc = new Comment();
				bc.setCid(crs.getInt(1));
				bc.setXid(crs.getInt(2));
				bc.setName(crs.getString(3));
				bc.setEmail(crs.getString(4));
				bc.setDate(crs.getString(5));
				bc.setContent(crs.getString(6));
				
				li.add(bc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// Collections.sort(li);
		return li;
	}
	
	public List<Comment> getCommentsByBid(int bid) {
		List<Comment> li = new ArrayList<Comment>();

		String sql = "select * from blogcomment where bid = ?";
		Object arr[] = {bid};
		CachedRowSet crs = DbHelp.executeQuery(sql,arr);
		try {
			while (crs.next()) {
				Comment bc = new Comment();
				bc.setCid(crs.getInt(1));
				bc.setXid(crs.getInt(2));
				bc.setName(crs.getString(3));
				bc.setEmail(crs.getString(4));
				bc.setDate(crs.getString(5));
				bc.setContent(crs.getString(6));
				
				li.add(bc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// Collections.sort(li);
		return li;
	}
	
	

	public boolean delComment(int id) {
		boolean b = false;
		String sql = "delete from blogcomment where cid=?";
		int count = DbHelp.executeUpdata(sql, id);
		if (count >= 0) {
			b = true;
		}
		return b;
	}

	public Comment getCommentById(int id) {
		Comment bc = new Comment();
		String sql = "select * from blogcomment where cid = ?";
		CachedRowSet crs = DbHelp.executeQuery(sql, id);
		try {
			while (crs.next()) {
				bc.setCid(crs.getInt(1));
				bc.setXid(crs.getInt(2));
				bc.setName(crs.getString(3));
				bc.setEmail(crs.getString(4));
				bc.setDate(crs.getString(5));
				bc.setContent(crs.getString(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bc;
	}


	public boolean addComment(Comment bc) {
		boolean b = false;
		int count = -1;
		String sql = "insert into blogcomment values(?,?,?,?,?,?)";
		Object[] arr = { bc.getCid(),bc.getXid(),bc.getName(),bc.getEmail(),bc.getDate(),bc.getContent()};
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
		String sql = "select count(*) from blogcomment";
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
