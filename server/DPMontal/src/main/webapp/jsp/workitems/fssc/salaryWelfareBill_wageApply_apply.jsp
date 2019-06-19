<%@page import="java.util.List"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.model.OaRewardpunishmentInfo"%>
<%@page import="com.deppon.montal.model.OaDeptexpenses"%>
<%@page import="com.deppon.montal.model.OaAccidentdescriptionInfo"%>
<%@page import="com.deppon.montal.model.OaNomalClaim"%>
<%@page import="com.deppon.montal.conf.F_Constants"%>
<%@page import="com.deppon.montal.conf.Constants"%>
<%@page import="com.deppon.fssc.module.remote.mobile.service.MobileFsscEntity"%>
<%@page import="com.deppon.fssc.module.remote.mobile.shared.ClaimFsscBase"%>
<%@page import="com.deppon.fssc.module.remote.mobile.shared.ClaimLineFssc"%>
<%@page import="com.deppon.fssc.module.remote.mobile.shared.ApproveFssc"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_win8.jsp" %>
</head>

<body>
 <%
 MobileFsscEntity info = (MobileFsscEntity)request.getAttribute("mobileFsscEntity");
 ClaimFsscBase base = info.getMobileBaseEntity();
 ClaimLineFssc[]  mobileLineList = info.getMobileLineArray();
 ApproveFssc[] mobileApprovalInfo = info.getMobileApprovalArray();
 %>
<div id="list">
	<%@include file="../wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
	    		<tr><th colspan="2" class="yellow">基本信息</th></tr>
	    		<tr><th>单据编号:</th><td id="workid"><%=base.getClaimNo() %></td></tr>
				<tr><th>申请人公司:</th><td><%=base.getApplyCompName()%></td></tr>
				<tr><th>申请日期:</th><td><%=base.getApplyDateStr()%></td></tr>
				<tr><th >申请人:</th><td><%= base.getApplyEmpName()%></td></tr>
				<tr><th >申请人部门:</th><td><%=base.getApplyDeptName()%></td></tr>
			   	
			    <tr><th colspan="2" class="yellow">报账信息</th></tr>
			    <tr><th >工作流名称:</th><td>薪酬福利报账单—工资申请</td></tr>	
				<tr><th >发票抬头:</th><td><%=base.getInvoiceTitle()%></td></tr>
				<tr><th >所属财务部:</th><td><%=base.getFinancialDept()%></td></tr>
				<tr><th >支付方式:</th><td><%=base.getPayType()%></td></tr>
			    <tr><th >币种:</th><td><%=base.getCurrency()%></td></tr>
				<tr><th >收款方:</th><td><%=base.getAccountName() == null ? "" : base.getAccountName()%></td></tr>
				<tr><th >最迟汇款日期:</th><td><%=base.getLatestRemitDateStr()%></td></tr>
				<tr><th >手机号码:</th><td><%=base.getContactInfo()==null?"":base.getContactInfo()%></td></tr>
				<tr><th>申请事由及说明:</th><td><%= base.getCostExplain() == null ? "" : base.getCostExplain()%></td></tr> 
				
				<tr class="yellow"><td colspan="2" >付款信息</td></tr>
			    <tr><th>报账金额:</th><td><%=FormatUtil.formatMoney(base.getApplyAmount())%></td></tr>
			    <tr><th>付款金额:</th><td><%=FormatUtil.formatMoney(base.getPayAmount())%></td></tr>
			    <tr><th>核销金额:</th><td><%=FormatUtil.formatMoney(base.getAlreadyWritedAmount())%></td></tr>
			    <tr class="changeByAccount"><th class="changeByAccount">核定金额:</th><td class="changeByAccount"><%=FormatUtil.formatMoney(base.getRatifyAmount())%></td></tr>
			    <tr><th>币种:</th><td><%=base.getCurrency()%></td></tr>
			    <tr><th>付款金额大写:</th><td id='amountCNY'></td></tr>
			    <tr><th>账户性质:</th><td><%=base.getAccountNature()%></td></tr>
			    <tr><th>银行账号:</th><td><%= base.getAccount()%></td></tr>
			    <tr><th>开户支行:</th><td><%=base.getSubbankName()%></td></tr>
			    
				<tr class="yellow"><td colspan="2" >其他信息-明细信息</td></tr>
				<%for(int i = 0; i < mobileLineList.length; i++ ) {%>
					<tr><th>序号:</th><td><%=i+1%></td></tr>
				   	<tr><th>费用类型:</th><td><%= mobileLineList[i].getScName()%></td></tr>
				   	<tr><th>员工工号:</th><td><%= mobileLineList[i].getEmpCode()== null ? "无" : mobileLineList[i].getEmpCode()%></td></tr>
				   	<tr><th>员工姓名:</th><td><%= mobileLineList[i].getEmpName()== null ? "无" : mobileLineList[i].getEmpName()%></td></tr>
				   	<tr><th>费用期间:</th><td><%= mobileLineList[i].getCostPeriod()%></td></tr>
				   	<tr><th>费用承担部门:</th><td><%= mobileLineList[i].getCostCenterName()%></td></tr>
				    <tr><th>社保主体:</th><td><%= mobileLineList[i].getSecurityUnits()%></td></tr>
				    <tr class="changeByAccount2"><th class="changeByAccount2">实发小计:</th ><td class="changeByAccount2"><%= mobileLineList[i].getActualAmount() == null ? "" : mobileLineList[i].getActualAmount()%></td></tr>
				    <tr class="changeByAccount"><th class="changeByAccount">核定金额:</th><td class="changeByAccount"><%= mobileLineList[i].getRetifyAmount() == null ? "" : mobileLineList[i].getRetifyAmount()%></td></tr>
			   <%} %>
			   
		  </table>
		  <%@include file="approve_process.jsp" %>
		</div>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
<script type="text/javascript">
$(function(){
	//将付款金额转成大写
	$("#amountCNY").html(numToCny(<%=base.getPayAmount()%>));
	var accountXXID = $("#AccountXXID").val();
	if (accountXXID=='AccountXX') {
		$(".changeByAccount").show();
		$(".changeByAccount2").hide();
	}else {
		$(".changeByAccount2").show();
		$(".changeByAccount").hide();
	}

});
</script>
</body>
</html>