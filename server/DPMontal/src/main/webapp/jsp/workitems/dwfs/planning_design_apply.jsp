<%@page import="com.deppon.wfs.workflow.domain.PlainDesignBean"%>
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
PlainDesignBean info = (PlainDesignBean)request.getAttribute("entity");
%>
<body>
<div id="list">
	<%@include file="../wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
				<tr><th>工作流号:</th><td id="workid"><%=info.getProcessinstid() %></td></tr>
				<tr><th>工作流:</th><td>企划类设计制作申请</td></tr>
				<tr><th>申请人:</th><td><%=info.getApplyPersonName()%></td></tr>
				<tr><th>申请人工号:</th><td><%=info.getApplyPersonId()%></td></tr>
				<tr><th>申请人部门:</th><td><%=info.getUserOrg()%></td></tr>
				<tr><th>事由说明:</th><td><%=info.getReason()%></td></tr>
		 	</table>
			<%@include file="approve_process.jsp" %>
			<table width="100%" style="display: none" id="msg">
				<tr><td style="color: red" align="center" colspan="2">此节点暂不支持手机审批</td></tr>
			</table>
    	</div>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
	
	
	<input type="hidden" id="busino" value="<%=info.getBusino()%>">
	<input type="hidden" id="approval_url" value="<%=F_Constants.NORMOL_APPROVAL_URL%>">
</div>
</body>
<script type="text/javascript">
//-VI管理小组负责人节点处特殊审批，但是审批人的级别不够总监所以不显示
$(document).ready(function(){
	var activitydefid=$('#activitydefid').val();
	if(activitydefid == 'manualActivity3'){
		$('#msg').show();
		document.getElementById("disagree_but").style.display = "none";
		document.getElementById("agree_but").style.display = "none";
		document.getElementById("rollback_but").style.display = "none";
		document.getElementById("approve_area").style.display = "none";
	}
});
</script>
</html>