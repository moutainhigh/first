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
<% RecommandNewEMP info = (RecommandNewEMP)request.getAttribute("RecommandNewEMP"); %>
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
						<td>推荐新员工<input type="hidden" id ="type_id" value="contractinfo"></td>
					</tr>
					<tr>
						<th>申请人:</th>
						<td><%=info.getApplyname()%></td>
					</tr>
					<tr>
						<th>被推荐人姓名:</th>
						<td><%=info.getRecommendedname()%></td>
					</tr>
					<tr>
						<th>与申请人关系:</th>
						<td><%=info.getRelation()%></td>
					</tr>
					<tr>
						<th>被推荐人性别:</th>
						<td><%=info.getRecommendedsex()%></td>
					</tr>
					<tr>
						<th>被推荐人学历:</th>
						<td><%=info.getRecommendededu()%></td>
					</tr>
					<tr>
						<th>毕业院校:</th>
						<td><%=info.getGraduatecollege()%></td>
					</tr>
					<tr>
						<th>毕业年限:</th>
						<td><%=info.getGraduateyears()%></td>
					</tr>
					<tr>
						<th>推荐类型:</th>
						<td><%=info.getRecommendedtype()%></td>
					</tr>
					<tr>
						<th>被推荐人欲入职区域:</th>
						<td><%=info.getRecommendedarename()%></td>
					</tr>
					<%if("亲属关系".equals(info.getRecommendedtype())){%>
					
					<% }else{%>
					<tr>
						<th>推荐入职部门:</th>
						<td><%=info.getRecommendeddeptname()%></td>
					</tr>
					<%} %>
					<tr>
						<th>申请事由:</th>
						<td><%=info.getRecommendedreason()==null?"":info.getRecommendedreason()%></td>
					</tr>
					<%@include file="approve_process.jsp" %>
		    	</table>
	    </div>
    <%@include file="workflow_approve_button.jsp" %>
   </div>
</div>
</body>
</html>