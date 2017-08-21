<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.chenxi.struts2.bean.Comment"%>
<%@ page import="com.chenxi.struts2.bean.Project"%>
<%@ page import="com.chenxi.struts2.util.MyTool"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Tregante</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet"
	href="background/kindeditor/jslib/plugins/code/prettify.css" />
<script charset="utf-8"
	src="background/kindeditor/jslib/plugins/code/prettify.js"></script>
<script charset="utf-8" src="js/jquery-1.7.1.min.js"></script>
</head>

<body onload="prettyPrint()">
	<%@include file="header.jsp"%>
	<%
		Project project = (Project) session.getAttribute("frontShow");
		List<Comment> com = (List<Comment>) session.getAttribute("commentShow");
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

			<li><a href="project.jsp"> <ins>
						<div class="br-left"></div>
						<div class="br-mid">项目</div>
						<!--br-mid-->
						<div class="br-right"></div>
						<!--br-right-->
					</ins>
			</a></li>

			<li><a class="active" href="##"> <ins>
						<div class="br-left"></div>
						<div class="br-mid">
							<%=project.getTitle()%>
						</div>
						<!--br-mid-->
						<div class="br-right"></div>
						<!--br-right-->
					</ins>
			</a></li>
			<li id="page-title"><%=project.getTitle()%></li>
			<!--page-title-->
		</ul>
		<!--breadcrumb-wrapper-->
		<div id="inner-border"></div>
		<div class="clear"></div>

		<div id="contentwrap-inner">
			<div class="slider-wrapper theme-default">
				<div id="slider-port-single" class="nivoSlider">
					<img src="images/detail-1.jpg" alt="" /> <img
						src="images/detail-2.jpg" alt="" /> <img
						src="images/detail-3.jpg" alt="" title="#htmlcaption" /> <img
						src="images/detail-4.jpg" alt="" />
				</div>
			</div>

			<div id="port-single-sidebar">
				<div id="port-single-protitle">
					<a href="##" title=""><ins>
							<h2><%=project.getTitle()%></h2>
						</ins></a>
				</div>
				<!--port-single-protitle-->

				<div id="port-single-date">
					<span class="day-single"><%=project.getDate().substring(8, 10)%></span>
					<span class="month-single"><%=MyTool.EngMonth(project.getDate().substring(5, 7))%></span>
					<span class="year-single"><%=project.getDate().substring(2, 4)%></span>
				</div>
				<!--port-single-date-->

				<div class="port-info">
					<div class="port-info-i">
						<h4>客户</h4>
						<div class="port-info-border"></div>
						<p><%=project.getMadeFor()%></p>
					</div>
					<!--port-info-i-->

					<div class="port-info-i">
						<h4>类别</h4>
						<div class="port-info-border"></div>
						<p><%=project.getCategory()%></p>
					</div>
					<!--port-info-i-->


					<div class="port-info-i">
						<h4>SHARE</h4>
						<div class="port-info-border"></div>
						<ul class="port-share">
							<%@include file="share.jsp"%>
						</ul>
						<div class="clear"></div>
						<div class="h-border"></div>
						<ul id="port-single-side-tns">
							<li><a href="images/detail-1.jpg" rel="prettyPhoto"><img
									src="images/detail-1.jpg" alt="Image Title" /></a></li>
							<li><a href="images/detail-2.jpg" rel="prettyPhoto"><img
									src="images/detail-2.jpg" alt="Image Title" /></a></li>
							<li><a href="images/detail-3.jpg" rel="prettyPhoto"><img
									src="images/detail-3.jpg" alt="Image Title" /></a></li>
							<li><a href="images/detail-4.jpg" rel="prettyPhoto"><img
									src="images/detail-4.jpg" alt="Image Title" /></a></li>
							<li><a href="images/detail-3.jpg" rel="prettyPhoto"><img
									src="images/detail-3.jpg" alt="Image Title" /></a></li>
							<li><a href="images/detail-4.jpg" rel="prettyPhoto"><img
									src="images/detail-4.jpg" alt="Image Title" /></a></li>
						</ul>
					</div>
					<!--port-info-i-->
				</div>
				<!--port-info-->

			</div>

			<div id="port-single-right">
				<p><%=project.getContent()%></p>
				<a href="##"><ins>
						<div class="bt-left"></div>
						<div class="bt-mid">LAUNCH</div>
						<div class="bt-right"></div>
					</ins></a>
				<div class="clear"></div>

				<div style="margin-top: 45px;"></div>
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
				<form id="comment" method="post"
					action="Comment!addProjectComment.action?pid=<%=project.getId()%>">
					<input class="textbox" name="comment.name" type="text" value='姓名'
						onfocus="if (this.value==this.defaultValue) this.value='';"
						onblur="if (this.value=='') this.value='姓名'" /> <input
						class="textbox" name="comment.email" type="text" value="邮箱"
						onfocus="if (this.value==this.defaultValue) this.value='';"
						onblur="if (this.value=='') this.value='邮箱'" />

					<div class="clearfix"></div>

					<textarea name="comment.content"
						onfocus="if (this.value==this.defaultValue) this.value='';"
						onblur="if (this.value=='') this.value='评论'">评论</textarea>
					<div class="clearfix"></div>
					<input name="submit" type="submit" class="submit" value="SUBMIT" />

				</form>

			</div>
			<!--port-single-right-->

			<div style="margin-top: 55px;" class="clear"></div>
		</div>
		<!--contentwrap-inner-->
	</div>
	<!--container-inner-->

	<%@include file="social.jsp"%>


	<%@include file="footer.jsp"%>

</body>
</html>
