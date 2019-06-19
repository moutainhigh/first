<%@page import="com.deppon.wfs.workflow.domain.RealContractBorrowBean"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page	import="com.deppon.montal.module.workitems.webservice.client.DWFSWorkItemServiceClient"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title><%=InitDataServlet.getValue("page_title")%>-待办事项</title>
<%@include file="/common_win8.jsp"%>
<style>
tr.details,tr.qytr {
	display: none;
}
</style>
</head>
<body onload="autoShowApproval()">
	<%
		RealContractBorrowBean info = (RealContractBorrowBean) request
				.getAttribute("entity");
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
						<td>实体合同借阅申请</td>
					</tr>
					<tr>
						<th>姓名:</th>
						<td><%=info.getApplyPersonName()%></td>
					</tr>
					<tr>
						<th>工号:</th>
						<td><%=info.getApplyPersonId()%></td>
					</tr>
					<tr>
						<th>所属事业部:</th>
						<td><%=info.getArea()==null ? "":info.getArea()%></td>
					</tr>
					<tr>
						<th>合同编号:</th>
						<td><%=info.getContractNum()==null ? "":info.getContractNum()%></td>
					</tr>
					<tr>
						<th>客户名称:</th>
						<td><%=info.getCustomerName()==null ? "":info.getCustomerName()%></td>
					</tr>
					<tr>
						<th>签订部门:</th>
						<td><%=info.getSignDepartment()==null ? "":info.getSignDepartment()%></td>
					</tr>
					<tr>
						<th>合同类别:</th>
						<td><%=info.getContractType()==null ? "":info.getContractType()%></td>
					</tr>
					<tr>
						<th>合同密级:</th>
						<td><%=info.getContractDense()==null ? "":info.getContractDense()%></td>
					</tr>
					<tr>
						<th>借阅天数:</th>
						<td><%=info.getBorrowDays()==null ? "":info.getBorrowDays()%></td>
					</tr>
					<tr>
						<th>开始时间:</th>
						<td><%=info.getStartDate()==null ? "":info.getStartDate()%></td>
					</tr>
					<tr>
						<th>结束时间:</th>
						<td><%=info.getEndDate()==null ? "":info.getEndDate()%></td>
					</tr>
					<tr>
						<th>申请事由:</th>
						<td><%=info.getApplyReason() == null ? "" : info.getApplyReason()%></td>
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
	//回退按钮隐藏
	$("#rollback_but").hide();
});
</script>
</html>