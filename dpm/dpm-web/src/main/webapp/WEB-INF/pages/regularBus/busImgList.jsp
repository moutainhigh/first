<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>班车图片管理</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jquery-easyui-1.4/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jquery-easyui-1.4/locale/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/scripts/jquery-easyui-1.4/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/scripts/jquery-easyui-1.4/themes/icon.css" />
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
			        	title:'图片类型',
			        	field:'type',
			        	width:100,
			        	align:'center',
			        	formatter:formatType
			        },{
			        	title:'图片',
			        	field:'imgUrl',
			        	width:300,
			        	align:'center',
			        	formatter:formatImg
			        },{
			        	title:'更新时间',
			        	field:'updateTime',
			        	width:100,
			        	align:'center',
			        	formatter:formatDate
			        },{
			        	title:'上传时间',
			        	field:'createTime',
			        	width:100,
			        	align:'center',
			        	formatter:formatDate
			        }
				]],
				fit:true,
				border:false,
				fitColumns:true,
				striped:true,
				pagination:true,
				pageNumber:1,
				pageSize:10,
				pageList:[10,20,30],
				rownumbers:true,
				url:'${pageContext.request.contextPath}/dpmManage/regularBusImg_list.action'
				
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
			var suffix = filename.substring(filename.lastIndexOf(".")).toLowerCase();
			if(!('.png'.toLowerCase() == suffix || '.jpg'.toLowerCase() == suffix)){
				$.messager.alert('警告','必须上传“jpg”或“png”格式的图片!','warning');
				return;
			}
			
			// 上传文件，表单序列化
			var formData = new FormData($("#uploadForm")[0]);
			$.ajax({
				   type: "POST",
				   url: "${pageContext.request.contextPath}/dpmManage/regularBusImg_uploadImg.action",
				   data: formData,
				   async: false,  
		           cache: false,  
		           contentType: false,  
		           processData: false,
				   success: function(data) {
					   if(data == "success"){
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
				$.post('${pageContext.request.contextPath}/dpmManage/regularBusImg_delete.action',rowData,function(data){
					if(data == "success") {
						$.messager.alert('提示','删除成功！','info');
					} else {
						$.messager.alert('错误','删除失败！','error');
					}
					$("#grid").datagrid('reload');
				});
			}
		});
	}
	
	function formatType(val,row) {
		if(val == '0') {
			return '上班路线';
		} else if(val == '1') {
			return '下班路线';
		} else {
			return val;
		}
	}
	
	function formatDate(val,row){
		var now = new Date(val);
		return now.format("yyyy-MM-dd hh:mm:ss");
	}
	
	function formatImg(val,row){
		var formatedImg = val.substring(val.lastIndexOf("/") + 1);
		return "<a href='"+val+"' target='_blank'>" + formatedImg + "</a>";
	}
	
	
</script>
<body>
	<div id="grid"></div>
	
	<div id="uploadWin" class="easyui-window" data-options="modal:true,iconCls:'icon-redo',title:'上传',closed:true,resizable:false,minimizable:false,maximizable:false,collapsible:false"
		style="width:400px;height:230px;padding:10px;">
		<div style="padding:20px 20px 20px 20px">
			<form id="uploadForm">
				<table cellpadding="7">
					<tr>
						<td>类型：</td>
						<td>
							<select class="easyui-combobox" data-options="required:true" name="type" style="width:200px;"> 
								<option value="0" selected="selected">上班路线</option> 
								<option value="1">下班路线</option> 
							</select> 
						</td>
					</tr>
					<tr>
						<td>图片：</td>
						<td>
							<input id="uploadbox" class="easyui-filebox" name="file" style="width: 200px;"/>
						</td>
					</tr>
					<tr>
						<td>
							<a id="upload-button" data-options="iconCls:'icon-ok',required:true" class="easyui-linkbutton">上传</a>
						</td>
						<td>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>