<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.montal.conf.F_Constants"%>
<%@page import="com.deppon.montal.model.OaResignApply"%>
<%@page import="com.deppon.montal.conf.Constants"%>
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
<body>
<div>
	<%@include file="/jsp/ios/work_items_head.jsp" %>
	<div id="div2">
  		<div class="ulBox2">
			<ul>
			 <%
			    OaResignApply info = (OaResignApply)request.getAttribute(Constants.PAGE_RESULT);
			 %>
			   <li>工作流号：<em><%=info.getProcessinstid() %>
			  	 <input type="hidden" id="workid" value="<%=info.getProcessinstid()%>">
			  	 <input type="hidden" id="type_id" value="resign">
			   	</em></li>
			   <li>工作流：<em">辞职申请</em></li>
			   <li>申请辞职人员：<em><%=info.getEmpname() %></em></li>
			   <li>申请辞职人员工号：<em><%=info.getEmpuserid() %></em></li>
			   <li>申请人职位：<em><%=info.getPosition() %></em></li>
			   <li>所属部门：<em><%=info.getAppdept() %></em></li>
			   <li>入职日期：<em><%=info.getJoindate()%></em></li>					
			   <li>辞职人员工作年限：<em><%=info.getWorkyears()%>个月</em></li>
			   <li>辞职人员近6个月ABC：<em><%=info.getAbc() %></em></li>
			   <li>差错编号：<em><%=info.getErrorno()== null ? "":info.getErrorno()%></em></li>
		       <li>辞职人员现任岗位类别：<em><%=info.getPostsort() %></em></li>
			   <li>辞职人员是否评优：<em><%=info.getIsgood()%></em></li>
			   <li>辞职人员所在人事部：<em><%=info.getPersonneldept()%></em></li>
			   <li>辞职主要原因：<em><%=info.getResignreason()%></em></li>
			   <li>辞职类型：<em><%="1".equals(info.getResigntype()) ? "辞职" : "2".equals(info.getResigntype()) ?"自离":""%></em></li>
			   <%if(!"否".equals(info.getIsreserve())){ %>
			   <li>辞职人是否参加储干：<em><%=info.getIsreserve()%></em></li>
			   <li>第几届储干：<em>第<%=info.getReservedate()%> 届</em></li>
			   <li>储干名次：<em>第<%=info.getReserveno()%> 名</em></li>
			   <%} %>
			   <li>申请事由：<em><%=info.getApplyreason()== null ? "" : info.getApplyreason()%></em></li>
			</ul>
		</div>
		<%@include file="approve_process.jsp" %>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>