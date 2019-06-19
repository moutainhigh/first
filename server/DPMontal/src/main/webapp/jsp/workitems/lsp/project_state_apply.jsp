<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.WorkflowEntity"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.ProjectStatusVo"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.ProjectStatusEntity"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.ProjectStatusEntry"%>
<%@page import="java.util.List"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_win8.jsp" %>
</head>

<body>
 <%
	 WorkflowEntity info = (WorkflowEntity)request.getAttribute("lspResponseEntity");
	 ProjectStatusVo temp = info.getProjectStatusVo();
	 ProjectStatusEntity base = temp.getProjectStatusEntity();
	 List<ProjectStatusEntry> items1 = temp.getProjectStatusEntry();
 %>
<div id="list">
	<%@include file="../wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table>
	    		<tr><th colspan="2" class="yellow">基本信息</th></tr>
	    		<tr><th>工&nbsp;&nbsp;作&nbsp;&nbsp;流:</th><td>工程项目状态申请单</td></tr>
	    		<tr><th>单据编号:</th><td id="workid"><%=base.getFnumber()%></td></tr>
				<tr><th>申请人:</th><td><%=base.getFapplypersonIdAsName()%></td></tr>
				<tr><th>申请日期:</th><td><%=base.getCfpetitionDateStr()%></td></tr>
				<tr><th>申请部门:</th><td><%=base.getCfpetitionOrgIdAsName()%></td></tr>
				<tr><th>申请状态:</th><td><%=base.getCfpetitionState()%></td></tr>
			   	<tr><th>项目状态:</th><td><%=base.getFprojectState()%></td></tr>
			   	<tr><th>项目编号:</th><td><%=base.getCfprojectNumberIdAsName()%></td></tr>
			   	<tr><th>项目名称:</th><td><%=base.getFprojectName()%></td></tr>
			   	<tr><th>项目发起部门:</th><td><%=base.getCfstartDeptIdAsName()%></td></tr>
			   	<tr><th>申请原因:</th><td><%=base.getCfpetitionCause()%></td></tr>
			   	<tr><th>暂停原因:</th><td><%=base.getCfpauseCause()%></td></tr>
			   	<tr class="yellow"><td colspan="2">会审意见</td></tr>
			   	<tr><th>会议主题:</th><td><%=base.getCfmeetingTheme()%></td></tr>
			    <tr><th>会议时间:</th><td><%=base.getCfjudgeDateStr()%></td></tr>
			    <tr><th>会审人员:</th><td><%=base.getFjudgeContainerAsName()%></td></tr>
			    <tr><th>会审决策:</th><td><%=base.getCfjudgereSolve()%></td></tr>

				<tr class="yellow"  ><td colspan="2">其他信息-代办明细</td></tr>
				<%for(int i = 0; i < items1.size() ; i++ ) {
					ProjectStatusEntry obj1 = items1.get(i);
				%>
					<tr <%=i==0 ? "" : "class='topLine'" %>><th>序号:</th><td><%=i+1 %></td></tr>
				   	<tr><th>会议主题:</th><td><%= obj1.getCfWaitMatter()%></td></tr>
				    <tr><th>负责人:</th><td><%= obj1.getCfResponsibleIdAsName()%></td></tr>
				   	<tr><th>完成时间:</th><td><%= obj1.getCfFinishTimeStr()%></td></tr>
				    <tr><th>备注:</th><td><%= obj1.getCfComment()%></td></tr>
			   <%} %>
		  </table>
		  <%@include file="approve_process_esb.jsp" %>
		</div>
	</div>
	<%@include file="workflow_approve_button_esb.jsp" %>
</div>
<script type="text/javascript">
	
</script>
</body>
</html>