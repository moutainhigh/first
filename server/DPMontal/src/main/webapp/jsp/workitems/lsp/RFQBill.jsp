<%@page import="java.util.List"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain.RfqBillVo"%>
<%@page import="com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain.RFQBillEntry"%>
<%@page import="com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain.RFQBillAuditDept"%>
<%@page import="com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain.RFQBill"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_win8.jsp" %>
		<style type="text/css">
		.otherInfo1{
			display:none;
		}
		.otherInfo2{
			display:none;
		}
	</style>
</head>

<body>
 <%
//RFQ单
	RfqBillVo info = (RfqBillVo)request.getAttribute("lspResponseEntity");
	//RFQ单表头对象，用来存储JS界面的RFQ单的表头信息
	RFQBill rfqBill = info.getRfqBill();
	//RFQ单分录  询价物品对象集合
	List<RFQBillEntry> rfqBillEntryList = info.getRfqBillEntryList();
	//RFQ单分录 技术评审对象集合
	List<RFQBillAuditDept> rfqBillAuditDeptList = info.getRfqBillAuditDeptList();
 %>
<div id="list">
	<%@include file="../wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
	    		<tr><th colspan="2" class="yellow">基本信息</th></tr>
	    		<tr><th>工&nbsp;&nbsp;作&nbsp;&nbsp;流:</th><td>RFQ单</td></tr>
	    		<tr><th>RFQ单号:</th><td><%=rfqBill.getNumber()%></td></tr>
				<tr><th>询价人:</th><td><%=rfqBill.getEnquiryer()%></td></tr>
				<tr><th>询价日期:</th><td><%=FormatUtil.formatDate(rfqBill.getEnquiryTurn())%></td></tr>
				<tr><th>RFQ申请单号:</th><td><%=rfqBill.getRfqclaimerNumber()%></td></tr>
			   	<tr><th>询价部门:</th><td><%=rfqBill.getEnquiryDepartment()%></td></tr>
			   	<tr><th>RFQ类型:</th><td><%=rfqBill.getRfqtype()%></td></tr>
			   	<tr><th>制单人是否为总部人员:</th><td><%=rfqBill.isDpzb()==true?"是":"否"%></td></tr>
			   	<tr><th>询价轮次:</th><td><%=rfqBill.getEnquiry()%></td></tr>
			   	<tr><th>总金额:</th><td><%=rfqBill.getAmountMoney()%></td></tr>
			    
				<tr class="yellow" id="otherInfo1Open"><td colspan="2">其他信息-询价物品</td></tr>
				
					<%
					int rfqBillEntrySize = rfqBillEntryList == null ? 0:rfqBillEntryList.size();
					for(int i = 0; i < rfqBillEntrySize ; i++ ) {
						RFQBillEntry obj1 = rfqBillEntryList.get(i);
					%>
						<tr <%=i==0 ? "" : "class='topLine otherInfo1'" %> class="otherInfo1"><th>序号:</th><td><%=i+1 %></td></tr>
					   	<tr class="otherInfo1"><th>物品编码:</th><td><%= obj1.getMateriaNumber()%></td></tr>
					    <tr class="otherInfo1"><th>物品名称:</th><td><%= obj1.getMateriaName()%></td></tr>
					   	<tr class="otherInfo1"><th>物品类型:</th><td><%= obj1.getMateriaType()%></td></tr>
					    <tr class="otherInfo1"><th>物品规格:</th><td><%= obj1.getMateriaStandard()%></td></tr>
					    <tr class="otherInfo1"><th>数量:</th><td><%= obj1.getQuantityDto()%></td></tr>
					    <tr class="otherInfo1"><th>计量单位:</th><td><%= obj1.getMeasureUnit()%></td></tr>
					    <tr class="otherInfo1"><th>是否打样:</th><td><%= obj1.isMakeProof()==true?"是":"否"%></td></tr>
					    <tr class="otherInfo1"><th>是否含运费:</th><td><%= obj1.isFreight()==true?"是":"否"%></td></tr>
					    <tr class="otherInfo1"><th>是否含税:</th><td><%= obj1.isRevenue()==true?"是":"否"%></td></tr>
					    <tr class="otherInfo1"><th>开票类型:</th><td><%= obj1.getInvoiceType()%></td></tr>
					    <tr class="otherInfo1"><th>供货时效（天）:</th><td><%= obj1.getDate()%></td></tr>
					    <tr class="otherInfo1"><th>备注:</th><td><%= obj1.getRemark()==null?"":obj1.getRemark()%></td></tr>
				   <%} %>
				   <tr class="yellow" style="display: none" id="otherInfo1Close"><td colspan="2">关闭信息-询价物品</td></tr>
			   
			   <tr class="yellow" id="otherInfo2Open" ><td colspan="2">其他信息-技术评审</td></tr>
				<%
				int rfqBillAuditDeptListSize = rfqBillAuditDeptList==null?0:rfqBillAuditDeptList.size();
				for(int i = 0; i < rfqBillAuditDeptListSize ; i++ ) {
					RFQBillAuditDept obj1 = rfqBillAuditDeptList.get(i);
				%>
					<tr <%=i==0 ? "" : "class='topLine otherInfo2'" %> class="otherInfo2"><th>序号:</th><td><%=i+1 %></td></tr>
				    <tr class="otherInfo2"><th>部门编码:</th><td><%= obj1.getDepartmentNumber()%></td></tr>
				   	<tr class="otherInfo2"><th>评审部门:</th><td><%= obj1.getReviewDepartment()%></td></tr>
			   <%} %>
			   <tr class="yellow" style="display: none" id="otherInfo2Close"><td colspan="2">关闭信息-技术评审</td></tr>
		  </table>
		  <%@include file="approve_process_esb3.jsp" %>
		</div>
	</div>
	<%@include file="workflow_approve_button_esb2.jsp" %>
</div>
<script type="text/javascript">
	$("#otherInfo1Open").click(function (){
		$(".otherInfo1").show();
		$("#otherInfo1Close").show();
	});
	$("#otherInfo1Close").click(function (){
		$(".otherInfo1").hide();
		$("#otherInfo1Close").hide();
	});
	$("#otherInfo2Open").click(function (){
		$(".otherInfo2").show();
		$("#otherInfo2Close").show();
	});
	$("#otherInfo2Close").click(function (){
		$(".otherInfo2").hide();
		$("#otherInfo2Close").hide();
	});
	$(function(){
		$("#rollback_but").hide();
		$("#disagree_but").show();
	});
</script>
</body>
</html>