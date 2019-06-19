<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div style="padding:10px 10px 10px 10px">
	<form id="addContent" method="post">
	    <table cellpadding="5">
	        <tr>
	            <td>应用编号:</td>
	            <td>
	            	<input class="easyui-numberbox" type="text" name="applyCode" data-options="min:0,max:99,precision:0,required:true" style="width: 280px;"></input>
	            	<input type="hidden" name="operation" value="save">
	            </td>
	        </tr>
	        <tr>
	            <td>文件数量:</td>
	            <td><input class="easyui-numberbox" type="text" name="count" data-options="min:0,max:1000,precision:0,required:true" style="width: 280px;"></input></td>
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
		
		var appId = $("#applyCode").val();
		if(appId == ''){
			$.messager.alert('提示','应用编号不能为空!');
			return;
		}
		var rows = $('#h5FileInfoList').datagrid('getRows')
		for(var i = 0; i < rows.length; i++){
			if(appId == rows[i]['applyCode']){
				$.messager.alert('提示','应用编号' + appId + '已存在!');
				return;
			}
		}
		
		if(!$('#addContent').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		
		$.ajax({
			
			   type: "POST",
			   url: "/dpm/dpmManage/h5AppFileComparePc_insertOrUpdate.action",
			   data: $("#addContent").serialize(),
			   
			   statusCode: {201: function() {
				   $.messager.alert('提示','新增成功!');
				   $('#h5FileInfoAdd').window('close');
				   $("#h5FileInfoList").datagrid("reload");
				   clearForm();
				  },
				  500:function(){
					  $.messager.alert('提示','新增失败!');
					  $('#h5FileInfoAdd').window('close');
					  $("#h5FileInfoList").datagrid("reload");
					  clearForm();
				  }
			   }
		});
	}
	function clearAddForm(){
		$('#addContent').form('reset');
	}
</script>