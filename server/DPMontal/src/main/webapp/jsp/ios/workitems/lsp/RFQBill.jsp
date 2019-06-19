<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain.RfqBillVo"%>
<%@page import="com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain.RFQBillEntry"%>
<%@page import="com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain.RFQBillAuditDept"%>
<%@page import="com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain.RFQBill"%>
<%@page import="java.util.List"%>
<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_ios.jsp" %>
	<style type="text/css">
		.otherInfo{
			display:none;
		}
	</style>
</head>
<body>
 <%
//RFQ单
	RfqBillVo info = (RfqBillVo)request.getAttribute("lspResponseEntity");
	//RFQ单表头对象，用来存储JS界面的RFQ单的表头信息
	RFQBill rfqBill = info.getRfqBill();
	//RFQ单分录  询价物品对象集合
	List<RFQBillEntry> rfqBillEntryList = info.getRfqBillEntryList();
	//RFQ单分录 技术评审对象集合
	List<RFQBillAuditDept> rfqBillAuditDeptList = info.getRfqBillAuditDeptList();
 %>
<div id="list">
	<%@include file="/jsp/ios/work_items_head.jsp" %>
	<div id="div2">
		<h4 class="yellow">基本信息-RFQ单</h4>
    	<div class="ulBox2">
	    	<ul>				  
	    		<li>RFQ单号:<em><%=rfqBill.getNumber()%></em></li>
				<li>询价人:<em><%=rfqBill.getEnquiryer()%></em></li>
				<li>询价日期:<em><%=FormatUtil.formatDate(rfqBill.getEnquiryTurn())%></em></li>
				<li>RFQ申请单号:<em><%=rfqBill.getRfqclaimerNumber()%></em></li>
			   	<li>询价部门:<em><%=rfqBill.getEnquiryDepartment()%></em></li>
			   	<li>RFQ类型:<em><%=rfqBill.getRfqtype()%></em></li>
			   	<li>制单人是否为总部人员:<em><%=rfqBill.isDpzb()==true?"是":"否"%></em></li>
			   	<li>询价轮次:<em><%=rfqBill.getEnquiry()%></em></li>
			   	<li>总金额:<em><%=rfqBill.getAmountMoney()%></em></li>
          	</ul>
        </div>
        <h4 class="yellow" onclick="otherInfoOpen(1);">其他信息-询价物品</h4>
	   	<div class="ulBox2">
    		<ul>
    		<%
					int rfqBillEntrySize = rfqBillEntryList == null ? 0:rfqBillEntryList.size();
					for(int i = 0; i < rfqBillEntrySize ; i++ ) {
						RFQBillEntry obj1 = rfqBillEntryList.get(i);
					%>
						<li <%=i==0?"class='first otherInfo tab1'":"class='line otherInfo tab1'" %>>序号:<em><%=i+1 %></em></li>
					   	<li class="otherInfo tab1">物品编码:<em><%= obj1.getMateriaNumber()%></em></li>
					    <li class="otherInfo tab1">物品名称:<em><%= obj1.getMateriaName()%></em></li>
					   	<li class="otherInfo tab1">物品类型:<em><%= obj1.getMateriaType()%></em></li>
					    <li class="otherInfo tab1">物品规格:<em><%= obj1.getMateriaStandard()%></em></li>
					    <li class="otherInfo tab1">数量:<em><%= obj1.getQuantityDto()%></em></li>
					    <li class="otherInfo tab1">计量单位:<em><%= obj1.getMeasureUnit()%></em></li>
					    <li class="otherInfo tab1">是否打样:<em><%=obj1.isMakeProof()==true?"是":"否"%></em></li>
					    <li class="otherInfo tab1">是否含运费:<em><%=obj1.isFreight()==true?"是":"否"%></em></li>
					    <li class="otherInfo tab1">是否含税:<em><%= obj1.isRevenue()==true?"是":"否"%></em></li>
					    <li class="otherInfo tab1">开票类型:<em><%= obj1.getInvoiceType()%></em></li>
					    <li class="otherInfo tab1">供货时效（天）:<em><%= obj1.getDate()%></em></li>
					    <li class="otherInfo tab1">备注:<em><%= obj1.getRemark()==null?"":obj1.getRemark()%></em></li>
				   <%} %>
		   </ul>
	    </div>
	    <h4 class="yellow" style="display: none" id="otherInfo1Close" onclick="otherInfoClose(1);">关闭信息-询价物品</h4>
	    <h4 class="yellow" onclick="otherInfoOpen(2);">其他信息-技术评审</h4>
	   	<div class="ulBox2">
    		<ul>
    		<%
				int rfqBillAuditDeptListSize = rfqBillAuditDeptList==null?0:rfqBillAuditDeptList.size();
				for(int i = 0; i < rfqBillAuditDeptListSize ; i++ ) {
					RFQBillAuditDept obj1 = rfqBillAuditDeptList.get(i);
				%>
					<li <%=i==0?"class='first otherInfo tab2'":"class='line otherInfo tab2'" %>>序号:<em><%=i+1 %></em></li>
				    <li  class="otherInfo tab2">部门编码:<em><%= obj1.getDepartmentNumber()%></em></li>
				   	<li  class="otherInfo tab2">评审部门:<em><%= obj1.getReviewDepartment()%></em></li>
			   <%} %>
		   </ul>
	    </div>
	    <h4 class="yellow" style="display: none" id="otherInfo2Close" onclick="otherInfoClose(2);">关闭信息-技术评审</h4>
	    <%@include file="approve_process_esb3.jsp"%> 
	</div>
	 <%@include file="workflow_approve_button_esb2.jsp" %>
</div>
</body>
<script type="text/javascript">
function otherInfoClose(obj){
	$(".otherInfo.tab"+obj).slideUp(200);
	$("#otherInfo"+obj+"Close").slideUp(200);
}
function otherInfoOpen(obj){
	$(".otherInfo.tab"+obj).slideDown(200);
	$("#otherInfo"+obj+"Close").slideDown(200);
}
$(function(){
	$("#rollback_but").hide();
	$("#disagree_but").show();
});
</script>
</html>