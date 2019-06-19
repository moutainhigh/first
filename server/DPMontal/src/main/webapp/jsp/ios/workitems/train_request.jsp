<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.model.OATrainRequest"%>
<%@page import="com.deppon.montal.model.CCOnbusiness"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_ios.jsp" %>
</head>
<body>
<%CCOnbusiness info  =(CCOnbusiness)request.getAttribute("CCOnbusiness");%>
<div id="list">
	<%@include file="/jsp/ios/work_items_head.jsp" %>
	<div id="div2">
    	<div class="ulBox2">
			<ul>	
				<%
					OATrainRequest apply = (OATrainRequest)request.getAttribute("trainRequest");	
				%>
				<li class="first">工作流号:<em><%=apply.getProcessinstid() %></em></li>
		  		<li>工作流:<em>培训需求申请</em><input type="hidden" id="workid" value="<%=apply.getProcessinstid()%>"></li>
				<li>申请人:<em><%=apply.getApplyname()%></em></li>
				<li>申请人部门:<em><%=apply.getApplydeptname()%></em></li>
				<li>培训类型:<em><%=apply.getTraintype()%></em></li>	
				<li>讲师资源是否充足:<em><%=apply.getIsconsultant()%></em></li>
				<li>选择所属培训组:<em><%=apply.getTrainorgName()%></em></li>
				<li>费用预算金额:<em><%=apply.getLecturername()%></em></li>
				<li>培训对象:<em><%=apply.getTrainmanagerposition()%></em></li>		
				<li>预计培训人数:<em><%=apply.getExpectednum()%></em></li>
				<li>培训起止时间:<em><%=FormatUtil.formatDate(apply.getBegintraindate())%>到<%=FormatUtil.formatDate(apply.getEndtraindate())%></em></li>
				<li>培训课程和目标:<em><%=apply.getTrainsubjects()%></em></li>
			 </ul>
	    </div>
	    <%@include file="approve_process.jsp" %>
	</div>
	 <%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>