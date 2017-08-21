<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.tracyzro.bean.Page" %>
<div class="clear"></div>
<div class="content-box">
	<!-- Start Content Box -->
	<div class="content-box-header">
		<h3>管理</h3>
		<ul class="content-box-tabs">
			<li><a href="#tab1" class="default-tab">博客</a></li>
		</ul>
		<div class="clear"></div>
	</div>
	
	<!-- End .content-box-header -->
	<div class="content-box-content">
		<div class="tab-content default-tab" id="tab1">
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
			<table>
				<thead>
					<tr>
						<th><input class="check-all" type="checkbox" /></th>
						<th>标题: </th>
						<th>作者</th>
						<th>类别</th>
						<th>时间</th>
						<th>简介</th>
						<th>操作</th>
					</tr>
				</thead>

				<tfoot>
					<tr>
						<td colspan="6">
							<div class="bulk-actions align-left">
								<select name="dropdown">
									<option value="option1">Choose an action...</option>
									<option value="option2">Edit</option>
									<option value="option3">Delete</option>
								</select> <a class="button" href="#">Apply to selected</a>
							</div>

							<div class="pagination">
								<a href="DividePage!BlogPaging.action?pageid=1" title="First Page">&laquo; First</a> 
								<a href="DividePage!BlogPaging.action?pageid=${page.curPage - 1}" title="Previous Page">&laquo; Previous</a> 
								<a href="DividePage!BlogPaging.action?pageid=${page.curPage}" class="number current" title="${page.curPage}">${page.curPage}</a>
								<a href="DividePage!BlogPaging.action?pageid=${page.curPage + 1}" class="number" title="${page.curPage + 1}">${page.curPage+ 1}</a>
								<c:choose>
									<c:when test="${page.curPage == page.totalPage}">
										<a href="DividePage!BlogPaging.action?pageid=${page.totalPage}" title="Next Page">Next &raquo;</a>
									</c:when>

									<c:otherwise>
										<a href="DividePage!BlogPaging.action?pageid=${page.curPage+1}" title="Next Page">Next &raquo;</a>
									</c:otherwise>
								</c:choose>
								<a href="DividePage!BlogPaging.action?pageid=${page.totalPage}" title="Last Page">Last &raquo;</a>
							</div> <!-- End .pagination -->

							<div class="clear"></div>
						</td>
					</tr>
				</tfoot>

				<tbody>
					<c:forEach items="${list}" var ="mylist">
						<tr>
							<td><input type="checkbox" /></td>
							<td>${mylist.title }</td>
							<td><a href="#" title="title">${mylist.author }</a></td>
							<td>${mylist.category }</td>
							<td>${mylist.date }</td>
							<td>${mylist.intro }</td>
							<td>
								<a href="Blog!BlogGet.action?bid=${mylist.id }&des=modify"  title="Edit"><img src="resources/images/icons/pencil.png" /></a>
								<a href="Blog!BlogDel.action?bid=${mylist.id }&pageid=${page.curPage}" title="Delete"><img src="resources/images/icons/cross.png" /></a> 
								<a href="Blog!BlogGet.action?bid=${mylist.id }&des=show" title="Edit Meta"><img src="resources/images/icons/hammer_screwdriver.png" /></a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<!-- End .content-box-content -->
</div>
