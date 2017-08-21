<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.chenxi.struts2.bean.Blog"%>
<%@ page import="com.chenxi.struts2.bean.Comment"%>
<%@ page import="com.chenxi.struts2.util.MyTool"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="background/kindeditor/jslib/plugins/code/prettify.css" />
<script charset="utf-8" src="background/kindeditor/jslib/plugins/code/prettify.js"></script>
<script charset="utf-8" src="js/jquery-1.7.1.min.js"></script>
<title>Tregante</title>
</head>

<body onload="prettyPrint()">
	<%@include file="header.jsp"%>
	<%
		Blog blog = (Blog) session.getAttribute("frontShow");
		List<Comment> com = (List<Comment>)session.getAttribute("commentShow");
	%>
	<div id="container-inner">
		<ul id="breadcrumb-wrapper">
			<li><a href="index.jsp"> <ins>
						<div class="br-left"></div>
						<div class="br-mid">主页</div>
						<!--br-mid-->
						<div class="br-right"></div>
						<!--br-right-->
					</ins>
			</a></li>

			<li><a href="blog.jsp"> <ins>
						<div class="br-left"></div>
						<div class="br-mid">博客</div>
						<!--br-mid-->
						<div class="br-right"></div>
						<!--br-right-->
					</ins>
			</a></li>

			<li><a class="active"> <ins>
						<div class="br-left"></div>
						<div class="br-mid">
							<%=blog.getTitle()%>
						</div>
						<div class="br-right"></div>
						<!--br-right-->
					</ins>
			</a></li>
			<li id="page-title"><%=blog.getDate()%></li>
		</ul>
		
		<div id="inner-border"></div>
		<div class="clear"></div>

		<div id="contentwrap-inner">

			<div id="blog-single-sidebar">
				<div id="blog-single-comments">
					<a href="#"><ins>
							<h1><%=MyTool.lengthGet(com.size())%></h1>
						</ins></a>
				</div>
				<div id="blog-single-date">
					<span class="day-single"><%=blog.getDate().substring(8, 10)%></span>
					<span class="month-single"><%=MyTool.EngMonth(blog.getDate().substring(5, 7))%></span>
					<span class="year-single"><%=blog.getDate().substring(2, 4)%></span>
				</div>
				<!--blog-single-date-->

				<div class="blog-info">
					<div class="blog-info-i">
						<h4>作者</h4>
						<div class="blog-info-border"></div>
						<p><%=blog.getAuthor()%></p>
					</div>

					<div class="blog-info-i">
						<h4>类别</h4>
						<div class="blog-info-border"></div>
						<p><%=blog.getCategory()%></p>
					</div>

					<div class="blog-info-i">
						<h4>标签</h4>
						<div class="blog-info-border"></div>
						<p class="side"><%=blog.getTags()%></p>
					</div>
					<!--blog-info-i-->

					<div class="blog-info-i">
						<h4>分享</h4>
						<div class="blog-info-border"></div>
						<ul class="blog-share">
							<%@include file="share.jsp" %>
						</ul>
						<div class="clear"></div>
					</div>
				</div>
			</div>

			<div id="blog-single-right">
				<a><ins>
						<h1><%=blog.getTitle()%></h1>
					</ins></a>
				<div class="port-single-right-h3-border"></div>
				<p><%=blog.getContent()%></p>
				<div class="port-single-right-h3-border"></div>
				<br /><br /><br /><br /><br />
				<div style="margin-top: 21px;"></div>
				<div class="port-single-right-h3-border">
					<h3><%=com.size() %>&nbsp;&nbsp;评论</h3>
				</div>
				<div id="commentlist">
					<ul>
						<c:forEach items="${commentShow}" var ="comlist">
							<li>
								<div class="avatar">
									<img src="images/user-avatar.png" alt="" />
								</div>
								<!--avatar-->
								<div class="h-border">
									<p class="comment-info">
										<a >${comlist.name }</a> / 
										<a class="comment-date" href="##">${comlist.date }</a>
									</p>
								</div>
								<p>${comlist.content }</p>
								<div class="clear"></div>
								<div class="h-border-reply">
								</div>
								<div class="clear"></div>
							</li>
						</c:forEach>
					</ul>

				</div>
				<!--commentlist-->

				<div class="port-single-right-h3-border">
					<h3>写评论</h3>
				</div>
				<form id="comment" method="post" action="Comment!addBlogComment.action?bid=<%=blog.getId() %>" >
				<input class="textbox" name="comment.name" type="text" value='姓名'
					onfocus="if (this.value==this.defaultValue) this.value='';"
					onblur="if (this.value=='') this.value='姓名'" /> 
				<input	class="textbox" name="comment.email" type="text" value="邮箱"
					onfocus="if (this.value==this.defaultValue) this.value='';"
					onblur="if (this.value=='') this.value='邮箱'" />

				<div class="clearfix"></div>

				<textarea name="comment.content" 	onfocus="if (this.value==this.defaultValue) this.value='';"
					onblur="if (this.value=='') this.value='评论'">评论</textarea>
				<div class="clearfix"></div>
				<input name="submit" type="submit" class="submit" value="SUBMIT" />

				</form>

			</div>
			<!--blog-single-right-->

			<div class="clear"></div>

		</div>
		<!--contentwrap-inner-->
	</div>
	<!--container-inner-->

	<%@include file="social.jsp"%>


	<%@include file="footer.jsp"%>

</body>
</html>
