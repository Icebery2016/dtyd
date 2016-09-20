var menuLabel = [ 'JS语言基础', 'JQuery组件' ];
var menuData = [
		[ new MenuOption('语言', 'jsp/fundamental/lang.jsp'),
				new MenuOption('面向对象', 'jsp/fundamental/obj.jsp') ],
		[ new MenuOption('核心功能', 'jsp/jquery/core.jsp'),
				new MenuOption('实用功能', 'jsp/jquery/util.jsp'),
				new MenuOption('动画效果', 'jsp/jquery/effects.jsp') ] ];

function MenuOption(label, uri) {
	this.label = label;
	this.uri = uri;
}

function initMenu(i, j) {
	$.each(menuLabel,
			function(index, value) {
				$(
						"<li><a href='" + menuData[index][0].uri + "'>" + value
								+ "</a></li>").appendTo("#mainNav");
			});

	$.each(menuData[i], function() {
		$("<li><a href='" + this.uri + "'>" + this.label + "</a></li>")
				.appendTo("#sidebar ul");
	});

	$("#mainNav li a:eq(" + i + ")").attr("class", "active");

	$("#sidebar ul li a:eq(" + j + ")").attr("class", "active");

	$(
			"<a>" + menuLabel[i] + "</a> &raquo; <a class='active'>"
					+ menuData[i][j].label + "</a>").appendTo("#crumb");

}
