<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>来电显示通讯录</title>
<link rel="stylesheet" type="text/css" href="/dpm/scripts/jquery-easyui-1.4/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="/dpm/scripts/jquery-easyui-1.4/themes/icon.css" />
<script type="text/javascript" src="/dpm/scripts/jquery-easyui-1.4/jquery.min.js"></script>
<script type="text/javascript" src="/dpm/scripts/jquery-easyui-1.4/jquery.easyui.min.js"></script>
<script type="text/javascript" src="/dpm/scripts/jquery-easyui-1.4/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="/dpm/scripts/common/common.js"></script>

<script type="text/javascript">
	$(function(){
		$("#grid").datagrid({
			toolbar:[{
				id:'syncBtn',
				text:'同步来电显示',
				iconCls:'icon-reload'
			},{
				id:'openPermission',
				text:'开放权限',
				iconCls:'icon-tip'
			},{
				id:'closePermission',
				text:'关闭权限',
				iconCls:'icon-lock'
			},{
				id:'openVoicePermission',
				text:'开放科大讯飞语音权限',
				iconCls:'icon-tip'
			},{
				id:'closeVoicePermission',
				text:'关闭科大讯飞语音权限',
				iconCls:'icon-lock'
			}],
			columns:[[{
						title:'ID',
						field:'id',
						width:100,
			        	align:'center'
			        },{
			        	title:'操作系统',
			        	field:'osType',
			        	width:200,
			        	align:'center'
			        },{
			        	title:'下载地址',
			        	field:'downloadUrl',
			        	width:200,
			        	align:'center'
			        },{
			        	title:'上次更新时间',
			        	field:'prevUpdateTime',
			        	width:200,
			        	align:'center',
			        	formatter:formatDate
			        },{
			        	title:'最后更新时间',
			        	field:'updateTime',
			        	width:200,
			        	align:'center',
			        	formatter:formatDate
			        },{
			        	title:'创建时间',
			        	field:'createTime',
			        	width:200,
			        	align:'center',
			        	formatter:formatDate
			        }
			]],
			fit:true,
			border:false,
			fitColumns:true,
			striped:true,
			singleSelect:false,
			loadMsg:'正在加载...',
			rownumbers:true,
			url:'${pageContext.request.contextPath}/dpmManage/cid_queryCID.action?isManagePage=true',
			method:'get',
		});
		
		$('#syncBtn').click(function(){
			// 弹出确认框
			$.messager.confirm('提示','确定开始同步?',function(r){
				if(r){
					// 弹出进度条
					$.messager.progress({
						text:'正在同步...',
						interval:1000 
					});
					
					$.ajax({ 
						type: "GET",
						url: "${pageContext.request.contextPath}/dpmManage/cid_syncCIDBook.action", 
						success: function(data){
							// 关闭进度条
							$.messager.progress('close');
							if(data == 'success') {
								// 弹框
								$.messager.alert('提示','同步成功','info');
							} else {
								$.messager.alert('提示','同步失败','error');
							}
							// 刷新页面
							$('#grid').datagrid('reload');
						},
						error:function(){
							// 关闭进度条
							$.messager.progress('close');
							// 弹框
							$.messager.alert('错误','请求失败','error');
						}
					});
				}
			});
		});
		
		$('#openPermission').click(function(){
			var selectedArray = $("#grid").datagrid('getSelections');
			if(selectedArray.length == 0){
				$.messager.alert('提示','必须选择一行！','info');
				return;
			}
			if(selectedArray.length > 1) {
				$.messager.alert('提示','只能选择一行！','info');
				return;
			}
			var rowData = selectedArray[0];
			$.messager.confirm('提示','是否开放来电显示权限？',function(r) {
				if(r) {
					$.get('${pageContext.request.contextPath}/dpmManage/cid_permissionControl.action?operate=1&entity.osType='+rowData.osType,function(data){
						if(data == 'success') {
							$.messager.show({
								 title:'提示',  	
								 msg:'操作成功！',  	
								 timeout:5000	
							});
						} else {
							$.messager.show({
								 title:'提示',  	
								 msg:'操作失败！',  	
								 timeout:5000	
							});
						}
					});
				}
			});
		});
		
		$('#closePermission').click(function(){
			var selectedArray = $("#grid").datagrid('getSelections');
			if(selectedArray.length == 0){
				$.messager.alert('提示','必须选择一行！','info');
				return;
			}
			if(selectedArray.length > 1) {
				$.messager.alert('提示','只能选择一行！','info');
				return;
			}
			var rowData = selectedArray[0];
			$.messager.confirm('提示','是否关闭来电显示权限？',function(r) {
				if(r) {
					$.get('${pageContext.request.contextPath}/dpmManage/cid_permissionControl.action?operate=0&entity.osType='+rowData.osType,function(data){
						if(data == 'success') {
							$.messager.show({
								 title:'提示',  	
								 msg:'操作成功！',  	
								 timeout:5000	
							});
						} else {
							$.messager.show({
								 title:'提示',  	
								 msg:'操作失败！',  	
								 timeout:5000	
							});
						}
					});
				}
			});
		});
		
		$('#openVoicePermission').click(function(){
			$.messager.confirm('提示','是否开放科大讯飞语音权限？',function(r) {
				if(r) {
					$.get('${pageContext.request.contextPath}/dpmManage/cid_permissionControl.action?operate=1&entity.osType=voice',function(data){
						if(data == 'success') {
							$.messager.show({
								 title:'提示',  	
								 msg:'操作成功！',  	
								 timeout:5000	
							});
						} else {
							$.messager.show({
								 title:'提示',  	
								 msg:'操作失败！',  	
								 timeout:5000	
							});
						}
					});
				}
			});
		});
		
		$('#closeVoicePermission').click(function(){
			$.messager.confirm('提示','是否关闭科大讯飞语音权限？',function(r) {
				if(r) {
					$.get('${pageContext.request.contextPath}/dpmManage/cid_permissionControl.action?operate=0&entity.osType=voice',function(data){
						if(data == 'success') {
							$.messager.show({
								 title:'提示',  	
								 msg:'操作成功！',  	
								 timeout:5000	
							});
						} else {
							$.messager.show({
								 title:'提示',  	
								 msg:'操作失败！',  	
								 timeout:5000	
							});
						}
					});
				}
			});
		});
		
	});
	
	function formatDate(val,row){
		var now = new Date(val);
		return now.format("yyyy-MM-dd hh:mm:ss");
	}
</script>
</head>
<body>
	<div id="grid"></div>
</body>
</html>