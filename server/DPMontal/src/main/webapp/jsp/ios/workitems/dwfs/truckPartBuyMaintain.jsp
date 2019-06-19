<%@page import="com.deppon.wfs.workflow.domain.TruckPartBuyMaintainBean"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
<%@include file="/common_ios.jsp"%>
</head>
<%
 request.setCharacterEncoding("UTF-8");
 response.setCharacterEncoding("UTF-8");
%>
<%
TruckPartBuyMaintainBean info = (TruckPartBuyMaintainBean)request.getAttribute("entity");
%>
<body>
	<div id="list">
		<%@include file="/jsp/ios/work_items_head.jsp"%>
		<!--div2 S-->
		<div id="div2">
			<div class="ulBox2">
				<ul>
					<li class="first">工作流号:<em><%=request.getAttribute("processinstid") %>
							<input type="hidden" id="busino" value="<%=info.getBusino()%>">
							<input type="hidden" id="approval_url"
							value="<%=F_Constants.NORMOL_APPROVAL_URL%>"> </em>
					</li>
					<li>
					   工&nbsp;&nbsp;作&nbsp;&nbsp;流:
					   <em>货车配件采购/维修/保养</em>
					</li>
					 <li>
					  申请人:
					  <em><%=info.getApplyPersonName()%></em>
				   </li>
					 <li>
					 所属事业部:
					  <em><%=info.getArea()%></em><!-- DIP_DIVISION_NEW_ADD -->
				   </li>
				   <li>
					  车牌号:
					  <em><%=info.getCarNumber()  %></em>
				   </li>
					 <li>
					  申请类型:
					  <em><%=info.getCategory()%></em><!-- WFS_TRUCK_APPLY_TYPE -->
				   </li>
					 <li>
					  报销费用:
					  <em><%=info.getMoney() %> </em>
				   </li>
				   <li>
					  车辆类型:
					  <em><%=info.getTruckType() %></em><!-- WFS_TRUCK_TYPE -->
				   </li>
 					   <li>
						  申请事由:
						  <em><%=info.getApplyReason()%></em>
					   </li>
					   
				</ul>
			</div>
			<%@include file="approve_process.jsp"%>
		</div>
		<%@include file="workflow_approve_button.jsp"%>
	</div>
</body>
</html>