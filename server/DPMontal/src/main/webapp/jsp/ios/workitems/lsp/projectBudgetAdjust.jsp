<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain.ProjectBudgeEntity"%>
<%@page import="com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain.ProjectBudgeEntries"%>
<%@page import="com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain.ProjectBudgeNoConstructEntity"%>
<%@page import="com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain.ProjectbudgeVo"%>
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
 ProjectbudgeVo info = (ProjectbudgeVo)request.getAttribute("lspResponseEntity");
 ProjectBudgeEntity entityPro = info.getProjectBudgeEntity();
 List<ProjectBudgeEntries> two = info.getProjectBudgeCollectList();
 List<ProjectBudgeEntries> three = info.getProjectBudgeEntriesList();
 List<ProjectBudgeNoConstructEntity> four = info.getProjectBudgeNoConstructEntityList();
 %>
<div id="list">
	<%@include file="/jsp/ios/work_items_head.jsp" %>
	<div id="div2">
		<h4 class="yellow">基本信息-工程项目预算调整单</h4>
    	<div class="ulBox2">
	    	<ul>				  
	    		<li>调整单编号单号:<em><%= entityPro.getNumber() %></em></li>
			   	<li>所属事业部:<em><%= entityPro.getDepartment() %></em></li>
			   	<li>申请时间:<em><%= entityPro.getCreateTime() == null ? "" : FormatUtil.formatDate(entityPro.getCreateTime())%></em></li>
				<li>申请人:<em><%= entityPro.getCreator()%></em></li>
			   	<li>申请部门:<em><%= entityPro.getCreatorg() %></em></li>
			   	<li>预算明细单号:<em><%= entityPro.getDetailBudget() %></em></li>
			   	<li>变更原因:<em><%= entityPro.getChangereason() %></em></li>
			   	<li>优惠金额:<em><%= FormatUtil.formatMoney(entityPro.getDiscount()) %></em></li>
			   	<li>工程项目编号:<em><%= entityPro.getProjectNumber()%></em></li>
			   	<li>工程项目名称:<em><%= entityPro.getProjectName() %></em></li>
			   	<li>调整后汇总金额:<em><%= FormatUtil.formatDouble("###,###.00",entityPro.getBudgetCollectedDto()) %></em></li>
			   	<li>项目状态:<em><%= entityPro.getProjectState() %></em></li>
			   	<li>调整金额:<em><%= FormatUtil.formatDouble("###,###.00", entityPro.getAdjustAmountDto())%></em></li>
			   	<li>调整前会总金额:<em><%= FormatUtil.formatDouble("###,###.00", entityPro.getBudgetCollectDto())%></em></li>
			   	<li>税率:<em><%= FormatUtil.formatDouble("###.0000",entityPro.getTaxAtionratioDto()) %></em></li>
			   	<li>税金:<em><%= FormatUtil.formatDouble("###,###.00", entityPro.getExpenseTaxationDto()) %></em></li>
			   	<li>含税总金额:<em><%= FormatUtil.formatDouble("###,###.00", entityPro.getAmountIncludeRaxationDto()) %></em></li>
			   	<li>模板:<em><%= entityPro.getMa()==null ? "":entityPro.getMa() %></em></li>
			   	<li>具体描述:<em><%= entityPro.getDescription()%></em></li>
          	</ul>
        </div>
        
	    <h4 class="yellow" id="otherInfo1Open">其他信息-汇总查看</h4>
	   	<div class="ulBox2 otherInfo1" style="display: none;">
    		<ul>
				  <%for(int i = 0; i < two.size() ; i++ ) {
					  ProjectBudgeEntries obj1 = two.get(i);
				%>
					<li <%=i==0?"class='first'":"class='line'"%>>序号:<em><%=i+1 %></em></li>
				    <li>预算类型:<em><%= obj1.getBudtupe()%></em></li>
				    <li>合计金额:<em><%= obj1.getTotalAmountDto()%></em></li>
			   <%} %>
		   </ul>
	    </div>
	    <h4 class="yellow" id="otherInfo1Close" style="display: none;">关闭汇总查看</h4>
	    <h4 class="yellow" id="otherInfo2Open">其他信息-施工类明细</h4>
	   	<div class="ulBox2 otherInfo2" style="display: none;">
    			<ul>
				  <%for(int i = 0; i < three.size()  ; i++ ) {
					  ProjectBudgeEntries obj1 = three.get(i);
				%>
					<li <%=i==0?"class='first'":"class='line'"%>>序号:<em><%=i+1 %></em></li>
				    <li>预算项目名称:<em><%= obj1.getProjectName()%></em></li>
				    <li>预算类型:<em><%= obj1.getBudtupe()%></em></li>
				   	<li>施工区域:<em><%= obj1.getConArea()%></em></li>
				    <li>供应商:<em><%= obj1.getSupplier()%></em></li>
				    <li>数量:<em><%= obj1.getQuanTityDto()%></em></li>
				    <li>单位:<em><%= obj1.getUnits()%></em></li>
				    <li>单价（人工费）:<em><%= obj1.getCostOfLaborDto()%></em></li>
				    <li>单价（材料费/机械费）:<em><%= obj1.getMaterialCostDto()%></em></li>
				    <li>合计金额:<em><%= obj1.getTotalAmountDto()%></em></li>
				    <li>是否甲供:<em><%= obj1.getGive()%></em></li>
				    <li>是否增项:<em><%= "0".equals(obj1.getIsNew().toString()) ? "否":obj1.getIsNew()%></em></li>
				    <li>无合同价格:<em><%= "0".equals(obj1.getNoContractPrice().toString()) ? "无":obj1.getNoContractPrice() %></em></li>
				    <li>备注:<em><%= obj1.getRemark()==null ? "": obj1.getRemark()%></em></li>
			   <%} %>
		   </ul>
		 </div>
		 <h4 class="yellow" id="otherInfo2Close" style="display: none;">关闭施工类明细</h4>
		   <h4 class="yellow" id="otherInfo3Open">其他信息-非施工类预算</h4>
	   	<div class="ulBox2 otherInfo3" style="display: none;">
    			<ul>
				  <%for(int i = 0; i < four.size() ; i++ ) {
					  ProjectBudgeNoConstructEntity obj1 = four.get(i);
				%>
					<li <%=i==0?"class='first'":"class='line'"%>>序号:<em><%=i+1 %></em></li>
				    <li>预算项目名称:<em><%= obj1.getProjectName()%></em></li>
				    <li>预算类型:<em><%= obj1.getBudtupe()%></em></li>
				   	<li>比例%:<em><%= obj1.getRatioDto()%></em></li>
				    <li>金额:<em><%= obj1.getAmountDto()%></em></li>
			   <%} %>
		   </ul>
		 </div>
		 <h4 class="yellow" id="otherInfo3Close">关闭非施工类预算</h4>
	    <%@include file="approve_process_esb3.jsp"%> 
	</div>
	<%@include file="workflow_approve_button_esb2.jsp" %>
</div>
</body>
<script type="text/javascript">
	$("#otherInfo1Open").click(function (){
		$(".otherInfo1").show();
		$("#otherInfo1Close").show();
	});
	$("#otherInfo1Close").click(function (){
		$(".otherInfo1").hide();
		$("#otherInfo1Close").hide();
	});
	$("#otherInfo2Open").click(function (){
		$(".otherInfo2").show();
		$("#otherInfo2Close").show();
	});
	$("#otherInfo2Close").click(function (){
		$(".otherInfo2").hide();
		$("#otherInfo2Close").hide();
	});
	$("#otherInfo3Open").click(function (){
		$(".otherInfo3").show();
		$("#otherInfo3Close").show();
	});
	$("#otherInfo3Close").click(function (){
		$(".otherInfo3").hide();
		$("#otherInfo3Close").hide();
	});
</script>
</html>