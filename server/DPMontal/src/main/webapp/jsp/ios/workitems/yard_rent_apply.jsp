<%@page import="com.deppon.montal.model.OAYardrentApply"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
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
<%
	OAYardrentApply apply = (OAYardrentApply)request.getAttribute("yardrentApply");
%>
<body>
<div id="list">
	<%@include file="/jsp/ios/work_items_head.jsp" %>
    <!--div2 S-->
    <div id="div2">
    	<div class="ulBox2">
    		<ul>
				<li class="first">工作流号：<em><%=apply.getProcessinstid() %></em>
				  	 <input type="hidden" id="workid" value="<%=apply.getProcessinstid()%>">
				</li>
				<li>工作流：<em>场地租赁申请</em></li>
				
				
				<li>申请人：<em><%=apply.getName() %></em></li>
				<li>工号:<em><%=apply.getEmpcode() %></em></li>
				<li>签订类型：<em><%=apply.getSigntype() %></em></li>
				<%
			   		if(null != apply.getSigntype() && (apply.getSigntype().equals("续签") 
			   				 || apply.getSigntype().equals("变更") || apply.getSigntype().equals("作废"))){
			    %>
				<li>原合同编号：<em><%=apply.getOldcontarctnum() %></em></li>
				<%
			   		}
			    %>
				<li>所属财务部：<em><%=apply.getFinancedept()%></em></li>
				<li>所属事业部：<em><%=apply.getArea() %></em></li>
				<li>所属公共事务组：<em><%=apply.getMatterTeam()==null?"":apply.getMatterTeam()%></em></li>
				<li>所属子公司：<em><%=apply.getChildcompany() %></em></li>
				<li>出租方名称：<em><%=apply.getRentname()%></em></li>
				<li>承租方名称：<em><%=apply.getLeasename() %></em></li>
				<li>承租部门：<em><%=apply.getLeasedept() %></em></li>
				<li>承租房屋面积：<em><%=apply.getLeasecreage() %></em></li>
				<li>每年租金：<em><%=apply.getYearrental() %></em></li>
				<li>付款方式：<em><%=apply.getPaytype() %></em></li>
				<li>租赁开始日期：<em><%=apply.getStartdate() %></em></li>
				<li>租赁结束日期：<em><%=apply.getEnddate() %></em></li>
				<li>免租开始日期：<em><%=apply.getRentfreebgdate() %></em></li>
				<li>免租结束日期：<em><%=apply.getRentfreeenddate() %></em></li>
				<li>租赁类型：<em><%=apply.getLeasetype() %></em></li>
				<li>工程项目编号：<em><%=apply.getProjectid() %></em></li>
				<li>工程项目名称：<em><%=apply.getProjectname() %></em></li>
			    <li>申请理由：<em><%=apply.getReason()==null?"":apply.getReason()%></em></li>
		  </ul>
		</div>
		<%@include file="approve_process.jsp" %>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>