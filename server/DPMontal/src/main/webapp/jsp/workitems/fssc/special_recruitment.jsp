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
	<%@include file="/common_win8.jsp" %>
</head>

<body>
 <%
 MobileFsscEntity entity = (MobileFsscEntity)request.getAttribute("mobileFsscEntity");
	ClaimFsscBase  info =  entity.getMobileBaseEntity();
	ClaimLineFssc[] lineBaseList = entity.getMobileLineArray(); 
	/*
	 *在FSSC系统里面，由于该报账单数据库里面没存projectType字段，造成不能对应，为了解决此问题，先转换一下
	      后面如果FSSC做了修改，就删除该转换，直接显示
	 */
	String protypecode = info.getProjectTypeCode();
	String protype = "";
	if("project".equals(protypecode)) {
		protype = "项目";
	} else if("specialCost".equals(protypecode)) {
		protype = "专项费用";
	} else {
		protype = "无";
	}
 %>
<div id="list">
	<%@include file="../wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
	    		<tr><th colspan="2" class="yellow">基本信息</th></tr>
	    		<tr><th>单据编号:</th><td><%=info.getClaimNo()%></td></tr>
				<tr><th>申请人:</th> <td><%=info.getApplyEmpName()%></td> </tr>
				<tr><th>申请日期:</th><td><%=info.getApplyDateStr()== null?"":info.getApplyDateStr()%></td></tr>	
				<tr><th>申请人部门:</th><td><%=info.getApplyDeptName()%></td></tr>
				<tr><th>申请人公司:</th><td><%=info.getApplyCompName()%></td></tr>
				
				<tr><th colspan="2" class="yellow">报账信息</th></tr>
				<tr><th>工作流名称:</th><td>招聘费</td></tr>
				<tr><th>币种:</th><td><%=info.getCurrency()%></td></tr>
				<tr><th>发票抬头:</th><td><%=info.getInvoiceTitle()%></td></tr>
				<tr><th>支付方式:</th><td><%=info.getPayType()%></td></tr>
				<tr><th>收款方:</th><td><%=info.getAccountName()%></td></tr>
				<tr><th>手机号码:</th><td ><%=info.getContactInfo()==null?"":info.getContactInfo()%></td></tr>
				<tr><th>所属财务部:</th><td><%=info.getFinancialDept()%></td></tr>
				<tr><th>最迟汇款日期:</th><td><%=info.getLatestRemitDateStr()==null?"":info.getLatestRemitDateStr()%></td></tr>
				<tr><th>项目类型:</th><td><%=info.getProjectType()%></td></tr>
				<tr><th>项目名称:</th><td><%=info.getProjectName()%></td></tr>
				<tr><th>招聘类型:</th><td><%=info.getBizType()%></td></tr>
				<%
				if("社会招聘".equals(info.getBizType())) {
				%>
					<tr><th>招聘岗位类别:</th><td><%=info.getJobTypeName()%></td></tr>
				<%} %>
				<tr><th>主招岗位:</th><td><%=info.getMainJobsName()%></td></tr>
				<tr><th>事前申请单号:</th><td><%=info.getPriorClaimNo()%></td></tr>
				<tr><th>申请事由及说明:</th><td><%=info.getCostExplain()%></td></tr>       
				           
				<tr class="yellow"><td colspan="2" >付款信息</td></tr>
				<tr><th>报账金额:</th><td><%=FormatUtil.formatMoney(info.getApplyAmount())%></td></tr>
				<tr><th>核销金额:</th><td><%=FormatUtil.formatMoney(info.getAlreadyWritedAmount())%></td></tr>
				<tr><th>付款金额:</th><td><%=FormatUtil.formatMoney(info.getPayAmount())%></td></tr>
				<tr><th>付款金额大写:</th><td id="amountCNY"></td></tr>
				<tr><th>币种:</th><td><%=info.getCurrency()%></td></tr>
				<tr class="changeByAccount"><th class="changeByAccount">核定金额:</th><td class="changeByAccount"><%=FormatUtil.formatMoney(info.getRatifyAmount())%></td></tr>
				<tr><th>账户性质:</th><td><%=info.getAccountNature()==null?"":info.getAccountNature()%></td></tr>
				<tr><th>银行账号:</th><td><%=info.getAccount()%></td></tr>
				<tr><th>开户支行:</th><td><%=info.getSubbankName()%></td></tr>
				
				<tr class="yellow"><td colspan="2" >明细信息</td></tr>
				
				<%
				for(int i=0; i< lineBaseList.length; i++){	
					ClaimLineFssc line = lineBaseList[i];
				 %>
				<tr <%=i==0?"":"class='topLine'" %>><th>费用类型:</th><td><%=line.getScName()%></td></tr>
				<tr><th>费用承担部门:</th><td><%=line.getCostCenterName()%></td></tr>
				<tr><th>业务发生日期:</th><td><%=line.getBizOccurDateStr()==null?"":line.getBizOccurDateStr()%></td></tr>
				<tr><th>报账金额:</th><td><%=FormatUtil.formatMoney(line.getActualAmount())%></td></tr>
				<tr class="changeByAccount"><th class="changeByAccount">核定金额:</th><td class="changeByAccount"><%=FormatUtil.formatMoney(line.getRetifyAmount())%></td></tr>
				<tr><th>费用说明:</th><td><%=line.getCostExplain()==null?"无":line.getCostExplain()%></td></tr>
				<%} %>
		  </table>
		  <%@include file="approve_process.jsp"%>
		</div>
		<%@include file="workflow_approve_button.jsp" %>
	</div>
</div>


<input type="hidden" id="workid" value="<%=info.getWfInstanceId() %>">

</body>

<script type="text/javascript">
$(function(){
	//将付款金额转成大写
	$("#amountCNY").html(numToCny(<%=info.getPayAmount()%>));
	
	//核定金额在费用核算组核算专员审批过后才能显示
	var accountXXID = $("#AccountXXID").val();
	if (accountXXID=='AccountXX') {
		$(".changeByAccount").show();
	}else {
		$(".changeByAccount").hide();
	}
});
</script>
</html>