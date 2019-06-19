<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>

<%@page import="com.deppon.nhr.module.remote.dpm.shared.domain.workflow.QueryWorkflowInfoResponse" %>
<%@page import="com.deppon.nhr.module.remote.dpm.shared.domain.workflow.PositiveInfo" %>

<%@ page language="java"  pageEncoding="UTF-8"%> 
<%@page import="java.util.Date"%> 
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.apache.commons.lang.StringUtils" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_win8.jsp" %>
	
</head>

<body>
 <%
 Boolean  appUI = (Boolean)request.getSession().getAttribute("app_ui");
 QueryWorkflowInfoResponse hrBusiRsp = (QueryWorkflowInfoResponse)request.getAttribute("hrBusiRsp");
 PositiveInfo info = hrBusiRsp.getPositiveInfo();
 //素质评分链接
 String linkads = info.getLinkads();
 String[] links = null;
 if(linkads != null){
	 //名称@地址，名称@地址，。。。。。。
	 links = linkads.split(",");
 }
 %>
<div id="list">
	<%@include file="../wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
	    		<tr><th colspan="2" class="yellow">基本信息</th></tr>
				<tr><th >申请单编号:</th><td><%=info.getWfno() == null ? "" : info.getWfno()%></td></tr>
			   	<tr><th >申请人工号:</th><td><%= info.getApplypsncode() == null ? "" : info.getApplypsncode()%></td></tr>
			   	<tr><th >申请人姓名:</th><td><%= info.getApplypsnname() == null ? "" : info.getApplypsnname()%></td></tr>
			   	<tr><th >申请人职位:</th><td><%=info.getPosition() == null ? "" : info.getPosition()%></td></tr>
			   	<tr><th >入职日期:</th><td><%=info.getIndate() == null ? "" : FormatUtil.formatDate(info.getIndate())%></td></tr>
			  	<tr><th >申请时间:</th><td><%=info.getApplydate() == null ? "" : FormatUtil.formatDate(info.getApplydate())%></td></tr>
				<tr><th >身份证号:</th><td><%=info.getDocnumber() == null ? "" : info.getDocnumber()%></td></tr>	
			   	<tr><th >申请人部门:</th><td><%=info.getAppdeptname() == null ? "" : info.getAppdeptname()%></td></tr>
				<tr><th >是否参加新员工培训:</th><td><%=info.getIsAttendtrain() == null ? "" : ("Y".equals(info.getIsAttendtrain())? "是" : "否") %></td></tr>
				<tr><th >工作岗位:</th><td><%=info.getJobtype() == null ? "" : info.getJobtype()%></td></tr>
				
				<!-- 考试通过情况 -->
				
				<tr><th >所在人事部:</th><td><%=info.getHrdeptname() == null ? "" : info.getHrdeptname()%></td></tr>
				<tr><th >考试通过日期:</th><td><%= info.getPassdate() == null ? "" : FormatUtil.formatDate(info.getPassdate())%></td></tr>
				
				<tr><th >企业文化:</th><td><%=info.getCulture()==null?"":info.getCulture()%></td></tr>
				<tr><th >打字:</th><td><%=info.getTyping() == null ? "" : info.getTyping()%></td></tr>
				<tr><th >专业知识:</th><td><%=info.getProfknowledge()==null?"":info.getProfknowledge()%></td></tr>
				<tr><th >开单:</th><td><%=info.getBilling()==null?"":info.getBilling()%></td></tr>
				<!-- 财务知识 -->
				
				
				<% if(info.getScore() != null && info.getScore() != ""){%>
					<tr><th>领导打分:</th><td><%=info.getScore() == null ? "" : info.getScore()%></td></tr>
				<%}%>
				
				<tr><th >个人心得体会:</th><td><%=info.getExperience() == null ? "" : info.getExperience()%></td></tr>
				<tr><th >对公司、部门、领导或其他方面的建议或意见:</th><td><%=info.getSuggestions() == null ? "" : info.getSuggestions()%></td></tr>
				<tr><th >部门同事评价:</th><td><%=info.getEvaluation() == null ? "" : info.getEvaluation()%></td></tr>
				<tr><th >申请事由:</th><td><%=info.getAppreason() == null ? "" : info.getAppreason()%></td></tr>
				
				<%String actydefid = (String)request.getAttribute("activitydefid");
				if("manualActivity1".equals(actydefid)){%>
				
				<tr><th>问卷链接:</th><td>
				<% for(int i=0;i < links.length;i++){
					String link = links[i];
					String[] linkNameAndLinks = link.split("@");%>
					<% if(false == appUI ){%>
						<a href="###" onclick="window.open('<%=linkNameAndLinks[1] %>');"><%=linkNameAndLinks[0] %></a><br/>
					<%}else{%>
						<a href="<%=linkNameAndLinks[1] %>"><%=linkNameAndLinks[0] %></a><br/>
					<%} %>
				<%}%></td></tr>
				<tr><th>评分结果:</th><td><input type="text" style="border: 1px solid;border-color: #aaa;width: 100px" id="score"/></td></tr>
				<%}%>
				
		  </table>
		  <%@include file="approve_process.jsp" %>
		</div>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>