<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain.SupplierDisposalVo"%>
<%@page import="com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain.SupplierDisposalEntity"%>
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
	//供应商处置单
	SupplierDisposalVo info = (SupplierDisposalVo)request.getAttribute("lspResponseEntity");
	//供应商处置单表头信息查询
	SupplierDisposalEntity billList = info.getBillList();
 %>
<div id="list">
	<%@include file="/jsp/ios/work_items_head.jsp" %>
	<div id="div2">
		<h4 class="yellow">基本信息-维修结算单</h4>
    	<div class="ulBox2">
	    	<ul>				  
			   	<li>处置单号:<em><%=billList.getNumber()%></em></li>
				<li>申请人:<em><%=billList.getCreatorName()%></em></li>
				<li>申请时间:<em><%=FormatUtil.formatDate(billList.getCreateTime())%></em></li>
				<li>供应商编码:<em><%=billList.getSupplierNumber()%></em></li>
				<li>考核单号:<em><%=billList.getSurveyNumber()%></em></li>
				<li>供应商状态:<em><%=billList.getSupplierStatu()%></em></li>
				
				<li>供应商名称:<em><%=billList.getSupplierName()%></em></li>
				<li>年份:<em><%=billList.getYears()%></em></li>
				<li>考核周期:<em><%=billList.getSurveyCycle()%></em></li>
				<li>考核人:<em><%=billList.getSurveyPeople()%></em></li>
				<li>加权得分:<em><%=billList.getScoreDto()%></em></li>
				<li>罚款金额:<em><%=billList.getFinesDto()%></em></li>
				<li>引述合同条款:<em><%=billList.getContractProvision()%></em></li>
				<li>评语:<em><%=billList.getComment()%></em></li>
				<li>违规说明:<em><%=billList.getViolationDesc()%></em></li>
				<li>公函内容:<em><%=billList.getLettersContent()%></em></li>
          	</ul>
        </div>
	    <%@include file="approve_process_esb3.jsp"%> 
	</div>
	 <%@include file="workflow_approve_button_esb2.jsp" %>
</div>
</body>
</html>