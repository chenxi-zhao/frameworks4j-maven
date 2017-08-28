package com.chenxi.ssmd.entity;

/**
 * Created by chenxi on 2017/8/28.
 *
 * @author chenxi
 */
public class Book {
    /**
     * 图书ID
     */
    private long bookId;

    /**
     * 图书名称
     */
    private String name;

    /**
     * 馆藏数量
     */
    private int number;//

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
