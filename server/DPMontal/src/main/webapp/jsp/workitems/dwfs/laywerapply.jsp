<%@page import="com.deppon.wfs.workflow.domain.LaywerapplyBean"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.module.workitems.webservice.client.DWFSWorkItemServiceClient"%>
<%@page import="com.deppon.wfs.workflow.domain.WarrantEntityBean"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_win8.jsp" %>
	<style>
	tr.details, tr.qytr { display:none;}
	</style>
</head>
<body onload="autoShowApproval()">
<%
	LaywerapplyBean info = (LaywerapplyBean)request.getAttribute("entity");
%>
<div id="list">
	<%@include file="../wf_head_win8.jsp" %>
	<input type="hidden" id="busino" value="<%=info.getBusino()%>">
	<input type="hidden" id="approval_url" value="<%=F_Constants.NORMOL_APPROVAL_URL%>">
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
    		   <tr>
				   <th>工作流号:</th>
				   <td id="workid"><%=request.getAttribute("processinstid")%></td>
				</tr>
				<tr>
				   <th>工&nbsp;&nbsp;作&nbsp;&nbsp;流:</th>
				   <td>诉讼案件立案/外请律师申请</td>
				</tr>
			   <tr>
				  <th>申请人:</th>
				  <td><%=info.getApplyPersonName()%></td>
			   </tr>
				 <tr>
				  <th>申请类别:</th>
				  <td><%=info.getAppCategory()%></td>
			   </tr>
			   <tr>
				  <th>案件名称:</th>
				  <td><%=info.getCaseName()%></td>
			   </tr>
			   <tr>
				  <th>涉案部门:</th>
				  <td><%=info.getOrg()%></td>
			   </tr>
			   <tr>
				  <th>涉案金额:</th>
				  <td><%=info.getMoney()%></td>
			   </tr>
			   <tr>
				  <th>诉讼费:</th>
				  <td><%=info.getLawsuitmoney()%></td>
			   </tr>
				<tr>
				  <th>所属子公司:</th>
				  <td><%=info.getChildcompany()%></td>
			   </tr>
			   <tr>
				  <th>立案基本情况:</th>
				  <td><%=info.getBasicinfo()%></td>
			   </tr>
			   <tr>
				  <th>请求事项:</th>
				  <td><%=info.getApplyinfo()%></td>
			   </tr>
				<tr>
				  <th>申请事由:</th>
				  <td><%=info.getReason()%></td>
			   </tr>
					   
			   <%@include file="approve_process.jsp" %>					   					   
	    	</table>
	    </div>
	</div>
	 <%@include file="workflow_approve_button.jsp" %>
</div>
</body>
<script type="text/javascript">
	$(function(){
			$("#rollback_but").hide();
	});
</script>
</html>