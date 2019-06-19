<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div style="padding:10px 10px 10px 10px">
	<form id="editContent" method="post">
	    <table cellpadding="5">
	        <tr>
	            <td>应用编号:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="applyCode" data-options="required:true,editable:false" style="width: 280px;"></input>
	           		<input type="hidden" name="operation" value="update">
	            </td>
	        </tr>
	        <tr>
	            <td>文件数量:</td>
	            <td><input class="easyui-numberbox" type="text" name="count" data-options="min:0,max:1000,precision:0,required:true" style="width: 280px;"></input></td>
	        </tr>
	    </table>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitEditForm()">修改</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearEditForm()">重置</a>
	</div>
</div>
<script type="text/javascript">
	function submitEditForm(){
		if(!$('#editContent').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		
	$.ajax({
			
			   type: "POST",
			   url: "/dpm/dpmManage/h5AppFileComparePc_insertOrUpdate.action",
			   data: $("#editContent").serialize(),
			   
			   statusCode: {204: function() {
				   $.messager.alert('提示','修改成功!');
				   $('#h5FileInfoEdit').window('close');
				   $("#h5FileInfoList").datagrid("reload");
				   clearForm();
				  },
				  500:function(){
					  $.messager.alert('提示','修改失败!');
					  $('#h5FileInfoEdit').window('close');
					  $("#h5FileInfoList").datagrid("reload");
					  clearForm();
				  }
			   }
		});
	}
	function clearEditForm(){
		$('#editContent').form('reset');
	}
</script>