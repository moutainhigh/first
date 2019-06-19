<%@page import="com.deppon.wfs.workflow.domain.RecommendNewEmpBean"%>
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
	RecommendNewEmpBean info = (RecommendNewEmpBean)request.getAttribute("entity");
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
					   <td>推荐新员工</td>
					</tr>
					   <tr><th>申请人:</th><td><%=info.getApplyPersonName()%></td></tr>
					   <tr><th>被推荐人姓名:</th><td><%=info.getRecommendedName()%></td></tr>
					   <tr><th>与申请人关系:</th><td><%=info.getRelation()%></td></tr>
					   <%if("m".equals(info.getRecommendedSex())){%>
						   <tr><th>被推荐人性别:</th><td>男</td></tr>
					   <%}else{%>
						   <tr><th>被推荐人性别:</th><td>女</td></tr>
					   <%} %>
					   <tr><th>被推荐人学历:</th><td><%=info.getRecommendedEdu()%></td></tr>
					   <tr><th>毕业院校:</th><td><%=info.getGraduateCollege()%></td></tr>
					   <tr><th>毕业年限:</th><td><%=info.getGraduateYears()%></td></tr>
					   <tr><th>推荐类型:</th><td><%=info.getRecommendedType()%></td></tr>
					   <tr><th>被推荐人欲入职区域:</th><td><%=info.getRecommendedArea()%></td></tr>
					   <%if("业务伙伴".equals(info.getRecommendedType())) {%>
						   <tr><th>推荐入职部门:</th><td><%=info.getRecommendedDept()%></td></tr>
					   <%} %>
					   <tr><th>申请事由:</th><td><%=info.getReason()==null?"":info.getReason()%></td></tr>
					   
				<%@include file="approve_process.jsp" %>					   					   
	    	</table>
	    </div>
	</div>
	 <%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>