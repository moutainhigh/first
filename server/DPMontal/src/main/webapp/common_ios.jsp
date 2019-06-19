<%@page import="com.deppon.montal.util.InitDataServlet" %>
<% 
	
	String path = request.getContextPath();   
    String basePath = InitDataServlet.getValue("dpm_domain_url") + "://"   
            + request.getServerName() + ":" + request.getServerPort()   
            + path;   
%>
	<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />
	<meta content="telephone=no" name="format-detection" />
	<meta http-equiv = "Content-Type" content = "application/xhtml+xml; charset=UTF-8" />
	<link rel="stylesheet" href="<%=basePath %>/css/reset.css" />
	<link rel="stylesheet" href="<%=basePath %>/css/ios/common.css" />
	<link rel="stylesheet" href="<%=basePath %>/css/ios/list.css" />
	<script type="text/javascript" src="<%=basePath %>/js/jquery-1.8.2.min.js"></script>
	<script type="text/javascript" src="<%=basePath %>/js/ios_auto_resize.js"></script>
	<script>
	window.onload = function(){
	  	$(".tit").find("img").attr("src","<%=basePath%>/imgnews/ios/work_items_tit.png");
	  	$(".return").find("img").attr("src","<%=basePath%>/imgnews/ios/ios_return.png");
	  	$(".home").find("img").attr("src","<%=basePath%>/imgnews/ios/ios_home.png");
	}
	</script>
	<%@include file="/titleControl.jsp" %>