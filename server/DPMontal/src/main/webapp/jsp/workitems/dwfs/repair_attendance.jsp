<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.wfs.workflow.domain.RepairAttendanceDetails"%>
<%@page import="com.deppon.wfs.workflow.domain.RepairAttendance"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_win8.jsp" %>
	<style>
	tr.details, tr.qytr { display:none;}
	</style>
</head>
<body onload="autoShowApproval()">
<%
	RepairAttendance info = (RepairAttendance)request.getAttribute("entity");
%>
<div id="list">
	<%@include file="../wf_head_win8.jsp" %>
	<input type="hidden" id="busino" value="<%=info.getBusino()%>">
	<input type="hidden" id="approval_url" value="<%=F_Constants.NORMOL_APPROVAL_URL%>">
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
	    		<tr>
					   <th>工作流号:</th>
					   <td id="workid"><%=request.getAttribute("processinstid")%></td>
					</tr>
					<tr>
					   <th>工&nbsp;&nbsp;作&nbsp;&nbsp;流:</th>
					   <td>补考勤申请</td>
					</tr>
			   <tr><th>申请人:</th><td><%=info.getApplyPersonName()%></td></tr>
			   <tr><th>所属区域:</th><td><%=info.getAreaName()%></td></tr>
				<tr>
					<th colspan="2" class="yellow">详细信息</th>
				</tr>
				<%
					for(int i=0;i<info.getRepairDetails().size();i++){
						RepairAttendanceDetails entry = info.getRepairDetails().get(i);
				%>
				<tr class="topLine">
				   <th>补考勤人员:</th>
				   <td><%=entry.getAttendancepersonname()%></td>
				</tr>
				<tr>
				   <th>所在的部门:</th>
				   <td><%=entry.getDepartmentName()%></td>
				</tr>
				<tr>
				   <th>未打卡日期:</th>
				   <td><%=FormatUtil.formatDate(entry.getRepairTime())%></td>
				</tr>
				<tr>
				   <th>补考勤类型:</th>
				   <td><%=entry.getAttendanceType()%></td>
				</tr>
				<tr>
				   <th>补考勤事由:</th>
				   <td><%=entry.getAttendanceReason()%></td>
				</tr>
				<tr>
				   <th>证明人姓名:</th>
				   <td><%=entry.getConfirmName()%></td>
				</tr>
				<%
					}
				%>
			    <tr class="topLine">
				  <th>申请事由:</th>
				  <td style="word-wrap:break-word;word-break:break-all"><%=info.getApplyReason()==null?"":info.getApplyReason() %></td>
			    </tr>
					   
				<%@include file="approve_process.jsp" %>					   					   
	    	</table>
	    </div>
	</div>
	 <%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>