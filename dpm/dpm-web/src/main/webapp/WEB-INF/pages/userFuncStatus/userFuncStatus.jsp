<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户功能开关</title>
<script type="text/javascript" src="/dpm/scripts/jquery-1.8.3.min.js"></script>
<link rel="stylesheet" type="text/css" href="/dpm/scripts/jquery-easyui-1.4/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="/dpm/scripts/jquery-easyui-1.4/themes/icon.css" />
<script type="text/javascript" src="/dpm/scripts/jquery-easyui-1.4/jquery.easyui.min.js"></script>
<script type="text/javascript" src="/dpm/scripts/jquery-easyui-1.4/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="/dpm/scripts/common/common.js"></script>
</head>
<script type="text/javascript">
    var _editIndex = undefined; 
	$(function(){
		$('#search').searchbox({
			width : 180,
		    searcher : doSearch,
		    prompt : '请输入工号'
		});
		
		$('#monitorInfoSearch').searchbox({
			width : 180,
		    searcher : doMonitorSearch,
		    prompt : '请输入工号'
		});
		
		$("#grid").datagrid({
			toolbar:'#tb',
			columns:[[{
			        	field:'id',
			        	checkbox:true
			        },{
			        	title:'工号',
			        	field:'userId',
			        	width:100,
			        	align:'center',
			        	editor:{
			        		type:'textbox',
	        				options:{
	        					required:true
	        				}
		        		}
			        },{
			        	title:'异常监控开关',
			        	field:'exceptionMonitorStatus',
			        	width:100,
			        	align:'center',
			        	formatter:formatStatus,
			        	editor:{
				        		type:'combobox',
		        				options:{
		        					valueField: 'label',
		        					textField: 'value',
		        					data:[{label:'true',value:'on'},{label:'false',value:'off'}]
		        				}
			        		}
			        },{
			        	title:'设备号',
			        	field:'deviceToken',
			        	width:150,
			        	align:'center',
			        	editor:{
			        		type:'textbox',
	        				options:{
	        					required:true
	        				}
		        		}
			        },{
			        	title:'创建时间',
			        	field:'createTime',
			        	width:150,
			        	align:'center',
			        	formatter:formatDate
			        },{
			        	title:'更新时间',
			        	field:'updateTime',
			        	width:150,
			        	align:'center',
			        	formatter:formatDate
			        }
				]],
				border:false,
				fitColumns:true,
				striped:true,
				rownumbers:true,
				onDblClickRow:doubleClick,
				onAfterEdit:submitEdit
		});
		
		/*******监控信息表格 start********/
		$('#monitorInfoGrid').datagrid({
			toolbar:'#monitorInfoTb',
			columns:[[{
		        	title:'工号',
		        	field:'userId',
		        	width:100,
		        	align:'center'
		        },{
		        	title:'是否存在文件',
		        	field:'exist',
		        	width:100,
		        	align:'center',
		        	formatter:formatExist
		        },{
		        	title:'路径',
		        	field:'path',
		        	width:300,
		        	align:'center'
		        },{
		        	title:'创建时间',
		        	field:'createTime',
		        	width:150,
		        	align:'center',
		        	formatter:formatDate
		        },{
		        	title:'更新时间',
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
			singleSelect:true,
			rownumbers:true,
			pagination:true,
			pageNumber:1,
			pageSize:10,
			pageList:[10,20,30],
			url:'${pageContext.request.contextPath}/dpmManage/userFuncMonitorAction_queryByPage.action',
			onClickCell:showPath
		});
		
		/*******监控信息表格 end********/
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
			
			$.get('${pageContext.request.contextPath}/dpmManage/userFuncStatusAction_queryByEmpcode.action?userId=' + searchVal,function(result){
				// 注意这句不能少
				var data = $.parseJSON(result); 
				if(data == '' || data.length == 0){
					$.messager.alert('提示','没有搜索到信息！','info');
					return;
				}
				$("#grid").datagrid('loadData',data);
			});
		}
		
		function doMonitorSearch(){
			// 校验输入的工号
			var searchVal = $("#monitorInfoSearch").val();
			if(searchVal == ''){
				$.messager.alert('警告','搜索条件不能为空！','warning');
				return;
			}
			if(searchVal.length != 6) {
				$.messager.alert('警告','工号必须为6位！','warning');
				return;
			}
			
			$('#monitorInfoGrid').datagrid('load',{
				userId:searchVal
			});
		}
		
		// 点击删除 
		$("#del").click(function(){
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
			$.messager.confirm('提示','确定删除id为："' + rowData.id + '" 的数据？',function(r){
				if(r){
					var searchVal = $("#search").val();
					$.post('${pageContext.request.contextPath}/dpmManage/userFuncStatusAction_delete.action',{"id":rowData.id},function(data){
						
						if($.parseJSON(data).success){
							$.messager.alert('提示','删除成功！','info');
							// 重新请求
							$.get('${pageContext.request.contextPath}/dpmManage/userFuncStatusAction_queryByEmpcode.action?userId=' + searchVal,function(result){
								// 注意这句不能少
								var dataArray = $.parseJSON(result); 
								$("#grid").datagrid('loadData',dataArray);
							});
						} else {
							$.messager.alert('提示','删除失败！','info');
						}
					});
				}
			});
		});
		
		// 点击取消
		$("#cancel-edit").click(function(){
			// 取消编辑
			$("#grid").datagrid('cancelEdit',_editIndex);
			_editIndex = undefined;
		}); 
		
		// 点击新增
		$("#add").click(function(){
			if(_editIndex == undefined) {
				// 取消编辑
				$("#grid").datagrid('cancelEdit',_editIndex);
				
				$("#grid").datagrid('insertRow',{
					index : 0,
					row : {}
				});
				$("#grid").datagrid('beginEdit',0);
				_editIndex = 0;
				// 获取编辑器
				var exceptionMonitorStatusEd = $("#grid").datagrid('getEditor',{index:_editIndex,field:'exceptionMonitorStatus'});
				// 状态发生改变触发结束编辑，提交
				$(exceptionMonitorStatusEd.target).combobox({
					onChange:function(newValue,oldValue) {
						// 结束编辑
						$("#grid").datagrid('endEdit',_editIndex);
					}
				});
			}
		});
		
	});
	
	
	// 双击一行的事件
	function doubleClick(rowIndex, rowData) {
		if(_editIndex != undefined){
			// 先取消正在编辑的行
			$("#grid").datagrid('cancelEdit',_editIndex);
		}
		// 开始编辑
		$("#grid").datagrid('beginEdit',rowIndex);
		// 获取编辑器
		var ed = $("#grid").datagrid('getEditor',{index:rowIndex,field:'exceptionMonitorStatus'});
		// 状态发生改变触发结束编辑，提交
		$(ed.target).combobox({
			onChange:function(newValue,oldValue) {
				// 结束编辑
				$("#grid").datagrid('endEdit',rowIndex);
			}
		});
		_editIndex = rowIndex;
	}
	
	// 提交编辑
	function submitEdit(rowIndex, rowData, changes) {
		var searchVal = rowData.userId;
		$.post('${pageContext.request.contextPath}/dpmManage/userFuncStatusAction_updateOrInsert.action',rowData,function(data){
			if($.parseJSON(data).success){
				$.messager.alert('提示','修改成功！','info');
				// 重新请求
				$.get('${pageContext.request.contextPath}/dpmManage/userFuncStatusAction_queryByEmpcode.action?userId=' + searchVal,function(result){
					// 注意这句不能少
					var dataArray = $.parseJSON(result); 
					$("#grid").datagrid('loadData',dataArray);
				});
			} else {
				$.messager.alert('提示','修改失败！','info');
				// 重新请求
				$.get('${pageContext.request.contextPath}/dpmManage/userFuncStatusAction_queryByEmpcode.action?userId=' + searchVal,function(result){
					// 注意这句不能少
					var dataArray = $.parseJSON(result); 
					$("#grid").datagrid('loadData',dataArray);
				});
			}
		});
		_editIndex = undefined;
	}
	
	function formatDate(val,row){
		var now = new Date(val);
		return now.format("yyyy-MM-dd hh:mm:ss");
	}
	
	function formatStatus(val,row) {
		return val == true ? '开启' : '关闭';
	}
	
	function formatExist(val,row) {
		return val == true ? '是' : '否';
	}
	
	function showPath(rowIndex, field, value){
		if(field == 'path'){
			if(value == undefined || value == ''){
				return;
			}
			$('#win').empty();
			$('#win').window('open');
			$('#win').append(value);
		}
	}
	
</script>
<body>
	<div id="tb"> 
		<input id="search">
		<a id="add" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新增</a>
		<a id="del" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true">删除</a> 
		<a id="cancel-edit" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">取消</a> 
	</div> 
	<div id="grid"></div>
	<br><br><br>
	<div id="monitorInfoGrid"></div>
	<div id="monitorInfoTb"> 
		<input id="monitorInfoSearch">
	</div>
	
	<div id="win" class="easyui-window" title="详情" style="width:500px;height:150px;padding:10px;background:#fafafa;
		display:block;word-break: break-all;word-wrap: break-word;" 
		data-options="iconCls:'icon-save',closed:true,collapsible:false,minimizable:false,maximizable:false">
	</div>
</body>
</html>
