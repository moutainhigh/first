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
<title><%=InitDataServlet.getValue("page_title") %>-任免公告</title>
<link rel="stylesheet" href="<%=basePath %>/css/reset.css" />
<link rel="stylesheet" href="<%=basePath %>/css/win8/common.css" />
<link rel="stylesheet" href="<%=basePath %>/css/win8/list.css" />
<script type="text/javascript" src="<%=basePath %>/js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="<%= basePath %>/js/win8_auto_resize.js"></script>
</head>

<script type="text/javascript">

	$(document).ready(function(){
		if($('#li_cxt').val() != ""){
			$('#ulist').empty();
			$('#ulist').append($('#li_cxt').val());
	    	$('#ulist').show();
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
	function filter(str)
	{
	    str = str.replace(/\+/g,"%2B");
	    str = str.replace(/\&/g,"%26");
	    return str;
	}
	
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
		var androidSession = '<%=request.getParameter("androidSession")%>';
		if(query_flag == "0"){
			return;
		}
		query_flag = "0";
		var pageSize = 8;
		var key = $('#key').val();
		var pageNum = Number($('#pageNum').val())+1;
  		key = encodeURIComponent(encodeURIComponent(key)).replace(/%20/g, "+");
  		$.ajax({
		   type: "GET",
		   url: "<%=basePath%>/toAnnouncement",
		   data: "key="+filter(key)+"&pageNum="+pageNum+"&pageSize="+pageSize+"&timestamp="+new Date().getTime()+"&ajaxAndroidSession=" + androidSession,
		   async:false,
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
		    	 $('#ulist_div').trigger("create");
		    	 $('#ulist').show();
		    	 $('#pageNum').val(pageNum);
		    	 //显示'查看更多'
		    	 var len = (msg.length-msg.replace(/(<tr)/g, '').length)/3;
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
</script>
<body>
<div id="list">
    <div id="div1">
    	<a class="return" href="javascript:history.back()"><img src="<%=basePath%>/imgnews/win8/list_return_btn.png" width="100%" /></a>
		<div class="logo" id="to_showmain"><img src="<%=basePath%>/imgnews/win8/list_logo.png" width="100%" /></div>
    </div>
    <div id="div2">
    	<h3 class="yellow" id="title">任免公告</h3>
    	<div class="searchBox">
	    	<table>
	    		<tr>
	    			<td><input class="text" type="text" id="key" placeholder="请输入标题关键字..." /></td>
	    			<td>
	    				<input class="btn" type="button" value="查询" onclick="qclick()"/>
	    				<input type="hidden" id="pageNum" value="0"/><!-- 当前页 -->
	    				<input type="hidden" id="li_cxt"/><!-- 内容 -->
						<input type="hidden" id="showmoreflag"/><!-- 是否显示更多 -->
	    			</td>
	    		</tr>
	    	</table>
    	</div>
    	<div id="ulist_div" class="tableBox">
    		<div id="querydiv" style="color: #403b65"></div>
	    	<table style="width: 100%">
	            	<tbody id="ulist">
	            	</tbody>
	        </table>	        
			<div id="morediv" class="moreBox" style="display: none;">
	   			<a class="more" onclick="moreclick()"  id="querymore">显示更多内容</a>
	   		</div>
        </div>
    </div>
</div>
<script type="text/javascript">
$(function(){
	$("#ulist").find("tr").live("click",function(){
		var unread = "1";
		if($(this).hasClass("bold")){
			$(this).removeClass("bold");
			$(this).addClass("ed");
			var unread = "0";
		}
		$('#li_cxt').val($('#ulist').html());
		var ggId = $(this).attr("id");
		location.href = "<%= basePath %>/announcementDetail?ggId="+ggId+"&unread="+unread;
	});
	
	$("#ulist").find("tr").live('touchstart',function(){
		$(this).addClass("on");
	});
	$("#ulist").find("tr").live('touchend',function(){
		$(this).removeClass("on");
	});
	$("#ulist").find("tr").live('touchmove',function(){
		$(this).removeClass("on");
	});
	$(".logo").click(function(){
		location.href ="<%=basePath%>/showmain";
	});
	
	
});
</script>
<%@include file="/titleControl.jsp" %>
</body>
</html>
