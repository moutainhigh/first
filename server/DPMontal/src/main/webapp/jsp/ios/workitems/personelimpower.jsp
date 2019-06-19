<%@page import="com.deppon.montal.model.OAPersonelimPower"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.conf.F_Constants"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<meta http-equiv = "Content-Type" content = "application/xhtml+xml; charset=UTF-8" />
	<%@include file="/common_ios.jsp" %>
	<style type="text/css">
	 li{word-wrap: break-word;}
	</style>
</head>
<body>
<div id="list">
	<%@include file="/jsp/ios/work_items_head.jsp" %>
    <!--div2 S-->
    <div id="div2">
    	<div class="ulBox2">
    		<ul>
				<%
					OAPersonelimPower powerApply = (OAPersonelimPower)request.getAttribute("powerApply");
				%>
				<li class="first">工作流号：<em><%=powerApply.getProcessinstid() %></em>
			  	 <input type="hidden" id="workid" value="<%=powerApply.getProcessinstid()%>">
			    </li>
				<li>工作流：<em>人事授权申请</em></li>
				<li>申请人：<em><%=powerApply.getApplyname() %></em></li>
				<li>授权给：<em><%=powerApply.getImpowerto() %></em></li>
				<li>授权开始日期：<em><%=FormatUtil.formatDate(powerApply.getImpowerstarttime())%></em></li>
				<li>授权结束日期：<em><%=FormatUtil.formatDate(powerApply.getImpowerendtime()) %></em></li>
				<!-- <li>是否授权审批工作流：<em><%=powerApply.getIsauthorized()==null?"":powerApply.getIsauthorized() %></em></li> -->
				<li>申请事由：<em><%=powerApply.getReason()==null?"":powerApply.getReason()%></em></li>
			</ul>
		</div>
		<%@include file="approve_process.jsp" %>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>