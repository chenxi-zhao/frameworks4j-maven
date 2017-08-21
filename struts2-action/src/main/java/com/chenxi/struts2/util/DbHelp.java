package com.chenxi.struts2.util;

import com.sun.rowset.CachedRowSetImpl;

import javax.sql.rowset.CachedRowSet;
import java.sql.*;

/**
 * 数据库访问帮助类
 */
public class DbHelp {
    private static final String Driver = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/tregante";
    private static final String USER = "root";
    private static final String PASS = "123456";

    /**
     * @return
     */
    public static Connection getConnection() {
        Connection cn = null;
        try {
            Class.forName(Driver);
            cn = DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cn;
    }

    /**
     * @param sql insert update delete
     * @param arr
     * @return
     */
    public static int executeUpdata(String sql, Object... arr) {
        int a = 0;
        Connection cn = null;
        PreparedStatement pstm = null;
        cn = getConnection();
        try {
            pstm = cn.prepareStatement(sql);
            for (int i = 0; i < arr.length; i++) {
                pstm.setObject(i + 1, arr[i]);
            }
            a = pstm.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                pstm.close();
                cn.close();
            } catch (SQLException ex) {

            }
        }
        return a;

    }

    /**
     * @param sql select
     * @param arr
     * @return rowset
     */
    public static CachedRowSet executeQuery(String sql, Object... arr) {
        ResultSet rs = null;
        Connection cn = null;
        PreparedStatement pstm = null;
        CachedRowSet cr = null;
        cn = getConnection();
        try {
            pstm = cn.prepareStatement(sql);
            for (int i = 0; i < arr.length; i++) {
                pstm.setObject(i + 1, arr[i]);
            }
            cr = new CachedRowSetImpl();
            rs = pstm.executeQuery();
            cr.populate(rs);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                pstm.close();
                cn.close();
            } catch (Exception e2) {
                // TODO: handle exception
            }
        }
        return cr;

    }

}
