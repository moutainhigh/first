<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<% 
	
	String path = request.getContextPath();   
    String basePath = InitDataServlet.getValue("dpm_domain_url") + "://"   
            + request.getServerName() + ":" + request.getServerPort()   
            + path;   
%>
<head>
	<title><%=InitDataServlet.getValue("page_title") %></title>
	<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />
	<meta content="telephone=no" name="format-detection" />
	<meta http-equiv = "Content-Type" content = "application/xhtml+xml; charset=UTF-8" />
	<link rel="stylesheet" href="<%=basePath%>/css/reset.css" />
	<link rel="stylesheet" href="<%=basePath%>/css/win8/common.css" />
	<link rel="stylesheet" href="<%=basePath%>/css/win8/menu.css" />
	<script src="<%=basePath%>/js/jquery-1.8.2.min.js"></script>
	<script src="<%=basePath%>/js/win8_auto_resize.js"></script>
</head>
<body>
	<input type="hidden" value="<%=basePath%>" id="basePath"/>
	<div id="menu">
		<div id="div1" class="white">
			<a class="return" id="back_loginout">
				<img src="" width="100%" />
			</a>
			<div class="logo">
				<img src="" width="100%" />
			</div>
		</div>
		<div id="div2">
				<div class="list">
					<div class="wide icon1" id="wf_list">
						<div class="tips">
							<em><%=request.getAttribute("flowCount") %></em>
						</div>
						<b></b>
						<p>待办事项</p>
					</div>
				</div>
				<div class="list">
					<div class="icon2 fyy-fl" id="ann_list">
						<p>任免公告</p>
					</div>
					<div class="icon6 fyy-fr" id="rollnew">
						<p>图片新闻</p>
					</div>
				</div>
				<div class="list">
					<div class="icon3 fyy-fl" id="addr_query">
						<p>通讯录</p>
					</div>
					<div class="icon7 fyy-fr" id="yuebao_query">
						<p>月报</p>
					</div>
				</div>
				<div class="list">
					<div class="icon4 fyy-fl" >
						<p>筹备中...</p>
					</div>
				</div>
		</div>
	</div>
	<div class="tipsWinCnt" style="display: none;">
		<div class="tipsWin" id="not_opened" style="display: none;">
			<h4>提示</h4>
			<div class="content" id="opened_msg"></div>
			<div class="btnBox">
				<span class="btn cancel" id="cancel">确定</span> 
			</div>
		</div>
		<div class="tipsWin" id="dialog" style="display: none;">
			<h4>提示</h4>
			<div class="content" id="confirm_msg">确认退出吗？</div>
			<div class="btnBox">
				<span class="btn cancel" id="lgout_ancel">取消</span> 
				<span class="btn confirm" id="lgout_btn">确定</span>
			</div>
		</div>
		<div class="shadowBg" id="shadowBg"></div>
	</div>
	<%@include file="/titleControl.jsp" %>
</body>
<%--
<% 
	String rollnews = (String)request.getAttribute("rollnews");
%>
--%>
<script type="text/javascript">
$(function(){
<%-- 	var rollObj = <%=rollnews%>; --%>
// 	$(rollObj).each(function(index){
// 		 var obj = rollObj[index];
// 		 if(typeof(obj.filename) != 'undefined'){
<%-- 			 obj.fileName = "<%=basePath%>/imgnews/"+obj.filename; --%>
// 		 }else{
<%-- 			 obj.fileName = "<%=basePath%>/imgnews/win8/noimg.jpg"; --%>
// 		 }
// 	});
// 	//显示滚动新闻
<%-- 	var path = "<%= basePath >/announcementDetail?ggId="; --%>
// 	rollload(0,rollObj,path);
	$(".btnBox").find(".btn").mousedown(function(){
		$(this).addClass('down');
	});
	$(".btnBox").find(".btn").mouseleave(function(){
		$(this).removeClass('down');
	});
	$("#lgout_ancel").click(function(){
		$(".tipsWinCnt").hide();
		$("#dialog").hide();
	});
	$("#cancel").click(function(){
		$(".tipsWinCnt").hide();
		$("#not_opened").hide();
	});
	$("#addr_query").click(function(){
		location.href ="<%=basePath%>/jsp/addresslist/addr_query.jsp";
	});
	$("#yuebao_query").click(function(){
		location.href ="<%=basePath%>/html5/pages/MonthlyReport/index.html";
	});
	$('#wf_list').click(function() {
		location.href ="<%=basePath%>/toWorkItemsList";
	});
	$('#ann_list').click(function() {
		// location.href ="
		<%-- <%=basePath%> --%>
		///jsp/notice/appoint_rmoval_announcement.jsp";
		location.href ="<%=basePath%>/html5/index.html#notice";
	});
	$('#back_loginout').click(function() {
		$('#dialog').fadeIn(600);
		$('.tipsWinCnt').show()
	});
	$('#lgout_btn').click( function() {
		location.href ="<%=basePath%>/logout.jsp";
	});
	$('#draft_workflow').click(function() {
		$('#opened_msg').html("亲：工作流功能建设ing,请等等哦...");
		$('#not_opened').fadeIn(600);
		$('.tipsWinCnt').show();
		
	});
	$('#character_report').click(function() {
		$('#opened_msg').html("亲：人品举报功能建设ing,请等等哦...");
		$('#not_opened').fadeIn(600);
		$('.tipsWinCnt').show()
	});
	$('#outLogin').click(function() {
		location.href ="<%=basePath%>/logout.jsp";
	});
	
	$('#rollnew').click(function() {
		//location.href ="
		<%-- <%=basePath%> --%>
		//jsp/rollnews/rollnews_list.jsp";
		location.href ="<%=basePath%>/html5/index.html#news";
	});
});
//图片缓加载
window.onload = function(){
	$(".return").find("img").attr("src","<%=basePath%>/imgnews/win8/return_btn.png");
	$(".logo").find("img").attr("src","<%=basePath%>/imgnews/win8/menu_logo.png");
}
</script>
</html>