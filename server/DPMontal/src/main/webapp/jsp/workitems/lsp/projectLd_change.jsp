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
	<%@include file="/common_win8.jsp" %>
	<style type="text/css">
		.otherInfo1{
			display:none;
		}
		.otherInfo2{
			display:none;
		}
	</style>
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
	<%@include file="../wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table>
	    		<tr><th colspan="2" class="yellow">基本信息</th></tr>
	    		<tr><th>工&nbsp;&nbsp;作&nbsp;&nbsp;流:</th><td>工程量单变更单</td></tr>
	    		<tr><th>变更编号:</th><td id="workid"><%=base.getfNumber()%></td></tr>
				<tr><th>申请变更人:</th><td><%=base.getCfVariationPerson()%></td></tr>
				<tr><th>变更日期:</th><td><%=base.getCfVariationTimeStr()%></td></tr>
				<tr><th>单据状态:</th><td><%=base.getfState()%></td></tr>
			   	<tr><th>项目状态:</th><td><%=base.getCfProState()%></td></tr>
			   	<tr><th>项目编号:</th><td><%=base.getCfProNumber()%></td></tr>
			   	<tr><th>项目名称:</th><td><%=base.getCfProName()%></td></tr>
			   	<tr><th>原量单编号:</th><td><%=base.getCfOriginalNumbers()%></td></tr>
			   	<tr><th>变更原因:</th><td><%=base.getCfVariationReasonName()%></td></tr>
			   	<tr><th>创建部门:</th><td><%=base.getCfCreateOrgUnitName()%></td></tr>
			   	<tr><th>具体描述:</th><td><%=base.getfRepresent()%></td></tr>
			    
				<tr class="yellow" id="otherInfo1Open"><td colspan="2">其他信息-变更明细</td></tr>
					<%for(int i = 0; i < items1.size() ; i++ ) {
						ChangeLine obj1 = items1.get(i);
					%>
						<tr <%=i==0 ? "" : "class='topLine otherInfo1'" %> class="otherInfo1"><th>序号:</th><td><%=i+1 %></td></tr>
					   	<tr class="otherInfo1"><th>施工区域:</th><td><%= obj1.getCfConstructAreaName()%></td></tr>
					    <tr class="otherInfo1"><th>费用名称（工程项目）:</th><td><%= obj1.getCfCostName()%></td></tr>
					   	<tr class="otherInfo1"><th>数量:</th><td><%= obj1.getCfAmount()%></td></tr>
					    <tr class="otherInfo1"><th>单位:</th><td><%= obj1.getfUnitName()%></td></tr>
					    <tr class="otherInfo1"><th>预计损耗率%:</th><td><%= obj1.getCfPredictLoss()%></td></tr>
					    <tr class="otherInfo1"><th>品牌、规格、型号:</th><td><%= obj1.getCfStandard()%></td></tr>
					    <tr class="otherInfo1"><th>备注:</th><td><%= obj1.getCfRemark()%></td></tr>
					    <tr class="otherInfo1"><th>是否增项:</th><td><%= obj1.getCfGivea()%></td></tr>
					    <tr class="otherInfo1"><th>增项时间:</th><td><%= obj1.getCfGiveaTimeStr()%></td></tr>
					    <tr class="otherInfo1"><th>是否甲供:</th><td><%= obj1.getCfArmorfor()%></td></tr>
					    <tr class="otherInfo1"><th>定标数量:</th><td><%= obj1.getfCaliAmount()%></td></tr>
					    <tr class="otherInfo1"><th>合同损耗率:</th><td><%= obj1.getfContractLoss()%></td></tr>
					    <tr class="otherInfo1"><th>应用阶段计划:</th><td><%= obj1.getfPlansTage()%></td></tr>
				   <%} %>
				   <tr class="yellow" style="display: none" id="otherInfo1Close"><td colspan="2">关闭信息-变更明细</td></tr>
			   
			   <tr class="yellow" id="otherInfo2Open" ><td colspan="2">其他信息-材料清单</td></tr>
				<%for(int i = 0; i < items2.size() ; i++ ) {
					StuffLine obj1 = items2.get(i);
				%>
					<tr <%=i==0 ? "" : "class='topLine otherInfo2'" %> class="otherInfo2"><th>序号:</th><td><%=i+1 %></td></tr>
				    <tr class="otherInfo2"><th>费用名称（工程项目）:</th><td><%= obj1.getCfCostName()%></td></tr>
				   	<tr class="otherInfo2"><th>材料名称:</th><td><%= obj1.getCfMaterialName()%></td></tr>
				    <tr class="otherInfo2"><th>规格:</th><td><%= obj1.getCfStandard()%></td></tr>
				    <tr class="otherInfo2"><th>型号:</th><td><%= obj1.getCfModel()%></td></tr>
				    <tr class="otherInfo2"><th>品牌:</th><td><%= obj1.getCfTradeMark()%></td></tr>
				    <tr class="otherInfo2"><th>备注:</th><td><%= obj1.getCfRemark()%></td></tr>
				    <tr class="otherInfo2"><th>材料附图:</th><td><%= obj1.getCfMaterialBook()%></td></tr>
			   <%} %>
			   <tr class="yellow" style="display: none" id="otherInfo2Close"><td colspan="2">关闭信息-材料清单</td></tr>
		  </table>
		  <%@include file="approve_process_esb.jsp" %>
		</div>
	</div>
	<%@include file="workflow_approve_button_esb.jsp" %>
</div>
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
</script>
</body>
</html>