package com.chenxi.ws.cxfrest.service;

import com.chenxi.ws.cxfrest.model.Book;
import com.chenxi.ws.cxfrest.model.HashDB;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * Created by zhaochx1 on 2016/11/28.
 */
public class BookService {
    protected final Logger logger = LoggerFactory.getLogger(BookService.class);


    @GET
    @Path("getbook/{name}")
    @Produces({"application/xml", "application/json"})
    @Consumes({"application/xml", "application/json", "application/x-www-form-urlencoded"})
    public Response getBucket(@PathParam("name") String name) {
        logger.debug("name: " + name);
        Book book = null;
        try {
            book = HashDB.getBook(URLDecoder.decode(name, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        if (book == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        } else {
            return Response.ok(book).build();
        }
    }


    @POST
    @Path("/addbook")
    @Produces({"application/xml", "application/json"})
    @Consumes({"application/xml", "application/json", "application/x-www-form-urlencoded"})
    public Response addBook(@FormParam("name") String bookName, @FormParam("author") String author) {
        logger.debug("inside addBook");
        Book book = new Book();
        book.setBookName(bookName);
        book.setAuthor(author);
        HashDB.insertBook(book);
        if (HashDB.getBook(bookName) == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        } else {
            return Response.ok(book).build();
        }

    }

}
