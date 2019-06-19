<%@page import="com.deppon.wfs.workflow.domain.WarrantEntityBean"%>
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
WarrantEntityBean info = (WarrantEntityBean)request.getAttribute("entity");
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
			   <li>工作流:<em>人事授权申请</em></li>
			   	<li>
					  申请人:<em><%=info.getApplyPersonName()%></em>
				</li>
				<li>
					  授权给:<em><%=info.getImpowerto()%></em>
				</li>
				<li>
					  授权开始时间:<em><%=FormatUtil.formatDate(info.getImpowerstarttime())  %></em>
				</li>
				<li>
					  授权结束时间:<em><%=FormatUtil.formatDate(info.getImpowerendtime())%></em>
				</li>
				<li>
				  	申请事由:<em><%=info.getReason()%></em>
			   	</li>
			</ul>
		</div>
		<%@include file="approve_process.jsp" %>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>