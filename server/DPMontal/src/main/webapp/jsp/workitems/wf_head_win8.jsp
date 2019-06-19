<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
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
/*     margin-bottom:85px; */
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
