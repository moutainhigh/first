<%@page import="com.deppon.montal.model.OATrainRequest"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="java.text.Format"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.montal.conf.F_Constants"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_win8.jsp" %>
</head>

<body>
<div id="list">
	<%@include file="wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
				<%
					
					OATrainRequest apply = (OATrainRequest)request.getAttribute("trainRequest");	
				%>
				
				<tr>
				   <th>工作流号:</th>
				   <td id="workid"><%=apply.getProcessinstid()%></td>
				</tr>
				<tr>
				   <th>工作流:</th>
				   <td>培训需求申请</td>
				</tr>				
				<tr>
					<th>申请人:</th>
					<td><%=apply.getApplyname()%></td>
				</tr>			    
				
				<tr>
				   <th>申请人部门:</th>
				   <td><%=apply.getApplydeptname()%></td>
				</tr>
				<tr>
				   <th>培训类型:</th>
				   <td><%=apply.getTraintype()%></td>
				</tr>
				<tr>
				   <th>讲师资源是否充足:</th>
				   <td><%=apply.getIsconsultant()%></td>
				</tr>
				<tr>
				   <th>选择所属培训组:</th>
				   <td><%=apply.getTrainorgName()%></td>
				</tr>
				
				<tr>
				   <th>费用预算金额:</th>
				   <td><%=apply.getLecturername()%></td>
				</tr>
				<tr>
				   <th>培训对象:</th>
				   <td><%=apply.getTrainmanagerposition()%></td>
				</tr>
				<tr>
				   <th>预计培训人数:</th>
				   <td><%=apply.getExpectednum()%></td>
				</tr>
				<tr>
				   <th>培训起止时间:</th>
				   <td><%=FormatUtil.formatDate(apply.getBegintraindate())%>到<%=FormatUtil.formatDate(apply.getEndtraindate())%></td>
				</tr>
				<tr>
				   <th>培训课程和目标:</th>
				   <td><%=apply.getTrainsubjects()%></td>
				</tr>
			    <%@include file="approve_process.jsp" %>
		  </table>
		</div>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>