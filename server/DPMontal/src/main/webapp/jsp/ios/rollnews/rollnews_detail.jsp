<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.model.OaRollNews"%>
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
<%
	OaRollNews rollnew = (OaRollNews)request.getAttribute("rollnew");
%>
<body>
<div id="list">
    <%@include file="/jsp/ios/work_items_head.jsp" %>
    <div id="div2">
    	<h3 class="yellow"></h3>
    	<div class="tableBox2">
	    	<table style="width:100%">
	            <tr>
	            	<th style="text-align: center;"><%=rollnew.getHeader() %></th>
	            </tr>
	            <tr>
	            	<td style="padding:5px 5px 5px 0">发布时间:&nbsp;<%=FormatUtil.formatDate(rollnew.getFbdate(), "yyyy-MM-dd HH:mm") %></td>
	            </tr>
	            <tr>
	            	<td>
		            	<h5>
				    		<a href="<%=basePath %>/html5/index.html#/img/<%=basePath %>/oaupload/oaGg/detail/<%=rollnew.getFilename() %>"><img src="<%=basePath %>/oaupload/oaGg/detail/<%=rollnew.getFilename() %>" width="80%" /></a><br />
				    		<%=rollnew.getTpsm()==null?"":rollnew.getTpsm() %>
				    	</h5>
	            	</td>
	            </tr>
	            <tr>
	            	<td style="text-indent:48px;">
	            		<%=rollnew.getContent() %>
	            	</td>
	            </tr>
	        </table>
        </div>
    </div>
</div>
<script>
window.onload = function(){
  	$(".tit").find("img").attr("src","<%=basePath%>/imgnews/ios/news_tit.png");
  	$(".return").find("img").attr("src","<%=basePath%>/imgnews/ios/ios_return.png");
  	$(".home").find("img").attr("src","<%=basePath%>/imgnews/ios/ios_home.png");
  }
</script>

<script>
$(function(){
	$(".logo").click(function(){
		history.back();
	});
});
</script>
<%@include file="/titleControl.jsp" %>
</body>
</html>
