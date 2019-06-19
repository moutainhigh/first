<%@page import="com.deppon.wfs.workflow.domain.TruckPartBuyMaintainBean"%>
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
TruckPartBuyMaintainBean info = (TruckPartBuyMaintainBean)request.getAttribute("entity");
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
					   <td>货车配件采购/维修/保养</td>
<!-- 					   <input type="hidden" id ="type_id" value="qualification"> -->
					</tr>
				    <tr>
					  <th>申请人:</th>
					  <td><%=info.getApplyPersonName()%></td>
				   </tr>
					 <tr>
					<th> 所属事业部:</th>
					  <td><%=info.getArea()%></td><!-- DIP_DIVISION_NEW_ADD -->
				   </tr>
				   <tr>
					<th>  车牌号:</th>
					  <td><%=info.getCarNumber()  %></td>
				   </tr>
					 <tr>
					  <th>申请类型:</th>
					  <td><%=info.getCategory()%></td><!-- WFS_TRUCK_APPLY_TYPE -->
				   </tr>
					 <tr>
					<th>  报销费用:</th>
					  <td><%=info.getMoney() %> </td>
				   </tr>
				   <tr>
					 <th> 车辆类型:</th>
					  <td><%=info.getTruckType() %></td><!-- WFS_TRUCK_TYPE -->
				   </tr>
 					   <tr>
						  <th>申请事由:</th>
						  <td><%=info.getApplyReason()%></td>
					   </tr>
				<%@include file="approve_process.jsp" %>					   					   
	    	</table>
	    </div>
	</div>
	 <%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>