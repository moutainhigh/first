<%@page import="com.deppon.montal.model.OABorrowsealApply"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_win8.jsp" %>
</head>
<body>
<%
	OABorrowsealApply info = (OABorrowsealApply)request.getAttribute("OABorrowsealApply");
%>
<div id="list">
	<%@include file="wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
	    		<tr><th>工作流号:</th><td id="workid"><%=info.getProcessinstid()%></td></tr>
				<tr><th>工作流:</th><td>借章申请</td></tr>
				<tr><th>姓名:</th><td><%=info.getName()%></td></tr>
				<tr><th>工号:</th><td><%=info.getEmpcode()%></td></tr>
				<tr><th>部门:</th><td><%=info.getDept()%></td></tr>
				<tr><th>所属事业部:</th><td><%=info.getArea1()%></td></tr>
<%-- 				<tr><th>所属区域:</th><td><%=info.getArea2()%></td></tr> --%>
				<tr><th>印章名称:</th><td><%=info.getSealname()%></td></tr>
				<tr><th>印章类型:</th><td><%=info.getSealtype()%></td></tr>
				<tr><th>印章序号:</th><td><%=info.getSealsequencecode()%></td></tr>
				<tr><th>借阅份数:</th><td><%=info.getSealbrrowcounts()%></td></tr>
				<tr><th>章全宗号:</th><td><%=info.getSealgeneralcode()%></td></tr>
				<tr><th>印章档号:</th><td><%=info.getSealarchivalcode()%></td></tr>
				<tr><th>印章所属:</th><td><%=info.getSealdept()%></td></tr>
				<tr><th>印章财务部:</th><td><%=info.getSealbrief()%></td></tr>
				<tr><th>保管部门:</th><td><%=info.getSealasavedept()%></td></tr>
				<tr><th>印章编号:</th><td><%=info.getSealcode()%></td></tr>
				<tr><th>借阅天数:</th><td><%=info.getBorrowdays()%></td></tr>
				<tr><th>申请日期:</th><td><%=info.getStartdate()%></td></tr>
 				<tr><th>带章去处:</th><td><%=info.getSealtaketo()%></td></tr>
				<tr><th>归还时间:</th><td><%=info.getReturndate()%></td></tr>
				<tr><th>申请事由:</th><td><%=info.getReason()%></td></tr>
	    	</table>
	    	 <%@include file="approve_process.jsp" %>
	    </div>
	</div>
	 <%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>