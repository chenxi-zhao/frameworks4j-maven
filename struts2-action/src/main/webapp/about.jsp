<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

			<li><a class="active" href="portfolio.jsp"> <ins>
						<div class="br-left"></div>
						<div class="br-mid">关于</div>
						<!--br-mid-->
						<div class="br-right"></div>
						<!--br-right-->
					</ins>
			</a></li>
			<li id="page-title">关于</li>
			<!--page-title-->
		</ul>
		<!--breadcrumb-wrapper-->
		<div id="inner-border"></div>
		<div class="clear"></div>

		<div id="contentwrap-inner">
			<ul class="box-fw">
				<li class="fwbox" style="border: none; margin-bottom: 15px;"><img
					class="about-pic" src="images/about-company.png" alt="" />
					<div class="about-left">
						<h1>ABOUT GROUP</h1>
						<p>
							本小组成立于2013年下半学期jsp课程设计，其他的。。。。你懂得以下为了占字数<br />
							面向未来，坚持自主创新，树立民族品牌是腾讯公司的长远发展规划。目前，腾讯50%以上员工为研发人员。腾讯在即时通信、电子商务、在线支付、搜索引擎、信息安全以及游戏等方面都拥有了相当数量的专利申请。
						</p>

						<p class="testimonial-about">
							<span class="testimonial" id="about">成就一番伟业的唯一途径就是热爱自己的事业。如果你还没能找到让自己热爱的事业，继续寻找，不要放弃。跟随自己的心，总有一天你会找到的。</span>
							<span class="testimonial-owner">乔布斯, CEO, <a href="##">公司</a></span>
						</p>
					</div> <!--about-left-->

					<div class="about-right">
						<div class="h-border">
							<h2>SOME STATS</h2>
						</div>
						<p class="stat-title">软件工程</p>
						<p class="stat-value">65%</p>
						<div class="clear"></div>
						<div class="stat-bar-wrapper">
							<div style="width: 65%;" class="stat-bar"></div>
						</div>

						<p class="stat-title">JavaWeb开发</p>
						<p class="stat-value">52%</p>
						<div class="clear"></div>
						<div class="stat-bar-wrapper">
							<div style="width: 52%;" class="stat-bar"></div>
						</div>

						<p class="stat-title">算法设计</p>
						<p class="stat-value">85%</p>
						<div class="clear"></div>
						<div class="stat-bar-wrapper">
							<div style="width: 85%;" class="stat-bar"></div>
						</div>
					</div> <!--about-right-->
					<div class="clear"></div></li>

				<div class="h-border" style="margin: 32px 0 28px 0;">

					<h1>ABOUT STAFF</h1>
				</div>
				<div class="clear"></div>
				<c:forEach items="${memberlist }" var="memli">
					<li class="fwbox"><img class="about-pic"
						src="images/about-staff.png" alt="" />
						<div class="about-left">
							<h1>${memli.name }</h1>
							<p>${memli.describe }</p>
						</div> <!--about-left-->

						<div class="about-right">
							<div class="h-border">
								<h2>SKILLS</h2>
							</div>
							<div class="clear"></div>
							<ul class="skill-list">
								<c:forEach items="${memli.skill }" var="skill">
									<li><h4>${skill}</h4></li>
								</c:forEach>
							</ul>
							<div class="clear"></div>

						</div> <!--about-right-->
						<div class="clear"></div></li>

				</c:forEach>
			</ul>
			<!--box-fw-->
			<div class="clear"></div>
			<div style="margin-top: -5px;"></div>

		</div>
	</div>


	<%@include file="social.jsp"%>


	<%@include file="footer.jsp"%>

</body>
</html>
