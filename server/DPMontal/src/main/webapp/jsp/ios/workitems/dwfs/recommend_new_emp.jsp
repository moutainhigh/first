<%@page import="com.deppon.wfs.workflow.domain.RecommendNewEmpBean"%>
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
 		RecommendNewEmpBean info = (RecommendNewEmpBean)request.getAttribute("entity");
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
			   <li>工作流:<em> 推荐新员工</em></li>
			   <li>申请人:<em><%=info.getApplyPersonName()%></em></li>
			   <li>被推荐人姓名:<em><%=info.getRecommendedName()%></em></li>
			   <li>与申请人关系:<em><%=info.getRelation()%></em></li>
			   <%if("m".equals(info.getRecommendedSex())){%>
				   <li>被推荐人性别:<em>男</em></li>
			   <%}else{%>
				   <li>被推荐人性别:<em>女</em></li>
			   <%} %>
			   <li>被推荐人学历:<em><%=info.getRecommendedEdu()%></em></li>
			   <li>毕业院校:<em><%=info.getGraduateCollege()%></em></li>
			   <li>毕业年限:<em><%=info.getGraduateYears()%></em></li>
			   <li>推荐类型:<em><%=info.getRecommendedType()%></em></li>
			   <li>被推荐人欲入职区域:<em><%=info.getRecommendedArea()%></em></li>
			   <%if("业务伙伴".equals(info.getRecommendedType())) {%>
				   <li>推荐入职部门:<em><%=info.getRecommendedDept()%></em></li>
			   <%} %>
			   <li>申请事由:<em><%=info.getReason()==null?"":info.getReason()%></em></li>
			</ul>
		</div>
		<%@include file="approve_process.jsp" %>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>