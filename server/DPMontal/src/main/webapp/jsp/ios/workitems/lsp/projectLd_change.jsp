<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.WorkflowEntity"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.ProgrammeChangeNoticeVo"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.BillSingleChange"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.ChangeLine"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.StuffLine"%>
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
	 ProgrammeChangeNoticeVo temp = info.getProgrammeChangeNoticeVo();
	 BillSingleChange base = temp.getProChangeEntity();
	 List<ChangeLine> items1 = temp.getChangeLineList();
	 List<StuffLine> items2 = temp.getStuffLineList();
 %>
<div id="list">
	<%@include file="/jsp/ios/work_items_head.jsp" %>
	<div id="div2">
		<h4 class="yellow">基本信息</h4>
    	<div class="ulBox2">
	    	<ul>				  
				<li>工&nbsp;&nbsp;作&nbsp;&nbsp;流:<em>工程量单变更单</em></li>
				<li>变更编号:<em><%=base.getfNumber()%></em></li>
				<li>申请变更人:<em><%=base.getCfVariationPerson()%></em></li>
				<li>变更日期:<em><%=base.getCfVariationTimeStr()%></em></li>
				<li>单据状态:<em><%=base.getfState()%></em></li>
			   	<li>项目状态:<em><%=base.getfProType()%></em></li>
			   	<li>项目编号:<em><%=base.getCfProNumberId()%></em></li>
			   	<li>项目名称:<em><%=base.getCfProName()%></em></li>
			   	<li>原量单编号:<em><%=base.getCfOriginalNumbers()%></em></li>
			   	<li>变更原因:<em><%=base.getCfVariationReasonName()%></em></li>
			   	<li>创建部门:<em><%=base.getCfCreateOrgUnitName()%></em></li>
			   	<li>具体描述:<em><%=base.getfRepresent()%></em></li>
          	</ul>
        </div>
        <h4 class="yellow">其他信息-变更明细</h4>
	   	<div class="ulBox2">
    		<ul>
			   <%for(int i = 0; i < items1.size() ; i++ ) {
				   ChangeLine obj1 = items1.get(i);
				%>
					<li <%=i==0?"class='first'":"class='line'"%>>序号:<em><%=i+1 %></em></li>
				   	<li>施工区域:<em><%= obj1.getCfConstructAreaName()%></em></li>
				    <li>费用名称（工程项目）:<em><%= obj1.getCfCostName()%></em></li>
				   	<li>数量:<em><%= obj1.getCfAmount()%></em></li>
				    <li>单位:<em><%= obj1.getfUnitName()%></em></li>
				    <li>预计损耗率%:<em><%= obj1.getCfPredictLoss()%></em></li>
				    <li>品牌、规格、型号:<em><%= obj1.getCfStandard()%></em></li>
				    <li>备注:<em><%= obj1.getCfRemark()%></em></li>
				    <li>是否增项:<em><%= obj1.getCfGivea()%></em></li>
				    <li>增项时间:<em><%= obj1.getCfGiveaTimeStr()%></em></li>
				    <li>是否甲供:<em><%= obj1.getCfArmorfor()%></em></li>
				    <li>定标数量:<em><%= obj1.getfCaliAmount()%></em></li>
				    <li>合同损耗率:<em><%= obj1.getfContractLoss()%></em></li>
				    <li>应用阶段计划:<em><%= obj1.getfPlansTage()%></em></li>
			   <%} %>
		   </ul>
	    </div>
	    
	    <h4 class="yellow">其他信息-材料清单</h4>
	   	<div class="ulBox2">
    		<ul>
			   <%for(int i = 0; i < items2.size() ; i++ ) {
				   StuffLine obj1 = items2.get(i);
				%>
					<li <%=i==0?"class='first'":"class='line'"%>>序号:<em><%=i+1 %></em></li>
				    <li>费用名称（工程项目）:<em><%= obj1.getCfCostName()%></em></li>
				   	<li>材料名称:<em><%= obj1.getCfMaterialName()%></em></li>
				    <li>规格:<em><%= obj1.getCfStandard()%></em></li>
				    <li>型号:<em><%= obj1.getCfModel()%></em></li>
				    <li>品牌:<em><%= obj1.getCfTradeMark()%></em></li>
				    <li>备注:<em><%= obj1.getCfRemark()%></em></li>
				    <li>材料附图:<em><%= obj1.getCfMaterialBook()%></em></li>
			   <%} %>
		   </ul>
	    </div>
	   
	    <%@include file="approve_process_esb.jsp"%> 
	</div>
	 <%@include file="workflow_approve_button_esb.jsp" %>
</div>
</body>

</html>