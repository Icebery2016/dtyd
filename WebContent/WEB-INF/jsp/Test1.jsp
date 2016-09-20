<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="keywords" content="jquery,ui,easy,easyui,web">
<meta name="description" content="easyui help you build youer web page easily!">

<title>项目管理系统</title>
	<link href="../css/default.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" type="text/css" href="../js/jquery-easyui-1.5/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../js/jquery-easyui-1.5/themes/icon.css">
	<script type="text/javascript" src="../js/jquery-easyui-1.5/jquery.min.js"></script>
	<script type="text/javascript" src="../js/jquery-easyui-1.5/jquery.easyui.min.js"></script>
    <script type="text/javascript">
    $(function(){
    	InitLeftMenu();
    	tabClose();
    	tabCloseEven();
    })

    //初始化左侧
    function InitLeftMenu() {
    	$("#nav").accordion({animate:false});//为id为nav的div增加手风琴效果，并去除动态滑动效果
        $.each(_menus.menus, function(i, n) {//$.each 遍历_menu中的元素
    		var menulist ='';
    		menulist +='<ul>';
            $.each(n.menus, function(j, o) {
    			menulist += '<li><div><a ref="'+o.menuid+'" href="#" rel="' + o.url + '" ><span class="icon '+o.icon+'" >&nbsp;</span><span class="nav">' + o.menuname + '</span></a></div></li> ';
            })
    		menulist += '</ul>';

    		$('#nav').accordion('add', {
                title: n.menuname,
                content: menulist,
                iconCls: 'icon ' + n.icon
            });
        });

    	$('.easyui-accordion li a').click(function(){//当单击菜单某个选项时，在右边出现对用的内容
    		var tabTitle = $(this).children('.nav').text();//获取超链里span中的内容作为新打开tab的标题

    		var url = $(this).attr("rel");
    		var menuid = $(this).attr("ref");//获取超链接属性中ref中的内容
    		var icon = getIcon(menuid,icon);

    		addTab(tabTitle,url,icon);//增加tab
    		$('.easyui-accordion li div').removeClass("selected");
    		$(this).parent().addClass("selected");
    	}).hover(function(){
    		$(this).parent().addClass("hover");
    	},function(){
    		$(this).parent().removeClass("hover");
    	});

    	//选中第一个
    	var panels = $('#nav').accordion('panels');
    	var t = panels[0].panel('options').title;
        $('#nav').accordion('select', t);
    }
    //获取左侧导航的图标
    function getIcon(menuid){
    	var icon = 'icon ';
    	$.each(_menus.menus, function(i, n) {
    		 $.each(n.menus, function(j, o) {
    		 	if(o.menuid==menuid){
    				icon += o.icon;
    			}
    		 })
    	})

    	return icon;
    }

    function addTab(subtitle,url,icon){
    	if(!$('#tabs').tabs('exists',subtitle)){
    		$('#tabs').tabs('add',{
    			title:subtitle,
    			content:createFrame(url),
    			closable:true,
    			icon:icon
    		});
    	}else{
    		$('#tabs').tabs('select',subtitle);
    		$('#mm-tabupdate').click();
    	}
    	tabClose();
    }
	 var _menus = {
		                 "menus":[
						{"menuid":"1","icon":"icon-sys","menuname":"项目管理",
						    "menus":[
									{"menuid":"12","menuname":"网页","icon":"icon-page","url":"menu1/treegrid.html"},
									{"menuid":"13","menuname":"类","icon":"icon-class","url":"menu1/class.html"},
									{"menuid":"14","menuname":"菜单","icon":"icon-role","url":"demo2.html"},
									{"menuid":"15","menuname":"菜单","icon":"icon-set","url":"demo.html"},
									{"menuid":"16","menuname":"菜单","icon":"icon-log","url":"demo1.html"}
								    ]},
						{"menuid":"2","icon":"icon-sys","menuname":"项目设计",
							"menus":[{"menuid":"21","menuname":"项目分析","icon":"icon-nav","url":"menu2/tree2.html"},
									{"menuid":"22","menuname":"菜单","icon":"icon-nav","url":"demo1.html"}
								]
						},{"menuid":"56","icon":"icon-sys","menuname":"菜单",
							"menus":[{"menuid":"31","menuname":"菜单","icon":"icon-nav","url":"demo1.html"},
									{"menuid":"32","menuname":"菜单","icon":"icon-nav","url":"demo2.html"}
								]
						},{"menuid":"28","icon":"icon-sys","menuname":"菜单",
							"menus":[{"menuid":"41","menuname":"菜单","icon":"icon-nav","url":"demo.html"},
									{"menuid":"42","menuname":"菜单","icon":"icon-nav","url":"demo1.html"},
									{"menuid":"43","menuname":"菜单","icon":"icon-nav","url":"demo2.html"}
								]
						},{"menuid":"39","icon":"icon-sys","menuname":"菜单",
							"menus":[{"menuid":"51","menuname":"菜单","icon":"icon-nav","url":"demo.html"},
									{"menuid":"52","menuname":"菜单","icon":"icon-nav","url":"demo1.html"},
									{"menuid":"53","menuname":"菜单","icon":"icon-nav","url":"demo2.html"}
								]
						}
				]};
 
		
    </script>
    </head>
    <body class="easyui-layout" style="overflow-y: hidden"  scroll="no">
<noscript>
    <div style=" position:absolute; z-index:100000; height:2046px;top:0px;left:0px; width:100%; background:white; text-align:center;"> <img src="images/noscript.gif" alt='抱歉，请开启脚本支持！' /> </div>
    </noscript>
<div region="north" split="true" border="false" style="overflow: hidden; height: 30px;
        background: url(images/layout-browser-hd-bg.gif) #7f99be repeat-x center 50%;
        line-height: 20px;color: #fff; font-family: Verdana, 微软雅黑,黑体"> <span style="float:right; padding-right:20px;" class="head">欢迎 管理员 <a href="#" id="editpass">修改密码</a> <a href="#" id="loginOut">安全退出</a></span> <span style="padding-left:10px; font-size: 16px; "><img src="images/blocks.gif" width="20" height="20" align="absmiddle" />项目管理系统</span> </div>
<div region="south" split="true" style="height: 30px; background: #D2E0F2; ">
      <div class="footer">版权所有，翻版必究</div>
    </div>
<div region="west" hide="true" split="true" title="导航菜单" style="width:180px;" id="west">
      <div id="nav" class="easyui-accordion" fit="true" border="false"> 

    <!--  导航内容 --> 
    
  </div>
    </div>
<div id="mainPanle" region="center" style="background: #eee; overflow-y:hidden">
      <div id="tabs" class="easyui-tabs"  fit="true" border="false" >
    <div title="欢迎使用" style="padding:20px;overflow:hidden; color:red; " >
          <h1 style="font-size:24px;">欢迎使用项目管理系统</h1>
        </div>
  </div>
    </div>
<div region="east" title="其他" split="true" style="width:180px;overflow:hidden;">
      <div class="easyui-calendar"></div>
    </div>


</body>
</html>