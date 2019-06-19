<%@page import="com.deppon.montal.model.WFSysDataChanges"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_win8.jsp" %>
</head>
<body>
<%
      WFSysDataChanges info = (WFSysDataChanges)request.getAttribute("detailList");
%>
<div id="list">
	<%@include file="wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
	    		<tr>
					   <th>工作流号:</th>
					   <td id="workid"><%=info.getProcessinstid()%></td>
					</tr>
					<tr>
					   <th>工作流:</th>
					   <td>系统数据变更申请
						   <input type="hidden" id ="type_id" value="sysdatachange">
						   <input type="hidden" id ="currentnode_id" value="<%=info.getCurrentnode() %>">
					   </td>
					</tr>
				   <tr>
					  <th>申请人姓名:</th>
					  <td><%=info.getApplyname()%></td>
				   </tr>
					 <tr>
					  <th>问题所属系统:</th>
					  <td><%=info.getSystemid()%></td>
				   </tr>
				   <tr>
					  <th>是否涉及财务:</th>
					  <td><%=info.getIsfinancial()%></td>
				   </tr>
					 <tr>
					  <th>提示信息:</th>
					  <td><%=info.getMessage()%></td>
				   </tr>
					 <tr>
					  <th>操作流程:</th>
					  <td><%=info.getProcess()%></td>
				   </tr>
				   <tr>
					  <th>申请事由:</th>
					  <td><%=info.getReason()%></td>
				   </tr>
				   <%
				    if(info.getCurrentnode()){
				   %>
				   <tr>
					  <th>开发人员:</th>
					  <td>
						  <input type="button" id="developerid" value="请选择...">
						  <input type="hidden" id="dev_id">
					  </td>
				   </tr>
				   <tr>
					  <th>开发经理:</th>
					  <td>
						  <input type="button" id="managerid" value="请选择...">
						  <input type="hidden" id="devmanager_id">
					  </td>
				   </tr>
				   <%} %>
				    <%@include file="approve_process.jsp" %>
	    	</table>
	    </div>
	</div>
	<div class="peSelection" style="display:none">
		<div class="tit yellow" id="selapptitle"></div>
    	<div id="approverdiv">
    	 	数据加载中！请稍后...
    	</div>
    	<div class="btnBox">
    		<span class="btn" onclick="appCancel()">取消</span>
			<span class="btn" onclick="setApprover()">确定</span>
		</div>
		<input type="hidden" id="appchag">
    </div>
	 <%@include file="workflow_approve_button.jsp" %>
</div>
</body>
<script type="text/javascript">
$(function(){
	$("#developerid").click(function(){
		$("#appchag").val("dev");
		refreshApp();
	});
	$("#managerid").click(function(){
		$("#appchag").val("mang");
		refreshApp();
	});
});
var approvermsg = "";
//自动加载选择框审批人员
function autoShowApprover(){
	if("" != approvermsg){
		showAppDiv();
		return;
	}
	$.ajax({
	   type: "POST",
	   url: "<%=basePathBut%>/getApprover",
	   data:"timestamp=" + new Date().getTime(),
	   cache:false,
	   success: function(msg){
		   approvermsg = msg;
		   $("#approverdiv").html(approvermsg);
		   $('#approverdiv').trigger("create");
		   showAppDiv();
	   }
	});
}
function showAppDiv(){
	var appchag = $("#appchag").val();
	if ("dev" == appchag){
		$("#devManegeId").hide();
		$("#selapptitle").html("选择开发人员");
		$("#devAppId").show();
	} else {
		$("#devAppId").hide();
		$("#devManegeId").show();
		$("#selapptitle").html("选择开发经理");
	}
}
function refreshApp(){
	autoShowApprover();
	$("#div2").hide();
	$("#div3").hide();
	$(".shadowWhite").show();
	$(".peSelection").fadeIn(300);
}
//自动加载人员
setTimeout(autoShowApprover,1000);

function setApprover(){
	var selradio = $('input[name="appuser"]:checked').val();
	var username = $("#"+selradio).html();
	var appchag = $("#appchag").val();
	if($("#dev_id").val() == selradio){
		appCancel();
		return;
	}else if($("#devmanager_id").val() == selradio){
		appCancel();
		return;
	}
	if(!jQuery("#"+selradio).length > 0){
		appCancel();
		return;
	}else if ("dev" == appchag){
		$("#developerid").val(username);
		$("#dev_id").val(selradio);
		$("#managerid").val("请选择...");
	}else{
		$("#managerid").val(username);
		$("#devmanager_id").val(selradio);
		$("#developerid").val("请选择...");
	}
	$(".peSelection").hide();
	$(".shadowWhite").hide();
	$("#div2").show();
	$("#div3").show();
	$(document).scrollTop(function(){
		return $("#developerid").offset().top;
	});
}
function appCancel(){
	$(".peSelection").hide();
	$(".shadowWhite").hide();
	$("#div2").show();
	$("#div3").show();
	$(document).scrollTop(function(){
		return $("#developerid").offset().top;
	});
}
</script>
</html>