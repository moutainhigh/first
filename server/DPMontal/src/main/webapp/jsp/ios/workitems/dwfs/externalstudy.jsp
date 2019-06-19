<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.wfs.workflow.domain.Externalstudy"%>
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
Externalstudy info = (Externalstudy)request.getAttribute("entity");
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
					<input type="hidden" id="approval_url" value="<%=F_Constants.EXTERNALSTUDY_APPROVAL_URL%>">		  	   		
			   		</em>
			   </li>
			   <li>工作流:<em>
		   		    外训申请
			   </em></li>
					  <li>申请人:<em>
					  <%=info.getApplyPersonName()%></em>
				   </li>
					 
					  <li>申请人工号:<em>
					  <%=info.getApplyPersonId()%></em>
				   </li>
				   
					  <li>申请人部门:<em>
					  <%=info.getApplyDepartment()%></em>
				   </li>
					 
					  <li>参加人:<em>
					 <%=info.getParticipator()%></em>
				   </li>
					 
					  <li>课程费用:<em>
					  <%=info.getCoursePrice()%></em>
				   </li>
				   
					  <li>所属人事部:<em>
					  <%=info.getBelongPersonnelDepartment()%></em>
				   </li>
					  <li>培训地点:<em>
					  <%=info.getCourseAddress()%></em>
				   </li>
					 
					  <li>举办机构:<em>
					  <%=info.getOrganization()%></em>
				   </li>
					  <li>是否向培训组备案:<em>
					  <%=info.getIfRecord()%></em>
				   </li>
					  <li>申请事由:<em>
					  <%=info.getApplyReason()==null?"":info.getApplyReason()%></em>
				   </li>
			</ul>
		</div>
		<%@include file="approve_process.jsp" %>
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