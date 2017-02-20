package com.chenxi.ws.cxfrest.service;

import com.chenxi.ws.cxfrest.model.Book;
import com.chenxi.ws.cxfrest.model.HashDB;

import javax.jws.WebService;

/**
 * Created by zhaochx1 on 2016/11/28.
 *
 * @author zhaochx1
 */
@WebService(endpointInterface = "com.chenxi.ws.cxfrest.service.BookShelfService", serviceName = "bookShelfService")
public class BookShelfServiceImpl {
    public String insertBook(Book book) {
        HashDB.insertBook(book);
        return "Book with name : " + book.getBookName() + " is now available on the shelf";
    }

    public Book getBook(String title) {

        return HashDB.getBook(title);
    }
}
