<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.wfs.workflow.domain.ManagerGrowthStagePassBean"%>
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
 		ManagerGrowthStagePassBean info = (ManagerGrowthStagePassBean)request.getAttribute("entity");
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
			   <li>工作流:<em> 管理人员转正成长期通过</em></li>
			   <li>申请人姓名:<em><%=info.getApplyPersonName()%></em></li>
				   <li>工号:<em><%=info.getApplyPersonId()%></em></li>
				   <li>申请人部门:<em><%=info.getApplyDepartment()%></em></li>
				   <li>所属区域:<em><%=info.getBelongArea()%></em></li>
				   <li>申请类别:<em><%=info.getApplyType()%></em></li>
				   <%if("管理人员转正".equals(info.getApplyType())){%>
					   <li>转正类别:<em><%=info.getPositiveType()%></em></li>
				   <%} %>
				   <%if("管理人员成长期通过".equals(info.getApplyType())){%>
				   	   <li>成长期通过类别:<em><%=info.getGrowthStageType()%></em></li>
					   <li>考核等级:<em><%=info.getAssessGrade()%></em></li>
					   <li>岗位:<em><%=info.getPost()%></em></li>
					   <li>转正工作流号:<em><%=info.getPositiveProcessinstid()%></em></li>
					   <li>转正日期:<em><%=FormatUtil.formatDate(info.getPositiveDate())%></em></li>
				   <%} %>
				   <li>任命日期:<em><%=FormatUtil.formatDate(info.getAppointDate())%></em></li>
				   <%if(null != info.getIfNegotiateSalary() && !"".equals(info.getIfNegotiateSalary())){%>
					   <li>是否谈判工资:<em><%=info.getIfNegotiateSalary()%></em></li>
				   <%} %>
				   <%if("是".equals(info.getIfNegotiateSalary())){%>
					   <li>谈判工资金额:<em><%=info.getNegotiateSalary()%></em></li>
					   <li>生效日期:<em><%=FormatUtil.formatDate(info.getEfficientDate())%></em></li>
				   <%} %>
				   <li>申请事由:<em><%=info.getApplyReason()==null?"":info.getApplyReason()%></em></li>
			</ul>
		</div>
		<%@include file="approve_process.jsp" %>
	</div>
	<div>
		<ul id="msg" style="display: none"> 
			<li class="fyy-textCt"><em style="color: red">该节点暂不支持手机审批</em></li>
		</ul>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
<script type="text/javascript">
$(document).ready(function(){
	var activitydefid = $('#activitydefid').val();
	if(activitydefid=="manualActivity5"){
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