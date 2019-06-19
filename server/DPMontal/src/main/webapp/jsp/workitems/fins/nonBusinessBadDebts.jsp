
<%@page import="java.text.Format"%>
<%@page import="java.util.List"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>

<%@page import="com.deppon.fins.esb.mobile.domain.UnBaddebtMobileWfEntity"%>
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
 UnBaddebtMobileWfEntity infoBasic =finsResponse.getMobileFinsWfEntity().getUnBaddebtMobileWfEntity();
 //其他信息
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
					<th >坏账类型:</th>
					<td><%=infoBasic.getBadBillTypeName() == null ? "" : infoBasic.getBadBillTypeName()%></td>
				</tr>
				<!-- 坏账类型：押金，保证金   1-->
				<tr class="classOne">
					<th class="classOne">押金类型:</th>
					<td class="classOne"><%=infoBasic.getDepositTypeName() == null ? "" : infoBasic.getDepositTypeName()%></td>
				</tr>
				<tr class="classOne">
					<th class="classOne">押金编号:</th>
					<td class="classOne"><%=infoBasic.getCodeNum() == null ? "" : infoBasic.getCodeNum()%></td>
				</tr>
				<tr class="classOne">
					<th class="classOne">押金收取方:</th>
					<td class="classOne"><%=infoBasic.getDepositName() == null ? "" : infoBasic.getDepositName()%></td>
				</tr>
				<tr class="classOne">
					<th class="classOne">起始日期:</th>
					<td class="classOne"><%=infoBasic.getStartDate() == null ? "" : infoBasic.getStartDate()%></td>
				</tr>
				<tr class="classOne">
					<th class="classOne">结束日期:</th>
					<td class="classOne"><%=infoBasic.getEndDate() == null ? "" : infoBasic.getEndDate()%></td>
				</tr>
				
				<!-- 坏账类型：应交营业款  3 -->
				<tr class="classTwo">
					<th class="classTwo">客户:</th>
					<td class="classTwo"><%=infoBasic.getDepositName() == null ? "" : infoBasic.getDepositName()%></td>
				</tr>
				
				<!-- 公有 -->
				<tr>
					<th >坏账金额:</th>
					<td><%=infoBasic.getBadBillMoney() == null ? "" : infoBasic.getBadBillMoney()%></td>
				</tr>
				<tr>
					<th >差错编号:</th>
					<td><%=infoBasic.getErrorcode() == null ? "" : infoBasic.getErrorcode()%></td>
				</tr>
				<tr>
					<th >产生坏账原因:</th>
					<td><%=infoBasic.getReasonForBadBill() == null ? "" : infoBasic.getReasonForBadBill()%></td>
				</tr>
				<tr>
					<th colspan="2" class="yellow">差错信息</th>
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
<script type="text/javascript">
$(function(){
	
	var badBillType = <%=infoBasic.getBadBillType()%>;
	if (badBillType == 1) {
		$(".classOne").show();
		$(".classTwo").hide();
	}else if(badBillType == 3){
		$(".classOne").hide();
		$(".classTwo").show();
	}
});
</script>
</body>
</html>