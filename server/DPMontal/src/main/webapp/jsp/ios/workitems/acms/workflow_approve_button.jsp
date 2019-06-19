<%@page import="com.deppon.montal.conf.F_Constants"%>
<%@page import="com.deppon.montal.util.InitDataServlet" %>
<%@page import="java.util.List"%>
<%@ page language="java"  pageEncoding="UTF-8"%>
<% 
	
	String pathBut = request.getContextPath();   
    String basePathBut = InitDataServlet.getValue("dpm_domain_url") + "://"   
            + request.getServerName() + ":" + request.getServerPort()   
            + pathBut; 
%>
	<div id="btnbox">
		<button type="button" class="btn"  id="disagree_but">不同意</button>
    	<button type="button"  class="btn" id="agree_but">同意</button>
	   	<button type="button" id="rollback_but" class="btn">回退</button>
	</div>
	<div class="tipsWinCnt" style="display: none;">
		<div class="tipsWin" id="app_window" style="display: none;">
			<input type="hidden" id="app_val">
			<div class="tipsWinBg"></div>
			<div class="tipsWinBox">
				<h4>提示</h4>
				<div class="content" id="confirm_msg"></div>
				<div class="btnBox">
					<span class="btn cancel" id="btnCancel">取消</span> 
					<span class="btn confirm" id="btnConfirm">确定</span>
				</div>
			</div>
		</div>
		<div class="tipsWin list" id="select_act_window" style="display: none;">
			<div class="tipsWinBg"></div>
			<div class="tipsWinBox">
				<h4>提示</h4>
				<h5>请选择回退环节</h5>
				<div class="content" id="select_act_val">
				</div>
				<div class="btnBox">
					<span class="btn cancel" id="select_act_cancel">取消</span> 
					<span class="btn confirm" id="select_act_confirm">确定</span>
				</div>
			</div>
		</div>
		<div class="tipsWin" id="activity_window" style="display: none;">
			<div class="tipsWinBg"></div>
			<div class="tipsWinBox">
				<h4>提示</h4>
				<div class="content" id="activity_val"></div>
				<div class="btnBox">
					<span class="btn cancel" id="activity_cancel">取消</span> 
					<span class="btn confirm" id="activity_confirm">确定</span>
				</div>
			</div>
		</div>
		<div class="tipsWin" id="result_window" style="display: none;">
			<div class="tipsWinBg"></div>
			<div class="tipsWinBox">
				<h4>提示</h4>
				<div class="content" id="result_msg"></div>
				<div class="btnBox">
					<span class="btn cancel" id="confirm_back" style="display: none;">确定</span>
					<span class="btn confirm" id="confirm_cancel" style="display: none;">确定</span>
				</div>
			</div>
		</div>
		<div class="loading" style="display:none;"><img src="<%=basePathBut%>/css/images/loading.gif" /></div>
		<div class="shadowBg" id="shadowBg"></div>
</div>
<script type="text/javascript">
$(function(){
	$("#to_showmain").click(function(){
		window.location.assign("<%=basePathBut%>/showmain");
	});
	$(".btnBox").find(".btn").mousedown(function(){
		$(this).addClass('down');
	});
	$(".btnBox").find(".btn").mouseleave(function(){
		$(this).removeClass('down');
	});
	$("#div3").find(".btn").live('touchstart',function(){
		$(this).addClass("on");
	});
	$("#div3").find(".btn").live('touchend',function(){
		$(this).removeClass("on");
	});
	$("#div3").find(".btn").live('touchmove',function(){
		$(this).removeClass("on");
	});
	$("#disagree_but").click(function(){
		$("#app_val").val("1");
		//审批意见验证
		var str = $('#textarea-a').val();
		if(str == "" ){ //回退时审批意见为空判断
			$("#textarea-a").focus();
			$("#textarea-a").parent().parent().parent().css("border-color","#f00");
			$("#approve_area").find($(".first")).removeClass("gray");
			$("#approve_area").find($(".first")).addClass("gray1");
			return;
		}
		$("#confirm_msg").html("您当前选择【不同意】该工作流，是否确定提交？");
		$("#app_window").fadeIn(600);
		$(".tipsWinCnt").show();
	});
	
	$("#agree_but").click(function(){
		$("#app_val").val("0");
		$("#confirm_msg").html("您当前选择【同意】该工作流，是否确定提交？");
		$(".tipsWinCnt").show();
		$("#app_window").fadeIn(600);
	});
	
	$("#rollback_but").click(function(){
		$("#result_window").hide();
		//acms 证照系统 回退判断
		$("#app_val").val("2");
		//审批意见验证
		var str = $('#textarea-a').val();
		if(str == "" ){ //回退时审批意见为空判断
			$("#textarea-a").focus();
			$("#textarea-a").parent().parent().parent().css("border-color","#f00");
			$("#approve_area").find($(".first")).removeClass("gray");
			$("#approve_area").find($(".first")).addClass("gray1");
			return;
		}
		$("#confirm_msg").html("您当前选择【回退】该工作流，是否确定提交？");
		//显示弹窗
		$("#app_window").fadeIn(600);
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
		var val = $('#radio-label-' + rollBackId).html();
		$("#activity_val").html("您当前选择回退至<br/>【" + val + "】！<br/>确认提交吗？");
		$("#activity_window").show();
		$("#activity_window").fadeIn(600);
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
	if($("#app_ui").val()=="false"){
		$("#btnbox").find("button").removeClass("btn");
		$("#btnbox").find("button").addClass("btn1");
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
	var textarea = $('#textarea-a').val();//审批意见	
	var decision = encodeURIComponent(encodeURIComponent(textarea)).replace(/%20/g, "+");
	var busino =  $("#busino").val();//业务编号
	var workitemid =  $("#workitemid").val();//工作项ID
	var syscode = $("#syscode").val();//业务编号
	var processinstid = $("#processinstid").val();//工作流号
	var processDefName = $("#processDefName").val();//工作流定义名称
	$(".loading").show();
	$.ajax({
		type : "GET",
		url : "<%=basePathBut%>/crmApproveWFAction",
	   	data: "busino="+busino+"&workitemid="+workitemid+"&opinion="+opinion+"&syscode="+syscode+"&processinstid="+processinstid+"&processDefName="+processDefName+"&decision="+decision+"&backnode="+backnode+"&syscode"+syscode+"&timestamp=" + new Date().getTime(),
		cache:false,	   
	   	success: function(msg){
	   		var result = eval("[" + msg + "]");
	   		$(".loading").hide();
	   		if (result.length > 0) {
	   			if( "0" == result[0].msg){
				    $('#result_msg').html("审批成功！");
// 				    $("#confirm_cancel").show();
				    $("#result_window").fadeIn(600);
				    $("#result_window").fadeOut(2000);
				    $(".tipsWinCnt").show();
				  //审批完成之后 处理页面提示框
					setTimeout(function(){approvResult();},2000);
			   	 } else {
			   		var reason = result[0].reason;
			   		console.log(reason);
			   		$('#result_msg').html("系统繁忙！请稍后再试...");
// 			   		$("#confirm_back").show();
			   		$("#result_window").fadeIn(600);
			   		$("#result_window").fadeOut(2000);
			   		$(".tipsWinCnt").show();
					//审批失败之后  提示框操作
				  	setTimeout(function(){approveFault();},2000);
			   	 }
	   		}else {
	   			var reason = result[0].reason;
		   		console.log(reason);
	   			$('#result_msg').html("系统繁忙！请稍后再试...");
// 		   		$("#confirm_back").show();
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
//	   		$("#confirm_back").show();
	   		$("#result_window").fadeIn(600);
	   		$("#result_window").fadeOut(2000);
	   		$(".tipsWinCnt").show();
			//审批失败之后  提示框操作
		  	setTimeout(function(){approveFault();},2000);
	   }
});
}
//审批意见输入监听
document.getElementById("textarea-a").onkeydown = function(event_e){
	if( window.event )
	event_e = window.event;
	var int_keycode = event_e.charCode||event_e.keyCode;
	var length = document.getElementById("textarea-a").value.length;
	if(length == 0 ){
		if(int_keycode ==32){
			return false;
	 	}
	}
	if(int_keycode ==32){
		return false;
 	}
	if (/^\s+/.test(document.getElementById("textarea-a").value)) {
		return false;
	}
	if(int_keycode ==13){
			return false;
	 }
}
var length0 = 300;
$('#textarea-a').bind('input propertychange', function() {
    $("#textarea-a").parent().parent().parent().css("border-color","#aaa");
    	var length1 = event.srcElement.value.length;
    	if(length1 <= length0){
    		var length2 = length0-length1;
        	$("#textareaNum").text((length2));
    	}
    	//审批意见字数超过300无法继续输入
   		if($(this).val().length >300){
   			$(this).val(this.value.substring(0,300));		
   		}
});
</script>
<!-- 系统编码 -->
<input type="hidden" id="syscode" value="<%=request.getAttribute("syscode")%>"/>
<!-- 工作流号 -->
<input type="hidden" id="processinstid" value="<%=request.getAttribute("processinstid")%>"/>
<!-- 工作流定义名称 -->
<input type="hidden" id="processDefName" value="<%=request.getAttribute("processDefName")%>"/>
<!-- 工作项ID -->
<input type="hidden" id="workitemid" value="<%=request.getAttribute("workitemid")%>"/>
<!-- 业务单据号 -->
<input type="hidden" id="busino" value="<%=request.getAttribute("busino")%>"/>
</html>