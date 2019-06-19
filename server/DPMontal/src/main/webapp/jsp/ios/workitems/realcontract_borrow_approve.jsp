<%@page import="com.deppon.montal.model.OARealcontractBorrow"%>
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
	OARealcontractBorrow info = (OARealcontractBorrow)request.getAttribute("OARealcontractBorrow");
%>
<body>
<div id="list">
	<%@include file="/jsp/ios/work_items_head.jsp" %>
	<div id="div2">
		<div class="ulBox2">
			<ul>
				<li class="first"> 工作流号:<em><%=info.getProcessinstid() %></em>
					<input type="hidden" id="workid" value="<%=info.getProcessinstid()%>">
				</li>
				<li>工作流:<em>实体合同借阅</em></li>
				<li>姓名:<em><%=info.getName()%></em></li>
				<li>工号:<em><%=info.getEmpcode()%></em></li>
				<li>所属事业部:<em><%=info.getArea()%></em></li>
				<li>合同编号:<em><%=info.getContractnum()%></em></li>
				<li>客户名称:<em><%=info.getCustomername()%></em></li>
				<li>签订部门:<em><%=info.getSigndepartment()%></em></li>
				<li>合同类别:<em><%=info.getContracttype()%></em></li>
				<li>合同密级:<em><% String ontractdense =info.getContractdense();%>
				   	   <%= "1".equals(ontractdense)?"普通":
				   	       "2".equals(ontractdense)?"机密":
				   		   "3".equals(ontractdense)?"绝密":""
				   		   %>
				</em>
				</li>
				<li>借阅天数:<em><%=info.getBorrowdays()%></em></li>
				<li>开始时间:<em><%=info.getStartdate()%></em></li>
				<li>结束时间:<em><%=info.getEnddate()%></em></li>
				<li>申请事由<em><%=info.getReson()%></em></li>
			</ul>
		</div>
	    <%@include file="approve_process.jsp" %>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>