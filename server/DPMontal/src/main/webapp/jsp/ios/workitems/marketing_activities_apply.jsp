<%@page import="com.deppon.montal.model.OAMarketingActivities"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_ios.jsp" %>
</head>
</head>
<%
OAMarketingActivities info = (OAMarketingActivities)request.getAttribute("OAMarketingActivities");
%>
<body>
<div id="list">
	<%@include file="/jsp/ios/work_items_head.jsp" %>
   <!--div2 S-->
   <div id="div2">
   	<div class="ulBox2">
			<ul>
				 <li class="first">工作流号:<em><%=info.getProcessinstid() %></em></li>
				<li>工作流:<em>营销活动申请</em></li>
				<li>申请人:<em><%=info.getApplyer()%></em></li>
				<li>申请人工号:<em><%=info.getUserid()%></em></li>
				<li>所属事业部:<em><%=info.getSubordinatedivision()%></em></li>
				<li>使用部门数:<em><%=info.getUsedepartmentnumber()%></em></li>
				<li>营销所属类型:<em><%=info.getMarkingtype()%></em></li>
				<li>是否为现有资料补做:<em><%=info.getIsredo()%></em></li>
				<li>宣传主题:<em> <%=info.getPropagandatheme()%></em></li>		
				<li>开展大区:<em> <%=info.getRegionin()%></em></li>		
				<li>开展小区:<em> <%=info.getConductscommunity()%></em></li>
				
				<%if ("lineType".equals(info.getMarketingsubordinatetype())){ %>
				
				<li>宣传路线类型:<em> <%=info.getPropagandalinetype()%></em></li>
				<li>出发城市:<em> <%=info.getFromcity()%></em></li>		
				<li>到达城市:<em> <%=info.getTocity()%></em></li>		
				<li>可提货时间:<em> <%=info.getDeliverytime()%></em></li>
						
				<%} %>	
					
				<%if ("businessType".equals(info.getMarketingsubordinatetype())){ %>
				
				<li>宣传业务类型:<em> <%=info.getPropagandabustype()%></em></li>
					
				<%} %>		
				
				<%if ("guildType".equals(info.getMarketingsubordinatetype())){ %>
				
				<li>宣传行业类型:<em> <%=info.getPropagandaindustrytype()%></em></li>
					
				<%} %>		
				
				<%if ("airType".equals(info.getMarketingsubordinatetype())){ %>
				
				<li>宣传空运类型:<em> <%=info.getPropagandaairtype()%></em></li>
				
				<%} %>		
				<li>活动开始时间:<em> <%=info.getActivitystarttime()%></em></li>		
				<li>活动结束时间:<em> <%=info.getActivityendtime()%></em></li>
				<li>第一个月目标:<em> <%=info.getFirsttarget()%></em></li>		
				<li>第二个月目标:<em> <%=info.getSecondtarget()%></em></li>		
				<li>第三个月目标:<em> <%=info.getThirdtarget()%></em></li>		
		   </ul>
    	</div>
    	<h4 class="yellow">设计要求</h4>	
		<div class="ulBox2">
			<ul>
				<li class="first">申请数量:<em> <%=info.getApplynumber()%></em></li>		
				<li>针对人群:<em> <%=info.getAccordingtocrowd()%></em></li>
				<li>对接人:<em> <%=info.getDockingpeople()%></em></li>		
				<li>联系电话:<em> <%=info.getTelphone()%></em></li>		
				<li>设计类型:<em> <%=info.getDesigntype()%></em></li>		
				<li>申请事由<em><%=info.getReason()%></em></li>
			</ul>
		</div>
    	<%@include file="approve_process.jsp" %>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
	
	
	
	
	<input type="hidden" id="workid" value="<%=info.getProcessinstid()%>">
</div>
</body>
</html>