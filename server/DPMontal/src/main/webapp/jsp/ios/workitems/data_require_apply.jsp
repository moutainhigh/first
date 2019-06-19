<%@page import="com.deppon.montal.model.OADataRequireApply"%>
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
OADataRequireApply info = (OADataRequireApply)request.getAttribute("OADataRequireApply");
%>
<body>
<div id="list">
	<%@include file="/jsp/ios/work_items_head.jsp" %>
	<div id="div2"> 
    	<div class="ulBox2">
	    	<ul>
				<li>工作流号:<em><%=info.getProcessinstid() %></em></li>
				<li>工作流:<em>数据需求审批流程</em></li>
				<li>申请人:<em><%=info.getApplyname()%></em></li>
				<li>是否对公司外部提供数据:<em><%=info.getIsprovide()%></em></li>
				<li>数据申请部门负责人:<em><%=info.getManager()%></em></li>
				<li>数据使用人:<em><%=info.getDatauser()%></em></li>
				<li>需求数据:<em><%=info.getData()%></em></li>
				<li>数据用途:<em><%=info.getPurpose()%></em></li>
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