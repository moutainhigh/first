<%@page import="com.deppon.wfs.workflow.domain.DiscountapplyBean"%>
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
DiscountapplyBean info = (DiscountapplyBean)request.getAttribute("entity");
%>
<body>
<div id="list">
	<%@include file="../wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
				<tr><th>工作流号:</th><td id="workid"><%=info.getProcessinstid() %></td></tr>
				<tr><th>工作流:</th><td>折扣申请/取消</td></tr>
				<tr><th>申请人:</th><td><%=info.getApplyPersonName()%></td></tr>
				<tr><th>申请人部门:</th><td><%=info.getDepartment()%></td></tr>
				<tr><th>折扣类型:</th><td><%=info.getDiscountTypeCN()%></td></tr>
				<%if("1".equals(info.getDiscountType())|| "2".equals(info.getDiscountType())){ %>
				<tr><th>所属事业部:</th><td><%=info.getDivisionCode()%></td></tr>
				<%} %>
				<tr><th>申请事由</th><td><%=info.getReason()%></td></tr>
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
	//起草人[manualActivity8]、起草人[manualActivity81]
	var activitydefid = $("#activitydefid").val();
	if(activitydefid == 'manualActivity8' ||  activitydefid == 'manualActivity81' ){
		$("#approve_area").hide();
		$("#div3").hide();
	} 
});
</script>
</body>
</html>