package com.chenxi.struts2.dao;

import com.chenxi.struts2.bean.Service;
import com.chenxi.struts2.util.DbHelp;

import javax.sql.rowset.CachedRowSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceDao {
	public List<Service> getServiceList(int start, int end) {
		List<Service> li = new ArrayList<Service>();

		String sql = "select * from service ORDER BY sid limit ?,?";
		Object arr[] = {start,end};
		CachedRowSet crs = DbHelp.executeQuery(sql,arr);
		try {
			while (crs.next()) {
				Service service = new Service();
				service.setId(crs.getInt(1));
				service.setSearchName(crs.getString(2));
				service.setDetailName(crs.getString(3));
				service.setDescribe(crs.getString(4));

				li.add(service);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return li;
	}

	public boolean delService(int id) {
		boolean b = false;
		String sql = "delete from service where sid=?";
		int count = DbHelp.executeUpdata(sql, id);
		if (count >= 0) {
			b = true;
		}
		return b;
	}

	public List<Service> getProjectBySearchName(String name) {
		List<Service> li = new ArrayList<Service>();
		String sql = "select * from project where category = ?";
		CachedRowSet crs = DbHelp.executeQuery(sql, name);
		try {
			while (crs.next()) {
				Service service = new Service();
				service.setId(crs.getInt(1));
				service.setSearchName(crs.getString(2));
				service.setDetailName(crs.getString(3));
				service.setDescribe(crs.getString(4));

				li.add(service);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return li;
	}

	public Service getSerivceById(int id) {
		Service service = null;
		String sql = "select * from service where sid = ?";
		CachedRowSet crs = DbHelp.executeQuery(sql, id);
		try {
			while (crs.next()) {
				service = new Service();
				service.setId(crs.getInt(1));
				service.setSearchName(crs.getString(2));
				service.setDetailName(crs.getString(3));
				service.setDescribe(crs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return service;
	}

//	public boolean updateMember(Member mem) {
//		boolean b = false;
//		String sql = "update serice set mname = ? ,mpass =? , addr =? ,email=? , tel=? , skill=? where mid =?";
//		Object[] obj = { mem.getName(), mem.getPass(), mem.getAddr(),
//				mem.getEmail(), mem.getTel(),
//				ListToString.List2Str(mem.getSkill()), mem.getId() };
//		int count = DbHelp.executeUpdata(sql, obj);
//		if (count >= 0) {
//			b = true;
//		}
//		return b;
//	}

	public boolean addService(Service service) {
		boolean b = false;
		String sql = "insert into service values(?,?,?,?)";
		Object[] arr = { service.getId(), service.getSearchName(),service.getDetailName(),service.getDescribe()};
		int count = DbHelp.executeUpdata(sql, arr);
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
		String sql = "select count(*) from service";
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