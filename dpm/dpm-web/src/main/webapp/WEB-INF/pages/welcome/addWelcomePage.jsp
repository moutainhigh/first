<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div style="padding:10px 10px 10px 10px">
	<form id="addContent" method="post" enctype="multipart/form-data">
	    <table cellpadding="5">
	        <tr>
	            <td>主题:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="subject" data-options="required:true" style="width: 280px;"></input>
	            </td>
	        </tr>
	        <tr>
	            <td>欢迎页图片:</td>
	            <td>
	            	<input class="easyui-filebox" name="file" data-options="prompt:'选择图片...',required:true" style="width:280px;">
	            </td>
	        </tr>
	        <tr>
	        	<td>欢迎页链接:</td>
	        	<td>
	        		<input id="linkselect" class="easyui-combobox" name="link" data-options="valueField:'appId',textField:'appCName',
	        			url:'${pageContext.request.contextPath }/dpmManage/getWelcomePageLinks.action',mode:'remote'" />
	        	</td>
	        </tr>
	        <tr>
	            <td>欢迎页展示时间:</td>
	            <td>
	            	<input class="easyui-datetimebox" type="text" name="startDate" data-options="formatter:formatDate,required:true" />
	            	-
	            	<input class="easyui-datetimebox" type="text" name="endDate" data-options="formatter:formatDate,required:true" />
	            </td>
	        </tr>
	        <tr>
	            <td>欢迎页存活时间（秒）:</td>
	            <td>
	            	 <input class="easyui-numberbox" type="text" name="existTime" data-options="min:0,precision:0" style="width: 280px;"/>
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
		var formData = new FormData($("#addContent")[0]);  
		$.ajax({
			   type: "POST",
			   url: "/dpm/dpmManage/saveEditPage.action",
			   data: formData,
			   async: false,  
	           cache: false,  
	           contentType: false,  
	           processData: false,
			   statusCode: {201: function() {
				   $.messager.alert('提示','新增成功!');
				   $('#welcomPageAdd').window('close');
				   $("#welcomPageList").datagrid("reload");
				   clearAddForm();
				  },
				  500:function(){
					  $.messager.alert('提示','新增失败!');
					  $('#welcomPageAdd').window('close');
					  $("#welcomPageList").datagrid("reload");
					  clearAddForm();
				  }
			   }
		});
	}
	function clearAddForm(){
		$('#addContent').form('reset');
	}
</script>