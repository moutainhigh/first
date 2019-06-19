<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.WorkflowEntity"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.FinalAccountApplyVo"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.FinalAccountApplyEntity"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.FinalAccountLine"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.NonConstructionType"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.WithHoldLine"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.Deviation"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.CostDpte"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.MeetingSummary"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
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
//决算单
FinalAccountApplyVo temp = info.getFinalAccountApplyVo();
//表头实体
FinalAccountApplyEntity base = temp.getFinalAccountApplyEntity();
//明细表体实体
List<FinalAccountLine> lineList = temp.getLineList();
/**
 * 非施工类型明细实体
 */
List<NonConstructionType> nonConstTypelineList = temp.getNonConstTypelineList();
/**
 * 扣款明细实体
 */
List<WithHoldLine> withHoldlineList = temp.getWithHoldlineList();
/**
 * 偏离度明细实体
 */
List<Deviation> deviationLineList = temp.getDeviationLineList();
/**
 * 费用承担部门实体
 */
List<CostDpte> costDpteList = temp.getCostDpteList();

/**
 * 项目类型为非网点时，多加显示的实体,决算会审意见和审计报告属于表头实体字段
 */
/**
 * 查询会议纪要明细实体
 */
List<MeetingSummary> meetingSummaryList = temp.getMeetingSummaryList();
%>
<div id="list">
	<%@include file="../wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table>
	    		<tr><th colspan="2" class="yellow">基本信息</th></tr>
	    		<tr><th>工&nbsp;&nbsp;作&nbsp;&nbsp;流:</th><td>决算单</td></tr>
	    		<tr><th>单据编号:</th><td id="workid"><%=base.getfNumber() %></td></tr>
	    		<tr><th>所属子公司:</th><td id="workid"><%=base.getCfSubsidiaryName() %></td></tr>
	    		<tr><th>申请时间:</th><td><%=FormatUtil.formatDate(base.getfCreateTime(), "yyyy-MM-dd hh:mm:ss")%></td></tr>
	    		<tr><th>公司（财务组织）:</th><td><%=base.getfCompanyName()%></td></tr>
	    		<tr><th >申请部门:</th><td><%=base.getCfCreateOrgUnitName()%></td></tr>
				<tr><th>申请人:</th><td><%=base.getfCreatorName()%></td></tr>
				
				<tr><th >项目编号:</th><td><%=base.getCfProjectNumberName()%></td></tr>
			   	<tr><th >项目名称:</th><td><%=base.getCfProjectName()%></td></tr>
			   	
				<tr><th >决算时间:</th><td><%=FormatUtil.formatDate(base.getCfBudgetTime(),"yyyy-MM-dd")%></td></tr>
			   	<tr><th >项目开始时间:</th><td><%=FormatUtil.formatDate(base.getCfStartTime(),"yyyy-MM-dd")%></td></tr>
			   	<tr><th >项目竣工时间:</th><td><%=FormatUtil.formatDate(base.getCfCompletedTime(),"yyyy-MM-dd")%></td></tr>
			   	<tr><th >供应商:</th><td><%=base.getCfSupplierName()%></td></tr>
			   	<tr><th >税率:</th><td><%=base.getCfTaxRate()%></td></tr>
			   	<tr><th >税额:</th><td><%=base.getCfTaxAmount()%></td></tr>
			   	
			    <tr><th >扣款总计:</th><td><%=base.getCfWithHoldTotal()%></td></tr>
			    <tr><th >决算总金额:</th><td><%=base.getCfBudgetAmount()%></td></tr>
			    <tr><th >决算总金额价税合计:</th><td><%=base.getCfBudgetAmountTax()%></td></tr>
			    <tr><th >本次付款金额:</th><td><%=base.getCfPayAmount()%></td></tr>
			    <tr><th >合同已付金额:</th><td><%=base.getCfPaymentAmount()%></td></tr>
			    <tr><th >合同金额:</th><td><%=base.getCfContractAmount()%></td></tr>
			    <tr><th >保修金额:</th><td><%=base.getCfGuaranteeAmount()%></td></tr>

				<tr class="yellow"><td colspan="2" >其他信息--决算明细</td></tr>
				<%
				int lineListSize = lineList == null?0:lineList.size();
				for(int i = 0; i < lineListSize; i++ ) {FinalAccountLine line = lineList.get(i); %>
					<tr <%=i==0 ? "" : "class='topLine'" %>><th>序号:</th><td><%=i+1 %></td></tr>
				   	<tr><th>预算项目类型:</th><td><%= line.getCfBudgetTypeName()%></td></tr>
				    <tr><th>费用名称:</th><td><%= line.getfPayNamesName()%></td></tr>
				   	<tr><th>单位:</th><td><%= line.getCfUnitsName()%></td></tr>
				    <tr><th>数量:</th><td><%= line.getCfQuantity()%></td></tr>
				    <tr><th>单价（人工费）:</th><td><%= line.getCfPricePeople()%></td></tr>
				    <tr><th>单价（材料费用）:</th><td><%= line.getCfPriceMaterial()%></td></tr>
				    <tr><th>金额:</th><td><%= line.getCfDetailAmount()%></td></tr>
			   <%} %>
			   
			   <tr class="yellow"><td colspan="2" >其他信息--非施工类费用</td></tr>
				<%
				int nonConstTypelineListsize = nonConstTypelineList == null?0:nonConstTypelineList.size();
				for(int i = 0; i < nonConstTypelineListsize; i++ ) {NonConstructionType line = nonConstTypelineList.get(i); %>
					<tr <%=i==0 ? "" : "class='topLine'" %>><th>序号:</th><td><%=i+1 %></td></tr>
				    <tr><th>费用名称:</th><td><%= line.getfPayNamesName()%></td></tr>
				   	<tr><th>费用类型:</th><td><%= line.getCfType()%></td></tr>
				    <tr><th>比例%:</th><td><%= line.getCfRatio()%></td></tr>
				    <tr><th>金额:</th><td><%= line.getCfConstructAmount()%></td></tr>
			   <%} %>
			   
			   <tr class="yellow"><td colspan="2" >其他信息--扣款</td></tr>
				<%
				int withHoldlineListsize = withHoldlineList == null?0:withHoldlineList.size();
				for(int i = 0; i < withHoldlineListsize; i++ ) {WithHoldLine line = withHoldlineList.get(i); %>
					<tr <%=i==0 ? "" : "class='topLine'" %>><th>序号:</th><td><%=i+1 %></td></tr>
				   	<tr><th>扣款事项:</th><td><%= line.getCfWithHoldMatterName()%></td></tr>
				    <tr><th>扣款金额:</th><td><%= line.getCfWithHoldAmount()%></td></tr>
				   	<tr><th>扣款日期:</th><td><%= FormatUtil.formatDate(line.getCfWithHoldDate(),"yyyy-MM-dd")%></td></tr>
			   <%} %>
			   <!-- 0：非网点的展示 -->
			   <% if(!"1".equals(base.getfProjectModel())){%>
				<tr class="yellow"><td colspan="2" >其他信息--决算会审意见</td></tr>
				<tr><th >会议主题:</th><td><%=base.getCfMeetingSubject()%></td></tr>
			    <tr><th >会审时间:</th><td><%=base.getCfMeetingTime()%></td></tr>
			    <tr><th >会审人员:</th><td><%=base.getCfMeetinOplegPName()%></td></tr>
			    <tr><th >会审决议:</th><td><%=base.getCfMeetingResult()%></td></tr> 
				   
				<tr class="yellow"><td colspan="2" >其他信息--会议纪要明细</td></tr>
				<%
				int meetingSummaryListsize = meetingSummaryList == null?0:meetingSummaryList.size(); 
 				for(int i = 0; i < meetingSummaryListsize; i++ ) {MeetingSummary line = meetingSummaryList.get(i); %>
					<tr <%=i==0 ? "" : "class='topLine'" %>><th>序号:</th><td><%=i+1 %></td></tr>
				   	<tr><th>代办事项:</th><td><%= line.getCfBackLog()%></td></tr>
				    <tr><th>负责人:</th><td><%= line.getCfPrincipalName()%></td></tr>
			   <%} %>

			   <tr class="yellow"><td colspan="2" >其他信息--审计报告</td></tr>
				<tr><th >审计部门:</th><td><%=base.getCfAuditDepartmentName()%></td></tr>
			    <tr><th >审计单位:</th><td><%=base.getCfAuditUnit()%></td></tr>
			    <tr><th >审计发现:</th><td><%=base.getCfAuditFind()%></td></tr>
			    <tr><th >审计原因:</th><td><%=base.getCfAuditResults()%></td></tr>
			   <%} %>


			<tr class="yellow"><td colspan="2" >其他信息--偏离度分析</td></tr>
				<%
				int deviationLineListsize = deviationLineList == null?0:deviationLineList.size();
				for(int i = 0; i < deviationLineListsize; i++ ) {Deviation line = deviationLineList.get(i); %>
					<tr <%=i==0 ? "" : "class='topLine'" %>><th>序号:</th><td><%=i+1 %></td></tr>
				   	<tr><th>设计项目名称:</th><td><%= line.getCfPartProjectName()%></td></tr>
				    <tr><th>场地面积（平方米）:</th><td><%= line.getCfAcreage()%></td></tr>
				    <tr><th>直接费用:</th><td><%= line.getCfDirectAmount()%></td></tr>
				    <tr><th>单位面积费用:</th><td><%= line.getCfAcreageAmount()%></td></tr>
			   <%} %>
			   <tr><th >预算金额:</th><td><%=base.getCfBudgetingAmount()%></td></tr>
			   <tr><th >偏离度:</th><td><%=base.getCfDeviation()%>%</td></tr>
			   <tr><th >验收扣款:</th><td><%=base.getCfAcceptWithHold()%></td></tr>
			   <tr><th >验收扣分:</th><td><%=base.getCfAcceptPoints()%></td></tr>
			   <tr><th >偏离度原因分析:</th><td><%=base.getCfDeviateReason()%></td></tr>
			   
			<tr class="yellow"><td colspan="2" >其他信息--费用承担部门</td></tr>
				<%
				int costDpteListsize = costDpteList == null?0:costDpteList.size();
				for(int i = 0; i < costDpteListsize; i++ ) {CostDpte line = costDpteList.get(i); %>
					<tr <%=i==0 ? "" : "class='topLine'" %>><th>序号:</th><td><%=i+1 %></td></tr>
				   	<tr><th>费用承担部门:</th><td><%= line.getCfCostdeptName()%></td></tr>
				    <tr><th>费用比例:</th><td><%= line.getCfProPortion()%></td></tr>
				    <tr><th>金额:</th><td><%= line.getCfAmountDept()%></td></tr>
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