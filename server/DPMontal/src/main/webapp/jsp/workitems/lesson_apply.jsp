<%@page import="com.deppon.montal.model.OALessonApply"%>
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
OALessonApply info = (OALessonApply)request.getAttribute("OALessonApply");
%>
<body>
<div id="list">
	<%@include file="wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
				<tr><th>工作流号:</th><td id="workid"><%=info.getProcessinstid() %></td></tr>
				<tr><th>工作流:</th><td>课程研发申请</td></tr>
				<tr><th>申请人:</th><td><%=info.getUsername()%></td></tr>
				<tr><th>工号:</th><td><%=info.getUserid()%></td></tr>
				<tr><th>部门:</th><td><%=info.getUserdept()%></td></tr>
				<tr><th>申请课程类别:</th><td><%=info.getLessontype()%></td></tr>
				<tr><th>申请课程名称:</th><td><%=info.getLessonname()%></td></tr>
				<% if(null != info.getLessonid()) {%>
				<tr><th>课程研发申请工作流号:</th><td><%=info.getLessonid()%></td></tr>
				<%} %>
				<tr><th>所属培训管理组:</th><td><%=info.getManagergroup()%></td></tr>
				<tr><th>申请事由</th><td><%=info.getWhyapply()%></td></tr>
		 	</table>
			<%@include file="approve_process.jsp" %>
    	</div>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>