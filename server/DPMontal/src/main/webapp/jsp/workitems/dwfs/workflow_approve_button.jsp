<%@page import="com.deppon.montal.module.workitems.webservice.client.DWFSWorkItemServiceClient"%>
<%@page import="com.deppon.montal.conf.F_Constants"%>
<%@page import="com.deppon.montal.model.WfActivityInst"%>
<%@page import="com.deppon.montal.util.InitDataServlet" %>
<%@page import="java.util.List"%>
<%@ page language="java"  pageEncoding="UTF-8"%>
<%
    String pathBut = request.getContextPath();
			String basePathBut = InitDataServlet.getValue("dpm_domain_url")+"://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ pathBut;
%>
<script type="text/javascript">

//当你是特殊审批页面时，将这个值在你的审批页面中设置为true
// var isValue = false;
// var isValueFlag = false;

$(function(){
	$(".btnBox").find(".btn").mousedown(function(){
		$(this).addClass('down');
	});
	$(".btnBox").find(".btn").mouseleave(function(){
		$(this).removeClass('down');
	});
	$("#to_showmain").click(function(){
		window.location.assign("<%=basePathBut%>/showmain");
	});
	$("#sliderDown").click(function(){
		showApproval();
	});
	$("#sliderUp").click(function(){
		$("table").find(".sh").hide();
	});
	$("#disagree_but").click(function(){
		$("#app_val").val("1");
		$("#confirm_msg").html("您当前选择【不同意】该工作流，是否确定提交？");
		$("#app_window").fadeIn(600);
		$(".tipsWinCnt").show();
	});
	
	$("#agree_but").click(function(){
// 		if (isValueFlag) {
// 			//当通过你的页面校验后，在你的页面中要把isValueId置为false
// 			isValueNull();
// 			if(isValue){
// 				return;
// 			}
// 		}
		$("#app_val").val("0");
		$("#confirm_msg").html("您当前选择【同意】该工作流，是否确定提交？");
		$("#app_window").fadeIn(600);
		$(".tipsWinCnt").show();
	});
	
	$("#rollback_but").click(function(){
		$("#result_window").hide();
		queryActivity();
	});
	$("#activity_cancel").click(function(){
		$(".tipsWinCnt").hide();
		$("#activity_window").hide();
	});
	$("#activity_confirm").click(function(){
		$("#result_window").hide();
		$("#activity_window").hide();
		rollBackWorkFlow();
	});
	$("#select_act_cancel").click(function(){
		$(".tipsWinCnt").hide();
		$("#select_act_window").hide();
	});
	$("#select_act_confirm").click(function(){
		$("#result_window").hide();
		$("#select_act_window").hide();
		var rollBackId = $('input[name="radio-choice"]:checked').val();
		var val = $('#val-' + rollBackId).val();
		$("#activity_val").html("您当前选择回退至<br/>【" + val + "】！<br/>确认提交吗？");
		$("#activity_window").fadeIn(600);
		$(".tipsWinCnt").show();
	});
	
	$("#confirm_back").click(function(){
		$("#result_window").hide();
		$("#confirm_back").hide();
		$(".tipsWinCnt").hide();
	});
	$("#confirm_cancel").click(function(){
		$("#result_window").hide();
		$("#confirm_cancel").hide();
		 window.location.replace("<%=basePathBut%>/toWorkItemsList");
	});
	
	$("#btnCancel").click(function(){
		$("#result_window").hide();
		$(".tipsWinCnt").hide();
		$("#app_window").hide();
	});
	$("#btnConfirm").click(function(){
		$("#result_window").hide();
		$(".tipsWinCnt").show();
		$("#app_window").hide();
		var appval = $("#app_val").val();
		approve(appval);
	});
	
	
});
var t;
var time = 20000;
function appTimeout(time){
	t = setTimeout(timeoutmsg, time);
}
function timeoutmsg(){
	$(".loading").hide();
	$('#result_msg').html("系统繁忙！请稍后再试...");
		$("#confirm_back").show();
		$("#result_window").fadeIn(600);
		$(".tipsWinCnt").show();
}
function showResultWindow(){
	$("#result_window").fadeIn(1000);
	$('#select_act_window').hide();
	$("#result_window").fadeOut(1000);
	$(".tipsWinCnt").show();
}
//审批意见输入监听
document.getElementById("textarea-a").onkeydown = function(event_e){
	if( window.event )
	event_e = window.event;
	var int_keycode = event_e.charCode||event_e.keyCode;
	var length = document.getElementById("textarea-a").value.length;
	var obj = document.getElementById("textarea-a");
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

$('#textarea-a').bind('input propertychange', function(event) {
    $("#textarea-a").parent().css("border-color","#aaa");
    	var length1 = event.srcElement.value.length;
    	if(length1 <= length0){
    		var length2 = length0-length1;
        	$("#textareaNum").text((length2));
    	}
    	if($(this).val().length >300){
			$(this).val(this.value.substring(0,300));		
		}
});

/**
* 审批完成之后 处理页面提示
*/
function approvResult(){
	$("#result_window").hide(1000);
	$("#confirm_cancel").hide(1000);
	window.location.replace("<%=basePathBut%>/toWorkItemsList?timestamp=" + new Date().getTime());
}
/**
 *审批失败之后操作 
 */
function approveFault(){
	$("#result_window").fadeOut(1000);
	$("#confirm_back").fadeOut(1000);
	$(".tipsWinCnt").fadeOut(1000);
}
//审批意见字数超过300无法继续输入

var html = "";
function queryActivity(){
	var str = $('#textarea-a').val();
	if(str == "" ){ //回退时审批意见为空判断
		$("#textarea-a").focus();
		$("#textarea-a").parent().css("border-color","#f00");
		return;
	}
	if ( "" != html ){ //判断是否已获取数据，阻止重复请求
		$("#select_act_window").fadeIn(600);
		$(".tipsWinCnt").show();
		return;
	}
	$(".tipsWinCnt").show();
	$(".loading").show();
// 	appTimeout(time);
	var workid = $("#workid").html();
	var actionUrl = $("#dwfs_back_array_url").val();
	var processinstid=$("#processinstid").val();
	var workItemId=$("#workItemId").val();
	$.ajax({
	   type: "GET",
	   url: "<%=basePathBut%>/DWFSHttpClient",
	   data: "processinstid="+processinstid+"&workItemId="+workItemId+"&actionUrl="+actionUrl+"&timestamp="+new Date().getTime(),
	   dataType: "json",
	   cache:false,
	   success: function(msg){
// 		   clearTimeout(t);
			$(".loading").hide();
		 if(msg != null){
			 var flag = true;
			 var obj = eval(msg);
			 $(obj).each(function(index){
				 var val = obj[index];
				 if("failure" == val.name){
					 $('#result_msg').html("查询回退节点失败!<br/>请稍后再试...");
// 					 $("#confirm_back").show();
					//审批失败之后  提示框操作
		   			showResultWindow();
		   			setTimeout(function(){approveFault();},2000);
					return flag = false;
				 }
				 var num = index+1;
				 html+="<p><input type=\"radio\" name=\"radio-choice\" id=\"radio-choice-"+num+"\"value=\""+val.nextActivity.activityDefId+"\" checked=\"checked\" />"+
						 "<label for=\"radio-choice-"+num+"\">"+val.nextActivity.activityName+"</label>"+
						 "<input type=\"hidden\"  id=\"val-"+val.nextActivity.activityDefId+"\"value=\""+val.nextActivity.activityName+"\"/></p>";
			 });
			 if(flag){
				 $('#select_act_val').html(html);
				 $('#select_act_window').trigger("create");
				 $("#select_act_window").fadeIn(600);
				 $(".tipsWinCnt").show();
			 }
	   	 }else{
	   		 $('#result_msg').html("查询回退节点失败!<br/>请稍后再试...");
	   		 $("#confirm_back").show();
			//审批失败之后  提示框操作
		   	showResultWindow();
		   	setTimeout(function(){approveFault();},2000);
	   	 }
	   }
	});
}

/**
 * DWFS门户二期项目工作流回退操作
 */
function rollBackWorkFlow(){
	//获取回退工作项活动定义ID
	var nextActitvityID = $('input[name="radio-choice"]:checked').val();
	//当前工作项ID
	var workItemId = $("#workItemId").val();
	//当前活动定义ID
	var activitydefid = $("#activitydefid").val();
	//当前活动实例ID
	var activityinstid = $("#activityinstid").val();
	//回退意见
	var str = $('#textarea-a').val();
	var approvever = encodeURIComponent(encodeURIComponent(str)).replace(/%20/g, "+");
	var processinstid;
	//工作流号
	if(typeof($("#workid").html())!='undefined'){
		 processinstid = $("#workid").html();
	}else{
		 processinstid = $("#processinstid").val();
	}
	
	//门户二期执行回退操作 url
	var actionUrl = $("#dwfs_roll_back_url").val();
	$(".tipsWinCnt").show();
	$(".loading").show();
	$.ajax({
	   type: "GET",
	   url: "<%=basePathBut%>/DWFSHttpClient",
	   //参数：processinstid工作流号，nextActitvityID获取回退工作项活动定义ID  approvever回退意见   timestamp当前日期   --当前工作项ID  当前活动定义ID  当前活动实例号
	   data : "approvelEntity.processinstid=" + processinstid + "&nextActitvityID=" + nextActitvityID + 
	   "&approvelEntity.approveOpinion=" + approvever + "&timestamp=" + new Date().getTime()+
	   "&approvelEntity.workItemId=" + workItemId + "&approvelEntity.activityDefId=" + activitydefid +"&approvelEntity.activityinstid=" + activityinstid +
	   "&actionUrl=" +  actionUrl,
	   cache:false,
			success : function(msg) {
// 				clearTimeout(t);
				$(".loading").hide();
				$(".tipsWinCnt").show();
				if ('true' == msg) {
					$("#result_msg").html("回退成功！");
// 					$("#confirm_cancel").show();
					showResultWindow();
					setTimeout(function(){approvResult();},2000);
				} else {
					var errormsg = eval(msg);
					$("#result_msg").html(errormsg[0].failReason);
// 					$("#confirm_back").show();
					showResultWindow();
					setTimeout(function(){approveFault();},2000);
				}
			}
		});
	}
function approve(isAgree) {
	$(".tipsWinCnt").show();
	var str = $('#textarea-a').val();
	var approvever = encodeURIComponent(encodeURIComponent(str)).replace(/%20/g, "+");
	var workid = $("#processinstid").val();
	var workItemId = $('#workItemId').val();
	var activityDefId = $('#activitydefid').val();
	var approvalUrl = $('#dwfs_approval_url').val();
	var approval_url = $('#approval_url').val();
	var activityinstid = $('#activityinstid').val();
	var flowType = $("#flowtype").val();
	var busiNo = $("#busino").val();
	//新部门成立特殊审批 选择流向
	var selectFlow = $("#selectFlow").val();
	var applyFlow = $("#applyFlow").val();
	
	var data;
	if(flowType == '<%=F_Constants.DWFS_NEW_DEPT_APPLY%>'){
		data  =    "approvelEntity.processinstid=" + workid + "&approvelEntity.workItemId=" + workItemId +"&approvelEntity.activityDefId=" + activityDefId +"&approvelEntity.activityinstid="+activityinstid+"&approvelEntity.isAgree="+isAgree
	   	+ "&approvelEntity.approveOpinion=" + approvever + "&actionUrl=" + approvalUrl+approval_url + "&bizEntity.applyFlow=" + applyFlow + "&bizEntity.applyReflow=" + selectFlow + "&bizEntity.processinstid=" + workid;
	}else if(flowType == '<%=F_Constants.DWFS_SITERENT%>') {
		data = "approvelEntity.processinstid=" + workid + "&approvelEntity.workItemId=" + workItemId +"&approvelEntity.activityDefId=" + activityDefId +"&approvelEntity.activityinstid="+activityinstid+"&approvelEntity.isAgree="+isAgree
	   	+ "&approvelEntity.approveOpinion=" + approvever + "&actionUrl=" + approvalUrl+approval_url + "&busino=" + busiNo;
	}else if(flowType == '<%=F_Constants.DWFS_PROBLEMFEEDBACKBEAN%>'){
		//一线问题反馈
		if("manualActivity3" == activityDefId){
			data = "approvelEntity.processinstid=" + workid + "&approvelEntity.workItemId=" + workItemId +"&approvelEntity.activityDefId=" + activityDefId +"&approvelEntity.activityinstid="+activityinstid+"&approvelEntity.isAgree="+isAgree
		   	+ "&approvelEntity.approveOpinion=" + approvever + "&actionUrl=" + approvalUrl+approval_url + "&busino=" + busiNo+"&processDefName="+flowType +"&bizEntity.busino="+busiNo+
			"&bizEntity.processinstid="+workid+"&bizEntity.responsibDepart="+ $("#responsibDepart").val()+"&bizEntityName="+'<%=F_Constants.PROBLEM_BEAN%>';
		}else if("manualActivity4" == activityDefId){
			if($("#submit_Flag").val()== "true"){
				$('#result_msg').html("请输入正确格式的时间，yyyy-MM-dd");
				$("#confirm_back").show();
		   		$("#result_window").fadeIn(600);
		   		$(".tipsWinCnt").show();
				return;
			}
			data = "approvelEntity.processinstid=" + workid + "&approvelEntity.workItemId=" + workItemId +"&approvelEntity.activityDefId=" + activityDefId +"&approvelEntity.activityinstid="+activityinstid+"&approvelEntity.isAgree="+isAgree
		   	+ "&approvelEntity.approveOpinion=" + approvever + "&actionUrl=" + approvalUrl+approval_url + "&busino=" + busiNo+"&processDefName="+flowType +"&bizEntity.busino="+busiNo+
			"&bizEntity.processinstid="+workid+"&bizEntity.completeDate="+ $("#completeDate").val()+"&bizEntityName="+'<%=F_Constants.PROBLEM_BEAN%>';
		}else if("manualActivity5" == activityDefId){
			if($("#submit_Flag").val()== "false"){
				$('#result_msg').html("请输入0-100的正整数");
				$("#confirm_back").show();
		   		$("#result_window").fadeIn(600);
		   		$(".tipsWinCnt").show();
				return;
			}
			data = "approvelEntity.processinstid=" + workid + "&approvelEntity.workItemId=" + workItemId +"&approvelEntity.activityDefId=" + activityDefId +"&approvelEntity.activityinstid="+activityinstid+"&approvelEntity.isAgree="+isAgree
		   	+ "&approvelEntity.approveOpinion=" + approvever + "&actionUrl=" + approvalUrl+approval_url + "&busino=" + busiNo+"&processDefName="+flowType +"&bizEntity.busino="+busiNo+
			"&bizEntity.processinstid="+workid+"&bizEntity.satisfaction="+ $("#satisfaction").val()+"&bizEntityName="+'<%=F_Constants.PROBLEM_BEAN%>';
		}else{
			data = "approvelEntity.processinstid=" + workid + "&approvelEntity.workItemId=" + workItemId +"&approvelEntity.activityDefId=" + activityDefId +"&approvelEntity.activityinstid="+activityinstid+"&approvelEntity.isAgree="+isAgree
		   	+ "&approvelEntity.approveOpinion=" + approvever + "&actionUrl=" + approvalUrl+approval_url;
		}
	}else if($("#flowtype").val() == '<%=F_Constants.DWFS_BANK_ACCOUNT%>') {
		if (activityDefId == "manualActivity3") {
			var bankAccount = $('#manualActivity3bankAccount').val();
			var openAccountBranch = $('#manualActivity3openAccountBranch').val();
			if ("0" == isAgree) {
				if(bankAccount== ""){
					$('#result_msg').html("请填写银行账号");
					$("#confirm_back").show();
			   		$("#result_window").fadeIn(600);
			   		$(".tipsWinCnt").show();
					return;
				}
				if(openAccountBranch== ""){
					$('#result_msg').html("请填写开户支行");
					$("#confirm_back").show();
			   		$("#result_window").fadeIn(600);
			   		$(".tipsWinCnt").show();
					return;
				}
			}
			var approval_url_special = $("#approval_url_special").val();
			data  = "approvelEntity.processinstid=" + workid + "&approvelEntity.workItemId=" + workItemId +"&approvelEntity.activityDefId=" + activityDefId +"&approvelEntity.activityinstid="+activityinstid+"&approvelEntity.isAgree="+isAgree
		   	+ "&approvelEntity.approveOpinion=" + approvever + "&actionUrl=" + approvalUrl + approval_url_special + "&bizEntity.busino="+busiNo+"&busino=" + busiNo + "&bizEntity.bankAccountApproval=" + bankAccount + "&bizEntity.openAccountBranch=" + openAccountBranch + "&bizEntityName=" + '<%=F_Constants.BANK_ACCOUNT_BEAN%>' + "&bizEntity.processinstid=" + workid;

		}else {
			data = "approvelEntity.processinstid=" + workid + "&approvelEntity.workItemId=" + workItemId +"&approvelEntity.activityDefId=" + activityDefId +"&approvelEntity.activityinstid="+activityinstid+"&approvelEntity.isAgree="+isAgree
		   	+ "&approvelEntity.approveOpinion=" + approvever + "&actionUrl=" + approvalUrl + approval_url;
		}
	}else if(flowType == '<%=F_Constants.DWFS_QUALI_FICATION_APPLY%>'){
		//中级
		if($('#applyType').val()== 3){
			//中级直接上级
			if(activityDefId == "immediateSuperior"){
				var abInfo = $("#abInfo").find("select");
				var abId = $("#abInfo").find("input");
				var skInfo = $("#skInfo").find("select");
				var skId = $("#skInfo").find("input");
				var enhancedSide1 = $("#textarea-b").val();
				//解决两个主观评价乱码问题
				var enhancedSide = encodeURIComponent(encodeURIComponent(enhancedSide1)).replace(/%20/g, "+");
				var excellentSide1 = $("#textarea-c").val();
				var excellentSide = encodeURIComponent(encodeURIComponent(excellentSide1)).replace(/%20/g, "+");
				var abStr = "";
				var abIdStr = "";
				var skStr = "";
				var skIdStr = "";
				//----------------------------------------------------------------------------------------------
				//通用能力
				for(var i =0 ;i<abInfo.length;i++){
					//获取分数
					abStr +="bizEntity.qualificationapplyList"+"["+i+"]"+".score="+ abInfo[i].value+"&";
					//获取表主键，用户update
					abIdStr +="bizEntity.qualificationapplyList"+"["+i+"]"+".tableid="+ abId[i].value+"&";
				
//	 				id='1'
//	 					var objs = $("#1").find("input[type=hidden]");///xunhuan xialakuang
//	 					var str = "";
//	 					entity.list[0].name=
//	 					for (var i=0;i<objs.length;i++) {
//	 						str += "entity.list[0].name=" + objsp[i]

//	 					}
				}
				//业务技能
				for(var i =0 ;i<skInfo.length;i++){
					
					//获取分数
					skStr +="bizEntity.qualificationapplySkillList"+"["+i+"]"+".score="+ skInfo[i].value+"&";
					//获取表主键，用户update
					skIdStr +="bizEntity.qualificationapplySkillList"+"["+i+"]"+".tableid="+ skId[i].value +"&";
				}
				var selects = $("#abInfo").find("select");
				for(var i = 0; i<selects.length;i++){
					if($(selects[i]).val() == '000'){
						$('#result_msg').html("请对能力进行评分");
						$("#confirm_back").show();
				   		$("#result_window").fadeIn(600);
				   		$(".tipsWinCnt").show();
						$(selects[i]).removeClass(".abScore");
						$(selects[i]).addClass(".unabScore");
						return;
					}
				}
				if(enhancedSide==''){
					$('#result_msg').html("请填写表现优秀方面");
					$("#confirm_back").show();
			   		$("#result_window").fadeIn(600);
			   		$(".tipsWinCnt").show();
					return;
				}
				if(excellentSide==''){	
					$('#result_msg').html("请填写有待提升方面");
					$("#confirm_back").show();
			   		$("#result_window").fadeIn(600);
			   		$(".tipsWinCnt").show();
					return;
				}

				data  =    "approvelEntity.processinstid=" + workid + "&approvelEntity.workItemId=" + workItemId +"&approvelEntity.activityDefId=" + activityDefId +"&approvelEntity.activityinstid="+activityinstid+"&approvelEntity.isAgree="+isAgree
			    + "&actionUrl=" + approvalUrl+approval_url  + "&" + abStr +  abIdStr +  skStr  + skIdStr +  "approvelEntity.approveOpinion=" + approvever + "&bizEntity.enhancedSide=" + enhancedSide + "&bizEntity.excellentSide=" +excellentSide+ "&bizEntity.busino="+busiNo + "&bizEntity.processinstid=" + workid ;
			}
			//中级直接上级的上级
				if(activityDefId == "manualActivity"){
					var isPassButton=$("#isPass").is(":checked");
					var isunPassButton = $("#isunPass").is(":checked");
					var isPass = 1 ;
					if(isPassButton){
						isPass = 1;
					}else if(isunPassButton){
						isPass = 0;
					}
					data  =    "approvelEntity.processinstid=" + workid + "&approvelEntity.workItemId=" + workItemId +"&approvelEntity.activityDefId=" + activityDefId +"&approvelEntity.activityinstid="+activityinstid+"&approvelEntity.isAgree="+isAgree
				   	+ "&approvelEntity.approveOpinion=" + approvever + "&actionUrl=" + approvalUrl+approval_url  + "&bizEntity.isPass=" + isPass + "&bizEntityName=" + '<%=F_Constants.DWFS_QUALI_FICATION_BEAN%>' + "&bizEntity.processinstid=" + workid 
				   	+ "&bizEntity.busino="+busiNo;
				}
		
		}else{
			data = "approvelEntity.processinstid=" + workid + "&approvelEntity.workItemId=" + workItemId +"&approvelEntity.activityDefId=" + activityDefId +"&approvelEntity.activityinstid="+activityinstid+"&approvelEntity.isAgree="+isAgree
		   	+ "&approvelEntity.approveOpinion=" + approvever + "&actionUrl=" + approvalUrl+approval_url;
		}
		
	}else if ($("#flowtype").val() == '<%=F_Constants.DWFS_SYSTEMDATACHANGEAPPLY%>') {
		
		if (activityDefId == "manualActivity2") {//系统版本负责人节点
			var approval_url_special = $("#approval_url_special").val();
			/* var bankAccount = $('#manualActivity3bankAccount').val();
			var openAccountBranch = $('#manualActivity3openAccountBranch').val(); */
			if ("0" == isAgree) {
				var flag3 = validate();
				if (!flag3) return;
			}
			var isMyselfSystem = $("#isMyselfSystem").get(0).getValue();
			var systemName = encodeURIComponent(encodeURIComponent($("#correspondingSystemID").get(0).getLabel())).replace(/%20/g, "+");
			var systemValue = $("#correspondingSystemID").get(0).getValue();
			var developDeptCode = $("#searchId").get(0).getValue();
			var developDeptName = encodeURIComponent(encodeURIComponent($("#searchId").get(0).getLabel())).replace(/%20/g, "+");
			data  = "approvelEntity.processinstid=" + workid + "&approvelEntity.workItemId=" + workItemId +"&approvelEntity.activityDefId=" + activityDefId +"&approvelEntity.activityinstid="+activityinstid+"&approvelEntity.isAgree="+isAgree
		   	+ "&approvelEntity.approveOpinion=" + approvever + "&actionUrl=" + approvalUrl + approval_url_special + "&bizEntity.busino="+busiNo + "&bizEntityName=" + '<%=F_Constants.DWFS_SYSTEMDATACHANGEAPPLY_BEAN%>' + "&processDefName=" + '<%=F_Constants.DWFS_SYSTEMDATACHANGEAPPLY%>'  + "&bizEntity.processinstid=" + workid
		    + "&bizEntity.referSystem=" + isMyselfSystem 
		    + "&bizEntity.correspondingSystem=" + systemValue + "&bizEntity.correspondingSystemName=" + systemName
		    + "&bizEntity.developmentTeamCode=" + developDeptCode + "&bizEntity.developmentTeamName=" + developDeptName;
		}else if (activityDefId == "manualActivity4") {//首个系统开发组负责人节点
			var approval_url_special = $("#approval_url_special").val();
			/* var bankAccount = $('#manualActivity3bankAccount').val();
			var openAccountBranch = $('#manualActivity3openAccountBranch').val(); */
			if ("0" == isAgree) {
				var flag3 = validate();
				if (!flag3) return;
			}
			var developEmpCode = $("#searchId").get(0).getValue();
			var developEmpName = encodeURIComponent(encodeURIComponent($("#searchId").get(0).getLabel())).replace(/%20/g, "+");
			data  = "approvelEntity.processinstid=" + workid + "&approvelEntity.workItemId=" + workItemId +"&approvelEntity.activityDefId=" + activityDefId +"&approvelEntity.activityinstid="+activityinstid+"&approvelEntity.isAgree="+isAgree
		   	+ "&approvelEntity.approveOpinion=" + approvever + "&actionUrl=" + approvalUrl + approval_url_special + "&bizEntity.busino="+busiNo+"&busino=" + busiNo + "&bizEntityName=" + '<%=F_Constants.DWFS_SYSTEMDATACHANGEAPPLY_BEAN%>' + "&bizEntity.processinstid=" + workid
		    + "&bizEntity.developersName=" + developEmpName + "&bizEntity.developersId=" + developEmpCode;
		}else if (activityDefId == "manualActivity3") {//对应系统高版本负责人节点
			var approval_url_special = $("#approval_url_special").val();
			/* var bankAccount = $('#manualActivity3bankAccount').val();
			var openAccountBranch = $('#manualActivity3openAccountBranch').val(); */
			if ("0" == isAgree) {
				var flag3 = validate();
				if (!flag3) return;
			}
			var developDeptCode = $("#searchId").get(0).getValue();
			var developDeptName = encodeURIComponent(encodeURIComponent($("#searchId").get(0).getLabel())).replace(/%20/g, "+");
			data  = "approvelEntity.processinstid=" + workid + "&approvelEntity.workItemId=" + workItemId +"&approvelEntity.activityDefId=" + activityDefId +"&approvelEntity.activityinstid="+activityinstid+"&approvelEntity.isAgree="+isAgree
		   	+ "&approvelEntity.approveOpinion=" + approvever + "&actionUrl=" + approvalUrl + approval_url_special + "&bizEntity.busino="+busiNo+"&busino=" + busiNo + "&bizEntityName=" + '<%=F_Constants.DWFS_SYSTEMDATACHANGEAPPLY_BEAN%>' + "&bizEntity.processinstid=" + workid
		    + "&bizEntity.developmentTeamCode=" + developDeptCode + "&bizEntity.developmentTeamName=" + developDeptName;
		}else {
			data = "approvelEntity.processinstid=" + workid + "&approvelEntity.workItemId=" + workItemId +"&approvelEntity.activityDefId=" + activityDefId +"&approvelEntity.activityinstid="+activityinstid+"&approvelEntity.isAgree="+isAgree
		   	+ "&approvelEntity.approveOpinion=" + approvever + "&actionUrl=" + approvalUrl + approval_url;
		}
	}else if(flowType == '<%=F_Constants.DWFS_ONLINEAPPLY%>'){
		//提交校验文本框是否输入正确
		if(!isValid() || !validate()){
			return;	
		}
// 		$('#result_msg').html("审批成功！");
// 	    $("#confirm_cancel").show();
// 	    $("#result_window").fadeIn(600);
// 	    $(".tipsWinCnt").show();
// 		return;
		//开线申请特殊审批
		if("manualActivity221" == activityDefId){
			var deptValue = $("#searchId").get(0).getValue();//隐藏域
// 			var deptLabel = $("#searchId").get(0).getLabel();//展示值bizEntity.carGroupCode
			var deptLabel = encodeURIComponent(encodeURIComponent($("#searchId").get(0).getLabel())).replace(/%20/g, "+");
			//运力管理组负责人
			data = "approvelEntity.processinstid=" + workid + "&approvelEntity.workItemId=" + workItemId +"&approvelEntity.activityDefId=" + activityDefId +"&approvelEntity.activityinstid="+activityinstid+"&approvelEntity.isAgree="+isAgree
		   	+ "&approvelEntity.approveOpinion=" + approvever + "&actionUrl=" + approvalUrl+approval_url + "&busino=" + busiNo+"&processDefName="+flowType +"&bizEntity.busino="+busiNo+
			"&bizEntity.processinstid="+workid+"&bizEntity.carHeadNum="+ $("#carHeadNum").val()+"&bizEntity.containerNumActual="+$("#containerNumActual").val()+"&bizEntity.carGroupCode="+deptValue+"&bizEntity.carGroup="+deptLabel+"&bizEntityName="+'<%=F_Constants.ONLINE_BEAN%>';
			
		}else if("manualActivity22" == activityDefId){
			//运输规划组审批界面
			data = "approvelEntity.processinstid=" + workid + "&approvelEntity.workItemId=" + workItemId +"&approvelEntity.activityDefId=" + activityDefId +"&approvelEntity.activityinstid="+activityinstid+"&approvelEntity.isAgree="+isAgree
		   	+ "&approvelEntity.approveOpinion=" + approvever + "&actionUrl=" + approvalUrl+approval_url + "&busino=" + busiNo+"&processDefName="+flowType +"&bizEntity.busino="+busiNo+
			"&bizEntity.processinstid="+workid+"&bizEntity.carNum="+ $("#carNum").val()+"&bizEntity.containerNumNeed="+ $("#containerNumNeed").val()+"&bizEntityName="+'<%=F_Constants.ONLINE_BEAN%>';
		}else if("manualActivity311" == activityDefId){
			//时效节点组负责人审批界面
			data = "approvelEntity.processinstid=" + workid + "&approvelEntity.workItemId=" + workItemId +"&approvelEntity.activityDefId=" + activityDefId +"&approvelEntity.activityinstid="+activityinstid+"&approvelEntity.isAgree="+isAgree
		   	+ "&approvelEntity.approveOpinion=" + approvever + "&actionUrl=" + approvalUrl+approval_url + "&busino=" + busiNo+"&processDefName="+flowType +"&bizEntity.busino="+busiNo+
			"&bizEntity.processinstid="+workid+"&bizEntity.outTime="+ $("#outTime").val()+"&bizEntity.inTime="+ $("#inTime").val()+"&bizEntity.backInTime="+ $("#backInTime").val()+
			"&bizEntity.backOutTime="+ $("#backOutTime").val()+"&bizEntityName="+'<%=F_Constants.ONLINE_BEAN%>';
		}else{
			data = "approvelEntity.processinstid=" + workid + "&approvelEntity.workItemId=" + workItemId +"&approvelEntity.activityDefId=" + activityDefId +"&approvelEntity.activityinstid="+activityinstid+"&approvelEntity.isAgree="+isAgree
		   	+ "&approvelEntity.approveOpinion=" + approvever + "&actionUrl=" + approvalUrl+approval_url;
		}
	}else if(flowType == '<%= F_Constants.DWFS_COURTRELOCATION %>'){
		//场地搬迁资源协调
		data = "approvelEntity.processinstid=" + workid + "&approvelEntity.workItemId=" + workItemId +"&approvelEntity.activityDefId="
		+ activityDefId +"&approvelEntity.activityinstid="+activityinstid+"&approvelEntity.isAgree="+isAgree
	   	+ "&approvelEntity.approveOpinion=" + approvever + "&processDefName=" + flowType
	   	+ "&bizEntity.busino="+busiNo + "&bizEntity.processinstid=" + workid + "&bizEntityName=" + '<%=F_Constants.COURTRELOCATION_BEAN%>'
	   	+ "&actionUrl=" + approvalUrl+approval_url;
	   	
		if("manualActivity3" == activityDefId) {
			//场地租赁/转租合同工作流号:  搬迁日期确定—— 场地租赁组负责人节点 manualActivity3
// 			if(!isValid()) {
// 				return;	
// 			}
			if(isAgree == '0'){
//	 			var checkFlag = checkProcessinstid("contractProcessinstid");
				var processinstiD = $("#contractProcessinstid").val(); 
				var checkFlag = $("#processinstIDFlag").val();
				if(processinstiD == null || processinstiD == "" || checkFlag == "false" || checkFlag == ""){
					$(".tipsWinCnt").hide();
					$("#contractProcessinstid").css("border-color","rgb(255, 0, 0)");
					alert("场地工作流号为必填项，且工作流应为已同意状态");
					return;
				}
			}
			data = data + "&bizEntity.contractProcessinstid=" + $("#contractProcessinstid").val();
		}else if("manualActivity5" == activityDefId || "manualActivity11" == activityDefId){
			//搬迁日期:搬迁日期确定—— 事业部总裁节点 manualActivity5
			//搬迁日期:目的站货区排布—— 事业部总裁节点 manualActivity11
			if(!validate()) {
				return;	
			}
			data = data + "&bizEntity.relocationDate=" + $("#relocationDate").get(0).getValue();
		}
	}else if(flowType == '<%=F_Constants.DWFS_EXPNEWPILOTOUTLETS%>'){
		//提交校验文本框是否输入正确
		if(!validate()){
			return;	
		}
		//快递新增试点网点申请特殊审批
		if("manualActivity9" == activityDefId){
			var deptOpeningTime = $("#deptOpeningTime").get(0).getValue();//隐藏域
			data = "approvelEntity.processinstid=" + workid + "&approvelEntity.workItemId=" + workItemId +"&approvelEntity.activityDefId=" + activityDefId +"&approvelEntity.activityinstid="+activityinstid+"&approvelEntity.isAgree="+isAgree
		   	+ "&approvelEntity.approveOpinion=" + approvever + "&actionUrl=" + approvalUrl+approval_url + "&busino=" + busiNo+"&processDefName="+flowType +"&bizEntity.busino="+busiNo+
			"&bizEntity.processinstid="+workid+"&expressNewPilot.deptOpeningTime="+ deptOpeningTime +"&bizEntityName="+'<%=F_Constants.EXPNEWPILOTOUTLETS_BEAN%>';
		}else{
			data = "approvelEntity.processinstid=" + workid + "&approvelEntity.workItemId=" + workItemId +"&approvelEntity.activityDefId=" + activityDefId +"&approvelEntity.activityinstid="+activityinstid+"&approvelEntity.isAgree="+isAgree
		   	+ "&approvelEntity.approveOpinion=" + approvever + "&actionUrl=" + approvalUrl+approval_url;
		}
	}else {
			data = "approvelEntity.processinstid=" + workid + "&approvelEntity.workItemId=" + workItemId +"&approvelEntity.activityDefId=" + activityDefId +"&approvelEntity.activityinstid="+activityinstid+"&approvelEntity.isAgree="+isAgree
		   	+ "&approvelEntity.approveOpinion=" + approvever + "&actionUrl=" + approvalUrl + approval_url;
	}
	$(".loading").show();
// 	appTimeout(time);
	$.ajax({
		type : "GET",
		url : "<%=basePathBut%>/DWFSHttpClient",
	   	data: data,
		cache:false,	   
	   	success: function(msg){
	   		$(".loading").hide();
	   		var result = msg;
		   if( result.indexOf("true")>= 0){
					    $('#result_msg').html("审批成功！");
// 					    $("#confirm_cancel").show();
					    $("#result_window").fadeIn(600);
					    $("#result_window").fadeOut("slow");
					    $(".tipsWinCnt").show();
// 					  //审批完成之后 处理页面提示框
						setTimeout(function(){approvResult();},2000);
					    
		   	 } else {
				   		$('#result_msg').html("系统繁忙！请稍后再试...");
// 				   		$("#confirm_back").show();
				   		$("#result_window").fadeIn(600);
				   		$("#result_window").fadeOut(2000);
				   		$(".tipsWinCnt").show();
						//审批失败之后  提示框操作
					  	setTimeout(function(){approveFault();},2000);
		   	 }
	   },
	   error:function () {
		   	$(".loading").hide();
		  	$('#result_msg').html("系统繁忙！请稍后再试...");
// 		    $("#confirm_cancel").show();
		    $("#result_window").fadeIn(600);
	   		$("#result_window").fadeOut(2000);
	   		$(".tipsWinCnt").show();
			//审批失败之后  提示框操作
		  	setTimeout(function(){approveFault();},2000);
	   }
});
}
	//处理记录信息
	var appmsg = "";
	//自动加载处理记录 获取历史审批记录
	function autoShowApproval(){
		if(appmsg != ""){
			$("#qytr").hide();
			$("table").find(".sh").show();
			return;
		}
		var processInstId = $("#processinstid").val();
		var actionUrl = $("#dwfs_approval_list").val();
		$.ajax({
		   type: "GET",
		   url: "<%=basePathBut%>/DWFSHttpClient",
		   data: "processInstId="+processInstId+"&actionUrl=" + actionUrl,
		   cache:false,	   
		   success: function(msg){
			   var obj = eval(msg);
			   var html = "";
			   for(var i = 0 ; i<obj.length; i++) {
				   if(obj[i].isagree=='0'){
						obj[i].isagree = '同意';
					}else if(obj[i].isagree=='1'){
						obj[i].isagree = '不同意';
					}else if(obj[i].isagree=='2'){
						obj[i].isagree = '起草流程';
					}else if(obj[i].isagree=='4'){
						obj[i].isagree = '退回';
					} else if (obj[i].isagree=='5'){
						obj[i].isagree = '同意并结束';
					} else if (obj[i].isagree=='6'){
						obj[i].isagree = '收回';
					} else if (obj[i].isagree=='9'){
						obj[i].isagree = '业务回退';
					}
					if(obj[i].approvever==null||obj[i].approvever==""){
						obj[i].approvever = "";
					}
					if(obj[i].duty==null||obj[i].duty=="") {
						obj[i].duty = "";
					}
					obj[i].approvedate = (obj[i].approvedate).substring(0,10) + " " +(obj[i].approvedate).substring(11,16);
					html += "<tr class='topLine sh'><th>处理时间</th><td>" + obj[i].approvedate + "</td></tr>";
					html +="<tr class='sh'><th>处理人</th><td>"+obj[i].approver+"</td></tr>";
					html +="<tr class='sh'><th>处理结果</th><td>"+obj[i].isagree+"</td></tr>";
					html +="<tr class='sh'><th>处理意见</th><td>"+obj[i].approvever+"</td></tr>";
					html +="<tr class='sh'><th>权责</th><td>"+obj[i].duty+"</td></tr>";
			   }
			   appmsg = html;
			   $("#qytr").after(appmsg);
			   if(msg != '' && $("#qytr").is(":visible")){
				   $("#qytr").hide();
				   $("table").find(".sh").show();
			   }
		   }
		});
	}
	//点击处理记录
	function showApproval(){
		if(appmsg != ""){
			$("table").find(".sh").show();
			return;
		}
		$("#qytr").show();
	}
	
	//图片缓加载
	window.onload = function(){
		$(".return").find("img").attr("src","<%=pathBut%>/imgnews/win8/list_return_btn.png");
		$(".logo").find("img").attr("src","<%=pathBut%>/imgnews/win8/list_logo.png");
	}
</script>
<script defer="defer">
//自动加载处理记录
	setTimeout(autoShowApproval,100);
//-->
</script>
<!-- 获取历史审批记录url -->
<input type="hidden" id="dwfs_approval_list" value="<%=DWFSWorkItemServiceClient.DWFS_APPROVAL_LIST_URL%>">
<!-- 获取回退列表url -->
<input type="hidden" id="dwfs_back_array_url" value="<%=DWFSWorkItemServiceClient.DWFS_GETBACKARRAY_URL%>">
<!-- 回退操作url -->
<input type="hidden" id="dwfs_roll_back_url" value="<%=DWFSWorkItemServiceClient.DWFS_ROLL_BACK_URL%>">
<!-- 审批操作url -->
<input type="hidden" id="dwfs_approval_url" value="<%=DWFSWorkItemServiceClient.DWFS_APPROVAL_URL%>">
<!-- 工作流实例ID -->
<input type="hidden" id="processinstid" value="<%=request.getAttribute("processinstid")%>">
<!-- 工作项ID -->
<input type="hidden" id="workItemId" value="<%=request.getAttribute("workItemId")%>">
<!-- 当前节点定义ID -->
<input type="hidden" id="activitydefid" value="<%=request.getAttribute("activitydefid")%>">
<!-- 活动实例ID -->
<input type="hidden" id="activityinstid" value="<%=request.getAttribute("activityinstid")%>">
<!-- 流程定义名称 -->
<input type="hidden" id="flowtype" value="<%=request.getAttribute("flowType")%>">
<!-- busino -->
<input type="hidden" id="busino" value="<%=request.getAttribute("busino")%>">
<div id="div3">
    	<span class="btn" id="disagree_but">不同意</span>
    	<span class="btn" id="agree_but">同&nbsp;&nbsp;意</span>
    	<%
		    String rollBackType = (String) request.getAttribute("rollBackType");
					if (F_Constants.ROLLBAIK_SHOW.equals(rollBackType)) {
		%>
    	<span class="btn" id="rollback_but">回&nbsp;&nbsp;退</span>
    	<%
		    }
		%>
    </div>
<div class="tipsWinCnt" style="display: none;">
	<div class="tipsWin" id="app_window" style="display: none;">
		<input type="hidden" id="app_val">
		<h4>提示</h4>
		<div class="content" id="confirm_msg"></div>
		<div class="btnBox">
			<span class="btn cancel" id="btnCancel">取消</span> 
			<span class="btn confirm" id="btnConfirm">确定</span>
		</div>
	</div>
	<div class="tipsWin list" id="select_act_window" style="display: none;">
		<h4>提示</h4>
		<h5>请选择回退环节</h5>
		<div class="content" id="select_act_val">
		</div>
		<div class="btnBox">
			<span class="btn cancel" id="select_act_cancel">取消</span> 
			<span class="btn confirm" id="select_act_confirm">确定</span>
		</div>
	</div>
	<div class="tipsWin" id="activity_window" style="display: none;">
		<h4>提示</h4>
		<div class="content" id="activity_val"></div>
		<div class="btnBox">
			<span class="btn cancel" id="activity_cancel">取消</span> 
			<span class="btn confirm" id="activity_confirm">确定</span>
		</div>
	</div>
	<div class="tipsWin" id="result_window" style="display: none;">
		<h4>提示</h4>
		<div class="content" id="result_msg"></div>
		<div class="btnBox">
			<span class="btn cancel" id="confirm_back" style="display: none;">确定</span>
			<span class="btn confirm" id="confirm_cancel" style="display: none;">确定</span>
		</div>
	</div>
	<div class="loading" style="display:none;"><img src="<%=basePathBut%>/css/images/loading.gif" /></div>
	<div class="shadowBg" id="shadowBg"></div>
</div>
