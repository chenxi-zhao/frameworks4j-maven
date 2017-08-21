<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.chenxi.struts2.bean.Blog" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Tregante_Blog</title>
</head>

<body>
<%@include file="header.jsp" %>
    <div id="container-inner">
    	<ul id="breadcrumb-wrapper">
	    	<li>
	            <a href="index.jsp">
                <ins>
				    <div class="br-left"></div>
				    <div class="br-mid">
				    	主页
				    </div><!--br-mid-->
				    <div class="br-right">
				    </div><!--br-right-->
                </ins>    
		        </a>
            </li>  
            <li>
	            <a class="active" href="blog.jsp">
                <ins>
				    <div class="br-left"></div>
				    <div class="br-mid">
				    	博客
				    </div><!--br-mid-->
				    <div class="br-right">
				    </div><!--br-right-->
                </ins>    
		        </a>
            </li>
            <li id="page-title">
          		博客
        	</li><!--page-title-->
        </ul><!--breadcrumb-wrapper-->
        <div id="inner-border"></div>
    	<div class="clear"></div>
        	
        <div id="contentwrap-inner">	
            <div id="content-left">
              <ul class="posts">
                	<% 
                		List<Blog> list =(ArrayList<Blog>)session.getAttribute("bloglist");
                		if(list != null){
	                		Iterator<Blog> i = list.iterator();
	        				while (i.hasNext()) {
	        					Blog blog = (Blog) i.next();
            		%>
						<li class="post">
                        <div class="blog-info">
                        	<div class="blog-info-i">
                            	<h4>作者</h4>
                                <div class="blog-info-border"></div>
                                <p><%=blog.getAuthor() %></p>
                            </div><!--blog-info-i-->
                            
                            <div class="blog-info-i">
                            	<h4>分享</h4>
                                <div class="blog-info-border"></div>
                                <ul class="blog-share">
                                	<%@include file="share.jsp" %>
                                </ul>
								
                                <div class="clear"></div>
                                <ul class="blog-bts-wrapper">
                                <li><a href="Blog!BlogGet.action?from=front&bid=<%=blog.getId()%>"><ins><div class="bt-left"></div><div class="bt-mid">全文</div><div class="bt-right"></div></ins></a></li>
                                </ul><!--blog-bts-wrapper-->
                            </div><!--blog-info-i-->
                        </div><!--blog-info-->
                        
                        <div class="blog-right">
                        	<a href="Blog!BlogGet.action?from=front&bid=<%=blog.getId()%>"><ins><h1><%=blog.getTitle() %></h1></ins></a>
                        	<p><%=blog.getIntro() %> <a class="excerpt" href="Blog!BlogGet.action?from=front&bid=<%=blog.getId()%>">......</a></p>
                       		<br /><br /><br /><br /><br />
                       		<div style="float: right;"><%=blog.getDate() %></div>
                        </div><!--blog-right-->
                        <div class="clear"></div>
                    </li>
					<%
					}}%>
                	
                	
                	
              </ul><!--posts-->
                    
              <ul class="page-numbers">
              	<li class="prev"><a href="FrontPage!BlogPaging.action?pageid=${fpage.curPage-1 }">&nbsp;</a></li>
                <li class="active"><a href="FrontPage!BlogPaging.action?pageid=${fpage.curPage}">${fpage.curPage }</a></li>
               <c:choose>
					<c:when test="${page.curPage == page.totalPage}">
               			<li class="next"><a href="FrontPage!BlogPaging.action?pageid=${fpage.curPage }">&nbsp;</a></li>
              		</c:when>
              		<c:otherwise>
              			<li class="next"><a href="FrontPage!BlogPaging.action?pageid=${fpage.curPage+1 }">&nbsp;</a></li>
              		</c:otherwise>	
              </c:choose>
              </ul>	
                    
            </div><!--content-left-->
            
            <div id="sidebar">
               	
                <div id="side-comments">
                	<div class="sidebar-border"><h3>最近的评论</h3></div>
                    <div class="clear"></div>
                    <ul>
                   	 <c:forEach items="${recentCom}" var ="recentCom">
                    	<li>
                        	<a href="Blog!BlogGet.action?from=front&bid=${recentCom.xid }">${recentCom.content }<span class="comment-owner">${recentCom.name }</span></a>
                        </li>
                       </c:forEach> 
                    </ul>
                    
                </div><!--side-comments-->
                 
            </div><!--sidebar-->
            <div class="clear"></div>
            
        </div><!--contentwrap-inner--> 
    </div><!--container-inner-->
    
   <%@include file="social.jsp" %>
   
    
   <%@include file="footer.jsp" %>

</body>
</html>
