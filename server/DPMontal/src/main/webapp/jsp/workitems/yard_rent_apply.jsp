<%@page import="com.deppon.montal.model.OAYardrentApply"%>
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
	OAYardrentApply apply = (OAYardrentApply)request.getAttribute("yardrentApply");
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
				   <th >工作流:</th>
				   <td>
						场地租赁申请
				   </td>
				</tr>
				<tr>
				   <th >申请人:</th>
				   <td><%=apply.getName() %></td>
				</tr>
				
			    <tr>
				  <th >工号:</th>
				  <td><%=apply.getEmpcode() %></td>
			   </tr>
				 <tr>
				  <th >签订类型:</th>
				  <td><%=apply.getSigntype() %></td>
			   </tr>
			   <%
			   		if(null != apply.getSigntype() && (apply.getSigntype().equals("续签") 
			   				 || apply.getSigntype().equals("变更") || apply.getSigntype().equals("作废"))){
			   %>
			   <tr>
				  <th>原合同编号:</th>
				  <td><%=apply.getOldcontarctnum() %></td>
			   </tr>
			   <%
			   		}
			   %>
			   <tr>
				  <th >所属财务部:</th>
				  <td><%=apply.getFinancedept()%></td>
			   </tr>
				 <tr>
				  <th >所属事业部:</th>
				  <td><%=apply.getArea() %></td>
			   </tr>
				 <tr>
				  <th>所属公共事务组:</th>
				  <td><%=apply.getMatterTeam()==null?"":apply.getMatterTeam()%></td>
			   </tr>	
				<tr>
					<th>所属子公司:</th>
					<td><%=apply.getChildcompany() %></td>
				</tr>		
				
				<tr>
					<th>出租方名称:</th>
					<td><%=apply.getRentname()%></td>
				</tr>
				<tr>
					<th>承租方名称:</th>
					<td><%=apply.getLeasename() %></td>
				</tr>
				<tr>
					<th>承租部门:</th>
					<td><%=apply.getLeasedept() %></td>
				</tr>
				<tr>
					<th>承租房屋面积:</th>
					<td><%=apply.getLeasecreage() %></td>
				</tr>
				<tr>
					<th>每年租金:</th>
					<td><%=apply.getYearrental() %></td>
				</tr>
				<tr>
					<th>付款方式:</th>
					<td><%=apply.getPaytype() %></td>
				</tr>
				
				<tr>
					<th>租赁开始日期:</th>
					<td><%=apply.getStartdate() %></td>
				</tr>
				<tr>
					<th>租赁结束日期:</th>
					<td><%=apply.getEnddate() %></td>
				</tr>
				<tr>
					<th>免租开始日期:</th>
					<td><%=apply.getRentfreebgdate() %></td>
				</tr>
				<tr>
					<th>免租结束日期:</th>
					<td><%=apply.getRentfreeenddate() %></td>
				</tr>
				<tr>
					<th>租赁类型:</th>
					<td><%=apply.getLeasetype() %></td>
				</tr>
				<tr>
					<th>工程项目编号:</th>
					<td><%=apply.getProjectid() %></td>
				</tr>
				<tr>
					<th>工程项目名称:</th>
					<td><%=apply.getProjectname() %></td>
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