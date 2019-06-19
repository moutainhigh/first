<%@page import="com.deppon.wfs.workflow.domain.AssessmentSchemeApplyBean"%>
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
	AssessmentSchemeApplyBean info = (AssessmentSchemeApplyBean)request.getAttribute("entity");
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
				   <td>考核方案提交申请</td>
				</tr>
			   <tr>
				  <th>申请人:</th>
				  <td><%=info.getApplyPersonName()%></td>
			   </tr>
			   <tr>
				  <th>考核部门:</th>
				  <td><%=info.getDept()%></td>
			   </tr>
			   <tr>
				  <th>考核年份:</th>
				  <td><%=info.getYear()%></td>
			   </tr>
			   <tr>
				  <th>考核季度:</th>
				  <td><%=info.getSeason()%></td>
			   </tr>
			   <tr>
				  <th>选择考核小组:</th>
				  <td><%=info.getCheckTeamCode()%></td>
			   </tr>
			   <tr>
				  <th>选择考核专员/绩效管理员:</th>
				  <td><%=info.getPersonMappingDeptName()%></td>
			   </tr>
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
</html>