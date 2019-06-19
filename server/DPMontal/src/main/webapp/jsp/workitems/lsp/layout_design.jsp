<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.lsp.module.mobilesecondworkflowlist.controlcenter.shared.domain.WorkflowSecondEntity"%>
<%@page import="com.deppon.lsp.module.mobilesecondworkflowlist.controlcenter.server.service.PlanDesignApplyVo"%>
<%@page import="com.deppon.lsp.module.mobilesecondworkflowlist.controlcenter.server.service.PlanDesignEntity"%>
<%@page import="com.deppon.lsp.module.mobilesecondworkflowlist.controlcenter.server.service.PlanDesignEntryEntity"%>
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
 PlanDesignApplyVo temp = info.getPlanDesignApplyVo();
 PlanDesignEntity base = temp.getPlanDesignEntity();
 List<PlanDesignEntryEntity> items = temp.getPlanDesignEntryEntity();
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
				<tr><th>单据编号:</th><td id="workid"><%=base.getFnumber() %></td></tr>
				<tr><th>所属子公司:</th><td><%=base.getCfsubOrdSubsiDiaryName().getName()%></td></tr>
				<tr><th>申请时间:</th><td><%=base.getFbizDateStr()%></td></tr>
				<tr><th>申请人:</th><td><%=base.getCfapplicant().getName()%></td></tr>
				<tr><th>申请部门:</th><td><%=base.getCfapplicantdeps().getName()%></td></tr>
			   	<tr><th>单据状态:</th><td><%=base.getCfstate()%></td></tr>
			   	<tr><th>库存组织:</th><td><%=base.getCfwarehousezz().getName()%></td></tr>
			   	<tr><th>到货部门:</th><td><%=base.getCfdeliveryDepart().getName()%></td></tr>
			   	<tr><th>预算承担部门:</th><td><%=base.getFcostCenter().getName()%></td></tr>
			   	<tr><th>联系电话:</th><td><%=base.getCfphone()%></td></tr>
			   	<tr><th>到货地址:</th><td><%=base.getCfaddress()%></td></tr>
			   	<tr><th>申请总金额:</th><td class="applyTotalAccountClass"><%=base.getCftotalApplyAmountStr()%></td></tr>
			   	<%if (base.getCfunplanPurchases() == 1) { %>
			    	<tr><th><input type="checkbox" checked="checked"/>是否计划外采购</th></tr>
				<%} else { %>
					<tr><th><input type="checkbox" />是否计划外采购</th></tr>
				<%}%>
				<%if (base.getCfchangeRepleni() == 1) { %>
			    	<tr><th><input type="checkbox" checked="checked"/>是否换补货</th></tr>
				<%} else { %>
					<tr><th><input type="checkbox" />是否换补货</th></tr>
				<%}%>
				<tr class="yellow"><td colspan="2" >其他信息-明细信息</td></tr>
				<%for(int i = 0; i < items.size(); i++ ) {%>
					<tr <%=i==0 ? "" : "class='topLine'" %>><th>序号:</th><td><%=i+1 %></td></tr>
				    <tr><th>物品编码:</th><td><%= items.get(i).getCfmaterialNum().getNumber()%></td></tr>
				   	<tr><th>物品名称:</th><td><%= items.get(i).getCfmaterialName()%></td></tr>
				    <tr><th>物品类型:</th><td><%= items.get(i).getCfmaterialTypes()%></td></tr>
				    <tr><th>规格型号:</th><td><%= items.get(i).getCfspecifications()%></td></tr>
				    <tr><th>单位:</th><td><%= items.get(i).getCfunit().getName()%></td></tr>
				    <tr><th>申请数量:</th><td><%= items.get(i).getCfquantityStr()%></td></tr>
				   	<tr><th>参考单价:</th><td><%= items.get(i).getCfreferencePriceStr()%></td></tr>
				    <tr><th>参考金额:</th><td><%= items.get(i).getCfreferenceAmountStr()%></td></tr>
				   	<tr><th>预算项目:</th><td><%= items.get(i).getFprojectBudget().getName()%></td></tr>
				    <tr><th>使用部门:</th><td><%= items.get(i).getCfuseDepartment().getName()%></td></tr>
				    <tr><th>未签收数量:</th><td><%= items.get(i).getCfsignAmountStr()%></td></tr>
				    <tr><th>出库数量:</th><td><%= items.get(i).getCfexportNumber()%></td></tr>
				    <tr><th>采购组织:</th><td><%= items.get(i).getCfpurorderunit().getName()%></td></tr>
				    <tr><th>物料属性:</th><td><%= items.get(i).getFmaterialMent().getNameChinese()%></td></tr>
				    <tr><th>申请原因:</th><td><%= items.get(i).getCfattribute()%></td></tr>
				    <tr><th>备注:</th><td><%= items.get(i).getCfremake()%></td></tr>
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
</html>