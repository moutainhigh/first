<%@page import="com.deppon.montal.model.OAManagerProcess"%>
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
OAManagerProcess info = (OAManagerProcess)request.getAttribute("oamanagerprocess");
%>
<body>
<div id="list">
	<%@include file="wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
				<tr><th>工作流号:</th><td id="workid"><%=info.getProcessinstid() %></td></tr>
				<tr><th>工作流:</th><td>流程新建/变更/废除</td></tr>
				<tr><th>申请人:</th><td><%=info.getApplyname()%></td></tr>
				<tr><th>申请人工号:</th><td><%=info.getApplyuserid()%></td></tr>
				<tr><th>申请人部门:</th><td><%=info.getApplydeptname()%></td></tr>
				<tr><th>申请类型:</th><td><%=info.getApplytype()%></td></tr>
				<tr><th>流程名称:</th><td><%=info.getApplyprocessname()%></td></tr>
				<tr><th>版本号:</th><td><%=info.getVersionno()==null?"":info.getVersionno()%></td></tr>
				<tr><th>申请事由</th><td><%=info.getApplyreason()==null?"":info.getApplyreason()%></td></tr>
		 </table>
		<%@include file="approve_process.jsp" %>
    	</div>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
	
	
</div>
</body>
</html>