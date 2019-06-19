<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.WorkflowEntity"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.StockmaintainVo"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.StockMaintainHead"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.StockMaintainEntryDto"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.StockMedeDto"%>
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
 WorkflowEntity info = (WorkflowEntity)request.getAttribute("lspResponseEntity");
 StockmaintainVo temp = info.getStockmaintainVo();
 StockMaintainHead base = temp.getStockMaintainHead();
 StockMaintainEntryDto[] items = temp.getStockMaintainEntryDtoList();
 StockMedeDto[] stockMedeDtoList = temp.getStockMedeDtoList();
 %>
<div id="list">
	<%@include file="../wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table>
	    		<tr><th colspan="2" class="yellow">基本信息</th></tr>
	    		<tr><th>工&nbsp;&nbsp;作&nbsp;&nbsp;流:</th><td>备货维护单</td></tr>
<%-- 	    		<tr><th>单据状态:</th><td><%=base.getBillState() %></td></tr> --%>
	    		<tr><th>备货维护单号:</th><td><%=base.getFnumber() %></td></tr>
	    		<tr><th>备货申请单号:</th><td><%=base.getStockBillNumber() %></td></tr>
	    		<tr><th>采购员:</th><td><%=base.getBuyerName()%></td></tr>
	    		<tr><th>申请人:</th><td><%=base.getApplyUser()%></td></tr>
				<tr><th>变更时间:</th><td><%=base.getBizDate() == null ? "" : base.getBizDate()%></td></tr>
				
				<tr><th >备货区域:</th><td><%=base.getStoreArea()%></td></tr>
				<tr><th >德邦库存:</th><td><%=base.getIsDpStock()==0?"否":"是"%></td></tr>
				<tr><th >库存组织:</th><td><%=base.getStockOrg()%></td></tr>
				<tr><th >需求汇总单:</th><td><%=base.getNeedsSummary()%></td></tr>
				<tr><th >备货类型:</th><td><%=base.getStockType()%></td></tr>
			   	<tr><th >仓库:</th><td><%=base.getWarehouse()%></td></tr>


				<tr class="yellow"><td colspan="2" >其他信息--备货维护信息表体</td></tr>
				<%
				int stockMedeDtoListSize = stockMedeDtoList.length;
				for(int i = 0; i < stockMedeDtoListSize; i++ ) {
					StockMedeDto en = stockMedeDtoList[i];
				%>
					<tr <%=i==0 ? "" : "class='topLine'" %>><th>序号:</th><td><%=i+1 %></td></tr>
				   	<tr><th>物品编码:</th><td><%= en.getMaterialNumber()%></td></tr>
				    <tr><th>物品名称:</th><td><%= en.getMaterialName()%></td></tr>
				   	<tr><th>物品类型:</th><td><%= en.getMaterialType()%></td></tr>
				   	<tr><th>物品规格:</th><td><%= en.getMaterialStandard()%></td></tr>
				   	<tr><th>物料属性:</th><td><%= en.getMaterialAttId()%></td></tr>
				   	<tr><th>供应商编码:</th><td><%= en.getSupplierNumber()%></td></tr>
				   	<tr><th>供应商名称:</th><td><%= en.getSupplierName()%></td></tr>
				   	<tr><th>备货数量:</th><td><%= en.getStockAmount()%></td></tr>
				   	<tr><th>采购合同编号:</th><td><%= en.getContractNumber()%></td></tr>
				   	<tr><th>备货单价:</th><td><%= en.getStockPrice()%></td></tr>
				   	<tr><th>备货总金额:</th><td><%= en.getStockAmounts()%></td></tr>
				   	<tr><th>备货配额是否按合同:</th><td><%= en.getIsContractRatio()==0?"否":"是"%></td></tr>
				   	<tr><th>配额类型:</th><td><%= en.getQuotaType()%></td></tr>
				   	<tr><th>备货配额:</th><td><%= en.getStockQuota()%></td></tr>
				   	<tr><th>配额说明:</th><td><%= en.getQuotaExplain()%></td></tr>
				   	<tr><th>包装方式:</th><td><%= en.getPackWay()%></td></tr>
				   	<tr><th>预计交货时间:</th><td><%= en.getDeliveryTime()==null?"":FormatUtil.formatDate(en.getDeliveryTime(), "yyyy-MM-dd") %></td></tr>
			   <%} %>
			 <tr class="yellow"><td colspan="2" >其他信息--备货申请表体</td></tr>
				<%
				int itemsSize = items.length;
				for(int i = 0; i < itemsSize; i++ ) {
					StockMaintainEntryDto en = items[i];
				%>
					<tr <%=i==0 ? "" : "class='topLine'" %>><th>序号:</th><td><%=i+1 %></td></tr>
				   	<tr><th>物品编码:</th><td><%= en.getMaterialNumber()%></td></tr>
				    <tr><th>物品名称:</th><td><%= en.getMaterialName()%></td></tr>
				   	<tr><th>物品类型:</th><td><%= en.getMaterialType()%></td></tr>
				   	<tr><th>物品规格:</th><td><%= en.getMaterialStandard()%></td></tr>
				   	<tr><th>计量单位:</th><td><%= en.getUnit()%></td></tr>
				   	<tr><th>预计备货量:</th><td><%= en.getStockAmount()%></td></tr>
				   	<tr><th>采购周期（天）:</th><td><%= en.getPeriod()%></td></tr>
				   	<tr><th>预计总金额:</th><td><%= en.getPredictAmount()%></td></tr>
				   	<tr><th>预计交货时间:</th><td><%=FormatUtil.formatDate(en.getPredictTime(), "yyyy-MM-dd") %></td></tr>
			   <%} %>
		  </table>
		  <%@include file="approve_process_esb.jsp" %>
		</div>
	</div>
	<%@include file="workflow_approve_button_esb.jsp" %>
</div>
<script type="text/javascript">

</script>
</body>
</html>