<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.WorkflowEntity"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.ProjectapprovalVo"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.ProjectApprovalEntity"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.ProjectApprovalEntryEntity"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.ProjectApprovalDEntryEntity"%>
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
 ProjectapprovalVo temp = info.getProjectapprovalVo();
 ProjectApprovalEntity base = temp.getProjectApprovalEntity();
 ProjectApprovalEntryEntity[] items1 = temp.getProjectApprovalEntryEntityList();
 ProjectApprovalDEntryEntity[] items2 = temp.getProjectApprovalDEntryEntityList();
 %>
<div id="list">
	<%@include file="../wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table>
	    		<tr><th colspan="2" class="yellow">基本信息</th></tr>
	    		<tr><th>工&nbsp;&nbsp;作&nbsp;&nbsp;流:</th><td>工程项目立项单</td></tr>
	    		<tr><th>项目编号:</th><td id="workid"><%=base.getNumber() %></td></tr>
			   	<tr><th>项目名称:</th><td><%=base.getName()%></td></tr>
			   	<tr><th>项目状态:</th><td><%=base.getProjectstatus()%></td></tr>
				<tr><th>所属事业部:</th><td><%=base.getDivision()%></td></tr>
			   	<tr><th>项目类型:</th><td><%=base.getProjecttpye()%></td></tr>
			   	<tr><th>单据状态:</th><td><%=base.getState()%></td></tr>
				<tr><th>申请时间:</th><td><%=base.getProapplitimeStr()%></td></tr>
			   	<tr><th>项目地点:</th><td><%=base.getProjectseat()%></td></tr>
			   	<tr><th>申请部门:</th><td><%=base.getCreateorg()%></td></tr>
			   	<tr><th>总工程编号:</th><td><%=base.getTotalprojectno()%></td></tr>
			   	<tr><th>预计开始时间:</th><td><%=base.getProjectexpstartStr()%></td></tr>
			   	<tr><th>项目经理:</th><td><%=base.getProjectmanager()%></td></tr>
			   	<tr><th>预计结束时间:</th><td><%=base.getProjectexpendStr()%></td></tr>
			    <tr><th>概算金额:</th><td><%=base.getBudgetamountStr()%></td></tr>
			    <%if (base.getNeedrecovery() == 1) { %>
			    	<tr><th><input type="checkbox" checked="checked"/>是否需要复原</th></tr>
				<%} else { %>
					<tr><th><input type="checkbox" />是否需要复原</th></tr>
				<%}%>
				<%if (base.getWheneeddesign() == 1) { %>
			    	<tr><th><input type="checkbox" checked="checked"/>是否做办公深度设计</th></tr>
				<%} else { %>
					<tr><th><input type="checkbox" />是否做办公深度设计</th></tr>
				<%}%>
				<%if (base.getInternalaudit() == 1) { %>
			    	<tr><th><input type="checkbox" checked="checked"/>内部审计</th></tr>
				<%} else { %>
					<tr><th><input type="checkbox" />内部审计</th></tr>
				<%}%>
				<%if (base.getExteraudit() == 1) { %>
			    	<tr><th><input type="checkbox" checked="checked"/>外部审计</th></tr>
				<%} else { %>
					<tr><th><input type="checkbox" />外部审计</th></tr>
				<%}%>
				<%if (base.getPromanaout() == 1) { %>
			    	<tr><th><input type="checkbox" checked="checked"/>工程管理服务外包</th></tr>
				<%} else { %>
					<tr><th><input type="checkbox" />工程管理服务外包</th></tr>
				<%}%>
				<%if (base.getFireapproval() == 1) { %>
			    	<tr><th><input type="checkbox" checked="checked"/>消防报批</th></tr>
				<%} else { %>
					<tr><th><input type="checkbox" />消防报批</th></tr>
				<%}%>
				<%if (base.getWhetherfor() == 1) { %>
			    	<tr><th><input type="checkbox" checked="checked"/>是否甲供</th></tr>
				<%} else { %>
					<tr><th><input type="checkbox" />是否甲供</th></tr>
				<%}%>
				<%if (base.getDesignout() == 1) { %>
			    	<tr><th><input type="checkbox" checked="checked"/>设计外包</th></tr>
				<%} else { %>
					<tr><th><input type="checkbox" />设计外包</th></tr>
				<%}%>
				<%if (base.getConstout() == 1) { %>
			    	<tr><th><input type="checkbox" checked="checked"/>施工外包</th></tr>
				<%} else { %>
					<tr><th><input type="checkbox" />施工外包</th></tr>
				<%}%>
				<%if (base.getSignsapproval() == 1) { %>
			    	<tr><th><input type="checkbox" checked="checked"/>招牌报批</th></tr>
				<%} else { %>
					<tr><th><input type="checkbox" />招牌报批</th></tr>
				<%}%>
				<%if (base.getBuild() == 1) { %>
			    	<tr><th><input type="checkbox" checked="checked"/>报建</th></tr>
				<%} else { %>
					<tr><th><input type="checkbox" />报建</th></tr>
				<%}%>
				<tr><th>非网点分类:</th><td><%=base.getNotpointtype()%></td></tr>
				<tr><th>分部工程:</th><td><%=base.getEngindivision()%></td></tr>
				<tr><th>项目级别:</th><td><%=base.getProjectlevel()%></td></tr>
				<tr><th>备注:</th><td><%=base.getRemarks()%></td></tr>
				<tr class="yellow"><td colspan="2" >其他信息-项目交付范围</td></tr>
				<%for(int i = 0; i < items1.length; i++ ) {%>
					<tr <%=i==0 ? "" : "class='topLine'" %>><th>序号:</th><td><%=i+1 %></td></tr>
				   	<tr><th>交付项:</th><td><%= items1[i].getDeliveryitem()%></td></tr>
				    <tr><th>接受方部门:</th><td><%= items1[i].getOrgName()%></td></tr>
				   	<tr><th>预计接受时间:</th><td><%= items1[i].getEstideliverydateStr()%></td></tr>
				    <tr><th>备注:</th><td><%= items1[i].getNoteen()%></td></tr>
			   <%} %>
			   <tr class="yellow"><td colspan="2" >其他信息-项目干系人</td></tr>
				<%for(int i = 0; i < items2.length; i++ ) {%>
					<tr <%=i==0 ? "" : "class='topLine'" %>><th>序号:</th><td><%=i+1 %></td></tr>
				   	<tr><th>姓名:</th><td><%= items2[i].getPerson()%></td></tr>
				    <tr><th>部门姓名:</th><td><%= items2[i].getOrgName()%></td></tr>
				   	<tr><th>项目角色:</th><td><%= items2[i].getProjectrole()%></td></tr>
				    <tr><th>工作职责:</th><td><%= items2[i].getJobRespon()%></td></tr>
				    <tr><th>联系电话:</th><td><%= items2[i].getTelephoneNo()%></td></tr>
				    <tr><th>邮箱:</th><td><%= items2[i].getEmail()%></td></tr>
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