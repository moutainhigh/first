<%@page import="com.deppon.montal.model.OAAssessreduceApply"%>
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
OAAssessreduceApply info = (OAAssessreduceApply)request.getAttribute("OAAssessreduceApply");
	String category = "1".equals(info.getCategory())?"应收账款、坏账类":
	    			  "2".equals(info.getCategory())?"其他类":"";
%>
<body>
<div id="list">
	<%@include file="/jsp/ios/work_items_head.jsp" %>
	<div id="div2">
    	<div class="ulBox2">
	    	<ul>
				<li class="first">工作流号:<em><%=info.getProcessinstid() %></em></li>
				<li>工作流:<em>考核特批减免申请</em></li>
				<li>申请人:<em><%=info.getName()%></em></li>
				<li>减免类别:<em><%=category%></em></li>
				<li>申请事由<em><%=info.getReason()%></em></li>
		 	</ul>
    	</div>
    	<%@include file="approve_process.jsp" %>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
	
	
	
	
	 <input type="hidden" id="workid" value="<%=info.getProcessinstid()%>">
</div>
</body>
</html>