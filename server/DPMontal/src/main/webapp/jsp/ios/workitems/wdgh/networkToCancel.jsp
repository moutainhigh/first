<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.wdgh.inteface.domain.QueryWorkflowInfoResponse"%>
<%@page import="com.deppon.wdgh.inteface.domain.DeptRevoke"%>
<%@page import="com.deppon.wdgh.inteface.domain.ModifyDeptDetail"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<meta http-equiv = "Content-Type" content = "application/xhtml+xml; charset=UTF-8" />
	<%@include file="/common_ios.jsp" %>
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
	<%@include file="/jsp/ios/work_items_head.jsp" %>
    <!--div2 S-->
    <div id="div2">
    	<div class="ulBox2">
    		<ul>
				<li>工作流:<em>网点撤销工作流</em></li>
				<li>申请人姓名:<em><%= base.getCreateUserName()%></em></li>
				<li>申请人职位:<em><%=base.getCreatePostion()%></em></li>
				<li>申请人部门:<em><%=base.getCreateOrgName()%></em></li>
				<li>申请撤销部门名称:<em><%=base.getReversedDeptName()%></em></li>
				<li>申请撤销日期:<em><%=FormatUtil.formatDate(base.getReversedTime(),"yyyy-MM-dd")%></em></li>
				<li>所属事业部:<em><%=base.getBusinessDivsionCode()%></em></li>
				<li>所属人事部:<em><%= base.getPersonnelDepartmentCode()%></em></li>
				<li>所属财务部:<em><%=base.getFinanceDeptCode()%></em></li>
				<li>固定资产认领办公室:<em><%=base.getPermanentAssetsOffice()%></em></li>
				<li>营业执照名称:<em><%=base.getBusinessLicenseName()%></em></li>
				<li>营业执照编号:<em><%= base.getBusinessLicenseNo()%></em></li>
				<li>税务登记编号:<em><%=base.getTaxregNo()%></em></li>
				<li>税务登记证颁发日期:<em><%=FormatUtil.formatDate(base.getTaxregIssueDate(),"yyyy-MM-dd")%></em></li>
				<li>合同开始时间:<em><%=FormatUtil.formatDate(base.getContractStartTime(),"yyyy-MM-dd")%></em></li>
				<li>合同结束时间:<em><%=FormatUtil.formatDate(base.getContractEndTime(),"yyyy-MM-dd")%></em></li>
				<li>押金:<em><%=FormatUtil.formatDoubleStr(base.getStallPledgeAmount())%></em></li>
				<li>转让费:<em><%=FormatUtil.formatDoubleStr(base.getTransferFee())%></em></li>
				<li>最近一次交租日期:<em><%=FormatUtil.formatDate(base.getLatestRentTime(),"yyyy-MM-dd")%></em></li>
				<li>最近一次交租费用:<em><%=base.getLatestRentAmount()%></em></li>
				<li>未到期费用未收回金额:<em><%=base.getOutstandingFees()%></em></li>
				<li>自提派送范围新增/修改/申请工作流号:<em><%=base.getWorkflowNo()%></em></li>
				<li>是否独立核算:<em><%="Y".equals(base.getIsIndependentAccout())?"是":"否"%></em></li>
				<li>申请撤销原因:<em><%=base.getReason()%></em></li>
		  </ul>
		</div>
		<%@include file="approve_process.jsp" %>
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