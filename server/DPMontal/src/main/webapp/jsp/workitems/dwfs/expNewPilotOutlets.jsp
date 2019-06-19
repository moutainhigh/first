<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.wfs.workflow.domain.ExpressNewPilotBean"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@ taglib prefix="f" uri="http://jspTag.common.montal.deppon.com" %>
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
ExpressNewPilotBean info = (ExpressNewPilotBean)request.getAttribute("entity");
%>
<f:init/>
<div id="list">
	<%@include file="../wf_head_win8.jsp" %>
	<input type="hidden" id="busino" value="<%=info.getBusino()%>">
	<input type="hidden" id="approval_url" value="<%=F_Constants.NORMOL_APPROVAL_URL%>">
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
	    		<tr><th>工作流号:</th><td id="workid"><%=request.getAttribute("processinstid")%></td></tr>
				<tr><th>工&nbsp;&nbsp;作&nbsp;&nbsp;流:</th><td>快递新增试点网点申请</td></tr>
				<tr><th>申请人:</th><td><%=info.getApplyPersonName()%></td></tr>
				<tr><th>所属部门:</th><td><%=info.getAppDept() %></td></tr>
				<tr><th>部门性质:</th><td><%=info.getDeptNature()  %></td></tr><!-- WFS_EXPRESS_DEPTNATURE -->
				<tr><th>现部门名称:</th><td><%=info.getNowDeptName()%></td></tr>
				<tr><th>点部经理:</th><td><%=info.getPointManager() %> </td></tr>
				<tr><th>所属子公司:</th><td><%=info.getSubCom() %></td></tr><!-- SUB_COMPANY -->
				<tr><th>所属事业部:</th><td><%=info.getDivision() %></td></tr><!-- DIP_DIVISION_NEW -->
				<tr><th>所属人事部:</th><td><%=info.getPersonnelDept()%></td></tr><!-- WFS_PAYMENT -->
				<tr><th>所属快递点部:</th><td><%=info.getExpressPointOf()%></td></tr>
				<tr><th>所属快递大区/分部:</th><td><%=info.getExpressRegional()%></td></tr>
				<tr><th>所属外场:</th><td><%=info.getOutField()%></td></tr>
				<tr><th>所属公共事务组:</th><td><%=info.getAffairsGroup()%></td></tr>
				<tr><th>所属车队:</th><td><%=info.getCarTeam()%></td></tr>
				<tr><th>门店合同面积:</th><td><%=info.getStoresContractArea()%></td></tr>
				<tr><th>当前点部快递员总数:</th><td><%=info.getCurrentTotalNum()%></td></tr>
				<tr><th>快递货区面积:</th><td><%=info.getExpressCargoArea()%></td></tr>
				<tr><th>点部快递员本月日均操作票数:</th><td><%=info.getAvgDailyOperatNum()%></td></tr>
				<% if(info.getDeptOpeningTime() != null){%>
				<tr><th>部门开业时间:</th><td><%=info.getDeptOpeningTime()%></td></tr>	
				<%} %>
				<tr><th>申请事由:</th><td><%=info.getApplyReason()%></td></tr>
				<% String activitydefid = (String)request.getAttribute("activitydefid");
					if("manualActivity9".equals(activitydefid)){%>
				<f:date displayName="部门开业时间" locationMessage="部门开业时间必填" id="deptOpeningTime"/>
				<%}%>
				<%@include file="approve_process.jsp" %>					   					   
	    	</table>
	    </div>
	</div>
	 <%@include file="workflow_approve_button.jsp" %>
</div>
</body>
<script type="text/javascript">
$(function(){
	$("#rollback_but").hide();
	$("#disagree_but").hide();
	var activitydefid = $("#activitydefid").val();
	//不同意按钮显示
	if("manualActivity" == activitydefid || "manualActivity1" == activitydefid || "manualActivity2" == activitydefid){
		$("#disagree_but").show();
	}
	if("manualActivity9" == activitydefid){
		$("#approval_url").val('expNewPilotApproval.action');
	}
});
</script>
</html>