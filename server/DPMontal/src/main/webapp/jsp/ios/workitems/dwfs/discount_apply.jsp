<%@page import="com.deppon.wfs.workflow.domain.DiscountapplyBean"%>
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
DiscountapplyBean info = (DiscountapplyBean)request.getAttribute("entity");
%>
<body>
<div id="list">
	<%@include file="/jsp/ios/work_items_head.jsp" %>
	<div id="div2">
   	<div class="ulBox2">
			<ul>
				<li class="first">工作流号:<em><%=info.getProcessinstid() %></em></li>
				<li>工作流:<em>折扣申请/取消</em></li>
				<li>申请人:<em><%=info.getApplyPersonName()%></em></li>
				<li>申请人部门:<em><%=info.getDepartment()%></em></li>
				<li>折扣类型:<em><%=info.getDiscountTypeCN()%></em></li>
				<%if("1".equals(info.getDiscountType())|| "2".equals(info.getDiscountType())){ %>
				<li>所属事业部:<em><%=info.getDivisionCode()%></em></li>
				<%} %>
				<li>申请事由<em><%=info.getReason()%></em></li>
		 </ul>
    	</div>
    	<%@include file="approve_process.jsp" %>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
	
	
	
	
	<input type="hidden" id="workid" value="<%=info.getProcessinstid()%>">
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