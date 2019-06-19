<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.nhr.module.remote.dpm.shared.domain.workflow.QueryWorkflowInfoResponse" %>
<%@page import="com.deppon.nhr.module.remote.dpm.shared.domain.workflow.PositiveInfo" %>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title><%=InitDataServlet.getValue("page_title")%>-待办事项</title>
<meta http-equiv="Content-Type"
	content="application/xhtml+xml; charset=UTF-8" />
<%@include file="/common_ios.jsp"%>
</head>
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
<body>
	<div id="list">
		<%@include file="/jsp/ios/work_items_head.jsp"%>
		<!--div2 S-->
		<div id="div2">
			<div class="ulBox2">
				<ul>
				<li style="border-top: 1px none #aaa;"><em class="yellow">基本信息</em>
				<li>申请单编号:<em><%=info.getWfno() == null ? "" : info.getWfno()%></em></li>
			   	<li>申请人工号:<em><%= info.getApplypsncode() == null ? "" : info.getApplypsncode()%></em></li>
			   	<li>申请人姓名:<em><%= info.getApplypsnname() == null ? "" : info.getApplypsnname()%></em></li>
			   	<li>申请人职位:<em><%=info.getPosition() == null ? "" : info.getPosition()%></em></li>
			   	<li>入职日期:<em><%=info.getIndate() == null ? "" : FormatUtil.formatDate(info.getIndate())%></em></li>
			  	<li>申请时间:<em><%=info.getApplydate() == null ? "" : FormatUtil.formatDate(info.getApplydate())%></em></li>
				<li>身份证号:<em><%=info.getDocnumber() == null ? "" : info.getDocnumber()%></em></li>	
			   	<li>申请人部门:<em><%=info.getAppdeptname() == null ? "" : info.getAppdeptname()%></em></li>
				<li>是否参加新员工培训:<em><%=info.getIsAttendtrain() == null ? "" : ("Y".equals(info.getIsAttendtrain())? "是" : "否") %></em></li>
				<li>工作岗位:<em><%=info.getJobtype() == null ? "" : info.getJobtype()%></em></li>
				
				<!-- 考试通过情况 -->
				
				<li>所在人事部:<em><%=info.getHrdeptname() == null ? "" : info.getHrdeptname()%></em></li>
				<li>考试通过日期:<em><%= info.getPassdate() == null ? "" : FormatUtil.formatDate(info.getPassdate())%></em></li>
				
				<li>企业文化:<em><%=info.getCulture()==null?"":info.getCulture()%></em></li>
				<li>打字:<em><%=info.getTyping() == null ? "" : info.getTyping()%></em></li>
				<li>专业知识:<em><%=info.getProfknowledge()==null?"":info.getProfknowledge()%></em></li>
				<li>开单:<em><%=info.getBilling()==null?"":info.getBilling()%></em></li>
				<!-- 财务知识 -->
				
				
				<% if(info.getScore() != null && info.getScore() != ""){%>
					<li>领导打分:<em><%=info.getScore() == null ? "" : info.getScore()%></em></li>
				<%}%>
				
				<li>个人心得体会:<em><%=info.getExperience() == null ? "" : info.getExperience()%></em></li>
				<li>对公司、部门、领导或其他方面的建议或意见:<em><%=info.getSuggestions() == null ? "" : info.getSuggestions()%></em></li>
				<li>部门同事评价:<em><%=info.getEvaluation() == null ? "" : info.getEvaluation()%></em></li>
				<li>申请事由:<em><%=info.getAppreason() == null ? "" : info.getAppreason()%></em></li>
				
				<%String actydefid = (String)request.getAttribute("activitydefid");
				if("manualActivity1".equals(actydefid)){%>
				
				<li>问卷链接:<em><br/>
				<% for(int i=0;i < links.length;i++){
					String link = links[i];
					String[] linkNameAndLinks = link.split("@");%>
					<% if(false == appUI){%>
					<a href="###" onclick="window.open('<%=linkNameAndLinks[1] %>');"><%=linkNameAndLinks[0] %></a><br/>
					<%}else{%>
						<a href="<%=linkNameAndLinks[1] %>"><%=linkNameAndLinks[0] %></a><br/>
					<%} %>
				<%}%></em></li>
				<li>评分结果:<em><input type="text" style="border: 1px solid;border-color: #aaa;width: 100px" id="score"/></em></li>
				<%}%>
				</ul>
			</div>
			<%@include file="approve_process.jsp"%>
		</div>
		<%@include file="workflow_approve_button.jsp"%>
	</div>
</body>
</html>