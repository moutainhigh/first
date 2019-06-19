<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<% 
	String path = request.getContextPath();   
    String basePath = InitDataServlet.getValue("dpm_domain_url") + "://"   
            + request.getServerName() + ":" + request.getServerPort()   
            + path;   
%>
<head>
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />
<meta content="telephone=no" name="format-detection" />
<meta http-equiv = "Content-Type" content = "application/xhtml+xml; charset=UTF-8" />
<title><%=InitDataServlet.getValue("page_title") %></title>
<link rel="stylesheet" href="<%=basePath %>/css/reset.css" />
<link rel="stylesheet" href="<%=basePath %>/css/ios/common.css" />
<link rel="stylesheet" href="<%=basePath %>/css/ios/list.css" />
<script type="text/javascript" src="<%=basePath %>/js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="<%= basePath %>/js/ios_auto_resize.js"></script>
</head>
<style type="text/css">

/* #ulist span{float:left;display:block;width:200px;height:30px;overflow:hidden;text-overflow:ellipsis;white-space:nowrap;word-break:keep-all;line-height:30px;font-size:12px;} */
/* #ulist p{float:left;display:block;width:200px;height:30px;overflow:hidden;text-overflow:ellipsis;white-space:nowrap;word-break:keep-all;line-height:30px;font-size:12px;} */

</style>
<script type="text/javascript">

	$(document).ready(function(){
		if($('#li_cxt').val() != ""){
			$('dl').remove();
			$('#morediv').before($('#li_cxt').val());
	    	$('#ulist').show();
	    	if($('#showmoreflag').val() == "1"){
	    		$('#morediv').show();
	    	}
		}else{
			query();
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
	
	var query_flag = "1";
	function query(){
		if(query_flag == "0"){
			return;
		}
		query_flag = "0";
		var pageSize = Number($('#pageSize').val());
		var pageNum = Number($('#pageNum').val())+1;
  		$.ajax({
		   type: "GET",
		   url: "<%=basePath%>/rollnewslist",
		   data: "pageSize="+pageSize+"&pageNum="+pageNum+"&timestamp="+new Date().getTime(),
		   cache:false,
		   success: function(msg){
			   if(msg == ''){
				 if(pageNum == 1){
					 $('#querydiv').html("记录为空!");
			    	 $('#querydiv').show();
			    	 $('#morediv').hide();
			    	 $('dl').remove();
			    	 $('#ulist').hide();
			    	 $('#pageNum').val(0);
			    	 $('#li_cxt').val("");
				 }else{
					 $('#morediv').hide();
				 }
		    	 
		     }else{
		    	//当前第几页		    	 
		    	 $('#querydiv').hide();	
		    	 if(pageNum == 1){
		    		 $('dl').remove();
		    		 $('#li_cxt').val("");
		    	 }
		    	 $('#morediv').before(msg);
		    	 $('#li_cxt').val($('#li_cxt').val()+msg);
		    	 $('#ulist_div').trigger("create");
		    	 $('#ulist').show();
		    	 $('#pageNum').val(pageNum);
		    	 //显示'查看更多'
		    	 var len = (msg.length-msg.replace(/(<dl)/g, '').length)/3;
		    	 if(len == pageSize){
		    		 $('#morediv').show();
		    		 $('#showmoreflag').val("1");
		    	 }else{
		    		 $('#morediv').hide();
		    		 $('#showmoreflag').val("0");
		    	 }
		     }
			   query_flag = "1"
				   imgstyle();
			   $(window).resize(function(){
				   imgstyle();
			   });
		   }
		});
	}
	
	/*强制调整缩略图比例*/
	function imgstyle(){
		$("dl").find("dt").height(function(){
			return $(this).width()*0.8;
		});
		$("dt").find("img").height(function(){
			return $(this).width()*0.8;
		});
	}
	
	/**显示新闻详情**/
	function showNewDetail(obj,ggid,filename,val){
		var readdiv = $(obj).find(".toread");
		var flag = "1";
		if(readdiv.html() == "未读"){
			readdiv.removeClass("toread");
			readdiv.addClass("readed");
			readdiv.html("已读");
			var flag = "0";
		}
		$('#li_cxt').val($('#ulist').html());
		location.href ="<%=basePath%>/rollnewsdetail?ggid="+ggid+"&filename="+filename+"&unread="+flag;
	}

	 window.onload = function(){
      	$(".tit").find("img").attr("src","<%=basePath%>/imgnews/ios/news_tit.png");
      	$(".return").find("img").attr("src","<%=basePath%>/imgnews/ios/ios_return.png");
      	$(".home").find("img").attr("src","<%=basePath%>/imgnews/ios/ios_home.png");
      }
</script>
<body>
<div id="list">
    <%@include file="/jsp/ios/work_items_head.jsp" %>
    <input type="hidden" id="pageNum" value="0"/><!-- 当前页 -->
    <input type="hidden" id="pageSize" value="5"/><!-- 每页条数 -->
   	<input type="hidden" id="li_cxt"/><!-- 内容 -->
	<input type="hidden" id="showmoreflag"/><!-- 是否显示更多 -->
    <div id="div2">
<!--     	<h3 class="yellow">新闻列表</h3> -->
    	<div id="querydiv" style="color: #403b65"></div>
    	<div class="newsBox" id="ulist">	
    		
    		<div id="morediv" class="more" style="display: none;">
	   			<a onclick="moreclick()"  id="querymore">显示更多内容</a>
	   		</div>
    	</div>
    </div>
</div>
<script>
$(function(){
	$(".logo").click(function(){
		location.href ="<%=basePath%>/showmain";
	});
	$("dl").find("dt").height(function(){
		return $(this).width()*0.8;
	});
	$("dt").find("img").height(function(){
		return $(this).width()*0.8;
	});
	var a = $(".new-con").next('div').find("p");
	var b = a.index();
	
});
		
	}
</script>

<%@include file="/titleControl.jsp" %>
</body>
</html>