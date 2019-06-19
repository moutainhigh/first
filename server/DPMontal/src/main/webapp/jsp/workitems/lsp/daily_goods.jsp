<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.lsp.module.mobilesecondworkflowlist.controlcenter.shared.domain.WorkflowSecondEntity"%>
<%@page import="com.deppon.lsp.module.mobilesecondworkflowlist.controlcenter.server.service.DailysuppliesVo"%>
<%@page import="com.deppon.lsp.module.mobilesecondworkflowlist.controlcenter.server.service.ReceiptData"%>
<%@page import="com.deppon.lsp.module.mobilesecondworkflowlist.controlcenter.server.service.JournalizeData"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_win8.jsp" %>
</head>

<body>
 <%
 WorkflowSecondEntity info = (WorkflowSecondEntity)request.getAttribute("lspResponseEntity");
 DailysuppliesVo temp = info.getDailysuppliesVo();
 ReceiptData base = temp.getReceiptData();
 List<JournalizeData> items = temp.getJournalizeDataList();
 String workflowNameLSP = (String)request.getAttribute("workflowNameLSP");
 %>
<div id="list">
	<%@include file="../wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table>
	    		<tr><th colspan="2" class="yellow">基本信息</th></tr>
	    		<tr><th>工&nbsp;&nbsp;作&nbsp;&nbsp;流:</th><td><%=workflowNameLSP %> </td></tr>
	    		<tr><th>单据编号:</th><td id="workid"><%=base.getReceiptNumber() %></td></tr>
				<tr><th>所属子公司:</th><td><%=base.getChildCompanyName()%></td></tr>
				<tr><th>申请时间:</th><td><%=base.getApplyTimeStr()%></td></tr>
				<tr><th>申请人:</th><td><%=base.getPersonName()%></td></tr>
				<tr><th>申请部门:</th><td><%=base.getDepartmentName()%></td></tr>
			   	<tr><th>预算承担部门:</th><td><%=base.getBudgetAssumeApartment()%></td></tr>
			   	<tr><th>库存组织:</th><td><%=base.getInventoryName()%></td></tr>
			   	<tr><th>到货部门:</th><td><%=base.getArrivalApartmentName()%></td></tr>
			   	<tr><th>联系电话:</th><td><%=base.getAssociationPhone()%></td></tr>
			   	<tr><th>到货地址:</th><td><%=base.getArrivalAddress()%></td></tr>
			   	<tr><th>申请总金额:</th><td class="applyTotalAccountClass"><%=base.getApplyTotalAccountStr()%></td></tr>
			    <tr><th>备注:</th><td><%=base.getMark()%></td></tr>
			    <tr><th>是否计划外采购:</th><td><%=base.getPlanOutPurchaseStr()%></td></tr>
			    <tr><th>是否换/补货:</th><td><%=base.getChangeRepairStr()%></td></tr>
			    <tr><th>是否积分礼品:</th><td><%=base.getFislStr()%></td></tr>
				 <tr><th>是否点部信息:</th><td><%=base.getCfisexpress()%></td></tr>
				<tr class="yellow"><td colspan="2" >其他信息-明细信息</td></tr>
				<%for(int i = 0; i < items.size(); i++ ) {%>
					<tr <%=i==0 ? "" : "class='topLine'" %>><th>序号:</th><td><%=i+1 %></td></tr>
				   	<tr><th>预算项目:</th><td><%= items.get(i).getStockBudgeItemsName()%></td></tr>
				    <tr><th>物品编码:</th><td><%= items.get(i).getFnumber()%></td></tr>
				   	<tr><th>物品名称:</th><td><%= items.get(i).getCfmaterialName()%></td></tr>
				    <tr><th>物品类型:</th><td><%= items.get(i).getCfmaterialTypes()%></td></tr>
				    <tr><th>规格型号:</th><td><%= items.get(i).getCfspecifications()%></td></tr>
				    <tr><th>单位:</th><td><%= items.get(i).getBaseUnit()%></td></tr>
				    <tr><th>申请数量:</th><td><%= items.get(i).getBuyNumber()%></td></tr>
				   	<tr><th>参考价格:</th><td><%= items.get(i).getPriceStr()%></td></tr>
				    <tr><th>参考金额:</th><td><%= items.get(i).getAmountStr()%></td></tr>
				    <tr><th>物料属性:</th><td><%= items.get(i).getAttriname()%></td></tr>
				    <tr><th>采购组织:</th><td><%= items.get(i).getPurChaseOrg()%></td></tr>
				    <tr><th>使用部门:</th><td><%= items.get(i).getCompanyOrgName()%></td></tr>
				    <tr><th>未签收数量:</th><td><%= items.get(i).getCfsignAmountStr()%></td></tr>
				    <tr><th>出库数量:</th><td><%= items.get(i).getCfexportNumberStr()%></td></tr>
				    <tr><th>调拨数量:</th><td><%= items.get(i).getFtransferNumStr()%></td></tr>
				    <tr><th>备注:</th><td><%= items.get(i).getCfremark()%></td></tr>
			   <%} %>
		  </table>
		  <%@include file="approve_process_esb2.jsp" %>
		</div>
	</div>
	<%@include file="workflow_approve_button_esb2.jsp" %>
</div>
<script type="text/javascript">
	var num = $(".applyTotalAccountClass");
	for (var i = 0;i < num.length;i ++ ) {
		if ($(num[i]).text() == "") {
			$(num[i]).text("");
		}else {
			var valueTempInt = $(num[i]).text();
			var valueTempFolat;
			var indexNum = valueTempInt.indexOf(".");
			if (indexNum > -1) {
				valueTempFolat = valueTempInt.substring(indexNum+1,valueTempInt.length);
				valueTempInt = valueTempInt.substring(0,indexNum);
				valueTempInt = valueTempInt.replace(/\d+?(?=(?:\d{3})+$)/img, "$&,");
				if (valueTempFolat) {
					valueTempInt += "." + valueTempFolat;
				}
			}
			$(num[i]).text(valueTempInt);
		}
	}
</script>
</body>
