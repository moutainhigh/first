<%@page import="com.deppon.montal.model.CCExpenseClaim"%>
<%@page import="com.deppon.montal.model.CCWelfareexpense"%>
<%@page import="com.deppon.montal.model.PorentCarOutside"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_ios.jsp" %>
</head>
<body>
<%
      CCExpenseClaim info = (CCExpenseClaim)request.getAttribute("expenseClaims");
%>
<div id="list">
	<%@include file="/jsp/ios/work_items_head.jsp" %>
	<div id="div2">
    	<div class="ulBox2">
	    	<ul>
			   <li class="first">工作流号:<em><%=info.getProcessinstid() %>
			   <input type="hidden" id="workid" value="<%=info.getProcessinstid()%>">
			   <input type="hidden" id ="type_id" value="expenseClaims">
<%-- 		   <input type="hidden" id ="currentnode_id" value="<%=info.getCurrentnode() %>"> --%>
			   </li>
				   <li>工作流:<em>日常费用报销申请</em></li>
				  <li>申请人姓名:<em><%=info.getApplypersonname()%></em></li>
				  <li>申请人部门:<em><%=info.getApplydept()%></em></li>
				  <li>所属子公司:<em><%=info.getApplycompany()%></em></li>
				  <li>发票抬头:<em><%=info.getInvoicetitle()%></em></li>
				  <li>收款方:<em><%=info.getPayee()%></em></li>
				  <li>申请总金额:<em><%=info.getAmount()%></em></li>
				  <li>账号:<em><%=info.getBanknumber()%></em></li>
				  <li>会计核定金额:<em><%=info.getAmountapproved()%></em></li>
				  <li>开户银行:<em><%=info.getBank()%></em></li>
				  <li>最迟汇款日期:<em><%=info.getLastremitdate()%></em></li>
				  <li>事由及说明:<em><%=info.getDiscription()==null?"":info.getDiscription()%></em></li>
				  <li><em class="yellow">详细信息</em></li>
				  <li id="queryExpenseClaims_id">查询中,请稍等...</li>
	    	</ul>
	    </div>
	     <%@include file="approve_process.jsp" %>
	      <%if("财务副总".equals(info.getCurrentnode())){%>
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
</div>
</body>
<script type="text/javascript">
function autoShowExpenseCalims(){
	var workId = $("#workid").val();
	$.ajax({
		type:"GET",
		url:"<%=basePath%>/getExpenseClaimEntry",
		data:"workId="+workId+"&timestamp=" + new Date().getTime(),
	   	cache:false,
		success:function(msg){
			var html = msg;
			if (html == ""){
				html = "无详细信息";
			}
			$("#queryExpenseClaims_id").hide();
			$("#queryExpenseClaims_id").after(html);
		}
	});
}
setTimeout(autoShowExpenseCalims,100);
</script>
</html>