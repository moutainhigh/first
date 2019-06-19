<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div style="padding:10px 10px 10px 10px">
	<form id="editContentHx" method="post">
	    <table cellpadding="5">
	        <tr>
	            <td>编号:</td>
	            <td>
	            	<input class="easyui-numberbox" type="text" id="id" name="id" data-options="min:0,max:100000000,precision:0,disabled:true" style="width: 280px;"></input>
	            	<input type="hidden" id="operationupdate" name="operation" value="update"/>
	            </td>
	        </tr>
	        <tr>
	            <td>问题:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" id="questionid" name="question" data-options="multiline:true" style="width: 280px;"/>
	            </td>
	        </tr>
	        <tr>
	            <td>答案:</td>
	            <td><input class="easyui-textbox" type="text" id="answerid" name="answer" data-options="multiline:true" style="width: 280px;height: 100px;"></input></td>
	        </tr>
	    </table>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitEditFormUpdate()">修改</a>
	    <!-- <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearEditForm()">重置</a> -->
	</div>
</div>
<script type="text/javascript">
	function submitEditFormUpdate(){
		if(!$('#editContentHx').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		debugger;
		var operation = $("#operationupdate").val();
		
		var id = $("#id").val();
		var question = $("#questionid").val();
		var answer = $("#answerid").val();
		
		$.ajax({
			
			   type: "POST",
			   url: "/dpm/dpmManage/hxQuestionPc_insertOrUpdate.action",
			   data: {"updateid":id,"operation":operation,"question":question,"answer":answer},
			   statusCode: {
				  204: function() {
					  $.messager.alert('提示','修改成功!');
					  $('#questionInfoEdit').window('close');
					  $("#questionInfoList").datagrid("reload");
					  clearEditForm();
				  },
				  500:function(){
					  $.messager.alert('提示','修改失败!');
					  $('#questionInfoEdit').window('close');
					  $("#questionInfoList").datagrid("reload");
					  clearEditForm();
				  }
			   }
		});
	}
	function clearEditForm(){
		$('#editContentHx').form('reset');
	}
</script>