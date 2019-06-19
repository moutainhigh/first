<%@page import="com.deppon.montal.model.OABankAccountOpencl"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.conf.F_Constants"%>
<%@page import="com.deppon.montal.model.OaContractApply"%>
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
<body>
<div id="list">
	<%@include file="/jsp/ios/work_items_head.jsp" %>
    <!--div2 S-->
    <div id="div2">
    	<div class="ulBox2">
    		<ul>
				<%
					OABankAccountOpencl apply = (OABankAccountOpencl)request.getAttribute("openClApply");
				%>
				
				<li class="first">工作流号：<em><%=apply.getProcessinstid() %></em>
			  	 	<input type="hidden" id="workid" value="<%=apply.getProcessinstid()%>">
			    </li>
			    <li>工作流：<em>银行开户/销户申请</em></li>
			    
			    <li>申请人姓名：<em><%=apply.getName() %></em></li>
			    <li>部门：<em><%=apply.getOrgname() %></em></li>
			    <li>申请类别：<em><%=apply.getApplytype().equals("1")?"开户":"销户" %></em></li>
			    <li>账户类型：<em><%=apply.getAccounttype().equals("1")?"个人户":"对公户" %></em></li>
			    
				<%
					if(apply.getAccountopenname() != null){
				%>
				<li>开户名：<em><%=apply.getAccountopenname() %></em></li>
			    <li>账号：<em><%=apply.getAccounts() %></em></li>
				<%
					}
				%>
				<li>所属财务部：<em><%=apply.getAccountingname()%></em></li>
				<%
					if(apply.getBankname() != null){
				%>
				<li>开户银行：<em><%=apply.getBankname()%></em></li>
				<%
					}
				%>
				<li>申请事由：<em><%=apply.getReason()==null?"": apply.getReason()%></em></li>
			</ul>
		</div>
		<%@include file="approve_process.jsp" %>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>