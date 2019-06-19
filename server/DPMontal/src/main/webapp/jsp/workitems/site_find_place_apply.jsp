<%@page import="com.deppon.montal.model.OASiteFindPlaceApply"%>
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
	OASiteFindPlaceApply info = (OASiteFindPlaceApply)request.getAttribute("OASiteFindPlaceApply");
%>
<div id="list">
	<%@include file="wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
	    		<tr><th>工作流号:</th><td id="workid"><%=info.getProcessinstid()%></td></tr>
				<tr><th>工作流:</th><td>场地找点申请</td></tr>
				<tr><th>申请人:</th><td><%=info.getName()%></td></tr>
				<tr><th>申请人工号:</th><td><%=info.getEmpcode()%></td></tr>
				<tr><th>申请人部门:</th><td><%=info.getDepartment()%></td></tr>
				<tr><th>所属事业部:</th><td><%=info.getArea()%></td></tr>
				<tr><th>申请事由:</th><td><%=info.getWhyapply()%></td></tr>
	    	</table>
	    	 <%@include file="approve_process.jsp" %>
	    </div>
	</div>
	 <%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>