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
	<%@include file="/common_ios.jsp" %>
</head>
<body>
 <%
 WorkflowEntity info = (WorkflowEntity)request.getAttribute("lspResponseEntity");
 StockApplybillVo temp = info.getStockApplybillVo();
 StockBillHeaderDto base = temp.getStockBillHeaderDto();
 StockBillEntryDto[] items = temp.getStockBillEntryDto();
 %>
<div id="list">
	<%@include file="/jsp/ios/work_items_head.jsp" %>
	<div id="div2">
		<h4 class="yellow">基本信息-备货申请单</h4>
    	<div class="ulBox2">
	    	<ul>				  
	    		<li>备货申请单号:<em id="workid"><%=base.getFnumber() %></em></li>
	    		<li>申请人:<em><%=base.getApplier()%></em></li>
				<li>申请时间:<em><%=FormatUtil.formatDate( base.getBizDate(), "yyyy-MM-dd")%></em></li>
				<li>申请部门:<em><%=base.getApplyDepart()%></em></li>
				
				<li>备货类型:<em><%=base.getStockType()%></em></li>
				<li>备货区域:<em><%=base.getStockArea()%></em></li>
			   	<li>采购类型:<em><%=base.getBillPurType()%></em></li>
			   	<li>需求汇总单:<em><%=base.getNeedsSummaryNum()%></em></li>
			   	<li>库存组织:<em><%=base.getStockOrg()%></em></li>
			   	<li>德邦库存:<em><%=base.getIsDpStock()==0?"否":"是"%></em></li>
			   	<li>仓库:<em><%=base.getWarehouse()%></em></li>
          	</ul>
        </div>
        <h4 class="yellow">其他信息</h4>
	   	<div class="ulBox2">
    		<ul>
				<%
				int length1 = items.length;
				for(int i = 0; i < length1; i++ ) {
					StockBillEntryDto en = items[i];
				%>
					<li <%=i==0?"class='first'":"class='line'" %>>序号:<em><%=i+1 %></em></li>
				   	<li>物品编码:<em><%= en.getMaterialsFnumber()%></em></li>
				    <li>物品名称:<em><%= en.getMaterialsName()%></em></li>
				   	<li>物品类型:<em><%= en.getMaterialType()%></em></li>
				   	<li>物品规格:<em><%= en.getMaterialsStadarts()%></em></li>
				   	<li>采购类型:<em><%= en.getPurchaseType()%></em></li>
				   	<li>单价:<em><%= en.getPrice()%></em></li>
				   	<li>计量单位:<em><%= en.getUnit()%></em></li>
				   	<li>申请备货量:<em><%= en.getStockAccount()%></em></li>
				   	<li>预计总金额（元）:<em><%= en.getAccountMoney()%></em></li>
				   	<li>使用部门:<em><%= en.getDepartment()%></em></li>
				   	<li>采购周期（天）:<em><%= en.getPurchaseDate()%></em></li>
				   	<li>预计交货时间:<em><%= FormatUtil.formatDate(en.getChangeDate(), "yyyy-MM-dd")%></em></li>
				   	<li>采购员:<em><%= en.getPurchasemanName()%></em></li>
				   	<li>备货原因:<em><%= en.getStockReason()%></em></li>
			   <%} %>
		   </ul>
	    </div>
	    <%@include file="approve_process_esb.jsp"%> 
	</div>
	 <%@include file="workflow_approve_button_esb.jsp" %>
</div>
</body>

</html>