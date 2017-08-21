package com.chenxi.struts2.bean;

@SuppressWarnings("unused")
public class Page {
    private int curPage = 1; // 当前页
    private int pageSize = 10; // 每页多少行
    private int totalRow; // 共多少行 10
    private int start;// 当前页起始行
    private int totalPage; // 共多少页

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        if (curPage < 1) {
            curPage = 1;

        } else {
            start = pageSize * (curPage - 1); //
        }
        this.curPage = curPage;
    }

    public int getStart() {
        // start=curPage*pageSize;
        return start;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalRow() {
        return totalRow;
    }

    public void setTotalRow(int totalRow) {
        this.totalRow = totalRow;
    }

    public int getTotalPage() {
        return this.totalRow % pageSize == 0 ? this.totalRow / pageSize
                : this.totalRow / pageSize + 1;
    }
}
