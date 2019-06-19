<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div style="padding:10px 10px 10px 10px">
	<form id="editContent" method="post">
	    <table cellpadding="5">
	        <tr>
	            <td>编号:</td>
	            <td><input class="easyui-numberbox" type="text" id="id" name="id" data-options="min:0,max:100000000,precision:0,disabled:true" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>工号:</td>
	            <td><input class="easyui-textbox" type="text" id="userid" name="userid" data-options="validType:'length[0,30]'" style="width: 280px;"></input></td>
				<input type="hidden" id="operation" name="operation" value="update">
			</tr>
	    </table>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitEditForm()">修改</a>
	    <!-- <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearEditForm()">重置</a> -->
	</div>
</div>
<script type="text/javascript">
	function submitEditForm(){
		if(!$('#editContent').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		debugger;
		var id = $("#id").val();
		var userid = $("#userid").val();
		var operation = $("#operation").val();
		
		$.ajax({
			
			   type: "POST",
			   url: "/dpm/dpmManage/autoPunchGlobalAddress_insertOrUpdate.action",
			   data: {"updateid":id,"userid":userid,"operation":operation},
			   
			   statusCode: {
				  204: function() {
					  $.messager.alert('提示','修改成功!');
					  $('#appPermissionInfoEdit').window('close');
					  $("#appPermissionInfoList").datagrid("reload");
					  clearForm();
				  },
				  500:function(){
					  $.messager.alert('提示','修改失败!');
					  $('#appPermissionInfoEdit').window('close');
					  $("#appPermissionInfoList").datagrid("reload");
					  clearForm();
				  }
			   }
		});
	}
	function clearEditForm(){
		$('#editContent').form('reset');
	}
</script>