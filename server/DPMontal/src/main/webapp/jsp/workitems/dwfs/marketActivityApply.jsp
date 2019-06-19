<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.module.workitems.webservice.client.DWFSWorkItemServiceClient"%>
<%@page import="com.deppon.wfs.workflow.domain.MarketActivityBean"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_win8.jsp" %>
	<style>
	tr.details, tr.qytr { display:none;}
	</style>
</head>
<body onload="autoShowApproval()">
<%
MarketActivityBean info = (MarketActivityBean)request.getAttribute("entity");
%>
<div id="list">
	<%@include file="../wf_head_win8.jsp" %>
	<input type="hidden" id="busino" value="<%=info.getBusino()%>">
	<input type="hidden" id="approval_url" value="<%=F_Constants.NORMOL_APPROVAL_URL%>">
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
	    		<tr>
					   <th>工作流号:</th>
					   <td id="workid"><%=request.getAttribute("processinstid")%></td>
					</tr>
					<tr>
					   <th>工&nbsp;&nbsp;作&nbsp;&nbsp;流:</th>
					   <td>营销活动申请<input type="hidden" id ="type_id" value="qualification"></td>
					</tr>
				   <tr>
					  <th>申请人:</th>
					  <td><%=info.getApplyPersonName()%></td>
				   </tr>
					 <tr>
					  <th>申请人工号:</th>
					  <td><%=info.getApplyPersonId()%></td>
				   </tr>
				   <tr>
					  <th>所属事业部:</th>
					  <td><%=info.getSubOrdinateDivision()  %></td><!-- DIP_DIVISION_NEW -->
				   </tr>
					 <tr>
					  <th>使用部门数:</th>
					  <td><%=info.getUseDeptNum()%></td>
				   </tr>
					 <tr>
					  <th>营销所属类型:</th>
					  <td><%=info.getMarketType() %> </td>
				   </tr>
				   <tr>
					  <th>是否为现有资料补做:</th>
					  <td><%=info.getIsRedo() %></td><!-- WFS_ISORNO -->
				   </tr>
				   <% if("lineType".equals(info.getType())){
					   //宣传线路类型%>
					<tr>
					  <th>宣传线路类型:</th>
					  <td><%=info.getPropagandalineType()%></td><!-- WFS_PUBLICITYLINE -->
				   	</tr>
					   <%
				   }else if ("businessType".equals(info.getType())){
					   //宣传业务类型%>
					<tr>
					  <th>宣传业务类型:</th>
					  <td><%=info.getPropagandaBusType()%></td><!-- WFS_PROPAGANDABUSTYPE -->
				   </tr>	   
				<%}else if("guildType".equals(info.getType())){
					   //宣传行业类型%>
					<tr>
					<th>宣传行业类型:</th>
					  <td><%=info.getPropagandainDustryType() %></td><!-- WFS_PROPAGANDAINDUSTRYTYPE -->
				   	</tr>
				<%}else{
					  //宣传空运类型%>
				<tr>
					  <th>宣传空运类型:</th>
					  <td><%=info.getPropaganDaairType()%></td><!-- WFS_PROPAGANDAAIRTYPE -->
				</tr>
				<%}%>
					 <tr>
					  <th>宣传主题:</th>
					  <td><%=info.getPropagandaTheme()%></td>
				   </tr>
				   <tr>
					  <th>开展区域:</th>
					  <td><%=info.getRegionin()%></td>
				   </tr>	
				   <% 
				   String type = info.getType();
				   if("lineType".equals(type)){%>
					 <tr>
					  <th>出发城市:</th>
					  <td><%=info.getFromCity()%></td>
				   </tr>   
					 <tr>
					  <th>到达城市:</th>
					  <td><%=info.getToCity()%></td>
				   </tr>
				    <tr>
					  <th>可提货时间:</th>
					  <td><%=info.getDeliveryTime()%></td>
				   </tr>      
				   <%}%>
				   <tr>
					  <th>活动开始时间:</th>
					  <td><%=FormatUtil.formatDate(info.getActivityStartTime())%></td>
				   </tr>
				   <tr>
					  <th>活动结束时间:</th>
					  <td><%=FormatUtil.formatDate(info.getActivityEndTime())%></td>
				   </tr>
				   <tr>
					  <th>第一个月目标:</th>
					  <td><%=info.getFirstTarget()%></td>
				   </tr>
				   <tr>
					  <th>第二个月目标:</th>
					  <td><%=info.getSecondTarget()%></td>
				   </tr>
				   	<tr>
					  <th>第三个月目标:</th>
					  <td><%=info.getThirdTarget()%></td>
				   </tr>
				   <tr>
					  <th>申请数量:</th>
					  <td><%=info.getApplyNumber()%></td>
				   </tr>	
				   <tr>
					  <th>针对人群:</th>
					  <td><%=info.getAccordingTocrowd()%></td>
				   </tr>
				   <tr>
					  <th>对接人:</th>
					  <td><%=info.getDockingPeople()%></td>
				   </tr>
				   <tr>
					  <th>联系电话:</th>
					  <td><%=info.getTelphone()%></td>
				   </tr>
				   <tr>
					  <th>设计类型:</th>
					  <td><%=info.getDesignType()%></td><!-- WFS_DESIGNTYPE -->
				   </tr>
 					   <tr>
						  <th>申请事由:</th>
						  <td><%=info.getReason()%></td>
					   </tr>
					   
				<%@include file="approve_process.jsp" %>					   					   
	    	</table>
	    </div>
	</div>
	 <%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>