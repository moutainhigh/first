<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.model.TWFSexpensehkSub"%>
<%@page import="com.deppon.montal.model.TWFSexpensehk"%>
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
	TWFSexpensehk expense = (TWFSexpensehk)request.getAttribute("expense_hk");
	List<TWFSexpensehkSub> entryList = (List<TWFSexpensehkSub>)request.getAttribute("expense_info");
%>
<body>
<div id="list">
<%@include file="/jsp/ios/work_items_head.jsp" %>
   <!--div2 S-->
   <div id="div2">
   	<div class="ulBox2">
		<ul>
		   <li class="first">工作流号:
		        <em><%=expense.getProcessinstid() %>
		  	   		<input type="hidden" id="workid" value="<%=expense.getProcessinstid()%>">
		  	   		<input type="hidden" id="type_id" value="wuzizicancaigou">
		   		</em>
		   </li>
		   <li>工作流:<em>
	   		  费用报销申请(香港)
		   </em></li>
		   <li>申请人姓名:<em><%=expense.getProposer() %></em></li>
		   <li>工号:<em><%=expense.getUserid()%></em></li>
		   <li>申请人部门:<em><%=expense.getApplydept() %></em></li>
		   <li>所属子公司:<em><%=expense.getSubcompany() %></em></li>
		   <li>收款方:<em><%=expense.getPayee() %></em></li>
		   <li>电话号码:<em><%=expense.getPhoneno()==null?"":expense.getPhoneno() %></em></li>
		   <li>开户银行:<em><%=expense.getBank() %></em></li>
		   <li>账号:<em><%=expense.getBankno() %></em></li>
		   <li>开户行省份:<em><%=expense.getProvince() %></em></li>
		   <li>开户行城市:<em><%=expense.getCity() %></em></li>
		   <li>开户支行:<em><%=expense.getSubbranch()%></em></li>
		   <li>支付方式:<em><%=expense.getPaymentmethod() %></em></li>
		   <li>账户性质:<em><%=expense.getAccounttype() %></em></li>
		   <li>发票抬头:<em><%=expense.getInvoicetitle() %></em></li>
		   <li>事由及说明：<em><%=expense.getReason()==null?"":expense.getReason() %></em></li>
		   <li><em class="yellow">详细信息</em></li>
			<%
				for(int i=0;i<entryList.size();i++){
					TWFSexpensehkSub entry = entryList.get(i);
			%>
						   
			   <li <%=i==0?"":"class='line'" %>>费用类型:<em><%=entry.getExpensetype()%></em></li>
			   <li>费用说明:<em><%=entry.getFeedesc() %></em></li>
			   <li>发生日期:<em><%=FormatUtil.formatDate(entry.getBizdate()) %></em></li>
			   <li>报销金额:<em><%=entry.getAmount() %></em></li>
			   <li>核定金额:<em><%=entry.getAmountapproved() %></em></li>
			   <li>费用承担部门:<em><%=entry.getCostdept() %></em></li>
			   <li>备注:<em><%=entry.getRemark()==null?"":entry.getRemark() %></em></li>
			<%
				}
			%>
			</ul>
		</div>
		<%@include file="approve_process.jsp" %>
	</div>
		<div>
			<ul>
				<%if("审核会计".equals(expense.getCurrentnode())){%>
					<li class="fyy-textCt"><em style="color: red">该节点暂不支持手机审批</em></li>
				<%}%>	
			</ul>
		</div>
<%-- 	<%if(!"审核会计".equals(expense.getCurrentnode())){%> --%>
	<%@include file="workflow_approve_button.jsp" %>
<%-- 	<%}%> --%>
	<%if("审核会计".equals(expense.getCurrentnode())){%>
		<script type="text/javascript">
		$(function(){
			document.getElementById("disagree_but").style.display = "none";
			document.getElementById("agree_but").style.display = "none";
			document.getElementById("rollback_but").style.display = "none";
			document.getElementById("approve_area").style.display = "none";
		});
		</script>
	<%}%>
</div>
</body>
</html>