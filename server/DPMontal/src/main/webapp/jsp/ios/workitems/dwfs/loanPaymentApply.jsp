<%@page import="com.deppon.wfs.workflow.domain.LoanPaymentApply"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.module.workitems.webservice.client.DWFSWorkItemServiceClient"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_ios.jsp" %>
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
<%@include file="/jsp/ios/work_items_head.jsp" %>
   <!--div2 S-->
   <div id="div2">
	   	<div class="ulBox2">
			<ul>
			   <li>工作流号:
			        <em><%=request.getAttribute("processinstid") %>
					<input type="hidden" id="busino" value="<%=info.getBusino()%>">
					<input type="hidden" id="approval_url" value="<%=F_Constants.NORMOL_APPROVAL_URL%>">
			   		</em>
			   </li>
			   <li>工作流:<em>
		   		  借章申请
			   </em></li>
					  <li>申请人:<em>
					  <%=info.getApplyPersonName()%></em>
				   </li>
					 
					  <li>工号：<em>
					  <%=info.getApplyPersonId()%></em>
				   </li>
					 
					  <li>申请人部门：<em>
					  <%=info.getApplyDept()%></em>
				   </li>
				   
				   	  <li>所属子公司 ：<em>
					  <%=info.getSubsidiary()%></em>
				   </li>
					 
					 <li>借支类型：<em>
					  <%=info.getLoanType()%></em>
				   </li>
				    <li>所属区域：<em>
					  <%=info.getArea()%></em>
				   </li>
					<li>费用类型:<em>
					  <%=info.getCostType()%></em>
				   </li>
					 
					  <li>费用总金额：<em>
					  <%=info.getTotalMoney()%></em>
				   </li>
					 
					  <li>收款人：<em>
					  <%=info.getPayee()%></em>
				   </li>
				   
				    <li>开户银行 ：<em>
					  <%=info.getDepositBank()%></em>
				   </li>
				   		  <li>开户支行名称:<em>
					  <%=info.getSubBranchBank()%></em>
				   </li>
					 
					  <li>开户银行：<em>
					  <%=info.getProvince()%></em>
				   </li>
					 
					  <li>开户行所在城市：<em>
					  <%=info.getCity()%></em>
				   </li>
				   
				   	  <li>账号 ：<em>
					  <%=info.getAccount()%></em>
				   </li>
					 
					 <li>最迟汇款日期：<em>
					  <%=FormatUtil.formatDate(info.getFinalRemittance(),"yyyy-MM-dd hh:mm:ss")%></em>
				   </li>
				    <li>发票抬头：<em>
					  <%=info.getInvoiceTitle()%></em>
				   </li>
				   	  <li>付款用途:<em>
					  <%=info.getPayUse()%></em>
				   </li>
					 
					  <li>费用发生日期：<em>
					  <%=FormatUtil.formatDate(info.getOccurencyDate(),"yyyy-MM-dd hh:mm:ss")%></em>
				   </li>
					 
					  <li>费用划分部门：<em>
					  <%=info.getDepartmentaization()%></em>
				   </li>
				   
				   	  <li>短信通知手机号码 ：<em>
					  <%=info.getMobilePhonebysms()%></em>
				   </li>
					
				     <li>申请事由:<em>
					  <%=info.getApplyReason()%></em>
				   </li>
			 </ul>
		</div>
		<%@include file="approve_process.jsp" %>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>