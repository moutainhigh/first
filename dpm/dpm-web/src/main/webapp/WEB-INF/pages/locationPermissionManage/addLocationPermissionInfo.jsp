<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div style="padding:10px 10px 10px 10px">
	<form id="addContent" method="post">
	    <table cellpadding="5">
	        <tr>
	            <td>部门编号:</td>
	            <td>
					<input class="easyui-numberbox" type="text" name="orgid" data-options="min:0,max:100000000,precision:0,required:true" style="width: 280px;"></input>
					<input type="hidden" name="operation" value="save">
				</td>
	        </tr>
	        <tr>
	            <td>工号:</td>
	            <td><input class="easyui-textbox" type="text" name="userid" data-options="validType:'length[0,30]',required:true" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>层级:</td>
	            <td><input class="easyui-textbox" type="text" name="level" data-options="validType:'length[0,30]'" style="width: 280px;"></input></td>
	        </tr>
	    </table>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitAddForm()">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearAddForm()">重置</a>
	</div>
</div>
<script type="text/javascript">
	function submitAddForm(){

		/* 
		var rows = $('#appPermissionInfoList').datagrid('getRows')
		for(var i = 0; i < rows.length; i++){
			if(appId == rows[i]['appid']){
				$.messager.alert('提示','应用编号' + appId + '已存在!');
				return;
			}
		}
		 */
		/*  
		if(!$('#addContent').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		 */
		$.ajax({
			
			   type: "POST",
			   url: "/dpm/dpmManage/locationPermissionPc_insertOrUpdate.action",
			   data: $("#addContent").serialize(),
			   
			   statusCode: {
				  201: function() {
					  $.messager.alert('提示','新增成功!');
					  $('#appPermissionInfoAdd').window('close');
					  $("#appPermissionInfoList").datagrid("reload");
                      clearAddForm();
				  },
				  500:function(){
					  $.messager.alert('提示','新增失败!');
					  $('#appPermissionInfoAdd').window('close');
					  $("#appPermissionInfoList").datagrid("reload");
                      clearAddForm();
				  }
			   }
		});
	}
	function clearAddForm(){
		$('#addContent').form('reset');
	}
</script>