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
	isDel = (String)session.getAttribute("isDel");
	if(isDel != null){
%>
	<div class="notification success png_bg">
		<a href="#" class="close"><img	src="resources/images/icons/cross_grey_small.png" title="Close this notification" alt="close" /></a>
		<div>${dealMsg}</div>
	</div>
<%
	}
%>


<div class="clear"></div>
<!-- End .clear -->
<div class="content-box" >
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
						<th>搜索名</th>
						<th>全称</th>
						<th>介绍</th>
						<th>操作</th>
					</tr>
				</thead>

				<tfoot>
					<tr>
						<td colspan="4">

							<div class="pagination">
								<a href="DividePage!ServicePaging.action?pageid=1" title="First Page">&laquo; First</a> 
								<a href="DividePage!ServicePaging.action?pageid=${page.curPage - 1}" title="Previous Page">&laquo; Previous</a> 
								<a href="DividePage!ServicePaging.action?pageid=${page.curPage}" class="number current" title="${page.curPage}">${page.curPage}</a>
								<a href="DividePage!ServicePaging.action?pageid=${page.curPage + 1}" class="number" title="${page.curPage + 1}">${page.curPage+ 1}</a>
								<c:choose>
									<c:when test="${page.curPage == page.totalPage}">
										<a href="DividePage!ServicePaging.action?pageid=${page.totalPage}" title="Next Page">Next &raquo;</a>
									</c:when>

									<c:otherwise>
										<a href="DividePage!ServicePaging.action?pageid=${page.curPage+1}" title="Next Page">Next &raquo;</a>
									</c:otherwise>
								</c:choose>
								<a href="DividePage!ServicePaging.action?pageid=${page.totalPage}" title="Last Page">Last &raquo;</a>
							</div> <!-- End .pagination -->

							<div class="clear"></div>
						</td>
					</tr>
				</tfoot>

				<tbody>
					<c:forEach items="${list}" var ="mylist">
						<tr>
							<td><input type="checkbox" /></td>
							<td>${mylist.searchName }</td>
							<td>${mylist.detailName }</td>
							<td>${mylist.describe }</td>
							<td>
								<a href="Service!ServiceDel.action?sid=${mylist.id }&pageid=${page.curPage}" title="Delete"><img src="resources/images/icons/cross.png" /></a> 
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	
	
		<div class="tab-content" id="tab2">
			<form action="Service!AddService" method="post" name="example">
				<fieldset>
					<p>
						<label>搜索名</label> <input class="text-input small-input"
							type="text" id="medium-input" name="service.searchName" />
					</p>
					<p>
						<label>全称</label> <input class="text-input medium-input"
							type="text" id="large-input" name="service.detailName" />
					</p>
					<p>
						<label>描述</label>
						<textarea style="width: 330px; height: 80px; overflow-y: hidden"
							name="service.describe"></textarea>
						<br />

					</p>
					<p>
						<input type="submit" name="button" value="提交内容" />
					</p>
				</fieldset>
				<div class="clear"></div>
			</form>
		</div>
	</div>
</div>
