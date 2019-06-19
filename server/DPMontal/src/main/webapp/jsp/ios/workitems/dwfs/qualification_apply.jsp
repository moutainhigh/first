<%@page import="com.deppon.wfs.workflow.domain.QualificationapplySkillBean"%>
<%@page import="com.deppon.wfs.workflow.domain.QualificationapplyChildBean"%>
<%@page import="com.deppon.montal.conf.domain.DictEntry"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.wfs.workflow.domain.QualificationApplyBean"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">


<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_ios.jsp" %>
	
<style type="text/css">
#setScore  ul .score {
font-size: 1em;
background-image: none;
} 
 #div2 ul li.top{ 
 border-top:none; 
 } 
 li.score { display:none;}
 .isPass ul li {
 border-bottom: none !important;
 font-size: 1em !important;
 margin: 0 1.5em;
 }
 .allTitle{
 background-color: #e4e4e7;
 margin: 0 -1.5em;
 }
 
 .title{
 background-color: #f7f7f7;
 margin: 0 -1.5em;
 }
 .title em{
  font-weight: bold;
  margin-left: 1.5em !important;
 }

.underLine {
margin: 0 -2em;
}
.em{
 margin-left:2em !important;
}
<!--试试这个CSS好不好使-->
.abScore{
display:inline-block;
	width:14px;
	height:25px;
	float:right;
	margin:0.35em 0 0 0.7em;
}
</style>
</head>
<%
 request.setCharacterEncoding("UTF-8");
 response.setCharacterEncoding("UTF-8");
%>
<%
	QualificationApplyBean info = (QualificationApplyBean)request.getAttribute("entity");
	List<QualificationapplyChildBean> clildBean = info.getQualificationapplyList();
	List<QualificationapplySkillBean> skillBean = info.getQualificationapplySkillList();
	List<DictEntry> scoreList = (List<DictEntry>) request.getAttribute("scoreDict");
%>
<body>
<div id="list">
<%@include file="/jsp/ios/work_items_head.jsp" %>
   <!--div2 S-->
   <div id="div2">
	   	<div class="ulBox2">
			<ul>
			 
			   <li class="first" id="topDetil">工作流号:
			        <em><%=request.getAttribute("processinstid") %>
					<input type="hidden" id="busino" value="<%=info.getBusino()%>">
					<input type="hidden" id="approval_url" value="<%=F_Constants.NORMOL_APPROVAL_URL%>">
					<input type="hidden" id="applyType" value="<%=info.getApptype()%>">		  	   		
			   		</em>
			   </li>
			   <li>工作流:<em>
		   		    任职资格申请
			   </em></li>
			   		<li>申请类型:
						<%if("1".equals(info.getApptype())){%>
							<em>任职资格报名</em>
						<%} else if ("2".equals(info.getApptype())){%>
							<em>任职资格复审</em>
						<%} else {%>
							<em>中级认证申请</em>
						<%}%>
					</li>
					<%if ("3".equals(info.getApptype())&& !(("".equals(info.getIsPass()) || info.getIsPass() == null))){%>
						<li>认证审核结果:
							<em style="color: red">
								<%if("0".equals(info.getIsPass())){%>
									认证不通过
								<%} else {%>
									认证通过
								<%} %>
							</em>
						</li>
					<%} %>						
					
					  <li>申请人:<em>
					  <%=info.getApplyPersonName()%></em>
				   </li>
					 
					  <li>申请人工号:<em>
					  <%=info.getApplyPersonId()%></em>
				   </li>
				   
					  <li>部门:<em>
					  <%=info.getDepartment()%></em>
				   </li>
					 
					  <li>职位:<em>
					  <%=info.getApplyPost()%></em>
				   </li>
					<%if(!"3".equals(info.getApptype())){%>
					  <li>性别:<em>
					  <%=info.getEmpsex()%></em>
				   </li>
				   
					  <li>身份证号:<em>
					  <%=info.getIdCard()%></em>
				   </li>
				   
				   
					  <li>入职日期:<em>
					  <%=info.getEnrollmentDateStr()%></em>
				   </li>
					 
					  <li>学历:<em>
					  <%=info.getEmpDegree()%></em>
				   </li>
					  <% 
					  	if(!info.getInapplyDate().equals(info.getInapplyDateImplDate())){%>
						  <li>入申报岗位时间:<em style="color: red"><%=FormatUtil.formatDate(info.getInapplyDate())%></em></li>
					  	<%}else {%>
						<li>入申报岗位时间:<em><%=FormatUtil.formatDate(info.getInapplyDate())%></em></li>
					  <%	}
					  %>
				   
					 
					  <li>入申报岗位时长:<em>
					  <%=info.getInapplyDuration()%>(个月)</em>
				   </li>
					 
					  <li>管理级别:<em>
					  <%=info.getManagementLevel()==null?"":info.getManagementLevel()%></em>
				   </li>
				   
					  <li>员工绩效:<em>
					  <%=info.getEmpPerformance()==null?"":info.getEmpPerformance()%></em>
				   </li>				   
				   
				   
					  <li>管理绩效:<em>
					  <%=info.getManagerPerformance()==null?"":info.getManagerPerformance()%></em>
				   </li>
				   <%if("1".equals(info.getApptype())) {%>
				   		<li>申请序列:<em><%=info.getApplyChannel()%></em></li>
				   		<li>申请通道岗位:<em><%=info.getApplyProfessionalPost()%></em></li>
				   		<li>当前等级:<em><%=info.getNowLevel()%></em></li>
				  		<li>申请等级:<em><%=info.getApplyLevel()%></em></li>
				   		<%if("1".equals(info.getIschiefRecommend())){%>
							<li>是否总监推荐:<em>是</em></li>
				   		<%} else {%>
				   			<li>是否总监推荐:<em>否</em></li>
				   		<%}%>
				   <%} %>
				   <%if("2".equals(info.getApptype())) {%>
						<li>复审通道:<em><%=info.getReexaminationChannel()%></em></li>		   
					   	<li>复审岗位:<em><%=info.getReexaminationProfesspost()%></em></li>
					   	<li>当前等级:<em><%=info.getReexaminationnowLevel()%></em></li>
					   	<li>复审等级:<em><%=info.getReexaminationLevel()%></em></li>
						<li>认证通过时间:<em><%=FormatUtil.formatDate(info.getCertificationPassdate())%></em></li>
					<%}%>
				<%} %>			   	
				<%if("3".equals(info.getApptype())){%>	
					<li>申请序列:<em><%=info.getApplyMiddleChannel()%></em></li>		   
					<li>申请等级:<em><%=info.getApplyMiddleLevel()%></em></li>
					<%if (!"".equals(info.getIsPass())){%>
					<li class="drafter">认证审核结果:<em><%="1".equals(info.getIsPass())?"认证通过":"认证不通过"%></em></li>
					<%} %>
						<%if (info.getExcellentSide()!=null){%>
							<li>表现优秀方面:<em><%=info.getExcellentSide()==null?"":info.getExcellentSide()%></em></li>
							<li>有待提升方面:<em><%=info.getEnhancedSide()==null?"":info.getEnhancedSide()%></em></li>
					 	<%} %>
				<%} %>	
 					   
						  <li>申请事由:<em>
						  <%=info.getReason()==null?"":info.getReason()%></em>
					   </li>
			</ul>
		</div>
					<%if("3".equals(info.getApptype())){%>
			
<!-- 		<a href="#general" class="yellow">	<h4  onclick="showDetails(2)" class="to_down">请对能力模型材料举证</h4></a> -->
				<a  class="yellow">	<h4  onclick="showDetails(2)" class="to_down">查看能力模型材料举证</h4></a>
		
		    	<div id="skill" style="display: none">
		    	<div class="ulBox2" id="general" name="general">
		    		<ul>
		    			<li class="qualificationAb allTitle"  ><h4 align="center" style=" padding: 0;" ><b>通用能力</b></h4></li>
						<% for(int i = 0 ; i< clildBean.size() ; i++) {
							QualificationapplyChildBean temp = clildBean.get(i); 
 								%><li class="first title"><em><%=temp.getGeneralAbility()%></em></li>
 							<li >能力项目:<em><%=temp.getAbilityItem()%></em></li><% 
 							%><li >能力描述:<em><%=temp.getAbilityDescription()%></em></li><% 
							%><li >举证名称:<em><%=temp.getBurdenName()%></em></li><%
 							%><li >发生时间:<em><%=temp.getHappenTime()%></em></li><% 
							%><li >发生地点:<em><%=temp.getHappenPlace()%></em></li><%
							%><li >扮演角色:<em><%=temp.getPlayRole()%></em></li><% 
							%><li >行为频率:<em><%=temp.getFrequencyBehavior()%></em></li><%
 							%><li >相关人员:<em><%=temp.getRelatedPersonnel()%></em></li><% 
							%><li >事件描述:<em><%=temp.getEventsDescription()%></em></li><%
 							%><li >事件结果:<em><%=temp.getEventsResult()%></em></li><% 
							%><li class="underLine"><em class="em">启示和感受:</em><em><%=temp.getEnlightenmentExperience()%></em></li><%
 						} %> 
 							<li class="qualificationAb allTitle"  id="skill" ><h4 align="center" style=" padding: 0;"><b>业务技能</b></h4></li>
						<% for(int i = 0 ; i< skillBean.size() ; i++) {
 							QualificationapplySkillBean temp = skillBean.get(i);
 								%><li class="first title"><em><%=temp.getBusinessSkills()%></em></li><% 
 							%><li >能力项目:<em><%=temp.getAbilityItem()%></em></li><%
							%><li >能力描述:<em><%=temp.getAbilityDescription()%></em></li><%
 							%><li >举证名称:<em><%=temp.getBurdenName()%></em></li><% 
							%><li >发生时间:<em><%=temp.getHappenTime()%></em></li><%
 							%><li >发生地点:<em><%=temp.getHappenPlace()%></em></li><% 
							%><li >扮演角色:<em><%=temp.getPlayRole()%></em></li><%
 							%><li >行为频率:<em><%=temp.getFrequencyBehavior()%></em></li><% 
							%><li >相关人员:<em><%=temp.getRelatedPersonnel()%></em></li><%
 							%><li >事件描述:<em><%=temp.getEventsDescription()%></em></li><% 
							%><li >事件结果:<em><%=temp.getEventsResult()%></em></li><%
 							%><li class="underLine"><em class="em">启示和感受:</em><em><%=temp.getEnlightenmentExperience()%></em></li><% 
						} %>									
		    		</ul>
		    		
		    	</div>
		    </div>
		    <h4 id="skillclose" class="yellow" onclick="closeDetails(2)" style="display: none">关闭能力模型材料举证</h4>	
		    		<a class="yellow" href="#toscore" ><h4  class="yellow to_down" id="openScore" onclick="showDetails(3)" >请对能力模型进行打分</h4></a>
		    		
		     <%} %>
		     <%if("3".equals(info.getApptype())) {%>
		     <div id="giveScore">
		    	  <div class="score ulBox2" style="display: none" id="setScore">
		    	  <ul id ="abInfo" class="score" style="display: none">
		    	  	<li class="allTitle"  id="toscore"><h4 align="center" style=" padding: 0;" ><b>通用能力</b></h4></li>
<!-- 					  		<li><h4 class='allTitle'  align="center" id="toscore"><b>通用能力</b></h4></li> -->
					  				<% for(int i = 0 ; i< clildBean.size() ; i++) {
   										QualificationapplyChildBean temp = clildBean.get(i);  
  										%>
  											
	  										<li class="score first title"><em><%=temp.getGeneralAbility()%></em></li><br><%  
											%><li class="score underLine"><em class="em"><%=temp.getAbilityItem()%></em>
											
												<em>
													<input type="hidden" value="<%=temp.getTableid()%>" name="bizEntity.qualificationapplyList.tableid">
												<select name="bizEntity.qualificationapplyList.score" id=<%=i%> class="abScore" style="color:#ccc;width: 5em;" onclick="changeColor1(<%=i%>)"   onchange="selectAbScore(<%=i%>)">
												<option value='000' >请选择</option>
												<% 
													for(DictEntry dicList:scoreList){
												%>
													<option value=<%=dicList.getDictid()%>><%=dicList.getDictname()%></option>
												<% 
													}
												%>
											</select>
												</em>
											</li>
										
									<%} %>
									<li class="allTitle"  ><h4 align="center" style=" padding: 0;" ><b>业务技能</b></h4></li>
									<% for(int i = 0 ; i< skillBean.size() ; i++) {
										QualificationapplySkillBean temp = skillBean.get(i);  
  										%>
	  										<li class="score first title"><em><%=temp.getBusinessSkills()%></em></li><br><%  
											%><li class="score underLine"><em class="em"><%=temp.getAbilityItem()%></em>
											
												<em>
													<input type="hidden" value="<%=temp.getTableid()%>"  name="bizEntity.qualificationapplySkillList.tableid">
													<select name="bizEntity.qualificationapplySkillList.score"  id=<%=i+100%> class="abScore"  style="color:#ccc;width: 5em;" onclick="changeColor2(<%=i+100%>)"  onchange="selectSkScore(<%=i+100%>)">
													<option value='000' >请选择</option>
												<% 
													for(DictEntry dicList:scoreList){
												%>
													<option value=<%=dicList.getDictid()%>><%=dicList.getDictname()%></option>
												<% 
													}
												%>
											</select>
												</em>
											</li>
											
									<%} %>
									</ul>
						</div>
						
						<div class="ulBox2 area" id="showTime_area1"  style="display: none">
							<ul class="showTime" style="display: none">
								<li>表现优秀方面:</li>
								<li class="first first1 gray top"><textarea onpropertychange="if(value.length>300) value=value.substr(0,300)" class="fccc opinion-area" id="textarea-b" name="bizEntity.excellentSide" placeholder="请输入表现优秀方面..."></textarea></li>
								<li class="num">剩余<i id="textareaNum1">300</i><i >/300</i>字</li>
							</ul>
						</div>
						<div class="ulBox2 area" id="showTime_area2"  style="display : none">
							<ul class="showTime" style="display: none">
								<li>有待提升方面:</li>
								<li class="first first1 gray top"><textarea onpropertychange="if(value.length>300) value=value.substr(0,300)" class="fccc opinion-area" id="textarea-c"  name="bizEntity.enhancedSide"  placeholder="请输入表现优秀方面..."></textarea></li>
								<li class="num">剩余<i id="textareaNum2">300</i><i >/300</i>字</li>
							</ul>
						</div>
					</div>	
				<h4 class="yellow" onclick="closeDetails(3)" style="display: none" id="closeGiveScore">关闭能力模型评分视图</h4>	
				<%} %>
				  <%if("3".equals(info.getApptype())) {
					  if(clildBean.size()>0){%>
				 
				<h4 class="line yellow to_down" onclick="showDetails(1)" id="showResult" >查看能力认证评分结果</h4>
		    	<div id="ulBoxDetails" style="display: none">
		    	<div class="ulBox2 drafter" id="resultScore">
		    		<ul>
						<% for(int i = 0 ; i< clildBean.size() ; i++) {
 							QualificationapplyChildBean temp = clildBean.get(i); 
							if (i == 0) { 
 								%><li class="first">通用能力:<em><%=temp.getGeneralAbility()%></em></li><% 
							} else {
								%><li class="line">通用能力:<em><%=temp.getGeneralAbility()%></em></li><%
							} 
							%><li class="details">能力项目:<em><%=temp.getAbilityItem()%></em></li><% 
							%><li class="details">能力对应分数:<em><%=temp.getScore()==null?"":temp.getScore()%></em></li><%
						} %> 
						<% for(int i = 0 ; i< skillBean.size() ; i++) {
 							QualificationapplySkillBean temp = skillBean.get(i); 
							if (i == 0) {
								%><li class = "first">业务技能:<em><%=temp.getBusinessSkills()%></em></li><% 
							} else {
								%><li class = "line">业务技能:<em><%=temp.getBusinessSkills()%></em></li><%
							} 
							
							%><li class="details">能力项目:<em><%=temp.getAbilityItem()%></em></li><% 
							%><li class="details">能力对应分数:<em><%=temp.getScore()==null?"":temp.getScore()%></em></li><%
						} %>							
		    		</ul>
		    	</div>
		    </div>
		   
		    <h4 id="hideListDetails" class="yellow" onclick="closeDetails(1)" style="display: none">关闭能力认证评分结果</h4>
		     <% }
		     }%>
					  <div class="isPass" style="display: none">
						  <ul>
						  	 <li>
	                       		<em>
	                       		认证审核结果：
	                       		</em>
	                       </li>
							<li>
								<em>	
									<label for="isPass" style="color: #ff0000"><input type="radio" name="bizEntity.isPass" id="isPass" value="1" checked="checked" style="color: #ff0000" />认证通过</label>
								</em>
	                      	 </li>
									
							<li>	
								<em>
									<label for="isunPass" style="color: #ff0000"><input type="radio" name="bizEntity.isPass" id="isunPass"  value="0" style="color: #ff0000"/>认证不通过</label>
	                       		</em>
	                       </li>
	                       </ul>
					  </div>
					  <div class="wrap">
					  		<a href="#topDetil"><img src="<%=basePath %>/images/ios/to_top.png" id="topImg">
					  							<img src="<%=basePath %>/images/ios/to_top_touch.png" id="topImg1" style="display: none">
					  		</a>
					  </div>
		<%@include file="approve_process.jsp" %>
	</div>
<!-- 	<div> -->
<!-- 		<ul id="msg" style="display: none">  -->
<!-- 			<li class="fyy-textCt"><em style="color: red">中级认证申请暂不支持手机审批</em></li> -->
<!-- 		</ul> -->
<!-- 	</div> -->
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
<script type="text/javascript">
	function showDetails(n){
		if (n == 1) {
			$('#ulBoxDetails').slideDown(200);
			$('#hideListDetails').show();
			$("#resultScore").show();
		} else if(n == 2){
			$('#skill').slideDown(200);
			$('#skillclose').show();
			 $('body,html').animate({scrollTop:500},100);
			//location.hash="general";
		}else {
			$('#giveScore').slideDown(200);
			$('.score').show();
			$('.showTime').show();
			$('.area').show();
			$('#closeGiveScore').show();
			 $('body,html').animate({scrollTop:525},100);
		}
		
	}
	function closeDetails(n){
		if (n == 1) {
			$('#ulBoxDetails').slideUp(200);
			$('#hideListDetails').hide();
		} else if(n == 2){
			$('#skill').slideUp(200);
			$('#skillclose').hide();
		} else{
			$('#giveScore').slideUp(200);
			$("#closeGiveScore").hide();
		}
		
	}
	$(document).ready(function(){
		var applyType = $('#applyType').val();
		var activitydefid = $("#activitydefid").val();
// 		if(applyType == 3){
// 			$('#msg').show();
// 			document.getElementById("disagree_but").style.display = "none";
// 			document.getElementById("agree_but").style.display = "none";
// 			document.getElementById("rollback_but").style.display = "none";
// 			document.getElementById("showTime_area").style.display = "none";
// 		}
	    //首先将#back-to-top隐藏
	    $(".wrap").hide();
	    //当滚动条的位置处于距顶部100像素以下时，跳转链接出现，否则消失
	    $(function () {
		    $(window).scroll(function(){
		    if ($(window).scrollTop()>100){
		  	  $(".wrap").fadeIn(100);
		    }
		    else
		    {
		   		 $(".wrap").fadeOut(150);
		    }
		});
	    //当点击跳转链接后，回到页面顶部位置
		    $(".wrap").click(function(){
			    $('body,html').animate({scrollTop:0},100);
			    return false;
		    });
	    });
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
// 				$(".score").attr("style","display: block;");
// 				$(".area").attr("style","display: inherit;");
			}
			//中级直接上级的上级，需要调用公共的保存业务数据的action，并显示是否通过
			if("manualActivity" == activitydefid){
				$("#approval_url").val("approvalWithbizEntity.action");
				$(".isPass").attr("style","display: inline-block;");
				$("#openScore").hide();
				$("#giveScore").remove();
			}
			if("manualActivity2" == activitydefid){
				$("#openScore").hide();
				$("#giveScore").remove();
			}
			
		}else{
			$("#giveScore").remove();
			$(".isPass").remove();
		}
		if($("#applyPersonId").val() == $("#userId").val()){
			$(".drafter").hide();
		}
		
		$("#agree_but").click(function(){
			var str = $('#textarea-b').val();
			if(str == "" ){ //回退时审批意见为空判断
				$("#textarea-b").focus();
				$("#textarea-b").parent().parent().parent().css("border-color","#f00");
				$("#showTime_area1").find($(".first1")).removeClass("gray");
				$("#showTime_area1").find($(".first1")).addClass("gray1");
				return;
			}
			var str = $('#textarea-c').val();
			if(str == "" ){ //回退时审批意见为空判断
				$("#textarea-c").focus();
				$("#textarea-c").parent().parent().parent().css("border-color","#f00");
				$("#showTime_area2").find($(".first1")).removeClass("gray");
				$("#showTime_area2").find($(".first1")).addClass("gray1");
				return;
			}
		});
		
		$(".wrap").mouseover(function(){
			$("#topImg").hide();
			$("#topImg1").show();
		});
		$(".wrap").mouseleave(function(){
			$("#topImg").show();
			$("#topImg1").hide();
		});
	});
	//审批意见输入监听
	document.getElementById("textarea-b").onkeydown = function(event_e){
		if( window.event )
		event_e = window.event;
		var int_keycode = event_e.charCode||event_e.keyCode;
		var obj = document.getElementById("textarea-b");
		var length = obj.value.length;
		$("#showTime_area1").find($(".first1")).removeClass("gray1");
		$("#showTime_area1").find($(".first1")).addClass("gray");
		if(length == 0 ){
			if(int_keycode ==32){
				return false;
		 	}
		}
		if(int_keycode ==32){
			return false;
	 	}
		if (/^\s+/.test(obj.value)) {
			return false;
		}
		if(int_keycode ==13){
				return false;
		 }
	};
	
	var length0 = 300;
	$('#textarea-b').bind('input propertychange', function() {
	    $("#textarea-b").parent().parent().parent().css("border-color","#aaa");
	    	var length1 = event.srcElement.value.length;
	    	if(length1 <= length0){
	    		var length2 = length0-length1;
	        	$("#textareaNum1").text((length2));
	    	}
	    	//审批意见字数超过300无法继续输入
	   		if($(this).val().length >300){
	   			$(this).val(this.value.substring(0,300));		
	   		}
	});
	
	//审批意见输入监听
	document.getElementById("textarea-c").onkeydown = function(event_e){
		if( window.event )
		event_e = window.event;
		var int_keycode = event_e.charCode||event_e.keyCode;
		var obj = document.getElementById("textarea-c");
		var length = obj.value.length;
		$("#showTime_area2").find($(".first1")).removeClass("gray1");
		$("#showTime_area2").find($(".first1")).addClass("gray");
		if(length == 0 ){
			if(int_keycode ==32){
				return false;
		 	}
		}
		if(int_keycode ==32){
			return false;
	 	}
		if (/^\s+/.test(obj.value)) {
			return false;
		}
		if(int_keycode ==13){
				return false;
		 }
	};
	
	var length0 = 300;
	$('#textarea-c').bind('input propertychange', function() {
	    $("#textarea-c").parent().parent().parent().css("border-color","#aaa");
	    	var length1 = event.srcElement.value.length;
	    	if(length1 <= length0){
	    		var length2 = length0-length1;
	        	$("#textareaNum2").text((length2));
	    	}
	    	//审批意见字数超过300无法继续输入
	   		if($(this).val().length >300){
	   			$(this).val(this.value.substring(0,300));		
	   		};
	});
	
	function selectAbScore(i){
		$("#"+i).find("option[value='000']").remove();
		$("#"+i).removeClass(".unabScore");
		$("#"+i).addClass(".abScore");
		changeColor1(i);
	};
	function selectSkScore(i){
		$("#"+i).find("option[value='000']").remove();
		$("#"+i).removeClass(".unabScore");
		$("#"+i).addClass(".abScore");
		changeColor2(i);
	}
	function changeColor1(i){
		$("#"+i).attr("style","rgb(46, 46, 46);width: 5em;");
	}
	function changeColor2(i){
		$("#"+i).attr("style","rgb(46, 46, 46);width: 5em;");
	}
</script>
</html>