<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.WorkflowEntity"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.ProFassAssessVo"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.ProFasAssesEntity"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.ProFasAssesEntryEntity"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_win8.jsp" %>
</head>

<body>
 <%
 WorkflowEntity info = (WorkflowEntity)request.getAttribute("lspResponseEntity");
 ProFassAssessVo temp = info.getProFasAssesEntityVo();
 ProFasAssesEntity base = temp.getProFasAssesEntity();
 ProFasAssesEntryEntity[] items = temp.getProFasAssesEntryList();
 %>
<div id="list">
	<%@include file="../wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table>
	    		<tr><th colspan="2" class="yellow">基本信息</th></tr>
	    		<tr><th>工&nbsp;&nbsp;作&nbsp;&nbsp;流:</th><td>工程项目可行性评估</td></tr>
	    		<tr><th>项目编号:</th><td id="workid"><%=base.getFprojectNumber() %></td></tr>
				<tr><th>申请人:</th><td><%=base.getApplyerName()%></td></tr>
				<tr><th>申请日期:</th><td><%=base.getFcreateTimeStr()%></td></tr>
				<tr><th >申请人部门:</th><td><%=base.getApplyDeptName()%></td></tr>
				<tr><th >所属事业部:</th><td><%=base.getBusDivision()%></td></tr>
			   	<tr><th >项目名称:</th><td><%=base.getFprojectName()%></td></tr>
			   	<tr><th >项目所在地:</th><td><%=base.getCfprojectSeat()%></td></tr>
			   	<tr><th >项目类型:</th><td><%=base.getCfprojectTypeName()%></td></tr>
			   	<tr><th >项目发起部门:</th><td><%=base.getCfstartDeptName()%></td></tr>
			   	<tr><th >项目级别:</th><td><%=base.getCfprojectLevelName()%></td></tr>
			   	<tr><th >施工类型:</th><td><%=base.getFconstructionTypeName()%></td></tr>
			   	<tr><th >项目发起时间:</th><td><%=base.getCfstartTimeStr()%></td></tr>
			    <tr><th >非网点分类:</th><td><%=base.getCfnotpionttypeName()%></td></tr>
			    <tr><th >估算金额（元）:</th><td><%=base.getCfreportedAmount()==null?"":base.getCfreportedAmount()%></td></tr>
			    <tr><th >设计评定预计难度:</th><td><%=base.getCfassessdifficult()%></td></tr>
			    <tr><th >评估分数:</th><td><%=base.getCfratingValue()==null?"":base.getCfratingValue()%></td></tr>
			    <tr><th >申请事由:</th><td><%=base.getCfassessideatow()%></td></tr>
			    <tr><th >评估意见:</th><td><%=base.getCfassessIdea()%></td></tr>

				<tr class="yellow"><td colspan="2" >其他信息-风险评估</td></tr>
				<%for(int i = 0; i < items.length; i++ ) {%>
					<tr <%=i==0 ? "" : "class='topLine'" %>><th>序号:</th><td><%=i+1 %></td></tr>
				   	<tr><th>风险类别:</th><td><%= items[i].getCfdangertype()%></td></tr>
				    <tr><th>风险事项:</th><td><%= items[i].getDangermatter()%></td></tr>
				   	<tr><th>风险描述:</th><td><%= items[i].getCfdangerDescribe()%></td></tr>
				    <tr><th>风险重要性:</th><td><%= items[i].getDangerImportantName()==null?"":items[i].getDangerImportantName()%></td></tr>
				    <tr><th>风险发生频率:</th><td><%= items[i].getCfdangerRate()==null?"":items[i].getCfdangerRate()%></td></tr>
			   <%} %>
		  </table>
		  <%@include file="approve_process_esb.jsp" %>
		</div>
	</div>
	<%@include file="workflow_approve_button_esb.jsp" %>
</div>
<script type="text/javascript">

</script>
</body>
</html>