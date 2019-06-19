<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.deppon.montal.util.InitDataServlet,com.deppon.montal.module.workitems.action.ToApproveAction,com.deppon.montal.login.model.LoginUser,java.util.Date" %>
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
<%
//报错预警
ToApproveAction ap=new ToApproveAction();
//获取用户信息
LoginUser login = (LoginUser)request.getSession().getAttribute("loginUser");
if(login!=null){
	String flowtype=(String)request.getSession().getAttribute("newflowtype");
	String busino=(String)request.getSession().getAttribute("newbusino");
	String issuccess="0";
	String errorInfo="errorPage.jsp 系统繁忙请稍后重试  界面中代码错误 请检查";
	System.out.println(errorInfo);
	ap.requestClient(login.getUserId(), flowtype, new Date(), new Date(), busino, issuccess, null, errorInfo);
}
%>
<body>
<%
   Object obj=request.getSession().getAttribute("version");
   if(obj!=null&&obj.toString().equals("new")){
	   %>
<header>
<span class="back" onclick="javascript:window.history.back()">
</span>
<h3>审批详情</h3>
</header>
<%} %>
<div style="margin-top:85px;">

对不起，系统繁忙，请稍后重试。

</div>
</body>
</html>