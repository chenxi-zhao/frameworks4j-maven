package com.chenxi.mybatis.beans;

import java.io.Serializable;
import java.util.List;

/**
 * Created by chenxi on 2017/8/16.
 *
 * ManyToMany
 *
 * @author chenxi
 */
public class StudentBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private List<CoursesBean> courses;
    public StudentBean() {
        super();
    }
    public StudentBean(Integer id, String name, List<CoursesBean> courses) {
        super();
        this.id = id;
        this.name = name;
        this.courses = courses;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<CoursesBean> getCourses() {
        return courses;
    }
    public void setCourses(List<CoursesBean> courses) {
        this.courses = courses;
    }
    @Override
    public String toString() {
        return "StudentBean [id=" + id + ", name=" + name + ", courses="
                + courses + "]";
    }


}
