<%@page import="com.deppon.wfs.workflow.domain.TrainBean"%>
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
TrainBean info = (TrainBean)request.getAttribute("entity");
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
			   <li>工作流:<em>培训需求申请/培训需求变更申请</em></li>
			   <% if("request".equals(info.getApplyType())){
						//培训申请
					%>
					<!-- 培训申请 -->
					<li>
					  申请类型:
					  <em>培训需求申请</em>
				   </li>	
				   <li>
					  申请人:
					  <em><%=info.getApplyPersonName()%></em>
				   </li>
					 <li>
					  申请人部门:
					  <em><%=info.getApplyDeptName()%></em>
				   </li>
				    <li>
					  所属培训组:
					  <em><%=info.getTrainGroup() %></em><!-- WFS_TRAINORG -->
				   </li>
				    <li>
					  培训类型:
					  <em><%=info.getTrainType()%></em><!-- WFS_TRAINTYPE -->
				   </li>
				   <li>
					  PMO立项:
					  <em><%=info.getPmoProject()%></em><!-- WFS_ISORNO -->
				   </li>
					<li>
					  项目名称:
					  <em><%=info.getTrainName()%></em>
				   </li>
				  <li>
					  培训时间从:
					  <em><%=FormatUtil.formatDate(info.getBeginTrainDate())  %>&nbsp;&nbsp; 至  &nbsp;&nbsp;<%=FormatUtil.formatDate(info.getEndTrainDate()) %></em>
				   </li>
					
				   <li>
					  预计培训人数:
					  <em><%=info.getExpectedNum() %> </em>
				   </li>
				      <li>
					  讲师资源是否充足:
					  <em><%=info.getIsconsultant()%></em>
				   </li>	
					<li>
					  培训对象:
					  <em><%=info.getTrainObjects()%></em>
				   	</li>
					 
					 <li>
					  费用核算金额:
					  <em><%=info.getLecturerName()%></em>
				   </li>
				 		   
				   
				   <li>
					  培训课程和目标:
					  <em><%=info.getTrainSubjects()%></em>
				   </li>
					<%
					}else if("change".equals(info.getApplyType())){
					%>
					<!-- 培训变更申请 -->
					<li>
					  申请类型:
					  <em>培训需求变更申请</em>
				   </li>
				   <li>
					  申请人:
					  <em><%=info.getApplyPersonName()%></em>
				   </li>
				    <li>
					  申请人部门:
					  <em><%=info.getApplyDeptName()%></em>
				   </li>
					<li>
					  工号:
					  <em><%=info.getApplyPersonId()%></em>
				   </li>
				   <li>
					  所属培训组:
					  <em><%=info.getTrainGroup()%></em> <!-- WFS_TRAINORG -->
				   </li>
				  
					
				   <li>
					  PMO立项:
					  <em><%=info.getPmoProject()%></em><!-- WFS_ISORNO -->
				   </li>
					<li>
					  项目名称:
					  <em><%=info.getTrainName()%></em>
				   </li>
				   <li>
					  变更类型:
					  <em><%=info.getChangeType()%></em><!-- WFS_CHANGTYPE -->
				   </li>
					<li>
					  培训申请工作流号:
					  <em><%=info.getTrainRequestProcessinstid()%></em>
				   </li>
 					<li>
						变更原因:
						<em><%=info.getChangeReason()%></em>
					</li>
					<li>
						变更内容:
						<em><%=info.getChangeContent()%></em>
					</li>
					<li>
						变更影响:
						<em><%=info.getChangeEffect()%></em>
					</li>
					<li>
						解决方案:
						<em><%=info.getSolution()%></em>
					</li> 
					<%
					}else{
					%>
					<li>
					   <em>数据异常</em>
					</li>
					<%
					} %>
			</ul>
		</div>
		<%@include file="approve_process.jsp" %>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>