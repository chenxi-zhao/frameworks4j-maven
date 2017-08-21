package com.chenxi.struts2.dao;

import com.chenxi.struts2.bean.Member;
import com.chenxi.struts2.util.DbHelp;
import com.chenxi.struts2.util.ListToString;

import javax.sql.rowset.CachedRowSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDao {
	public Member Login(String username, String password) {
		Member mem = null;
		String sql = "select * from member where mname=? and mpass=?";
		Object[] arr = { username, password };
		CachedRowSet crs = DbHelp.executeQuery(sql, arr);
		try {
			while (crs.next()) {
				mem = new Member();
				mem.setId(crs.getInt(1));
				mem.setName(crs.getString(2));
				mem.setPass(crs.getString(3));
				mem.setAddr(crs.getString(4));
				mem.setEmail(crs.getString(5));
				mem.setTel(crs.getString(6));
				mem.setSkill(ListToString.Str2List(crs.getString(7)));
				mem.setDescribe(crs.getString(8));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mem;
	}

	public List<Member> getMemberList(int start, int end) {
		List<Member> li = new ArrayList<Member>();

		String sql = "select * from member ORDER BY mid limit ?,?";
		Object arr[] = {start,end};
		CachedRowSet crs = DbHelp.executeQuery(sql,arr);
		try {
			while (crs.next()) {
				Member mem = new Member();
				mem.setId(crs.getInt(1));
				mem.setName(crs.getString(2));
				mem.setPass(crs.getString(3));
				mem.setAddr(crs.getString(4));
				mem.setEmail(crs.getString(5));
				mem.setTel(crs.getString(6));
				mem.setSkill(ListToString.Str2List(crs.getString(7)));
				mem.setDescribe(crs.getString(8));
				li.add(mem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// Collections.sort(li);
		return li;
	}

	public boolean delMember(int id) {
		boolean b = false;
		String sql = "delete from member where mid=?";
		int count = DbHelp.executeUpdata(sql, id);
		if (count >= 0) {
			b = true;
		}
		return b;
	}

	public Member getMemberByName(String name) {
		Member mem = null;
		String sql = "select * from member where mname = ?";
		CachedRowSet crs = DbHelp.executeQuery(sql, name);
		try {
			while (crs.next()) {
				mem = new Member();
				mem.setId(crs.getInt(1));
				mem.setName(crs.getString(2));
				mem.setPass(crs.getString(3));
				mem.setAddr(crs.getString(4));
				mem.setEmail(crs.getString(5));
				mem.setTel(crs.getString(6));
				mem.setSkill(ListToString.Str2List(crs.getString(7)));
				mem.setDescribe(crs.getString(8));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mem;
	}

	public Member getMemberById(int id) {
		Member mem = null;
		String sql = "select * from member where mid = ?";
		CachedRowSet crs = DbHelp.executeQuery(sql, id);
		try {
			while (crs.next()) {
				mem = new Member();
				mem.setId(crs.getInt(1));
				mem.setName(crs.getString(2));
				mem.setPass(crs.getString(3));
				mem.setAddr(crs.getString(4));
				mem.setEmail(crs.getString(5));
				mem.setTel(crs.getString(6));
				mem.setSkill(ListToString.Str2List(crs.getString(7)));
				mem.setDescribe(crs.getString(8));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mem;
	}

	public boolean updateMember(Member mem) {
		boolean b = false;
		String sql = "update member set mname = ? ,mpass =? , addr =? ,email=? , tel=? , skill=? where mid =?";
		Object[] obj = { mem.getName(), mem.getPass(), mem.getAddr(),
				mem.getEmail(), mem.getTel(),
				ListToString.List2Str(mem.getSkill()), mem.getId() };
		int count = DbHelp.executeUpdata(sql, obj);
		if (count >= 0) {
			b = true;
		}
		return b;
	}

	public boolean addMember(Member mem) {
		boolean b = false;
		String sql = "insert into member values(?,?,?,?,?,?,?,?)";
		Object[] arr = { mem.getId(), mem.getName(), mem.getPass(),
				mem.getAddr(), mem.getEmail(), mem.getTel(), ListToString.List2Str(mem.getSkill()) ,mem.getDescribe()};
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
		String sql = "select count(*) from member";
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
