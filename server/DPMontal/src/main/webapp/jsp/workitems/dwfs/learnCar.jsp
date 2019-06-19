<%@page import="com.deppon.wfs.workflow.domain.LearnCarBean"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page	import="com.deppon.montal.module.workitems.webservice.client.DWFSWorkItemServiceClient"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
<%@include file="/common_win8.jsp"%>
<style>
tr.details,tr.qytr {
	display: none;
}
</style>
</head>
<body onload="autoShowApproval()">
	<%
	LearnCarBean info = (LearnCarBean)request.getAttribute("entity");
%>
	<div id="list">
		<%@include file="../wf_head_win8.jsp"%>
		<input type="hidden" id="busino" value="<%=info.getBusino()%>">
		<input type="hidden" id="approval_url"
			value="<%=F_Constants.NORMOL_APPROVAL_URL%>">
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
						<td>学车报名申请</td>
					</tr>
					<tr>
						<th>申请人姓名:</th>
						<td><%=info.getApplyPersonName()%></td>
					</tr>
					<tr>
						<th>当地办公室:</th>
						<td><%=info.getLocalOfficeName()%></td>
					</tr>
					<tr>
						<th>享受福利原因:</th>
						<td><%=info.getWelfareReason()%></td>
					</tr>
					<%if("1".equals(info.getWelfareReasonCode())) { %>
						<tr>
							<th>转正工作流号:</th>
							<td><%=info.getFormalWorkflowId()%></td>
						</tr>
					<%}%>

					<%if("3".equals(info.getWelfareReasonCode())) {%>
						<tr>
							<th>储干区域:</th>
							<td><%=info.getCadreArea()%></td>
						</tr>
						<tr>
							<th>第几届储干:</th>
							<td><%=info.getCadreTime()%></td>
						</tr>
						<tr>
							<th>储干名次:</th>
							<td><%=info.getCadreRank()%></td>
						</tr>
					<%} %>
					<tr>
						<th>报名日期:</th>
						<td><%=FormatUtil.formatDate(info.getEnrollDate())%></td>
					</tr>
					<tr>
						<th>学车费用总金额:</th>
						<td><%=info.getFeeAmount()%></td>
					</tr>
					<tr>
						<th>驾校名称:</th>
						<td><%=info.getDschoolName()%></td>
					</tr>
					<tr>
						<th>驾校电话:</th>
						<td><%=info.getDschoolTel()%></td>
					</tr>
					<tr>
						<th>申请事由:</th>
						<td><%=info.getReason()%></td>
					</tr>
					<%@include file="approve_process.jsp"%>
				</table>
			</div>
		</div>
		<%@include file="workflow_approve_button.jsp"%>
	</div>
</body>
<script type="text/javascript">
	$(function(){
		$("#rollback_but").hide();
	});
</script>
</html>