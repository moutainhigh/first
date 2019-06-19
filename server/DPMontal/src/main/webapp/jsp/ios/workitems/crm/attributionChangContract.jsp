<%@page import="java.util.List"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.conf.F_Constants"%>
<%@page import="com.deppon.montal.conf.Constants"%>
<%@page import="com.deppon.montal.module.crm.damin.QueryWorkflowInfoResponse"%>
<%@page import="com.deppon.montal.module.crm.damin.ContractInfo"%>
<%@page import="com.deppon.montal.module.crm.damin.ApprovalInfo"%>
<%@page import="com.deppon.montal.module.crm.damin.FileInfo"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title><%=InitDataServlet.getValue("page_title")%>-待办事项</title>
<meta http-equiv="Content-Type"
	content="application/xhtml+xml; charset=UTF-8" />
<%@include file="/common_ios.jsp"%>
<style type="text/css">
li {
	word-wrap: break-word;
}
</style>
</head>
<%
QueryWorkflowInfoResponse info = (QueryWorkflowInfoResponse)request.getAttribute("queryWorkflowInfoResponse");
ContractInfo base = info.getContractinfo();
List<ApprovalInfo>  approvalInfos = info.getApprovalInfo();
List<FileInfo> mobileApprovalInfo = info.getFileInfo();
String processdefname = (String)request.getAttribute("processDefName");
%>
<body>
	<div id="list">
		<%@include file="/jsp/ios/work_items_head.jsp"%>
		<!--div2 S-->
		<div id="div2">
			<div class="ulBox2">
				<ul>
				<li style="border-top: 1px none #aaa;">
					<em class="yellow">基本信息</em>
				</li>
				<li>
				   工作流:
				   <em>
				 <% if("com.deppon.bpms.module.crm.bpsdesign.administLegal.attributionChangContract".equals(processdefname)){%>
					   月结合同归属变更
				 <%}else{%>
				 月结合同归属变更
				 <%} %>  
				 </em>
				</li>
				<li>
				   申请人工号:
				   <em id="workid"><%=base.getApplyPersonCode() %></em>
				</li>
				   <li>
					  申请人:
					  <em><%= base.getApplyPersonName() %></em>
				   </li>
				<li>
					  所属事业部:
					  <em><%=base.getDivisionCode()%></em>
				   </li>
				   <li>
					  所属部门:
					  <em><%=base.getApplyPersonDept()%></em>
				   </li>
					 <li>
					  申请类型:
					  <em><%=base.getApplyType()%></em>
				   </li>
				   <li>
						<em class="yellow"></em>
				   </li>	
				   <li>
					  合同序号:
					  <em><%=base.getContractNumber()%></em>
				   </li>
					<li>
						所属子公司:
						<em><%=base.getSubsidiary()%></em>
					</li>
					<li>合同起始日期:<em><%=FormatUtil.formatDate(base.getContractStartDate(),"yyyy-MM-dd") %></em></li>
					<li>
						合同到期日期:
						<em><%=FormatUtil.formatDate(base.getContractEndDate(),"yyyy-MM-dd")%></em>
					</li>
					<li>
						客户编码:
						<em><%=base.getCustomerCode()%></em>
					</li>
					 <li>
					  客户名称:
					  <em><%=base.getCustomerName()%></em>
				   </li>
				    <li>
					  客户全称:
					  <em><%=base.getCustomerAllName()%></em>
				   </li>
				   <li>
						结款日期:
						<em><%=base.getSettleAccountsDate()%></em>
					</li> 
					 <li>
					结算限额:
					  <em><%=base.getBalanceAccount()%></em>
				   </li>
					<li>
					  联系人手机:
					  <em><%= base.getContactPhone() == null ? "":base.getContactPhone()%></em>
				   </li>
					 <li>
					  联系人电话:
					  <em><%=base.getContactTel() == null ? "":base.getContactTel()%></em>
				   </li>
				    <li>
					  签署合同公司:
					  <em><%=base.getSignCompany() == null ? "":base.getSignCompany()%></em>
				   </li>
				   <li>
						协议联系人:
						<em><%=base.getProtocolContactName() == null ? "":base.getProtocolContactName()%></em>
					</li>
				    <li>
					  发票标记:
					  <em><%= base.getInvoiceTypeName() == null ? "":base.getInvoiceTypeName()%></em>
				   </li>
				   
				    <li class="yellow">
						<em class="yellow">零担</em>
					</li>
				   <!-- 零担 -->
				    <li class='topLine'>
					  近三月发货金额:<!-- amountOfConsignment -->
					  <em><%=base.getAmountOfConsignment()%></em>
				   </li>
				    <li>
					  结款方式:
					  <em><%= base.getNodeSectionType()== null ?"":base.getNodeSectionType()%></em>
				   </li>
					 <li  >
					  优惠类型:
					  <em><%=base.getPreferentialType()== null ?"":base.getPreferentialType()%></em>
				   </li>
					 <li  >
					  运费折扣:
					  <em><%=base.getFreightDiscount()== null ?"":base.getFreightDiscount()%></em>
				   </li>
					 <li  >
					  代收费率折扣:
					  <em><%=base.getGenerationRateDiscount()== null ?"":base.getGenerationRateDiscount()%></em>
				   </li>
					 <li  >
					  保价费率折扣:
					  <em><%=base.getChargeRateDiscount()== null ?"":base.getChargeRateDiscount()%></em>
				   </li>
				   <li  >
					  接货费:
					  <em><%=base.getCargoFeeDiscount()==null?"":base.getCargoFeeDiscount()%></em>
				   </li>
				    <li  >
					  送货费折扣:
					  <em><%= base.getDeliveryFeeDiscount()==null?"":base.getDeliveryFeeDiscount()%></em>
				   </li>
				    <li  >
					  价格版本:
					  <em><%=FormatUtil.formatDate(base.getPriceVersionDate(),"yyyy-MM-dd hh:mm:ss")%></em>
				   </li>
				   
				   <li class="yellow">
						<em class="yellow">快递</em>
					</li>
					 <li  >
					  近三月发货金额:
					  <em><%=base.getExpAmountOfConsignMent()%></em>
				   </li>    
					
				   <li>
					  结款方式:
					  <em><%=base.getExpNodesectionType()==null?"":base.getExpNodesectionType()%></em>
				   </li>
				   <li>
					  优惠类型:
					  <em><%=base.getExpressPreferentialType()==null?"":base.getExpressPreferentialType()%></em>
				   </li>
				  
				   <li>
					  运费折扣:
					  <em><%=base.getExpFreightDiscount()== null?"":base.getExpFreightDiscount()%></em>
				   </li>
				  <li>
					代收费率折扣:
					  <em><%=base.getGenerationRateDiscount()== null?"":base.getGenerationRateDiscount() %></em>
				   </li>
				   <li>
					  保价费率折扣:
					  <em><%=base.getExpChargeRateDiscount()== null?"":base.getExpChargeRateDiscount() %></em>
				   </li>
				   <li>
					  价格版本:
					  <em><%= FormatUtil.formatDate(base.getExpPriceVersiondate(),"yyyy-MM-dd hh:mm:ss")%></em>
				   </li>
				   <li>
					  申请事由:
					  <em><%=base.getApplyReason()%></em>
				   </li>
				    <li class="yellow">
						<em class="yellow">申请归属变更如下</em>
					</li>
					 <li>
					现在归属部门:
					  <em><%=base.getAscriptionDeptName()== null?"":base.getAscriptionDeptName() %></em>
				   </li>
				    <li>
					  申请变更部门:
					  <em><%=base.getApplyRenewalDeptName()== null?"":base.getApplyRenewalDeptName() %></em>
				   </li>
<!-- 				    <li> -->
<!-- 					  已上传附件: -->
<%-- 					  <em><%=base.getSubbankName()%></em> --%>
<!-- 				   </li>  -->
				</ul>
			</div>
			<%@include file="approve_process.jsp"%>
		</div>
		<%@include file="workflow_approve_button.jsp"%>
	</div>
<script type="text/javascript">
	$(function() {
// 			//直接上级、起草人；
// 			var activitydefid = $("#activitydefid").val();
// 			if (activitydefid != 'zjsj') {
// 				$("#approve_area").hide();
// 				$("#div3").hide();
// 			}
		});
	</script>
</body>
</html>