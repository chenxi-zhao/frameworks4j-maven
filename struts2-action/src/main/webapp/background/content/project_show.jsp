<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.tracyzro.bean.Project"%>
<%
	request.setCharacterEncoding("UTF-8");
	Project pro = (Project)session.getAttribute("show");
	String contentEdit = pro.getContent() != null ? pro.getContent() : "";
%>
<div class="clear"></div>
<!-- End .clear -->
<div class="content-box">
	<!-- Start Content Box -->
	<div class="content-box-header">
		<h3>${show.title }</h3>
		<ul class="content-box-tabs">
			<li><a href="#tab2" class = "default-tab">时间:&nbsp;&nbsp;&nbsp;&nbsp;${show.date }</a></li>
		</ul>
		<div class="clear"></div>
	</div>
	<!-- End .content-box-header -->
	
	
	<div class="content-box-content">
		<div class="tab-content default-tab" id="tab2">
					<p >
						<label style="border: 2px;"><%=contentEdit %></label>
						<br />
		
					</p>
					<br/><br/><br/><br/><br/>
					<p>
						<label style="float: right; margin-right: 60px;">交付单位:&nbsp;&nbsp;&nbsp;&nbsp;${show.madeFor } </label> 
						<br/>
					</p>
					<p>
						<label style="float: right; margin-right: 60px;">类别:&nbsp;&nbsp;&nbsp;&nbsp;${show.category}</label> 
						<br>
					</p>
				<div class="clear"></div>
		</div>
	</div>
	<!-- End .content-box-content -->
</div>
<!-- End .content-box -->
