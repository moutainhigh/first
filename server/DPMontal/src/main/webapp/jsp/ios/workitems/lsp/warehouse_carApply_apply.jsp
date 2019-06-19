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
	<%@include file="/common_ios.jsp" %>
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
	<%@include file="/jsp/ios/work_items_head.jsp" %>
	<div id="div2">
		<h4 class="yellow">基本信息</h4>
    	<div class="ulBox2">
	    	<ul>				  
				<li>工&nbsp;&nbsp;作&nbsp;&nbsp;流:<em>车辆申请单-<%=carType %></em></li>
	    		<li>单据编号:<em><%=base.getFnumber() %></em></li>
				<li>所属子公司:<em><%=base.getCfsubOrdSubsiDiaryAsName()%></em></li>
				<li>申请时间:<em><%=base.getFcreateTimeStr()%></em></li>
				<li>申请人:<em><%=base.getCfapplicantIdAsName()%></em></li>
				<li>申请部门:<em><%=base.getCfapplicantdepsIdAsName()%></em></li>
			   	<li>预算承担部门:<em><%=base.getFcostCenterIdAsName()%></em></li>
			   	<li>库存组织:<em><%=base.getCfwarehousezzIdAsName()%></em></li>
			   	<li>采购组织:<em><%=base.getCfpurOrderUnitIdAsName()%></em></li>
			   	<li>车辆类型:<em><%=base.getCfcarTypeStr()%></em></li>
			   	<li>配车部门类型:<em><%=base.getCfcarDepartmTypeStr()%></em></li>
			   	<li>申请总金额:<em id="formateID2_1"><%=base.getCftotalApplyAmount()%></em></li>
			   	<li>备注:<em><%=base.getCfremake()==null?"":base.getCfremake()%></em></li>
			    <li>是否计划外采购:<em><%=base.getFisPurStr()%></em></li>
          	</ul>
        </div>
        <h4 class="yellow">其他信息--<%=carType %></h4>
	   	<div class="ulBox2">
    		<ul>
    			<%for(int i = 0; i < items.length; i++ ) {%>
					<li   <%=i==0?"class='first'":"class='line'" %> >序号:<em><%=i+1 %></em></li>
				   	<li>预算项目:<em><%= items[i].getFprojectBudgetIdAsName()==null?"":items[i].getFprojectBudgetIdAsName()%></em></li>
				    <li>物品编码:<em><%= items[i].getCfmaterialNumIdFnumberAsName()==null?"":items[i].getCfmaterialNumIdFnumberAsName()%></em></li>
				   	<li>物品名称:<em><%= items[i].getCfmaterialName()==null?"":items[i].getCfmaterialName()%></em></li>
				   	<%if ("商务车".equals(carType)) {%>
				    	<li>规格型号:<em><%= items[i].getCfspecifications()==null?"":items[i].getCfspecifications()%></em></li>
				   	<%} %>
				    <li>单位:<em><%= items[i].getCfunitIdAsName()==null?"":items[i].getCfunitIdAsName()%></em></li>
				    <li>物料属性:<em><%= items[i].getFmaterialMentIdAsName()==null?"":items[i].getFmaterialMentIdAsName()%></em></li>
				    <li>数量:<em><%= items[i].getCfquantity()==null?"":items[i].getCfquantity()%></em></li>
				   	<%if ("营运车".equals(carType)) {%>
				   		<li>未签收数量:<em><%= items[i].getCfsignAmount()==null?"":items[i].getCfsignAmount()%></em></li>
				    <%} %>
				    <li>参考单价:<em id="formateID3_1"><%= items[i].getCfreferencePrice()==null?"":items[i].getCfreferencePrice()%></em></li>
				    <li>参考金额:<em id="formateID2_2"><%= items[i].getCfreferenceAmount()==null?"":items[i].getCfreferenceAmount()%></em></li>
				    <li>所属事业部:<em><%= items[i].getCfsubordinateDivisAsName()==null?"":items[i].getCfsubordinateDivisAsName()%></em></li>
					<%if ("商务车".equals(carType)) {%>    
					    <li>上牌和贷款公司:<em><%= items[i].getCfregistrationLoanAsName()==null?"":items[i].getCfregistrationLoanAsName()%></em></li>
					<%} %>
				   	<%if ("营运车".equals(carType)) {%>
					    <li>上牌子公司:<em><%= items[i].getCfregistrationLoanAsName()==null?"":items[i].getCfregistrationLoanAsName()%></em></li>
					    <li>牌照类型:<em><%= items[i].getCflicenceTypeStr()%></em></li>
					    <li>车型:<em><%= items[i].getCfcarModel()==null?"":items[i].getCfcarModel()%></em></li>
					    <li>需到位日期:<em><%= items[i].getCfshouldPlaceStr()==null?"":items[i].getCfshouldPlaceStr()%></em></li>
					    <li>车队联系人:<em><%= items[i].getCfteamcontactIdAsName()==null?"":items[i].getCfteamcontactIdAsName()%></em></li>
					    <li>车队联系方式:<em><%= items[i].getCfcontact()==null?"":items[i].getCfcontact()%></em></li>
					    <li>安全员联系人:<em><%= items[i].getCfsecurityContactiAsName()==null?"":items[i].getCfsecurityContactiAsName()%></em></li>
					    <li>安全员联系方式:<em><%= items[i].getCfrelationMethod()==null?"":items[i].getCfrelationMethod()%></em></li>
					    <li>备注:<em><%= items[i].getCfremake()==null?"":items[i].getCfremake()%></em></li>
				    <%} %>
				    <li>出库数量:<em><%= items[i].getCfexportNumber()==null?"":items[i].getCfexportNumber()%></em></li>
				    <li>使用部门:<em><%= items[i].getCfuseDepartmentIdAsName()==null?"":items[i].getCfuseDepartmentIdAsName()%></em></li>
				   	<%if ("商务车".equals(carType)) {%>    
				    	<li>未签收数量:<em><%= items[i].getCfsignAmount()==null?"":items[i].getCfsignAmount()%></em></li>
				    <%} %>
				   	<%if ("营运车".equals(carType)) {%>
				    	<li>申请事由:<em><%= items[i].getCfapplyReasons()==null?"":items[i].getCfapplyReasons()%></em></li>
				    <%} %>
			   <%} %>
		   </ul>
	    </div>
	    <%@include file="approve_process_esb.jsp"%> 
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