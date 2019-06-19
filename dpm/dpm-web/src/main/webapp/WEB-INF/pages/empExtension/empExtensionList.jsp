<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录信息监控</title>
<script type="text/javascript" src="/dpm/scripts/jquery-1.8.3.min.js"></script>
<link rel="stylesheet" type="text/css" href="/dpm/scripts/jquery-easyui-1.4/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="/dpm/scripts/jquery-easyui-1.4/themes/icon.css" />
<script type="text/javascript" src="/dpm/scripts/jquery-easyui-1.4/jquery.easyui.min.js"></script>
<script type="text/javascript" src="/dpm/scripts/jquery-easyui-1.4/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="/dpm/scripts/common/common.js"></script>
</head>
<script type="text/javascript">
	$(function(){
		$('#search').searchbox({
			width : 180,
		    searcher : doSearch,
		    prompt : '请输入工号'
		});
		$("#loginInfogrid").datagrid({
			toolbar:'#tb',
			columns:[[{
			        	title:'工号',
			        	field:'empCode',
			        	width:80,
			        	align:'center',
			        },{
			        	title:'在线状态',
			        	field:'empStatus',
			        	width:80,
			        	align:'center'
			        },{
			        	title:'设备号',
			        	field:'deviceToken',
			        	width:150,
			        	align:'center'
			        },{
			        	title:'登录时间',
			        	field:'loginTime',
			        	width:150,
			        	align:'center',
			        	formatter:formatDate
			        },{
			        	title:'设备类型',
			        	field:'osType',
			        	width:100,
			        	align:'center'
			        },{
			        	title:'app版本',
			        	field:'appVersion',
			        	width:100,
			        	align:'center'
			        },{
			        	title:'机型',
			        	field:'phoneModel',
			        	width:100,
			        	align:'center'
			        },{
			        	title:'操作系统',
			        	field:'osVersion',
			        	width:100,
			        	align:'center'
			        },{
			        	title:'mac地址',
			        	field:'phoneMac',
			        	width:150,
			        	align:'center'
			        }
				]],
				fit:true,
				border:false,
				fitColumns:true,
				striped:true,
				rownumbers:true,
				pagination:true,
				singleSelect:true,
				pageNumber:1,
				pageSize:20,
				pageList:[20,30,50],
				url:'${pageContext.request.contextPath}/dpmManage/queryLoginInfo.action',
		});
		
		// 点击搜索
		function doSearch(){
			// 校验输入的工号
			var searchVal = $("#search").val();
			if(searchVal == ''){
				$.messager.alert('警告','搜索条件不能为空！','warning');
				return;
			}
			if(searchVal.length != 6) {
				$.messager.alert('警告','工号必须为6位！','warning');
				return;
			}
			
			$('#loginInfogrid').datagrid('load',{
				empCode:searchVal
			});
		}
		
		function formatDate(val,row){
			var now = new Date(val);
			return now.format("yyyy-MM-dd hh:mm:ss");
		}
	});
	
</script>
<body>
	<div id="tb">  
		<input id="search">
	</div> 
	<div id="loginInfogrid"></div>
</body>
</html>