<%@page import="com.deppon.montal.model.OAMuchRecompensate"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.montal.conf.F_Constants"%>
<%@page import="java.util.List"%>
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
	OAMuchRecompensate sate  = (OAMuchRecompensate)request.getAttribute("muchSate");
%>
<body>
<div id="list">
<%@include file="/jsp/ios/work_items_head.jsp" %>
   <!--div2 S-->
   <div id="div2">
   		<div class="ulBox2">
			<ul>
			   <li class="first">工作流号:
			        <em><%=sate.getProcessinstid() %>
			  	   		<input type="hidden" id="workid" value="<%=sate.getProcessinstid()%>">		  	   		
			   		</em>
			   </li>
			   <li>工作流:<em>
		   		  	多赔
			   </em></li>
			   <li>申请人:<em><%=sate.getApplypersonname() %></em></li>
			   <li>多赔单号:<em><%=sate.getTransportorerrorcode() %></em></li>
			   <li>多赔金额:<em><%=sate.getRecompensiesmoney() %></em></li>
			   <li>合计理赔金额:<em><%=sate.getAmountintotal() %></em></li>
			   <li>应收账款是否收回:<em><%=sate.getHasrepaydebt() %></em></li>
			   <li>部门会计:<em><%=sate.getDeptaccountant()==null?"":sate.getDeptaccountant() %></em></li>
			   <li>所属事业部:<em><%=sate.getEnterprisedept()%></em></li>
			   <li>申请事由:<em><%=sate.getApplyreason()  %></em></li>
			</ul>
		</div>
		<%@include file="approve_process.jsp" %>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>