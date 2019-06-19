<%@page import="com.deppon.montal.model.LaywerApply"%>
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
				 	LaywerApply apply = (LaywerApply)request.getAttribute("laywerApply");
				 %>
				   <li class="first">工作流号：<em><%=apply.getProcessinstid() %></em>
				  	 <input type="hidden" id="workid" value="<%=apply.getProcessinstid()%>">
				   </li>
				   <li>申请类别：<em><%=apply.getCategory().equals("1")?"诉讼案件立案":"外请律师" %></em>
				   <li>案件名称：<em><%=apply.getName()%></em></li>
				   <li>涉案部门：<em><%=apply.getOrg() %></em></li>
				   <li>所属子公司：<em><%=apply.getChildcompany() %></em></li>
				   <li>涉案金额：<em><%=apply.getMoney() %></em></li>
				   <li>诉讼费：<em><%=apply.getLawsuitmoney() %></em></li>
				   <li>案件基本情况：<em><%=apply.getBasicinfo()%></em></li>
				   <li>请求事项：<em><%=apply.getApplyinfo() %></em></li>
				   <li>申请理由：<em><%=apply.getReason()==null?"":apply.getReason()%></em></li>
			</ul>
		</div>
		<%@include file="approve_process.jsp" %>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>