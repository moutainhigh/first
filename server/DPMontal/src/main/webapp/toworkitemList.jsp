<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% 
	String path = request.getContextPath();   
    String basePath = InitDataServlet.getValue("dpm_domain_url") + "://"   
            + request.getServerName() + ":" + request.getServerPort()   
            + path;   
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script>
   window.onload=function(){
   var ua = navigator.userAgent;
    	    isAndroid = /Android/i.test(ua);
    	    isBlackBerry = /BlackBerry/i.test(ua);
    	    isWindowPhone = /IEMobile/i.test(ua);
    	    isIOS = /iPhone|iPad|iPod/i.test(ua);
    	    isMobile = isAndroid || isBlackBerry || isWindowPhone || isIOS;
    	    if (isAndroid)
    	        isMobile = 'android';
    	    if (isBlackBerry)
    	        isMobile = 'BlackBerry';
    	    if (isWindowPhone)
    	        isMobile = 'WindowPhone';
    	    if (isIOS)
    	        isMobile = 'IOS';
   	   		if(isMobile=="IOS"){
	         	window.location.href = "js-call://IOS/ReturnToIndex";
	    	}else{
	    		window.androidApi.input();
	    	}
	    	}
</script>
<!-- <body>
<header>
<span class="back" onclick="javascript:window.history.back()">
</span>
<h3>审批详情</h3>
</header>
<div style="margin-top:85px;">

<a href="javascript:test()">testtesttest</a>
</div>
</body> -->
</html>