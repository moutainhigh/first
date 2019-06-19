<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div style="padding:10px 10px 10px 10px">
	<form id="addContentHx" method="post">
	    <table cellpadding="5">
	        <tr>
	            <td>问题:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" id="questionAdd" name="question" data-options="multiline:true" style="width: 280px;"></input>
	            	<input type="hidden" id="operation" name="operation" value="save">
	            </td>
	        </tr>
	         <tr>
	            <td>答案:</td>
	            <td><input class="easyui-textbox" type="text" id="answerAdd" name="answer" data-options="multiline:true" style="width: 280px;height: 120px;"></input></td>
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
		
		$.ajax({
			
			   type: "POST",
			   url: "/dpm/dpmManage/hxQuestionPc_insertOrUpdate.action",
			   data: $("#addContentHx").serialize(),
			   
			   statusCode: {
				  201: function() {
					  $.messager.alert('提示','新增成功!');
					  $('#questionInfoAdd').window('close');
					  $("#questionInfoList").datagrid("reload");
					  clearAddForm();
				  },
				  500:function(){
					  $.messager.alert('提示','新增失败!');
					  $('#questionInfoAdd').window('close');
					  $("#questionInfoList").datagrid("reload");
					  clearAddForm();
				  },
				  501:function(){
					  $.messager.alert('提示','新增失败,部门不存在!');
					  $('#questionInfoAdd').window('close');
					  $("#questionInfoList").datagrid("reload");
					  clearAddForm();
				  }
			   }
		});
	}
	function clearAddForm(){
		$('#addContentHx').form('reset');
	}
</script>