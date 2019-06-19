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
		<%@include file="/common_ios.jsp" %>
</head>

<body>
 <%
 MobileFsscEntity info = (MobileFsscEntity)request.getAttribute("mobileFsscEntity");
 ClaimFsscBase base = info.getMobileBaseEntity();
 ClaimLineFssc[]  mobileLineList = info.getMobileLineArray();
 ApproveFssc[] mobileApprovalInfo = info.getMobileApprovalArray();
 %>
<div id="list">
	<%@include file="/jsp/ios/work_items_head.jsp" %>
	<div id="div2">
    	<div class="ulBox2">
	    	<ul>
	    		<li  class="first"><em class="yellow">基本信息 </em></li>
	    		<li> 单据编号:  <em id="workid"><%=base.getClaimNo() %></em></li>
				<li>
				    工作流: 
				   <em>薪酬福利报账-社保（德邦）-付款</em>
				</li>
				   <li>
					   申请人: 
					  <em><%= base.getApplyEmpName()%></em>
				   </li>
					 <li>
					   申请人部门: 
					  <em><%=base.getApplyDeptName()%></em>
				   </li>
					 <li>
					   申请人公司: 
					  <em><%=base.getApplyCompName()%></em>
				   </li>
					 <li>
					   申请时间: 
					  <em><%=base.getApplyDateStr()%></em>
				   </li>
				   <li>
						<em  class="yellow">报账信息 </em>
				   </li>	
				  
					<li>
						 发票抬头: 
						<em><%=base.getInvoiceTitle()%></em>
					</li>
					<li> 所属财务部:<em><%=base.getFinancialDept()%></em></li>
					<li> 所属薪酬组:<em><%=base.getSalaryGroupName()%></em></li>
					<li>
						 支付方式: 
						<em><%=base.getPayType()%></em>
					</li>
					 <li>
						 币种: 
						<em><%=base.getCurrency()%></em>
					</li>
					<li>
						 收款方: 
						<em><%=base.getAccountName() == null ? "" : base.getAccountName()%></em>
					</li>
					<li> 最迟汇款日期:<em><%=base.getLatestRemitDateStr()==null?"":base.getLatestRemitDateStr()%></em>
					<li>
						 手机号码: 
						<em><%=base.getContactInfo()==null?"":base.getContactInfo()%></em>
					</li>
					<li>
						 申请事由及说明: 
						<em><%=base.getCostExplain()%></em>
					</li>                  
					<li class="yellow">
						<em>付款信息</em>
					</li>
				   <li>
					   报账金额: 
					  <em><%=FormatUtil.formatMoney(base.getApplyAmount())%></em>
				   </li>
				    <li>
					   付款金额: 
					  <em><%=FormatUtil.formatMoney(base.getPayAmount())%></em>
				   </li>
				   <li>
					   核销金额: 
					  <em><%=FormatUtil.formatMoney(base.getAlreadyWritedAmount())%></em>
				   </li>
				  
				   <li>
					   币种: 
					  <em><%=base.getCurrency()%></em>
				   </li>
				    <li>
					   付款金额大写: 
					  <em id='amountCNY'></em>
				   </li>
				   <li>
					   账户性质: 
					  <em><%=base.getAccountNature()%></em>
				   </li>
				   <li>
					   银行账号: 
					  <em><%= base.getAccount()%></em>
				   </li>
				   <li>
					   开户支行: 
					  <em><%=base.getSubbankName()%></em>
				   </li>
					<li class="yellow">
						<em>明细信息</em>
					</li>
					<%for(int i = 0; i < mobileLineList.length; i++ ) {%>
					<li <%=i==0?"":"class='line'" %>>费用类型:<em><%=mobileLineList[i].getScName()%></em></li>
				<li>员工工号:<em><%=mobileLineList[i].getEmpCode()==null?"无":mobileLineList[i].getEmpCode()%></em></li>
				<li>员工姓名:<em><%=mobileLineList[i].getEmpName()==null?"无":mobileLineList[i].getEmpName()%></em></li>
				<li>费用期间:<em><%=mobileLineList[i].getCostPeriod()==null?"":mobileLineList[i].getCostPeriod()%></em></li>
				<li>费用承担部门:<em><%=mobileLineList[i].getCostCenterName()%></em></li>
				<%-- <li>业务发生日期:<em><%=line.getBizOccurDateStr()==null?"":line.getBizOccurDateStr()%></em></li> --%>
				<li>社保主体:<em><%=mobileLineList[i].getSecurityUnits()==null?"无":mobileLineList[i].getSecurityUnits()%></em></li>
				<li>实发小计:<em><%=FormatUtil.formatMoney(mobileLineList[i].getActualAmount())%></em></li>
				   
				   <%} %>
		    </ul>
		</div>
		  <%@include file="approve_process.jsp" %>
		</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
<script type="text/javascript">
$(function(){
	//将付款金额转成大写
	$("#amountCNY").html(numToCny(<%=base.getPayAmount()%>));
});
</script>
</body>
</html>