<%@page import="com.deppon.montal.model.CCZhuanfeiLixiang"%>
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
	CCZhuanfeiLixiang info = (CCZhuanfeiLixiang)request.getAttribute("CCZhuanfeiLixiang");
%>
<div id="list">
<%@include file="/jsp/ios/work_items_head.jsp" %>
   <!--div2 S-->
   <div id="div2">
   		<div class="ulBox2">
   			<ul>
	    		<li>工作流号:<em><%=info.getProcessinstid()%></em></li>
				<li>工作流:<em>专项费用立项申请</em></li>
				<li>申请人姓名:<em><%=info.getApplyname()%></em></li>
				<li>申请人工号:<em><%=info.getApplyid()%></em></li>
				<li>所属子公司:<em><%=info.getSubcompany()%></em></li>
				<li>申请事由:<em><%=info.getReason()%></em></li>
	    	</ul>
	    </div>
	    <%@include file="approve_process.jsp" %>
	</div>
	 <%@include file="workflow_approve_button.jsp" %>
	 
	 
	 
	 <input type="hidden" id="workid" value="<%=info.getProcessinstid()%>">
</div>
</body>
</html>