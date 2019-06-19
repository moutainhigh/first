<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>系统更新控制</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jquery-1.8.3.min.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/scripts/jquery-easyui-1.4/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/scripts/jquery-easyui-1.4/themes/icon.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jquery-easyui-1.4/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jquery-easyui-1.4/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/common/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/ocupload/jquery.ocupload-1.1.2.js"></script>
</head>
<script type="text/javascript">
	$(function(){
		$("#grid").datagrid({
			toolbar:[{
				id:'button-upload',
				text:'上传',
				iconCls:'icon-redo',
			},{
				text:'编辑',
				iconCls:'icon-edit',
				handler:doEdit
			},{
				text:'删除',
				iconCls:'icon-cancel',
				handler:doDel
			}],
			columns:[[{
			        	title:'id',
			        	field:'id',
			        	width:80,
			        	align:'center',
			        	checkbox:true
			        },{
			        	title:'类型',
			        	field:'configType',
			        	width:100,
			        	align:'center',
			        	formatter:formatConfigType
			        },{
			        	title:'全类名',
			        	field:'fileName',
			        	width:300,
			        	align:'center',
			        },{
			        	title:'文件路径',
			        	field:'filePath',
			        	width:200,
			        	align:'center',
			        	formatter:formatToALabel
			        },{
			        	title:'加载状态',
			        	field:'loadStatus',
			        	width:100,
			        	align:'center'
			        },{
			        	title:'更新时间',
			        	field:'updateTime',
			        	width:150,
			        	align:'center',
			        	formatter:formatDate
			        },{
			        	title:'上传时间',
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
				url:'${pageContext.request.contextPath}/dpmManage/versionUpdateControl_list.action'
		});
		
		// 对上传按钮添加点击事件 
		$("#button-upload").bind('click',function(){
			$("#uploadWin").window('open');
		});
		
		// 上传
		$("#upload-button").click(function(){
			if(!$("#uploadForm").form('validate')){
				$.messager.alert('警告','表单还未填写完成！','warning');
				return;
			}
			
			var filename = $("#uploadbox").filebox('getValue');
			if(filename.substring(filename.lastIndexOf(".")) != '.class'){
				$.messager.alert('警告','上传文件必须是class文件！','warning');
				return;
			}
			
			// 上传文件，表单序列化
			var formData = new FormData($("#uploadForm")[0]);
			$.ajax({
				   type: "POST",
				   url: "${pageContext.request.contextPath}/dpmManage/versionUpdateControl_uploadJavaFile.action",
				   data: formData,
				   async: false,  
		           cache: false,  
		           contentType: false,  
		           processData: false,
				   success: function(data) {
					   if(data){
						  $.messager.alert('提示','上传成功！','info'); 
					   }else{
						  $.messager.alert('错误','上传失败！','error'); 
					   }
					   // 清除表单
					   $("#uploadForm").form('reset');
					   // 关闭窗口
					   $("#uploadWin").window('close');
					   // 重新加载datagrid
					   $("#grid").datagrid('reload');
				   },
				   error: function(data) {
					   $.messager.alert('错误','上传失败！','error'); 
					   // 清除表单
					   $("#uploadForm").form('reset');
					   // 关闭窗口
					   $("#uploadWin").window('close');
					   // 重新加载datagrid
					   $("#grid").datagrid('reload');
				   }
			});
		});
		
		// 编辑
		function doEdit(){
			var rowData = selectOneRow();
			if(!rowData){
				return;
			}
			$("#editWin").window('open').panel({
				onOpen : function(){
					$("#editForm").form('reset');
					//回显数据
		     	    $("#editForm").form('load',rowData);
				}
			});
		}
	});
	
	function selectOneRow(){
		var selectedRows = $("#grid").datagrid('getSelections');
		if(selectedRows.length == 0) {
			$.messager.alert('警告','必须选中一行！','warning');
			return;
		}
		
		if(selectedRows.length > 1) {
			$.messager.alert('警告','有且只能选择一行！','warning');
			return;
		}
		return selectedRows[0];
	}
	
	function doDel(){
		var rowData = selectOneRow();
		if(!rowData){
			return;
		}
		$.messager.confirm('确认提示框','确定删除？',function(r){
			if(r) {
				$.get('${pageContext.request.contextPath}/dpmManage/versionUpdateControl_delete.action?id=' + rowData.id,function(data){
					if(data) {
						$.messager.alert('提示','删除成功！','info');
					} else {
						$.messager.alert('错误','删除失败！','error');
					}
					$("#grid").datagrid('reload');
				});
			}
		});
	}
	
	function formatToALabel(val,row) {
		return '<a href="'+val+'" target="_blank">'+ val + '</a>';
	}
	
	function formatConfigType(val,row) {
		return val == '0' ? '弹框控制' : '更新控制';
	}
	
	function formatDate(val,row){
		var now = new Date(val);
		return now.format("yyyy-MM-dd hh:mm:ss");
	}
	
	// 提交修改
	function submitForm(){
		if(!$('#editForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		
		$.ajax({
			type:"POST",
			url:"${pageContext.request.contextPath}/dpmManage/versionUpdateControl_update.action",
			data: $("#editForm").serialize(),
			success:function(data){
				if(data) {
					$.messager.alert('提示','修改成功！','info');
					$("#grid").datagrid('reload');
					$("#editWin").window('close');
				} else {
					$.messager.alert('错误','修改失败！','error');
					$("#grid").datagrid('reload');
					$("#editWin").window('close');
				}
			},
			error:function(data){
				$.messager.alert('错误','修改失败！','error');
				$("#grid").datagrid('reload');
				$("#editWin").window('close');
			}
		});
		
		
	}
	
</script>
<body>
	<div id="grid"></div>
	<div id="editWin" class="easyui-window" data-options="modal:true,iconCls:'icon-edit',title:'编辑',closed:true,resizable:false"
			style="width:500px;height:300px;padding:10px;">
		<div style="padding:20px 20px 20px 20px">
			<form id="editForm">
				<table cellpadding="7">
					<tr>
						<td>类型：</td>
						<td>
							<select class="easyui-combobox" data-options="required:true" name="configType" style="width:300px;"> 
								<option value="0" selected="selected">弹框控制</option> 
								<option value="1">更新控制</option> 
							</select> 
							<input type="hidden" name="id" />
						</td>
					</tr>
					<tr>
						<td>全类名：</td>
						<td>
							<input class="easyui-textbox" data-options="required:true,editable:false" name="fileName" style="width: 300px;"/>
						</td>
					</tr>
					<tr>
						<td>文件路径：</td>
						<td>
							<input class="easyui-textbox" data-options="required:true,editable:false" name="filePath" style="width: 300px;"/>
						</td>
					</tr>
					<tr>
						<td>加载状态：</td>
						<td>
							<select class="easyui-combobox" data-options="required:true" name="loadStatus" style="width: 300px;"> 
								<option value="on">on</option> 
								<option value="off">off</option> 
							</select> 
						</td>
					</tr>
					<tr>
						<td>
							<a style="width: 50px;"  class="easyui-linkbutton" data-options="iconCls:'icon-ok',plain:true" onclick='submitForm();'></a>
						</td>
						<td></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div id="uploadWin" class="easyui-window" data-options="modal:true,iconCls:'icon-redo',title:'上传',closed:true,resizable:false"
		style="width:400px;height:260px;padding:10px;">
		<div style="padding:20px 20px 20px 20px">
			<form id="uploadForm">
				<table cellpadding="7">
					<tr>
						<td>类型：</td>
						<td>
							<select class="easyui-combobox" data-options="required:true" name="configType" style="width:200px;"> 
								<option value="0" selected="selected">弹框控制</option> 
								<option value="1">更新控制</option> 
							</select> 
						</td>
					</tr>
					<tr>
						<td>包名：</td>
						<td>
							<input class="easyui-textbox" data-options="required:true" name="packageName" style="width: 200px;"/>
						</td>
					</tr>
					<tr>
						<td>文件：</td>
						<td>
							<input id="uploadbox" class="easyui-filebox" name="file" style="width: 200px;"/>
						</td>
					</tr>
					<tr>
						<td>
							<a id="upload-button" data-options="iconCls:'icon-ok',required:true" class="easyui-linkbutton">上传</a>
						</td>
						<td></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>