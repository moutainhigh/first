<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.module.workitems.webservice.client.DWFSWorkItemServiceClient"%>
<%@page import="com.deppon.wfs.workflow.domain.AssessmentSchemeBean"%>
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
AssessmentSchemeBean info = (AssessmentSchemeBean)request.getAttribute("entity");
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
					   <td>考核方案申请</td>
					</tr>
				   <tr>
					  <th>申请人:</th>
					  <td><%=info.getApplyPersonName()%></td>
				   </tr>
					 <tr>
					  <th>是否为绩效管理员:</th>
					  <td><%=info.getIsPerformanceManager()%></td><!-- WFS_RADION_TYPE -->
				   </tr>
				   <tr>
					  <th>考核部门:</th>
					  <td><%=info.getOragnizationName()  %></td>
				   </tr>
					 <tr>
					  <th>所属事业部:</th>
					  <td><%=info.getArea()%></td><!-- DIP_DIVISION_NEW -->
				   </tr>
					 <tr>
					  <th>考核年份:</th>
					  <td><%=info.getYeartime() %></td>
				   </tr>
				   <tr>
					  <th>考核季度:</th>
					  <td><%=info.getSeason() %></td><!-- WFS_QUARTER -->
				   </tr>
				   <tr>
					  <th>所属部门性质:</th>
					  <td><%=info.getOrgType() %> </td><!-- WFS_DEPARTMENT_PROPERTY -->
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