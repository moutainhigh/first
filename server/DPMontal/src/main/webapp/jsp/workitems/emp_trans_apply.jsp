<%@page import="com.deppon.montal.model.OAChangeAndresignApply"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_win8.jsp" %>
</head>
<body>
<%
	OAChangeAndresignApply info = (OAChangeAndresignApply)request.getAttribute("OAChangeAndresignApply");
%>
<div id="list">
	<%@include file="wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
	    		<tr><th>工作流号:</th><td id="workid"><%=info.getProcessinstid()%></td></tr>
				<tr><th>工作流:</th><td>异动调动申请</td></tr>
				<tr><th>申请人工号:</th><td><%=info.getUserid()%></td></tr>
				<tr><th>申请人姓名:</th><td><%=info.getName() %></td></tr>
				<tr><th>申请类别:</th><td><%=info.getApplytype()%></td></tr>
				<tr><th>职位等级:</th><td><%=info.getJoblevel()%></td></tr>
				<%if("公司调动".equals(info.getApplytype())) {%>
				<tr><th>部门性质:</th><td><%=info.getDeptnature()%></td></tr>
					<%if("员工进职能部门".equals(info.getDeptnature())){%>
				<tr><th>是否参加储备经理培训:</th><td><%=info.getIsmanagertrain()%></td></tr>
					<%} %>
				<%} %>
				<tr><th>所属人事部:</th><td><%=info.getAreapersonneldept()%></td></tr>
				<tr><th>变动前部门:</th><td><%=info.getBeforedept()%></td></tr>
				<tr><th>变动前职位:</th><td><%=info.getBeforeposition()%></td></tr>
				<tr><th>变动后部门:</th><td><%=info.getAfterdept()%></td></tr>
				<tr><th>变动后职位:</th><td><%=info.getAfterposition()%></td></tr>
				<tr><th>增补员工作流号:</th><td><%=info.getAddpersonno()%></td></tr>
				<%if("个人异动".equals(info.getApplytype())) {%>
				<tr><th>回原籍工作流号:</th><td><%=info.getBackoriginno()%></td></tr>
				<%}%>
				<tr><th>是否引起住所变更:</th><td><%=info.getIsvaraddress()%></td></tr>
				<tr><th>是否使用公司手机卡:</th><td><%=info.getIsusephone()%></td></tr>
				<%if("是".equals(info.getIsusephone())) {%>
				<tr><th>手机号码:</th><td><%=info.getPhonenumber()%></td></tr>
				<tr><th>是否交接手机卡:</th><td><%=info.getIstelhand()%></td></tr>
					<%if("是".equals(info.getIstelhand())) {%>
				<tr><th>交接手机卡后使用人:</th><td><%=info.getAfteruser()%></td></tr>
				<tr><th>交接前手机话费:</th><td><%=info.getMoney()%></td></tr>
					<%}%>
				<%}%>
				<tr><th>申请事由:</th><td><%=info.getReason()%></td></tr>
	    	</table>
	    	<%@include file="approve_process.jsp" %>
	    </div>
	</div>
	 <%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>