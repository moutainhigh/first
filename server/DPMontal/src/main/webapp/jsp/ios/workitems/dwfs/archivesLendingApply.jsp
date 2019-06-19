<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.module.workitems.webservice.client.DWFSWorkItemServiceClient"%>
<%@page import="com.deppon.wfs.workflow.domain.ArchivesLendingApplyBean"%>
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
	ArchivesLendingApplyBean info = (ArchivesLendingApplyBean)request.getAttribute("entity");
%>
<body>
<div id="list">
	<%@include file="/jsp/ios/work_items_head.jsp" %>
	<div id="div2">
    	<div class="ulBox2">
	    	<ul>
	    		 <li class="first">工作流号:
			        <em><%=request.getAttribute("processinstid") %>
					<input type="hidden" id="busino" value="<%=info.getBusino()%>">
					<input type="hidden" id="approval_url" value="<%=F_Constants.NORMOL_APPROVAL_URL%>">		  	   		
			   		</em></li>
			   	
					   <li>工&nbsp;&nbsp;作&nbsp;&nbsp;流:
					   <em>财务档案借阅申请 </em></li>
					  <li>申请人:<em><%=info.getApplyPersonName()%></em></li>
					  <li>工号:<em><%=info.getApplyPersonId()%></em></li>
					  <li>部门:<em><%=info.getDepartment()%></em></li>
					  <li>职位:<em><%=info.getPosition()%></em></li>
					  <li>电子邮箱:<em><%=info.getEmail()%></em></li>
					  <li>手机号码:<em><%=info.getTelphone()%></em></li>
					  <li>档案所属财务部:<em><%=info.getFinancialDepartment()%></em></li>
					  <li>档案所属子公司:<em><%=info.getSubCorporation()%></em></li>
					  <li>借阅性质:<em><%=info.getLendingNature()%></em></li>
					   <%if("续借".equals(info.getLendingNature())){ %>
						  <li>借阅工作流编号:
						  <em><%=info.getLendingWorkflowNumber()%></em></li>
					   <%}%>
					  <li>借阅时间:<em><%=FormatUtil.formatDate(info.getLendingTime())%></em></li>
					  <li>归还时间:<em><%=FormatUtil.formatDate(info.getReturnTime())%></em></li>
					  <li>档案类型:<em><%=info.getFinancialType()%></em></li>
					  <li>档案分类:<em><%=info.getFinancialCategory()%></em></li>
					  <li>是否打印:<em><%=info.getIsPrint()%></em></li>
					  <li>档案明细:<em><%=info.getFinancialDetail()%></em></li>
					  <li>申请事由:<em><%=info.getApplyReasons()%></em></li>
	    	</ul>
	    </div>
			<%@include file="approve_process.jsp" %>					   					   
	</div>
	 <%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>