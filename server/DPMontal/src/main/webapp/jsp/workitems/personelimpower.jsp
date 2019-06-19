<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.model.OAPersonelimPower"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.montal.conf.F_Constants"%>
<%@page import="java.util.List"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_win8.jsp" %>
</head>
</head>
<%
	OAPersonelimPower powerApply = (OAPersonelimPower)request.getAttribute("powerApply");
%>
<body>
<div id="list">
	<%@include file="wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
					<tr>
					   <th>工作流号:</th>
					   <td id="workid"><%=powerApply.getProcessinstid() %></td>
					</tr>
					<tr>
					   <th>工作流:</th>
					   <td>
						  人事授权申请
					   </td>
					</tr>
					<tr>
					   <th>申请人:</th>
					   <td>
						  <%=powerApply.getApplyname() %>
					   </td>
					</tr>
					<tr>
					   <th>授权给:</th>
					   <td>
						  <%=powerApply.getImpowerto() %>
					   </td>
					</tr>
					<tr>
					   <th>授权开始日期:</th>
					   <td>
						  <%=FormatUtil.formatDate(powerApply.getImpowerstarttime())%>
					   </td>
					</tr>
					<tr>
					   <th>授权结束日期:</th>
					   <td>
						  <%=FormatUtil.formatDate(powerApply.getImpowerendtime()) %>
					   </td>
					</tr>
					<!-- 
					<tr>
					   <th>是否授权审批工作流:</th>
					   <td>
						  <%=powerApply.getIsauthorized()==null?"":powerApply.getIsauthorized() %>
					   </td>
					</tr>
					-->
					<tr>
					   <th>申请事由:</th>
					   <td>
						  <%=powerApply.getReason()==null?"":powerApply.getReason() %>
					   </td>
					</tr>
				</table>
				<%@include file="approve_process.jsp" %>
    	</div>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>