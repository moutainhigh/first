<%@page import="com.deppon.montal.model.OASiteFindPlaceApply"%>
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
	OASiteFindPlaceApply info = (OASiteFindPlaceApply)request.getAttribute("OASiteFindPlaceApply");
%>
<div id="list">
	<%@include file="/jsp/ios/work_items_head.jsp" %>
	<div id="div2">
   	<div class="ulBox2">
			<ul>
	    		<li class="first">工作流号:<em><%=info.getProcessinstid()%></em></li>
				<li>工作流:<em>场地找点申请</em></li>
				<li>申请人:<em><%=info.getName()%></em></li>
				<li>申请人工号:<em><%=info.getEmpcode()%></em></li>
				<li>申请人部门:<em><%=info.getDepartment()%></em></li>
				<li>所属事业部:<em><%=info.getArea()%></em></li>
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