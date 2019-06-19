<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div style="padding:10px 10px 10px 10px">
	<form id="addContent" method="post">
	    <table cellpadding="5">
	        <tr>
	            <td>发布人:</td>
	            <td><input class="easyui-textbox" type="text" name="publisher" data-options="required:true" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>发布人邮箱:</td>
	            <td><input class="easyui-textbox" type="text" name="publisherEmail" data-options="required:true" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>发布时间:</td>
	            <td><input class="easyui-datebox" type="text" name="publishTime" data-options="formatter:formatDate" />
	            </td>
	        </tr>
	        <tr>
	            <td>招聘职位:</td>
	            <td>
	            	 <input class="easyui-textbox" type="text" name="recruitPosition" data-options="required:true" style="width: 280px;"/>
	            </td>
	        </tr>
	        <tr>
	            <td>标题:</td>
	            <td>
	                <input class="easyui-textbox" type="text" name="title" data-options="required:true" style="width: 280px;"/>
	            </td>
	        </tr>
	        <tr>
	            <td>内容:</td>
	            <td>
	            	<textarea class="easyui-validatebox" name="content" data-options="required:true" style="height:300px;width:500px"></textarea>
	            </td>
	        </tr>
	        <tr>
	            <td>是否有奖金:</td>
	            <td>
	            	<input class="easyui-radio" type="radio" name="hasAward" value="true" checked="checked"/> 有
	            	<input class="easyui-radio" type="radio" name="hasAward" value="false"/> 无
	            </td>
	        </tr>
	        <tr>
	            <td>奖金:</td>
	            <td>
	                <input class="easyui-textbox" data-options="required:true" type="text" name="reward" style="width: 280px;"/>
	            </td>
	        </tr>
	        <tr>
	            <td>联系人:</td>
	            <td>
	                <input class="easyui-textbox" type="text" name="contactPerson" data-options="required:true" style="width: 280px;"/>
	            </td>
	        </tr>
	        <tr>
	            <td>联系人电话:</td>
	            <td>
	                <input class="easyui-textbox" type="text" name="contactPhone" data-options="required:true" style="width: 280px;"/>
	            </td>
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
		if(!$('#addContent').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		/* $.post("/user/save",$("#content").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','新增会员成功!');
				$('#userAdd').window('close');
				$("#userList").datagrid("reload");
				clearForm();
			}else{
				$.messager.alert('提示','新增会员失败!');
			}
		}); */
		
		$.ajax({
			
			   type: "POST",
			   url: "/dpm/dpmManage/toSaveAward.action",
			   data: $("#addContent").serialize(),
			   
			   statusCode: {201: function() {
				   $.messager.alert('提示','新增会员成功!');
				   $('#awardAdd').window('close');
				   $("#awardList").datagrid("reload");
				   clearForm();
				  },
				  500:function(){
					  $.messager.alert('提示','新增会员失败!');
					  $('#awardAdd').window('close');
					  $("#awardList").datagrid("reload");
					  clearForm();
				  }
			   }
		});
	}
	function clearAddForm(){
		$('#addContent').form('reset');
	}
</script>