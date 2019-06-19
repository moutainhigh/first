<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain.DetailEntity"%>
<%@page import="com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain.NonConstructionEntity"%>
<%@page import="com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain.ProjectBudgeDetailEntity"%>
<%@page import="com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain.ProjectBudgeDetailVo"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.math.BigDecimal"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
		<%@include file="/common_win8.jsp" %>
</head>
<body>
 <%
 ProjectBudgeDetailVo info = (ProjectBudgeDetailVo)request.getAttribute("lspResponseEntity");
 ProjectBudgeDetailEntity entityPro = info.getProjectBudgeDetailEntity();
 DetailEntity[] two = info.getDetailEntities();
 //汇总查看 处理
 int twoEnSize = two==null?0:two.length;
 HashSet set = new HashSet();
 for(int i=0;i<twoEnSize;i++){
	 DetailEntity entity =  two[i];
	 String type = entity.getBudgetType();
	 set.add(type);
 }
 Iterator<String> it = set.iterator();
 ArrayList list = new ArrayList();
 while (it.hasNext()) {  
   String str = it.next();  
   System.out.println(str);
   HashMap map = new HashMap();
   BigDecimal sum = new BigDecimal(0);
   for(int i=0;i<twoEnSize;i++){
		 DetailEntity entity =  two[i];
		 String type = entity.getBudgetType();
		 if(str.equals(type)){
			 sum = sum.add(entity.getPrice());
		 }
		 map.put("typeName", entity.getBudtupe());
	}
   map.put("prices", sum.longValue());
   list.add(map);
 }  
 NonConstructionEntity[] three = info.getNonConstructionEntities();
 %>
<div id="list">
	<%@include file="../wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table>		
	    		<tr><th colspan="2" class="yellow">基本信息-工程项目预算明细单</th></tr>
	    		<tr><th>预算编号:</th><td><%= entityPro.getNumber() %></td></tr>
			   	<tr><th>所属事业部:</th><td><%= entityPro.getDepartment() %></td></tr>
			   	<tr><th>申请时间:</th><td><%= entityPro.getCreateTime() == null ? "" : FormatUtil.formatDate(entityPro.getCreateTime())%></td></tr>
				<tr><th>申请人:</th><td><%= entityPro.getCreator()%></td></tr>
			   	<tr><th>申请部门:</th><td><%= entityPro.getCreatorg() %></td></tr>
			   	<tr><th>优惠金额:</th><td><%= FormatUtil.formatMoney(entityPro.getDiscount()) %></td></tr>
			   	<tr><th>工程项目编号:</th><td><%= entityPro.getProjectNumber() %></td></tr>
			   	<tr><th>工程项目名称:</th><td><%= entityPro.getProjectName() %></td></tr>
			   	<tr><th>版本号:</th><td><%= entityPro.getVersionNumber()%></td></tr>
			   	<tr><th>模板:</th><td><%= entityPro.getMa()==null ? "":entityPro.getMa() %></td></tr>
			   	<tr><th>项目状态:</th><td><%= entityPro.getProjectType() %></td></tr>
			   	<tr><th>分部工程:</th><td><%= entityPro.getEnginDivisions()==null ? "": entityPro.getEnginDivisions() %></td></tr>
			   	<tr><th>总金额:</th><td><%=FormatUtil.formatDouble("###,###,###.00", entityPro.getTotalPriceDto())  %></td></tr>
			   	<tr><th>税率:</th><td><%= FormatUtil.formatDouble("###.0000",entityPro.getTaxationRatioDto()) %></td></tr>
			   	<tr><th>税金:</th><td><%= FormatUtil.formatDouble("###,###,###.00",entityPro.getExpenseTaxationDto()) %></td></tr>
			   	<tr><th>含税总金额:</th><td><%= FormatUtil.formatDouble("###,###,###.00",entityPro.getAmountIncludeTaxationDto()) %></td></tr>
  			  	<tr class="yellow" id="otherInfo1Open"><td colspan="2">其他信息-汇总查看</td></tr>
  			  	<tbody style="display: none" class="otherInfo1">
				  <%
				  int listSize = list == null?0:list.size();
				  for(int i = 0; i < listSize ; i++ ) {
					  DetailEntity obj1 = two[i];
					  Map map = (Map)list.get(i);
				%>
					<tr <%=i==0?"class='first'":"class='topLine'"%>><th>序号:</th><td><%=i+1 %></td></tr>
				    <tr><th>预算类型:</th><td><%= map.get("typeName")%></td></tr>
				    <tr><th>合计金额:</th><td><%= map.get("prices")%></td></tr>
			   <%} %>
		   <tr class="yellow" style="display: none" id="otherInfo1Close"><td colspan="2">关闭汇总查看</td></tr>
    		</tbody>
    		<tr class="yellow" id="otherInfo2Open" ><td colspan="2">其他信息-施工类明细</td></tr>
    		<tbody style="display: none" class="otherInfo2">
				  <%for(int i = 0; i < two.length  ; i++ ) {
					  DetailEntity obj1 = two[i];
				%>
					<tr <%=i==0?"class='first'":"class='topLine'"%>><th>序号:</th><td><%=i+1 %></td></tr>
				    <tr><th>预算项目名称:</th><td><%= obj1.getProjectName()%></td></tr>
				    <tr><th>预算类型:</th><td><%= obj1.getBudtupe()%></td></tr>
				   	<tr><th>施工区域:</th><td><%= obj1.getConArea()%></td></tr>
				   	<tr><th>数量:</th><td><%= obj1.getAmountDto()%></td></tr>
				    <tr><th>单位:</th><td><%= obj1.getUnits()%></td></tr>
				    <tr><th>供应商:</th><td><%= obj1.getSupplier()%></td></tr>
				    <tr><th>单价（人工费）:</th><td><%= obj1.getUnitPricePeDto()%></td></tr>
				    <tr><th>单价（材料费/机械费）:</th><td><%= obj1.getUnitPriceMeDto()%></td></tr>
				    <tr><th>合计金额:</th><td><%= obj1.getPriceDto()%></td></tr>
				    <tr><th>是否甲供:</th><td><%= obj1.getGive()%></td></tr>
				    <tr><th>是否新增:</th><td><%= "0".equals(obj1.getIsNew().toString()) ? "否":obj1.getIsNew()%></td></tr>
				    <tr><th>无合同价格:</th><td><%= "0".equals(obj1.getNoContractPrice().toString()) ? "无":obj1.getNoContractPrice() %></td></tr>
				    <tr><th>备注:</th><td><%= obj1.getComment()==null ? "": obj1.getComment()%></td></tr>
			   <%} %>
		 <tr class="yellow" style="display: none" id="otherInfo2Close"><td colspan="2">关闭施工类明细</td></tr>
		 </tbody>
		 
    		<tr class="yellow" id="otherInfo3Open" ><td colspan="2">其他信息-非施工类预算</td></tr>
    		<tbody  style="display: none" class="otherInfo3">
				  <%for(int i = 0; i < three.length ; i++ ) {
					  NonConstructionEntity obj1 = three[i];
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