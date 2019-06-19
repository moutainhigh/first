<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-通讯录</title>
	<%@include file="/common_ios.jsp"%>
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
				
							<input class="text101" type="text" name="queryval" id="key" placeholder="请输入工号或姓名查询..."/>
							<input type="hidden" id="pageNum"/>
							<!-- 用于ios返回 -->
							<input type="hidden" id="li_cxt"/>
							<input type="hidden" id="showmoreflag"/>
						
							<button class="btn" onclick="qclick()" type="button" >查询</button>
			</div>
			<div class="ulBox">
				<ul id="ulist">
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
<script>
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
	$("#to_showMain").click(function(){
		location.href ="<%=basePath%>/showmain";
	});
	$("#div2").find("li").live('touchstart',function(){
		$(this).addClass("on");
	});
	$("#div2").find("li").live('touchend',function(){
		$(this).removeClass("on");
	});
	$("#div2").find("li").live('touchmove',function(){
		$(this).removeClass("on");
	});
});

	//点击查询		
	function qclick(){			
		$('#pageNum').val(0);
		query();
	}
	$(document).keydown(function(e){
		if(e.keyCode == 13) {
			qclick();
		}
	});
	$(document).ready(function(){
		//alert("key="+$('#key').val()+"pageNum="+$('#pageNum').val());
		$('#morediv').hide();
		if($('#li_cxt').val() != ""){
			$('#ulist').empty();
			$('#ulist').append($('#li_cxt').val());
	    	$("#ulist").trigger("create");
	    	$('#ulist').show();
	    	$('#querydiv').hide();
	    	if($('#showmoreflag').val() == "1"){
	    		$('#morediv').show();
	    	}
		}
	});
	
	//查询更多
	function moreclick(){			
		query();
	}
	
	
	var query_flag = "1";
	
	function query(){
		
		if(query_flag == "0"){
			return;
		}
		var key = $('#key').val();
		var pageNum = Number($('#pageNum').val())+1;
		var patter = /^.{0,50}$/;
		if (!patter.exec(key)){   
			//alert("不允许输入特殊字符,且长度不得超过50!");
			$(".tipsWinCnt").show();
			return;
		} 
		key = encodeURIComponent(encodeURIComponent(key)).replace(/%20/g, "+");
		query_flag = "0";
		$.ajax({
		   type: "GET",
		   url: "<%=basePath%>/queryAdresslist",
	   data: "key="+key+"&pageNum="+pageNum+"&timestamp="+new Date().getTime(),	
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
	    	 //当前第几页
	    	 $('#pageNum').val(pageNum);
	    	 $('#querydiv').hide();	
	    	 if(pageNum == 1){
	    		 $('#ulist').empty();
	    		 $('#li_cxt').val("");
	    	 }
	    	 $('#ulist').append(msg);
	    	 $('#li_cxt').val($('#li_cxt').val()+msg);
	    	 $("#ulist").trigger("create");
	    	 $('#ulist').show();
	    	 
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
	
       //点击事件开始
       function adressDetaul(empid){
			location.href = "<%=basePath%>/getAdressDetail?empid="+empid;//location.href实现客户端页面的跳转
       }
      window.onload = function(){
      	$(".tit").find("img").attr("src","<%=basePath%>/imgnews/ios/addr_tit.png");
      	$(".return").find("img").attr("src","<%=basePath%>/imgnews/ios/ios_return.png");
      	$(".home").find("img").attr("src","<%=basePath%>/imgnews/ios/ios_home.png");
      }
</script>
</body>

</html>