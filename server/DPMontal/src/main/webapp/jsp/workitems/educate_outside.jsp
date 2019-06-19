<%@page import="com.deppon.montal.model.OAExterNaltraining"%>
<%@page import="com.deppon.montal.model.OADismissal"%>
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
	OAExterNaltraining training = (OAExterNaltraining)request.getAttribute("training");
%>
<div id="list">
	<%@include file="wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
	    		<tr><th>工作流号:</th><td id="workid"><%=training.getProcessinstid()%></td></tr>
				<tr><th>工作流:</th><td>外训申请</td></tr>
				<tr><th>申请人姓名:</th><td><%=training.getName()%></td></tr>
				<tr><th>申请人工号:</th><td><%=training.getApppersonnumber()%></td></tr>
				<tr><th>申请人部门:</th><td><%=training.getApppersonorgname()%></td></tr>
				<tr><th>参加人姓名:</th><td><%=training.getParticipant()%></td></tr>
				<tr><th>所属人事部:</th><td><%=training.getPersonel()%></td></tr>
				<tr><th>课程费用:</th><td><%=training.getCoursefee()%></td></tr>
				
				<tr><th>培训地点:</th><td><%=training.getTrainplace()%></td></tr>
				<tr><th>举办机构:</th><td><%=training.getSponsoringorg()%></td></tr>
				<tr><th>是否向培训组备案:</th><td><%=training.getIsremark()%></td></tr>
				<tr><th>申请事由:</th><td><%=training.getReason()%></td></tr>
	    	</table>
	    	 <%@include file="approve_process.jsp" %>
	    </div>
	</div>
	 <%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>