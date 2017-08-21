<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.tracyzro.bean.Project"%>
<%
	request.setCharacterEncoding("UTF-8");
	Project pro = (Project)session.getAttribute("modify");
	String contentEdit = pro.getContent() != null ? pro.getContent() : "";
%>

<%
	String projectSave = "";
	projectSave = (String) session.getAttribute("modifySave");
	if (projectSave != null) {
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
			<li><a href="#tab2" class = "default-tab">项目</a></li>
		</ul>
		<div class="clear"></div>
	</div>
	<!-- End .content-box-header -->
	
	
	<div class="content-box-content">
		<div class="tab-content default-tab" id="tab2">
			<form action="Project!ProjectUpdate?pid=${modify.id }" method="post" name="example">
				<fieldset>
					<p>
						<label>课题</label>
						<input class="text-input small-input" type="text" id="small-input"	name="project.title" value="${modify.title }"/>
<!-- 						 <span class="input-notification success png_bg">Successful	message</span> -->
<!-- 						 <br /> <small>A small description of the field</small> -->
					</p>
					<p>
						<label>交付单位</label> 
						<input class="text-input medium-input datepicker" type="text" id="medium-input" name="project.madeFor" value="${modify.madeFor }"/> 
<!-- 						<span class="input-notification error png_bg">Error message</span> -->
					</p>
					<p>
						<label>简介</label> <input class="text-input large-input" type="text" id="large-input" name="project.intro" value="${modify.intro }"/>
					</p>
					<p>
						<label>类别</label> 
						<select name="project.category" class="small-input">
							<option value="StaticWeb">StaticWeb</option>
							<option value="Mobile">Mobile</option>
							<option value="WordPress">WordPress</option>
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
