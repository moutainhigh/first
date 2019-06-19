<%@page import="com.deppon.montal.model.OADataRequireApply"%>
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
OADataRequireApply info = (OADataRequireApply)request.getAttribute("OADataRequireApply");
%>
<body>
<div id="list">
	<%@include file="wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
				<tr><th>工作流号:</th><td id="workid"><%=info.getProcessinstid() %></td></tr>
				<tr><th>工作流:</th><td>数据需求审批流程</td></tr>
				<tr><th>申请人:</th><td><%=info.getApplyname()%></td></tr>
				<tr><th>是否对公司外部提供数据:</th><td><%=info.getIsprovide()%></td></tr>
				<tr><th>数据申请部门负责人:</th><td><%=info.getManager()%></td></tr>
				<tr><th>数据使用人:</th><td><%=info.getDatauser()%></td></tr>
				<tr><th>需求数据:</th><td><%=info.getData()%></td></tr>
				<tr><th>数据用途:</th><td><%=info.getPurpose()%></td></tr>
				<tr><th>申请事由</th><td><%=info.getReason()%></td></tr>
		 </table>
		<%@include file="approve_process.jsp" %>
    	</div>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>