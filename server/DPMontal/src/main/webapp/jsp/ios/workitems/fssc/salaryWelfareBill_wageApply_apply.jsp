<%@page import="com.deppon.fssc.module.remote.mobile.shared.ClaimLineFssc"%>
<%@page import="com.deppon.fssc.module.remote.mobile.shared.ClaimFsscBase"%>
<%@page import="com.deppon.fssc.module.remote.mobile.service.MobileFsscEntity"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.conf.F_Constants"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<meta http-equiv = "Content-Type" content = "application/xhtml+xml; charset=UTF-8" />
	<%@include file="/common_ios.jsp" %>
	<style type="text/css">
	 li{word-wrap: break-word;}
	</style>
</head>
<%
	MobileFsscEntity entity = (MobileFsscEntity)request.getAttribute("mobileFsscEntity");
	ClaimFsscBase  baseEntity =  entity.getMobileBaseEntity();
	ClaimLineFssc[] lineBaseList = entity.getMobileLineArray(); 
%>
<body>
<div id="list">
	<%@include file="/jsp/ios/work_items_head.jsp" %>
    <!--div2 S-->
    <div id="div2">
    	<div class="ulBox2">
    		<ul>
				<li class="first"><em class="yellow">基本信息 </em></li>			
				<li>单据编号:<em><%=baseEntity.getClaimNo()%></em></li>
				<li>申请人公司:<em><%=baseEntity.getApplyCompName() %></em></li>
				<li>申请日期:<em><%=baseEntity.getApplyDateStr()%></em></li>
				<li>申请人:<em><%=baseEntity.getApplyEmpName() %></em></li>				
				<li>申请人部门:<em><%=baseEntity.getApplyDeptName() %></em></li>
				
								
				<li><em class="yellow">报账信息</em></li> 
				<li>工作流名称:<em>薪酬福利报账单—工资申请</em></li> 
				<li>发票抬头:<em><%=baseEntity.getInvoiceTitle()%></em></li>
				<li>所属财务部:<em><%=baseEntity.getFinancialDept()%></em></li>
				<li>支付方式:<em><%=baseEntity.getPayType() %></em></li>
				<li>币种:<em><%=baseEntity.getCurrency() %></em></li>
				<li>收款方:<em><%=baseEntity.getAccountName() == null ? "" : baseEntity.getAccountName()%></em></li>
				<li>最迟汇款日期:<em><%=baseEntity.getLatestRemitDateStr()%></em></li>
				<li>手机号码:<em><%=baseEntity.getContactInfo()==null?"":baseEntity.getContactInfo()%></em></li>
				<li>申请事由及说明:<em><%=baseEntity.getCostExplain()==null?"":baseEntity.getCostExplain()%></em></li>
					
				<li><em class="yellow">付款信息</em></li>
				<li>报账金额:<em><%=FormatUtil.formatMoney(baseEntity.getApplyAmount()) %></em></li>
				<li>付款金额:<em><%=FormatUtil.formatMoney(baseEntity.getPayAmount()) %></em></li>
				<li>核销金额:<em><%=FormatUtil.formatMoney(baseEntity.getAlreadyWritedAmount()) %></em></li>
				<li class="changeByAccount">核定金额:<em class="changeByAccount"><%=FormatUtil.formatMoney(baseEntity.getRatifyAmount()) %></em></li>
				<li>币种:<em><%=baseEntity.getCurrency() %></em></li>
				<li>付款金额大写:<em id="amountCNY"></em></li>
				<li>账户性质:<em><%=baseEntity.getAccountNature()==null?"":baseEntity.getAccountNature()%></em></li>
				<li>银行账号:<em><%=baseEntity.getAccount()%></em></li>
				<li>开户支行:<em><%=baseEntity.getSubbankName()%></em></li>
				
				<li><em class="yellow">其他信息-明细信息</em></li>
				<%
					for(int i=0; i< lineBaseList.length; i++){							
						ClaimLineFssc line = lineBaseList[i];
				%>
				<li>序号:<em><%=i+1 %></em></li>
				<li>费用类型:<em><%=line.getScName() %></em></li>
				<li>员工工号:<em><%=line.getEmpCode()  == null ? "无" : line.getEmpCode()%></em></li>
				<li>员工姓名:<em><%=line.getEmpName() == null ? "无" : line.getEmpName()%></em></li>
				<li>费用期间:<em><%=line.getCostPeriod() %></em></li>
				<li>费用承担部门:<em><%=line.getCostCenterName() %></em></li>
				<li>社保主体:<em><%=line.getSecurityUnits() %></em></li>
				<li class="changeByAccount2">实发小计:<em class="changeByAccount2"><%= line.getActualAmount() == null ? "" : line.getActualAmount()%></em></li>
				<li class="changeByAccount">核定金额:<em class="changeByAccount"><%= line.getRetifyAmount() == null ? "" : line.getRetifyAmount()%></em></li>
				<%
					}
				%>				
		  </ul>
		</div>
		<%@include file="approve_process.jsp" %>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>

<script type="text/javascript">
$(function(){
	//将付款金额转成大写
	$("#amountCNY").html(numToCny(<%=baseEntity.getPayAmount() %>));
	var accountXXID = $("#AccountXXIDIOS").val();
	if (accountXXID=='AccountXX') {
		$(".changeByAccount").show();
		$(".changeByAccount2").hide();
	}else {
		$(".changeByAccount2").show();
		$(".changeByAccount").hide();
	}
});
</script>
</body>
</html>