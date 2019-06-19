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
	<link rel="stylesheet" href="<%=basePath%>/css/ios/common.css" />
	<link rel="stylesheet" href="<%=basePath%>/css/ios/menu.css" />
	<script src="<%=basePath%>/js/jquery-1.8.2.min.js"></script>
	<script src="<%=basePath%>/js/ios_auto_resize.js"></script>
</head>
<body>
	<input type="hidden" value="<%=basePath%>" id="basePath"/>
	<div id="menu">
		<!--div1 S-->
		<div id="div1" class="white">
			<div class="mainTit"><img src="" width="100%" /></div>
			<a class="return" id="back_loginout"><img src="" width="100%" /></a>
			<div class="addr" id="addr_query"><img src="" width="100%" /></div>
		</div>
		<!--div1 E-->
		<!--div2 S-->
		<div id="div2">
			<div class="annImg">
				<i class="arrowR"></i>
				<div class="newsInfo">图片新闻标题</div>
				<a class="newsIcon" href="<%=basePath%>/jsp/ios/rollnews/rollnews_list.jsp">
					<img src="<%=basePath%>/imgnews/ios/news_icon.png" width="100%" height="100%" />
				</a>
				<img id="adPic" src="<%=basePath%>/imgnews/ios/news01.jpg" width="75%" />
			</div>
			<div class="tabList">
				<ul>
					<li class="on" id="nav1" onclick="chaBox(1,3)">
						<div class="iosTips"><%=request.getAttribute("flowCount") %></div>
						<a>待办事项</a>
					</li><li class="line">
					</li><li id="nav2" onclick="chaBox(2,3)">
					<a>任免公告</a></li><li class="line">
					</li><li id="nav3" onclick="chaBox(3,3)">
					<a>其他模块</a></li>
				</ul>
			</div>
			<div id="box1">
				<div class="searchBox">
					<em>审批工作流</em><span>
						<i class="search" onclick="reQuery()"></i>
							<input id="wf_key" type="text" class="text" placeholder="请输入工作流号"/>
							<input id="wf_pageNum" type="hidden" value="0"/>
						<i class="clear" onclick="clearKey()"></i>
					</span>
				</div>
				<div class="ulBox">
					<div id="querydiv" class="null" style="display: none;"> 
						记录为空!
					</div>
					<ul id="wf_ul">
						
					</ul>
				</div>
				<div id="morediv" class="showMore" style="display: none;">
					<a id="wf_more_href" onclick="query_workflow()">点击查看更多</a>
				</div>
			</div>
			<div id="box2" style="display:none;">
				<div class="ulBox">
					<ul id="nt_ul">
						
					</ul>
				</div>
				<div class="ulBox" >
					<ul>
						<li id="ann_list" class="first last"><a>点击进入详细列表</a></li>
					</ul>
				</div>
			</div>
			<div id="box3" style="display:none;">
				<div class="ulBox">
					<div class="null">
						筹备中...
					</div>
				</div>
			</div>
		</div>
		<!--div2 E-->
	</div>
	<div class="tipsWinCnt" style="display:none;">
			<div class="tipsWin" id="not_opened" style="display: none;">
				<div class="tipsWinBg"></div>
				<div class="tipsWinBox">
					<h4>提示</h4>
					<div class="content" id="opened_msg"></div>
					<div class="btnBox">
						<span class="btn cancel" id="cancel">确定</span> 
					</div>
				</div>
			</div>
			<div class="tipsWin" id="dialog" style="display: none;">
				<div class="tipsWinBg"></div>
				<div class="tipsWinBox">
					<h4>提示</h4>
					<div class="content" id="confirm_msg">确认退出吗？</div>
					<div class="btnBox">
						<span class="btn cancel" id="lgout_ancel">取消</span> 
						<span class="btn confirm" id="lgout_btn">确定</span>
					</div>
				</div>
			</div>
			<div class="shadowBg" id="shadowBg"></div>
		</div>
		<%@include file="/titleControl.jsp" %>
</body>
<%
String rollnews = (String)request.getAttribute("rollnews");
%>
<script type="text/javascript">
$(function(){
	var rollObj = <%=rollnews%>;
	$(rollObj).each(function(index){
		 var obj = rollObj[index];
		 if(typeof(obj.filename) != 'undefined'){
			 obj.imgpath = "<%=basePath%>/oaupload/oaGg/detail/"+obj.filename;
		 }else{
			 obj.imgpath = "<%=basePath%>/imgnews/win8/noimg.jpg";
		 }
	});
	//显示滚动新闻
	var path = "<%= basePath %>/rollnewsdetail?ggid=";
	rollload(0,rollObj,path);
	
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
	//通讯录
	$("#addr_query").click(function(){
		location.href ="<%=basePath%>/jsp/ios/addresslist/addr_query.jsp";
	});
	//更多任免
	$('#ann_list').click(function() {
		location.href ="<%=basePath%>/jsp/ios/notice/appoint_rmoval_announcement.jsp";
	});
	$('#back_loginout').click(function() {
		$(".tipsWinCnt").show();
		$("#dialog").fadeIn(600);
	});
	$('#lgout_btn').click( function() {
		location.href ="<%=basePath%>/logout.jsp";
	});

	$('#outLogin').click(function() {
		location.href ="<%=basePath%>/logout.jsp";
	});
	$(".searchBox").find("span").width(function(){
		return $(window).width()-$(".searchBox").find("em").width()-38;
	});
	$(".text").width(function(){
		return $(".searchBox").find("span").width()-58;
	});
	$(".ulBox").find("li").live('touchstart',function(){
		$(this).addClass("on");
	});
	$(".ulBox").find("li").live('touchend',function(){
		$(this).removeClass("on");
	});
	$(".ulBox").find("li").live('touchmove',function(){
		$(this).removeClass("on");
	});
	$(".newsInfo").width(function(){
		return $(".annImg").find("#adPic").width()-20;
	});
});


//tab切换
function chaBox(now,n) {
	for(var i=1;i<=n;i++){
		if(i==now){
			$("#nav"+i).addClass("on");
			$("#box"+i).show();
			if(i==1){
				$(".searchBox").find("span").width(function(){
					return $(window).width()-$(".searchBox").find("em").width()-38;
				});
				$(".text").width(function(){
					return $(".searchBox").find("span").width()-58;
				});
			}
		}
		else {
			$("#nav"+i).removeClass("on");
			$("#box"+i).hide();
		}
	}
}
//图片缓加载
window.onload = function(){
	
	var wf_count = "<%=request.getAttribute("flowCount") %>";
	if(wf_count != "0"){
		//查询代办事项
		reQuery();
	}else{
		chaBox(2,3);
		$('#querydiv').html("记录为空!");
   	 	$('#querydiv').show();
	}
	
	$(".mainTit").find("img").attr("src","<%=basePath%>/imgnews/ios/ios_tit.png");
	$(".return").find("img").attr("src","<%=basePath%>/imgnews/ios/ios_return.png");
	$(".addr").find("img").attr("src","<%=basePath%>/imgnews/ios/ios_addr.png");
	
}

//点击搜索代办
function reQuery(){
	$('#wf_pageNum').val(0);
	query_workflow();
}
$(document).keydown(function(e){
	if(e.keyCode == 13) {
		reQuery();
	}
});

//清楚搜索条件
function clearKey(){
	$("#wf_key").val("");
}

//显示工作流详细
function showWf(workId,type,syscode,busino,workitemid,activitydefid,activityinstid){
	location.href = "<%= basePath %>/toApprove?workId="+workId+"&type="
			      +type+"&syscode="+syscode+"&busino="+busino+"&workitemid="
			      +workitemid+"&activitydefid="+activitydefid+"&activityinstid="+activityinstid;
}

//显示任免公告详细
function showDetail(val,obj){
	var unread = "1";
	if($(obj).hasClass("bold")){
		$(obj).removeClass("bold");
		$(obj).addClass("ed");
		var unread = "0";
	}
	location.href = "<%= basePath %>/announcementDetail?ggId="+val+"&unread="+unread;
}

var queryIngFlag = "0";

//代办事项查询
function query_workflow(){
	
	if(queryIngFlag == "1"){
		return;
	}
	queryIngFlag = "1";//开始查询
	$("#wf_more_href").html("正在查询中...");
	var key = $('#wf_key').val();
	var pageNum = Number($('#wf_pageNum').val())+1;
	var pageSize = 4;
	var fst_size = <%=request.getAttribute("flowCount") %>;
	if(pageNum > 1){
		pageSize = 8;
	}
	key = encodeURIComponent(encodeURIComponent(key)).replace(/%20/g, "+");
	$.ajax({
	   type: "GET",
	   url: "<%=basePath%>/toworklistios",
	   cache:false,
	   data: "key="+key+"&pagenum="+pageNum+"&pagesize="+pageSize+"&timestamp="+new Date().getTime(),			   
	   success: function(msg){
	     
		 if(msg == ''){	
			 if(pageNum == 1){
				 $('#querydiv').html("记录为空!");
		    	 $('#querydiv').show();
		    	 $('#morediv').hide();
		    	 $('#wf_ul').empty();
		    	 $('#wf_ul').hide();
		    	 $('#wf_pageNum').val(0);		    	 
			 }else{
				 $('#morediv').hide();
			 }
	     }else{
	    	 //当前第几页
	    	 $('#wf_pageNum').val(pageNum);
	    	 $('#querydiv').hide();	
	    	 if(pageNum == 1){
	    		 $('#wf_ul').empty();	    		 
	    	 }
	    	 $('#wf_ul').append(msg);
	    	 $("#wf_ul").trigger("create");
	    	 wf_style_ul();
	    	 $('#wf_ul').show();
	    	 
	    	 //显示'查看更多'
	    	 var len = (msg.length-msg.replace(/(<li)/g, '').length)/3;
	    	 $("#wf_more_href").html("点击查看更多");
	    	 if(len == pageSize){
	    		 $('#morediv').show();	 
	    		 if(len == fst_size){
	    			 $('#morediv').hide();
	    		 }
	    	 }else{
	    		 $('#morediv').hide();	    		 
	    	 }
	     }
		 
		 queryIngFlag = "0";//查询结束
		 
	   }
	});
	
}
//ios-ul样式变化
function wf_style_ul(){
	$('#wf_ul').find(".first").removeClass("first");
	$('#wf_ul').find(".last").removeClass("last");
	$('#wf_ul').find("li:first").addClass("first");
	$('#wf_ul').find("li:last").addClass("last");
}


// 任免公告查询
function notice_query(){	
	$.ajax({
	   type: "GET",
	   url: "<%=basePath%>/toAnnouncement",
	   cache:false,
	   data: "key=&pageNum=1&pageSize=4"+"&timestamp="+new Date().getTime(),			   
	   success: function(msg){
		   	 $('#nt_ul').append(msg);
	    	 $("#nt_ul").trigger("create");
	    	 nt_style_ul();
	    	 $('#nt_ul').show();
	     }
	});
}

//ios-ul样式变化
function nt_style_ul(){
	$('#nt_ul').find(".first").removeClass("first");
	$('#nt_ul').find(".last").removeClass("last");
	$('#nt_ul').find("li:first").addClass("first");
	$('#nt_ul').find("li:last").addClass("last");
}


$(window).resize(function(){
	$(".searchBox").find("span").width(function(){
		return $(window).width()-$(".searchBox").find("em").width()-38;
	});
	$(".text").width(function(){
		return $(".searchBox").find("span").width()-58;
	});
	$(".newsInfo").width(function(){
		return $(".annImg").find("#adPic").width()-20;
	});
});
</script>
<script defer="defer">
<!-- 自动加载任免公告
	setTimeout(notice_query,100);
//-->
</script>
</html>