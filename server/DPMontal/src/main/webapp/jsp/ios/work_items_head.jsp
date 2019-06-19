<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="/js/jquery-1.8.2.min.js"></script>
</head>

	<style>
header {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 66px;
    background-color: #373c62;
    margin: 0;
    padding: 0;
    overflow: hidden;
    line-height: 46px;
    z-index: 1;
}

header h3 {
    text-align: center;
    color: #FFF;
    margin-top: 20px;
}

header span.back, .bar .buttons .back {
    display: block;
    position: absolute;
    width: 60px;
    height: 46px;
    border: 0;
    background-color: rgba(0, 0, 0, 0);
    top: 20px;
    left: 0;
    background-image: url(back.png);
    background-repeat: no-repeat;
    /*background-position: 4px 6px;*/
    background-position: 11px 15px;
    background-size: 10px auto;
}
</style>
<script type="text/javascript">
var header = document.querySelector("header");
var div2_temp = document.getElementById("div2");
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
$("textarea").focus(function(){
	if(isMobile=="IOS"){
        header.style.position = "relative";
        if(div2_temp)div2_temp.style.top = "0";
    }
});
$("textarea").blur(function(){
	setTimeout(function(){
		if(isMobile == "IOS"){
			header.style.position = "fixed";
			if(div2_temp)div2_temp.style.top = "66px";
		}
	},500);
});
/* element.bind("focus",function(event){
	var doTouch = function (e) {
        $timeout(function(){
            if (e.target != event.target && e.target.tagName != 'INPUT') {
                event.target.blur();
            }
            document.removeEventListener('touchend', doTouch, false);
        },300);
    }
    document.addEventListener('touchend', doTouch, false);
    if(localStorage.getItem("deviceType") == "IOS"){
        header.style.position = "relative";
    }
}).bind("blur",function(){
    $timeout(function(){
		if(localStorage.getItem("deviceType") == "IOS"){
			header.style.position = "fixed";
		}
	},500);
}) */
</script>
<%
   Object obj=request.getSession().getAttribute("version");
   if(obj!=null&&obj.toString().equals("new")){
	   %>
<header>
<span class="back" onclick="javascript:window.history.back()">
</span>
<h3>审批详情</h3>
</header>
   <%
   }
%>