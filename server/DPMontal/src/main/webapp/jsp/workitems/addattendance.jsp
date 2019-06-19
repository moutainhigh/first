<%@page import="com.deppon.montal.model.OAaddAttendanceEntry"%>
<%@page import="com.deppon.montal.model.OAaddAttendance"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.montal.conf.F_Constants"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_win8.jsp" %>
</head>
<%
	OAaddAttendance attend = (OAaddAttendance)request.getAttribute("addAttendance");
	List<OAaddAttendanceEntry> attendDetails = (List<OAaddAttendanceEntry>)request.getAttribute("attendDetails");
%>
<body>
<div id="list">
	<%@include file="wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
				<tr>
				   <th>工作流号:</th>
				   <td id="workid"><%=attend.getProcessinstid()%></td>
				</tr>
				<tr>
				   <th>工作流:</th>
				   <td>补考勤申请<input type="hidden" id ="type_id" value="addattendance">
				   </td>
				</tr>
				<tr>
					<th>申请人:</th>
					<td><%=attend.getName()%></td>
				</tr>
			    <tr>
				   <th>所属区域:</th>
				   <td><%=attend.getAreaname()%></td>
				</tr>
				<tr>
					<th colspan="2" class="yellow">补考勤详情</th>
				</tr>
				<%
					for(int i=0;i<attendDetails.size();i++){
						OAaddAttendanceEntry entry = attendDetails.get(i);
				%>
				<tr class="topLine">
				   <th>补考勤人员:</th>
				   <td><%=entry.getAddman()%></td>
				</tr>
				<tr>
				   <th>所在部门:</th>
				   <td><%=entry.getAdddept()%></td>
				</tr>
				<tr>
				   <th>未打卡日期:</th>
				   <td><%=entry.getAdddate()%></td>
				</tr>
				<tr>
				   <th>补考勤类型:</th>
				   <td><%=entry.getAddtype()%></td>
				</tr>
				<tr>
				   <th>补考勤事由:</th>
				   <td><%=entry.getReason()%></td>
				</tr>
				<tr>
				   <th>证明人姓名:</th>
				   <td><%=entry.getReference()%></td>
				</tr>
				<%
					}
				%>
			    <tr class="topLine">
				  <th>申请事由:</th>
				  <td style="word-wrap:break-word;word-break:break-all"><%=attend.getRemark()==null?"":attend.getRemark() %></td>
			    </tr>
			    <%@include file="approve_process.jsp" %>
		  </table>
		</div>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>