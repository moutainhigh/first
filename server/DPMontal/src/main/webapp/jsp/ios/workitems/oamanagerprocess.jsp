<%@page import="com.deppon.montal.model.OAManagerProcess"%>
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
OAManagerProcess info = (OAManagerProcess)request.getAttribute("oamanagerprocess");

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
				<li>工作流:<em>流程新建/变更/废除</em></li>
				<li>申请人:<em><%=info.getApplyname()%></em></li>
				<li>申请人工号:<em><%=info.getApplyuserid()%></em></li>
				<li>申请人部门:<em><%=info.getApplydeptname()%></em></li>
				<li>申请类型:<em><%=info.getApplytype()%></em></li>
				<li>流程名称:<em><%=info.getApplyprocessname()%></em></li>
				<li>版本号:<em><%=info.getVersionno()==null?"":info.getVersionno()%></em></li>
				<li>申请事由:<em><%=info.getApplyreason()==null?"":info.getApplyreason()%></em></li>
	    	</ul>
	    </div>
	     <%@include file="approve_process.jsp" %>
	</div>
	 <%@include file="workflow_approve_button.jsp" %>
</div>
</body>

</html>