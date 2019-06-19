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
	<%@include file="/common_win8.jsp" %>
	
</head>

<body>
 <%
 QueryWorkflowInfoResponse responseCrm = (QueryWorkflowInfoResponse)request.getAttribute("queryWorkflowInfoResponse");
 ContractInfo info = responseCrm.getContractinfo();
 %>
<div id="list">
	<%@include file="../wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
	    		<tr>
					<th colspan="2" class="yellow">基本信息</th>
				</tr>
			   	<tr>
				  <th >申请人工号:</th>
				  <td><%= info.getApplyPersonCode()%></td>
			   	</tr>
				<tr>
				  <th >申请人姓名:</th>
				  <td><%=info.getApplyPersonName()%></td>
			   	</tr>
				<tr>
				  <th >所属事业部:</th>
				  <td><%=info.getDivisionCode() == null ? "" : info.getDivisionCode()%></td>
			   	</tr>
				<tr>
				  <th >所属部门:</th>
				  <td><%=info.getApplyPersonDept() == null ? "" : info.getApplyPersonDept()%></td>
			  	 </tr>
			   	<tr>
				  <th >申请类型:</th>
				  <td><%= info.getApplyType() == null ? "" : info.getApplyType()%></td>
			   	</tr>
				<tr>
				  <th >原合同序号:</th>
				  <td><%=info.getOldContractNumber() == null ? "" : info.getOldContractNumber()%></td>
			    </tr>
			    	<tr>
				  <th >所属子公司:</th>
				  <td><%= info.getSubsidiary() == null ? "" : info.getSubsidiary()%></td>
			   	</tr>
			   	<tr>
				  <th >合同开始日期:</th>
				  <td><%=info.getContractStartDate() == null ? "" : FormatUtil.formatDate(info.getContractStartDate(),"yyyy-MM-dd")%></td>
			   	</tr>
				<tr>
				  <th >合同到期日期:</th>
				  <td><%=info.getContractEndDate() == null ? "" : FormatUtil.formatDate(info.getContractEndDate(),"yyyy-MM-dd")%></td>
			   	</tr>
				<tr>
				  <th >客户编码:</th>
				  <td><%=info.getCustomerCode() == null ? "" : info.getCustomerCode()%></td>
			   	</tr>
			   	<tr>
				  <th >客户名称:</th>
				  <td><%=info.getCustomerName() == null ? "" : info.getCustomerName()%></td>
			   	</tr>
				<tr>
				  <th >客户全称:</th>
				  <td><%=info.getCustomerAllName() == null ? "" : info.getCustomerAllName()%></td>
			  	 </tr>
			   	<tr>
				  <th >结款日期:</th>
				  <td><%= info.getNodeSectionType() == null ? "" : info.getSettleAccountsDate()%></td>
			   	</tr>
			   	<tr>
				  <th >结算限额:</th>
				  <td><%= info.getBalanceAccount() == null ? "" : info.getBalanceAccount()%></td>
			   	</tr>
				<tr>
				  <th >联系人电话:</th>
				  <td><%=info.getContactTel() == null ? "" : info.getContactTel()%></td>
			    </tr>
			    <tr>
				  <th >联系人手机:</th>
				  <td><%= info.getContactPhone() == null ? "" : info.getContactPhone()%></td>
			   	</tr>
			   	<tr>
				  <th >签署合同公司:</th>
				  <td><%= info.getSignCompany() == null ? "" : info.getSignCompany()%></td>
			   	</tr>
				<tr>
				  <th >协议联系人:</th>
				  <td><%=info.getProtocolContactName() == null ? "" : info.getProtocolContactName()%></td>
			   	</tr>
				<tr>
				  <th >发票标记:</th>
				  <td><%=info.getInvoiceTypeName() == null ? "" : info.getInvoiceTypeName()%></td>
			   	</tr>
				
			   <tr>
					<th colspan="2" class="yellow">零担</th>
			   </tr>	
			   <tr>
					<th >近三月发货金额:</th>
					<td><%=info.getAmountOfConsignment() == null ? "" : info.getAmountOfConsignment()%></td>
				</tr>
				<tr>
					<th >结款方式:</th>
					<td><%=info.getNodeSectionType() == null ? "" : info.getNodeSectionType()%></td>
				</tr>
				<tr>
					<th >优惠类型:</th>
					<td><%=info.getPreferentialType() == null ? "" : info.getPreferentialType()%></td>
				</tr>
				<tr>
					<th >运费折扣:</th>
					<td><%= info.getFreightDiscount() == null ? "" : info.getFreightDiscount()%></td>
				</tr>
				<tr>
					<th >代收费率折扣:</th>
					<td><%=info.getGenerationRateDiscount() == null ? "" : info.getGenerationRateDiscount()%></td>
				</tr>
				<tr>
					<th >保价费率折扣:</th>
					<td><%=info.getChargeRateDiscount() == null ? "" : info.getChargeRateDiscount()%></td>
				</tr>
				<tr>
					<th >接货费:</th>
					<td><%=info.getCargoFeeDiscount() == null ? "" : info.getCargoFeeDiscount()%></td>
				</tr>
				<tr>
					<th >送货费折扣:</th>
					<td><%=info.getDeliveryFeeDiscount() == null ? "" : info.getDeliveryFeeDiscount()%></td>
				</tr>
				<tr>
					<th colspan="2" class="yellow">快递</th>
			   </tr>	
			   <tr>
					<th >近三月发货金额:</th>
					<td><%=info.getExpAmountOfConsignMent() == null ? "" : info.getExpAmountOfConsignMent()%></td>
				</tr>
				<tr>
					<th >结款方式:</th>
					<td><%=info.getExpNodesectionType() == null ? "" : info.getExpNodesectionType()%></td>
				</tr>
				<tr>
					<th >优惠类型:</th>
					<td><%=info.getExpressPreferentialType() == null ? "" : info.getExpressPreferentialType()%></td>
				</tr>
				<tr>
					<th >运费折扣:</th>
					<td><%=info.getExpFreightDiscount() == null ? "" : info.getExpFreightDiscount()%></td>
				</tr>
				<tr>
					<th >即日退代收折扣:</th>
					<td><%=info.getExpWxpgenerationRateDiscount() == null ? "" : info.getExpWxpgenerationRateDiscount()%></td>
				</tr>
				<tr>
					<th >保价费率折扣:</th>
					<td><%=info.getExpChargeRateDiscount() == null ? "" : info.getExpChargeRateDiscount()%></td>
				</tr> 
				<tr>
					<th >价格版本:</th>
					<td><%=info.getExpPriceVersiondate() == null ? "" : FormatUtil.formatDate(info.getExpPriceVersiondate(),"yyyy-MM-dd hh:mm:ss")%></td>
				</tr>
				<tr>
					<th colspan="2" class="yellow">合同信息修改如下：</th>
			    </tr>	
			    <tr>
					<th >合同序号:</th>
					<td><%=info.getContractNumber() == null ? "" : info.getContractNumber()%></td>
				</tr>
				<tr>
					<th >结算限额:</th>
					<td><%=info.getNewBalanceAccount() == null ? "" : info.getNewBalanceAccount()%></td>
				</tr>
				<tr>
					<th >签署合同公司:</th>
					<td><%=info.getNewSignCompany() == null ? "" : info.getNewSignCompany()%></td>
				</tr>
				<tr>
					<th >发票标记:</th>
					<td><%=info.getNewInvoiceTypeName() == null ? "" : info.getNewInvoiceTypeName()%></td>
				</tr>
				<tr>
					<th colspan="2" class="yellow">零担：</th>
			    </tr>	
			    <tr>
					<th >优惠类型:</th>
					<td><%=info.getNewPreferentialType() == null ? "" : info.getNewPreferentialType()%></td>
				</tr>
				<tr>
					<th >运费折扣:</th>
					<td><%=info.getNewFreightDiscount() == null ? "" : info.getNewFreightDiscount()%></td>
				</tr>
				<tr>
					<th >代收费率折扣:</th>
					<td><%=info.getNewGenerationRateDiscount() == null ? "" : info.getNewGenerationRateDiscount()%></td>
				</tr>
				<tr>
					<th >保价费率折扣:</th>
					<td><%=info.getNewChargeRateDiscount() == null ? "" : info.getNewChargeRateDiscount()%></td>
				</tr>
				<tr>
					<th >接货费:</th>
					<td><%=info.getNewCargoFeeDiscount() == null ? "" : info.getNewCargoFeeDiscount()%></td>
				</tr>
				<tr>
					<th >送货费折扣:</th>
					<td><%=info.getNewDeliveryFeeDiscount() == null ? "" : info.getNewDeliveryFeeDiscount()%></td>
				</tr>
				<tr>
					<th >价格版本:</th>
					<td><%=info.getPriceVersionDate() == null ? "" : FormatUtil.formatDate(info.getPriceVersionDate(),"yyyy-MM-dd hh:mm:ss")%></td>
				</tr>
				<tr>
					<th colspan="2" class="yellow">快递：</th>
			    </tr>	
			    <tr>
					<th >优惠类型:</th>
					<td><%=info.getExpNewPreferentialType() == null ? "" : info.getExpNewPreferentialType()%></td>
				</tr>
				<tr>
					<th >运费折扣:</th>
					<td><%=info.getExpNewFreightDiscount() == null ? "" : info.getExpNewFreightDiscount()%></td>
				</tr>
				<tr>
					<th >即日退代收折扣:</th>
					<td><%=info.getExpNewDiscount() == null ? "" : info.getExpNewDiscount()%></td>
				</tr>
				<tr>
					<th >保价费率折扣:</th>
					<td><%=info.getExpNewChargeRateDiscount() == null ? "" : info.getExpNewChargeRateDiscount()%></td>
				</tr>
				<tr>
					<th >价格版本:</th>
					<td><%=info.getExpPriceVersiondate() == null ? "" : FormatUtil.formatDate(info.getExpPriceVersiondate(),"yyyy-MM-dd hh:mm:ss")%></td>
				</tr>
				<tr>
					<th >申请事由:</th>
					<td><%=info.getApplyReason() == null ? "" : info.getApplyReason()%></td>
				</tr>
		  </table>
		  <%@include file="approve_process.jsp" %>
		</div>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>