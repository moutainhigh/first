<%@page import="com.deppon.montal.model.OAaddAttendanceEntry"%>
<%@page import="com.deppon.montal.model.OAaddAttendance"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.montal.conf.F_Constants"%>
<%@page import="java.util.List"%>
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
	OAaddAttendance attend = (OAaddAttendance)request.getAttribute("addAttendance");
	List<OAaddAttendanceEntry> attendDetails = (List<OAaddAttendanceEntry>)request.getAttribute("attendDetails");
%>
<body>
<div id="list">
<%@include file="/jsp/ios/work_items_head.jsp" %>
   <!--div2 S-->
   <div id="div2">
   	<div class="ulBox2">
		<ul data-role="listview" id="ulist" data-inset="ture" data-theme="c" data-dividertheme="b">
		 
		   <li class="first">工作流号:
		        <em><%=attend.getProcessinstid() %>
		  	   		<input type="hidden" id="workid" value="<%=attend.getProcessinstid()%>">
		  	   		<input type="hidden" id="type_id" value="addattendance">
		   		</em>
		   </li>
		   <li>工作流:<em>补考勤申请</em></li>
		   <li>申请人:<em><%=attend.getName()%></em></li>
		   <li>工作流:<em><%=attend.getAreaname()%></em></li>
		   <li>详细信息</li>
			<%
				for(int i=0;i<attendDetails.size();i++){
					OAaddAttendanceEntry entry = attendDetails.get(i);
			%>
						   
			   <li <%=i==0?"":"class='line'" %>>补考勤人员:<em><%=entry.getAddman()%></em></li>
			   <li>所在部门:<em><%=entry.getAdddept()%></em></li>
			   <li>未打卡日期:<em><%=entry.getAdddate()%></em></li>
			   <li>补考勤类型:<em><%=entry.getAddtype()%></em></li>
			   <li>补考勤事由:<em><%=entry.getReason()%></em></li>
			   <li>证明人姓名:<em><%=entry.getReference()%></em></li>
			<%
				}
			%>			   
			   <li class="last">申请事由：<em><%=attend.getRemark()==null?"":attend.getRemark() %></em></li>
			</ul>
		</div>
		<%@include file="approve_process.jsp" %>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>