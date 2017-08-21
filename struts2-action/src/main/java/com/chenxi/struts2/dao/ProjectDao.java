package com.chenxi.struts2.dao;

import com.chenxi.struts2.bean.Project;
import com.chenxi.struts2.util.DbHelp;
import com.chenxi.struts2.util.ListToString;

import javax.sql.rowset.CachedRowSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjectDao {
	public List<Project> getProjectList(int start, int end) {
		List<Project> li = new ArrayList<Project>();

		String sql = "select * from project ORDER BY pid limit ?,?";
		Object arr[] = {start,end};
		CachedRowSet crs = DbHelp.executeQuery(sql,arr);
		try {
			while (crs.next()) {
				Project project = new Project();
				project.setId(crs.getInt(1));
				project.setTitle(crs.getString(2));
				project.setMadeFor(crs.getString(3));
				project.setDate(crs.getString(4));
				project.setCategory(crs.getString(5));
				project.setIntro(crs.getString(6));
				project.setComments((ListToString.Str2List(crs.getString(7))));
				project.setContent(crs.getString(8));
				
				li.add(project);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return li;
	}

	public boolean delProject(int id) {
		boolean b = false;
		String sql = "delete from project where pid=?";
		int count = DbHelp.executeUpdata(sql, id);
		if (count >= 0) {
			b = true;
		}
		return b;
	}

//	public Blog getBlogByName(String name) {
//		Blog blog = new Blog();
//		String sql = "select * from blog where title = ?";
//		CachedRowSet crs = DbHelp.executeQuery(sql, name);
//		try {
//			while (crs.next()) {
//				
//				blog.setId(crs.getInt(1));
//				blog.setTitle(crs.getString(2));
//				blog.setAuthor(crs.getString(3));
//				blog.setDate(crs.getString(4));
//				blog.setCategory(crs.getString(5));
//				blog.setTags(crs.getString(6));
//				blog.setIntro(crs.getString(7));
//				blog.setComments((ListToString.Str2List(crs.getString(8))));
//				blog.setContent(crs.getString(9));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return blog;
//	}

	public Project getProjectById(int id) {
		Project project = new Project();
		String sql = "select * from project where pid = ?";
		CachedRowSet crs = DbHelp.executeQuery(sql, id);
		try {
			while (crs.next()) {
				project.setId(crs.getInt(1));
				project.setTitle(crs.getString(2));
				project.setMadeFor(crs.getString(3));
				project.setDate(crs.getString(4));
				project.setCategory(crs.getString(5));
				project.setIntro(crs.getString(6));
				project.setComments((ListToString.Str2List(crs.getString(7))));
				project.setContent(crs.getString(8));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return project;
	}

	public boolean updateProject(Project project) {
		boolean b = false;
		String sql = "update project set title = ? ,madeFor=? , intro=? ,category=?, content=? where pid =?";
		Object[] obj = { project.getTitle(), project.getMadeFor(), project.getIntro(),
				project.getCategory(), project.getContent(), project.getId() };
		int count = DbHelp.executeUpdata(sql, obj);
		if (count >= 0) {
			b = true;
		}
		return b;
	}

	public boolean addProject(Project project) {
		boolean b = false;
		int count = -1;
//		Connection cn = null;
//		PreparedStatement pstm = null;
//		cn = DbHelp.getConnection();
//		Object[] arr = { null,blog.getTitle(), blog.getAuthor(),
//				blog.getDate(), blog.getCategory(), blog.getTags(), blog.getIntro(),ListToString.List2Str(blog.getComments())};
		String sql = "insert into project values(?,?,?,?,?,?,?,?)";
//		try {
//			pstm = cn.prepareStatement(sql);
//			for (int i = 0; i < arr.length; i++) {
//				pstm.setObject(i + 1, arr[i]);
//			}
//			System.out.println();
//			Reader reader = new StringReader(blog.getContent());
//			pstm.setClob(9, reader, blog.getContent().length());
//			
//			
//			count = pstm.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				pstm.close();
//				cn.close();
//			} catch (SQLException ex) {
//
//			}
//		}
		Object[] arr = { project.getId(),project.getTitle(), project.getMadeFor(),
				project.getDate(), project.getCategory(), project.getIntro(),ListToString.List2Str(project.getComments()),project.getContent()};
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
		String sql = "select count(*) from project";
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
