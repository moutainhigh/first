<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.module.workitems.webservice.client.DWFSWorkItemServiceClient"%>
<%@page import="com.deppon.wfs.workflow.domain.ArchivesLendingApplyBean"%>
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
ArchivesLendingApplyBean info = (ArchivesLendingApplyBean)request.getAttribute("entity");
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
					   <td>财务档案借阅申请 </td>
					</tr>
				   <tr>
					  <th>申请人:</th>
					  <td><%=info.getApplyPersonName()%></td>
				   </tr>
					 <tr>
					  <th>工号:</th>
					  <td><%=info.getApplyPersonId()%></td>
				   </tr>
				   <tr>
					  <th>部门:</th>
					  <td><%=info.getDepartment()%></td>
				   </tr>
					 <tr>
					  <th>职位:</th>
					  <td><%=info.getPosition()%></td>
				   </tr>
					 <tr>
					  <th>电子邮箱:</th>
					  <td><%=info.getEmail()%></td>
				   </tr>
				   
				   <tr>
					  <th>手机号码:</th>
					  <td><%=info.getTelphone()%></td>
				   </tr>
				   
				   <tr>
					  <th>档案所属财务部:</th>
					  <td><%=info.getFinancialDepartment()%></td>
				   </tr>
				   
				   <tr>
					  <th>档案所属子公司:</th>
					  <td><%=info.getSubCorporation()%></td>
				   </tr>
				   <tr>
					  <th>借阅性质:</th>
					  <td><%=info.getLendingNature()%></td>
				   </tr>
				   <%if("续借".equals(info.getLendingNature())){ %>
				   <tr>
					  <th>借阅工作流编号:</th>
					  <td><%=info.getLendingWorkflowNumber()%></td>
				   </tr>
				   <%}%>
				   <tr>
					  <th>借阅时间:</th>
					  <td><%=FormatUtil.formatDate(info.getLendingTime())%></td>
				   </tr>
				   <tr>
					  <th>归还时间:</th>
					  <td><%=FormatUtil.formatDate(info.getReturnTime())%></td>
				   </tr>
				   <tr>
					  <th>档案类型:</th>
					  <td><%=info.getFinancialType()%></td>
				   </tr>
				   <tr>
					  <th>档案分类:</th>
					  <td><%=info.getFinancialCategory()%></td>
				   </tr>
				   <tr>
					  <th>是否打印:</th>
					  <td><%=info.getIsPrint()%></td>
				   </tr>
				   <tr>
					  <th>档案明细:</th>
					  <td><%=info.getFinancialDetail()%></td>
				   </tr>
				   <tr>
					  <th>申请事由:</th>
					  <td><%=info.getApplyReasons()%></td>
				   </tr>
					
				<%@include file="approve_process.jsp" %>					   					   
	    	</table>
	    </div>
	</div>
	 <%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>