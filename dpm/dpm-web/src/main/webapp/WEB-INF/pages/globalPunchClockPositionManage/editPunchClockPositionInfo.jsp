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
	            <td>部门ID:</td>
	            <td>
	            	<input class="easyui-numberbox" type="text" id="orgid" name="orgid" data-options="min:0,max:100000000,precision:0,disabled:true" style="width: 280px;"></input>
	            	<input type="hidden" id="operationupdate" name="operation" value="update">
	            </td>
	        </tr>
	        <tr>
	            <td>地址:</td>
	            <td><input class="easyui-textbox" type="text" id="salesdepartaddr" name="salesdepartaddr" data-options="validType:'length[0,30]',disabled:true" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>部门经理工号:</td>
	            <td><input class="easyui-textbox" type="text" id="managerid" name="managerid" data-options="validType:'length[0,30]',disabled:true" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>直属上级部门ID:</td>
	            <td><input class="easyui-numberbox" type="text" id="parentorgid" name="parentorgid" data-options="min:0,max:100000000,precision:0,disabled:true" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>纬度:</td>
	            <td><input class="easyui-textbox" type="text" id="latitude" name="latitude" data-options="validType:'length[0,30]'" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>经度:</td>
	            <td><input class="easyui-textbox" type="text" id="longitude" name="longitude" data-options="validType:'length[0,30]'" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>半径:</td>
	            <td><input class="easyui-numberbox" type="text" id="radius" name="radius" data-options="min:0,max:100000000,precision:0" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>审核状态:</td>
	            <td><input class="easyui-numberbox" type="text" id="verifystatus" name="verifystatus" data-options="min:0,max:2,precision:0" style="width: 280px;"></input></td>
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
		if(!$('#editContent').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		debugger;
		var operation = $("#operationupdate").val();
		
		var id = $("#id").val();
		var latitude = $("#latitude").val();
		var longitude = $("#longitude").val();
		var radius = $("#radius").val();
		var verifystatus = $("#verifystatus").val();
		
		$.ajax({
			
			   type: "POST",
			   url: "/dpm/dpmManage/punchClockPositionGlobalPc_insertOrUpdate.action",
			   data: {"updateid":id,"operation":operation,
				      "latitude":latitude,"longitude":longitude,"radius":radius,"verifystatus":verifystatus},
			   
			   statusCode: {
				  204: function() {
					  $.messager.alert('提示','修改成功!');
					  $('#appPermissionInfoEdit').window('close');
					  $("#appPermissionInfoList").datagrid("reload");
					  clearForm();
				  },
				  500:function(){
					  $.messager.alert('提示','修改失败!');
					  $('#appPermissionInfoEdit').window('close');
					  $("#appPermissionInfoList").datagrid("reload");
					  clearForm();
				  }
			   }
		});
	}
	function clearEditForm(){
		$('#editContent').form('reset');
	}
</script>