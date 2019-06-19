<%@page import="com.deppon.montal.model.OATrainLeave"%>
<%@page import="com.deppon.montal.model.OATrainLeaveDetail"%>
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
OATrainLeave info = (OATrainLeave)request.getAttribute("OATrainLeave");
List<OATrainLeaveDetail> details = (List<OATrainLeaveDetail>)request.getAttribute("OATrainLeaveDetail");
%>
<body>
<div id="list">
	<%@include file="wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
				<tr><th>工作流号:</th><td id="workid"><%=info.getProcessinstid() %></td></tr>
				<tr><th>工作流:</th><td>培训请假申请</td></tr>
				<tr><th>申请人:</th><td><%=info.getName()%></td></tr>
				<tr><th>部门性质:</th><td><%=info.getDeptproperty()%></td></tr>
				<tr><th>培训请假项目:</th><td><%=info.getTrainname()%></td></tr>
				<tr><th>所属人事部:</th><td><%=info.getArea()%></td></tr>
				<tr><th>请假开始日期:</th><td><%=info.getStartdate()%></td></tr>
				<tr><th>请假结束日期:</th><td><%=info.getEnddate()%></td></tr>
		 </table>
		 <table width="100%">
		 		<tr class="yellow"><th colspan="2">详细信息</tr>
				<%
					int index = 0;
					for(OATrainLeaveDetail detail : details){
				%>
				<tr <%=index == 0 ?"":"class='topLine'" %>>
				<th>请假人姓名:</th><td><%=detail.getName()%></td></tr>
				<tr><th>请假人工号:</th><td><%=detail.getEmpid()%></td></tr>
				<tr><th>请假事由:</th><td><%=detail.getRemark()%></td></tr>
				<tr><th>已参加人姓名:</th><td><%=detail.getUsername()%></td></tr>
				<tr><th>已参加人工号:</th><td><%=detail.getUserid()%></td></tr>
				<tr><th>病/事假申请工作流号:</th><td><%=detail.getLeaveprocid()%></td></tr>
				<%index++; } %>
		 </table>
		<%@include file="approve_process.jsp" %>
    	</div>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>