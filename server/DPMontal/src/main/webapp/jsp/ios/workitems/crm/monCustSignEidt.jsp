<%@page import="java.util.List"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.model.OaRewardpunishmentInfo"%>
<%@page import="com.deppon.montal.model.OaDeptexpenses"%>
<%@page import="com.deppon.montal.model.OaAccidentdescriptionInfo"%>
<%@page import="com.deppon.montal.model.OaNomalClaim"%>
<%@page import="com.deppon.montal.conf.F_Constants"%>
<%@page import="com.deppon.montal.conf.Constants"%>

<%@page import="com.deppon.montal.module.crm.damin.QueryWorkflowInfoResponse" %>
<%@page import="com.deppon.montal.module.crm.damin.RecompenseInfo"%>
<%@page import="com.deppon.montal.module.crm.damin.ContractInfo" %>
<%@page import="com.deppon.montal.module.crm.damin.OverpayInfo" %>
<%@page import="com.deppon.montal.module.crm.damin.ApprovalInfo" %>
<%@page import="com.deppon.montal.module.crm.damin.FileInfo" %>

<%@ page language="java"  pageEncoding="UTF-8"%> 
<%@page import="java.util.Date"%> 
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.apache.commons.lang.StringUtils" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<meta http-equiv = "Content-Type" content = "application/xhtml+xml; charset=UTF-8" />
	<%@include file="/common_ios.jsp" %>
	<style type="text/css">
	 li{word-wrap: break-word;}
	</style>
</head>

<body>
 <%
 QueryWorkflowInfoResponse responseCrm = (QueryWorkflowInfoResponse)request.getAttribute("queryWorkflowInfoResponse");
 ContractInfo info = responseCrm.getContractinfo();
 %>
<div id="list">
	<%@include file="/jsp/ios/work_items_head.jsp" %>
	<div id="div2">
    	<div class="ulBox2">
	    	<ul>
				<li class="first"><em class="yellow">基本信息</em></li>
				<li>申请人工号:<em><%= info.getApplyPersonCode()%></em></li>
				<li>申请人姓名:<em><%=info.getApplyPersonName()%></em></li>
				<li>所属事业部:<em><%=info.getDivisionCode()== null ? "" : info.getDivisionCode()%></em></li>
				<li>所属部门:<em><%=info.getApplyPersonDept()== null ? "" : info.getApplyPersonDept()%></em></li>
				<li>申请类型:<em><%= info.getApplyType()== null ? "" : info.getApplyType()%></em></li>
				<li>原合同序号:<em><%=info.getOldContractNumber()== null ? "" : info.getOldContractNumber()%></em></li>
				<li>所属子公司:<em><%= info.getSubsidiary()== null ? "" : info.getSubsidiary()%></em></li>
				<li>合同开始日期:<em><%=info.getContractStartDate()== null ? "" : FormatUtil.formatDate(info.getContractStartDate(),"yyyy-MM-dd")%></em></li>
				<li>合同到期日期:<em><%=info.getContractEndDate()== null ? "" : FormatUtil.formatDate(info.getContractEndDate(),"yyyy-MM-dd")%></em></li>
				<li>客户编码:<em><%=info.getCustomerCode()== null ? "" : info.getCustomerCode()%></em></li>
				<li>客户名称:<em><%=info.getCustomerName()== null ? "" : info.getCustomerName()%></em></li>
				<li>客户全称:<em><%=info.getCustomerAllName()== null ? "" : info.getCustomerAllName()%></em></li>
				<li>结款日期:<em><%= info.getNodeSectionType()== null ? "" : info.getSettleAccountsDate()%></em></li>
				<li>结算限额:<em><%= info.getBalanceAccount()== null ? "" : info.getBalanceAccount()%></em></li>
				<li>联系人电话:<em><%=info.getContactTel()== null ? "" : info.getContactTel()%></em></li>
				<li>联系人手机:<em><%= info.getContactPhone()== null ? "" : info.getContactPhone()%></em></li>
				<li>签署合同公司:<em><%= info.getSignCompany()== null ? "" : info.getSignCompany()%></em></li>
				<li>协议联系人:<em><%=info.getProtocolContactName()== null ? "" : info.getProtocolContactName()%></em></li>
				<li>发票标记:<em><%=info.getInvoiceTypeName()== null ? "" : info.getInvoiceTypeName()%></em></li>
				<li><em class="yellow">零担</em></li>
				<li>近三月发货金额:<em><%=info.getAmountOfConsignment() == null ? "" : info.getAmountOfConsignment()%></em></li>
				<li>结款方式:<em><%=info.getNodeSectionType() == null ? "" : info.getNodeSectionType()%></em></li>
				<li>优惠类型:<em><%=info.getPreferentialType() == null ? "" : info.getPreferentialType()%></em></li>
				<li>运费折扣:<em><%= info.getFreightDiscount() == null ? "" : info.getFreightDiscount()%></em></li>
				<li>代收费率折扣:<em><%=info.getGenerationRateDiscount() == null ? "" : info.getGenerationRateDiscount()%></em></li>
				<li>保价费率折扣:<em><%=info.getChargeRateDiscount() == null ? "" : info.getChargeRateDiscount()%></em></li>
				<li>接货费:<em><%=info.getCargoFeeDiscount() == null ? "" : info.getCargoFeeDiscount()%></em></li>
				<li>送货费折扣:<em><%=info.getDeliveryFeeDiscount() == null ? "" : info.getDeliveryFeeDiscount()%></em></li>
				<li><em class="yellow">快递</em></li>
				<li>近三月发货金额:<em><%=info.getExpAmountOfConsignMent() == null ? "" : info.getExpAmountOfConsignMent()%></em></li>
				<li>结款方式:<em><%=info.getExpNodesectionType() == null ? "" : info.getExpNodesectionType()%></em></li>
				<li>优惠类型:<em><%=info.getExpressPreferentialType() == null ? "" : info.getExpressPreferentialType()%></em></li>
				<li>运费折扣:<em><%=info.getExpFreightDiscount() == null ? "" : info.getExpFreightDiscount()%></em></li>
				<li>即日退代收折扣:<em><%=info.getExpWxpgenerationRateDiscount() == null ? "" : info.getExpWxpgenerationRateDiscount()%></em></li>
				<li>保价费率折扣:<em><%=info.getExpChargeRateDiscount() == null ? "" : info.getExpChargeRateDiscount()%></em></li>
				<li>价格版本:<em><%=info.getExpPriceVersiondate() == null ? "" : FormatUtil.formatDate(info.getExpPriceVersiondate(),"yyyy-MM-dd hh:mm:ss")%></em></li>
				<li><em class="yellow">合同信息修改如下：</em></li>
				<li>合同序号:<em><%=info.getContractNumber() == null ? "" : info.getContractNumber()%></em></li>
				<li>结算限额:<em><%=info.getNewBalanceAccount() == null ? "" : info.getNewBalanceAccount()%></em></li>
				<li>签署合同公司:<em><%=info.getNewSignCompany() == null ? "" : info.getNewSignCompany()%></em></li>
				<li>发票标记:<em><%=info.getNewInvoiceTypeName() == null ? "" : info.getNewInvoiceTypeName()%></em></li>
				<li><em class="yellow">零担：</em></li>
				<li>优惠类型:<em><%=info.getNewPreferentialType() == null ? "" : info.getNewPreferentialType()%></em></li>
				<li>运费折扣:<em><%=info.getNewFreightDiscount() == null ? "" : info.getNewFreightDiscount()%></em></li>
				<li>代收费率折扣:<em><%=info.getNewGenerationRateDiscount() == null ? "" : info.getNewGenerationRateDiscount()%></em></li>
				<li>保价费率折扣:<em><%=info.getNewChargeRateDiscount() == null ? "" : info.getNewChargeRateDiscount()%></em></li>
				<li>接货费:<em><%=info.getNewCargoFeeDiscount() == null ? "" : info.getNewCargoFeeDiscount()%></em></li>
				<li>送货费折扣:<em><%=info.getNewDeliveryFeeDiscount() == null ? "" : info.getNewDeliveryFeeDiscount()%></em></li>
				<li>价格版本:<em><%=info.getPriceVersionDate() == null ? "" : FormatUtil.formatDate(info.getPriceVersionDate(),"yyyy-MM-dd hh:mm:ss")%></em></li>
				<li><em class="yellow">快递：</em></li>
				<li>优惠类型:<em><%=info.getExpNewPreferentialType() == null ? "" : info.getExpNewPreferentialType()%></em></li>
				<li>运费折扣:<em><%=info.getExpNewFreightDiscount() == null ? "" : info.getExpNewFreightDiscount()%></em></li>
				<li>即日退代收折扣:<em><%=info.getExpNewDiscount() == null ? "" : info.getExpNewDiscount()%></em></li>
				<li>保价费率折扣:<em><%=info.getExpNewChargeRateDiscount() == null ? "" : info.getExpNewChargeRateDiscount()%></em></li>
				<li>价格版本:<em><%=info.getExpPriceVersiondate() == null ? "" : FormatUtil.formatDate(info.getExpPriceVersiondate(),"yyyy-MM-dd hh:mm:ss")%></em></li>
				<li>申请事由:<em><%=info.getApplyReason() == null ? "" : info.getApplyReason()%></em></li>
		  <%@include file="approve_process.jsp" %>
		  </ul>
		</div>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>