<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.WorkflowEntity"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.VehicleRenovateApplyVo"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.VehicleRenovateApplyEntity"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.TyreInformationEntity"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.VehicleAccessoriesEntity"%>
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
 VehicleRenovateApplyVo temp = info.getVehicleRenovateApplyVo();
 VehicleRenovateApplyEntity base = temp.getVehicleRenovateApply();
 List<TyreInformationEntity> items1 = temp.getTyreInformation();
 List<VehicleAccessoriesEntity> items2 = temp.getVehicleAccessories();
 %>
<div id="list">
	<%@include file="../wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table>
	    		<tr><th colspan="2" class="yellow">基本信息</th></tr>
	    		<tr><th>工&nbsp;&nbsp;作&nbsp;&nbsp;流:</th><td>车辆更新申请单</td></tr>
	    		<tr><th>单据编号:</th><td id="workid"><%=base.getFnumber()%></td></tr>
				<tr><th>车牌号:</th><td><%=base.getPlateNumber()%></td></tr>
				<tr><th>资产所属子公司:</th><td><%=base.getAffiliationCompany()%></td></tr>
				<tr><th>所属办公室:</th><td><%=base.getAffiliationOffice()%></td></tr>
				<tr><th>车型:</th><td><%=base.getVehicleType()%></td></tr>
			   	<tr><th>固定资产编码:</th><td><%=base.getFixedAssets()%></td></tr>
			   	<tr><th>车辆品牌:</th><td><%=base.getVehicleBrand()%></td></tr>
			   	<tr><th>吨位:</th><td><%=base.getTonnage()%></td></tr>
			   	<tr><th>开始使用日期:</th><td><%=base.getStarteUseTimeStr()%></td></tr>
			   	<tr><th>申请部门:</th><td><%=base.getProductDepartment()%></td></tr>
			   	<tr><th>判定结果:</th><td><%=base.getResult()%></td></tr>
			   	<tr><th>使用部门所属子公司:</th><td><%=base.getUsingFinance()%></td></tr>
			    <tr><th>申请事由:</th><td><%=base.getDescription()%></td></tr>

				<tr class="yellow"><td colspan="2" >其他信息-轮胎信息</td></tr>
				<%for(int i = 0; i < items1.size() ; i++ ) {
					TyreInformationEntity obj1 = items1.get(i);
				%>
					<tr <%=i==0 ? "" : "class='topLine'" %>><th>序号:</th><td><%=i+1 %></td></tr>
				   	<tr><th>轮胎胎号:</th><td><%= obj1.getTireNO()%></td></tr>
				    <tr><th>轮胎位置:</th><td><%= obj1.getLocation()%></td></tr>
				   	<tr><th>公里数:</th><td><%= obj1.getEvenNumberStr()%></td></tr>
				    <tr><th>是否变卖:</th><td><%= obj1.getIsSellStr()%></td></tr>
			   <%} %>
			   <tr class="yellow"><td colspan="2" >其他信息-车辆附件</td></tr>
				<%for(int i = 0; i < items2.size(); i++ ) {
					VehicleAccessoriesEntity obj2 = items2.get(i);
				%>
					<tr <%=i==0 ? "" : "class='topLine'" %>><th>序号:</th><td><%=i+1 %></td></tr>
				   	<tr><th>车辆附件:</th><td><%= obj2.getVehicleAccessory()%></td></tr>
				    <tr><th>是否变卖:</th><td><%= obj2.getIsSellStr()%></td></tr>
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