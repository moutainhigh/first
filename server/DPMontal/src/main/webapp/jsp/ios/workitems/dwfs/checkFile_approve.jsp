<%@page import="com.deppon.wfs.workflow.domain.CheckFileApplyBean"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.module.workitems.webservice.client.DWFSWorkItemServiceClient"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_ios.jsp" %>
</head>
<%
 request.setCharacterEncoding("UTF-8");
 response.setCharacterEncoding("UTF-8");
%>
<%
	CheckFileApplyBean info = (CheckFileApplyBean)request.getAttribute("entity");
%>
<body>
<div id="list">
<%@include file="/jsp/ios/work_items_head.jsp" %>
   <!--div2 S-->
   <div id="div2">
	   	<div class="ulBox2">
			<ul>
			 
			   <li class="first">工作流号:
			        <em><%=request.getAttribute("processinstid") %>
					<input type="hidden" id="busino" value="<%=info.getBusino()%>">
					<input type="hidden" id="approval_url" value="<%=F_Constants.NORMOL_APPROVAL_URL%>">
			   		</em>
			   </li>
			   <li>工作流:<em>
		   		    管理文件发布申请
			   </em></li>
					  <li>申请人:<em>
					  <%=info.getApplyPersonName()%></em>
				   </li>
					 
					  <li>文件责任部门：<em>
					  <%=info.getApplydept()%></em>
				   </li>
				   
					  <li>文件名称 ：<em>
					  <%=info.getFileName()%></em>
				   </li>
					 
					  <li>申请类型：<em>
					  <%=info.getAppType()%></em>
				   </li>
				   
				   	  <li>文件页数 ：<em>
					  <%=info.getFliePage()%></em>
				   </li>
					 
					  <li>文件类型：<em>
					  <%=info.getFileCategory()%></em>
				   </li>
				   
					  <li>文件过期日期 ：<em>
					  <%=FormatUtil.formatDate(info.getFileOverdueDate()) %></em>
				   </li>
					 
					  <li>适用范围：<em>
					  <%=info.getUsearea()%></em>
				   </li>
				   
				   
					<%if("2".equals(info.getAppTypeCode())){%>
					  <li>原文件名称 ：<em>
					  <%=info.getPrevFilename()%></em>
				   </li>
				   
					  <li>修订次数：<em>
					  <%=info.getEditFileNum()%></em>
				   </li>
				     <%} %>
				    <%if(info.getFileCode()!= null){%>
						  <li>文件编号 ：<em>
					  <%=info.getFileCode()%></em>
				   </li>
				    <%} %>
				   <%if(info.getRelatedDepartments()!= null){%>
					  <li>涉及业务部门：<em>
					  <%=info.getRelatedDepartments()%></em>
				   </li>
					  <%} %>
					  <li>文件摘要：<em>
					  <%=info.getFileSummary()%></em>
				   </li>
				     <li>申请事由:<em>
					  <%=info.getRemarks()%></em>
				   </li>
				 </ul>
			</div>
			<%@include file="approve_process.jsp" %>
	</div>
	<div>
		<ul id="msg" style="display: none"> 
			<li class="fyy-textCt"><em style="color: red">此节点暂不支持手机审批</em></li>
		</ul>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
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
</html>