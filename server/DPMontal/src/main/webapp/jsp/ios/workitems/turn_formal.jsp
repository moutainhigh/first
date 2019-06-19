<%@page import="com.deppon.montal.model.OAConverterApply"%>
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
OAConverterApply info = (OAConverterApply)request.getAttribute("turn_formal");
%>
<div id="list">
	<%@include file="/jsp/ios/work_items_head.jsp" %>
	<div id="div2">
    	<div class="ulBox2">
	    	<ul>
			   <li class="first">工作流号:<em><%=info.getProcessinstid() %></em>
			   <input type="hidden" id="workid" value="<%=info.getProcessinstid()%>">
			   <input type="hidden" id ="type_id" value="turn_formal">
<%-- 		   <input type="hidden" id ="currentnode_id" value="<%=info.getCurrentnode() %>"> --%>
			   </li>				  
					<li>
					   工&nbsp;&nbsp;作&nbsp;&nbsp;流:<em>
					   转正申请<input type="hidden" id ="type_id" value="turn_formal"></em></li>
					
				   <li>
					  部门:<em>
					  <%=info.getDept()%></em></li>
				   
					 <li>
					  姓名:<em>
					  <%=info.getName()%></em></li>
				   
				   <li>
					  工号:<em>
					  <%=info.getUserid()%></em></li>
				   
					 <li>
					  身份证号码:<em>
					  <%=info.getIdcard()%></em></li>
				   
					 <li>
					  岗位:<em>
					  <%=info.getPosition()%></em></li>
				   
				   <%if(!"请选择".equals(info.getFlowtype())){%>
				   <li>
					  意见类型:<em>
					  <%=info.getFlowtype()==null?"":info.getFlowtype()%></em></li>
				   
				   <%} %>
				   <li>
					  入职日期:<em>
					  <%=info.getBoarddate()%></em></li>
				   
				   <li>
					  考试通过日期:<em>
					  <%=info.getExacrossdate()%></em></li>
				   
				   <li>
					  是否参加新员工培训:<em>
					  <%=info.getIsnewpx()%></em></li>
				   
				   <li>
					  工作岗位:<em>
					  <%=info.getGwflag()%></em></li>
				   
				   <%if("营运部门人员".equals(info.getGwflag())){%>
					  <li>
					   企业文化:<em>
					   <%=info.getCulture()%></em></li>
				    
				    <li>
					  打字:<em>
					  <%=info.getTyping()%></em></li>
				   
				   <li>
					  专业知识:<em>
					  <%=info.getExpertise()%></em></li>
				   				   
				  <% }if("外场人员".equals(info.getGwflag())){%>
					   <li>
					  员工手册和外场操作综合知识:<em>
					  <%=info.getCknowledge()%></em></li>
				   
				   <%}if("司机".equals(info.getGwflag())){%>
					   <li>
					  员工手册和外场操作综合知识:<em>
					  <%=info.getCknowledge()%></em></li>
				   
				   <li>
					  路考:<em>
					  <%=info.getDriversinfo()%></em></li>
				   
				   <%}if("职能部门".equals(info.getGwflag())){%>
					  <li>
					   企业文化:<em>
					   <%=info.getCulture()%></em></li>
				    
				    <li>
					  打字:<em>
					  <%=info.getTyping()%></em></li>
				   
				   <li>					   
				   <%} %>
				   <li>
					  是否加入员工关爱互助基金会:<em>
					  <%=info.getIsjoinfund()%></em></li>
				   
				   <li>
					  个人心得体会:<em>
					  <%=info.getExperience()%></em></li>
				   
				   <li>
					  对公司、部门、领导或其他方面的建议与意见:<em>
					  <%=info.getComments()%></em></li>
				   
				   <li>
					  部门同事评价:<em>
					  <%=info.getCollevaluation()%></em></li>
				   
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