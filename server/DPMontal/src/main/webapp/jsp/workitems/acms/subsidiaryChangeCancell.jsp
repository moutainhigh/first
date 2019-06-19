<%@page import="java.util.List"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.dpm.module.acms.domain.SyncWorkflowinfoResponse"%>
<%@page import="com.deppon.dpm.module.acms.domain.SubSiDiarySetEntity"%>
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
 SubSiDiarySetEntity info = syncwfinfoResponse.getSubSiDiarySetEntity();
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
					   <td>子公司设立、变更及注销申请 </td>
					</tr>
				   <tr>
					  <th>申请人:</th>
					  <td><%=info.getApplyName()%></td>
				   </tr>
					<tr>
					  <th>申请类别:</th>
					  <td><%=info.getType()%></td>
				   </tr>
				   <tr>
					  <th>子公司名称:</th>
					  <td><%=info.getSubCompany()%></td>
				   </tr>
				   <tr>
					  <th>所属区域:</th>
					  <td><%=info.getArea()%></td>
				   </tr>
				   <tr>
					  <th>所属财务部:</th>
					  <td><%=info.getFinanceDep()%></td>
				   </tr>
				   <tr>
					  <th>所属公共事务组:</th>
					  <td><%=info.getCompenSation()%></td>
				   </tr>
				   <tr>
					  <th>所属薪酬组:</th>
					  <td><%=info.getMatterTeam()%></td>
				   </tr>
				   <%if(!"设立".equals(info.getType())){%>
					<tr>
					  <th>变更类型:</th>
					  <td><%=info.getUpdateType()%></td>
				   	</tr>		
				   <%} %>
				   
				    <%if("变更".equals(info.getType())){%>
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