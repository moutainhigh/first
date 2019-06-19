<%@page errorPage="/errorPage.jsp" %>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.WorkflowEntity"%>
<%@page import="com.deppon.lsp.module.mobileworkflow.server.service.Auditparameters"%>
<%@page import="com.deppon.montal.util.InitDataServlet" %>
<%@page import="java.util.List"%>
<%@ page language="java"  pageEncoding="UTF-8"%>
<%
    String pathBut = request.getContextPath();
	String basePathBut = InitDataServlet.getValue("dpm_domain_url") + "://"
						+ request.getServerName() + ":" + request.getServerPort()
						+ pathBut;
	//获得审批信息
// 	WorkflowEntity entity = (WorkflowEntity)request.getAttribute("lspResponseEntity");
	Auditparameters approvalLSPEntity = (Auditparameters)request.getAttribute("approvalLSPEntity");
	String interfaceBatchLSP = (String)request.getAttribute("interfaceBatchLSP");
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
	
	$("#rollback_but").click(function(){
		$("#app_val").val("back");
		$("#confirm_msg").html("您当前选择【回退】该工作流，是否确定提交？");
		$("#app_window").fadeIn(600);
		$(".tipsWinCnt").show();
	});
	
	/**
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
	});**/
	
	$("#agree_but").click(function(){
		$("#app_val").val("agree");
		$("#confirm_msg").html("您当前选择【同意】该工作流，是否确定提交？");
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
		var backnode = $('input[name="radio-choice"]:checked').val();//获取页面选择的决策值
		approve("back",backnode);//将决策意见传递给审批
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
/**
* 审批完成之后 处理页面提示
*/
function approvResult(){
	$("#result_window").hide(2000);
	$("#confirm_cancel").hide(2000);
	window.location.replace("<%=basePathBut%>/toWorkItemsList?timestamp=" + new Date().getTime());
}
/**
 *审批失败之后操作 
 */
function approveFault(){
	$("#result_window").fadeOut(2000);
	$("#confirm_back").fadeOut(2000);
	$(".tipsWinCnt").fadeOut(2000);
}
function approve(decision,backnode) {
	$(".tipsWinCnt").show();
	//获得审批意见
	var textarea = $('#textarea-a').val();
	var opinions = (encodeURIComponent(textarea));
	var processinstidLSP = $("#processinstidLSP").val();//工作流号
	var activityIdLSP = $("#activityIdLSP").val();//当前节点的活动定义id
	var workitemidLSP = $("#workitemidLSP").val();//工作项ID
	var businoLSP = $("#businoLSP").val();//业务单据号

	$(".loading").show();
// 	appTimeout(time);
	$.ajax({
		type : "GET",
		url : "<%=basePathBut%>/lspESBApproveAction",
	   	data: {"processinstidDLSP":processinstidLSP,
	   			"activityIdDLSP":activityIdLSP,
	   			"workitemidDLSP":workitemidLSP,
	   			"businoDLSP":businoLSP,
	   			"opinionsLSP":opinions,
	   			"decisionDLSP":decision,
	   			"interfaceBatchLSP":<%=interfaceBatchLSP%>,
	   			"timestamp=":new Date().getTime()},
		cache:false,
		success: function(msg){
			var result = eval("[" + msg + "]");
// 	   		clearTimeout(t);
	   		$(".loading").hide();
	   		if (result.length > 0) {
	   			if( "1" == result[0].msg){
	   				if (decision=='agree'){
	   					$('#result_msg').html("审批成功！");
	   				}else if (decision=='back') {
	   					$('#result_msg').html("成功回退到起草人！");
	   				}else {
	   					$('#result_msg').html("操作成功！");
	   				}
// 				    $("#confirm_cancel").show();
				    $("#result_window").fadeIn(600);
				    $("#result_window").fadeOut(2000);
				    $(".tipsWinCnt").show();
				  //审批完成之后 处理页面提示框
				  setTimeout(function(){approvResult();},2000);
			   	 } else {
			   		$('#result_msg').html("系统繁忙！请稍后再试...");
// 			   		$("#confirm_back").show();
			   		$("#result_window").fadeIn(600);
			   		$("#result_window").fadeOut(2000);
			   		$(".tipsWinCnt").show();
					//审批失败之后  提示框操作
				  	setTimeout(function(){approveFault();},2000);
			   	 }
	   		}else {
	   			$('#result_msg').html("系统繁忙！请稍后再试...");
// 		   		$("#confirm_back").show();
		   		$("#result_window").fadeIn(600);
		   		$("#result_window").fadeOut(2000);
		   		$(".tipsWinCnt").show();
				//审批失败之后  提示框操作
			  	setTimeout(function(){approveFault();},2000);
	   		}
	   },
	   error:function() {
		   $(".loading").hide();
		   $('#result_msg').html("系统繁忙！请稍后再试...");
// 	   		$("#confirm_back").show();
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

<!-- 工作流号 -->
<input type="hidden" id="processinstidLSP" value="<%=approvalLSPEntity.getWfInstanceId()%>"/>
<!-- 当前节点的活动定义id -->
<input type="hidden" id="activityIdLSP" value="<%=approvalLSPEntity.getWfState()%>"/>
<!-- 工作项ID -->
<input type="hidden" id="workitemidLSP" value="<%=approvalLSPEntity.getWfWorkItemId()%>"/>
<!-- 业务单据号 -->
<input type="hidden" id="businoLSP" value="<%=approvalLSPEntity.getDocId()%>"/>

<!-- 决策意见选择 -->
<div id="div3">
   	<span class="btn" id="agree_but">同&nbsp;&nbsp;意</span>
   	<span class="btn" id="rollback_but">回&nbsp;&nbsp;退</span> 
</div>

<!-- 各种提示语 -->
<div class="tipsWinCnt" style="display: none;">
	<!-- 提交审批的界面 -->
	<div class="tipsWin" id="app_window" style="display: none;">
		<input type="hidden" id="app_val">
		<h4>提示</h4>
		<div class="content" id="confirm_msg"></div>
		<div class="btnBox">
			<span class="btn cancel" id="btnCancel">取消</span> 
			<span class="btn confirm" id="btnConfirm">确定</span>
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
	<!-- 结果响应的界面 -->
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
