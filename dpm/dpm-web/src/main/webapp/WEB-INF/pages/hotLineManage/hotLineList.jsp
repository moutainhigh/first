<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>热线管理</title>
<link rel="stylesheet" type="text/css" href="/dpm/scripts/jquery-easyui-1.4/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="/dpm/scripts/jquery-easyui-1.4/themes/icon.css" />
<script type="text/javascript" src="/dpm/scripts/jquery-easyui-1.4/jquery.min.js"></script>
<script type="text/javascript" src="/dpm/scripts/jquery-easyui-1.4/jquery.easyui.min.js"></script>
<script type="text/javascript" src="/dpm/scripts/jquery-easyui-1.4/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="/dpm/scripts/common/common.js"></script>
</head>
<body>
    <table class="easyui-datagrid" id="appPermissionInfoList"
	       data-options="singleSelect:false,pagination:true,url:'/dpm/dpmManage/hotLinePc_list.action',method:'get',pageSize:10,toolbar:toolbar,pageList:[5,10,20]
	       				,fit:true,border:false,fitColumns:true,striped:true">
	    <thead>
	        <tr>
	        	<th data-options="field:'ck',checkbox:true"></th>
	        	<th data-options="field:'id',width:80">编号</th>
	            <th data-options="field:'name',width:80">热线名称</th>
	            <th data-options="field:'phone',width:80">电话</th>
	        </tr>
	    </thead>
	</table>
<div id="appPermissionInfoAdd" class="easyui-window" title="新增" data-options="modal:true,closed:true,iconCls:'icon-save',href:'/dpm/dpmManage/hotLinePc_toPage.action?pageType=toAddPage'" style="width:600px;height:300px;padding:10px;">
        The window content.
</div>
<div id="appPermissionInfoEdit" class="easyui-window" title="编辑" data-options="modal:true,closed:true,iconCls:'icon-edit',href:'/dpm/dpmManage/hotLinePc_toPage.action?pageType=toEditPage'" style="width:600px;height:300px;padding:10px;">
        The window content.
</div>
<script type="text/javascript">
function formatDate(val,row){
	var now = new Date(val);
	return now.format("yyyy-MM-dd hh:mm:ss");
}
function getSelectionsIds(){
	var h5FileInfoList = $("#appPermissionInfoList");
	var sels = h5FileInfoList.datagrid("getSelections");
	var ids = [];
	for(var i in sels){
		ids.push(sels[i].id);
	}
	ids = ids.join(",");
	return ids;
}
var toolbar = [{
    text:'新增',
    iconCls:'icon-add',
    handler:function(){
    	$('#appPermissionInfoAdd').window('open');
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
    		$.messager.alert('提示','只能选择一条信息编辑!');
    		return ;
    	}    	
    	var row = $("#appPermissionInfoList").datagrid('getSelected');
    	 
        $('#appPermissionInfoEdit').window('open').panel({
        	onLoad : function(){ 

        		//回显数据
         	    $("#editContent").form('load',row);
        	}

        });   //打开form表达窗口
      
       	
   }
},{
    text:'删除',
    iconCls:'icon-cancel',
    handler:function(){
    	var ids = getSelectionsIds();
    	if(ids.length == 0){
    		$.messager.alert('提示','未选中!');
    		return ;
    	}
    	$.messager.confirm('确认','确定删除ID为 '+ids+' 的信息吗？',function(r){
    	    if (r){
        		
    	    	$.ajax({
    				   type: "POST",
    				   url: "/dpm/dpmManage/hotLinePc_delete.action",
    				   data: {'ids':ids},
    				   statusCode: {204: function() {
    					   $.messager.alert('提示','删除成功!',undefined,function(){
           					$("#appPermissionInfoList").datagrid("reload");
    					   });
    					  },
    					  500:function(){
    						  $.messager.alert('提示','删除失败!',undefined,function(){
    	           					$("#appPermissionInfoList").datagrid("reload");
    	    				  });
    					  }
    				   }
    			});
    	    }
    	});
    }
}
];
</script>
</body>
</html>