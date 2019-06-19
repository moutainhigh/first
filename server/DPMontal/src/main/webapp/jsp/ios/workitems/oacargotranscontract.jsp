<%@page import="com.deppon.montal.model.OACarGoTransContract"%>
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
OACarGoTransContract info = (OACarGoTransContract)request.getAttribute("oaCarGoTransContract");

%>
<div id="list">
	<%@include file="/jsp/ios/work_items_head.jsp" %>
	<div id="div2">
    	<div class="ulBox2">
	    	<ul>
			   <li class="first">工作流号:<em><%=info.getProcessinstid() %></em>
			   <input type="hidden" id="workid" value="<%=info.getProcessinstid()%>">
			   <input type="hidden" id ="type_id" value="subsidiaryset">
<%-- 		   <input type="hidden" id ="currentnode_id" value="<%=info.getCurrentnode() %>"> --%>
			   </li>				  
				<li>工作流:<em>整车货物运输合同</em></li>
				<li>申请人姓名:<em><%=info.getName()%></em></li>
				<li>所属区域:<em><%=info.getArea()%></em></li>
				<li>所属子公司:<em><%=info.getSubsidiary()%></em></li>
				<li>申请事由<em><%=info.getReason()==null?"":info.getReason()%></em></li>
	    	</ul>
	    </div>
	     <%@include file="approve_process.jsp" %>
	</div>
	 <%@include file="workflow_approve_button.jsp" %>
</div>
</body>

</html>