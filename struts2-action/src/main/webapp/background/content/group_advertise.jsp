<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String serivceAdd = "";
	serivceAdd = (String) session.getAttribute("sthAdd");
	if (serivceAdd != null) {
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

<%
	String isDel = "";
	isDel = (String) session.getAttribute("isDel");
	if (isDel != null) {
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
	<div class="content-box-header">
		<h3>服务</h3>
		<ul class="content-box-tabs">
			<li><a href="#tab1" class="default-tab">管理</a></li>
			<li><a href="#tab2">添加</a></li>
		</ul>
		<div class="clear"></div>
	</div>

	<div class="content-box-content">

		<div class="tab-content default-tab" id="tab1">
			<table>
				<thead>
					<tr>
						<th><input class="check-all" type="checkbox" /></th>
						<th>名称</th>
						<th>文件名</th>
						<th>描述</th>
						<th>操作</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${indexImg}" var="mylist">
						<tr>
							<td><input type="checkbox" /></td>
							<td>${mylist.name }</td>
							<td>${mylist.imgFileFileName }</td>
							<td>${mylist.describe }</td>
							<td><a
								href="IndexImg!DelImg.action?path=${mylist.filePath }"
								title="Delete"><img src="resources/images/icons/cross.png" /></a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>


		<div class="tab-content" id="tab2">
			<form action="IndexImg!Upload.action" method="post" enctype="multipart/form-data">
				<fieldset>
					<p>
						<label>名称</label> <input class="text-input small-input"
							type="text" name="indexImg.name" />
					</p>
					<p>
						<label>文件</label> <input type="file" name="indexImg.imgFile" />
					</p>
					<p>
						<label>描述</label>
						<textarea style="width: 330px; height: 80px; overflow-y: hidden"
							name="indexImg.describe"></textarea>
						<br />
					</p>
					<p>
						<input type="submit" name="button" value="提交" />
					</p>
				</fieldset>
				<div class="clear"></div>
			</form>
		</div>
	</div>
</div>

