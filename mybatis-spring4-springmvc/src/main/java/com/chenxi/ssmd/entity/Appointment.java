package com.chenxi.ssmd.entity;

import java.util.Date;

/**
 * Created by chenxi on 2017/8/28.
 *
 * @author chenxi
 */
public class Appointment {

    /**
     * 图书ID
     */
    private long bookId;

    /**
     * 学号
     */
    private long studentId;

    /**
     * 预约时间
     */
    private Date appointTime;

    /**
     * 图书实体, 多对一的复合属性
     */
    private Book book;

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public Date getAppointTime() {
        return appointTime;
    }

    public void setAppointTime(Date appointTime) {
        this.appointTime = appointTime;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
