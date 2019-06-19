<%@page import="com.deppon.montal.model.OaContractAdd"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.montal.conf.F_Constants"%>
<%@page import="com.deppon.montal.model.OaResignApply"%>
<%@page import="com.deppon.montal.conf.Constants"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title><%=InitDataServlet.getValue("page_title")%>-待办事项</title>
<%@include file="/common_ios.jsp"%>
</head>
<%
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
%>
<body>
	<div>
		<%@include file="/jsp/ios/work_items_head.jsp"%>
		<div id="div2">
			<div class="ulBox2">
				<ul>
					<%
						OaContractAdd info = (OaContractAdd) request
														.getAttribute("oacontractAdd");
					%>
					<li class="first">工作流号：<em><%=info.getProcessinstid()%> <input
							type="hidden" id="workid" value="<%=info.getProcessinstid()%>">
							<input type="hidden" id="type_id" value="oacontractAdd"> </em></li>
					<li>工作流：<em>月结客户签订申请</em></li>
					<li>申请人工号: <em><%=info.getApplypersoncode()%></em></li>
					<li>申请人姓名: <em><%=info.getApplypersonname()%></em></li>
					<li>所属事业部: <em><%=info.getDivisioncode()%></em></li>
					<li>所属部门: <em><%=info.getApplypersondept()%></em></li>
					<li>申请类型: <em><%=info.getApplytype()%></em></li>
<%-- 					<li>超系统额定: <em><%=info.getOverrange()==null?"":info.getOverrange()%></em></li> --%>
					<li>合同序号: <em><%=info.getContractnumber()==null?"":info.getContractnumber()%></em></li>
					<li>所属子公司: <em><%=info.getSubsidiary()==null?"":info.getSubsidiary()%></em></li>
					<li>合同起始日期: <em><%=info.getContractstartdate()==null?"":info.getContractstartdate()%></em></li>
					<li>合同到期日期: <em><%=info.getContractenddate()==null?"":info.getContractenddate()%></em></li>
					<li>客户编码: <em><%=info.getCustomercode()==null?"":info.getCustomercode()%></em></li>
					<li>客户名称: <em><%=info.getCustomername()==null?"":info.getCustomername()%></em></li>
					<li>近三个月发货金额: <em><%=info.getAmountofconsignment()==null?"":info.getAmountofconsignment()%></em></li>
					<li>客户全称: <em><%=info.getCustomerallname()==null?"":info.getCustomerallname()%></em></li>
					<li>借款方式: <em><%=info.getNodesectiontype()==null?"":info.getNodesectiontype()%></em></li>
					<li>结算限额: <em><%=info.getBalanceaccount()==null?"":info.getBalanceaccount()%></em></li>
					<li>借款日期: <em><%=info.getSettleaccountsdate()==null?"":info.getSettleaccountsdate()%></em></li>
					<li>运费折扣: <em><%=info.getFreightdiscount()==null?"":info.getFreightdiscount()%></em></li>
					<li>优惠类型: <em><%=info.getPreferentialtype()==null?"":info.getPreferentialtype()%></em></li>
					<li>代收费率折扣: <em><%=info.getGenerationratediscount()==null?"":info.getGenerationratediscount()%></em></li>
					<li>保价费率折扣: <em><%=info.getChargeratediscount()==null?"":info.getChargeratediscount()%></em></li>
					<li>接货费折扣: <em><%=info.getCargofeediscount()==null?"":info.getCargofeediscount()%></em></li>
					<li>送货费折扣: <em><%=info.getDeliveryfeediscount()==null?"":info.getDeliveryfeediscount()%></em></li>
					<li>协议联系人: <em><%=info.getProtocolcontactname()==null?"":info.getProtocolcontactname()%></em></li>
					<li>联系人手机: <em><%=info.getContactphone()==null?"":info.getContactphone()%></em></li>
					<li>联系人电话: <em><%=info.getContacttel()==null?"":info.getContacttel()%></em></li>
<%-- 					<li>折扣: <em><%=info.getDiscount()==null?"":info.getDiscount()%></em></li> --%>
<%-- 					<li>合同修改类型: <em><%=info.getModifycontracttype()==null?"":info.getModifycontracttype()%></em></li> --%>
<%-- 					<li>原合同序号: <em><%=info.getOldcontractnumber()==null?"":info.getOldcontractnumber()%></em></li> --%>
<%-- 					<li>新结算限额: <em><%=info.getNewbalanceaccount()==null?"":info.getNewbalanceaccount()%></em></li> --%>
<%-- 					<li>新运费折扣: <em><%=info.getNewfreightdiscount()==null?"":info.getNewfreightdiscount()%></em></li> --%>
<%-- 					<li>新运费类型: <em><%=info.getNewpreferentialtype()==null?"":info.getNewpreferentialtype()%></em></li> --%>
<%-- 					<li>新代收费率折扣: <em><%=info.getNewgenerationratediscount()==null?"":info.getNewgenerationratediscount()%></em></li> --%>
<%-- 					<li>新保价费率折扣: <em><%=info.getNewchargeratediscount()==null?"":info.getNewchargeratediscount()%></em></li> --%>
<%-- 					<li>新接送货折扣: <em><%=info.getNewcargofeediscount()==null?"":info.getNewcargofeediscount()%></em></li> --%>
<%-- 					<li>新送货费折扣: <em><%=info.getNewdeliveryfeediscount()==null?"":info.getNewdeliveryfeediscount()%></em></li> --%>
<%-- 					<li>合同归属部门: <em><%=info.getContrctascriptiondept()==null?"":info.getContrctascriptiondept()%></em></li> --%>
<%-- 					<li>申请绑定部门: <em><%=info.getApplybondingdept()==null?"":info.getApplybondingdept()%></em></li> --%>
<%-- 					<li>现有归属部门: <em><%=info.getAscriptiondept()==null?"":info.getAscriptiondept()%></em></li> --%>
<%-- 					<li>申请变更部门: <em><%=info.getApplyrenewaldept()==null?"":info.getApplyrenewaldept()%></em></li> --%>
					<li>申请事由：<em><%=info.getApplyreason() == null ? "" : info.getApplyreason()%></em></li>
				</ul>
			</div>
			<%@include file="approve_process.jsp"%>
		</div>
		<%@include file="workflow_approve_button.jsp"%>
	</div>
</body>
</html>