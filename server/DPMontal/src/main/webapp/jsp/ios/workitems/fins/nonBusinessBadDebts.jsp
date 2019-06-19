<%@page import="java.util.List"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.fins.esb.mobile.domain.WfInfoEntity" %>
<%@page import="com.deppon.fins.esb.mobile.domain.WayInfoPojo" %>
<%@page import="com.deppon.fins.esb.mobile.domain.Duty" %>
<%@page import="com.deppon.fins.esb.mobile.domain.InitWorkFlowViewDataResponse" %>
<%@page import="com.deppon.fins.esb.mobile.domain.UnBaddebtMobileWfEntity"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title><%=InitDataServlet.getValue("page_title")%>-待办事项</title>
<meta http-equiv="Content-Type"
	content="application/xhtml+xml; charset=UTF-8" />
<%@include file="/common_ios.jsp"%>
<style type="text/css">
li {
	word-wrap: break-word;
}
</style>
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
	<%@include file="/jsp/ios/work_items_head.jsp" %>
	<div id="div2">
    	<div class="ulBox2">
	    	<ul>
				<li class="first"><em class="yellow">基本信息</em></li>
				<li>工作流号:<em><%=applyInfo.getWorkflowid() == null ? "" : applyInfo.getWorkflowid()%></em></li>
				<li>申请时间:<em><%=applyInfo.getApplydate() == null ? "" : applyInfo.getApplydate()%></em></li>
				<li>申请人:<em><%= applyInfo.getApplyname() == null ? "" : applyInfo.getApplyname()%></em></li>
				<li>申请部门:<em><%=applyInfo.getApplydept() == null ? "" : applyInfo.getApplydept()%></em></li>
				
				<li><em class="yellow">坏账信息</em></li>
				<li>工作流名称:<em><%=infoBasic.getWorkflowName() == null ? "" : infoBasic.getWorkflowName()%></em></li>
				<li>坏账类型:<em><%=infoBasic.getBadBillTypeName() == null ? "" : infoBasic.getBadBillTypeName()%></em></li>
				<!-- 坏账类型：押金，保证金   1-->
				<li class="classOne">押金类型:<em class="classOne"><%=infoBasic.getDepositTypeName() == null ? "" : infoBasic.getDepositTypeName()%></em></li>
				<li class="classOne">押金编号:<em class="classOne"><%=infoBasic.getCodeNum() == null ? "" : infoBasic.getCodeNum()%></em></li>
				<li class="classOne">押金收取方:<em class="classOne"><%=infoBasic.getDepositName() == null ? "" : infoBasic.getDepositName()%></em></li>
				<li class="classOne">起始日期:<em class="classOne"><%=infoBasic.getStartDate() == null ? "" : infoBasic.getStartDate()%></em></li>
				<li class="classOne">结束日期:<em class="classOne"><%=infoBasic.getEndDate() == null ? "" : infoBasic.getEndDate()%></em></li>
				<!-- 坏账类型：应交营业款  3 -->
				<li class="classTwo">客户:<em class="classTwo"><%=infoBasic.getDepositName() == null ? "" : infoBasic.getDepositName()%></em></li>
				<!-- 公有 -->
				<li>坏账金额:<em><%=infoBasic.getBadBillMoney() == null ? "" : infoBasic.getBadBillMoney()%></em></li>
				<li>差错编号:<em><%=infoBasic.getErrorcode() == null ? "" : infoBasic.getErrorcode()%></em></li>
				<li>产生坏账原因:<em><%=infoBasic.getReasonForBadBill() == null ? "" : infoBasic.getReasonForBadBill()%></em></li>
				<li><em class="yellow">差错信息</em></li>
			   <%
				int size2 = dutyList == null ? 0 : dutyList.size();
				for(int i=0; i< size2; i++){
					Duty  duty = dutyList.get(i);
				%>
				 <li <%=i==0?"":"class='line'" %>>责任部门:<em><%=duty.getResponsibledept() == null ? "" : duty.getResponsibledept()%></em></li>	
				 <li>入部门费用:<em><%=duty.getIndeptmoney() == null ? "" : duty.getIndeptmoney()%></em></li>	
				 <li>责任人:<em><%=duty.getResponsibleperson() == null ? "" : duty.getResponsibleperson()%></em></li>	
				 <li>个人扣款:<em><%=duty.getDeductionamount() == null ? "" : duty.getDeductionamount()%></em></li>	
				<%
				}
				%>	
		  </ul>
			</div>
			<%@include file="approve_process.jsp"%>
		</div>
		<%@include file="workflow_approve_button.jsp"%>
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