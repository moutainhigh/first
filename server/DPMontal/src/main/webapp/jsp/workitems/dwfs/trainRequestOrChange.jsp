<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.module.workitems.webservice.client.DWFSWorkItemServiceClient"%>
<%@page import="com.deppon.wfs.workflow.domain.TrainBean"%>
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
TrainBean info = (TrainBean)request.getAttribute("entity");
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
					   <td>培训需求申请/培训需求变更申请</td>
					</tr>
					<% if("request".equals(info.getApplyType())){
						//培训申请
					%>
					<!-- 培训申请 -->
									
				   <tr>
					  <th>申请类型:</th>
					  <td>培训需求申请</td>
				   </tr>			
				   <tr>
					  <th>申请人:</th>
					  <td><%=info.getApplyPersonName()%></td>
				   </tr>
					 <tr>
					  <th>申请人部门:</th>
					  <td><%=info.getApplyDeptName()%></td>
				   </tr>
				    <tr>
					  <th>所属培训组:</th>
					  <td><%=info.getTrainGroup() %></td><!-- WFS_TRAINORG -->
				   </tr>
				    <tr>
					  <th>培训类型:</th>
					  <td><%=info.getTrainType()%></td><!-- WFS_TRAINTYPE -->
				   </tr>
				   <tr>
					  <th>PMO立项:</th>
					  <td><%=info.getPmoProject()%></td><!-- WFS_ISORNO -->
				   </tr>
					<tr>
					  <th>项目名称:</th>
					  <td><%=info.getTrainName()%></td>
				   </tr>
				   <tr>
					  <th>培训时间从:</th>
					  <td><%=FormatUtil.formatDate(info.getBeginTrainDate())  %>&nbsp;&nbsp; 至  &nbsp;&nbsp;<%=FormatUtil.formatDate(info.getEndTrainDate()) %></td>
				   </tr>
				   <tr>
					  <th>预计培训人数:</th>
					  <td><%=info.getExpectedNum() %> </td>
				   </tr>
				      <tr>
					  <th>讲师资源是否充足:</th>
					  <td><%=info.getIsconsultant()%></td>
				   </tr>	
					<tr>
					  <th>培训对象:</th>
					  <td><%=info.getTrainObjects()%></td>
				   	</tr>
					 
					 <tr>
					  <th>费用核算金额:</th>
					  <td><%=info.getLecturerName()%></td>
				   </tr>
				 		   
				   
				   <tr>
					  <th>培训课程和目标:</th>
					  <td><%=info.getTrainSubjects()%></td>
				   </tr>
					<%
					}else if("change".equals(info.getApplyType())){
					%>
					<!-- 培训变更申请 -->
					<tr>
					  <th>申请类型:</th>
					  <td>培训需求变更申请</td>
				   </tr>
				   <tr>
					  <th>申请人:</th>
					  <td><%=info.getApplyPersonName()%></td>
				   </tr>
				     <tr>
					  <th>申请人部门:</th>
					  <td><%=info.getApplyDeptName()%></td>
				   </tr>
				   
					<tr>
					  <th>工号:</th>
					  <td><%=info.getApplyPersonId()%></td>
				   </tr>
				 
					<tr>
					  <th>所属培训组:</th>
					  <td><%=info.getTrainGroup()%></td> <!-- WFS_TRAINORG -->
				   </tr>
				   <tr>
					  <th>PMO立项:</th>
					  <td><%=info.getPmoProject()%></td><!-- WFS_ISORNO -->
				   </tr>
					<tr>
					  <th>项目名称:</th>
					  <td><%=info.getTrainName()%></td>
				   </tr>
				   <tr>
					  <th>变更类型:</th>
					  <td><%=info.getChangeType()%></td><!-- WFS_CHANGTYPE -->
				   </tr>
					<tr>
					  <th>培训申请工作流号:</th>
					  <td><%=info.getTrainRequestProcessinstid()%></td>
				   </tr>
 					<tr>
						<th>变更原因:</th>
						<td><%=info.getChangeReason()%></td>
					</tr>
					<tr>
						<th>变更内容:</th>
						<td><%=info.getChangeContent()%></td>
					</tr>
					<tr>
						<th>变更影响:</th>
						<td><%=info.getChangeEffect()%></td>
					</tr>
					<tr>
						<th>解决方案:</th>
						<td><%=info.getSolution()%></td>
					</tr> 
					<%
					}else{
					%>
					<tr>
					   <td>数据异常</td>
					</tr>
					<%
					} %>
				<%@include file="approve_process.jsp" %>					   					   
	    	</table>
	    </div>
	</div>
	 <%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>