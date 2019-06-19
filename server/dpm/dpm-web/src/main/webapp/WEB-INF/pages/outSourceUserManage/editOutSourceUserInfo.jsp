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
	            <td><input class="easyui-textbox" type="text" id="staff_id" name="staff_id" data-options="validType:'length[0,30]',disabled:true" style="width: 280px;"></input></td>
	        	<input type="hidden" id="operation" name="operation" value="update">
	        </tr>
	        <tr>
	            <td>旧密码:</td>
	            <td><input class="easyui-textbox" type="text" id="passwd" name="passwd" data-options="validType:'length[0,30]',disabled:true" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>新密码:</td>
	            <td><input class="easyui-textbox" type="text" id="newPasswd" name="newPasswd" data-options="validType:'length[0,30]'" style="width: 280px;"></input></td>
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
		var staff_id = $("#staff_id").val();
		var newPasswd = $("#newPasswd").val();
		var operation = $("#operation").val();
		var id = $("#id").val();
		
		$.ajax({
		   
		   type:"POST",
		   url:"/dpm/dpmManage/outSourceUserManagerPc_updateOutUser.action",
		   contentType:"application/json; charset=utf-8",
		   data:{"updateid":id,"staff_id":staff_id,"newPasswd":newPasswd},
		   //data:$("#editContent").serialize(),
		   success:function(responseText,status,jqXHR){
			   console.log(jqXHR.status);
			   $.messager.alert('提示','修改成功!');
			   $('#outSourceUserInfoEdit').window('close');
			   $("#outSourceUserInfoList").datagrid("reload");
			   clearEditForm();
		   },
		   error:function(response){
			   if(response.status == 599){
				   $.messager.alert('提示','修改失败:密码过于简单!');
			   }else{
				   $.messager.alert('提示','修改失败!');
			   }
			   $('#outSourceUserInfoEdit').window('close');
			   $("#outSourceUserInfoList").datagrid("reload");
			   clearEditForm();
		   }
		   /* statusCode: {
			  204: function() {
				  $.messager.alert('提示','修改成功!');
				  $('#outSourceUserInfoEdit').window('close');
				  $("#outSourceUserInfoList").datagrid("reload");
				  clearEditForm();
			  },
			  500:function(){
				  $.messager.alert('提示','修改失败!');
				  $('#outSourceUserInfoEdit').window('close');
				  $("#outSourceUserInfoList").datagrid("reload");
				  clearEditForm();
			  }
		   } */
		   
		});
	}
	function clearEditForm(){
		$('#editContent').form('reset');
	}
</script>