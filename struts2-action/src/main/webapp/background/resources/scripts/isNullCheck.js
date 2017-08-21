function $Id(element){
	return element = document.getElementById(element);
}
function $Name(element){
	return element = document.getElementByName(element);
}

function isNull(inputId,spanId){
	
	var str = $Id(inputId).value;
	if(""==str){
		$Id(spanId).innerHTML = '不能为空';
		$Id(spanId).style.display = 'block';
	}
}

function getFocus(spanId){
	$Id(spanId).style.display='none';
}

function passCheck(passId, rePassId, repassnoti){
	var pass = $Id(passId).value;
	var repass = $Id(rePassId).value;
	if(pass != repass){
		$Id(repassnoti).innerHTML = '密码不同请重新输入';
		$Id(repassnoti).style.display = 'block';
	}
}
