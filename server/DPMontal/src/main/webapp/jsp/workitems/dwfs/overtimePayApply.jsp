<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.module.workitems.webservice.client.DWFSWorkItemServiceClient"%>
<%@page import="com.deppon.wfs.workflow.domain.OvertimeApplyParentBean"%>
<%@page import="com.deppon.wfs.workflow.domain.OvertimeApplyChildBean"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_win8.jsp" %>
	<style>
	tr.details, tr.qytr { display:none;}
	</style>
</head>
<body onload="autoShowApproval()">
<%
OvertimeApplyParentBean info = (OvertimeApplyParentBean)request.getAttribute("entity");
%>
<div id="list">
	<%@include file="../wf_head_win8.jsp" %>
	<input type="hidden" id="busino" value="<%=info.getBusino()%>">
	<input type="hidden" id="approval_url" value="<%=F_Constants.NORMOL_APPROVAL_URL%>">
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
	    		<tr>
					   <th>工作流号:</th>
					   <td id="workid"><%=request.getAttribute("processinstid")%></td>
					</tr>
					<tr>
					   <th>工&nbsp;&nbsp;作&nbsp;&nbsp;流:</th>
					   <td>加班/加班工资申请 </td>
					</tr>
				   <tr>
					  <th>申请人:</th>
					  <td><%=info.getApplyPersonName()%></td>
				   </tr>
					 <tr>
					  <th>申请人工号:</th>
					  <td><%=info.getApplyPersonId()%></td>
				   </tr>
				   <tr>
					  <th>申请人部门:</th>
					  <td><%=info.getDept()%></td>
				   </tr>
					 <tr>
					  <th>申请人职位:</th>
					  <td><%=info.getPosition()%></td>
				   </tr>
					 <tr>
					  <th>申请类型:</th>
					  <td><%=info.getApplyTypeCode()%></td>
				   </tr>
				   <tr>
					  <th>所属人事部:</th>
					  <td><%=info.getPersonnelDeptName()%></td>
				   </tr>
				   <%if("管理人员晚班".equals(info.getApplyTypeCode())){%>
					   <tr>
						  <th>晚班开始日期:</th>
						  <td><%=info.getNbeginDateStr()%></td>
					   </tr>
					   <tr>
						  <th>晚班结束日期:</th>
						  <td><%=info.getNendDateStr()%></td>
					   </tr>
					   <tr>
						  <th>晚班总天数:</th>
						  <td><%=info.getNightDays()%></td>
					   </tr>
					   <tr>
						  <th>证明人:</th>
						  <td><%=info.getNwitness()%></td>
					   </tr>
				  <%}else{%>
				   <%if("加班工资申请".equals(info.getApplyTypeCode())){ %>
				   <tr>
					  <th>加班工作流号:</th>
					  <td><%=info.getOtapplyno()%></td>
				   </tr>
				   <%}%>
				   <tr>
					  <th>平时加班总天数:</th>
					  <td><%=info.getWorkdays()==null?"":info.getWorkdays()%></td>
				   </tr>
				   <tr>
					  <th>周末加班总天数:</th>
					  <td><%=info.getHolidays()==null?"":info.getHolidays()%></td>
				   </tr>
				   <tr>
					  <th>法定加班总天数:</th>
					  <td><%=info.getLegaldays()==null?"":info.getLegaldays()%></td>
				   </tr>
				   <tr class="yellow">
						<th colspan="2" class="yellow">加班信息：</th>
				   </tr>
				   <%
				   int  infoSizes = info.getOverTimeInfoList() == null?0:info.getOverTimeInfoList().size();
				   for(int i=0;i<infoSizes;i++){
					   OvertimeApplyChildBean item = info.getOverTimeInfoList().get(i);
				   %>
						   <tr <%=i==0?"":"class='topLine'" %>>
							  <th>加班类型:</th>
							  <td><%=item.getOttype()%></td>
						   </tr>
						   <tr>
							  <th>加班开始日期:</th>
							  <td><%=item.getBeginDateStr()%></td>
						   </tr>
						   <tr>
							  <th>加班结束日期:</th>
							  <td><%=item.getEndDateStr()%></td>
						   </tr>
						 <%}%>
				   <%}%>
				   <tr>
					  <th>申请事由:</th>
					  <td><%=info.getReason()%></td>
				   </tr>
					
				<%@include file="approve_process.jsp" %>					   					   
	    	</table>
	    </div>
	</div>
	 <%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>