<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.WorkflowEntity"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.StockmaintainVo"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.StockMaintainHead"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.StockMaintainEntryDto"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.StockMedeDto"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
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
 WorkflowEntity info = (WorkflowEntity)request.getAttribute("lspResponseEntity");
 StockmaintainVo temp = info.getStockmaintainVo();
 StockMaintainHead base = temp.getStockMaintainHead();
 StockMaintainEntryDto[] items = temp.getStockMaintainEntryDtoList();
 StockMedeDto[] stockMedeDtoList = temp.getStockMedeDtoList();
 %>
<div id="list">
	<%@include file="/jsp/ios/work_items_head.jsp" %>
	<div id="div2">
		<h4 class="yellow">基本信息-备货维护单</h4>
    	<div class="ulBox2">
	    	<ul>				  
<%-- 			   	<li>单据状态:<em id="workid"><%=base.getBillState() %></em></li> --%>
	    		<li>备货维护单号:<em><%=base.getFnumber() %></em></li>
	    		<li>备货申请单号:<em><%=base.getStockBillNumber() %></em></li>
	    		<li>采购员:<em><%=base.getBuyerName()%></em></li>
	    		<li>申请人:<em><%=base.getApplyUser()%></em></li>
				<li>变更时间:<em><%=base.getBizDate() == null ? "" : base.getBizDate()%></em></li>
				
				<li>备货区域:<em><%=base.getStoreArea()%></em></li>
				<li>德邦库存:<em><%=base.getIsDpStock()==0?"否":"是"%></em></li>
				<li>库存组织:<em><%=base.getStockOrg()%></em></li>
				<li>需求汇总单:<em><%=base.getNeedsSummary()%></em></li>
				<li>备货类型:<em><%=base.getStockType()%></em></li>
			   	<li>仓库:<em><%=base.getWarehouse()%></em></li>
          	</ul>
        </div>
        <h4 class="yellow">其他信息--备货维护信息表体</h4>
	   	<div class="ulBox2">
    		<ul>
    		<%
				int stockMedeDtoListSize = stockMedeDtoList.length;
				for(int i = 0; i < stockMedeDtoListSize; i++ ) {
					StockMedeDto en = stockMedeDtoList[i];
				%>
					<li <%=i==0?"class='first'":"class='line'" %>>序号:<em><%=i+1 %></em></li>
				   	<li>物品编码:<em><%= en.getMaterialNumber()%></em></li>
				    <li>物品名称:<em><%= en.getMaterialName()%></em></li>
				   	<li>物品类型:<em><%= en.getMaterialType()%></em></li>
				   	<li>物品规格:<em><%= en.getMaterialStandard()%></em></li>
				   	<li>物料属性:<em><%= en.getMaterialAttId()%></em></li>
				   	<li>供应商编码:<em><%= en.getSupplierNumber()%></em></li>
				   	<li>供应商名称:<em><%= en.getSupplierName()%></em></li>
				   	<li>备货数量:<em><%= en.getStockAmount()%></em></li>
				   	<li>采购合同编号:<em><%= en.getContractNumber()%></em></li>
				   	<li>备货单价:<em><%= en.getStockPrice()%></em></li>
				   	<li>备货总金额:<em><%= en.getStockAmounts()%></em></li>
				   	<li>备货配额是否按合同:<em><%= en.getIsContractRatio()==0?"否":"是"%></em></li>
				   	<li>配额类型:<em><%= en.getQuotaType()%></em></li>
				   	<li>备货配额:<em><%= en.getStockQuota()%></em></li>
				   	<li>配额说明:<em><%= en.getQuotaExplain()%></em></li>
				   	<li>包装方式:<em><%= en.getPackWay()%></em></li>
				   	<li>预计交货时间:<em><%= en.getDeliveryTime()==null?"":FormatUtil.formatDate(en.getDeliveryTime(), "yyyy-MM-dd") %></em></li>
			   <%} %>
		   </ul>
	    </div>
	     <h4 class="yellow">其他信息--备货申请表体</h4>
	   	<div class="ulBox2">
    		<ul>
    		<%
				int itemsSize = items.length;
				for(int i = 0; i < itemsSize; i++ ) {
					StockMaintainEntryDto en = items[i];
				%>
					<li <%=i==0?"class='first'":"class='line'" %>>序号:<em><%=i+1 %></em></li>
				   	<li>物品编码:<em><%= en.getMaterialNumber()%></em></li>
				    <li>物品名称:<em><%= en.getMaterialName()%></em></li>
				   	<li>物品类型:<em><%= en.getMaterialType()%></em></li>
				   	<li>物品规格:<em><%= en.getMaterialStandard()%></em></li>
				   	<li>计量单位:<em><%= en.getUnit()%></em></li>
				   	<li>预计备货量:<em><%= en.getStockAmount()%></em></li>
				   	<li>采购周期（天）:<em><%= en.getPeriod()%></em></li>
				   	<li>预计总金额:<em><%= en.getPredictAmount()%></em></li>
				   	<li>预计交货时间:<em><%=FormatUtil.formatDate(en.getPredictTime(), "yyyy-MM-dd") %></em></li>
			   <%} %>
		   </ul>
	    </div>
	    <%@include file="approve_process_esb.jsp"%> 
	</div>
	 <%@include file="workflow_approve_button_esb.jsp" %>
</div>
</body>

</html>