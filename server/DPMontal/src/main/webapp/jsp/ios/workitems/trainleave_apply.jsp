<%@page import="com.deppon.montal.model.OATrainLeave"%>
<%@page import="com.deppon.montal.model.OATrainLeaveDetail"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_ios.jsp" %>
</head>
</head>
<%
OATrainLeave info = (OATrainLeave)request.getAttribute("OATrainLeave");
List<OATrainLeaveDetail> details = (List<OATrainLeaveDetail>)request.getAttribute("OATrainLeaveDetail");
%>
<body>
<div id="list">
	<%@include file="/jsp/ios/work_items_head.jsp" %>
	<div id="div2">
   	<div class="ulBox2">
			<ul>
				<li class="first">工作流号:<em><%=info.getProcessinstid() %></em></li>
				<li>工作流:<em>培训请假申请</em></li>
				<li>申请人:<em><%=info.getName()%></em></li>
				<li>部门性质:<em><%=info.getDeptproperty()%></em></li>
				<li>培训请假项目:<em><%=info.getTrainname()%></em></li>
				<li>所属人事部:<em><%=info.getArea()%></em></li>
				<li>请假开始日期:<em><%=info.getStartdate()%></em></li>
				<li>请假结束日期:<em><%=info.getEnddate()%></em></li>
		 		<li><em class="yellow">请假人详细信息</em></li>
				<%
					int index = 0;
					for(OATrainLeaveDetail detail : details){
				%>
				<li <%=index >0 ? "class='line'" : "" %>>请假人姓名:<em><%=detail.getName()%></em></li>
				<li>请假人工号:<em><%=detail.getEmpid()%></em></li>
				<li>请假事由:<em><%=detail.getRemark()%></em></li>
				<li>已参加人姓名:<em><%=detail.getUsername()%></em></li>
				<li>已参加人工号:<em><%=detail.getUserid()%></em></li>
				<li>病/事假申请工作流号:<em><%=detail.getLeaveprocid()%></em></li>
				<%index++; } %>
		 </ul>
    	</div>
    	<%@include file="approve_process.jsp" %>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
	
	
	
	<input type="hidden" id="workid" value="<%=info.getProcessinstid()%>">
</div>
</body>
</html>