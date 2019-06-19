<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.model.OaLeaveDetail"%>
<%@page import="com.deppon.montal.conf.F_Constants"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.deppon.montal.conf.Constants"%>
<%@page import="com.deppon.montal.model.OaLeaveApply"%>
<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_win8.jsp" %>
</head>
<body>
 <%
 	OaLeaveApply info = (OaLeaveApply)request.getAttribute(Constants.PAGE_RESULT);

 %>
<div id="list">
	<%@include file="wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
	    		<tr>
					   <th>工作流号:</th>
					   <td id="workid"><%=info.getProcessinstid()%></td>
					</tr>
					<tr>
					   <th>工作流:</th>
					   <td>请假/调休申请<input type="hidden" id ="type_id" value="leaveapply"></td>
					</tr>
				   <tr>
					  <th >申请人姓名:</th>
					  <td><%=info.getApplyname() %></td>
				   </tr>
					 <tr>
					  <th >申请人工号:</th>
					  <td><%=info.getUserid() %></td>
				   </tr>
				   <tr>
					  <th >所属部门:</th>
					  <td><%=info.getOrgname() %></td>
				   </tr>
					 <tr>
					  <th >所属区域:</th>
					  <td><%=info.getArea() %></td>
				   </tr>
					 <tr>
					  <th >申请类别:</th>
					  <td>
					  <%=info.getApplycategory().equals("1")? "请假申请": 
					      info.getApplycategory().equals("2")? "加班调休申请" : "销假申请" %>
					    </td>
				   </tr>
				   <%
				   	if(!info.getApplycategory().equals("2")){
				   %>
					 <tr>
					  <th >假期所属类型:</th>
					  <td> 
					  <%=info.getDetailcategory().equals("0")?"无薪假":
					      info.getDetailcategory().equals("1")?"有薪假":
					      info.getDetailcategory().equals("2")?"病假":"产假"
					      %>
					  </td>
				   </tr>
				   <%
				   	}
				    if(info.getApplycategory().equals("1")){
				   %>	
					<tr>
						<th >入职日期:</th>
						<td >
						<%=FormatUtil.formatDate(info.getEmployeetime())%>
						
						</td>
					</tr>
					<tr>
						<th >请假类型:</th>
						<td><%= F_Constants.codeToString(info.getLeavecategory())%></td>
					</tr>
					<%
				    }
				    if(info.getApplycategory().equals("2")){
					%>
					<tr>
						<th >加班工作流号:</th>
						<td><%=info.getWorkflowno() %></td>
					</tr>
					<tr>
						<th >加班天数:</th>
						<td><%=info.getOvertimedays() %></td>
					</tr>
					<%
				    }	
				    if(info.getApplycategory().equals("1") || info.getApplycategory().equals("2")){
					%>
					<tr>
						<th >请假/调休开始日期:</th>
						<td><%=FormatUtil.formatDate(info.getDatestart())%></td>
					</tr>
					<tr>
						<th >请假/调休结束日期:</th>
						<td><%=FormatUtil.formatDate(info.getDatefinsh())%></td>
					</tr>
					<%
				    }
				    if(info.getApplycategory().equals("3")){
					%>
					
					<tr>
						<th >入职日期:</th>
						<td><%=FormatUtil.formatDate(info.getXiaojiaemployeetime()) %></td>
					</tr>
					<tr>
						<th >销假类型:</th>
						<td><%=F_Constants.codeToString(info.getXiaojia())%></td>
					</tr>
					<tr>
						<th >销假工作流号:</th>
						<td><%=info.getXiaojiaprocessinstid()%></td>
					</tr>
					<tr>
						<th >销假开始日期:</th>
						<td><%=FormatUtil.formatDate(info.getDatestartxiaojia())%></td>
					</tr>
					<tr>
						<th >销假结束日期:</th>
						<td><%=FormatUtil.formatDate(info.getDatefinshxiaojia())%></td>
					</tr>
					
					<%
				    }
					%>
					
					<tr>
							<th >请假/调休天数:</th>
							<td><%=info.getDays() %></td>
					</tr>
					<tr>
							<th >工作交接人:</th>
							<td ><%=info.getWorkto()%></td>
					</tr>
	
					<tr class="yellow"><th colspan="2">请假详细信息:</tr>
					<% 
						List<OaLeaveDetail> detailList = (List<OaLeaveDetail>)request.getAttribute("detailList");
						for(OaLeaveDetail detail : detailList){
					%>
					<tr class="topLine">
						<th>请假月份:</th>
						<td ><%=detail.getMonth() %></td>
					</tr>
					<tr>
						<th>当月请假天数:</th>
						<td><%=detail.getDays()%></td>
					</tr>
					<%} %>
				   <tr>
					  <th>申请理由:</th>
					  <td style="word-wrap:break-word;word-break:break-all"><%=info.getReason()== null ? "" : info.getReason()%></td>
				   </tr>
				   <%@include file="approve_process.jsp" %>
			  </table>
	    </div>
	</div>
	 <%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>