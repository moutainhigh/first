<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.WorkflowEntity"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.MaintenancebillVo"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.MaintenanceEntity"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.MaintenanceIREntity"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.MaintenanceMatthewWilderEntity"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.MaintenanceEntryLEntity"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.MaintenanceEntryWEntity"%>
<%@page import="java.util.List"%>
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
 MaintenancebillVo temp = info.getMaintenancebillVo();
 MaintenanceEntity base = temp.getMaintenanceEntity();
 MaintenanceIREntity[] items1 = temp.getMaintenanceIREntity();
 MaintenanceMatthewWilderEntity[] items2 = temp.getMaintenanceMatthewWilderList();
 MaintenanceEntryLEntity[] lentry = temp.getMaintenanceEntryLList();
 MaintenanceEntryWEntity[] wentry = temp.getMaintenanceEntryWList();
 
 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
 Date useDate = base.getCfStratDate();
 String useStr = sdf.format(useDate);
 Date repairsDate = base.getCfrepairsTime();
 String repairsStr = sdf.format(repairsDate);
 Date startDate = base.getCfMtStartDate();
 String startStr = sdf.format(startDate);
 Date endDate = base.getCfMtEndDate();
 String endStr = sdf.format(endDate);
 %>
<div id="list">
	<%@include file="../wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table>
	    		<tr><th colspan="2" class="yellow">基本信息</th></tr>
	    		<tr><th>工&nbsp;作&nbsp;流:</th><td>维修保养单</td></tr>
	    		<tr><th>单据编号:</th><td><%=base.getFnumber()%></td></tr>
				<tr><th>保养计划单:</th><td><%=base.getCfMaintenancePlotI()%></td></tr>
				<tr><th>车牌号:</th><td><%=base.getCfCarNumberID()%></td></tr>
				<tr><th>维保对象:</th><td><%=base.getCfObjectName()%></td></tr>
				<tr><th>固定资产卡片:</th><td><%=base.getCfAssetsIdID()%></td></tr>
			   	<tr><th>车辆用途:</th><td><%=base.getCfVehicleUse()%></td></tr>
			   	<tr><th>车辆品牌:</th><td><%=base.getCfVehicleBrand()%></td></tr>
			   	<tr><th>车型:</th><td><%=base.getCfVehicleType()%></td></tr>
			   	<tr><th>当前公里数:</th><td><%=base.getCfCurrencyKM()%></td></tr>
			   	<tr><th>维保类别:</th><td><%=base.getCfMtCategory()%></td></tr>
			   	<tr><th>管理部门:</th><td><%=base.getCfMgmtDeptID()%></td></tr>
			   	<tr><th>开始使用日期:</th><td><%=useStr%></td></tr>
			    <tr><th>维保单位:</th><td><%=base.getCfMtUnitID()%></td></tr>
			    <tr><th>司机:</th><td><%=base.getCfDriverID()%></td></tr>
			    <tr><th>保养:</th><td><%=base.getCfIsMaintenance()==0?"否":"是"%></td></tr>
			    <tr><th>报修部门:</th><td><%=base.getCfMtContentID()%></td></tr>
			    <tr><th>报修人:</th><td><%=base.getCfRepairID()%></td></tr>
			    <tr><th>报修时间:</th><td><%=repairsStr%></td></tr>
			    <tr><th>维修内容:</th><td><%=base.getCfcontent()%></td></tr>
			    <tr><th>维保类型:</th><td><%=base.getCfMtType()%></td></tr>
			    <tr><th>事故单编码:</th><td><%=base.getCfCarAccidentID()%></td></tr>
			    <tr><th>维保开始日期:</th><td><%=startStr%></td></tr>
			    <tr><th>维保结束日期:</th><td><%=endStr%></td></tr>
			    <tr><th>维修厂商:</th><td><%=base.getCfMtFactoryID()%></td></tr>
			    <tr><th>维修厂商电话:</th><td><%=base.getCfMtTel()%></td></tr>
			    <tr><th>维修预计金额:</th><td><%=base.getCfAmount()%></td></tr>
			    <tr><th>材料费用合计:</th><td><%=base.getCfMaterialCostTotal()%></td></tr>
			    <tr><th>工时费用合计:</th><td><%=base.getCfWorkTimeCostTotal()%></td></tr>
			    <tr><th>费用合计:</th><td><%=base.getCfMtCostTotal()%></td></tr>
			    <tr><th>费用承担部门:</th><td><%=base.getCffeeOwnerDept()%></td></tr>
			    <tr><th>是否合作供应商:</th><td><%="1".equals(base.getCfcooperation().toString())?"是":"否"%></td></tr>
			    <tr><th>是否供应商结算:</th><td><%="1".equals(base.getCfIsSupPay().toString())?"是":"否"%></td></tr>

				<%if("内修".equals(base.getCfMtType())) { %> 
					<!-- 内修 -->
					<tr class="yellow"><td colspan="2">内修</td></tr>
					<%for(int i = 0; i < items1.length; i++ ) {%>
						<tr><th>序号:</th><td><%=i+1%></td></tr>
					   	<tr><th>维保项目:</th><td><%= items1[i].getCfMaintainIdID()%></td></tr>
					    <tr><th>轮胎:</th><td><%= items1[i].getFcarTireID()%></td></tr>
					   	<tr><th>车体附件:</th><td><%= items1[i].getCfCarAccessoryID()%></td></tr>
					    <tr><th>报修内容:</th><td><%= items1[i].getCfRepairs()%></td></tr>
					    <tr><th>维修内容:</th><td><%= items1[i].getCfMtContent()%></td></tr>
					    <tr><th>工时费:</th><td><%= items1[i].getCfWorkTimeCost()%></td></tr>
					    <tr><th>修理工:</th><td><%= items1[i].getCfMechanic()%></td></tr>
				   <%} %>
				   <tr class="yellow" ><td colspan="2" >物品明细</td></tr>
					<%for(int i = 0; i < lentry.length; i++ ) {%>
						<tr><th>序号:</th><td><%=i+1%></td></tr>
					   	<tr><th>物料编码:</th><td><%= lentry[i].getCfMaterialReqNumber()%></td></tr>
					    <tr><th>物料名称:</th><td><%= lentry[i].getCfMaterialName()%></td></tr>
					   	<tr><th>规格型号:</th><td><%= lentry[i].getCfNorms()%></td></tr>
					   	<tr><th>计量单位:</th><td><%= lentry[i].getCfPrickle()%></td></tr>
					    <tr><th>数量:</th><td><%= lentry[i].getCfNumbers()%></td></tr>
					   	<tr><th>单价:</th><td><%= lentry[i].getCfPrice()%></td></tr>
					   	<tr><th>物品总费用:</th><td><%= lentry[i].getCfClCountCost()%></td></tr>
				   <%} %>
				<%} else {%>
					<tr class="yellow"  ><td colspan="2">外修</td></tr>
					<%for(int i = 0; i < items2.length; i++ ) {%>
						<tr><th>序号:</th><td><%=i+1%></td></tr>
					   	<tr><th>维保项目:</th><td><%= items2[i].getCfMaintainPorject()%></td></tr>
					    <tr><th>轮胎:</th><td><%= items2[i].getFcarTireID()%></td></tr>
					   	<tr><th>车体附件:</th><td><%= items2[i].getCfCarAccessoryID()%></td></tr>
					    <tr><th>工时费:</th><td><%= items2[i].getCfWorkTimeCost()%></td></tr>
					    <tr><th>备注:</th><td><%= items2[i].getCfNote()%></td></tr>
				   <%} %>
				   <tr class="yellow" ><td colspan="2" >物品明细</td></tr>
					<%for(int i = 0; i < wentry.length; i++ ) {%>
						<tr><th>序号:</th><td><%=i+1%></td></tr>
					   	<tr><th>物料名称:</th><td><%= wentry[i].getCfMaterialName()%></td></tr>
					    <tr><th>规格型号:</th><td><%= wentry[i].getCfNorms()%></td></tr>
					   	<tr><th>计量单位:</th><td><%= wentry[i].getCfUnitID()%></td></tr>
					   	<tr><th>数量:</th><td><%= wentry[i].getCfNumbers()%></td></tr>
					    <tr><th>单价:</th><td><%= wentry[i].getCfPrice()%></td></tr>
					   	<tr><th>物品总费用:</th><td><%= wentry[i].getCfClCountCost()%></td></tr>
				   <%} %>
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