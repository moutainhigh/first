<%@page import="com.deppon.wfs.workflow.domain.QualificationapplySkillBean"%>
<%@page import="com.deppon.wfs.workflow.domain.QualificationapplyChildBean"%>
<%@page import="com.deppon.montal.conf.domain.DictEntry"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.module.workitems.webservice.client.DWFSWorkItemServiceClient"%>
<%@page import="com.deppon.wfs.workflow.domain.QualificationApplyBean"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_win8.jsp" %>
	<style>
	tr.details, tr.qytr { display:none;}
	tr.skill, tr.qytr { display:none;}
  	table tbody tr.score { display:none;}  
	</style>
</head>
<body onload="autoShowApproval()">
<%
	QualificationApplyBean info = (QualificationApplyBean)request.getAttribute("entity");
	List<QualificationapplyChildBean> clildBean = info.getQualificationapplyList();
	List<QualificationapplySkillBean> skillBean = info.getQualificationapplySkillList();
	List<DictEntry> scoreList = (List<DictEntry>) request.getAttribute("scoreDict");


%>
<div id="list">
	<%@include file="../wf_head_win8.jsp" %>
	<input type="hidden" id="busino" value="<%=info.getBusino()%>">
	<input type="hidden" id="approval_url" value="<%=F_Constants.NORMOL_APPROVAL_URL%>">
	<input type="hidden" id="applyType" value="<%=info.getApptype()%>">
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
					   <td>任职资格申请<input type="hidden" id ="type_id" value="qualification"></td>
					</tr>
					<tr>
						<th>申请类型:</th>
						<%if("1".equals(info.getApptype())){%>
							<td>任职资格报名</td>
						<%} else if ("2".equals(info.getApptype())){%>
							<td>任职资格复审</td>
						<%} else {%>
							<td>中级认证申请</td>
						<%}%>
						
					</tr>
					<%if ("3".equals(info.getApptype())&& !(("".equals(info.getIsPass()) || info.getIsPass() == null))){%>
						<tr>
						<th>认证审核结果:</th>
						<td style="color: red">
							<%if("0".equals(info.getIsPass())){%>
								认证不通过
							<%} else {%>
								认证通过
							<%} %>
						</td>
					</tr>
					<%} %>				
				   <tr>
					  <th>申请人:</th>
					  <td><%=info.getApplyPersonName()%></td>
				   </tr>
					 <tr>
					  <th>申请人工号:</th>
					  <td><%=info.getApplyPersonId()%></td>
					  <!-- 申请人工号 -->
					  <input type="hidden" value="<%=info.getApplyPersonId()%>" id="applyPersonId">
					  <!-- 当前登录人工号 -->
					   <input type="hidden" value="<%=request.getAttribute("userId")%>" id="userId">
				   </tr>
				   <tr>
					  <th>部门:</th>
					  <td><%=info.getDepartment()%></td>
				   </tr>
					 <tr>
					  <th>职位:</th>
					  <td><%=info.getApplyPost()%></td>
				   </tr>
				   <%if(!"3".equals(info.getApptype())){%>
						<tr>
							<th>性别:</th>
						  	<td><%=info.getEmpsex()%></td>
					   	</tr>
					   	<tr>
							<th>身份证号:</th>
						  	<td><%=info.getIdCard()%></td>
					   	</tr>
						<tr>
							<th>入职日期:</th>
							<td><%=info.getEnrollmentDateStr()%></td>
						</tr>
						<tr>
						 	<th>学历:</th>
						 	<td><%=info.getEmpDegree()%></td>
						</tr>
					   	<tr>
						  	<th>入申报岗位时间:</th>
						  <%if(!info.getInapplyDate().equals(info.getInapplyDateImplDate())){%>
							  	<td style="color: red"><%=FormatUtil.formatDate(info.getInapplyDate())%></td>
						  <%}else {%>
								<td><%=FormatUtil.formatDate(info.getInapplyDate())%></td>
						  <%}%>
					   </tr>
						<tr>
					  		<th>入申报岗位时长:</th>
					  		<td><%=info.getInapplyDuration()%>(个月)</td>
				   		</tr>
					 	<tr>
					  		<th>管理级别:</th>
					  		<td><%=info.getManagementLevel()==null?"":info.getManagementLevel()%></td>
				   		</tr>
				   		<tr>
					  		<th>员工绩效:</th>
					  		<td><%=info.getEmpPerformance()==null?"":info.getEmpPerformance()%></td>
				   		</tr>				   
					   	<tr>
						  	<th>管理绩效:</th>
						  	<td><%=info.getManagerPerformance()==null?"":info.getManagerPerformance()%></td>
					   	</tr>
					   	<%if("1".equals(info.getApptype())) {%>
					   		<tr>
					  			<th>申请序列:</th>
					  			<td><%=info.getApplyChannel()%></td>
				   			</tr>
				   			<tr>
					  			<th>申请通道岗位:</th>
					  			<td><%=info.getApplyProfessionalPost()%></td>
				   			</tr>
				   			<tr>
					 			<th>当前等级:</th>
					  			<td><%=info.getNowLevel()%></td>
				   			</tr>
<%-- 				   			<%if(!(info.getApplyProfessionalPost().contains("见习")||info.getApplyProfessionalPost().contains("助理")||info.getApplyProfessionalPost().contains("专家"))){%> --%>
				     			<tr>
						  			<th>申请等级:</th>
						  			<td><%=info.getApplyLevel()%></td>
					   			</tr>
<%-- 				   			<%} %> --%>
							<%if("1".equals(info.getIschiefRecommend())){%>
								<tr><th>是否总监推荐:</th><td>是</td></tr>
				   			<%} else {%>
				   				<tr><th>是否总监推荐:</th><td>否</td></tr>
				   			<%}%>
					   	<%}%>
					   	<%if("2".equals(info.getApptype())) {%>
					   		<tr>
						  		<th>复审通道:</th>
						  		<td><%=info.getReexaminationChannel()%></td>
					   		</tr>		   
					   		<tr>
						  		<th>复审岗位:</th>
						  		<td><%=info.getReexaminationProfesspost()%></td>
					   		</tr>
					   		<tr>
						  		<th>当前等级:</th>
						  		<td><%=info.getReexaminationnowLevel()%></td>
					   		</tr>
					   		<tr>
							  <th>复审等级:</th>
							  <td><%=info.getReexaminationLevel()%></td>
						   </tr>
						   	<tr>
								<th>认证通过时间:</th>
						  		<td><%=FormatUtil.formatDate(info.getCertificationPassdate())%></td>
					   		</tr>
					   	<%}%>
				   <%} %>
				   <%if("3".equals(info.getApptype())){%>
						<tr>
							<th>申请序列:</th>
						  	<td><%=info.getApplyMiddleChannel()%></td>
					   	</tr>		   
					   	<tr>
						  	<th>申请等级:</th>
						  	<td><%=info.getApplyMiddleLevel()%></td>
					   	</tr>
					   	<%if (info.getExcellentSide()!=null ){%>
					   		<tr>
							  <th>表现优秀方面:</th>
							  <td><%=info.getExcellentSide()==null?"":info.getExcellentSide()%></td>
						   </tr>
						   	<tr>
								<th>有待提升方面:</th>
						  		<td><%=info.getEnhancedSide()==null?"":info.getEnhancedSide()%></td>
					   		</tr>
					   	<%} %>
					  <%} %>
					   	<tr>
						  <th>申请事由:</th>
						  <td><%=info.getReason()%></td>
					   </tr>
					   <%if("3".equals(info.getApptype())){%>
					   <tbody class="drafter">
					   	<%if (!"".equals(info.getExcellentSide())){%>
					   		<%if(clildBean.size() > 0 && skillBean.size() > 0) {%>
							   	<tr id="appstr">
									<th colspan="2"><a class="yellow" id="showResult" onclick="showDetails(1)">查看能力认证评分结果</a></th>
								</tr>
									<% for(int i = 0 ; i< clildBean.size() ; i++) {
   										QualificationapplyChildBean temp = clildBean.get(i); 
  										%><tr class="details topLine"><th>通用能力:</th><td><%=temp.getGeneralAbility()%></td></tr><%  
										%><tr class="details"><th>能力项目:</th><td><%=temp.getAbilityItem()%></td></tr><%
  										%><tr class="details"><th>能力对应分数:</th><td><%=temp.getScore()==null?"":temp.getScore()%></td></tr><%  
									} %>
									<% for(int i = 0 ; i< skillBean.size() ; i++) {
   										QualificationapplySkillBean temp = skillBean.get(i);  
  										%><tr class="details topLine"><th>业务技能:</th><td><%=temp.getBusinessSkills()%></td></tr><%  
										%><tr class="details"><th>能力项目:</th><td><%=temp.getAbilityItem()%></td></tr><%
  										%><tr class="details"><th>能力对应分数:</th><td><%=temp.getScore()==null?"":temp.getScore()%></td></tr><%  
									} %>							
								<tr class="topLine" style="display: none">
									<th colspan="2"><a class="yellow" id="closeDetails" onclick="closeDetails(1)">关闭能力认证评分结果</a></th>
								</tr>
						   	<%} %>
							
						   	<tr id="appstr">
									<th colspan="2"><a class="yellow" onclick="showDetails(2)" href="#general">查看能力模型材料举证</a></th>
								</tr>
								<tr class="skill" style="display: none" >
									<th align="center"><a id="general"><b>通用能力</b></a></th>
								</tr>
									<% for(int i = 0 ; i< clildBean.size() ; i++) {
   										QualificationapplyChildBean temp = clildBean.get(i);  
  										%><tr class="skill topLine"><td><%=temp.getGeneralAbility()%></td></tr><%  
  										%><tr class="skill"><th>能力项目:</th><td><%=temp.getAbilityItem()%></td></tr><%
										%><tr class="skill"><th>能力描述:</th><td><%=temp.getAbilityDescription()%></td></tr><%
  										%><tr class="skill"><th>举证名称:</th><td><%=temp.getBurdenName()%></td></tr><%  
										%><tr class="skill"><th>发生时间:</th><td><%=temp.getHappenTime()%></td></tr><%
  										%><tr class="skill"><th>发生地点:</th><td><%=temp.getHappenPlace()%></td></tr><%  
										%><tr class="skill"><th>扮演角色:</th><td><%=temp.getPlayRole()%></td></tr><%
  										%><tr class="skill"><th>行为频率:</th><td><%=temp.getFrequencyBehavior()%></td></tr><%  
										%><tr class="skill"><th>相关人员:</th><td><%=temp.getRelatedPersonnel()%></td></tr><%
  										%><tr class="skill"><th>事件描述:</th><td><%=temp.getEventsDescription()%></td></tr><% 
										%><tr class="skill"><th>事件结果:</th><td><%=temp.getEventsResult()%></td></tr><%
  										%><tr class="skill"><th>启示和感受:</th><td><%=temp.getEnlightenmentExperience()%></td></tr><%  
									} %>
								<tr class="skill" style="display: none">
									<th align="center"><a id="skill"><b>业务技能</b></a></th>
								</tr>
									<% for(int i = 0 ; i< skillBean.size() ; i++) {
   										QualificationapplySkillBean temp = skillBean.get(i);  
  										%><tr class="skill topLine"><td><%=temp.getBusinessSkills()%></td></tr><%  
  										%><tr class="skill"><th>能力项目:</th><td><%=temp.getAbilityItem()%></td></tr><%
										%><tr class="skill"><th>能力描述:</th><td><%=temp.getAbilityDescription()%></td></tr><%
  										%><tr class="skill"><th>举证名称:</th><td><%=temp.getBurdenName()%></td></tr><%  
										%><tr class="skill"><th>发生时间:</th><td><%=temp.getHappenTime()%></td></tr><%
  										%><tr class="skill"><th>发生地点:</th><td><%=temp.getHappenPlace()%></td></tr><%  
										%><tr class="skill"><th>扮演角色:</th><td><%=temp.getPlayRole()%></td></tr><%
  										%><tr class="skill"><th>行为频率:</th><td><%=temp.getFrequencyBehavior()%></td></tr><%  
										%><tr class="skill"><th>相关人员:</th><td><%=temp.getRelatedPersonnel()%></td></tr><%
  										%><tr class="skill"><th>事件描述:</th><td><%=temp.getEventsDescription()%></td></tr><%  
										%><tr class="skill"><th>事件结果:</th><td><%=temp.getEventsResult()%></td></tr><%
  										%><tr class="skill"><th>启示和感受:</th><td><%=temp.getEnlightenmentExperience()%></td></tr><%  
									} %>							
								<tr class="skill topLine" style="display: none">
									<th colspan="2"><a class="yellow" id="skill" onclick="closeDetails(2)">关闭能力模型材料举证</a></th>
								</tr>
					   		<%} %>
 					   
					   </tbody>
					  <%} %>
					  
					  	<tr  class="apprScore" >
								<th colspan="2"><a class="yellow" onclick="showDetails(3)" href="#general">请对能力模型进行打分</a></th>
						</tr>
					
					  <tbody class="score" style="display: none">
					  	 	<tbody id ="abInfo" class="score" style="display: none">
					  				<% for(int i = 0 ; i< clildBean.size() ; i++) {
   										QualificationapplyChildBean temp = clildBean.get(i);  
  										%><tr class="score topLine"><td><%=temp.getGeneralAbility()%></td></tr><%  
										%><tr class="score"><td><%=temp.getAbilityItem()%></td></tr>
										<tr class="score">
											<td>
												<input type="hidden" value="<%=temp.getTableid()%>" name="bizEntity.qualificationapplyList.tableid">
										<select name="bizEntity.qualificationapplyList.score" id=<%=i%> style="color:#ccc;width: 5em;"  onclick="changeColor1(<%=i%>)"   onchange="selectAbScore(<%=i%>)">
										<option value='000' >请选择</option>
											<% 
												for(DictEntry dicList:scoreList){
											%>
												<option value=<%=dicList.getDictid()%>><%=dicList.getDictname()%></option>
											<% 
												}
											%>
										</select>
											</td>
										</tr>
									<%} %>
						</tbody>
						<tbody id ='skInfo' class="score" style="display: none">
									<% for(int i = 0 ; i< skillBean.size() ; i++) {
										QualificationapplySkillBean temp = skillBean.get(i);  
  										%><tr class="score topLine"><td><%=temp.getBusinessSkills()%></td></tr><%  
										%><tr class="score"><td><%=temp.getAbilityItem()%></td></tr>
										<tr class="score">
											<td>
												<input type="hidden" value="<%=temp.getTableid()%>" name="bizEntity.qualificationapplySkillList.tableid">
												<select name="bizEntity.qualificationapplySkillList.score" style="color:#ccc;width: 5em;" id=<%=i+100%> onclick="changeColor2(<%=i+100%>)"  onchange="selectSkScore(<%=i+100%>)">
											<option value='000' >请选择</option>
											<% 
												for(DictEntry dicList:scoreList){
											%>
												<option value=<%=dicList.getDictid()%>><%=dicList.getDictname()%></option>
											<% 
												}
											%>
										</select>
											</td>
										</tr>
										
									<%} %>
						</tbody>
						<tbody class="score" style="display: none">
							<tr>
								<th>表现优秀方面:</th>
							   	<td colspan="2">
							   		<div class="area allSide" id="approve_area1">
										<textarea onpropertychange="if(value.length>300) value=value.substr(0,300)" name="bizEntity.excellentSide" id="textarea-b" placeholder="请输入审批意见..."></textarea>
										<h6>剩余<i id="textareaNum1">300</i><i>/300</i>字</h6>
									</div>
							   	</td>
							</tr>
							<tr>
								<th>有待提升方面:</th>
							   	<td colspan="2">
							   		<div class="area allSide" id="approve_area2">
										<textarea onpropertychange="if(value.length>300) value=value.substr(0,300)" name="bizEntity.enhancedSide" id="textarea-c" placeholder="请输入审批意见..."></textarea>
										<h6>剩余<i id="textareaNum2">300</i><i>/300</i>字</h6>
									</div>
							   	</td>
							</tr>
						</tbody>
					  </tbody>
					 <tr id="closeApprScore" style="display: none">
									<th colspan="2"><a class="yellow" id="apprScroe" onclick="closeDetails(3)">关闭能力模型评分视图</a></th>
						</tr>
					  <tbody class="isPass" style="display: none">
					  	 <tr>
                       		<th width="95">认证审核结果：</th>
                       		<td>
								<label for="isPass"><input type="radio" name="bizEntity.isPass" id="isPass" value="1" checked="checked" />认证通过</label>
								<label for="isunPass"><input type="radio" name="bizEntity.isPass" id="isunPass"  value="0"/>认证不通过</label>
                       		</td>
                       </tr>
					  </tbody>
				<%@include file="approve_process.jsp" %>					   					   
	    	</table>
<!-- 	    	<table width="100%" style="display: none" id="msg"> -->
<!-- 				<tr><td style="color: red" align="center" colspan="2">中级认证申请暂不支持手机审批</td></tr> -->
<!-- 			</table> -->
	    </div>
	</div>
	 <%@include file="workflow_approve_button.jsp" %>
</div>
<script type="text/javascript">
	function showDetails(n){
		if (n ==1) {
			$('.details').show();
			$('#closeDetails').parents("tr").show();
		} else if(n == 3){
			$('.score').show();
			$('.allSide').show();
			$('#apprScroe').parents("tr").show();
		}else {
			$('.skill').show();
			$('#skill').parents("tr").show();
		}
	}
	function closeDetails(n){
		if (n == 1) {
			$('.details').hide();
			$('#closeDetails').parents("tr").hide();
		} else if(n == 3){
			$('.score').hide();
			$('.allSide').hide();
			$('#apprScroe').parents("tr").hide();
		}else {
			$('.skill').hide();
			$('#skill').parents("tr").hide();
		}
	}
	$(document).ready(function(){
		var applyType = $('#applyType').val();
		var activitydefid = $("#activitydefid").val();
		if(applyType == 3){
			//$('#msg').show();
			//中级认证知己上级审批时只有同意和回退
			if("immediateSuperior" == activitydefid){
			document.getElementById("disagree_but").style.display = "none";
			}else {
				//中级直接上级的上级以及任职组只能同意
				document.getElementById("disagree_but").style.display = "none";
				document.getElementById("rollback_but").style.display = "none";
					}
			//中级直接上级审批是需要用特殊action酱紫标信息保存，并显示评分表
			if("immediateSuperior" == activitydefid){
				$("#approval_url").val("qualificationApproval.action");
				$("#showResult").hide();
// 				$(".score").show();
			}
			//中级直接上级的上级，需要调用公共的保存业务数据的action，并显示是否通过
			if("manualActivity" == activitydefid){
				$("#approval_url").val("approvalWithbizEntity.action");
				$(".score").remove();
				$(".isPass").show();
				$(".apprScore").remove();
			}
			if("manualActivity2" == activitydefid){
				$(".score").remove();
				$(".apprScore").remove();
			};
		}else{
			$(".score").remove();
			$(".isPass").remove();
			$(".apprScore").remove();
		}
		if($("#applyPersonId").val() == $("#userId").val()){
			$(".drafter").hide();
		}
		$("#agree_but").click(function(){
			var str = $('#textarea-b').val();
			if(str == "" ){ //回退时审批意见为空判断
				$("#textarea-b").focus();
				$("#textarea-b").parent().css("border-color","#f00");
				return;
			}
			var str1 = $('#textarea-c').val();
			if(str1 == "" ){ //回退时审批意见为空判断
				$("#textarea-c").focus();
				$("#textarea-c").parent().css("border-color","#f00");
				return;
			}
		});
		
	});
	
	
	//审批意见输入监听
	document.getElementById("textarea-b").onkeydown = function(event_e){
		if( window.event )
		event_e = window.event;
		var int_keycode = event_e.charCode||event_e.keyCode;
		var length = document.getElementById("textarea-b").value.length;
		var obj = document.getElementById("textarea-b");
		if(length == 0 ){
			if(int_keycode ==32){
				return false;
		 	}
		}
		if (/^\s+/.test(obj.value)) {
			return false;
		} 
		if(int_keycode ==13){
				return false;
		 }
	}
	var length0 = 300;

	$('#textarea-b').bind('input propertychange', function(event) {
	    $("#textarea-b").parent().css("border-color","#aaa");
	    	var length1 = event.srcElement.value.length;
	    	if(length1 <= length0){
	    		var length2 = length0-length1;
	        	$("#textareaNum1").text((length2));
	    	}
	    	if($(this).val().length >300){
				$(this).val(this.value.substring(0,300));		
			}
	});
	//审批意见输入监听
	document.getElementById("textarea-c").onkeydown = function(event_e){
		if( window.event )
		event_e = window.event;
		var int_keycode = event_e.charCode||event_e.keyCode;
		var length = document.getElementById("textarea-c").value.length;
		var obj = document.getElementById("textarea-c");
		if(length == 0 ){
			if(int_keycode ==32){
				return false;
		 	}
		}
		if (/^\s+/.test(obj.value)) {
			return false;
		} 
		if(int_keycode ==13){
				return false;
		 }
	}
	var length0 = 300;

	$('#textarea-c').bind('input propertychange', function(event) {
	    $("#textarea-c").parent().css("border-color","#aaa");
	    	var length1 = event.srcElement.value.length;
	    	if(length1 <= length0){
	    		var length2 = length0-length1;
	        	$("#textareaNum2").text((length2));
	    	}
	    	if($(this).val().length >300){
				$(this).val(this.value.substring(0,300));		
			}
	});

	function selectAbScore(i){
		$("#"+i).find("option[value='000']").remove();
		changeColor1(i);
	};
	function selectSkScore(i){
		$("#"+i).find("option[value='000']").remove();
		changeColor2(i);
	}
	function changeColor1(i){
		$("#"+i).attr("style","rgb(46, 46, 46);width: 5em;");
	}
	function changeColor2(i){
		$("#"+i).attr("style","rgb(46, 46, 46);width: 5em;");
	}
</script>
</body>
</html>