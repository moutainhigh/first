<%@page import="com.deppon.wfs.workflow.domain.LoanPaymentApply"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.module.workitems.webservice.client.DWFSWorkItemServiceClient"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_win8.jsp" %>
</head>
<%
 request.setCharacterEncoding("UTF-8");
 response.setCharacterEncoding("UTF-8");
%>
<%
LoanPaymentApply info = (LoanPaymentApply)request.getAttribute("entity");
%>
<body>
<div id="list">
	<%@include file="../wf_head_win8.jsp" %>
   <!--div2 S-->
   <div id="div2">
	   	<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
			   <tr><th>工作流号:</th>
			        <td><%=request.getAttribute("processinstid") %>
					<input type="hidden" id="busino" value="<%=info.getBusino()%>">
					<input type="hidden" id="approval_url" value="<%=F_Constants.NORMOL_APPROVAL_URL%>">
			   		</td>
			   </tr>
			   <tr><th>工作流:</th><td>
		   		  借章申请
			   </td></tr>
					  <tr><th>申请人:</th><td>
					  <%=info.getApplyPersonName()%></td>
				   </tr>
					 
					  <tr><th>工号：</th><td>
					  <%=info.getApplyPersonId()%></td>
				   </tr>
					 
					  <tr><th>申请人部门：</th><td>
					  <%=info.getApplyDept()%></td>
				   </tr>
				   
				   	  <tr><th>所属子公司 ：</th><td>
					  <%=info.getSubsidiary()%></td>
				   </tr>
					 
					 <tr><th>借支类型：</th><td>
					  <%=info.getLoanType()%></td>
				   </tr>
				    <tr><th>所属区域：</th><td>
					  <%=info.getArea()%></td>
				   </tr>
					<tr><th>费用类型:</th><td>
					  <%=info.getCostType()%></td>
				   </tr>
					 
					  <tr><th>费用总金额：</th><td>
					  <%=info.getTotalMoney()%></td>
				   </tr>
					 
					  <tr><th>收款人：</th><td>
					  <%=info.getPayee()%></td>
				   </tr>
				   
				    <tr><th>开户银行 ：</th><td>
					  <%=info.getDepositBank()%></td>
				   </tr>
				   		  <tr><th>开户支行名称:</th><td>
					  <%=info.getSubBranchBank()%></td>
				   </tr>
					 
					  <tr><th>开户银行：</th><td>
					  <%=info.getProvince()%></td>
				   </tr>
					 
					  <tr><th>开户行所在城市：</th><td>
					  <%=info.getCity()%></td>
				   </tr>
				   
				   	  <tr><th>账号 ：</th><td>
					  <%=info.getAccount()%></td>
				   </tr>
					 
					 <tr><th>最迟汇款日期：</th><td>
					  <%=FormatUtil.formatDate(info.getFinalRemittance(),"yyyy-MM-dd hh:mm:ss")%></td>
				   </tr>
				    <tr><th>发票抬头：</th><td>
					  <%=info.getInvoiceTitle()%></td>
				   </tr>
				   	  <tr><th>付款用途:</th><td>
					  <%=info.getPayUse()%></td>
				   </tr>
					 
					  <tr><th>费用发生日期：</th><td>
					  <%=FormatUtil.formatDate(info.getOccurencyDate(),"yyyy-MM-dd hh:mm:ss")%></td>
				   </tr>
					 
					  <tr><th>费用划分部门：</th><td>
					  <%=info.getDepartmentaization()%></td>
				   </tr>
				   
				   	  <tr><th>短信通知手机号码 ：</th><td>
					  <%=info.getMobilePhonebysms()%></td>
				   </tr>
					
				     <tr><th>申请事由:</th><td>
					  <%=info.getApplyReason()%></td>
				   </tr>
				<%@include file="approve_process.jsp" %>					   					   
	    	</table>
	    </div>
	</div>
	 <%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>