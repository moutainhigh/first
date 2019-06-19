<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.nhr.module.remote.dpm.shared.domain.workflow.QueryWorkflowInfoResponse" %>
<%@page import="com.deppon.nhr.module.remote.dpm.shared.domain.workflow.TransferInfo" %>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_win8.jsp" %>
</head>
<body>
 <%
 QueryWorkflowInfoResponse hrBusiRsp = (QueryWorkflowInfoResponse)request.getAttribute("hrBusiRsp");
 TransferInfo info = hrBusiRsp.getTransferInfo();
 
 %>
<div id="list">
	<%@include file="../wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
	    		<tr><th colspan="2" class="yellow">基本信息-异动调动申请</th></tr>
				<tr><th>申请单编号:</th><td><%=info.getWfno() %></td></tr>
			   	<tr><th>申请人姓名:</th><td><%=info.getApplypsnname()==null?"":info.getApplypsnname() %></td></tr>
			   	<tr><th>申请人工号:</th><td><%= info.getApplypsncode()== null?"":info.getApplypsncode() %></td></tr>
			   	<tr><th>申请人职位:</th><td><%=info.getBeforeposition()== null?"":info.getBeforeposition() %></td></tr>
			   	<tr><th>入职日期:</th><td><%=info.getGroupdef1() %></td></tr>
			  	<tr><th>申请时间:</th><td><%=info.getApplydate()==null?"":FormatUtil.formatDate(info.getApplydate(),"yyyy-MM-dd")%></td></tr>
				<tr><th>身份证号:</th><td><%=info.getIdcard()==null?"":info.getIdcard() %></td></tr>	
			    <tr><th>申请类别:</th><td><%=info.getApplytype()==null?"":info.getApplytype() %></td></tr>
				<tr><th>职位等级:</th><td><%=info.getPositionlevel()==null?"":info.getPositionlevel() %></td></tr>
				<tr><th>部门性质:</th><td><%=info.getDeptnature()==null?"":info.getDeptnature() %></td></tr>
				<tr><th>所属人事部:</th><td><%=info.getAreapersonneldeptname()==null?"":info.getAreapersonneldeptname() %></td></tr>
				<tr><th>所属选拔组:</th><td><%=info.getEnterprisepersonneldept()==null?"":info.getEnterprisepersonneldept() %></td></tr>
				<tr><th>变动前部门:</th><td><%=info.getBeforedept()== null?"":info.getBeforedept() %></td></tr>
				<tr><th>变动前职位:</th><td><%=info.getBeforeposition()== null?"":info.getBeforeposition() %></td></tr>
				<tr><th>变动后部门:</th><td><%=info.getAfterdept()== null?"":info.getAfterdept() %></td></tr>
				<tr><th>变动后职位:</th><td><%=info.getAfterposition()== null?"":info.getAfterposition() %></td></tr>
				<tr><th>异进部门增补员工作流号:</th><td><%=info.getAddpersonno()== null?"":info.getAddpersonno() %></td></tr>
				<%if ("公司调动".equals(info.getApplytype())) {%>
				<tr><th>回原籍工作流号:</th><td><%=info.getBackoriginno()== null?"":info.getBackoriginno() %></td></tr>
				<%} %>
				<tr><th>是否引起住所变更:</th><td><%=info.getIsvaraddress()== null?"":info.getIsvaraddress() %></td></tr>
				<tr><th>是否使用公司手机卡:</th><td><%=info.getTIsrelegation()== null?"":info.getTIsrelegation() %></td></tr>
				<%if ("是".equals(info.getTIsrelegation())) {%>
				<tr><th>手机号码:</th><td><%=info.getPhone()== null?"":info.getPhone() %></td></tr>
				<tr><th>是否交接公司手机卡:</th><td><%=info.getIstelhand()== null?"":info.getIstelhand() %></td></tr>
					<%if ("是".equals(info.getIstelhand())) {%>
						<tr><th>交接前手机话费:</th><td><%=info.getMoney()== null?"":info.getMoney() %></td></tr>
						<tr><th>手机卡交接后使用人:</th><td><%=info.getAfteruser()== null?"":info.getAfteruser() %></td></tr>
					<%} %>
				<%} %>
				<tr><th>申请事由:</th><td><%=info.getReason()== null?"":info.getReason() %></td></tr>
		  </table>
		  <%@include file="approve_process.jsp" %>
		</div>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>