<%@ page language="java"  pageEncoding="UTF-8"%> 
<%@page import="java.util.List"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.dpm.module.acms.domain.SyncWorkflowinfoResponse"%>
<%@page import="com.deppon.dpm.module.acms.domain.CompanyFillChangeEntity"%>
<%@page import="com.deppon.dpm.module.acms.domain.ApproveEntity"%>
<%@page import="com.deppon.dpm.module.acms.domain.Attachment"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_ios.jsp" %>
</head>
<body>
 <%
 SyncWorkflowinfoResponse syncwfinfoResponse = (SyncWorkflowinfoResponse)request.getAttribute("acmsSyncResponse");
 CompanyFillChangeEntity info = syncwfinfoResponse.getCompanyFillChangeEntity();
 %>
<div id="list">
	<%@include file="/jsp/ios/work_items_head.jsp" %>
	<div id="div2">
    	<div class="ulBox2">
	    	<ul>
	    		<li>工&nbsp;&nbsp;作&nbsp;&nbsp;流:<em class="yellow">证照补办及分公司变更申请</em></li>		  
	    		<li>工作流号:<em><%=request.getAttribute("processinstid")%></em></li>
				<li>申请人:<em><%=info.getApplyName()%></em></li>
				<li>申请类别:<em><%=info.getApplyType()%></em></li>
				<li>公司类型:<em><%=info.getCompanyType()%></em></li>
				<li>公司名称:<em><%=info.getCompanyName()%></em></li>
				<li>营业部名称:<em><%=info.getSalesDeptName()%></em></li>
				<%if(!"变更".equals(info.getApplyType())){%>
				<li>补办证照:<em><%=info.getLicenseType()%></em></li>
				<%} %>
				<%if("变更".equals(info.getApplyType())){%>
				<li>变更类型:<em><%=info.getChangeType()%></em></li>
				<li>变更前内容:<em><%=info.getChangeBefore()%></em></li>
				<li>变更后内容:<em><%=info.getChangeAfter()%></em></li>
				<%} %>
				<li>申请事由:<em><%=info.getReason() == null ? "" : info.getReason()%></em></li>
          	</ul>
        </div>
	     <%@include file="approve_process.jsp" %>
	</div>
	 <%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>