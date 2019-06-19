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
			    <tr><th >工作流名称:</th><td>事前申请单-临时租车费</td></tr>	
				<tr><th >发票抬头:</th><td><%=base.getInvoiceTitle()%></td></tr>
				<tr><th >所属财务部:</th><td><%=base.getFinancialDept()%></td></tr>
				<%
					if ("104cd".equals(base.getDeptNature())) {
						base.setDeptNature("车队");
					}else if ("yy".equals(base.getDeptNature())) {
						base.setDeptNature("营业部");
					}else if ("jy".equals(base.getDeptNature())) {
						base.setDeptNature("派送部部");
					}else if(base.getDeptNature()==null) {
						base.setDeptNature("");
					}%>
				<tr><th >部门性质:</th><td><%=base.getDeptNature()%></td></tr>
				<tr><th >项目类型:</th><td><%=base.getProjectType()==null?"无":base.getProjectType()%></td></tr>
				<tr><th >项目名称:</th><td><%=base.getProjectName() == null ? "无" : base.getProjectName() %></td></tr>
				<tr><th>申请事由及说明:</th><td><%= base.getCostExplain() == null ? "" : base.getCostExplain()%></td></tr> 
				
				<tr class="yellow"><td colspan="2" >付款信息</td></tr>
			    <tr><th>预计金额:</th><td><%=FormatUtil.formatMoney(base.getApplyAmount())%></td></tr>
			    <tr><th>借款金额:</th><td><%=FormatUtil.formatMoney(base.getPlanAmount())%></td></tr>
			    <tr><th>预计金额大写:</th><td id='amountCNY'></td></tr>
			    <tr><th>币种:</th><td><%=base.getCurrency()%></td></tr>
			    <tr><th>账户性质:</th><td><%=base.getAccountNature()==null?"":base.getAccountNature()%></td></tr>
			    <tr><th>银行账号:</th><td><%= base.getAccount()==null?"":base.getAccount()%></td></tr>
			    <tr><th>开户支行:</th><td><%=base.getSubbankName()==null?"":base.getSubbankName()%></td></tr>
			    
				<tr class="yellow"><td colspan="2" >其他信息-明细信息</td></tr>
				<%for(int i = 0; i < mobileLineList.length; i++ ) {%>
					<tr><th>序号:</th><td><%=i+1 %></td></tr>
				   	<tr><th>费用类型:</th><td><%= mobileLineList[i].getScName()%></td></tr>
				   	<tr><th>费用承担部门:</th><td><%= mobileLineList[i].getCostCenterName()%></td></tr>
				    <tr><th>业务发生日期:</th><td><%= mobileLineList[i].getBizOccurDateStr()%></td></tr>
				    <tr><th>预计金额:</th><td><%= mobileLineList[i].getPlanAmount()%></td></tr>
				    <tr><th>借款金额:</th><td><%= mobileLineList[i].getActualAmount() == null ? "" : mobileLineList[i].getActualAmount()%></td></tr>
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
	$("#amountCNY").html(numToCny(<%=base.getApplyAmount()%>));
});
</script>
</body>
</html>