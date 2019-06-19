<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.wfs.workflow.domain.OvertimeApplyParentBean"%>
<%@page import="com.deppon.wfs.workflow.domain.OvertimeApplyChildBean"%>
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
OvertimeApplyParentBean info = (OvertimeApplyParentBean)request.getAttribute("entity");
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
			   <li>工作流:<em>
		   		   加班/加班工资申请
			   </em></li>
					  <li>申请人:<em>
					  <%=info.getApplyPersonName()%></em>
				   </li>
					 
					  <li>申请人工号:<em>
					  <%=info.getApplyPersonId()%></em>
				   </li>
				   
					  <li>申请人部门:<em>
					  <%=info.getDept()%></em>
				   </li>
					 
					  <li>申请人职位:<em>
					  <%=info.getPosition()%></em>
				   </li>
					 
					  <li>申请类型:<em>
					  <%=info.getApplyTypeCode()%></em>
				   </li>
				   
					  <li>所属人事部:<em>
					 <%=info.getPersonnelDeptName()%></em>
				   </li>
				    <%if("管理人员晚班".equals(info.getApplyTypeCode())){%>
				   
					  <li>晚班开始日期:<em>
					  <%=info.getNbeginDateStr()%></em>
				   </li>
					 
					  <li>晚班结束日期:<em>
					  <%=info.getNendDateStr()%></em>
				   </li>
					  
				   <li>晚班总天数:<em>
					 <%=info.getNightDays()%></em>
				   </li>
					  <li>证明人:<em>
					  <%=info.getNwitness()%></em>
				   </li>
				   <%}else{%>
				   <%if("加班工资申请".equals(info.getApplyTypeCode())){ %>
					  <li>加班工作流号:<em>
					  <%=info.getOtapplyno()%></em>
				   </li>				   
				   <%}%>
				   
					  <li>平时加班总天数:<em>
					  <%=info.getWorkdays()==null?"":info.getWorkdays()%></em>
				   </li>
				   <li>周末加班总天数:<em>
					  <%=info.getHolidays()==null?"":info.getHolidays()%></em>
				   </li>
					  <li>法定加班总天数:<em>
					 <%=info.getLegaldays()==null?"":info.getLegaldays()%></em>
				   </li>
				   
				   <li><em class="yellow">加班信息</em></li>
				   <%
				   int  infoSizes = info.getOverTimeInfoList() == null?0:info.getOverTimeInfoList().size();
				   for(int i=0;i<infoSizes;i++){
					   OvertimeApplyChildBean item = info.getOverTimeInfoList().get(i);
				%>
					  <li <%=i==0?"":"class='line'" %>>加班类型:<em>
					  <%=item.getOttype()%></em>
				   </li>
					  <li>加班开始日期:<em>
					 <%=item.getBeginDateStr()%></em>
				   </li>
					  <li>加班结束日期:<em>
					 <%=item.getEndDateStr()%></em>
				   </li>
				    <%}%>
				   <%}%>
					 <li>申请事由:<em>
						 <%=info.getReason()%></em>
					  </li>
			</ul>
		</div>
		<%@include file="approve_process.jsp" %>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>