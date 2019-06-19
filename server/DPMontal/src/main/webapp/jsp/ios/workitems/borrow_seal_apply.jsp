<%@page import="com.deppon.montal.model.OABorrowsealApply"%>
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
	OABorrowsealApply info = (OABorrowsealApply)request.getAttribute("OABorrowsealApply");
%>
<div id="list">
	<%@include file="/jsp/ios/work_items_head.jsp" %>
	<div id="div2">
    	<div class="ulBox2">
	    	<ul>
	    		<li class="first">工作流号:<em><%=info.getProcessinstid()%></em></li>
				<li>工作流:<em>借章申请</em></li>
				<li>申请人姓名:<em><%=info.getName()%></em></li>
				<li>工号:<em><%=info.getEmpcode()%></em></li>
				<li>部门:<em><%=info.getDept()%></em></li>
				<li>所属人事部:<em><%=info.getArea1()%></em></li>
<%-- 				<li>所属区域:<em><%=info.getArea2()%></em></li> --%>
				<li>印章名称:<em><%=info.getSealname()%></em></li>
				<li>印章类型:<em><%=info.getSealtype()%></em></li>
				<li>印章序号:<em><%=info.getSealsequencecode()%></em></li>
				<li>借阅份数:<em><%=info.getSealbrrowcounts()%></em></li>
				<li>章全宗号:<em><%=info.getSealgeneralcode()%></em></li>
				<li>印章档号:<em><%=info.getSealarchivalcode()%></em></li>
				<li>印章所属:<em><%=info.getSealdept()%></em></li>
				<li>印章财务部:<em><%=info.getSealbrief()%></em></li>
				<li>保管部门:<em><%=info.getSealasavedept()%></em></li>
				<li>印章编号:<em><%=info.getSealcode()%></em></li>
				<li>借阅天数:<em><%=info.getBorrowdays()%></em></li>
				<li>申请日期:<em><%=info.getStartdate()%></em></li>
 				<li>带章去处:<em><%=info.getSealtaketo()%></em></li>
				<li>归还时间:<em><%=info.getReturndate()%></em></li>
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