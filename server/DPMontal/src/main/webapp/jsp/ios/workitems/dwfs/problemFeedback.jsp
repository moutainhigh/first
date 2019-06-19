<%@page import="com.deppon.wfs.workflow.domain.ProblemFeedbackBean"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.conf.domain.DictEntry"%>
<%@ page language="java" pageEncoding="UTF-8"%>
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
ProblemFeedbackBean info = (ProblemFeedbackBean) request.getAttribute("entity");
List<DictEntry> list = (List<DictEntry>)request.getAttribute("dict");

%>
<body>
<div id="list">
<%@include file="/jsp/ios/work_items_head.jsp" %>
   <!--div2 S-->
   <div id="div2">
	   	<div class="ulBox2">
			<ul>
			 <li class="first">工作流号:<em><%=request.getAttribute("processinstid")%>
							<input type="hidden" id="busino" value="<%=info.getBusino()%>">
							<input type="hidden" id="approval_url" value="<%=F_Constants.NORMOL_APPROVAL_URL%>"> </em>
					</li>

					<li>工作流:<em>一线问题反馈</em></li>
					<li>申请人:<em><%=info.getApplyPersonName()%></em></li>
					<li>所属部门:<em><%=info.getDepartment()%></em></li>
					<li>所属事业部:<em><%=info.getDivision()%></em></li>
					<li>所属经营本部:<em><%=info.getOperateDept()%></em></li>
					<li>问题类型:<em><%=info.getProblemType()%></em></li>
					<li>问题内容:<em><%=info.getProblemContent()%></em></li>
					<% 
					String completeDateStr = info.getCompleteDateStr();
					if(completeDateStr != null && completeDateStr != ""){%>
					<li>
						预计完成时间:
						<em><%=completeDateStr %></em>
					</li>	
					<%} %>
					<% 
					Long satisfaction = info.getSatisfaction();
					if(satisfaction != null){%>
					<li>
						满意度得分:
						<em><%=satisfaction%></em>
					</li>
					<%} %>
			</ul>
		</div>
		<div style="display: none;" id="flowDiv_responsibDepart">
			<ul>
				<li>
					下级审批人：
					<em class="selectFlow">
						<select name="bizEntity.responsibDepart" id="responsibDepart">
							<% 
								for(DictEntry dicList:list){
							%>
								<option value=<%=dicList.getDictid()%>><%=dicList.getDictname()%></option>
							<% 
								}
							%>
						</select>
					</em>
				</li>
			</ul>
		</div>
		<div style="display: none;" id="flowDiv_completeDate">
			<ul>
				<li>
					预计完成时间：
					<em>
					<input type="text" name="bizEntity.completeDate" id="completeDate" onchange="regMatchTime(this.value);">&nbsp;&nbsp;<span style="color: red">格式：2014-05-21</span>
					</em>
				</li>
			</ul>
		</div>
		<div style="display: none;" id="flowDiv_satisfaction">
			<ul>
				<li>
					满意度得分：
					<em>
					<input type="text" name="bizEntity.satisfaction" id="satisfaction" onchange="matchSatisfaction(this.value)">分(0-100)
					</em>
				</li>
			</ul>
		</div>
		<%@include file="approve_process.jsp" %>
	</div>
	<div>
		<ul id="msg" style="display: none"> 
			<li class="fyy-textCt"><em style="color: red">此节点暂不支持手机审批</em></li>
		</ul>
	</div>
	<input type="hidden" id="submit_Flag">
	<%@include file="workflow_approve_button.jsp" %>
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
		$("#btnbox").css("display","none");
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