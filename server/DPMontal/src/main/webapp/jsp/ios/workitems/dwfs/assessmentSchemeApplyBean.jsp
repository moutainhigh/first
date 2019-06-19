<%@page import="com.deppon.wfs.workflow.domain.AssessmentSchemeApplyBean"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
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
	AssessmentSchemeApplyBean info = (AssessmentSchemeApplyBean)request.getAttribute("entity");
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
			   
			   <li>工作流:<em>考核方案提交申请</em></li>
			   <li>申请人:<em><%=info.getApplyPersonName()%></em></li>
			   <li>考核部门:<em><%=info.getDept()%></em></li>
			   <li>考核年份:<em><%=info.getYear()%></em></li>
			   <li>考核季度:<em><%=info.getSeason()%></em></li><!-- WFS_ASSESSMENT_QUARTER -->
			   <li>选择考核小组:<em><%=info.getCheckTeamCode()%></em></li><!-- WFS_CHECK_TEAM -->
			   <li>选择考核专员/绩效管理员:<em><%=info.getPersonMappingDeptName()%></em></li>
			   <li>申请事由:<em><%=info.getApplyReason()%></em></li>
					
			</ul>
		</div>
		<%@include file="approve_process.jsp" %>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>