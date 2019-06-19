<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="easyui-layout" style="width: 100%;height: 100%">
	<div  data-options="region:'north',border:false" style="padding: 5px">
		<a id="editbutton" class="easyui-linkbutton" onclick="submitEditForm();" data-options="iconCls:'icon-save',plain:true">修改</a>
	</div>
	<div data-options="region:'center',border:false">
		<form id="editContent" method="post">
		    <table cellpadding="5">
		        <tr>
		            <td>ID:</td>
		            <td><input class="easyui-textbox" type="text" name="vid" data-options="required:true,editable:false" style="width: 280px;"></input>
		            </td>
		        </tr>
		        <tr>
		            <td>操作系统:</td>
		            <td><input class="easyui-textbox" type="text" name="osType" data-options="required:true,editable:false" style="width: 280px;"></input></td>
		        </tr>
		        <tr>
		            <td>版本号:</td>
		            <td><input class="easyui-textbox" type="text" name="version" data-options="required:true" style="width: 280px;"></input></td>
		        </tr>
		        <tr>
		            <td>强制更新:</td>
		            <td>
		            	<input class="easyui-radio" type="radio" name="rforce" value="1"/> 是
		            	<input class="easyui-radio" type="radio" name="rforce" value="0" checked="checked"/> 否
		            </td>
		        </tr>
		        <tr>
		            <td>下载地址:</td>
		            <td>
		            	 <input class="easyui-textbox" type="text" name="url" data-options="required:true,multiline:true" style="width: 280px;height: 50px"/>
		            </td>
		        </tr>
		        <tr>
		            <td>更新内容:</td>
		            <td>
		                <input  class="easyui-textbox" name="content" data-options="required:true,multiline:true" style="width: 350px;height:200px;"/>
		            </td>
		        </tr>
		    </table>
		</form>
	</div>
</div>
<script type="text/javascript">
	function submitEditForm(){
		if(!$('#editContent').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		
		$.post("${pageContext.request.contextPath}/dpmManage/versionConfig_update.action",
				$("#editContent").serialize(),
				function(data){
					if(data.success){
						$.messager.alert("提示","修改成功！","info");
					}else{
						$.messager.alert("错误","修改失败！","error");
					}
					$("#editContent").form('reset');
					$("#editwin").window('close');
					$("#grid").datagrid('reload');
		});
	}
</script>