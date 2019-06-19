<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.lsp.module.mobilesecondworkflowlist.controlcenter.shared.domain.WorkflowSecondEntity"%>
<%@page import="com.deppon.lsp.module.mobilesecondworkflowlist.controlcenter.server.service.DailysuppliesVo"%>
<%@page import="com.deppon.lsp.module.mobilesecondworkflowlist.controlcenter.server.service.ReceiptData"%>
<%@page import="com.deppon.lsp.module.mobilesecondworkflowlist.controlcenter.server.service.JournalizeData"%>
<%@page import="java.util.List"%>
<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_ios.jsp" %>
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
	<%@include file="/jsp/ios/work_items_head.jsp" %>
	<div id="div2">
		<h4 class="yellow">基本信息</h4>
    	<div class="ulBox2">
	    	<ul>				  
				<li>工&nbsp;&nbsp;作&nbsp;&nbsp;流:<em><%=workflowNameLSP %></em></li>
	    		<li>单据编号:<em><%=base.getReceiptNumber() %></em></li>
				<li>所属子公司:<em><%=base.getChildCompanyName()%></em></li>
				<li>申请时间:<em><%=base.getApplyTimeStr()%></em></li>
				<li>申请人:<em><%=base.getPersonName()%></em></li>
				<li>申请部门:<em><%=base.getDepartmentName()%></em></li>
			   	<li>预算承担部门:<em><%=base.getBudgetAssumeApartment()%></em></li>
			   	<li>库存组织:<em><%=base.getInventoryName()%></em></li>
			   	<li>到货部门:<em><%=base.getArrivalApartmentName()%></em></li>
			   	<li>联系电话:<em><%=base.getAssociationPhone()%></em></li>
			   	<li>到货地址:<em><%=base.getArrivalAddress()%></em></li>
			   	<li>申请总金额:<em class="applyTotalAccountClass"><%=base.getApplyTotalAccountStr()%></em></li>
			    <li>备注:<em><%=base.getMark()%></em></li>
			    <li>是否计划外采购:<em><%=base.getPlanOutPurchaseStr()%></em></li>
			    <li>是否换/补货:<em><%=base.getChangeRepairStr()%></em></li>
			    <li>是否积分礼品:<em><%=base.getFislStr()%></em></li>
			    <li>是否点部信息:<em><%=base.getCfisexpress()%></em></li>
          	</ul>
        </div>
        <h4 class="yellow">其他信息-明细信息</h4>
	   	<div class="ulBox2">
    		<ul>
			   <%for(int i = 0; i < items.size() ; i++ ) { %>
				    <li <%=i==0?"class='first'":"class='line'"%>>序号:<em><%=i+1 %></em></li>
				   	<li>预算项目:<em><%= items.get(i).getStockBudgeItemsName()%></em></li>
				    <li>物品编码:<em><%= items.get(i).getFnumber()%></em></li>
				   	<li>物品名称:<em><%= items.get(i).getCfmaterialName()%></em></li>
				    <li>物品类型:<em><%= items.get(i).getCfmaterialTypes()%></em></li>
				    <li>规格型号:<em><%= items.get(i).getCfspecifications()%></em></li>
				    <li>单位:<em><%= items.get(i).getBaseUnit()%></em></li>
				    <li>申请数量:<em><%= items.get(i).getBuyNumber()%></em></li>
				   	<li>参考价格:<em><%= items.get(i).getPriceStr()%></em></li>
				    <li>参考金额:<em><%= items.get(i).getAmountStr()%></em></li>
				    <li>物料属性:<em><%= items.get(i).getAttriname()%></em></li>
			  		<li>采购组织:<em><%= items.get(i).getPurChaseOrg()%></em></li>
				    <li>使用部门:<em><%= items.get(i).getCompanyOrgName()%></em></li>
				    <li>未签收数量:<em><%= items.get(i).getCfsignAmountStr()%></em></li>
				    <li>出库数量:<em><%= items.get(i).getCfexportNumberStr()%></em></li>
				    <li>调拨数量:<em><%= items.get(i).getFtransferNumStr()%></em></li>
				    <li>备注:<em><%= items.get(i).getCfremark()%></em></li>
			   <%} %>
		   </ul>
	    </div>
	    <%@include file="approve_process_esb2.jsp"%> 
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

</html>