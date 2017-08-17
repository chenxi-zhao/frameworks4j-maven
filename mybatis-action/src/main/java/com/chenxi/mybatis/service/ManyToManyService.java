package com.chenxi.mybatis.service;

import com.chenxi.mybatis.beans.CoursesBean;
import com.chenxi.mybatis.beans.StudentBean;
import com.chenxi.mybatis.mapper.CoursesMapper;
import com.chenxi.mybatis.mapper.StudentMapper;
import com.chenxi.mybatis.tools.DBTools;
import org.apache.ibatis.session.SqlSession;

/**
 * Created by chenxi on 2017/8/16.
 *
 * @author chenxi
 */
public class ManyToManyService {
    public static void main(String[] args) {
        findStudentByCourses();
        findCoursesByStudent();
    }


    private static void findCoursesByStudent() {
        SqlSession session = DBTools.getSession();
        StudentMapper sm = session.getMapper(StudentMapper.class);
        StudentBean sb = sm.findStuAndCou(1);
        System.out.println(sb);

    }


    private static void findStudentByCourses() {
        SqlSession session = DBTools.getSession();
        CoursesMapper cm = session.getMapper(CoursesMapper.class);
        CoursesBean cb = cm.findCouAndStu(2);
        System.out.println(cb);
    }
}
