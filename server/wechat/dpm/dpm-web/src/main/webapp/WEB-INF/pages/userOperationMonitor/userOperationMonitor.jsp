<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户操作监控</title>
<script type="text/javascript" src="/dpm/scripts/jquery-1.8.3.min.js"></script>
<link rel="stylesheet" type="text/css" href="/dpm/scripts/jquery-easyui-1.4/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="/dpm/scripts/jquery-easyui-1.4/themes/icon.css" />
<script type="text/javascript" src="/dpm/scripts/jquery-easyui-1.4/jquery.easyui.min.js"></script>
<script type="text/javascript" src="/dpm/scripts/jquery-easyui-1.4/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="/dpm/scripts/common/common.js"></script>

<style type="text/css">
	div .btn-separator {  
	  float: left;  
	  height: 24px;  
	  border-left: 1px solid LightGrey;  
	  border-right: 0px solid LightGrey;  
	  margin: 1px 1px;  
	} 	
</style>
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
			        	field:'userId',
			        	width:100,
			        	align:'center'
			        },{
			        	title:'操作',
			        	field:'operation',
			        	width:200,
			        	align:'center'
			        },{
			        	title:'操作系统',
			        	field:'osType',
			        	width:100,
			        	align:'center'
			        },{
			        	title:'应用版本',
			        	field:'appVersion',
			        	width:100,
			        	align:'center'
			        },{
			        	title:'设备号',
			        	field:'deviceToken',
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
			        	title:'mac地址',
			        	field:'phoneMac',
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
				pageSize:5,
				pageList:[5,10,20],
				url:'${pageContext.request.contextPath}/dpmManage/userOperationMonitorAction_queryByUserIdAndTime.action',
				onClickCell:showOperation
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
			
			// 开始时间
			var startTime = $("input[name='startTime']").val();
			// 结束时间
			var endTime = $("input[name='endTime']").val();
			
			$('#grid').datagrid('load',{
				userId:searchVal,
				startTime:startTime,
				endTime:endTime
			});
		}
		
	});
	
	function formatDate(val,row){
		var now = new Date(val);
		return now.format("yyyy-MM-dd hh:mm:ss");
	}
	
	function showOperation(rowIndex, field, value){
		if(field == 'operation'){
			if(value == undefined || value == ''){
				return;
			}
			
			var finalVal = '';
			var operatArray = value.split("@");
			for(var i in operatArray){
				if(i != 0 && i % 3 == 0){
					finalVal += '<br/>';
				}
				finalVal += operatArray[i];
			}
			
			$('#win').empty();
			$('#win').window('open');
			$('#win').append(finalVal);
		}
	}
	
</script>
<body>
	<div id="tb"> 
		<table>
			<tr>
				<td><input id="search"></td>
				<td>&nbsp;</td>
				<td><div class="btn-separator"></div></td>
				<td>&nbsp;</td>
				<td>
					<span>开始时间</span>
					<input class="easyui-datetimebox"  name="startTime">
				</td>
				<td>&nbsp;&nbsp;</td>
				<td>
					<span>结束时间</span>
					<input class="easyui-datetimebox"  name="endTime">
				</td>
			</tr>
		</table>
	</div> 
	<div id="grid"></div>
	
	<div id="win" class="easyui-window" title="详情" style="width:800px;height:500px;padding:10px;background:#fafafa;
		display:block;word-break: break-all;word-wrap: break-word;" 
		data-options="iconCls:'icon-save',closed:true,collapsible:false,minimizable:false,maximizable:false">
	</div>
</body>
</html>