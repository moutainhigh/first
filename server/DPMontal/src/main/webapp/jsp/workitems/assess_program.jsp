<%@page import="com.deppon.montal.model.OAAssessApply"%>
<%@page import="java.util.ArrayList"%>
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
OAAssessApply info = (OAAssessApply)request.getAttribute("assess_program");
%>
<div id="list">
	<%@include file="wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
	    		<tr>
					   <th>工作流号:</th>
					   <td id="workid"><%=info.getProcessinstid()%></td>
					</tr>
					<tr>
					   <th>工&nbsp;&nbsp;作&nbsp;&nbsp;流:</th>
					   <td>考核方案申请<input type="hidden" id ="type_id" value="assess_program"></td>
					</tr>
				   <tr>
					  <th>申请人:</th>
					  <td><%=info.getName()%></td>
				   </tr>
					 <tr>
					  <th>考核部门:</th>
					  <td><%=info.getDept()%></td>
				   </tr>
				   <tr>
					  <th>考核年份:</th>
					  <td><%=info.getYear()%></td>
				   </tr>
					 <tr>
					  <th>考核季度:</th>
					  <td><%=info.getSeason()%></td>
				   </tr>
					 <tr>
					  <th>申请事由:</th>
					  <td><%=info.getReason()==null?"":info.getReason()%></td>
				   </tr>
				   <tr>
					  <th>部门性质:</th>
					  <td><%=info.getQuality()%></td>
				   </tr>
			     <%@include file="approve_process.jsp" %>
	    	</table>
	    </div>
	</div>
	 <%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>