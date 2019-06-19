<%@page import="com.deppon.montal.model.OAElectroniContractBorrow"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
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
	OAElectroniContractBorrow apply = (OAElectroniContractBorrow)request.getAttribute("borrowApply");
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
					   <td id="workid"><%=apply.getProcessinstid() %></td>
					</tr>
					<tr>
					   <th>工作流:</th>
					   <td>
						 	电子合同借阅
					   </td>
					</tr>
					<tr>
					   <th>姓名:</th>
					   <td>
						  <%=apply.getName() %>
					   </td>
					</tr>
					<tr>
					   <th>工号:</th>
					   <td>
						  <%=apply.getEmpcode()%>
					   </td>
					</tr>
					<tr>
					   <th>所属事业部:</th>
					   <td>
						  <%=apply.getArea() %>
					   </td>
					</tr>
					<tr>
					   <th>合同编号:</th>
					   <td>
						  <%=apply.getContractnum()%>
					   </td>
					</tr>
					<tr>
					   <th>合同类别:</th>
					   <td>
						  <%=apply.getContracttype()==null?"":apply.getContracttype()%>
					   </td>
					</tr>
					<tr>
					   <th>合同密级:</th>
					   <td>
						  <%=OAElectroniContractBorrow.BORROW_CONTRACT_DENSE.get(apply.getContractdense())%>
					   </td>
					</tr>
					
					<tr>
					   <th>借阅天数:</th>
					   <td>
						  <%=apply.getBorrowdays()%>
					   </td>
					</tr>
					<tr>
					   <th>开始时间:</th>
					   <td>
						  <%=apply.getStartdate()%>
					   </td>
					</tr>
					<tr>
					   <th>结束时间:</th>
					   <td>
						  <%=apply.getEnddate()%>
					   </td>
					</tr>
					
					<tr>
					   <th>申请事由:</th>
					   <td>
						  <%=apply.getReason()==null?"":apply.getReason() %>
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