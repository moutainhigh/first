<%@page import="com.deppon.montal.model.OADismissal"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_ios.jsp" %>
</head>
<body>
<%
	OADismissal info = (OADismissal)request.getAttribute("OADismissal");
%>
<div id="list">
	<%@include file="/jsp/ios/work_items_head.jsp" %>
	<div id="div2">
    	<div class="ulBox2">
	    	<ul>
	    		<li class="first">工作流号:<em><%=info.getProcessinstid()%></em></li>
				<li>工作流:<em>免职申请</em></li>
				<li>申请人姓名:<em><%=info.getName()%></em></li>
				<li>免职类型:<em><%=info.getDismissaltype()%></em></li>
				<li>被免职人:<em><%=info.getManname()%></em></li>
				<li>被免职人部门:<em><%=info.getMandept()%></em></li>
				<li>被免职人职位:<em><%=info.getManpost()%></em></li>
				<li>所属人事部:<em><%=info.getPersonnel()%></em></li>
				<li>申请事由:<em><%=info.getRemark()%></em></li>
	    	</ul>
	    	 <%@include file="approve_process.jsp" %>
	    </div>
	</div>
	 <%@include file="workflow_approve_button.jsp" %>
	 



	 <input type="hidden" id="workid" value="<%=info.getProcessinstid()%>">
</div>
</body>
</html>