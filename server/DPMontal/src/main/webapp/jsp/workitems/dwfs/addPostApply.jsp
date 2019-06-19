<%@page import="com.deppon.wfs.workflow.domain.PostApplyBean"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_win8.jsp" %>
</head>
</head>
<%
PostApplyBean info = (PostApplyBean)request.getAttribute("entity");
%>
<body>
<div id="list">
	<%@include file="../wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
				<tr><th>工作流号:</th><td id="workid"><%=info.getProcessinstid() %></td></tr>
				<tr><th>工作流:</th><td>新增岗位申请</td></tr>
				<tr><th>申请人:</th><td><%=info.getApplyPersonName()%></td></tr>
				<tr><th>新增岗位名称:</th><td><%=info.getPostName()%></td></tr>
				<tr><th>申请事由:</th><td><%=info.getApplyReasons()%></td></tr>
		 </table>
		<%@include file="approve_process.jsp" %>
    	</div>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
	
	
	<input type="hidden" id="busino" value="<%=info.getBusino()%>">
	<input type="hidden" id="approval_url" value="<%=F_Constants.NORMOL_APPROVAL_URL%>">
</div>
<script type="text/javascript">
$(function(){
	//首个组织架构研究组具备不同意权限，其他节点均无不同意
	var activitydefid = $("#activitydefid").val();
	if(activitydefid != 'organizationTeam'){
		$("#disagree_but").hide();
	} 
});
</script>
</body>
</html>