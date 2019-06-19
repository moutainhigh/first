<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.wfs.workflow.domain.SystempowerapplyParentBean"%>
<%@page import="com.deppon.wfs.workflow.domain.SystempowerapplyChildBean"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.montal.conf.F_Constants"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_ios.jsp" %>
</head>
<%
	SystempowerapplyParentBean apply = (SystempowerapplyParentBean)request.getAttribute("entity");
%>
<body>
<div id="list">
	<%@include file="/jsp/ios/work_items_head.jsp" %>
	<div id="div2">
		<div class="ulBox2">
    		<ul>
				<li class="first">工作流号:
			        <em><%=request.getAttribute("processinstid") %>
					<input type="hidden" id="busino" value="<%=apply.getBusino()%>">
					<input type="hidden" id="approval_url" value="<%=F_Constants.NORMOL_APPROVAL_URL%>">		  	   		
			   		</em>
			   </li>
			   <li>工作流:<em>系统权限申请</em></li>
			   		<li>申请人:<em><%=apply.getApplyPersonName()%></em></li>
					<li>工号:<em><%=apply.getApplyPersonId()%></em></li>
					<li>部门:<em><%=apply.getEmpdept()%></em></li>
					<li>职位:<em><%=apply.getEmpposition()%></em></li>
					<li style="color: red">申请明细</li>
				<%
					for(int i=0;i<apply.getSysApplyDetailedList().size();i++){
						SystempowerapplyChildBean entry = apply.getSysApplyDetailedList().get(i);
				%>
				   <li <%=i==0?"":"class='line'" %>>所属系统:<em><%=entry.getBelongSystem()%></em></li>
				   <li>所属模块:<em><%=entry.getBelongModular()%></em></li>
				   <li>权限描述:<em><%=entry.getAuthorityDescription() %></em></li>
			   	<%
					}
			   	%>
			    
				  <li>申请事由:<em><%=apply.getWhyapply()==null?"":apply.getWhyapply() %></em></li>
		  </ul>
		</div>
		<%@include file="approve_process.jsp" %>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>