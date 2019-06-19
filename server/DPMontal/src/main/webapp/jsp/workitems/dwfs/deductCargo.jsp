<%@page import="com.deppon.wfs.workflow.domain.DeductCargo"%>
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
	DeductCargo info = (DeductCargo)request.getAttribute("entity");
%>
<div id="list">
	<%@include file="../wf_head_win8.jsp" %>
	<input type="hidden" id="busino" value="<%=info.getBusino()%>">
	<input type="hidden" id="approval_url" value="<%=F_Constants.NORMOL_APPROVAL_URL%>">
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
	    		<tr><th>工作流号:</th><td id="workid"><%=request.getAttribute("processinstid")%></td></tr>
				<tr><th>工&nbsp;&nbsp;作&nbsp;&nbsp;流:</th><td>扣货申请</td></tr>
				<tr><th>申请人:</th><td><%=info.getApplyPersonName()%></td></tr>
				<tr><th>所属事业部:</th><td><%=info.getBusinessDept()%></td><!-- DIP_DIVISION_NEW -->
				</tr><tr><th>扣货单号:</th><td><%=info.getDeductCargoNo()%></td></tr>
				<tr><th>货物扣留所在部门:</th><td><%=info.getDepartment() %></td></tr>
				<tr><th>发货人姓名:</th><td><%=info.getSendName()%></td></tr>
				<tr><th>收货人姓名:</th><td><%=info.getReceiveName()%></td></tr>
				<tr><th>保价金额:</th><td><%=info.getKeepValueMoney()%></td></tr>
				<tr><th>代收款金额:</th><td><%=info.getAgencyMoney() %></td></tr>
				<tr><th>合同编码:</th><td><%=info.getContractNo()%></td></tr>
				<tr><th>申请事由:</th><td><%=info.getApplyReason()%></td></tr>
				<%@include file="approve_process.jsp" %>					   					   
	    	</table>
	    </div>
	</div>
	 <%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>