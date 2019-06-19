<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎页管理系统</title>
<link rel="stylesheet" type="text/css" href="/dpm/scripts/jquery-easyui-1.4/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="/dpm/scripts/jquery-easyui-1.4/themes/icon.css" />
<script type="text/javascript" src="/dpm/scripts/jquery-easyui-1.4/jquery.min.js"></script>
<script type="text/javascript" src="/dpm/scripts/jquery-easyui-1.4/jquery.easyui.min.js"></script>
<script type="text/javascript" src="/dpm/scripts/jquery-easyui-1.4/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="/dpm/scripts/common/common.js"></script>
</head>
<body>
    <table class="easyui-datagrid" id="welcomPageList"
	       data-options="singleSelect:false,collapsible:true,pagination:true,url:'/dpm/dpmManage/getWelcomePageList.action',method:'get',pageSize:10,toolbar:toolbar,pageList:[5,10,20]
	       				,fit:true,border:false,fitColumns:true,striped:true">
	    <thead>
	        <tr>
	        	<th data-options="field:'ck',checkbox:true"></th>
	        	<th data-options="field:'id',width:80,align:'center'">ID</th>
	            <th data-options="field:'subject',width:150,align:'center'">主题</th>
	            <th data-options="field:'fileFileName',width:280,align:'center'">图片名</th>
	            <th data-options="field:'link',width:100,align:'center',formatter:formatLink">链接类型</th>
	            <th data-options="field:'existTime',width:100,align:'center'">存活时间（秒）</th>
	            <th data-options="field:'timeOut',width:100,align:'center',formatter:formatSet">状态</th>
	            <th data-options="field:'startDate',width:150,align:'center',formatter:formatDate">展示起始时间</th>
	            <th data-options="field:'endDate',width:150,align:'center',formatter:formatDate">展示结束时间</th>
	            <th data-options="field:'operateTime',width:150,align:'center',formatter:formatDate">创建时间</th>
	        </tr>
	    </thead>
	</table>
<div id="welcomPageAdd" class="easyui-window" title="新增欢迎页配置" data-options="modal:true,closed:true,iconCls:'icon-save',onClose:clearAddForm,href:'/dpm/dpmManage/toWelcomePage_addWelcomePage.action'" style="width:800px;height:550px;padding:10px;">
        The window content.
</div>
<script type="text/javascript">

function formatLink(val,row){
	if(val == 'none' || val == '' || val == null){
		return "无";
	}
	return val;
}

function formatDate(val,row){
	var now = new Date(val);
	return now.format("yyyy-MM-dd hh:mm:ss");
}
function formatSet(val,row){
	if(val == true){
		return "已过期";
	}else{
		return "未过期";
	}
}

function clearAddForm(){
	$("#addContent").form('reset');
	// 手动隐藏select
	$("#hiddenSelect").attr('style','display:none;');
}

function getSelectionsIds(){
	var welcomPageList = $("#welcomPageList");
	var sels = welcomPageList.datagrid("getSelections");
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
    	$('#welcomPageAdd').window('open');
    }
},{
    text:'删除',
    iconCls:'icon-cancel',
    handler:function(){
    	var ids = getSelectionsIds();
    	if(ids.length == 0){
    		$.messager.alert('提示','未选中数据!');
    		return ;
    	}
    	$.messager.confirm('确认','确定删除ID为 '+ids+' 的欢迎页吗？',function(r){
    	    if (r){
            	/* $.post("/user/delete",{'ids':ids}, function(data){
        			if(data.status == 200){
        				$.messager.alert('提示','删除会员成功!',undefined,function(){
        					$("#userList").datagrid("reload");
        				});
        			}
        		}); */
        		
    	    	$.ajax({
    				   type: "POST",
    				   url: "/dpm/dpmManage/delWelcomePage.action",
    				   data: {'ids':ids},
    				   statusCode: {204: function() {
    					   $.messager.alert('提示','删除成功!',undefined,function(){
           					$("#welcomPageList").datagrid("reload");
    					   });
    					  },
    					  500:function(){
    						  $.messager.alert('提示','删除失败!',undefined,function(){
    	           					$("#welcomPageList").datagrid("reload");
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