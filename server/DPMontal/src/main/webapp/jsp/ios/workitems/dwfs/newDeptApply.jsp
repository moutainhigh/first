<%@page import="com.deppon.montal.conf.domain.DictEntry"%>
<%@page import="com.deppon.wfs.workflow.domain.NewDeptApplyBean"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
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
	NewDeptApplyBean info = (NewDeptApplyBean)request.getAttribute("entity");
	List<DictEntry> list = (List<DictEntry>) request.getAttribute("dict");

%>
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
					<input type="hidden" id="approval_url" value="<%=F_Constants.SAVE_ENTITY__APPROVAL_URL%>">	
						  	   		
			   		</em>
			   </li>
			   	<li>工作流:<em> 组织架构调整申请</em></li>
				<li>申请人:<em><%=info.getApplyPersonName()%></em></li>
				<li>架构调整类型:<em><%=info.getDeptChange()%></em></li><!-- WFS_DEPTCHANGE_TYPE -->
				<li>架构调整部门:<em><%=info.getNewDeptName()%></em></li>
				<li>申请事由及调整方案简述:<em><%=info.getApplyReason()%></em></li>
			</ul>
		</div>
		<div style="display: none;" id="flowDiv">
			<ul>
				<li>工作流流向：
					<em>
						<select name="bizEntity.applyFlow" id="applyFlow" onclick="selectFlow()">
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
				
				<li class="selectFlow">重新选择流向：
					<em>
						<select name="bizEntity.applyFlow" id="selectFlow">
							<% 
								for(DictEntry dicList:list){
									if(dicList.getDictid().equals("FUNCTION")){
										
									}
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
		<%@include file="approve_process.jsp" %>
	</div>
	<div>
		<ul id="msg" style="display: none"> 
			<li class="fyy-textCt"><em style="color: red">此节点暂不支持手机审批</em></li>
		</ul>
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