<%@page import="com.deppon.montal.model.OALicenseLendRead"%>
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
	OALicenseLendRead info = (OALicenseLendRead)request.getAttribute("licenseLendRead");
%>
<div id="list">
	<%@include file="/jsp/ios/work_items_head.jsp" %>
	<div id="div2">
   	<div class="ulBox2">
			<ul>
	    		<li class="first">工作流号:<em><%=info.getProcessinstid()%></em></li>
				<li>工作流:<em>证照借阅申请</em></li>
				<li>借阅人:<em><%=info.getName()%></em></li>
				<li>借阅人工号:<em><%=info.getLendinguserid()%></em></li>
				<li>使用人:<em><%=info.getUsername()%></em></li>
				<li>借阅部门:<em><%=info.getLendingdepart()%></em></li>
				<li>借阅时间:<em><%=info.getLendingdate()%></em></li>
				<li>证照类型:<em><%=info.getLicensetype()%></em></li>
				<li>所属事业部:<em><%=info.getArea()%></em></li>
				<li>借用证照名称:<em><%=info.getLicensename()%></em></li>
				<li>归回日期:<em><%=info.getBackdate()%></em></li>
				<li>使用说明:<em><%=info.getHelp()%></em></li>				
				<li>申请事由:<em><%=info.getWhyapply()%></em></li>
	    	</ul>
	    </div>
	    <%@include file="approve_process.jsp" %>
	</div>
	 <%@include file="workflow_approve_button.jsp" %>
	 
	 
	 
	 <input type="hidden" id="workid" value="<%=info.getProcessinstid()%>">
</div>
</body>
</html>