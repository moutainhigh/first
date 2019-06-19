<%@page import="com.deppon.wfs.workflow.domain.ProcessManagementBean"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
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
ProcessManagementBean info = (ProcessManagementBean)request.getAttribute("entity");
%>
<body>
<div id="list">
<%@include file="/jsp/ios/work_items_head.jsp" %>
   <!--div2 S-->
   <div id="div2">
	   	<div class="ulBox2">
			<ul>
			   <li>
						工作流号:
						<em id="workid"><%=request.getAttribute("processinstid")%></em>
					</li>
					<li>
						工&nbsp;&nbsp;作&nbsp;&nbsp;流:
						<em>流程管理工作流</em>
					</li>
					<li>
						申请人:
						<em><%=info.getApplyPersonName()%></em>
					</li>
					<li>
					  申请人工号:
					  <em><%=info.getApplyPersonId()%></em>
				   </li>
					 <li>
					  申请人部门:
					  <em><%=info.getApplydeptname()%></em>
				   </li>
				   <li>
					  申请类型：
					  <em><%=info.getApplyType()%></em><!-- WFS_PROCESS_MANAGEMENT_APPLY_TYPE -->
				   </li>
				   <%
				   	String applyType = info.getApplyType();
				   	if ("清单变更".equals(applyType) ) {
				   %>
					<li>
					  清单级别：
					  <em><%=info.getBillLevel()%></em><!-- WFS_BILL_LEVEL -->
				   </li>
				    <li>
					  流程名称：
					  <em><%=info.getApplyProcessName()%></em>
				   </li>
				   <li>
					  清单类型：
					  <em><%=info.getBillType()%></em><!-- WFS_BILL_TYPE -->
				   </li>
				   <%
				   	}
				   	else if ("流程入基线".equals(applyType)) {
				   %>
				    <li>
					  流程名称：
					  <em><%=info.getApplyProcessName()%></em>
				   </li>
				   <li>
					  版本号：
					  <em><%=info.getVersionno()%></em>
				   </li>
				     <li>
					  入基线类型：
					  <em><%=info.getBaselineType()%></em><!-- WFS_BASELIN_TYPE -->
				   </li>
				    <li>
					  所属支撑组：
					  <em><%=info.getSupportGroup()%></em><!-- WFS_SUPPORT_GROUP -->
				   </li>
				   <li>
					  是否流程优化：
					  <em><%=info.getProcessImprove()%></em><!-- WFS_REFER_FINANCIAL -->
				   </li>
				   <li>
					  是否涉及流程目标或绩效变更：
					  <em><%=info.getProcessGoalSalchange()%></em><!-- WFS_REFER_FINANCIAL -->
				   </li>
				   <li>
					  流程是否为三级以下：
					  <em><%=info.getUnder3level()%></em><!-- WFS_REFER_FINANCIAL -->
				   </li>
				   <%
				   	}else if ("流程发布".equals(applyType)) {
				    %>
					<li>
					  流程名称：
					  <em><%=info.getApplyProcessName()%></em>
				   </li>
				    <li>
					  版本号：
					  <em><%=info.getVersionno()%></em>
				   </li>
				   <%
				   	}%>
				  <li>
						  申请事由:
						  <em><%=info.getApplyReason()%></em>
				  </li>
			</ul>
		</div>
		<%@include file="approve_process.jsp" %>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
<script type="text/javascript">
$(function(){
	//流程监控组负责人、所属流程支撑组负责人、流程相关部门负责人、一级流程部门负责人、二级流程部门负责人、流程管理部负责人
	//manualActivity7，manualActivity1，manualActivity10，manualActivity4，manualActivity11，manualActivity12，manualActivity3，manualActivity5
// 	var activitydefid = $("#activitydefid").val();
// 	if(activitydefid != 'manualActivity7' 
// 			&& activitydefid != 'manualActivity1' 
// 			&& activitydefid != 'manualActivity10' 
// 			&& activitydefid != 'manualActivity4' 
// 			&& activitydefid != 'manualActivity11' 
// 			&& activitydefid != 'manualActivity12' 
// 			&& activitydefid != 'manualActivity3' 
// 			&& activitydefid != 'manualActivity5'){
// 		$("#div3").hide();
// 		$("#approve_area").hide();
// 		var html = "<div id='div_span'><span style='color:red;float:left;text-align:center;line-height:20px;width: 100%;font-size: 20px;'>该节点未设置手机端，请至网页端审批，谢谢。</span></div>";
// 		$("body").append(html);
// 	}
});
</script>
</html>