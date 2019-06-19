<%@page import="com.deppon.wfs.workflow.domain.PaymentWageinfoBean"%>
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
PaymentWageinfoBean info = (PaymentWageinfoBean)request.getAttribute("entity");
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
					   工&nbsp;&nbsp;作&nbsp;&nbsp;流:
					   <em>工资信息更改申请</em>
					</li>
				   <li>
					  申请人:
					  <em><%=info.getApplyPersonName()%></em>
				   </li>
					 <li>
					  申请类型:
					  <em><%=info.getApplyType()%></em><!-- WFS_PAYMENT_APPLYTYPE -->
				   </li>
				   <li>
					  申请人所在部门:
					  <em><%=info.getApplyDept()  %></em>
				   </li>
					<%
					String type = info.getApplyType();
					if(type == "" || "工资发放更改申请".equals(type) || "工资表提交申请".equals(type)){
					%>
					<li>
					  工资年月:
					  <em><%=FormatUtil.formatDate(info.getPayYearMonth(), "yyyy-MM")%></em>
				   </li>					
					<%}%>
				<%
					if("工资发放更改申请".equals(type)){
					%>
					<li>
					  更改类型:
					  <em><%=info.getChangeType() %> </em><!-- WFS_PAYMENT_CHANGETYPE -->
				   </li>				
					<%}%>
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