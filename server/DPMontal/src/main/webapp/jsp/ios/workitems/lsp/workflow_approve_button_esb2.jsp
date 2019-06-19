<%@page errorPage="/errorPage.jsp" %>
<%@page import="com.deppon.lsp.module.mobilesecondworkflowlist.controlcenter.shared.domain.WorkflowSecondEntity"%>
<%@page import="com.deppon.lsp.module.mobileworkflow.server.service.Auditparameters"%>
<%@page import="java.util.List"%>
<%@page import="com.deppon.montal.util.InitDataServlet" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<% 
	
	String pathBut = request.getContextPath();   
    String basePathBut = InitDataServlet.getValue("dpm_domain_url") + "://"   
            + request.getServerName() + ":" + request.getServerPort()   
            + pathBut;  
    Auditparameters approvalLSPEntity = (Auditparameters)request.getAttribute("approvalLSPEntity");
	String interfaceBatchLSP = (String)request.getAttribute("interfaceBatchLSP");
%>
	<div id="btnbox">
	   	<button type="button"  class="btn" id="agree_but">同意</button>
	   	<button type="button" id="rollback_but" class="btn">回退</button>
	   	<button type="button" id="disagree_but" class="btn" style="display: none">不同意</button>
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
		<div class="tipsWin" id="result_window" style="display: none;">
			<div class="tipsWinBg"></div>
			<div class="tipsWinBox">
				<h4>提示</h4>
				<div class="content" id="result_msg"></div>
				<div class="tipsWinBox btnBox">
					<span class="btn cancel" id="confirm_cancel" style="display: none;">确定</span>
					<span class="btn confirm" id="confirm_back" style="display: none;">确定</span>
				</div>
			</div>
		</div>
		<div class="loading" style="display:none;"><img src="<%=basePathBut%>/css/images/loading.gif" /></div>
		<div class="shadowBg" id="shadowBg"></div>
	</div>
	<!-- 工作流号 -->
	<input type="hidden" id="processinstidLSP" value="<%=approvalLSPEntity.getWfInstanceId()%>"/>
	<!-- 当前节点的活动定义id -->
	<input type="hidden" id="activityIdLSP" value="<%=approvalLSPEntity.getWfState()%>"/>
	<!-- 工作项ID -->
	<input type="hidden" id="workitemidLSP" value="<%=approvalLSPEntity.getWfWorkItemId()%>"/>
	<!-- 业务单据号 -->
	<input type="hidden" id="businoLSP" value="<%=approvalLSPEntity.getDocId()%>"/>
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
	
	$("#agree_but").click(function(){
		$("#app_val").val("agree");
		$("#confirm_msg").html("您当前选择【同意】该工作流，是否确定提交？");
		$(".tipsWinCnt").show();
		$("#app_window").fadeIn(600);
	});
	
	$("#rollback_but").click(function(){
		$("#app_val").val("back");
		$("#confirm_msg").html("您当前选择【回退】该工作流，是否确定提交？");
		$(".tipsWinCnt").show();
		$("#app_window").fadeIn(600);
	});
	$("#disagree_but").click(function(){
		$("#app_val").val("disagree");
		$("#confirm_msg").html("您当前选择【不同意】该工作流，是否确定提交？");
		$(".tipsWinCnt").show();
		$("#app_window").fadeIn(600);
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
	$("#confirm_cancel").click(function(){
		$("#result_window").hide();
		$("#confirm_back").hide();
		$(".tipsWinCnt").hide();
	});
	$("#confirm_back").click(function(){
		$("#result_window").hide();
		$("#confirm_cancel").hide();
		 window.location.replace("<%=basePathBut%>/toWorkItemsList");
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
	$("#result_window").fadeOut(1000);
	$("#confirm_cancel").fadeOut(1000);
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
function approve(decision) {
	//不同意操作 做退回处理
	var operate = "";
	if("disagree" == decision){
		operate = "back";
	}else{
		operate = decision;
	}
	$(".tipsWinCnt").show();
	//获得审批意见
	var textarea = $('#textarea-a').val();
	var opinions = (encodeURIComponent(textarea));
	var processinstidLSP = $("#processinstidLSP").val();//工作流号
	var activityIdLSP = $("#activityIdLSP").val();//当前节点的活动定义id
	var workitemidLSP = $("#workitemidLSP").val();//工作项ID
	var businoLSP = $("#businoLSP").val();//业务单据号
	$(".loading").show();
	$.ajax({
		type : "GET",
		url : "<%=basePathBut%>/lspESBApproveAction",
	   	data: {"processinstidDLSP":processinstidLSP,
	   			"activityIdDLSP":activityIdLSP,
	   			"workitemidDLSP":workitemidLSP,
	   			"businoDLSP":businoLSP,
	   			"opinionsLSP":opinions,
	   			"decisionDLSP":operate,
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
				    
// 				    $("#confirm_back").show();
				    $("#result_window").fadeIn(600);
				    $("#result_window").fadeOut(2000);
				    $(".tipsWinCnt").show();
				  //审批完成之后 处理页面提示框
					setTimeout(function(){approvResult();},2000);
			   	 } else {
			   		$('#result_msg').html("系统繁忙！请稍后再试...");
// 			   		$("#confirm_cancel").show();
			   		$("#result_window").fadeIn(600);
			   		$("#result_window").fadeOut(2000);
			   		$(".tipsWinCnt").show();
					//审批失败之后  提示框操作
				  	setTimeout(function(){approveFault();},2000);
			   	 }
	   		}else {
	   			$('#result_msg').html("系统繁忙！请稍后再试...");
// 		   		$("#confirm_cancel").show();
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
// 	   		$("#confirm_cancel").show();
	   		//$("#result_window").css("background","rgba(11,27,68,.8)");
	   		$("#result_window").fadeIn(600);
	   		$("#result_window").fadeOut(2000);
	   		$(".tipsWinCnt").show();
			//审批失败之后  提示框操作
		  	setTimeout(function(){approveFault();},2000);
  	   }
	});
}
</script>
</html>