<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN""http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Tregante Admin</title>
<!--                       CSS                       -->
<!-- Reset Stylesheet -->
<link rel="stylesheet" href="resources/css/reset.css" type="text/css"
	media="screen" />
<!-- Main Stylesheet -->
<link rel="stylesheet" href="resources/css/style.css" type="text/css"
	media="screen" />
<!-- Invalid Stylesheet. This makes stuff look pretty. Remove it if you want the CSS completely valid -->
<link rel="stylesheet" href="resources/css/invalid.css" type="text/css"
	media="screen" />
<!--                       Javascripts                       -->
<!-- jQuery -->
<script type="text/javascript"
	src="resources/scripts/jquery-1.3.2.min.js"></script>
<!-- jQuery Configuration -->
<script type="text/javascript"
	src="resources/scripts/simpla.jquery.configuration.js"></script>
<!-- Facebox jQuery Plugin -->
<script type="text/javascript" src="resources/scripts/facebox.js"></script>
<!-- jQuery WYSIWYG Plugin -->
<script type="text/javascript" src="resources/scripts/jquery.wysiwyg.js"></script>
</head>

<body id="login">
	<div id="login-wrapper" class="png_bg">
		<div id="login-top">
			<h1>Tregante Admin</h1>
			<a href="#"><img id="logo" src="resources/images/logo.png"
				alt="Simpla Admin logo" /></a>
		</div>
		<!-- End #logn-top -->
		<div id="login-content">
			<form action="Member!MemberLogin.action" method="post">


				<c:choose>
					<c:when test="${sessionScope.isLogin == false}">
						<div class="notification information png_bg">
							<a href="#" class="close"><img
								src="resources/images/icons/cross_grey_small.png"
								title="Close this notification" alt="close" /></a>
							<div>Username or Password Error</div>
						</div>
					</c:when>
				</c:choose>


				<p>
					<label>Username</label> <input class="text-input"
						name="member.name" type="text" />
				</p>
				<div class="clear"></div>
				<p>
					<label>Password</label> <input class="text-input"
						name="member.pass" type="password" />
				</p>
				<div class="clear"></div>
				<p id="remember-password">
					<input type="checkbox" /> Remember me
				</p>
				<div class="clear"></div>
				<p>
					<input class="button" type="submit" value="Sign In" />
				</p>
			</form>
		</div>
		<!-- End #login-content -->
	</div>
	<!-- End #login-wrapper -->
</body>
</html>
