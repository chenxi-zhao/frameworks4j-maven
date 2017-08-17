package com.chenxi.mybatis.mapper;

import com.chenxi.mybatis.beans.CoursesBean;

/**
 * Created by chenxi on 2017/8/16.
 *
 * @author chenxi
 */
public interface CoursesMapper {
    /**
     * 根据id查询课程
     *
     * @param id
     * @return
     */
    public CoursesBean findCouById(int id);

    /**
     * 要求查课时，将选课的学生一并查出
     *
     * @param id
     * @return
     */
    public CoursesBean findCouAndStu(int id);
}
