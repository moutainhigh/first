<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.module.workitems.webservice.client.DWFSWorkItemServiceClient"%>
<%@page import="com.deppon.wfs.workflow.domain.AssessReduceBean"%>
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
AssessReduceBean info = (AssessReduceBean)request.getAttribute("entity");
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
					   <td>考核特批减免申请</td>
					</tr>
				   <tr>
					  <th>申请人:</th>
					  <td><%=info.getApplyPersonName()%></td>
				   </tr>
					 <tr>
					  <th>减免类别:</th>
					  <td><%=info.getReduceType()%></td><!-- WFS_REDUCETYPE -->
				   </tr>
				   <tr>
					  <th>申请事由:</th>
					  <td><%=info.getApplyReason()  %></td>
				   </tr>
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
	if("manualActivity" != activitydefid && "manualActivity4" != activitydefid){
		//隐藏回退功能
		$("#rollback_but").hide();
	}
});
</script>
</html>