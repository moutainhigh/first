<%@page import="com.deppon.wfs.workflow.domain.CommissionMakeOrChangeBean"%>
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
	CommissionMakeOrChangeBean info = (CommissionMakeOrChangeBean)request.getAttribute("entity");
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
			   
			   	<li>工作流:<em>营运提成单项奖设立与调整申请</em></li>
			   	<li>申请人姓名:<em><%=info.getApplyPersonName()%></em></li>
			   	<li>工号:<em><%=info.getApplyPersonId()%></em></li>
			   	<li>申请人部门:<em><%=info.getDept()%></em></li>
	   			<li>所属经营本部:<em><%=info.getOperationDepartment()%></em></li>
				<li>申请类别:<em><%=info.getApplyType()%></em></li>
				<li>是否涉及薪资调整:<em><%=info.getRelateSalary()%></em></li>
			   	<li>申请事由:<em><%=info.getApplyReason()%></em></li>
					
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
$(function(){
	var activitydefid = $("#activitydefid").val();
	if("manualActivity14" == activitydefid){
		//最后一个节点 只有同意按钮
		$("#disagree_but").hide();
		$("#rollback_but").hide();
	}else if("manualActivity2" == activitydefid || "manualActivity5" == activitydefid || "manualActivity6" == activitydefid){
		$("#btnbox").hide();
		$("#approve_area").hide();
		$("#msg").show();
	}
	//回退按钮隐藏
	if("manualActivity10" == activitydefid || "manualActivity12" == activitydefid || 
			"manualActivity9" == activitydefid || "manualActivity11" == activitydefid){
		$("#rollback_but").hide();
	}
});
</script>
</html>