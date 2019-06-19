<%@page import="com.deppon.wfs.workflow.domain.FoundQueryTeamBean"%>
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
FoundQueryTeamBean info = (FoundQueryTeamBean)request.getAttribute("entity");
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
			   <li>工作流:<em>成立接货开单查询组申请</em></li>
			    <li>
				  申请人:
				  <em><%=info.getApplyPersonName()%></em>
			   </li>
				 <li>
				  当地选拔组:
				  <em><%=info.getLocalPersonnel()%></em><!-- WFS_TRAIN -->
			   </li>
			   <li>
				  对应运作是否发线:
				  <em><%=info.getIsSendLine()%></em><!-- WFS_ISSEND_LINE -->
			   </li>
			   <li>
				  连续半个月日均集中开单票数:
				  <em><%=info.getBillingNum()%></em>
			   </li>
			   <li>
				  参与集中接货部门数:
				  <em><%=info.getDeptNum() %></em>
			   </li>
			   <li>
				  申请事由:
				  <em><%=info.getReason()%></em>
			   </li>
			</ul>
		</div>
		<%@include file="approve_process.jsp" %>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>