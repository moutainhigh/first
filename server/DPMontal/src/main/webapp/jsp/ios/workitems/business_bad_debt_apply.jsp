<%@page import="com.deppon.montal.model.OABusinessBaddebts"%>
<%@page import="com.deppon.montal.model.OABusinessBaddebtbill"%>
<%@page import="com.deppon.montal.model.OABusinessBaddebtleaf"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_ios.jsp" %>
</head>
</head>
<%
	OABusinessBaddebts info = (OABusinessBaddebts)request.getAttribute("businessBaddebts");
	List<OABusinessBaddebtbill> bills = (List<OABusinessBaddebtbill>)request.getAttribute("baddebtbills");
	List<OABusinessBaddebtleaf> leafs = (List<OABusinessBaddebtleaf>)request.getAttribute("baddebtleafs");
%>
<body>
<div id="list">
	<%@include file="/jsp/ios/work_items_head.jsp" %>
	<div id="div2">
   	<div class="ulBox2">
			<ul>
				<li class="first">工作流号:<em><%=info.getProcessinstid() %></em></li>
				<li>工作流:<em>业务类坏账申请</em></li>
				<li>申请人:<em><%=info.getApplyname()%></em></li>
				<li>所属部门:<em><%=info.getApplydept()%></em></li>
				<li>申请时间:<em><%=info.getApplydate()%></em></li>
				<li>坏账原因:<em><%=info.getReason()%></em></li>
				<li>客户编码:<em><%=info.getCustomercode()%></em></li>
				<li>客户名称:<em><%=info.getCustomername()%></em></li>
				<li>坏账金额:<em><%=info.getBadamount()%></em></li>
				
				<%if("公司内部原因".equals(info.getReason())){ %>
				<li>冲账方式:<em><%=info.getBalancemethod()%></em></li>
				<%} %>
				
				<li>坏账产生原因说明:<em><%=info.getDiscription()%></em></li>
				<li>差错处理编码:<em><%=info.getErrorcode()%></em></li>
				<li><em class="yellow">坏账表单信息</em></li>	
							
				<% int index1 = 0;
				  for(OABusinessBaddebtbill bill : bills ) {%> 
				<li <%= index1 == 0 ?"":"class='line'" %>>账单:<em><%=bill.getBusinessnumber()%></em></li>
				<li>未核销金额:<em><%=bill.getNoverification()%></em></li>
				<li>业务日期:<em><%=bill.getBusinessdate()%></em></li>
				<%index1++; } %>
				<li><em class="yellow">责任相关信息</em></li>
						
				<% int index2 = 0;
				  for(OABusinessBaddebtleaf leaf : leafs ) {%> 
				<li <%= index2 == 0 ? "" : "class='line'" %>>责任部门:<em><%=leaf.getResponsibledept()%></em></li>
				<li>入部门费用:<em><%=leaf.getIndeptmoney()%></em></li>
				<li>责任人:<em><%=leaf.getResponsibleperson()%></em></li>
				<li>个人扣款:<em><%=leaf.getDeductionamount()%></em></li>
				<%index2++; } %>
				
		 </ul>
    	</div>
    	<%@include file="approve_process.jsp" %>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
	
	
	<input type="hidden" id="workid" value="<%=info.getProcessinstid()%>">
</div>
</body>
</html>