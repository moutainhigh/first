<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.wdgh.inteface.domain.QueryWorkflowInfoResponse"%>
<%@page import="com.deppon.wdgh.inteface.domain.NewPointInfo"%>
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
 NewPointInfo base = infoNew.getNewPointInfo();
 %>
<div id="list">
	<%@include file="../wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
				<tr><th>工作流:</th><td>新点信息提交申请</td></tr>
				<tr><th>申请人姓名:</th><td><%= base.getCreateUserName()%></td></tr>
				<tr><th>申请人所在部门:</th><td><%=base.getCreateOrgName()%></td></tr>
				<tr><th>商铺租赁合同工作流号:</th><td><%=base.getRentcontractWorkflowno()%></td></tr>
				<tr><th>新点开设申请工作流号:</th><td><%=base.getNewDeptWorkflowNo()%></td></tr>
				<tr><th>合同开始时间:</th><td><%=FormatUtil.formatDate(base.getContractStartTime(),"yyyy/MM/dd")%></td></tr>
				<tr><th>合同结束时间:</th><td><%=FormatUtil.formatDate(base.getContractEndTime(),"yyyy/MM/dd")%></td></tr>
				<tr><th>办证时间:</th><td><%=FormatUtil.formatDate(base.getProcessingTime(), "yyyy/MM/dd")%></td></tr>
				<tr><th>新营业部名称:</th><td><%=base.getNewDeptName()%></td></tr>
				<tr><th>是否单点城市:</th><td><%="Y".equals(base.getIsSingledeptCity())?"是":"否"%></td></tr>
				<tr><th>区域:</th><td><%=base.getRegionCode()%></td></tr>
				<tr><th>物料发放办公室:</th><td><%=base.getMaterialReleaseOffice()%></td></tr>
				<tr><th>物料目的发放站:</th><td><%=base.getMaterialReleaseDest()%></td></tr>
				<tr><th>LMS工程项目编号:</th><td><%=base.getLmsProjectNo()==null?"旧点搬迁，无需录入":base.getLmsProjectNo()%></td></tr>
				<tr><th>人事部:</th><td><%=base.getPersonnelDepartmentCode()%></td></tr>
				<tr><th>所属事业部:</th><td><%=base.getBusinessDivsionCode()%></td></tr>
				<tr><th>申请事由:</th><td><%=base.getReason()%></td></tr>
		  </table>
		  <%@include file="approve_process.jsp" %>
		</div>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
<script type="text/javascript">
$(function(){
	var activitydefid = $("#activitydefid").val();
	//时效节点设计组负责人 不同意按钮隐藏
	if(activitydefid == "AgingNodeDesignPrincipal"){
		$("#disagree_but").hide();
	}
});
</script>
</html>