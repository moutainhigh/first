<%@page import="com.deppon.montal.model.OALessonApply"%>
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
OALessonApply info = (OALessonApply)request.getAttribute("OALessonApply");
%>
<body>
<div id="list">
   <%@include file="/jsp/ios/work_items_head.jsp" %>
   <!--div2 S-->
   <div id="div2">
   	<div class="ulBox2">
			<ul>
				<li class="first">工作流号:<em><%=info.getProcessinstid() %></em></li>
				<li>工作流:<em>课程研发申请</em></li>
				<li>申请人:<em><%=info.getUsername()%></em></li>
				<li>工号:<em><%=info.getUserid()%></em></li>
				<li>部门:<em><%=info.getUserdept()%></em></li>
				<li>申请课程类别:<em><%=info.getLessontype()%></em></li>
				<li>申请课程名称:<em><%=info.getLessonname()%></em></li>
				<% if(null != info.getLessonid()) {%>
				<li>课程研发申请工作流号:<em><%=info.getLessonid()%></em></li>
				<%} %>
				<li>所属培训管理组:<em><%=info.getManagergroup()%></em></li>
				<li>申请事由<em><%=info.getWhyapply()%></em></li>
		 	</ul>
    	</div>
    	<%@include file="approve_process.jsp" %>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
	
	
	
	 <input type="hidden" id="workid" value="<%=info.getProcessinstid()%>">
</div>
</body>
</html>