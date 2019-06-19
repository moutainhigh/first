<%@page import="com.deppon.montal.module.crm.damin.QueryWorkflowInfoResponse"%>
<%@page import="com.deppon.montal.module.crm.damin.OverpayInfo"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
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
	QueryWorkflowInfoResponse responseEntity = (QueryWorkflowInfoResponse)request.getAttribute("queryWorkflowInfoResponse");
	OverpayInfo  info = responseEntity.getOverPayInfo();
%>
<body>
<div id="list">
<%@include file="/jsp/ios/work_items_head.jsp" %>
   <!--div2 S-->
   <div id="div2">
	   	<div class="ulBox2">
			<ul>
			   <li>工作流:<em>多赔申请</em></li>
			   <li>申请人:<em><%=info.getCrateUserName()%></em></li>
			   <li>运输类型:<em><%=info.getTransType()==null?"":info.getTransType()%></em></li>
			   <li>多赔单号:<em><%=info.getWaybillNumber()==null?"":info.getWaybillNumber()%></em></li>
			   <li>多赔金额:<em><%=info.getOverpayAmount()==null?"":info.getOverpayAmount()%></em></li>
			   <li>合计理赔金额:<em><%=info.getRealAmount()==null?"":info.getRealAmount()%></em></li>
			   <li>应收账款是否收回:<em><%=info.getRecoverYszk()==null?"":info.getRecoverYszk()%></em></li>
			   <li>部门会计:<em><%=info.getDeptAccount()==null?"":info.getDeptAccount()%></em></li>
			   <li>所属事业部:<em><%=info.getDivisionName()==null?"":info.getDivisionName()%></em></li>
			   <li>申请事由:<em><%=info.getOverpayReason()==null?"":info.getOverpayReason()%></em></li>
			</ul>
		</div>
		<%@include file="approve_process.jsp" %>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>