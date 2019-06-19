<%@page import="com.deppon.montal.model.OALoanPaymentInfo"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.montal.conf.F_Constants"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_win8.jsp" %>
</head>
<body>
<div id="list">
	<%@include file="wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
				<%
					OALoanPaymentInfo payment = (OALoanPaymentInfo)request.getAttribute("payment");
				%>
				<tr>
				   <th>工作流号:</th>
				   <td id="workid"><%=payment.getProcessinstid()%></td>
				</tr>
				<tr>
				   <th>工作流:</th>
				   <td>借支申请</td>
				</tr>
				<tr>
					<th>申请人:</th>
					<td><%=payment.getApplypersonname()%></td>
				</tr>
				<tr>
					<th>工号:</th>
					<td><%=payment.getApplypersoncode()%></td>
				</tr>
			    <tr>
				   <th>申请人部门:</th>
				   <td><%=payment.getApplydept()%></td>
				</tr>
				
				<tr>
				   <th>所属子公司:</th>
				   <td><%=payment.getSubsidiary()%></td>
				</tr>
				<tr>
				   <th>借支类型:</th>
				   <td><%=payment.getLoantype()%></td>
				</tr>
				<tr>
				   <th>所属区域:</th>
				   <td><%=payment.getArea()%></td>
				</tr>
				
				<tr>
				   <th>费用类型:</th>
				   <td><%=payment.getCosttype()%></td>
				</tr>
				<tr>
				   <th>费用总金额:</th>
				   <td><%=payment.getTotalmoney()%></td>
				</tr>
				<tr>
				   <th>收款人:</th>
				   <td><%=payment.getPayee()%></td>
				</tr>
				
				<tr>
				   <th>开户银行:</th>
				   <td><%=payment.getDepositbank()%></td>
				</tr>
				<tr>
				   <th>开户支行名称:</th>
				   <td><%=payment.getSubbranchbank()%></td>
				</tr>
				<tr>
				   <th>开户支行所在省份:</th>
				   <td><%=payment.getProvince()%></td>
				</tr>
				<tr>
				   <th>开户支行所在城市:</th>
				   <td><%=payment.getCity()%></td>
				</tr>
				<tr>
				   <th>帐号:</th>
				   <td><%=payment.getAccount()%></td>
				</tr>
				<tr>
				   <th>最迟汇款日期:</th>
				   <td><%=payment.getFinalremittance()%></td>
				</tr>
				<tr>
				   <th>发票抬头:</th>
				   <td><%=payment.getInvoicetitle()%></td>
				</tr>
				<tr>
				   <th>付款用途:</th>
				   <td><%=payment.getPayuse()%></td>
				</tr>
				<tr>
				   <th>费用发生日期:</th>
				   <td><%=payment.getOccurencydate()%></td>
				</tr>
				
				<tr>
				   <th>费用划分部门:</th>
				   <td><%=payment.getDepartmentaization()%></td>
				</tr>
				<tr>
				   <th>短信通知手机号码:</th>
				   <td><%=payment.getMobilephonebysms()%></td>
				</tr>
			    <tr>
				  <th>申请事由:</th>
				  <td style="word-wrap:break-word;word-break:break-all"><%=payment.getApplyreason()==null?"":payment.getApplyreason()%></td>
			    </tr>
			    <%@include file="approve_process.jsp" %>
		  </table>
		</div>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>