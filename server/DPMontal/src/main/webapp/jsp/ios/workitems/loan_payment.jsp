<%@page import="com.deppon.montal.model.OALoanPaymentInfo"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_ios.jsp" %>
</head>
<body>

<div id="list">
	<%@include file="/jsp/ios/work_items_head.jsp" %>
	<div id="div2">
    	<div class="ulBox2">
	    	<ul>
				<%
					OALoanPaymentInfo payment = (OALoanPaymentInfo)request.getAttribute("payment");
				%>
				
				<li class="first">工作流号：<em><%=payment.getProcessinstid() %></em>
					<input type="hidden" id="workid" value="<%=payment.getProcessinstid()%>">
				</li>
			   
			    <li>工作流：<em>借支申请</em></li>
			    
			    <li>申请人：<em><%=payment.getApplypersonname()%></em></li>
			    <li>工号：<em><%=payment.getApplypersoncode()%></em></li>
			    <li>申请人部门：<em><%=payment.getApplydept()%></em></li>
			    <li>所属子公司：<em><%=payment.getSubsidiary()%></em></li>
			    <li>借支类型：<em><%=payment.getLoantype()%></em></li>
			    <li>所属区域：<em><%=payment.getArea()%></em></li>
			    <li>费用类型：<em><%=payment.getCosttype()%></em></li>
			    <li>费用总金额：<em><%=payment.getTotalmoney()%></em></li>
			    <li>收款人：<em><%=payment.getPayee()%></em></li>
			    <li>开户银行：<em><%=payment.getDepositbank()%></em></li>
			    <li>开户支行名称：<em><%=payment.getSubbranchbank()%></em></li>
			    <li>开户支行所在省份：<em><%=payment.getProvince()%></em></li>
			    <li>开户支行所在城市：<em><%=payment.getCity()%></em></li>
			    <li>帐号：<em><%=payment.getAccount()%></em></li>
			    <li>最迟汇款日期：<em><%=payment.getFinalremittance()%></em></li>
			    <li>发票抬头：<em><%=payment.getInvoicetitle()%></em></li>
			    <li>付款用途：<em><%=payment.getPayuse()%></em></li>
			    <li>费用发生日期：<em><%=payment.getOccurencydate()%></em></li>
			    <li>费用划分部门：<em><%=payment.getDepartmentaization()%></em></li>
			    <li>短信通知手机号码：<em><%=payment.getMobilephonebysms()%></em></li>
				
			    <li class="last">申请事由：<em><%=payment.getApplyreason()==null?"":payment.getApplyreason() %></em></li>
			</ul>
		</div>
		<%@include file="approve_process.jsp" %>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>