<%@page import="com.deppon.montal.model.OAMuchRecompensate"%>
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
	OAMuchRecompensate sate  = (OAMuchRecompensate)request.getAttribute("muchSate");
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
				   <td id="workid"><%=sate.getProcessinstid() %></td>
				</tr>
				<tr>
				   <th>工作流:</th>
				   <td>
					  	多赔
				   </td>
				</tr>				
				<tr>
					<th>申请人：</th>
					<td><%=sate.getApplypersonname() %></td>
				</tr>
				<tr>
					<th>多赔单号：</th>
					<td><%=sate.getTransportorerrorcode() %></td>
				</tr>
				<tr>
					<th>多赔金额：</th>
					<td><%=sate.getRecompensiesmoney() %></td>					
				</tr>
				<tr>
					<th>合计理赔金额：</th>
					<td><%=sate.getAmountintotal()%></td>
				</tr>
				<tr>
					<th>应收账款是否收回：</th>
					<td><%=sate.getHasrepaydebt() %></td>
				</tr>
				<tr>
					<th>部门会计：</th>
					<td><%=sate.getDeptaccountant()==null?"":sate.getDeptaccountant() %></td>
				</tr>
				<tr>
					<th>所属事业部：</th>
					<td><%=sate.getEnterprisedept() %></td>
				</tr>
				<tr>
					<th>申请事由：</th>
					<td><%=sate.getApplyreason() %></td>
				</tr>
				<%@include file="approve_process.jsp" %>					
			</table>
    	</div>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>