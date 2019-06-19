<%@page import="com.deppon.montal.model.OACheckFileApply"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_ios.jsp" %>
</head>
<body>
	<div id="list">
		<%@include file="/jsp/ios/work_items_head.jsp" %>
		<div id="div2">
	    	<div class="ulBox2">
		    	<ul>
		    		<%
						OACheckFileApply apply = (OACheckFileApply)request.getAttribute("fileApply");
					%>
					<li class="first">工作流号：<em><%=apply.getProcessinstid() %></em>
					   <input type="hidden" id="workid" value="<%=apply.getProcessinstid()%>">
					</li>
					<li>工作流：<em>发文审核申请</em></li>
					
					<li>申请人：<em><%=apply.getName()%></em></li>
					<li>文件名称：<em><%=apply.getFilename()%></em></li>
					<li>所在部门：<em><%=apply.getApplydept()%></em></li>
					<li>文件类别：<em><%=apply.getFilecategory()%></em></li>
					<%
						if(apply.getPrevfilename()!=null){
					%>
					<li>原文件名称：<em><%=apply.getPrevfilename()==null?"":apply.getPrevfilename()%></em></li>
					<li>文件修改次数：<em><%=apply.getEditfilenum()==null?"":apply.getEditfilenum()%></em></li>
					<%
						}
					%>
					<li>适用范围：<em><%=apply.getUsearea()%></em></li>
					<li>申请事由：<em><%=apply.getRemark() == null ? "" : apply.getRemark()%></em></li>
				</ul>
			</div>
			<%@include file="approve_process.jsp"%>
		</div>
		<%@include file="workflow_approve_button.jsp"%>
	</div>
</body>
</html>