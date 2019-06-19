<%@page import="com.deppon.montal.model.OAUseSealApply"%>
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
OAUseSealApply info = (OAUseSealApply)request.getAttribute("use_seal_apply");

%>
<div id="list">
	<%@include file="/jsp/ios/work_items_head.jsp" %>
	<div id="div2">
    	<div class="ulBox2">
	    	<ul>
			   <li class="first">工作流号:<em><%=info.getProcessinstid() %></em>
			   <input type="hidden" id="workid" value="<%=info.getProcessinstid()%>">
			   <input type="hidden" id ="type_id" value="use_seal_apply">
<%-- 		   <input type="hidden" id ="currentnode_id" value="<%=info.getCurrentnode() %>"> --%>
			   </li>				  
          <li>工作流:<em>用章申请<input type="hidden" id ="type_id" value="use_seal_apply"></em></li>
					<li>
					  姓名:<em>
					  <%=info.getName()==null?"":info.getName()%></em></li>
				   
					 <li>
					  工号:<em>
					  <%=info.getUserid()==null?"":info.getUserid()%></em></li>
				   
				   <li>
					  部门:<em>
					  <%=info.getDept()==null?"":info.getDept()%></em></li>
				   
					 <li>
					  所属事业部:<em>
					  <%=info.getArea()==null?"":info.getArea()%></em></li>
				   
				   	<li>
					  印章名称:<em>
					  <%=info.getSealname()==null?"":info.getSealname()%></em></li>
				   
					 <li>
					  印章类型:<em>
					  <%=info.getSealtype()==null?"":info.getSealtype()%></em></li>
				   
				   <li>
					  印章序号:<em>
					  <%=info.getSealsequencecode()==null?"":info.getSealsequencecode()%></em></li>
				   
					 <li>
					  印章份数:<em>
					  <%=info.getSealcounts()==null?"":info.getSealcounts()%></em></li>
				   
				   <li>
					  印章所属:<em>
					  <%=info.getSealdept()==null?"":info.getSealdept()%></em></li>
				   
					<li>
					  所属财务部:<em>
					  <%=info.getSealbrief()==null?"":info.getSealbrief()%></em></li>
				   
				   <li>
					  用章保管部门:<em>
					  <%=info.getSealasavedept()==null?"":info.getSealasavedept()%></em></li>
				   
					 <li>
					  需盖章资料名称:<em>
					  <%=info.getSealneedname()==null?"":info.getSealneedname()%></em></li>
				   
				   <li>
					  章全宗号:<em>
					  <%=info.getSealgeneralcode()==null?"":info.getSealgeneralcode()%></em></li>
				   
					 <li>
					  印章编号:<em>
					  <%=info.getSealcode()==null?"":info.getSealcode()%></em></li>
				   
				   <li>
					  使用日期:<em>
					  <%=info.getSealusedate().substring(0, 10)%></em></li>
				   
					 <li>
					  印章档号:<em>
					  <%=info.getSealarchivalcode()==null?"":info.getSealarchivalcode()%></em></li>
				   
				   <li>
					  申请事由:<em>
					  <%=info.getReason()==null?"":info.getReason()%></em></li>
	    	</ul>
	    </div>
	     <%@include file="approve_process.jsp" %>
	</div>
	 <%@include file="workflow_approve_button.jsp" %>
</div>
</body>

</html>