<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.wdgh.inteface.domain.QueryWorkflowInfoResponse"%>
<%@page import="com.deppon.wdgh.inteface.domain.NewPointInfo"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<meta http-equiv = "Content-Type" content = "application/xhtml+xml; charset=UTF-8" />
	<%@include file="/common_ios.jsp" %>
	<style type="text/css">
	 li{word-wrap: break-word;}
	</style>
</head>
<%
QueryWorkflowInfoResponse infoNew = (QueryWorkflowInfoResponse)request.getAttribute("wdghBusiRsp");
NewPointInfo base = infoNew.getNewPointInfo();
%>
<body>
<div id="list">
	<%@include file="/jsp/ios/work_items_head.jsp" %>
    <!--div2 S-->
    <div id="div2">
    	<div class="ulBox2">
    		<ul>
				<li>工作流:<em>新点信息提交申请</em></li>
				<li>申请人姓名:<em><%= base.getCreateUserName()%></em></li>
				<li>申请人所在部门:<em><%=base.getCreateOrgName()%></em></li>
				<li>商铺租赁合同工作流号:<em><%=base.getRentcontractWorkflowno()%></em></li>
				<li>新点开设申请工作流号:<em><%=base.getNewDeptWorkflowNo()%></em></li>
				<li>合同开始时间:<em><%=FormatUtil.formatDate(base.getContractStartTime(),"yyyy/MM/dd")%></em></li>
				<li>合同结束时间:<em><%=FormatUtil.formatDate(base.getContractEndTime(),"yyyy/MM/dd")%></em></li>
				<li>办证时间:<em><%=FormatUtil.formatDate(base.getProcessingTime(), "yyyy/MM/dd")%></em></li>
				<li>新营业部名称:<em><%=base.getNewDeptName()%></em></li>
				<li>是否单点城市:<em><%="Y".equals(base.getIsSingledeptCity())?"是":"否"%></em></li>
				<li>区域:<em><%=base.getRegionCode()%></em></li>
				<li>物料发放办公室:<em><%=base.getMaterialReleaseOffice()%></em></li>
				<li>物料目的发放站:<em><%=base.getMaterialReleaseDest()%></em></li>
				<li>LMS工程项目编号:<em><%=base.getLmsProjectNo()==null?"旧点搬迁，无需录入":base.getLmsProjectNo()%></em></li>
				<li>人事部:<em><%=base.getPersonnelDepartmentCode()%></em></li>
				<li>所属事业部:<em><%=base.getBusinessDivsionCode()%></em></li>
				<li>申请事由:<em><%=base.getReason()%></em></li>	
		  </ul>
		</div>
		<%@include file="approve_process.jsp" %>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
<script type="text/javascript">
$(function(){
	var activitydefid = $("#activitydefid").val();
	//时效节点设计组负责人 不同意按钮隐藏
	if(activitydefid == "AgingNodeDesignPrincipal"){
		$("#disagree_but").hide();
	}
});
</script>
</body>
</html>