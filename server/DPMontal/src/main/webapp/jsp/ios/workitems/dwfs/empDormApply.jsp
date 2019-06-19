<%@page import="com.deppon.wfs.workflow.domain.EmpDormBean"%>
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
EmpDormBean info = (EmpDormBean)request.getAttribute("entity");
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
			   <li>
				  申请人:
				  <em><%=info.getApplyPersonName()%></em>
			   </li>
				 <li>
				  申请人职位:
				  <em><%=info.getEmpPost()%></em>
			   </li>
			   <li>
				  宿舍长:
				  <em><%=info.getDormItorymanager()%></em>
			   </li>
			   <li>
				  所属区域:
				  <em><%=info.getAreaub()%></em><!-- DIP_DIVISION_NEW -->
			   </li>
			   <li>
				  是否外租:
				  <em><%=info.getIsrent() == 1 ? "是":"否" %></em>
			   </li>
			   <li>
				  是否续租:
				  <em><%=info.getContinuerent() == 1 ? "是":"否" %></em>
			   </li>
			   <% int continuerent = info.getContinuerent(); 
			   if(continuerent == 1){%>
			    <li>
				  续租费用:
				  <em><%=info.getContinuerentCost()%></em>
			   </li>
			   <%}%>
			    <li>
				  宿舍住宿人数:
				  <em><%=info.getLivingno()%></em>
			   </li>
			    <li>
				  部门性质:
				  <em><%=info.getDepartNature()%></em><!-- WFS_DEPT_TYPE -->
			   </li>
			   <li>
				  申请事由:
				  <em><%=info.getApplyReasons()%></em>
			   </li>
			</ul>
		</div>
		<%@include file="approve_process.jsp" %>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>