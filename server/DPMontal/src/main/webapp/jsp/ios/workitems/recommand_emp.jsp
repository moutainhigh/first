<%@page import="com.deppon.montal.model.RecommandNewEMP"%>
<%@page import="com.deppon.montal.model.OaBudgetdataApply"%>
<%@page import="com.deppon.montal.model.OaContractAdd"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.montal.conf.F_Constants"%>
<%@page import="com.deppon.montal.model.OaResignApply"%>
<%@page import="com.deppon.montal.conf.Constants"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title><%=InitDataServlet.getValue("page_title")%>-待办事项</title>
<%@include file="/common_ios.jsp"%>
</head>
<%
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
%>
<body>
	<div>
		<%@include file="/jsp/ios/work_items_head.jsp"%>
		<div id="div2">
			<div class="ulBox2">
				<ul data-role="listview" id="ulist" data-inset="ture" data-theme="c"
					data-dividertheme="b">
					<%
						RecommandNewEMP info = (RecommandNewEMP) request
														.getAttribute("RecommandNewEMP");
					%>
					<li class="first">工作流号:<em><%=info.getProcessinstid()%> <input
							type="hidden" id="workid" value="<%=info.getProcessinstid()%>">
							<input type="hidden" id="type_id" value="RecommandNewEMP"> </em></li>
					<li>工作流:<em>推荐新员工</em></li>

            <li>申请人:
            <em><%=info.getApplyname()%></em></li>
          
          
            <li>被推荐人姓名:
            <em><%=info.getRecommendedname()%></em></li>
          
          
            <li>与申请人关系:
            <em><%=info.getRelation()%></em></li>
          
          
            <li>被推荐人性别:
            <em><%=info.getRecommendedsex()%></em></li>
          
          
            <li>被推荐人学历:
            <em><%=info.getRecommendededu()%></em></li>
          
          
            <li>毕业院校:
            <em><%=info.getGraduatecollege()%></em></li>
          
          
            <li>毕业年限:
            <em><%=info.getGraduateyears()%></em></li>
          
          
            <li>推荐类型:
            <em><%=info.getRecommendedtype()%></em></li>
          
          
            <li>被推荐人欲入职区域:
            <em><%=info.getRecommendedarename()%></em></li>
          
          	<%if("亲属关系".equals(info.getRecommendedtype())){}else{%>
            <li>推荐入职部门:
            <em><%=info.getRecommendeddeptname()%></em></li>
          	<%} %>
            <li>申请事由:
            <em><%=info.getRecommendedreason()==null?"":info.getRecommendedreason()%></em></li>
				</ul>
			</div>
			<%@include file="approve_process.jsp"%>
		</div>
		<%@include file="workflow_approve_button.jsp"%>
	</div>
</body>
</html>