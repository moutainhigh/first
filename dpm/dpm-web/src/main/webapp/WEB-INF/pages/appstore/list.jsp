<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>应用商店管理</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="/dpm/scripts/jquery-easyui-1.4/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="/dpm/scripts/jquery-easyui-1.4/themes/icon.css" />
<script type="text/javascript" src="/dpm/scripts/jquery-easyui-1.4/jquery.min.js"></script>
<script type="text/javascript" src="/dpm/scripts/jquery-easyui-1.4/jquery.easyui.min.js"></script>
<script type="text/javascript" src="/dpm/scripts/jquery-easyui-1.4/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="/dpm/scripts/common/common.js"></script>
</head>
<body>
    <table class="easyui-datagrid" id="applyStoreList"
	       data-options="singleSelect:false,collapsible:true,pagination:true,url:'/dpm/dpmManage/applyStoreList.action',method:'get',pageSize:20,toolbar:toolbar,pageList:[20,30,50]
	       				,fit:true,border:false,fitColumns:true,striped:true">
	    <thead>
	        <tr>
	        	<th data-options="field:'ck',checkbox:true"></th>
	        	<th data-options="field:'appId',width:80,align:'center'">应用编号</th>
	            <th data-options="field:'enName',width:100,align:'center'">英文名称</th>
	            <th data-options="field:'cnName',width:100,align:'center'">中文名称</th>
	           <!--  <th data-options="field:'size',width:100,align:'center'">资源大小</th> -->
	            <th data-options="field:'autoUpdate',width:100,align:'center',formatter:formatBoolean">自动更新</th>
	             <th data-options="field:'appAutoRefreshControlList',width:200,align:'center',formatter:formatUpdateCondition">更新条件</th>
	            <th data-options="field:'status',width:100,align:'center'">状态</th>
	            <th data-options="field:'partnerPermission',width:100,align:'center',formatter:formatPermission">合伙人权限</th>
	            <th data-options="field:'versionType',width:100,align:'center'">应用版本号</th>
	            <th data-options="field:'androidAppVersion',width:100,align:'center'">上线安卓版本</th>
	            <th data-options="field:'iosAppVersion',width:100,align:'center'">上线ios版本</th>
	            <th data-options="field:'defaultApp',width:100,align:'center',formatter:formatHas">是否属于应用商店应用</th>
	            <th data-options="field:'hasResources',width:100,align:'center',formatter:formatHas">是否需要更新H5资源</th>
	            <th data-options="field:'downloadLine',width:100,align:'center',formatter:formatDLoadLine">平台源</th>
	            <th data-options="field:'downloadUrl',width:100,align:'center'">下载路径</th>
	            <th data-options="field:'appOrder',width:100,align:'center'">排序</th>
	          <!--   <th data-options="field:'url',width:200,align:'center'">下载路径</th> -->
	           <!--  <th data-options="field:'summary',width:200,align:'center'">简介</th> -->
	            <!-- <th data-options="field:'createTime',width:125,align:'center',formatter:formatDate">创建时间</th> -->
	        </tr>
	    </thead>
	</table>
<div id="applyStoreAdd" class="easyui-window" title="新增" data-options="modal:true,closed:true,iconCls:'icon-save',href:'/dpm/dpmManage/toAppStorePage_addApplyStore.action'" style="width:900px;height:600px;padding:10px;">
        The window content.
</div>
<div id="applyStoreEdit" class="easyui-window" title="编辑" data-options="modal:true,closed:true,iconCls:'icon-save',href:'/dpm/dpmManage/toAppStorePage_editApplyStore.action'" style="width:900px;height:600px;padding:10px;">
        The window content.
</div>

<div id="dd" class="easyui-dialog" title="平台选择" style="width:300px;height:150px;text-align:center;padding-top:25px;" 
	data-options="iconCls:'icon-save',closed:true,modal:true,buttons:'#bb'"> 
		<select id="dloadLineSelc" class="easyui-combobox" data-options="editable:false,panelHeight:45" style="width:100px;"> 
			<option value="1">TECHOWN</option> 
			<option value="0" selected="selected">DPM</option> 
		</select> 
</div>
<div id="bb">  	
  <a href="#" id="bb-ok" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">保存</a>  	
  <a href="#" id="bb-cancel" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">取消</a>  
</div>  


<script type="text/javascript">

$(function(){
	$('#applyStoreAdd').window({
		onClose:function(){
    		// 重置表单
    		$('#addApplyStoreContent').form('reset');
    	}
	});
	
	$('#bb-ok').click(function(){
		var slecVal = $('#dloadLineSelc').combobox('getValue'); 
		$.get('${pageContext.request.contextPath}/dpmManage/updateDLoadLine.action?dLoadLine=' + slecVal
				,function(data){
			if(data == 'success') {
				$.messager.alert('提示','切换成功!');
			} else {
				$.messager.alert('提示','切换失败!');
			}
			
			$('#dd').dialog('close');
			$("#applyStoreList").datagrid("reload");
		});
	});
	
	$('#bb-cancel').click(function(){
		$('#dd').dialog('close');
	});
});


function formatHas(val,row){
	if(val == 1){
		return "是";
	}else if(val == 0){
		return "否";
	}
}

function formatBoolean(val,row){
	return val ? '是' : '否';
}

function formatPermission(val,row){
	return val == 1 ? '开放' : '不开放';
}

function formatDate(val,row){
	var now = new Date(val);
	return now.format("yyyy-MM-dd");
}

function formatSet(val,row){
	if(val == true){
		return "有";
	}else{
		return "无";
	}
}

function formatDLoadLine(val,row) {
	if(val == 1){
		return "TECHOWN";
	}else{
		return "DPM";
	}
}

function formatUpdateCondition(val,row){
	var showTmpStrArr = [];
	if(val.length > 0) {
		for(var i in val) {
			var judgeSymbol = val[i].judgeSymbol;
			if(judgeSymbol == 0) {
				judgeSymbol = '=';
			} else if(judgeSymbol == 1) {
				judgeSymbol = '>=';
			} else if(judgeSymbol == 2) {
				judgeSymbol = '<=';
			}
			var showTmpStr = val[i].osType + '条件：' + judgeSymbol + val[i].appVersion;
			showTmpStrArr.push(showTmpStr);
		}
		return showTmpStrArr.join('&nbsp;&nbsp;');
	}
	return '';
}

function getSelectionsIds(){
	var awardList = $("#applyStoreList");
	var sels = awardList.datagrid("getSelections");
	var ids = [];
	for(var i in sels){
		ids.push(sels[i].appId);
	}
	ids = ids.join(",");
	return ids;
}
var toolbar = [{
    text:'新增',
    iconCls:'icon-add',
    handler:function(){
    	$('#applyStoreAdd').window('open').window('maximize');
    }
},{
    text:'编辑',
    iconCls:'icon-edit',
    handler:function(){
    	var ids = getSelectionsIds().split(",");
    	if(ids == "" || ids.length == 0){
    		$.messager.alert('提示','未选中!');
    		return ;
    	}else if(ids.length > 1){
    		$.messager.alert('提示','只能选择一条内容!');
    		return ;
    	}    	
    	 
    	var row = $("#applyStoreList").datagrid('getSelected');
    	var pp = row.partnerPermission;
		if(pp == 'true' || pp == 1 || pp == '开放'){
			row.partnerPermission = 'true';
		}else{
			row.partnerPermission = 'false';
		}
		
		row.autoUpdate = (row.autoUpdate == 'true' || row.autoUpdate == 1 || row.autoUpdate == '是') ? 'true' : 'false';
        $('#applyStoreEdit').window({
        	onLoad : function(){ 
        		//回显数据
         	    $("#editApplyStoreContent").form('load',row);
       			
       			// 自动更新控制条件
      			var autoUpdateData = row.appAutoRefreshControlList;
      			if(autoUpdateData.length > 0) {
      				var showTmpStrArr = [];
      				var hiddenTmpStrArr = [];
      				for(var i in autoUpdateData){
      					var hiddenTmpStr = '{"osType":"'+autoUpdateData[i].osType+'","judgeSymbol":'+autoUpdateData[i].judgeSymbol+',"appVersion":"'+autoUpdateData[i].appVersion+'"}';
      					hiddenTmpStrArr.push(hiddenTmpStr);
      					
      					var judgeSymbol = autoUpdateData[i].judgeSymbol;
      					if(judgeSymbol == 0) {
      						judgeSymbol = '=';
      					} else if(judgeSymbol == 1) {
      						judgeSymbol = '>=';
      					} else if(judgeSymbol == 2) {
      						judgeSymbol = '<=';
      					}
      					
      					var showTmpStr = autoUpdateData[i].osType + '条件：' + judgeSymbol + autoUpdateData[i].appVersion;
      					showTmpStrArr.push(showTmpStr);
      				}
					
      				$('#edit-autoUpdateConditionTr').removeAttr('hidden');
      				$('#edit-autoUpdateConditionTextBox').textbox('setValue',showTmpStrArr.join('        '));
      				var tmpStr = '[';
      				for(var i in hiddenTmpStrArr) {
      					tmpStr += hiddenTmpStrArr[i] + ',';
      				}
      				
      				tmpStr = tmpStr.substring(0,tmpStr.length - 1) + ']';
      				$('#edit-autoUpdateCondition').val(tmpStr);
      			}
      			
        		// 显示应用图片
        		var url1 = $("#appFileUrl1Id").val();
        		var url2 = $("#appFileUrl2Id").val();
        		var url3 = $("#appFileUrl3Id").val();
        		if(url1 != null && url1 != "") {
        			$("#appFileUrlTr").show();
        			$("#appFileUrlDiv1").css("display","block");
	        		$("#appFileUrl1IdHref").attr('href',url1);
	        		$("#appFileUrl1IdPic").attr('src',url1); 
        		}
        		if(url2 != null && url2 != "") {
        			$("#appFileUrlTr").show();
        			$("#appFileUrlDiv2").css("display","block");
	        		$("#appFileUrl2IdHref").attr('href',url2);
	        		$("#appFileUrl2IdPic").attr('src',url2); 
        		}
        		if(url3 != null && url3 != "") {
        			$("#appFileUrlTr").show();
        			$("#appFileUrlDiv3").css("display","block");
	        		$("#appFileUrl3IdHref").attr('href',url3);
	        		$("#appFileUrl3IdPic").attr('src',url3); 
        		}
        	},
        	onClose:function(){
        		// 重置表单
        		$('#editApplyStoreContent').form('reset');
        	}
        }).window('open').window('maximize');   //打开form表达窗口 
   }
},{
    text:'删除',
    iconCls:'icon-cancel',
    handler:function(){
    	var ids = getSelectionsIds().split(",");
    	if(ids == "" || ids.length == 0){
    		$.messager.alert('提示','未选中!');
    		return ;
    	}else if(ids.length > 1){
    		$.messager.alert('提示','只能选择一条内容!');
    		return ;
    	} 	
    	$.messager.confirm('确认','确定删除应用编号为 '+ids+' 的内容吗？',function(r){
    	    if (r){
    	    	$.ajax({
    				   type: "POST",
    				   url: "/dpm/dpmManage/toDeleteApplyStore.action",
    				   data: {'appid':ids+""},
    				   statusCode: {200: function() {
    					   $.messager.alert('提示','删除成功!',undefined,function(){
           					$("#applyStoreList").datagrid("reload");
    					   });
    					  },
    					  500:function(){
    						  $.messager.alert('提示','删除失败!',undefined,function(){
    	           					$("#applyStoreList").datagrid("reload");
    	    				  });
    					  }
    				   }
    			});
    	    }
    	});
      }
   },{
	    text:'切换下载平台',
	    iconCls:'icon-search',
	    handler:function(){
	    	$('#dd').dialog('open');
	    }
   }
];

</script>
</body>
</html>