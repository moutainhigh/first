<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.fssc.module.remote.mobile.service.MobileFsscEntity"%>
<%@page import="com.deppon.fssc.module.remote.mobile.shared.ClaimFsscBase"%>
<%@page import="com.deppon.fssc.module.remote.mobile.shared.ClaimLineFssc"%>
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
 %>
<div id="list">
	<%@include file="../wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
	    		<tr>
					<th colspan="2" class="yellow">基本信息</th>
				</tr>
	    		<tr>
				   <th>单据编号:</th>
			
				   <td id="workid"><%=base.getClaimNo() %></td>
				</tr>
				<tr>
				   <th >工作流:</th>
				   <td>暂收款支付-押金</td>
				</tr>
				   <tr>
					  <th >申请人:</th>
					  <td><%= base.getApplyEmpName()%></td>
				   </tr>
					 <tr>
					  <th >申请人部门:</th>
					  <td><%=base.getApplyDeptName()%></td>
				   </tr>
					 <tr>
					  <th >申请人公司:</th>
					  <td><%=base.getApplyCompName()%></td>
				   </tr>
					 <tr>
					  <th >申请时间:</th>
					  <td><%=base.getApplyDateStr()%></td>
				   </tr>
				   <tr>
						<th colspan="2" class="yellow">报账信息</th>
				   </tr>	
				   <tr>
					  <th>币种:</th>
					  <td><%=base.getCurrency()%></td>
				   </tr>
					<tr>
						<th >发票抬头:</th>
						<td><%=base.getInvoiceTitle()%></td>
					</tr>
					<tr><th>所属财务部:</th><td><%=base.getFinancialDept()%></td></tr>
					<tr>
						<th >支付方式:</th>
						<td><%=base.getPayType()%></td>
					</tr>
					<tr>
						<th >收款方:</th>
						<td><%=base.getAccountName() == null ? "" : base.getAccountName()%></td>
					</tr>
					 <tr>
					  <th>账户性质:</th>
					  <td><%=base.getAccountNature()%></td>
				   </tr>
					<tr>
						<th >最迟汇款日期:</th>
						<td><%=base.getLatestRemitDateStr()%></td>
					</tr>
					<tr>
						<th >手机号码:</th>
						<td><%=base.getContactInfo()==null?"":base.getContactInfo()%></td>
					</tr>
					<tr>
						<th>申请事由及说明:</th>
						<td><%=base.getCostExplain()%></td>
					</tr>                  
					<tr class="yellow">
						<td colspan="2" >付款信息</td>
					</tr>
				   <tr>
					  <th>报账金额:</th>
					  <td><%=FormatUtil.formatMoney(base.getApplyAmount())%></td>
				   </tr>
				   <tr>
					  <th>付款金额:</th>
					  <td><%=FormatUtil.formatMoney(base.getPayAmount())%></td>
				   </tr>
				   <tr class="changeByAccount">
					  <th>核定金额:</th>
					  <td><%=FormatUtil.formatMoney(base.getRatifyAmount())%></td>
				   </tr>
				   
				   <tr>
					  <th>币种:</th>
					  <td><%=base.getCurrency()%></td>
				   </tr>
				    <tr>
					  <th>付款金额大写:</th>
					  <td id='amountCNY'></td>
				   </tr>
				   <tr>
					  <th>账户性质:</th>
					  <td><%=base.getAccountNature()%></td>
				   </tr>
				   <tr>
					  <th>银行账号:</th>
					  <td><%= base.getAccount()%></td>
				   </tr>
				   <tr>
					  <th>开户支行:</th>
					  <td><%=base.getSubbankName()%></td>
				   </tr>
				  
					<tr class="yellow">
						<td colspan="2" >暂收款支付信息</td>
					</tr>
					<%for(int i = 0; i < mobileLineList.length; i++ ) {%>
					 <tr class='topLine'>
					  <th>认领编号:</th>
					  <td><%= mobileLineList[i].getApplyNum()%></td>
				   </tr>
				   <tr>
					  <th>押金系统编号:</th>
					  <td><%= mobileLineList[i].getDepositSysnum()%></td>
				   </tr>
					 <tr  >
					  <th>费用承担部门:</th>
					  <td><%= mobileLineList[i].getCostCenterName()%></td>
				   </tr>
					 <tr  >
					  <th>押金类型:</th>
					  <td><%= mobileLineList[i].getDepositType()%></td>
				   </tr>
				    <tr  >
					  <th>暂收款客户:</th>
					  <td><%= mobileLineList[i].getClientName()%></td>
				   </tr>
				   <tr>
					  <th>暂收款客户关联号:</th>
					  <td><%= mobileLineList[i].getClientCode() == null ? "无" : mobileLineList[i].getClientCode()%></td>
				   </tr>
				    <tr>
					  <th>费用类型:</th>
					  <td><%=mobileLineList[i].getScName()%></td>
				   </tr>
				    <tr  >
					  <th>暂收款总金额:</th>
					  <td><%=FormatUtil.formatMoney(mobileLineList[i].getDepositTotAmount())%></td>
				   </tr>
				    <tr>
					  <th>收据编号:</th>
					  <td><%= mobileLineList[i].getReceiptNum() == null ? "无" : mobileLineList[i].getReceiptNum()%></td>
				   </tr>
				   <tr>
					  <th>可支付金额:</th>
					  <td><%=FormatUtil.formatMoney(mobileLineList[i].getAblePayAmount())%></td>
				   </tr>
				    <tr>
					  <th>暂收日期:</th>
					  <td><%= mobileLineList[i].getDepositDate()%></td>
				   </tr>
				    <tr>
					  <th>合同到期日:</th>
					  <td><%= mobileLineList[i].getExpireDate()%></td>
				   </tr>
				   <tr>
					  <th>客户与我司在其他业务往来中是否存在欠款:</th>
					  <td><%="Y".equals(mobileLineList[i].getExistDebt()) ? "是":"否" %></td>
				   </tr>
				   <%if("Y".equals(mobileLineList[i].getExistDebt())){%>
					   <tr>
					  <th>客户欠款金额:</th>
					  <td><%=FormatUtil.formatMoney(mobileLineList[i].getDebtAmount())%></td>
				   	</tr>
				   <%} %>
				    
				    <tr>
					  <th>客户在本次业务往来中是否存在违约行为:</th>
					  <td><%="Y".equals(mobileLineList[i].getIsBreach()) ? "是":"否" %></td>
				   </tr>
				   
				   <%if("Y".equals(mobileLineList[i].getIsBreach())){%>
					 <tr>
					  <th>扣除违约金额:</th>
					  <td><%=FormatUtil.formatMoney(mobileLineList[i].getDeductBreachAmount())%></td>
				   </tr>
				   <%} %>
				    <%if("Y".equals(mobileLineList[i].getIsOffsetRent())){%>
				    <tr>
					  <th>押金是否用于冲抵房租:</th>
					  <td><%="Y".equals(mobileLineList[i].getIsOffsetRent()) ? "是":"否" %></td>
				   </tr>
				   <%} %>
				   <%if("Y".equals(mobileLineList[i].getIsOffsetRent())){%>
					 <tr>
					  <th>抵扣房租押金:</th>
					  <td><%=FormatUtil.formatMoney(mobileLineList[i].getOffsetRentAmount())%></td>
				   </tr>
				   <%} %>
				    <tr>
					  <th>本次退款金额:</th>
					  <td><%=FormatUtil.formatMoney(mobileLineList[i].getPayAmount())%></td>
				   </tr>
				    <tr>
					  <th>剩余金额:</th>
					  <td><%=FormatUtil.formatMoney(((mobileLineList[i].getAblePayAmount().subtract(mobileLineList[i].getDeductBreachAmount())).subtract(mobileLineList[i].getOffsetRentAmount())).subtract(mobileLineList[i].getPayAmount()))%></td>
				   </tr>
				    <tr class="changeByAccount">
					  <th>核定金额:</th>
					  <td><%=FormatUtil.formatMoney(mobileLineList[i].getRetifyAmount())%></td>
				   </tr>
				   <tr class="changeByAccount">
					  <th>辅助账客户:</th>
					  <td><%= mobileLineList[i].getAidAttriName() == null ? "无":mobileLineList[i].getAidAttriName()%></td>
				   </tr>
				   <%} %>
		  </table>
		  <%@include file="approve_process.jsp" %>
		</div>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
	<input type="hidden" value="<%=request.getAttribute("activitydefid")%>" id="activitydefid">
</div>
<script type="text/javascript">
$(function(){
	//将付款金额转成大写
	$("#amountCNY").html(numToCny(<%=base.getPayAmount()%>));
	//直接上级、总监级、高级总监级、副总级、事业部财务部负责人；
// 	var activitydefid = $("#activitydefid").val();
// 	if(activitydefid != 'manualActivity' && activitydefid != 'manualActivity11' && activitydefid != 'manualActivity111' && activitydefid != 'manualActivity1111' && activitydefid != "manualActivity10"){
// 		$("#approve_area").hide();
// 		$("#div3").hide();
// 	}
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