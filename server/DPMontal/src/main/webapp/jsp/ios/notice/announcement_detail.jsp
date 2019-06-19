<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.model.OaAnnounceMent"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-任免公告</title>
	<%@include file="/common_ios.jsp" %>
</head>
<%
 request.setCharacterEncoding("UTF-8");
 response.setCharacterEncoding("UTF-8");
%>
<body>
	<div id="list">
	    <%@include file="/jsp/ios/work_items_head.jsp" %>
	    <div id="div2">
    		<div class="tableBox">
				<ul class="m-list role-con ul_detail">
				 <%
				  OaAnnounceMent oaAnn = (OaAnnounceMent)request.getAttribute("oaAnn");
				 %>
				 <li>
					<div class="">
						<b>标题:</b><%=oaAnn.getHeader() %>
					</div>
				</li>
				 <li>
					<div class="">
						<b>发布人:</b><%=oaAnn.getFbr()  %>
					</div>
				</li>
				 <li>
					<div class="">
						<b>发布日期:</b><%=FormatUtil.formatDate(oaAnn.getFbdate())  %>
					</div>
				</li>
				  <li></li>		 
				    
				    <li>
						<div class="">
						   	<%=oaAnn.getContent() %>
						</div>
				</li>
			  </ul>
			</div>
		</div>
	</div>
</body>
<script>
$(function(){
	$("#div2").find("li").live('touchstart',function(){
		$(this).addClass("on");
	});
	$("#div2").find("li").live('touchend',function(){
		$(this).removeClass("on");
	});
	$("#div2").find("li").live('touchmove',function(){
		$(this).removeClass("on");
	});
});
window.onload = function(){
  	$(".tit").find("img").attr("src","<%=basePath%>/imgnews/ios/notice_tit.png");
  	$(".return").find("img").attr("src","<%=basePath%>/imgnews/ios/ios_return.png");
  	$(".home").find("img").attr("src","<%=basePath%>/imgnews/ios/ios_home.png");
}
</script>
</html>