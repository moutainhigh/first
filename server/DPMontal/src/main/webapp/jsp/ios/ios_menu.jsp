<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="com.deppon.montal.util.InitDataServlet" %>
<% 
	
	String pathMenu = request.getContextPath();   
    String basePathMenu = InitDataServlet.getValue("dpm_domain_url") + "://"   
            + request.getServerName() + ":" + request.getServerPort()   
            + pathMenu;   
%>
<div id="slideMenu">
	<div class="slideMenuCnt">
		<div class="arrowT"></div>
		<div class="fyy-clear"></div>
		<ul>
			<li style="border:none;"><a href="<%=basePathMenu%>/showmain">返回首页</a></li>
			<li><a href="<%=basePathMenu%>/toWorkItemsList">待办事项</a></li>
			<li><a href="<%=basePathMenu%>/jsp/ios/rollnews/rollnews_list.jsp">图片新闻</a></li>
			<li><a href="<%=basePathMenu%>/jsp/ios/notice/appoint_rmoval_announcement.jsp">任免公告</a></li>
			<li><a href="<%=basePathMenu%>/jsp/ios/addresslist/addr_query.jsp">通讯录</a></li>
		</ul>
	</div>
	<div class="slideMenuBg"></div>
</div>
<script>
$(function(){
	$("#div1").find(".home").click(function(){
		$("#slideMenu").toggle();
		$("#slideMenu").find(".slideMenuCnt").slideToggle(500);
	});
	$("#slideMenu").find(".slideMenuBg").click(function(){
		$("#slideMenu").find(".slideMenuCnt").slideUp(500);
		setTimeout(hideSlide,500);
	});
	$("#slideMenu").find("li").live("touchstart",function(){
		$(this).addClass("on");
	});
	$("#slideMenu").find("li").live('touchend',function(){
		$(this).removeClass("on");
	});
	$("#slideMenu").find("li").live('touchmove',function(){
		$(this).removeClass("on");
	});
});
function hideSlide(){
	$("#slideMenu").hide();
}
</script>