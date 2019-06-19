<%@page import="com.deppon.montal.model.OAExterNaltraining"%>
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
					OAExterNaltraining training = (OAExterNaltraining)request.getAttribute("training");
				%>
	    		
	    		<li class="first">工作流号：<em><%=training.getProcessinstid() %></em>
				   <input type="hidden" id="workid" value="<%=training.getProcessinstid()%>">
				</li>
			    <li>工作流:<em>外训申请</em></li>
			    
			    <li>申请人姓名:<em><%=training.getName()%></em></li>
			    <li>申请人工号:<em><%=training.getApppersonnumber()%></em></li>
			    <li>申请人部门:<em><%=training.getApppersonorgname()%></em></li>
			    <li>参加人姓名:<em><%=training.getParticipant()%></em></li>
			    <li>所属人事部:<em><%=training.getPersonel()%></em></li>
			    <li>课程费用:<em><%=training.getCoursefee()%></em></li>
			    <li>培训地点:<em><%=training.getTrainplace()%></em></li>
			    
			    <li>举办机构:<em><%=training.getSponsoringorg()%></em></li>
			    <li>是否向培训组备案:<em><%=training.getIsremark()%></em></li>
			    <li>申请事由:<em><%=training.getReason()%></em></li>
	    	</ul>
	    </div>
	     <%@include file="approve_process.jsp" %>
	</div>
	 <%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>