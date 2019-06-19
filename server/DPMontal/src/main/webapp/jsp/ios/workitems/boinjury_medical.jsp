<%@page import="com.deppon.montal.model.CCBoInjuryMedical"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.montal.conf.F_Constants"%>
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
	CCBoInjuryMedical medical = (CCBoInjuryMedical)request.getAttribute("medical");
%>
<body>
<div id="list">
<%@include file="/jsp/ios/work_items_head.jsp" %>
   <!--div2 S-->
   <div id="div2">
	   	<div class="ulBox2">
			<ul>
			 
			   <li class="first">工作流号:
			        <em><%=medical.getProcessinstid() %>
			  	   		<input type="hidden" id="workid" value="<%=medical.getProcessinstid()%>">		  	   		
			   		</em>
			   </li>
			   
			   <li>申请人:<em><%=medical.getApplypersonname() %></em></li>
			   <li>申请部门:<em><%=medical.getApplydept() %></em></li>
			   <li>申请日期:<em><%=medical.getApplydate() %></em></li>
			   
			   <li>工作流:<em>
		   		     借款单——工伤医疗费用
			   </em></li>
			   <li>发票抬头:<em><%=medical.getInvoicetitle() %></em></li>
			   <li>收款方:<em><%=medical.getPayee() %></em></li>
			   <li>申请总金额:<em><%=medical.getAmount()%></em></li>
			   <li>账号:<em><%=medical.getBanknumber()%></em></li>
			   <li>会计核定金额:<em><%=medical.getAmountapproved()%></em></li>
			   <li>开户银行:<em><%=medical.getBank()%></em></li>
			   <li>最迟汇款日期:<em><%=medical.getLastremitdate()%></em></li>
			   <li>工伤人员:<em><%=medical.getInjuryperson()%></em></li>
			   <li>工伤人员部门:<em><%=medical.getInjurydept()%></em></li>
			   <li>工伤人员公司:<em><%=medical.getInjurycompany()%></em></li>
			   <li>工伤日期:<em><%=medical.getInjurydate()%></em></li>
			   <li>工伤差错编号：<em><%=medical.getInjurybillnum()%></em></li>
			   <li>事由及说明:<em><%=medical.getDiscription()%></em></li>
			   
			</ul>
		</div>
		<%@include file="approve_process.jsp" %>
     		 <%
			  if("财务副总".equals(medical.getCurrentnode())){
			 %>
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
			 <% }else if("直接上级".equals(medical.getCurrentnode())) {%>
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
		 <%} %>
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