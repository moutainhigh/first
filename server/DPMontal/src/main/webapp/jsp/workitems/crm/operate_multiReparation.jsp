<%@page import="com.deppon.montal.module.crm.damin.QueryWorkflowInfoResponse"%>
<%@page import="com.deppon.montal.module.crm.damin.OverpayInfo"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.module.workitems.webservice.client.DWFSWorkItemServiceClient"%>
<%@page import="com.deppon.wfs.workflow.domain.WarrantEntityBean"%>
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
	QueryWorkflowInfoResponse responseEntity = (QueryWorkflowInfoResponse)request.getAttribute("queryWorkflowInfoResponse");
	OverpayInfo  info = responseEntity.getOverPayInfo();
%>
<div id="list">
	<%@include file="../wf_head_win8.jsp" %>
<%-- 	<input type="hidden" id="busino" value="<%=info.getWaybillNumber()%>"> --%>
<%-- 	<input type="hidden" id="approval_url" value="<%=F_Constants.NORMOL_APPROVAL_URL%>"> --%>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
			   <tr><th>工作流:</th><td>多赔申请</td></tr>
			   <tr><th>申请人:</th><td><%=info.getCrateUserName()%></td></tr>
			   <tr><th>运输类型:</th><td><%=info.getTransType()==null?"":info.getTransType()%></td></tr>
			   <tr><th>多赔单号:</th><td><%=info.getWaybillNumber()==null?"":info.getWaybillNumber()%></td></tr>
			   <tr><th>多赔金额:</th><td><%=info.getOverpayAmount()==null?"":info.getOverpayAmount()%></td></tr>
			   <tr><th>合计理赔金额:</th><td><%=info.getRealAmount()==null?"":info.getRealAmount()%></td></tr>
			   <tr><th>应收账款是否收回:</th><td><%=info.getRecoverYszk()==null?"":info.getRecoverYszk()%></td></tr>
			   <tr><th>部门会计:</th><td><%=info.getDeptAccount()==null?"":info.getDeptAccount()%></td></tr>
			   <tr><th>所属事业部:</th><td><%=info.getDivisionName()==null?"":info.getDivisionName()%></td></tr>
			   <tr><th>申请事由:</th><td><%=info.getOverpayReason()==null?"":info.getOverpayReason()%></td></tr>
			   <%@include file="approve_process.jsp" %>
	    	</table>
	    </div>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>