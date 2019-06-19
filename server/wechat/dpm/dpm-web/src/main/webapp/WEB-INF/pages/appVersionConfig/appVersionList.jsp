<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>系统版本管理</title>
<link rel="stylesheet" type="text/css" href="/dpm/scripts/jquery-easyui-1.4/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="/dpm/scripts/jquery-easyui-1.4/themes/icon.css" />
<script type="text/javascript" src="/dpm/scripts/jquery-easyui-1.4/jquery.min.js"></script>
<script type="text/javascript" src="/dpm/scripts/jquery-easyui-1.4/jquery.easyui.min.js"></script>
<script type="text/javascript" src="/dpm/scripts/jquery-easyui-1.4/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="/dpm/scripts/common/common.js"></script>

<script type="text/javascript">
	var editIndex = undefined; 
	$(function(){
		$("#grid").datagrid({
			
			columns:[[{
			        	title:'系统',
			        	field:'osType',
			        	width:150,
			        	align:'center'
			        },{
			        	title:'应用版本号',
			        	field:'version',
			        	width:150,
			        	align:'center'
			        },{
			        	title:'是否强制更新',
			        	field:'rforce',
			        	width:150,
			        	align:'center',
			        	formatter:formatSet
			        },{
			        	title:'更新链接',
			        	field:'url',
			        	width:150,
			        	align:'center'
			        },{
			        	title:'更新内容',
			        	field:'content',
			        	width:150,
			        	align:'center'
			        },{
			        	title:'修改时间',
			        	field:'updateTime',
			        	width:150,
			        	align:'center',
			        	formatter:formatDate
			        }
			]],
			fit:true,
			border:false,
			fitColumns:true,
			striped:true,
			loadMsg:'正在加载...',
			rownumbers:true,
			url:'${pageContext.request.contextPath}/dpmManage/versionConfig_list.action',
			method:'get',
			onDblClickRow:editRow
		});
	});
	
	function editRow(rowIndex, rowData){
		$("#editwin").window('open').panel({
			onLoad : function(){ 
        		//回显数据
         	    $("#editContent").form('load',rowData);
        	}
		});
	}
	
	function formatDate(val,row){
		var now = new Date(val);
		return now.format("yyyy-MM-dd hh:mm:ss");
	}
	
	function formatSet(val,row){
		if(val == 0){
			return "否";
		}else{
			return "是";
		}
	}
</script>
</head>
<body>
	<div id="grid"></div>
	
	<div id="editwin" class="easyui-window" title="编辑版本" style="width:700px;height:500px" data-options="closed:true,iconCls:'icon-edit',modal:true,
		href:'${pageContext.request.contextPath }/dpmManage/versionConfig_toEditPage.action'"></div>
</body>
</html>