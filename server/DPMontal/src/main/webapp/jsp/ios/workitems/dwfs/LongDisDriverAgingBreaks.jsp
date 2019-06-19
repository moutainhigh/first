<%@page import="com.deppon.wfs.workflow.domain.LongDisDriverAgingBreaksBean"%>
<%@page import="com.deppon.wfs.workflow.domain.LongDisDriversDataDellBean"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_ios.jsp" %>
</head>
<%
LongDisDriverAgingBreaksBean info = (LongDisDriverAgingBreaksBean)request.getAttribute("entity");
%>
<body>
<div id="list">
	<%@include file="/jsp/ios/work_items_head.jsp" %>
	<div id="div2">
		<div class="ulBox2">
    		<ul>
				<li class="first">工作流号:
			        <em><%=request.getAttribute("processinstid") %>
					<input type="hidden" id="busino" value="<%=info.getBusino()%>">
					<input type="hidden" id="approval_url" value="<%=F_Constants.NORMOL_APPROVAL_URL%>">		  	   		
			   		</em>
			   </li>
			   <li>工作流:<em>长途司机时效减免申请</em></li>
			   	<li>
				  申请人:
				  <em><%=info.getApplyPersonName()%></em>
			   </li>
				 <li>
				  工号:
				  <em><%=info.getApplyPersonId()%></em>
			   </li>
			   <li>
				  所在部门:
				  <em><%=info.getApplyDept()%></em>
			   </li>
			   <li>
				 联系方式:
				  <em><%=info.getContact()%></em>
			   </li>
			   <li>
				  是否涉及安全:
				  <em><%=info.getIsInvolvingSecurity() %></em><!-- WFS_ISINVOLVINGSECURITY -->
			   </li>
			   
					<li style="color: red">时效减免</li>
				<%
				List<LongDisDriversDataDellBean> dataCells = info.getDataCells();
				int length = dataCells == null ? 0:dataCells.size();
					for(int i=0;i<length;i++){
						LongDisDriversDataDellBean entry = dataCells.get(i);
				%>
				   <li <%=i==0?"":"class='line'" %>>申请减免类型:<em><%=entry.getApplyBreaksType()%></em></li><!-- WFS_APPLYBREAKSTYPE -->
				<li>
				   超时时长:
				   <em><%=entry.getTimeoutValue()%></em><!-- WFS_TIMEOUTVALUE -->
				</li>
				<li>
				   发车日期 :
				   <em><%=FormatUtil.formatDate(entry.getStartDate(), "yyyy-MM-dd")%></em>
				</li>
				<li>
				  运行线路:
				  <em><%=entry.getRunningRoute()%></em>
			   </li>
			   <li>
				  车牌号:
				  <em><%=entry.getLicensePlateNumber()%></em>
			   </li>
			   <li>
				  驾驶员:
				  <em><%=entry.getDriver()%></em>
			   </li>
			   <li>
				  出发地:
				  <em><%=entry.getOrigin()%></em>
			   </li>
			   <li>
				  到达地:
				  <em><%=entry.getDestination()%></em>
			   </li>
			   	<%
					}
			   	%>
			    
				  <li>申请事由:<em><%=info.getReason()==null?"":info.getReason() %></em></li>
		  </ul>
		</div>
		<%@include file="approve_process.jsp" %>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>