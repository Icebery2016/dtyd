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
	<!-- 打开tab页面的script；注#tabs，是home子页面的id -->
	<script type="text/javascript">
	function addTab(title, url){
		if ($('#tabs').tabs('exists', title)){
			$('#tabs').tabs('select', title);
		} else {
			var content = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
			$('#tabs').tabs('add',{
				title:title,
				content:content,
				closable:true
			});
		}
	}
	</script>
</head>
<body class="easyui-layout" style="overflow-y: hidden"  scroll="no">
<!-- 顶部，北 -->
<div region="north" split="true" border="false" style="overflow: hidden; height: 30px;
        background: url(../images/layout-browser-hd-bg.gif) #7f99be repeat-x center 50%;
        line-height: 20px;color: #fff; font-family: Verdana, 微软雅黑,黑体"> <span style="float:right; padding-right:20px;" class="head">欢迎 管理员 <a href="#" id="editpass">修改密码</a> <a href="#" id="loginOut">安全退出</a></span> <span style="padding-left:610px; font-size: 16px; "><img src="../images/blocks.gif" width="20" height="20" align="absmiddle""/>项目管理系统</span> </div>
<!-- 底部，南 -->
<div region="south" split="true" style="height: 30px; background: #D2E0F2; ">
      <div class="footer">版权所有，翻版必究</div>
    </div>
<!-- 左侧导航栏，西 -->  
<div region="west" hide="true" split="true" title="导航菜单" style="width:180px;" id="west">
     <div id="nav" class="easyui-accordion" fit="true" border="false"> 

           		 <div  title="项目管理" style="overflow:auto;padding:10px;">	
       			 	<ul>
						<li>
							<div class="point">
							<a href="javascirpt:;"  name='icon-reload' onclick="addTab('运维周报','http://www.baidu.com')">
							<span class="icon-reload">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
							<span class="nav">运维周报</span></a>
							</div>
						</li>
						<li>
							<div class="point">
							<a href="javascirpt:;" rel="index.jsp" name='icon-reload' onclick="clickMe(this)">
							<span class="icon-reload">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
							<span class="nav">运维月报</span></a>
							</div>
						</li>
					</ul>
					</div>
				    <div title="运维项目"  style="overflow:auto;">
       				 <ul>
						<li>
							<div>
							<a href="javascirpt:;" rel="index.jsp" name='icon-reload' onclick="clickMe(this)">
							<span class="icon-reload">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
							<span class="nav">运维记录</span></a>
							</div>
						</li>
						<li>
							<div>
							<a href="javascirpt:;" rel="index.jsp" name='icon-reload' onclick="clickMe(this)">
							<span class="icon-reload">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
							<span class="nav">优化记录</span></a>
							</div>
						</li>
					</ul>
    			</div>
    			<div title="设备管理"  style="overflow:auto;">
       				 <ul>
						<li>
							<div>
							<a href="javascirpt:;" rel="index.jsp" name='icon-reload' onclick="clickMe(this)">
							<span class="icon-reload">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
							<span class="nav">医保系统1</span></a>
							</div>
						</li>
						<li>
							<div>
							<a href="javascirpt:;" rel="index.jsp" name='icon-reload' onclick="clickMe(this)">
							<span class="icon-reload">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
							<span class="nav">医保系统2</span></a>
							</div>
						</li>
					</ul>
    			</div>
		
    			<div title="Tree Menu" >
        		<ul id="tt1" class="easyui-tree">
         			   <li>
              			  <span>Folder1</span>
                <ul>
                    <li>
                        <span>Sub Folder 1</span>
                        <ul>
                            <li><span>File 11</span></li>
                            <li><span>File 12</span></li>
                            <li><span>File 13</span></li>
                        </ul>
                    </li>
                    <li><span>File 2</span></li>
                    <li><span>File 3</span></li>
                </ul>
            </li>
            <li><span>File2</span></li>
        </ul>
    </div>
    <!-- 末尾增加空白的panel，解决默认所有panel都关闭状态 -->
    <div title="" selected style="overflow:auto;"></div>
</div>	 
  	  </div>
    </div>
    
<!-- 中间内容区域 -->
<div id="mainPanle" region="center" style="background: #eee; overflow-y:hidden">
      <div id="tabs" class="easyui-tabs"  fit="true" border="false" >
    <div title="欢迎使用" style="padding:20px;overflow:hidden; color:red; " >
          <h1 style="font-size:24px;">欢迎使用项目管理系统</h1>
        </div>
  </div>
    </div>
   
 <!-- 右边其他，东 -->   
<div region="east" title="其他" split="true" style="width:180px;overflow:hidden;">
      <div class="easyui-calendar"></div>
    </div>


</body>
</html>