package com.chenxi.ws.cxfrest.service;

import com.chenxi.ws.cxfrest.model.Book;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by zhaochx1 on 2016/11/28.
 *
 * @author zhaochx1
 */
@WebService
public interface BookShelfService {

    @WebMethod
    String insertBook(Book book);

    @WebMethod
    Book getBook(String title);
}
