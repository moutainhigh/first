<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.wdgh.inteface.domain.QueryWorkflowInfoResponse"%>
<%@page import="com.deppon.wdgh.inteface.domain.DeptInfoModify"%>
<%@page import="com.deppon.wdgh.inteface.domain.ModifyDeptDetail"%>
<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_win8.jsp" %>
</head>

<body>
 <%
 QueryWorkflowInfoResponse infoNew = (QueryWorkflowInfoResponse)request.getAttribute("wdghBusiRsp");
 DeptInfoModify base = infoNew.getDeptInfoModify();
 List<ModifyDeptDetail> modifyDeptDetail = base.getModifyDeptDetail();
 %>
<div id="list">
	<%@include file="../wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
				<tr><th>工作流:</th><td>营业部信息更改申请</td></tr>
				<tr><th>申请人姓名:</th><td><%= base.getCreateUserName()%></td></tr>
				<tr><th>所属事业部:</th><td><%=base.getBusinessDivsionName()%></td></tr>
				
				<tr class="yellow"><td colspan="2" >明细信息</td></tr>
					<%
					int modifyDeptDetailsize = modifyDeptDetail == null?0:modifyDeptDetail.size();
					for(int i = 0; i < modifyDeptDetailsize; i++ ) {
						ModifyDeptDetail detail = modifyDeptDetail.get(i);
					%>
					 <tr <%=i==0 ? "" : "class='topLine'" %>><th>部门名称:</th><td><%= detail.getDeptName()%></td></tr>
					 <% if("DEPTINFO_MODIFY_TYPE_DEPT_NAME".equals(detail.getModifyType())){%>
					 <tr><th>修改类型:</th><td>部门名称</td></tr>
					 <%} else if("DEPTINFO_MODIFY_TYPE_DEPT_TEL".equals(detail.getModifyType())){%>
					<tr><th>修改类型:</th><td>部门电话</td></tr>
					<%}  else if("DEPTINFO_MODIFY_TYPE_DEPT_FAX".equals(detail.getModifyType())){%>
					<tr><th>修改类型:</th><td>部门传真</td></tr>
					<%}  else if("DEPTINFO_MODIFY_TYPE_DEPT_ADDRESS".equals(detail.getModifyType())){%>
					<tr><th>修改类型:</th><td>部门地址</td></tr>
					<%}  else {%>
					<tr><th>修改类型:</th><td><%= detail.getModifyType()%></td></tr>
					<%} %>
				    <tr><th>修改前内容:</th><td><%= detail.getBeforeContent()%></td></tr>
				    <tr><th>修改后内容:</th><td><%= detail.getAfterContent()%></td></tr>
				   <%} %>
				<tr><th>申请事由:</th><td><%=base.getReason()%></td></tr>
		  </table>
		  <%@include file="approve_process.jsp" %>
		</div>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>