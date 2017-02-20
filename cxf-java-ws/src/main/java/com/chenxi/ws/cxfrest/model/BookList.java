package com.chenxi.ws.cxfrest.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaochx1 on 2016/11/28.
 *
 * @author zhaochx1
 */
@XmlRootElement(name = "BookList")
public class BookList {
    private List<Book> bookList;

    public List<Book> getBookList() {
        if (this.bookList == null) {
            bookList = new ArrayList<Book>();
        }
        return this.bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}
