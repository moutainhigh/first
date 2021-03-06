<%@page import="com.deppon.wfs.workflow.domain.ProjectContractApplyBean"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page	import="com.deppon.montal.module.workitems.webservice.client.DWFSWorkItemServiceClient"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page language="java" pageEncoding="UTF-8"%>
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
	ProjectContractApplyBean info = (ProjectContractApplyBean)request.getAttribute("entity");
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
						<td>项目类合同申请</td>
					</tr>
					<tr>
						<th>申请人：</th>
						<td><%= info.getApplyPersonName()%></td>
					</tr>
					<tr>
						<th>申请人工号：</th>
						<td><%= info.getApplyPersonId()%></td>
					</tr>
					<tr>
						<th>是否PMO跟踪项目：</th>
						<td><%=info.getIsPmcProject()%></td>
					</tr>
					<tr>
						<th>经办部门：</th>
						<td><%=info.getChargeIndDept()%></td>
					</tr>
					<tr>
						<th>是否框架合同：</th>
						<td><%=info.getIsFrameContract()%></td>
					</tr>
					<tr>
						<th>所属事业部：</th>
						<td><%=info.getSubOrdInateDept()%></td>
					</tr>
					<tr>
						<th>所属财务部：</th>
						<td><%=info.getFinanceDept()%></td>
					</tr>
					<tr>
						<th>签订类型：</th>
						<td><%=info.getSignType()%></td>
					</tr>
					<tr>
						<th>合同类型：</th>
						<td><%=info.getContractType()%></td>
					</tr>
					<% if(!"新签".equals(info.getSignType())) {%>
						<tr>
							<th>原合同编号：</th>
							<td><%=info.getOriginalContractNo()%></td>
						</tr>
					<%} %>
					<tr>
						<th>合同名称：</th>
						<td><%=info.getContractName()%></td>
					</tr>
					<tr>
						<th>合同金额：</th>
						<td><%=info.getContractAmount()%></td>
					</tr>
					<tr>
						<th>签约对方单位 ：</th>
						<td><%=info.getSigningEachOtherUnit()%></td>
					</tr>
					<tr>
						<th>签约我方单位 ：</th>
						<td><%=info.getSigningOurUnit()%></td>
					</tr>
					<tr>
						<th>合同开始日期 ：</th>
						<td><%=FormatUtil.formatDate(info.getContractStarttime())%></td>
					</tr>
					<tr>
						<th>合同结束日期 ：</th>
						<td><%=FormatUtil.formatDate(info.getContractEndtime())%></td>
					</tr>
					<tr>
						<th>优先盖章方 ：</th>
						<td><%=info.getSeal()%></td>
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
</html>