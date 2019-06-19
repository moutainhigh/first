<%@page import="com.deppon.montal.model.OACarGoTransContract"%>
<%@page import="com.deppon.montal.model.OASitedesign"%>
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
OACarGoTransContract info = (OACarGoTransContract)request.getAttribute("oaCarGoTransContract");
%>
<body>
<div id="list">
	<%@include file="wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
				<tr><th>工作流号:</th><td id="workid"><%=info.getProcessinstid() %></td></tr>
				<tr><th>工作流:</th><td>整车货物运输合同</td></tr>
				<tr><th>申请人姓名:</th><td><%=info.getName()%></td></tr>
				<tr><th>所属区域:</th><td><%=info.getArea()%></td></tr>
				<tr><th>所属子公司:</th><td><%=info.getSubsidiary()%></td></tr>
				<tr><th>申请事由</th><td><%=info.getReason()==null?"":info.getReason()%></td></tr>
		 </table>
		<%@include file="approve_process.jsp" %>
    	</div>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
	
	
</div>
</body>
</html>