<%@page import="com.deppon.wfs.workflow.domain.ProblemFeedbackBean"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page	import="com.deppon.montal.module.workitems.webservice.client.DWFSWorkItemServiceClient"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.montal.conf.domain.DictEntry"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title><%=InitDataServlet.getValue("page_title")%>-待办事项</title>
<%@include file="/common_win8.jsp"%>
<style>
tr.details,tr.qytr {
	display: none;
}
</style>
</head>
<body onload="autoShowApproval()">
	<%
		ProblemFeedbackBean info = (ProblemFeedbackBean) request
				.getAttribute("entity");
	List<DictEntry> list = (List<DictEntry>)request.getAttribute("dict");
	%>
	<div id="list">
		<%@include file="../wf_head_win8.jsp"%>
		<input type="hidden" id="busino" value="<%=info.getBusino()%>">
		<input type="hidden" id="paramDate"><!-- 特殊审批界面 所需传递的参数 -->
		<input type="hidden" id="approval_url"
			value="<%=F_Constants.NORMOL_APPROVAL_URL%>">
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
						<td>一线问题反馈</td>
					</tr>
					<tr>
						<th>申请人:</th>
						<td><%=info.getApplyPersonName()%></td>
					</tr>
					<tr>
						<th>所属部门:</th>
						<td><%=info.getDepartment()%></td>
					</tr>
					<tr>
						<th>所属事业部:</th>
						<td><%=info.getDivision()%></td>
					</tr>
					<tr>
						<th>所属经营本部:</th>
						<td><%=info.getOperateDept()%></td>
					</tr>
					<tr>
						<th>问题类型:</th>
						<td><%=info.getProblemType()%></td>
					</tr>
					<tr>
						<th>问题内容:</th>
						<td><%=info.getProblemContent()%></td>
					</tr>
					<% 
					String completeDateStr = info.getCompleteDateStr();
					if(completeDateStr != null && completeDateStr != ""){%>
					<tr>
						<th>预计完成时间:</th>
						<td><%=completeDateStr %></td>
					</tr>	
					<%} %>
					<% 
					Long satisfaction = info.getSatisfaction();
					if(satisfaction != null){%>
					<tr>
						<th>满意度得分:</th>
						<td><%=satisfaction%></td>
					</tr>
					<%} %>
					
				<tbody style="display: none;" id="flowDiv_responsibDepart">
				<tr>
					<th class="selectFlow">下级审批人：</th>
					<td class="selectFlow">
						<select name="bizEntity.responsibDepart" id="responsibDepart">
							<% 
								for(DictEntry dicList:list){
							%>
								<option value=<%=dicList.getDictid()%>><%=dicList.getDictname()%></option>
							<% 
								}
							%>
						</select>
					</td>
				</tr>
			</tbody>
			<tbody style="display: none;" id="flowDiv_completeDate">
				<tr>
					<th>预计完成时间：</th>
					<td>
					<input type="text" name="bizEntity.completeDate" id="completeDate" onchange="regMatchTime(this.value);">&nbsp;&nbsp;<span style="color: red">格式：2014-05-21</span>
					</td>
				</tr>
			</tbody>
			<tbody style="display: none;" id="flowDiv_satisfaction">
				<tr>
					<th>满意度得分：</th>
					<td>
					<input type="text" name="bizEntity.satisfaction" id="satisfaction" onchange="matchSatisfaction(this.value)">分(0-100)
					</td>
				</tr>
			</tbody>
					<%@include file="approve_process.jsp"%>
				</table>
			</div>
		</div>
		<input type="hidden" id="submit_Flag">
		<div id="div_hidden" class="fyy-textCt">
    	 	<span id="msg" style="display: none"> 
			<em style="color: red">此节点暂不支持手机审批</em>
			</span>
    	</div>
		<%@include file="workflow_approve_button.jsp"%>
	</div>
	<script type="text/javascript">
$(function(){
	//回退按钮隐藏
	$("#rollback_but").hide();
	var activitydefid = $("#activitydefid").val();
	var data = "";
	//专业部门负责人
	if("manualActivity3" == activitydefid){
		$("#flowDiv_responsibDepart").show();
		$("#approval_url").val('<%=F_Constants.APPROVAL_SAVEENTITY_URL%>');
	}else if("manualActivity4" == activitydefid){
		$("#approve_area").hide();
		$("#div3").find(".btn").css("display","none");
		$("#msg").show();
// 		$("#div3").append(cdeeklj);
		//责任部门负责人
// 		$("#flowDiv_completeDate").show();
<%-- 		$("#approval_url").val('<%=F_Constants.APPROVAL_SAVEENTITY_URL%>'); --%>
	}else if("manualActivity5" == activitydefid){
		//大区总/转运中心总监
		document.getElementById("satisfaction").style.border="1px solid #aaa";
		document.getElementById("satisfaction").style.width="60px";
		$("#flowDiv_satisfaction").show();
		$("#approval_url").val('<%=F_Constants.APPROVAL_SAVEENTITY_URL%>');
	}
});
function matchSatisfaction(value){
// 	var reg = new RegExp("^[1]?[0]{2}|[0]|[1-9]?[0-9]{1}$");
	var reg = /^\d+$/;
	if(value != null && reg.test(value)){
		var va = parseInt(value);
		if(va <= 100 && va >= 0){
			$("#satisfaction").val(va);
			$("#submit_Flag").val("true");
		}else{
			$("#submit_Flag").val("false");
		}
		
	}else{
		$("#submit_Flag").val("false");
	}
}
</script>
</body>
</html>