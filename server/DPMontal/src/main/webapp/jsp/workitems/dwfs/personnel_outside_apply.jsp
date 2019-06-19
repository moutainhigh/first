<%@page import="com.deppon.wfs.workflow.domain.StaffOutsideBean"%>
<%@page import="com.deppon.montal.conf.domain.DictEntry"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_win8.jsp" %>

</head>
<%
StaffOutsideBean info = (StaffOutsideBean)request.getAttribute("entity");
%>
<body>
<div id="list">
	<%@include file="../wf_head_win8.jsp" %>
	<input type="hidden" id="busino" value="<%=info.getBusino()%>">
	<input type="hidden" id="approval_url" value="<%=F_Constants.NORMOL_APPROVAL_URL%>">
	
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
				<tr class="yellow"><th>工作流:</th><td>人员外请申请</td></tr>
				<tr><th>工作流号:</th><td id="workid"><%=info.getProcessinstid() %></td></tr>
				<tr><th>申请人:</th><td><%=info.getApplyPersonName()%></td></tr>
				<tr><th>申请人工号:</th><td><%=info.getApplyPersonId()%></td></tr>
				<tr><th>职位:</th><td><%=info.getPosition()%></td></tr>
				<tr><th>所属部门:</th><td><%=info.getDept()%></td></tr>
				<tr><th>所属区域:</th><td><%=info.getArea()%></td></tr>
				<tr><th>外请开始时间:</th><td><%=info.getStartTimeStr()%></td></tr>
				<tr><th>外请结束时间:</th><td><%=info.getEndTimeStr()%></td></tr>
				<tr><th>外请类型:</th><td><%=info.getType()%></td></tr>
				<tr><th>外请天数:</th><td><%=info.getDays()%></td></tr>
				<tr><th>外请人数:</th><td><%=info.getNumberOfPeople()%></td></tr>
				<%if("2".equals(info.getTypeCode())){ %>
				<tr><th>人均费用:</th><td><%=info.getPerCost()%></td></tr>
				<tr><th>预算总费用:</th><td><%=info.getTotalCost()%></td></tr>
				<%} %>
				<tr><th>计费方式:</th><td><%=info.getBillingMethod()%></td></tr>
				<tr><th>工作流人员缺口:</th><td><%=info.getPersonnelGap()%></td></tr>
				<%if(info.getWorkflowNo() != null){ %>
				<tr><th>增补员工作流号:</th><td><%=info.getWorkflowNo()%></td></tr>
				<%} %>
				<tr><th>申请事由:</th><td><%=info.getApplyReason()%></td></tr>
		 </table>
		<%@include file="approve_process.jsp" %>
    	</div>
	<%@include file="workflow_approve_button.jsp" %>
	</div>
</div>
</body>
</html>