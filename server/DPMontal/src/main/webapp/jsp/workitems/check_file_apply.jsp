<%@page import="com.deppon.montal.model.OACheckFileApply"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.montal.conf.F_Constants"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_win8.jsp" %>
</head>
<body>
<div id="list">
	<%@include file="wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
	    		<%
					OACheckFileApply apply = (OACheckFileApply)request.getAttribute("fileApply");
				%>
				<tr>
				   <th>工作流号:</th>
				   <td id="workid"><%=apply.getProcessinstid()%></td>
				</tr>
				<tr>
				   <th>工作流:</th>
				   <td>发文审核申请</td>
				</tr>
				<tr>
					<th>申请人:</th>
					<td><%=apply.getName()%></td>
				</tr>
			    <tr>
				   <th>文件名称:</th>
				   <td><%=apply.getFilename()%></td>
				</tr>
				<tr>
				   <th>所在部门:</th>
				   <td><%=apply.getApplydept()%></td>
				</tr>
				<tr>
				   <th>文件类别:</th>
				   <td><%=apply.getFilecategory()%></td>
				</tr>
				<%
					if(apply.getPrevfilename()!=null){
				%>
				<tr>
				   <th>原文件名称:</th>
				   <td><%=apply.getPrevfilename()==null?"":apply.getPrevfilename()%></td>
				</tr>
				<tr>
				   <th>文件修改次数:</th>
				   <td><%=apply.getEditfilenum()==null?"":apply.getEditfilenum()%></td>
				</tr>
				<%
					}
				%>
				<tr>
				   <th>适用范围:</th>
				   <td><%=apply.getUsearea()%></td>
				</tr>
			    <tr>
				  <th>申请事由:</th>
				  <td style="word-wrap:break-word;word-break:break-all"><%=apply.getRemark()==null?"":apply.getRemark() %></td>
			    </tr>
			    <%@include file="approve_process.jsp" %>
		  </table>
		</div>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>