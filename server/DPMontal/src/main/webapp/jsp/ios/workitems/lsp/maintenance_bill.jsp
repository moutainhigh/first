<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
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
	<%@include file="/common_ios.jsp" %>
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
	<%@include file="/jsp/ios/work_items_head.jsp" %>
	<div id="div2">
		<h4 class="yellow">基本信息</h4>
    	<div class="ulBox2">
	    	<ul>				  
				<li>工&nbsp;作&nbsp;流:<em>维修保养单</em></li>
	    		<li>单据编号:<em><%=base.getFnumber()%></em></li>
				<li>保养计划单:<em><%=base.getCfMaintenancePlotI()%></em></li>
				<li>车牌号:<em><%=base.getCfCarNumberID()%></em></li>
				<li>维保对象:<em><%=base.getCfObjectName()%></em></li>
				<li>固定资产卡片:<em><%=base.getCfAssetsIdID()%></em></li>
			   	<li>车辆用途:<em><%=base.getCfVehicleUse()%></em></li>
			   	<li>车辆品牌:<em><%=base.getCfVehicleBrand()%></em></li>
			   	<li>车型:<em><%=base.getCfVehicleType()%></em></li>
			   	<li>当前公里数:<em><%=base.getCfCurrencyKM()%></em></li>
			   	<li>维保类别:<em><%=base.getCfMtCategory()%></em></li>
			   	<li>管理部门:<em><%=base.getCfMgmtDeptID()%></em></li>
			   	<li>开始使用日期:<em><%=useStr%></em></li>
			    <li>维保单位:<em><%=base.getCfMtUnitID()%></em></li>
			    <li>司机:<em><%=base.getCfDriverID()%></em></li>
			    <li>保养:<em><%=base.getCfIsMaintenance()==0?"否":"是"%></em></li>
			    <li>报修部门:<em><%=base.getCfMtContentID()%></em></li>
			    <li>报修人:<em><%=base.getCfRepairID()%></em></li>
			    <li>报修时间:<em><%=repairsStr%></em></li>
			    <li>维修内容:<em><%=base.getCfcontent()%></em></li>
			    <li>维保类型:<em><%=base.getCfMtType()%></em></li>
			    <li>事故单编码:<em><%=base.getCfCarAccidentID()%></em></li>
			    <li>维保开始日期:<em><%=startStr%></em></li>
			    <li>维保结束日期:<em><%=endStr%></em></li>
			    <li>维修厂商:<em><%=base.getCfMtFactoryID()%></em></li>
			    <li>维修厂商电话:<em><%=base.getCfMtTel()%></em></li>
			    <li>维修预计金额:<em><%=base.getCfAmount()%></em></li>
			    <li>材料费用合计:<em><%=base.getCfMaterialCostTotal()%></em></li>
			    <li>工时费用合计:<em><%=base.getCfWorkTimeCostTotal()%></em></li>
			    <li>费用合计:<em><%=base.getCfMtCostTotal()%></em></li>
			    <li>费用承担部门:<em><%=base.getCffeeOwnerDept()%></em></li>
			    <li>是否合作供应商:<em><%="1".equals(base.getCfcooperation().toString())?"是":"否"%></em></li>
			    <li>是否供应商结算:<em><%="1".equals(base.getCfIsSupPay().toString())?"是":"否"%></em></li>
          	</ul>
        </div>
        
        <%if("内修".equals(base.getCfMtType())) { %>
       	    <!-- 内修 -->
        	<h4 class="yellow">内修</h4>
		   	<div class="ulBox2">
	    		<ul>
				   <%for(int i = 0; i < items1.length; i++ ) {%>
						<li>序号:<em><%=i+1%></em></li>
					   	<li>维保项目:<em><%= items1[i].getCfMaintainIdID()%></em></li>
					    <li>轮胎:<em><%= items1[i].getFcarTireID()%></em></li>
					   	<li>车体附件:<em><%= items1[i].getCfCarAccessoryID()%></em></li>
					    <li>报修内容:<em><%= items1[i].getCfRepairs()%></em></li>
					    <li>维修内容:<em><%= items1[i].getCfMtContent()%></em></li>
					    <li>工时费:<em><%= items1[i].getCfWorkTimeCost()%></em></li>
					    <li>修理工:<em><%= items1[i].getCfMechanic()%></em></li>
				   <%} %>
			   </ul>
		    </div>
		    <h4 class="yellow">物品明细</h4>
		   	<div class="ulBox2">
	    		<ul>
				  <%for(int i = 0; i < lentry.length; i++ ) {%>
						<li>序号:<em><%=i+1%></em></li>
					   	<li>物料编码:<em><%= lentry[i].getCfMaterialReqNumber()%></em></li>
					    <li>物料名称:<em><%= lentry[i].getCfMaterialName()%></em></li>
					   	<li>规格型号:<em><%= lentry[i].getCfNorms()%></em></li>
					   	<li>计量单位:<em><%= lentry[i].getCfPrickle()%></em></li>
					    <li>数量:<em><%= lentry[i].getCfNumbers()%></em></li>
					   	<li>单价:<em><%= lentry[i].getCfPrice()%></em></li>
					   	<li>物品总费用:<em><%= lentry[i].getCfClCountCost()%></em></li>
				   <%} %>
			   </ul>
		    </div>
        <%} else { %>
        	<h4 class="yellow">外修</h4>
		   	<div class="ulBox2">
	    		<ul>
				   <%for(int i = 0; i < items2.length; i++ ) {%>
						<li>序号:<em><%=i+1%></em></li>
					   	<li>维保项目:<em><%= items2[i].getCfMaintainPorject()%></em></li>
					    <li>轮胎:<em><%= items2[i].getFcarTireID()%></em></li>
					   	<li>车体附件:<em><%= items2[i].getCfCarAccessoryID()%></em></li>
					    <li>工时费:<em><%= items2[i].getCfWorkTimeCost()%></em></li>
					    <li>备注:<em><%= items2[i].getCfNote()%></em></li>
				   <%} %>
			   </ul>
		    </div>
		    <h4 class="yellow">物品明细</h4>
		   	<div class="ulBox2">
	    		<ul>
				  <%for(int i = 0; i < wentry.length; i++ ) {%>
						<li>序号:<em><%=i+1%></em></li>
					   	<li>物料名称:<em><%= wentry[i].getCfMaterialName()%></em></li>
					    <li>规格型号:<em><%= wentry[i].getCfNorms()%></em></li>
					   	<li>计量单位:<em><%= wentry[i].getCfUnitID()%></em></li>
					   	<li>数量:<em><%= wentry[i].getCfNumbers()%></em></li>
					    <li>单价:<em><%= wentry[i].getCfPrice()%></em></li>
					   	<li>物品总费用:<em><%= wentry[i].getCfClCountCost()%></em></li>
				   <%} %>
			   </ul>
		    </div>
        <%} %>
        
	    <%@include file="approve_process_esb.jsp"%> 
	</div>
	 <%@include file="workflow_approve_button_esb.jsp" %>
</div>
</body>

</html>