<%@page import="com.deppon.wfs.workflow.domain.PlainDesignBean"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_ios.jsp" %>
</head>
</head>
<%
PlainDesignBean info = (PlainDesignBean)request.getAttribute("entity");
%>
<body>
<div id="list">
	<%@include file="/jsp/ios/work_items_head.jsp" %>
	<div id="div2">
   	<div class="ulBox2">
			<ul>
				<li class="first">工作流号:<em><%=info.getProcessinstid() %></em></li>
				<li>工作流:<em>企划类设计制作申请</em></li>
				<li>申请人:<em><%=info.getApplyPersonName()%></em></li>
				<li>申请人工号:<em><%=info.getApplyPersonId()%></em></li>
				<li>申请人部门:<em><%=info.getUserOrg()%></em></li>
				<li>事由说明:<em><%=info.getReason()%></em></li>
		 </ul>
    	</div>
    	<%@include file="approve_process.jsp" %>
	</div>
	<div>
		<ul id="msg" style="display: none"> 
			<li class="fyy-textCt"><em style="color: red">此节点暂不支持手机审批</em></li>
		</ul>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
	<input type="hidden" id="workid" value="<%=info.getProcessinstid()%>">
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