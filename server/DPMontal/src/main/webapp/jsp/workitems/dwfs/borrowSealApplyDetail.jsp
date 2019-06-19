<%@page import="com.deppon.wfs.workflow.domain.BorrowSealApplyBean"%>
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
	BorrowSealApplyBean info = (BorrowSealApplyBean)request.getAttribute("entity");
%>
	<div id="list">
		<%@include file="../wf_head_win8.jsp"%>
		<input type="hidden" id="busino" value="<%=info.getBusino()%>">
		<input type="hidden" id="approval_url"	value="<%=F_Constants.NORMOL_APPROVAL_URL%>">
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
						<td>借章申请</td>
					</tr>
					<tr>
						<th>姓名:</th>
						<td><%= info.getApplyPersonName()%></td>
					</tr>
					<tr>
						<th>工号:</th>
						<td><%=info.getApplyPersonId()%></td>
					</tr>
					<tr>
						<th>部门:</th>
						<td><%=info.getDept()==null ? "":info.getDept()%></td>
					</tr>
					<tr>
						<th>所属事业部:</th>
						<td><%=info.getArea()==null ? "":info.getArea()%></td>
					</tr>
					<tr>
						<th>印章名称:</th>
						<td><%=info.getSealName()==null ? "":info.getSealName()%></td>
					</tr>
					<tr>
						<th>印章类型:</th>
						<td><%=info.getSealType()==null ? "":info.getSealType()%></td>
					</tr>
					<tr>
						<th>印章序号:</th>
						<td><%=info.getSealSequenceCode()==null ? "":info.getSealSequenceCode()%></td>
					</tr>
					<tr>
						<th>借阅份数:</th>
						<td><%=info.getSealBrrowCounts()==null ? "":info.getSealBrrowCounts()%></td>
					</tr>
					<tr>
						<th>章全宗号:</th>
						<td><%=info.getSealGeneralCode()==null ? "":info.getSealGeneralCode()%></td>
					</tr>
					<tr>
						<th>印章档号:</th>
						<td><%=info.getSealArchivalCode()==null ? "":info.getSealArchivalCode()%></td>
					</tr>
					<tr>
						<th>印章所属:</th>
						<td><%=info.getSealDept()==null ? "":info.getSealDept()%></td>
					</tr>
					<tr>
						<th>印章财务部:</th>
						<td><%=info.getSealBrief()==null ? "":info.getSealBrief()%></td>
					</tr>
					<tr>
						<th>保管部门:</th>
						<td><%=info.getSealAsaveDept()==null ? "":info.getSealAsaveDept()%></td>
					</tr>
					<tr>
						<th>印章编号:</th>
						<td><%=info.getSealCode()==null ? "":info.getSealCode()%></td>
					</tr>
					<tr>
						<th>借阅天数:</th>
						<td><%=info.getBorrowDays()==null ? "":info.getBorrowDays()%></td>
					</tr>
					<tr>
						<th>申请日期:</th>
						<td><%=info.getStartDate()==null ? "":info.getStartDate()%></td>
					</tr>
					<tr>
						<th>带章去处:</th>
						<td><%=info.getSealTaketo()==null ? "":info.getSealTaketo()%></td>
					</tr>
					<tr>
						<th>归还时间:</th>
						<td><%=info.getReturnDate()==null ? "":info.getReturnDate()%></td>
					</tr>
					<tr>
						<th>申请事由:</th>
						<td><%=info.getApplyReason()==null ? "":info.getApplyReason()%></td>
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