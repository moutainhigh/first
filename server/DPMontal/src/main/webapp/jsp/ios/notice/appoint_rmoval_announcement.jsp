<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title><%=InitDataServlet.getValue("page_title") %>-任免公告</title>
	<%@include file="/common_ios.jsp"%>
	<style type="text/css">
 		.searchBox img{ 
  			display: inline-block;  
 			width: 32px;  
  			padding-left: 10px;
 		}
 		.text1001{
 			margin-right: 45px;
 		
 		}
 		.text1001 input{
 			border-radius:0.3em;
			font-size:1em;
			text-indent: 10px;
			padding:0.4em 0;
			width:100%;
			background:#fff;
 		}
 		#qclick{
 			height:32px;
 			float: right;
 			margin-top: -31px;
 		}
 		.searchBox{
 			height: 1.8em;
 		}
	</style>
</head>
<%
 request.setCharacterEncoding("UTF-8");
 response.setCharacterEncoding("UTF-8");
%>
<body>
	<div id="list">
	    <%@include file="/jsp/ios/work_items_head.jsp" %>
	     <div id="div2">
	     	<div class="searchBox">
<!-- 		    	<table > -->
<!-- 		    		<tr> -->
<!-- 		    			<td width="80%"> -->
						<div class="text1001">
		    				<input type="text" name="queryval" id="key" placeholder="请输入标题关键字..." />
<%-- 		    				<img src="<%=basePath %>/images/ios/search_ico.gif" /> --%>
						</div>
		    				<input type="hidden" id="pageNum"/>
		    				<input type="hidden" id="li_cxt"/>
							<input type="hidden" id="showmoreflag"/>
<!-- 		    			</td> -->
<!-- 		    			<td> <input class="btn" type="button" id="qclick" value="查询" /></td> -->
<!-- 		    		</tr> -->
<!-- 		    	</table> -->
<!-- 							<button class="btn" type="button" id="qclick">查询</button> -->
								<img id="qclick" src="<%=basePath %>/images/ios/searchBtn@2x.png">
    		</div>
    		<div>
				<ul id="ulist" class="m-list">
				</ul>
			</div>
			<div id="querydiv"></div>
			<div class="more" id="morediv"><a onclick="moreclick()">点击查看更多</a></div>
		</div>
		<div class="tipsWinCnt" style="display: none;">
			<div class="tipsWin">
				<div class="tipsWinBg"></div>
				<div class="tipsWinBox">
					<h4>提示</h4>
					<div class="content">查询关键字长度不得超过50!</div>
					<div class="btnBox">
						<span class="btn cancel" id="confirm_back">确定</span>
					</div>
				</div>
			</div>
			<div class="shadowBg" id="shadowBg"></div>
		</div>
	</div>
</body>
<script type="text/javascript">
$(function(){
	$(".btnBox").find(".btn").mousedown(function(){
		$(this).addClass('down');
	});
	$(".btnBox").find(".btn").mouseleave(function(){
		$(this).removeClass('down');
	});
	$("#confirm_back").click(function(){
		$(".tipsWinCnt").hide();
	});
	$("#qclick").click(function(){
		qclick();
	});
	//鼠标放下事件
	$("#qclick").mousedown(function(){
		$("#qclick").attr("src","<%=basePath %>/images/ios/searchBtnSelected@2x.png");
	});
	//鼠标释放事件
	$("#qclick").mouseup(function(){
		$("#qclick").attr("src","<%=basePath %>/images/ios/searchBtn@2x.png");
	});
	var app_ui = $(".App_ui_flag").val();
	if(app_ui=="false"){
		$("#div2").find("button").removeClass("btn");
		$("#div2").find("button").addClass("btn1");
	}
	
});

function showDetail(val,obj){
	var unread = "1";
	if($(obj).hasClass("bold")){
		$(obj).removeClass("bold");
		$(obj).addClass("ed");
		var unread = "0";
	}
	$('#li_cxt').val($('#ulist').html());	
	
	location.href = "<%= basePath %>/announcementDetail?ggId="+val+"&unread="+unread;
}

$(document).ready(function(){
	//alert("key="+$('#key').val()+"pageNum="+$('#pageNum').val());
	if($('#li_cxt').val() != ""){
		$('#ulist').empty();
		$('#ulist').append($('#li_cxt').val());
    	$("#ulist").trigger("create");
    	$('#ulist').show();
    	$('#querydiv').hide();
    	if($('#showmoreflag').val() == "1"){
    		$('#morediv').show();
    	}
	}else{
		query();
	}
});
$(document).keydown(function(e){
	if(e.keyCode == 13) {
		qclick();
	}
});

//点击查询
function qclick(){
	$('#pageNum').val(0);
	query();
}

//点击更多
function moreclick(){
	query();
}

function filter(str)
{
    str = str.replace(/\+/g,"%2B");
    str = str.replace(/\&/g,"%26");
    return str;
}

var query_flag = "1";

function query(){
	
	if(query_flag == "0"){
		return;
	}
	query_flag = "0";
	var key = $('#key').val();
	var pageSize = 8;
	var pageNum = Number($('#pageNum').val())+1;
	var patter = /^.{0,50}$/;
	
	if (!patter.exec(key)){   
 			$(".tipsWinCnt").show();
 			return;
 		} 
 		key = encodeURIComponent(encodeURIComponent(key)).replace(/%20/g, "+");
 		
	$.ajax({
	   type: "GET",
	   url: "<%=basePath%>/toAnnouncement",
	   data: "key="+filter(key)+"&pageNum="+pageNum+"&pageSize="+pageSize+"&timestamp="+new Date().getTime(),
	   cache:false,
	   success: function(msg){
		   if(msg == ''){
			 if(pageNum == 1){
				 $('#querydiv').html("记录为空!");
		    	 $('#querydiv').show();
		    	 $('#morediv').hide();
		    	 $('#ulist').empty();
		    	 $('#ulist').hide();
		    	 $('#pageNum').val(0);
		    	 $('#li_cxt').val("");
			 }else{
				 $('#morediv').hide();
			 }
	    	 
	     }else{
	    	 if(msg.indexOf("<html>")>= 0){
	    		 //重定向至appTimeOut页面
	    		 window.location.href="<%=basePath %>/appTimeOut.jsp";
	    	 }
	    	//当前第几页		    	 
	    	 $('#querydiv').hide();	
	    	 if(pageNum == 1){
	    		 $('#ulist').empty();
	    		 $('#li_cxt').val("");
	    	 }
	    	 $('#ulist').append(msg);
	    	 $('#li_cxt').val($('#li_cxt').val()+msg);
	    	 $("#ulist").trigger("create");
	    	 $('#ulist').show();
	    	 $('#pageNum').val(pageNum);
	    	 //显示'查看更多'
	    	 var len = (msg.length-msg.replace(/(<li)/g, '').length)/3;
	    	 if(len == 8){
	    		 $('#morediv').show();
	    		 $('#showmoreflag').val("1");
	    	 }else{
	    		 $('#morediv').hide();
	    		 $('#showmoreflag').val("0");
	    	 }
	     }
		   query_flag = "1";
	   }
	});
}
window.onload = function(){
  	$(".tit").find("img").attr("src","<%=basePath%>/imgnews/ios/notice_tit.png");
  	$(".return").find("img").attr("src","<%=basePath%>/imgnews/ios/ios_return.png");
  	$(".home").find("img").attr("src","<%=basePath%>/imgnews/ios/ios_home.png");
}
</script>
</html>