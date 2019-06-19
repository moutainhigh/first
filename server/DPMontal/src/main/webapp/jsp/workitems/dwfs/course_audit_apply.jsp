<%@page import="com.deppon.wfs.workflow.domain.CourseDevelopUpdateAuditBean"%>
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
CourseDevelopUpdateAuditBean info = (CourseDevelopUpdateAuditBean)request.getAttribute("entity");
CourseDevelopUpdateAuditBean info1 = info.getReSetEntity();
%>
<body>
<div id="list">
	<%@include file="../wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
				<tr><th>工作流号:</th><td id="workid"><%=info.getProcessinstid() %></td></tr>
				<tr><th>工作流:</th><td>课程研发/更新/审核申请</td></tr>
				<tr><th>申请人:</th><td><%=info.getApplyPersonName()%></td></tr>
				<tr><th>申请人工号:</th><td><%=info.getApplyPersonId()%></td></tr>
				<tr><th>所在部门:</th><td><%=info.getApplyDept()%></td></tr>
				<%if("research".equals(info.getApplyCourseType())){%>
					<tr><th>申请课程类型:</th><td>课程研发申请</td></tr>
				<%}else if("check".equals(info.getApplyCourseType())){ %>
					<tr><th>申请课程类型:</th><td>课程审核申请</td></tr>
				<%}else if("update".equals(info.getApplyCourseType())){ %>
					<tr><th>申请课程类型:</th><td>课程更新申请</td></tr>
				<%}else{ %>
					<tr><th>申请课程类型:</th><td><%=info.getApplyCourseType()%></td></tr>
				<%} %>
				<tr><th>申请课程名称:</th><td><%=info.getCourseName()%></td></tr>
				<tr><th>所属培训管理组:</th><td><%=info.getTrainManagementGroup()%></td></tr>
				<% if("check".equals(info.getApplyCourseType())) {%>
				<tr><th>课程研发/更新申请工作流号:</th><td><a style="color:blue;"  onclick="workflowdetail()" id="jumpUrl"><%=info.getDevlopUpdateId()%></a></td></tr>
				<%} %>
				<tr><th>申请事由</th><td><%=info.getReason()%></td></tr>
				<%if(info1.getApplyPersonName()!=""){%>
			 	<tbody class="showQueryDetails" style="display: none;" >
			 					<tr class="showQueryDetails" style="display: none">
									<th colspan="2"><a class="yellow" id="skill" >以下是工作流号：<%=info.getDevlopUpdateId()%>,校验详情</a></th>
								</tr>
			 		<tr class="queryDetails"><th>工作流号:</th><td><%=info1.getProcessinstid() %></td></tr>
					<tr class="queryDetails"><th>申请人:</th><td><%=info1.getApplyPersonName()%></td></tr>
					<tr class="queryDetails"><th>申请人工号:</th><td><%=info1.getApplyPersonId()%></td></tr>
					<tr class="queryDetails"><th>所在部门:</th><td><%=info1.getApplyDept()%></td></tr>
						<%if("research".equals(info1.getApplyCourseType())){%>
							<tr><th>申请课程类型:</th><td>课程研发申请</td></tr>
						<%}else if("check".equals(info1.getApplyCourseType())){ %>
							<tr><th>申请课程类型:</th><td>课程审核申请</td></tr>
						<%}else if("update".equals(info1.getApplyCourseType())){ %>
							<tr><th>申请课程类型:</th><td>课程更新申请</td></tr>
						<%}else{ %>
							<tr><th>申请课程类型:</th><td><%=info1.getApplyCourseType()%></td></tr>
						<%} %>
					<tr class="queryDetails"><th>申请课程名称:</th><td><%=info1.getCourseName()%></td></tr>
					<tr class="queryDetails"><th>所属培训管理组:</th><td><%=info1.getTrainManagementGroup()%></td></tr>
					<tr class="queryDetails"><th>申请事由:</th><td><%=info1.getReason()%></td></tr>
								
			 
		 	<%} else{%>
		 		
		 			<tr> <th>该工作流号不存在！</th></tr>
		 		
		 	<%}%>
		 		<tr class="showQueryDetails" style="display: none">
									<th colspan="2"><a class="yellow"  onclick="closeDetails()">关闭工作流号校验详情</a></th>
					</tr>
		 		</tbody>
		 	</table>
			<%@include file="approve_process.jsp" %>
    	</div>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
	
	<input type="hidden" id="busino" value="<%=info.getBusino()%>">
	<input type="hidden" id="approval_url" value="<%=F_Constants.NORMOL_APPROVAL_URL%>">
</div>
</body>
<script type="text/javascript">
	function workflowdetail(){
		$(".showQueryDetails").slideDown(200);
		$('.queryDetails').show();
	};
	function closeDetails(){
		$(".showQueryDetails").slideUp(200);
		$('.queryDetails').hide();
	};
</script>
</html>