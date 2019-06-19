<%@page import="com.deppon.montal.model.CCDlworkrelatedInjury"%>
<%@page import="com.deppon.montal.model.CCDlworkrelatedInjuryEntry"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="java.util.List"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_ios.jsp" %>
</head>
<%
 request.setCharacterEncoding("UTF-8");
 response.setCharacterEncoding("UTF-8");
%>
<%
CCDlworkrelatedInjury info = (CCDlworkrelatedInjury)request.getAttribute("CCDlworkrelatedInjury");
List<CCDlworkrelatedInjuryEntry> entryList = (List<CCDlworkrelatedInjuryEntry>)request.getAttribute("CCDlworkrelatedInjuryEntry");
	boolean bool = "直接上级".equals(info.getCurrentnode());
%>
<body>
<div id="list">
<%@include file="/jsp/ios/work_items_head.jsp" %>
   <!--div2 S-->
   <div id="div2">
	   	<div class="ulBox2">
			<ul>
			   <li class="first">工作流号:<em><%=info.getProcessinstid() %></em></li>
			   <li>工作流:<em>工伤医疗报销单</em></li>
			   <li>申请人:<em><%=info.getApplypersonname() %></em></li>
			   <li>申请部门:<em><%=info.getApplydept() %></em></li>
			   <li>所属子公司:<em><%=info.getApplycompany() %></em></li>
			   <li>发票抬头:<em><%=info.getInvoicetitle() %></em></li>
			   <li>收款方:<em><%=info.getPayee() %></em></li>
			   <li>申请总金额:<em><%=info.getAmount()%></em></li>
			   <li>账号:<em><%=info.getBanknumber()%></em></li>
			   <li>会计核定金额:<em><%=info.getAmountapproved()%></em></li>
			   <li>开户银行:<em><%=info.getBank()%></em></li>
			   <li>最迟汇款日期:<em><%=info.getLastremitdate()%></em></li>
			   <li>工伤人员:<em><%=info.getInjuryperson()%></em></li>
			   <li>工伤人员部门:<em><%=info.getInjurydept()%></em></li>
			   <li>工伤人员公司:<em><%=info.getInjurycompany()%></em></li>
			   <li>工伤日期:<em><%=info.getInjurydate()%></em></li>
			   <li>工伤差错编号:<em><%=info.getInjurybillnum()%></em></li>
			   <li>医疗费用:<em><%=info.getFeeforservice()%></em></li>
			   <li>住院伙食补助费:<em><%=info.getFeeformess()%></em></li>
			   <li>住院陪护费:<em><%=info.getFeefornurse()%></em></li>
			   <li>其它费用:<em><%=info.getFeeforother()%></em></li>
			   <li>事由及说明:<em><%=info.getDiscription()%></em></li>
			   <li><em class="yellow">详细信息</em></li>
			   <%int i = 0; for(CCDlworkrelatedInjuryEntry infoEntry:entryList){%>
					<%if (i==0){ %>
			   <li>费用类型:<em><%=infoEntry.getExpensetype() %></em></li>
					<%}else { %>
			   <li class="line">费用类型:<em><%=infoEntry.getExpensetype() %></em></li>
					<%} %>
				<li>费用说明:<em><%=infoEntry.getDiscription() %></em></li>
				<li>发生日期:<em><%=infoEntry.getBizdate() %></em></li>
				<li>报销金额:<em><%=infoEntry.getAmount() %></em></li>
				<li>核定金额:<em><%=infoEntry.getAmountapproved() %></em></li>
				<li>费用承担部门:<em><%=infoEntry.getCostdept() %></em></li>
				<li>备注:<em><%=infoEntry.getRemark() %></em></li>
				<%i++;}%>
				<%if(i==0){%>
				<li>无详细信息</li>
				<%}%>
			</ul>
		</div>
		 <%@include file="approve_process.jsp" %>
   		 <%if(bool){%>
	   <div class="ulBox2">
     	 <ul>
			  <li class="first">
				 	所属事业部:
				 	<em>
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
				 	</em>
				 </li>	
		</ul>
     </div>
	 <% }else if("财务副总".equals(info.getCurrentnode())){ %>
	   <div class="ulBox2">
     	 <ul>
			 <li class="first">
			 	是否总裁审批:
			 	<em>
				 	<input type="radio" name="need" value="1"><label>需要</label>
				 	<input type="radio" name="need" value="0" checked="checked"><label>不需要</label>
			 	</em>
			 </li>
		</ul>
     </div>
	 <% } %>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
	
	
	
	<input type="hidden" id="workid" value="<%=info.getProcessinstid()%>">		  	   		
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