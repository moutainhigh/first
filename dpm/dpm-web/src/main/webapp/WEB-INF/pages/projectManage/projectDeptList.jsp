<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>工程管理部门</title>
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
				id:'add',
				text:'新增',
				iconCls:'icon-add'
			},{
				id:'del',
				text:'删除',
				iconCls:'icon-cancel'
			}],
			columns:[[{
						field:'id',
						checkbox:true
			        },{
			        	title:'部门编码',
			        	field:'orgcode',
			        	width:200,
			        	align:'center'
			        },{
			        	title:'部门名称',
			        	field:'orgname',
			        	width:200,
			        	align:'center'
			        }
			]],
			fit:true,
			border:false,
			fitColumns:true,
			striped:true,
			singleSelect:false,
			loadMsg:'正在加载...',
			rownumbers:true,
			url:'${pageContext.request.contextPath}/dpmManage/projectManagePcAction_list.action',
			method:'get',
			pageList:[10,20],
			pageNumber:0,
			pageSize:10,
			pagination:true
		});
		
		// 新增按钮点击事件
		$("#add").click(function(){
			$("#addWin").window('open');
		});
		
		// 新增
		$("#submit-button").click(function(){
			if(!$("#addForm").form('validate')){
				$.messager.alert('警告','表单还未填写完成！','warning');
				return;
			}
			$.ajax({
				   type: "POST",
				   url: "${pageContext.request.contextPath}/dpmManage/projectManagePcAction_save.action",
				   data: $("#addForm").serialize(),
				   success: function(data) {
					   data = $.parseJSON(data); 
					   if(data.success){
						  $.messager.alert('提示','新增成功！','info'); 
					   }else{
						  $.messager.alert('错误','新增失败！','error'); 
					   }
					   // 清除表单
					   $("#addForm").form('reset');
					   // 关闭窗口
					   $("#addWin").window('close');
					   // 重新加载datagrid
					   $("#grid").datagrid('reload');
				   },
				   error: function(data) {
					   $.messager.alert('错误','新增失败！','error'); 
					   // 清除表单
					   $("#addForm").form('reset');
					   // 关闭窗口
					   $("#addWin").window('close');
					   // 重新加载datagrid
					   $("#grid").datagrid('reload');
				   }
			});
		});
		
		// 删除按钮点击事件
		$("#del").click(function(){
			var rows = $("#grid").datagrid('getSelections');
			if(rows.length == 0) {
				$.messager.alert('提示','至少选择一行删除！','info');
				return;
			}
			$.messager.confirm('提示','确认删除？',function(r){
				if(r){
					var orgcodes = '';
					for(var i in rows) {
						orgcodes = orgcodes + rows[i].orgcode + ',';
					}
					orgcodes = orgcodes.substring(0,orgcodes.length - 1);
					$.post('${pageContext.request.contextPath}/dpmManage/projectManagePcAction_delete.action',{'orgcode':orgcodes},
							function(data){
						data = $.parseJSON(data); 
						if(data.success){
							$.messager.alert('提示','删除成功！','info');
							$("#grid").datagrid('reload');
						} else {
							$.messager.alert('提示','删除失败！','info');
							$("#grid").datagrid('reload');
						}
					});
				}
			});
		});
	});
</script>
</head>
<body>
	<div id="grid"></div>
	<div id="addWin" class="easyui-window" data-options="modal:true,iconCls:'icon-add',title:'新增',closed:true,resizable:false"
		style="width:400px;height:230px;padding:10px;">
		<div style="padding:20px 20px 20px 20px">
			<form id="addForm">
				<table cellpadding="7">
					<tr>
						<td>部门编号：</td>
						<td>
							<input class="easyui-textbox" data-options="required:true" name="orgcode" style="width: 200px;"/>
						</td>
					</tr>
					<tr>
						<td>部门名称：</td>
						<td>
							<input class="easyui-textbox" name="orgname" style="width: 200px;"/>
						</td>
					</tr>
					<tr>
						<td>
							<a id="submit-button" data-options="iconCls:'icon-ok'" class="easyui-linkbutton">新增</a>
						</td>
						<td></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>