<%@page import="com.deppon.wfs.workflow.domain.FoundQueryTeamBean"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_win8.jsp" %>
	<style>
	tr.details, tr.qytr { display:none;}
	</style>
</head>
<body onload="autoShowApproval()">
<%
FoundQueryTeamBean info = (FoundQueryTeamBean)request.getAttribute("entity");
%>
<div id="list">
	<%@include file="../wf_head_win8.jsp" %>
	<input type="hidden" id="busino" value="<%=info.getBusino()%>">
	<input type="hidden" id="approval_url" value="<%=F_Constants.NORMOL_APPROVAL_URL%>">
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
    		   <tr>
				   <th>工作流号:</th>
				   <td id="workid"><%=request.getAttribute("processinstid")%></td>
				</tr>
				<tr>
				   <th>工&nbsp;&nbsp;作&nbsp;&nbsp;流:</th>
				   <td>成立接货开单查询组申请</td>
				</tr>
			   <tr>
				  <th>申请人:</th>
				  <td><%=info.getApplyPersonName()%></td>
			   </tr>
				 <tr>
				  <th>当地选拔组:</th>
				  <td><%=info.getLocalPersonnel()%></td><!-- WFS_TRAIN -->
			   </tr>
			   <tr>
				  <th>对应运作是否发线:</th>
				  <td><%=info.getIsSendLine()%></td><!-- WFS_ISSEND_LINE -->
			   </tr>
			   <tr>
				  <th>连续半个月日均集中开单票数:</th>
				  <td><%=info.getBillingNum()%></td>
			   </tr>
			   <tr>
				  <th>参与集中接货部门数:</th>
				  <td><%=info.getDeptNum() %></td>
			   </tr>
			   <tr>
				  <th>申请事由:</th>
				  <td><%=info.getReason()%></td>
			   </tr>
			   <%@include file="approve_process.jsp" %>					   					   
	    	</table>
	    </div>
	</div>
	 <%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>