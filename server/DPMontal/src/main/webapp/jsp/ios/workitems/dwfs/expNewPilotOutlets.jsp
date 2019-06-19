<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.wfs.workflow.domain.ExpressNewPilotBean"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@ taglib prefix="f" uri="http://jspTag.common.montal.deppon.com" %>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_ios.jsp" %>
</head>
<%
 request.setCharacterEncoding("UTF-8");
 response.setCharacterEncoding("UTF-8");
%>
<%
ExpressNewPilotBean info = (ExpressNewPilotBean)request.getAttribute("entity");
%>
<f:init/>
<body>
<div id="list">
<%@include file="/jsp/ios/work_items_head.jsp" %>
   <!--div2 S-->
   <div id="div2">
	   	<div class="ulBox2">
			<ul>
			   <li class="first">工作流号:
			        <em><%=request.getAttribute("processinstid") %>
					<input type="hidden" id="busino" value="<%=info.getBusino()%>">
					<input type="hidden" id="approval_url" value="<%=F_Constants.NORMOL_APPROVAL_URL%>">		  	   		
			   		</em>
			   </li>
			  	<li>申请人:<em><%=info.getApplyPersonName()%></em></li>
				<li>所属部门:<em><%=info.getAppDept() %></em></li>
				<li>部门性质:<em><%=info.getDeptNature()  %></em></li><!-- WFS_EXPRESS_DEPTNATURE -->
				<li>现部门名称:<em><%=info.getNowDeptName()%></em></li>
				<li>点部经理:<em><%=info.getPointManager() %> </em></li>
				<li>所属子公司:<em><%=info.getSubCom() %></em></li><!-- SUB_COMPANY -->
				<li>所属事业部:<em><%=info.getDivision() %></em></li><!-- DIP_DIVISION_NEW -->
				<li>所属人事部:<em><%=info.getPersonnelDept()%></em></li><!-- WFS_PAYMENT -->
				<li>所属快递点部:<em><%=info.getExpressPointOf()%></em></li>
				<li>所属快递大区/分部:<em><%=info.getExpressRegional()%></em></li>
				<li>所属外场:<em><%=info.getOutField()%></em></li>
				<li>所属公共事务组:<em><%=info.getAffairsGroup()%></em></li>
				<li>所属车队:<em><%=info.getCarTeam()%></em></li>
				<li>门店合同面积:<em><%=info.getStoresContractArea()%></em></li>
				<li>当前点部快递员总数:<em><%=info.getCurrentTotalNum()%></em></li>
				<li>快递货区面积:<em><%=info.getExpressCargoArea()%></em></li>
				<li>点部快递员本月日均操作票数:<em><%=info.getAvgDailyOperatNum()%></em></li>
				<% if(info.getDeptOpeningTime() != null){%>
				<li>部门开业时间:<em><%=info.getDeptOpeningTime()%></em></li>	
				<%} %>
				<li>申请事由:<em><%=info.getApplyReason()%></em></li>
				<% String activitydefid = (String)request.getAttribute("activitydefid");
					if("manualActivity9".equals(activitydefid)){%>
				<f:date displayName="部门开业时间" jspType="ios" locationMessage="部门开业时间必填" id="deptOpeningTime"/>
				<%}%>
			</ul>
		</div>
		<%@include file="approve_process.jsp" %>
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