<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/ext" prefix="ext"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head lang="en">
<meta charset="UTF-8">
<title>消息推送</title>
<link type="text/css" href="/dpm/styles/bootstrap.min.css" rel="stylesheet" media="screen">
<script type="text/javascript" src="/dpm/scripts/js/jquery-2.0.0.js"></script>
<script type="text/javascript" src="/dpm/scripts/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/dpm/scripts/js/config.js"></script>

<script type="text/javascript">
	var url = location.search;
	var id = '';
	if (url.indexOf('?') >= 0) {
		id = url.substring(url.indexOf('?'));
	}

	$.ajax({
		type : "get",
		url : "/dpm/dpmManage/getMessage.action" + id,
		success : function(aaa) {
			var a = JSON.parse(aaa);
			$("#title").html(a.title);
			$("#content").html(a.content);
			$("#time").html(a.pushTime);
		},
		error : function(e) {
			alert("服务器异常，请稍后再试");
		}
	});
</script>
<style type="text/css">
#container {
	margin: 5px;
}
</style>
</head>
<body>
	<div id="container">
	<b>标题：</b>
	<div id="title"></div>
	<br> 
	<b>时间：</b>
	<div id="time"></div>
	<br> 
	<b>内容：</b>
	<br>
	<div id="content"></div>
	</div>
</body>
</html>