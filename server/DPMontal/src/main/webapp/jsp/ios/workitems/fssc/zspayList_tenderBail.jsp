<%@page import="com.deppon.fssc.module.remote.mobile.shared.ClaimLineFssc"%>
<%@page import="com.deppon.fssc.module.remote.mobile.shared.ClaimFsscBase"%>
<%@page import="com.deppon.fssc.module.remote.mobile.service.MobileFsscEntity"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page language="java" pageEncoding="UTF-8"%>
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
<%
	MobileFsscEntity entity = (MobileFsscEntity) request
			.getAttribute("mobileFsscEntity");
	ClaimFsscBase baseEntity = entity.getMobileBaseEntity();
	ClaimLineFssc[] lineBaseList = entity.getMobileLineArray();
%>
<body>
	<div id="list">
		<%@include file="/jsp/ios/work_items_head.jsp"%>
		<!--div2 S-->
		<div id="div2">
			<div class="ulBox2">
				<ul>
					<li class="first"><em class="yellow">基本信息 </em></li>
					<li>工作流:<em>暂收款支付-投标保证金</em></li>
					<li>单据编号:<em><%=baseEntity.getClaimNo()%></em></li>
					<li>申请人:<em><%=baseEntity.getApplyEmpName()%></em></li>
					<li>申请日期:<em><%=baseEntity.getApplyDateStr()%></em></li>
					<li>申请人部门:<em><%=baseEntity.getApplyDeptName()%></em></li>
					<li>申请人公司:<em><%=baseEntity.getApplyCompName()%></em></li>
					<li><em class="yellow">报账信息</em></li>
					<li>币种: <em><%=baseEntity.getCurrency()%></em>
					</li>
					<li>发票抬头: <em><%=baseEntity.getInvoiceTitle()%></em>
					</li>
					<li>所属财务部:<em><%=baseEntity.getFinancialDept()%></em></li>
					<li>支付方式:<em><%=baseEntity.getPayType()%></em>
					</li>
					<li>收款方: <em><%=baseEntity.getAccountName() == null ? "" : baseEntity
					.getAccountName()%></em>
					</li>
					<li>账户性质: <em><%=baseEntity.getAccountNature()%></em>
					</li>
					<li>最迟汇款日期: <em><%=baseEntity.getLatestRemitDateStr()%></em>
					</li>
					<li>手机号码: <em><%=baseEntity.getContactInfo() == null ? "" : baseEntity
					.getContactInfo()%></em>
					</li>
					<li>申请事由及说明: <em><%=baseEntity.getCostExplain()%></em>
					</li>
					<li class="yellow"><em>付款信息</em></li>
					<li>报账金额: <em><%=FormatUtil.formatMoney(baseEntity.getApplyAmount())%></em>
					</li>
<%-- 					<li>核销金额: <em><%=FormatUtil.formatMoney(baseEntity --%>
<%-- 					.getAlreadyWritedAmount())%></em> --%>
<!-- 					</li> -->
					<li>付款金额: <em><%=FormatUtil.formatMoney(baseEntity.getPayAmount())%></em>
					</li>
					<li>币种: <em><%=baseEntity.getCurrency()%></em>
					</li>
					<li>付款金额大写: <em id='amountCNY'></em>
					</li>
					<li>账户性质: <em><%=baseEntity.getAccountNature()%></em>
					</li>
					<li>银行账号: <em><%=baseEntity.getAccount()%></em>
					</li>
					<li>开户支行: <em><%=baseEntity.getSubbankName()%></em>
					</li>

					<li><em class="yellow">暂收款支付信息</em></li>
					<%
						for (int i = 0; i < lineBaseList.length; i++) {
							ClaimLineFssc line = lineBaseList[i];
					%>
					<li <%=i == 0 ? "" : "class='line'"%>>认领编号:<em><%=line.getApplyNum()%></em></li>
					<li>押金系统编号:<em><%=line.getDepositSysnum()%></em></li>
					<li>费用承担部门:<em><%=line.getCostCenterName()%></em></li>
					<li>押金类型:<em><%=line.getDepositType()%></em></li>
					<li>暂收款客户:<em><%=line.getClientName()%></em></li>
					<li>暂收款客户关联号:<em><%=line.getClientCode()== null ? "无" : line.getClientCode()%></em></li>
					<li>费用类型:<em><%=line.getScName()%></em></li>
					<li>暂收款总金额:<em><%=FormatUtil.formatMoney(line.getDepositTotAmount())%></em></li>
					<li>收据编号:<em><%=line.getReceiptNum()== null ? "无" : line.getReceiptNum()%></em></li>
					<li>可支付金额:<em><%=FormatUtil.formatMoney(line.getAblePayAmount())%></em></li>
					<li>暂收日期:<em><%=line.getDepositDate()%></em></li>
					<li>汇款人账号:<em><%= line.getAccountNo() == null ? "无" : line.getAccountNo()%></em></li>
					<li>是否中标:<em><%="Y".equals(line.getIsWin()) ? "是":"否" %></em></li>
					<% if("Y".equals(line.getIsWin())){%>
					<li>合同到期日:<em><%=line.getExpireDate() == null ? "无" : line.getExpireDate()%></em></li>
				   <%} %>
					<li>退款日期:<em><%=line.getRefundDate() == null ? "无" : line.getRefundDate()%></em></li>
					<% if("N".equals(line.getIsWin())){%>
					 <li>招标日期:<em><%=line.getInviteBidDate() == null ? "无" : line.getInviteBidDate()%></em></li>
				   <%} %>
					<li>客户在本次业务往来中是否存在违约行为:<em><%="Y".equals(line.getIsBreach()) ? "是":"否" %></em></li>
					<li>扣除违约金额:<em><%=FormatUtil.formatMoney(line.getDeductBreachAmount())%></em></li>
					<li>本次退款金额:<em><%=FormatUtil.formatMoney(line.getPayAmount())%></em></li>
					<li>剩余金额:<em><%=FormatUtil.formatMoney((line.getAblePayAmount().subtract(line.getDeductBreachAmount())).subtract(line.getPayAmount()))%></em></li>
					<%
						}
					%>
				</ul>
			</div>
			<%@include file="approve_process.jsp"%>
		</div>
		<%@include file="workflow_approve_button.jsp"%>
		<input type="hidden"
			value="<%=request.getAttribute("activitydefid")%>" id="activitydefid">
	</div>
<script type="text/javascript">
	$(function() {
		//将付款金额转成大写
		$("#amountCNY").html(numToCny(<%=baseEntity.getPayAmount()%>));
// 			//直接上级、起草人；
// 			var activitydefid = $("#activitydefid").val();
// 			if (activitydefid != 'zjsj') {
// 				$("#approve_area").hide();
// 				$("#div3").hide();
// 			}
		});
	</script>
</body>
</html>