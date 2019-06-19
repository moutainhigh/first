<%@page import="com.deppon.montal.model.OAMarketingActivities"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_win8.jsp" %>
</head>
</head>
<%
OAMarketingActivities info = (OAMarketingActivities)request.getAttribute("OAMarketingActivities");
%>
<body>
<div id="list">
	<%@include file="wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
				<tr><th>工作流号:</th><td id="workid"><%=info.getProcessinstid() %></td></tr>
				<tr><th>工作流:</th><td>营销活动申请</td></tr>
				<tr><th>申请人:</th><td><%=info.getApplyer()%></td></tr>
				<tr><th>申请人工号:</th><td><%=info.getUserid()%></td></tr>
				<tr><th>所属事业部:</th><td><%=info.getSubordinatedivision()%></td></tr>
				<tr><th>使用部门数:</th><td><%=info.getUsedepartmentnumber()%></td></tr>
				<tr><th>营销所属类型:</th><td><%=info.getMarkingtype()%></td></tr>
				<tr><th>是否为现有资料补做:</th><td><%=info.getIsredo()%></td></tr>
				<tr><th>宣传主题:</th><td> <%=info.getPropagandatheme()%></td></tr>		
				<tr><th>开展大区:</th><td> <%=info.getRegionin()%></td></tr>		
				<tr><th>开展小区:</th><td> <%=info.getConductscommunity()%></td></tr>
				
				<%if ("lineType".equals(info.getMarketingsubordinatetype())){ %>
				
				<tr><th>宣传路线类型:</th></th><td> <%=info.getPropagandalinetype()%></td></tr>
				<tr><th>出发城市:</th><td> <%=info.getFromcity()%></td></tr>		
				<tr><th>到达城市:</th><td> <%=info.getTocity()%></td></tr>		
				<tr><th>可提货时间:</th><td> <%=info.getDeliverytime()%></td></tr>
						
				<%} %>	
					
				<%if ("businessType".equals(info.getMarketingsubordinatetype())){ %>
				
				<tr><th>宣传业务类型:</th><td> <%=info.getPropagandabustype()%></td></tr>
					
				<%} %>		
				
				<%if ("guildType".equals(info.getMarketingsubordinatetype())){ %>
				
				<tr><th>宣传行业类型:</th><td> <%=info.getPropagandaindustrytype()%></td></tr>
					
				<%} %>		
				
				<%if ("airType".equals(info.getMarketingsubordinatetype())){ %>
				
				<tr><th>宣传空运类型:</th><td> <%=info.getPropagandaairtype()%></td></tr>
				
				<%} %>		
				<tr><th>活动开始时间:</th><td> <%=info.getActivitystarttime()%></td></tr>		
				<tr><th>活动结束时间:</th><td> <%=info.getActivityendtime()%></td></tr>
				<tr><th>第一个月目标:</th><td> <%=info.getFirsttarget()%></td></tr>		
				<tr><th>第二个月目标:</th><td> <%=info.getSecondtarget()%></td></tr>		
				<tr><th>第三个月目标:</th><td> <%=info.getThirdtarget()%></td></tr>
				<tr id="appstr"><th colspan="2"><a class="yellow">设计要求</a></th></tr>		
				<tr><th>申请数量:</th><td> <%=info.getApplynumber()%></td></tr>		
				<tr><th>针对人群:</th><td> <%=info.getAccordingtocrowd()%></td></tr>
				<tr><th>对接人:</th><td> <%=info.getDockingpeople()%></td></tr>		
				<tr><th>联系电话:</th><td> <%=info.getTelphone()%></td></tr>		
				<tr><th>设计类型:</th><td> <%=info.getDesigntype()%></td></tr>		
				<tr><th>申请事由</th><td><%=info.getReason()%></td></tr>
		 </table>
		<%@include file="approve_process.jsp" %>
    	</div>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>