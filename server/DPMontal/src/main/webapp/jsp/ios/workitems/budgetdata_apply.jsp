<%@page import="com.deppon.montal.model.OaBudgetdataApply"%>
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
						OaBudgetdataApply info = (OaBudgetdataApply) request
														.getAttribute("OaBudgetdataApply");
					%>
					<li class="first">工作流号：<em><%=info.getProcessinstid()%><input
							type="hidden" id="workid" value="<%=info.getProcessinstid()%>">
							<input type="hidden" id="type_id" value="budgetData"></em></li>
					<li>工作流:<em>预算数据申请</em></li>
					<li>申请人:<em><%=info.getName()%></em></li>
					<li>预算部门:<em><%=info.getBudgetorgname()%></em></li>
		            <li>工作流类型:<em><%=info.getApptype()==null?"":info.getApptype()%></em></li>
		            <li>预算年份:<em><%=info.getBudgetdyeay()%></em></li>
		          	<%if("预算调整".equals(info.getApptype())){%>
		          	<li>预算月份:<em><%=info.getBudgetdquaeter()%>月</em></li>
		            <li>费用类型:<em><%=info.getFeetype()%></em></li>
		            <li>费用金额:<em><%=info.getRate()%></em></li>
		          	<%}else{%>
		            <li>预算季度:<em>第<%=info.getBudgetdquaeter()%>季度</em></li>
		          	<%} %>
		            <li>申请事由:<em><%=info.getWhyapply()==null?"":info.getWhyapply()%></em></li>
				</ul>
			</div>
			<%@include file="approve_process.jsp"%>
		</div>
		<%@include file="workflow_approve_button.jsp"%>
	</div>
</body>
</html>