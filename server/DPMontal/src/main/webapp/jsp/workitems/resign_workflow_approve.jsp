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
<% OaResignApply info = (OaResignApply)request.getAttribute(Constants.PAGE_RESULT); %>
<div id="list">
   <%@include file="wf_head_win8.jsp" %>
    <!--div2 S-->
    <div id="div2">
    	<h3 class="yellow">审批工作流</h3>
	    	<div class="tableBox">
		    	<table>
		    		<tr>
						<th>工作流号:</th>
						<td id="workid"><%=info.getProcessinstid() %></td>
					</tr>
					<tr>
						<th>工作流:</th>
						<td>辞职申请<input type="hidden" id ="type_id" value="resign"></td>
					</tr>
					<tr>
						<th>申请辞职人员:</th>
						<td><%=info.getEmpname()%></td>
					</tr>
					<tr>
						<th>申请辞职人员工号:</th>
						<td><%=info.getEmpuserid()%></td>
					</tr>
					<tr>
						<th>申请人职位:</th>
						<td><%=info.getPosition()%></td>
					</tr>
					<tr>
						<th>所属部门:</th>
						<td><%=info.getAppdept()%></td>
					</tr>
		
					<tr>
						<th>入职日期:</th>
						<td><%=info.getJoindate()%></td>
					</tr>
					<tr>
						<th>辞职人员工作年限:</th>
						<td><%=info.getWorkyears()%>个月</td>
					</tr>
					<tr>
						<th>辞职人员近6个月ABC:</th>
						<td><%=info.getAbc()%></td>
					</tr>
					<tr>
						<th>差错编号:</th>
						<td><%=info.getErrorno()== null ? "":info.getErrorno()%></td>
					</tr>
					<tr>
						<th>辞职人员现任岗位类别:</th>
						<td><%=info.getPostsort()%></td>
					</tr>
					<tr>
						<th>辞职人员是否评优:</th>
						<td><%=info.getIsgood()%></td>
					</tr>
					<tr>
						<th>辞职人员所在人事部:</th>
						<td><%=info.getPersonneldept()%></td>
					</tr>
					<tr>
						<th>辞职主要原因:</th>
						<td><%=info.getResignreason()%></td>
					</tr>
					<tr>
						<th>辞职类型:</th>
						<td><%="1".equals(info.getResigntype()) ? "辞职" : "2".equals(info.getResigntype()) ?"自离":""%></td>
					</tr>
					<%if(!info.getIsreserve().equals("否")){ %>
					<tr>
						<th>辞职人是否参加储干:</th>
						<td><%=info.getIsreserve()%></td>
					</tr>
					<tr>
						<th>第几届储干:</th>
						<td>第<%=info.getReservedate()%> 届</td>
					</tr>
					<tr>
						<th>储干名次:</th>
						<td>第<%=info.getReserveno()%> 名</td>
					</tr>
					<%} %>
					<tr>
						<th>申请事由:</th>
						<td style="word-wrap:break-word;word-break:break-all"><%=info.getApplyreason()== null ? "" : info.getApplyreason()%></td>
					</tr>
					<%@include file="approve_process.jsp" %>
		    	</table>
	    </div>
    <%@include file="workflow_approve_button.jsp" %>
   </div>
</div>
</body>
</html>