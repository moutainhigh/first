<%@page import="com.deppon.montal.model.CCDlworkrelatedInjury"%>
<%@page import="com.deppon.montal.model.CCDlworkrelatedInjuryEntry"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
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
CCDlworkrelatedInjury info = (CCDlworkrelatedInjury)request.getAttribute("CCDlworkrelatedInjury");
List<CCDlworkrelatedInjuryEntry> entryList = (List<CCDlworkrelatedInjuryEntry>)request.getAttribute("CCDlworkrelatedInjuryEntry");
boolean bool = "直接上级".equals(info.getCurrentnode());
%>
<body>
<div id="list">
	<%@include file="wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
				<tr><th>工作流号:</th><td id="workid"><%=info.getProcessinstid()%></td></tr>
				<tr><th>工作流:</th><td>工伤医疗报销单</td></tr>
				<tr><th>申请人:</th><td><%=info.getApplypersonname() %></td></tr>
				<tr><th>申请部门:</th><td><%=info.getApplydept() %></td></tr>
				<tr><th>所属子公司:</th><td><%=info.getApplycompany() %></td></tr>
				<tr><th>发票抬头:</th><td><%=info.getInvoicetitle() %></td></tr>
				<tr><th>收款方:</th><td><%=info.getPayee() %></td></tr>
				<tr><th>申请总金额:</th><td><%=info.getAmount()%></td></tr>
				<tr><th>账号:</th><td><%=info.getBanknumber()%></td></tr>
				<tr><th>会计核定金额:</th><td><%=info.getAmountapproved()%></td></tr>
				<tr><th>开户银行:</th><td><%=info.getBank()%></td></tr>
				<tr><th>最迟汇款日期:</th><td><%=info.getLastremitdate()%></td></tr>
				<tr><th>工伤人员:</th><td><%=info.getInjuryperson()%></td></tr>
				<tr><th>工伤人员部门:</th><td><%=info.getInjurydept()%></td></tr>
				<tr><th>工伤人员公司:</th><td><%=info.getInjurycompany()%></td></tr>
				<tr><th>工伤日期:</th><td><%=info.getInjurydate()%></td></tr>
				<tr><th>工伤差错编号:</th><td><%=info.getInjurybillnum()%></td></tr>
				<tr><th>医疗费用:</th><td><%=info.getFeeforservice()%></td></tr>
				<tr><th>住院伙食补助费:</th><td><%=info.getFeeformess()%></td></tr>
				<tr><th>住院陪护费:</th><td><%=info.getFeefornurse()%></td></tr>
				<tr><th>其它费用:</th><td><%=info.getFeeforother()%></td></tr>
				<tr><th>事由及说明:</th><td><%=info.getDiscription()%></td></tr>
				<tr class="yellow"><th colspan="2">详细信息</th></tr>
				<%int i = 0; for(CCDlworkrelatedInjuryEntry infoEntry:entryList){%>
					<%if (i==0){ %>
						<tr><th>费用类型:</th><td><%=infoEntry.getExpensetype() %></td></tr>
					<%}else { %>
						<tr class="topLine"><th>费用类型:</th><td><%=infoEntry.getExpensetype() %></td></tr>
					<%} %>
				<tr><th>费用说明:</th><td><%=infoEntry.getDiscription() %></td></tr>
				<tr><th>发生日期:</th><td><%=infoEntry.getBizdate() %></td></tr>
				<tr><th>报销金额:</th><td><%=infoEntry.getAmount() %></td></tr>
				<tr><th>核定金额:</th><td><%=infoEntry.getAmountapproved() %></td></tr>
				<tr><th>费用承担部门:</th><td><%=infoEntry.getCostdept() %></td></tr>
				<tr><th>备注:</th><td><%=infoEntry.getRemark() %></td></tr>
				<%i++;}%>
				<%if(i==0){%>
				<tr><th th colspan="2">无详细信息</th></tr>
				<%}%>
				</table>
			<%@include file="approve_process.jsp" %>
			  <%if(bool){ %>
			  <table>
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
				</table>
			<% } else if("财务副总".equals(info.getCurrentnode())){%>
			 <table>
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
$(function(){
	var bool = <%=bool%>
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