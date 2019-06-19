<%@page import="com.deppon.wfs.workflow.domain.DeductCargo"%>
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
DeductCargo info = (DeductCargo)request.getAttribute("entity");
%>
<body>
<div id="list">
<%@include file="/jsp/ios/work_items_head.jsp" %>
   <!--div2 S-->
   <div id="div2">
	   	<div class="ulBox2">
			<ul>
			 
			   <li class="first">工作流号:
			        <em><%=request.getAttribute("processinstid") %>
					<input type="hidden" id="busino" value="<%=info.getBusino()%>">
					<input type="hidden" id="approval_url" value="<%=F_Constants.NORMOL_APPROVAL_URL%>">		  	   		
			   		</em>
			   </li>
			   	<li>工作流:<em> 扣货申请</em></li>
				<li>申请人:<em><%=info.getApplyPersonName()%></em></li>
				<li>所属事业部:<em><%=info.getBusinessDept()%></em></li><!-- DIP_DIVISION_NEW -->
				<li>扣货单号:<em><%=info.getDeductCargoNo()%></em></li>
				<li>货物扣留所在部门:<em><%=info.getDepartment() %></em></li>
				<li>发货人姓名:<em><%=info.getSendName()%></em></li>
				<li>收货人姓名:<em><%=info.getReceiveName()%></em></li>
				<li>保价金额:<em><%=info.getKeepValueMoney()%></em></li>
				<li>代收款金额:<em><%=info.getAgencyMoney() %></em></li>
				<li>合同编码:<em><%=info.getContractNo()%></em></li>
				<li>申请事由:<em><%=info.getApplyReason()%></em></li>
			</ul>
		</div>
		<%@include file="approve_process.jsp" %>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>