function setMenuAction() {
	var url = this.location.href
	var pos = url.lastIndexOf("/");
	if (pos == -1) {
		pos = url.lastIndexOf("\\")
	}
	var filename = url.substr(pos + 1);
	var divmaps = $("#nav>li");
	var tagLine = $("table")[0];
	switch (filename) {
	case "index.jsp":
		divmaps[0].className = 'active';
		tagLine.style.display = 'none';
		break;
	case "services.jsp":
		divmaps[1].className = 'active';
		break;
	case "project.jsp":
		divmaps[2].className = 'active';
		break;
	case "project-2col.jsp":
		divmaps[2].className = 'active';
		break;
	case "project-3col.jsp":
		divmaps[2].className = 'active';
		break;
	case "project-4col.jsp":
		divmaps[2].className = 'active';
		break;
	case "project-single.jsp":
		divmaps[2].className = 'active';
		break;
	case "blog.jsp":
		divmaps[3].className = 'active';
		break;
	case "blog-single.jsp":
		divmaps[3].className = 'active';
		break;
	case "contact.jsp":
		divmaps[4].className = 'active';
		break;
	case "about.jsp":
		divmaps[5].className = 'active';
		break;
	default:
		divmaps[0].className = 'active';
		break;
	}
}