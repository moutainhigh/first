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
	<%@include file="/common_ios.jsp" %>
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
	<%@include file="/jsp/ios/work_items_head.jsp" %>
	<div id="div2">
		<h4 class="yellow">基本信息</h4>
    	<div class="ulBox2">
	    	<ul>				  
				<li>工&nbsp;&nbsp;作&nbsp;&nbsp;流:<em>车辆更新申请单</em></li>
	    		<li>单据编号:<em><%=base.getFnumber()%></em></li>
				<li>车牌号:<em><%=base.getPlateNumber()%></em></li>
				<li>资产所属子公司:<em><%=base.getAffiliationCompany()%></em></li>
				<li>所属办公室:<em><%=base.getAffiliationOffice()%></em></li>
				<li>车型:<em><%=base.getVehicleType()%></em></li>
			   	<li>固定资产编码:<em><%=base.getFixedAssets()%></em></li>
			   	<li>车辆品牌:<em><%=base.getVehicleBrand()%></em></li>
			   	<li>吨位:<em><%=base.getTonnage()%></em></li>
			   	<li>开始使用日期:<em><%=base.getStarteUseTimeStr()%></em></li>
			   	<li>申请部门:<em><%=base.getProductDepartment()%></em></li>
			   	<li>判定结果:<em><%=base.getResult()%></em></li>
			   	<li>使用部门所属子公司:<em><%=base.getUsingFinance()%></em></li>
			    <li>申请事由:<em><%=base.getDescription()%></em></li>
          	</ul>
        </div>
        <h4 class="yellow">其他信息-轮胎信息</h4>
	   	<div class="ulBox2">
    		<ul>
			  <%for(int i = 0; i < items1.size() ; i++ ) {
					TyreInformationEntity obj1 = items1.get(i);
				%>
					<li <%=i==0?"class='first'":"class='line'"%>>序号:<em><%=i+1 %></em></li>
				   	<li>轮胎胎号:<em><%= obj1.getTireNO()%></em></li>
				    <li>轮胎位置:<em><%= obj1.getLocation()%></em></li>
				   	<li>公里数:<em><%= obj1.getEvenNumberStr()%></em></li>
				    <li>是否变卖:<em><%= obj1.getIsSellStr()%></em></li>
			   <%} %>
		   </ul>
	    </div>
	    <h4 class="yellow">其他信息-车辆附件</h4>
	   	<div class="ulBox2">
    		<ul>
			  <%for(int i = 0; i < items2.size(); i++ ) {
					VehicleAccessoriesEntity obj2 = items2.get(i);
				%>
					<li <%=i==0?"class='first'":"class='line'"%>>序号:<em><%=i+1 %></em></li>
				   	<li>车辆附件:<em><%= obj2.getVehicleAccessory()%></em></li>
				    <li>是否变卖:<em><%= obj2.getIsSellStr()%></em></li>
			   <%} %>
		   </ul>
	    </div>
	    <%@include file="approve_process_esb.jsp"%> 
	</div>
	 <%@include file="workflow_approve_button_esb.jsp" %>
</div>
</body>

</html>