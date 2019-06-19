<%@page import="com.deppon.wfs.workflow.domain.EmpDormBean"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
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
EmpDormBean info = (EmpDormBean)request.getAttribute("entity");
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
				   <td>员工宿舍</td>
				</tr>
			   <tr>
				  <th>申请人:</th>
				  <td><%=info.getApplyPersonName()%></td>
			   </tr>
				 <tr>
				  <th>申请人职位:</th>
				  <td><%=info.getEmpPost()%></td>
			   </tr>
			   <tr>
				  <th>宿舍长:</th>
				  <td><%=info.getDormItorymanager()%></td>
			   </tr>
			   <tr>
				  <th>所属区域:</th>
				  <td><%=info.getAreaub()%></td><!-- DIP_DIVISION_NEW -->
			   </tr>
			   <tr>
				  <th>是否外租:</th>
				  <td><%=info.getIsrent() == 1 ? "是":"否" %></td>
			   </tr>
			   <tr>
				  <th>是否续租:</th>
				  <td><%=info.getContinuerent() == 1 ? "是":"否" %></td>
			   </tr>
			   <% int continuerent = info.getContinuerent(); 
			   if(continuerent == 1){%>
			    <tr>
				  <th>续租费用:</th>
				  <td><%=info.getContinuerentCost()%></td>
			   </tr>
			   <%}%>
			    <tr>
				  <th>宿舍住宿人数:</th>
				  <td><%=info.getLivingno()%></td>
			   </tr>
			    <tr>
				  <th>部门性质:</th>
				  <td><%=info.getDepartNature()%></td><!-- WFS_DEPT_TYPE -->
			   </tr>
			   <tr>
				  <th>申请事由:</th>
				  <td><%=info.getApplyReasons()%></td>
			   </tr>
			   <%@include file="approve_process.jsp" %>					   					   
	    	</table>
	    </div>
	</div>
	 <%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>