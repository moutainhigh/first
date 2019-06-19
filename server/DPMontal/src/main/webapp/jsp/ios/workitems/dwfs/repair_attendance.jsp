<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.wfs.workflow.domain.RepairAttendanceDetails"%>
<%@page import="com.deppon.wfs.workflow.domain.RepairAttendance"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
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
 		RepairAttendance info = (RepairAttendance)request.getAttribute("entity");
%>
<body>
<div id="list">
<%@include file="/jsp/ios/work_items_head.jsp" %>
   <!--div2 S-->
   <div id="div2">
	   	<div class="ulBox2">
			<ul>
			 
			   <li class="first">工作流号:
			        <em><%=request.getAttribute("processinstid") %>
					<input type="hidden" id="busino" value="<%=info.getBusino()%>">
					<input type="hidden" id="approval_url" value="<%=F_Constants.NORMOL_APPROVAL_URL%>">		  	   		
			   		</em>
			   </li>
			   <li>工作流:<em>补考勤申请</em></li>
			   <li>申请人:<em><%=info.getApplyPersonName()%></em></li>
			   <li>所属区域:<em><%=info.getAreaName()%></em></li>
			   <li style="color: red">详细信息</li>
				<%
					for(int i=0;i<info.getRepairDetails().size() ;i++){
						RepairAttendanceDetails entry = info.getRepairDetails().get(i);
				%>
							   
				   <li <%=i==0?"":"class='line'" %>>补考勤人员:<em><%=entry.getAttendancepersonname()%></em></li>
				   <li>所在的部门:<em><%=entry.getDepartmentName()%></em></li>
				   <li>未打卡日期:<em><%=FormatUtil.formatDate(entry.getRepairTime())%></em></li>
				   <li>补考勤类型:<em><%=entry.getAttendanceType()%></em></li>
				   <li>补考勤事由:<em><%=entry.getAttendanceReason()%></em></li>
				   <li>证明人姓名:<em><%=entry.getConfirmName()%></em></li>
				<%
					}
				%>				   
			   <li>申请事由:<em><%=info.getApplyReason()==null?"":info.getApplyReason()%></em></li>
			</ul>
		</div>
		<%@include file="approve_process.jsp" %>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>