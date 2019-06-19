<%@page import="com.deppon.montal.model.OALicenseCanceledInfo"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_ios.jsp" %>
</head>
<body>
<%
	OALicenseCanceledInfo info = (OALicenseCanceledInfo)request.getAttribute("licensecanceledinfo");
%>
<div id="list">
	<%@include file="/jsp/ios/work_items_head.jsp" %>
	<div id="div2">
   	<div class="ulBox2">
			<ul>
	    		<li class="first">工作流号:<em><%=info.getProcessinstid()%></em></li>
				<li>工作流:<em>分公司证照注销</em></li>
				<li>申请人姓名:<em><%=info.getName()%></em></li>
				<li>部门名称:<em><%=info.getOrgname()%></em></li>
				<li>分公司名称:<em><%=info.getSubcompany()%></em></li>
				<li>注销时效:<em><%=info.getCancellaging()%></em></li>
				<li>所属财务部:<em><%=info.getFinancedep()%></em></li>
				<li>所属公共事务组:<em><%=info.getMatterteam()%></em></li>
				<li>注销证照种类:<em><%=info.getCanceltype()%></em></li>
				<li>申请事由:<em><%=info.getReason()%></em></li>
	    	</ul>
	    </div>
	    <%@include file="approve_process.jsp" %>
	</div>
	 <%@include file="workflow_approve_button.jsp" %>
	 
	 
	 
	 <input type="hidden" id="workid" value="<%=info.getProcessinstid()%>">
</div>
</body>
</html>