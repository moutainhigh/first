<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.wfs.workflow.domain.SystempowerapplyParentBean"%>
<%@page import="com.deppon.wfs.workflow.domain.SystempowerapplyChildBean"%>
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
	SystempowerapplyParentBean apply = (SystempowerapplyParentBean)request.getAttribute("entity");
%>
<body>
<div id="list">
	<%@include file="../wf_head_win8.jsp" %>
	<input type="hidden" id="busino" value="<%=apply.getBusino()%>">
	<input type="hidden" id="approval_url" value="<%=F_Constants.NORMOL_APPROVAL_URL%>">
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
				<tr>
				   <th>工作流号:</th>
				   <td id="workid"><%=apply.getProcessinstid()%></td>
				</tr>
				<tr>
				   <th>工作流:</th>
				   <td>系统权限申请<input type="hidden" id ="type_id" value="systemPowerApply">
				   </td>
				</tr>
				<tr>
					<th>申请人:</th>
					<td><%=apply.getApplyPersonName()%></td> 
				</tr>
				<tr>
					<th>工号:</th>
					<td><%=apply.getApplyPersonId()%></td>
				</tr>
				<tr>
					<th>部门:</th>
					<td><%=apply.getEmpdept()%></td>
				</tr>
				<tr>
					<th>职位:</th>
					<td><%=apply.getEmpposition()%></td>
				</tr>
				<tr>
					<th colspan="2" class="yellow">申请明细</th>
				</tr>
				<%
					for(int i=0;i<apply.getSysApplyDetailedList().size();i++){
						SystempowerapplyChildBean entry = apply.getSysApplyDetailedList().get(i);
				%>
				
					<tr class="topLine">
				   <th>所属系统:</th>
				   <td><%=entry.getBelongSystem()%></td>
				</tr>
				<tr>
				   <th>所属模块:</th>
				   <td><%=entry.getBelongModular()%></td>
				</tr>
				<tr>
				   <th>权限描述 :</th>
				   <td><%=entry.getAuthorityDescription() %></td>
				</tr>
				
			   	<%
					}
			   	%>
			    
			    <tr>
				  <th>申请事由:</th>
				  <td style="word-wrap:break-word;word-break:break-all"><%=apply.getWhyapply()==null?"":apply.getWhyapply() %></td>
			    </tr>
			    
			    <%@include file="approve_process.jsp" %>
		  </table>
		</div>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>