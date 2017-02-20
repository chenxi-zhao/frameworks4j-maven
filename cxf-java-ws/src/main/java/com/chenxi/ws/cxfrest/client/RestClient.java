package com.chenxi.ws.cxfrest.client;

import com.chenxi.ws.cxfrest.model.Book;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;

import java.net.URLEncoder;

/**
 * Created by zhaochx1 on 2016/11/28.
 *
 * @author zhaochx1
 */
public class RestClient {
    public static void main(String[] args) {
        RestClient restClient = new RestClient();
        try {
            restClient.addBook("Naked Sun", "Issac Asimov");
            restClient.getBook("Naked Sun");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Book getBook(String bookName) throws Exception {

        String output = null;
        try {
            String url = "http://localhost:8080/bookservice/getbook/";

            url = url + URLEncoder.encode(bookName, "UTF-8");

            HttpClient client = new HttpClient();
            PostMethod mPost = new PostMethod(url);
            client.executeMethod(mPost);
            Header mtHeader = new Header();
            mtHeader.setName("content-type");
            mtHeader.setValue("application/x-www-form-urlencoded");
            mtHeader.setName("accept");
            mtHeader.setValue("application/xml");
            mPost.addRequestHeader(mtHeader);
            client.executeMethod(mPost);
            output = mPost.getResponseBodyAsString();
            mPost.releaseConnection();
            System.out.println("out : " + output);
        } catch (Exception e) {
            throw new Exception("Exception in retriving group page info : " + e);
        }
        return null;
    }

    public void addBook(String bookName, String author) throws Exception {

        String output = null;
        try {
            String url = "http://localhost:8080/bookservice/addbook";
            HttpClient client = new HttpClient();
            PostMethod mPost = new PostMethod(url);
            mPost.addParameter("name", "Naked Sun");
            mPost.addParameter("author", "Issac Asimov");
            Header mtHeader = new Header();
            mtHeader.setName("content-type");
            mtHeader.setValue("application/x-www-form-urlencoded");
            mtHeader.setName("accept");
            mtHeader.setValue("application/xml");
            //mtHeader.setValue("application/json");
            mPost.addRequestHeader(mtHeader);
            client.executeMethod(mPost);
            output = mPost.getResponseBodyAsString();
            mPost.releaseConnection();
            System.out.println("output : " + output);
        } catch (Exception e) {
            throw new Exception("Exception in adding bucket : " + e);
        }

    }
}
