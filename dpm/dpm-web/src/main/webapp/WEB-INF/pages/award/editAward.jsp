<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div style="padding:10px 10px 10px 10px">
	<form id="editContent" method="post">
	    <table cellpadding="5">
	        <tr>
	            <td>ID:</td>
	            <td><input class="easyui-textbox" type="text" name="articleID" data-options="required:true,editable:false" style="width: 280px;"></input>
	            </td>
	        </tr>
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
	            	<input class="easyui-radio" type="radio" name="hasAward" value="true"/> 有
	            	<input class="easyui-radio" type="radio" name="hasAward" value="false"/> 无
	            </td>
	        </tr>
	        <tr>
	            <td>奖金:</td>
	            <td>
	                <input class="easyui-textbox" type="text" data-options="required:true" name="reward" style="width: 280px;"/>
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
		/*  $.post("/dpm/award/toSaveAward.action",$("#content").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','修改悬赏成功!');
				$('#awardEdit').window('close');
				$("#awardList").datagrid("reload");
				clearForm();
			}else{
				$.messager.alert('提示','修改悬赏失败!');
			}
		});  */
		
	$.ajax({
			
			   type: "POST",
			   url: "/dpm/dpmManage/toSaveAward.action",
			   data: $("#editContent").serialize(),
			   
			   statusCode: {204: function() {
				   $.messager.alert('提示','修改悬赏成功!');
				   $('#awardEdit').window('close');
				   $("#awardList").datagrid("reload");
				   clearForm();
				  },
				  500:function(){
					  $.messager.alert('提示','修改悬赏失败!');
					  $('#awardEdit').window('close');
					  $("#awardList").datagrid("reload");
					  clearForm();
				  }
			   }
		});
	}
	function clearEditForm(){
		$('#editContent').form('reset');
	}
</script>