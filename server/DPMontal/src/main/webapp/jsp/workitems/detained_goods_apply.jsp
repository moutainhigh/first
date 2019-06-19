<%@page import="com.deppon.montal.model.OAKouhuoApply"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_win8.jsp" %>
</head>
<body>
<%
	OAKouhuoApply info = (OAKouhuoApply)request.getAttribute("detained_goods_apply");
%>
<div id="list">
	<%@include file="wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
	    		<tr>
					   <th>工作流号:</th>
					   <td id="workid"><%=info.getProcessinstid()%></td>
					</tr>
					<tr>
					   <th>工作流:</th>
					   <td>扣货申请<input type="hidden" id ="type_id" value="detained_goods_apply"></td>
					</tr>
				   <tr>
					  <th>扣货单号:</th>
					  <td><%=info.getKouhuodanhao()%></td>
				   </tr>
					 <tr>
					  <th>货物扣留所在部门:</th>
					  <td><%=info.getGoodsdetaininorgname()%></td>
				   </tr>
				   <tr>
					  <th>保价金额:</th>
					  <td><%=info.getInsuredamout()%></td>
				   </tr>
					 <tr>
					  <th>代收款金额:</th>
					  <td><%=info.getCollectionamout()%></td>
				   </tr>
				   <tr>
					  <th>申请事由:</th>
					  <td><%=info.getWhyapply()==null?"":info.getWhyapply()%></td>
				   </tr>
			     <%@include file="approve_process.jsp" %>
	    	</table>
	    </div>
	</div>
	 <%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>