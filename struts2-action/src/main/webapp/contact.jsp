<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title>Tregante</title>
</head>

<body>
  <%@include file="header.jsp" %>
    
    <div id="container-inner">
    	<ul id="breadcrumb-wrapper">
        
	    	<li>
	            <a href="index.jsp">
                <ins>
				    <div class="br-left"></div>
				    <div class="br-mid">
				    	主页
				    </div><!--br-mid-->
				    <div class="br-right">
				    </div><!--br-right-->
                </ins>    
		        </a>
            </li>  
            
            <li>
	            <a class="active" href="contact.jsp">
                <ins>
				    <div class="br-left"></div>
				    <div class="br-mid">
				    	联系
				    </div><!--br-mid-->
				    <div class="br-right">
				    </div><!--br-right-->
                </ins>    
		        </a>
            </li>
            <li id="page-title">
          		联系
        	</li><!--page-title-->
        </ul><!--breadcrumb-wrapper-->
        <div id="inner-border"></div>
    	<div class="clear"></div>
        	
        <div id="contentwrap-inner">	
            <div id="content-left">
				<form id="contactform" action="processForm.php" method="post">
					<table>
						<tr>
							<td><label for="name"></label></td>
							<td><input class="textbox" type="text" id="name" name="name"
								value='Name'
								onfocus="if (this.value==this.defaultValue) this.value='';"
								onblur="if (this.value=='') this.value='Name'" /></td>
						</tr>

						<tr>
							<td><label for="email"></label></td>
							<td><input class="textbox" type="text" id="email"
								name="email" value="Email"
								onfocus="if (this.value==this.defaultValue) this.value='';"
								onblur="if (this.value=='') this.value='Email'" /></td>
						</tr>

						<tr>
							<td><label for="message"></label></td>
							<td><textarea id="message" name="message"
									onfocus="if (this.value==this.defaultValue) this.value='';"
									onblur="if (this.value=='') this.value='Message'">Message</textarea></td>
						</tr>
					</table>
					<input name="submit" type="submit" id="send"
								value="SEND" />
				</form>
				<div id="response"></div>
      
      </div><!--content-left-->
            
            <div id="sidebar">
            	<div class="sidebar-border"><h3>地址</h3></div><!--sidebar-border-->
                <div class="clear"></div>
                <p class="contactSide">西南大学橘园
	                <br />
	  				   中国*重庆
	                <br />      
	                                   邮政编码: 400715
	                <br />
                </p> 
                
                <div style="margin-top:18px;" class="sidebar-border"><h3>电话</h3></div><!--sidebar-border-->
                <div class="clear"></div>
                <p class="contactSide">13627673706</p> 
                
                <div style="margin-top:18px;" class="sidebar-border"><h3>邮箱</h3></div><!--sidebar-border-->
                <div class="clear"></div>
                <br />
                <p id="contactSide">you@yourdomain.com</p> 
	               
            </div><!--sidebar-->
            <div class="clear"></div>
            
        </div><!--contentwrap-inner--> 
    </div><!--container-inner-->
    
    <%@include file="social.jsp" %>
   
    
   <%@include file="footer.jsp" %>

</body>
</html>
