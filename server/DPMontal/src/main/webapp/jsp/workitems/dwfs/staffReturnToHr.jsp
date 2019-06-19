<%@page import="com.deppon.wfs.workflow.domain.StaffReturnToHrBean"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.module.workitems.webservice.client.DWFSWorkItemServiceClient"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
		<%@include file="/common_win8.jsp" %>
</head>
<%
 request.setCharacterEncoding("UTF-8");
 response.setCharacterEncoding("UTF-8");
%>
<%
	StaffReturnToHrBean info = (StaffReturnToHrBean)request.getAttribute("entity");
%>
<body>
<div id="list">
	<%@include file="../wf_head_win8.jsp" %>
   <!--div2 S-->
   <div id="div2">
   <h3 class="yellow">审批工作流</h3>
	   	<div class="tableBox">
			<table width="100%">
			   <tr><th>工作流号:
			        </th><td><%=request.getAttribute("processinstid") %>
					<input type="hidden" id="busino" value="<%=info.getBusino()%>">
					<input type="hidden" id="approval_url" value="<%=F_Constants.NORMOL_APPROVAL_URL%>">
			   		</td>
			   </tr>
			   <tr><th>工作流:</th><td>
		   		   员工退回人力资源部
			   </td></tr>
					  <tr><th>申请人:</th><td>
					  <%=info.getApplyPersonName()%></td>
				   </tr>
					 
					  <tr><th>所在部门：</th><td>
					  <%=info.getApplyDept()%></td>
				   </tr>
				   
					  <tr><th>职位 ：</th><td>
					  <%=info.getPosition()%></td>
				   </tr>
					 
					  <tr><th>所属人事部：</th><td>
					  <%=info.getPersonal()%></td>
				   </tr>
				   
				   	  <tr><th>被退回人姓名 ：</th><td>
					  <%=info.getReturnPersonName()%></td>
				   </tr>
					 
					  <tr><th>被退回人工号：</th><td>
					  <%=info.getReturnPersonId()%></td>
				   </tr>
				 
				     <tr><th>申请事由:</th><td>
					  <%=info.getReason()%></td>
				   </tr>
		<%@include file="approve_process.jsp" %>		   					   
	    	</table>
	    </div>
	</div>
	 <%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>