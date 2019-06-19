<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.module.workitems.webservice.client.DWFSWorkItemServiceClient"%>
<%@page import="com.deppon.wfs.workflow.domain.ProcessManagementBean"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title")%>-待办事项</title>
	<%@include file="/common_win8.jsp" %>
	<style>
	tr.details, tr.qytr { display:none;}
	</style>
</head>
<body onload="autoShowApproval()">
<%
	ProcessManagementBean info = (ProcessManagementBean) request
			.getAttribute("entity");
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
						<td>流程管理工作流</td>
					</tr>
					<tr>
						<th>申请人:</th>
						<td><%=info.getApplyPersonName()%></td>
					</tr>
					<tr>
					  <th>申请人工号:</th>
					  <td><%=info.getApplyPersonId()%></td>
				   </tr>
					 <tr>
					  <th>申请人部门:</th>
					  <td><%=info.getApplydeptname()%></td>
				   </tr>
				   <tr>
					  <th>申请类型：</th>
					  <td><%=info.getApplyType()%></td><!-- WFS_PROCESS_MANAGEMENT_APPLY_TYPE -->
				   </tr>
				   <%
				   	String applyType = info.getApplyType();
				   	if ("清单变更".equals(applyType)) {
				   %>
					<tr>
					  <th>清单级别：</th>
					  <td><%=info.getBillLevel()%></td><!-- WFS_BILL_LEVEL -->
				   </tr>
				    <tr>
					  <th>流程名称：</th>
					  <td><%=info.getApplyProcessName()%></td>
				   </tr>
				   <tr>
					  <th>清单类型：</th>
					  <td><%=info.getBillType()%></td><!-- WFS_BILL_TYPE -->
				   </tr>
				   <%
				   	}
				   	else if ("流程入基线".equals(applyType)) {
				   %>
				    <tr>
					  <th>流程名称：</th>
					  <td><%=info.getApplyProcessName()%></td>
				   </tr>
				   <tr>
					  <th>版本号：</th>
					  <td><%=info.getVersionno()%></td>
				   </tr>
				     <tr>
					  <th>入基线类型：</th>
					  <td><%=info.getBaselineType()%></td><!-- WFS_BASELIN_TYPE -->
				   </tr>
				    <tr>
					  <th>所属支撑组：</th>
					  <td><%=info.getSupportGroup()%></td><!-- WFS_SUPPORT_GROUP -->
				   </tr>
				   <tr>
					  <th>是否流程优化：</th>
					  <td><%=info.getProcessImprove()%></td><!-- WFS_REFER_FINANCIAL -->
				   </tr>
				   <tr>
					  <th>是否涉及流程目标或绩效变更：</th>
					  <td><%=info.getProcessGoalSalchange()%></td><!-- WFS_REFER_FINANCIAL -->
				   </tr>
				   <tr>
					  <th>流程是否为三级以下：</th>
					  <td><%=info.getUnder3level()%></td><!-- WFS_REFER_FINANCIAL -->
				   </tr>
				   <%
				   	}else if ("流程发布".equals(applyType)) {
				    %>
					<tr>
					  <th>流程名称：</th>
					  <td><%=info.getApplyProcessName()%></td>
				   </tr>
				    <tr>
					  <th>版本号：</th>
					  <td><%=info.getVersionno()%></td>
				   </tr>
				   <%
				   	}%>
				  <tr>
						  <th>申请事由:</th>
						  <td><%=info.getApplyReason()%></td>
				  </tr>
				<%@include file="approve_process.jsp" %>					   					   
	    	</table>
	    </div>
	</div>
	 <%@include file="workflow_approve_button.jsp" %>
</div>
</body>
<script type="text/javascript">
$(function(){
	
	//流程监控组负责人、所属流程支撑组负责人、流程相关部门负责人、一级流程部门负责人、二级流程部门负责人、流程管理部负责人
	//manualActivity7，manualActivity1，manualActivity10，manualActivity4，manualActivity11，manualActivity12，manualActivity3，manualActivity5
// 	var activitydefid = $("#activitydefid").val();
// 	if(activitydefid != 'manualActivity7' 
// 			&& activitydefid != 'manualActivity1' 
// 			&& activitydefid != 'manualActivity10' 
// 			&& activitydefid != 'manualActivity4' 
// 			&& activitydefid != 'manualActivity11' 
// 			&& activitydefid != 'manualActivity12' 
// 			&& activitydefid != 'manualActivity3' 
// 			&& activitydefid != 'manualActivity5'){
// 		$("#div3").hide();
// 		$("#approve_area").hide();
// 		var html = "<div id='div_span'><span style='color:red;float:left;text-align:center;line-height:20px;width: 100%;height: 30px;font-size: 20px;'>该节点未设置手机端，请至网页端审批，谢谢。</span></div>";
// 		$("body").append(html);
// 	}
});
</script>
</html>