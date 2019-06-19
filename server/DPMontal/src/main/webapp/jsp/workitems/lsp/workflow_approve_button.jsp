<%@page errorPage="/errorPage.jsp" %>
<%@page import="com.deppon.montal.conf.F_Constants"%>
<%@page import="com.deppon.montal.model.WfActivityInst"%>
<%@page import="java.util.List"%>
<%@page import="com.deppon.montal.util.InitDataServlet" %>
<%@ page language="java"  pageEncoding="UTF-8"%>
<%
    String pathBut = request.getContextPath();
			String basePathBut = InitDataServlet.getValue("dpm_domain_url") + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ pathBut;
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
	$("#sliderDown").click(function(){
		showApproval();
	});
	$("#sliderUp").click(function(){
		$("table").find(".sh").hide();
	});
	$("#disagree_but").click(function(){
// 		var str = $('#textarea-a').val();
// 		if(str == "" ){ //回退时审批意见为空判断
// 			$("#textarea-a").focus();
// 			$("#textarea-a").parent().css("border-color","#f00");
// 			return;
// 		}		
		$("#app_val").val("back");
		$("#confirm_msg").html("您当前选择【回退】该工作流，是否确定提交？");
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
	$.ajax({
	   type: "GET",
	   url: "<%=basePathBut%>/querWfActivityInst",
	   data: "workid="+workid+"&timestamp=" + new Date().getTime(),
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
					 $("#confirm_back").show();
					 showResultWindow();
					 return flag = false;
				 }
				 var num = index+1;
				 html+="<p><input type=\"radio\" name=\"radio-choice\" id=\"radio-choice-"+num+"\"value=\""+val.id+"\" checked=\"checked\" />"+
						 "<label for=\"radio-choice-"+num+"\">"+val.name+"</label>"+
						 "<input type=\"hidden\"  id=\"val-"+val.id+"\"value=\""+val.name+"\"/></p>";
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
			 showResultWindow();
	   	 }
	   }
	});
}
function rollBackWorkFlow(){
	var rollBackId = $('input[name="radio-choice"]:checked').val();
	var str = $('#textarea-a').val();
	var approvever = encodeURIComponent(encodeURIComponent(str)).replace(/%20/g, "+");
	var workid = $("#workid").html();
	$(".tipsWinCnt").show();
	$(".loading").show();
// 	appTimeout(time);
	$.ajax({
	   type: "GET",
	   url: "<%=basePathBut%>/rollBackWorkFlow",
	   data : "workid=" + workid + "&rollBackId=" + rollBackId + "&approvever=" + approvever+"&timestamp=" + new Date().getTime(),
	   cache:false,
			success : function(msg) {
// 				clearTimeout(t);
				$(".loading").hide();
				$(".tipsWinCnt").show();
				if ('success' == msg || '发送消息给其他人出错' == msg) {
					$("#result_msg").html("审批成功！");
					$("#confirm_cancel").show();
					showResultWindow();
				} else {
					$("#result_msg").html(msg);
					$("#confirm_back").show();
					showResultWindow();
				}
			}
		});
	}
function approve(isAgree) {
	$(".tipsWinCnt").show();
	var str = $('#textarea-a').val();
	var approvever = encodeURIComponent(encodeURIComponent(str)).replace(/%20/g, "+");
	var workid = $('#workid').val();
	var workItemId = $('#workItemId').val();
	var busino = $('#docId').val();
	var wfState = $('#wfState').val();
	var type = $('#type').val();
	$(".loading").show();
// 	appTimeout(time);
	$.ajax({
		type : "GET",
		url : "<%=basePathBut%>/lspApproveAction" ,
		data: "workid=" + workid + "&agree=" + isAgree +"&approvever=" + approvever + "&busino=" + busino + "&workItemId=" + workItemId + "&wfState=" + wfState + "&type=" + type,
		cache:false,	   
	   	success: function(msg){
// 	   		clearTimeout(t);
	   		$(".loading").hide();
		   if( "1" == msg){
					    $('#result_msg').html("审批成功！");
					    $("#confirm_cancel").show();
					    $("#result_window").fadeIn(600);
					    $(".tipsWinCnt").show();
		   	 } else {
				   		$('#result_msg').html("系统繁忙！请稍后再试...");
				   		$("#confirm_back").show();
				   		$("#result_window").fadeIn(600);
				   		$(".tipsWinCnt").show();
		   	 }
	   },error:function(){
		   $(".loading").hide();
		   $('#result_msg').html("系统繁忙！请稍后再试...");
	   		$("#confirm_back").show();
	   		$("#result_window").fadeIn(600);
	   		$(".tipsWinCnt").show();
	   }
});
}
	//处理记录信息
	var appmsg = "";

	//自动加载处理记录
	function autoShowApproval(){
		if(appmsg != ""){
			$("#qytr").hide();
			$("table").find(".sh").show();
			return;
		}
		var workid = $("#workid").html();
		$.ajax({
		   type: "GET",
		   url: "<%=basePathBut%>/showAproval",
		   data: "workId="+workid+"&timestamp=" + new Date().getTime(),
		   cache:false,	   
		   success: function(msg){
			   appmsg = msg;
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
<!-- 自动加载处理记录
	setTimeout(autoShowApproval,100);
//-->
</script>
<div id="div3">
    	<span class="btn" id="disagree_but">回&nbsp;&nbsp;退</span>
    	<span class="btn" id="agree_but">同&nbsp;&nbsp;意</span>
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
