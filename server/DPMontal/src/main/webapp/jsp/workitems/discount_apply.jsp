<%@page import="com.deppon.montal.model.OAdisCountApply"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_win8.jsp" %>
</head>
</head>
<%
OAdisCountApply info = (OAdisCountApply)request.getAttribute("OAdisCountApply");
%>
<body>
<div id="list">
	<%@include file="wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
				<tr><th>工作流号:</th><td id="workid"><%=info.getProcessinstid() %></td></tr>
				<tr><th>工作流:</th><td>折扣申请</td></tr>
				<tr><th>申请人:</th><td><%=info.getProposer()%></td></tr>
				<tr><th>申请人部门:</th><td><%=info.getDepartment()%></td></tr>
				<tr><th>折扣类型:</th><td><%=info.getDiscounttype()%></td></tr>
				<tr><th>申请事由</th><td><%=info.getReason()%></td></tr>
		 </table>
		<%@include file="approve_process.jsp" %>
    	</div>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>