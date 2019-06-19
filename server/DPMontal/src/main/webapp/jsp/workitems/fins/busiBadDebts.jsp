
<%@page import="java.text.Format"%>
<%@page import="java.util.List"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.model.OaRewardpunishmentInfo"%>
<%@page import="com.deppon.montal.model.OaDeptexpenses"%>
<%@page import="com.deppon.montal.model.OaAccidentdescriptionInfo"%>
<%@page import="com.deppon.montal.model.OaNomalClaim"%>
<%@page import="com.deppon.montal.conf.F_Constants"%>
<%@page import="com.deppon.montal.conf.Constants"%>

<%@page import="com.deppon.fins.esb.mobile.domain.BaddebtMobileWfEntity"%>
<%@page import="com.deppon.fins.esb.mobile.domain.WfInfoEntity" %>
<%@page import="com.deppon.fins.esb.mobile.domain.WayInfoPojo" %>
<%@page import="com.deppon.fins.esb.mobile.domain.Duty" %>
<%@page import="com.deppon.fins.esb.mobile.domain.InitWorkFlowViewDataResponse" %>

<%@ page language="java"  pageEncoding="UTF-8"%> 
<%@page import="java.util.Date"%> 
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.apache.commons.lang.StringUtils" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_win8.jsp" %>
	
</head>

<body>
 <%
 InitWorkFlowViewDataResponse finsResponse = (InitWorkFlowViewDataResponse)request.getAttribute("finsBusiRsp");
 //起草人信息
 WfInfoEntity applyInfo = finsResponse.getMobileFinsWfEntity().getWfInfoEntity();
 //坏账业务信息
 BaddebtMobileWfEntity infoBasic =finsResponse.getMobileFinsWfEntity().getBaddebtMobileWfEntity();
 //其他信息
 List<WayInfoPojo> wayInfoPojoList = infoBasic.getWayInfoPojo();
 List<Duty> dutyList= infoBasic.getDuty();
 %>
<div id="list">
	<%@include file="../wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
	    		<tr>
					<th colspan="2" class="yellow">基本信息</th>
				</tr>
				<tr>
				  <th >工作流号:</th>
				  <td><%=applyInfo.getWorkflowid() == null ? "" : applyInfo.getWorkflowid()%></td>
			   	</tr>
				<tr>
				  <th >申请时间:</th>
				  <td><%=applyInfo.getApplydate() == null ? "" : applyInfo.getApplydate()%></td>
			  	 </tr>
			   	<tr>
				  <th >申请人:</th>
				  <td><%= applyInfo.getApplyname() == null ? "" : applyInfo.getApplyname()%></td>
			   	</tr>
				<tr>
				  <th >申请部门:</th>
				  <td><%=applyInfo.getApplydept() == null ? "" : applyInfo.getApplydept()%></td>
			    </tr>
			   <tr>
					<th colspan="2" class="yellow">坏账信息</th>
			   </tr>	
			   <tr>
					<th >工作流名称:</th>
					<td><%=infoBasic.getWorkflowName() == null ? "" : infoBasic.getWorkflowName()%></td>
				</tr>
				<tr>
					<th >坏账金额:</th>
					<td><%=infoBasic.getBadamount() == null ? "" : infoBasic.getBadamount()%></td>
				</tr>
				<tr>
					<th >客户编码:</th>
					<td><%=infoBasic.getCustomercode() == null ? "" : infoBasic.getCustomercode()%></td>
				</tr>
				<tr>
					<th >客户名称:</th>
					<td><%= infoBasic.getCustomername() == null ? "" : infoBasic.getCustomername()%></td>
				</tr>
				<tr>
					<th >坏账原因:</th>
					<td><%=infoBasic.getReason() == null ? "" : infoBasic.getReason()%></td>
				</tr>
				<tr>
					<th >原因类型:</th>
					<td><%=infoBasic.getReasontypename() == null ? "" : infoBasic.getReasontypename()%></td>
				</tr>
				<tr>
					<th >差错处理编码:</th>
					<td><%=infoBasic.getErrorcode() == null ? "" : infoBasic.getErrorcode()%></td>
				</tr>
				<tr>
					<th >产生坏账原因:</th>
					<td><%=infoBasic.getDiscription() == null ? "" : infoBasic.getDiscription()%></td>
				</tr>
				<tr>
					<th colspan="2" class="yellow">运单信息</th>
			   </tr>
			   <%
				int size1 = wayInfoPojoList == null ? 0 : wayInfoPojoList.size();
				for(int i=0; i< size1; i++){
					WayInfoPojo  wayInfoPojo = wayInfoPojoList.get(i);
				%>
				 <tr <%=i==0 ? "" : "class='topLine'" %>><th>账单:</th> <td><%=wayInfoPojo.getBusinessnumber() == null ? "" : wayInfoPojo.getBusinessnumber()%></td> </tr>
				 <tr><th>未核销金额:</th> <td><%=wayInfoPojo.getNoverification() == null ? "" : wayInfoPojo.getNoverification()%></td> </tr>
				 <tr><th>业务日期:</th> <td><%=wayInfoPojo.getBusinessdate() == null ? "" : wayInfoPojo.getBusinessdate()%></td></tr>
				<%
				}
				%>	
				
				<tr>
					<th colspan="2" class="yellow">责任人及责任部门</th>
			   </tr>
			   <%
				int size2 = dutyList == null ? 0 : dutyList.size();
				for(int i=0; i< size2; i++){
					Duty  duty = dutyList.get(i);
				%>
				 <tr <%=i==0 ? "" : "class='topLine'" %>><th>责任部门:</th> <td><%=duty.getResponsibledept() == null ? "" : duty.getResponsibledept()%></td> </tr>
				 <tr><th>入部门费用:</th> <td><%=duty.getIndeptmoney() == null ? "" : duty.getIndeptmoney()%></td> </tr>
				 <tr><th>责任人:</th> <td><%=duty.getResponsibleperson() == null ? "" : duty.getResponsibleperson()%></td></tr>
				 <tr><th>个人扣款:</th> <td><%=duty.getDeductionamount() == null ? "" : duty.getDeductionamount()%></td></tr>
				<%
				}
				%>	
		  </table>
		  <%@include file="approve_process.jsp" %>
		</div>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>