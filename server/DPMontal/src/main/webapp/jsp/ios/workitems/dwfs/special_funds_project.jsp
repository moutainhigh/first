<%@page import="com.deppon.wfs.workflow.domain.SpecialFundsProject"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_ios.jsp" %>
</head>
<%
 request.setCharacterEncoding("UTF-8");
 response.setCharacterEncoding("UTF-8");
%>
<%
 		SpecialFundsProject info = (SpecialFundsProject)request.getAttribute("entity");
%>

<body>
<div id="list">
<%@include file="/jsp/ios/work_items_head.jsp" %>
   <!--div2 S-->
   <div id="div2">
	   	<div class="ulBox2">
			<ul>
			 
			   <li class="first">工作流号:
			        <em><%=request.getAttribute("processinstid") %>
					<input type="hidden" id="busino" value="<%=info.getBusino()%>">
					<input type="hidden" id="approval_url" value="<%=F_Constants.NORMOL_APPROVAL_URL%>">		  	   		
			   		</em>
			   </li>
			   <li>工作流:<em> 专项费用立项申请</em></li>
			   <li>起草人工号:<em><%=info.getApplyPersonId()%></em></li>
			   <li>起草人姓名:<em><%=info.getApplyPersonName()%></em></li>
			   <li>申请人:<em><%=info.getApplyName()%></em></li>
			   <li>申请人部门:<em><%=info.getApplyDepartment()%></em></li>
			   <li>申请事由:<em><%=info.getReason()%></em></li>
			</ul>
		</div>
		<%@include file="approve_process.jsp" %>
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