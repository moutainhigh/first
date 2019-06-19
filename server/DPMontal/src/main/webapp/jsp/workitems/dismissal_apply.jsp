<%@page import="com.deppon.montal.model.OADismissal"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_win8.jsp" %>
</head>
<body>
<%
	OADismissal info = (OADismissal)request.getAttribute("OADismissal");
%>
<div id="list">
	<%@include file="wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
	    		<tr><th>工作流号:</th><td id="workid"><%=info.getProcessinstid()%></td></tr>
				<tr><th>工作流:</th><td>免职申请</td></tr>
				<tr><th>申请人姓名:</th><td><%=info.getName()%></td></tr>
				<tr><th>免职类型:</th><td><%=info.getDismissaltype()%></td></tr>
				<tr><th>被免职人:</th><td><%=info.getManname()%></td></tr>
				<tr><th>被免职人部门:</th><td><%=info.getMandept()%></td></tr>
				<tr><th>被免职人职位:</th><td><%=info.getManpost()%></td></tr>
				<tr><th>所属人事部:</th><td><%=info.getPersonnel()%></td></tr>
				<tr><th>申请事由:</th><td><%=info.getRemark()%></td></tr>
	    	</table>
	    	 <%@include file="approve_process.jsp" %>
	    </div>
	</div>
	 <%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>