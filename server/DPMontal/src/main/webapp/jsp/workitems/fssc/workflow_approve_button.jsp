<%@page import="com.deppon.fssc.module.remote.mobile.shared.MobileBranchRule"%>
<%@page import="com.deppon.fssc.module.claimsupport.shared.vo.WfParamVo"%>
<%@page import="com.deppon.montal.conf.F_Constants"%>
<%@page import="com.deppon.montal.model.WfActivityInst"%>
<%@page import="com.deppon.montal.util.InitDataServlet" %>
<%@page import="java.util.List"%>
<%@ page language="java"  pageEncoding="UTF-8"%>
<%
    String pathBut = request.getContextPath();
			String basePathBut = InitDataServlet.getValue("dpm_domain_url") + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ pathBut;
	WfParamVo wfParamVo = (WfParamVo)request.getAttribute("wfParamVo");
	 String rollBackType = (String) request.getAttribute("rollBackType");//是否回退
	MobileBranchRule[] mobileBackRules = (MobileBranchRule[])request.getAttribute("mobileBackRules");//回退节点
%>
<script type="text/javascript">
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
	
	$("#disagree_but").click(function(){
		$("#app_val").val("disagree");
		$("#confirm_msg").html("您当前选择【不同意】该工作流，是否确定提交？");
		$("#app_window").fadeIn(600);
		$(".tipsWinCnt").show();
	});
	
	$("#agree_but").click(function(){
		$("#app_val").val("agree");
		$("#confirm_msg").html("您当前选择【同意】该工作流，是否确定提交？");
		$("#app_window").fadeIn(600);
		$(".tipsWinCnt").show();
	});
	
	$("#rollback_but").click(function(){
		$("#result_window").hide();
		
		//审批意见验证
		var str = $('#textarea-a').val();
		if(str == "" ){ //回退时审批意见为空判断
			$("#textarea-a").focus();
			$("#textarea-a").parent().css("border-color","#f00");
			return;
		}
		//显示弹窗
		$("#select_act_window").fadeIn(600);
		$(".tipsWinCnt").show();
	});
	$("#activity_cancel").click(function(){
		$(".tipsWinCnt").hide();
		$("#activity_window").hide();
	});
	$("#activity_confirm").click(function(){
		$("#result_window").hide();
		$("#activity_window").hide();
		var backnode = $('input[name="radio-choice"]:checked').val();//
		approve("back",backnode);
	});
	$("#select_act_cancel").click(function(){
		$(".tipsWinCnt").hide();
		$("#select_act_window").hide();
	});
	$("#select_act_confirm").click(function(){
		$("#result_window").hide();
		$("#select_act_window").hide();
		var rollBackId = $('input[name="radio-choice"]:checked').val();
		var val = $('#radio-label-' + rollBackId).text();
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
		window.location.replace("<%=basePathBut%>/toWorkItemsList?timestamp=" + new Date().getTime());
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
		approve(appval,null);
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
	$("#result_window").fadeIn(600);
	 $('#select_act_window').hide();
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
function approve(opinion,backnode) {
	$(".tipsWinCnt").show();
	//var workid = $("#workid").html();//工作流ID	
	var textarea = $('#textarea-a').val();//审批意见	
	var decision = encodeURIComponent(encodeURIComponent(textarea)).replace(/%20/g, "+");
	var busino = "<%=wfParamVo.getClaimNo()%>";//业务编号
	var workitemid = "<%=wfParamVo.getWfWorkitemId()%>";//工作项ID
	$(".loading").show();
// 	appTimeout(time);
	$.ajax({
		type : "GET",
		url : "<%=basePathBut%>/fsscApproveAction",
	   	data: "busino="+busino+"&workitemid="+workitemid+"&opinion="+opinion+"&decision="+decision+"&backnode="+backnode+"&timestamp=" + new Date().getTime(),
		cache:false,	   
	   	success: function(msg){
// 	   		clearTimeout(t);
	   		$(".loading").hide();
		   if( "1" == msg){
					    $('#result_msg').html("审批成功！");
// 					    $("#confirm_cancel").show();
					    $("#result_window").fadeIn(600);
					    $("#result_window").fadeOut(2000);
					    $(".tipsWinCnt").show();
					  //审批完成之后 处理页面提示框
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
	   error:function(){
		   	$(".loading").hide();
	   		$('#result_msg').html("系统繁忙！请稍后再试...");
			$("#result_window").fadeIn(600);
			$("#result_window").fadeOut(2000);
			$(".tipsWinCnt").show();
			//审批失败之后  提示框操作
			setTimeout(function(){approveFault();},2000);
	   }
});
}

	//图片缓加载
	window.onload = function(){
		$(".return").find("img").attr("src","<%=pathBut%>/imgnews/win8/list_return_btn.png");
		$(".logo").find("img").attr("src","<%=pathBut%>/imgnews/win8/list_logo.png");
	}
</script>
<div id="div3">
    	<span class="btn" id="disagree_but">不同意</span>
    	<span class="btn" id="agree_but">同&nbsp;&nbsp;意</span>
    	<%
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
		<%
		int size = mobileBackRules == null ? 0 : mobileBackRules.length;
			for(int i=0; i<size; i++){
				MobileBranchRule backRule = mobileBackRules[i];
		%>
			<p>
				<input type="radio" name="radio-choice" id="radio-choice-<%=i%>"  value="<%=backRule.getActivityDefId() %>" checked="checked" />
				<label for="radio-choice-<%=i%>" id="radio-label-<%=backRule.getActivityDefId()%>">
					<%=backRule.getActivityDefId().equals("Drafter")?"申请人":(backRule.getActivityDefId().indexOf("TaskPool")!=-1?"审核会计":backRule.getActivityName()) %>
				</label>
			</p>	
		<%
			}
		%>
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
