<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.tracyzro.bean.Blog" %>
<%
	request.setCharacterEncoding("UTF-8");
	Blog blog = (Blog)session.getAttribute("show");
	String contentEdit = blog.getContent() != null ? blog.getContent() : "";
%>

<div class="clear"></div>
<div class="content-box">
	<div class="content-box-header">
		<h3>${show.title }</h3>
		<ul class="content-box-tabs">
			<li><a href="#tab2" class = "default-tab">时间:&nbsp;&nbsp;&nbsp;&nbsp;${show.date} </a></li>
		</ul>
		<div class="clear"></div>
	</div>
	
	
	<div class="content-box-content">
		<div class="tab-content default-tab" id="tab2">
					<p>
						<label style="float: right; margin-right: 60px;">作者:&nbsp;&nbsp;${show.author } </label> 
						<br/>
					</p>
					<p >
						<label><%=contentEdit %></label>
						<br />
		
					</p>
					<br/><br/><br/><br/><br/>
					<p>
						<label style="float: right; margin-right: 60px;">标签:&nbsp;&nbsp;&nbsp;&nbsp;${show.tags } </label> 
						<br/>
					</p>
					<p>
						<label style="float: right; margin-right: 60px;">类别:&nbsp;&nbsp;&nbsp;&nbsp;${show.category}</label> 
						<br>
					</p>
				<div class="clear"></div>
		</div>
		<!-- End #tab2 -->
	</div>
	<!-- End .content-box-content -->
</div>
