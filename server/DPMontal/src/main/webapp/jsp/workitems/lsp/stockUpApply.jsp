<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.WorkflowEntity"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.StockApplybillVo"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.StockBillHeaderDto"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.StockBillEntryDto"%>
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
 StockApplybillVo temp = info.getStockApplybillVo();
 StockBillHeaderDto base = temp.getStockBillHeaderDto();
 StockBillEntryDto[] items = temp.getStockBillEntryDto();
 %>
<div id="list">
	<%@include file="../wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table>
	    		<tr><th colspan="2" class="yellow">基本信息</th></tr>
	    		<tr><th>工&nbsp;&nbsp;作&nbsp;&nbsp;流:</th><td>备货申请单</td></tr>
	    		<tr><th>备货申请单号:</th><td id="workid"><%=base.getFnumber() %></td></tr>
	    		<tr><th>申请人:</th><td><%=base.getApplier()%></td></tr>
				<tr><th>申请时间:</th><td><%=FormatUtil.formatDate( base.getBizDate(), "yyyy-MM-dd")%></td></tr>
				<tr><th >申请部门:</th><td><%=base.getApplyDepart()%></td></tr>
				
				<tr><th >备货类型:</th><td><%=base.getStockType()%></td></tr>
				<tr><th >备货区域:</th><td><%=base.getStockArea()%></td></tr>
			   	<tr><th >采购类型:</th><td><%=base.getBillPurType()%></td></tr>
			   	<tr><th >需求汇总单:</th><td><%=base.getNeedsSummaryNum()%></td></tr>
			   	<tr><th >库存组织:</th><td><%=base.getStockOrg()%></td></tr>
			   	<tr><th >德邦库存:</th><td><%=base.getIsDpStock()==0?"否":"是"%></td></tr>
			   	<tr><th >仓库:</th><td><%=base.getWarehouse()%></td></tr>

				<tr class="yellow"><td colspan="2" >其他信息</td></tr>
				<%
				int length1 = items.length;
				for(int i = 0; i < length1; i++ ) {
					StockBillEntryDto en = items[i];
				%>
					<tr <%=i==0 ? "" : "class='topLine'" %>><th>序号:</th><td><%=i+1 %></td></tr>
				   	<tr><th>物品编码:</th><td><%= en.getMaterialsFnumber()%></td></tr>
				    <tr><th>物品名称:</th><td><%= en.getMaterialsName()%></td></tr>
				   	<tr><th>物品类型:</th><td><%= en.getMaterialType()%></td></tr>
				   	<tr><th>物品规格:</th><td><%= en.getMaterialsStadarts()%></td></tr>
				   	<tr><th>采购类型:</th><td><%= en.getPurchaseType()%></td></tr>
				   	<tr><th>单价:</th><td><%= en.getPrice()%></td></tr>
				   	<tr><th>计量单位:</th><td><%= en.getUnit()%></td></tr>
				   	<tr><th>申请备货量:</th><td><%= en.getStockAccount()%></td></tr>
				   	<tr><th>预计总金额（元）:</th><td><%= en.getAccountMoney()%></td></tr>
				   	<tr><th>使用部门:</th><td><%= en.getDepartment()%></td></tr>
				   	<tr><th>采购周期（天）:</th><td><%= en.getPurchaseDate()%></td></tr>
				   	<tr><th>预计交货时间:</th><td><%= FormatUtil.formatDate(en.getChangeDate(), "yyyy-MM-dd")%></td></tr>
				   	<tr><th>采购员:</th><td><%= en.getPurchasemanName()%></td></tr>
				   	<tr><th>备货原因:</th><td><%= en.getStockReason()%></td></tr>
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