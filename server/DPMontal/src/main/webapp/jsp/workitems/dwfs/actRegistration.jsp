<%@page import="com.deppon.wfs.workflow.domain.ActRegistrationBean"%>
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
	ActRegistrationBean info = (ActRegistrationBean)request.getAttribute("entity");
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
						<td>活动报名申请</td>
					</tr>
					<tr>
						<th>申请人：</th>
						<td><%=info.getApplyPersonName()%></td>
					</tr>
					<tr>
						<th>申请人工号：</th>
						<td><%=info.getApplyPersonId()%></td>
					</tr>
					<tr>
						<th>所属部门：</th>
						<td><%=info.getDeptName()%></td>
					</tr>
					<tr>
						<th>所属事业部：</th>
						<td><%=info.getDivisionCode()%></td>
					</tr>
					<tr>
						<th>入职时间：</th>
						<td><%=FormatUtil.formatDate(info.getJoinDate())%></td>
					</tr>
					<tr>
						<th>申请人职位：</th>
						<td><%=info.getPosition()%></td>
					</tr>
					<tr>
						<th>申请人电话：</th>
						<td><%=info.getTelephone()%></td>
					</tr>
					<tr>
						<th>申请项目：</th>
						<td><%=info.getApplyProject()%></td>
					</tr>
					<%if("集体婚礼".equals(info.getApplyProject())) { %>
						<tr>
							<th>结婚证领取日期：</th>
							<td><%=FormatUtil.formatDate(info.getMarrylicenseDate())%></td>
						</tr>
						<tr>
							<th>参加婚礼地点：</th>
							<td><%=info.getWeddingAddress()%></td>
						</tr>
						<tr>
							<th>身份证号：</th>
							<td><%=info.getCardno()%></td>
						</tr>
						<tr>
							<th>配偶是否德邦员工：</th>
							<td><%=info.getIsInternalStaff() %></td>
						</tr>
					<%} %>
					<%if("集体婚礼".equals(info.getApplyProject())) { %>
						<%if("是".equals(info.getIsInternalStaff())) { %>
							<tr>
								<th>配偶姓名：</th>
								<td><%=info.getSpouseName()%></td>
							</tr>
							<tr>
								<th>配偶工号：</th>
								<td><%=info.getSpouseCode()%></td>
							</tr>
							<tr>
								<th>配偶部门：</th>
								<td><%=info.getSpouseDept()%></td>
							</tr>
							<tr>
								<th>所属事业部：</th>
								<td><%=info.getSpouseDivisionCode()%></td>
							</tr>
							<tr>
								<th>入职时间：</th>
								<td><%=FormatUtil.formatDate(info.getSpouseJoinDate())%></td>
							</tr>
							<tr>
								<th>配偶职位：</th>
								<td><%=info.getSpousePosition()%></td>
							</tr>
						<%} %>
					<%} %>
					<%if("集体婚礼".equals(info.getApplyProject())) { %>
						<%if("否".equals(info.getIsInternalStaff())) { %>
							<tr>
								<th>配偶姓名：</th>
								<td><%=info.getSpouseName()%></td>
							</tr>
							<tr>
								<th>工作单位：</th>
								<td><%=info.getWorkUnit()%></td>
							</tr>
						<%} %>
					<%} %>
					<%if("集体婚礼".equals(info.getApplyProject())) { %>
						<tr>
							<th>配偶电话：</th>
							<td><%=info.getSpouseTel()%></td>
						</tr>
						<tr>
							<th>配偶身份证号：</th>
							<td><%=info.getSpouseId()%></td>
						</tr>
					<%} %>
					<%if("中秋月饼".equals(info.getApplyProject())) { %>
						<tr>
							<th>家属姓名：</th>
							<td><%=info.getRelationName()%></td>
						</tr>
						<tr>
							<th>与家属关系：</th>
							<td><%=info.getRelationShip()%></td>
						</tr>
						<tr>
							<th>家属电话：</th>
							<td><%=info.getRelationTel() == null ? "" : info.getRelationTel()%></td>
						</tr>
						<tr>
							<th>邮编：</th>
							<td><%=info.getZipCode()%></td>
						</tr>
						<tr>
							<th>固定电话：</th>
							<td><%=info.getFixedLine() == null ? "" : info.getFixedLine()%></td>
						</tr>
						<tr>
							<th>省份：</th>
							<td><%=info.getProvince()%></td>
						</tr>
						<tr>
							<th>城市：</th>
							<td><%=info.getCity()%></td>
						</tr>
						<tr>
							<th>区/县：</th>
							<td><%=info.getDistrictCounty()%></td>
						</tr>
						<tr>
							<th>街道：</th>
							<td><%=info.getStreet()%></td>
						</tr>
					<%} %>
					<tr>
						<th>申请事由:</th>
						<td><%=info.getApplyReason()%></td>
					</tr>
					<%@include file="approve_process.jsp"%>
				</table>
			</div>
		</div>
		<%@include file="workflow_approve_button.jsp"%>
	</div>
</body>
</html>