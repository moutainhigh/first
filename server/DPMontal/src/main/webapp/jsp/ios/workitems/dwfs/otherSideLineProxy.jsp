<%@page import="com.deppon.wfs.workflow.domain.OtherSideLineProxy"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
<%@include file="/common_ios.jsp"%>
</head>
<%
 request.setCharacterEncoding("UTF-8");
 response.setCharacterEncoding("UTF-8");
%>
<%
OtherSideLineProxy info = (OtherSideLineProxy)request.getAttribute("entity");
%>
<body>
	<div id="list">
		<%@include file="/jsp/ios/work_items_head.jsp"%>
		<!--div2 S-->
		<div id="div2">
			<div class="ulBox2">
				<ul>

					<li class="first">工作流号:<em><%=request.getAttribute("processinstid") %>
							<input type="hidden" id="busino" value="<%=info.getBusino()%>">
							<input type="hidden" id="approval_url"
							value="<%=F_Constants.NORMOL_APPROVAL_URL%>"> </em>
					</li>

					 <li>
					  申请人:
					  <em><%=info.getApplyPersonName()%></em>
				   </li>
					 <li>
					  申请人工号:
					  <em><%=info.getApplyPersonId()%></em>
				   </li>
				   <li>
					  工作流类别:
					  <em><%=info.getFlowCategory()  %></em><!-- WFS_PROXY_WFTYPE -->
				   </li>
					 <li>
					  外发部门名称:
					  <em><%=info.getStartOrgName()%></em>
				   </li>
					 <li>
					  所属财务部:
					  <em><%=info.getFinqnceCode() %> </em><!-- NEW_FINANCIAL -->
				   </li>
				   <li>
					  所属事业部:
					  <em><%=info.getBusinessUnitsCode() %></em><!-- DIP_DIVISION_NEW -->
				   </li>
				    <li>
					  保证金支付方式:
					  <em><%=info.getMarginpayCategory() %></em><!-- WFS_PAYMENT -->
				   </li>
				   <li>
					  外发成本支付方式:
					  <em><%=info.getStartCostPayCategory()%></em><!-- WFS_PAYMENT -->
				   </li>
				    <li>
					  代理名称:
					  <em><%=info.getAgentName()%></em>
				   </li>
				    <li>
					  代理所在城市:
					  <em><%=info.getAgentCity()%></em>
				   </li>
				    <li>
					  保证金金额:
					  <em><%=info.getMargin()%></em>
				   </li>
 					   <li>
						  申请事由:
						  <em><%=info.getReason()%></em>
					   </li>
					   
				</ul>
			</div>
			<%@include file="approve_process.jsp"%>
		</div>
		<%@include file="workflow_approve_button.jsp"%>
	</div>
</body>
</html>