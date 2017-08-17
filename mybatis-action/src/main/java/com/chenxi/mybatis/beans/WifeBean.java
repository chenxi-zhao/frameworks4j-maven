package com.chenxi.mybatis.beans;

/**
 * Created by chenxi on 2017/8/16.
 *
 * @author chenxi
 */
public class WifeBean {
    private Integer id;
    private String name;
    private HusbandBean husband;

    public WifeBean() {
        super();
    }

    public WifeBean(Integer id, String name, HusbandBean husband) {
        super();
        this.id = id;
        this.name = name;
        this.husband = husband;
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

    public HusbandBean getHusband() {
        return husband;
    }

    public void setHusband(HusbandBean husband) {
        this.husband = husband;
    }

    @Override
    public String toString() {
        return "Wife [id=" + id + ", name=" + name + ", husband=" + husband + "]";
    }
}
