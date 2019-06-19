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
	<%@include file="/jsp/ios/work_items_head.jsp" %>
	<div id="div2">
		<h4 class="yellow">基本信息-新点物料申请单</h4>
    	<div class="ulBox2">
	    	<ul>				  
				<li>单据编号:<em id="workid"><%=base.getfNumber() %></em></li>
	    		<li>所属子公司:<em id="workid"><%=base.getCfSubsidiaryName() %></em></li>
	    		<li>申请时间:<em><%=FormatUtil.formatDate(base.getfCreateTime(), "yyyy-MM-dd hh:mm:ss")%></em></li>
	    		<li>公司（财务组织）:<em><%=base.getfCompanyName()%></em></li>
	    		<li>申请部门:<em><%=base.getCfCreateOrgUnitName()%></em></li>
				<li>申请人:<em><%=base.getfCreatorName()%></em></li>
				
				<li>项目编号:<em><%=base.getCfProjectNumberName()%></em></li>
			   	<li>项目名称:<em><%=base.getCfProjectName()%></em></li>
			   	
				<li>决算时间:<em><%=FormatUtil.formatDate(base.getCfBudgetTime(),"yyyy-MM-dd")%></em></li>
			   	<li>项目开始时间:<em><%=FormatUtil.formatDate(base.getCfStartTime(),"yyyy-MM-dd")%></em></li>
			   	<li>项目竣工时间:<em><%=FormatUtil.formatDate(base.getCfCompletedTime(),"yyyy-MM-dd")%></em></li>
			   	<li>供应商:<em><%=base.getCfSupplierName()%></em></li>
			   	<li>税率:<em><%=base.getCfTaxRate()%></em></li>
			   	<li>税额:<em><%=base.getCfTaxAmount()%></em></li>
			   	
			    <li>扣款总计:<em><%=base.getCfWithHoldTotal()%></em></li>
			    <li>决算总金额:<em><%=base.getCfBudgetAmount()%></em></li>
			    <li>决算总金额价税合计:<em><%=base.getCfBudgetAmountTax()%></em></li>
			    <li>本次付款金额:<em><%=base.getCfPayAmount()%></em></li>
			    <li>合同已付金额:<em><%=base.getCfPaymentAmount()%></em></li>
			    <li>合同金额:<em><%=base.getCfContractAmount()%></em></li>
			    <li>保修金额:<em><%=base.getCfGuaranteeAmount()%></em></li>
				
          	</ul>
        </div>
        <h4 class="yellow">其他信息--决算明细</h4>
	   	<div class="ulBox2">
    		<ul>
				<%
				int lineListSize = lineList == null?0:lineList.size();
				for(int i = 0; i < lineListSize; i++ ) {FinalAccountLine line = lineList.get(i); %>
					<li <%=i==0?"class='first'":"class='line'" %>>序号:<em><%=i+1 %></em></li>
				    <li>预算项目类型:<em><%= line.getCfBudgetTypeName()%></em></li>
				    <li>费用名称:<em><%= line.getfPayNamesName()%></em></li>
				   	<li>单位:<em><%= line.getCfUnitsName()%></em></li>
				    <li>数量:<em><%= line.getCfQuantity()%></em></li>
				    <li>单价（人工费）:<em><%= line.getCfPricePeople()%></em></li>
				    <li>单价（材料费用）:<em><%= line.getCfPriceMaterial()%></em></li>
				    <li>金额:<em><%= line.getCfDetailAmount()%></em></li>
			   <%} %>
			  
		   </ul>
	    </div>
	     <h4 class="yellow">其他信息--非施工类费用</h4>
	   	<div class="ulBox2">
    		<ul>
				<%
				int nonConstTypelineListsize = nonConstTypelineList == null?0:nonConstTypelineList.size();
				for(int i = 0; i < nonConstTypelineListsize; i++ ) {NonConstructionType line = nonConstTypelineList.get(i); %>
					<li <%=i==0?"class='first'":"class='line'" %>>序号:<em><%=i+1 %></em></li>
				    <li>费用名称:<em><%= line.getfPayNamesName()%></em></li>
				   	<li>费用类型:<em><%= line.getCfType()%></em></li>
				    <li>比例%:<em><%= line.getCfRatio()%></em></li>
				    <li>金额:<em><%= line.getCfConstructAmount()%></em></li>
			   <%} %>
		   </ul>
	    </div>
	     <h4 class="yellow">其他信息--扣款</h4>
	   	<div class="ulBox2">
    		<ul>
				<%
				int withHoldlineListsize = withHoldlineList == null?0:withHoldlineList.size();
				for(int i = 0; i < withHoldlineListsize; i++ ) {WithHoldLine line = withHoldlineList.get(i); %>
					<li <%=i==0?"class='first'":"class='line'" %>>序号:<em><%=i+1 %></em></li>
				   	<li>扣款事项:<em><%= line.getCfWithHoldMatterName()%></em></li>
				    <li>扣款金额:<em><%= line.getCfWithHoldAmount()%></em></li>
				   	<li>扣款日期:<em><%= FormatUtil.formatDate(line.getCfWithHoldDate(),"yyyy-MM-dd")%></em></li>
			   <%} %>
			   
			   
		   </ul>
	    </div>
	    
	    
	     <!-- 0：非网点的展示 -->
		<% if(!"1".equals(base.getfProjectModel())){%>
		 <h4 class="yellow">其他信息--决算会审意见</h4>
	   	<div class="ulBox2">
    	<ul>
			    <li>会议主题:<em><%=base.getCfMeetingSubject()%></em></li>
			    <li>会审时间:<em><%=base.getCfMeetingTime()%></em></li>
			    <li>会审人员:<em><%=base.getCfMeetinOplegPName()%></em></li>
			    <li>会审决议:<em><%=base.getCfMeetingResult()%></em></li> 
	    </ul>
	    </div>
	     <h4 class="yellow">其他信息--会议纪要明细</h4>
	   	<div class="ulBox2">
    		<ul>
				<%
				int meetingSummaryListsize = meetingSummaryList == null?0:meetingSummaryList.size();
				for(int i = 0; i < meetingSummaryListsize; i++ ) {MeetingSummary line = meetingSummaryList.get(i); %>
					<li <%=i==0?"class='first'":"class='line'" %>>序号:<em><%=i+1 %></em></li>
				    <li>代办事项:<em><%= line.getCfBackLog()%></em></li>
				    <li>负责人:<em><%= line.getCfPrincipalName()%></em></li>
			   <%} %>
		   </ul>
	    </div>
	    <h4 class="yellow">其他信息--审计报告</h4>
	   	<div class="ulBox2">
    		<ul>
			    <li>审计部门:<em><%=base.getCfAuditDepartmentName()%></em></li>
			    <li>审计单位:<em><%=base.getCfAuditUnit()%></em></li>
			    <li>审计发现:<em><%=base.getCfAuditFind()%></em></li>
			    <li>审计原因:<em><%=base.getCfAuditResults()%></em></li>
		   </ul>
	    </div>
	    <%}%>
	    
	     <h4 class="yellow">其他信息--偏离度分析</h4>
	   	<div class="ulBox2">
    		<ul>
				<%
				int deviationLineListsize = deviationLineList == null?0:deviationLineList.size();
				for(int i = 0; i < deviationLineListsize; i++ ) {Deviation line = deviationLineList.get(i); %>
					<li <%=i==0?"class='first'":"class='line'" %>>序号:<em><%=i+1 %></em></li>
				    <li>设计项目名称:<em><%= line.getCfPartProjectName()%></em></li>
				    <li>场地面积（平方米）:<em><%= line.getCfAcreage()%></em></li>
				    <li>直接费用:<em><%= line.getCfDirectAmount()%></em></li>
				    <li>单位面积费用:<em><%= line.getCfAcreageAmount()%></em></li>
			   <%} %>
			   <li>预算金额:<em><%=base.getCfBudgetingAmount()%></em></li>
			   <li>偏离度:<em><%=base.getCfDeviation()%>%</em></li>
			   <li>验收扣款:<em><%=base.getCfAcceptWithHold()%></em></li>
			   <li>验收扣分:<em><%=base.getCfAcceptPoints()%></em></li>
			   <li>偏离度原因分析:<em><%=base.getCfDeviateReason()%></em></li>
		   </ul>
	    </div>
	   
	     <h4 class="yellow">其他信息--费用承担部门</h4>
	   	<div class="ulBox2">
    		<ul>
				<%
				int costDpteListsize = costDpteList == null?0:costDpteList.size();
				for(int i = 0; i < costDpteListsize; i++ ) {CostDpte line = costDpteList.get(i); %>
					<li <%=i==0?"class='first'":"class='line'" %>>序号:<em><%=i+1 %></em></li>
				    <li>费用承担部门:<em><%= line.getCfCostdeptName()%></em></li>
				    <li>费用比例:<em><%= line.getCfProPortion()%></em></li>
				    <li>金额:<em><%= line.getCfAmountDept()%></em></li>
			   <%} %>
		   </ul>
	    </div>
	    <%@include file="approve_process_esb.jsp"%> 
	</div>
	 <%@include file="workflow_approve_button_esb.jsp" %>
</div>
</body>

</html>