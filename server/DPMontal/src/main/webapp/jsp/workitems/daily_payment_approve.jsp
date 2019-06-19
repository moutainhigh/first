<%@page import="com.deppon.montal.model.CCPodailyPayment"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_win8.jsp" %>
</head>
<body>
<%
	CCPodailyPayment info = (CCPodailyPayment)request.getAttribute("CCPodailyPayment");
%>
<div id="list">
	<%@include file="wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
	    		<tr><th>工作流号:</th><td id="workid"><%=info.getProcessinstid()%></td></tr>
				<tr><th>工作流:</th><td><%="45".equals(info.getApplytype())?"付款单——FOSS日常":!"45".equals(info.getApplytype())?"付款单—日常付款":""%></td></tr>
				<tr><th>申请人姓名:</th><td><%=info.getApplypersonname()%></td></tr>
				<tr><th>申请人部门:</th><td><%=info.getApplydept()%></td></tr>
				<tr><th>所属子公司:</th><td><%=info.getApplycompany()%></td></tr>
				<tr><th>发票抬头:</th><td><%=info.getInvoicetitle()%></td></tr>
				<tr><th>收款方:</th><td><%=info.getPayee()%></td></tr>
				<tr><th>申请总金额:</th><td><%=info.getAmount()%></td></tr>
				<tr><th>账号:</th><td><%=info.getBanknumber()%></td></tr>
				<tr><th>会计核定金额:</th><td><%=info.getAmountapproved()%></td></tr>
				<tr><th>开户银行:</th><td><%=info.getBank()%></td></tr>
				<tr><th>最迟汇款日期:</th><td><%=info.getLastremitdate()%></td></tr>
				<tr><th>事由及说明:</th><td><%=info.getDiscription()%></td></tr>
				 <tr class="yellow"><th colspan="2">详细信息</tr>
				 <tr id="dailyPayment_id"><th colspan="2">查询中,请稍等...</th></tr>
	    	</table>
	    	 <%@include file="approve_process.jsp" %>
				 <%
				  if("财务副总".equals(info.getCurrentnode())){
				 %>
				 <table width="100%">
					 <tr>
					 	<th>是否总裁审批:</th>
					 	<td>
						 	<input type="radio" name="need" value="1"><label>需要</label>
						 	<input type="radio" name="need" value="0" checked="checked"><label>不需要</label>
					 	<td>
					 </tr>
				 </table>
				 <% } %>
	    </div>
	</div>
	 <%@include file="workflow_approve_button.jsp" %>
</div>
</body>
<script type="text/javascript">
function autoShowDailyPaymentEntry(){
	var workId = $("#workid").html();
	$.ajax({
		type:"GET",
		url:"<%=basePath%>/getDailyPaymentEntry",
		data:"workId="+workId+"&timestamp=" + new Date().getTime(),
	   	cache:false,
		success:function(msg){
			var html = msg;
			if (html == ""){
				html = "无详细信息";
			}
			$("#dailyPayment_id").hide();
			$("#dailyPayment_id").after(html);
		}
	});
}
setTimeout(autoShowDailyPaymentEntry,100);
</script>
</html>