<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>悬赏管理系统</title>
<link rel="stylesheet" type="text/css" href="/dpm/scripts/jquery-easyui-1.4/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="/dpm/scripts/jquery-easyui-1.4/themes/icon.css" />
<script type="text/javascript" src="/dpm/scripts/jquery-easyui-1.4/jquery.min.js"></script>
<script type="text/javascript" src="/dpm/scripts/jquery-easyui-1.4/jquery.easyui.min.js"></script>
<script type="text/javascript" src="/dpm/scripts/jquery-easyui-1.4/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="/dpm/scripts/common/common.js"></script>
</head>
<body>
	<div>
    <table class="easyui-datagrid" id="awardList" title="悬赏列表"
	       data-options="singleSelect:false,collapsible:true,pagination:true,url:'/dpm/dpmManage/awardList.action',method:'get',pageSize:10,toolbar:toolbar,pageList:[5,10,20]">
	    <thead>
	        <tr>
	        	<th data-options="field:'ck',checkbox:true"></th>
	        	<th data-options="field:'articleID',width:80">ID</th>
	            <th data-options="field:'publisher',width:100">发布人</th>
	            <th data-options="field:'publisherEmail',width:150">发布人邮箱</th>
	            <th data-options="field:'publishTime',width:100,align:'center',formatter:formatDate">发布时间</th>
	            <th data-options="field:'recruitPosition',width:100">招聘职位</th>
	            <th data-options="field:'title',width:100,align:'center'">标题</th>
	            <th data-options="field:'content',width:300,align:'center'">内容</th>
	            <th data-options="field:'hasAward',width:40,align:'center',formatter:formatSet">是否有奖金</th>
	            <th data-options="field:'reward',width:80,align:'center'">奖金</th>
	            <th data-options="field:'contactPerson',width:80,align:'center'">联系人</th>
	            <th data-options="field:'contactPhone',width:80,align:'center'">联系人电话</th>
	        </tr>
	    </thead>
	</table>
	</div>
<div id="awardAdd" class="easyui-window" title="新增悬赏" data-options="modal:true,closed:true,iconCls:'icon-save',href:'/dpm/dpmManage/toAwardPage_addAward.action'" style="width:900px;height:600px;padding:10px;">
        The window content.
</div>
<div id="awardEdit" class="easyui-window" title="编辑悬赏" data-options="modal:true,closed:true,iconCls:'icon-edit',href:'/dpm/dpmManage/toAwardPage_editAward.action'" style="width:900px;height:600px;padding:10px;">
        The window content.
</div>
<script type="text/javascript">
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
function getSelectionsIds(){
	var awardList = $("#awardList");
	var sels = awardList.datagrid("getSelections");
	var ids = [];
	for(var i in sels){
		ids.push(sels[i].articleID);
	}
	ids = ids.join(",");
	return ids;
}
var toolbar = [{
    text:'新增',
    iconCls:'icon-add',
    handler:function(){
    	$('#awardAdd').window('open');
    }
},{
    text:'编辑',
    iconCls:'icon-edit',
    handler:function(){
    	var ids = getSelectionsIds().split(",");
    	if(ids == "" || ids.length == 0){
    		$.messager.alert('提示','未选中悬赏!');
    		return ;
    	}else if(ids.length > 1){
    		$.messager.alert('提示','只能选择一条悬赏编辑!');
    		return ;
    	}    	
    	var row = $("#awardList").datagrid('getSelected');
    	 
        $('#awardEdit').window('open').panel({
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
    		$.messager.alert('提示','未选中悬赏!');
    		return ;
    	}
    	$.messager.confirm('确认','确定删除ID为 '+ids+' 的悬赏吗？',function(r){
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
    				   url: "/dpm/dpmManage/toDeleteAward.action",
    				   data: {'ids':ids},
    				   statusCode: {204: function() {
    					   $.messager.alert('提示','删除悬赏成功!',undefined,function(){
           					$("#awardList").datagrid("reload");
    					   });
    					  },
    					  500:function(){
    						  $.messager.alert('提示','删除悬赏失败!',undefined,function(){
    	           					$("#awardList").datagrid("reload");
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