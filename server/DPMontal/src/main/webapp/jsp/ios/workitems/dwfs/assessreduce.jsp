<%@page import="com.deppon.wfs.workflow.domain.AssessReduceBean"%>
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
AssessReduceBean info = (AssessReduceBean)request.getAttribute("entity");
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
			   <li>工作流:<em> 考核特批减免申请</em></li>
					<li>
					  申请人:<em>
					  <%=info.getApplyPersonName()%></em>
				   </li>
				   <li>
					  申请人工号:<em>
					  <%=info.getApplyPersonId()%></em>
				   </li>	
				   <li>
					  申请人部门:<em>
					  <%=info.getApplyDept()%></em>
				   </li>				   			   
					 <li>
					  减免类别:<em>
					  <%=info.getReduceType()%></em><!-- WFS_REDUCETYPE -->
				   </li>
				   <%if("其他类".equals(info.getReduceType())){%>
					<li>
 					  选择考核小组:<em><!--WFS_ASSESSMENT_TEAM -->
					  <%=info.getAssessmentTeam()%></em><!-- WFS_ASSESSMENT_TEAM -->
				   	</li>
					<li>
					  选择考核专员/绩效管理员:<em><!--WFS_ASSESSMENT_AREA -->
					  <%=info.getPerformanceManager()%></em><!-- WFS_ASSESSMENT_AREA -->
				   </li>					   
				   <%} %>
				   <li>
					  申请事由:<em>
					  <%=info.getApplyReason()  %></em>
				   </li>
			</ul>
		</div>
		<%@include file="approve_process.jsp" %>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>

</html>