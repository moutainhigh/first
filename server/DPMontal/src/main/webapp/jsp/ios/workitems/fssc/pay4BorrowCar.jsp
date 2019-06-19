<%@page import="com.deppon.fssc.module.remote.mobile.shared.ClaimLineFssc"%>
<%@page import="com.deppon.fssc.module.remote.mobile.shared.ClaimFsscBase"%>
<%@page import="com.deppon.fssc.module.remote.mobile.service.MobileFsscEntity"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.conf.F_Constants"%>
<%@page import="java.util.Date"%>
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
				<li>工作流:<em>FOSS专线外请车-付款</em></li>
				<li>申请人:<em><%= base.getApplyEmpName()%></em></li>
				<li>申请人部门:<em><%=base.getApplyDeptName()%></em></li>
				<li>申请人公司:<em><%=base.getApplyCompName()%></em></li>
				<li>申请时间:<em><%=base.getApplyDateStr()%></em></li>
								
				<li><em class="yellow">报账信息</em></li>  
				<li>币种:<em><%=base.getCurrency()%></em></li>
				<li>发票抬头:<em><%=base.getInvoiceTitle()%></em></li>
				<li>所属财务部:<em><%=base.getFinancialDept()%></em></li>
				<li>支付方式:<em><%=base.getPayType()%></em></li>
				<li>收款方:<em><%=base.getAccountName() == null ? "" : base.getAccountName()%></em></li>
				<li>最迟汇款日期:<em><%="".equals(base.getLatestRemitDateStr())?FormatUtil.formateDateAdd(new Date(), 2):base.getLatestRemitDateStr()%></em></li>
				<li>手机号码:<em><%=base.getContactInfo()==null?"":base.getContactInfo()%></em></li>
				<li>申请事由及说明:<em><%=base.getCostExplain()==null?"":base.getCostExplain()%></em></li>    
					
				<li><em class="yellow">付款信息</em></li>
				<li>报账金额:<em><%=FormatUtil.formatMoney(base.getPayAmount())%></em></li>
				<li>付款金额:<em><%=FormatUtil.formatMoney(base.getPayAmount())%></em></li>
				<li class="changeByAccount">核定金额:<em><%=FormatUtil.formatMoney(base.getPayAmount())%></em></li>
				<li>币种:<em><%=base.getCurrency()%></em></li>
				<li>付款金额大写:<em id='amountCNY'></em></li>
				<li>账户性质:<em><%=base.getAccountNature()%></em></li>
				<li>银行账号:<em><%= base.getAccount()%></em></li>
				<li>开户支行:<em><%=base.getSubbankName()%></em></li>
				
				<li><em class="yellow">明细信息</em></li>
				<%for(int i = 0; i < mobileLineList.length; i++ ) {%>
				<li <%=i==0?"":"class='line'" %>>出发部门:<em><%= mobileLineList[i].getStartDeptName()%></em></li>
				<li>到达部门:<em><%= mobileLineList[i].getArriveDeptName()%></em></li>
				<li>费用类型:<em><%= mobileLineList[i].getScName()%></em></li>
				<li>车次号:<em><%= mobileLineList[i].getCarNum()%></em></li>
				<li>车牌号:<em><%= mobileLineList[i].getLicensePlateNum()%></em></li>
				<li>司机:<em><%= mobileLineList[i].getDriverName()%></em></li>
				<li>总额:<em><%= mobileLineList[i].getTotalAmount()%></em></li>
				<li>出发付金额:<em><%= mobileLineList[i].getStartPayAmount()%></em></li>
				<li>到达付金额:<em><%= mobileLineList[i].getArrivePayAmount()%></em></li>
				<li>增减变化:<em><%=mobileLineList[i].getRagulationChange() == null?"":mobileLineList[i].getRagulationChange()%></em></li>
				<li>押回单:<em><%= "Y".equals(mobileLineList[i].getIsReturnBill())?"是":"否"%></em></li>
				<li class="changeByAccount">核定金额:<em><%= mobileLineList[i].getRetifyAmount()%></em></li>
				<%
					}
				%>				
		  </ul>
		</div>
		<%@include file="approve_process.jsp" %>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>

<script type="text/javascript">
$(function(){
	//将付款金额转成大写
	$("#amountCNY").html(numToCny(<%=base.getPayAmount() %>));
	var accountXXID = $("#AccountXXID").val();
	if (accountXXID=="AccountXX") {
		$(".changeByAccount").show();
	}else {
		$(".changeByAccount").hide();
	}
});
</script>
</body>
</html>