<%@page import="com.deppon.montal.model.OABankAccountOpencl"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.model.OABaddebtChild"%>
<%@page import="com.deppon.montal.model.OABaddebtApply"%>
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
<body>
<div id="list">
	<%@include file="wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
					<%
						OABankAccountOpencl apply = (OABankAccountOpencl)request.getAttribute("openClApply");
					%>
					<tr>
					   <th>工作流号:</th>
					   <td id="workid"><%=apply.getProcessinstid() %></td>
					</tr>
					<tr>
					   <th>工作流:</th>
					   <td>
							银行开户/销户申请
					   </td>
					</tr>
					<tr>
						<th>申请人姓名：</th>
						<td><%=apply.getName() %>
						</td>
					</tr>
					<tr>
						<th>部门：</th>
						<td><%=apply.getOrgname() %></td>
					</tr>
					
					<tr>
						<th>申请类别：</th>
						<td><%=apply.getApplytype().equals("1")?"开户":"销户" %></td>
					</tr>
					<tr>
						<th>账户类型：</th>
						<td><%=apply.getAccounttype().equals("1")?"个人户":"对公户" %></td>
					</tr>
					<%
						if(apply.getAccountopenname() != null){
					%>
					<tr>
						<th>开户名：</th>
						<td><%=apply.getAccountopenname() %></td>
					</tr>
					<tr>
						<th>账号：</th>
						<td><%=apply.getAccounts() %></td>
					</tr>
					<%
						}
					%>
					<tr>
						<th>所属财务部：</th>
						<td><%=apply.getAccountingname()%></td>
					</tr>
					<%
						if(apply.getBankname() != null){
					%>
					<tr>
						<th>开户银行：</th>
						<td><%=apply.getBankname() %></td>
					</tr>
					<%
						}
					%>
					<tr>
						<th>申请事由：</th>
						<td  style="word-wrap:break-word;word-break:break-all"><%=apply.getReason()==null?"": apply.getReason()%></td>
					</tr>
				</table>
				<%@include file="approve_process.jsp" %>
    	</div>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>