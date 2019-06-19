<%@page import="com.deppon.wfs.workflow.domain.LongDisDriverAgingBreaksBean"%>
<%@page import="com.deppon.wfs.workflow.domain.LongDisDriversDataDellBean"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
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
LongDisDriverAgingBreaksBean info = (LongDisDriverAgingBreaksBean)request.getAttribute("entity");
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
				   <td>长途司机时效减免申请</td>
				</tr>
			   <tr>
				  <th>申请人:</th>
				  <td><%=info.getApplyPersonName()%></td>
			   </tr>
				 <tr>
				  <th>工号:</th>
				  <td><%=info.getApplyPersonId()%></td>
			   </tr>
			   <tr>
				  <th>所在部门:</th>
				  <td><%=info.getApplyDept()%></td><
			   </tr>
			   <tr>
				  <th>联系方式:</th>
				  <td><%=info.getContact()%></td>
			   </tr>
			   <tr>
				  <th>是否涉及安全:</th>
				  <td><%=info.getIsInvolvingSecurity() %></td><!-- WFS_ISINVOLVINGSECURITY -->
			   </tr>
			   
			   <tr>
					<th colspan="2" class="yellow">时效减免</th>
				</tr>
				<%	List<LongDisDriversDataDellBean> dataCells = info.getDataCells();
				int length = dataCells == null ? 0:dataCells.size();
					for(int i=0;i<length;i++){
						LongDisDriversDataDellBean entry = dataCells.get(i);
				%>
					<tr class="topLine">
				   <th>申请减免类型:</th>
				   <td><%=entry.getApplyBreaksType()%></td><!-- WFS_APPLYBREAKSTYPE -->
				</tr>
				<tr>
				   <th>超时时长:</th>
				   <td><%=entry.getTimeoutValue()%></td><!-- WFS_TIMEOUTVALUE -->
				</tr>
				<tr>
				   <th>发车日期 :</th>
				   <td><%=FormatUtil.formatDate(entry.getStartDate(), "yyyy-MM-dd")%></td>
				</tr>
				<tr>
				  <th>运行线路:</th>
				  <td><%=entry.getRunningRoute()%></td>
			   </tr>
			   <tr>
				  <th>车牌号:</th>
				  <td><%=entry.getLicensePlateNumber()%></td>
			   </tr>
			   <tr>
				  <th>驾驶员:</th>
				  <td><%=entry.getDriver()%></td>
			   </tr>
			   <tr>
				  <th>出发地:</th>
				  <td><%=entry.getOrigin()%></td>
			   </tr>
			   <tr>
				  <th>到达地:</th>
				  <td><%=entry.getDestination()%></td>
			   </tr>
			   	<%
					}
			   	%>
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