<%@page import="com.deppon.montal.model.LaywerApply"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.conf.F_Constants"%>
<%@page import="com.deppon.montal.model.OaContractApply"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_win8.jsp" %>
</head>
<%
	LaywerApply apply = (LaywerApply)request.getAttribute("laywerApply");
%>
<body>
<div id="list">
	<%@include file="wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
				<tr>
				   <th>工作流号:</th>
				   <td id="workid"><%=apply.getProcessinstid() %></td>
				</tr>
				<tr>
				   <th >申请类别:</th>
				   <td>
						<%=apply.getCategory().equals("1")?"诉讼案件立案":"外请律师" %>
				   </td>
				</tr>				
			    <tr>
				  <th >案件名称:</th>
				  <td><%=apply.getName() %></td>
			   </tr>
				 <tr>
				  <th >涉案部门:</th>
				  <td><%=apply.getOrg() %></td>
			   </tr>
			   <tr>
				  <th >所属子公司:</th>
				  <td><%=apply.getChildcompany() %></td>
			   </tr>
				 <tr>
				  <th >涉案金额:</th>
				  <td><%=apply.getMoney()%></td>
			   </tr>
				 <tr>
				  <th >诉讼费:</th>
				  <td><%=apply.getLawsuitmoney() %></td>
			   </tr>
				 <tr>
				  <th >案件基本情况:</th>
				  <td><%=apply.getBasicinfo() %></td>
			   </tr>	
				<tr>
					<th>请求事项:</th>
					<td><%=apply.getApplyinfo() %></td>
				</tr>
			    <tr>
				  <th >申请事由:</th>
				  <td style="word-wrap:break-word;word-break:break-all"><%=apply.getReason()==null?"":apply.getReason() %></td>
			    </tr>
			    <%@include file="approve_process.jsp" %>
		  </table>
		</div>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>