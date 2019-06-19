<%@page import="java.util.List"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.dpm.module.acms.domain.SyncWorkflowinfoResponse"%>
<%@page import="com.deppon.dpm.module.acms.domain.CompanyFillChangeEntity"%>
<%@page import="com.deppon.dpm.module.acms.domain.ApproveEntity"%>
<%@page import="com.deppon.dpm.module.acms.domain.Attachment"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_win8.jsp" %>
</head>

<body>
 <%
 SyncWorkflowinfoResponse syncwfinfoResponse = (SyncWorkflowinfoResponse)request.getAttribute("acmsSyncResponse");
 CompanyFillChangeEntity info = syncwfinfoResponse.getCompanyFillChangeEntity();
 %>
<div id="list">
	<%@include file="../wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
	    			<tr>
						<th>工作流号:</th>
					   <td><%=request.getAttribute("processinstid")%></td>
					</tr>
					<tr>
						<th>业务编码:</th>
					   <td><%=request.getAttribute("busino")%></td>
					</tr>
					<tr>
					   <th>工&nbsp;&nbsp;作&nbsp;&nbsp;流:</th>
					   <td>证照补办及分公司变更申请 </td>
					</tr>
				   <tr>
					  <th>申请人:</th>
					  <td><%=info.getApplyName()%></td>
				   </tr>
					<tr>
					  <th>申请类别:</th>
					  <td><%=info.getApplyType()%></td>
				   </tr>
				   <tr>
					  <th>公司类型:</th>
					  <td><%=info.getCompanyType()%></td>
				   </tr>
				   <tr>
					  <th>公司名称:</th>
					  <td><%=info.getCompanyName()%></td>
				   </tr>
				   <tr>
					  <th>营业部名称:</th>
					  <td><%=info.getSalesDeptName()%></td>
				   </tr>
				   <%if(!"变更".equals(info.getApplyType())){%>
				   <tr>
					  <th>补办证照:</th>
					  <td><%=info.getLicenseType()%></td>
				   </tr>
				   <%} %>
				    <%if("变更".equals(info.getApplyType())){%>
				    <tr>
					  <th>变更类型:</th>
					  <td><%=info.getChangeType()%></td>
				   </tr>
				   <tr>
					  <th>变更前内容:</th>
					  <td><%=info.getChangeBefore()%></td>
				   </tr>
				  
					<tr>
					  <th>变更后内容:</th>
					  <td><%=info.getChangeAfter()%></td>
				   	</tr>					   
				   <%} %>
				   <tr>
					  <th>申请事由:</th>
					  <td><%=info.getReason() == null ? "" : info.getReason()%></td>
				   </tr>
		  	</table>
		  <%@include file="approve_process.jsp" %>
		</div>
		<%@include file="workflow_approve_button.jsp" %>
	</div>
</div>
<script type="text/javascript">
</script>
</body>
</html>