<%@page import="com.deppon.montal.model.CCBoInjuryMedical"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.montal.conf.F_Constants"%>
<%@page import="java.util.List"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_win8.jsp" %>
</head>
</head>
<%
	CCBoInjuryMedical medical = (CCBoInjuryMedical)request.getAttribute("medical");
%>
<body>
<div id="list">
	<%@include file="wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
					<tr>
					   <th>工作流号:</th>
					   <td id="workid"><%=medical.getProcessinstid()%></td>
					</tr>
					
					<tr>
						<th>申请人：</th>
						<td><%=medical.getApplypersonname() %></td>
					</tr>
					<tr>
						<th>申请部门：</th>
						<td><%=medical.getApplydept() %></td>
					</tr>
					<tr>
						<th>申请日期：</th>
						<td><%=medical.getApplydate() %></td>
					</tr>
					
					
					<tr>
					   <th>工作流:</th>
					   <td>
						   借款单——工伤医疗费用
					   </td>
					</tr>
					<tr>
						<th>发票抬头：</th>
						<td><%=medical.getInvoicetitle() %></td>
					</tr>
					<tr>
						<th>收款方：</th>
						<td><%=medical.getPayee() %></td>
					</tr>
					<tr>
						<th>申请总金额：</th>
						<td><%=medical.getAmount()%></td>
					</tr>
					<tr>
						<th>账号：</th>
						<td><%=medical.getBanknumber()%></td>
					</tr>
					<tr>
						<th>会计核定金额：</th>
						<td><%=medical.getAmountapproved()%></td>
					</tr>
					<tr>
						<th>开户银行：</th>
						<td><%=medical.getBank()%></td>
					</tr>
					<tr>
						<th>最迟汇款日期：</th>
						<td><%=medical.getLastremitdate()%></td>
					</tr>
					
					<tr>
						<th>工伤人员：</th>
						<td><%=medical.getInjuryperson()%></td>
					</tr>
					<tr>
						<th>工伤人员部门：</th>
						<td><%=medical.getInjurydept()%></td>
					</tr>
					<tr>
						<th>工伤人员公司：</th>
						<td><%=medical.getInjurycompany()%></td>
					</tr>
					<tr>
						<th>工伤日期：</th>
						<td><%=medical.getInjurydate()%></td>
					</tr>
					<tr>
						<th>工伤差错编号：</th>
						<td><%=medical.getInjurybillnum()%></td>
					</tr>					
					<tr>
						<th>事由及说明：</th>
						<td><%=medical.getDiscription()%></td>
					</tr>
					<%@include file="approve_process.jsp" %>
					<%
					  if("财务副总".equals(medical.getCurrentnode())){ 
					 %>
					 <tr>
					 	<th>是否总裁审批:</th>
					 	<td>
						 	<input type="radio" name="need" value="1"><label>需要</label>
						 	<input type="radio" name="need" value="0" checked="checked"><label>不需要</label>
					 	<td>
					 </tr>
					 <% } %>
					 <%
					  if("直接上级".equals(medical.getCurrentnode())){ 
					 %>
					 <tr>
					 	<th>所属事业部:</th>
					 	<td>
						 	<select id="localper" name="localper">
						 		<option value="0" selected="selected">--请选择--</option>
						 		<option value="W01000301041001">东北事业部人事部</option>
						 		<option value="W01000301041002">河南事业部人事部</option>
						 		<option value="W01000301041003">山东事业部人事部</option>
						 		<option value="W011206">广州事业部人事部</option>
						 		<option value="W011207">深圳事业部人事部</option>
						 		<option value="W011208">北京事业部人事部</option>
						 		<option value="W011209">湖北事业部人事部</option>
						 		<option value="W01120901">西南事业部人事部</option>
						 		<option value="W011210">上海事业部人事部</option>
						 		<option value="W17000313">江苏事业部人事部</option>
						 		<option value="W17000314">浙江事业部人事部</option>
						 	</select>
					 	<td>
					 </tr>
					 <% } %>					
				</table>
    	</div>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
<script type="text/javascript">
$(function(){
	var bool = <%="直接上级".equals(medical.getCurrentnode())%>
	if(bool){
		$("#agree_but").unbind();
		$("#agree_but").click(function(){
			agreeBut();
		});
	}
});
function agreeBut(){
	var val = $("#localper").val(); // 所属事业部
	if(val == "0"){
		$("#result_msg").html("请选择所属事业部!");
		$("#confirm_back").show();
		$("#result_window").fadeIn(600);
		$(".tipsWinCnt").show();
		
		return;
	}
		
	$("#app_val").val("0");
	$("#confirm_msg").html("您当前选择【同意】该工作流，是否确定提交？");
	$("#app_window").fadeIn(600);
	$(".tipsWinCnt").show();
}
</script>
</html>