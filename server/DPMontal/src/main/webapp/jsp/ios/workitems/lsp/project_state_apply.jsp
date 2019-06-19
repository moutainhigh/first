<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.WorkflowEntity"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.ProjectStatusVo"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.ProjectStatusEntity"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.ProjectStatusEntry"%>
<%@page import="java.util.List"%>
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
	 ProjectStatusVo temp = info.getProjectStatusVo();
	 ProjectStatusEntity base = temp.getProjectStatusEntity();
	 List<ProjectStatusEntry> items1 = temp.getProjectStatusEntry();
 %>
<div id="list">
	<%@include file="/jsp/ios/work_items_head.jsp" %>
	<div id="div2">
		<h4 class="yellow">基本信息</h4>
    	<div class="ulBox2">
	    	<ul>				  
				<li>工&nbsp;&nbsp;作&nbsp;&nbsp;流:<em>工程项目状态申请单</em></li>
				<li>单据编号:<em><%=base.getFnumber()%></em></li>
				<li>申请人:<em><%=base.getFapplypersonIdAsName()%></em></li>
				<li>申请日期:<em><%=base.getCfpetitionDateStr()%></em></li>
				<li>申请部门:<em><%=base.getCfpetitionOrgIdAsName()%></em></li>
				<li>申请状态:<em><%=base.getCfpetitionState()%></em></li>
			   	<li>项目状态:<em><%=base.getFprojectState()%></em></li>
			   	<li>项目编号:<em><%=base.getCfprojectNumberIdAsName()%></em></li>
			   	<li>项目名称:<em><%=base.getFprojectName()%></em></li>
			   	<li>项目发起部门:<em><%=base.getCfstartDeptIdAsName()%></em></li>
			   	<li>申请原因:<em><%=base.getCfpetitionCause()%></em></li>
			   	<li>暂停原因:<em><%=base.getCfpauseCause()%></em></li>
          	</ul>
        </div>
        <h4 class="yellow">会审意见</h4>
        <div class="ulBox2">
	    	<ul>				  
			   	<li>会议主题:<em><%=base.getCfmeetingTheme()%></em></li>
			    <li>会议时间:<em><%=base.getCfjudgeDateStr()%></em></li>
			    <li>会审人员:<em><%=base.getFjudgeContainerAsName()%></em></li>
			    <li>会审决策:<em><%=base.getCfjudgereSolve()%></em></li>
          	</ul>
        </div>
        <h4 class="yellow">其他信息-变更明细</h4>
	   	<div class="ulBox2">
    		<ul>
			   <%for(int i = 0; i < items1.size() ; i++ ) {
				   ProjectStatusEntry obj1 = items1.get(i);
				%>
					<li <%=i==0?"class='first'":"class='line'"%>>序号:<em><%=i+1 %></em></li>
				    <li>会议主题:<em><%= obj1.getCfWaitMatter()%></em></li>
				    <li>负责人:<em><%= obj1.getCfResponsibleIdAsName()%></em></li>
				   	<li>完成时间:<em><%= obj1.getCfFinishTimeStr()%></em></li>
				    <li>备注:<em><%= obj1.getCfComment()%></em></li>
			   <%} %>
		   </ul>
	    </div>
	   
	    <%@include file="approve_process_esb.jsp"%> 
	</div>
	 <%@include file="workflow_approve_button_esb.jsp" %>
</div>
</body>

</html>