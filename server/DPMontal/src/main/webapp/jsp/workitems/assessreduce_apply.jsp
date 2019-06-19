<%@page import="com.deppon.montal.model.OAAssessreduceApply"%>
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
OAAssessreduceApply info = (OAAssessreduceApply)request.getAttribute("OAAssessreduceApply");
	String category = "1".equals(info.getCategory())?"应收账款、坏账类":
	    			  "2".equals(info.getCategory())?"其他类":"";
%>
<body>
<div id="list">
	<%@include file="wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
				<tr><th>工作流号:</th><td id="workid"><%=info.getProcessinstid() %></td></tr>
				<tr><th>工作流:</th><td>考核特批减免申请</td></tr>
				<tr><th>申请人:</th><td><%=info.getName()%></td></tr>
				<tr><th>减免类别:</th><td><%=category%></td></tr>
				<tr><th>申请事由</th><td><%=info.getReason()%></td></tr>
		 </table>
		<%@include file="approve_process.jsp" %>
    	</div>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>