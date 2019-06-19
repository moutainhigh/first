<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain.SupplierDisposalVo"%>
<%@page import="com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain.SupplierDisposalEntity"%>
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
	//供应商处置单
	SupplierDisposalVo info = (SupplierDisposalVo)request.getAttribute("lspResponseEntity");
	//供应商处置单表头信息查询
	SupplierDisposalEntity billList = info.getBillList();

 %>
<div id="list">
	<%@include file="../wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table>
	    		<tr><th colspan="2" class="yellow">基本信息</th></tr>
	    		<tr><th>工&nbsp;&nbsp;作&nbsp;&nbsp;流:</th><td>供应商处置单</td></tr>
				<tr><th>处置单号:</th><td><%=billList.getNumber()%></td></tr>
				<tr><th>申请人:</th><td><%=billList.getCreatorName()%></td></tr>
				<tr><th>申请时间:</th><td><%=FormatUtil.formatDate(billList.getCreateTime())%></td></tr>
				<tr><th>供应商编码:</th><td><%=billList.getSupplierNumber()%></td></tr>
				<tr><th>考核单号:</th><td><%=billList.getSurveyNumber()%></td></tr>
				<tr><th>供应商状态:</th><td><%=billList.getSupplierStatu()%></td></tr>
				
				<tr><th>供应商名称:</th><td><%=billList.getSupplierName()%></td></tr>
				<tr><th>年份:</th><td><%=billList.getYears()%></td></tr>
				<tr><th>考核周期:</th><td><%=billList.getSurveyCycle()%></td></tr>
				<tr><th>考核人:</th><td><%=billList.getSurveyPeople()%></td></tr>
				<tr><th>加权得分:</th><td><%=billList.getScoreDto()%></td></tr>
				<tr><th>罚款金额:</th><td><%=billList.getFinesDto()%></td></tr>
				<tr><th>引述合同条款:</th><td><%=billList.getContractProvision()%></td></tr>
				<tr><th>评语:</th><td><%=billList.getComment()%></td></tr>
				<tr><th>违规说明:</th><td><%=billList.getViolationDesc()%></td></tr>
				<tr><th>公函内容:</th><td><%=billList.getLettersContent()%></td></tr>
				
		  </table>
		  <%@include file="approve_process_esb3.jsp" %>
		</div>
	</div>
	<%@include file="workflow_approve_button_esb2.jsp" %>
</div>
</body>
</html>