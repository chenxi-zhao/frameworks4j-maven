function setAction() {
	var cur = $("#main-content").attr("title");
	var curde = $("#body-wrapper").attr("title");
	var li = $("#main-nav>li");
	var aa = li.find("a");

	if (cur == "member") {
		aa[0].className += " current";
	} else if (cur == "blog") {
		aa[1].className += " current";
		$("#main-nav>li ul:eq(0)").slideToggle(0);
		if(curde == "write"){
			aa[2].className += " current";
		}else if(curde == "manage"){
			aa[3].className += " current";
		}else if(curde == "comment"){
			aa[4].className += " current";
		}
	}else if(cur == "project"){
		aa[5].className += " current";
		$("#main-nav>li ul:eq(1)").slideToggle(0);
		if(curde == "add"){
			aa[6].className += " current";
		}else if(curde == "list"){
			aa[7].className += " current";
		}
	}else if(cur == "service"){
		aa[8].className += " current";
		$("#main-nav>li ul:eq(2)").slideToggle(0);
		if(curde == "service"){
			aa[9].className += " current";
		}
	}else if(cur == "group"){
		aa[10].className += " current";
		$("#main-nav>li ul:eq(3)").slideToggle(0);
		if(curde == "advertise"){
			aa[11].className += " current";
		}else if(curde == "ability"){
			aa[12].className += " current";
		}else if(curde == "work"){
			aa[13].className += " current";
		}else if(curde == "excellent"){
			aa[14].className += " current";
		}else if(curde == "about"){
			aa[15].className += " current";
		}
	}
}