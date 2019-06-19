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
	<%@include file="/common_ios.jsp" %>
</head>
<body>
 <%
 QueryWorkflowInfoResponse hrBusiRsp = (QueryWorkflowInfoResponse)request.getAttribute("hrBusiRsp");
 OriginInfo info = hrBusiRsp.getOriginInfo();
 %>
<div id="list">
	<%@include file="/jsp/ios/work_items_head.jsp" %>
	<div id="div2">
		<h4 class="yellow">基本信息-回原籍申请</h4>
    	<div class="ulBox2">
    		<ul>
	    		<li>申请单编号:<em><%=info.getWfno() == null ? "" : info.getWfno() %></em></li>
			   	<li>申请人:<em><%=info.getApplypsnname() == null ? "" : info.getApplypsnname()%></em></li>
			   	<li>申请人工号:<em><%= info.getApplypsncode() == null ? "" : info.getApplypsncode()%></em></li>
			   	<li>职位等级:<em><%= info.getPositionlevel() == null ? "" : info.getPositionlevel()%></em></li>
			   	<li>异动性质:<em><%=info.getTIspersonorcompany() == null ? "" : info.getTIspersonorcompany()%></em></li>
			   	<li>所属人事部:<em><%=info.getAreapersonneldeptname() == null ? "" : info.getAreapersonneldeptname()%></em></li>
			  	<li>异入人事部:<em><%=info.getEnterprisepersonneldeptname() == null ? "" : info.getEnterprisepersonneldeptname()%></em></li>
				<li>籍贯:<em><%=info.getTNativespace() == null ? "" : info.getTNativespace()%></em></li>	
			    <li>申请时间:<em><%=info.getApplydate() == null ? "" : FormatUtil.formatDate(info.getApplydate(),"yyyy-MM-dd")%></em></li>
			    <li>申请人职位:<em><%=info.getBeforeposition() == null ? "" : info.getBeforeposition()%></em></li>
				<li>当前部门:<em><%=info.getBeforedept() == null ? "" : info.getBeforedept() %></em></li>
				<li>工作年限（月）:<em><%=info.getTNowposduretime() == null ? "" : info.getTNowposduretime()%></em></li>
				<li>异动目标区域/地区:<em><%= info.getTWanttoplace() == null ? "" : info.getTWanttoplace()%></em></li>
				<li>是否降级异动:<em><%=info.getTIsrelegation() == null ? "" : (info.getTIsrelegation() == "1" ? "是" : "否")%></em></li>
				<li>近六个月内绩效考核:<em><%=info.getTLastsixmark()==null?"":info.getTLastsixmark()%></em></li>
				<li>近半年胜任力排名:<em><%=info.getT_lastsixcompetency()==null?"":info.getT_lastsixcompetency()%>&nbsp;&nbsp;&nbsp;<span style="color: red !important;">经理级以上,例:3/7,1/7</span></em></li>
				<li>申请事由:<em><%=info.getReason() == null ? "" : info.getReason()%></em></li>
		  	</ul>
        </div>
		  <%@include file="approve_process.jsp" %>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>