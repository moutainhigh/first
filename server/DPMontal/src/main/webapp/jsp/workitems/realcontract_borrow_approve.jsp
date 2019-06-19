<%@page import="com.deppon.montal.model.OARealcontractBorrow"%>
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
	OARealcontractBorrow info = (OARealcontractBorrow)request.getAttribute("OARealcontractBorrow");
%>
<body>
<div id="list">
	<%@include file="wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
					<tr><th>工作流号:</th><td id="workid"><%=info.getProcessinstid() %></td></tr>
					<tr><th>工作流:</th><td>实体合同借阅</td></tr>
					<tr> <th>姓名:</th><td><%=info.getName()%></td></tr>
					<tr><th>工号:</th><td><%=info.getEmpcode()%></td></tr>
					<tr><th>所属事业部:</th><td><%=info.getArea()%></td></tr>
					<tr><th>合同编号:</th><td><%=info.getContractnum()%></td></tr>
					<tr><th>客户名称:</th><td><%=info.getCustomername()%></td></tr>
					<tr><th>签订部门:</th><td><%=info.getSigndepartment()%></td></tr>
					<tr><th>合同类别:</th><td><%=info.getContracttype()%></td></tr>
					<tr><th>合同密级:</th><td>
						   <% String ontractdense =info.getContractdense();%>
					   	   <%= "1".equals(ontractdense)?"普通":
					   	       "2".equals(ontractdense)?"机密":
					   		   "3".equals(ontractdense)?"绝密":""
					   	   %>
					   </td>
					</tr>
					<tr><th>借阅天数:</th><td><%=info.getBorrowdays()%></td></tr>
					<tr> <th>开始时间:</th><td><%=info.getStartdate()%></td></tr>
					<tr><th>结束时间:</th><td><%=info.getEnddate()%></td></tr>
					<tr class="topLine"><th>申请事由</th><td  style="word-wrap:break-word;word-break:break-all"><%=info.getReson()%></td></tr>
				</table>
				<%@include file="approve_process.jsp" %>
    	</div>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>