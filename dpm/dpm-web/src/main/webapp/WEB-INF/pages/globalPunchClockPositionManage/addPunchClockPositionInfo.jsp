<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div style="padding:10px 10px 10px 10px">
	<form id="addContent" method="post">
	    <table cellpadding="5">
	        <tr>
	            <td>部门名称:</td>
	            <td>
	            	<!-- <input class="easyui-numberbox" type="text" id="orgid" name="orgid" data-options="min:0,max:100000000,precision:0" style="width: 280px;"></input> -->
	            	<input class="easyui-textbox" type="text" id="orgnamea" name="orgname" data-options="validType:'length[0,30]'" style="width: 280px;"></input>
	            	<input type="hidden" id="operation" name="operation" value="save">
	            </td>
	        </tr>
	         <tr>
	            <td>地址:</td>
	            <td><input class="easyui-textbox" type="text" id="salesdepartaddra" name="salesdepartaddr" data-options="validType:'length[0,30]'" style="width: 280px;"></input></td>
	        </tr>
	        <!-- <tr>
	            <td>部门经理工号:</td>
	            <td><input class="easyui-textbox" type="text" id="managerid" name="managerid" data-options="validType:'length[0,30]'" style="width: 280px;"></input></td>
	        </tr> -->
	        <!-- <tr>
	            <td>直属上级部门ID:</td>
	            <td><input class="easyui-numberbox" type="text" id="parentorgid" name="parentorgid" data-options="min:0,max:100000000,precision:0" style="width: 280px;"></input></td>
	        </tr> -->
	        <tr>
	            <td>纬度:</td>
	            <td><input class="easyui-textbox" type="text" id="latitudea" name="latitude" data-options="validType:'length[0,30]'" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>经度:</td>
	            <td><input class="easyui-textbox" type="text" id="longitudea" name="longitude" data-options="validType:'length[0,30]'" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>半径:</td>
	            <td><input class="easyui-numberbox" type="text" id="radiusa" name="radius" data-options="min:0,max:100000000,precision:0" style="width: 280px;"></input></td>
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
		
		var appId = $("#appid").val();
		if(appId == ''){
			$.messager.alert('提示','应用编号不能为空!');
			return;
		}
		/* 
		var rows = $('#appPermissionInfoList').datagrid('getRows')
		for(var i = 0; i < rows.length; i++){
			if(appId == rows[i]['appid']){
				$.messager.alert('提示','应用编号' + appId + '已存在!');
				return;
			}
		}
		 */
		/*  
		if(!$('#addContent').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		 */
		$.ajax({
			
			   type: "POST",
			   url: "/dpm/dpmManage/punchClockPositionGlobalPc_insertOrUpdate.action",
			   data: $("#addContent").serialize(),
			   
			   statusCode: {
				  201: function() {
					  $.messager.alert('提示','新增成功!');
					  $('#appPermissionInfoAdd').window('close');
					  $("#appPermissionInfoList").datagrid("reload");
					  clearForm();
				  },
				  500:function(){
					  $.messager.alert('提示','新增失败!');
					  $('#appPermissionInfoAdd').window('close');
					  $("#appPermissionInfoList").datagrid("reload");
					  clearForm();
				  },
				  501:function(){
					  $.messager.alert('提示','新增失败,部门不存在!');
					  $('#appPermissionInfoAdd').window('close');
					  $("#appPermissionInfoList").datagrid("reload");
					  clearForm();
				  }
			   }
		});
	}
	function clearAddForm(){
		$('#addContent').form('reset');
	}
</script>