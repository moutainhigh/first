<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>

<%@page import="com.deppon.nhr.module.remote.dpm.shared.domain.workflow.QueryWorkflowInfoResponse" %>
<%@page import="com.deppon.nhr.module.remote.dpm.shared.domain.workflow.TransferInfo" %>
<%@page import="com.deppon.montal.util.FormatUtil" %>

<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_ios.jsp" %>
</head>
<body>
 <%
 QueryWorkflowInfoResponse hrBusiRsp = (QueryWorkflowInfoResponse)request.getAttribute("hrBusiRsp");
 TransferInfo info = hrBusiRsp.getTransferInfo();
 %>
<div id="list">
	<%@include file="/jsp/ios/work_items_head.jsp" %>
	<div id="div2">
		<h4 class="yellow">基本信息-异动调动申请</h4>
    	<div class="ulBox2">
    		<ul>
	    		<li>申请单编号:<em><%=info.getWfno()==null?"":info.getWfno() %></em></li>
				<li>申请人姓名:<em><%=info.getApplypsnname()==null?"":info.getApplypsnname() %></em></li>
			   	<li>申请人工号:<em><%= info.getApplypsncode()==null?"":info.getApplypsncode() %></em></li>
			   	<li>申请人职位:<em><%= info.getBeforeposition() == null ? "" : info.getBeforeposition()%></em></li>
			   	<li>入职日期:<em><%=info.getGroupdef1()%></em></li>
			   	<li>申请时间:<em><%=info.getApplydate()==null?"":FormatUtil.formatDate(info.getApplydate(),"yyyy-MM-dd")%></em></li>
			   	<li>身份证号:<em><%= info.getIdcard()==null?"":info.getIdcard() %></em></li>
			   	<li>申请类别:<em><%= info.getApplytype()==null?"":info.getApplytype() %></em></li>
			   	<li>职位等级:<em><%=info.getPositionlevel()==null?"":info.getPositionlevel() %></em></li>
			   	<li>部门性质:<em><%=info.getDeptnature()==null?"":info.getDeptnature() %></em></li>
			  	<li>所属人事部:<em><%=info.getAreapersonneldeptname()==null?"":info.getAreapersonneldeptname() %></em></li>
				<li>所属选拔组:<em><%=info.getEnterprisepersonneldept()==null?"":info.getEnterprisepersonneldept() %></em></li>	
			    <li>变动前部门:<em><%=info.getBeforedept()==null?"":info.getBeforedept() %></em></li>
				<li>变动前职位:<em><%=info.getBeforeposition()==null?"":info.getBeforeposition() %></em></li>
				<li>变动后部门:<em><%=info.getAfterdept()==null?"":info.getAfterdept() %></em></li>
				<li>变动后职位:<em><%= info.getAfterposition()==null?"":info.getAfterposition() %></em></li>
				<li>异进部门增补员工作流号:<em><%=info.getAddpersonno()==null?"":info.getAddpersonno() %></em></li>
				<%if ("公司调动".equals(info.getApplytype())) {%>
				<li>回原籍工作流号:<em><%=info.getBackoriginno()==null?"":info.getBackoriginno() %></em></li>
				<%} %>
				<li>是否引起住所变更:<em><%=info.getIsvaraddress()==null?"":info.getIsvaraddress() %></em></li>
				<li>是否使用公司手机卡:<em><%=info.getTIsrelegation()==null?"":info.getTIsrelegation() %></em></li>
				<%if ("是".equals(info.getTIsrelegation())) {%>
				<li>手机号码:<em><%=info.getPhone()==null?"":info.getPhone() %></em></li>
				<li>是否交接公司手机卡:<em><%=info.getIstelhand()==null?"":info.getIstelhand() %></em></li>
					<%if ("是".equals(info.getIstelhand())) {%>
						<li>交接前手机话费:<em><%=info.getMoney()==null?"":info.getMoney() %></em></li>
						<li>手机卡交接后使用人:<em><%=info.getAfteruser()==null?"":info.getAfteruser() %></em></li>
					<%} %>
				<%} %>
				<li>申请事由:<em><%=info.getReason()==null?"":info.getReason() %></em></li>
		  	</ul>
        </div>
		  <%@include file="approve_process.jsp" %>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>