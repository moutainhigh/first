<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>

<%@page import="com.deppon.nhr.module.remote.dpm.shared.domain.workflow.QueryWorkflowInfoResponse" %>
<%@page import="com.deppon.nhr.module.remote.dpm.shared.domain.workflow.OriginInfo" %>
<%@page import="com.deppon.montal.util.FormatUtil" %>

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
 OriginInfo info = hrBusiRsp.getOriginInfo();
 %>
<div id="list">
	<%@include file="../wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
	    		<tr><th colspan="2" class="yellow">基本信息-回原籍申请</th></tr>
	    		<tr><th>申请单编号:</th><td><%=info.getWfno() == null ? "" : info.getWfno()%></td></tr>
				<tr><th>申请人:</th><td><%=info.getApplypsnname() == null ? "" : info.getApplypsnname()%></td></tr>
			   	<tr><th>申请人工号:</th><td><%= info.getApplypsncode() == null ? "" : info.getApplypsncode()%></td></tr>
			   	<tr><th>职位等级:</th><td><%= info.getPositionlevel() == null ? "" : info.getPositionlevel()%></td></tr>
			   	<tr><th>异动性质:</th><td><%=info.getTIspersonorcompany() == null ? "" : info.getTIspersonorcompany()%></td></tr>
			   	<tr><th>所属人事部:</th><td><%=info.getAreapersonneldeptname() == null ? "" : info.getAreapersonneldeptname()%></td></tr>
			  	<tr><th>异入人事部:</th><td><%=info.getEnterprisepersonneldeptname() == null ? "" : info.getEnterprisepersonneldeptname()%></td></tr>
				<tr><th>籍贯:</th><td><%=info.getTNativespace() == null ? "" : info.getTNativespace()%></td></tr>	
			    <tr><th>申请时间:</th><td><%=info.getApplydate() == null ? "" : FormatUtil.formatDate(info.getApplydate(),"yyyy-MM-dd")%></td></tr>
			    <tr><th>申请人职位:</th><td><%=info.getBeforeposition() == null ? "" : info.getBeforeposition()%></td></tr>
				<tr><th>当前部门:</th><td><%=info.getBeforedept() == null ? "" : info.getBeforedept() %></td></tr>
				<tr><th>工作年限（月）:</th><td><%=info.getTNowposduretime() == null ? "" : info.getTNowposduretime()%></td></tr>
				<tr><th>异动目标区域/地区:</th><td><%= info.getTWanttoplace() == null ? "" : info.getTWanttoplace()%></td></tr>
				<tr><th>是否降级异动:</th><td><%=info.getTIsrelegation() == null ? "" : (info.getTIsrelegation() == "1" ? "是" : "否")%></td></tr>
				<tr><th>近六个月内绩效考核:</th><td><%=info.getTLastsixmark()==null?"":info.getTLastsixmark()%></td></tr>
				<tr><th>近半年胜任力排名:</th><td><%=info.getT_lastsixcompetency()==null?"":info.getT_lastsixcompetency()%>&nbsp;&nbsp;&nbsp;<span style="color: red !important;">经理级以上,例:3/7,1/7</span></td></tr>
				<tr><th>申请事由:</th><td><%=info.getReason() == null ? "" : info.getReason()%></td></tr>
		  </table>
		  <%@include file="approve_process.jsp" %>
		</div>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>