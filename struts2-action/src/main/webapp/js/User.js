function UserLogin() {
	var login = $("#search>input");
	$.ajax({
		url : "UserRequest!UserLogin.action",// 后台处理程序
		type : "post", // 数据发送方式
		dataType : "json",// 接收数据格式
		data : "user.uname=" + login[0].value + "&user.upass="
				+ login[1].value,// 要传递的数据
		// 回传函数
		timeout : 20000,// 设置请求超时时间（毫秒）。
		error : function() {// 请求失败时调用函数。
			alert("服务器连接失败");
		},

		success : function(data) { // 请求成功后回调函数。如果dataType是json不就需要再转换为json对象
			var uname = data.user.uname;
			var upass = data.user.upass;
			loginSu(uname,upass);
		}
	})
}
function loginSu(uname,upass){
	document.getElementById("search").style.display = 'none';
	document.getElementById("loginpro").innerHTML =uname+"_"+upass+"<input	type='submit' value='o' id='search-bt'  onclick='UserOut()'/>";
	document.getElementById("loginpro").style.display = 'block';
}