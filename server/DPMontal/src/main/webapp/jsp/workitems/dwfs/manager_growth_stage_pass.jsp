<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.wfs.workflow.domain.ManagerGrowthStagePassBean"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
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
	ManagerGrowthStagePassBean info = (ManagerGrowthStagePassBean)request.getAttribute("entity");
%>
<div id="list">
	<%@include file="../wf_head_win8.jsp" %>
	<input type="hidden" id="busino" value="<%=info.getBusino()%>">
	<input type="hidden" id="approval_url" value="<%=F_Constants.NORMOL_APPROVAL_URL%>">
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
	    		<tr>
					   <th>工作流号:</th>
					   <td id="workid"><%=request.getAttribute("processinstid")%></td>
					</tr>
					<tr>
					   <th>工&nbsp;&nbsp;作&nbsp;&nbsp;流:</th>
					   <td>管理人员转正成长期通过</td>
					</tr>
				   <tr><th>申请人姓名:</th><td><%=info.getApplyPersonName()%></td></tr>
				   <tr><th>工号:</th><td><%=info.getApplyPersonId()%></td></tr>
				   <tr><th>申请人部门:</th><td><%=info.getApplyDepartment()%></td></tr>
				   <tr><th>所属区域:</th><td><%=info.getBelongArea()%></td></tr>
				   <tr><th>申请类别:</th><td><%=info.getApplyType()%></td></tr>
				   <%if("管理人员转正".equals(info.getApplyType())){%>
					   <tr><th>转正类别:</th><td><%=info.getPositiveType()%></td></tr>
				   <%} %>
				   <%if("管理人员成长期通过".equals(info.getApplyType())){%>
				   	   <tr><th>成长期通过类别:</th><td><%=info.getGrowthStageType()%></td></tr>
					   <tr><th>考核等级:</th><td><%=info.getAssessGrade()%></td></tr>
					   <tr><th>岗位:</th><td><%=info.getPost()%></td></tr>
					   <tr><th>转正工作流号:</th><td><%=info.getPositiveProcessinstid()%></td></tr>
					   <tr><th>转正日期:</th><td><%=FormatUtil.formatDate(info.getPositiveDate())%></td></tr>
				   <%} %>
				   <tr><th>任命日期:</th><td><%=FormatUtil.formatDate(info.getAppointDate())%></td></tr>
				   <%if(null != info.getIfNegotiateSalary() && !"".equals(info.getIfNegotiateSalary())){%>
					   <tr><th>是否谈判工资:</th><td><%=info.getIfNegotiateSalary()%></td></tr>
				   <%} %>
				   <%if("是".equals(info.getIfNegotiateSalary())){%>
					   <tr><th>谈判工资金额:</th><td><%=info.getNegotiateSalary()%></td></tr>
					   <tr><th>生效日期:</th><td><%=FormatUtil.formatDate(info.getEfficientDate())%></td></tr>
				   <%} %>
				   <tr><th>申请事由:</th><td><%=info.getApplyReason()==null?"":info.getApplyReason()%></td></tr>
					   
				<%@include file="approve_process.jsp" %>					   					   
	    	</table>
	    	<table width="100%" style="display: none" id="msg">
				<tr><td style="color: red" align="center" colspan="2">该节点暂不支持手机审批</td></tr>
			</table>
	    </div>
	</div>
	 <%@include file="workflow_approve_button.jsp" %>
</div>
<script type="text/javascript">
	$(document).ready(function(){
		var activitydefid = $('#activitydefid').val();
		if(activitydefid=="manualActivity5"){
			$('#msg').show();
			document.getElementById("disagree_but").style.display = "none";
			document.getElementById("agree_but").style.display = "none";
			document.getElementById("rollback_but").style.display = "none";
			document.getElementById("approve_area").style.display = "none";
		}
	});
</script>
</body>
</html>