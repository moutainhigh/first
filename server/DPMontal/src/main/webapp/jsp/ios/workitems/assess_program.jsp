<%@page import="com.deppon.montal.model.OAAssessApply"%>
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
	OAAssessApply info = (OAAssessApply)request.getAttribute("assess_program");
%>
<div id="list">
	<%@include file="/jsp/ios/work_items_head.jsp" %>
	<div id="div2">
    	<div class="ulBox2">
	    	<ul>
			   <li class="first">工作流号:<em><%=info.getProcessinstid() %></em>
			   <input type="hidden" id="workid" value="<%=info.getProcessinstid()%>">
			   <input type="hidden" id ="type_id" value="assess_program">
<%-- 		   <input type="hidden" id ="currentnode_id" value="<%=info.getCurrentnode() %>"> --%>
			   </li>				  
          <li>工作流:<em>考核方案申请<input type="hidden" id ="type_id" value="assess_program"></em></li>
           <li>申请人:<em><%=info.getName()%></em></li>
           <li>考核部门:<em><%=info.getDept()%></em></li>
           <li>考核年份:<em><%=info.getYear()%></em></li>
           <li>考核季度:<em><%=info.getSeason()%></em></li>
           <li>申请事由:<em><%=info.getReason()==null?"":info.getReason()%></em></li>
           <li> 部门性质:<em><%=info.getQuality()%></em></li>
	    	</ul>
	    </div>
	     <%@include file="approve_process.jsp" %>
	</div>
	 <%@include file="workflow_approve_button.jsp" %>
</div>
</body>

</html>