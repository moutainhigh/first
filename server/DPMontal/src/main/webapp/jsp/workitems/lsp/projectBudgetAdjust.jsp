<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
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
	<%@include file="/common_win8.jsp" %>
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
	<%@include file="../wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table>			
	    		<tr><th colspan="2" class="yellow">基本信息-工程项目预算调整单</th></tr>		  
	    		<tr><th>调整单编号单号:</th><td><%= entityPro.getNumber() %></td></tr>
			   	<tr><th>所属事业部:</th><td><%= entityPro.getDepartment() %></td></tr>
			   	<tr><th>申请时间:</th><td><%= entityPro.getCreateTime() == null ? "" : FormatUtil.formatDate(entityPro.getCreateTime())%></td></tr>
				<tr><th>申请人:</th><td><%= entityPro.getCreator()%></td></tr>
			   	<tr><th>申请部门:</th><td><%= entityPro.getCreatorg() %></td></tr>
			   	<tr><th>预算明细单号:</th><td><%= entityPro.getDetailBudget() %></td></tr>
			   	<tr><th>变更原因:</th><td><%= entityPro.getChangereason() %></td></tr>
			   	<tr><th>优惠金额:</th><td><%= FormatUtil.formatMoney(entityPro.getDiscount()) %></td></tr>
			   	<tr><th>工程项目编号:</th><td><%= entityPro.getProjectNumber()%></td></tr>
			   	<tr><th>工程项目名称:</th><td><%= entityPro.getProjectName() %></td></tr>
			   	<tr><th>调整后汇总金额:</th><td><%= FormatUtil.formatDouble("###,###.00",entityPro.getBudgetCollectedDto())%></td></tr>
			   	<tr><th>项目状态:</th><td><%= entityPro.getProjectState() %></td></tr>
			   	<tr><th>调整金额:</th><td><%= FormatUtil.formatDouble("###,###.00", entityPro.getAdjustAmountDto())%></td></tr>
			   	<tr><th>调整前会总金额:</th><td><%= FormatUtil.formatDouble("###,###.00", entityPro.getBudgetCollectDto())%></td></tr>
			   	<tr><th>税率:</th><td><%= FormatUtil.formatDouble("###.0000",entityPro.getTaxAtionratioDto()) %></td></tr>
			   	<tr><th>税金:</th><td><%= FormatUtil.formatDouble("###,###.00", entityPro.getExpenseTaxationDto()) %></td></tr>
			   	<tr><th>含税总金额:</th><td><%= FormatUtil.formatDouble("###,###.00", entityPro.getAmountIncludeRaxationDto()) %></td></tr>
			   	<tr><th>模板:</th><td><%= entityPro.getMa()==null ? "":entityPro.getMa() %></td></tr>
			   	<tr><th>具体描述:</th><td><%= entityPro.getDescription()%></td></tr>
      		  <tr class="yellow" id="otherInfo1Open"><td colspan="2">其他信息-汇总查看</td></tr>
  			  	<tbody style="display: none" class="otherInfo1">
				  <%for(int i = 0; i < two.size() ; i++ ) {
					  ProjectBudgeEntries obj1 = two.get(i);
				%>
					<tr <%=i==0?"class='first'":"class='topLine'"%>><th>序号:</th><td><%=i+1 %></td></tr>
				    <tr><th>预算类型:</th><td><%= obj1.getBudtupe()%></td></tr>
				    <tr><th>合计金额:</th><td><%= obj1.getTotalAmountDto()%></td></tr>
			   <%} %>
		   <tr class="yellow" style="display: none" id="otherInfo1Close"><td colspan="2">关闭汇总查看</td></tr>
    		</tbody>
    		<tr class="yellow" id="otherInfo2Open" ><td colspan="2">其他信息-施工类明细</td></tr>
    		<tbody style="display: none" class="otherInfo2">
				  <%for(int i = 0; i < three.size()  ; i++ ) {
					  ProjectBudgeEntries obj1 = three.get(i);
				%>
					<tr <%=i==0?"class='first'":"class='topLine'"%>><th>序号:</th><td><%=i+1 %></td></tr>
				    <tr><th>预算项目名称:</th><td><%= obj1.getProjectName()%></td></tr>
				    <tr><th>预算类型:</th><td><%= obj1.getBudtupe()%></td></tr>
				   	<tr><th>施工区域:</th><td><%= obj1.getConArea()%></td></tr>
				    <tr><th>供应商:</th><td><%= obj1.getSupplier()%></td></tr>
				    <tr><th>数量:</th><td><%= obj1.getQuanTityDto()%></td></tr>
				    <tr><th>单位:</th><td><%= obj1.getUnits()%></td></tr>
				    <tr><th>单价（人工费）:</th><td><%= obj1.getCostOfLaborDto()%></td></tr>
				    <tr><th>单价（材料费/机械费）:</th><td><%= obj1.getMaterialCostDto()%></td></tr>
				    <tr><th>合计金额:</th><td><%= obj1.getTotalAmountDto()%></td></tr>
				    <tr><th>是否甲供:</th><td><%= obj1.getGive()%></td></tr>
				    <tr><th>是否增项:</th><td><%= "0".equals(obj1.getIsNew().toString()) ? "否":obj1.getIsNew()%></td></tr>
				    <tr><th>无合同价格:</th><td><%= "0".equals(obj1.getNoContractPrice().toString()) ? "无":obj1.getNoContractPrice() %></td></tr>
				    <tr><th>备注:</th><td><%= obj1.getRemark()==null ? "": obj1.getRemark()%></td></tr>
			   <%} %>
		 <tr class="yellow" style="display: none" id="otherInfo2Close"><td colspan="2">关闭施工类明细</td></tr>
		 </tbody>
		 
    		<tr class="yellow" id="otherInfo3Open" ><td colspan="2">其他信息-非施工类预算</td></tr>
    		<tbody  style="display: none" class="otherInfo3">
				  <%for(int i = 0; i < four.size() ; i++ ) {
					  ProjectBudgeNoConstructEntity obj1 = four.get(i);
				%>
					<tr <%=i==0?"class='first'":"class='topLine'"%>><th>序号:</th><td><%=i+1 %></td></tr>
				    <tr><th>预算项目名称:</th><td><%= obj1.getProjectName()%></td></tr>
				    <tr><th>预算类型:</th><td><%= obj1.getBudtupe()%></td></tr>
				   	<tr><th>比例%:</th><td><%= obj1.getRatioDto()%></td></tr>
				    <tr><th>金额:</th><td><%= obj1.getAmountDto()%></td></tr>
			   <%} %>
		   <tr class="yellow" style="display: none" id="otherInfo3Close"><td colspan="2">关闭非施工类预算</td></tr>
		  </tbody>
  		</table>
		  <%@include file="approve_process_esb3.jsp" %>
		</div>
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