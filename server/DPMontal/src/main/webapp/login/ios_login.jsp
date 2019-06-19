<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@ page language="java" pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />
<meta http-equiv = "Content-Type" content = "application/xhtml+xml; charset=UTF-8" />
<meta http-equiv="pragma" content="no-cache" /> 
<meta http-equiv="Cache-Control" content="no-cache, must-revalidate" /> 
<meta http-equiv="expires" content="Thu, 01 Jan 1970 00:00:01 GMT" /> 
<meta http-equiv="expires" content="0" />
<% 
	
	String path = request.getContextPath();   
    String basePath = InitDataServlet.getValue("dpm_domain_url") + "://"   
            + request.getServerName() + ":" + request.getServerPort()   
            + path;   
%>
<title><%=InitDataServlet.getValue("page_title") %></title>
<link rel="stylesheet" href="<%=basePath %>/css/reset.css" />
<link rel="stylesheet" href="<%=basePath %>/css/ios/common.css" />
<link rel="stylesheet" href="<%=basePath %>/css/ios/login.css" />
<script src="<%=basePath%>/js/jquery-1.8.2.min.js"></script>
<script src="<%=basePath%>/js/jquery.base64.js"></script>
</head>
<body>
<div id="login">
	<!--div1 S-->
    <div id="div1">
    	<div class="logo"><img src="<%=basePath%>/imgnews/ios/ios_login_logo.jpg" width="100%" /></div>
        <div class="title">
        	<img src="<%=basePath%>/imgnews/ios/ios_login_title.jpg" width="100%" /><br />
        </div>
    </div>
    <!--div1 E-->
    <!--div2 S-->
 
	    <div id="div2">
	    	<form action="logincheck" method="post" id="loginform" name="loginform">
	    	<table>
	        	<tr>
	            	<th>工号：</th><td><input type="text" class="text" id="userid" name="userid" placeholder="请输入工号"/></td>
	            </tr>
	            <tr>
	            	<td colspan="2" class="space1">&nbsp;</td>
	            </tr>
	            <tr>
	            	<th>密码：</th><td><input type="password" class="text" id="password" name="password" placeholder="请输入密码 "/></td>
	            </tr>
	            <tr>
	            	<td colspan="2" class="space2">&nbsp;</td>
	            </tr>
	            <tr>
	            	<td colspan="2" style="overflow:hidden; text-align:right;">
	            	<label class='save' for="savePassword"><input type="checkbox" id="savePassword" name='isSave' checked="checked">记住我</label>
	            	<a style='float:right;' id="submit_btn" onclick="lgin();" class="button loginBtn"><em>登&nbsp;录</em></a>
	            	</td>
	            </tr>
	        </table>
	        </form>
	    </div>
 
    <!--div2 E-->
    <!--div3 S-->
    <div id="div3"><%=request.getAttribute("errors")==null?"":request.getAttribute("errors") %></div>
    <!--div3 E-->
    <!--div4 S-->
    <div id="div4">
    	<p>Copyright © <%= request.getAttribute("year")%> 德邦物流股份有限公司. All rights reserved.</p>
    </div>
    <!--div3 E-->
</div>
</body>
<script type="text/javascript">
function init() {
	var userid = getCookie('userid');
	//var pswd = getCookie('password');
	$('#userid').val(userid);
	//$('#password').val(pswd);
}
function setCookie(name, value) 
{ 
    var argv = setCookie.arguments; 
    var argc = setCookie.arguments.length; 
    var expires = (argc > 2) ? argv[2] : null; 
    if(expires!=null) 
    { 
        var largeExpDate = new Date(); 
        largeExpDate.setTime(largeExpDate.getTime() + (expires*1000*3600*24));         
    } 
    document.cookie = name + "=" + escape (value)+((expires == null) ? "" : ("; expires=" +largeExpDate.toGMTString())); 
}
// 获取cookie
function getCookie(Name) 
{ 
    var search = Name + "=" ;
    if(document.cookie.length > 0) 
    { 
        offset = document.cookie.indexOf(search) ;
        if(offset != -1) 
        { 
            offset += search.length ;
            end = document.cookie.indexOf(";", offset) ;
            if(end == -1) end = document.cookie.length ;
            return unescape(document.cookie.substring(offset, end)) ;
        } 
        else return "" ;
    } 
} 
// 删除cookie
function deleteCookie(name) 
{ 
   var expdate = new Date(); 
   expdate.setTime(expdate.getTime() - (86400 * 1000 * 1)); 
   setCookie(name, "", expdate); 
} 
function lgin(){
	setCookie('userid', $('#userid').val(), 30);
	//setCookie('password', $('#password').val(), 30);
	if(!mycheckbox()) {
		deleteCookie('userid');
		//deleteCookie('password');
	}
	if($('#userid').val() == ''){
		$('#div3').html("请输入工号！");
		$('#userid').focus();
	}else if($('#password').val() == ''){
		$('#div3').html("请输入密码！");
		$('#password').focus();
	}else {
		if(/^\d+$/.test($('#userid').val())){
            $.base64.utf8encode = true;
            var dec = $.base64.btoa($('#password').val());
            //设置base64
            $('#password').val(dec);
            
            $("#loginform").submit();   
        }else{
            $('#div3').html("工号或密码错误！");
        }
	}
}
//是否被选中验证有选中的return true,否return false 
function mycheckbox() { 
	var falg = 0; 
	$("input[name='isSave']:checkbox").each(function () { 
		if ($(this).attr("checked")) { 
		falg += 1; 
		} 
	}); 
	if (falg > 0) 
		return true; 
	else 
		return false; 
} 
$(function(){
	$(".logo").find("img").height(function(){
		return $(this).width();
	})
});
$(window).resize(function(){
	$(".logo").find("img").height(function(){
		return $(this).width();
	})
	$(".title").find("img").height(function(){
		return $(this).width()*0.7;
	})
});
$(document).keydown(function(e){
	if(e.keyCode == 13) {
		lgin();
	}
});
$(function(){

	init();
	var errorVal = $("#div3").html();
	if("工号或密码错误！" == errorVal)
		$('#password').focus();
});
function lgin(){
	setCookie('userid', $('#userid').val());
	//setCookie('password', $('#password').val());
	if(!mycheckbox()) {
		deleteCookie('userid');
		//deleteCookie('password');
	}
	if($('#userid').val() == ''){
		$('#div3').html("请输入工号！");
	}else if($('#password').val() == ''){
		$('#div3').html("请输入密码！");
	}else {
		if(/^\d+$/.test($('#userid').val())){
            $.base64.utf8encode = true;
            var dec = $.base64.btoa($('#password').val());
            //设置base64
            $('#password').val(dec);
            
            $("#loginform").submit();   
        }else{
            $('#div3').html("工号或密码错误！");
        }
	}	
}
</script>
</html>
