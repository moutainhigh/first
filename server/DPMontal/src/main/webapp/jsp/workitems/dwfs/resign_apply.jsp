<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.module.workitems.webservice.client.DWFSWorkItemServiceClient"%>
<%@page import="com.deppon.wfs.workflow.domain.ResignationBean"%>
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
ResignationBean info = (ResignationBean)request.getAttribute("entity");
%>
<div id="list">
	<%@include file="../wf_head_win8.jsp" %>
	<input type="hidden" id="busino" value="<%=info.getBusino()%>">
	<input type="hidden" id="approval_url" value="<%=F_Constants.RESIGN_APPROVAL_URL%>">
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
					   <td>辞职申请</td>
					</tr>
				   <tr>
					  <th>申请人:</th>
					  <td><%=info.getApplyPersonName()%></td>
				   </tr>
					 <tr>
					  <th>申请人工号:</th>
					  <td><%=info.getApplyPersonId()%></td>
				   </tr>
				   <tr>
					  <th>申请人职位:</th>
					  <td><%=info.getPosition()%></td>
				   </tr>
					 <tr>
					  <th>所属部门:</th>
					  <td><%=info.getAppDept()%></td>
				   </tr>
					 <tr>
					  <th>辞职类型:</th>
					  <td><%=info.getResignTypeName()%></td>
				   </tr>
				   <tr>
					  <th>入职日期:</th>
					  <td><%=info.getJoinDateStr()%></td>
				   </tr>
				   <%if("1".equals(info.getResignType())){ %>
				   <tr>
					  <th>直属上级级别:</th>
					  <td><%=info.getSuperiorDegreeName()%></td>
				   </tr>
				   <% }%>
					 <tr>
					  <th>工作年限:</th>
					  <td><%=info.getWorkYears()%></td>
				   </tr>
				   <%if("2".equals(info.getSuperiorDegree())|| "3".equals(info.getSuperiorDegree())){%>
				   <tr>
					  <th>岗位类型:</th>
					  <td><%=info.getPostsortName()%></td>
				   </tr>
				    <%if("2".equals(info.getSuperiorDegree())){%>
					   <% if("2".equals(info.getPostsort())){%>
					    <tr>
						  <th>是否管理岗位:</th>
						  <td><%=info.getIsManagerName()%></td>
					   </tr>
					   <%}%>
					<%}%>
				   <%}%>
					 <tr>
					  <th>所在人事部:</th>
					  <td><%=info.getPersonnelDeptName()%></td>
				   </tr>
					 <tr>
					  <th>辞职原因:</th>
					  <td><%=info.getResignReason()==null?"":info.getResignReason()%></td>
				   </tr>
				   <tr>
					  <th>差错编号:</th>
					  <td><%=info.getErrorNo()==null?"":info.getErrorNo()%></td>
				   </tr>				   
				   
				   <tr>
					  <th>申请事由:</th>
					  <td><%=info.getApplyReason()%></td>
				   </tr>
				<%@include file="approve_process.jsp" %>					   					   
	    	</table>
	    	
	    	<table width="100%" style="display: none" id="msg">
				<tr><td style="color: red" align="center" colspan="2">该节点暂不支持手机审批</td></tr>
			</table>
	    </div>
	</div>
	 <%@include file="workflow_approve_button.jsp" %>
</div>
<script type="text/javascript">
$(function(){
	var activitydefid=$('#activitydefid').val();
	if(activitydefid=="manualActivity2"){
		$('#disagree_but').hide();
		$('#agree_but').text("已回收");
	};
	if(activitydefid=="manualActivity6"){
		$('#msg').show();
		document.getElementById("disagree_but").style.display = "none";
		document.getElementById("agree_but").style.display = "none";
		document.getElementById("rollback_but").style.display = "none";
		document.getElementById("approve_area").style.display = "none";
	}
});
</script>
</body>
</html>