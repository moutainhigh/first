<%@page import="com.deppon.wfs.workflow.domain.CentralizedPickBean"%>
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
CentralizedPickBean info = (CentralizedPickBean)request.getAttribute("entity");
%>
<body>
<div id="list">
	<%@include file="/jsp/ios/work_items_head.jsp" %>
	<div id="div2">
   	<div class="ulBox2">
			<ul>
				<li class="first">工作流号:<em><%=info.getProcessinstid() %></em></li>
				<li>工作流:<em>集中接货申请</em></li>
				<li>申请人:<em><%=info.getApplyPersonName()%></em></li>
				<li>申请事由<em><%=info.getApplyReason()%></em></li>
		 </ul>
    	</div>
    	<%@include file="approve_process.jsp" %>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
	
	
	
	
	<input type="hidden" id="workid" value="<%=info.getProcessinstid()%>">
	<input type="hidden" id="busino" value="<%=info.getBusino()%>">
	<input type="hidden" id="approval_url" value="<%=F_Constants.NORMOL_APPROVAL_URL%>">
</div>
</body>
</html>