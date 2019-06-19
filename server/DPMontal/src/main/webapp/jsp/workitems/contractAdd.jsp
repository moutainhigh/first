<%@page import="com.deppon.montal.model.OaContractAdd"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.montal.conf.F_Constants"%>
<%@page import="com.deppon.montal.model.OaResignApply"%>
<%@page import="com.deppon.montal.conf.Constants"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_win8.jsp" %>
</head>
<body>
<% OaContractAdd info = (OaContractAdd)request.getAttribute("oacontractAdd"); %>
<div id="list">
    	 <%@include file="wf_head_win8.jsp" %>
    <!--div2 S-->
    <div id="div2">
    	<h3 class="yellow">审批工作流</h3>
	    	<div class="tableBox">
		    	<table width="100%">
		    		<tr>
						<th>工作流号:</th>
						<td id="workid"><%=info.getProcessinstid() %></td>
					</tr>
					<tr>
						<th>工作流:</th>
						<td>月结客户签订申请<input type="hidden" id ="type_id" value="contractinfo"></td>
					</tr>
					<tr>
						<th>申请人工号:</th>
						<td><%=info.getApplypersoncode()%></td>
					</tr>
					<tr>
						<th>申请人姓名:</th>
						<td><%=info.getApplypersonname()%></td>
					</tr>
					<tr>
						<th>所属事业部:</th>
						<td><%=info.getDivisioncode()%></td>
					</tr>
					<tr>
						<th>所属部门:</th>
						<td><%=info.getApplypersondept()%></td>
					</tr>
					<tr>
						<th>申请类型:</th>
						<td><%=info.getApplytype()%></td>
					</tr>
					<tr>
						<th>合同序号:</th>
						<td><%=info.getContractnumber()==null?"":info.getContractnumber()%></td>
					</tr>
					<tr>
						<th>所属子公司:</th>
						<td><%=info.getSubsidiary()==null?"":info.getSubsidiary()%></td>
					</tr>
					<tr>
						<th>合同起始日期:</th>
						<td><%=info.getContractstartdate()==null?"":info.getContractstartdate()%></td>
					</tr>
					<tr>
						<th>合同到期日期:</th>
						<td><%=info.getContractenddate()==null?"":info.getContractenddate()%></td>
					</tr>
					<tr>
						<th>客户编码:</th>
						<td><%=info.getCustomercode()==null?"":info.getCustomercode()%></td>
					</tr>
					<tr>
						<th>客户名称:</th>
						<td><%=info.getCustomername()==null?"":info.getCustomername()%></td>
					</tr>
					<tr>
						<th>近三个月发货金额:</th>
						<td><%=info.getAmountofconsignment()==null?"":info.getAmountofconsignment()%></td>
					</tr>
					<tr>
						<th>客户全称:</th>
						<td><%=info.getCustomerallname()==null?"":info.getCustomerallname()%></td>
					</tr>
					<tr>
						<th>借款方式:</th>
						<td><%=info.getNodesectiontype()==null?"":info.getNodesectiontype()%></td>
					</tr>
					<tr>
						<th>结算限额:</th>
						<td><%=info.getBalanceaccount()==null?"":info.getBalanceaccount()%></td>
					</tr>
					<tr>
						<th>借款日期:</th>
						<td><%=info.getSettleaccountsdate()==null?"":info.getSettleaccountsdate()%></td>
					</tr>
					<tr>
						<th>运费折扣:</th>
						<td><%=info.getFreightdiscount()==null?"":info.getFreightdiscount()%></td>
					</tr>
					<tr>
						<th>优惠类型:</th>
						<td><%=info.getPreferentialtype()==null?"":info.getPreferentialtype()%></td>
					</tr>
					<tr>
						<th>代收费率折扣:</th>
						<td><%=info.getGenerationratediscount()==null?"":info.getGenerationratediscount()%></td>
					</tr>
					<tr>
						<th>保价费率折扣:</th>
						<td><%=info.getChargeratediscount()==null?"":info.getChargeratediscount()%></td>
					</tr>
					<tr>
						<th>接货费折扣:</th>
						<td><%=info.getCargofeediscount()==null?"":info.getCargofeediscount()%></td>
					</tr>
					<tr>
						<th>送货费折扣:</th>
						<td><%=info.getDeliveryfeediscount()==null?"":info.getDeliveryfeediscount()%></td>
					</tr>
					<tr>
						<th>协议联系人:</th>
						<td><%=info.getProtocolcontactname()==null?"":info.getProtocolcontactname()%></td>
					</tr>
					<tr>
						<th>联系人手机:</th>
						<td><%=info.getContactphone()==null?"":info.getContactphone()%></td>
					</tr>
					<tr>
						<th>联系人电话:</th>
						<td><%=info.getContacttel()==null?"":info.getContacttel()%></td>
					</tr>
					<tr>
						<th>申请事由:</th>
						<td style="word-wrap:break-word;word-break:break-all"><%=info.getApplyreason()== null ? "" : info.getApplyreason()%></td>
					</tr>
					<%@include file="approve_process.jsp" %>
		    	</table>
	    </div>
    <%@include file="workflow_approve_button.jsp" %>
   </div>
</div>
</body>
</html>