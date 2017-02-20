package com.chenxi.ws.cxfrest.model;

import java.util.HashMap;

/**
 * Created by zhaochx1 on 2016/11/28.
 */
public class HashDB {
    public static HashMap<String, Book> bookDB = new HashMap<String, Book>();
    public static int counter = 0;

    public static void insertBook(Book book) {
        if (HashDB.bookDB.size() > 10000) {
            HashDB.bookDB.clear();
            counter++;
        }
        HashDB.bookDB.put(book.getBookName(), book);
    }

    public static Book getBook(String bookName) {
        return HashDB.bookDB.get(bookName);
    }


}
