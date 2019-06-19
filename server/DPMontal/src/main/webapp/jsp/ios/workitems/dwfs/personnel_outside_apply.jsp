<%@page import="com.deppon.wfs.workflow.domain.StaffOutsideBean"%>
<%@page import="com.deppon.montal.conf.domain.DictEntry"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@ page language="java"  pageEncoding="UTF-8"%> <!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_ios.jsp" %>
</head>
<%
StaffOutsideBean info = (StaffOutsideBean)request.getAttribute("entity");
%>
<body>
<div id="list">
	<%@include file="/jsp/ios/work_items_head.jsp" %>
	<input type="hidden" id="busino" value="<%=info.getBusino()%>">
	<input type="hidden" id="approval_url" value="<%=F_Constants.NORMOL_APPROVAL_URL%>">
	
	<div id="div2">
   	<div class="ulBox2">
			<ul>
				<li class="first">工作流:<em>人员外请申请</em></li>
				<li>申请人:<em><%=info.getApplyPersonName()%></em></li>
				<li>工作流号:<em><%=info.getProcessinstid() %></em></li>
				<li>申请人:<em><%=info.getApplyPersonName()%></em></li>
				<li>申请人工号:<em><%=info.getApplyPersonId()%></em></li>
				<li>职位:<em><%=info.getPosition()%></em></li>
				<li>所属部门:<em><%=info.getDept()%></em></li>
				<li>所属区域:<em><%=info.getArea()%></em></li>
				<li>外请开始时间:<em><%=info.getStartTimeStr()%></em></li>
				<li>外请结束时间:<em><%=info.getEndTimeStr()%></em></li>
				<li>外请类型:<em><%=info.getType()%></em></li>
				<li>外请天数:<em><%=info.getDays()%></em></li>
				<li>外请人数:<em><%=info.getNumberOfPeople()%></em></li>
				<%if("2".equals(info.getTypeCode())){ %>
				<li>人均费用:<em><%=info.getPerCost()%></em></li>
				<li>预算总费用:<em><%=info.getTotalCost()%></em></li>
				<%} %>
				<li>计费方式:<em><%=info.getBillingMethod()%></em></li>
				<li>工作流人员缺口:<em><%=info.getPersonnelGap()%></em></li>
				<%if(info.getWorkflowNo() != null){ %>
				<li>增补员工作流号:<em><%=info.getWorkflowNo()%></em></li>
				<%} %>
				<li>申请事由:<em><%=info.getApplyReason()%></em></li>
		 </ul>
    </div>
    	<%@include file="approve_process.jsp" %>
		<%@include file="workflow_approve_button.jsp" %>
	</div>
</div>
</body>
</html>