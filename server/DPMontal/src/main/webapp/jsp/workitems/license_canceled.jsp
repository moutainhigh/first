<%@page import="com.deppon.montal.model.OALicenseCanceledInfo"%>
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
	OALicenseCanceledInfo info = (OALicenseCanceledInfo)request.getAttribute("licensecanceledinfo");
%>
<div id="list">
	<%@include file="wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
	    		<tr><th>工作流号:</th><td id="workid"><%=info.getProcessinstid()%></td></tr>
				<tr><th>工作流:</th><td>分公司证照注销</td></tr>
				<tr><th>申请人姓名:</th><td><%=info.getName()%></td></tr>
				<tr><th>部门名称:</th><td><%=info.getOrgname()%></td></tr>
				<tr><th>分公司名称:</th><td><%=info.getSubcompany()%></td></tr>
				<tr><th>注销时效:</th><td><%=info.getCancellaging()%></td></tr>
				<tr><th>所属财务部:</th><td><%=info.getFinancedep()%></td></tr>
				<tr><th>所属公共事务组:</th><td><%=info.getMatterteam()%></td></tr>
				<tr><th>注销证照种类:</th><td><%=info.getCanceltype()%></td></tr>
				<tr><th>申请事由:</th><td><%=info.getReason()%></td></tr>
	    	</table>
	    	 <%@include file="approve_process.jsp" %>
	    </div>
	</div>
	 <%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>