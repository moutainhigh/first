<%@page import="com.deppon.montal.model.OmEmployee"%>
<%@ page language="java"  pageEncoding="UTF-8"%>
<%@page import="com.deppon.montal.util.InitDataServlet" %>
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
<title>德邦物流-通讯录</title>
<link rel="stylesheet" href="<%=basePath %>/css/reset.css" />
<link rel="stylesheet" href="<%=basePath %>/css/win8/common.css" />
<link rel="stylesheet" href="<%=basePath %>/css/win8/list.css" />
<script type="text/javascript" src="<%=basePath %>/js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/js/win8_auto_resize.js"></script>
</head>
<%
	OmEmployee emp = (OmEmployee)request.getAttribute("emp");
	String tel ="无";
	if(emp.getMobileNo()!=null){
		tel = emp.getMobileNo().replace(";", "</br>");
	}
%>
<body>
<div id="list">
    <div id="div1">
    	<a class="return" href="javascript:history.back()"><img src="<%=basePath%>/imgnews/win8/list_return_btn.png" width="100%" /></a>
		<div class="logo" id="to_showmain"><img src="<%=basePath%>/imgnews/win8/list_logo.png" width="100%" /></div>
    </div>
    <div id="div2">
    	<ul class="persInfo">
    		<li>姓名</li>
    		<li><%=emp.getEmpName() %>(工号:<%=emp.getUserId() %>)</li>
    		<li>手机</li>
    		<li><%=tel%></li>
    		<li>办公电话</li>
    		<li><%=emp.getTelephone()==null?"无": emp.getTelephone() %></li>
    		<li>邮箱</li>
    		<li><%=emp.getEmail()==null?"无": emp.getEmail() %></li>
    		<li>部门</li>
    		<li><%=emp.getOrgName()==null?"无":emp.getOrgName() %></li>
    		<li>职位</li>
    		<li><%=emp.getJobName()==null?"无":emp.getJobName() %></li>
    		<li>工作职责</li>
    		<li><%=emp.getWorkExp()==null?" ":emp.getWorkExp() %></li>
    	</ul>
    </div>
</div>
<script>
$(function(){
	$(".persInfo").find("li:even").addClass("yellow");
	$(".logo").click(function(){
		location.href ="<%=basePath%>/showmain";
	});
});

</script>
<%@include file="/titleControl.jsp" %>
</body>
</html>
