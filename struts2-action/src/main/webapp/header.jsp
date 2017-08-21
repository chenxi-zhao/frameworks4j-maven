<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link href='http://fonts.googleapis.com/css?family=Crimson+Text:600'
          rel='stylesheet' type='text/css'/>
    <link href="css/prettyPhoto.css" rel="stylesheet" type="text/css"/>
    <link href="css/nivo-slider.css" rel="stylesheet" type="text/css"/>
    <link href="css/default.css" rel="stylesheet" type="text/css"/>
    <link href="css/reset.css" rel="stylesheet" type="text/css"/>
    <link href="style.css" rel="stylesheet" type="text/css"/>
    <link rel="icon" type="image/png" href="images/tregante-fav-icon.png"/>

    <script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
    <script type="text/javascript" src="js/jquery.easing.min.js"></script>
    <script type="text/javascript" src="js/jquery.plusslider-min.js"></script>
    <script type="text/javascript" src="js/jquery.bt.js"></script>
    <script type="text/javascript" src="js/jquery.validate.min.js"></script>
    <script type="text/javascript" src="js/jquery.ui.totop.js"></script>
    <script type="text/javascript" src="js/jquery.prettyPhoto.js"></script>
    <script type="text/javascript" src="js/config.js"></script>
    <script type="text/javascript" src="js/contact.js"></script>
    <script type="text/javascript" src="js/jquery.form.js"></script>
    <script type="text/javascript" src="js/jquery.nivo.slider.pack.js"></script>
    <script type="text/javascript" src="js/activeJudge.js"></script>
    <script type="text/javascript" src="js/User.js"></script>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
</head>
<body onload="setMenuAction()">
<div id="header">
    <div id="logo">
        <a href="index.jsp"> <span class="hidden">Tregante</span> <img
                src="images/logo.png" alt=""/>
        </a>
    </div>
    <!--logo-->

    <ul id="nav">
        <li><a href="index.jsp">主页</a></li>
        <li><a href="services.jsp">业务</a></li>
        <li><a href="project.jsp">项目</a>
            <!-- 				<ul> -->
            <!-- 					<li><a href="project-2col.jsp">2 COLUMNS</a></li> -->
            <!-- 					<li><a href="project-3col.jsp">3 COLUMNS</a></li> -->
            <!-- 					<li><a href="project-4col.jsp">4 COLUMNS</a></li> -->
            <!-- 					<li><a href="project-single.jsp">PORTFOLIO-SINGLE</a></li> -->
            <!-- 				</ul></li> -->
        <li><a href="blog.jsp">博客</a>
        <li><a href="contact.jsp">联系</a></li>
        <li><a href="about.jsp">关于</a></li>
    </ul>

    <!-- 		登录操作 -->

    <%
			String ss = (String) session.getAttribute("loginMsg");

			if ("success".equals(ss) == false) {
		%>
		<div id="search">
			<input type="text" id="searchbox" name="user.uname" value='Username'
				onfocus="if (this.value==this.defaultValue) this.value='';"
				onblur="if (this.value=='') this.value='Username'" /> <input
				type="text" id="searchbox" name="user.upass" value='Password'
				onfocus="if (this.value==this.defaultValue) this.value='';"
				onblur="if (this.value=='') this.value='Password'" /> <input
				type="submit" value="L" id="search-bt" onclick="UserLogin()" />
		</div>
		<%
			} else {
		%>
		<div id="loginpro" style="display: block;">
			${user.uname }__${user.upass}<input type="submit" value="o"
				id="search-bt" onclick="UserLoginOut()" />
		</div>
		<%
			}
		%>
		<div id="loginpro">
			<input type="submit" value="o" id="search-bt"
				onclick="UserLoginOut()" />
		</div>

		<div class="clear"></div>
		<table id="tagline-tb">
			<tr>
				<td>
					<div id="tagline">
						YOYOYOYOYOYOOYOYOYYOYOYOYOYOYOY!!
						<div id="tagline-right"></div>
					</div> <!--tagline-->
				</td>
			</tr>
		</table>
		<div class="clear"></div>
	</div>
	<!--header-->


</body>
</html>