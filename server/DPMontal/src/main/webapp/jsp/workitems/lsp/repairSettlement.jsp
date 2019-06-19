<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain.ProjectRepairVo"%>
<%@page import="com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain.RepairSettlementEntity"%>
<%@page import="com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain.RepairSettlementEntryEntity"%>
<%@page import="java.util.List"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_win8.jsp" %>
	<style type="text/css">
		.otherInfo{
			display:none;
		}
	</style>
</head>
<body>
 <%
	//维修结算单
	ProjectRepairVo info = (ProjectRepairVo)request.getAttribute("lspResponseEntity");
	//维修结算单表头信息
	RepairSettlementEntity repairSettlementEntity = info.getRepairSettlementEntity();
	//维修结算单分录实体
	List<RepairSettlementEntryEntity>  repairSettlementEntryEntities = info.getRepairSettlementEntryEntities();

 %>
<div id="list">
	<%@include file="../wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table>
	    		<tr><th colspan="2" class="yellow">基本信息</th></tr>
	    		<tr><th>工&nbsp;&nbsp;作&nbsp;&nbsp;流:</th><td>维修结算单</td></tr>
				<tr><th>单据编号:</th><td><%=repairSettlementEntity.getFnumber()%></td></tr>
				<tr><th>创建人:</th><td><%=repairSettlementEntity.getFcreatorID()%></td></tr>
				<tr><th>创建时间:</th><td><%=FormatUtil.formatDate(repairSettlementEntity.getFcreateTime())%></td></tr>
				<tr><th>创建部门:</th><td><%=repairSettlementEntity.getCfCreateDepID()%></td></tr>
				<tr><th>结算日期:</th><td><%=FormatUtil.formatDate(repairSettlementEntity.getCfClearMonth())%></td></tr>
				<tr><th>结算总计:</th><td><%=FormatUtil.formatDouble("###,###,###.00",repairSettlementEntity.getCfClearTotalDto())%></td></tr>
				<tr><th>维修供应商:</th><td><%=repairSettlementEntity.getCfRepairSupplierID()%></td></tr>
			    
				<tr class="yellow" id="otherInfo1Open" onclick="otherInfoOpen(1);"><td colspan="2">其他信息-明细信息</td></tr>
				
					<%//List<RepairSettlementEntryEntity>  repairSettlementEntryEntities
					int entrysSize = repairSettlementEntryEntities == null ? 0:repairSettlementEntryEntities.size();
					for(int i = 0; i < entrysSize ; i++ ) {
						RepairSettlementEntryEntity obj1 = repairSettlementEntryEntities.get(i);
					%>
						<tr <%=i==0 ? "class='otherInfo tab1'" : "class='topLine otherInfo tab1'" %>><th>序号:</th><td><%=i+1 %></td></tr>
					   	<tr class="otherInfo tab1"><th>维修记录单编号:</th><td><%= obj1.getCfRepairRecordNum()%></td></tr>
					    <tr class="otherInfo tab1"><th>维修申请/计划单编号:</th><td><%= obj1.getCfRepairApplyNum()%></td></tr>
					   	<tr class="otherInfo tab1"><th>被服务部门:</th><td><%= obj1.getCfByServiceDepID()%></td></tr>
					    <tr class="otherInfo tab1"><th>所属大区:</th><td><%= obj1.getCfBelongsAreaID()%></td></tr>
					    <tr class="otherInfo tab1"><th>发票抬头:</th><td><%= obj1.getCfInvoiceTitleID()%></td></tr>
					    <tr class="otherInfo tab1"><th>维修事项:</th><td><%= obj1.getCfMaintenanceMatte()%></td></tr>
					    <tr class="otherInfo tab1"><th>维修开始日期:</th><td><%= FormatUtil.formatDate(obj1.getCfDateStartRepair())%></td></tr>
					    <tr class="otherInfo tab1"><th>维修完成日期:</th><td><%= FormatUtil.formatDate(obj1.getCfDateComRepair())%></td></tr>
					    <tr class="otherInfo tab1"><th>结算总额:</th><td><%= FormatUtil.formatDouble("###,###,###.00",obj1.getCfTotalAmountDto())%></td></tr>
					    <tr class="otherInfo tab1"><th>是否预提:</th><td><%= obj1.getCfIfProvision()%></td></tr>
					    <tr class="otherInfo tab1"><th>安排人:</th><td><%= obj1.getCfArrangerID()%></td></tr>
					    <tr class="otherInfo tab1"><th>费用承担部门:</th><td><%= obj1.getCfFeeAssumeDeptID()%></td></tr>
				   <%} %>
				   <tr class="yellow" style="display: none" id="otherInfo1Close" onclick="otherInfoClose(1);"><td colspan="2">关闭信息-明细信息</td></tr>
		  </table>
			<%@include file="approve_process_esb3.jsp" %>
		</div>
	</div>
	<%@include file="workflow_approve_button_esb2.jsp" %>
</div>
<script type="text/javascript">
function otherInfoClose(obj){
	$(".otherInfo.tab"+obj).slideUp(200);
	$("#otherInfo"+obj+"Close").slideUp(200);
}
function otherInfoOpen(obj){
	$(".otherInfo.tab"+obj).slideDown(200);
	$("#otherInfo"+obj+"Close").slideDown(200);
}
</script>
</body>
</html>