<%@page import="com.deppon.montal.module.crm.damin.QueryWorkflowInfoResponse"%>
<%@page import="com.deppon.montal.module.crm.damin.RecompenseInfo"%>
<%@page import="com.deppon.montal.module.crm.damin.AwardItem"%>
<%@page import="com.deppon.montal.module.crm.damin.DeptCharge"%>
<%@page import="java.util.List"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_ios.jsp" %>
</head>
<%
 request.setCharacterEncoding("UTF-8");
 response.setCharacterEncoding("UTF-8");
%>
<%
	QueryWorkflowInfoResponse responseEntity = (QueryWorkflowInfoResponse)request.getAttribute("queryWorkflowInfoResponse");
	RecompenseInfo  info = responseEntity.getRecompenseInfo();
	List<AwardItem> awardItems = info.getAwardItems();
    List<DeptCharge> deptCharges = info.getDeptCharges();
%>
<body>
<div id="list">
<%@include file="/jsp/ios/work_items_head.jsp" %>
   <!--div2 S-->
   <div id="div2">
	   	<div class="ulBox2">
			<ul>
			   <li>工作流:<em>常规理赔申请</em></li>
			   <li>运单号:<em><%=info.getTransportOrErrorCode()%></em></li>
			   <li>运输类型:<em><%=info.getHaulType()%></em></li>
			   <li>始发站:<em><%=info.getStartingStation()%></em></li>
			   <li>报价人:<em><%=info.getInsuredUnits()%></em></li>
			   <li>联系电话:<em><%=info.getContactPhone()%></em></li>
			   <li>收货部门:<em><%=info.getReceivingDept()%></em></li>
			   <li>货物名称:<em><%=info.getGoodsName()%></em></li>
			   <li>件/重/体:<em><%=info.getGoodsAttribute()%></em></li>
			   <li>保险金额:<em><%=info.getInsuredAmount()%></em></li>
			   <li>目标部门:<em><%=info.getTargetDept()%></em></li>
			   <li>发货日期:<em><%=info.getSendingDateStr()%></em></li>
			   <li>出险日期:<em><%=info.getDangerDateStr()%></em></li>
			   <li>所属区域:<em><%=info.getArea()%></em></li>
			   <li>理赔类型:<em><%=info.getClaimsType()%></em></li>
			   <li>冲账方式:<em><%=info.getOffsetType()==null?"":info.getOffsetType()%></em></li>
			   <li>报案人:<em><%=info.getCaseReporterName()%></em></li>
			   <li>报案部门:<em><%=info.getReportDeptName()%></em></li>
			   <li>报案日期:<em><%=info.getReportDateStr()%></em></li>
			   <li>处理人:<em><%=info.getHandler()%></em></li>
			   <li>处理日期:<em><%=info.getHandleDateStr()%></em></li>
			   <li>索赔金额:<em><%=info.getClaimAmount()%></em></li>
			   <li>正常理赔金额:<em><%=info.getNormalAmount()%></em></li>
			   <li>实际理赔金额:<em><%=info.getActualClaimsAmount()%></em></li>
			   <li>入公司费用:<em><%=info.getToCompanyCost()%></em></li>
			   <li>入公司部门费用:
				   <em>
				   		<%
				   			DeptCharge obj1 = new DeptCharge();
						   	for(int i=0;i<deptCharges.size();i++){
						   		obj1 = deptCharges.get(i);
					   %>
					   <%= obj1.getDeptName() + "  " + obj1.getAmount() + "</br>"%>
					   <%	
					   }%>
				   </em>
			   </li>
			   <li>出险情况说明:<em><%=info.getIssueItemDesc()%></em></li>
			   <li>其他费用说明:<em><%=info.getOtherCost()%></em></li>
			   <li>奖罚说明:
			   		<em>
				   		<%
						   	AwardItem obj5 = new AwardItem();
						   	for(int i=0;i<awardItems.size();i++){
						   		obj5 = awardItems.get(i);
					   %>
					   <%= obj5.getDeptName() + "  " + obj5.getAwardType() + "</br>"%>
					   <%	
					   }%>
				   </em>
			   </li>
			   <li>责任部门:<em><%=info.getResponsibleDept()%></em></li>
			</ul>
		</div>
		<%@include file="approve_process.jsp" %>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>