<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.wdgh.inteface.domain.QueryWorkflowInfoResponse"%>
<%@page import="com.deppon.wdgh.inteface.domain.DeptRevoke"%>
<%@page import="com.deppon.wdgh.inteface.domain.ModifyDeptDetail"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<meta http-equiv = "Content-Type" content = "application/xhtml+xml; charset=UTF-8" />
	<%@include file="/common_win8.jsp" %>
	<style type="text/css">
	 li{word-wrap: break-word;}
	</style>
</head>
<%
QueryWorkflowInfoResponse infoNew = (QueryWorkflowInfoResponse)request.getAttribute("wdghBusiRsp");
DeptRevoke base = infoNew.getDeptRevoke();
SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
%>
<body>
<div id="list">
	<%@include file="../wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
				<tr><th>工作流:</th><td>网点撤销工作流</td></tr>
				<tr><th>申请人姓名:</th><td><%= base.getCreateUserName()%></td></tr>
				<tr><th>申请人职位:</th><td><%=base.getCreatePostion()%></td></tr>
				<tr><th>申请人部门:</th><td><%=base.getCreateOrgName()%></td></tr>
				<tr><th>申请撤销部门名称:</th><td><%=base.getReversedDeptName()%></td></tr>
				<tr><th>申请撤销日期:</th><td><%=FormatUtil.formatDate(base.getReversedTime(),"yyyy-MM-dd")%></td></tr>
				<tr><th>所属事业部:</th><td><%=base.getBusinessDivsionCode()%></td></tr>
				<tr><th>所属人事部:</th><td><%= base.getPersonnelDepartmentCode()%></td></tr>
				<tr><th>所属财务部:</th><td><%=base.getFinanceDeptCode()%></td></tr>
				<tr><th>固定资产认领办公室:</th><td><%=base.getPermanentAssetsOffice()%></td></tr>
				<tr><th>营业执照名称:</th><td><%=base.getBusinessLicenseName()%></td></tr>
				<tr><th>营业执照编号:</th><td><%= base.getBusinessLicenseNo()%></td></tr>
				<tr><th>税务登记编号:</th><td><%=base.getTaxregNo()%></td></tr>
				<tr><th>税务登记证颁发日期:</th><td><%=FormatUtil.formatDate(base.getTaxregIssueDate(),"yyyy-MM-dd")%></td></tr>
				<tr><th>合同开始时间:</th><td><%=FormatUtil.formatDate(base.getContractStartTime(),"yyyy-MM-dd")%></td></tr>
				<tr><th>合同结束时间:</th><td><%=FormatUtil.formatDate(base.getContractEndTime(),"yyyy-MM-dd")%></td></tr>
				<tr><th>押金:</th><td><%=FormatUtil.formatDoubleStr(base.getStallPledgeAmount())%></td></tr>
				<tr><th>转让费:</th><td><%=FormatUtil.formatDoubleStr(base.getTransferFee())%></td></tr>
				<tr><th>最近一次交租日期:</th><td><%=FormatUtil.formatDate(base.getLatestRentTime(),"yyyy-MM-dd")%></td></tr>
				<tr><th>最近一次交租费用:</th><td><%=base.getLatestRentAmount()%></td></tr>
				<tr><th>未到期费用未收回金额:</th><td><%=base.getOutstandingFees()%></td></tr>
				<tr><th>自提派送范围新增/修改/申请工作流号:</th><td><%=base.getWorkflowNo()%></td></tr>
				<tr><th>是否独立核算:</th><td><%="Y".equals(base.getIsIndependentAccout())?"是":"否"%></td></tr>
				<tr><th>申请撤销原因:</th><td><%=base.getReason()%></td></tr>
				<tr><th>申请事由:</th><td><%=base.getReason()%></td></tr>
		  </table>
		  <%@include file="approve_process.jsp" %>
		</div>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
<script type="text/javascript">
	$(document).ready(function(){
		document.getElementById("disagree_but").style.display = "none";
	});
</script>
</body>
</html>