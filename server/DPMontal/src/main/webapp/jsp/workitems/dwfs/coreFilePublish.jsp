<%@page import="com.deppon.wfs.workflow.domain.FilePublishBean"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
<%@include file="/common_win8.jsp"%>
<style>
tr.details,tr.qytr {
	display: none;
}
</style>
</head>
<body onload="autoShowApproval()">
	<%
	FilePublishBean info = (FilePublishBean)request.getAttribute("entity");
%>
	<div id="list">
		<%@include file="../wf_head_win8.jsp"%>
		<input type="hidden" id="busino" value="<%=info.getBusino()%>">
		<input type="hidden" id="approval_url"
			value="<%=F_Constants.NORMOL_APPROVAL_URL%>">
		<div id="div2">
			<h3 class="yellow">审批工作流</h3>
			<div class="tableBox">
				<table width="100%">
					<tr><th>工作流号:</th><td id="workid"><%=request.getAttribute("processinstid")%></td></tr>
					<tr><th>工&nbsp;&nbsp;作&nbsp;&nbsp;流:</th><td>文件发布申请</td></tr>
					<tr><th>申请人：</th><td><%=info.getApplyPersonName()%></td></tr>
					<tr><th>责任部门：</th><td><%=info.getResponDepart()%></td></tr>
					<tr><th>责任者：</th><td><%=info.getResponPeople()%></td></tr>
					<tr><th>页数：</th><td><%=info.getCountPage()%></td></tr>
					<tr><th>效力状态：</th><td><%=info.getEffectState()%></td></tr>
					<tr><th>申请类别：</th><td><%=info.getApplyType()%></td></tr>
					<tr><th>文件类别：</th><td><%=info.getFileType()%></td></tr>
					<tr><th>任免类型：</th><td><%=info.getAppointedType()%></td></tr>
					<tr><th>被任免人所在事业部：</th><td><%=info.getDivision()%></td></tr>
					<tr><th>文件使用范围：</th><td><%=info.getFileScope()%></td></tr>
					<tr><th>文件编号：</th><td><%=info.getFileCode()%></td></tr>
					<tr><th>文件标题：</th><td><%=info.getFileTitle()%></td></tr>
					
					<tr><th>文件摘要：</th><td><%=info.getFileAbstract()%></td></tr>
					<tr><th>文件生效日期：</th><td><%=FormatUtil.formatDate(info.getEffectDate())%></td></tr>
					<tr><th>文件过期日期：</th><td><%=FormatUtil.formatDate(info.getExpiredDate())%></td></tr>
					<tr><th>申请事由：</th><td><%=info.getApplyReason()%></td></tr>
					<%@include file="approve_process.jsp"%>
				</table>
			</div>
		</div>
		<%@include file="workflow_approve_button.jsp"%>
	</div>
</body>
<script type="text/javascript">
	$(function(){
		var activityDefId = $('#activitydefid').val();
		if(activityDefId == 'manualActivity6'){
			$("#approve_area").hide();
			$("#div3").hide();
	 		var html = "<div id='div_span'><span style='color:red;float:left;text-align:center;line-height:20px;width: 100%;height: 30px;font-size: 20px;'>该节点未设置手机端，请至网页端审批，谢谢。</span></div>";
	 		$("body").append(html);
		}
		
	});
</script>
</html>