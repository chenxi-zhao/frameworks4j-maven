<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page import="com.chenxi.struts2.action.FrontStaticMethod" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Tregante</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body >

	<%	FrontStaticMethod.getServicePaging(null, 8); %>

	 <%@include file="header.jsp" %>

	<div id="container-inner">
		<ul id="breadcrumb-wrapper">

			<li><a href="index.jsp"> <ins>
						<div class="br-left"></div>
						<div class="br-mid">
							<ins></ins>
							主页
						</div>
						<!--br-mid-->
						<div class="br-right">
							<span class="hidden">占空间用</span>
						</div>
						
					</ins>
			</a></li>

			<li><a class="active" href="portfolio.jsp"> <ins>
						<div class="br-left">
							<span class="hidden">占空间用</span>
						</div>
						<div class="br-mid">
							<span class="hidden">占空间用</span> 服务
						</div>
						<!--br-mid-->
						<div class="br-right">
							<span class="hidden">占空间用</span>
						</div>
						<!--br-right-->
					</ins>
			</a></li>

			<li id="page-title">服务</li>
			<!--page-title-->

		</ul>
		<!--breadcrumb-wrapper-->
		<div id="inner-border"></div>
		<div class="clear"></div>

		<div id="contentwrap-inner">
			<ul class="twocol">
				<c:forEach items="${frontlist}" var ="mylist">
			
				<li class="col">
					<div class="services-img">
						<img src="images/services-web.png" alt="" />
					</div>
					<div class="h-border">
						<h1>${mylist.detailName }</h1>
					</div>
					<div class="clear"></div>
					<p>${mylist.describe }</p> <br />
					<a href="##"><ins>
							<div class="bt-left"></div>
							<div class="bt-mid">VIEW PROJECTS</div>
							<div class="bt-right"></div>
						</ins></a>
				</li>
				</c:forEach>
				
			</ul>
			<!--twcol-->
			<div class="clear"></div>
			<div style="margin-top: -37px;"></div>
		</div>
		<!--contentwrap-inner-->
	</div>
	<!--container-inner-->
	
	<%@include file="social.jsp" %>
   
    
    <%@include file="footer.jsp" %>

</body>
</html>
