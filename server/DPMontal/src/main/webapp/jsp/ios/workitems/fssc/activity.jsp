<%@page import="com.deppon.fssc.module.remote.mobile.shared.ClaimLineFssc"%>
<%@page import="com.deppon.fssc.module.remote.mobile.shared.ClaimFsscBase"%>
<%@page import="com.deppon.fssc.module.remote.mobile.service.MobileFsscEntity"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.conf.F_Constants"%>
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
MobileFsscEntity info = (MobileFsscEntity)request.getAttribute("mobileFsscEntity");
ClaimFsscBase base = info.getMobileBaseEntity();
ClaimLineFssc[]  mobileLineList = info.getMobileLineArray();
ApproveFssc[] mobileApprovalInfo = info.getMobileApprovalArray();
%>
<body>
<div id="list">
	<%@include file="/jsp/ios/work_items_head.jsp" %>
    <!--div2 S-->
    <div id="div2">
    	<div class="ulBox2">
    		<ul>
				<li class="first"><em class="yellow">基本信息 </em></li>
				<li>单据编号:<em id="workid"><%=base.getClaimNo() %></em></li>
				<li>工作流:<em>文化活动费-报销</em></li>
				<li>申请人:<em><%= base.getApplyEmpName()%></em></li>
				<li>申请日期:<em><%=base.getApplyDateStr()%></em></li>
				<li>申请人部门:<em><%=base.getApplyDeptName()%></em></li>
				<li>申请人公司:<em><%=base.getApplyCompName()%></em></li>
				
				<li><em class="yellow">报账信息</em></li>
				<li>币种:<em><%=base.getCurrency()%></em></li>
				<li>发票抬头:<em><%=base.getInvoiceTitle()%></em></li>
				<li>所属财务部:<em><%=base.getFinancialDept()%></em></li>
				
				<li>支付方式:<em><%=base.getPayType()%></em></li>
				<li>收款方:<em><%=base.getAccountName() == null ? "" : base.getAccountName()%></em></li>
				<li>最迟汇款日期:<em><%=base.getLatestRemitDateStr()== null ? "" : base.getLatestRemitDateStr()%></em></li>
				<li>手机号码:<em><%=base.getContactInfo()==null?"":base.getContactInfo()%></em></li>
				
				<li>项目类型:<em><%=base.getProjectType()==null?"无":base.getProjectType()%></em></li>
				<li>项目名称:<em><%=base.getProjectName() == null ? "无" : base.getProjectName() %></em></li>
				<li>文化活动类型:<em><%=base.getBizType()%></em></li>
				<li>所属事业部:<em><%=base.getBusinessDept()%></em></li>
				<li>事前申请单号:<em><%=base.getPriorClaimNo()%></em></li>
				<li>申请事由及说明:<em><%=base.getCostExplain()%></em></li>
				
				<li><em class="yellow">付款信息</em></li>
				<li>报账金额:<em><%=FormatUtil.formatMoney(base.getApplyAmount())%></em></li>
				<li>核销金额:<em><%=FormatUtil.formatMoney(base.getAlreadyWritedAmount())%></em></li>
				<li>付款金额:<em><%=FormatUtil.formatMoney(base.getPayAmount())%></em></li>
				<li>币种:<em><%=base.getCurrency()%></em></li>
				<li>付款金额大写:<em id='amountCNY'></em></li>
				
				<li>账户性质:<em><%=base.getAccountNature()%></em></li>
				<li>银行账号:<em><%= base.getAccount()%></em></li>
				<li>开户支行:<em><%=base.getSubbankName()%></em></li>
					
				<li><em class="yellow">明细信息</em></li>
				<%
					for(int i=0; i< mobileLineList.length; i++){							
				%>
				<li <%=i==0?"":"class='line'" %>>费用承担部门:<em><%= mobileLineList[i].getCostCenterName()%></em></li>
				<li>费用类型:<em><%= mobileLineList[i].getScName()%></em></li>
				<li>业务发生日期:<em><%= mobileLineList[i].getBizOccurDateStr()%></em></li>
				<li>报账金额:<em><%= FormatUtil.formatMoney(mobileLineList[i].getActualAmountStd())%></em></li>
				<li>费用说明:<em><%= mobileLineList[i].getCostExplain() == null ? "" : mobileLineList[i].getCostExplain()%></em></li>
				<%}%>
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