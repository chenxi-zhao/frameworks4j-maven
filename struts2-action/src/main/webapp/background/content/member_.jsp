<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.tracyzro.bean.Page" %>
<%
	String blogAdd = "";
	blogAdd = (String) session.getAttribute("sthAdd");
	if (blogAdd != null) {
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
<div class="content-box">
	<!-- Start Content Box -->
	<div class="content-box-header">
		<h3>列表</h3>
		<ul class="content-box-tabs">
			<li><a href="#tab1" class="default-tab">团队成员</a></li>
			<li><a href="#tab2">添加</a></li>
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
						<th>ID</th>
						<th>姓名</th>
						<th>电话</th>
						<th>地址</th>
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
								<a href="DividePage!MemberPaging.action?pageid=1" title="First Page">&laquo; First</a> 
								<a href="DividePage!MemberPaging.action?pageid=${page.curPage - 1}" title="Previous Page">&laquo; Previous</a> 
								<a href="DividePage!MemberPaging.action?pageid=${page.curPage}" class="number current" title="${page.curPage}">${page.curPage}</a>
								<a href="DividePage!MemberPaging.action?pageid=${page.curPage + 1}" class="number" title="${page.curPage + 1}">${page.curPage+ 1}</a>
								<c:choose>
									<c:when test="${page.curPage == page.totalPage}">
										<a href="DividePage!MemberPaging.action?pageid=${page.totalPage}" title="Next Page">Next &raquo;</a>
									</c:when>

									<c:otherwise>
										<a href="DividePage!MemberPaging.action?pageid=${page.curPage+1}" title="Next Page">Next &raquo;</a>
									</c:otherwise>
								</c:choose>
								<a href="DividePage!MemberPaging.action?pageid=${page.totalPage}" title="Last Page">Last &raquo;</a>
							</div> <!-- End .pagination -->

							<div class="clear"></div>
						</td>
					</tr>
				</tfoot>

				<tbody>
					<c:forEach items="${list}" var ="mylist">
						<tr>
							<td><input type="checkbox" /></td>
							<td>${mylist.id }</td>
							<td><a href="#" title="title">${mylist.name }</a></td>
							<td>${mylist.tel }</td>
							<td>${mylist.addr }</td>
							<td>
								<a href="#editbox" rel="modal" title="Edit"><img src="resources/images/icons/pencil.png" /></a>
								<a href="Member!MemberDel.action?mid=${mylist.id }&pageid=${page.curPage}" title="Delete"><img src="resources/images/icons/cross.png" /></a> 
								<a href="#" title="Edit Meta"><img src="resources/images/icons/hammer_screwdriver.png" /></a>
							</td>
						</tr>
						
					</c:forEach>
				</tbody>
			</table>
		</div>
		
		<div class="tab-content" id="tab2">
			<form action="Member!AddMember" method="post" name="example">
				<fieldset>
					<p>
						<label>姓名</label> 
						<input class="text-input medium-input" id="myname" type="text"  name="member.name" onblur="isNull(this.id,'namenoti')" onfocus="getFocus('namenoti')"/>
						<span id="namenoti" class="input-notification error png_bg" ></span>
					</p>
					<p>
						<label>密码</label> 
						<input class="text-input medium-input" id='mypass' type="password"  name="member.pass" onblur="isNull(this.id,'passnoti')" onfocus="getFocus('passnoti')"/>
						<span id="passnoti" class="input-notification error png_bg" ></span>
					</p>
					<p>
						<label>重复密码</label> 
						<input class="text-input medium-input" id="repass" type="password"  onblur="passCheck('mypass',this.id,'repassnoti')" onfocus="getFocus('repassnoti')"/>
						<span id="repassnoti" class="input-notification error png_bg" ></span>
					</p>
					<p>
						<label>地址</label> 
						<input class="text-input medium-input" type="text"  name="member.addr" />
					</p>
					<p>
						<label>邮箱</label> 
						<input class="text-input medium-input" type="text"  name="member.email" />
					</p>
					<p>
						<label>电话</label> 
						<input class="text-input medium-input" type="text"  name="member.tel" />
					</p>
					<p>
						<label>Skill</label> 
						<input class="text-input medium-input" type="text" name="skill" />
						<small>输入时请以英文逗号隔开</small>
					</p>
					<p>
						<label>描述</label>
						<textarea style="width: 330px; height: 80px; overflow-y: hidden"
							name="member.describe"></textarea>
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
	<!-- End .content-box-content -->
	
	
</div>
<!-- End .content-box -->