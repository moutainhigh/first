<%@page import="com.deppon.wfs.workflow.domain.DataProvideApproval"%>
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
 		DataProvideApproval info = (DataProvideApproval)request.getAttribute("entity");
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
			   <li>工作流:<em> 数据提供审批</em></li>
			   <li>申请人:<em><%=info.getApplyPersonName()%></em></li>
			   <li>所属组织:<em><%=info.getOragnizationName()%></em></li>
			   <li>数据提供给:<em><%=info.getTargetName()%></em></li>
			   <%if("3".equals(info.getTarget())){%>
				   <li>所属事业部:<em><%=info.getAreaName()%></em></li>
			   <%} %>
			   <li>申请事由:<em><%=info.getApplyReason()%></em></li>
			</ul>
		</div>
		<%@include file="approve_process.jsp" %>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>