<%@page import="com.deppon.montal.model.OAUseSealApply"%>
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
	OAUseSealApply info = (OAUseSealApply)request.getAttribute("use_seal_apply");
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
					   <td>用章申请<input type="hidden" id ="type_id" value="usesealapply"></td>
					</tr>
					<tr><th>
					  姓名:</th><td>
					  <%=info.getName()==null?"":info.getName()%></td></tr>
				   
					 <tr><th>
					  工号:</th><td>
					  <%=info.getUserid()==null?"":info.getUserid()%></td></tr>
				   
				   <tr><th>
					  部门:</th><td>
					  <%=info.getDept()==null?"":info.getDept()%></td></tr>
				   
					 <tr><th>
					  所属事业部:</th><td>
					  <%=info.getArea()==null?"":info.getArea()%></td></tr>
				   
				   	<tr><th>
					  印章名称:</th><td>
					  <%=info.getSealname()==null?"":info.getSealname()%></td></tr>
				   
					 <tr><th>
					  印章类型:</th><td>
					  <%=info.getSealtype()==null?"":info.getSealtype()%></td></tr>
				   
				   <tr><th>
					  印章序号:</th><td>
					  <%=info.getSealsequencecode()==null?"":info.getSealsequencecode()%></td></tr>
				   
					 <tr><th>
					  印章份数:</th><td>
					  <%=info.getSealcounts()==null?"":info.getSealcounts()%></td></tr>
				   
				   <tr><th>
					  印章所属:</th><td>
					  <%=info.getSealdept()==null?"":info.getSealdept()%></td></tr>
				   
					<tr><th>
					  所属财务部:</th><td>
					  <%=info.getSealbrief()==null?"":info.getSealbrief()%></td></tr>
				   
				   <tr><th>
					  用章保管部门:</th><td>
					  <%=info.getSealasavedept()==null?"":info.getSealasavedept()%></td></tr>
				   
					 <tr><th>
					  需盖章资料名称:</th><td>
					  <%=info.getSealneedname()==null?"":info.getSealneedname()%></td></tr>
				   
				   <tr><th>
					  章全宗号:</th><td>
					  <%=info.getSealgeneralcode()==null?"":info.getSealgeneralcode()%></td></tr>
				   
					 <tr><th>
					  印章编号:</th><td>
					  <%=info.getSealcode()==null?"":info.getSealcode()%></td></tr>
				   
				   <tr><th>
					  使用日期:</th><td>
					  <%=info.getSealusedate().substring(0, 10)%></td></tr>
				   
					 <tr><th>
					  印章档号:</th><td>
					  <%=info.getSealarchivalcode()==null?"":info.getSealarchivalcode()%></td></tr>
				   
				   <tr><th>
					  申请事由:</th><td>
					  <%=info.getReason()==null?"":info.getReason()%></td></tr>
			     <%@include file="approve_process.jsp" %>
	    	</table>
	    </div>
	</div>
	 <%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>