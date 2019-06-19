<%@page import="com.deppon.montal.model.OAConverterApply"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_win8.jsp" %>
</head>
<body>
<%
	OAConverterApply info = (OAConverterApply)request.getAttribute("turn_formal");
%>
<div id="list">
	<%@include file="wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
	    		<tr>
					   <th>工作流号:</th>
					   <td id="workid"><%=info.getProcessinstid()%></td>
					</tr>
					<tr>
					   <th>工&nbsp;&nbsp;作&nbsp;&nbsp;流:</th>
					   <td>转正申请<input type="hidden" id ="type_id" value="turn_formal"></td>
					</tr>
				   <tr>
					  <th>部门:</th>
					  <td><%=info.getDept()%></td>
				   </tr>
					 <tr>
					  <th>姓名:</th>
					  <td><%=info.getName()%></td>
				   </tr>
				   <tr>
					  <th>工号:</th>
					  <td><%=info.getUserid()%></td>
				   </tr>
					 <tr>
					  <th>身份证号码:</th>
					  <td><%=info.getIdcard()%></td>
				   </tr>
					 <tr>
					  <th>岗位:</th>
					  <td><%=info.getPosition()%></td>
				   </tr>
				   <%if(!"请选择".equals(info.getFlowtype())){%>
				   <tr>
					  <th>意见类型:</th>
					  <td><%=info.getFlowtype()==null?"":info.getFlowtype()%></td>
				   </tr>
				   <%} %>
				   <tr>
					  <th>入职日期:</th>
					  <td><%=info.getBoarddate()%></td>
				   </tr>
				   <tr>
					  <th>考试通过日期:</th>
					  <td><%=info.getExacrossdate()%></td>
				   </tr>
				   <tr>
					  <th>是否参加新员工培训:</th>
					  <td><%=info.getIsnewpx()%></td>
				   </tr>
				   <tr>
					  <th>工作岗位:</th>
					  <td><%=info.getGwflag()%></td>
				   </tr>
				   <%if("营运部门人员".equals(info.getGwflag())){%>
					  <tr>
					   <th>企业文化:</th>
					   <td><%=info.getCulture()%></td>
				    </tr>
				    <tr>
					  <th>打字:</th>
					  <td><%=info.getTyping()%></td>
				   </tr>
				   <tr>
					  <th>专业知识:</th>
					  <td><%=info.getExpertise()%></td>
				   </tr>				   
				  <% }if("外场人员".equals(info.getGwflag())){%>
					   <tr>
					  <th>员工手册和外场操作综合知识:</th>
					  <td><%=info.getCknowledge()%></td>
				   </tr>
				   <%}if("司机".equals(info.getGwflag())){%>
					   <tr>
					  <th>员工手册和外场操作综合知识:</th>
					  <td><%=info.getCknowledge()%></td>
				   </tr>
				   <tr>
					  <th>路考:</th>
					  <td><%=info.getDriversinfo()%></td>
				   </tr>
				   <%}if("职能部门".equals(info.getGwflag())){%>
					  <tr>
					   <th>企业文化:</th>
					   <td><%=info.getCulture()%></td>
				    </tr>
				    <tr>
					  <th>打字:</th>
					  <td><%=info.getTyping()%></td>
				   </tr>
				   <tr>					   
				   <%} %>
				   <tr>
					  <th>是否加入员工关爱互助基金会:</th>
					  <td><%=info.getIsjoinfund()%></td>
				   </tr>
				   <tr>
					  <th>个人心得体会:</th>
					  <td><%=info.getExperience()%></td>
				   </tr>
				   <tr>
					  <th>对公司、部门、领导或其他方面的建议与意见:</th>
					  <td><%=info.getComments()%></td>
				   </tr>
				   <tr>
					  <th>部门同事评价:</th>
					  <td><%=info.getCollevaluation()%></td>
				   </tr>
				   <tr>
					  <th>申请事由:</th>
					  <td><%=info.getReason()==null?"":info.getReason()%></td>
				   </tr>
			     <%@include file="approve_process.jsp" %>
	    	</table>
	    </div>
	</div>
	 <%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>