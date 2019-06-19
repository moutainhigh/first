<%@page import="com.deppon.wfs.workflow.domain.SpecialFundsProject"%>
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
	SpecialFundsProject info = (SpecialFundsProject)request.getAttribute("entity");
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
					   <td>专项费用立项申请</td>
					</tr>
				   <tr><th>起草人工号:</th><td><%=info.getApplyPersonId()%></td></tr>
				   <tr><th>起草人姓名:</th><td><%=info.getApplyPersonName()%></td></tr>
				   <tr><th>申请人:</th><td><%=info.getApplyName()%></td></tr>
				   <tr><th>申请人部门:</th><td><%=info.getApplyDepartment()%></td></tr>
				   <tr><th>申请事由:</th><td><%=info.getReason()%></td></tr>
					   
				<%@include file="approve_process.jsp" %>					   					   
	    	</table>
	    </div>
	</div>
	 <%@include file="workflow_approve_button.jsp" %>
</div>
</body>
<script type="text/javascript">
	$(function(){
		var activitydefid = $("#activitydefid").val();
		if(activitydefid == "manualActivity1"){
			$("#rollback_but").hide();
		}
	});
</script>
</html>