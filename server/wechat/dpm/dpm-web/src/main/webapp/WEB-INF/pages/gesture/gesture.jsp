<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>手势密码</title>
<script type="text/javascript" src="/dpm/scripts/jquery-1.8.3.min.js"></script>
<link rel="stylesheet" type="text/css" href="/dpm/scripts/jquery-easyui-1.4/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="/dpm/scripts/jquery-easyui-1.4/themes/icon.css" />
<script type="text/javascript" src="/dpm/scripts/jquery-easyui-1.4/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="/dpm/scripts/jquery-easyui-1.4/jquery.easyui.min.js"></script>
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
			        	field:'ID',
			        	checkbox:true
			        },{
			        	title:'工号',
			        	field:'userId',
			        	width:100,
			        	align:'center'
			        },{
			        	title:'手势状态',
			        	field:'gustureStatus',
			        	width:100,
			        	align:'center',
			        	editor:{
				        		type:'combobox',
		        				options:{
		        					valueField: 'label',
		        					textField: 'value',
		        					data:[{label:'on',value:'on'},{label:'off',value:'off'}]
		        				}
			        		}
			        },{
			        	title:'手势密码',
			        	field:'gusturePassword',
			        	width:200,
			        	align:'center'
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
				rownumbers:true,
				onDblClickRow:doubleClick,
				onAfterEdit:submitEdit
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
			
			$.get('${pageContext.request.contextPath}/dpmManage/gesture_queryByEmpcode.action?userId=' + searchVal,function(result){
				// 注意这句不能少
				var data = $.parseJSON(result); 
				var dataArray = [];
				dataArray.push(data);
				if(data == '' || data.length == 0){
					$.messager.alert('提示','没有搜索到信息！','info');
					return;
				}
				$("#grid").datagrid('loadData',dataArray);
			});
		}
		
		function formatDate(val,row){
			var now = new Date(val);
			return now.format("yyyy-MM-dd hh:mm:ss");
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
			$.messager.confirm('提示','确定删除工号为："' + rowData.userId + '" 的数据？',function(r){
				if(r){
					$.post('${pageContext.request.contextPath}/dpmManage/gesture_deleteByEmpcode.action',{"userId":rowData.userId},function(data){
						
						if($.parseJSON(data).success){
							$.messager.alert('提示','删除成功！','info');
							$("#grid").datagrid('deleteRow',0);
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
			$("#grid").datagrid('cancelEdit',0);
			_editIndex = undefined;
		}); 
	});
	
	
	// 双击一行的事件
	function doubleClick(rowIndex, rowData) {
		// 开始编辑
		$("#grid").datagrid('beginEdit',rowIndex);
		// 获取编辑器
		var ed = $("#grid").datagrid('getEditor',{index:rowIndex,field:'gustureStatus'});
		// 状态发生改变触发结束编辑，提交
		$(ed.target).combobox({
			onChange:function(newValue,oldValue) {
				// 开始编辑
				$("#grid").datagrid('endEdit',rowIndex);
			}
		});
	}
	
	// 提交编辑
	function submitEdit(rowIndex, rowData, changes) {
		var searchVal = $("#search").val();
		$.post('${pageContext.request.contextPath}/dpmManage/gesture_update.action',rowData,function(data){
			if($.parseJSON(data).success){
				$.messager.alert('提示','修改成功！','info');
				// 重新请求
				$.get('${pageContext.request.contextPath}/dpmManage/gesture_queryByEmpcode.action?userId=' + searchVal,function(result){
					// 注意这句不能少
					var data = $.parseJSON(result); 
					var dataArray = [];
					dataArray.push(data);
					$("#grid").datagrid('loadData',dataArray);
				});
			} else {
				$.messager.alert('提示','修改失败！','info');
				// 重新请求
				$.get('${pageContext.request.contextPath}/dpmManage/gesture_queryByEmpcode.action?userId=' + searchVal,function(result){
					// 注意这句不能少
					var data = $.parseJSON(result); 
					var dataArray = [];
					dataArray.push(data);
					$("#grid").datagrid('loadData',dataArray);
				});
			}
		});
		
	
	}
	
	
	
</script>
<body>
	<div id="tb"> 
		<input id="search">
		<a id="del" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true">删除</a> 
		<a id="cancel-edit" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">取消</a> 
	</div> 
	<div id="grid"></div>
</body>
</html>