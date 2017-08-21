<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.tracyzro.bean.Blog" %>
<%
	request.setCharacterEncoding("UTF-8");
	Blog blog = (Blog)session.getAttribute("modify");
	String contentEdit = blog.getContent() != null ? blog.getContent() : "";
%>

<%
	String blogSave = "";
	blogSave = (String) session.getAttribute("modifySave");
	if (blogSave != null) {
%>
<div class="notification success png_bg">
	<a href="#" class="close"><img
		src="resources/images/icons/cross_grey_small.png"
		title="Close this notification" alt="close" /></a>
	<div>${dealMsg}</div>
</div>
<%
	}
%>

<div class="clear"></div>
<!-- End .clear -->
<div class="content-box">
	<!-- Start Content Box -->
	<div class="content-box-header">
		<h3>修改</h3>
		<ul class="content-box-tabs">
			<li><a href="#tab2" class = "default-tab">博客</a></li>
		</ul>
		<div class="clear"></div>
	</div>
	<!-- End .content-box-header -->
	
	
	<div class="content-box-content">
		<div class="tab-content default-tab" id="tab2">
			<form action="Blog!BlogUpdate?bid=${modify.id }" method="post" name="example">
				<fieldset>
					<p>
						<label>标题</label>
						<input class="text-input small-input" type="text" id="small-input"	name="blog.title" value="${modify.title}"/>
						
<!-- 						 <span class="input-notification success png_bg">Successful	message</span> -->
<!-- 						 <br /> <small>A small description of the field</small> -->
					</p>
					<p>
						<label>标签</label> 
						<input class="text-input medium-input datepicker" type="text" id="medium-input" name="blog.tags" value="${modify.tags}"/> 
<!-- 						<span class="input-notification error png_bg">Error message</span> -->
						<small>标签之间以逗号隔开，如”裸分，教育“</small>
					</p>
					<p>
						<label>简介</label> <input class="text-input large-input" type="text" id="large-input" name="blog.intro" value="${modify.intro}" />
					</p>
					<p>
						<label>类别</label> 
						<select name="blog.category" class="small-input">
							<option value="生活">生活</option>
							<option value="旅行">旅行</option>
							<option value="美食">美食</option>
							<option value="学习">学习</option>
						</select>
					</p>
					<p>
						<label>正文</label>
						<textarea name="content" cols="100" rows="8" style="width:700px;height:200px;visibility:hidden;"><%=htmlspecialchars(contentEdit)%></textarea>
						<br />
		
					</p>
					<p>
						<input type="submit" name="button" value="提交内容" /> (提交快捷键: Ctrl + Enter)
					</p>
				</fieldset>
				<div class="clear"></div>
				
				
			</form>
		</div>
		<!-- End #tab2 -->
	</div>
	<!-- End .content-box-content -->
</div>
<!-- End .content-box -->
<%-- <%=session.getAttribute("mycontent") %> --%>
<%!
private String htmlspecialchars(String str) {
	str = str.replaceAll("&", "&amp;");
	str = str.replaceAll("<", "&lt;");
	str = str.replaceAll(">", "&gt;");
	str = str.replaceAll("\"", "&quot;");
	return str;
}
%>