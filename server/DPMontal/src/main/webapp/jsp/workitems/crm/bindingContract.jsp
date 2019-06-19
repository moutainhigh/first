<%@page import="java.util.List"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.conf.F_Constants"%>
<%@page import="com.deppon.montal.conf.Constants"%>
<%@page import="com.deppon.montal.module.crm.damin.QueryWorkflowInfoResponse"%>
<%@page import="com.deppon.montal.module.crm.damin.ContractInfo"%>
<%@page import="com.deppon.montal.module.crm.damin.ApprovalInfo"%>
<%@page import="com.deppon.montal.module.crm.damin.FileInfo"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_win8.jsp" %>
</head>

<body>
 <%
 QueryWorkflowInfoResponse info = (QueryWorkflowInfoResponse)request.getAttribute("queryWorkflowInfoResponse");
 ContractInfo base = info.getContractinfo();
 List<ApprovalInfo>  approvalInfos = info.getApprovalInfo();
 List<FileInfo> mobileApprovalInfo = info.getFileInfo();
 String processdefname = (String)request.getAttribute("processDefName");
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
				   <th >工作流:</th>
				   <td> <% if("com.deppon.bpms.module.crm.bpsdesign.administLegal.bindingContract".equals(processdefname)){%>
					    月结合同绑定
				 <%}else{%>
				   月结合同绑定
				 <%} %>  </td>
				</tr>
				<tr>
				   <th>申请人工号:</th>
				   <td id="workid"><%=base.getApplyPersonCode() %></td>
				</tr>
				   <tr>
					  <th >申请人:</th>
					  <td><%= base.getApplyPersonName() %></td>
				   </tr>
					 <tr>
					  <th >所属事业部:</th>
					  <td><%=base.getDivisionCode()%></td>
				   </tr>
				   <tr>
					  <th >所属部门:</th>
					  <td><%=base.getApplyPersonDept()%></td>
				   </tr>
					 <tr>
					  <th >申请类型:</th>
					  <td><%=base.getApplyType()%></td>
				   </tr>
				   <tr>
						<th colspan="2" class="yellow"></th>
				   </tr>	
				   <tr>
					  <th>合同序号:</th>
					  <td><%=base.getContractNumber()%></td>
				   </tr>
					<tr>
						<th >所属子公司:</th>
						<td><%=base.getSubsidiary()%></td>
					</tr>
					<tr><th>合同起始日期:</th><td><%=FormatUtil.formatDate(base.getContractStartDate(),"yyyy-MM-dd")%></td></tr>
					<tr>
						<th >合同到期日期:</th>
						<td><%=FormatUtil.formatDate(base.getContractEndDate(),"yyyy-MM-dd")%></td>
					</tr>
					<tr>
						<th >客户编码:</th>
						<td><%=base.getCustomerCode()%></td>
					</tr>
					 <tr>
					  <th>客户名称:</th>
					  <td><%=base.getCustomerName()%></td>
				   </tr>
				    <tr>
					  <th>客户全称:</th>
					  <td><%=base.getCustomerAllName()%></td>
				   </tr>
				   <tr>
						<th>结款日期:</th>
						<td><%=base.getSettleAccountsDate()%></td>
					</tr> 
					 <tr>
					<th>结算限额:</th>
					  <td><%=base.getBalanceAccount()%></td>
				   </tr>
					<tr>
					  <th>联系人手机:</th>
					  <td><%= base.getContactPhone() == null ? "":base.getContactPhone()%></td>
				   </tr>
					 <tr>
					  <th>联系人电话:</th>
					  <td><%=base.getContactTel() == null ? "":base.getContactTel()%></td>
				   </tr>
				    <tr>
					  <th>签署合同公司:</th>
					  <td><%=base.getSignCompany() == null ? "":base.getSignCompany()%></td>
				   </tr>
				   <tr>
						<th >协议联系人:</th>
						<td><%=base.getProtocolContactName() == null ? "":base.getProtocolContactName()%></td>
					</tr>
				    <tr>
					  <th>发票标记:</th>
					  <td><%= base.getInvoiceTypeName() == null ? "":base.getInvoiceTypeName()%></td>
				   </tr>
				   
				   
				   
				    <tr class="yellow">
						<td colspan="2" >零担</td>
					</tr>
				   <!-- 零担 -->
				   <tr class='topLine'>
					  <th>近三月发货金额:</th><!-- amountOfConsignment -->
					  <td><%=base.getAmountOfConsignment()%></td>
				   </tr>
				    <tr>
					  <th>结款方式:</th>
					  <td><%=base.getNodeSectionType()== null ?"":base.getNodeSectionType()%></td>
				   </tr>
					 <tr  >
					  <th>优惠类型:</th>
					  <td><%=base.getPreferentialType()== null ?"":base.getPreferentialType()%></td>
				   </tr>
					 <tr  >
					  <th>运费折扣:</th>
					  <td><%=base.getFreightDiscount()== null ?"":base.getFreightDiscount()%></td>
				   </tr>
					 <tr  >
					  <th>代收费率折扣:</th>
					  <td><%=base.getGenerationRateDiscount()== null ?"":base.getGenerationRateDiscount()%></td>
				   </tr>
					 <tr  >
					  <th>保价费率折扣:</th>
					  <td><%=base.getChargeRateDiscount()== null ?"":base.getChargeRateDiscount()%></td>
				   </tr>
				   <tr  >
					  <th>接货费:</th>
					  <td><%=base.getCargoFeeDiscount()== null?"":base.getCargoFeeDiscount()%></td>
				   </tr>
				    <tr  >
					  <th>送货费折扣:</th>
					  <td><%= base.getDeliveryFeeDiscount()== null?"":base.getDeliveryFeeDiscount()%></td>
				   </tr>
				    <tr>
					  <th>价格版本:</th>
					  <td><%=FormatUtil.formatDate(base.getPriceVersionDate(),"yyyy-MM-dd hh:mm:ss")%></td>
				   </tr>
				   
				   <tr class="yellow">
						<td colspan="2" >快递</td>
					</tr>
					 <tr  >
					  <th>近三月发货金额:</th>
					  <td><%=base.getExpAmountOfConsignMent()%></td>
				   </tr>    
					
				   <tr>
					  <th>结款方式:</th>
					  <td><%=base.getExpNodesectionType()==null?"":base.getExpNodesectionType()%></td>
				   </tr>
				   <tr>
					  <th>优惠类型:</th>
					  <td><%=base.getExpressPreferentialType()==null?"":base.getExpressPreferentialType()%></td>
				   </tr>
				  
				   <tr>
					  <th>运费折扣:</th>
					  <td><%=base.getExpFreightDiscount()== null?"":base.getExpFreightDiscount()%></td>
				   </tr>
				    <tr>
					  <th>代收费率折扣:</th><!-- 客户编码(合同编码)/  即日退代收折扣(无) -->
					  <td><%=base.getGenerationRateDiscount()==null?"":base.getGenerationRateDiscount() %></td>
				   </tr>
				   <tr>
					  <th>保价费率折扣:</th>
					  <td><%=base.getExpChargeRateDiscount()==null?"":base.getExpChargeRateDiscount()%></td>
				   </tr>
				   <tr>
					  <th>价格版本:</th>
					  <td><%= FormatUtil.formatDate(base.getExpPriceVersiondate(),"yyyy-MM-dd hh:mm:ss")%></td>
				   </tr>
				   <tr>
					  <th>申请事由:</th>
					  <td><%=base.getApplyReason()%></td>
				   </tr>
				    <tr class="yellow">
						<td colspan="2" >申请绑定如下</td>
					</tr>
					 <tr  >
					  <th>合同归属部门:</th>
					   <td><%=base.getContrctAscriptionDeptName()==null?"":base.getContrctAscriptionDeptName()%></td>
				   </tr>    
					
				   <tr>
					  <th>合同绑定部门:</th>
					  <td><%=base.getApplyBondingDeptName()==null?"":base.getApplyBondingDeptName()%></td>
				   </tr>
<!-- 				    <tr> -->
<!-- 					  <th>已上传附件:</th> -->
<%-- 					  <td><%=base.getSubbankName()%></td> --%>
<!-- 				   </tr>  -->
		  </table>
		  <%@include file="approve_process.jsp" %>
		</div>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
	<input type="hidden" value="<%=request.getAttribute("activitydefid")%>" id="activitydefid">
</div>
<script type="text/javascript">
</script>
</body>
</html>