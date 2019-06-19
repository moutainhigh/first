<%@page import="com.deppon.montal.model.OAChangeAndresignApply"%>
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
	OAChangeAndresignApply info = (OAChangeAndresignApply)request.getAttribute("OAChangeAndresignApply");
%>
<div id="list">
	<%@include file="/jsp/ios/work_items_head.jsp" %>
	<div id="div2">
    	<div class="ulBox2">
	    	<ul>
	    		<li class="first">工作流号:<em><%=info.getProcessinstid()%></em></li>
				<li>工作流:<em>异动调动申请</em></li>
				<li>申请人工号:<em><%=info.getUserid()%></em></li>
				<li>申请人姓名:<em><%=info.getName() %></em></li>
				<li>申请类别:<em><%=info.getApplytype()%></em></li>
				<li>职位等级:<em><%=info.getJoblevel()%></em></li>
				<%if("公司调动".equals(info.getApplytype())) {%>
				<li>部门性质:<em><%=info.getDeptnature()%></em></li>
					<%if("员工进职能部门".equals(info.getDeptnature())){%>
				<li>是否参加储备经理培训:<em><%=info.getIsmanagertrain()%></em></li>
					<%} %>
				<%} %>
				<li>所属人事部:<em><%=info.getAreapersonneldept()%></em></li>
				<li>变动前部门:<em><%=info.getBeforedept()%></em></li>
				<li>变动前职位:<em><%=info.getBeforeposition()%></em></li>
				<li>变动后部门:<em><%=info.getAfterdept()%></em></li>
				<li>变动后职位:<em><%=info.getAfterposition()%></em></li>
				<li>增补员工作流号:<em><%=info.getAddpersonno()%></em></li>
				<%if("个人异动".equals(info.getApplytype())) {%>
				<li>回原籍工作流号:<em><%=info.getBackoriginno()%></em></li>
				<%}%>
				<li>是否引起住所变更:<em><%=info.getIsvaraddress()%></em></li>
				<li>是否使用公司手机卡:<em><%=info.getIsusephone()%></em></li>
				<%if("是".equals(info.getIsusephone())) {%>
				<li>手机号码:<em><%=info.getPhonenumber()%></em></li>
				<li>是否交接手机卡:<em><%=info.getIstelhand()%></em></li>
					<%if("是".equals(info.getIstelhand())) {%>
				<li>交接手机卡后使用人:<em><%=info.getAfteruser()%></em></li>
				<li>交接前手机话费:<em><%=info.getMoney()%></em></li>
					<%}%>
				<%}%>
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