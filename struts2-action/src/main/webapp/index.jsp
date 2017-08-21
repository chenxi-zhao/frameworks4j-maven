<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>

<title>Tregante</title>
</head>

<body>
	<%@include file="header.jsp"%>

	<div id="pic-holder">

		<div id="slider">
			<c:forEach items="${indexImg }" var="imglist">
				<div class="slider-pic"
					style="background:url(background/IndexImg/${imglist.imgFileFileName}) no-repeat scroll center center;">
					<div class="slider-caption">
						<p>${imglist.describe }</p>
					</div>
				</div>
			</c:forEach>
		</div>
		<!--slider-->
	</div>
	<!--pic-holder-->
	<div id="slider-border"></div>
	<div class="inner_copyright">Copyright 2013 Tregante All Rights
		Reserved By TracyZro</div>


	<div id="container">
		<div class="home3col">
			<div class="home3col-ribbon">
				<img src="images/creativity.png" alt="" />
			</div>
			<!--home3col-rb-->
			<h1>使命(MISSION)</h1>
			<p>使产品和服务像水和电一样源源不断融入人们的生活，为人们带来便捷和愉悦；
				关注不同地域、不同群体，并针对不同对象提供差异化的产品和服务； 打造开放共赢平台， 与合作伙伴共同营造健康的互联网生态环境。</p>
			<div class="home3col-details">
				<a href="##">Details</a>
				<div class="home3col-details-border"></div>
			</div>
			<!--home3col-details-->
		</div>
		<!--home3col-->
		<div class="home3col">
			<div class="home3col-ribbon">
				<img style="margin-left: -4px;" src="images/speciality.png" alt="" />
			</div>
			<!--home3col-rb-->
			<h1>愿景（VISION）</h1>
			<p>不断倾听和满足用户需求，引导并超越用户需求，赢得用户尊敬；
				通过提升企业地位与品牌形象，使员工具有高度的企业荣誉感和自豪感，赢得员工尊敬；
				推动互联网行业的健康发展，与合作伙伴共同成长，赢得行业尊敬；</p>
			<div class="home3col-details">
				<a href="##">Details</a>
				<div class="home3col-details-border"></div>
			</div>
			<!--home3col-details-->
		</div>
		<!--home3col-->
		<div class="home3col" id="home3colLast">
			<div class="home3col-ribbon">
				<img src="images/consistency.png" alt="" />
			</div>
			<!--home3col-rb-->
			<h1>价值观(VALUES)</h1>
			<p>具有开放共赢心态，与合作伙伴共享行业成长； 具备大局观，能够与其他团队相互配合，共同达成目标；
				乐于分享专业知识与工作经验，与同事共同成长。创新的目的是为用户创造价值.</p>
			<div class="home3col-details">
				<a href="##">Details</a>
				<div class="home3col-details-border"></div>
			</div>
			<!--home3col-details-->
		</div>
		<!--home3col-->
		<div class="clear"></div>

		<div id="lwt">
			<h2>如果你想加入我们！</h2>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;点击右边的按键，向我们发送信息</p>
			<div id="lwt-border"></div>
			<div id="get-a-quote">
				<a href="contact.jsp"><span class="hidden">Get A Quote</span></a>
			</div>
		</div>
		<!--lwt-->

		<div id="sp">
			<h2>我们的小伙伴们</h2>
			<div class="h-border" id="sph"></div>
		</div>
		<!--sp-->
		<div class="clear"></div>
		<div id="sp-carousel">
			<div id="sp-carouselPrev"></div>
			<div id='carousel_inner'>
				<ul id='carousel_ul'>
					<li><a href="##"><img src="images/sp1.png" alt="" /></a></li>
					<li><a href="##"><img src="images/sp2.png" alt="" /></a></li>
					<li><a href="##"><img src="images/sp3.png" alt="" /></a></li>
					<li><a href="##"><img src="images/sp4.png" alt="" /></a></li>
					<li><a href="##"><img src="images/sp5.png" alt="" /></a></li>
					<li><a href="##"><img src="images/sp6.png" alt="" /></a></li>
					<li><a href="##"><img src="images/sp7.png" alt="" /></a></li>
					<li><a href="##"><img src="images/sp8.png" alt="" /></a></li>
					<li><a href="##"><img src="images/sp9.png" alt="" /></a></li>
					<li><a href="##"><img src="images/sp10.png" alt="" /></a></li>
					<li><a href="##"><img src="images/sp11.png" alt="" /></a></li>
					<li><a href="##"><img src="images/sp1.png" alt="" /></a></li>
					<li><a href="##"><img src="images/sp2.png" alt="" /></a></li>
					<li><a href="##"><img src="images/sp3.png" alt="" /></a></li>
					<li><a href="##"><img src="images/sp4.png" alt="" /></a></li>
					<li><a href="##"><img src="images/sp5.png" alt="" /></a></li>
					<li><a href="##"><img src="images/sp6.png" alt="" /></a></li>
					<li><a href="##"><img src="images/sp7.png" alt="" /></a></li>
					<li><a href="##"><img src="images/sp8.png" alt="" /></a></li>
					<li><a href="##"><img src="images/sp9.png" alt="" /></a></li>
					<li><a href="##"><img src="images/sp10.png" alt="" /></a></li>
					<li><a href="##"><img src="images/sp11.png" alt="" /></a></li>
				</ul>
			</div>
			<!--carousel_inner-->
			<div id="sp-carouselNext"></div>
		</div>
		<!--sp-carousel-->
		<div class="clear"></div>

		<div id="rw">
			<h2>最近的工作</h2>
			<div class="h-border" id="hrw"></div>
			<div class="clear"></div>
			<ul id="rw-pro">
				<li><a class="rw-pp" title="&nbsp;" href="images/rw-1-big.jpg"
					rel="prettyPhoto[rw]"><ins>
							<img src="images/rw-1.jpg" alt="Project Title" />
							<div class="rw-pro-rb">
								<ins>
									<h6>PROJECT TITLE</h6>
								</ins>
							</div>
						</ins></a></li>

				<li><a class="rw-pp" title="&nbsp;" href="images/rw-2-big.jpg"
					rel="prettyPhoto[rw]"><ins>
							<img src="images/rw-2.jpg" alt="Project Title" />
							<div class="rw-pro-rb">
								<ins>
									<h6>PROJECT TITLE</h6>
								</ins>
							</div>
						</ins></a></li>

				<li><a class="rw-pp" title="&nbsp;" href="images/rw-3-big.jpg"
					rel="prettyPhoto[rw]"><ins>
							<img src="images/rw-3.jpg" alt="Project Title" />
							<div class="rw-pro-rb">
								<ins>
									<h6>PROJECT TITLE</h6>
								</ins>
							</div>
						</ins></a></li>

			</ul>
		</div>
		<!--rw-->

		<div id="testimonial">
			<div id="testimonial-rb"></div>
			<div class="h-border">
				<h2>CLIENT TESTIMONIALS</h2>
			</div>
			<!--hborder-->
			<div id="testimonial-slider">
				<div>
					<p>
						Quisque est nibh, pellentesque in ultricies vel, vulputate vel
						diam. Cras scelerisque blandit lacus, et rutrum mi congue in
						ultricies. <span class="testimonial-owner">Client Name 1,
							Position, <a href="##">Company</a>
						</span>
					</p>
				</div>

				<div>
					<p>
						Sodales dapibus sem, a malesuada erat tempor sit amet ut sem ipsum
						fusce auctor, sagittis purus eu tempor venenatis. <span
							class="testimonial-owner">Client Name 2, Position, <a
							href="##">Company</a></span>
					</p>
				</div>

				<div>
					<p>
						Praesent rutrum purus at magna viverra viverra. Phasellus dapibus
						faucibus sagittis. Proin ullamcorper aliquet molestie pretium. <span
							class="testimonial-owner">Client Name 3, Position, <a
							href="##">Company</a></span>
					</p>
				</div>
			</div>
			<!--testimonial-slider-->
		</div>
		<!--testimonial-->

		<div class="clear"></div>
	</div>
	<!--container-->

	<%@include file="social.jsp"%>


	<%@include file="footer.jsp"%>

</body>
</html>
