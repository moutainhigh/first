<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.module.workitems.webservice.client.DWFSWorkItemServiceClient"%>
<%@page import="com.deppon.wfs.workflow.domain.OtherSideLineProxy"%>
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
OtherSideLineProxy info = (OtherSideLineProxy)request.getAttribute("entity");
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
					   <td>偏线代理合同</td>
<!-- 					   <input type="hidden" id ="type_id" value="qualification"> -->
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
					  <th>工作流类别:</th>
					  <td><%=info.getFlowCategory()  %></td><!-- WFS_PROXY_WFTYPE -->
				   </tr>
					 <tr>
					  <th>外发部门名称:</th>
					  <td><%=info.getStartOrgName()%></td>
				   </tr>
					 <tr>
					  <th>所属财务部:</th>
					  <td><%=info.getFinqnceCode() %> </td><!-- NEW_FINANCIAL -->
				   </tr>
				   <tr>
					  <th>所属事业部:</th>
					  <td><%=info.getBusinessUnitsCode() %></td><!-- DIP_DIVISION_NEW -->
				   </tr>
				    <tr>
					  <th>保证金支付方式:</th>
					  <td><%=info.getMarginpayCategory() %></td><!-- WFS_PAYMENT -->
				   </tr>
				   <tr>
					  <th>外发成本支付方式:</th>
					  <td><%=info.getStartCostPayCategory()%></td><!-- WFS_PAYMENT -->
				   </tr>
				    <tr>
					  <th>代理名称:</th>
					  <td><%=info.getAgentName()%></td>
				   </tr>
				    <tr>
					  <th>代理所在城市:</th>
					  <td><%=info.getAgentCity()%></td>
				   </tr>
				    <tr>
					  <th>保证金金额:</th>
					  <td><%=info.getMargin()%></td>
				   </tr>
 					   <tr>
						  <th>申请事由:</th>
						  <td><%=info.getReason()%></td>
					   </tr>
				<%@include file="approve_process.jsp" %>					   					   
	    	</table>
	    </div>
	</div>
	 <%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>