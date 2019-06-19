<%@page import="com.deppon.montal.module.crm.damin.QueryWorkflowInfoResponse"%>
<%@page import="com.deppon.montal.module.crm.damin.RecompenseInfo"%>
<%@page import="com.deppon.montal.module.crm.damin.AwardItem"%>
<%@page import="com.deppon.montal.module.crm.damin.DeptCharge"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.module.workitems.webservice.client.DWFSWorkItemServiceClient"%>
<%@page import="com.deppon.wfs.workflow.domain.WarrantEntityBean"%>
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
QueryWorkflowInfoResponse responseEntity = (QueryWorkflowInfoResponse)request.getAttribute("queryWorkflowInfoResponse");
RecompenseInfo  info = responseEntity.getRecompenseInfo();
List<AwardItem> awardItems = info.getAwardItems();
List<DeptCharge> deptCharges = info.getDeptCharges();
%>
<div id="list">
	<%@include file="../wf_head_win8.jsp" %>
<%-- 	<input type="hidden" id="busino" value="<%=info.getWaybillNumber()%>"> --%>
<%-- 	<input type="hidden" id="approval_url" value="<%=F_Constants.NORMOL_APPROVAL_URL%>"> --%>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
				<tr>
				   <th>工&nbsp;&nbsp;作&nbsp;&nbsp;流:</th>
				   <td>常规理赔申请</td>
				</tr>
			   <tr><th>运单号:</th><td><%=info.getTransportOrErrorCode()%></td></tr>
			   <tr><th>运输类型:</th><td><%=info.getHaulType()%></td></tr>
			   <tr><th>始发站:</th><td><%=info.getStartingStation()%></td>
			   </tr><tr><th>报价人:</th><td><%=info.getInsuredUnits()%></td></tr>
			   <tr><th>联系电话:</th><td><%=info.getContactPhone()%></td></tr>
			   <tr><th>收货部门:</th><td><%=info.getReceivingDept()%></td></tr>
			   <tr><th>货物名称:</th><td><%=info.getGoodsName()%></td></tr>
			   <tr><th>件/重/体:</th><td><%=info.getGoodsAttribute()%></td></tr>
			   <tr><th>保险金额:</th><td><%=info.getInsuredAmount()%></td></tr>
			   <tr><th>目标部门:</th><td><%=info.getTargetDept()%></td></tr>
			   <tr><th>发货日期:</th><td><%=info.getSendingDateStr()%></td></tr>
			   <tr><th>出险日期:</th><td><%=info.getDangerDateStr()%></td></tr>
			   <tr><th>所属区域:</th><td><%=info.getArea()%></td></tr>
			   <tr><th>理赔类型:</th><td><%=info.getClaimsType()%></td></tr>
			   <tr><th>冲账方式:</th><td><%=info.getOffsetType()==null?"":info.getOffsetType()%></td></tr>
			   <tr><th>报案人:</th><td><%=info.getCaseReporterName()%></td></tr>
			   <tr><th>报案部门:</th><td><%=info.getReportDeptName()%></td></tr>
			   <tr><th>报案日期:</th><td><%=info.getReportDateStr()%></td></tr>
			   <tr><th>处理人:</th><td><%=info.getHandler()%></td></tr>
			   <tr><th>处理日期:</th><td><%=info.getHandleDateStr()%></td></tr>
			   <tr><th>索赔金额:</th><td><%=info.getClaimAmount()%></td></tr>
			   <tr><th>正常理赔金额:</th><td><%=info.getNormalAmount()%></td></tr>
			   <tr><th>实际理赔金额:</th><td><%=info.getActualClaimsAmount()%></td></tr>
			   <tr><th>入公司费用:</th><td><%=info.getToCompanyCost()%></td></tr>
			   <tr><th>入公司部门费用:
				   </th><td>
				   		<%
				   			DeptCharge obj1 = new DeptCharge();
						   	for(int i=0;i<deptCharges.size();i++){
						   		obj1 = deptCharges.get(i);
					   %>
					   <%= obj1.getDeptName() + "  " + obj1.getAmount() + "</br>"%>
					   <%	
					   }%>
				   </td>
			   </tr>
			   <tr><th>出险情况说明:</th><td><%=info.getIssueItemDesc()%></td></tr>
			   <tr><th>其他费用说明:</th><td><%=info.getOtherCost()%></td></tr>
			   <tr><th>奖罚说明:
			   		</th><td>
				   		<%
				   			AwardItem obj5 = new AwardItem();
						   	for(int i=0;i<awardItems.size();i++){
						   		obj5 = awardItems.get(i);
					   %>
					   <%= obj5.getDeptName() + "  " + obj5.getAwardType() + "</br>"%>
					   <%	
					   }%>
				   </td>
			   </tr>
			   <tr><th>责任部门:</th><td><%=info.getResponsibleDept()%></td></tr>
					   
			   <%@include file="approve_process.jsp" %>
	    	</table>
	    </div>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>