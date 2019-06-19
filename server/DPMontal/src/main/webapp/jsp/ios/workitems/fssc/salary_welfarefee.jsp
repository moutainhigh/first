<%@page import="java.util.Date"%> 
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.apache.commons.lang.StringUtils" %>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.fssc.module.remote.mobile.service.MobileFsscEntity"%>
<%@page import="com.deppon.fssc.module.remote.mobile.shared.ClaimLineFssc"%>
<%@page import="com.deppon.fssc.module.remote.mobile.shared.ClaimFsscBase"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_ios.jsp" %>
</head>

<body>
 <%
 MobileFsscEntity entity = (MobileFsscEntity)request.getAttribute("mobileFsscEntity");
	ClaimFsscBase  info =  entity.getMobileBaseEntity();
	ClaimLineFssc[] lineBaseList = entity.getMobileLineArray(); 
 %>
<div id="list">
	<%@include file="/jsp/ios/work_items_head.jsp" %>
	<div id="div2">
    	<div class="ulBox2">
	    	<ul>
	    		<li class="first"><em class="yellow">基本信息</em></li>
	    		<li>单据编号:<em><%=info.getClaimNo() %></em></li>
				<li>申请人:<em><%=info.getApplyEmpName()%></em></li>
				<li>申请日期:<em><%=info.getApplyDateStr()== null?"":info.getApplyDateStr()%></em></li>	
				<li>申请人部门:<em><%=info.getApplyDeptName()%></em></li>
				<li>申请人公司:<em><%=info.getApplyCompName()%></em></li>
				
				<li><em class="yellow">报账信息</em></li>
				<li>工作流名称:<em>福利费其他</em></li>
				<li>币种:<em><%=info.getCurrency()%></em></li>
				<li>发票抬头:<em><%=info.getInvoiceTitle()%></em></li>
				<li>支付方式:<em><%=info.getPayType()%></em></li>
				<li>收款方:<em><%=info.getAccountName()%></em></li>
				<li>手机号码:<em><%=info.getContactInfo()==null?"":info.getContactInfo()%></em></li>
				<li>所属财务部:<em><%=info.getFinancialDept()%></em></li>
				<li>所属薪酬组:<em><%=info.getSalaryGroupName()%></em></li>
				<li>最迟汇款日期:<em><%=info.getLatestRemitDateStr()%></em></li>
				<li>申请事由及说明:<em><%=StringUtils.isEmpty(info.getCostExplain())?"":info.getCostExplain()%></em></li>      
				
				<li><em class="yellow">付款信息</em></li>
				<li>报账金额:<em><%=FormatUtil.formatMoney(info.getApplyAmount())%></em></li>
				<li>付款金额:<em><%=FormatUtil.formatMoney(info.getPayAmount())%></em></li>
				<li>核销金额:<em><%=FormatUtil.formatMoney(info.getAlreadyWritedAmount())%></em></li>
				<li class="changeByAccount">核定金额:<em class="changeByAccount"><%=FormatUtil.formatMoney(info.getRatifyAmount()) %></em></li>
				<li>币种:<em><%=info.getCurrency()%></em></li>
				<li>付款金额大写:<em id="amountCNY"></em></li>
				<li>账户性质:<em><%=info.getAccountNature()==null?"":info.getAccountNature()%></em></li>
				<li>银行账号:<em><%=info.getAccount()%></em></li>
				<li>开户支行:<em><%=info.getSubbankName()%></em></li>
				
				<li><em class="yellow">明细信息</em></li>
				<%
				for(int i=0; i< lineBaseList.length; i++){	
					ClaimLineFssc line = lineBaseList[i];
				 %>
				<li <%=i==0?"":"class='topLine'" %>>费用类型:<em><%=line.getScName()%></em></li>
				<li>员工工号:<em><%=line.getEmpCode()==null?"无":line.getEmpCode()%></em></li>
				<li>员工姓名:<em><%=line.getEmpName()==null?"无":line.getEmpName()%></em></li>
				<li>费用期间:<em><%=line.getCostPeriod()==null?"":line.getCostPeriod()%></em></li>
				<li>费用承担部门:<em><%=line.getCostCenterName()%></em></li>
				<%-- <li>业务发生日期:<em><%=line.getBizOccurDateStr()==null?"":line.getBizOccurDateStr()%></em></li> --%>
				<li>社保主体:<em><%=line.getSecurityUnits()==null?"无":line.getSecurityUnits()%></em></li>
				<li>实发小计:<em><%=FormatUtil.formatMoney(line.getActualAmount())%></em></li>
				<li class="changeByAccount">核定金额:<em class="changeByAccount"><%= line.getRetifyAmount() == null ? "" : FormatUtil.formatMoney(line.getRetifyAmount())%></em></li>
				<%} %>
		  </ul>
		</div>
		<%@include file="approve_process.jsp"%>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
<input type="hidden" id="workid" value="<%=info.getWfInstanceId() %>">
</body>
<script type="text/javascript">
$(function(){
	//将付款金额转成大写
	$("#amountCNY").html(numToCny(<%=info.getPayAmount()%>));
	
	//核定金额在费用核算组核算专员审批过后才显示
	var accountXXID = $("#AccountXXIDIOS").val();
	if (accountXXID=='AccountXX') {
		$(".changeByAccount").show();
	}else {
		$(".changeByAccount").hide();
	}
});
</script>
</html>