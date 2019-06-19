<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.WorkflowEntity"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.ProFassAssessVo"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.ProFasAssesEntity"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.ProFasAssesEntryEntity"%>
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
 ProFassAssessVo temp = info.getProFasAssesEntityVo();
 ProFasAssesEntity base = temp.getProFasAssesEntity();
 ProFasAssesEntryEntity[] items = temp.getProFasAssesEntryList();
 %>
<div id="list">
	<%@include file="/jsp/ios/work_items_head.jsp" %>
	<div id="div2">
		<h4 class="yellow">基本信息-工程项目可行性评估</h4>
    	<div class="ulBox2">
	    	<ul>				  
          		<li>项目编号:<em><%=base.getFprojectNumber() %></em></li>
				<li>申请人:<em><%=base.getApplyerName()%></em></li>
				<li>申请日期:<em><%=base.getFcreateTimeStr()%></em></li>
				<li>申请人部门:<em><%=base.getApplyDeptName()%></em></li>
				<li>所属事业部:<em><%=base.getBusDivision()%></em></li>
			   	<li>项目名称:<em><%=base.getFprojectName()%></em></li>
			   	<li>项目所在地:<em><%=base.getCfprojectSeat()%></em></li>
			   	<li>项目类型:<em><%=base.getCfprojectTypeName()%></em></li>
			   	<li>项目发起部门:<em><%=base.getCfstartDeptName()%></em></li>
			   	<li>项目级别:<em><%=base.getCfprojectLevelName()%></em></li>
			   	<li>施工类型:<em><%=base.getFconstructionTypeName()%></em></li>
			   	<li>项目发起时间:<em><%=base.getCfstartTimeStr()%></em></li>
			    <li>非网点分类:<em><%=base.getCfnotpionttypeName()%></em></li>
			    <li>估算金额（元）:<em><%=base.getCfreportedAmount()==null?"":base.getCfreportedAmount()%></em></li>
			    <li>设计评定预计难度:<em><%=base.getCfassessdifficult()%></em></li>
			    <li>评估分数:<em><%=base.getCfratingValue()==null?"":base.getCfratingValue()%></em></li>
			    <li>申请事由:<em><%=base.getCfassessideatow()%></em></li>
			    <li>评估意见:<em><%=base.getCfassessIdea()%></em></li>
          	</ul>
        </div>
        <h4 class="yellow">其他信息-风险评估</h4>
	   	<div class="ulBox2">
    		<ul>
				<%for(int i = 0; i < items.length; i++ ) {%>
					<li  <%=i==0?"class='first'":"class='line'" %> >序号:<em><%=i+1 %></em></li>
				   	<li>风险类别:<em><%= items[i].getCfdangertype()%></em></li>
				    <li>风险事项:<em><%= items[i].getDangermatter()%></em></li>
				   	<li>风险描述:<em><%= items[i].getCfdangerDescribe()%></em></li>
				    <li>风险重要性:<em><%= items[i].getDangerImportantName()==null?"":items[i].getDangerImportantName()%></em></li>
				    <li>风险发生频率:<em><%= items[i].getCfdangerRate()==null?"":items[i].getCfdangerRate()%></em></li>
			   <%} %>
		   </ul>
	    </div>
	    <%@include file="approve_process_esb.jsp"%> 
	</div>
	 <%@include file="workflow_approve_button_esb.jsp" %>
</div>
</body>

</html>