<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>移动办公后台管理系统</title>

<STYLE>BODY {
	SCROLLBAR-ARROW-COLOR: #ffffff; SCROLLBAR-BASE-COLOR: #dee3f7
}
</STYLE>
<LINK href="/dpm/css/Font.css" type="text/css" rel="stylesheet">
<LINK href="/dpm/css/Style.css" type="text/css" rel="stylesheet">
<!-- 导入jquery核心类库 -->
<script type="text/javascript" src="/dpm/scripts/jquery-easyui-1.4/jquery.min.js"></script>
<!-- 导入easyui类库 -->
<link id="easyuiTheme" rel="stylesheet" type="text/css"
	href="/dpm/scripts/jquery-easyui-1.4/themes/default/easyui.css">
<script type="text/javascript" src="/dpm/scripts/jquery-easyui-1.4/locale/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" type="text/css" href="/dpm/scripts/jquery-easyui-1.4/themes/icon.css">
<script type="text/javascript" src="/dpm/scripts/jquery-easyui-1.4/jquery.easyui.min.js"></script>
<!-- 导入ztree类库 -->
<script language="JavaScript" src="/dpm/scripts/jquery.ztree.all-3.5.js"></script>
<link type="text/css" rel="stylesheet" href="/dpm/css/menu.css" />
<link rel="stylesheet" type="text/css" href="/dpm/css/zTreeStyle.css" />

<script type="text/javascript">
	// 初始化ztree菜单
	$(function() {
		var setting = {
			data : {
				simpleData : { // 简单数据 
					enable : true,
					idKey: "id",
	                pIdKey: "pid"
				}
			},
			callback : {
				onClick : onClick
			}
		};
		
		// 功能菜单加载
		$.ajax({
			url : '${pageContext.request.contextPath}/json/menu.json',
			type : 'POST',
			dataType : 'text',
			success : function(data) {
				var zNodes = eval("(" + data + ")");
				$.fn.zTree.init($("#treeMenu"), setting, zNodes);
	            var zTree = $.fn.zTree.getZTreeObj("treeMenu");//获取ztree对象  
                var node = zTree.getNodeByParam('name', '应用商店');//获取name为应用商店的node
                zTree.selectNode(node);//选择点  
                zTree.setting.callback.onClick(null, zTree.setting.treeId, node);//调用
			},
			error : function(msg) {
				alert('菜单加载异常!');
			}
		});
		
	});

	//使用ztree树型菜单的选择，是否加载选项卡
	function onClick(event, treeId, treeNode, clickFlag) {
		// 判断树菜单节点是否含有 page属性
		if (treeNode.page!=undefined && treeNode.page!= "") {
			if ($("#tabs").tabs('exists', treeNode.name)) {// 判断tab是否存在
				$('#tabs').tabs('select', treeNode.name); // 切换tab
			} else {
				// 开启一个新的tab页面
				var content = '<div style="width:100%;height:100%;overflow:hidden;">'
						+ '<iframe src="'
						+ treeNode.page
						+ '" scrolling="auto" style="width:100%;height:100%;border:0;" ></iframe></div>';

				$('#tabs').tabs('add', {
					title : treeNode.name,
					content : content,
					closable : true
				});
			}
		}
	}

	/*******顶部特效 *******/
	/**
	 * 更换EasyUI主题的方法
	 * @param themeName
	 * 主题名称
	 */
	changeTheme = function(themeName) {
		var $easyuiTheme = $('#easyuiTheme');
		var url = $easyuiTheme.attr('href');
		var href = url.substring(0, url.indexOf('themes')) + 'themes/'
				+ themeName + '/easyui.css';
		$easyuiTheme.attr('href', href);
		var $iframe = $('iframe');
		if ($iframe.length > 0) {
			for ( var i = 0; i < $iframe.length; i++) {
				var ifr = $iframe[i];
				$(ifr).contents().find('#easyuiTheme').attr('href', href);
			}
		}
	};
	// 退出登录
	function logoutFun() {
		$.messager.confirm('系统提示','您确定要退出本次登录吗?',function(isConfirm) {
			if (isConfirm) {
				location.href = '${pageContext.request.contextPath }/dpmManage/manage_logout.action';
			}
		});
	}
	// 返回首页
	function loadingFun() {
		window.location.reload();//刷新当前页面
	}
</script>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',border:false,split:true"
		style="height: 80px;background: #373C64;overflow:hidden;">
		<div style="float:left;margin-left: 2%;">
			<img src="${pageContext.request.contextPath }/images/logo-main.png">
		</div>
		<div style="float:right;margin-right: 1%;">
			<div id="sessionInfoDiv" style="padding: 5px;">
				<span id="online"
					style="background: url(${pageContext.request.contextPath }/images/online.png) no-repeat left;padding-left:18px;margin-left:3px;font-size:11pt;color:#DDDDDD;">
					<strong>${requestScope.loginName}</strong> 欢迎您!
				</span>
				<div style="margin-top:5px;">
					<FONT color=#DDDDDD size="2"> <b> <SCRIPT
								language=JavaScript>
					<!--
						tmpDate = new Date();
						date = tmpDate.getDate();
						month = tmpDate.getMonth() + 1;
						year = tmpDate.getFullYear();
						document.write(year);
						document.write("年");
						document.write(month);
						document.write("月");
						document.write(date);
						document.write("日 ");
	
						myArray = new Array(6);
						myArray[0] = "星期日"
						myArray[1] = "星期一"
						myArray[2] = "星期二"
						myArray[3] = "星期三"
						myArray[4] = "星期四"
						myArray[5] = "星期五"
						myArray[6] = "星期六"
						weekday = tmpDate.getDay();
						if (weekday == 0 | weekday == 6) {
							document.write(myArray[weekday])
						} else {
							document.write(myArray[weekday])
						};
					// -->
					</SCRIPT>
					</b>
					</FONT>
				</div>
			</div>
			<div>
				<a href="javascript:void(0);" class="easyui-menubutton"
					data-options="menu:'#layout_north_pfMenu',iconCls:'icon-ok'"><font color="#999">更换皮肤</font></a>
				<a href="javascript:void(0);" class="easyui-menubutton"
					data-options="menu:'#layout_north_kzmbMenu',iconCls:'icon-help'"><font color="#999">控制面板</font></a>
			</div>
			<div id="layout_north_pfMenu" style="width: 120px; display: none;">
				<div onclick="changeTheme('default');">bootstrap</div>
				<div onclick="changeTheme('gray');">gray</div>
				<div onclick="changeTheme('black');">black</div>
				<div onclick="changeTheme('bootstrap');">default</div>
				<div onclick="changeTheme('metro');">metro</div>
			</div>
			<div id="layout_north_kzmbMenu" style="width: 100px; display: none;">
				<div data-options="iconCls:'icon-help'" onclick="showAbout();">联系管理员</div>
				<div class="menu-sep"></div>
				<div data-options="iconCls:'icon-reload'" onclick="loadingFun();">返回首页</div>
				<div data-options="iconCls:'icon-back'" onclick="logoutFun();">退出系统</div>
			</div>
		</div>
	</div>
	<div data-options="region:'west',split:true,title:'菜单导航',border:false"
			style="width:200px">
			<div class="easyui-accordion" fit="true" border="false">
				<div title="系统管理" data-options="iconCls:'icon-mini-add'" style="overflow:auto">
					<ul id="treeMenu" class="ztree"></ul>
				</div>
			</div>
		</div>
		<div data-options="region:'center',border:false,split:true">
			<div id="tabs" fit="true" class="easyui-tabs" border="false">
			</div>
		</div>
		<div data-options="region:'south',border:false,split:true"
			style="background-color: #373C64;height:30px;overflow:hidden;padding:4px;">
			<table style="width: 100%;">
				<tbody align="center">
					<tr>
						<td>
							<div style="color: #999; font-size: 8pt;">
								Copyright © 
								<SCRIPT language=JavaScript>
									document.write(new Date().getFullYear());
								</SCRIPT> 
								德邦物流股份有限公司. All rights reserved. | Powered by <a href="http://www.deppon.com/" target='_blank'><font color="#4682B4">deppon.com</font></a>
							</div>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
</body>
</html>