<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<div style="padding:10px 10px 10px 10px">
	<form id="editApplyStoreContent" method="post" >
	    <table cellpadding="8">
	        <tr>
	            <td>应用编号:</td>
	            <td><input class="easyui-numberbox" type="text" name="appId" data-options="min:1,max:99,precision:0,required:false,editable:false" style="width: 280px;"></input>
	            </td>
	        </tr>
	        <tr>
	            <td>英文名称:</td>
	            <td><input class="easyui-textbox" type="text" name="enName" data-options="validType:'length[0,30]',required:true" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>中文名称:</td>
	            <td><input class="easyui-textbox" type="text" name="cnName" data-options="validType:'length[0,30]',required:true" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>资源大小:</td>
	            <td><input class="easyui-textbox" type="text" name="size" data-options="validType:'length[0,16]'" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	        	<td>自动更新:</td>
	        	<td>
	        		<select class="easyui-combobox" data-options="required:true,editable:false,onChange:showEditDialog" name="autoUpdate" style="width:280px;"> 
						<option value="true">是</option> 
						<option value="false" selected="selected">否</option> 
					</select> 
	        	</td>
	        </tr>
	        
	        <tr hidden="true" id="edit-autoUpdateConditionTr">
	        	<td>自动更新条件:</td>
	        	<td>
					<input id="edit-autoUpdateConditionTextBox" class="easyui-textbox" data-options="editable:false" style="width: 280px;"/>
	       			<input id="edit-autoUpdateCondition" type="hidden" name="autoUpdateCondition"/>
	       		</td>
	        </tr>
	        <tr>
	            <td>应用状态:</td>
	            <td>
	            	<select class="easyui-combobox" data-options="required:true,editable:false" name="status" style="width:280px;"> 
						<option value="on">on</option> 
						<option value="off">off</option> 
					</select> 
	            </td>
	        </tr>
	        <tr>
	            <td>合伙人权限:</td>
	            <td>
	            	<select class="easyui-combobox" data-options="required:true,editable:false" name="partnerPermission" style="width:280px;"> 
						<option value='true' >开放</option> 
						<option value='false'>不开放</option> 
					</select> 
	            </td>
	        </tr>
	        <tr>
	            <td>应用版本号:</td>
	            <td>
	                <input class="easyui-textbox" type="text" name="versionType" data-options="validType:'length[0,50]',required:false" style="width: 280px;"/>
	            </td>
	        </tr>
	        <tr>
	            <td>是否属于应用商店应用:</td>
	            <td>
	            	<input class="easyui-radio" type="radio" name="defaultApp" value="0" /> 不是
	            	<input class="easyui-radio" type="radio" name="defaultApp" value="1" /> 是
	            </td>
	        </tr>
	        <tr>
	            <td>是否需要更新H5资源:</td>
	            <td>
	            	<input class="easyui-radio" type="radio" name="hasResources" value="0"/> 不需要
	            	<input class="easyui-radio" type="radio" name="hasResources" value="1" /> 需要
	            </td>
	        </tr>
	        <tr>
	        	<td>数据源:</td>
	        	<td>
					<input class="easyui-radio" type="radio" name="downloadLine"  value="1"/> TECHOWN
	            	<input class="easyui-radio" type="radio" name="downloadLine" value="0"/> DPM
	        	</td>
	        </tr>
	        <tr>
	            <td>下载路径:</td>
	            <td><input class="easyui-textbox" type="text" name="downloadUrl" data-options="validType:'length[16,128]'" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>排序:</td>
	            <td>
	            	<input class="easyui-numberbox" name="appOrder" data-options="min:0,max:10000,required:true" style="width: 280px;"/>
	            </td>
	        </tr>
	         <tr>
	            <td>上线安卓版本:</td>
	            <td>
	                <input class="easyui-textbox" type="text" name="androidAppVersion" data-options="required:false" style="width: 280px;"/>
	            </td>
	        </tr>
	         <tr>
	            <td>上线ios版本:</td>
	            <td>
	                <input class="easyui-textbox" type="text" name="iosAppVersion" data-options="required:false" style="width: 280px;"/>
	            </td>
	        </tr>
	        <tr>
	            <td>应用图片1:</td>
	            <td>
	            	<input type="hidden" id="appFileUrl1Id" name="appFileUrl1" />
					<input class="easyui-filebox" name="appFile1" id="appFileId1" 
	            			data-options="prompt:'请选择图片...'" style="width:100%" />
	            </td>
	        </tr>
	        <tr>
	            <td>应用图片2:</td>
	            <td>
	            	<input type="hidden" id="appFileUrl2Id" name="appFileUrl2" />
	            	<input class="easyui-filebox" id="appFileId2" name="appFile2" 
	            			data-options="prompt:'请选择图片...'" style="width:100%" />
	            </td>
	        </tr>
	        <tr>
	            <td>应用图片3:</td>
	            <td>
	            	<input type="hidden" id="appFileUrl3Id" name="appFileUrl3" />
	            	<input class="easyui-filebox" id="appFileId3" name="appFile3" 
	            			data-options="prompt:'请选择图片...'" style="width:100%"/>
	            </td>
	        </tr>
	        <tr>
	            <td>应用简介:</td>
	            <td>
	            	<textarea class="textarea easyui-validatebox" name="summary" data-options="validType:'length[0,150]',required:false" 
	            	style="height:80px;width:500px"></textarea>
	            </td>
	        </tr>
	        <tr>
	            <td>内容提要:</td>
	            <td>
	            	<textarea class="textarea easyui-validatebox" name="appContent" data-options="validType:'length[0,400]',required:false" 
	            	style="height:200px;width:500px"></textarea>
	            </td>
	        </tr>
	        <tr>
	            <td>创建时间:</td>
	            <td>
		            <input class="easyui-datebox" readonly="readonly" type="text" name="createTime"
		            	data-options="required:false,editable:false" />
	            </td>
	        </tr>
	        <tr id="appFileUrlTr" hidden="true">
	            <td>已上传应用图片:</td>
	            <td>
	            	<div style="float: left;width: 100px;height: 50px;display: none;" id="appFileUrlDiv1"
		            		onmouseover="mouseover('appFileUrl1IdDiv')" onmouseout="mouseout('appFileUrl1IdDiv')">
	            		<div title="删除" style="display: none;" id="appFileUrl1IdDiv" >
	            			<a href="javascript:void(0)" onclick="deleteImg('appFileUrlDiv1','appFileUrl1Id');">删除</a>
	            		</div>
		            	<a href="" target="_blank" id="appFileUrl1IdHref" >
							<img src="" width="40px" id="appFileUrl1IdPic" height="40px">
						</a>
	            	</div>
	            	<div style="float:left;width: 100px;height:50px;display: none;" id="appFileUrlDiv2"
	            		onmouseover="mouseover('appFileUrl2IdDiv')" onmouseout="mouseout('appFileUrl2IdDiv')">
	            		<div title="删除" style="display: none;" id="appFileUrl2IdDiv">
	            			<a href="javascript:void(0)" onclick="deleteImg('appFileUrlDiv2','appFileUrl2Id');">删除</a>
	            		</div>
			            <a href="" target="_blank" id="appFileUrl2IdHref" >
							<img src="" width="40px" id="appFileUrl2IdPic" height="40px">
						</a>
	            	</div>
	            	<div style="float:left;width: 100px;height:50px;display: none;" id="appFileUrlDiv3" 
	            		onmouseover="mouseover('appFileUrl3IdDiv')" onmouseout="mouseout('appFileUrl3IdDiv')">
	            		<div title="删除" style="display: none;" id="appFileUrl3IdDiv">
	            			<a href="javascript:void(0)" onclick="deleteImg('appFileUrlDiv3','appFileUrl3Id');">删除</a>
	            		</div>
			            <a href="" target="_blank" id="appFileUrl3IdHref" >
							<img src="" width="40px" id="appFileUrl3IdPic" height="40px">
						</a>
	            	</div>
	            </td>
	        </tr>
	    </table>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitEditForm()">修改</a>
	</div>
	
	<div id="edit-autoUpdateDialog" class="easyui-dialog" title="自动更新控制" 
	data-options="iconCls:'icon-edit',modal:true,closed:true,buttons:'#edit-footerbtn'"
	style="width:400px;height:300px;"> 
		<form>
			<table style="padding:40px" cellpadding="8">
				<tr>
					<th>机型</th>
					<th>判断逻辑</th>
					<th>系统版本</th>
				</tr>
				<tr>
					<td>android</td>
					<td>
						<select id="edit-anrdJudgeSymbol" class="easyui-combobox" data-options="editable:false,prompt:'判断逻辑',onChange:showEditAndrVersionBox" name="anrdJudgeSymbol" style="width:100px;"> 
							<option value="">无</option> 
							<option value="0">等于</option> 
							<option value="1">大于等于</option> 
							<option value="2">小于等于</option> 
						</select> 
					</td>
					<td>
						<div hidden="true">
							<input class="easyui-validatebox" name="anrdVersion" data-options="prompt:'系统版本',required:true,validType:'versionValid'"style="width: 100px;"/>
						</div>
					</td>
				</tr>
				
				<tr>
					<td>iphone</td>
					<td>
						<select id="edit-iosJudgeSymbol" class="easyui-combobox" data-options="editable:false,prompt:'判断逻辑',onChange:showEditIosVersionBox" name="iosJudgeSymbol" style="width:100px;"> 
							<option value="">无</option> 
							<option value="0">等于</option> 
							<option value="1">大于等于</option> 
							<option value="2">小于等于</option> 
						</select> 
					</td>
					<td>
						<div hidden="true">
							<input class="easyui-validatebox"  name="iosVersion" data-options="prompt:'系统版本',required:true,validType:'versionValid'"style="width: 100px;"/>
						</div>
					</td>
				</tr>
			</table>
		</form>
	</div>
	
	<div id="edit-footerbtn">  	
	  <a href="#" id="editDialogConfirmBtn" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">确定</a>  	
	</div> 
</div>
<script type="text/javascript">
/*************dialog start*******************/
$.extend($.fn.validatebox.defaults.rules, {
	versionValid : {
		validator : function(value) {
			var versionReg = /^[1-9][.][0-9][.][0-9]$/;
			return versionReg.test(value);
		},
		message : '版本号不正确'
	}
});

//清空弹框form
function clearEditDialog(){
	$('#edit-autoUpdateDialog form').form('clear');
	// 将版本的input隐藏
	$('#edit-autoUpdateDialog input[name="anrdVersion"]')
	.parent().attr('hidden','true');
	$('#edit-autoUpdateDialog input[name="iosVersion"]')
	.parent().attr('hidden','true');
	
}

function showEditDialog(newVal, oldVal){
	if (newVal == 'true') {
		// 弹框
		$('#edit-autoUpdateDialog').dialog({
			closed : false,
			onClose:clearEditDialog
		});

	} else {
		// 关闭弹框
		$('#edit-autoUpdateDialog').dialog('close');
		// 清空自动更新条件input值
		$('#edit-autoUpdateCondition').val('');
		// 隐藏自动更新条件
		$('#edit-autoUpdateConditionTr').attr('hidden','true');
	}
}

function showEditAndrVersionBox(newVal, oldVal) {
	if (newVal != '') {
		$('#edit-autoUpdateDialog input[name="anrdVersion"]')
				.parent().removeAttr('hidden');
	} else {
		$('#edit-autoUpdateDialog input[name="anrdVersion"]')
				.parent().attr('hidden', 'true');
		$('#edit-autoUpdateDialog input[name="anrdVersion"] ').val('');
	}
}

function showEditIosVersionBox(newVal, oldVal) {
	if (newVal != '') {
		$('#edit-autoUpdateDialog input[name="iosVersion"]')
				.parent().removeAttr('hidden');
	} else {
		$('#edit-autoUpdateDialog input[name="iosVersion"]')
				.parent().attr('hidden', 'true');
		$('#edit-autoUpdateDialog input[name="iosVersion"]').val('');
	}
}

// 点击弹框的确定按钮
$('#editDialogConfirmBtn').click(function(){
	var anrdVersionVal =  $('#edit-autoUpdateDialog input[name="anrdVersion"]').val();
	var iosVersionVal =  $('#edit-autoUpdateDialog input[name="iosVersion"]').val();
	
	var andrJudgeSymbol = $('#edit-anrdJudgeSymbol').combobox('getValue');
	var iosJudgeSymbol = $('#edit-iosJudgeSymbol').combobox('getValue');
	
	var andrSymbol = '';
	if(andrJudgeSymbol == 0) {
		andrSymbol = '=';
	} else if(andrJudgeSymbol == 1) {
		andrSymbol = '>=';
	} else if(andrJudgeSymbol == 2) {
		andrSymbol = '<=';
	}
	
	var iosSymbol = '';
	if(iosJudgeSymbol == 0) {
		iosSymbol = '=';
	} else if(iosJudgeSymbol == 1) {
		iosSymbol = '>=';
	} else if(iosJudgeSymbol == 2) {
		iosSymbol = '<=';
	}
	
	// 只控制安卓
	if(andrJudgeSymbol != '' && $('#edit-autoUpdateDialog input[name="anrdVersion"]').validatebox('isValid') 
			&& iosJudgeSymbol == ''){
		// 回填
		$('#edit-autoUpdateConditionTr').removeAttr('hidden');
		$('#edit-autoUpdateConditionTextBox').textbox('setValue','android条件：' + andrSymbol + anrdVersionVal);
		$('#edit-autoUpdateCondition').val('[{"osType":"android","judgeSymbol":'+andrJudgeSymbol+',"appVersion":"'+anrdVersionVal+'"}]');
		// 关闭弹框
		$('#edit-autoUpdateDialog').dialog('close');
	}
	
	// 只控制ios
	else if (iosJudgeSymbol != '' && $('#edit-autoUpdateDialog input[name="iosVersion"]').validatebox('isValid')
			&& andrJudgeSymbol == '') {
		// 回填
		$('#edit-autoUpdateConditionTr').removeAttr('hidden');
		$('#edit-autoUpdateConditionTextBox').textbox('setValue','ios条件：' + iosSymbol + iosVersionVal);
		$('#edit-autoUpdateCondition').val('[{"osType":"iphone","judgeSymbol":'+iosJudgeSymbol+',"appVersion":"'+iosVersionVal+'"}]');
		// 关闭弹框
		$('#edit-autoUpdateDialog').dialog('close');
	}
	
	// ios和安卓都控制
	else if (andrJudgeSymbol != '' && $('#edit-autoUpdateDialog input[name="anrdVersion"]').validatebox('isValid')
			&& iosJudgeSymbol != '' && $('#edit-autoUpdateDialog input[name="iosVersion"]').validatebox('isValid')){
		// 回填
		$('#edit-autoUpdateConditionTr').removeAttr('hidden');
		$('#edit-autoUpdateConditionTextBox').textbox('setValue','android条件：' + andrSymbol + anrdVersionVal + "   ios条件：" + iosSymbol + iosVersionVal);
		$('#edit-autoUpdateCondition').val('[{"osType":"android","judgeSymbol":'+andrJudgeSymbol+',"appVersion":"'+anrdVersionVal+'"},{"osType":"iphone","judgeSymbol":'+iosJudgeSymbol+',"appVersion":"'+iosVersionVal+'"}]');
		// 关闭弹框
		$('#edit-autoUpdateDialog').dialog('close');
	}
	
	// 都不控制
	else if (andrJudgeSymbol == '' && iosJudgeSymbol == ''){
		$('#edit-autoUpdateCondition').val('[]');
		// 关闭弹框
		$('#edit-autoUpdateDialog').dialog('close');
	}
});
/************dialog  end***************/

	$('#appFileId1').filebox({
		 buttonText: '请选择图片', 
		 buttonAlign: 'right' 
		})
	$('#appFileId2').filebox({
	 buttonText: '请选择图片', 
	 buttonAlign: 'right' 
	})
	$('#appFileId3').filebox({
	 buttonText: '请选择图片', 
	 buttonAlign: 'right' 
	})
	function deleteImg(divId,appFileId){
		$.messager.confirm('确认','确定删除此图片吗？',function(r){
    	    if (r){
    	    	$("#"+divId+"").css("display","none");
    	    	$("#"+appFileId+"").val("");
    	    }
    	});
	}
	function mouseover(id){
		$("#"+id+"").css("display","block"); 
	}
	function mouseout(id){
		$("#"+id+"").css("display","none"); 
	}
	function submitEditForm(){
		if(!$('#editApplyStoreContent').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		
		// 校验H5应用版本号
		var versionType = $("input[name='versionType']").val();
		var hasResources = $("input[name='hasResources']:checked").val();
		var reg = /^[0-9.]+$/;
		if(hasResources == 1 && (versionType == "" || !reg.test(versionType))){
			$.messager.alert('提示','请输入正确应用版本号，例：3.5.4');
			return ;
		}
		
		// 校验app版本号
		var iosVersion = $("input[name='iosAppVersion']").val();
		var androidVersion = $("input[name='androidAppVersion']").val();
		var appVersionReg = /^[1-9][.][0-9][.][0-9]$/;
		if(iosVersion != '' && !appVersionReg.test(iosVersion)){
			$.messager.alert('提示','请输入正确的ios版本号，例：3.5.4');
			return ;
		}
		if(androidVersion != '' && !appVersionReg.test(androidVersion)){
			$.messager.alert('提示','请输入正确的android版本号，例：3.5.4');
			return ;
		}
		
		var par = $("input[name='partnerPermission']").val();
		/**********/
		if(par == '开放' || par == 'true'){
			$("input[name='partnerPermission']").val('true');
		}else{
			$("input[name='partnerPermission']").val('false');
		}
		/**********/
		var formData = new FormData($("#editApplyStoreContent")[0]);  
	$.ajax({
			   type: "POST",
			   url: "/dpm/dpmManage/toSaveApplyStore.action",
			   data: formData,
			   async: false,  
	           cache: false,  
	           contentType: false,  
	           processData: false,
			   statusCode: {200: function() {
				   $.messager.alert('提示','修改成功!');
				   $('#applyStoreEdit').window('close');
				   $("#applyStoreList").datagrid("reload");
				   $('#editApplyStoreContent').form('reset');
				  },
				  500:function(){
					  $.messager.alert('提示','修改失败!');
					  $('#applyStoreEdit').window('close');
					  $("#applyStoreList").datagrid("reload");
					  $('#editApplyStoreContent').form('reset');
				  }
			   }
		});
	}
</script>