<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.chenxi.struts2.bean.Project" %>
<%@ page import="com.chenxi.struts2.util.MyTool" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

    <title>Tregante</title>
</head>

<body>

<%@include file="header.jsp"%>

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
			<li><a class="active" href="project.jsp"> <ins>
						<div class="br-left"></div>
						<div class="br-mid">项目</div>
						<!--br-mid-->
						<div class="br-right"></div>
					</ins>
			</a></li>
			<li id="page-title">项目</li>
			<!--page-title-->
		</ul>

		<div id="inner-border"></div>
		<div class="clear"></div>

		<div id="contentwrap-inner">
			<div id="port-left">

				<ul class="projects">
				
					<% 
						List<Project> list =(ArrayList<Project>)session.getAttribute("projectlist");
						if(list != null){
							Iterator<Project> i = list.iterator();
	        				
	                		while (i.hasNext()) {
	        					Project project = (Project) i.next();
            		%>
					<li class="project">
						<div class="port-img-wrap">
							<a class="port-pp" title="&nbsp;" href="images/rw-2-big.jpg"
								rel="prettyPhoto"> <ins>
									<div class="port-img-inner">
										<img class="port-img" src="images/rw-2-big.jpg" alt="" />
									</div>
								</ins>
							</a>
							<div class="pro-date">
								<span class="day"><%=project.getDate().substring(8, 10)%></span> 
								<span class="month"><%=MyTool.EngMonth(project.getDate().substring(5, 7))%></span> 
								<span class="year"><%=project.getDate().substring(2, 4)%></span>
							</div>
							<!--pro-date-->
							<div class="port-protitle">
								<a class="project-single" title="&nbsp;"
									href="Project!ProjectGet.action?from=front&pid=<%=project.getId()%>"><ins>
										<h4><%=project.getTitle() %></h4>
									</ins></a>
							</div>
							<!--port-protitle-->
							<ul class="port-category">
								<li><span class="h">类别</span> <a ><%=project.getCategory() %></a></li>
							</ul>
						</div> <!--port-img-wrap-->

						<div class="port-info">
							<div class="port-info-i">
								<h4>客户</h4>
								<div class="port-info-border"></div>
								<p><%=project.getMadeFor() %></p>
							</div>
							<!--port-info-i-->

							<div class="port-info-i">
								<h4>分享</h4>
								<div class="port-info-border"></div>
								<ul class="port-share">
									<%@include file="share.jsp" %>
								</ul>
								<div class="clear"></div>
								<ul class="port-bts-wrapper">
									<li><a href="Project!ProjectGet.action?from=front&pid=<%=project.getId()%>"><ins>
												<div class="bt-left"></div>
												<div class="bt-mid">详细情况</div>
												<div class="bt-right"></div>
											</ins></a></li>
									<li><a href="##"><ins>
												<div class="bt-left"></div>
												<div class="bt-mid">试运行</div>
												<div class="bt-right"></div>
											</ins></a></li>
								</ul>
								<!--port-bts-wrapper-->
							</div>
							<!--port-info-i-->
						</div> <!--port-info-->

						<div class="port-right">
							<%=project.getIntro() %>
						</div> <!--port-right-->
						<div class="clear"></div>
					</li>
					
					
					<%}}%>
					
					
				</ul>
				<!--projects-->

				<ul class="page-numbers">
              	<li class="prev"><a href="FrontPage!ProjectPaging.action?pageid=${fpage.curPage-1 }">&nbsp;</a></li>
                <li class="active"><a href="FrontPage!ProjectPaging.action?pageid=${fpage.curPage}">${fpage.curPage }</a></li>
                <c:choose>
					<c:when test="${page.curPage == page.totalPage}">
                		<li class="next"><a href="FrontPage!ProjectPaging.action?pageid=${fpage.curPage }">&nbsp;</a></li>
              		</c:when>
              		<c:otherwise>
              			<li class="next"><a href="FrontPage!ProjectPaging.action?pageid=${fpage.curPage+1 }">&nbsp;</a></li>
              		</c:otherwise>
              	</c:choose>
              </ul>	
			</div>
			<!--port-left-->


			<div id="port-sidebar">
				<div class="port-sidebar-border">
					<h3>最近的客户</h3>
				</div>
				<!--port-sidebar-border-->
				<div id="side-clients">
					<ul>
						<li><a href="##"><img src="images/side-client-1.png"
								alt="" /></a></li>
						<li><a href="##"><img src="images/side-client-2.png"
								alt="" /></a></li>
						<li><a href="##"><img src="images/side-client-3.png"
								alt="" /></a></li>
						<li><a href="##"><img src="images/side-client-4.png"
								alt="" /></a></li>
						<li><a href="##"><img src="images/side-client-5.png"
								alt="" /></a></li>
						<li><a href="##"><img src="images/side-client-6.png"
								alt="" /></a></li>
						<li><a href="##"><img src="images/side-client-7.png"
								alt="" /></a></li>
						<li><a href="##"><img src="images/side-client-8.png"
								alt="" /></a></li>
						<li><a href="##"><img src="images/side-client-9.png"
								alt="" /></a></li>
						<li><a href="##"><img src="images/side-client-10.png"
								alt="" /></a></li>
					</ul>
				</div>
				<!--side-clients-->
				<div class="clear"></div>

				<div id="side-categories">
					<div class="port-sidebar-border">
						<h3>类别</h3>
					</div>
					<!--port-sidebar-border-->
					<div class="clear"></div>
					<ul>
						<li><a href="##"><ins>
									<div class="bt-left"></div>
									<div class="bt-mid">所有</div>
									<div class="bt-right"></div>
								</ins></a></li>
						<li><a href="##"><ins>
									<div class="bt-left"></div>
									<div class="bt-mid">STATIC WEB</div>
									<div class="bt-right"></div>
								</ins></a></li>
						<li><a href="##"><ins>
									<div class="bt-left"></div>
									<div class="bt-mid">WORDPRESS</div>
									<div class="bt-right"></div>
								</ins></a></li>
						<li><a href="##"><ins>
									<div class="bt-left"></div>
									<div class="bt-mid">MOBILE</div>
									<div class="bt-right"></div>
								</ins></a></li>
					</ul>
					<div class="clear"></div>
				</div>
				<!--side-categories-->

			</div>
			<!--port-sidebar-->

			<div class="clear"></div>

		</div>
		<!--contentwrap-inner-->
	</div>
	<!--container-inner-->

	<%@include file="social.jsp"%>


	<%@include file="footer.jsp"%>

</body>
</html>
