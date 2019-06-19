<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.module.workitems.webservice.client.DWFSWorkItemServiceClient"%>
<%@page import="com.deppon.wfs.workflow.domain.Externalstudy"%>
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
Externalstudy info = (Externalstudy)request.getAttribute("entity");
%>
<div id="list">
	<%@include file="../wf_head_win8.jsp" %>
	<input type="hidden" id="busino" value="<%=info.getBusino()%>">
	<input type="hidden" id="approval_url" value="<%=F_Constants.EXTERNALSTUDY_APPROVAL_URL%>">
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
					   <td>外训申请</td>
					</tr>
				   <tr>
					  <th>申请人:</th>
					  <td><%=info.getApplyPersonName()%></td>
				   </tr>
					 <tr>
					  <th>申请人工号:</th>
					  <td><%=info.getApplyPersonId()%></td>
				   </tr>
				   <tr>
					  <th>申请人部门:</th>
					  <td><%=info.getApplyDepartment()%></td>
				   </tr>
					 <tr>
					  <th>参加人:</th>
					  <td><%=info.getParticipator()%></td>
				   </tr>
					 <tr>
					  <th>课程费用:</th>
					  <td><%=info.getCoursePrice()%></td>
				   </tr>
				   <tr>
					  <th>所属人事部:</th>
					  <td><%=info.getBelongPersonnelDepartment()%></td>
				   </tr>
				   
				   <tr>
					  <th>培训地点:</th>
					  <td><%=info.getCourseAddress()%></td>
				   </tr>
					 <tr>
					  <th>举办机构:</th>
					  <td><%=info.getOrganization()%></td>
				   </tr>
				   <tr>
					  <th>是否向培训组备案:</th>
					  <td><%=info.getIfRecord()%></td>
				   </tr>
					 <tr>
					  <th>申请事由:</th>
					  <td><%=info.getApplyReason()==null?"":info.getApplyReason()%></td>
				   </tr>
				<%@include file="approve_process.jsp" %>					   					   
	    	</table>
	    </div>
	</div>
	 <%@include file="workflow_approve_button.jsp" %>
</div>
<script type="text/javascript">
//逐级审批总裁不能有回退按纽
$(function(){
	var activitydefid=$('#activitydefid').val();
	if(activitydefid=="manualActivity"){
		$('#rollback_but').hide();
	}
});
</script>
</body>
</html>