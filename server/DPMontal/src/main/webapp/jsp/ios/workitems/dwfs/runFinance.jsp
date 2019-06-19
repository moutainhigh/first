<%@page import="com.deppon.wfs.workflow.domain.RunFinanceBean"%>
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
RunFinanceBean info = (RunFinanceBean)request.getAttribute("entity");
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
		   		  资金运作
			   </em></li>
					  <li>申请人:<em>
					  <%=info.getApplyPersonName()%></em>
				   </li>
					 
					  <li>申请人工号：<em>
					  <%=info.getApplyPersonId()%></em>
				   </li>
					 
					  <li>所在部门：<em>
					  <%=info.getDeptName()%></em>
				   </li>
				   
				   	  <li>申请人职位 ：<em>
					  <%=info.getJobName()%></em>
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