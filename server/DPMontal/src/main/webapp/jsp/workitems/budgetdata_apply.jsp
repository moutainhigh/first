<%@page import="com.deppon.montal.model.OaBudgetdataApply"%>
<%@page import="com.deppon.montal.model.RecommandNewEMP"%>
<%@page import="com.deppon.montal.model.OaContractAdd"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.montal.conf.F_Constants"%>
<%@page import="com.deppon.montal.model.OaResignApply"%>
<%@page import="com.deppon.montal.conf.Constants"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_win8.jsp" %>
</head>
<body>
<% OaBudgetdataApply info = (OaBudgetdataApply)request.getAttribute("OaBudgetdataApply"); %>
<div id="list">
    <%@include file="wf_head_win8.jsp" %>
    <!--div2 S-->
    <div id="div2">
    	<h3 class="yellow">审批工作流</h3>
	    	<div class="tableBox">
		    	<table width="100%">
		    		<tr>
						<th>工作流号:</th>
						<td id="workid">
						<%=info.getProcessinstid() %>
						</td>
					</tr>
					<tr>
						<th>工作流:</th>
						<td>预算数据申请<input type="hidden" id ="type_id" value="budgetData"></td>
					</tr>
					<tr>
						<th>申请人:</th>
						<td><%=info.getName()%></td>
					</tr>
					<tr>
						<th>预算部门:</th>
						<td><%=info.getBudgetorgname()%></td>
					</tr>
					<tr>
						<th>工作流类型:</th>
						<td><%=info.getApptype()==null?"":info.getApptype()%></td>
					</tr>
					<tr>
						<th>预算年份:</th>
						<td><%=info.getBudgetdyeay()%></td>
					</tr>
					<%if("预算调整".equals(info.getApptype())){%>
		          	<tr>
						<th>预算月份:</th>
						<td><%=info.getBudgetdquaeter()%>月</td>
					</tr>
 	          		 <tr>
						<th>费用类型:</th>
						<td><%=info.getFeetype()%></td>
					</tr>
		            <tr>
						<th>费用金额:</th>
						<td><%=info.getRate()%></td>
					</tr>
          			<%}else{%>
         		   <tr>
						<th>预算季度:</th>
						<td>第<%=info.getBudgetdquaeter()%>季度</td>
					</tr>
      		    	<%} %>
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