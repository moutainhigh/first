<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.model.OaAnnounceMent"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<% 
	String path = request.getContextPath();   
    String basePath = InitDataServlet.getValue("dpm_domain_url") + "://"   
            + request.getServerName() + ":" + request.getServerPort()   
            + path;   
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />
<meta content="telephone=no" name="format-detection" />
<meta http-equiv ="Content-Type" content ="application/xhtml+xml; charset=UTF-8" />
<title><%=InitDataServlet.getValue("page_title") %>-任免公告</title>
<link rel="stylesheet" href="<%=basePath %>/css/reset.css" />
<link rel="stylesheet" href="<%=basePath %>/css/win8/common.css" />
<link rel="stylesheet" href="<%=basePath %>/css/win8/list.css" />
<script type="text/javascript" src="<%=basePath %>/js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="<%= basePath %>/js/win8_auto_resize.js"></script>
</head>

<body>
<div id="list">
    <div id="div1">
    	<a class="return" href="javascript:history.back()"><img src="<%=basePath%>/imgnews/win8/list_return_btn.png" width="100%" /></a>
		<div class="logo" id="to_showmain"><img src="<%=basePath%>/imgnews/win8/list_logo.png" width="100%" /></div>
    </div>
    <!--div2 S-->
    <div id="div2">
    	<h3 class="yellow" id="title">公告详情</h3>
    	<div class="tableBox">
    	<%
    		OaAnnounceMent oaAnn = (OaAnnounceMent)request.getAttribute("oaAnn");
    	%>
    	<table>
            <tr>
            	<th width="35%">公告标题:</th>
            	<td><%=oaAnn.getHeader() %></td>
            </tr>
            <tr>
            	<th>发布日期:</th>
            	<td><%=FormatUtil.formatDate(oaAnn.getFbdate()) %></td>
            </tr>
            <tr>
            	<td colspan="2">
            		<%=oaAnn.getContent() %>
            	</td>
            </tr>
            
        </table>
        </div>
    </div>
    <!--div2 E-->
</div>
<%@include file="/titleControl.jsp" %>
</body>
<script type="text/javascript">
	$(".logo").click(function(){
		location.href ="<%=basePath%>/showmain";
	});
</script>

</html>
