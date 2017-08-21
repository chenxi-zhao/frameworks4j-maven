<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<div id="sidebar">
	<div id="sidebar-wrapper">
		<!-- Sidebar with logo and menu -->

		<h1 id="sidebar-title">
			<a href="#">Tregante Admin</a>
		</h1>
		<!-- Logo (221px wide) -->
		<a href="BgMenubar.action?barMa=main"><img id="logo" src="resources/images/logo.png"
			alt="Simpla Admin logo" /></a>
		<!-- Sidebar Profile links -->


		<div id="profile-links">
			Hello, <a href="#" title="Edit your profile">${mymember.name }</a>, you have <a
				href="#messages" rel="modal" title="3 Messages">3 Messages</a> <br />
			<br /> <a href="#" title="View the Site">View the Site</a> | <a
				href="Member!MemberLoginOut.action" title="Sign Out">Sign Out</a>
		</div>
		
		<ul id="main-nav">
			<!-- Accordion Menu -->
			<li><a href="BgMenubar.action?barMa=member" class="nav-top-item no-submenu"> 
					成员管理
			</a></li>
			<li><a href="#" class="nav-top-item"> 
					博客管理
			</a>
				<ul>
					<li><a href="BgMenubar.action?barMa=blog&detail=write">写新博客</a></li>
					<li><a href="BgMenubar.action?barMa=blog&detail=manage">博客管理</a></li>
					<li><a href="BgMenubar.action?barMa=blog&detail=comment">评论管理</a></li>
				</ul></li>
			<li><a href="#" class="nav-top-item"> 项目管理 </a>
				<ul>
					<li><a href="BgMenubar.action?barMa=project&detail=add">添加项目</a></li>
					<li><a href="BgMenubar.action?barMa=project&detail=list">项目列表</a></li>
				</ul></li>
			<li><a href="#" class="nav-top-item"> 服务管理 </a>
				<ul>
					<li><a href="BgMenubar.action?barMa=service&detail=service">服务管理</a></li>
				</ul></li>
			<li><a href="#" class="nav-top-item"> Settings </a>
				<ul>
					<li><a href="BgMenubar.action?barMa=group&detail=advertise">主页宣传</a></li>
					<li><a href="BgMenubar.action?barMa=group&detail=ability">团队内涵</a></li>
					<li><a href="BgMenubar.action?barMa=group&detail=work">团队工作</a></li>
					<li><a href="BgMenubar.action?barMa=group&detail=excellent">优秀成员</a></li>
					<li><a href="BgMenubar.action?barMa=group&detail=about">关于团队</a></li>
				</ul></li>
		</ul>
		<!-- End #main-nav -->
		
		
		
		<div id="messages" style="display: none">
			<!-- Messages are shown when a link with these attributes are clicked: href="#messages" rel="modal"  -->
			<h3>3 Messages</h3>
			<p>
				<strong>17th May 2009</strong> by Admin<br /> Lorem ipsum dolor sit
				amet, consectetur adipiscing elit. Vivamus magna. Cras in mi at
				felis aliquet congue. <small><a href="#" class="remove-link"
					title="Remove message">Remove</a></small>
			</p>
			<p>
				<strong>2nd May 2009</strong> by Jane Doe<br /> Ut a est eget
				ligula molestie gravida. Curabitur massa. Donec eleifend, libero at
				sagittis mollis, tellus est malesuada tellus, at luctus turpis elit
				sit amet quam. Vivamus pretium ornare est. <small><a
					href="#" class="remove-link" title="Remove message">Remove</a></small>
			</p>
			<p>
				<strong>25th April 2009</strong> by Admin<br /> Lorem ipsum dolor
				sit amet, consectetur adipiscing elit. Vivamus magna. Cras in mi at
				felis aliquet congue. <small><a href="#" class="remove-link"
					title="Remove message">Remove</a></small>
			</p>
			<form action="#" method="post">
				<h4>New Message</h4>
				<fieldset>
					<textarea class="textarea" name="textfield" cols="79" rows="5"></textarea>
				</fieldset>
				<fieldset>
					<select name="dropdown" class="small-input">
						<option value="option1">Send to...</option>
						<option value="option2">Everyone</option>
						<option value="option3">Admin</option>
						<option value="option4">Jane Doe</option>
					</select> <input class="button" type="submit" value="Send" />
				</fieldset>
			</form>
		</div>
		
		<!-- End #messages -->
	</div>
</div>
<!-- End #sidebar -->