<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.WorkflowEntity"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.MaintenrequestVo"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.MaintenRequestEntity"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.MaintenRequestEntryEntity"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_ios.jsp" %>
</head>
<body>
 <%
 WorkflowEntity info = (WorkflowEntity)request.getAttribute("lspResponseEntity");
 MaintenrequestVo temp = info.getMaintenrequestVo();
 MaintenRequestEntity base = temp.getMaintenRequestEntity();
 MaintenRequestEntryEntity[] items = temp.getMaintenRequestEntryEntityList();
 %>
<div id="list">
	<%@include file="/jsp/ios/work_items_head.jsp" %>
	<div id="div2">
		<h4 class="yellow">基本信息-工程维修申请单</h4>
    	<div class="ulBox2">
	    	<ul>				  
          		<li>单据编号:<em><%=base.getFnumber() %></em></li>
				<li>申请部门:<em><%=base.getApplyDepart().getName()%></em></li>
				<li>申请时间:<em><%=base.getApplyTimeStr()%></em></li>
				<li>单据状态:<em><%=base.getBillState()%></em></li>
				<li>项目编码:<em><%=base.getProNumber().getProNumber()%></em></li>
				<li>所属大区:<em><%=base.getBelongsArea().getName()%></em></li>
			   	<li>所属工程部:<em><%=base.getBelongProDept().getName()%></em></li>
			   	<li>项目名称:<em><%=base.getProName()%></em></li>
			   	<li>维修项目所在地:<em><%=base.getRepproLocation()%></em></li>
			   	<li>预计维修金额:<em><%=base.getEstimatedAmountStr()%></em></li>
			   	<li>处理方式:<em><%=base.getApproach()%></em></li>
			   	<li>项目竣工时间:<em><%=base.getEndTimeStr()%></em></li>
			   	<li>项目维修分类:<em><%=base.getCfmaintenType()%></em></li>
			    <li>申请事由:<em><%=base.getApplyReason()%></em></li>
          	</ul>
        </div>
        <h4 class="yellow">其他信息-明细信息</h4>
	   	<div class="ulBox2">
    		<ul>
				<%for(int i = 0; i < items.length; i++ ) {%>
					<li>序号:<em><%= items[i].getSeqStr()%></em></li>
				   	<li>维修类别:<em><%= items[i].getRepairType().getMtname()%></em></li>
				    <li>维修事项:<em><%= items[i].getRepairMatter().getMname()%></em></li>
				   	<li>维修区域:<em><%= items[i].getRepairArea().getAname()%></em></li>
				    <li>损坏原因:<em><%= items[i].getDamageReason()%></em></li>
				    <li>期望维修时间:<em><%= items[i].getExpRepairTimeStr()%></em></li>
				    <li>维修性质:<em><%= items[i].getMaintenanceNature() %></em></li>
			   <%} %>
		   </ul>
	    </div>
	    <%@include file="approve_process_esb.jsp"%> 
	</div>
	<div>
		<ul id="msg" style="display: none"> 
			<li class="fyy-textCt"><em style="color: red">该节点暂不支持手机审批</em></li>
		</ul>
	</div>
	 <%@include file="workflow_approve_button_esb.jsp" %>
</div>
<script type="text/javascript">
$(document).ready(function(){
	var activitydefid = $('#activitydefid').val();
	if(activitydefid=="manualActivity1"){
		$('#msg').show();
		document.getElementById("agree_but").style.display = "none";
		document.getElementById("rollback_but").style.display = "none";
		document.getElementById("approve_area").style.display = "none";
	}
});
</script>
</body>

</html>