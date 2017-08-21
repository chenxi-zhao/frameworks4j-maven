<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>

	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    	<link rel="stylesheet" href="jslib/themes/default/default.css" />
		<script charset="utf-8" src="jslib/kindeditor-min.js"></script>
		<script charset="utf-8" src="jslib/lang/zh_CN.js"></script>
       <script>
        var editor;
			KindEditor.ready(function(K) {
				editor = K.create('textarea[name="content"]', {
					allowFileManager : true
				});
				
			});
        </script>
    </head>
    
    <body>
    	<form action="AddNewsServlet" method="post">
        	newsTitle:<input type="text" name="title"/>
            <br/>
            newsContent:<textarea name="content" style="width:800px;height:400px;visibility:hidden;">KindEditor</textarea>
        	<input type="submit"/>
        </form>
    </body>

</html>