<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.WorkflowEntity"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.VehicleapplyVo"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.SonApplicationNeedsVo"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.SonAneVehicleVo"%>
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
 VehicleapplyVo  entity2 = info.getVehicleapplyvoList();//车辆申请工作流对外实体
 SonApplicationNeedsVo base = entity2.getSonApplicationNeeds();//车辆申请的表头实体
 SonAneVehicleVo[] items = entity2.getSonAneVehicleVoList();//分录表实体
 String carType = base.getCfcarTypeStr();//车辆类型字符串
 %>
<div id="list">
	<%@include file="../wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table>
	    		<tr><th colspan="2" class="yellow">基本信息</th></tr>
	    		<tr><th>工&nbsp;&nbsp;作&nbsp;&nbsp;流:</th><td>车辆申请单-<%=carType %></td></tr>
	    		<tr><th>单据编号:</th><td id="workid"><%=base.getFnumber() %></td></tr>
				<tr><th>所属子公司:</th><td><%=base.getCfsubOrdSubsiDiaryAsName()==null?"":base.getCfsubOrdSubsiDiaryAsName()%></td></tr>
				<tr><th>申请时间:</th><td><%=base.getFcreateTimeStr()%></td></tr>
				<tr><th>申请人:</th><td><%=base.getCfapplicantIdAsName()%></td></tr>
				<tr><th>申请部门:</th><td><%=base.getCfapplicantdepsIdAsName()%></td></tr>
			   	<tr><th>预算承担部门:</th><td><%=base.getFcostCenterIdAsName()%></td></tr>
			   	<tr><th>库存组织:</th><td><%=base.getCfwarehousezzIdAsName()%></td></tr>
			   	<tr><th>采购组织:</th><td><%=base.getCfpurOrderUnitIdAsName()%></td></tr>
			   	<tr><th>车辆类型:</th><td><%=base.getCfcarTypeStr()%></td></tr>
			   	<tr><th>配车部门类型:</th><td><%=base.getCfcarDepartmTypeStr()%></td></tr>
			   	<tr><th>申请总金额:</th><td id="formateID2_1"><%=base.getCftotalApplyAmount()%></td></tr>
			   	<tr><th>备注:</th><td><%=base.getCfremake()==null?"":base.getCfremake()%></td></tr>
			    <tr><th>是否计划外采购:</th><td><%=base.getFisPurStr()%></td></tr>

				<tr class="yellow"><td colspan="2" >其他信息-<%=carType %></td></tr>
				<%for(int i = 0; i < items.length; i++ ) {%>
					<tr <%=i==0 ? "" : "class='topLine'" %>><th>序号:</th><td><%=i+1 %></td></tr>
				   	<tr><th>预算项目:</th><td><%= items[i].getFprojectBudgetIdAsName()==null?"":items[i].getFprojectBudgetIdAsName()%></td></tr>
				    <tr><th>物品编码:</th><td><%= items[i].getCfmaterialNumIdFnumberAsName()==null?"":items[i].getCfmaterialNumIdFnumberAsName()%></td></tr>
				   	<tr><th>物品名称:</th><td><%= items[i].getCfmaterialName()==null?"":items[i].getCfmaterialName()%></td></tr>
				   	<%if ("商务车".equals(carType)) {%>
				    	<tr><th>规格型号:</th><td><%= items[i].getCfspecifications()==null?"":items[i].getCfspecifications()%></td></tr>
				   	<%} %>
				    <tr><th>单位:</th><td><%= items[i].getCfunitIdAsName()==null?"":items[i].getCfunitIdAsName()%></td></tr>
				    <tr><th>物料属性:</th><td><%= items[i].getFmaterialMentIdAsName()==null?"":items[i].getFmaterialMentIdAsName()%></td></tr>
				    <tr><th>数量:</th><td><%= items[i].getCfquantity()==null?"":items[i].getCfquantity()%></td></tr>
				   	<%if ("营运车".equals(carType)) {%>
				   		<tr><th>未签收数量:</th><td><%= items[i].getCfsignAmount()==null?"":items[i].getCfsignAmount()%></td></tr>
				    <%} %>
				    <tr><th>参考单价:</th><td id="formateID3_1"><%= items[i].getCfreferencePrice()==null?"":items[i].getCfreferencePrice()%></td></tr>
				    <tr><th>参考金额:</th><td id="formateID2_2"><%= items[i].getCfreferenceAmount()==null?"":items[i].getCfreferenceAmount()%></td></tr>
				    <tr><th>所属事业部:</th><td><%= items[i].getCfsubordinateDivisAsName()==null?"":items[i].getCfsubordinateDivisAsName()%></td></tr>
					<%if ("商务车".equals(carType)) {%>    
					    <tr><th>上牌和贷款公司:</th><td><%= items[i].getCfregistrationLoanAsName()==null?"":items[i].getCfregistrationLoanAsName()%></td></tr>
					<%} %>
				   	<%if ("营运车".equals(carType)) {%>
					    <tr><th>上牌子公司:</th><td><%= items[i].getCfregistrationLoanAsName()==null?"":items[i].getCfregistrationLoanAsName()%></td></tr>
					    <tr><th>牌照类型:</th><td><%= items[i].getCflicenceTypeStr()%></td></tr>
					    <tr><th>车型:</th><td><%= items[i].getCfcarModel()==null?"":items[i].getCfcarModel()%></td></tr>
					    <tr><th>需到位日期:</th><td><%= items[i].getCfshouldPlaceStr()==null?"":items[i].getCfshouldPlaceStr()%></td></tr>
					    <tr><th>车队联系人:</th><td><%= items[i].getCfteamcontactIdAsName()==null?"":items[i].getCfteamcontactIdAsName()%></td></tr>
					    <tr><th>车队联系方式:</th><td><%= items[i].getCfcontact()==null?"":items[i].getCfcontact()%></td></tr>
					    <tr><th>安全员联系人:</th><td><%= items[i].getCfsecurityContactiAsName()==null?"":items[i].getCfsecurityContactiAsName()%></td></tr>
					    <tr><th>安全员联系方式:</th><td><%= items[i].getCfrelationMethod()==null?"":items[i].getCfrelationMethod()%></td></tr>
					    <tr><th>备注:</th><td><%= items[i].getCfremake()==null?"":items[i].getCfremake()%></td></tr>
				    <%} %>
				    <tr><th>出库数量:</th><td><%= items[i].getCfexportNumber()==null?"":items[i].getCfexportNumber()%></td></tr>
				    <tr><th>使用部门:</th><td><%= items[i].getCfuseDepartmentIdAsName()==null?"":items[i].getCfuseDepartmentIdAsName()%></td></tr>
				   	<%if ("商务车".equals(carType)) {%>    
				    	<tr><th>未签收数量:</th><td><%= items[i].getCfsignAmount()==null?"":items[i].getCfsignAmount()%></td></tr>
				    <%} %>
				   	<%if ("营运车".equals(carType)) {%>
				    	<tr><th>申请事由:</th><td><%= items[i].getCfapplyReasons()==null?"":items[i].getCfapplyReasons()%></td></tr>
				    <%} %>
			   <%} %>
		  </table>
		  <%@include file="approve_process_esb.jsp" %>
		</div>
	</div>
	<%@include file="workflow_approve_button_esb.jsp" %>
</div>
<script type="text/javascript">
	function formatNum(num,n)
	{//参数说明：num 要格式化的数字 n 保留小数位
		num = new Number(num+"");
	    num = String(num.toFixed(n));
	    var re = /(-?\d+)(\d{3})/;
	    while(re.test(num)) num = num.replace(re,"$1,$2");
	    return num;
	}
	$(function() {
		$("#formateID2_1").text(formatNum($("#formateID2_1").text(),2));
		$("#formateID2_2").text(formatNum($("#formateID2_2").text(),2));
		$("#formateID3_1").text(formatNum($("#formateID3_1").text(),3));
	});
</script>
</body>
</html>