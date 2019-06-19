<%@page import="com.deppon.montal.model.OAElectroniContractBorrow"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_ios.jsp" %>
</head>
<body>
<div id="list">
	<%@include file="/jsp/ios/work_items_head.jsp" %>
	<div id="div2">
    	<div class="ulBox2">
	    	<ul>
				<%
					OAElectroniContractBorrow apply = (OAElectroniContractBorrow)request.getAttribute("borrowApply");
				%>
				<li class="first">工作流号：<em><%=apply.getProcessinstid() %></em>
				   <input type="hidden" id="workid" value="<%=apply.getProcessinstid()%>">
				</li>
			    <li>工作流:<em>电子合同借阅</em></li>
			    
			    <li>姓名:<em><%=apply.getName() %></em></li>
			    <li>工号:<em><%=apply.getEmpcode()%></em></li>
			    <li>所属事业部:<em><%=apply.getArea() %></em></li>
			    <li>合同编号:<em><%=apply.getContractnum()%></em></li>
			    <li>合同类别:<em><%=apply.getContracttype()==null?"":apply.getContracttype()%></em></li>
			    <li>合同密级:<em><%=OAElectroniContractBorrow.BORROW_CONTRACT_DENSE.get(apply.getContractdense())%></em></li>
			    <li>借阅天数:<em><%=apply.getBorrowdays()%></em></li>
			    <li>开始时间:<em><%=apply.getStartdate()%></em></li>
			    <li>结束时间:<em><%=apply.getEnddate()%></em></li>
				<li>申请事由:<em> <%=apply.getReason()==null?"":apply.getReason() %></em></li>
			</ul>
	    </div>
	     <%@include file="approve_process.jsp" %>
	</div>
	 <%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>