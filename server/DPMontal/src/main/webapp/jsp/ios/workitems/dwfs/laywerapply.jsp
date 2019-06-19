<%@page import="com.deppon.wfs.workflow.domain.LaywerapplyBean"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
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
	LaywerapplyBean info = (LaywerapplyBean)request.getAttribute("entity");
%>
<body>
<div id="list">
<%@include file="/jsp/ios/work_items_head.jsp" %>
   <!--div2 S-->
   <div id="div2">
	   	<div class="ulBox2">
			<ul>
			 
			   <li class="first">工作流号:
			        <em><%=request.getAttribute("processinstid") %>
					<input type="hidden" id="busino" value="<%=info.getBusino()%>">
					<input type="hidden" id="approval_url" value="<%=F_Constants.NORMOL_APPROVAL_URL%>">		  	   		
			   		</em>
			   </li>
			   
			   <li>工作流:<em>诉讼案件立案/外请律师申请</em></li>
			   <li>申请人:<em><%=info.getApplyPersonName()%></em></li>
			   <li>申请类别:<em><%=info.getAppCategory()%></em></li>
			   <li>案件名称:<em><%=info.getCaseName()%></em></li>
			   <li>涉案部门:<em><%=info.getOrg()%></em></li>
			   <li>涉案金额:<em><%=info.getMoney()%></em></li>
			   <li>诉讼费:<em><%=info.getLawsuitmoney()%></em></li>
			   <li>所属子公司:<em><%=info.getChildcompany()%></em></li>
			   <li>立案基本情况:<em><%=info.getBasicinfo()%></em></li>
			   <li>请求事项:<em><%=info.getApplyinfo()%></em></li>
			   <li>申请事由:<em><%=info.getReason()%></em></li>
					
			</ul>
		</div>
		<%@include file="approve_process.jsp" %>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
<script type="text/javascript">
	$(function(){
		$("#rollback_but").hide();
	});
</script>
</html>