package com.chenxi.struts2.bean;

import java.io.Serializable;
import java.util.List;

public class Project implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String title;
    private String madeFor;
    private String date;
    private String category;
    private String intro;
    private List<String> comments;
    private String content;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMadeFor() {
        return madeFor;
    }

    public void setMadeFor(String madeFor) {
        this.madeFor = madeFor;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return id + "_" + title + "_" + madeFor + "_" + content;
    }
}
