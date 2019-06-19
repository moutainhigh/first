<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>本地推送配置</title>
<link rel="stylesheet" type="text/css" href="/dpm/scripts/jquery-easyui-1.4/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="/dpm/scripts/jquery-easyui-1.4/themes/icon.css" />
<script type="text/javascript" src="/dpm/scripts/jquery-easyui-1.4/jquery.min.js"></script>
<script type="text/javascript" src="/dpm/scripts/jquery-easyui-1.4/jquery.easyui.min.js"></script>
<script type="text/javascript" src="/dpm/scripts/jquery-easyui-1.4/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="/dpm/scripts/common/common.js"></script>
<script type="text/javascript">
	$(function(){
		
		$("#grid").datagrid({
			toolbar:[
				{
					id:'add',
					text:'添加',
					iconCls:'icon-add'
				},'-',{
					id:'del',
					text:'删除',
					iconCls:'icon-cancel'
				}         
			],
			columns:[[
				{
					field:'id',
					title:'ID',
					align:'center',
					checkbox:true
				},{
					field:'appId',
					title:'应用编号',
					width:100,
					align:'center',
					hidden:true
				},{
					field:'appName',
					title:'应用名',
					width:100,
					align:'center'
				},{
					field:'pushCondition',
					title:'条件',
					width:200,
					align:'center'
				},{
					field:'title',
					title:'标题',
					width:200,
					align:'center'
				},{
					field:'linkAddr',
					title:'链接',
					width:200,
					align:'center'
				},{
					field:'content',
					title:'内容',
					width:200,
					align:'center'
				},{
					field:'intoMsg',
					title:'进入消息中心',
					width:100,
					align:'center',
					formatter:flagFormat
				},{
					field:'intime',
					title:'即时推送',
					width:100,
					align:'center',
					formatter:flagFormat
				},{
					field:'pushTime',
					title:'推送日期',
					width:150,
					align:'center',
					formatter:dateFormate
				},{
					field:'status',
					title:'状态',
					width:100,
					align:'center',
					formatter:statusFormate,
					editor:{
		        		type:'combobox',
        				options:{
        					valueField: 'label',
        					textField: 'value',
        					data:[{label:true,value:'有效'},{label:false,value:'无效'}]
        				}
	        		}
				}
				
			]],
			fit:true,
			border:false,
			fitColumns:true,
			striped:true,
			rownumbers:true,
			pagination:true,
			pageList:[20,50],
			pageNumber:0,
			pageSize:20,
			url:'${pageContext.request.contextPath}/dpmManage/nativePushPcAction_list.action',
			onDblClickRow:doubleClick,
			onAfterEdit:submitEdit
		});
		
		$('#search').searchbox({
			width : 180,
		    searcher : doSearch,
		    prompt : '输入关键字'
		});
		
		$('#orggrid').datagrid({
			toolbar:'#tb',
			columns:[[{
				field:'id',
	        	checkbox:true
	        },{
	        	title:'部门名称',
	        	field:'orgName',
	        	width:430,
	        	align:'center'
	        }]]
		});
		
		$('#add').click(function(){
			// 打开window窗口
			$("#win").window('open').panel({
				onOpen : function(){
					// 先清空表单，隐藏域手动清空
					$('#contentForm').form('reset');
					$("input[name='id']").val('')
				}
			});
		});
		
		// 删除
		$('#del').click(function(){
			var selectedArray = $('#grid').datagrid('getSelections');
			if(selectedArray.length == 0) {
				$.messager.alert('提示','必须至少选中一行删除！','warning');
				return;
			}
			var idArray = [];
			var rownumArray = []
			for(var i in selectedArray) {
				idArray.push(selectedArray[i].id);
				rownumArray.push($('#grid').datagrid('getRowIndex',selectedArray[i]) + 1)
			}
			var ids = idArray.join(",");
			$.messager.confirm('提示','确认要删除行号为 “' + rownumArray.join(",") + '” 的配置信息吗？',function(r){
				if(r){
					$.post('${pageContext.request.contextPath}/dpmManage/nativePushPcAction_delete.action',{"ids":ids},function(result){
						if($.parseJSON(result).success){
							$.messager.alert('提示','删除成功！','info');
							$('#grid').datagrid('reload');
						} else {
							$.messager.alert('错误','删除失败！','error');
							$('#grid').datagrid('reload');
						}
					});
				}
			});
		});
		
		// 提交按钮
		$('#submit-button').click(function(){
			// 校验表单是否填写完
			if(!$('#contentForm').form('validate')){
				$.messager.alert('提示','表单还未填写完！','warning');
				return;
			}
			
			// 校验是否选择了应用
			var appVal = $('#contentForm input[name="appId"]').val();
			if(appVal == '' || appVal == '0' || appVal == undefined){
				$.messager.alert('提示','请选择要推送的应用!','warning');
				return;
			}
			
			// 获取pushCondition
			var pushCondition = '';
			var conditionKey = $('#main-select').combobox('getValue');
			if(conditionKey == 'ALL'){
				// 选择了全员
				pushCondition = "ALL";
			} else if(conditionKey == 'JOBLEVEL'){
				// 选择了层级，判断是否选择了复选框
				var checkedArray = [];
				$("#joblevel-div input:checkbox[name='joblevel']:checked").each(function(){
					checkedArray.push($(this).val());
				});
				if(checkedArray.length == 0){
					// 没有选择，提示
					$.messager.alert('提示','请选择要推送的层级!','warning');
					return;
				}
				pushCondition = "{\"JOBLEVEL\":\""+checkedArray.join(",")+"\"}";
			} else if(conditionKey == 'ORG') {
				// 选择了部门，判断是否选择了
				var orgName = $("#orgName-div input[name='orgName']").val();
				if(orgName == ''){
					// 没有选择，提示
					$.messager.alert('提示','请选择要推送的部门!','warning');
					return;
				}
				pushCondition = "{\"ORG\":\""+orgName+"\"}";
			}
			// 将pushCondition设置到隐藏的input中
			$('input[name="pushCondition"]').val(pushCondition);
			// ajax请求提交表单
			$.post('${pageContext.request.contextPath}/dpmManage/nativePushPcAction_saveOrUpdate.action',$('#contentForm').serialize(),function(data){
				if($.parseJSON(data).success){
					$.messager.alert('提示','新增成功！','info');
					$('#grid').datagrid('reload');
				} else {
					$.messager.alert('提示','新增失败！','info');
					$('#grid').datagrid('reload');
				}
			});
			
			// 关闭窗口
			$('#win').window('close');
		});
		
		// 为主选择框添加选择事件
		$('#main-select').combobox({
			onSelect:function(record){
				if(record.value == 'JOBLEVEL') {
					// 隐藏部门显示框
					$('#orgName-div').removeAttr('hidden').attr('hidden',true);
					// 显示层级复选框
					$('#joblevel-div').removeAttr('hidden');
				} else if(record.value == 'ORG') {
					// 隐藏层级复选框
					$('#joblevel-div').removeAttr('hidden').attr('hidden',true);
					// 显示已选择的部门
					$('#orgName-div').removeAttr('hidden');
					// 打开新窗口
					$('#orgWin').window('open');
				} else {
					// 将部门显示框和层级复选框都隐藏
					$('#joblevel-div').removeAttr('hidden').attr('hidden',true);
					$('#orgName-div').removeAttr('hidden').attr('hidden',true);
				}
			}
		});
		
		// 搜索部门的删除按钮
		$('#del-btn').click(function(){
			var selectedRows = $('#orggrid').datagrid('getSelections');
			if(selectedRows.length == 0){
				$.messager.alert('提示','至少选择一行删除！','warning');
				return;
			}
			for(var i in selectedRows){
				var index = $("#orggrid").datagrid('getRowIndex',selectedRows[i]);
				$("#orggrid").datagrid('deleteRow',index);
			}
		});
		
		// 搜索部门的确定按钮
		$('#ok-btn').click(function(){
			var selectedRows = $('#orggrid').datagrid('getSelections');
			if(selectedRows.length == 0){
				$.messager.alert('提示','还没有选择推送的部门!','warning');
				return;
			}
			// 关闭搜索窗口
			$("#orgWin").window('close');
			// 将部门名称以,分隔显示到隐藏的input
			var orgNameArr = [];
			for(var i in selectedRows){
				orgNameArr.push(selectedRows[i].orgName);
			}
			var orgNames = orgNameArr.join(",");
			$("#orgName-textbox").textbox('setValue',orgNames);
			$("#orgName-div input[name='orgName']").val(orgNames);
		});
	});
	
	function doubleClick(rowIndex, rowData){
		// 开始编辑
		$("#grid").datagrid('beginEdit',rowIndex);
		// 获取编辑器
		var ed = $("#grid").datagrid('getEditor',{index:rowIndex,field:'status'});
		// 状态发生改变触发结束编辑，提交
		$(ed.target).combobox({
			onSelect:function(newValue,oldValue) {
				// 结束编辑
				$("#grid").datagrid('endEdit',rowIndex);
			}
		});
	}
	
	function submitEdit(rowIndex, rowData, changes){
		$.post('${pageContext.request.contextPath}/dpmManage/nativePushPcAction_saveOrUpdate.action',rowData,function(data){
			if($.parseJSON(data).success){
				$.messager.alert('提示','修改成功！','info');
				$('#grid').datagrid('reload');
			} else {
				$.messager.alert('提示','修改失败！','info');
				$('#grid').datagrid('reload');
			}
		});
	}
	
	function dateFormate(val,row) {
		if(val == '' || val == undefined){
			return '';
		}
		var now = new Date(val);
		return now.format("yyyy-MM-dd hh:mm:ss");
	}
	
	function statusFormate(val,row) {
		if(val == true){
			return "有效";
		}
		return "无效";
	}
	
	function flagFormat(val,row) {
		if(val == true){
			return "是";
		}
		return "否";
	}
	
	// 搜索
	function doSearch() {
		// 校验输入的工号
		var searchVal = $("#search").val();
		if(searchVal == ''){
			$.messager.alert('警告','搜索条件不能为空！','warning');
			return;
		}
		
		$.post('${pageContext.request.contextPath}/dpmManage/nativePushPcAction_queryOrgByName.action',{"orgName":searchVal},function(result){
			// 注意这句不能少
			var data = $.parseJSON(result); 
			if(data == '' || data.length == 0){
				$.messager.alert('提示','没有搜索到信息！','info');
				return;
			}
			for(var i in data){
				$("#orggrid").datagrid('appendRow',data[i]);
			}
		});
	}
	
	// 关闭新增窗口的事件
	function closeAddWinfunc(){
		// 将层级复选框和部门名称显示框隐藏，并且将其值清空
		$("#orgName-div input[name='orgName']").val('');
		$("#joblevel-div input[name='joblevel']").removeAttr('checked');
		
		$('#orgName-div').removeAttr('hidden').attr('hidden',true);
		$('#joblevel-div').removeAttr('hidden').attr('hidden',true);
	}
	
</script>
</head>
<body>
	<div id="grid"></div>
	<div id="win" class="easyui-window" data-options="onClose:closeAddWinfunc,modal:true,iconCls:'icon-save',title:'新增',closed:true,resizable:false"
		style="width:500px;height:540px;padding:10px;">
		<div style="padding:20px 20px 0px 20px">
			<form id="contentForm">
				<table cellpadding="7">
					<tr>
						<td>应用：</td>
						<td>
							<input class="easyui-combobox" name="appId"  data-options="editable:false,valueField:'appId',textField:'appCName',
	        					url:'${pageContext.request.contextPath }/dpmManage/getWelcomePageLinks.action',mode:'remote'" 
	        					style="width: 300px;"/>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<hr style="border: dashed 1px;color: #ddd;">
						</td>
					</tr>
					<tr>
						<td>条件：</td>
						<td>
							<input type="hidden" name="pushCondition"/>
							<select id="main-select" data-options="editable:false" class="easyui-combobox" name="conditionKey" style="width:300px;"> 
								<option value="ALL">全员</option> 
								<option value="JOBLEVEL">层级</option> 
								<option value="ORG">部门</option> 
							</select >
							<div id="joblevel-div"  hidden="true">
								<br>
                                 <input type="checkbox" name ="joblevel" value="04"/><span>04</span>
                                 <input type="checkbox" name ="joblevel" value="05"/><span>05</span>
                                 <input type="checkbox" name ="joblevel" value="06"/><span>06</span>
                                 <input type="checkbox" name ="joblevel" value="07"/><span>07</span>
                                 <input type="checkbox" name ="joblevel" value="08"/><span>08</span>
                                 <input type="checkbox" name ="joblevel" value="09"/><span>09</span>
                                 <input type="checkbox" name ="joblevel" value="10"/><span>10</span>
                                 <input type="checkbox" name ="joblevel" value="D"/><span>D</span>
                                 <input type="checkbox" name ="joblevel" value="C"/><span>C</span>
							</div>
							<div id="orgName-div" hidden="true">
								<br>
								<input id="orgName-textbox" class="easyui-textbox" data-options="editable:false,multiline:true" name="orgName" style="width: 300px;height:70px;"/>
							</div>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<hr style="border: dashed 1px;color: #ddd;">
						</td>
					</tr>
					<tr>
						<td>标题：</td>
						<td>
							<input class="easyui-textbox"  name="title" style="width: 300px;"/>
						</td>
					</tr>
					<tr>
						<td>链接地址：</td>
						<td>
							<input class="easyui-textbox"  name="linkAddr" style="width: 300px;"/>
						</td>
					</tr>
					<tr>
						<td>内容：</td>
						<td>
							<input class="easyui-textbox" name="content" style="width: 300px;"/>
						</td>
					</tr>
					<tr>
						<td>是否进入消息中心：</td>
						<td>
							<select class="easyui-combobox" data-options="required:true,editable:false" name="intoMsg" style="width:300px;"> 
								<option value="true" selected="selected">是</option> 
								<option value="false">否</option> 
							</select> 
						</td>
					</tr>
					<tr>
						<td>是否即时推送：</td>
						<td>
							<select class="easyui-combobox" data-options="required:true,editable:false" name="intime" style="width:300px;"> 
								<option value="true" selected="selected">是</option> 
								<option value="false">否</option> 
							</select> 
						</td>
					</tr>
					<tr>
						<td>推送日期：</td>
						<td>
							<input class="easyui-datetimebox" data-options="required:true" name="pushTime" style="width: 300px;"/>
						</td>
					</tr>
					<tr>
						<td>
							<a id="submit-button" data-options="iconCls:'icon-ok',required:true" class="easyui-linkbutton">提交</a>
						</td>
						<td></td>
					</tr>
				</table>
			</form>
		</div>	
	</div>
	
	<div id="orgWin" class="easyui-window" data-options="modal:true,iconCls:'icon-search',title:'查询',closed:true,resizable:false"
		style="width:500px;height:540px;padding:10px;">
		<div id="tb"> 
			<input id="search">
			<a id="del-btn" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true">删除</a> 
			<a id="ok-btn" class="easyui-linkbutton" data-options="iconCls:'icon-ok',plain:true">确定</a> 
		</div> 
		<div id="orggrid">
		</div>
	</div>
</body>
</html>