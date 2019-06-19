<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div style="padding:10px 10px 10px 10px">
	<form id="addApplyStoreContent" method="post">
	    <table cellpadding="5">
	        <tr>
	            <td>应用编号:</td>
	            <td><input class="easyui-numberbox" id="appIdInput" type="text" name="appId" data-options="min:1,max:99,precision:0,required:true" style="width: 280px;"></input>
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
	        		<select class="easyui-combobox" data-options="required:true,editable:false,onChange:showAddDialog" name="autoUpdate" style="width:280px;"> 
						<option value="true">是</option> 
						<option value="false" selected="selected">否</option> 
					</select> 
	        	</td>
	        </tr>
	        
	        <tr hidden="true" id="add-autoUpdateConditionTr">
	        	<td>自动更新条件:</td>
	        	<td>
					<input id="add-autoUpdateConditionTextBox" class="easyui-textbox" data-options="editable:false" style="width: 280px;"/>
	       			<input id="add-autoUpdateCondition" type="hidden" name="autoUpdateCondition"/>
	       		</td>
	        </tr>
	         <tr>
	            <td>应用状态:</td>
	            <td>
	            	<select class="easyui-combobox" data-options="required:true,editable:false" name="status" style="width:280px;"> 
						<option value="on" selected="selected">on</option> 
						<option value="off">off</option> 
					</select> 
	            </td>
	        </tr>
	         <tr>
	            <td>合伙人权限:</td>
	            <td>
	            	<select class="easyui-combobox" data-options="required:true,editable:false" name="partnerPermission" style="width:280px;"> 
						<option value="true">开放</option> 
						<option value="false" selected="selected">不开放</option> 
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
	            	<input class="easyui-radio" type="radio" name="defaultApp" value="0"/> 不是
	            	<input class="easyui-radio" type="radio" name="defaultApp" checked="checked" value="1" /> 是
	            </td>
	        </tr>
	        <tr>
	            <td>是否需要更新H5资源:</td>
	            <td>
	            	<input class="easyui-radio" type="radio" name="hasResources" checked="checked" value="0"/> 不需要
	            	<input class="easyui-radio" type="radio" name="hasResources" value="1" /> 需要
	            </td>
	        </tr>
	        <tr>
	        	<td>数据源:</td>
	        	<td>
					<input class="easyui-radio" type="radio" name="downloadLine"  value="1"/> TECHOWN
	            	<input class="easyui-radio" type="radio" name="downloadLine" value="0" checked="checked"/> DPM
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
					<input class="easyui-filebox" name="appFile1" id="appFileId1" 
	            			data-options="prompt:'请选择图片...'" style="width:100%" />
	            </td>
	        </tr>
	        <tr>
	            <td>应用图片2:</td>
	            <td>
	            	<input class="easyui-filebox" id="appFileId2" name="appFile2" 
	            			data-options="prompt:'请选择图片...'" style="width:100%" />
	            </td>
	        </tr>
	        <tr>
	            <td>应用图片3:</td>
	            <td>
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
	    </table>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitAddForm()">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearAddForm()">重置</a>
	</div>
	
	<div id="add-autoUpdateDialog" class="easyui-dialog" title="自动更新控制" 
	data-options="iconCls:'icon-edit',modal:true,closed:true,buttons:'#add-footerbtn'"
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
						<select id="add-anrdJudgeSymbol" class="easyui-combobox" data-options="editable:false,prompt:'判断逻辑',onChange:showAddAndrVersionBox" name="anrdJudgeSymbol" style="width:100px;"> 
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
						<select id="add-iosJudgeSymbol" class="easyui-combobox" data-options="editable:false,prompt:'判断逻辑',onChange:showAddIosVersionBox" name="iosJudgeSymbol" style="width:100px;"> 
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
	
	<div id="add-footerbtn">  	
	  <a href="#" id="addDialogConfirmBtn" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">确定</a>  	
	</div> 
</div>

<script type="text/javascript">
/*************dialog start*******************/
	// 自定义validType
	$.extend($.fn.validatebox.defaults.rules, {
		versionValid : {
			validator : function(value) {
				var versionReg = /^[1-9][.][0-9][.][0-9]$/;
				return versionReg.test(value);
			},
			message : '版本号不正确'
		}
	});
	
	// 选择自动更新的事件
	function showAddDialog(newVal, oldVal){
		if (newVal == 'true') {
			// 弹框
			$('#add-autoUpdateDialog').dialog({
				closed : false,
				onClose:clearAddDialog
			});

		} else {
			// 关闭弹框
			$('#add-autoUpdateDialog').dialog('close');
			// 清空自动更新条件input值
			$('#add-autoUpdateCondition').val('');
			// 隐藏自动更新条件
			$('#add-autoUpdateConditionTr').attr('hidden','true');
		}
	}
	
	// 清空弹框form
	function clearAddDialog(){
		$('#add-autoUpdateDialog form').form('clear');
		// 将版本的input隐藏
		$('#add-autoUpdateDialog input[name="anrdVersion"]')
		.parent().attr('hidden','true');
		$('#add-autoUpdateDialog input[name="iosVersion"]')
		.parent().attr('hidden','true');
		
	}

	// 	选择弹框中安卓自动更新条件的事件
	function showAddAndrVersionBox(newVal, oldVal){
		if (newVal != '') {
			$('#add-autoUpdateDialog input[name="anrdVersion"]')
					.parent().removeAttr('hidden');
		} else {
			$('#add-autoUpdateDialog input[name="anrdVersion"]')
					.parent().attr('hidden', 'true');
			$('#add-autoUpdateDialog input[name="anrdVersion"] ').val('');
		}
	}
	
	// 	选择弹框中ios自动更新条件的事件
	function showAddIosVersionBox(newVal, oldVal){
		if (newVal != '') {
			$('#add-autoUpdateDialog input[name="iosVersion"]')
					.parent().removeAttr('hidden');
		} else {
			$('#add-autoUpdateDialog input[name="iosVersion"]')
					.parent().attr('hidden', 'true');
			$('#add-autoUpdateDialog input[name="iosVersion"]').val('');
		}
	}
	
	// 点击弹框的确定按钮
	$('#addDialogConfirmBtn').click(function(){
		var anrdVersionVal =  $('#add-autoUpdateDialog input[name="anrdVersion"]').val();
		var iosVersionVal =  $('#add-autoUpdateDialog input[name="iosVersion"]').val();
		
		var andrJudgeSymbol = $('#add-anrdJudgeSymbol').combobox('getValue');
		var iosJudgeSymbol = $('#add-iosJudgeSymbol').combobox('getValue');
		
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
		if(andrJudgeSymbol != '' && $('#add-autoUpdateDialog input[name="anrdVersion"]').validatebox('isValid') 
				&& iosJudgeSymbol == ''){
			// 回填
			$('#add-autoUpdateConditionTr').removeAttr('hidden');
			$('#add-autoUpdateConditionTextBox').textbox('setValue','android条件：' + andrSymbol + anrdVersionVal);
			$('#add-autoUpdateCondition').val('[{"osType":"android","judgeSymbol":'+andrJudgeSymbol+',"appVersion":"'+anrdVersionVal+'"}]');
			// 关闭弹框
			$('#add-autoUpdateDialog').dialog('close');
		}
		
		// 只控制ios
		else if (iosJudgeSymbol != '' && $('#add-autoUpdateDialog input[name="iosVersion"]').validatebox('isValid')
				&& andrJudgeSymbol == '') {
			// 回填
			$('#add-autoUpdateConditionTr').removeAttr('hidden');
			$('#add-autoUpdateConditionTextBox').textbox('setValue','ios条件：' + iosSymbol + iosVersionVal);
			$('#add-autoUpdateCondition').val('[{"osType":"iphone","judgeSymbol":'+iosJudgeSymbol+',"appVersion":"'+iosVersionVal+'"}]');
			// 关闭弹框
			$('#add-autoUpdateDialog').dialog('close');
		}
		
		// ios和安卓都控制
		else if (andrJudgeSymbol != '' && $('#add-autoUpdateDialog input[name="anrdVersion"]').validatebox('isValid')
				&& iosJudgeSymbol != '' && $('#add-autoUpdateDialog input[name="iosVersion"]').validatebox('isValid')){
			// 回填
			$('#add-autoUpdateConditionTr').removeAttr('hidden');
			$('#add-autoUpdateConditionTextBox').textbox('setValue','android条件：' + andrSymbol + anrdVersionVal + "   ios条件：" + iosSymbol + iosVersionVal);
			$('#add-autoUpdateCondition').val('[{"osType":"android","judgeSymbol":'+andrJudgeSymbol+',"appVersion":"'+anrdVersionVal+'"},{"osType":"iphone","judgeSymbol":'+iosJudgeSymbol+',"appVersion":"'+iosVersionVal+'"}]');
			// 关闭弹框
			$('#add-autoUpdateDialog').dialog('close');
		}
		
		// 都不控制
		else if (andrJudgeSymbol == '' && iosJudgeSymbol == ''){
			$('#add-autoUpdateCondition').val('[]');
			// 关闭弹框
			$('#add-autoUpdateDialog').dialog('close');
		}
	});
/************dialog  end***************/

	$('#appFileId1').filebox({
		buttonText : '请选择图片',
		buttonAlign : 'right'
	})
	$('#appFileId2').filebox({
		buttonText : '请选择图片',
		buttonAlign : 'right'
	})
	$('#appFileId3').filebox({
		buttonText : '请选择图片',
		buttonAlign : 'right'
	})
	function submitAddForm() {

		var appId = $("#appIdInput").val();
		if (appId == '') {
			$.messager.alert('提示', '应用编号不能为空!');
			return;
		}
		var rows = $('#applyStoreList').datagrid('getRows')
		for ( var i = 0; i < rows.length; i++) {
			if (appId == rows[i]['appId']) {
				$.messager.alert('提示', '应用编号' + appId + '已存在!');
				return;
			}
		}

		if (!$('#addApplyStoreContent').form('validate')) {
			$.messager.alert('提示', '表单还未填写完成!');
			return;
		}

		var versionType = $("input[name='versionType']").val();
		var hasResources = $("input[name='hasResources']:checked").val();
		var reg = /^[0-9.]+$/;
		if (hasResources == 1 && versionType != "" && !reg.test(versionType)) {
			$.messager.alert('提示', '请输入正确应用版本号，例：3.5.4');
			return;
		}

		// 校验app版本号
		var iosVersion = $("input[name='iosAppVersion']").val();
		var androidVersion = $("input[name='androidAppVersion']").val();
		var appVersionReg = /^[1-9][.][0-9][.][0-9]$/;
		if (iosVersion != '' && !appVersionReg.test(iosVersion)) {
			$.messager.alert('提示', '请输入正确的ios版本号，例：3.5.4');
			return;
		}
		if (androidVersion != '' && !appVersionReg.test(androidVersion)) {
			$.messager.alert('提示', '请输入正确的android版本号，例：3.5.4');
			return;
		}

		var formData = new FormData($("#addApplyStoreContent")[0]);
		$.ajax({

			type : "POST",
			url : "/dpm/dpmManage/toSaveApplyStore.action",
			data : formData,
			async : false,
			cache : false,
			contentType : false,
			processData : false,
			statusCode : {
				200 : function() {
					$.messager.alert('提示', '新增成功!');
					$('#applyStoreAdd').window('close');
					$("#applyStoreList").datagrid("reload");
					$('#addApplyStoreContent').form('reset');
				},
				500 : function() {
					$.messager.alert('提示', '新增失败!');
					$('#applyStoreAdd').window('close');
					$("#applyStoreList").datagrid("reload");
					$('#addApplyStoreContent').form('reset');
				}
			}
		});
	}

	function clearAddForm() {
		$("#addApplyStoreContent").form('reset');
	}
</script>