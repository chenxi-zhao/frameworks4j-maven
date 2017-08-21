<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Tregante Admin</title>
<!--                       CSS                       -->
<link rel="stylesheet" href="resources/css/reset.css" type="text/css" media="screen" />
<link rel="stylesheet" href="resources/css/style.css" type="text/css" media="screen" />
<link rel="stylesheet" href="resources/css/invalid.css" type="text/css" media="screen" />
<!--                       Javascripts                       -->
<script type="text/javascript" src="resources/scripts/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="resources/scripts/jquery-1.8.2.js"></script>
<script type="text/javascript" src="resources/scripts/simpla.jquery.configuration.js"></script>
<script type="text/javascript" src="resources/scripts/facebox.js"></script>
<script type="text/javascript" src="resources/scripts/jquery.wysiwyg.js"></script>
<script type="text/javascript" src="resources/scripts/jquery.datePicker.js"></script>
<script type="text/javascript" src="resources/scripts/jquery.date.js"></script>
<script type="text/javascript" src="resources/scripts/slider.action.js"></script>
<script type="text/javascript" src="resources/scripts/isNullCheck.js"></script>
<link rel="stylesheet" href="kindeditor/jslib/themes/default/default.css" />
<link rel="stylesheet" href="kindeditor/jslib/plugins/code/prettify.css" />
<script charset="utf-8" src="kindeditor/jslib/kindeditor.js"></script>
<script charset="utf-8" src="kindeditor/jslib/lang/zh_CN.js"></script>
<script charset="utf-8" src="kindeditor/jslib/plugins/code/prettify.js"></script>
<script>
		KindEditor.ready(function(K) {
			var editor1 = K.create('textarea[name="content"]', {
				cssPath : 'kindeditor/jslib/plugins/code/prettify.css',
				uploadJson : 'kindeditor/upload_json.jsp',
				width : '1000px',
				height: '400px',
				fileManagerJson : 'kindeditor/file_manager_json.jsp',
				allowFileManager : true,
				afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
				}
			});
			prettyPrint();
		});
</script>

</head>
<body onload="setAction()">
	<div id="body-wrapper" title="<%=session.getAttribute("detail")%>">
		<!-- Wrapper for the radial gradient background -->

		<jsp:include page="content/menubar.jsp" />

		<div id="main-content" title="<%=session.getAttribute("barMa")%>">
			
			
			
			<!-- Main Content Section with everything 这段没有实际意义-->
			<noscript>
				<!-- Show a notification if the user has disabled javascript -->
				<div class="notification error png_bg">
					<div>
						Javascript is disabled or is not supported by your browser. Please
						<a href="http://browsehappy.com/"
							title="Upgrade to a better browser">upgrade</a> your browser or <a
							href="http://www.google.com/support/bin/answer.py?answer=23852"
							title="Enable Javascript in your browser">enable</a> Javascript
						to navigate the interface properly. Download From <a
							href="http://www.exet.tk">exet.tk</a>
					</div>
				</div>
			</noscript>
			
			
			<%
				String prv = (String)session.getAttribute("barMa");
				if(prv == null){
					prv = "main";
				}
				String pro = (String)session.getAttribute("detail");
				if(pro == null ){
					pro = "";
				}
                String filename= "content/"+prv+"_"+pro+".jsp";
           %>
			
			<%
				if("main".equals(prv)){
					
			%>
				<%@include file="content/fast.jsp"%>
			<%
				}
			%>
			
			<jsp:include page='<%=filename%>'/>

			
		</div>
		<!-- End #main-content -->
	</div>
	
</body>

</html>
