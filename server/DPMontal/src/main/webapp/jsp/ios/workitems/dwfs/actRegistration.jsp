<%@page import="com.deppon.wfs.workflow.domain.ActRegistrationBean"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
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
	ActRegistrationBean info = (ActRegistrationBean)request.getAttribute("entity");
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

					<li>工作流:<em>活动报名申请</em></li>
					<li>申请人:<em><%=info.getApplyPersonName()%></em></li>
					<li>申请人工号:<em><%=info.getApplyPersonId()%></em></li>
					<li>所属部门:<em><%=info.getDeptName()%></em></li>
					<li>所属事业部:<em><%=info.getDivisionCode()%></em></li>
					<li>入职时间:<em><%=FormatUtil.formatDate(info.getJoinDate())%></em></li>
					<li>申请人职位:<em><%=info.getPosition()%></em></li>
					<li>申请人电话:<em><%=info.getTelephone()%></em></li>
					<li>申请项目:<em><%=info.getApplyProject()%></em></li>
					<%if("集体婚礼".equals(info.getApplyProject())) { %>
						<li>结婚证领取日期:<em><%=FormatUtil.formatDate(info.getMarrylicenseDate())%></em></li>
						<li>参加婚礼地点:<em><%=info.getWeddingAddress()%></em></li>
						<li>身份证号:<em><%=info.getCardno()%></em></li>
						<li>配偶是否德邦员工:<em><%=info.getIsInternalStaff() %></em></li>
					<%} %>
					<%if("集体婚礼".equals(info.getApplyProject())) { %>
						<%if("是".equals(info.getIsInternalStaff())) { %>
							<li>配偶姓名:<em><%=info.getSpouseName()%></em></li>
							<li>配偶工号:<em><%=info.getSpouseCode()%></em></li>
							<li>配偶部门:<em><%=info.getSpouseDept()%></em></li>
							<li>所属事业部:<em><%=info.getSpouseDivisionCode()%></em></li>
							<li>入职时间:<em><%=FormatUtil.formatDate(info.getSpouseJoinDate())%></em></li>
							<li>配偶职位:<em><%=info.getSpousePosition()%></em></li>
						<%} %>
					<%} %>
					<%if("集体婚礼".equals(info.getApplyProject())) { %>
						<%if("否".equals(info.getIsInternalStaff())) { %>
							<li>配偶姓名:<em><%=info.getSpouseName()%></em></li>
							<li>工作单位:<em><%=info.getWorkUnit()%></em></li>
						<%} %>
					<%} %>
					<%if("集体婚礼".equals(info.getApplyProject())) { %>
						<li>配偶电话:<em><%=info.getSpouseTel()%></em></li>
						<li>配偶身份证号:<em><%=info.getSpouseId()%></em></li>
					<%} %>
					<%if("中秋月饼".equals(info.getApplyProject())) { %>
						<li>家属姓名:<em><%=info.getRelationName()%></em></li>
						<li>与家属关系:<em><%=info.getRelationShip()%></em></li>
						<li>家属电话:<em><%=info.getRelationTel() == null ? "" : info.getRelationTel()%></em></li>
						<li>邮编:<em><%=info.getZipCode()%></em></li>
						<li>固定电话:<em><%=info.getFixedLine() == null ? "" : info.getFixedLine()%></em></li>
						<li>省份:<em><%=info.getProvince()%></em></li>
						<li>城市:<em><%=info.getCity()%></em></li>
						<li>区/县:<em><%=info.getDistrictCounty()%></em></li>
						<li>街道:<em><%=info.getStreet()%></em></li>
					<%} %>
					<li>申请事由:<em><%=info.getApplyReason()%></em></li>
				</ul>
			</div>
			<%@include file="approve_process.jsp"%>
		</div>
		<%@include file="workflow_approve_button.jsp"%>
	</div>
</body>
</html>