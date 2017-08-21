package com.chenxi.struts2.dao;

import com.chenxi.struts2.bean.IndexImg;
import com.chenxi.struts2.util.DbHelp;

import javax.sql.rowset.CachedRowSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IndexImgDao {
	public List<IndexImg> getIndexImgList() {
		List<IndexImg> li = new ArrayList<IndexImg>();

		String sql = "select * from indeximg;";
		CachedRowSet crs = DbHelp.executeQuery(sql);
		try {
			while (crs.next()) {
				IndexImg ii = new IndexImg();
				ii.setName(crs.getString(1));
				ii.setFilePath(crs.getString(2));
				ii.setImgFileContentType(crs.getString(3));
				ii.setImgFileFileName(crs.getString(4));
				ii.setDescribe(crs.getString(5));
				li.add(ii);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return li;
	}

	public boolean delImg(String name) {
		boolean b = false;
		String sql = "delete from indeximg where path=?";
		int count = DbHelp.executeUpdata(sql, name);
		if (count >= 0) {
			b = true;
		}
		return b;
	}



	public boolean addBlog(IndexImg ii) {
		boolean b = false;
		int count = -1;
		String sql = "insert into indeximg values(?,?,?,?,?)";
		Object[] arr = { ii.getName(),ii.getFilePath(),ii.getImgFileContentType(),ii.getImgFileFileName(),ii.getDescribe()};
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
		String sql = "select count(*) from indeximg";
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
