<%@page import="com.deppon.wfs.workflow.domain.CommissionMakeOrChangeBean"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.module.workitems.webservice.client.DWFSWorkItemServiceClient"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_win8.jsp" %>
	<style>
	tr.details, tr.qytr { display:none;}
	</style>
</head>
<body onload="autoShowApproval()">
<%
	CommissionMakeOrChangeBean info = (CommissionMakeOrChangeBean)request.getAttribute("entity");
%>
<div id="list">
	<%@include file="../wf_head_win8.jsp" %>
	<input type="hidden" id="busino" value="<%=info.getBusino()%>">
	<input type="hidden" id="approval_url" value="<%=F_Constants.NORMOL_APPROVAL_URL%>">
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
    		   <tr>
				   <th>工作流号:</th>
				   <td id="workid"><%=request.getAttribute("processinstid")%></td>
				</tr>
				<tr>
				   <th>工&nbsp;&nbsp;作&nbsp;&nbsp;流:</th>
				   <td>营运提成单项奖设立与调整申请</td>
				</tr>
			   <tr>
			   		<th>申请人姓名:</th>
			   		<td><%=info.getApplyPersonName()%></td>
			   </tr>
			   <tr>
				  <th>工号:</th>
				  <td><%=info.getApplyPersonId()%></td>
			   </tr>
		    	<tr>
		   			<th>申请人部门:</th>
		   			<td><%=info.getDept()%></td>
		   		</tr>
		   		<tr>
	   				<th>所属经营本部:</th>
					<td><%=info.getOperationDepartment()%></td>
				</tr>
				<tr>
					<th>申请类别:</th>
					<td><%=info.getApplyType()%></td>
				</tr>
				<tr>
					<th>是否涉及薪资调整:</th>
					<td><%=info.getRelateSalary()%></td>
				</tr>
			   <tr>
				  <th>申请事由:</th>
				  <td><%=info.getApplyReason()%></td>
			   </tr>
			   <%@include file="approve_process.jsp" %>					   					   
	    	</table>
	    </div>
	</div>
	<div id="div_hidden" class="fyy-textCt">
    	 	<span id="msg" style="display: none"> 
			<em style="color: red">此节点暂不支持手机审批</em>
			</span>
    	</div>
	 <%@include file="workflow_approve_button.jsp" %>
</div>
</body>
<script type="text/javascript">
$(function(){
	var activitydefid = $("#activitydefid").val();
	if("manualActivity14" == activitydefid){
		//最后一个节点 只有同意按钮
		$("#disagree_but").hide();
		$("#rollback_but").hide();
	}else if("manualActivity2" == activitydefid || "manualActivity5" == activitydefid || "manualActivity6" == activitydefid){
		$("#div3").hide();
		$("#approve_area").hide();
		$("#msg").show();
	}
	//回退按钮隐藏
	if("manualActivity10" == activitydefid || "manualActivity12" == activitydefid || 
			"manualActivity9" == activitydefid || "manualActivity11" == activitydefid){
		$("#rollback_but").hide();
	}
});
</script>
</html>