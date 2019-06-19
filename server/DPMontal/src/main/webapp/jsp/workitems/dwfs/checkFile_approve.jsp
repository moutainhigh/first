<%@page import="com.deppon.wfs.workflow.domain.CheckFileApplyBean"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.module.workitems.webservice.client.DWFSWorkItemServiceClient"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_win8.jsp" %>
	<style>
	tr.details, tr.qytr { display:none;}
	tr.skill, tr.qytr { display:none;}
	</style>
</head>
<body onload="autoShowApproval()">
<%
	CheckFileApplyBean info = (CheckFileApplyBean)request.getAttribute("entity");
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
					   <td>管理文件发布申请<input type="hidden" id ="type_id" value="qualification"></td>
					</tr>
					<tr>
						<th>申请人：</th>
						<td><%=info.getApplyPersonName()%></td>
					</tr>
					<tr>
						<th>文件责任部门：</th>
						<td><%=info.getApplydept()%></td>
					</tr>
				   <tr>
					  <th>文件名称 ：</th>
					  <td><%=info.getFileName()%></td>
				   </tr>
					 <tr>
					  <th>申请类型：</th>
					  <td><%=info.getAppType()%></td>
				   </tr>
				   <tr>
					  <th>文件页数 ：</th>
					  <td><%=info.getFliePage()%></td>
				   </tr>
					<tr>
					  <th>文件类型：</th>
					  <td><%=info.getFileCategory()%></td>
				   </tr>
				   <tr>
					  <th>文件过期日期 ：</th>
					  <td><%=FormatUtil.formatDate(info.getFileOverdueDate())%></td>
				   </tr>
				     <tr>
					  <th>适用范围：</th>
					  <td><%=info.getUsearea()%></td>
				   </tr>
				   <%if("2".equals(info.getAppTypeCode())){%>
					<tr>
					  <th>原文件名称 ：</th>
					  <td><%=info.getPrevFilename()==null?"":info.getPrevFilename()%></td>
				   </tr>
				   <tr>
					  <th>修订次数：</th>
					  <td><%=info.getEditFileNum()==null?"":info.getEditFileNum()%></td>
				   </tr>
				   <%}%>
				   <%if(info.getFileCode()!= null){%>
						<tr>
							<th>文件编号 ：</th>
						  	<td><%=info.getFileCode()== null ? "" : info.getFileCode()%></td>
					   	</tr>
				   <%}%>
				   <%if(info.getRelatedDepartments()!= null){%>
						<tr>
							<th>涉及业务部门：</th>
						  	<td><%=info.getRelatedDepartments()== null ? "" :info.getRelatedDepartments() %></td>
					   	</tr>
				   <%}%>
					   	<tr>
							<th>文件摘要：</th>
						  	<td><%=info.getFileSummary()%></td>
					   	</tr>
						
					   	<tr>
						  <th>申请事由:</th>
						  <td><%=info.getRemarks()%></td>
					   </tr><br>
				<%@include file="approve_process.jsp" %>		
							   					   
	    	</table>
	    	<table width="100%" style="display: none" id="msg">
				<tr><td style="color: red" align="center" colspan="2">此节点暂不支持手机审批</td></tr>
			</table>
	    </div>
	</div>
	 <%@include file="workflow_approve_button.jsp" %>
	 
</div>
<script type="text/javascript">
	$(document).ready(function(){
		var activitydefid=$('#activitydefid').val();
		if(activitydefid == 'manualActivity1'){
			$('#msg').show();
			document.getElementById("disagree_but").style.display = "none";
			document.getElementById("agree_but").style.display = "none";
			document.getElementById("rollback_but").style.display = "none";
			document.getElementById("approve_area").style.display = "none";
		}else{
			document.getElementById("rollback_but").style.display = "none";
			$("#textarea-a").attr("placeholder","1.文件中涉及本部门内容无异议，审批“同意”；2.文件中涉及本部门内容需修改，请备注修改意见，审批“不同意”");
		}
			
	});
</script>
</body>
</html>