<%@page import="com.deppon.montal.model.OABusinessBaddebts"%>
<%@page import="com.deppon.montal.model.OABusinessBaddebtbill"%>
<%@page import="com.deppon.montal.model.OABusinessBaddebtleaf"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_win8.jsp" %>
</head>
</head>
<%
OABusinessBaddebts info = (OABusinessBaddebts)request.getAttribute("businessBaddebts");
List<OABusinessBaddebtbill> bills = (List<OABusinessBaddebtbill>)request.getAttribute("baddebtbills");
List<OABusinessBaddebtleaf> leafs = (List<OABusinessBaddebtleaf>)request.getAttribute("baddebtleafs");
%>
<body>
<div id="list">
	<%@include file="wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
				<tr><th>工作流号:</th><td id="workid"><%=info.getProcessinstid() %></td></tr>
				<tr><th>工作流:</th><td>业务类坏账申请</td></tr>
				<tr><th>申请人:</th><td><%=info.getApplyname()%></td></tr>
				<tr><th>所属部门:</th><td><%=info.getApplydept()%></td></tr>
				<tr><th>申请时间:</th><td><%=info.getApplydate()%></td></tr>
				<tr><th>坏账原因:</th><td><%=info.getReason()%></td></tr>
				<tr><th>客户编码:</th><td><%=info.getCustomercode()%></td></tr>
				<tr><th>客户名称:</th><td><%=info.getCustomername()%></td></tr>
				<tr><th>坏账金额:</th><td><%=info.getBadamount()%></td></tr>
				
				<%if("公司内部原因".equals(info.getReason())){ %>
				<tr><th>冲账方式:</th><td><%=info.getBalancemethod()%></td></tr>
				<%} %>
				
				<tr><th>坏账产生原因说明:</th><td><%=info.getDiscription()%></td></tr>
				<tr><th>差错处理编码:</th><td><%=info.getErrorcode()%></td></tr>
				<tr class="yellow"><th colspan="2">坏账表单信息</tr>		
						
				<% int index1 = 0;
				  for(OABusinessBaddebtbill bill : bills ) {%> 
				<tr <%= index1 == 0 ?"":"class='topLine'" %>><th>账单:</th><td><%=bill.getBusinessnumber()%></td></tr>
				<tr><th>未核销金额:</th><td><%=bill.getNoverification()%></td></tr>
				<tr><th>业务日期:</th><td><%=bill.getBusinessdate()%></td></tr>
				<%index1++; } %>
				
				<tr class="yellow"><th colspan="2">责任相关信息</tr>		
				
				<% int index2 = 0;
				  for(OABusinessBaddebtleaf leaf : leafs ) {%> 
				<tr <%= index2 == 0 ?"":"class='topLine'" %>><th>责任部门:</th><td><%=leaf.getResponsibledept()%></td></tr>
				<tr><th>入部门费用:</th><td><%=leaf.getIndeptmoney()%></td></tr>
				<tr><th>责任人:</th><td><%=leaf.getResponsibleperson()%></td></tr>
				<tr><th>个人扣款:</th><td><%=leaf.getDeductionamount()%></td></tr>
				<%index2++; } %>
				
		 </table>
		<%@include file="approve_process.jsp" %>
    	</div>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>