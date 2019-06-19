<%@page import="com.deppon.wfs.workflow.domain.SystemDataChangeApplyBean"%>
<%@page import="com.deppon.montal.conf.domain.DictEntry"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<%@ taglib prefix="f" uri="http://jspTag.common.montal.deppon.com" %>


<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_win8.jsp" %>

</head>
<%
SystemDataChangeApplyBean info = (SystemDataChangeApplyBean)request.getAttribute("entity");
//List<DictEntry> dictEntry = info.getSystemList();
//List<DictEntry> dictFinancialEntry = info.getFinancialDict();
String currentActivitydefid = (String)request.getAttribute("activitydefid");
%>
<body>
<div id="list">
	<%@include file="../wf_head_win8.jsp" %>
	<input type="hidden" id="busino" value="<%=info.getBusino()%>">
	<input type="hidden" id="approval_url" value="<%=F_Constants.NORMOL_APPROVAL_URL%>">
	<input type="hidden" id="approval_url_special" value="<%=F_Constants.APPROVAL_SAVEENTITY_URL%>">
	
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
				<tr class="yellow"><th>工作流:</th><td>系统数据变更申请</td></tr>
				<tr><th>工作流号:</th><td id="workid"><%=info.getProcessinstid() %></td></tr>
				<tr><th>申请人:</th><td><%=info.getApplyPersonName()%></td></tr>
				<tr><th>问题所属系统:</th><td><%=info.getSystemId()%></td></tr>
				<tr><th>涉及财务:</th><td><%=info.getFinancialDicValue()%></td></tr>
				<%if("0".equals(info.getFinancialStatus())){ %>
				<tr><th>涉及业务:</th><td><%=info.getBusinessName()%></td></tr>
				<%} %>
				<tr><th>提示信息:</th><td><%=info.getMessage()%></td></tr>
				<tr><th>操作流程:</th><td><%=info.getProcess()%></td></tr>
				<tr><th>事由说明:</th><td><%=info.getApplyReason()%></td></tr>
				<%if(!"manualActivity".equals(currentActivitydefid)&&!"manualActivity1".equals(currentActivitydefid)&&!"manualActivity6".equals(currentActivitydefid)&&!"manualActivity8".equals(currentActivitydefid)&&!"manualActivity9".equals(currentActivitydefid)){ %>
					<%if("manualActivity5".equals(currentActivitydefid)){ %>
						<tr><td style="color: red" align="center" colspan="2">*&nbsp;需上传附件，如需“同意”操作，请登录PC网页版 </td></tr>
					<%} else {%>
						<tr class="yellow" style="display: none"><th colspan="2">添加审批信息</th></tr>
						<%if("manualActivity2".equals(currentActivitydefid)){ %>
							<f:radio displayName="是否本系统" id="isMyselfSystem" defaultCheck="0" dicttypeid="WFS_REFER_FINANCIAL" onselect="changeChoice" locationMessage="把是否本系统填一下呗亲，o(~_~)o" style="display: none" classCSS="manualActivity2" />
							<f:selectOption displayName="对应系统" id="correspondingSystemID" dicttypeid="WFS_PROBLEM_BELONG_SYSTEM" isValidate="false" style="display: none"  classCSS="manualActivity2  firstHidden" locationMessage="把对应系统内容填一下呗亲，o(~_~)o" />
							<f:selector displayName="本系统开发组" searchModel="selectorDeptModel" locationMessage="把本系统开发组内容填一下呗亲，o(~_~)o" selectorViewId="selectorDeptId"  nullText="点击查询部门" id="searchId" classCSS="manualActivity2  firstShow" style="display: none"/>
						<%} else if ("manualActivity4".equals(currentActivitydefid)) {%>
							<input type="hidden" value="<%=info.getDevelopmentTeamCode()%>" id="teamCodeId" />
							<f:selector displayName="开发人员" searchModel="selectorPeopleModel" selectorViewId="selectorPeopleId" nullText="点击查询开发员" id="searchId" classCSS="manualActivity4" style="display: none"/>
						<%} else if ("manualActivity3".equals(currentActivitydefid)) {%>
							<f:selector displayName="本系统开发组" searchModel="selectorDeptModel" selectorViewId="selectorDeptId" nullText="点击查询部门" id="searchId" classCSS="manualActivity3" style="display: none"/>
						<%}%>
					<%}%>
				<%}%>
		 </table>
		<%@include file="approve_process.jsp" %>
    	</div>
	<%@include file="workflow_approve_button.jsp" %>
	</div>
</div>

<script type="text/javascript">
$(function(){
	//开发员节点[manualActivity5]
	var activitydefid = $("#activitydefid").val();
	if(activitydefid == 'manualActivity5'){
		//同意按钮隐藏，请将同意之后 提示框隐藏
		$("#agree_but").css("background","#ccc");
		$("#agree_but").click(function(){
			$("#app_window").hide();
			$(".tipsWinCnt").hide();
			return;
		});
	}else if (activitydefid == 'manualActivity2') {
		$(".manualActivity2").show();
		$(".manualActivity2.firstHidden").hide();
		//$(".inputRemoveDiv").parent("div").css("display","inline-block");
	}else if (activitydefid == 'manualActivity9') {
		document.getElementById("disagree_but").style.display = "none";
		//$(".inputRemoveDiv").parent("div").css("display","inline-block");
	}else if (activitydefid == 'manualActivity4') {
		var finsyCode = $("#teamCodeId").val();
		selectorPeopleModel.queryModel.fields[2].value = finsyCode;
		$(".manualActivity4").show();
	}else if (activitydefid == 'manualActivity3') {
		$(".manualActivity3").show();
	}
});
function changeChoice(l,v,obj) {
	if (v == '0') {
		$(".manualActivity2.firstHidden").hide();
		$("#correspondingSystemID").get(0).setVerifiable(false);
		$(".manualActivity2.firstShow").show();
		$("#searchId").get(0).setVerifiable(true);
	}else {
		$(".manualActivity2.firstHidden").show();
		$("#correspondingSystemID").get(0).setVerifiable(true);
		$(".manualActivity2.firstShow").hide();
		$("#searchId").get(0).setVerifiable(false);
	}
};

/* $(document).ready(function(){
	var activitydefid = $('#activitydefid').val();
	if(activitydefid=="manualActivity5"||activitydefid=="manualActivity1"||activitydefid=="manualActivity4"||activitydefid=="manualActivity6"||activitydefid=="manualActivity7"){
		$('#msg').show();
		document.getElementById("disagree_but").style.display = "none";
		document.getElementById("agree_but").style.display = "none";
		document.getElementById("rollback_but").style.display = "none";
		document.getElementById("approve_area").style.display = "none";
	}else if (activitydefid=="manualActivity3"){
		$('.manualActivity3').show();
	}
	
});  */
</script>
<f:init/>
</body>
</html>