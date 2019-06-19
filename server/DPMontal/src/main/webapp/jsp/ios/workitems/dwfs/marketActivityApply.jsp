<%@page import="com.deppon.wfs.workflow.domain.MarketActivityBean"%>
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
MarketActivityBean info = (MarketActivityBean)request.getAttribute("entity");
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
			   <li>工作流:<em>营销活动申请</em></li>
			   <li>
					  申请人:
					  <em><%=info.getApplyPersonName()%></em>
				   </li>
					 <li>
					  申请人工号:
					  <em><%=info.getApplyPersonId()%></em>
				   </li>
				   <li>
					  所属事业部:
					  <em><%=info.getSubOrdinateDivision()  %></em><!-- DIP_DIVISION_NEW -->
				   </li>
					 <li>
					  使用部门数:
					  <em><%=info.getUseDeptNum()%></em>
				   </li>
					 <li>
					  营销所属类型:
					  <em><%=info.getMarketType() %> </em>
				   </li>
				   <li>
					  是否为现有资料补做:
					  <em><%=info.getIsRedo() %></em><!-- WFS_ISORNO -->
				   </li>
				   <% if("lineType".equals(info.getType())){
					   //宣传线路类型%>
					<li>
					  宣传线路类型:
					  <em><%=info.getPropagandalineType()%></em><!-- WFS_PUBLICITYLINE -->
				   	</li>
					   <%
				   }else if ("businessType".equals(info.getType())){
					   //宣传业务类型%>
					<li>
					  宣传业务类型:
					  <em><%=info.getPropagandaBusType()%></em><!-- WFS_PROPAGANDABUSTYPE -->
				   </li>	   
				<%}else if("guildType".equals(info.getType())){
					   //宣传行业类型%>
					<li>
					宣传行业类型:
					  <em><%=info.getPropagandainDustryType() %></em><!-- WFS_PROPAGANDAINDUSTRYTYPE -->
				   	</li>
				<%}else{
					  //宣传空运类型%>
				<li>
					  宣传空运类型:
					  <em><%=info.getPropaganDaairType()%></em><!-- WFS_PROPAGANDAAIRTYPE -->
				</li>
				<%}%>
					 <li>
					  宣传主题:
					  <em><%=info.getPropagandaTheme()%></em>
				   </li>
				   <li>
					  开展区域:
					  <em><%=info.getRegionin()%></em>
				   </li>			   
				    <% 
				   String type = info.getType();
				   if("lineType".equals(type)){%>
					 <li>
					  出发城市:
					  <em><%=info.getFromCity()%></em>
				   </li>   
					 <li>
					  到达城市:
					  <em><%=info.getToCity()%></em>
				   </li>
				    <li>
					  可提货时间:
					  <em><%=info.getDeliveryTime()%></em>
				   </li>      
				   <%}%>
				   <li>
					  活动开始时间:
					  <em><%=FormatUtil.formatDate(info.getActivityStartTime())%></em>
				   </li>
				   <li>
					  活动结束时间:
					  <em><%=FormatUtil.formatDate(info.getActivityEndTime())%></em>
				   </li>
				   <li>
					  第一个月目标:
					  <em><%=info.getFirstTarget()%></em>
				   </li>
				   <li>
					  第二个月目标:
					  <em><%=info.getSecondTarget()%></em>
				   </li>
				   	<li>
					  第三个月目标:
					  <em><%=info.getThirdTarget()%></em>
				   </li>
				   <li>
					  申请数量:
					  <em><%=info.getApplyNumber()%></em>
				   </li>	
				   <li>
					  针对人群:
					  <em><%=info.getAccordingTocrowd()%></em>
				   </li>
				   <li>
					  对接人:
					  <em><%=info.getDockingPeople()%></em>
				   </li>
				   <li>
					  联系电话:
					  <em><%=info.getTelphone()%></em>
				   </li>
				   <li>
					  设计类型:
					  <em><%=info.getDesignType()%></em><!-- WFS_DESIGNTYPE -->
				   </li>
 					   <li>
						  申请事由:
						  <em><%=info.getReason()%></em>
					   </li>
			</ul>
		</div>
		<%@include file="approve_process.jsp" %>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>