<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.WorkflowEntity"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.MaintenrequestVo"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.MaintenRequestEntity"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.MaintenRequestEntryEntity"%>
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
 MaintenrequestVo temp = info.getMaintenrequestVo();
 MaintenRequestEntity base = temp.getMaintenRequestEntity();
 MaintenRequestEntryEntity[] items = temp.getMaintenRequestEntryEntityList();
 %>
<div id="list">
	<%@include file="../wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table>
	    		<tr><th colspan="2" class="yellow">基本信息-工程维修申请单</th></tr>
	    		<tr><th>单据编号:</th><td><%=base.getFnumber() %></td></tr>
				<tr><th>申请部门:</th><td><%=base.getApplyDepart().getName()%></td></tr>
				<tr><th>申请时间:</th><td><%=base.getApplyTimeStr()%></td></tr>
				<tr><th>单据状态:</th><td><%=base.getBillState()%></td></tr>
				<tr><th>项目编码:</th><td><%=base.getProNumber().getProNumber()%></td></tr>
				<tr><th>所属大区:</th><td><%=base.getBelongsArea().getName()%></td></tr>
			   	<tr><th>所属工程部:</th><td><%=base.getBelongProDept().getName()%></td></tr>
			   	<tr><th>项目名称:</th><td><%=base.getProName()%></td></tr>
			   	<tr><th>维修项目所在地:</th><td><%=base.getRepproLocation()%></td></tr>
			   	<tr><th>预计维修金额:</th><td><%=base.getEstimatedAmountStr()%></td></tr>
			   	<tr><th>处理方式:</th><td><%=base.getApproach()%></td></tr>
			   	<tr><th>项目竣工时间:</th><td><%=base.getEndTimeStr()%></td></tr>
			   	<tr><th>项目维修分类:</th><td><%=base.getCfmaintenType()%></td></tr>
			    <tr><th>申请事由:</th><td><%=base.getApplyReason()%></td></tr>

				<tr class="yellow"><td colspan="2" >其他信息-明细信息</td></tr>
				<%for(int i = 0; i < items.length; i++ ) {%>
				   	<tr><th>序号:</th><td><%= items[i].getSeqStr()%></td></tr>
				   	<tr><th>维修类别:</th><td><%= items[i].getRepairType().getMtname()%></td></tr>
				    <tr><th>维修事项:</th><td><%= items[i].getRepairMatter().getMname()%></td></tr>
				   	<tr><th>维修区域:</th><td><%= items[i].getRepairArea().getAname()%></td></tr>
				    <tr><th>损坏原因:</th><td><%= items[i].getDamageReason()%></td></tr>
				    <tr><th>期望维修时间:</th><td><%= items[i].getExpRepairTimeStr()%></td></tr>
				    <tr><th>维修性质:</th><td><%= items[i].getMaintenanceNature() %></td></tr>
			   <%} %>
		  </table>
		  <%@include file="approve_process_esb.jsp" %>
		  <table width="100%" style="display: none" id="msg">
				<tr><td style="color: red" align="center" colspan="2">该节点暂不支持手机审批</td></tr>
		</table>
		</div>
	</div>
	<%@include file="workflow_approve_button_esb.jsp" %>
</div>
<script type="text/javascript">
$(document).ready(function(){
	var activitydefid = $('#activitydefid').val();
	if(activitydefid=="manualActivity1"){
		$('#msg').show();
		document.getElementById("agree_but").style.display = "none";
		document.getElementById("rollback_but").style.display = "none";
		document.getElementById("approve_area").style.display = "none";
	}
});
</script>
</body>
</html>