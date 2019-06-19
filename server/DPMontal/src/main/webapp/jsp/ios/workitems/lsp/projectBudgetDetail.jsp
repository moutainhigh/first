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
	<%@include file="/common_ios.jsp" %>
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
	<%@include file="/jsp/ios/work_items_head.jsp" %>
	<div id="div2">
		<h4 class="yellow">基本信息-工程项目预算明细单</h4>
    	<div class="ulBox2">
	    	<ul>				  
	    		<li>预算编号:<em><%= entityPro.getNumber() %></em></li>
			   	<li>所属事业部:<em><%= entityPro.getDepartment() %></em></li>
			   	<li>申请时间:<em><%= entityPro.getCreateTime() == null ? "" : FormatUtil.formatDate(entityPro.getCreateTime())%></em></li>
				<li>申请人:<em><%= entityPro.getCreator()%></em></li>
			   	<li>申请部门:<em><%= entityPro.getCreatorg() %></em></li>
			   	<li>优惠金额:<em><%= FormatUtil.formatMoney(entityPro.getDiscount()) %></em></li>
			   	<li>工程项目编号:<em><%= entityPro.getProjectNumber() %></em></li>
			   	<li>工程项目名称:<em><%= entityPro.getProjectName() %></em></li>
			   	<li>版本号:<em><%= entityPro.getVersionNumber()%></em></li>
			   	<li>模板:<em><%= entityPro.getMa()==null ? "":entityPro.getMa() %></em></li>
			   	<li>项目状态:<em><%= entityPro.getProjectType() %></em></li>
			   	<li>分部工程:<em><%= entityPro.getEnginDivisions()==null ? "": entityPro.getEnginDivisions() %></em></li>
			   	<li>总金额:<em><%=FormatUtil.formatDouble("###,###,###.00", entityPro.getTotalPriceDto())  %></em></li>
			   	<li>税率:<em><%= FormatUtil.formatDouble("###.0000",entityPro.getTaxationRatioDto()) %></em></li>
			   	<li>税金:<em><%= FormatUtil.formatDouble("###,###,###.00",entityPro.getExpenseTaxationDto()) %></em></li>
			   	<li>含税总金额:<em><%= FormatUtil.formatDouble("###,###,###.00",entityPro.getAmountIncludeTaxationDto()) %></em></li>
          	</ul>
        </div>
        
	    <h4 class="yellow" id="otherInfo1Open">其他信息-汇总查看</h4>
	   	<div class="ulBox2 otherInfo1"  style="display: none;">
    		<ul>
				  <%int listSize = list == null?0:list.size();
				  for(int i = 0; i < listSize ; i++ ) {
					  DetailEntity obj1 = two[i];
					  Map map = (Map)list.get(i);
				%>
					<li <%=i==0?"class='first'":"class='line'"%>>序号:<em><%=i+1 %></em></li>
				    <li>预算类型:<em><%=map.get("typeName")%></em></li>
				    <li>合计金额:<em><%= map.get("prices")%></em></li>
			   <%} %>
		   </ul>
	    </div>
	     <h4 class="yellow" id="otherInfo1Close"  style="display: none;">关闭汇总查看</h4>
	    <h4 class="yellow" id="otherInfo2Open">其他信息-施工类明细</h4>
	   	<div class="ulBox2 otherInfo2" style="display: none;">
    			<ul>
				  <%for(int i = 0; i < two.length  ; i++ ) {
					  DetailEntity obj1 = two[i];
				%>
					<li <%=i==0?"class='first'":"class='line'"%>>序号:<em><%=i+1 %></em></li>
				   <li>预算项目名称:<em><%= obj1.getProjectName()%></em></li>
				    <li>预算类型:<em><%= obj1.getBudtupe()%></em></li>
				   	<li>施工区域:<em><%= obj1.getConArea()%></em></li>
				   	<li>数量:<em><%= obj1.getAmountDto()%></em></li>
				    <li>单位:<em><%= obj1.getUnits()%></em></li>
				    <li>供应商:<em><%= obj1.getSupplier()%></em></li>
				    <li>单价（人工费）:<em><%= obj1.getUnitPricePeDto()%></em></li>
				    <li>单价（材料费/机械费）:<em><%= obj1.getUnitPriceMeDto()%></em></li>
				    <li>合计金额:<em><%= obj1.getPriceDto()%></em></li>
				    <li>是否甲供:<em><%= obj1.getGive()%></em></li>
				    <li>是否新增:<em><%= "0".equals(obj1.getIsNew().toString()) ? "否":obj1.getIsNew()%></em></li>
				    <li>无合同价格:<em><%= "0".equals(obj1.getNoContractPrice().toString()) ? "无":obj1.getNoContractPrice() %></em></li>
				    <li>备注:<em><%= obj1.getComment()==null ? "": obj1.getComment()%></em></li>
			   <%} %>
		   </ul>
		 </div>
		  <h4 class="yellow" id="otherInfo2Close" style="display: none;">关闭施工类明细</h4>
		   <h4 class="yellow" id="otherInfo3Open">其他信息-非施工类预算</h4>
	   	<div class="ulBox2 otherInfo3" style="display: none;">
    			<ul>
				  <%for(int i = 0; i < three.length ; i++ ) {
					  NonConstructionEntity obj1 = three[i];
				%>
					<li <%=i==0?"class='first'":"class='line'"%>>序号:<em><%=i+1 %></em></li>
				   <li>预算项目名称:<em><%= obj1.getProjectName()%></em></li>
				    <li>预算类型:<em><%= obj1.getBudtupe()%></em></li>
				   	<li>比例%:<em><%= obj1.getRatioDto()%></em></li>
				    <li>金额:<em><%= obj1.getAmountDto()%></em></li>
			   <%} %>
		   </ul>
		 </div>
		 <h4 class="yellow" id="otherInfo3Close" style="display: none;">关闭非施工类预算</h4>
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