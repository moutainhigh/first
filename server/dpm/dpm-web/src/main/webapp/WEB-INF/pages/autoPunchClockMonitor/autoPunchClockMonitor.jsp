<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>自动打卡监控</title>
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
		$("#grid").datagrid({
			toolbar:'#tb',
			columns:[[{
			        	title:'工号',
			        	field:'empCode',
			        	width:100,
			        	align:'center'
			        },{
			        	title:'状态',
			        	field:'status',
			        	width:100,
			        	align:'center',
			        	formatter:statusFormat
			        },{
			        	title:'公司内',
			        	field:'within',
			        	width:100,
			        	align:'center',
			        	formatter:withinFormat
			        },{
			        	title:'自动/手动',
			        	field:'auto',
			        	width:100,
			        	align:'center',
			        	formatter:autoFormat
			        },{
			        	title:'错误信息',
			        	field:'errorMsg',
			        	width:200,
			        	align:'center',
		        		formatter:formatMsg
			        },{
			        	title:'网络',
			        	field:'network',
			        	width:100,
			        	align:'center'
			        },{
			        	title:'ip',
			        	field:'ip',
			        	width:100,
			        	align:'center'
			        },{
			        	title:'系统',
			        	field:'osType',
			        	width:100,
			        	align:'center'
			        },{
			        	title:'应用版本',
			        	field:'appVersion',
			        	width:100,
			        	align:'center'
			        },{
			        	title:'机型',
			        	field:'phoneModel',
			        	width:100,
			        	align:'center'
			        },{
			        	title:'系统版本',
			        	field:'osVersion',
			        	width:100,
			        	align:'center'
			        },{
			        	title:'经度',
			        	field:'longitude',
			        	width:100,
			        	align:'center'
			        },{
			        	title:'纬度',
			        	field:'latitude',
			        	width:100,
			        	align:'center'
			        },{
			        	title:'时间',
			        	field:'createTime',
			        	width:150,
			        	align:'center',
			        	formatter:formatDate
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
				url:'${pageContext.request.contextPath}/dpmManage/autoPunchClockMonitorPc_queryByPage.action',
				onClickCell:showErrorMsg
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
			
			$('#grid').datagrid('load',{
				empCode:searchVal
			});
		}
		
	});
	
	function formatDate(val,row){
		var now = new Date(val);
		return now.format("yyyy-MM-dd hh:mm:ss");
	}
	
	function statusFormat(val,row){
		return (val == 1 || (row.within && !row.auto)) ? '<span style="color: green">成功</span>' : '<span style="color: red">失败</span>';
	}
	
	function formatMsg(val,row){
		if(val == undefined){
			return '';
		}
		return "<span title='" + val + "'>" + val + "</span>";
	}
	
	function showErrorMsg(rowIndex, field, value){
		if(field == 'errorMsg'){
			if(value == undefined || value == ''){
				return;
			}
			$('#win').empty();
			$('#win').window('open');
			$('#win').append(value);
		}
	}
	
	function withinFormat(val,row){
		if(val == false){
			return '否';
		} else {
			return '是';
		}
	}
	
	function autoFormat(val,row){
		if(val == false) {
			return '手动';
		}else{
			return '自动';
		}
	}
	
</script>
<body>
	<div id="tb"> 
		<input id="search">
	</div> 
	<div id="grid"></div>
	
	<div id="win" class="easyui-window" title="详情" style="width:500px;height:150px;padding:10px;background:#fafafa;
		display:block;word-break: break-all;word-wrap: break-word;" 
		data-options="iconCls:'icon-save',closed:true,collapsible:false,minimizable:false,maximizable:false">
	</div>
</body>
</html>