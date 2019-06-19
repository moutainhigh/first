<%@page import="com.deppon.montal.conf.domain.DictEntry"%>
<%@page import="com.deppon.wfs.workflow.domain.NewDeptApplyBean"%>
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
	NewDeptApplyBean info = (NewDeptApplyBean)request.getAttribute("entity");
	List<DictEntry> list = (List<DictEntry>) request.getAttribute("dict");
%>
<div id="list">
	<%@include file="../wf_head_win8.jsp" %>
	<input type="hidden" id="busino" value="<%=info.getBusino()%>">
	<input type="hidden" id="approval_url" value="<%=F_Constants.SAVE_ENTITY__APPROVAL_URL%>">
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
	    		<tr><th>工作流号:</th><td id="workid"><%=request.getAttribute("processinstid")%></td></tr>
				<tr><th>工&nbsp;&nbsp;作&nbsp;&nbsp;流:</th><td>组织架构调整申请</td></tr>
				<tr><th>申请人:</th><td><%=info.getApplyPersonName()%></td></tr>
				<tr><th>架构调整类型:</th><td><%=info.getDeptChange()%></td></tr><!-- WFS_DEPTCHANGE_TYPE -->
				<tr><th>架构调整部门:</th><td><%=info.getNewDeptName()%></td></tr>
				<tr><th>申请事由及调整方案简述:</th><td><%=info.getApplyReason()%></td></tr>
			<tbody style="display: none;" id="flowDiv">
				<tr>
					<th style="width: 100px;">工作流流向：</th>
					<td>
						<select name="bizEntity.applyFlow" id="applyFlow" onclick="selectFlow()">
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
				<tr>
					<th class="selectFlow">重新选择流向：</th>
					<td class="selectFlow">
						<select name="bizEntity.applyReflow" id="selectFlow">
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
				<%@include file="approve_process.jsp" %>	
			
	    	</table>
	    	<table width="100%" style="display: none" id="msg">
				<tr><td style="color: red" align="center" colspan="2">此节点暂不支持手机审批</td></tr>
			</table>
	    </div>
	</div>
	 <%@include file="workflow_approve_button.jsp" %>
</div>
<script type="text/javascript">
//有特殊审批需要注意，有没有权限不同意的--人员配置组、薪资研究组、营运提成管理小组、所属事业部招聘选拔组/选拔组负责人---- 组织与人才发展负责人、组织架构研究组、当直接上级审批时（可以不同意）
$(document).ready(function(){
	var activitydefid=$('#activitydefid').val();
	if(activitydefid == 'empDeployTeam'||activitydefid == 'payResearchTeam'||activitydefid == 'opePushTeam' ||activitydefid == 'areauBrecruitManager' ||activitydefid == 'selectImpManager' ){
		$("#disagree_but").hide();
	}else{
		$("#disagree_but").show();
	}
	if(activitydefid=='orgResearchTeam'){
		$("#flowDiv").attr("style","display: inline;");
		if($('#applyFlow').val()=='PERSON_DEPLOY'){
			$(".selectFlow").show();
		}else{
			$(".selectFlow").hide();
		}
	}
	if(activitydefid == 'empDeployTeam'|| activitydefid == 'payResearchTeam' || activitydefid == 'opePushTeam' || activitydefid == 'empDeployTeam'){
		$('#msg').show();
		document.getElementById("disagree_but").style.display = "none";
		document.getElementById("agree_but").style.display = "none";
		document.getElementById("rollback_but").style.display = "none";
		document.getElementById("approve_area").style.display = "none";
	}
});
function selectFlow(){
	var activitydefid=$('#activitydefid').val();
	if(activitydefid=='orgResearchTeam'){
		$("#flowDiv").attr("style","display: inline;");
		if($('#applyFlow').val()=='PERSON_DEPLOY'){
			$(".selectFlow").show();
		}else{
			$(".selectFlow").hide();
		}
	}
}
</script>
</body>
</html>